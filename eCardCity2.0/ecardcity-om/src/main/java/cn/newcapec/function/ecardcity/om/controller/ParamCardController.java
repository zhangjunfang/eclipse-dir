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
import cn.newcapec.function.ecardcity.om.biz.CardTypeService;
import cn.newcapec.function.ecardcity.om.biz.ParamService;
import cn.newcapec.function.ecardcity.om.model.CardType;
import cn.newcapec.function.ecardcity.om.model.Dict;
import cn.newcapec.function.ecardcity.om.model.Param;
import cn.newcapec.function.ecardcity.om.utils.Constant;
import cn.newcapec.function.ecardcity.om.utils.DictionaryUtil;
import cn.newcapec.function.ecardcity.om.utils.TreeView;

/**
 * @author wj
 * @category 参数Controller
 * @version 1.0
 * @date 2014年4月03日 上午11:23:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/paramCard")
@SuppressWarnings("all")
public class ParamCardController extends MultiViewResource {
    @Autowired
    protected ParamService paramService;
    @Autowired
    protected DictionaryUtil dictionaryUtil;
    @Autowired
    private CardTypeService cardTypeService;
    
    /**
     * 参数列表
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listParam")
    public ModelAndView listParam(ModelMap modelMap) {
	//卡类型父级ID
	String cardtype="";
	if(getJsonObject()!=null&&getJsonObject().has("cardtype")&&StringUtils.isNotBlank(getJsonObject().getString("cardtype"))){
	    cardtype=getJsonObject().getString("cardtype").trim();
	}
	modelMap.put("cardtype", cardtype);	
	return  toView(getUrl("param.card.list"), modelMap);
    }
    
    /**
     * 模板列表数据
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listParamUIData")
    public ModelAndView listParamUIData(ModelMap modelMap) {
	if(getJsonObject()!=null&&getJsonObject().has("cardtype")&&StringUtils.isNotBlank(getJsonObject().getString("cardtype"))){
        	Page page = paramService.getCardPageList(getJsonObject());
        	PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
        	pageView.setQueryResult(page);
        	pageView.setJsMethod("reloadList");
        	modelMap.put("pageView", pageView);
	}
	return  toView(getUrl("param.card.list.data"), modelMap);
    }

    /**
     * 卡类型列表
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listCard")
    public ModelAndView listCard(ModelMap modelMap) {
	//卡类型父级ID
	String pid="";
	if(getJsonObject()!=null&&getJsonObject().has("pid")&&StringUtils.isNotBlank(getJsonObject().getString("pid"))){
	    pid=getJsonObject().getString("pid").trim();
	}
	modelMap.put("pid", pid);
	return  toView(getUrl("param.card.list.type"), modelMap);
    }
    
    /**
     * 卡类型列表数据
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listCardUIData")
    public ModelAndView listCardUIData(ModelMap modelMap) {
	Page page = cardTypeService.getPageList(getJsonObject());
	PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
	pageView.setQueryResult(page);
	pageView.setJsMethod("reloadListCard");
	modelMap.put("pageView", pageView);
	modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_CARD_BIG_TYPE));//获取字典
	return  toView(getUrl("param.card.list.type.data"), modelMap);
    }
    
    /**
     * 添加卡类型
     * @return	String
     */
    @RequestMapping(value = "addCardUI")
    public ModelAndView addCardUI(ModelMap modelMap) {
	CardType obj=new CardType();
	obj.setVer(0);
	obj.setSort_num(0);
	obj.setGroupid(getJsonObject().getString("pid"));
	modelMap.put("obj", obj);
	modelMap.put("paramLibList", dictionaryUtil.getDictMap().get(Constant.DIC_LIB_PARAM_TYPE));//获取字典
	modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_CARD_BIG_TYPE));//获取字典
	return  toView(getUrl("param.card.type.edit"), modelMap);
    }
    
    /**
     * 修改卡类型
     * @return	String
     */
    @RequestMapping(value = "updateCardUI")
    public ModelAndView updateCardUI(ModelMap modelMap) {
	Assert.isTrue(null != getJsonObject(),"传入参数失败！");
	CardType obj = cardTypeService.get(getJsonObject().getString("id"));
	modelMap.put("obj", obj);
	modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_CARD_BIG_TYPE));//获取字典
	return toView(getUrl("param.card.type.edit"), modelMap);
    }
    
    /**
     * 删除卡类型
     * @return	Msg
     */
    @RequestMapping(value = "delCard", method = RequestMethod.POST)
    @ResponseBody
    public Msg delCard(final HttpServletRequest request) {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		// 判断参数是否为空
		Assert.isTrue(null != getJsonObject(), "删除失败！");
		String[] ids=request.getParameterValues("id");
		cardTypeService.delete(ids);
		msg.setMsg("删除成功！");
	    }
	});
    }
    
    /**
     * 保存卡类型
     * @return	Msg
     */
    @RequestMapping(value = "saveCard", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveCard() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(null != getJsonObject(),"传入参数失败！");
		//卡类型对象保存
		CardType obj = JSONTools.JSONToBean(getJsonObject(), CardType.class);
		obj.setVer(obj.getVer()+1);
		cardTypeService.saveOrUpdate(obj);
		
		//卡类型参数复制
		if(getJsonObject()!=null&&getJsonObject().has("paraFrom")){
		    String paraFrom = getJsonObject().getString("paraFrom");
		    if (paraFrom.equals("1")) {// 从模板复制
			paramService.cardParamsInit(obj.getId(), paraFrom, getJsonObject().getString("lib_group"));
		    } else if (paraFrom.equals("2")) {// 从已有卡类型列表复制
			paramService.cardParamsInit(obj.getId(), paraFrom, getJsonObject().getString("cardFrom"));
		    }
		}
		
		msg.setMsg("保存成功！");
	    }
	});
    }
    
    /**
     * 修改卡参数
     * @return	String
     */
    @RequestMapping(value = "updateParamUI")
    public ModelAndView updateParamUI(ModelMap modelMap) {
	Assert.isTrue(null != getJsonObject(),"传入参数失败！");
	Param obj = paramService.get(getJsonObject().getString("id"));
	//允许修改
	if(obj.getAllow_edit().equals(Constant.STATE_VALID)){
	    modelMap.put("obj", obj);
	    return  toView(getUrl("param.card.edit"), modelMap);
	}else{
	    return this.listParam(modelMap);
	}	
    }
    
    /**
     * 保存卡参数
     * @return	Msg
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Msg save() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(null != getJsonObject(),"传入参数失败！");
		Param obj = paramService.get(getJsonObject().getString("id"));
		obj.setP_value(getJsonObject().getString("p_value"));
		obj.setVer(obj.getVer()+1);
		paramService.saveOrUpdate(obj);
		msg.setMsg("保存成功！");
	    }
	});
    }
    
    /**
     * ajax根据卡类别，获取卡类型列表
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetTypeList",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetTypeList() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		PageContext.setPagesize(Integer.MAX_VALUE);
		List list = cardTypeService.getListByGroup(getJsonObject().getString("groupid"));
		msg.setData(JSONArray.fromObject(list).toString());
	    }
	});
    }
    
    /**
     * ajax获取卡类型列表
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetCardTree",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetCardTree() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		List list=new ArrayList();
		//根
		TreeView tree=new TreeView();
		tree.setId("-1");
		tree.setpId(null);
		tree.setName("卡类别");
		tree.setOpen(true);
		tree.setTarget("_self");
		tree.setUrl("listCard");
		list.add(tree);
		//大类别
		List<Dict> dictCategoryList=(List<Dict>)dictionaryUtil.getDictMap().get(Constant.DIC_CARD_BIG_TYPE);
		List<CardType> typeList=null;
		for(Dict dict:dictCategoryList){
		    tree=new TreeView();
		    tree.setId(dict.getD_code());
		    tree.setpId("-1");
		    tree.setName(dict.getD_desc1());
		    tree.setOpen(true);
		    tree.setTarget("_self");
		    tree.setUrl("listCard?pid="+dict.getD_code());
		    list.add(tree);
		    //小类别
		    typeList=(List<CardType>)cardTypeService.getListByGroup(dict.getD_code());
		    for(CardType cardType:typeList){
			    tree=new TreeView();
			    tree.setId(cardType.getId());
			    tree.setpId(cardType.getGroupid());
			    tree.setName(cardType.getCardtypename());
			    tree.setOpen(false);
			    tree.setTarget("_self");
			    tree.setUrl("listParam?cardtype="+cardType.getId());
			    list.add(tree);
		    }
		}
		msg.setData(JSONArray.fromObject(list).toString());
	    }
	});
    }
    
    /**
     * ajax卡类型是否存在
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetCardTypeExists",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetCardTypeExists() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Map<String, Object> attrMap=new HashMap<String, Object>();
		if(getJsonObject().getString("attrName").equals("typeid")){
		    attrMap.put("typeid", getJsonObject().getLong("attrValue"));
		}else{
		    attrMap.put(getJsonObject().getString("attrName"), getJsonObject().getString("attrValue"));
		}
		msg.setData(cardTypeService.getListByAttr(attrMap).size()>0);
	    }
	});
    }    
}
