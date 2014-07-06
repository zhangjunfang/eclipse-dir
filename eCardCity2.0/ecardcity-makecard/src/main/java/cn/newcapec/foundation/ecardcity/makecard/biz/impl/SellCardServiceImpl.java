/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.biz.impl;

import java.io.Serializable;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.foundation.ecardcity.makecard.biz.SellCardService;
import cn.newcapec.foundation.ecardcity.makecard.dao.SellCardDao;
import cn.newcapec.foundation.ecardcity.makecard.model.CardAppinfo;
import cn.newcapec.foundation.ecardcity.makecard.model.CardMakes;
import cn.newcapec.foundation.ecardcity.makecard.model.CardType;
import cn.newcapec.foundation.ecardcity.makecard.model.Customer;
import cn.newcapec.foundation.ecardcity.makecard.model.NetSite;
import cn.newcapec.foundation.ecardcity.makecard.model.TermInfo;
import cn.newcapec.foundation.ecardcity.makecard.util.CardCodeConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.CardConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.CardTipConstant;
import cn.newcapec.framework.core.rest.Msg;
import cn.newcapec.framework.core.utils.dataUtils.DateUtil;
import cn.newcapec.framework.core.utils.jsonUtils.JSONTools;

/**
 * 售卡业务接口实现类
 * 
 * @author wulimo
 * 
 */
@Service("sellCardService")
@Transactional
@SuppressWarnings("all")
public class SellCardServiceImpl implements SellCardService {

	private static final Logger log = Logger
			.getLogger(SellCardServiceImpl.class);

	@Autowired
	private SellCardDao sellCardDao;

	@Override
	public Customer get(String id) {
		return sellCardDao.get(id);
	}

	@Override
	public void removeUnused(String id) {

	}

	@Override
	public void saveOrUpdate(Customer customer) {
		sellCardDao.saveOrUpdate(customer);
	}

	@Override
	public void delCustomer(Serializable id) {
		sellCardDao.delCustomer(id);
	}

