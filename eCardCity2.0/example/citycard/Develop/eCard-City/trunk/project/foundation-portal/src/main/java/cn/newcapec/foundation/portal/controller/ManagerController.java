package cn.newcapec.foundation.portal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.newcapec.foundation.privilege.biz.UserService;
import cn.newcapec.framework.core.handler.MultiViewResource;

@Controller
@Scope("prototype")
@RequestMapping("/manager")
@SuppressWarnings("all")
public class ManagerController  extends MultiViewResource {

	@Autowired
	private UserService userService;

	
	/**
	 *test
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index() {
	
		return  "manager/manageIndex";
	}

	
}
