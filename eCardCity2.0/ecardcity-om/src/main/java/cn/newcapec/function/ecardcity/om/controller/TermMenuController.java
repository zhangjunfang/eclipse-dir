/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.commons.lang.ArrayUtils;
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
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.framework.core.utils.pagesUtils.PageContext;
import cn.newcapec.framework.core.utils.pagesUtils.PageView;
import cn.newcapec.function.ecardcity.om.biz.NetSiteService;
import cn.newcapec.function.ecardcity.om.biz.ParamService;
import cn.newcapec.function.ecardcity.om.biz.TermInfoService;
import cn.newcapec.function.ecardcity.om.biz.TermMenuService;
import cn.newcapec.function.ecardcity.om.model.NetSite;
import cn.newcapec.function.ecardcity.om.model.Param;
import cn.newcapec.function.ecardcity.om.model.TermMainMenu;
import cn.newcapec.function.ecardcity.om.model.TermSubMenu;
import cn.newcapec.function.ecardcity.om.utils.Constant;
import cn.newcapec.function.ecardcity.om.utils.DateUtil;
import cn.newcapec.function.ecardcity.om.utils.DictionaryUtil;

/**
 * @author wj
 * @category 终端菜单Controller
 * @version 1.0
 * @date 2014年4月22日 上午15:52:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/termMenu")
@SuppressWarnings("all")
public class TermMenuController extends MultiViewResource {
    @Autowired
    private NetSiteService traderService;
    @Autowired
    private TermInfoService termService;
    @Autowired
    private TermMenuService termMenuService;
    @Autowired
    private DictionaryUtil dictionaryUtil;
    @Autowired
    protected ParamService paramService;    
    /**
     * 菜单列表
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listMenu")
    public ModelAndView listMenu(ModelMap modelMap) {
	modelMap.put("traderList",getTraderList(null));//获取商户列表
	return  toView(getUrl("term.menu.list"), modelMap);
    }

    /**
     * 菜单列表数据
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listMenuData")
    public ModelAndView listMenuData(ModelMap modelMap) {
	Page page = termMenuService.getPageMenu(getJsonObject());
	PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
	pageView.setQueryResult(page);
	pageView.setJsMethod("reloadList");
	modelMap.put("pageView", pageView);
	modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_TERM_TRADE_TYPE));//获取终端交易类型字典
	modelMap.put("permParamList", paramService.getPramListByType(Constant.PARAM_TERM_GENERAL));//获取业务权限类型
	return toView(getUrl("term.menu.list.data"), modelMap);
    }

    /**
     * 添加菜单
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "addMenu")
    public ModelAndView addMenu(ModelMap modelMap) {
	//获取商户类别
	modelMap.put("traderList",getTraderList(null));
	//获取终端交易类型字典
	modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_TERM_TRADE_TYPE));
	return  toView(getUrl("term.menu.add"), modelMap);
    }

    /**
     * 修改
     * @return	String
     */
    @RequestMapping(value = "updateMenu")
    public ModelAndView updateMenu(ModelMap modelMap) {
	Assert.isTrue(null != getJsonObject(),"传入参数失败！");
	PageContext.setPagesize(Integer.MAX_VALUE);
	List menuList=termMenuService.getPageMenu(getJsonObject()).getItems();
	Assert.isTrue(menuList.size()>0,"发生异常错误，当前修改的终端菜单项已被删除！");
	Map obj=(Map)menuList.get(0);
	modelMap.put("main_menu", obj.get("MAIN_MENU"));
	modelMap.put("trader_id", obj.get("SITEID"));
	String traderName=((NetSite)getTraderList(obj.get("SITEID").toString()).get(0)).getNetname();
	modelMap.put("trader_name", traderName);
	modelMap.put("term_id", obj.get("TERMID"));
	modelMap.put("term_name", obj.get("TERMNAME"));
	modelMap.put("param_ver", obj.get("PARAM_VER"));
	modelMap.put("ver_time", obj.get("VER_TIME"));
	
	modelMap.put("menuList", menuList);
	modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_TERM_TRADE_TYPE));//获取终端交易类型字典
	//获取业务权限类型
	List permParamList = generatePermLocList(
		paramService.getPramListByType(Constant.PARAM_TERM_GENERAL),
		obj.get("TERMID").toString(),
		menuList);
	modelMap.put("permParamList", permParamList);
	return  toView(getUrl("term.menu.update"), modelMap);
    }
    
    /**
     * 删除
     * @return	String
     */
    @RequestMapping(value = "delMenu")
    @ResponseBody
    public Msg delMenu(ModelMap modelMap,final HttpServletRequest request) {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(null != getJsonObject()&&null!=request.getParameterValues("mainId"),"传入参数失败！");
		String[] mainIds=request.getParameterValues("mainId");
		termMenuService.delete(mainIds);
		msg.setMsg("删除成功！");
	    }
	});
    }    
    
    /**
     * 保存终端自定义菜单
     * 
     * @return	Msg
     */
    @RequestMapping(value = "saveMenuAdd", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveMenuAdd(final HttpServletRequest request) {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		//校验：是否有子菜单
		Assert.isTrue(null != request.getParameterValues("line_no") && request.getParameterValues("line_no").length > 0,"至少应添加一个子菜单，保存失败！");
		//paramenters
		String termid=getJsonObject().getString("termid");
		String main_menu=getJsonObject().getString("main_menu");
		String param_ver=getJsonObject().getString("param_ver");
		String ver_time=getJsonObject().getString("ver_time");
		String[] line_no=request.getParameterValues("line_no");
		String[] sub_id=request.getParameterValues("sub_id");
		String[] sub_menu=request.getParameterValues("sub_menu");
		String[] main_menu_key=request.getParameterValues("main_menu_key");
		String[] sub_trade_type=request.getParameterValues("sub_trade_type");
		String[] sub_acl_location=request.getParameterValues("sub_acl_location");
		String[] sub_acl_setting=request.getParameterValues("sub_acl_setting");
		//校验：当前的子菜单名称的长度
		Assert.isTrue(isSubMenuValid(sub_menu),"二级菜单数量多余4个时，每个二级菜单名称的长度不能大于4！");
		//校验：二级菜单编号
		Assert.isTrue(!isExistsRepeatElement(sub_id),"二级菜单编号不能重复！");
		//校验：二级菜单编号
		Assert.isTrue(!isExistsRepeatElement(sub_menu),"二级菜单名称不能重复！");
		//校验：当前的二级菜单权限列表位置
		Assert.isTrue(sub_acl_location!=null,"二级菜单占用的权限列表位置不能为空（或没有可用的二级菜单占用的权限列表位置）！");
		Assert.isTrue(!isExistsRepeatElement(sub_acl_location),"二级菜单占用的权限列表位置不能重复！");
		
		//删除已存在的主菜单和子菜单
		termMenuService.deleteByMainMenu(main_menu,termid);
		
		//保存主菜单
		TermMainMenu mainMenu=new TermMainMenu();
		mainMenu.setMain_menu(main_menu);
		mainMenu.setParam_ver(param_ver);
		mainMenu.setTermid(termid);
		mainMenu.setVer_time(DateUtil.parseDate(ver_time, DateUtil.SHORT_DATE_FORMAT));
		for(int i=0;i<line_no.length;i++){
		    switch(i){
		    	case 0:
		    	    mainMenu.setMain_menu_key1(sub_id[i]);
		    	    break;
		    	case 1:
		    	    mainMenu.setMain_menu_key2(sub_id[i]);
		    	    break;
		    	case 2:mainMenu.setMain_menu_key3(sub_id[i]);
		    	    break;
		    	case 3:
		    	    mainMenu.setMain_menu_key4(sub_id[i]);
		    	    break;
		    	case 4:
		    	    mainMenu.setMain_menu_key5(sub_id[i]);
		    	    break;
		    	case 5:
		    	    mainMenu.setMain_menu_key6(sub_id[i]);
		    	    break;
		    	case 6:
		    	    mainMenu.setMain_menu_key7(sub_id[i]);
		    	    break;
		    	case 7:
		    	    mainMenu.setMain_menu_key8(sub_id[i]);
		    	    break;
		    }
		}
		termMenuService.saveOrUpdate(mainMenu);
		
		//保存子菜单
		TermSubMenu subMenu;
		for(int i=0;i<line_no.length;i++){
		    subMenu=new TermSubMenu();
		    subMenu.setMain_id(mainMenu.getId());
		    subMenu.setSub_acl_location(sub_acl_location[i]);
		    subMenu.setSub_acl_setting(sub_acl_setting[i]);
		    subMenu.setSub_id(sub_id[i]);
		    subMenu.setSub_menu(sub_menu[i]);
		    subMenu.setSub_trade_type(sub_trade_type[i]);
		    termMenuService.saveOrUpdateSubMenu(subMenu);
		}
		msg.setMsg("保存成功！");
	    }
	});
    }
    
    /**
     * 判断提交的参数组中是否存在指定的重复元素
     * @param	arrToSearch	需要搜索的元素数组
     * @return  boolean		是否有重复的元素
     */
    private boolean isExistsRepeatElement(String[] arrToSearch) {
	String[] arr=null;
	String ele=null;
	for(int i=0;i<arrToSearch.length;i++){
	    ele=arrToSearch[i];
	    arr=(String[])ArrayUtils.remove(arrToSearch, i);
	    
	    if(arr.length>0&&ArrayUtils.contains(arr, ele)){
		return true;
	    }
	}
	arr=null;
	ele=null;
	return false;
    }
    
    /**
     * 子菜单名称是否符合要求：数量>4,名称长度<4
     * @param	arr	名称数组
     * @return  boolean	是否有不符要求的子菜单名称
     */
    private boolean isSubMenuValid(String[] arr) {
	if(arr.length<5){
	    return true;
	}
	for (String ele : arr) {
	    if (ele.length() > 4) {
		return false;
	    }
	}
	return true;
    }
    
    /**
     * 修改时，根据情况生成可用权限位置列表
     * @param	permLocList	全部权限列表
     * @param	termId		当前终端ID
     * @param	menuList	当前修改项涉及的二级菜单列表
     * @return 	List		可用权限列表
     */
    private List generatePermLocList(List permLocList,String termId,List menuList){
	Param param=null;
	Map map=null;
	String aclLocation=null;
	List rtnList=new ArrayList();
	//获取当前修改终端已用的
	for(int i=0;i<menuList.size();i++){
	    aclLocation=((Map)menuList.get(i)).get("SUB_ACL_LOCATION").toString();
	    for(int j=0;j<permLocList.size();j++){
		param=(Param)permLocList.get(j);
		if(aclLocation.equals(param.getP_value())){
		    map=new HashMap();
		    map.put("P_VALUE", param.getP_value());
		    map.put("TITLE_NAME", param.getTitle_name());
		    rtnList.add(map);
		    break;
		}
	    }
	}	
	//获取该终端可用的权限位置
	PageContext.setPagesize(Integer.MAX_VALUE);
	List currList = termMenuService.getPermLocListByTerm(termId);
	
	//生成最终可用权限MAP列表
	rtnList.addAll(currList);
	return rtnList;
    }
    
    /**
     * 获取商户列表
     * @return List
     */
    private List getTraderList(String id) {
	Map<String, Object> attrMap=new HashMap<String, Object>();
	attrMap.put("netkind", Constant.NETSITE_KIND_AGENT);
	attrMap.put("status", Constant.RECORD_DEL_NOT);
	if(StringUtils.isNotBlank(id)){
	    attrMap.put("id", id);
	}
	return traderService.getList(attrMap);
    }
    
    /**
     * ajax根据终端，获取可用权限位置
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetPermLocList",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetPermLocList() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(null != getJsonObject()&&getJsonObject().has("termid")&&StringUtils.isNotBlank(getJsonObject().getString("termid")),"传入参数失败！");
		String termid=getJsonObject().getString("termid");
		PageContext.setPagesize(Integer.MAX_VALUE);
		//获取该终端可用的权限位置
		List list = termMenuService.getPermLocListByTerm(termid);
		msg.setData(JSONArray.fromObject(list).toString());
	    }
	});
    }
    
    /**
     * ajax根据商户，获取终端列表
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetTermList",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetTermList() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(null != getJsonObject()&&getJsonObject().has("netsiteid")&&StringUtils.isNotBlank(getJsonObject().getString("netsiteid")),"传入参数失败！");
		Map<String, Object> para=new HashMap<String, Object>();
		para.put("isdelete", Constant.RECORD_DEL_NOT);
		para.put("isuse", Constant.RECORD_USED_VALID);
		para.put("siteid", getJsonObject().getString("netsiteid"));
		PageContext.setPagesize(Integer.MAX_VALUE);
		List list = termService.getList(para);
		msg.setData(JSONArray.fromObject(list).toString());
	    }
	});
    }
    
    
    /**
     * ajax主菜单名称是否存在
     * @return	Msg
     */
    @RequestMapping(value = "ajaxMenuCheck",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxMenuCheck() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Map<String, Object> attrMap=new HashMap<String, Object>();
		attrMap.put(getJsonObject().getString("attrName"), getJsonObject().getString("attrValue"));
		attrMap.put("termid", getJsonObject().getString("termid"));
		PageContext.setPagesize(Integer.MAX_VALUE);
		msg.setData(termMenuService.getPageMainMenu(attrMap).getTotal()>0);
	    }
	});
    }
}
