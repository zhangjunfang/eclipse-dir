/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.controller;

import java.util.Date;
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
import cn.newcapec.function.ecardcity.om.biz.NetSiteService;
import cn.newcapec.function.ecardcity.om.model.NetSite;
import cn.newcapec.function.ecardcity.om.utils.Constant;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 网点信息（商户）管理Controller
 * @version 1.0
 * @date 2014年5月8日 上午10:20:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/netsite")
@SuppressWarnings("all")
public class NetSiteController extends MultiViewResource {
    @Autowired
    private NetSiteService objService;
    @Autowired
    private BaseIndustryService industryService;

    /**
     * 网点列表
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listNetsite")
    public ModelAndView listNetsite(ModelMap modelMap) {
	return toView(getUrl("netsite.list"), modelMap);
    }

    /**
     * 网点列表数据
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listNetsiteData")
    public ModelAndView listNetsiteData(ModelMap modelMap) {
	Page page = objService.getPage(getJsonObject());
	PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
	pageView.setQueryResult(page);
	pageView.setJsMethod("reloadList");
	modelMap.put("pageView", pageView);
	return toView(getUrl("netsite.list.data"), modelMap);
    }
    
    /**
     * 添加网点信息
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "addNetsite")
    public ModelAndView addNetsite(ModelMap modelMap) {
	NetSite obj = new NetSite();
	obj.setNetstatus(Constant.STATE_VALID);
	obj.setNettype(Constant.NETSITE_TYPE_RECHARGE);
	obj.setNetid_p("0");
	obj.setNetkind(Constant.NETSITE_KIND_DIRECT);
	obj.setVer(0);
	obj.setSort_num(0);
	modelMap.put("obj", obj);
	//父级网点列表
	Map<String, Object> attrMap=new HashMap<String, Object>();
	attrMap.put("status", Constant.RECORD_DEL_NOT);
	modelMap.put("pNetsiteList", objService.getList(attrMap));
	modelMap.put("pIndustryList", industryService.getListByAttr(null));
	return toView(getUrl("netsite.edit"), modelMap);
    }

    /**
     * 修改网点行业信息
     * @return	String
     */
    @RequestMapping(value = "updateNetsite")
    public ModelAndView updateNetsite(ModelMap modelMap) {
	Assert.isTrue(null != getJsonObject(),"传入参数失败！");
	NetSite obj = objService.get(getJsonObject().getString("id"));
	modelMap.put("obj", obj);
	//父级网点列表
	Map<String, Object> attrMap=new HashMap<String, Object>();
	attrMap.put("status", Constant.RECORD_DEL_NOT);
	modelMap.put("pNetsiteList", objService.getList(attrMap));
	modelMap.put("pIndustryList", industryService.getListByAttr(null));
	return  toView(getUrl("netsite.edit"), modelMap);
    }
    
    /**
     * 保存网点信息
     * @return	Msg
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Msg save() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(null != getJsonObject(), "参数传入失败！");
		//是否重复
		KeyValue[] arr = new KeyValue[2];
		arr[0]=new KeyValue("id", getJsonObject().getString("id"), KeyValue.RELATION_NE);
		arr[1]=new KeyValue("netname", getJsonObject().getString("netname"));
		Assert.isTrue(!objService.isExists(arr),"该网点名称的网点已存在！");
		//保存
		NetSite obj = JSONTools.JSONToBean(getJsonObject(), NetSite.class);
		obj.setVer(obj.getVer()+1);
		obj.setEdit_date(new Date());
		//生成网点ID
		if(StringUtils.isBlank(getJsonObject().getString("netid"))){
    			int netId=objService.getMaxNetSiteID(obj.getInduscode_code());
    			String strNetid=netId==0?obj.getInduscode_code()+"000001":String.valueOf(netId+1);
    			obj.setNetid(strNetid);
		}
		//TODO 需要更改为从session中获取
		obj.setEdit_person("admin");
		obj.setStatus(Constant.RECORD_DEL_NOT);
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
     * ajax站点是否存在
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetNetsiteExists",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetNetsiteExists() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		KeyValue[] arr={new KeyValue(getJsonObject().getString("attrName"),getJsonObject().getString("attrValue"))};
		msg.setData(objService.isExists(arr));
	    }
	});
    }    
}
