/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.controller;

import java.util.List;

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
@RequestMapping(value = "/sellcard")
@SuppressWarnings("all")
public class SellCardController extends MultiViewResource {
	@Autowired
	private ConsumeCardService consumeCardService;
	@Autowired
	private SellCardService sellCardService;

	/**
	 * 进入发卡界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "sellCard")
	public ModelAndView sellCardUI(ModelMap modelMap) {
		JSONObject param = getJsonObject();
		List<CardType> cardTypes = sellCardService.getSellCardTypes();
		modelMap.put("countrys", sellCardService
				.getDictListByCode(CardCodeConstant.CODE_DICT_COUNTRY));
		modelMap.put("nations", sellCardService
				.getDictListByCode(CardCodeConstant.CODE_DICT_NATION));
		modelMap.put("certificatetypes", sellCardService
				.getDictListByCode(CardCodeConstant.CODE_DICT_CERTIFICATETYPE));
		modelMap.put("cardTypes", cardTypes);
		// bootstrap版本
		if (null != param && param.containsKey("ver")) {
			String ver = param.getString("ver");
			if (ver.equals("bootstrap")) {
				return toView(getUrl("makecard.consumecard.tosellCardUI"),
						modelMap);
			}
		}
		return toView(getUrl("makecard.consumecard.sellCardUI"), modelMap);
		// return getUrl("makecard.consumecard.sellCardUI");
	}

	/**
	 * 售卡--读卡验证
	 * 
	 * @return
	 */
	@RequestMapping(value = "readCardForSellCard", method = RequestMethod.POST)
	@ResponseBody
	public Msg readCardForSellCard() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				// 判断传递参数是否为null
				JSONObject param = getJsonObject();
				Assert.isTrue(null != param,
						CardTipConstant.TIP_SELLCARD_READCARD_FAIL);

				if (getJsonObject().containsKey("userId")) {

				} else {
					// 获取当前用户信息
					String userId = "1";
					// userId=request.getSession().getAttribute("userId").toString();
					param.put("userId", userId);
				}
				Msg obj = sellCardService.readCardForSellCard(param);
				msg.setMsg(obj.getMsg());
				if (CardTipConstant.TIP_IS_OK.equals(obj.getMsg())) {
					msg.setSuccess(true);
					msg.setData(obj.getData());
				} else {
					msg.setSuccess(false);
				}
			}
		});
	}

	/**
	 * 售卡--售卡操作：售卡申请
	 * 
	 * @return
	 */
	@RequestMapping(value = "reqSellChard", method = RequestMethod.POST)
	@ResponseBody
	public Msg reqSellChard() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				Assert.isTrue(null != getJsonObject(),
						CardTipConstant.TIP_SELLCARD_REQ_FAIL);
				Msg obj = sellCardService.reqSellChard(getJsonObject());
				msg.setMsg(obj.getMsg());
				if (CardTipConstant.TIP_IS_OK.equals(obj.getMsg())) {
					msg.setSuccess(true);
					msg.setData(obj.getData());
				} else {
					msg.setSuccess(false);
				}
			}
		});
	}

	/**
	 * 售卡--售卡操作：售卡提交
	 * 
	 * @return
	 */
	@RequestMapping(value = "commitSellChard", method = RequestMethod.POST)
	@ResponseBody
	public Msg commitSellChard() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				Assert.isTrue(null != getJsonObject(),
						CardTipConstant.TIP_SELLCARD_COMMIT_FAIL);
				Msg obj = sellCardService.commitSellChard(getJsonObject());
				msg.setMsg(obj.getMsg());
				if (CardTipConstant.TIP_IS_OK.equals(obj.getMsg())) {
					msg.setSuccess(true);
					msg.setData(obj.getData());
				} else {
					msg.setSuccess(false);
				}
			}
		});
	}

}
