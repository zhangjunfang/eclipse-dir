/**
 * 
 */
package com.bolo.examples.base.service;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author ocean
 * date : 2014-4-13 上午11:03:34
 * email : zhangjunfang0505@163.com
 * Copyright : newcapec zhengzhou
 */
@Service
@Component
@Controller
@Repository
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AAAA  implements  Serializable{

	private static  Log log=LogFactory.getLog(AAAA.class);
	private static final long serialVersionUID = -1135007450118439483L;

	public AAAA() {
		log.info("---------------------------------------------------------------"+System.nanoTime());
		System.out.println("---------------------------------------------------------------"+System.nanoTime());
	}

}
