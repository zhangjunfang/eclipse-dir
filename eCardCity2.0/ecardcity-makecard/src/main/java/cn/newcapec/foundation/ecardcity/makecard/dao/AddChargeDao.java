/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.dao.base.CardCommonDao;
import cn.newcapec.foundation.ecardcity.makecard.model.CardMoneySum;
import cn.newcapec.foundation.ecardcity.makecard.model.Chargeauth;
import cn.newcapec.foundation.ecardcity.makecard.model.ChargeauthAcc;
import cn.newcapec.foundation.ecardcity.makecard.model.MoneyDrawApplyFailure;
import cn.newcapec.foundation.ecardcity.makecard.model.MoneyDrawApplyPlan;
import cn.newcapec.foundation.ecardcity.makecard.model.MoneyDrawApplyStatus;
import cn.newcapec.foundation.ecardcity.makecard.model.MoneyDrawApplySuccessed;
import cn.newcapec.foundation.ecardcity.makecard.model.MoneySaveFailure;
import cn.newcapec.foundation.ecardcity.makecard.model.MoneySaveSuccessed;
import cn.newcapec.foundation.ecardcity.makecard.util.ACUserNetInfoForm;
import cn.newcapec.foundation.ecardcity.makecard.util.CardCodeConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.CardConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.CardInfoForm;
import cn.newcapec.foundation.ecardcity.makecard.util.CardTipConstant;
import cn.newcapec.framework.core.utils.dataUtils.DateUtil;

/**
 * 充值业务Dao层实现
 * 
 * @author wulimo
 * 
 */
@Repository
@SuppressWarnings("all")
public class AddChargeDao extends CardCommonDao {
	/**
	 * 更新网点授权额度
	 * 
	 * @param currACUserInfo
	 *            当前充值员信息
	 * @param opFare
	 *            操作金额
	 * @param dir
	 *            变化标识：-1 减少 0 不变 1 增加
	 * @param tacdt
	 *            操作时间
	 */
	@SuppressWarnings("unchecked")
	public String netChargeauthChange(ACUserNetInfoForm currACUserInfo,
			double opFare, String dir, String tacdt) {
		String authaId = "";
		String hql = "from Chargeauth where netsiteid=? and id=? ";
		List<Chargeauth> list = find(
				hql,
				new Object[] { currACUserInfo.getNetid(),
						currACUserInfo.getBankId() });
		if (null != list && list.size() > 0) {
			Chargeauth autha = list.get(0);
			// dir变化标识：-1 减少 0 不变 1 增加
			double curoddfare = autha.getCuroddfare().doubleValue();
			double afterfare = curoddfare;
			if (CardConstant.NET_AUTHCHANGE_DIR_CUT.equals(dir)) {
				afterfare = curoddfare - opFare;
			}
			if (CardConstant.NET_AUTHCHANGE_DIR_ADD.equals(dir)) {
				afterfare = curoddfare + opFare;
			}
			autha.setCuroddfare(afterfare);
			autha.setAuthtime(DateUtil.getCurrDay());
			autha.setEdit_person(currACUserInfo.getUserId());
			autha.setEdit_date(DateUtil.toDatetime(tacdt));
			saveOrUpdate(autha);
			authaId = autha.getId();
			if (authaId.length() > 0) {
				ChargeauthAcc authaAcc = new ChargeauthAcc();
				authaAcc.setNetsiteid(currACUserInfo.getNetid());
				authaAcc.setCuroddfare(afterfare);
				authaAcc.setLastoddfare(curoddfare);
				authaAcc.setOpfare(opFare);
				authaAcc.setAllowoverdraftfare((double) 0);
				authaAcc.setMaxlimitdate((long) 3);
				authaAcc.setIsuse(autha.getIsuse());
				authaAcc.setSumfare(autha.getSumfare());
				authaAcc.setCustomerunitcode(currACUserInfo.getMerchantcode());
				authaAcc.setDir(dir);
				authaAcc.setFlag(CardConstant.DATA_ISNOT_DELETED);
				authaAcc.setEdit_person(currACUserInfo.getUserId());
				authaAcc.setEdit_date(DateUtil.getCurrDay());
				String id = (String) save(authaAcc);
				if (id.length() > 0) {
					return authaId;
				} else {
					return "";
				}
			}
		}
		return authaId;
	}

