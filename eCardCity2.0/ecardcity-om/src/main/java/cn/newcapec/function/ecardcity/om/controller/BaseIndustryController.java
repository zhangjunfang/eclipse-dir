/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
import cn.newcapec.function.ecardcity.om.biz.BaseIndustryService;
import cn.newcapec.function.ecardcity.om.model.BaseIndustry;
import cn.newcapec.function.ecardcity.om.model.ParamLib;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 基础行业信息管理Controller
 * @version 1.0
 * @date 2014年5月5日 下午2:31:05
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/industry")
@SuppressWarnings("all")
public class BaseIndustryController extends MultiViewResource {
    @Autowired
    private BaseIndustryService objService;

    /**
     * 行业列表
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listIndustry")
    public ModelAndView listIndustry(ModelMap modelMap) {
	return toView(getUrl("industry.list"), modelMap);
    }

    /**
     * 行业列表数据
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listIndustryData")
    public ModelAndView listIndustryData(ModelMap modelMap) {
	Page page = objService.getPageList(getJsonObject());
	PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
	pageView.setQueryResult(page);
	pageView.setJsMethod("reloadList");
	modelMap.put("pageView", pageView);
	return toView(getUrl("industry.list.data"), modelMap);
    }
    
    /**
     * 添加基础行业信息
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "addIndustry")
    public ModelAndView addIndustry(ModelMap modelMap) {
	BaseIndustry obj = new BaseIndustry();
	obj.setIndustrygrade("01");
	obj.setIndustry_p("");
	obj.setReserved("0");
	obj.setIsshow(1);
	modelMap.put("obj", obj);
	//父级行业列表
	modelMap.put("pIndustryList", objService.getListByAttr(null));
	return toView(getUrl("industry.edit"), modelMap);
    }

    /**
     * 修改基础行业信息
     * @return	String
     */
    @RequestMapping(value = "updateIndustry")
    public ModelAndView updateIndustry(ModelMap modelMap) {
	Assert.isTrue(null != getJsonObject(),"传入参数失败！");
	BaseIndustry obj = objService.get(getJsonObject().getString("id"));
	modelMap.put("obj", obj);
	modelMap.put("pIndustryList", objService.getListByAttr(null));
	return  toView(getUrl("industry.edit"), modelMap);
    }
    
    /**
     * 保存基础行业信息
     * @return	Msg
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Msg save() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(null != getJsonObject(), "参数传入失败！");
		//是否允许修改
		boolean allowUpdate=true;
		String id=getJsonObject().getString("id");
		if(id!=null&&StringUtils.isNotBlank(id)){
		    BaseIndustry oldObj = objService.get(getJsonObject().getString("id"));
		    if(oldObj.getReserved().equals("1")){
			allowUpdate=false;
		    }
		}
		Assert.isTrue(allowUpdate,"该行业信息是保留行业，不允许修改！");
		
		//是否重复
		KeyValue[] arr = new KeyValue[2];
		arr[0]=new KeyValue("id", getJsonObject().getString("id"), KeyValue.RELATION_NE);
		arr[1]=new KeyValue("industrycode", getJsonObject().getString("industrycode"));
		Assert.isTrue(!objService.isExists(arr),"该代码的行业已存在！");
		
		arr[1]=new KeyValue("industryname", getJsonObject().getString("industryname"));
		Assert.isTrue(!objService.isExists(arr),"该名称的行业已存在！");		
		//保存
		BaseIndustry obj = JSONTools.JSONToBean(getJsonObject(), BaseIndustry.class);
		obj.setAcccode("20"+obj.getIndustrycode());
		objService.saveOrUpdate(obj);
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
    public Msg del(final HttpServletRequest request) {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		// 判断参数是否为空
		Assert.isTrue(null != getJsonObject(), "删除失败！");
		String[] ids=request.getParameterValues("id");
		objService.delete(ids);
		msg.setMsg("删除成功！");
	    }
	});
    }

    /**
     * ajax行业是否存在
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetIndustryExists",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetIndustryExists() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		KeyValue[] arr={new KeyValue(getJsonObject().getString("attrName"),getJsonObject().getString("attrValue"))};
		msg.setData(objService.isExists(arr));
	    }
	});
    }    
}
