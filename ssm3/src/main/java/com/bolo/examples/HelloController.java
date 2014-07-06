package com.bolo.examples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author ocean
 * date : 2014-4-14 上午09:25:19
 * email : zhangjunfang0505@163.com
 * Copyright : newcapec zhengzhou
 */
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
}
