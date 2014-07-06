package com.iisquare.smh.frame.springmvc;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;
import org.springframework.web.servlet.mvc.condition.HeadersRequestCondition;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.iisquare.smh.frame.FrameConfiguration;
import com.iisquare.smh.frame.util.DPUtil;

public class ControllerRequestMappingHandlerMapping extends
		RequestMappingHandlerMapping {

	private FrameConfiguration frameConfiguration;
	private boolean useSuffixPatternMatch = true;
	private boolean useTrailingSlashMatch = true;
	private final List<String> fileExtensions = new ArrayList<String>();
	
	public FrameConfiguration getFrameConfiguration() {
		return frameConfiguration;
	}

	public void setFrameConfiguration(FrameConfiguration frameConfiguration) {
		this.frameConfiguration = frameConfiguration;
	}

	@Override
	protected RequestMappingInfo getMappingForMethod(Method method,
			Class<?> handlerType) {
		RequestMappingInfo info =  super.getMappingForMethod(method, handlerType);
		if(null == info) { // 未设置@RequestMapping时执行约定路由映射
			/* 提取相关URI路径参数 */
			String classFullName = method.getDeclaringClass().getName();
			String actionName = method.getName();
			Scope scope = method.getDeclaringClass().getAnnotation(Scope.class);
			/* 约定前提判定 */
			if(null == scope // 确保对象为多实例模式
					|| !ConfigurableBeanFactory.SCOPE_PROTOTYPE.equals(scope.value())) return null;
			if(!classFullName.startsWith(frameConfiguration.getModulePrefix())) return null;
			if(!classFullName.endsWith(frameConfiguration.getControllerSuffix())) return null;
			if(!actionName.endsWith(frameConfiguration.getActionSuffix())) return null;
			/* 提取Module名称 */
			String moduleName = classFullName.substring(0, classFullName.lastIndexOf("."));
			moduleName = moduleName.substring(frameConfiguration.getModulePrefix().length());
			/* 提取Controller名称 */
			String controllerName = classFullName.substring(classFullName.lastIndexOf(".") + 1);
			controllerName = controllerName.substring(0, controllerName.lastIndexOf(frameConfiguration.getControllerSuffix()));
			controllerName = DPUtil.lowerCaseFirst(controllerName);
			/* 提取Action名称 */
			actionName = actionName.substring(0, actionName.lastIndexOf(frameConfiguration.getActionSuffix()));
			/* 组合Pattern路径 */
			StringBuffer patternBuffer = new StringBuffer();
			if(0 < moduleName.length()) {
				patternBuffer.append("/")
						.append(moduleName.replaceAll("\\.", "/"));
			}
			patternBuffer.append("/")
					.append(controllerName)
					.append("/")
					.append(actionName);
			String[] patterns = {patternBuffer.toString()};
			/* 生成RequestMappingInfo对象 */
			RequestCondition<?> methodCondition = getCustomMethodCondition(method);
			info = new RequestMappingInfo(
					new PatternsRequestCondition(patterns, getUrlPathHelper(), getPathMatcher(),
							this.useSuffixPatternMatch, this.useTrailingSlashMatch, this.fileExtensions),
					new RequestMethodsRequestCondition(),
					new ParamsRequestCondition(),
					new HeadersRequestCondition(),
					new ConsumesRequestCondition(),
					new ProducesRequestCondition(),
					methodCondition);
		}
		return info;
	}

}
