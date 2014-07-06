/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.biz.impl;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.foundation.ecardcity.makecard.biz.ConsumeCardService;
import cn.newcapec.foundation.ecardcity.makecard.dao.base.CardCommonDao;
import cn.newcapec.foundation.ecardcity.makecard.model.TermInfo;
import cn.newcapec.foundation.ecardcity.makecard.util.CardTipConstant;
import cn.newcapec.foundation.ecardcity.makecard.util.UserBizTotalMsgForm;
import cn.newcapec.framework.core.rest.Msg;

/**
 * 卡务业务接口实现类
 * 
 * @author wulimo
 * 
 */
@Service("consumeCardService")
@Transactional
@SuppressWarnings("all")
public class ConsumeCardServiceImpl implements ConsumeCardService {

	@Autowired
	private CardCommonDao cardCommonDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.ConsumeCardService#
	 * getBizTotalMsg(java.lang.Long, java.lang.String)
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Msg getBizTotalMsg(Long psamcardno, String userId) {
		Msg msg = new Msg();
		msg.setMsg(CardTipConstant.TIP_GET_BIZTOTAL_FAIL);
		if (psamcardno.longValue() > 0) {
			TermInfo termInfo = cardCommonDao.getTermInfoBySamcard(psamcardno);
			if (null != termInfo) {
				String termId = termInfo.getTermid().toString();
				UserBizTotalMsgForm msgForm = cardCommonDao
						.getUserBizTotalMsgForm(termId, userId);
				JSONObject msgObj = new JSONObject();
				msgObj.put("msgForm", msgForm);
				msgObj.put("psamcardno", psamcardno);
				msgObj.put("termId", termId);
				msgObj.put("userId", userId);
				msg.setMsg(CardTipConstant.TIP_IS_OK);
				msg.setData(msgObj.toString());
			}
		}
		return msg;
	}

}
