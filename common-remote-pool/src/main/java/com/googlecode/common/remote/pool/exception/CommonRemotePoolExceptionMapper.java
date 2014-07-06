package com.googlecode.common.remote.pool.exception;
 
import java.util.NoSuchElementException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
 
@Provider
 public class CommonRemotePoolExceptionMapper implements ExceptionMapper<Exception> 
{

	private final static Logger LOG=Logger.getLogger(CommonRemotePoolExceptionMapper.class);

	@Override
	public Response toResponse(Exception exception) {
		String message = exception.getMessage();
		LOG.info("receive exception:"+exception.getClass());
		LOG.info("receive exception:"+message);
  
		if(exception instanceof ResourceFactoryClassNoUploadException || exception.getCause() instanceof ResourceFactoryClassNoUploadException){
	         return Response.status(Status.NOT_ACCEPTABLE).entity(message).build();  
 		}
		
		if(exception instanceof NoSuchElementException || exception instanceof NoResourceCanUsedException){
			return Response.status(Response.Status.NOT_FOUND)
					.entity("no any resource can be used for: "+message).build();
		}
   		
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(message).build();  
	}
 
}