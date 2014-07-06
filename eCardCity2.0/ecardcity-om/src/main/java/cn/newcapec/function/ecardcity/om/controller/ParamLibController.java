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
import cn.newcapec.function.ecardcity.om.biz.ParamLibService;
import cn.newcapec.function.ecardcity.om.model.Department;
import cn.newcapec.function.ecardcity.om.model.DepartmentMapping;
import cn.newcapec.function.ecardcity.om.model.ParamLib;
import cn.newcapec.function.ecardcity.om.utils.Constant;
import cn.newcapec.function.ecardcity.om.utils.DictionaryUtil;

/**
 * @author wj
 * @category 参数模板Controller
 * @version 1.0
 * @date 2014年4月01日 上午10:03:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/paramLib")
@SuppressWarnings("all")
public class ParamLibController extends MultiViewResource {
    @Autowired
    private ParamLibService pLibService;
    @Autowired
    private DictionaryUtil dictionaryUtil;
    
    /**
     * 模板列表
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listParamLib")
    public ModelAndView listParamLib(ModelMap modelMap) {
	modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_LIB_PARAM_TYPE));//获取字典
	return  toView(getUrl("param.lib.list"), modelMap);
    }
    
    /**
     * 模板列表数据
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listParamLibUIData")
    public ModelAndView listParamLibUIData(ModelMap modelMap) {
	Page page = pLibService.getPageList(getJsonObject());
	PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
	pageView.setQueryResult(page);
	pageView.setJsMethod("reloadList");
	modelMap.put("pageView", pageView);	
	modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_LIB_PARAM_TYPE));//获取字典
	return  toView(getUrl("param.lib.list.data"), modelMap);
    }

    /**
     * 添加
     * @return	String
     */
    @RequestMapping(value = "addParamLibUI")
    public ModelAndView addParamLibUI(ModelMap modelMap) {
	ParamLib obj=new ParamLib();
	obj.setVer(0);
	obj.setSort_num(0);
	obj.setP_lib_group("2");
	obj.setAllow_edit(Constant.STATE_VALID);
	obj.setAllow_visible(Constant.STATE_VALID);
	modelMap.put("obj", obj);
	modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_LIB_PARAM_TYPE));//获取字典
	return  toView(getUrl("param.lib.edit"), modelMap);
    }
    
    /**
     * 修改
     * @return	String
     */
    @RequestMapping(value = "updateParamLibUI")
    public ModelAndView updateParamLibUI(ModelMap modelMap) {
	Assert.isTrue(null != getJsonObject(),"传入参数失败！");
	ParamLib obj = pLibService.get(getJsonObject().getString("id"));
	//允许修改
	if(obj.getAllow_edit().equals(Constant.STATE_VALID)){
	    modelMap.put("obj", obj);
	    modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_LIB_PARAM_TYPE));//获取字典
	    return  toView(getUrl("param.lib.edit"), modelMap);
	}else{
	    return this.listParamLib(modelMap);
	}
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
		ParamLib obj = JSONTools.JSONToBean(getJsonObject(), ParamLib.class);
		obj.setVer(obj.getVer()+1);
		pLibService.saveOrUpdate(obj);
		msg.setMsg("保存成功！");
	    }
	});
    }    
}
