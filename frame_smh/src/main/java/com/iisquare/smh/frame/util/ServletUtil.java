package com.iisquare.smh.frame.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet操作类
 */
public class ServletUtil {
	
	public static String cookieEnc = "UTF-8";

	public static void addCookie(HttpServletRequest request, HttpServletResponse response, String key, String value, int maxAge) throws UnsupportedEncodingException {
		if(null != value) value = URLEncoder.encode(value, cookieEnc);
		Cookie cookie = new Cookie(key, value);
		String host = request.getHeader("host");
		if(host.indexOf(":") > -1) {
			host = host.split(":")[0];
		}
		cookie.setDomain(host);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
	
	public static String getCookie(HttpServletRequest request, String key) throws UnsupportedEncodingException {
		Cookie cookies[] = request.getCookies();
		if(null == cookies) return null;
		for(Cookie cookie : cookies) {
			if(key.equals(cookie.getName())) return URLDecoder.decode(cookie.getValue(), cookieEnc);
		}
		return null;
	}
	
	public static void setSession(HttpServletRequest request, Map<String, Object> map) {
		HttpSession session = request.getSession();
		for(Map.Entry<String, Object> item : map.entrySet()) {
			session.setAttribute(item.getKey(), item.getValue());
		}
	}
	
	public static void setSession(HttpServletRequest request, String key, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}
	
	public static Map<String, Object> getSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Enumeration<String> e = session.getAttributeNames();
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			map.put(key, session.getAttribute(key));
		}
		return map;
	}
	
	public static Object getSession(HttpServletRequest request, String key) {
		HttpSession session = request.getSession();
		return session.getAttribute(key);
	}
	
	public static void invalidateSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
	}
	
	/**
	 * 获取客户端IP地址
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	public static String getWebRoot(HttpServletRequest request) {
		String webRoot = request.getServletContext().getRealPath("/");
		return webRoot.substring(0, webRoot.length() - 1);
	}
	
	public static String getWebUrl(HttpServletRequest request) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(request.getScheme())
				.append("://")
				.append(request.getServerName());
		if(80 != request.getServerPort()) {
			stringBuffer.append(":").append(request.getServerPort());
		}
		stringBuffer.append(request.getContextPath());
		return stringBuffer.toString();
	}
	
	public static String getDirectorySeparator(HttpServletRequest request) {
		String webRoot = getWebRoot(request);
		if(webRoot.startsWith("/")) return "/";
		return "\\";
	}
}
