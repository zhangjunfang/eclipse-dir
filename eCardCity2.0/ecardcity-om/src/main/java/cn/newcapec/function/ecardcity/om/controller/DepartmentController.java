/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.runtime.parser.node.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.newcapec.framework.core.exception.asserts.Assert;
import cn.newcapec.framework.core.exception.asserts.AssertObject;
import cn.newcapec.framework.core.handler.MultiViewResource;
import cn.newcapec.framework.core.rest.Msg;
import cn.newcapec.framework.core.utils.jsonUtils.JSONTools;
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.framework.core.utils.pagesUtils.PageContext;
import cn.newcapec.framework.core.utils.pagesUtils.PageView;
import cn.newcapec.function.ecardcity.om.biz.DepartmentService;
import cn.newcapec.function.ecardcity.om.model.Department;
import cn.newcapec.function.ecardcity.om.utils.Constant;

/**
 * @author wj
 * @category 部门操作Controller
 * @version 1.0
 * @date 2014年3月19日 上午11:46:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/department")
@SuppressWarnings("all")
public class DepartmentController extends MultiViewResource {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private  HttpServletRequest request;
    
    /**
     * 获取父级ID参数
     * @return	String
     */
    private String genContextPid() {
	if(getJsonObject()!=null&&getJsonObject().has("parentid")&&StringUtils.isNotBlank(getJsonObject().getString("parentid"))){
	    return getJsonObject().getString("parentid").trim();
	}
	
	return "0";
    }

    /**
     * 部门页面列表视图
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listDepUI")
    public ModelAndView listDepUI(ModelMap modelMap) {
	// 部门树
	PageContext.setPagesize(Integer.MAX_VALUE);
	List list = departmentService.getListByFatherIncludeChildren("0");
	modelMap.put("list", list);
	modelMap.put("parentid", genContextPid());
	return  toView(getUrl("dep.listDepUI"), modelMap);
    }

    
    /**
     * 部门页面列表视图
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listDepUIData")
    public ModelAndView listDepUIData(ModelMap modelMap) {
	String id = genContextPid();
	Page page = departmentService.getPageByFatherIncludeChildren(id);
	PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
	pageView.setQueryResult(page);
	pageView.setJsMethod("reloadListDep");
	modelMap.put("pageView", pageView);
	modelMap.put("parentid", id);
	return  toView(getUrl("dep.listDepUIData"), modelMap);
    }

    /**
     * 添加
     * @return	String
     */
    @RequestMapping(value = "addDepUI")
    public ModelAndView addDepUI(ModelMap modelMap) {
	Department dep = new Department();
	dep.setValid(Constant.STATE_VALID);
	dep.setVer(0);
	modelMap.put("dep", dep);
	modelMap.put("parentid", genContextPid());
	return toView(getUrl("dep.editDepUI"), modelMap);
    }
    
    /**
     * 修改
     * @return	String
     */
    @RequestMapping(value = "updateDepUI")
    public ModelAndView updateDepUI(ModelMap modelMap) {
	Assert.isTrue(null != getJsonObject(),"传入参数失败！");
	Department dep = departmentService.get(getJsonObject().getString("id"));
	modelMap.put("dep", dep);
	modelMap.put("parentid", genContextPid());
	return  toView(getUrl("dep.editDepUI"), modelMap);
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
		Department dep = JSONTools.JSONToBean(getJsonObject(), Department.class);
		dep.setVer(dep.getVer()+1);
		departmentService.saveOrUpdate(dep);
		msg.setMsg("保存成功！");
	    }
	});
    }
    
    /**
     * 删除
     * @return	Msg
     */
    @RequestMapping(value = "del", method = RequestMethod.POST)
    @ResponseBody
    public Msg del() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		// 判断参数是否为空
		Assert.isTrue(null != getJsonObject(), "删除失败！");
		String[] ids=request.getParameterValues("id");
		departmentService.delete(ids);
		msg.setMsg("删除成功！");
	    }
	});
    }
    
    /**
     * ajax部门列表
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetDepList",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetDepList() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		PageContext.setPagesize(Integer.MAX_VALUE);
		List list = departmentService.getListByFatherExcludeChildren(getJsonObject().getString("pid"));
		msg.setData(JSONArray.fromObject(list).toString());
	    }
	});
    }
    
    /**
     * ajax部门是否存在
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetDepIsExists",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetDepIsExists() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Map<String, Object> attrMap=new HashMap<String, Object>();
		attrMap.put(getJsonObject().getString("attrName"), getJsonObject().getString("attrValue"));
		msg.setData(departmentService.getListByAttr(attrMap).size()>0);
	    }
	});
    }
}
