package cn.newcapec.foundation.ecardcity.makecard.biz.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.foundation.ecardcity.makecard.biz.CardEmployeeService;
import cn.newcapec.foundation.ecardcity.makecard.biz.EmployeeService;
import cn.newcapec.foundation.ecardcity.makecard.dao.CardEmployeeDAO;
import cn.newcapec.foundation.ecardcity.makecard.dao.CardPsamDAO;
import cn.newcapec.foundation.ecardcity.makecard.dao.EmployeeDAO;
import cn.newcapec.foundation.ecardcity.makecard.dao.SystemBlackDAO;
import cn.newcapec.foundation.ecardcity.makecard.dao.TermInfoDAO;
import cn.newcapec.foundation.ecardcity.makecard.model.CardEmployee;
import cn.newcapec.foundation.ecardcity.makecard.model.CardPsam;
import cn.newcapec.foundation.ecardcity.makecard.model.Employee;
import cn.newcapec.foundation.ecardcity.makecard.model.Param;
import cn.newcapec.foundation.ecardcity.makecard.model.SystemBlack;
import cn.newcapec.foundation.ecardcity.makecard.model.TermInfo;
import cn.newcapec.framework.core.utils.pagesUtils.Page;

/**
 * 职员卡业务接口实现类
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:48:24
 * @version V1.0
 */
@Service("cardemployeeService")
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("all")
public class CardEmployeeServiceImpl implements CardEmployeeService {

	/* 接口类 */
	@Autowired
	private CardEmployeeDAO cardemployeeDAO;
	@Autowired
	private CardPsamDAO cardpsamdao;
	@Autowired
	private TermInfoDAO terminfodao;
	@Autowired
	private SystemBlackDAO systemblackdao;

	/* (non-Javadoc)
	 * @see cn.newcapec.framework.core.biz.BaseService#removeUnused(java.lang.String)
	 */
	@Override
	public void removeUnused(String arg0) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
	 */
	@Override
	public CardEmployee get(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see cn.newcapec.framework.core.biz.BaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(CardEmployee cardemployee) {
		cardemployeeDAO.saveOrUpdate(cardemployee);
		
	}
	
	@Override
	public void updateLoss(CardEmployee cardemployee,SystemBlack systemBlack) {
		//修改功能卡状态
		cardemployeeDAO.updateLoss(cardemployee);
		//形成黑名单
		systemblackdao.saveOrUpdate(systemBlack);
	}
	
	/* (non-Javadoc)
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.CardEmployeeService#queryByNetsiteId(java.lang.String, java.util.LinkedHashMap)
	 */
	@Override
	public List<Map<String, Object>> queryByEmpId(String id,
			LinkedHashMap<String, String> orderby) {
		List<Map<String, Object>> page = cardemployeeDAO.queryByEmpId(id ,orderby);
		if (null != page && !page.isEmpty()){
			return page;
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.CardEmployeeService#delete(cn.newcapec.foundation.ecardcity.makecard.model.CardEmployee)
	 */
	@Override
	public void delete(CardEmployee cardemployee) {
		cardemployeeDAO.delete(cardemployee);
		
	}
	/* (non-Javadoc)
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.CardEmployeeService#queryByPsam(java.lang.String)
	 */
	@Override
	public CardPsam queryByPsam(String psamno) {
		return cardpsamdao.queryByPsam(psamno);
	}
	/* (non-Javadoc)
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.CardEmployeeService#queryTermInfoByPsam(java.lang.String)
	 */
	@Override
	public TermInfo queryTermInfoByPsam(String psamno) {
		return terminfodao.queryTermInfoByPsam(psamno);
	}
	/* (non-Javadoc)
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.CardEmployeeService#queryBySnr(java.lang.String)
	 */
	@Override
	public CardEmployee queryBySnr(String snr) {
		return cardemployeeDAO.queryBySnr(snr);
	}
	/* (non-Javadoc)
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.CardEmployeeService#getCardParam(java.lang.String)
	 */
	@Override
	public List getCardParam(String cCode) {
		return cardemployeeDAO.getCardParam(cCode);
	}
	/* (non-Javadoc)
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.CardEmployeeService#queryByAsn(java.lang.String)
	 */
	@Override
	public CardEmployee queryByAsn(String asn) {
		return cardemployeeDAO.queryByAsn(asn);
	}
	/* (non-Javadoc)
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.CardEmployeeService#updateunLoss(java.lang.String)
	 */
	@Override
	public void updateunLoss(String asn) {
		//修改功能卡状态
		cardemployeeDAO.updateunLoss(asn);
		//修改黑名单
		systemblackdao.updateunLoss(asn);
	}

	
}
