package com.googlecode.common.remote.pool.resource.example.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

import org.apache.commons.pool.PoolableObjectFactory;

public class ResourceFactory implements PoolableObjectFactory<Resource> {

	public static final String CONFIG_FILE = "resource.txt";

	private static Stack<Resource> stack = new Stack<Resource>();

	static {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ResourceFactory.class
				.getResourceAsStream(CONFIG_FILE)));
		try {
			String extensionLine;
			while ((extensionLine = bufferedReader.readLine()) != null) {
				String[] split = extensionLine.split(",");
				stack.push(new Resource(split[0], split[1], split[2], split[3]));

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

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
