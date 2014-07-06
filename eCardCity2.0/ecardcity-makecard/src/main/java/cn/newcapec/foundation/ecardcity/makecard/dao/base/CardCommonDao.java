/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.dao.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.model.CardAppinfo;
import cn.newcapec.foundation.ecardcity.makecard.model.CardType;
import cn.newcapec.foundation.ecardcity.makecard.model.Customer;
import cn.newcapec.foundation.ecardcity.makecard.model.NetSite;
import cn.newcapec.foundation.ecardcity.makecard.model.TermInfo;
import cn.newcapec.foundation.ecardcity.makecard.util.ACUserNetInfoForm;
import cn.newcapec.foundation.ecardcity.makecard.util.CardCodeConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.CardConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.CardInfoForm;
import cn.newcapec.foundation.ecardcity.makecard.util.CardTipConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.UserBizTotalMsgForm;
import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;

/**
 * 卡片业务相关的数据操作类
 * 
 * @author wulimo
 * 
 */
@Repository
@SuppressWarnings("all")
public class CardCommonDao extends HibernateEntityDao {
	@Override
	protected Class getReferenceClass() {
		return Customer.class;
	}

	public Customer get(Serializable key) {
		return (Customer) get(getReferenceClass(), key);
	}

	public Customer getByCustId(String customerid) {
		if (null == customerid || customerid.length() <= 0)
			return null;
		String hql = "from Customer where customerid=? ";
		List<Customer> list = find(hql,
				new Object[] { Long.parseLong(customerid) });
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 主键查询终端信息
	 * 
	 * @param Id
	 * @return
	 */
	public TermInfo getTermInfoById(String id) {
		if (null == id || "".equals(id))
			return null;
		return (TermInfo) get(TermInfo.class, id);
	}

	/**
	 * 终端编号查询终端信息
	 * 
	 * @param termId
	 * @return
	 */
	public TermInfo getTermInfoByTermId(String termId) {
		if (null == termId || "".equals(termId))
			return null;
		String hql = "from TermInfo where termid=? ";
		List<TermInfo> list = find(hql, new Object[] { Long.parseLong(termId) });
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * SamCardNo查询终端信息
	 * 
	 * @param termId
	 * @return
	 */
	public TermInfo getTermInfoBySamcard(Long psamcardno) {
		if (null == psamcardno || psamcardno.longValue() <= 0)
			return null;
		String hql = "from TermInfo where psamcardno=? ";
		List<TermInfo> list = find(hql, new Object[] { psamcardno });
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * net、poscode查询终端信息
	 * 
	 * @param poscode
	 * @param addNetId
	 * @return
	 */
	public TermInfo getTermInfoByNetPoscode(String poscode, String addNetId) {
		if (null == poscode || poscode.length() <= 0)
			return null;
		String hql = "from TermInfo where poscode=? and siteid=? ";
		List<TermInfo> list = find(hql, new Object[] { poscode, addNetId });
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 网点ID号查询网点信息
	 * 
	 * @param siteId
	 * @return
	 */
	public NetSite getNetSite(String siteId) {
		if (null == siteId || "".equals(siteId))
			return null;
		String hql = "from NetSite where netid=? ";
		List<NetSite> list = find(hql, new Object[] { siteId });
		return list != null ? list.get(0) : new NetSite();
	}

	/**
	 * 卡应用信息
	 * 
	 * @param customerid
	 * @param snr
	 * @return
	 */
	public CardAppinfo getCardAppinfo(String customerid, String snr) {
		if (null == customerid || "".equals(customerid))
			return null;
		String ahql = "from CardAppinfo where customerid=? and scardsnr=? ";
		List<CardAppinfo> list = find(ahql, new Object[] { customerid, snr });
		return list != null ? list.get(0) : new CardAppinfo();
	}

	/**
	 * 验证终端读卡器、及Psam卡信息的合法性
	 * 
	 * @param termInfo
	 * @param psamcardno
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String checkTermPsamCard(TermInfo termInfo, String psamcardno) {
		String msg = CardTipConstant.TIP_IS_OK;
		if (!psamcardno.equals(termInfo.getPsamcardno().toString())) {
			msg = CardTipConstant.TIP_TERM_NOT_MATCH_PSAM;
			return msg;
		}
		if (CardConstant.RS_IS.equals(termInfo.getIsdelete())) {
			msg = CardTipConstant.TIP_TERM_IS_DEL;
			return msg;
		}
		if (!CardConstant.STATUS_NOR.equals(termInfo.getIsuse())) {
			msg = CardTipConstant.TIP_TERM_IS_STOP;
			return msg;
		}
		if (!CardConstant.RS_IS.equals(termInfo.getIsauth())) {
			msg = CardTipConstant.TIP_TERM_NOT_AUTH;
			return msg;
		}

		StringBuffer sqlsb = new StringBuffer();
		sqlsb.append("SELECT ID, ");
		sqlsb.append("       SAMCARDNAME, ");
		sqlsb.append("       SAMCARDSN, ");
		sqlsb.append("       SAMCARDSNR, ");
		sqlsb.append("       STATE ");
		sqlsb.append("FROM   CARD_PSAM P ");
		sqlsb.append("WHERE  P.SAMCARDNO = ? ");
		sqlsb.append("       AND P.STARTDATE < sysdate ");
		sqlsb.append("       AND P.ENDDATE > sysdate ");
		List list = sqlQueryForList(sqlsb.toString(),
				new Object[] { psamcardno }, null);
		if (null != list && list.size() > 0) {
			Map<String, Object> map = (Map<String, Object>) list.get(0);
			String state = getStr(map, "STATE");
			if (!CardConstant.STATUS_NOR.equals(state)) {
				msg = CardTipConstant.TIP_PSAMSTATUS_NOT_NOR;
				return msg;
			}
		} else {
			msg = CardTipConstant.TIP_SYS_NOT_PSAM;
			return msg;
		}
		return msg;
	}

	/**
	 * 查询卡相关的信息
	 * 
	 * @param snr
	 * @param cardKind
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CardInfoForm getCardInfoForm(String snr, String cardKind) {
		CardInfoForm cardinfo = new CardInfoForm();
		String customerid = "";// 客户Id
		String appinfoId = "";// 当前卡应用Id
		// 制卡表信息
		StringBuffer csql = new StringBuffer();
		csql.append("SELECT c.customerid, ");
		csql.append("       c.asn, ");
		csql.append("       c.scardsnr, ");
		csql.append("       c.cardkind, ");
		csql.append("       c.cardtype, ");
		csql.append("       c.wallettype ");
		csql.append("FROM   card_makes c ");
		csql.append("WHERE  c.scardsnr = ? ");
		csql.append("       AND c.cardkind = ? ");
		List list = sqlQueryForList(csql.toString(), new Object[] { snr,
				cardKind }, null);
		if (null != list && list.size() > 0) {
			Map<String, Object> cmap = (Map<String, Object>) list.get(0);
			customerid = getStr(cmap, "CUSTOMERID");
			cardinfo.setCustomerid(customerid);
			cardinfo.setAsn(getStr(cmap, "ASN"));
			cardinfo.setScardsnr(snr);
			cardinfo.setCardkind(cardKind);
			cardinfo.setCardtype(getStr(cmap, "CARDTYPE"));
			cardinfo.setWallettype(getStr(cmap, "WALLETTYPE"));
		}

		// 卡应用信息
		if (customerid.length() > 0) {
			CardAppinfo appInfo = getCardAppinfo(customerid, snr);
			if (null != appInfo) {
				appinfoId = appInfo.getId();
				cardinfo.setAppinfoId(appinfoId);
				cardinfo.setCardsn(appInfo.getCardsn());
				cardinfo.setCitycardno(appInfo.getCitycardno());
				cardinfo.setCardstatus(appInfo.getCardstatus());
			}
		}

		// 当前卡余额
		if (appinfoId.length() > 0) {
			String ssql = "SELECT OPCOUNT,SAVEOPCOUNT,ODDFARE FROM CARD_MONEY_SUM "
					+ " WHERE APPINFO_ID=? ";
			List clist = sqlQueryForList(ssql, new Object[] { appinfoId }, null);
			if (null != clist && clist.size() > 0) {
				Map<String, Object> obj = (Map<String, Object>) clist.get(0);
				if (null != obj) {
					cardinfo.setOpcount(getStr(obj, "OPCOUNT"));
					cardinfo.setSaveopcount(getStr(obj, "SAVEOPCOUNT"));
					cardinfo.setOddfare(getCashStr(getStr(obj, "ODDFARE"), 2));
				}
			}
		}
		return cardinfo;
	}

	/**
	 * 当前用户的名称和部门信息
	 * 
	 * @param userId
	 * @return
	 */
	public Map<String, Object> getEmpAndDept(String userId) {
		Map<String, Object> obj = null;
		if (userId.length() > 0) {
			StringBuffer usql = new StringBuffer();
			usql.append("SELECT e.EMPID, ");
			usql.append("       e.SALE_CARDTYPE, ");
			usql.append("       e.CASH_CARDTYPE, ");
			usql.append("       e.PRIVILEGE_CASHIN, ");
			usql.append("       e.PRIVILEGE_CASHOUT, ");
			usql.append("       e.PRIVILEGE_LOGIN, ");
			usql.append("       d.dept_name, ");
			usql.append("       d.address, ");
			usql.append("       d.code, ");
			usql.append("       m.dept_id,m.user_name, ");
			usql.append("       m.login_name ");
			usql.append("FROM   base_employee e, ");
			usql.append("       base_dept d, ");
			usql.append("       base_dept_mapping m ");
			usql.append("WHERE  e.user_id = m.user_id ");
			usql.append("       AND d.id = m.dept_id ");
			usql.append("       AND m.user_id = ? ");
			List clist = sqlQueryForList(usql.toString(),
					new Object[] { userId }, null);
			if (null != clist && clist.size() > 0) {
				obj = (Map<String, Object>) clist.get(0);
			}
		}
		return obj;
	}

	/**
	 * 获取当前充值员、终端、网点等信息信息（登陆用户）
	 * 
	 * @param termId
	 *            终端Id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ACUserNetInfoForm getACUserNetInfo(String termId, String userId) {
		// 封装充值员对象Bean
		ACUserNetInfoForm acUserNetInfo = new ACUserNetInfoForm();
		// 当前职员名称及所属部门
		acUserNetInfo.setUserId(userId);
		Map<String, Object> obj = getEmpAndDept(userId);
		if (null != obj) {
			acUserNetInfo.setUserName(getStr(obj, "USER_NAME"));
			acUserNetInfo.setLoginName(getStr(obj, "LOGIN_NAME"));
			acUserNetInfo.setEmpId(getStr(obj, "EMPID"));
			acUserNetInfo.setDeptId(getStr(obj, "DEPT_ID"));
			acUserNetInfo.setDeptCode(getStr(obj, "CODE"));
			acUserNetInfo.setDeptName(getStr(obj, "DEPT_NAME"));
			acUserNetInfo.setAddress(getStr(obj, "ADDRESS"));
		}

		// 终端
		if (null == termId || "".equals(termId)) {
			//
		} else {
			TermInfo terminfo = getTermInfoByTermId(termId);
			if (null != terminfo) {
				acUserNetInfo.setTermId(termId);
				// 终端名称
				acUserNetInfo.setTermname(terminfo.getTermname());
				// 商户代码
				acUserNetInfo.setMerchantcode(terminfo.getMerchantcode());
				// 上层指定的终端唯一编号
				acUserNetInfo.setPoscode(terminfo.getPoscode());
				// 终端类型编号
				acUserNetInfo.setTypeid(terminfo.getTypeid());
				// 终端读卡器上的PSAM卡号
				acUserNetInfo.setPsamcardno(terminfo.getPsamcardno());
				// 网点编号
				acUserNetInfo.setSiteid(terminfo.getSiteid());
				// PSAM卡信息
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT ID, ");
				sql.append("       SAMCARDNAME, ");
				sql.append("       SAMCARDSN, ");
				sql.append("       SAMCARDSNR, ");
				sql.append("       STATE ");
				sql.append("FROM   CARD_PSAM P ");
				sql.append("WHERE  P.SAMCARDNO = ? ");
				sql.append("       AND P.STARTDATE < sysdate ");
				sql.append("       AND P.ENDDATE > sysdate ");
				List list = sqlQueryForList(sql.toString(),
						new Object[] { terminfo.getPsamcardno() }, null);
				if (null != list && list.size() > 0) {
					Map<String, Object> map = (Map<String, Object>) list.get(0);
					acUserNetInfo.setPsamcardid(getStr(map, "ID"));
					acUserNetInfo.setSamcardname(getStr(map, "SAMCARDNAME"));
					acUserNetInfo.setSamcardsn(Long.parseLong(getStr(map,
							"SAMCARDSN")));
					acUserNetInfo.setSamcardsnr(getStr(map, "SAMCARDSNR"));
				}
			}
		}
		// 网点
		if (null != acUserNetInfo.getSiteid()) {
			NetSite netSiteInfo = getNetSite(acUserNetInfo.getSiteid());
			if (null != netSiteInfo) {
				// 网点编号
				acUserNetInfo.setNetid(netSiteInfo.getNetid());
				// 网点名称
				acUserNetInfo.setNetname(netSiteInfo.getNetname());
				// 网点简称
				acUserNetInfo.setNetjp(netSiteInfo.getNetjp());
				// 网点状态 0：停用、1：正常
				acUserNetInfo.setNetstatus(netSiteInfo.getNetstatus());
				// 网点类型（0：充值网点:1：综合网点）
				acUserNetInfo.setNettype(netSiteInfo.getNettype());
				// 网点种类，0直属，1代理（代理网点记账方式不同）
				acUserNetInfo.setNetkind(netSiteInfo.getNetkind());
			}
		}
		// 授权额度
		if (null != acUserNetInfo.getSiteid()) {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ID, ");
			sql.append("       ISUSE, ");
			sql.append("       CURODDFARE, ");
			sql.append("       SUMFARE ");
			sql.append("FROM   CHARGEAUTH ");
			sql.append("WHERE  NETSITEID = ? ");
			sql.append("       AND id IN(SELECT e.bank_id ");
			sql.append("                 FROM   BASE_EMPLOYEE e ");
			sql.append("                 WHERE  e.netsite_id = ? ");
			sql.append("                        AND e.user_id = ?) ");
			List list = sqlQueryForList(sql.toString(), new Object[] {
					acUserNetInfo.getSiteid(), acUserNetInfo.getSiteid(),
					userId }, null);
			if (null != list && list.size() > 0) {
				Map<String, Object> cmap = (Map<String, Object>) list.get(0);
				acUserNetInfo.setBankId(getStr(cmap, "ID"));
				acUserNetInfo.setIsuseauth(getStr(cmap, "ISUSE"));
				acUserNetInfo.setCuroddfare(getCashStr(
						getStr(cmap, "CURODDFARE"), 2));
				acUserNetInfo
						.setSumfare(getCashStr(getStr(cmap, "SUMFARE"), 2));
			}
		}
		return acUserNetInfo;
	}

	/**
	 * 获取及时消息
	 * 
	 * @param termId
	 * @param userId
	 * @return
	 */
	public UserBizTotalMsgForm getUserBizTotalMsgForm(String termId,
			String userId) {
		UserBizTotalMsgForm bizTotalMsg = new UserBizTotalMsgForm();
		// 充值员信息
		// 当前职员名称及所属部门
		bizTotalMsg.setUserId(userId);
		Map<String, Object> obj = getEmpAndDept(userId);
		if (null != obj) {
			bizTotalMsg.setUserName(getStr(obj, "USER_NAME"));
			bizTotalMsg.setLoginName(getStr(obj, "LOGIN_NAME"));
			bizTotalMsg.setEmpId(getStr(obj, "EMPID"));
			bizTotalMsg.setDeptId(getStr(obj, "DEPT_ID"));
			bizTotalMsg.setDeptCode(getStr(obj, "CODE"));
			bizTotalMsg.setDeptName(getStr(obj, "DEPT_NAME"));
			bizTotalMsg.setAddress(getStr(obj, "ADDRESS"));
			bizTotalMsg.setSaleCardtype(getStr(obj, "SALE_CARDTYPE"));
			bizTotalMsg.setCashCardtype(getStr(obj, "CASH_CARDTYPE"));
			bizTotalMsg.setIsCanLogin(getStr(obj, "PRIVILEGE_LOGIN"));
		}
		// 终端-->网点
		String siteId = (String) sqlFindObject(
				"select siteid from term_info where id=? ",
				new Object[] { termId });
		if (siteId.length() > 0) {
			// 充值员、网点-->授权余额
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ID, ");
			sql.append("       ISUSE, ");
			sql.append("       CURODDFARE, ");
			sql.append("       SUMFARE ");
			sql.append("FROM   CHARGEAUTH ");
			sql.append("WHERE  NETSITEID = ? ");
			sql.append("       AND id IN(SELECT e.bank_id ");
			sql.append("                 FROM   BASE_EMPLOYEE e ");
			sql.append("                 WHERE  e.NETSITE_ID = ? ");
			sql.append("                        AND e.user_id = ?) ");
			List list = sqlQueryForList(sql.toString(), new Object[] { siteId,
					siteId, userId }, null);
			if (null != list && list.size() > 0) {
				Map<String, Object> cmap = (Map<String, Object>) list.get(0);
				bizTotalMsg.setBankId(getStr(cmap, "ID"));
				bizTotalMsg.setIsUseAuth(getStr(cmap, "ISUSE"));
				bizTotalMsg.setCurrOddFare(getCashStr(
						getStr(cmap, "CURODDFARE"), 2));// 当前授权余额
			}
		}

		// 售卡张数
		StringBuffer sql0 = new StringBuffer();
		sql0.append("SELECT Nvl(Count(*), 0) sellnum ");
		sql0.append("FROM   card_makes ");
		sql0.append("WHERE  To_char(edit_date, 'yyyy-mm-dd') = To_char(sysdate, 'yyyy-mm-dd') ");
		sql0.append("       AND EDIT_PERSON = ? ");
		BigDecimal currSellCardNum = (BigDecimal) sqlFindObject(
				sql0.toString(), new Object[] { userId });
		bizTotalMsg.setCurrSellCardNum(currSellCardNum.toString());

		// 售卡收费金额每售卡一张对应多项费用信息(3001开户卡成本费(含卡套费)、3101新卡手续费)
		StringBuffer sql01 = new StringBuffer();
		sql01.append("SELECT Nvl(Sum(accfare), 0) sellcash ");
		sql01.append("FROM   FARE_COST ");
		sql01.append("WHERE  To_char(edit_date, 'yyyy-mm-dd') = To_char(sysdate, 'yyyy-mm-dd') ");
		sql01.append("       AND EDIT_PERSON = ? ");
		sql01.append("       AND ACCCODE in('3001','3101') ");
		BigDecimal currSellCardCash = (BigDecimal) sqlFindObject(
				sql01.toString(), new Object[] { userId });
		bizTotalMsg.setCurrSellCardCash(getCashStr(currSellCardCash.toString(),
				2));

		// 钱包充值张数/金额(1001PC钱包充值1006PC支票充值)
		StringBuffer sql1 = new StringBuffer();
		sql1.append("SELECT Count(*)              ACNUM, ");
		sql1.append("       Nvl(Sum(s.OPFARE), 0) ACOPFARE ");
		sql1.append("FROM   MONEY_SAVE_SUCCESSED s ");
		sql1.append("WHERE  s.netid = ? ");
		sql1.append("       AND s.businesstype =? ");
		sql1.append("       AND s.acccode in('1001','1006') ");
		sql1.append("       AND To_char(s.opdt, 'yyyy-mm-dd') = To_char(sysdate, 'yyyy-mm-dd') ");
		List list1 = sqlQueryForList(sql1.toString(), new Object[] { siteId,
				CardCodeConstant.CODE_DICT_BUSINESSTYPE_2 }, null);
		if (null != list1 && list1.size() > 0) {
			Map<String, Object> cmap = (Map<String, Object>) list1.get(0);
			bizTotalMsg.setCurrAddChargeNum(getStr(cmap, "ACNUM"));
			bizTotalMsg.setCurrAddChargeCash(getCashStr(
					getStr(cmap, "ACOPFARE"), 2));
		} else {
			bizTotalMsg.setCurrAddChargeNum("0");
			bizTotalMsg.setCurrAddChargeCash("0.00");
		}

		// 充值撤销张数/金额(2103：电子钱包充值撤销)
		StringBuffer sql2 = new StringBuffer();
		sql2.append("SELECT Count(*)              ACNUM, ");
		sql2.append("       Nvl(Sum(s.OPFARE), 0) ACOPFARE ");
		sql2.append("FROM   MONEY_SAVE_SUCCESSED s ");
		sql2.append("WHERE  s.netid = ? ");
		sql2.append("       AND s.businesstype = ? ");
		sql2.append("       AND s.acccode = ? ");
		sql2.append("       AND To_char(s.opdt, 'yyyy-mm-dd') = To_char(sysdate, 'yyyy-mm-dd') ");
		List list2 = sqlQueryForList(sql2.toString(), new Object[] { siteId,
				CardCodeConstant.CODE_DICT_BUSINESSTYPE_2,
				CardCodeConstant.ACCCODE_QUASH_ADDCHARGE_CASHADD }, null);
		if (null != list2 && list2.size() > 0) {
			Map<String, Object> map = (Map<String, Object>) list2.get(0);
			bizTotalMsg.setCurrUnAddChargeNum(getStr(map, "ACNUM"));
			bizTotalMsg.setCurrUnAddChargeCash(getCashStr(
					getStr(map, "ACOPFARE"), 2));
		} else {
			bizTotalMsg.setCurrUnAddChargeNum("0");
			bizTotalMsg.setCurrUnAddChargeCash("0.00");
		}

		// 消费纠错张数：0
		bizTotalMsg.setCurrPutRightNum("0");
		// 消费纠错金额：0.00
		bizTotalMsg.setCurrPutRightCash("0.00");
		// 补卡张数：0
		bizTotalMsg.setCurrRenewCardNum("0");
		// 挂失张数：0
		bizTotalMsg.setCurrCardLossNum("0");
		// 有卡销户张数：0
		bizTotalMsg.setCurrHasCardLogoutNum("0");
		// 无卡销户张数：0
		bizTotalMsg.setCurrNoCardLogoutNum("0");
		// 领取冻结金额：0.00
		bizTotalMsg.setCurrGetFrozenCash("0.00");
		// 解挂张数：0
		bizTotalMsg.setCurrCardUnLossNum("0");
		// 有卡销户金额：0.00
		bizTotalMsg.setCurrHasCardLogoutCash("0.00");
		// 无卡销户金额：0.00
		bizTotalMsg.setCurrNoCardLogoutCash("0.00");

		// 总收入金额=成本+充值
		String currCntIn = ""
				+ (currSellCardCash.doubleValue() + Double
						.parseDouble(bizTotalMsg.getCurrAddChargeCash()));

		// 总支出金额=成本+充值-撤销-有卡销户-无卡销户-消费纠错
		bizTotalMsg.setCurrCntIn(getCashStr(currCntIn, 2));
		String currCntOut = ""
				+ (Double.parseDouble(currCntIn)
						- Double.parseDouble(bizTotalMsg
								.getCurrUnAddChargeCash())
						- Double.parseDouble(bizTotalMsg
								.getCurrHasCardLogoutCash())
						- Double.parseDouble(bizTotalMsg
								.getCurrNoCardLogoutCash()) - Double
						.parseDouble(bizTotalMsg.getCurrPutRightCash()));
		bizTotalMsg.setCurrCntOut(getCashStr(currCntOut, 2));

		return bizTotalMsg;
	}

	/**
	 * 获取Map键值
	 * 
	 * @param map
	 * @param reg
	 * @return
	 */
	public String getStr(Map map, String reg) {
		reg = reg.toUpperCase();
		if (null != map)
			return map.get(reg) == null ? "" : map.get(reg).toString();
		return "";
	}

	/**
	 * 格式化小数，保留指定位数
	 * 
	 * @param reg
	 * @param dig
	 * @return
	 */
	public String getCashStr(String reg, int dig) {
		double d = 0.00;
		String rs = "0.00";
		if (reg.length() > 0) {
			d = Double.parseDouble(reg);
		}
		rs = String.format("%." + 2 + "f", d);
		return rs;
	}

	/**
	 * 卡大类关联出卡类型(小类)
	 * 
	 * @param groupId
	 *            卡大类
	 * @return
	 */
	public List<CardType> getCardTypeByGroupId(String groupId) {
		String hql = "from CardType where groupid=? order by sort_num asc ";
		return find(hql, new Object[] { groupId });
	}

	/**
	 * @param code
	 * @return
	 */
	public List getDictListByCode(String code) {
		String sql = "SELECT D.ID,D.D_CODE,D.D_DESC1 FROM BASE_DICT D WHERE D.C_CODE=? ";
		LinkedHashMap map = new LinkedHashMap<String, String>();
		map.put("sort_num", "asc");
		return sqlQueryForList(sql, new Object[] { code }, 1,
				Integer.MAX_VALUE, map);
	}
}
