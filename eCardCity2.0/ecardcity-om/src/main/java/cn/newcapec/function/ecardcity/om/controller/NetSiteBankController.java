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
import java.util.List;
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
import cn.newcapec.function.ecardcity.om.biz.NetSiteBankService;
import cn.newcapec.function.ecardcity.om.biz.NetSiteService;
import cn.newcapec.function.ecardcity.om.model.NetSiteBank;
import cn.newcapec.function.ecardcity.om.utils.Constant;
import cn.newcapec.function.ecardcity.om.utils.DictionaryUtil;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 网点账号管理Controller
 * @version 1.0
 * @date 2014年5月12日 下午3:00:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/netsiteBank")
@SuppressWarnings("all")
public class NetSiteBankController extends MultiViewResource {
    @Autowired
    private NetSiteBankService objService;
    @Autowired
    private NetSiteService netSiteService;
    @Autowired
    protected DictionaryUtil dictionaryUtil;
    /**
     * 网点账号列表
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listNetsiteBank")
    public ModelAndView listNetsite(ModelMap modelMap) {
	//网点列表
	modelMap.put("netsiteList", getNetSiteList());
	//银行列表
	modelMap.put("bankList", dictionaryUtil.getDictMap().get(Constant.DIC_BANK));
	return toView(getUrl("netsite.bank.list"), modelMap);
    }

    /**
     * 网点列表数据
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listNetsiteBankData")
    public ModelAndView listNetsiteData(ModelMap modelMap) {
	Page page = objService.getPage(getJsonObject());
	PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
	pageView.setQueryResult(page);
	pageView.setJsMethod("reloadList");
	modelMap.put("pageView", pageView);
	return toView(getUrl("netsite.bank.list.data"), modelMap);
    }
    
    /**
     * 添加网点账号信息
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "addNetsiteBank")
    public ModelAndView addNetsiteBank(ModelMap modelMap) {
	NetSiteBank obj = new NetSiteBank();
	//默认非对公账号
	obj.setPublic_account(Constant.NETSITE_BANK_PUBLIC_ACCOUNT_NOT);
	modelMap.put("obj", obj);
	//网点列表
	modelMap.put("netsiteList", getNetSiteList());
	//银行列表
	modelMap.put("bankList", dictionaryUtil.getDictMap().get(Constant.DIC_BANK));
	return toView(getUrl("netsite.bank.edit"), modelMap);
    }

    /**
     * 修改网点账号信息
     * @return	String
     */
    @RequestMapping(value = "updateNetsiteBank")
    public ModelAndView updateNetsiteBank(ModelMap modelMap) {
	Assert.isTrue(null != getJsonObject(),"传入参数失败！");
	NetSiteBank obj = objService.get(getJsonObject().getString("id"));
	modelMap.put("obj", obj);
	//网点列表
	modelMap.put("netsiteList", getNetSiteList());
	//银行列表
	modelMap.put("bankList", dictionaryUtil.getDictMap().get(Constant.DIC_BANK));
	return  toView(getUrl("netsite.bank.edit"), modelMap);
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
		NetSiteBank obj = JSONTools.JSONToBean(getJsonObject(), NetSiteBank.class);
		//开户账号是否重复
		KeyValue[] arr = new KeyValue[2];
		arr[0]=new KeyValue("id", obj.getId(), KeyValue.RELATION_NE);
		arr[1]=new KeyValue("open_account", obj.getOpen_account());
		Assert.isTrue(!objService.isExists(arr),"该开户账号已存在！");
		//转账账号是否重复
		if(StringUtils.isNotBlank(obj.getTransfer_account())){
		    arr[1]=new KeyValue("transfer_account", obj.getTransfer_account());
		    Assert.isTrue(!objService.isExists(arr),"该转账账号已存在！");
		}
		//保存
		//TODO 需要更改为从session中获取
		obj.setEdit_person("admin");
		obj.setEdit_date(new Date());
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
     * 网点列表
     * @return	List
     */
    private List getNetSiteList(){
	Map<String, Object> attrMap=new HashMap<String, Object>();
	attrMap.put("status", Constant.RECORD_DEL_NOT);
	return netSiteService.getList(attrMap);
    }
}
