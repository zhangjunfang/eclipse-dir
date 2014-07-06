package com.googlecode.common.remote.pool.impl;

import java.lang.reflect.Field;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

@Path("object")
public class DefaultResourcePoolService {

	private final static Logger LOG=Logger.getLogger(DefaultResourcePoolService.class);

	private static DefaultResourcePoolService INSTANCE;

	public static DefaultResourcePoolService getInstance() {
		if (INSTANCE != null) {
			return INSTANCE;
		}

		synchronized (DefaultResourcePoolService.class) {
			if (INSTANCE != null) {
				return INSTANCE;
			}

			INSTANCE = new DefaultResourcePoolService();
			return INSTANCE;
		}
	}

 	@GET
	@Path("list")
	public Response list() throws Exception {
 		Class<?> superclass = getObjectPoolImpl().getClass().getSuperclass();
		Field declaredField = superclass.getDeclaredField("_pool");
		declaredField.setAccessible(true);

		String result=declaredField.get(getObjectPoolImpl()).toString();
     	System.out.println(result);

      	if(result.equalsIgnoreCase("[]"))
     		 result="no any resource";

    	System.out.println(result);

    	result=result.replace(", {", "<br>{");
    	result=result.replace("[", "");
    	result=result.replace("]", "");



		return Response.ok(result, MediaType.TEXT_PLAIN_TYPE).build();
	}


	private GenericObjectPoolImpl getObjectPoolImpl() {
		return GenericObjectPoolImpl.getInstance();
	}

}
