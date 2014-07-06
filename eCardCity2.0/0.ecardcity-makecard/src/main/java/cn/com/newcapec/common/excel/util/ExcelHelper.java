package cn.com.newcapec.common.excel.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * <p>
 * 功能描述:Excel文件解析工具类
 *   
 * Author : Wangjian 
 * Date   : 2007-11-14 
 * Time   : 09:24:51
 * Version: 1.2
 * </p>
 */
public class ExcelHelper
{ 
	/**
	 * <p>
     * 调用默认构造方法产生一个对象
     *
     * @param classType 类型
     *
     * @return Object
     *
     * @throws Exception 无法构造对象异常
     * </p>
     */
    public static Object getObjectByDefaultConstructor(Class classType) throws Exception
    {
        Constructor constructor = classType.getDeclaredConstructor();
        return constructor.newInstance();
    }

    /**
     * <p>
     * 调用一个参数构造方法产生一个对象
     *
     * @param classType 类型
     * @param value     参数
     *
     * @return Object
     *
     * @throws Exception 无法构造对象异常
     * </p>
     */
    public static Object getObjectByConstructor(Class classType, Object value) throws Exception
    {

        Constructor constructor = classType.getDeclaredConstructor(value.getClass());
        return constructor.newInstance(value);
    }

    /**
     * <p>
     * 调用对象obj的set方法
     *
     * @param obj       对象
     * @param fieldName 名称
     * @param value     参数
     *
     * @throws Exception 调用set方法异常
     * </p>
     */
    public static void invokeSetMethod(Object obj, String fieldName, Object value) throws Exception
    {
        String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Method setMethod = obj.getClass().getDeclaredMethod(setMethodName,value.getClass());
        setMethod.invoke(obj, value);
    }

    /**
     * <p>
     * 调用对象obj的get方法
     *
     * @param obj       对象
     * @param fieldName 名称
     *
     * @return Object
     * @throws Exception 调用get方法异常
     * </p>
     */
    public static Object invokeGetMethod(Object obj, String fieldName) throws Exception
    {
        String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Method getMethod = obj.getClass().getDeclaredMethod(getMethodName);
        return getMethod.invoke(obj);
    }

    /**
     * <p>
     * 如果字符串长度超过maxLength，则截取到最大长度
     *
     * @param str       原字符串
     * @param maxLength 最大长度
     *
     * @return String
     * </p>
     */
    public static String getMaxLengthString(String str, int maxLength)
    {
        if (str == null || str.length() ==0)
        {
            return "";
        }
        if (str.length() > maxLength && maxLength > 0)
        {
            return str.substring(0, maxLength);
        }
        return str;
    }

    /**
     * <p>
     * 如果字符串为NULL，则返回空串
     *
     * @param str 原字符串
     *
     * @return String
     * </p>
     */
    public static String nullToString(String str)
    {
        if (str == null)
        {
            str = "";
        }
        return str;
    }

    /**
     * <p>
     * 将String转化为Integer
     *
     * @param source 原字符串
     *
     * @return Integer
     * </p>
     */
    public static Integer getIntegerByString(String source)
    {
        try
        {
            return Integer.parseInt(source);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    /**
     * <p>
     * 将source中的regex全部替换为replacement
     *
     * @param source 原字符串
     * @param regex  被替换字符串
     * @param replacement  替换字符串
     *
     * @return String
     * </p>
     */
    public static String replaceAll(String source,String regex, String replacement)
    {
        if(source==null||source.length()==0)
        {
            return "";
        }
        return source.replaceAll(regex, replacement);
    }
}
