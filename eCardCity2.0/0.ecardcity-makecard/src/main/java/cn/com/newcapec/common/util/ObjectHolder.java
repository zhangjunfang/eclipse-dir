package cn.com.newcapec.common.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * <p>
 * 对象处理工具类
 * Author : Wangjian 
 * Date : 2013-10-22
 * Time : 16:30:46 
 * Version:1.0
 * </p>
 */
public class ObjectHolder {
	/**
	 * 根据给定的对象List取得某个属性的列表
	 * 
	 * @param 	objectList	对象列表
	 * @param	field		对象的属性
	 * @return	List<Object>
	 * */
	public static <E> List<Object> getFieldList(List<E> objectList, String field) {
		String methodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
		Class<?> cls=null;
		Method method=null;
		Log log = LogFactory.getLog(ObjectHolder.class);
		List<Object> fieldList = new ArrayList<Object>();
		try {
			for (E e : objectList) {
				if(cls==null){
					cls = e.getClass();
					method=cls.getMethod(methodName);
				}
				Object obj = method.invoke(e);
				fieldList.add(obj);
			}
			return fieldList;
		} catch (Exception e1) {
			if (log.isDebugEnabled()) {
				log.debug(e1.getMessage(), e1.getCause());
			}
			return null;
		}
	}
	
/*	public static void main(String[] args){
		Class cls=BaseTPatrolMapping.class;
		Field[] fields=cls.getSuperclass().getDeclaredFields();
		for(Field field:fields){
			System.out.println(field.getName()+":"+field.getType());
		}
	}*/
}
