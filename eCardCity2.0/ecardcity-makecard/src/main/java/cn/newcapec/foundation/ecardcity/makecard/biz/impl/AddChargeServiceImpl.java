/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.biz.impl;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.foundation.ecardcity.makecard.biz.AddChargeService;
import cn.newcapec.foundation.ecardcity.makecard.dao.AddChargeDao;
import cn.newcapec.foundation.ecardcity.makecard.model.Customer;
import cn.newcapec.foundation.ecardcity.makecard.model.MoneyDrawApplyPlan;
import cn.newcapec.foundation.ecardcity.makecard.model.NetSite;
import cn.newcapec.foundation.ecardcity.makecard.model.TermInfo;
import cn.newcapec.foundation.ecardcity.makecard.util.ACUserNetInfoForm;
import cn.newcapec.foundation.ecardcity.makecard.util.CardConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.CardInfoForm;
import cn.newcapec.foundation.ecardcity.makecard.util.CardTipConstant;
import cn.newcapec.framework.core.exception.BaseException;
import cn.newcapec.framework.core.rest.Msg;
import cn.newcapec.framework.core.utils.dataUtils.DateUtil;
import cn.newcapec.framework.core.utils.jsonUtils.JSONTools;

/**
 * 充值业务接口实现类
 * 
 * @author wulimo
 * 
 */
@Service("addChargeService")
@Transactional
@SuppressWarnings("all")
public class AddChargeServiceImpl implements AddChargeService {

	/**
	 * 本地Log4J管道日志输出
	 */
	private static final Logger log = Logger
			.getLogger(AddChargeServiceImpl.class);

