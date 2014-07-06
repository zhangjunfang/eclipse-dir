/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wj
 * @category 日期处理类
 * @version 1.0
 * @date 2014年4月30日 上午10:22:11
 */
public class DateUtil {
    /* 日期格式 */
    public static final String FULL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String MIDDLE_DATE_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 功能描述：将日期转化为指定格式的字符串
     * 
     * @param date 日期
     * @param format 格式字符串
     * @return String 返回转化后的字符串,若转化出错则返回空串
     */
    public static String formatDate(Date date, String format) {
	try {
	    return new SimpleDateFormat(format).format(date);
	} catch (Exception e) {
	    return "";
	}
    }

    /**
     * 功能描述：将指定格式的字符串转化为日期
     * 
     * @param source 源字符串
     * @param format 格式字符串
     * @return Date 返回转化后的日期串,若转化出错则返回null
     */
    public static Date parseDate(String source, String format) {
	try {
	    return new SimpleDateFormat(format).parse(source);
	} catch (Exception e) {
	    return null;
	}
    }
}
