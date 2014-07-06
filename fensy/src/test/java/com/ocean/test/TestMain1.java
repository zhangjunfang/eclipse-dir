package com.ocean.test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;


public class TestMain1 {
	public static void main(String[] args) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			InstantiationException {
		Test test1 = new Test();
		Test test2 = new Test();

		
		// 复制单个属性
		BeanUtils.copyProperty(test1, "username", test2);

		
		// 克隆对象,注意是浅克隆
		@SuppressWarnings("unused")
		Test test3 = (Test) BeanUtils.cloneBean(test1);

		
		/*
		 * 在设置时间时,读者需要注意一个小问题, 
		 * 用-->setProperty(test1, "date", new Date());
		 * 这种方式设置时间时没有问题的,但若然使用字符串的形式2013-10-3
		 * 就会出现问题,这是因为BeanUtils无法识别字符串类型和时间类型的关系,
		 * 所以我们需要使用ConvertUtils来辅助BeanUtils,
		 * 但使用如下方式进行转换后,PropertyUtils仍然是无能为力
		 */
		
		//用此种方式没任何问题
		BeanUtils.setProperty(test1, "date", new Date()); 
		//此种方式无法区别字符串还是日期
		//BeanUtils.setProperty(test1, "date", "2013-10-01");

		
		// 自定义一个转换器
		ConvertUtils.register(new Converter() {

			@SuppressWarnings("rawtypes")
			@Override
			public Object convert(Class type, Object value) {
				if (value == null) {
					throw new RuntimeException("value is null");
				}
				if (value.getClass() == Date.class) {
					return value;
				}
				if (value.getClass() != String.class) {
					throw new RuntimeException("type not match");
				}
				String valueStr = (String) value;
				if (StringUtils.isBlank(valueStr)) {
					throw new RuntimeException("string is empty");
				}
				try {
					return new SimpleDateFormat("yyyy-MM-dd").parse(valueStr);
				} catch (ParseException e) {
					e.printStackTrace();
					return null;
				}
			}
		}, Date.class);

		// 此时使用字符串的日期形式都可以成功转换
		BeanUtils.setProperty(test1, "date", "2013-10-1");
	}
}
