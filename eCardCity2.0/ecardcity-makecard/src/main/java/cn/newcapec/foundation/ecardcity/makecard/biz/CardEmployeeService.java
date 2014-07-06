package cn.newcapec.foundation.ecardcity.makecard.biz;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.newcapec.foundation.ecardcity.makecard.model.CardEmployee;
import cn.newcapec.foundation.ecardcity.makecard.model.CardPsam;
import cn.newcapec.foundation.ecardcity.makecard.model.Employee;
import cn.newcapec.foundation.ecardcity.makecard.model.Param;
import cn.newcapec.foundation.ecardcity.makecard.model.SystemBlack;
import cn.newcapec.foundation.ecardcity.makecard.model.TermInfo;
import cn.newcapec.framework.core.biz.BaseService;
import cn.newcapec.framework.core.utils.pagesUtils.Page;

/**
 * 职员卡接口业务接口类
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:48:49
 * @version V1.0
 */
@SuppressWarnings("all")
public interface CardEmployeeService extends BaseService<CardEmployee> {

	/**
	 * 根据 empid 查询操作员卡信息
	 * @Description: TODO
	 * @param @param id
	 * @param @param orderby
	 * @param @return   
	 * @return Page    
	 * @throws
	 */
	public List<Map<String, Object>> queryByEmpId(String id,
			LinkedHashMap<String, String> orderby);
	/**
	 * 
	 * @Description: TODO
	 * @param @param user   
	 * @return void    
	 * @throws
	 */
	public void delete(CardEmployee cardemployee);
	/**
	 * @Description: 
	 * @param @param snr
	 * @param @return   
	 * @return Object    
	 * @throws
	 */ 
	public TermInfo queryTermInfoByPsam(String psamno) ;
	/**
	 * @Description: 
	 * @param @param snr
	 * @param @return   
	 * @return Object    
	 * @throws
	 */ 
	public CardPsam queryByPsam(String psamno);
	/**
	 * @Description: TODO
	 * @param @param snr
	 * @param @return   
	 * @return Object    
	 * @throws
	 */ 
	public CardEmployee queryBySnr(String snr);
	/**
	 * @Description: TODO
	 * @param @param cCode   
	 * @return void    
	 * @throws
	 */ 
	public List getCardParam(String cCode);
	/**
	 * @Description: TODO
	 * @param @param cCode   
	 * @return void    
	 * @throws
	 */ 
	public void updateLoss(CardEmployee cardEmployee,SystemBlack systemblack);
	/**
	 * @Description: TODO
	 * @param @param asn
	 * @param @return   
	 * @return CardEmployee    
	 * @throws
	 */ 
	public CardEmployee queryByAsn(String asn);
	/**
	 * @Description: TODO
	 * @param @param asn   
	 * @return void    
	 * @throws
	 */ 
	public void updateunLoss(String asn);
}