	/**
	 * 充值申请阶段--保存充值申请计划信息
	 * 
	 * @param cardInfoForm
	 * @param acUserNetInfo
	 * @param chargeMoney
	 * @param tac
	 * @param isCoat
	 * @param tacdt
	 * @return
	 */
	public MoneyDrawApplyPlan saveMoneyDrawApplyPlan(CardInfoForm cardInfoForm,
			ACUserNetInfoForm acUserNetInfo, String chargeMoney, String tac,
			String isCoat, String tacdt) {
		MoneyDrawApplyPlan moneyPlan = new MoneyDrawApplyPlan();
		moneyPlan.setCustomerid(cardInfoForm.getCustomerid());
		moneyPlan.setAsn(Long.parseLong(cardInfoForm.getAsn()));
		moneyPlan.setWallettype(cardInfoForm.getWallettype());
		moneyPlan.setCardsn(cardInfoForm.getCardsn());
		moneyPlan.setCardkind(cardInfoForm.getCardkind());
		moneyPlan.setCardtype(cardInfoForm.getCardtype());
		moneyPlan.setOddfare(Double.parseDouble(cardInfoForm.getOddfare()));
		moneyPlan.setOpfare(Double.parseDouble(chargeMoney));
		moneyPlan.setOpcount(Long.parseLong(cardInfoForm.getOpcount()));
		// 默认准备状态
		moneyPlan.setStatus("0");
		// 申请状态
		moneyPlan.setAffairstatus("1");
		moneyPlan
				.setDescrition("1".equals(isCoat) ? CardCodeConstant.ACCCODE_ADDCHARGE_COSTADD_DESC
						: CardCodeConstant.ACCCODE_ADDCHARGE_CASHADD_DESC);
		moneyPlan.setPoscode(acUserNetInfo.getPoscode());
		moneyPlan.setPsamcardno(acUserNetInfo.getPsamcardno());
		moneyPlan.setTac(tac);
		// 申请时操作计数
		moneyPlan.setPresaveopcount(Long.parseLong(cardInfoForm
				.getSaveopcount()));
		// 提交操作计数,提交后加1
		moneyPlan.setSaveopcount(Long.parseLong(cardInfoForm.getSaveopcount()));
		// 交易种类:1:消费;2:存款;3:取款;
		moneyPlan.setBusinesstype(CardCodeConstant.CODE_DICT_BUSINESSTYPE_2);
		// 交易科目
		moneyPlan
				.setAcccode("1".equals(isCoat) ? CardCodeConstant.ACCCODE_ADDCHARGE_COSTADD
						: CardCodeConstant.ACCCODE_ADDCHARGE_CASHADD);
		// 签到批次号
		moneyPlan.setTransbatno(DateUtil.getCurrDay().getTime());
		// 撤销标识，0-未撤销1-已撤销
		moneyPlan.setCorrect(CardConstant.QUASH_ADDCHARGE_NOT_CORRECT);
		moneyPlan.setEdit_person(acUserNetInfo.getUserId());
		moneyPlan.setEdit_date(DateUtil.toDatetime(tacdt));
		String planId = (String) save(moneyPlan);
		if (planId.length() == 32) {
			moneyPlan.setId(planId);
		}
		return moneyPlan;
	}

