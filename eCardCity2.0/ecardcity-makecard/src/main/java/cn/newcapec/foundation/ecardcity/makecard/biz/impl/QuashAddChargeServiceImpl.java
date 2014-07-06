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

import cn.newcapec.foundation.ecardcity.makecard.biz.ECardPreService;
import cn.newcapec.foundation.ecardcity.makecard.biz.QuashAddChargeService;
import cn.newcapec.foundation.ecardcity.makecard.dao.QuashAddChargeDao;
import cn.newcapec.foundation.ecardcity.makecard.model.Customer;
import cn.newcapec.foundation.ecardcity.makecard.model.MoneyDrawApplyPlan;
import cn.newcapec.foundation.ecardcity.makecard.model.MoneyDrawApplySuccessed;
import cn.newcapec.foundation.ecardcity.makecard.model.MoneySaveSuccessed;
import cn.newcapec.foundation.ecardcity.makecard.model.NetSite;
import cn.newcapec.foundation.ecardcity.makecard.model.TermInfo;
import cn.newcapec.foundation.ecardcity.makecard.util.ACUserNetInfoForm;
import cn.newcapec.foundation.ecardcity.makecard.util.CardConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.CardInfoForm;
import cn.newcapec.foundation.ecardcity.makecard.util.CardTipConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.ECardPreServiceResultForm;
import cn.newcapec.framework.core.exception.BaseException;
import cn.newcapec.framework.core.rest.Msg;
import cn.newcapec.framework.core.utils.dataUtils.DateUtil;
import cn.newcapec.framework.core.utils.jsonUtils.JSONTools;

/**
 * 充值撤销业务接口实现类
 * 
 * @author wulimo
 * 
 */
@Service("quashAddChargeService")
@Transactional
@SuppressWarnings("all")
public class QuashAddChargeServiceImpl implements QuashAddChargeService {

	/**
	 * 本地Log4J管道日志输出
	 */
	private static final Logger log = Logger
			.getLogger(QuashAddChargeServiceImpl.class);

