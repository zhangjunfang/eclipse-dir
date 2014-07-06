package com.iisquare.smh.frame.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ControllerHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			Object object = ((HandlerMethod) handler).getBean();
			if(object instanceof ControllerBase) {
				((ControllerBase) object).init(request, response, handler);
			}
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (handler instanceof HandlerMethod) {
			Object object = ((HandlerMethod) handler).getBean();
			if(object instanceof ControllerBase) {
				((ControllerBase) object).destroy(request, response, handler, modelAndView);
			}
		}
		super.postHandle(request, response, handler, modelAndView);
	}

}