	/**
	 * 充值申请阶段--保存充值申请状态变化
	 * 
	 * @param cardInfoForm
	 * @param planId
	 * @param reason
	 * @param userName
	 * @param tacdt
	 * @param poscode
	 * @return
	 */
	public String saveMoneyDrawApplyStatus(CardInfoForm cardInfoForm,
			String planId, String reason, String userId, String tacdt,
			String poscode) {
		MoneyDrawApplyStatus planStatus = new MoneyDrawApplyStatus();
		planStatus.setPlanid(planId);
		planStatus.setCustomerid(cardInfoForm.getCustomerid());
		// 事务状态：0：初始状态，1：申请状态，2：提交，3：回滚，4：挂起
		planStatus.setOldstate("0");
		planStatus.setNewstate("1");
		planStatus.setOldaffairstatus("0");
		planStatus.setNewaffairstatus("1");
		planStatus.setReason(reason);
		planStatus.setReasoncode((long) 1);
		planStatus.setAsn(Long.parseLong(cardInfoForm.getAsn()));
		// 交易种类:1:消费;2:存款;3:取款;
		planStatus.setBusinesstype(CardCodeConstant.CODE_DICT_BUSINESSTYPE_2);
		planStatus.setCardsn(cardInfoForm.getCardsn());
		planStatus.setWallettype(cardInfoForm.getWallettype());
		// 充值交易计数
		planStatus
				.setSaveopcount(Long.parseLong(cardInfoForm.getSaveopcount()));
		// 消费操作计数
		planStatus.setOpcount(Long.parseLong(cardInfoForm.getOpcount()));
		planStatus.setPoscode(poscode);
		planStatus.setEdit_person(userId);//
		planStatus.setEdit_date(DateUtil.toDatetime(tacdt));
		return (String) save(planStatus);
	}

