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

import net.sf.json.JSONArray;

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
import cn.newcapec.function.ecardcity.om.biz.BaseEmployeeService;
import cn.newcapec.function.ecardcity.om.biz.CardTypeService;
import cn.newcapec.function.ecardcity.om.biz.NetSiteBankService;
import cn.newcapec.function.ecardcity.om.biz.NetSiteService;
import cn.newcapec.function.ecardcity.om.model.BaseEmployee;
import cn.newcapec.function.ecardcity.om.model.CardType;
import cn.newcapec.function.ecardcity.om.rest.PlatformUsersData;
import cn.newcapec.function.ecardcity.om.utils.Constant;
import cn.newcapec.function.ecardcity.om.utils.DictionaryUtil;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 操作员管理Controller
 * @version 1.0
 * @date 2014年5月12日 下午3:00:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/employee")
@SuppressWarnings("all")
public class BaseEmployeeController extends MultiViewResource {
    @Autowired
    private BaseEmployeeService objService;
    @Autowired
    private NetSiteService netSiteService;
    @Autowired
    private NetSiteBankService netSiteBankService;
    @Autowired
    private CardTypeService cardTypeService;
    
    /**
     * 操作员列表
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listEmployee")
    public ModelAndView listEmployee(ModelMap modelMap) {
	//网点列表
	modelMap.put("netsiteList", getNetSiteList());
	return toView(getUrl("netsite.employee.list"), modelMap);
    }

    /**
     * 操作员列表数据
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listEmployeeData")
    public ModelAndView listEmployeeData(ModelMap modelMap) {
	Page page = objService.getPage(getJsonObject());
	PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
	pageView.setQueryResult(page);
	pageView.setJsMethod("reloadList");
	modelMap.put("pageView", pageView);
	modelMap.put("userList", PlatformUsersData.getAllUsers());
	return toView(getUrl("netsite.employee.list.data"), modelMap);
    }
    
    /**
     * 添加操作员信息
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "addEmployee")
    public ModelAndView addEmployee(ModelMap modelMap) {
	BaseEmployee obj = new BaseEmployee();
	//默认非对公账号
	obj.setPrivilege_cashin("1");
	obj.setPrivilege_cashout("1");
	obj.setPrivilege_login("1");
	obj.setPrivilege_pos("1");
	obj.setVer(0);
	modelMap.put("obj", obj);
	//网点列表
	modelMap.put("netsiteList", getNetSiteList());
	//用户列表, 需要更改为从接口中获取
	//modelMap.put("userList", objService.getUsersFliterEployee(PlatformUsersData.getAllUsers()));
	modelMap.put("userList", PlatformUsersData.getAllUsers());
	//卡类型列表，只取普通卡
	modelMap.put("typeList",cardTypeService.getListByGroup(Constant.DIC_CARD_BIG_TYPE_COMMON));
	return toView(getUrl("netsite.employee.edit"), modelMap);
    }

    /**
     * 修改操作员信息
     * @return	String
     */
    @RequestMapping(value = "updateEmployee")
    public ModelAndView updateEmployee(ModelMap modelMap) {
	Assert.isTrue(null != getJsonObject(),"传入参数失败！");
	BaseEmployee obj = objService.get(getJsonObject().getString("id"));
	modelMap.put("obj", obj);
	//网点列表
	modelMap.put("netsiteList", getNetSiteList());
	//用户列表, 需要更改为从接口中获取
	//modelMap.put("userList", objService.getUsersFliterEployee(PlatformUsersData.getAllUsers()));
	modelMap.put("userList", PlatformUsersData.getAllUsers());
	//卡类型列表，只取普通卡
	modelMap.put("typeList",cardTypeService.getListByGroup(Constant.DIC_CARD_BIG_TYPE_COMMON));	
	return  toView(getUrl("netsite.employee.edit"), modelMap);
    }
    
    /**
     * 保存
     * @return	Msg
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Msg save(final HttpServletRequest request) {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(null != getJsonObject(), "参数传入失败！");
		Assert.isTrue(null != request.getParameterValues("bank_id"),"请选择绑定银行！");
		Assert.isTrue(null != request.getParameterValues("sale_cardtype") && request.getParameterValues("sale_cardtype").length > 0,"请选择职员允许销售卡类型！");
		Assert.isTrue(null != request.getParameterValues("cash_cardtype") && request.getParameterValues("cash_cardtype").length > 0,"请选择职员允许充值卡类型！");
		BaseEmployee obj = JSONTools.JSONToBean(getJsonObject(), BaseEmployee.class);
		
		//该网点下的该银行账号是否被使用
		KeyValue[] arr = new KeyValue[3];
		arr[0]=new KeyValue("id", obj.getId(), KeyValue.RELATION_NE);
		arr[1]=new KeyValue("bank_id", obj.getBank_id());
		arr[2]=new KeyValue("status", Constant.RECORD_DEL_NOT);
		
		Assert.isTrue(!objService.isExists(arr),"绑定的该银行账号已被分配给其他操作员！");
		
		//该操作员是否已存在
		arr[1]=new KeyValue("user_id", obj.getUser_id());
		arr[2]=new KeyValue("status", Constant.RECORD_DEL_NOT);
		Assert.isTrue(!objService.isExists(arr),"该操作员已存在！");
		
		String[] saleCardtypeArr=request.getParameterValues("sale_cardtype");
		String[] cashCardtypeArr=request.getParameterValues("cash_cardtype");
		String saleCardtype="",cashCardtype="";
		//可销售卡类型
		for(String cardType:saleCardtypeArr){
		    saleCardtype+=cardType+",";
		}
		saleCardtype=saleCardtype.substring(0, saleCardtype.length()-1);
		obj.setSale_cardtype(saleCardtype);
		
		//可充值卡类型
		for(String cardType:cashCardtypeArr){
		    cashCardtype+=cardType+",";
		}
		cashCardtype=cashCardtype.substring(0, cashCardtype.length()-1);
		obj.setCash_cardtype(cashCardtype);
		
		//生成职员ID
		if(StringUtils.isBlank(getJsonObject().getString("empid"))){
			int empId=objService.getMaxEmpID();
			obj.setEmpid(empId+1);
		}

		//保存
		obj.setStatus(Constant.RECORD_DEL_NOT);
		obj.setVer(obj.getVer()+1);
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

    /**
     * ajax网点账号列表
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetNetsiteBankList",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetNetsiteBankList() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(StringUtils.isNotBlank(getJsonObject().getString("netsite_id")), "请先选择网点！");
		String netSiteId=getJsonObject().getString("netsite_id");
		msg.setData(JSONArray.fromObject(netSiteBankService.getListByNetSiteID(netSiteId)).toString());
	    }
	});
    }
}
