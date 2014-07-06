package com.radiadesign.catalina.session;

import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.Session;
import org.apache.catalina.Valve;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class RedisSessionHandlerValve extends ValveBase {
	private final Log log = LogFactory.getLog(RedisSessionManager.class);
	private RedisSessionManager manager;

	public RedisSessionHandlerValve() {
		super(true);
	}

	public void setRedisSessionManager(RedisSessionManager manager) {
		this.manager = manager;
	}

	public void invoke(Request request, Response response) throws IOException,
			ServletException {
		Session session;
		try {
			getNext().invoke(request, response);
		} finally {
			Session session = request.getSessionInternal(false);
			storeOrRemoveSession(session);
			this.manager.afterRequest();
		}
	}

	private void storeOrRemoveSession(Session session) {
		try {
			if (session != null)
				if (session.isValid()) {
					this.log.trace("Request with session completed, saving session "
							+ session.getId());
					if (session.getSession() != null) {
						this.log.trace("HTTP Session present, saving "
								+ session.getId());
						this.manager.save(session);
					} else {
						this.log.trace("No HTTP Session present, Not saving "
								+ session.getId());
					}
				} else {
					this.log.trace("HTTP Session has been invalidated, removing :"
							+ session.getId());
					this.manager.remove(session);
				}
		} catch (Exception localException) {
		}
	}
}