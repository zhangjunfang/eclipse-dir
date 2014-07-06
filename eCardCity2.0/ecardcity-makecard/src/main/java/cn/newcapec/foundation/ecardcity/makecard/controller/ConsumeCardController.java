/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.newcapec.foundation.ecardcity.makecard.biz.ConsumeCardService;
import cn.newcapec.foundation.ecardcity.makecard.biz.ECardPreService;
import cn.newcapec.foundation.ecardcity.makecard.util.CardTipConstant;
import cn.newcapec.framework.core.exception.asserts.Assert;
import cn.newcapec.framework.core.exception.asserts.AssertObject;
import cn.newcapec.framework.core.handler.MultiViewResource;
import cn.newcapec.framework.core.rest.Msg;

/**
 * 消费卡-公用接口
 * 
 * @author wulimo
 * 
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/consumeCard")
@SuppressWarnings("all")
public class ConsumeCardController extends MultiViewResource {

	@Autowired
	private ConsumeCardService consumeCardService;
	@Autowired
	private ECardPreService eCardPreService;
	@Autowired
	private HttpServletRequest request;

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
	 * 调用密钥WebService
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "reqECardSecretKey", method = { RequestMethod.POST })
	@ResponseBody
	public Msg reqECardSecretKey() {
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
