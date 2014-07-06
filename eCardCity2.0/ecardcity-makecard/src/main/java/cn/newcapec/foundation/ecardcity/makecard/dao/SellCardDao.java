/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.dao.base.CardCommonDao;
import cn.newcapec.foundation.ecardcity.makecard.model.CardAnnualInspection;
import cn.newcapec.foundation.ecardcity.makecard.model.CardAppinfo;
import cn.newcapec.foundation.ecardcity.makecard.model.CardMakes;
import cn.newcapec.foundation.ecardcity.makecard.model.CardMoneySum;
import cn.newcapec.foundation.ecardcity.makecard.model.Customer;
import cn.newcapec.foundation.ecardcity.makecard.model.FareCost;
import cn.newcapec.foundation.ecardcity.makecard.util.CardConstant;
import cn.newcapec.framework.core.utils.dataUtils.DateUtil;
import cn.newcapec.framework.core.utils.encryptUtils.MD5;

/**
 * 售卡业务Dao层实现
 * 
 * @author wulimo
 * 
 */
@Repository
@SuppressWarnings("all")
public class SellCardDao extends CardCommonDao {
	public void delCustomer(Serializable id) {
		delete((Object) get(id));
	}

	public void delCustomerByCustId(String custid) {
		String hql = " from Customer where customerid? ";
		List<Customer> list = find(hql, new Object[] { Long.parseLong(custid) });
		if (null != list && list.size() > 0) {
			delete(list.get(0));
		}
	}

	/**
	 * 获取客户新账号(序列)
	 * 
	 * @return
	 */
	public long getCustomerNxetID() {
		BigDecimal custId = (BigDecimal) sqlFindObject(
				"SELECT SEQ_NEWCITY_CUSTOMERID.NEXTVAL FROM DUAL ",
				new Object[] {});
		return custId.longValue();
	}

