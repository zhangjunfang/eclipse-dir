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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.newcapec.foundation.ecardcity.makecard.biz.ConsumeCardService;
import cn.newcapec.foundation.ecardcity.makecard.biz.ECardPreService;
import cn.newcapec.foundation.ecardcity.makecard.biz.QuashAddChargeService;
import cn.newcapec.foundation.ecardcity.makecard.util.CardTipConstant;
import cn.newcapec.framework.core.exception.asserts.Assert;
import cn.newcapec.framework.core.exception.asserts.AssertObject;
import cn.newcapec.framework.core.handler.MultiViewResource;
import cn.newcapec.framework.core.rest.Msg;

/**
 * 消费卡-充值撤销视图控制展示
 * 
 * @author wulimo
 * 
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/quashaddcharge")
@SuppressWarnings("all")
public class QuashAddChargeController extends MultiViewResource {

	@Autowired
	private ConsumeCardService consumeCardService;
	@Autowired
	private QuashAddChargeService quashAddChargeService;
	@Autowired
	private ECardPreService eCardPreService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * 进入充值撤销主页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "quashAddCharge")
	public String quashAddChargeUI() {
		JSONObject param = getJsonObject();
		if (null != param && param.containsKey("ver")) {
			String ver = param.getString("ver");
			if (ver.equals("bootstrap")) {
				return getUrl("makecard.consumecard.toquashAddChargeUI");
			}
		}
		return getUrl("makecard.consumecard.quashAddChargeUI");
	}

	/**
	 * 充值撤销-读卡查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "readCardAndQuery", method = RequestMethod.POST)
	@ResponseBody
	public Msg readCardAndQuery() {
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
				Msg obj = quashAddChargeService.readCardAndQuery(param);
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
	 * 充值撤销-申请
	 * 
	 * @return
	 */
	@RequestMapping(value = "reqQuashAdd", method = RequestMethod.POST)
	@ResponseBody
	public Msg reqQuashAdd() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				// 判断传递参数是否为null
				JSONObject param = getJsonObject();
				Assert.isTrue(null != param,
						CardTipConstant.TIP_QUASHADDCHARGE_REQFAULT);
				if (getJsonObject().containsKey("userId")) {

				} else {
					// 获取当前用户信息
					String userId = "1";
					// userId=request.getSession().getAttribute("userId").toString();
					param.put("userId", userId);
				}
				Msg obj = quashAddChargeService.reqQuashAdd(param);
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
	 * 充值撤销-提交
	 * 
	 * @return
	 */
	@RequestMapping(value = "commitQuashAdd", method = RequestMethod.POST)
	@ResponseBody
	public Msg commitQuashAdd() {
		return doExpAssert(new AssertObject() {
			@Override
			public void AssertMethod(Msg msg) {
				// 判断传递参数是否为null
				JSONObject param = getJsonObject();
				Assert.isTrue(null != param,
						CardTipConstant.TIP_QUASHADDCHARGE_COMMITFAULT);
				if (getJsonObject().containsKey("userId")) {

				} else {
					// 获取当前用户信息
					String userId = "1";
					// userId=request.getSession().getAttribute("userId").toString();
					param.put("userId", userId);
				}
				Msg obj = quashAddChargeService.commitQuashAdd(param);
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
