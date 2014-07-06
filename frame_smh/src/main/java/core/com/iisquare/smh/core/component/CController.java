package com.iisquare.smh.core.component;

import java.util.HashMap;
import java.util.Map;

import com.iisquare.smh.frame.springmvc.ControllerBase;

public class CController extends ControllerBase {
	/**
	 * 返回JSON信息，可根据需要拓展XML等格式
	 * @param status 状态码，根据内部规范自定义
	 * 		小于0 - 正常返回的具体状态码
	 * 		等于0 - 返回正常
	 * 		大于0 - 错误码
	 * @param message 详细信息或数据
	 * @return
	 * @throws Exception
	 */
	public String displayMessage(int status, Object message) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("status", status);
		map.put("message", message);
		return displayJSON(map);
	}
}