	/**
	 * 验证当前操作员是否有充值权限
	 * 
	 * @param userId
	 * @param sitedId
	 * @param cardKind
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String checkUserPermission(String userId, String sitedId,
			String cardKind) {
		String msg = CardTipConstant.TIP_IS_OK;
		if (null == userId || "".equals(userId)) {
			msg = CardTipConstant.TIP_GET_SYSCURRUSER_FAIL;
			return msg;
		}
		StringBuffer sqlsb = new StringBuffer();
		sqlsb.append("SELECT e.BANK_ID, ");
		sqlsb.append("       e.CASH_CARDTYPE, ");
		sqlsb.append("       e.PRIVILEGE_CASHIN, ");
		sqlsb.append("       e.PRIVILEGE_LOGIN, ");
		sqlsb.append("       c.ISUSE, ");
		sqlsb.append("       c.CURODDFARE ");
		sqlsb.append("FROM   BASE_EMPLOYEE e, ");
		sqlsb.append("       CHARGEAUTH c ");
		sqlsb.append("WHERE  e.BANK_ID = c.id ");
		sqlsb.append("       AND e.NETSITE_ID = c.NETSITEID ");
		sqlsb.append("       AND e.user_id = ? ");
		sqlsb.append("       AND e.NETSITE_ID = ? ");
		List list = sqlQueryForList(sqlsb.toString(), new Object[] { userId,
				sitedId }, null);
		if (null != list && list.size() > 0) {
			Map<String, Object> map = (Map<String, Object>) list.get(0);
			String cashType = getStr(map, "CASH_CARDTYPE");
			String cashPrivi = getStr(map, "PRIVILEGE_CASHIN");
			String isLogin = getStr(map, "PRIVILEGE_LOGIN");
			String isuse = getStr(map, "ISUSE");
			if (!CardConstant.RS_IS.equals(isLogin)) {
				msg = CardTipConstant.TIP_CURRENTUSER_NO_LOGINPRIVIT;
				return msg;
			}
			if (!CardConstant.RS_IS.equals(cashPrivi)) {
				msg = CardTipConstant.TIP_CURRENTUSER_NO_CASHADD;
				return msg;
			}
			// 可操作的卡类型由前端页面判断
			// 是否启用充值授权
			if (CardConstant.RS_IS.equals(isuse)) {
				String money = getStr(map, "CURODDFARE");
				double curoddfare = money.length() > 0 ? Double
						.parseDouble(money) : 0;
				if (curoddfare <= 0) {
					msg = CardTipConstant.TIP_CURR_NET_ODDFARE_NEED;
					return msg;
				}
			}
		} else {
			msg = CardTipConstant.TIP_CURRENTUSER_GET_CASHADD_PRIVT_FAULT;
			return msg;
		}
		return msg;
	}

	/**
	 * 检查卡充值未决
	 * 
	 * @param cardinfoform
	 *            库中卡片相关信息
	 * @param cardSaveOpCnt
	 *            卡片充值操作计数
	 * @param cardRec
	 *            卡钱包余额：分
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String checkAddUnsettled(CardInfoForm cardinfoform,
			String cardSaveOpCnt, String cardRec) {
		String msg = "OK";
		// 查询充值计划、充值状态变化记录
		StringBuffer sqlsb = new StringBuffer();
		sqlsb.append("SELECT m.ID, ");
		sqlsb.append("       m.CUSTOMERID, ");
		sqlsb.append("       m.AFFAIRSTATUS, ");
		sqlsb.append("       m.CARDSN, ");
		sqlsb.append("       m.CARDKIND, ");
		sqlsb.append("       m.BUSINESSTYPE ");
		sqlsb.append("FROM   MONEY_DRAW_APPLY_PLAN m ");
		sqlsb.append("WHERE  m.CUSTOMERID = ? ");
		sqlsb.append("       AND m.ASN = ? ");
		sqlsb.append("       AND m.CARDKIND = ? ");
		sqlsb.append("       AND m.BUSINESSTYPE = ? ");
		sqlsb.append("       AND m.ACCCODE in('1001','1006') ");
		sqlsb.append("ORDER  BY EDIT_DATE DESC ");
		List list = sqlQueryForList(sqlsb.toString(), new Object[] {
				cardinfoform.getCustomerid(), cardinfoform.getAsn(),
				cardinfoform.getCardkind(),
				CardCodeConstant.CODE_DICT_BUSINESSTYPE_2 }, null);
		// 有充值计划
		if (null != list && list.size() > 0) {
			Map<String, Object> cmap = (Map<String, Object>) list.get(0);
			// 事务状态：0：初始状态，1：申请状态，2：提交，3：回滚，4：挂起
			String affairstatus = getStr(cmap, "AFFAIRSTATUS");
			// 初始化状态---没用吧???
			if ("0".equals(affairstatus)) {

			}
			// 申请状态,充值申请完成
			if ("1".equals(affairstatus)) {
				// 卡、库操作计数一致
				if (cardSaveOpCnt.equals(cardinfoform.getSaveopcount())) {
					// 但是写卡没成功--出现充值未决
					// 未决处理办法---删除充值计划---标示充值状态变化--检查更改充值授权额度
				}

				// 卡操作计数>库中操作计数
				if (Integer.parseInt(cardSaveOpCnt) > Integer
						.parseInt(cardinfoform.getSaveopcount())) {
					// 写卡成功--但是提交失败--出现充值未决
					// 未决处理办法---提交充值申请步骤
				}
			}
		} else {
			// 没有充值计划 ----无充值未决
		}
		return msg;
	}

	/**
	 * 记录：充值申请计划提交的结果
	 * 
	 * @param moneyPlan
	 * @param netId
	 * @param writeFlag
	 * @param tacdt
	 * @param tac
	 * @return
	 */
	public String updtApplyPlanRecord(MoneyDrawApplyPlan moneyPlan,
			String netId, String writeFlag, String tacdt, String tac) {
		String id = "";
		if (CardConstant.WRITECARD_IS_YES.equals(writeFlag)) {
			MoneyDrawApplySuccessed applySuccessed = new MoneyDrawApplySuccessed();
			applySuccessed.setPlanid(moneyPlan.getId());
			applySuccessed.setCustomerid(moneyPlan.getCustomerid());
			applySuccessed.setAsn(moneyPlan.getAsn());
			applySuccessed.setWallettype(moneyPlan.getWallettype());
			applySuccessed.setCardsn(moneyPlan.getCardsn());
			applySuccessed.setCardkind(moneyPlan.getCardkind());
			applySuccessed.setCardtype(moneyPlan.getCardtype());
			applySuccessed.setOddfare(moneyPlan.getOddfare());
			applySuccessed.setOpfare(moneyPlan.getOpfare());
			applySuccessed.setOpcount(moneyPlan.getOpcount());
			applySuccessed.setStatus(moneyPlan.getStatus());
			applySuccessed.setAffairstatus(moneyPlan.getAffairstatus());
			// 记录状态 正常、灰色、MAC错误，支持8个。0x00：正常记录；0x01灰色记录；0x02MAC校验错
			applySuccessed.setRecordstatus(CardConstant.FARESTATUS_OPCODE_NOR);
			applySuccessed.setUploaddate(DateUtil.getCurrDay());
			applySuccessed.setDescrition(moneyPlan.getDescrition());
			applySuccessed.setPoscode(moneyPlan.getPoscode());
			applySuccessed.setPsamcardno(moneyPlan.getPsamcardno());
			// 交易记录流水号，用于后期分析是否丢失记录
			applySuccessed.setPostradeno(DateUtil.getCurrDay().getTime());
			// PSAM交易序号
			applySuccessed.setSamtradeno(moneyPlan.getOpcount());
			applySuccessed.setTac(moneyPlan.getTac());
			applySuccessed.setFirstdt(moneyPlan.getFirstdt());
			applySuccessed.setCreatedt(moneyPlan.getCreatedt());
			applySuccessed.setOppzwdate(moneyPlan.getOppzwdate());
			applySuccessed.setOppaccfc(moneyPlan.getOppaccfc());
			applySuccessed.setPresaveopcount(moneyPlan.getPresaveopcount());
			applySuccessed.setSaveopcount(moneyPlan.getSaveopcount());
			applySuccessed.setBusinesstype(moneyPlan.getBusinesstype());
			applySuccessed.setAcccode(moneyPlan.getAcccode());
			applySuccessed.setNetid(netId);
			applySuccessed.setEdit_person(moneyPlan.getEdit_person());
			applySuccessed.setEdit_date(DateUtil.toDatetime(tacdt));
			id = (String) save(applySuccessed);
		} else {
			MoneyDrawApplyFailure applyFailure = new MoneyDrawApplyFailure();
			applyFailure.setPlanid(moneyPlan.getId());
			applyFailure.setCustomerid(moneyPlan.getCustomerid());
			applyFailure.setAsn(moneyPlan.getAsn());
			applyFailure.setWallettype(moneyPlan.getWallettype());
			applyFailure.setCardsn(moneyPlan.getCardsn());
			applyFailure.setCardkind(moneyPlan.getCardkind());
			applyFailure.setCardtype(moneyPlan.getCardtype());
			applyFailure.setOddfare(moneyPlan.getOddfare());
			applyFailure.setOpfare(moneyPlan.getOpfare());
			applyFailure.setOpcount(moneyPlan.getOpcount());
			applyFailure.setStatus(moneyPlan.getStatus());
			applyFailure.setAffairstatus(moneyPlan.getAffairstatus());
			applyFailure.setRecordstatus(CardConstant.FARESTATUS_OPCODE_GRAY);
			applyFailure.setUploaddate(DateUtil.getCurrDay());
			applyFailure.setDescrition(moneyPlan.getDescrition());
			applyFailure.setPoscode(moneyPlan.getPoscode());
			applyFailure.setPsamcardno(moneyPlan.getPsamcardno());
			// 交易记录流水号，用于后期分析是否丢失记录
			applyFailure.setPostradeno(DateUtil.getCurrDay().getTime());
			// PSAM交易序号
			applyFailure.setSamtradeno(moneyPlan.getOpcount());
			applyFailure.setTac(moneyPlan.getTac());
			applyFailure.setFirstdt(moneyPlan.getFirstdt());
			applyFailure.setCreatedt(moneyPlan.getCreatedt());
			applyFailure.setOppzwdate(moneyPlan.getOppzwdate());
			applyFailure.setOppaccfc(moneyPlan.getOppaccfc());
			applyFailure.setPresaveopcount(moneyPlan.getPresaveopcount());
			applyFailure.setSaveopcount(moneyPlan.getSaveopcount());
			applyFailure.setBusinesstype(moneyPlan.getBusinesstype());
			applyFailure.setAcccode(moneyPlan.getAcccode());
			applyFailure.setTradno((long) 0);
			applyFailure.setIsdelete(CardConstant.DATA_ISNOT_DELETED);
			applyFailure.setEdit_person(moneyPlan.getEdit_person());
			applyFailure.setEdit_date(DateUtil.toDatetime(tacdt));
			id = (String) save(applyFailure);
		}
		return id;
	}

