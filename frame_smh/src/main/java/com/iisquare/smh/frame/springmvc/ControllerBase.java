package com.iisquare.smh.frame.springmvc;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iisquare.smh.frame.FrameConfiguration;
import com.iisquare.smh.frame.util.DPUtil;
import com.iisquare.smh.frame.util.ServletUtil;

public abstract class ControllerBase {
	
	public static class ControllerResultType {
		public static final String _FREEMARKER_ = "_FREEMARKER_";
		public static final String _REDIRECT_ = "_REDIRECT_";
		public static final String _TEXT_ = "_TEXT_";
		public static final String _STREAM_ = "_STREAM_";
		public static final String _PLAIN_TEXT_ = "_PLAIN_TEXT_";
	}
	
	@Autowired
	private FrameConfiguration frameConfiguration;
	
	public ControllerBase _BASE_;
	public HttpServletRequest _REQUEST_;
	public HttpServletResponse _RESPONSE_;
	public String _, _MODULE_, _CONTROLLER_, _ACTION_;
	public Map<String, Object> _ASSIGN_;
	public String _WEB_ROOT_, _WEB_URL_, _SKIN_URL_, _THEME_URL_, _DIRECTORY_SEPARATOR_;
	
	public FrameConfiguration getFrameConfiguration() {
		return frameConfiguration;
	}

	public void setFrameConfiguration(FrameConfiguration frameConfiguration) {
		this.frameConfiguration = frameConfiguration;
	}

	public ControllerBase() {
		
    }
	
	/**
	 * 初始化函数，设置相关参数
	 */
	public void init(HttpServletRequest request, HttpServletResponse response, Object handler) {
		_BASE_ = this;
		_REQUEST_ = request;
		_RESPONSE_ = response;
		_ASSIGN_ = new HashMap<String, Object>(0);
		_WEB_ROOT_ = ServletUtil.getWebRoot(request);
		_WEB_URL_ = ServletUtil.getWebUrl(request);
		if(DPUtil.empty(frameConfiguration.getSkinFolder())) {
			_SKIN_URL_ = _WEB_URL_;
		} else {
			StringBuffer stringBuffer = new StringBuffer(_WEB_URL_);
			stringBuffer.append("/").append(frameConfiguration.getSkinFolder());
			_SKIN_URL_ = stringBuffer.toString();
		}
		if(DPUtil.empty(frameConfiguration.getThemeName())) {
			_THEME_URL_ = _SKIN_URL_;
		} else {
			StringBuffer stringBuffer = new StringBuffer(_SKIN_URL_);
			stringBuffer.append("/").append(frameConfiguration.getThemeName());
			_THEME_URL_ = stringBuffer.toString();
		}
		_DIRECTORY_SEPARATOR_ = ServletUtil.getDirectorySeparator(request);
		Method method = ((HandlerMethod) handler).getMethod();
		/* 提取相关URI路径参数 */
		String classFullName = this.getClass().getName();
		String actionName = method.getName();
		/* 约定前提判定 */
		if(classFullName.startsWith(frameConfiguration.getModulePrefix())
				&& classFullName.endsWith(frameConfiguration.getControllerSuffix())
				&& actionName.endsWith(frameConfiguration.getActionSuffix())) {
			/* 提取Module名称 */
			String moduleName = classFullName.substring(0, classFullName.lastIndexOf("."));
			moduleName = moduleName.substring(frameConfiguration.getModulePrefix().length());
			_MODULE_ = moduleName.replaceAll("\\.", "/");
			/* 提取Controller名称 */
			String controllerName = classFullName.substring(classFullName.lastIndexOf(".") + 1);
			controllerName = controllerName.substring(0, controllerName.lastIndexOf(frameConfiguration.getControllerSuffix()));
			_CONTROLLER_ = DPUtil.lowerCaseFirst(controllerName);
			/* 提取Action名称 */
			_ACTION_ = actionName.substring(0, actionName.lastIndexOf(frameConfiguration.getActionSuffix()));
		}
	}
	
	/**
	 * 当Action方法执行后被调用
	 */
	public void destroy(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		String viewName = modelAndView.getViewName();
		if(DPUtil.empty(viewName)) {
			modelAndView.clear();
		} else if(viewName.startsWith("redirect:")) {
			modelAndView.addAllObjects(_ASSIGN_);
		} else {
			modelAndView.addObject("_BASE_", _BASE_)
			.addObject("_REQUEST_", _REQUEST_)
			.addObject("_RESPONSE_", _RESPONSE_)
			.addObject("_MODULE_", _MODULE_)
			.addObject("_CONTROLLER_", _CONTROLLER_)
			.addObject("_ACTION_", _ACTION_)
			.addObject("_WEB_ROOT_", _WEB_ROOT_)
			.addObject("_WEB_URL_", _WEB_URL_)
			.addObject("_SKIN_URL_", _SKIN_URL_)
			.addObject("_THEME_URL_", _THEME_URL_)
			.addObject("_CONFIG_", frameConfiguration)
			.addObject("_DIRECTORY_SEPARATOR_", _DIRECTORY_SEPARATOR_)
			.addAllObjects(_ASSIGN_);
		}
	}
	
	protected String url() {
		return url(_ACTION_);
	}
	