	@Autowired
	private AddChargeDao addChargeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.AddChargeService#
	 * readCardForAddCharge(net.sf.json.JSONObject)
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Msg readCardForAddCharge(JSONObject param) {
		// 充值读卡验证--返回信息
		Msg msg = new Msg();
		// 获取前台传入的参数
		// 当前登录用户及时消息中传入
		String userId = param.getString("userId");
		// 终端PSAM卡号10进制
		String psamcardno = param.getString("psamcardno");
		// 卡唯一号10进制
		String snr = param.getString("snr");
		// 卡应用序列号ASN16进制
		String asn16 = param.getString("asn16");
		// 卡应用序列号ASN10进制
		String asn = "" + Long.parseLong(asn16, 16);
		// 卡种类1-M1 2-CPU
		String cardKind = param.getString("cardKind");
		// 卡余额单位：分
		String cardRec = param.getString("cardRec");
		// 卡片消费计数
		String cardOpCnt = param.getString("cardOpCnt");
		// 卡片充值计数
		String cardSaveOpCnt = param.getString("cardSaveOpCnt");
		// 当前可充值操作的卡类型
		String cashCardtype = param.getString("cashCardtype");
		// 参数空值判断
		if (psamcardno.equals("") || snr.equals("") || asn.equals("")) {
			msg.setMsg(CardTipConstant.TIP_ADDCHARDE_READCARDREQ_FAIL);
			return msg;
		}

		// 查询终端，验证终端合法性，是否启用了授权
		// 得到终端信息
		TermInfo termInfo = addChargeDao.getTermInfoBySamcard(Long
				.parseLong(psamcardno));
		// 终端Id
		String termId = termInfo.getTermid().toString();
		// 当前所属网点信息
		NetSite netSite = null;
		// 终端合法查询网点信息
		if (null != termInfo) {
			String terTip = addChargeDao
					.checkTermPsamCard(termInfo, psamcardno);
			if (CardTipConstant.TIP_IS_OK.equals(terTip)) {
				netSite = addChargeDao.getNetSite(termInfo.getSiteid());
			} else {
				msg.setMsg(terTip);
			}
		} else {
			msg.setMsg(CardTipConstant.TIP_ADDCHARDE_NOT_THIS_TERM);
			return msg;
		}

		// 验证网点信息，网点合法查询用户权限
		if (null != netSite
				&& CardConstant.STATUS_NOR.equals(netSite.getNetstatus())) {
			// 验证当前操作员是否有充值权限
			String ckTip = addChargeDao.checkUserPermission(userId,
					netSite.getNetid(), cardKind);
			if (!CardTipConstant.TIP_IS_OK.equals(ckTip)) {
				msg.setMsg(ckTip);
				return msg;
			}
		} else {
			msg.setMsg(CardTipConstant.TIP_ADDCHARDE_NETSTATUS_STOP);
			return msg;
		}

		// 验证卡用户、卡信息
		CardInfoForm cardinfoform = cardinfoform = addChargeDao
				.getCardInfoForm(snr, cardKind);
		if (null == cardinfoform || null == cardinfoform.getAppinfoId()) {
			msg.setMsg(CardTipConstant.TIP_ADDCHARDE_GET_CUSTCARD_FAIL);
			return msg;
		} else {
			if ("".equals(cashCardtype) || cashCardtype.length() == 0) {
				msg.setMsg(CardTipConstant.TIP_DONOT_CAN_OP_CARD);
				return msg;
			} else {
				if (("," + cashCardtype + ",").indexOf(","
						+ cardinfoform.getCardtype() + ",") == -1) {
					msg.setMsg(CardTipConstant.TIP_DONOT_CAN_OP_CARD);
					return msg;
				}
			}
			if (!CardConstant.CUST_CARDSTATUS_NOR.equals(cardinfoform
					.getCardstatus())) {
				msg.setMsg(CardTipConstant.TIP_ADDCHARDE_CUSTCARDSTATUS_NOT_NOR
						+ "[code:" + cardinfoform.getCardstatus() + "]");
				return msg;
			}
			cardinfoform.setAsn16(asn16);
		}

		// 验证处理充值未决
		String unsttleTip = addChargeDao.checkAddUnsettled(cardinfoform,
				cardSaveOpCnt, cardRec);
		if (!CardTipConstant.TIP_IS_OK.equals(unsttleTip)) {
			msg.setMsg(unsttleTip);
			return msg;
		}

		// 读卡验证成功
		msg.setMsg(CardTipConstant.TIP_IS_OK);
		// 封装客户、卡信息
		Customer customer = addChargeDao.getByCustId(cardinfoform
				.getCustomerid());
		if (null == customer) {
			throw new BaseException(CardTipConstant.TIP_ADDCHARDE_GET_CUST_FAIL);
		}
		param.put("customer", customer);
		// 封装操作员、网点、终端信息
		ACUserNetInfoForm acUserNetInfo = addChargeDao.getACUserNetInfo(termId,
				userId);
		param.put("acUserNetForm", acUserNetInfo);
		param.put("cardInfoForm", cardinfoform);
		msg.setData(param.toString());
		return msg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.AddChargeService#
	 * reqChashToWallet(net.sf.json.JSONObject)
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Msg reqChashToWallet(JSONObject param) {
		// 充值申请成功返回消息
		Msg msg = new Msg();

		// 获取前台传入的参数
		// 充值金额
		String chargeMoney = param.getString("chargeMoney");
		// 是否支票充值
		String useCardCoat = param.containsKey("useCardCoat") ? param
				.getString("useCardCoat") : "0";
		String isCoat = "".equals(useCardCoat) ? "0" : useCardCoat;
		// mac1预充值获取ChargeInit
		String mac1 = param.getString("mac1");
		// mac2密钥系统验证获得
		String mac2 = param.getString("mac2");

		// 还原读卡的数据
		JSONObject readData = param.getJSONObject("readData");
		// 还原读卡验证的数据对象
		ACUserNetInfoForm acUserNetInfo = JSONTools.JSONToBean(
				readData.getJSONObject("acUserNetForm"),
				ACUserNetInfoForm.class);
		Customer customer = JSONTools.JSONToBean(
				readData.getJSONObject("customer"), Customer.class);
		CardInfoForm cardInfoForm = JSONTools.JSONToBean(
				readData.getJSONObject("cardInfoForm"), CardInfoForm.class);
		/**
		 * 生成充值的19位时间:<br>
		 * 1、优先使用M1卡调用密钥系统checkMac时已生成操作时间<br>
		 * 2、没有checkMac操作时，使用充值申请的时间<br>
		 * 3、前端写卡时checkTac统一使用此时间<br>
		 * 4、充值数据生成的记录统一使用此时间<br>
		 */
		String tacdt = "";
		if (param.containsKey("tacdt")) {
			tacdt = param.getString("tacdt");
		}
		if (tacdt.length() == 19) {
			// 有
		} else {
			tacdt = DateUtil.toDateTimeString(DateUtil.getCurrDay(),
					DateUtil.DATETIME_FORMAT);
		}

		// 充值申请计划
		MoneyDrawApplyPlan moneyPlan = addChargeDao.saveMoneyDrawApplyPlan(
				cardInfoForm, acUserNetInfo, chargeMoney, "", isCoat, tacdt);

		// 充值申请计划状态变化信息
		String planId = moneyPlan.getId();
		String planstateId = addChargeDao.saveMoneyDrawApplyStatus(
				cardInfoForm, planId, moneyPlan.getDescrition(),
				acUserNetInfo.getUserId(), tacdt, acUserNetInfo.getPoscode());

		// 更新网点授权额度--扣减授权余额
		String authaId = addChargeDao.netChargeauthChange(acUserNetInfo,
				Double.parseDouble(chargeMoney),
				CardConstant.NET_AUTHCHANGE_DIR_CUT, tacdt);
		if (planId.length() > 0 && authaId.length() > 0) {
			readData.put("moneyPlan", moneyPlan);
			readData.put("planstateId", planstateId);
			readData.put("authaId", authaId);
			readData.put("chargeMoney", chargeMoney);
			readData.put("isCoat", isCoat);
			readData.put("mac1", mac1);
			readData.put("mac2", mac2);
			readData.put("tacdt", tacdt);
		} else {
			msg.setMsg(CardTipConstant.TIP_ADDCHARDE_REQCHASHTOWALLET_FAIL);
			return msg;
		}
		// 申请成功
		msg.setMsg(CardTipConstant.TIP_IS_OK);
		msg.setData(readData.toString());

		// 关键信息日志
		String message = "充值申请>>userId:" + acUserNetInfo.getUserId()
				+ "|planId:" + planId + "|authaId:" + authaId + "|chargeMoney:"
				+ chargeMoney + "元|tacDate:" + tacdt;
		// 本地Log4J记录
		log.info(message);
		// 系统日志记录
		// logEnabled.log.info(message);
		return msg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.AddChargeService#
	 * commitChashToWallet(net.sf.json.JSONObject)
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Msg commitChashToWallet(JSONObject param) {
		// 获取前台传入的参数

		// 写卡标示Q写卡成功或失败（Y成功N失败）E写卡异常
		String writeFlag = param.getString("writeFlag");

		// 写卡后钱包余额:分
		String wcardRec = param.getString("wcardRec");
		// 写卡后消费操作计数
		String wcardOpCnt = param.getString("wcardOpCnt");
		// 写卡后充值操作计数
		String wcardSaveOpCnt = param.getString("wcardSaveOpCnt");
		// 充值记录Tac码密钥系统验证获取
		String tac = param.getString("tac");

		// 充值申请的数据和参数
		JSONObject reqData = param.getJSONObject("reqData");
		// 还原充值申请的数据对象
		// tac校验时间19位
		String tacdt = reqData.getString("tacdt");
		// 充值金额
		String chargeMoney = reqData.getString("chargeMoney");
		// 是否支票充值
		String useCardCoat = param.containsKey("useCardCoat") ? param
				.getString("useCardCoat") : "0";
		String isCoat = "".equals(useCardCoat) ? "0" : useCardCoat;
		// 充值申请状态变化ID
		String planstateId = reqData.getString("planstateId");
		// 授权额度主键
		String authaId = reqData.getString("authaId");
		// 充值计划
		MoneyDrawApplyPlan moneyPlan = JSONTools.JSONToBean(
				reqData.getJSONObject("moneyPlan"), MoneyDrawApplyPlan.class);

		// 读卡时的数据对象
		ACUserNetInfoForm acUserNetInfo = JSONTools
				.JSONToBean(reqData.getJSONObject("acUserNetForm"),
						ACUserNetInfoForm.class);
		Customer customer = JSONTools.JSONToBean(
				reqData.getJSONObject("customer"), Customer.class);
		CardInfoForm cardInfoForm = JSONTools.JSONToBean(
				reqData.getJSONObject("cardInfoForm"), CardInfoForm.class);

		// 根据写卡结果提交或回滚数据，并作记录
		String msgTip = CardTipConstant.TIP_ADDCHARDE_COMMITCHASHTOWALLET_FAIL;
		if (CardConstant.WRITECARD_IS_YES.equals(writeFlag)) {
			// 写卡成功
			// 更新网点授权额度--额度不变

			// 更新卡片当前余额
			addChargeDao.updateCardMoneySum(cardInfoForm.getAppinfoId(),
					chargeMoney, wcardOpCnt, wcardSaveOpCnt, wcardRec);

			// 提交充值计划、及状态变化、记录存款记录
			msgTip = addChargeDao.commitApllyPlanRecord(
					acUserNetInfo.getNetid(), moneyPlan.getId(), planstateId,
					wcardOpCnt, wcardSaveOpCnt, writeFlag, tacdt, tac);
		} else {
			if (CardConstant.WRITECARD_IS_NO.equals(writeFlag)
					|| CardConstant.WRITECARD_IS_EXCEPTION.equals(writeFlag)) {
				// 写卡失败或异常
				// 更新网点授权额度--退还授权余额
				String eauth = addChargeDao.netChargeauthChange(acUserNetInfo,
						Double.parseDouble(chargeMoney),
						CardConstant.NET_AUTHCHANGE_DIR_ADD, tacdt);
				if (eauth.length() > 0) {
					// 删除充值计划、及状态变化、记录存款记录
					msgTip = addChargeDao.commitApllyPlanRecord(
							acUserNetInfo.getNetid(), moneyPlan.getId(),
							planstateId, wcardOpCnt, wcardSaveOpCnt, writeFlag,
							tacdt, tac);
				}
			}
		}

		// 返回数据，封装打印对象信息
		// 商户代码
		reqData.put("merchantCode", acUserNetInfo.getMerchantcode());
		// 商户名称--网点名称
		reqData.put("netName", acUserNetInfo.getNetname());
		// 终端编号
		reqData.put("termCode", acUserNetInfo.getPoscode());
		// 操作员
		reqData.put("userName", acUserNetInfo.getUserName());
		// 流水号
		reqData.put("planId", moneyPlan.getId());
		// 户名
		reqData.put("custName", customer.getName());
		// 市民卡号
		reqData.put("custCardNo", cardInfoForm.getCitycardno());
		// 交易类型
		reqData.put("opType", moneyPlan.getDescrition());
		// 交易金额
		reqData.put("opFare", moneyPlan.getOpfare());
		// 交易时间
		reqData.put("opTime", tacdt);
		// 交易应答
		reqData.put(
				"opOK",
				CardConstant.WRITECARD_IS_YES.equals(writeFlag) ? CardConstant.REQ_IS_SUNCESS
						: CardConstant.REQ_IS_FAIL);

		Msg msg = new Msg();
		msg.setMsg(msgTip);
		msg.setData(reqData.toString());

		// 关键信息日志
		String message = "充值提交>>userId:" + acUserNetInfo.getUserId()
				+ "|planId:" + moneyPlan.getId() + "|authaId:" + authaId
				+ "|chargeMoney:" + chargeMoney + "元|tacDate:" + tacdt
				+ "|writeFlag:" + writeFlag;
		// 本地Log4J记录
		log.info(message);
		// 系统日志记录
		// logEnabled.log.info(message);
		return msg;
	}

}
