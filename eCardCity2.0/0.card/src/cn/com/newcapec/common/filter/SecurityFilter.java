package cn.com.newcapec.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.newcapec.common.util.Constants;

import java.io.IOException;

/**
 * <pre>
 * 功能描述:安全检查,如果用户没有登录,则转到登录页面
 *   
 * Author : Wangjian 
 * Date   : 2007-10-10
 * Time   : 10:24:54
 * Version: 1.0
 * </pre>
 */
public class SecurityFilter implements Filter
{
	private String loginPage = null;

	public void init(FilterConfig config) throws ServletException
	{
		loginPage = config.getInitParameter("loginPage");
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException
	{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if (request.getSession().getAttribute(Constants.SESSION_USER) == null)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
			dispatcher.forward(request, response);
		}
		else
		{
			chain.doFilter(request, response);
		}
	}

	public void destroy()
	{
		loginPage = null;
	}
}
