package com.iisquare.smh.frame.freemarker;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;

/**
 * FreeMarker自定义函数管理器
 */
public class TemplateFreemarkerManager {
	private FreeMarkerConfigurer freeMarkerConfigurer;

	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		return freeMarkerConfigurer;
	}

	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
        configuration.setSharedVariable("millisToDateTime", new MillisToDateTimeFreemarkerModel());
        configuration.setSharedVariable("empty", new EmptyFreemarkerModel());
        configuration.setSharedVariable("escapeHtml", new EscapeHtmlFreemarkerModel());
        configuration.setSharedVariable("unescapeHtml", new UnescapeHtmlFreemarkerModel());
	}
	
	public TemplateFreemarkerManager() {
		
	}
}
