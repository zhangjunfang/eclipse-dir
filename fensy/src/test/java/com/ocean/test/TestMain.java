package com.ocean.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;

public class TestMain {
	public static void main(String[] args) throws IllegalAccessException,
			InstantiationException {

		// 创建动态Bean所拥有的字段
		DynaProperty[] props = new DynaProperty[] {
				new DynaProperty("id", String.class),
				new DynaProperty("testMap", Map.class),
				new DynaProperty("username", String.class), 
				new DynaProperty("testArray", Integer[].class) 
		
		};

		
		// 创建dynaClass的BasicDynaClass实现,传入定义的props
		DynaClass dynaClass = new BasicDynaClass("bean", null, props);

		
		// 通过dynaClass创建Bean
		DynaBean bean = dynaClass.newInstance();

		
		// 可以按普通bean的方式对其进行使用
		bean.set("id", "hello");
		bean.set("testMap", new HashMap<String,String>());
		bean.set("testMap", "Hello", "World");

		bean.get("id");
		bean.get("testMap", "Hello");


		/*
		 * BasicDynaClass是DynaClass接口的实现类, 
		 * 其中还有LazyDynaClass的实现可以帮助我们更方便
		 * 的使用动态bean,lazy,懒嘛!方便
		 */

		// 不需要再定义dynaProperty,直接赋值时将会自动声明属性
		//DynaClass dynaClass = new LazyDynaClass();

		DynaBean dynaBean = dynaClass.newInstance();

		dynaBean.set("username", "Hello");
		dynaBean.set("testArray", 0, "Hello");
		dynaBean.set("testMap", "Hello", "World");

		dynaBean.get("username");
		dynaBean.get("testArray", 0);
		dynaBean.get("testMap", "Hello");

	}
}
