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

import cn.newcapec.framework.core.exception.asserts.Assert;
import cn.newcapec.framework.core.exception.asserts.AssertObject;
import cn.newcapec.framework.core.handler.MultiViewResource;
import cn.newcapec.framework.core.rest.Msg;
import cn.newcapec.framework.core.utils.jsonUtils.JSONTools;
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.framework.core.utils.pagesUtils.PageContext;
import cn.newcapec.framework.core.utils.pagesUtils.PageView;
import cn.newcapec.function.ecardcity.om.biz.ParamService;
import cn.newcapec.function.ecardcity.om.model.Department;
import cn.newcapec.function.ecardcity.om.model.DepartmentMapping;
import cn.newcapec.function.ecardcity.om.model.Param;
import cn.newcapec.function.ecardcity.om.utils.Constant;
import cn.newcapec.function.ecardcity.om.utils.DictionaryUtil;

/**
 * @author wj
 * @category 系统参数Controller
 * @version 1.0
 * @date 2014年4月03日 上午11:23:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/paramSys")
@SuppressWarnings("all")
public class ParamSysController extends MultiViewResource {
    @Autowired
    protected ParamService paramService;
    @Autowired
    protected DictionaryUtil dictionaryUtil;
    
    /**
     * 模板列表
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listParam")
    public ModelAndView listParam(ModelMap modelMap) {
	modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_SYS_PARAM_TYPE));//获取字典
	return  toView(getUrl("param.sys.list"), modelMap);
    }
    
    /**
     * 模板列表数据
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listParamUIData")
    public ModelAndView listParamUIData(ModelMap modelMap) {
	Page page = paramService.getSysPageList(getJsonObject());
	PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
	pageView.setQueryResult(page);
	pageView.setJsMethod("reloadList");
	modelMap.put("pageView", pageView);	
	modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_SYS_PARAM_TYPE));//获取字典
	return  toView(getUrl("param.sys.list.data"), modelMap);
    }

    /**
     * 修改
     * @return	String
     */
    @RequestMapping(value = "updateParamUI")
    public ModelAndView updateParamUI(ModelMap modelMap) {
	Assert.isTrue(null != getJsonObject(),"传入参数失败！");
	Param obj = paramService.get(getJsonObject().getString("id"));
	//允许修改
	if(obj.getAllow_edit().equals(Constant.STATE_VALID)){
	    modelMap.put("obj", obj);
	    modelMap.put("dictList", dictionaryUtil.getDictMap().get(Constant.DIC_SYS_PARAM_TYPE));//获取字典
	    return  toView(getUrl("param.sys.edit"), modelMap);
	}else{
	    return this.listParam(modelMap);
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
		Assert.isTrue(null != getJsonObject(),"传入参数失败！");
		Param obj = paramService.get(getJsonObject().getString("id"));
		obj.setP_value(getJsonObject().getString("p_value"));
		obj.setVer(obj.getVer()+1);
		paramService.saveOrUpdate(obj);
		msg.setMsg("保存成功！");
	    }
	});
    }    
}
