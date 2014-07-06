package com.googlecode.common.remote.pool.resource.example.one;

import java.util.EmptyStackException;
import java.util.Stack;

import org.apache.commons.pool.PoolableObjectFactory;

public class ResourceFactory implements PoolableObjectFactory<Resource> {


	private static Stack<Resource> stack = new Stack<Resource>();

	public ResourceFactory(){
              //add only for demo.
             stack.push(new Resource("env1.properties"));
             stack.push(new Resource("env2.properties"));
 	}

	@Override
	public Resource makeObject() throws Exception {
		try {
			return stack.pop();
		} catch (EmptyStackException e) {
		    return null;
 		}
	}

	@Override
	public void destroyObject(Resource phone) throws Exception {
		stack.push(phone);
	}

	@Override
	public boolean validateObject(Resource paramT) {
		return false;
	}

	@Override
	public void activateObject(Resource paramT) throws Exception {

	}

	@Override
	public void passivateObject(Resource paramT) throws Exception {

	}


}