	/**
	 * 保存存款记录
	 * 
	 * @param moneyPlan
	 * @param netId
	 * @param writeFlag
	 * @param tacdt
	 * @param tac
	 * @return
	 */
	public String updtMoneySaveRecord(MoneyDrawApplyPlan moneyPlan,
			String netId, String writeFlag, String tacdt, String tac) {
		String id = "";
		if (CardConstant.WRITECARD_IS_YES.equals(writeFlag)) {
			MoneySaveSuccessed noneySuccessed = new MoneySaveSuccessed();
			noneySuccessed.setPlanid(moneyPlan.getId());
			noneySuccessed.setCustomerid(moneyPlan.getCustomerid());
			noneySuccessed.setAsn(moneyPlan.getAsn());
			noneySuccessed.setWallettype(moneyPlan.getWallettype());
			noneySuccessed.setCardsn(moneyPlan.getCardsn());
			noneySuccessed.setCardkind(moneyPlan.getCardkind());
			noneySuccessed.setCardtype(moneyPlan.getCardtype());
			noneySuccessed.setOddfare(moneyPlan.getOddfare());
			noneySuccessed.setOpfare(moneyPlan.getOpfare());
			noneySuccessed.setOpcount(moneyPlan.getOpcount());
			noneySuccessed.setRecordstatus(CardConstant.FARESTATUS_OPCODE_NOR);
			noneySuccessed.setUploaddate(DateUtil.getCurrDay());
			noneySuccessed.setDscrp(moneyPlan.getDescrition());
			noneySuccessed.setPoscode(moneyPlan.getPoscode());
			noneySuccessed.setSamcardno(moneyPlan.getPsamcardno());
			// 交易记录流水号，用于后期分析是否丢失记录
			noneySuccessed.setPostradeno(DateUtil.getCurrDay().getTime());
			// PSAM交易序号
			noneySuccessed.setSamtradeno(moneyPlan.getOpcount());
			// 签到批次号（交易批次号）
			noneySuccessed.setTransbatno(moneyPlan.getOpcount());
			noneySuccessed.setTac(moneyPlan.getTac());
			noneySuccessed.setSaveopcount(moneyPlan.getSaveopcount());
			noneySuccessed.setBusinesstype(moneyPlan.getBusinesstype());
			noneySuccessed.setAcccode(moneyPlan.getAcccode());
			noneySuccessed.setNetid(netId);
			noneySuccessed.setOpdt(DateUtil.toDatetime(tacdt));
			noneySuccessed.setCollectdt(DateUtil.toDatetime(tacdt));
			noneySuccessed.setStatdate(DateUtil.toDatetime(tacdt));
			noneySuccessed.setCorrect(CardConstant.QUASH_ADDCHARGE_NOT_CORRECT);
			id = (String) save(noneySuccessed);
		} else {
			MoneySaveFailure moneyFailure = new MoneySaveFailure();
			moneyFailure.setPlanid(moneyPlan.getId());
			moneyFailure.setCustomerid(moneyPlan.getCustomerid());
			moneyFailure.setAsn(moneyPlan.getAsn());
			moneyFailure.setWallettype(moneyPlan.getWallettype());
			moneyFailure.setCardsn(moneyPlan.getCardsn());
			moneyFailure.setCardkind(moneyPlan.getCardkind());
			moneyFailure.setCardtype(moneyPlan.getCardtype());
			moneyFailure.setOddfare(moneyPlan.getOddfare());
			moneyFailure.setOpfare(moneyPlan.getOpfare());
			moneyFailure.setOpcount(moneyPlan.getOpcount());
			moneyFailure.setRecordstatus(CardConstant.FARESTATUS_OPCODE_GRAY);
			moneyFailure.setUploaddate(DateUtil.getCurrDay());
			moneyFailure.setDscrp(moneyPlan.getDescrition());
			moneyFailure.setPoscode(moneyPlan.getPoscode());
			moneyFailure.setSamcardno(moneyPlan.getPsamcardno());
			// 交易记录流水号，用于后期分析是否丢失记录
			moneyFailure.setPostradeno(DateUtil.getCurrDay().getTime());
			// PSAM交易序号
			moneyFailure.setSamtradeno(moneyPlan.getOpcount());
			// 签到批次号（交易批次号）
			moneyFailure.setTransbatno(moneyPlan.getOpcount());
			moneyFailure.setTac(moneyPlan.getTac());
			moneyFailure.setSaveopcount(moneyPlan.getSaveopcount());
			moneyFailure.setBusinesstype(moneyPlan.getBusinesstype());
			moneyFailure.setAcccode(moneyPlan.getAcccode());
			moneyFailure.setNetid(netId);
			moneyFailure.setOpdt(DateUtil.toDatetime(tacdt));
			moneyFailure.setCollectdt(DateUtil.toDatetime(tacdt));
			moneyFailure.setStatdate(DateUtil.toDatetime(tacdt));
			moneyFailure.setBadrecid("0");
			id = (String) save(moneyFailure);
		}
		return id;
	}

