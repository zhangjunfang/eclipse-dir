package com.radiadesign.catalina.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.apache.catalina.Container;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.Loader;
import org.apache.catalina.Pipeline;
import org.apache.catalina.Session;
import org.apache.catalina.Valve;
import org.apache.catalina.session.ManagerBase;
import org.apache.catalina.util.LifecycleSupport;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisSessionManager extends ManagerBase implements Lifecycle {
	protected byte[] NULL_SESSION = "null".getBytes();

	private final Log log = LogFactory.getLog(RedisSessionManager.class);

	protected String host = "localhost";
	protected int port = 6379;
	protected int database = 0;
	protected String password = null;
	protected int timeout = 2000;
	protected JedisPool connectionPool;
	protected RedisSessionHandlerValve handlerValve;
	protected ThreadLocal<RedisSession> currentSession = new ThreadLocal();
	protected ThreadLocal<String> currentSessionId = new ThreadLocal();
	protected ThreadLocal<Boolean> currentSessionIsPersisted = new ThreadLocal();
	protected Serializer serializer;
	protected static String name = "RedisSessionManager";

	protected String serializationStrategyClass = "com.radiadesign.catalina.session.JavaSerializer";

	protected LifecycleSupport lifecycle = new LifecycleSupport(this);

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getDatabase() {
		return this.database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	public int getTimeout() {
		return this.timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSerializationStrategyClass(String strategy) {
		this.serializationStrategyClass = strategy;
	}

	public int getRejectedSessions() {
		return 0;
	}

	public void setRejectedSessions(int i) {
	}

	protected Jedis acquireConnection() {
		Jedis jedis = (Jedis) this.connectionPool.getResource();

		if (getDatabase() != 0) {
			jedis.select(getDatabase());
		}

		return jedis;
	}

	protected void returnConnection(Jedis jedis, Boolean error) {
		if (error.booleanValue())
			this.connectionPool.returnBrokenResource(jedis);
		else
			this.connectionPool.returnResource(jedis);
	}

	protected void returnConnection(Jedis jedis) {
		returnConnection(jedis, Boolean.valueOf(false));
	}

	public void load() throws ClassNotFoundException, IOException {
	}

	public void unload() throws IOException {
	}

	public void addLifecycleListener(LifecycleListener listener) {
		this.lifecycle.addLifecycleListener(listener);
	}

	public LifecycleListener[] findLifecycleListeners() {
		return this.lifecycle.findLifecycleListeners();
	}

	public void removeLifecycleListener(LifecycleListener listener) {
		this.lifecycle.removeLifecycleListener(listener);
	}

	protected synchronized void startInternal() throws LifecycleException {
		super.startInternal();

		setState(LifecycleState.STARTING);

		Boolean attachedToValve = Boolean.valueOf(false);
		for (Valve valve : getContainer().getPipeline().getValves()) {
			if ((valve instanceof RedisSessionHandlerValve)) {
				this.handlerValve = ((RedisSessionHandlerValve) valve);
				this.handlerValve.setRedisSessionManager(this);
				this.log.info("Attached to RedisSessionHandlerValve");
				attachedToValve = Boolean.valueOf(true);
				break;
			}
		}

		if (!attachedToValve.booleanValue()) {
			String error = "Unable to attach to session handling valve; sessions cannot be saved after the request without the valve starting properly.";
			this.log.fatal(error);
			throw new LifecycleException(error);
		}
		try {
			initializeSerializer();
		} catch (InstantiationException e) {
			this.log.fatal("Unable to load serializer", e);
			throw new LifecycleException(e);
		}

		this.log.info("Will expire sessions after " + getMaxInactiveInterval()
				+ " seconds");

		initializeDatabaseConnection();

		setDistributable(true);
	}

	protected synchronized void stopInternal() throws LifecycleException {
		if (this.log.isDebugEnabled()) {
			this.log.debug("Stopping");
		}

		setState(LifecycleState.STOPPING);
		try {
			this.connectionPool.destroy();
		} catch (Exception localException) {
		}

		super.stopInternal();
	}

	public Session createSession(String sessionId) {
		RedisSession session = (RedisSession) createEmptySession();

		session.setNew(true);
		session.setValid(true);
		session.setCreationTime(System.currentTimeMillis());
		session.setMaxInactiveInterval(getMaxInactiveInterval());

		String jvmRoute = getJvmRoute();

		Boolean error = Boolean.valueOf(true);
		Jedis jedis = null;
		try {
			jedis = acquireConnection();
			do {
				if (sessionId == null) {
					sessionId = generateSessionId();
				}

				if (jvmRoute != null)
					sessionId = sessionId + '.' + jvmRoute;
			} while (jedis.setnx(sessionId.getBytes(), this.NULL_SESSION)
					.longValue() == 1L);

			error = Boolean.valueOf(false);

			session.setId(sessionId);
			session.tellNew();

			this.currentSession.set(session);
			this.currentSessionId.set(sessionId);
			this.currentSessionIsPersisted.set(Boolean.valueOf(false));
		} finally {
			if (jedis != null) {
				returnConnection(jedis, error);
			}
		}

		return session;
	}

	public Session createEmptySession() {
		return new RedisSession(this);
	}

	public void add(Session session) {
		try {
			save(session);
		} catch (IOException ex) {
			this.log.warn("Unable to add to session manager store: "
					+ ex.getMessage());
			throw new RuntimeException(
					"Unable to add to session manager store.", ex);
		}
	}

	public Session findSession(String id) throws IOException {
		RedisSession session;
		if (id == null) {
			RedisSession session = null;
			this.currentSessionIsPersisted.set(Boolean.valueOf(false));
		} else {
			RedisSession session;
			if (id.equals(this.currentSessionId.get())) {
				session = (RedisSession) this.currentSession.get();
			} else {
				session = loadSessionFromRedis(id);

				if (session != null) {
					this.currentSessionIsPersisted.set(Boolean.valueOf(true));
				}
			}
		}
		this.currentSession.set(session);
		this.currentSessionId.set(id);

		return session;
	}

	public void clear() {
		Jedis jedis = null;
		Boolean error = Boolean.valueOf(true);
		try {
			jedis = acquireConnection();
			jedis.flushDB();
			error = Boolean.valueOf(false);
		} finally {
			if (jedis != null)
				returnConnection(jedis, error);
		}
	}

	public int getSize() throws IOException {
		Jedis jedis = null;
		Boolean error = Boolean.valueOf(true);
		try {
			jedis = acquireConnection();
			int size = jedis.dbSize().intValue();
			error = Boolean.valueOf(false);
			int i = size;
			return i;
		} finally {
			if (jedis != null)
				returnConnection(jedis, error);
		}
		throw localObject;
	}

	public String[] keys() throws IOException {
		Jedis jedis = null;
		Boolean error = Boolean.valueOf(true);
		try {
			jedis = acquireConnection();
			Set keySet = jedis.keys("*");
			error = Boolean.valueOf(false);
			String[] arrayOfString = (String[]) keySet
					.toArray(new String[keySet.size()]);
			return arrayOfString;
		} finally {
			if (jedis != null)
				returnConnection(jedis, error);
		}
		throw localObject;
	}

	public RedisSession loadSessionFromRedis(String id) throws IOException {
		Jedis jedis = null;
		Boolean error = Boolean.valueOf(true);
		try {
			this.log.trace("Attempting to load session " + id + " from Redis");

			jedis = acquireConnection();
			byte[] data = jedis.get(id.getBytes());
			error = Boolean.valueOf(false);
			RedisSession session;
			RedisSession session;
			if (data == null) {
				this.log.trace("Session " + id + " not found in Redis");
				session = null;
			} else {
				if (Arrays.equals(this.NULL_SESSION, data)) {
					throw new IllegalStateException(
							"Race condition encountered: attempted to load session["
									+ id
									+ "] which has been created but not yet serialized.");
				}
				this.log.trace("Deserializing session " + id + " from Redis");
				session = (RedisSession) createEmptySession();
				this.serializer.deserializeInto(data, session);
				session.setId(id);
				session.setNew(false);
				session.setMaxInactiveInterval(getMaxInactiveInterval() * 1000);
				session.access();
				session.setValid(true);
				session.resetDirtyTracking();

				if (this.log.isTraceEnabled()) {
					this.log.trace("Session Contents [" + id + "]:");
					for (Iterator localIterator = Collections.list(
							session.getAttributeNames()).iterator(); localIterator
							.hasNext();) {
						Object name = localIterator.next();
						this.log.trace("  " + name);
					}
				}
			}

			RedisSession localRedisSession1 = session;
			return localRedisSession1;
		} catch (IOException e) {
			this.log.fatal(e.getMessage());
			throw e;
		} catch (ClassNotFoundException ex) {
			this.log.fatal("Unable to deserialize into session", ex);
			throw new IOException("Unable to deserialize into session", ex);
		} finally {
			if (jedis != null)
				returnConnection(jedis, error);
		}
		throw localObject1;
	}

	public void save(Session session) throws IOException {
		Jedis jedis = null;
		Boolean error = Boolean.valueOf(true);
		try {
			this.log.trace("Saving session " + session + " into Redis");

			RedisSession redisSession = (RedisSession) session;

			if (this.log.isTraceEnabled()) {
				this.log.trace("Session Contents [" + redisSession.getId()
						+ "]:");
				for (Iterator localIterator = Collections.list(
						redisSession.getAttributeNames()).iterator(); localIterator
						.hasNext();) {
					Object name = localIterator.next();
					this.log.trace("  " + name);
				}
			}

			Boolean sessionIsDirty = redisSession.isDirty();

			redisSession.resetDirtyTracking();
			byte[] binaryId = redisSession.getId().getBytes();

			jedis = acquireConnection();

			if ((sessionIsDirty.booleanValue())
					|| (!((Boolean) this.currentSessionIsPersisted.get())
							.booleanValue())) {
				jedis.set(binaryId, this.serializer.serializeFrom(redisSession));
			}

			this.currentSessionIsPersisted.set(Boolean.valueOf(true));

			this.log.trace("Setting expire timeout on session ["
					+ redisSession.getId() + "] to " + getMaxInactiveInterval());
			jedis.expire(binaryId, getMaxInactiveInterval());

			error = Boolean.valueOf(false);
		} catch (IOException e) {
			this.log.error(e.getMessage());

			throw e;
		} finally {
			if (jedis != null)
				returnConnection(jedis, error);
		}
	}

	public void remove(Session session) {
		remove(session, false);
	}

	public void remove(Session session, boolean update) {
		Jedis jedis = null;
		Boolean error = Boolean.valueOf(true);

		this.log.trace("Removing session ID : " + session.getId());
		try {
			jedis = acquireConnection();
			jedis.del(session.getId());
			error = Boolean.valueOf(false);
		} finally {
			if (jedis != null)
				returnConnection(jedis, error);
		}
	}

	public void afterRequest() {
		RedisSession redisSession = (RedisSession) this.currentSession.get();
		if (redisSession != null) {
			this.currentSession.remove();
			this.currentSessionId.remove();
			this.currentSessionIsPersisted.remove();
			this.log.trace("Session removed from ThreadLocal :"
					+ redisSession.getIdInternal());
		}
	}

	public void processExpires() {
	}

	private void initializeDatabaseConnection() throws LifecycleException {
		try {
			this.connectionPool = new JedisPool(new JedisPoolConfig(),
					getHost(), getPort(), getTimeout(), getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			throw new LifecycleException("Error Connecting to Redis", e);
		}
	}

	private void initializeSerializer() throws ClassNotFoundException,
			IllegalAccessException, InstantiationException {
		this.log.info("Attempting to use serializer :"
				+ this.serializationStrategyClass);
		this.serializer = ((Serializer) Class.forName(
				this.serializationStrategyClass).newInstance());

		Loader loader = null;

		if (this.container != null) {
			loader = this.container.getLoader();
		}

		ClassLoader classLoader = null;

		if (loader != null) {
			classLoader = loader.getClassLoader();
		}
		this.serializer.setClassLoader(classLoader);
	}
}