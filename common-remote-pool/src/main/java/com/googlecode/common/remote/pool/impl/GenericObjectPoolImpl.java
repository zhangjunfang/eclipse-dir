package com.googlecode.common.remote.pool.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;

import com.googlecode.common.remote.pool.exception.ResourceFactoryClassNoUploadException;

public class GenericObjectPoolImpl extends GenericObjectPool<Object> {

	private static final String DEFAULT_RESOURCE_FACTORY = "com.googlecode.common.remote.pool.resource.ResourceFactory";
	private static String classForResourceFactory = DEFAULT_RESOURCE_FACTORY;
	private static final Logger LOG = Logger.getLogger(GenericObjectPoolImpl.class);

	private static GenericObjectPoolImpl INSTANCE;

	public static GenericObjectPoolImpl getInstance() {
		if (INSTANCE != null)
			return INSTANCE;

		synchronized (GenericObjectPoolImpl.class) {
			if (INSTANCE != null)
				return INSTANCE;

			try {
				LOG.info("need reload GenericObjectPoolImpl");
				INSTANCE = new GenericObjectPoolImpl();
			} catch (ClassNotFoundException e) {
				throw new ResourceFactoryClassNoUploadException(
						"no right resource factory class uploaded, the current enable class is: "
								+ classForResourceFactory, e);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			return INSTANCE;
		}

	}

	private GenericObjectPoolImpl() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		super(getFactoryInstance());
		this.setTestOnBorrow(true);
	}

	@SuppressWarnings("unchecked")
	private static PoolableObjectFactory<Object> getFactoryInstance()
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		InputStream resourceAsStream = GenericObjectPoolImpl.class
				.getClassLoader().getResourceAsStream("config.txt");
		try {
			String string = IOUtils.toString(resourceAsStream);
			LOG.info("import:" + string);
			if (string == null || string.isEmpty()) {
				classForResourceFactory = DEFAULT_RESOURCE_FACTORY;
			} else {
				classForResourceFactory = string;
			}

			LOG.info("new classForResourceFactory: " + classForResourceFactory);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(resourceAsStream);
		}
		return (PoolableObjectFactory<Object>) Class.forName(
				classForResourceFactory).newInstance();
	}

	public static void resetPoolImpl(String newResourceFactory) {
		INSTANCE = null;
        LOG.info("set null to GenericObjectPoolImpl");
 		classForResourceFactory = newResourceFactory;
        LOG.info("set classForResourceFactory:"+newResourceFactory);
 	}

	   public static void resetPoolImpl() {
	        INSTANCE = null;
	        LOG.info("set null to GenericObjectPoolImpl");
	}

	public static String getClassForResourceFactory() {
		return classForResourceFactory;
	}

}
