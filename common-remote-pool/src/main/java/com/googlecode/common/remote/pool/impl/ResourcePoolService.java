package com.googlecode.common.remote.pool.impl;

import java.lang.reflect.Method;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.spi.BadRequestException;

import com.googlecode.common.remote.pool.exception.NoResourceCanUsedException;

@Path("object")
public class ResourcePoolService {

	private final static Logger LOG=Logger.getLogger(ResourcePoolService.class);


	private static ResourcePoolService INSTANCE;

	public static ResourcePoolService getInstance() {
		if (INSTANCE != null) {
			return INSTANCE;
		}

		synchronized (ResourcePoolService.class) {
			if (INSTANCE != null) {
				return INSTANCE;
			}

			INSTANCE = new ResourcePoolService();
			return INSTANCE;
		}
	}

	@GET
	@Path("borrow")
	@Produces(MediaType.APPLICATION_JSON)
	public Object borrow() throws Exception {
		Object borrowObject = getObjectPoolImpl().borrowObject();
		if (borrowObject == null)
			throw new NoResourceCanUsedException();

		return borrowObject;
	}

	@GET
	@Path("getFactory")
	public Response getFactory() {
		String factory = GenericObjectPoolImpl.getClassForResourceFactory();
		return Response.ok(factory, MediaType.TEXT_PLAIN_TYPE).build();
	}

	@GET
	@Path("drain")
	public Response drain() throws Exception {
        GenericObjectPoolImpl.resetPoolImpl();
        return Response.status(200).entity("OK").build();
	}

	@POST
	@Path("return")
	@Consumes(MediaType.APPLICATION_JSON)
	public void returnObject(Object object) throws Exception {
		getObjectPoolImpl().returnObject(object);
	}

	public void returnObjectWithoutActiveNumberChanage(Object object) throws Exception {
		GenericObjectPoolImpl objectPoolImpl = getObjectPoolImpl();
		Class<?> superclass = objectPoolImpl.getClass().getSuperclass();
		Method method = superclass.getDeclaredMethod("addObjectToPool",Object.class, boolean.class);
		method.setAccessible(true);
		method.invoke(objectPoolImpl,object, false);
	}

	@POST
	@Path("add")
	public Response addObject(@Form ResouceAddForm form) {
		LOG.info("begin to add resource:");

		String originalJsonContent = form.getJsonContent();
		if (originalJsonContent.isEmpty()) {
			throw new BadRequestException("content is empty");
		}
		String jsonContent = originalJsonContent.trim();
		LOG.info("jsonContent:" + jsonContent);
		try {
			if (jsonContent.startsWith("[")) {
				ObjectMapper objectMapper = new ObjectMapper();
				Object[] readValue = objectMapper.readValue(jsonContent,
						Object[].class);
				for (Object object : readValue) {
					returnObjectWithoutActiveNumberChanage(object);
				}

			} else {
				ObjectMapper objectMapper = new ObjectMapper();
				Object object = objectMapper.readValue(jsonContent,
						Object.class);
				returnObjectWithoutActiveNumberChanage(object);
 			}
			return Response.status(200).entity("OK").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("FAIL:" + e.getMessage())
					.build();
		}

	}

	/**
	 *
	 *
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("active")
	public Response getActiveNumber() throws Exception {
		GenericObjectPoolImpl objectPoolImpl = getObjectPoolImpl();
		int activeNumber = objectPoolImpl.getNumActive();

		return Response.ok(activeNumber, MediaType.TEXT_PLAIN_TYPE).build();
	}

	@GET
	@Path("info")
	public Response getPoolInfo() throws Exception {
		GenericObjectPoolImpl objectPoolImpl = getObjectPoolImpl();
		int activeNumber = objectPoolImpl.getNumActive();
		int idleNumber=objectPoolImpl.getNumIdle();
		int totalNumber=activeNumber+idleNumber;

		return Response.ok(new PoolInfo(activeNumber,idleNumber,totalNumber), MediaType.APPLICATION_JSON_TYPE).build();
	}

	@GET
	@Path("idle")
	public Response getIdleNumber() throws Exception {
		int activeNumber = getObjectPoolImpl().getNumIdle();
 		return Response.ok(activeNumber, MediaType.TEXT_PLAIN_TYPE).build();
	}

	private GenericObjectPoolImpl getObjectPoolImpl() {
		return GenericObjectPoolImpl.getInstance();
	}
}
