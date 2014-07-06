package com.iisquare.smh.frame.freemarker;

import java.util.List;

import com.iisquare.smh.frame.util.DPUtil;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

/**
 * 判断变量是否为空
 */
public class EmptyFreemarkerModel implements TemplateMethodModelEx {
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object exec(List list) throws TemplateModelException {
		if (list == null || list.size() < 1) {  
            throw new TemplateModelException("Resource src is null!");  
        }
		return DPUtil.empty(list.get(0));
	}
}