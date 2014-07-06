package cn.com.newcapec.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

/**
 * <p>
 * HttpServlet的操作静态方法
 * Author : Wangjian 
 * Date : 2013-01-27
 * Time : 18:17:46 
 * Version:1.0
 * </p>
 */
public class HttpServletHelper{
	/**
	 * <p>
	 * 获取Request对象
	 * @return	HttpServletRequest
	 *  <p>
	 */
	public static HttpServletRequest getRequest(ActionContext ctx){
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		return request;
	}
	
	/**
	 * <p>
	 * 获取Session对象
	 * @return	HttpSession
	 *  <p>
	 */
	public static HttpSession getSession(ActionContext ctx){
		return getRequest(ctx).getSession(true);
	}
	
	/**
	 * 向session设置值
	 * @param key
	 * @param value
	 * void
	 *  
	 */
	public static  void setSessionValue(ActionContext ctx,String key,String value){
		getSession(ctx).setAttribute(key, value);
	}
	

	/**
	 * 获取session中的参数值
	 * @param key
	 * @return
	 * String
	 *  
	 */
	public static  Object getSessionValue(ActionContext ctx,String key){
		return getSession(ctx).getAttribute(key);
	}	
	/**
	 * <p>
	 * 获取Request中的参数值
	 * @param para
	 * @return String
	 * String
	 *  <p>
	 */
	public static  String getReqyestParameter(ActionContext ctx,String para){
		return getRequest(ctx).getParameter(para);
	}
	
	/**
	 * <p>
	 * 获取Request的真实IP地址
	 * @param ctx
	 * @param getProxy	是否获取代理IP地址，如果有的话
	 * @return
	 * String
	 *  <p>
	 */
	public static  String getIP(ActionContext ctx, Boolean getProxy) {
		HttpServletRequest request = getRequest(ctx);
		String ip = null;
		if (getProxy) {
			ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		} else {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
