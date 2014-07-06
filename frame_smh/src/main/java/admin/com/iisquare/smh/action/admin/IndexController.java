package com.iisquare.smh.action.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iisquare.smh.core.component.CController;
import com.iisquare.smh.service.admin.TestService;

/**
 * 后台首页
 * @author Ouyang <iisquare@163.com>
 *
 */
@Controller
@Scope("prototype")
public class IndexController extends CController {
	
	@Autowired
	TestService testService;
	@Autowired
	com.iisquare.smh.service.index.TestService indexService;
	
	@RequestMapping(value="/admin")
	public String indexAction() throws Exception {
		return displayTemplate();
	}
	
	/* 多模块协作示例 */
	public String conflictAction() throws Exception {
		assign("testService", testService.conflict());
		assign("indexService", indexService.conflict());
		return displayJSON();
	}
}
