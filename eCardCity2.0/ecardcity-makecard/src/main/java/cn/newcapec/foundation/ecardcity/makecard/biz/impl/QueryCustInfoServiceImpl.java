/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.biz.impl;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.foundation.ecardcity.makecard.biz.QueryCustInfoService;
import cn.newcapec.foundation.ecardcity.makecard.dao.QueryCustInfoDao;
import cn.newcapec.foundation.ecardcity.makecard.model.CardAppinfo;
import cn.newcapec.foundation.ecardcity.makecard.model.CardMoneySum;
import cn.newcapec.foundation.ecardcity.makecard.model.Customer;

/**
 * 客户信息查询业务接口实现类
 * 
 * @author wulimo
 * 
 */
@Service("queryCustInfoService")
@Transactional
@SuppressWarnings("all")
public class QueryCustInfoServiceImpl implements QueryCustInfoService {

	/**
	 * 本地Log4J管道日志输出
	 */
	private static final Logger log = Logger
			.getLogger(QueryCustInfoServiceImpl.class);
	@Autowired
	private QueryCustInfoDao queryCustInfoDao;
	/**
	 * 分页查询头
	 */
	public static String headsql = "select * from (select aa.*,rownum rn from (";
	/**
	 * 分页查询未
	 */
	public static String endsql = " ) aa ) where rn>=? and rn<=?";
	/**
	 * 分页查询总数
	 */
	public static String countsql = "select count(*) from ( ";
	public static String countsqlEnd = ")";

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.QueryCustInfoService#
	 * readCardQuery(net.sf.json.JSONObject)
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List readCardQuery(JSONObject param) {
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

		String custName = param.getString("custName");
		String custCardNo = param.getString("custCardNo");
		String custIdCardNo = param.getString("custIdCardNo");

		StringBuffer varname1 = new StringBuffer();
		varname1.append("SELECT c.id, ");
		varname1.append("       c.name, ");
		varname1.append("       c.sex, ");
		varname1.append("       c.telephone, ");
		varname1.append("       c.idcardno, ");
		varname1.append("       c.customerid, ");
		varname1.append("       a.citycardno, ");
		varname1.append("       a.cardtype, ");
		varname1.append("       a.cardstatus, ");
		varname1.append("       to_char(a.asn) asnstr,a.id appid, ");
		varname1.append("       to_char(a.edit_date,'yyyy-mm-dd hh:mi:ss') editdt ");
		varname1.append("FROM   customer c, ");
		varname1.append("       card_appinfo a ");
		varname1.append("WHERE  c.customerid = a.customerid ");
		if (custName.length() > 0) {
			varname1.append("       AND c.name = '" + custName + "' ");
		}
		if (custCardNo.length() > 0) {
			varname1.append("       AND a.citycardno = '" + custCardNo + "' ");
		}
		if (custIdCardNo.length() > 0) {
			varname1.append("       AND c.idcardno = '" + custIdCardNo + "' ");
		}
		varname1.append("       AND to_char(a.asn) = ? ");
		return queryCustInfoDao.sqlQueryForList(varname1.toString(),
				new Object[] { asn }, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.QueryCustInfoService#
	 * searchCustList(net.sf.json.JSONObject)
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Map searchCustList(JSONObject param) {
		// 获取前台传入的参数
		// 当前登录用户及时消息中传入
		String userId = param.getString("userId");

		String custName = param.getString("custName");
		String custCardNo = param.getString("custCardNo");
		String custIdCardNo = param.getString("custIdCardNo");

		String startPage = param.getString("startPage");
		String endPage = param.getString("endPage");

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT c.id, ");
		sb.append("       c.name, ");
		sb.append("       c.sex, ");
		sb.append("       c.telephone, ");
		sb.append("       c.idcardno, ");
		sb.append("       c.customerid, ");
		sb.append("       a.citycardno, ");
		sb.append("       a.cardtype, ");
		sb.append("       a.cardstatus, ");
		sb.append("       to_char(a.asn) asnstr,a.id appid, ");
		sb.append("       to_char(a.edit_date,'yyyy-mm-dd hh:mi:ss') editdt ");
		sb.append("FROM   customer c, ");
		sb.append("       card_appinfo a ");
		sb.append("WHERE  c.customerid = a.customerid ");
		if (custName.length() > 0) {
			sb.append("       AND upper(c.name) like '%"
					+ custName.toUpperCase() + "%' ");
		}
		if (custCardNo.length() > 0) {
			sb.append("       AND a.citycardno like '%" + custCardNo + "%' ");
		}
		if (custIdCardNo.length() > 0) {
			sb.append("       AND c.idcardno like '%" + custIdCardNo + "%' ");
		}

		Map obj = new HashedMap();
		obj.put("totalCount", 0);
		obj.put("startPage", startPage);
		obj.put("endPage", endPage);

		String cntsql = countsql + sb.toString() + countsqlEnd;

		String searchSql = headsql + sb.toString()
				+ " order by a.citycardno desc " + endsql;

		BigDecimal cntNum = (BigDecimal) queryCustInfoDao.sqlFindObject(
				cntsql.toString(), new Object[] {});

		if (cntNum.intValue() > 0) {
			obj.put("totalCount", cntNum.intValue());
			LinkedHashMap orderby = new LinkedHashMap<String, String>();
			orderby.put("CITYCARDNO", "desc");
			List list = queryCustInfoDao.sqlQueryForList(searchSql,
					new Object[] { startPage, endPage }, null);
			obj.put("currList", list);
		}
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.QueryCustInfoService#
	 * getCustDetail(net.sf.json.JSONObject)
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Map getCustDetail(JSONObject param) {
		// 获取前台传入的参数
		// 当前登录用户及时消息中传入
		String userId = param.getString("userId");
		String custId = param.getString("custId");
		String cardNo = param.getString("cardNo");// 市民卡号

		Map obj = new HashedMap();
		Customer customer = queryCustInfoDao.getByCustId(custId);
		CardAppinfo cardAppinfo = queryCustInfoDao.getCardAppinfoByCustIdNo(
				custId, cardNo);
		CardMoneySum cardMoneySum = queryCustInfoDao
				.getCardMoneySumByAppinfoid(cardAppinfo.getId());
		obj.put("customer", customer);
		obj.put("cardAppinfo", cardAppinfo);
		obj.put("cardMoneySum", cardMoneySum);
		return obj;
	}
}
