/*  
 * @(#) SpringConext.java Create on 2013-5-30 上午11:38:48   
 *   
 * Copyright 2013 by pztx.   
 */

package cn.newcapec.function.citycard.platform.privilege.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @author andy.li
 */
@Component
public class SpringBusinessConexts implements ApplicationContextAware {

	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext acx) {
		context = acx;
	}

	public static ApplicationContext getApplicationContext() {
		return context;
	}
}