	protected String url(String action) {
		return url(_CONTROLLER_, action);
	}
	
	protected String url(String controller, String action) {
		return url(_MODULE_, controller, action);
	}
	
	/**
	 * 获取URL地址
	 * @param module 模块名称
	 * @param controller 控制器名称
	 * @param action 方法名称
	 * @return
	 */
	protected String url(String module, String controller, String action) {
		StringBuffer sb = new StringBuffer("/");
		sb.append(module).append("/").append(controller).append("/").append(action);
		return sb.toString();
	}
	
	protected String displayTemplate() throws Exception {
		return displayTemplate(_ACTION_);
	}
	
	protected String displayTemplate(String action) throws Exception {
		return displayTemplate(_CONTROLLER_, action);
	}
	
	protected String displayTemplate(String controller, String action) throws Exception {
		return displayTemplate(_MODULE_, controller, action);
	}
	
	/**
	 * 渲染视图
	 * @param module
	 * @param controller
	 * @param action
	 * @return
	 * @throws Exception
	 */
	protected String displayTemplate(String module, String controller, String action) throws Exception {
		StringBuffer sb = new StringBuffer("/");
		sb.append(module).append("/").append(controller).append("/").append(action);
		return display(sb.toString(), ControllerResultType._FREEMARKER_);
	}
	
	/**
	 * 输出文本信息
	 * @param text
	 * @return
	 * @throws Exception
	 */
	protected String displayText(String text) throws Exception {
		return display(text, ControllerResultType._TEXT_);
	}
	
	protected String displayJSON() throws Exception {
		return displayJSON(_ASSIGN_);
	}
	
	/**
	 * 输出JSON信息
	 * @param object
	 * @return
	 * @throws Exception
	 */
	protected String displayJSON(Object object) throws Exception {
		String result;
		if(object instanceof Map) {
			result = JSONObject.fromObject(object).toString();
		} else {
			result = JSONArray.fromObject(object).toString();
		}
		return display(result, ControllerResultType._TEXT_);
	}
	
	protected String redirect() throws Exception {
		return redirect(_ACTION_);
	}
	
	/**
	 * 重定向自定义URL地址
	 * @param url
	 * @return
	 * @throws Exception
	 */
	protected String redirect(String url) throws Exception {
		return display(url, ControllerResultType._REDIRECT_);
	} 
	
	protected String redirect(String action, String params) throws Exception {
		return redirect(_CONTROLLER_, action, params);
	}
	
	protected String redirect(String controller, String action, String params) throws Exception {
		return redirect(_MODULE_, controller, action, params);
	}
	
	/**
	 * 重定向至对应控制器
	 * @param module
	 * @param controller
	 * @param action
	 * @param params
	 * @return
	 * @throws Exception
	 */
	protected String redirect(String module, String controller, String action, String params) throws Exception {
		StringBuffer sb = new StringBuffer("/");
		sb.append(module).append("/").append(controller).append("/").append(action).append(params);
		return display(sb.toString(), ControllerResultType._REDIRECT_);
	}
	
	/**
	 * 根据类型输出视图
	 * @param result
	 * @param type
	 * @return
	 * @throws Exception
	 */
	protected String display(String result, String type) throws Exception {
		if(ControllerResultType._FREEMARKER_ == type) {
			if(!DPUtil.empty(frameConfiguration.getThemeName())) {
				StringBuffer stringBuffer = new StringBuffer("/");
				stringBuffer.append(frameConfiguration.getThemeName()).append(result);
				return stringBuffer.toString();
			}
			return result;
		} else if(ControllerResultType._TEXT_ == type){
			PrintWriter out = _RESPONSE_.getWriter();
			out.print(result);
			out.flush();
			return "";
		} else if (ControllerResultType._REDIRECT_ == type) {
			return "redirect:" + result;
		}
		return null;
	}
	
	/**
	 * 设置视图中需要的参数
	 * @param key
	 * @param value
	 */
	protected void assign(String key, Object value) {
		_ASSIGN_.put(key, value);
	}

	/**
	 * 获取请求参数
	 * @param key 参数名称
	 * @param bReturnNull 当参数不存在时返回NULL或空字符串
	 * @return
	 */
	protected String get(String key, Boolean bReturnNull) {
		String value = _REQUEST_.getParameter(key);
		if(null == value && !bReturnNull) {
			return "";
		}
		return value;
	}
	
	protected String get(String key) {
		return get(key, false);
	}
	
	/**
	 * 获取请求参数数组
	 * @param key 参数名称
	 * @param bReturnNull 当参数不存在时返回NULL或空字符串数组
	 * @return
	 */
	protected String[] gets(String key, Boolean bReturnNull) {
		String[] values = _REQUEST_.getParameterValues(key);
		if(null == values && !bReturnNull) {
			String[] temp = {};
			return temp;
		}
		return values;
	}
	
	protected String[] gets(String key) {
		return gets(key, false);
	}
	
	/**
	 * 当对象不存在时返回空字符串
	 * @param object
	 * @return
	 */
	protected String S(Object object) {
		if(DPUtil.empty(object)) return "";
		return object.toString();
	}
	
	/**
	 * 当对象不存在时返回0
	 * @param object
	 * @return
	 */
	protected int I(Object object) {
		return DPUtil.parseInt(object);
	}
}
