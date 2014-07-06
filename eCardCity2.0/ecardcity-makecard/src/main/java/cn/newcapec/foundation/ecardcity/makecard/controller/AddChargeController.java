/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.newcapec.foundation.ecardcity.makecard.biz.AddChargeService;
import cn.newcapec.foundation.ecardcity.makecard.biz.ConsumeCardService;
import cn.newcapec.foundation.ecardcity.makecard.biz.ECardPreService;
import cn.newcapec.foundation.ecardcity.makecard.util.CardTipConstant;
import cn.newcapec.framework.core.exception.asserts.Assert;
import cn.newcapec.framework.core.exception.asserts.AssertObject;
import cn.newcapec.framework.core.handler.MultiViewResource;
import cn.newcapec.framework.core.rest.Msg;

/**
 * 消费卡-充值视图控制展示
 * 
 * @author wulimo
 * 
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/addcharge")
@SuppressWarnings("all")
public class AddChargeController extends MultiViewResource {

	@Autowired
	private ConsumeCardService consumeCardService;
	@Autowired
	private AddChargeService addChargeService;
	@Autowired
	private ECardPreService eCardPreService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * 进入充值主页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "addCharge")
	public String addChargeUI() {
		JSONObject param = getJsonObject();
		if (null != param && param.containsKey("ver")) {
			String ver = param.getString("ver");
			if (ver.equals("bootstrap")) {
				return getUrl("makecard.consumecard.toaddChargeUI");
			}
		}
		return getUrl("makecard.consumecard.addChargeUI");
	}

	/**
	 * 充值--读卡
	 * 
	 * @return
	 */
	@RequestMapping(value = "readCardForAddCharge", method = RequestMethod.POST)
	@ResponseBody
	public Msg readCardForAddCharge() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				// 判断传递参数是否为null
				JSONObject param = getJsonObject();
				Assert.isTrue(null != param,
						CardTipConstant.TIP_ADDCHARDE_READCARD_FAIL);
				if (getJsonObject().containsKey("userId")) {

				} else {
					// 获取当前用户信息
					String userId = "1";
					// userId=request.getSession().getAttribute("userId").toString();
					param.put("userId", userId);
				}
				Msg obj = addChargeService.readCardForAddCharge(param);
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
	 * 充值--充值操作：充值申请
	 * 
	 * @return
	 */
	@RequestMapping(value = "reqChashToWallet", method = RequestMethod.POST)
	@ResponseBody
	public Msg reqChashToWallet() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				Assert.isTrue(null != getJsonObject(),
						CardTipConstant.TIP_ADDCHARDE_REQCHASHTOWALLET_FAIL);
				Msg obj = addChargeService.reqChashToWallet(getJsonObject());
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
	 * 充值--充值操作：充值提交
	 * 
	 * @return
	 */
	@RequestMapping(value = "commitChashToWallet", method = RequestMethod.POST)
	@ResponseBody
	public Msg commitChashToWallet() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				Assert.isTrue(null != getJsonObject(),
						CardTipConstant.TIP_ADDCHARDE_COMMITCHASHTOWALLET_FAIL);
				Msg obj = addChargeService.commitChashToWallet(getJsonObject());
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
	 * 充值完成打印页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "addChargePrint", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView addChargePrintUI(ModelMap modelMap) {
		Assert.isTrue(null != getJsonObject(),
				CardTipConstant.TIP_ADDCHARDE_REQPRINT_FAIL);
		// 打印数据
		JSONObject printData = getJsonObject().getJSONObject("printData");
		modelMap.put("printData", printData);
		return toView(getUrl("makecard.consumecard.addChargePrintUI"), modelMap);
	}

	/**
	 * 获取及时统计消息
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "getBizTotalMsg", method = { RequestMethod.POST })
	@ResponseBody
	public Msg getBizTotalMsg() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				Assert.isTrue(null != getJsonObject(),
						CardTipConstant.TIP_GET_BIZTOTAL_FAIL);
				// 获取当前用户信息
				String userId = "1";
				// userId=request.getSession().getAttribute("userId").toString();
				String psamcardno = getJsonObject().getString("psamcardno");
				Msg obj = consumeCardService.getBizTotalMsg(
						Long.parseLong(psamcardno), userId);
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
	 * 调用WebService
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "reqECardPreServiceCity", method = { RequestMethod.POST })
	@ResponseBody
	public Msg reqECardPreServiceCity() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				Msg obj = eCardPreService
						.getECardPreServiceCity(getJsonObject());
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