	@Override
	public long getCustomerNxetID() {
		return sellCardDao.getCustomerNxetID();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Customer getCustomerByIDCardNo(String idCardNo) {
		return sellCardDao.getCustomerByIDCardNo(idCardNo);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public boolean isUsedCityCardNo(String cityCardNo) {
		return sellCardDao.getCardAppinfoByCitycardno(cityCardNo).size() > 0;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public boolean isSelledCard(String snr) {
		return sellCardDao.getCardMakesBySnr(snr).size() > 0;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public boolean isSelledKindCard(String custId, String cardKind,
			String cardType) {
		return sellCardDao.getCardMakesByTypes(custId, cardKind, cardType)
				.size() > 0;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public String getNewCityCardNo(long custId, String asn16) {
		String rs = "";
		if (asn16.length() > 4) {
			rs = asn16.substring(0, 4);
		}
		return rs + custId;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Msg readCardForSellCard(JSONObject param) {
		// 售卡读卡验证--返回信息
		Msg msg = new Msg();
		// 获取前台传入的参数
		// 当前用户及时消息中传入
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
		// 当前可操作的售卡类型
		String saleCardtype = param.getString("saleCardtype");

		// 参数值空验证
		if (psamcardno.equals("") || snr.equals("") || asn.equals("")) {
			msg.setMsg(CardTipConstant.TIP_ADDCHARDE_READCARDREQ_FAIL);
			return msg;
		}

		// 查询终端，验证终端合法性，是否启用了授权
		// 终端合法查询网点信息
		TermInfo termInfo = sellCardDao.getTermInfoBySamcard(Long
				.parseLong(psamcardno));

		// 终端ID
		String termId = termInfo.getTermid().toString();

		// 当前所属网点信息
		NetSite netSite = null;
		if (null != termInfo) {
			String terTip = sellCardDao.checkTermPsamCard(termInfo, psamcardno);
			if (CardTipConstant.TIP_IS_OK.equals(terTip)) {
				netSite = sellCardDao.getNetSite(termInfo.getSiteid());
			} else {
				msg.setMsg(terTip);
				return msg;
			}
		} else {
			msg.setMsg(CardTipConstant.TIP_ADDCHARDE_NOT_THIS_TERM);
			return msg;
		}

		// 验证网点信息，网点合法查询用户权限
		if (null != netSite
				&& CardConstant.STATUS_NOR.equals(netSite.getNetstatus())) {
			// 验证当前操作员是否有售卡权限
			if ("".equals(saleCardtype) || saleCardtype.length() == 0) {
				msg.setMsg(CardTipConstant.TIP_DONOT_CAN_OP_CARD);
				return msg;
			}
		} else {
			msg.setMsg(CardTipConstant.TIP_ADDCHARDE_NETSTATUS_STOP);
			return msg;
		}

		// 当前卡片是否被使用过
		if (isSelledCard(snr)) {
			msg.setMsg(CardTipConstant.TIP_SELLCARD_ISUSED);
			return msg;
		}

		// 读卡验证成功
		msg.setMsg(CardTipConstant.TIP_IS_OK);

		// 生成客户卡号
		long custId = getCustomerNxetID();
		String cityCardNo = getNewCityCardNo(custId, asn16);
		// 携带参数
		param.put("userId", userId);
		param.put("asn", asn);
		param.put("custId", custId);
		param.put("cityCardNo", cityCardNo);
		msg.setData(param.toString());
		return msg;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Msg reqSellChard(JSONObject param) {
		// 售卡申请成功返回消息
		Msg msg = new Msg();

		// 获取前台传入的参数
		// 充值金额
		String chargeMoney = param.getString("chargeMoney");
		// 卡成本
		String cardCost = param.getString("cardCost");
		// 管理费(手续费)
		String manageCost = param.getString("manageCost");
		// 卡套费
		String cardTaoCoat = param.getString("cardTaoCoat");
		// tac
		String tac = param.getString("tac");
		// 填写的市民卡号
		String cardno = param.getString("cardno");
		// 填写的身份证号码
		String idcardno = param.getString("idcardno");
		// 选择的卡类型A卡B卡
		String cardType = param.getString("cardtype");

		// 生成:个人密码--卡片的个人身份密码
		String asPwd = sellCardDao.getCardPWDByIdcardno(idcardno);
		param.put("asPwd", asPwd);

		// 统一消费密码:消费密码--查询密码--交易密码
		if (param.containsKey("onecunsumepassword")) {
			param.put("sConsumePWD", param.getString("onecunsumepassword")
					.equals("1") ? "888888" : asPwd);
		} else {
			param.put("sConsumePWD", idcardno.substring(0, 6));
		}

		// 不记名
		if (param.containsKey("noname")
				&& param.getString("noname").equals("1")) {
			param.put("nidFlag", 1);
		} else {
			param.put("nidFlag", 0);
		}
		// 还原读卡时的数据
		JSONObject readData = param.getJSONObject("readData");
		// 当前登录用户
		String userId = readData.getString("userId");
		// 客户编号
		String custId = readData.getString("custId");
		// 客户卡号(读卡验证是空卡时生成的市民卡号)
		String cityCardNo = readData.getString("cityCardNo");
		// 卡应用序列号ASN16进制
		String asn16 = readData.getString("asn16");
		// 卡应用序列号ASN10进制
		long asn = Long.parseLong(asn16, 16);
		// 卡唯一号/物理卡号
		String snr = readData.getString("snr");
		// 卡种类1-M1 2-CPU
		String cardKind = readData.getString("cardKind");
		// 当前可操作的售卡类型
		String saleCardtype = readData.getString("saleCardtype");
		if (saleCardtype.length() > 0) {
			if (("," + saleCardtype + ",").indexOf("," + cardType + ",") == -1) {
				msg.setMsg(CardTipConstant.TIP_DONOT_CAN_OP_CARD);
				return msg;
			}
		}

		// 市民卡号是否被使用(使用读卡生成的卡号不验证)
		if (cityCardNo.equals(cardno)) {
			// OK
		} else {
			msg.setMsg(CardTipConstant.TIP_SELLCARD_REQ_CARDNO_USED);
			return msg;
		}

		// 验证客户信息(身份证号定位此客户信息是否存在或已发过卡片)
		Customer oldCust = getCustomerByIDCardNo(idcardno);
		if (null != oldCust && oldCust.getId() != null) {
			if (isSelledKindCard(oldCust.getCustomerid().toString(), cardKind,
					cardType)) {
				msg.setMsg(CardTipConstant.TIP_SELLCARD_REQ_CUST_HAVE_KINDCARD);
				return msg;
			} else {
				// 此客户信息存在(但未发过此类卡)
				// 保存制卡信息
				CardMakes makeCard = sellCardDao.saveCardMake(oldCust
						.getCustomerid().toString(), asn, snr, cardKind,
						cardType, userId, 0);
				param.put("makeCard", makeCard);
				param.put("custId", oldCust.getId());
			}
		} else {
			// 无此客户信息
			Customer customer = JSONTools.JSONToBean(param, Customer.class);
			customer.setCustomerid(Long.parseLong(custId));
			customer.setEdit_person(userId);
			customer.setEdit_date(DateUtil.getCurrDay());
			if (param.get("nidFlag").equals("1")) {
				// 不记名
				customer.setName("BJM" + cardno);
				customer.setJpdm("BJM");
			}
			String cid = sellCardDao.checkAndSaveCustomer(customer);
			if (cid.length() > 0) {
				// 保存制卡信息
				CardMakes makeCard = sellCardDao.saveCardMake(custId, asn, snr,
						cardKind, cardType, userId, 1);
				param.put("makeCard", makeCard);
				param.put("custId", custId);
			} else {
				sellCardDao.delete(customer);
				msg.setMsg(CardTipConstant.TIP_SELLCARD_REQ_CUST_SAVECUST_FAIL);
				return msg;
			}
		}

		// 售卡申请计划
		// 售卡时间19位
		String reqdt = DateUtil.toDateTimeString(DateUtil.getCurrDay(),
				DateUtil.DATETIME_FORMAT);
		param.put("reqdt", reqdt);
		msg.setMsg(CardTipConstant.TIP_IS_OK);
		msg.setData(param.toString());

		// 关键信息日志记录
		log.info("售卡申请>>userId:" + userId + "|custId:"
				+ param.getString("custId") + "|idcardno:" + idcardno
				+ "|psamcardno:" + readData.getString("psamcardno") + "|snr:"
				+ snr + "|asn:" + asn + "|cardno:" + cardno + "|cardCost:"
				+ cardCost + "|manageCost:" + manageCost + "|cardTaoCoat:"
				+ cardTaoCoat + "|reqdt:" + reqdt);
		return msg;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Msg commitSellChard(JSONObject param) {
		// 售卡提交成功返回消息
		Msg msg = new Msg();

		// 获取前台传入的参数
		// 售卡写卡是否成功
		String writeFlag = param.getString("writeFlag");
		// psam卡号
		String psamcardno = param.getString("psamcardno");

		// 还原读卡时的数据
		JSONObject reqData = param.getJSONObject("reqData");
		// 制卡信息
		CardMakes makeCard = JSONTools.JSONToBean(
				reqData.getJSONObject("makeCard"), CardMakes.class);
		// 持卡序号
		long cardsn = makeCard.getCardsn();
		// 发卡的客户编号
		String custId = reqData.getString("custId");
		// 市民卡号(一个应用对应一个)
		String cardno = reqData.getString("cardno");

		// 生成收费信息
		// 卡成本
		String cardCost = reqData.getString("cardCost");
		// 管理费
		String manageCost = reqData.getString("manageCost");
		// 卡套费
		String cardTaoCoat = reqData.getString("cardTaoCoat");
		// 售卡申请时间19位标准时间
		String reqdt = reqData.getString("reqdt");
		// 当前售卡客户
		Customer customer = sellCardDao.getByCustId(custId);
		// 根据写卡结果提交或回滚数据，并作记录

		// 写卡成功
		if (CardConstant.WRITECARD_IS_YES.equals(writeFlag)) {
			// 当前发卡为第一张卡
			if (cardsn == 1) {
				// 更新客户状态
				customer.setStatus(CardConstant.CUST_CARDSTATUS_NOR);
				sellCardDao.update(customer);
			} else if (cardsn > 1) {
				// 当前发卡不是该客户的第一张
			}

			// 生成卡应用信息
			// 消费密码--查询密码--交易密码
			String sConsumePWD = reqData.getString("sConsumePWD");
			// 个人密码--卡片的个人身份密码
			String asPwd = reqData.getString("asPwd");
			// 是否不记名 0-记名1-不记名
			String nidFlag = reqData.getString("nidFlag");
			CardAppinfo appInfo = sellCardDao.saveCardAppInfo(customer,
					makeCard, cardno, asPwd, sConsumePWD, nidFlag);
			if (null == appInfo || appInfo.getId() == null) {
				if (cardsn == 1) {
					// 删除客户
					sellCardDao.delete(customer);
				}
				// 删除制卡信息
				sellCardDao.delete(makeCard);
				// 返回，卡应用信息失败
				msg.setMsg(CardTipConstant.TIP_SELLCARD_COMMIT_SAVEAPP_FAIL);
				return msg;
			} else {

				// 应收金额
				double accfare = Double.parseDouble(cardCost)
				// + Double.parseDouble(manageCost)
						+ Double.parseDouble(cardTaoCoat);
				// 开户卡成本费(含卡套费)
				String fareId = sellCardDao.saveFareCost(makeCard, accfare,
						CardCodeConstant.ACCCODE_SELLCARD_NEWCARDFARE,
						CardCodeConstant.ACCCODE_SELLCARD_NEWCARDFARE_DESC);
				// 手续费(管理费)
				String fareId1 = sellCardDao.saveFareCost(makeCard,
						Double.parseDouble(manageCost),
						CardCodeConstant.ACCCODE_SELLCARD_OPPFARE,
						CardCodeConstant.ACCCODE_SELLCARD_OPPFARE_DESC);

				// 初始化卡余额信息
				String cardMoneySumId = sellCardDao.saveCardMoneySum(makeCard,
						appInfo.getId());

				// 年检判断
				String yc = sellCardDao.cardYearCheck(psamcardno, appInfo);
				if (fareId.length() > 0 && fareId1.length() > 0
						&& yc.length() > 0) {

				} else {
					if (cardsn == 1) {
						// 删除客户
						sellCardDao.delete(customer);
					}
					// 删除制卡信息
					sellCardDao.delete(makeCard);

					// 返回，卡应用信息失败
					msg.setMsg(CardTipConstant.TIP_SELLCARD_COMMIT_FAIL);
					return msg;
				}
			}
		} else {
			// 当前发卡为第一张卡
			if (cardsn == 1) {
				// 删除客户
				sellCardDao.delete(customer);
			}
			// 删除制卡信息
			sellCardDao.delete(makeCard);
		}

		// 售卡提交
		msg.setMsg(CardTipConstant.TIP_IS_OK);
		msg.setData(param.toString());

		// 关键信息日志记录
		log.info("售卡提交>>userId:" + makeCard.getEdit_person() + "|custId:"
				+ custId + "|idcardno:" + customer.getIdcardno()
				+ "|psamcardno:" + psamcardno + "|snr:"
				+ makeCard.getScardsnr() + "|asn:" + makeCard.getAsn()
				+ "|cardno:" + cardno + "|reqdt:" + reqdt + "|cardCost:"
				+ cardCost + "|manageCost:" + manageCost + "|cardTaoCoat:"
				+ cardTaoCoat + "|writeFlag:" + writeFlag);
		return msg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.AddChargeService#
	 * getSellCardTypes()
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<CardType> getSellCardTypes() {
		return sellCardDao
				.getCardTypeByGroupId(CardCodeConstant.CODE_CARDTYPEGROUP_0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.SellCardService#
	 * getDictListByCode(java.lang.String)
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List getDictListByCode(String code) {
		return sellCardDao.getDictListByCode(code);
	}
}
