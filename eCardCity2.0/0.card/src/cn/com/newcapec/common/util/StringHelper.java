package cn.com.newcapec.common.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

/**
 * <pre>
 * 字符处理实用工具  
 * Author : Wangjian 
 * Date : 2007-11-08 
 * Time : 17:28:46 
 * Version:1.0
 * </pre>
 */
public class StringHelper{
	/**
	 * <pre>
	 * 功能描述：将字符串数组转化为Integer数组
	 * 
	 * @param source 源字符串数组
	 * 
	 * @return Integer 返回转化后的Integer类型,转化失败返回null
	 * </pre>
	 */
	public static Integer[] toInteger(String[] source){
		Integer[] rtn=new Integer[source.length];
		try{
			for(int i=0;i<source.length;i++){
				rtn[i]=Integer.valueOf(source[i]);
			}
			return rtn;
		}
		catch (Exception e){
			return null;
		}
	}

	/**
	 * <pre>
	 * 功能描述：将字符串转化为Integer类型
	 * 
	 * @param source 源字符串
	 * 
	 * @return Integer 返回转化后的Integer类型,转化失败返回null
	 * </pre>
	 */
	public static Integer toInteger(String source)
	{
		try
		{
			return Integer.valueOf(source);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * <pre>
	 * 功能描述：将字符串转化为Long类型
	 * 
	 * @param source 源字符串
	 * 
	 * @return Long 返回转化后的Long类型,转化失败返回null
	 * </pre>
	 */
	public static Long toLong(String source)
	{
		try
		{
			return Long.valueOf(source);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * <pre>
	 * 功能描述：将字符串中的单引号替换为双引号
	 * 
	 * @param source 源字符串
	 * 
	 * @return String 返回转化后的字符串
	 * </pre>
	 */
	public static String quot1ToQuot2(String source)
	{
		if (source == null)
		{
			return "";
		}
		return source.replaceAll("'", "''");
	}

	/**
	 * <pre>
	 * 功能描述：若字符串为null,则转化为空串;否则返回源串
	 * 
	 * @param source 源字符串
	 * 
	 * @return String 返回转化后的字符串
	 * </pre>
	 */
	public static String null2Blank(String source)
	{
		return source == null ? "" : source;
	}

	/**
	 * <pre>
	 * 功能描述：若数字的长度小于指定的长度前补零
	 * 
	 * @param num 数字
	 * @param length 长度 
	 * 
	 * @return String 返回补零后的数字字符串
	 * </pre>
	 */
	public static String fillZero(Integer num, Integer length)
	{
		if (num == null)
		{
			return "";
		}
		if (length == null)
		{
			return num.toString();
		}
		String str = num.toString();
		int len = length - str.length();
		if (len <= 0)
		{
			return str;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++)
		{
			sb.append("0");
		}
		sb.append(str);
		return sb.toString();
	}

	/**
	 * <pre>
	 * 功能描述：移除数字字符串前的零,并转化为整数
	 * 
	 * @param str 数字字符串
	 * 
	 * @return Integer 返回转化后的整数
	 * </pre>
	 */
	public static Integer removeZero(String str)
	{
		if (str == null || str.length() == 0)
		{
			return 0;
		}
		int idx = 0;
		for (char c : str.toCharArray())
		{
			if (c != '0')
			{
				break;
			}
			idx++;
		}
		Integer num = toInteger(str.substring(idx));
		return num == null ? 0 : num;
	}

	/**
	 * <pre>
	 * 如果字符串长度超过maxLength，则截取到最大长度
	 * 
	 * @param str       原字符串
	 * @param maxLength 最大长度
	 * 
	 * @return String
	 * </pre>
	 */
	public static String getMaxLengthString(String str, int maxLength)
	{
		if (str == null || str.length() == 0)
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
     * 功能描述:对密码进行MD5格式的加密算法
     * 
     * @param password 前台传来的用户密码
     * 
     * @return Password_MD5 经过算法加密后的密码串
     * 
     * @throws Exception
     */
    public static String convertToMd5(String password) throws Exception{
    	MessageDigest md5;
	    md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
	    String Password_MD5=base64en.encode(md5.digest(password.getBytes("utf-8")));
		for (int i = 0; i < Password_MD5.length(); i++) {
			if (Password_MD5.charAt(i)  == '+') {
				Password_MD5 = Password_MD5.replace('+', '1');
				}
			if (Password_MD5.charAt(i)  == '#') {
				Password_MD5 = Password_MD5.replace('#', '1');
				}
			if (Password_MD5.charAt(i)   == '&') {
				Password_MD5 = Password_MD5.replace('&', '1');
				}
			}
		return Password_MD5;
    }

}