	/**
	 * 更新当前卡应用金额表(存款操作)
	 * 
	 * @param appinfoId
	 * @param opfare
	 *            存款额
	 * @param wcardOpCnt
	 *            存款写卡后操作计数
	 * @param wcardSaveOpCnt
	 *            存款写卡后操作计数
	 * @param wcardRec
	 *            存款写卡后卡余额
	 */
	@SuppressWarnings("unchecked")
	public boolean updateCardMoneySum(String appinfoId, String opfare,
			String wcardOpCnt, String wcardSaveOpCnt, String wcardRec) {
		String hql = "from CardMoneySum where appinfo_id=? ";
		List<CardMoneySum> list = find(hql, new Object[] { appinfoId });
		if (null != list && list.size() > 0) {
			CardMoneySum cardMoneySum = list.get(0);
			// 消费操作计数
			cardMoneySum.setOpcount(Long.parseLong(wcardOpCnt));
			// 存款操作计数
			cardMoneySum.setSaveopcount(Long.parseLong(wcardSaveOpCnt));
			// 交易后卡余额
			cardMoneySum.setOddfare(Double.parseDouble(wcardRec) / 100);
			// oddfareacc;// 系统余额
			cardMoneySum.setOddfareacc(cardMoneySum.getOddfareacc()
					.doubleValue() + Double.parseDouble(opfare));
			// umaddfare;// 加款额累加
			cardMoneySum.setSumsave(Double.parseDouble(opfare)
					+ cardMoneySum.getSumaddfare().doubleValue());
			// sumsave;// 存款累加
			cardMoneySum.setSumsave(Double.parseDouble(opfare)
					+ cardMoneySum.getSumsave().doubleValue());
			saveOrUpdate(cardMoneySum);
			return true;
		}
		return false;
	}

