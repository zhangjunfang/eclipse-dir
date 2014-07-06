package cn.com.newcapec.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * 格式化日期  
 * Author : Wangjian 
 * Date : 2007-10-11 
 * Time : 18:17:46 
 * Version:1.0
 * </pre>
 */
public class DateHelper
{
	/* 日期格式 */
	public static final String FULL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String MIDDLE_DATE_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String yyyyMMdd="yyyyMMdd";
	
	/**
	 * <pre>
	 * 功能描述：将日期转化为指定格式的字符串
	 * 
	 * @param date 日期
	 * @param format 格式字符串
	 * @return String 返回转化后的字符串,若转化出错则返回空串
	 * </pre>
	 */
	public static String formatDate(Date date, String format)
	{
		try
		{
			return new SimpleDateFormat(format).format(date);
		}
		catch (Exception e)
		{
			return "";
		}
	}

	/**
	 * <pre>
	 * 功能描述：将指定格式的字符串转化为日期
	 * 
	 * @param source 源字符串
	 * @param format 格式字符串
	 * @return Date 返回转化后的日期串,若转化出错则返回null
	 * </pre>
	 */
	public static Date parseDate(String source, String format)
	{
		try
		{
			return new SimpleDateFormat(format).parse(source);
		}
		catch (Exception e)
		{
			return null;
		}
	}

}