	/**
	 * 证件号码获取客户信息
	 * 
	 * @param idCardNo
	 * @return
	 */
	public Customer getCustomerByIDCardNo(String idCardNo) {
		String ahql = "from Customer where idcardno=? ";
		List<Customer> list = find(ahql, new Object[] { idCardNo });
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 市民卡号获取卡应用信息<br>
	 * (市民卡号是否被占用)
	 * 
	 * @param citycardno
	 * @return
	 */
	public List getCardAppinfoByCitycardno(String citycardno) {
		String ahql = "from CardAppinfo where citycardno=? ";
		return find(ahql, new Object[] { citycardno });
	}

	/**
	 * 卡唯一号 物理号判断卡片在系统中发过卡
	 * 
	 * @param snr
	 * @return
	 */
	public List getCardMakesBySnr(String snr) {
		String ahql = "from CardMakes where scardsnr=? ";
		return find(ahql, new Object[] { snr });
	}

	/**
	 * 当前客户发过的指定类型的卡片
	 * 
	 * @param custId
	 * @param cardKind
	 * @param cardType
	 * @return
	 */
	public List<CardMakes> getCardMakesByTypes(String custId, String cardKind,
			String cardType) {
		String ahql = "from CardMakes where customerid=? and cardkind=? and cardtype=? ";
		return find(ahql, new Object[] { custId, cardKind, cardType });
	}

	/**
	 * 保存制卡信息
	 * 
	 * @param custId
	 * @param asn
	 * @param snr
	 * @param cardKind
	 * @param cardType
	 * @param userId
	 * @param sn
	 * @return
	 */
	public CardMakes saveCardMake(String custId, long asn, String snr,
			String cardKind, String cardType, String userId, long sn) {
		// 获取持卡序号
		if (sn == 1) {
			// 第一张卡片
		} else {
			String sql = "select nvl(t.cardsn,0) from card_makes t where t.customerid=? ";
			BigDecimal cardsn = (BigDecimal) sqlFindObject(sql,
					new Object[] { custId });
			sn = cardsn.longValue() + 1;
		}
		CardMakes cardMake = new CardMakes();
		cardMake.setCustomerid(custId);
		cardMake.setAsn(asn);
		cardMake.setOld_asn(null);
		cardMake.setCardsn(sn);
		cardMake.setScardsnr(snr);
		cardMake.setPty(CardConstant.SELLCARED_TYPE_PTY0);// 发卡类型
		cardMake.setWallettype(CardConstant.WALLETTYPE_DEFAULT1);// 钱包类型(8个)默认1
		cardMake.setCardkind(cardKind);
		cardMake.setCardtype(cardType);
		cardMake.setEdit_person(userId);
		cardMake.setEdit_date(DateUtil.getCurrDay());
		return merge(cardMake);
	}

	/**
	 * 发卡申请时新建客户信息，标示客户为休眠状态
	 * 
	 * @param customer
	 * @return
	 */
	public String checkAndSaveCustomer(Customer customer) {
		if (null == customer || "".equals(customer)
				|| null == customer.getCustomerid()) {
			customer.setCustomerid(getCustomerNxetID());
		}

		customer.setStatus(CardConstant.CUST_CARDSTATUS_START);
		customer.setVer(1);
		customer.setEmail(customer.getEmail() == null ? "" : (customer
				.getEmail().contains("@") ? customer.getEmail() : ""));
		return (String) save(customer);
	}

	/**
	 * 生成卡应用信息
	 * 
	 * @param customer
	 * @param makeCard
	 * @param cardno
	 * @param asPwd
	 * @param sConsumePWD
	 * @param nidFlag
	 * @return
	 */
	public CardAppinfo saveCardAppInfo(Customer customer, CardMakes makeCard,
			String cardno, String asPwd, String sConsumePWD, String nidFlag) {
		CardAppinfo appInfo = new CardAppinfo();
		appInfo.setCustomerid(customer.getCustomerid().toString());
		appInfo.setAsn(makeCard.getAsn());
		appInfo.setCitycardno(cardno);
		appInfo.setScardsnr(makeCard.getScardsnr());
		appInfo.setCardsn(makeCard.getCardsn());
		appInfo.setCardkind(makeCard.getCardkind());// 【原：卡种类 1：M1卡 2：CPU卡】
		appInfo.setCardtype(makeCard.getCardtype());// 卡类型 A卡B卡
		appInfo.setCardstatus(CardConstant.CUST_CARDSTATUS_NOR);
		appInfo.setFlag(CardConstant.RESELLCARED_IS_NOT_PUTIN);// 转款标记（补卡、换卡，老卡上的金额是否转入新卡）0：没有转
																// 1：已转入
		appInfo.setCardflag(CardConstant.CARD_FLAG_NOR);
		appInfo.setCarduse((long) 0);// 保留，标记卡用途（指哪个行业应用），卡空间规划有，直接从卡上取，行业代码，4个数字，00-城市通，01-公交，......
		appInfo.setPwd(MD5.MD5Encode(asPwd));// 个人密码--卡片的个人身份密码
		appInfo.setLossdt(null);
		appInfo.setSearchpwd(MD5.MD5Encode(sConsumePWD));// 查询密码--交易密码--卡片的消费密码
		appInfo.setVer((long) 1);
		appInfo.setMark_name(nidFlag);// 是否记名卡，根据字典类别查找并引用 默认0-记名，1-不记名
		appInfo.setIs_annual_inspection(CardConstant.YEAR_CHECK_NO_NEED);// 是否需要年检
																			// 0：不需要
																			// 1：需要
		int year = DateUtil.getYear(DateUtil.getCurrDay());
		appInfo.setAnnual_inspection_start(DateUtil.toDate((year + 20)
				+ "-01-01"));
		appInfo.setAnnual_inspection_end(DateUtil
				.toDate((year + 20) + "-12-31"));
		appInfo.setEdit_person(makeCard.getEdit_person());
		appInfo.setEdit_date(makeCard.getEdit_date());
		return merge(appInfo);
	}

	/**
	 * 身份证号码生成个人卡密码<br>
	 * 去后6位，最后一位X用*代替
	 * 
	 * @param idcardno
	 * @return
	 */
	public String getCardPWDByIdcardno(String idcardno) {
		String rs = "";
		if (idcardno.length() == 15) {
			rs = idcardno.substring(12);
		}
		if (idcardno.length() == 18) {
			rs = idcardno.substring(9);
		}
		rs = rs.toUpperCase().replaceAll("X", "*");
		return rs;
	}

	/**
	 * 生成售卡卡片手续费
	 * 
	 * @param makeCard
	 * @param accfare
	 * @return
	 */
	public String saveFareCost(CardMakes makeCard, double accfare,
			String acccode, String dscrp) {
		FareCost fareCost = new FareCost();
		fareCost.setCustomerid(makeCard.getCustomerid());
		fareCost.setAsn(makeCard.getAsn());
		fareCost.setAcccode(acccode);// 科目代码
		fareCost.setDscrp(dscrp);// 代码描述
		fareCost.setHasreturn("0");// 是否已退卡成本 0：初始值 2：已退
		fareCost.setCardkind(makeCard.getCardkind());
		fareCost.setCardtype(makeCard.getCardtype());
		fareCost.setAccfare(accfare);// 应收金额
		fareCost.setIscharge("1");// 是否收费，0系统规定不收费，1收费 2 出纳员不收费
		fareCost.setOpfare(fareCost.getIscharge().equals("1") ? accfare : 0.00);// 交易金额
		fareCost.setEdit_person(makeCard.getEdit_person());
		fareCost.setEdit_date(makeCard.getEdit_date());
		return merge(fareCost).getId();
	}

	/**
	 * 初始化卡余额信息
	 * 
	 * @param makeCard
	 * @param appInfoId
	 * @return
	 */
	public String saveCardMoneySum(CardMakes makeCard, String appInfoId) {
		CardMoneySum cardMoneySum = new CardMoneySum();
		cardMoneySum.setAppinfo_id(appInfoId);// 卡信息表id
		cardMoneySum.setWallettype(makeCard.getWallettype());// 钱包类型
		cardMoneySum.setOpcount((long) 0);// 消费操作计数（交易后）
		cardMoneySum.setSaveopcount((long) 0);// 存款操作计数（交易后）
		cardMoneySum.setOddfare(0.00);// 卡余额（交易后）
		cardMoneySum.setOddfareacc(0.00);// 系统余额
		cardMoneySum.setSumconsumefare(0.00);// 消费额累加
		cardMoneySum.setSumaddfare(0.00);// 消费额累加
		cardMoneySum.setSumqc(0.00);// 圈存累加
		cardMoneySum.setSumload(0.00);// 取款累加
		cardMoneySum.setSumsave(0.00);// 存款累加
		return merge(cardMoneySum).getId();

	}

	/**
	 * 卡年检
	 * 
	 * @param psamcardno
	 * @param appInfo
	 * @return
	 */
	public String cardYearCheck(String psamcardno, CardAppinfo appInfo) {
		String ycResult = "0";
		if (CardConstant.YEAR_CHECK_NEED.equals(appInfo
				.getIs_annual_inspection())) {
			ycResult = CardConstant.YEAR_CHECK_NEED;
			CardAnnualInspection yc = new CardAnnualInspection();
			yc.setPoscode(psamcardno);
			yc.setAsn(appInfo.getAsn());
			yc.setAnnual_inspection_result(ycResult);
			yc.setPre_annual_inspection_start(appInfo
					.getAnnual_inspection_start());
			yc.setPre_annual_inspection_end(appInfo.getAnnual_inspection_end());
			yc.setEdit_person(appInfo.getEdit_person());
			yc.setEdit_date(appInfo.getEdit_date());
			return merge(yc).getId();
		}
		return psamcardno;
	}
}
