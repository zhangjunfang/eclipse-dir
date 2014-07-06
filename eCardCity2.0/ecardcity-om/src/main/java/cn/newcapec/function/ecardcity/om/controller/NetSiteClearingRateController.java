/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
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
import cn.newcapec.function.ecardcity.om.biz.NetSiteClearingRateService;
import cn.newcapec.function.ecardcity.om.biz.NetSiteService;
import cn.newcapec.function.ecardcity.om.model.NetSiteClearingRate;
import cn.newcapec.function.ecardcity.om.utils.Constant;
import cn.newcapec.function.ecardcity.om.utils.DateUtil;

/**
 * @author wj
 * @category 网点结算费率设置Controller
 * @version 1.0
 * @date 2014年5月15日 下午4:00:00
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/netsiteClearingRate")
@SuppressWarnings("all")
public class NetSiteClearingRateController extends MultiViewResource {
    @Autowired
    private NetSiteClearingRateService objService;
    @Autowired
    private NetSiteService netSiteService;

    /**
     * 费率设置入口
     * @param	modelMap	map模型
     * @return	ModelAndView
     */
    @RequestMapping(value = "edit")
    public ModelAndView edit(ModelMap modelMap) {
	//网点列表
	modelMap.put("netsiteList", getNetSiteList());
	return  toView(getUrl("netsite.netsiteclearingrate.edit"), modelMap);
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
		Assert.isTrue(null != getJsonObject(), "参数传入失败！");
		NetSiteClearingRate obj = JSONTools.JSONToBean(getJsonObject(), NetSiteClearingRate.class);
		Assert.isTrue(StringUtils.isNotBlank(obj.getNetsiteid()), "请先选择网点！");
		if(obj.getFlag().equals("0")){
		    //固定收付（按交易次数）
		    Assert.isTrue(StringUtils.isNotBlank(String.valueOf(obj.getFeepersale())), "请输入每笔交易收费金额！");
		    Assert.isTrue(!obj.getFeepersale().equals("0"), "每笔交易收费金额不能为0！");
		    obj.setFeepersale(new BigDecimal(obj.getFeepersale()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		    obj.setCurrencyrates("0");
		}else{
		    //按金额收费
		    Assert.isTrue(StringUtils.isNotBlank(String.valueOf(obj.getCurrencyrates())), "请输入交易金额收费比列！");
		    Assert.isTrue(!obj.getCurrencyrates().equals("0"), "交易金额收费比列不能为0！");
		    obj.setCurrencyrates(new BigDecimal(obj.getCurrencyrates()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		    obj.setFeepersale("0");
		}
		Assert.isTrue(StringUtils.isNotBlank(String.valueOf(obj.getTransferratesofbank())), "请输入银行转账费率！");
		obj.setTransferratesofbank(new BigDecimal(obj.getTransferratesofbank()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());

		//TODO 需要更改为从session中获取
		obj.setEdit_person("admin");
		obj.setEdit_date(new Date());
		objService.saveOrUpdate(obj);
		msg.setMsg("保存成功！");
	    }
	});
    }

    /**
     * ajax获取当前网点费率设置数据
     * @return	Msg
     */
    @RequestMapping(value = "ajaxGetClearingRate",method=RequestMethod.POST)
    @ResponseBody
    public Msg ajaxGetClearingRate() {
	return doExpAssert(new AssertObject() {
	    @Override
	    public void AssertMethod(Msg msg) {
		Assert.isTrue(StringUtils.isNotBlank(getJsonObject().getString("netsiteid")), "请先选择网点！");
		String netSiteId=getJsonObject().getString("netsiteid");
		NetSiteClearingRate obj=objService.getByNetSiteID(netSiteId);
		//如果为null，则创建一个默认
		JSONObject json=new JSONObject();
		json.put("netsiteid" ,netSiteId);
		if(obj==null){
		    json.put("id" ,"");
		    json.put("flag" ,"0");
		    json.put("feepersale" ,"0");
		    json.put("currencyrates" ,"0");
		    json.put("edit_person" ,"");
		    json.put("edit_date" ,"");
		}else{
		    json.put("id" ,obj.getId());
		    json.put("flag" ,obj.getFlag());
		    json.put("feepersale" ,obj.getFeepersale());
		    json.put("currencyrates" ,obj.getCurrencyrates());
		    json.put("transferratesofbank" ,obj.getTransferratesofbank());
		    json.put("edit_person" ,obj.getEdit_person());
		    json.put("edit_date" ,DateUtil.formatDate(obj.getEdit_date(),DateUtil.FULL_DATE_FORMAT));
		}
		msg.setData(json.toString());
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