	/**
	 * 提交充值计划、及状态变化、记录存款记录
	 * 
	 * @param netId
	 * @param planId
	 * @param planstateId
	 * @param wcardOpCnt
	 * @param wcardSaveOpCnt
	 * @param writeFlag
	 * @param tacdt
	 * @param tac
	 * @return
	 */
	public String commitApllyPlanRecord(String netId, String planId,
			String planstateId, String wcardOpCnt, String wcardSaveOpCnt,
			String writeFlag, String tacdt, String tac) {
		String msg = CardTipConstant.TIP_ADDCHARDE_COMMITCHASHTOWALLET_FAIL;
		if (planId.length() > 0 && planstateId.length() > 0) {
		} else {
			msg = msg + "[参数错]";
			return msg;
		}
		// 记录：更改充值申请计划
		MoneyDrawApplyPlan moneyPlan = get(MoneyDrawApplyPlan.class, planId);
		if (null != moneyPlan) {
			// 事务状态：0：初始状态，1：申请状态，2：提交，3：回滚，4：挂起
			if (CardConstant.WRITECARD_IS_YES.equals(writeFlag)) {
				moneyPlan.setAffairstatus("2");
			} else {
				moneyPlan.setAffairstatus("3");
			}
			// 提交操作计数,提交后加1
			moneyPlan.setOpcount(Long.parseLong(wcardOpCnt));
			moneyPlan.setSaveopcount(Long.parseLong(wcardSaveOpCnt));
			moneyPlan.setEdit_date(DateUtil.toDatetime(tacdt));
			moneyPlan.setTac(tac);
			saveOrUpdate(moneyPlan);

		} else {
			msg = msg + "[充值申请记录异常]";
			return msg;
		}
		// 记录：记录充值申请计划状态变化
		MoneyDrawApplyStatus planStatusOld = get(MoneyDrawApplyStatus.class,
				planstateId);
		String statuId = "";
		if (null != planStatusOld) {
			MoneyDrawApplyStatus planStatus = new MoneyDrawApplyStatus();
			planStatus.setPlanid(planId);
			planStatus.setCustomerid(planStatusOld.getCustomerid());
			// 事务状态：0：初始状态，1：申请状态，2：提交，3：回滚，4：挂起
			planStatus.setOldstate(planStatusOld.getNewstate());
			// 状态迁移前事务状态
			planStatus.setOldaffairstatus(planStatusOld.getNewaffairstatus());
			if (CardConstant.WRITECARD_IS_YES.equals(writeFlag)) {
				// 迁移到的补助状态
				planStatus.setNewstate("2");
				// 当前事务状态
				planStatus.setNewaffairstatus("2");
			} else {
				planStatus.setNewstate("3");
				planStatus.setNewaffairstatus("3");
			}
			planStatus.setReason(planStatusOld.getReason());
			planStatus.setReasoncode(planStatusOld.getReasoncode());
			planStatus.setAsn(planStatusOld.getAsn());
			// 交易种类:1:消费;2:存款;3:取款;
			planStatus.setBusinesstype(planStatusOld.getBusinesstype());
			planStatus.setCardsn(planStatusOld.getCardsn());
			planStatus.setWallettype(planStatusOld.getWallettype());
			// 充值交易计数
			planStatus.setSaveopcount(Long.parseLong(wcardSaveOpCnt));
			// 消费操作计数
			planStatus.setOpcount(Long.parseLong(wcardOpCnt));
			planStatus.setEdit_person(planStatusOld.getEdit_person());//
			planStatus.setEdit_date(DateUtil.toDatetime(tacdt));
			planStatus.setPoscode(planStatusOld.getPoscode());
			statuId = (String) save(planStatus);
		} else {
			msg = msg + "[充值申请状态记录异常]";
			return msg;
		}
		if (!(statuId.length() > 0)) {
			msg = msg + "[充值申请状态记录异常]";
			return msg;
		}
		// 记录：充值申请计划提交的结果
		String planRecod = updtApplyPlanRecord(moneyPlan, netId, writeFlag,
				tacdt, tac);
		if (!(planRecod.length() > 0)) {
			msg = msg + "[提交记录异常]";
			return msg;
		}
		// 记录：存款记录
		String moneyRecod = updtMoneySaveRecord(moneyPlan, netId, writeFlag,
				tacdt, tac);
		if (!(moneyRecod.length() > 0)) {
			msg = msg + "[存款记录异常]";
			return msg;
		}
		// 删除充值计划表记录
		delete(moneyPlan);
		return CardTipConstant.TIP_IS_OK;
	}

}