	@Autowired
	private QuashAddChargeDao quashAddChargeDao;
	@Autowired
	private ECardPreService eCardPreService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.AddChargeService#
	 * readCardForAddCharge(net.sf.json.JSONObject)
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Msg readCardAndQuery(JSONObject param) {
		// 充值读卡验证--返回信息
		Msg msg = new Msg();

		// 获取前台传入的参数
		// 当前登录用户及时消息中传入
		String userId = param.getString("userId");
		// 证件号码
		String pidno = param.getString("pidno");
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

		// 钱包当前余额单位：分
		String cardRec = param.getString("cardRec");
		// 消费操作计数
		String cardOpCnt = param.getString("cardOpCnt");
		// 充值操作计数
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
		TermInfo termInfo = quashAddChargeDao.getTermInfoBySamcard(Long
				.parseLong(psamcardno));
		// 终端Id
		String termId = termInfo.getTermid().toString();
		// 当前所属网点信息
		NetSite netSite = null;
		// 终端合法查询网点信息
		if (null != termInfo) {
			String terTip = quashAddChargeDao.checkTermPsamCard(termInfo,
					psamcardno);
			if (CardTipConstant.TIP_IS_OK.equals(terTip)) {
				netSite = quashAddChargeDao.getNetSite(termInfo.getSiteid());
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
			String ckTip = quashAddChargeDao.checkUserPermissionForQuash(
					userId, netSite.getNetid(), cardKind);
			if (!CardTipConstant.TIP_IS_OK.equals(ckTip)) {
				msg.setMsg(ckTip);
				return msg;
			}
		} else {
			msg.setMsg(CardTipConstant.TIP_ADDCHARDE_NETSTATUS_STOP);
			return msg;
		}

		// 验证卡用户、卡信息
		CardInfoForm cardinfoform = cardinfoform = quashAddChargeDao
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

			if ("0".equals(cardinfoform.getSaveopcount())) {
				msg.setMsg(CardTipConstant.TIP_QUASHADDCHARGE_NO_ADDINFO);
				return msg;
			}
			cardinfoform.setAsn16(asn16);
		}

		// 最后一笔充值信息(只查询充值的)
		MoneySaveSuccessed saveObj = quashAddChargeDao
				.getMoneySaveSuccessedByQuery(cardinfoform);
		MoneyDrawApplySuccessed saveApplyObj = null;
		if (null != saveObj && saveObj.getId() != null) {
			// 库中校验计数
			long dbOpCnt = Long.parseLong(cardinfoform.getOpcount());
			long dbSaveOpCnt = Long.parseLong(cardinfoform.getSaveopcount());

			// 存款计数:卡存款计数==存款记录的存款计数==库中存款计数
			if (saveObj.getSaveopcount().longValue() == dbSaveOpCnt
					&& cardSaveOpCnt.equals(cardinfoform.getSaveopcount())) {
				// 不存在撤销记录(应该未撤销标记)
				if (CardConstant.QUASH_ADDCHARGE_IS_CORRECT.equals(saveObj
						.getCorrect())) {
					msg.setMsg(CardTipConstant.TIP_QUASHADDCHARGE_CORRECT_FLAG_ERR);
					return msg;
				}
			} else {
				// 充值未决(卡库存款计数不一致)
				// msg.setMsg(CardTipConstant.TIP_QUASHADDCHARGE_HAVE_UNSETILADDINFO);
				// return msg;
			}

			// 消费计数:卡消费计数==存款记录的消费计数==库中消费计数
			if (saveObj.getOpcount().longValue() == Long.parseLong(cardOpCnt)
					&& cardOpCnt.equals(cardinfoform.getOpcount())) {

			} else {
				// 卡库消费计数不一致(消费记录未上传)
				// msg.setMsg(CardTipConstant.TIP_QUASHADDCHARGE_CARDANDDB_OPCNT_NOTSAME);
				// return msg;
			}

			// 对应的充值计划信息
			saveApplyObj = quashAddChargeDao
					.getMMoneyDrawApplySuccessedByQuery(saveObj.getPlanid(),
							saveObj.getCustomerid());

		} else {
			msg.setMsg(CardTipConstant.TIP_QUASHADDCHARGE_GETINFO_FAULT);
			return msg;
		}

		// 充值计划信息
		if (null != saveApplyObj && saveApplyObj.getId() != null) {
			// 读卡查询验证成功
			msg.setMsg(CardTipConstant.TIP_IS_OK);

			// 封装客户、卡信息
			Customer customer = quashAddChargeDao.getByCustId(cardinfoform
					.getCustomerid());
			if (null == customer) {
				throw new BaseException(
						CardTipConstant.TIP_ADDCHARDE_GET_CUST_FAIL);
			}
			// 当前(操作员)充值员信息
			ACUserNetInfoForm currACUserInfo = quashAddChargeDao
					.getACUserNetInfo(termId, userId);

			// 封装充值记录的操作员信息（操作充值员、充值网点、终端）
			String addUserId = saveApplyObj.getEdit_person();
			String addNetId = saveObj.getNetid();
			String addPoscode = saveObj.getPoscode();
			ACUserNetInfoForm addUserInfo = quashAddChargeDao.getAddUserInfo(
					addUserId, addNetId, addPoscode);
			param.put("customer", customer);
			param.put("addUserInfo", addUserInfo);
			param.put("custCardInfo", cardinfoform);
			param.put("saveObj", saveObj);
			param.put("currACUserInfo", currACUserInfo);
			param.put("opfare", quashAddChargeDao.getCashStr(saveObj
					.getOpfare().toString(), 2));
			param.put("opDate", DateUtil.toDateTimeString(saveObj.getOpdt(),
					DateUtil.DATETIME_FORMAT));
		} else {
			msg.setMsg(CardTipConstant.TIP_QUASHADDCHARGE_GETAPPLYINFO_FAULT);
			return msg;
		}
		msg.setData(param.toString());
		return msg;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Msg reqQuashAdd(JSONObject param) {
		// 充值撤销申请成功返回消息
		Msg msg = new Msg();

		// 获取前台传入的参数
		// 卡片Mac
		String cardmac16 = param.getString("cardmac16");
		// 撤销密码(交易密码)
		String searchpwd = param.getString("searchpwd");

		// 还原读卡的数据
		JSONObject readData = param.getJSONObject("readData");

		// 还原读卡验证的数据对象
		CardInfoForm custCardInfo = JSONTools.JSONToBean(
				readData.getJSONObject("custCardInfo"), CardInfoForm.class);
		MoneySaveSuccessed saveObj = JSONTools.JSONToBean(
				readData.getJSONObject("saveObj"), MoneySaveSuccessed.class);
		// 当前充值员信息
		ACUserNetInfoForm currACUserInfo = JSONTools.JSONToBean(
				readData.getJSONObject("currACUserInfo"),
				ACUserNetInfoForm.class);
		// 卡种类1-M1 2-CPU
		String cardKind = custCardInfo.getCardkind();

		// 充值撤销密码校验
		if (!quashAddChargeDao.checkSearchPWD(searchpwd,
				custCardInfo.getAppinfoId())) {
			msg.setMsg(CardTipConstant.TIP_QUASHADDCHARGE_REQFAULT_PWDERR);
			return msg;
		}

		// 如果M1卡，请求密钥系统获取充值密钥(写卡前调用)
		if (CardConstant.CARDKIND_M1.equals(cardKind)) {
			JSONObject obj = new JSONObject();
			obj.put("method", "GetTopUpKey");
			obj.put("cardmac", cardmac16);
			obj.put("asn", custCardInfo.getAsn());
			Msg rs = eCardPreService.getECardPreServiceCity(obj);
			if (CardTipConstant.TIP_IS_OK.equals(rs.getMsg())) {
				ECardPreServiceResultForm preKeyObj = (ECardPreServiceResultForm) rs
						.getData();
				readData.put("preKeyObj", preKeyObj);
				readData.put("tacdt", preKeyObj.getOpdate());
			} else {
				msg.setMsg(CardTipConstant.TIP_QUASHADDCHARGE_REQFAULT_GETCHRKEYERR);
				return msg;
			}
		}

		/**
		 * 生成充值撤销的19位时间:<br>
		 * 1、优先使用M1卡调用密钥系统GetTopUpKey时已生成操作时间<br>
		 * 2、没有checkMac操作时，使用充值申请的时间<br>
		 * 3、前端写卡时checkTac统一使用此时间<br>
		 * 4、充值数据生成的记录统一使用此时间<br>
		 */
		String tacdt = "";
		if (readData.containsKey("tacdt")) {
			tacdt = readData.getString("tacdt");
		}
		if (tacdt.length() == 19) {
			// 有
		} else {
			tacdt = DateUtil.toDateTimeString(DateUtil.getCurrDay(),
					DateUtil.DATETIME_FORMAT);
			readData.put("tacdt", tacdt);
		}

		// 保存充值计划
		MoneyDrawApplyPlan moneyPlan = quashAddChargeDao
				.saveMoneyDrawApplyPlanForQuash(custCardInfo, saveObj, tacdt,
						currACUserInfo);

		// 充值申请计划状态变化信息
		String planId = moneyPlan.getId();
		String planstateId = quashAddChargeDao
				.saveMoneyDrawApplyStatusForQuash(custCardInfo, planId,
						moneyPlan.getDescrition(), currACUserInfo.getUserId(),
						tacdt, moneyPlan.getPoscode());

		if (planId.length() > 0 && planstateId.length() > 0) {
			readData.put("moneyPlan", moneyPlan);
			readData.put("planstateId", planstateId);
		} else {
			msg.setMsg(CardTipConstant.TIP_QUASHADDCHARGE_REQFAULT);
			return msg;
		}
		// 申请成功
		msg.setMsg(CardTipConstant.TIP_IS_OK);
		msg.setData(readData.toString());

		// 关键信息日志
		String message = "充值撤销申请>>userId:" + currACUserInfo.getUserId()
				+ "|planId:" + planId + "|planstateId:" + planstateId
				+ "|Opfare:" + saveObj.getOpfare() + "元|tacDate:" + tacdt;
		// 本地Log4J记录
		log.info(message);
		// 系统日志记录
		// logEnabled.log.info(message);
		return msg;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Msg commitQuashAdd(JSONObject param) {
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

		// 充值申请状态变化ID
		String planstateId = reqData.getString("planstateId");

		// 充值计划
		MoneyDrawApplyPlan moneyPlan = JSONTools.JSONToBean(
				reqData.getJSONObject("moneyPlan"), MoneyDrawApplyPlan.class);

		// 读卡时的数据对象
		// 还原读卡验证的数据对象
		ACUserNetInfoForm addUserInfo = JSONTools.JSONToBean(
				reqData.getJSONObject("addUserInfo"), ACUserNetInfoForm.class);
		Customer customer = JSONTools.JSONToBean(
				reqData.getJSONObject("customer"), Customer.class);
		CardInfoForm custCardInfo = JSONTools.JSONToBean(
				reqData.getJSONObject("custCardInfo"), CardInfoForm.class);
		MoneySaveSuccessed saveObj = JSONTools.JSONToBean(
				reqData.getJSONObject("saveObj"), MoneySaveSuccessed.class);
		// 当前充值员信息
		ACUserNetInfoForm currACUserInfo = JSONTools.JSONToBean(
				reqData.getJSONObject("currACUserInfo"),
				ACUserNetInfoForm.class);
		// 根据写卡结果提交或回滚数据，并作记录
		String msgTip = CardTipConstant.TIP_QUASHADDCHARGE_COMMITFAULT;
		if (CardConstant.WRITECARD_IS_YES.equals(writeFlag)) {
			// 写卡成功
			// 更新网点授权额度--额度加上(退还授权余额)
			String eauth = quashAddChargeDao.netChargeauthChangeForQuash(
					currACUserInfo, moneyPlan.getOpfare().doubleValue(),
					CardConstant.NET_AUTHCHANGE_DIR_ADD, tacdt);
			// 更新卡片当前余额
			quashAddChargeDao.updateCardMoneySumForQuash(custCardInfo
					.getAppinfoId(), moneyPlan.getOpfare().toString(),
					wcardOpCnt, wcardSaveOpCnt, wcardRec);

			// 提交充值撤销计划、及状态变化、记录存款记录
			msgTip = quashAddChargeDao.commitApllyPlanRecordForQuash(
					currACUserInfo, moneyPlan, planstateId, wcardOpCnt,
					wcardSaveOpCnt, writeFlag, tacdt, tac);

			// 修改充值记录为已撤销标示
			if (CardTipConstant.TIP_IS_OK.equals(msgTip)) {
				saveObj.setCorrect(CardConstant.QUASH_ADDCHARGE_IS_CORRECT);
				quashAddChargeDao.update(saveObj);
			}
		} else {
			if (CardConstant.WRITECARD_IS_NO.equals(writeFlag)
					|| CardConstant.WRITECARD_IS_EXCEPTION.equals(writeFlag)) {
				// 写卡失败或异常
				// 更新网点授权额度--不做修改

				// 删除充值撤销计划、及状态变化、记录存款记录
				msgTip = quashAddChargeDao.commitApllyPlanRecordForQuash(
						currACUserInfo, moneyPlan, planstateId, wcardOpCnt,
						wcardSaveOpCnt, writeFlag, tacdt, tac);
			}
		}

		// 返回数据，封装打印对象信息
		// 商户代码
		reqData.put("merchantCode", currACUserInfo.getMerchantcode());
		// 商户名称--网点名称
		reqData.put("netName", currACUserInfo.getNetname());
		// 终端编号
		reqData.put("termCode", currACUserInfo.getPoscode());
		// 操作员
		reqData.put("userName", currACUserInfo.getUserName());
		// 流水号
		reqData.put("planId", moneyPlan.getId());
		// 户名
		reqData.put("custName", customer.getName());
		// 市民卡号
		reqData.put("custCardNo", custCardInfo.getCitycardno());
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
		String message = "充值撤销提交>>userId:" + currACUserInfo.getUserId()
				+ "|planId:" + moneyPlan.getId() + "|opFare:"
				+ moneyPlan.getOpfare().doubleValue() + "元|tacDate:" + tacdt
				+ "|writeFlag:" + writeFlag;
		// 本地Log4J记录
		log.info(message);
		// 系统日志记录
		// logEnabled.log.info(message);
		return msg;
	}
}
