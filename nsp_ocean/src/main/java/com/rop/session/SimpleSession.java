
package com.rop.session;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 功能说明：
 * </pre>
 */
@SuppressWarnings("all")
public class SimpleSession implements Session {

    private Map<String, Object> attributes = new HashMap<String, Object>();

    @Override
	public void setAttribute(String name, Object obj) {
        attributes.put(name, obj);
    }

    @Override
	public Object getAttribute(String name) {
        return attributes.get(name);
    }
}

