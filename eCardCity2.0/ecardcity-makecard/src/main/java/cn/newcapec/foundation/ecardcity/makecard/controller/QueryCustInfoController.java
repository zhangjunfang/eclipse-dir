/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.controller;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.newcapec.foundation.ecardcity.makecard.biz.ConsumeCardService;
import cn.newcapec.foundation.ecardcity.makecard.biz.QueryCustInfoService;
import cn.newcapec.foundation.ecardcity.makecard.biz.SellCardService;
import cn.newcapec.foundation.ecardcity.makecard.model.CardType;
import cn.newcapec.foundation.ecardcity.makecard.util.CardCodeConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.CardTipConstant;
import cn.newcapec.framework.core.exception.asserts.Assert;
import cn.newcapec.framework.core.exception.asserts.AssertObject;
import cn.newcapec.framework.core.handler.MultiViewResource;
import cn.newcapec.framework.core.rest.Msg;

/**
 * 消费卡-售卡视图控制展示
 * 
 * @author wulimo
 * 
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/querycustinfo")
@SuppressWarnings("all")
public class QueryCustInfoController extends MultiViewResource {
	@Autowired
	private ConsumeCardService consumeCardService;
	@Autowired
	private QueryCustInfoService queryCustInfoService;
	@Autowired
	private SellCardService sellCardService;

	/**
	 * 进入客户信息查询界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "queryCustInfo")
	public String sellCardUI(ModelMap modelMap) {
		return getUrl("makecard.consumecard.queryCustInfoUI");
	}

	/**
	 * 读卡查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "readCardQuery", method = RequestMethod.POST)
	@ResponseBody
	public Msg readCardQuery() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				// 判断传递参数是否为null
				JSONObject param = getJsonObject();
				Assert.isTrue(null != param,
						CardTipConstant.TIP_QUERYCUST_FAULT);

				if (getJsonObject().containsKey("userId")) {

				} else {
					// 获取当前用户信息
					String userId = "1";
					// userId=request.getSession().getAttribute("userId").toString();
					param.put("userId", userId);
				}
				List custList = queryCustInfoService.readCardQuery(param);
				if (null != custList && custList.size() > 0) {
					msg.setMsg(CardTipConstant.TIP_IS_OK);
					msg.setSuccess(true);
					msg.setData(custList);
				} else {
					msg.setMsg(CardTipConstant.TIP_QUERYCUST_NORS);
					msg.setSuccess(false);
				}

			}
		});
	}

	/**
	 * 模糊查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "searchCustList", method = RequestMethod.POST)
	@ResponseBody
	public Msg searchCustList() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				// 判断传递参数是否为null
				JSONObject param = getJsonObject();
				Assert.isTrue(null != param,
						CardTipConstant.TIP_QUERYCUST_FAULT);

				if (getJsonObject().containsKey("userId")) {

				} else {
					// 获取当前用户信息
					String userId = "1";
					// userId=request.getSession().getAttribute("userId").toString();
					param.put("userId", userId);
				}
				Map map = queryCustInfoService.searchCustList(param);
				msg.setSuccess(true);
				msg.setData(map);
			}
		});
	}

	/**
	 * 查看详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "showCustDetail", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView showCustDetail(ModelMap modelMap) {
		// 判断传递参数是否为null
		JSONObject param = getJsonObject();
		Assert.isTrue(null != param, CardTipConstant.TIP_QUERYCUST_FAULT);

		if (getJsonObject().containsKey("userId")) {

		} else {
			// 获取当前用户信息
			String userId = "1";
			// userId=request.getSession().getAttribute("userId").toString();
			param.put("userId", userId);
		}
		Map map = queryCustInfoService.getCustDetail(param);
		List<CardType> cardTypes = sellCardService.getSellCardTypes();
		modelMap.put("countrys", sellCardService
				.getDictListByCode(CardCodeConstant.CODE_DICT_COUNTRY));
		modelMap.put("nations", sellCardService
				.getDictListByCode(CardCodeConstant.CODE_DICT_NATION));
		modelMap.put("certificatetypes", sellCardService
				.getDictListByCode(CardCodeConstant.CODE_DICT_CERTIFICATETYPE));
		modelMap.put("cardTypes", cardTypes);
		modelMap.put("obj", map);
		return toView(getUrl("makecard.consumecard.custDetailUI"), modelMap);
	}

}
