package com.ocean.test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

public class TestMain2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		// 初始化信息
		Test test = new Test();
		Integer[] testArray = new Integer[10];
		Map<String, String> testMap = new HashMap<String, String>();

		
		// 以下方法名为set开始的方法均有get方法与其对应

		
		// 设置username,testArray,testMap属性
		PropertyUtils.setProperty(test, "username", "Hello");
		PropertyUtils.setProperty(test, "testArray", testArray);
		PropertyUtils.setProperty(test, "testMap", testMap);

		
		// 设置testArray属性下标为0的值为10
		PropertyUtils.setIndexedProperty(test, "testArray[0]", 10);

		
		// 设置testMap属性的值为参数三,遗憾是 key参数只支持字符串
		PropertyUtils.setMappedProperty(test, "testMap", "Hello", "10");

		
		// 在类中有嵌套类的时候,就不能使用简单的setProperty来对引用类设置属性,
		// 要使用nested,address为test类中属性名引用
		PropertyUtils.setProperty(test, "address", new Address());
		PropertyUtils.setNestedProperty(test, "address.id", 1);

		
		// 判断属性是否有get方法或set方法
		PropertyUtils.isReadable(test, "username");
		PropertyUtils.isWriteable(test, "username");

		
		// 返回该实例全部属性,属性名为key,值为value
		@SuppressWarnings("unused")
		Map<String, Object> map = PropertyUtils.describe(test);

		
		// 把test对象的所有属性复制到test2对象当中,
		// 通过反射字段名匹配进行复制,但要注意将会覆盖原值
		Test test2 = new Test();
		PropertyUtils.copyProperties(test2, test);


		// 获取属性的Class类型
		PropertyUtils.getPropertyType(test, "username");
	}
}
