package com.googlecode.common.remote.pool.resource;

import java.util.EmptyStackException;
import java.util.Stack;

import org.apache.commons.pool.PoolableObjectFactory;

public class DefaultResourceFactory implements PoolableObjectFactory<Object> {

	private static Stack<Object> stack = new Stack<Object>();

	public DefaultResourceFactory(){
              //add only for demo.
  	}

	@Override
	public Object makeObject() throws Exception {
		try {
			return stack.pop();
		} catch (EmptyStackException e) {
		    return null;
 		}
	}

	public static Stack<Object> getStack() {
		return stack;
	}

	@Override
	public void destroyObject(Object object) throws Exception {
		stack.push(object);
	}

	@Override
	public boolean validateObject(Object object) {
		return object!=null;
	}

	@Override
	public void activateObject(Object object) throws Exception {

	}

	@Override
	public void passivateObject(Object object) throws Exception {

	}

}
