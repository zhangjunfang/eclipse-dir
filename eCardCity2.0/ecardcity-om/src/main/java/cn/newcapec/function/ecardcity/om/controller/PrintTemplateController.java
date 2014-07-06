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
import cn.newcapec.function.ecardcity.om.biz.ParamService;
import cn.newcapec.function.ecardcity.om.biz.PrintTemplateService;
import cn.newcapec.function.ecardcity.om.model.PrintTemplate;
import cn.newcapec.function.ecardcity.om.utils.Constant;
import cn.newcapec.function.ecardcity.om.utils.DictionaryUtil;

/**
 * @author wj
 * @category 打印模板Controller
 * @version 1.0
 * @date 2014年4月15日 上午10:11:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/printTemplate")
@SuppressWarnings("all")
public class PrintTemplateController extends MultiViewResource {
    @Autowired
    protected PrintTemplateService objService;
    @Autowired
    protected ParamService paramService;
    @Autowired
    protected DictionaryUtil dictionaryUtil;    
    /**
     * 模板列表
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listTemplate")
    public ModelAndView listTemplate(ModelMap modelMap) {
	modelMap.put("dictList", paramService.getPramListByType(Constant.PARAM_TERM_GENERAL));//获取模板类型字典
	return  toView(getUrl("template.list"), modelMap);
    }
    
    /**
     * 模板列表数据
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listTemplateData")
    public ModelAndView listTemplateData(ModelMap modelMap) {
	if(null != getJsonObject()&&getJsonObject().has("template_name")&&StringUtils.isNotBlank(getJsonObject().getString("template_name"))){
	    Page page = objService.getPage(getJsonObject());
	    PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
	    pageView.setQueryResult(page);
	    pageView.setJsMethod("reloadList");
	    modelMap.put("pageView", pageView);
	    modelMap.put("sysPrintParamList", paramService.getPramListByType(Constant.DIC_SYS_PRINT_PARAM_CODE));//打印相关参数
	}
	return  toView(getUrl("template.list.data"), modelMap);
    }

    /**
     * 添加
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "addTemplate")
    public ModelAndView addTemplate(ModelMap modelMap) {
	modelMap.put("dictList", paramService.getPramListByType(Constant.PARAM_TERM_GENERAL));	     //获取字典
	modelMap.put("sysPrintParamList", paramService.getPramListByType(Constant.DIC_SYS_PRINT_PARAM_CODE));//打印相关参数
	return  toView(getUrl("template.add"), modelMap);
    }
    
    /**
     * 修改
     * @return	String
     */
    @RequestMapping(value = "updateTemplate")
    public ModelAndView updateTemplate(ModelMap modelMap) {
	Assert.isTrue(null != getJsonObject(),"传入参数失败！");
	PageContext.setPagesize(Integer.MAX_VALUE);
	List templateList=objService.getPage(getJsonObject()).getItems();
	modelMap.put("template_type", getJsonObject().getString("template_type"));//获取字典
	modelMap.put("template_name", getJsonObject().getString("template_name"));//获取字典
	modelMap.put("templateList", templateList);
	modelMap.put("dictList", paramService.getPramListByType(Constant.PARAM_TERM_GENERAL));//获取字典
	modelMap.put("sysPrintParamList", paramService.getPramListByType(Constant.DIC_SYS_PRINT_PARAM_CODE));//打印相关参数
	return  toView(getUrl("template.update"), modelMap);
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
		Assert.isTrue(null != request.getParameterValues("line_no") && request.getParameterValues("line_no").length > 0,"至少应添加一个参数，保存失败！");
		String template_type=getJsonObject().getString("template_type");
		String template_name=getJsonObject().getString("template_name").trim();
		//更新保存时，先删除原有模板
		if(getJsonObject().has("old_template_name") && StringUtils.isNotBlank(getJsonObject().getString("old_template_name"))){
		    String old_template_name=getJsonObject().getString("old_template_name");
		    objService.deleteByName(old_template_name);
		}
		//save
		String[] line_no=request.getParameterValues("line_no");
		String[] symbol_1=request.getParameterValues("symbol_1");
		String[] symbol_2=request.getParameterValues("symbol_2");
		String[] symbol_3=request.getParameterValues("symbol_3");
		String[] symbol_4=request.getParameterValues("symbol_4");
		String[] print_param=request.getParameterValues("print_param");
		String[] print_title=request.getParameterValues("print_title");
		PrintTemplate template;
		for(int i=0;i<line_no.length;i++){
		    template=new PrintTemplate();
		    template.setControl_symbol(symbol_1[i]+","+symbol_2[i]+","+symbol_3[i]+","+symbol_4[i]);
		    template.setLine_no(Integer.valueOf(line_no[i]));
		    template.setNetsiteid("");
		    template.setPrint_param(print_param[i]);
		    template.setPrint_title(print_title[i]);
		    template.setTemplate_name(template_name);
		    template.setTemplate_type(template_type);
		    objService.saveOrUpdate(template);
		}
		msg.setData(template_name);
		msg.setMsg("保存成功！");
	    }
	});
    }

    /**
     * ajax根据模板类型，获取模板名称列表（仅仅是系统模板）
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetTemplateList",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetTemplateList() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(null != getJsonObject()&&getJsonObject().has("templateType")&&StringUtils.isNotBlank(getJsonObject().getString("templateType")),"传入参数失败！");
		PageContext.setPagesize(Integer.MAX_VALUE);
		List list = objService.getListByType(getJsonObject().getString("templateType"));
		msg.setData(JSONArray.fromObject(list).toString());
	    }
	});
    }
    
    /**
     * ajax模板名称是否存在
     * @return	Msg
     */
    @RequestMapping(value = "ajaxTemplateCheck",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxTemplateCheck() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Map<String, Object> attrMap=new HashMap<String, Object>();
		attrMap.put(getJsonObject().getString("attrName"), getJsonObject().getString("attrValue"));
		PageContext.setPagesize(Integer.MAX_VALUE);
		msg.setData(objService.getPage(attrMap).getTotal()>0);
	    }
	});
    }
}
