package cn.com.newcapec.common.interceptor;

import cn.com.newcapec.common.util.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * <p>
 * 功能描述:认证拦截,如果用户没有登录,则转到登录页面
 *   
 * Author : Wangjian 
 * Date   : 2007-10-10
 * Time   : 10:24:54
 * Version: 1.0
 * </p>
 */
public class AuthenticationInterceptor implements Interceptor {
	private static final long serialVersionUID = -5472538284025813826L;

	public void init() {
	}

	public String intercept(ActionInvocation ai) throws Exception {

		if (ai.getInvocationContext().getSession().get(Constants.SESSION_USER) == null) {
			//TODO 特殊URL拦截器放行
//			HttpServletRequest request = ServletActionContext.getRequest();
//			if(!request.getRequestURI().endsWith("_view.action")){
				return Action.LOGIN;
//			}
		}
		return ai.invokeActionOnly();
	}

	public void destroy() {
	}
}
