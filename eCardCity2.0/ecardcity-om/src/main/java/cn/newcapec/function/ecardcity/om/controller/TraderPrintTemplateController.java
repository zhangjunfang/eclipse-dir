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
import cn.newcapec.function.ecardcity.om.biz.NetSiteService;
import cn.newcapec.function.ecardcity.om.biz.ParamService;
import cn.newcapec.function.ecardcity.om.biz.PrintTemplateService;
import cn.newcapec.function.ecardcity.om.model.PrintTemplate;
import cn.newcapec.function.ecardcity.om.utils.Constant;
import cn.newcapec.function.ecardcity.om.utils.DictionaryUtil;

/**
 * @author wj
 * @category 商户打印模板Controller
 * @version 1.0
 * @date 2014年4月15日 上午10:11:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/traderPrintTemplate")
@SuppressWarnings("all")
public class TraderPrintTemplateController extends PrintTemplateController {
    @Autowired
    private NetSiteService traderService;
    /**
     * 模板列表
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listTemplate")
    public ModelAndView listTemplate(ModelMap modelMap) {
	modelMap.put("traderList",getTraderList());//获取商户列表
	modelMap.put("dictList", paramService.getPramListByType(Constant.PARAM_TERM_GENERAL));//获取模板类型字典
	return  toView(getUrl("template.trader.list"), modelMap);
    }

    /**
     * 模板列表数据
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "listTemplateData")
    public ModelAndView listTemplateData(ModelMap modelMap) {
	Page page = objService.getTraderPage(getJsonObject());
	PageView<Map<String, Object>> pageView = new PageView<Map<String, Object>>(PageContext.getPagesize(), PageContext.getOffset());
	pageView.setQueryResult(page);
	pageView.setJsMethod("reloadList");
	modelMap.put("pageView", pageView);
	modelMap.put("traderList", getTraderList());// 获取商户列表
	modelMap.put("dictList", paramService.getPramListByType(Constant.PARAM_TERM_GENERAL));//获取模板类型字典
	return toView(getUrl("template.trader.list.data"), modelMap);
    }

    /**
     * 添加
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "addTemplate")
    public ModelAndView addTemplate(ModelMap modelMap) {
	modelMap.put("traderList",getTraderList());							     //获取商户列表
	modelMap.put("dictList", paramService.getPramListByType(Constant.PARAM_TERM_GENERAL));	     //获取模板类型字典
	return  toView(getUrl("template.trader.add"), modelMap);
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
	Assert.isTrue(templateList.size()>0,"发生异常错误，当前修改的模板已被删除！");
	Map obj=(Map)templateList.get(0);
	modelMap.put("template_name", getJsonObject().getString("template_name"));
	modelMap.put("template_type", obj.get("TEMPLATE_TYPE"));
	modelMap.put("netsiteid", obj.get("NETSITEID"));
	modelMap.put("templateList", templateList);
	modelMap.put("traderList",getTraderList());							     //获取商户列表
	modelMap.put("dictList", paramService.getPramListByType(Constant.PARAM_TERM_GENERAL));	     //获取模板类型字典
	modelMap.put("sysPrintParamList", paramService.getPramListByType(Constant.DIC_SYS_PRINT_PARAM_CODE));//打印相关参数
	return  toView(getUrl("template.trader.update"), modelMap);
    }
    
    /**
     * 保存商户模板
     * @return	Msg
     */
    @RequestMapping(value = "saveTemplate", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveTemplate(final HttpServletRequest request) {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(
			null != getJsonObject()
				&& getJsonObject().has("template_name")
				&& getJsonObject().has("netsiteid")
				&& getJsonObject().has("template_type")
				&& getJsonObject().has("defaultFrom"),
			"传入参数失败！");
		String netsiteid=getJsonObject().getString("netsiteid");
		String template_type=getJsonObject().getString("template_type");
		String defaultFrom=getJsonObject().getString("defaultFrom");
		String template_name=getJsonObject().getString("template_name").trim();
		
		Assert.isTrue(!objService.hasExistsTemplate(template_type, netsiteid),"之前已生成该商户该类型的打印模板，保存失败！");

		//copy template from exists
		objService.copyTemplate(template_name, netsiteid, defaultFrom);
		msg.setMsg("保存成功！");
	    }
	});
    }
    
    /**
     * 保存商户模板参数
     * @return	Msg
     */
    @RequestMapping(value = "saveTemplatePara", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveTemplatePara(final HttpServletRequest request) {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(null != request.getParameterValues("line_no") && request.getParameterValues("line_no").length > 0,"至少应添加一个参数，保存失败！");
		String template_type=getJsonObject().getString("template_type");
		String netsiteid=getJsonObject().getString("netsiteid");
		String template_name=getJsonObject().getString("template_name").trim();
		String old_template_name=getJsonObject().getString("old_template_name");
		//delete all
		objService.deleteByName(old_template_name);
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
		    template.setPrint_param(print_param[i]);
		    template.setPrint_title(print_title[i]);
		    template.setNetsiteid(netsiteid);
		    template.setTemplate_name(template_name);
		    template.setTemplate_type(template_type);
		    objService.saveOrUpdate(template);
		}
		msg.setMsg("保存成功！");
	    }
	});
    }

    /**
     * @return List
     */
    private List getTraderList() {
	Map<String, Object> attrMap=new HashMap<String, Object>();
	attrMap.put("netkind", Constant.NETSITE_KIND_AGENT);
	attrMap.put("status", Constant.RECORD_DEL_NOT);
	return traderService.getList(attrMap);
    }
}
