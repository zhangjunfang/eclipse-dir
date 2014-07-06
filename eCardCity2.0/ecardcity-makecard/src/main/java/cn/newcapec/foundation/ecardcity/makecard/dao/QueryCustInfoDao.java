/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.dao.base.CardCommonDao;
import cn.newcapec.foundation.ecardcity.makecard.model.CardAppinfo;
import cn.newcapec.foundation.ecardcity.makecard.model.CardMoneySum;

/**
 * 客户信息查询业务Dao层实现
 * 
 * @author wulimo
 * 
 */
@Repository
@SuppressWarnings("all")
public class QueryCustInfoDao extends CardCommonDao {

	/**
	 * 获取卡应用信息
	 * 
	 * @param custId
	 * @param cardNo
	 * @return
	 */
	public CardAppinfo getCardAppinfoByCustIdNo(String custId, String cardNo) {
		if (null == custId || "".equals(cardNo))
			return null;
		String ahql = "from CardAppinfo where customerid=? and citycardno=? ";
		List<CardAppinfo> list = find(ahql, new Object[] { custId, cardNo });
		return list != null ? list.get(0) : new CardAppinfo();
	}

	/**
	 * 当前卡余额信息
	 * 
	 * @param appinfoid
	 * @return
	 */
	public CardMoneySum getCardMoneySumByAppinfoid(String appinfoid) {
		if (null == appinfoid || "".equals(appinfoid))
			return null;
		String ahql = "from CardMoneySum where appinfo_id=? ";
		List<CardMoneySum> list = find(ahql, new Object[] { appinfoid });
		return list != null ? list.get(0) : new CardMoneySum();
	}
}
