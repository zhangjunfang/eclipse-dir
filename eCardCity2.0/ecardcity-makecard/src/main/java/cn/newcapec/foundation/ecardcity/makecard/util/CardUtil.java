/**  
 * @Title: CardUtil.java
 * @Package cn.newcapec.foundation.ecardcity.makecard.util
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-5-16 上午09:39:52
 * @version V1.0  
 */
package cn.newcapec.foundation.ecardcity.makecard.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.newcapec.framework.core.exception.BaseException;

/**
 * @Description: 卡务部分常用公共类
 * @author 高崇飞
 * @date 2014-5-16 上午09:39:52
 * @version V1.0
 */
public class CardUtil {

	/**
	 * @Description: 以指定格式获取当前时间 --可以放到公共方法
	 * @param @param format 格式 如：//"yyyy-MM-dd HH:mm:ss"
	 * @param @return
	 * @return Date
	 * @throws
	 * @author 高崇飞
	 * @date 2014-4-21 下午03:49:52
	 * @version V1.0
	 */
	public static Date getNowDate(String format) {
		Date date = new Date();
		SimpleDateFormat sbf = new SimpleDateFormat(format);
		try {
			date = sbf.parse(sbf.format(date));
		} catch (ParseException e) {
			throw new BaseException("设置日期时间错误!", e);
		}
		return date;
	}

	/**
	 * @Description: 以指定格式获取当前时间 --可以放到公共方法
	 * @param format
	 *            格式 如：//"yyyy-MM-dd HH:mm:ss"
	 * @return String
	 * @author 高崇飞
	 * @date 2014-5-20 下午03:49:52
	 * @version V1.0
	 */
	public static String getNowDateStr(String format) {
		Date date = new Date();
		SimpleDateFormat sbf = new SimpleDateFormat(format);
		String dateStr = sbf.format(date);
		return dateStr;
	}
}
