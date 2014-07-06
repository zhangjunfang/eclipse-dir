package com.iisquare.smh.action.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisquare.smh.core.component.CController;
import com.iisquare.smh.service.index.TestService;

/**
 * 另一个测试
 * @author Ouyang <iisquare@163.com>
 *
 */
@Controller
@Scope("prototype")
public class TestController extends CController {
	@Autowired
	TestService testService;
	
	/* 主模块资源调用示例 */
	public String conflictAction() throws Exception {
		assign("testService", testService.conflict());
		return displayJSON();
	}
}
