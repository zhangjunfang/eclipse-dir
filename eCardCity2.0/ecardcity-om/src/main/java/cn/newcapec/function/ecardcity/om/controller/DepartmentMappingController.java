/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.newcapec.framework.core.exception.asserts.AssertObject;
import cn.newcapec.framework.core.handler.MultiViewResource;
import cn.newcapec.framework.core.rest.Msg;
import cn.newcapec.framework.core.utils.pagesUtils.PageContext;
import cn.newcapec.function.ecardcity.om.biz.DepartmentMappingService;
import cn.newcapec.function.ecardcity.om.biz.DepartmentService;
import cn.newcapec.function.ecardcity.om.model.DepartmentMapping;
import cn.newcapec.function.ecardcity.om.rest.PlatformUsersData;

/**
 * @author wj
 * @category 部门映射操作Controller
 * @version 1.0
 * @date 2014年3月26日 上午12:03:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/departmentMapping")
public class DepartmentMappingController extends MultiViewResource {
    @Autowired
    private DepartmentMappingService departmentMappingService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private  HttpServletRequest request;
    
    /**
     * 部门映射入口
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "editDepMappingUI")
    public ModelAndView editDepMappingUI(ModelMap modelMap) {
	//获取全部部门
	PageContext.setPagesize(Integer.MAX_VALUE);
	List<Map<String, Object>> depList = departmentService.getListByFatherIncludeChildren("0");
	modelMap.put("depList", depList);
	
	//获取全部人员
	modelMap.put("userJson", PlatformUsersData.getAllUsers());
	return  toView(getUrl("dep.editDepMappingUI"), modelMap);
    }
    
    /**
     * 保存
     * @return	Msg
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Msg save() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		String depId=getJsonObject().getString("dept");
		String[] selUsers=getJsonObject().getString("selUsers").split(",");
		//删除全部
		departmentMappingService.deleteByDep(new String[]{depId});
		//重新保存
		DepartmentMapping dp=null;
		JSONObject user=null;
		for(String userId:selUsers){
		    user=PlatformUsersData.getUser(userId);
		    dp=new DepartmentMapping();
		    dp.setDept_id(depId);
		    dp.setUser_id(userId);
		    dp.setLogin_name(user.getString("login_name"));
		    dp.setUser_name(user.getString("user_name"));
		    departmentMappingService.saveOrUpdate(dp);
		}
		msg.setMsg("保存成功！");
	    }
	});
    }

    /**
     * ajax获取部门人员列表
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetDepUser",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetDepUser() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		PageContext.setPagesize(Integer.MAX_VALUE);
		List<Map<String, Object>> list = departmentMappingService.getListByDep(getJsonObject().getString("depId"));
		msg.setData(JSONArray.fromObject(list).toString());
	    }
	});
    }
    
}
