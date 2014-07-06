package com.iisquare.smh.frame.freemarker;

import java.util.List;

import com.iisquare.smh.frame.FrameConfiguration;
import com.iisquare.smh.frame.util.DPUtil;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

/**
 * 将毫秒转换为日期格式
 */
public class MillisToDateTimeFreemarkerModel implements TemplateMethodModelEx {
	
	private FrameConfiguration frameConfiguration;
	
	public FrameConfiguration getFrameConfiguration() {
		return frameConfiguration;
	}

	public void setFrameConfiguration(FrameConfiguration frameConfiguration) {
		this.frameConfiguration = frameConfiguration;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object exec(List list) throws TemplateModelException {
		if (list == null || list.size() < 1) {  
            throw new TemplateModelException("Millis value is null!");  
        }
		Long millis = DPUtil.parseLong(list.get(0));
		String datetimeFormat;
		if(list.size() >= 2) {
			datetimeFormat =  list.get(1).toString();
		} else {
			datetimeFormat =  frameConfiguration.getDateTimeFormat();
		}
		return DPUtil.millisToDateTime(millis, datetimeFormat);
	}

}