/**
 * 
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.model.CardEmployee;
import cn.newcapec.foundation.ecardcity.makecard.util.CardUtil;
import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;
import cn.newcapec.framework.core.exception.BaseException;


/**
 * 
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:20:42
 * @version V1.0
 */
@SuppressWarnings("all")
@Repository("cardemployeeDAO")
public class CardEmployeeDAO  extends HibernateEntityDao{

	private static final long serialVersionUID = 7350122404195799135L;
	@Override
	protected Class getReferenceClass() {
		return CardEmployee.class;
	}
	/**
	 * @Description:  根据 empid 查询操作员卡信息
	 * @param @param id
	 * @param @param orderby
	 * @param @return   
	 * @return List<Map<String,Object>>    
	 * @throws
	 */ 
	public List<Map<String, Object>> queryByEmpId(String id,
			LinkedHashMap<String, String> orderby) {
		String sql = "select * from card_employee t where t.empid = ?";
		return this.sqlQueryForList(sql, new Object[]{id}, orderby);
	}
	
	/**
	 * 
	 * @Description: 校验 卡信息
	 * @param @param id
	 * @param @return   
	 * @return CardEmployee    
	 * @throws
	 */
	public CardEmployee queryBySnr(String str) {
		String hql = "select t from CardEmployee t where t.scardsnr = ?";
		return (CardEmployee)this.findForObject(hql,  new Object[]{str});
	}
	/**
	 * @Description: 参数卡发卡 --获取参数
	 * @param @param cCode
	 * @param @return   
	 * @return Object    
	 * @throws
	 */ 
	public List getCardParam(String cCode) {
		String sql = "select * from base_param t where t.cardtype = 43"; //43从 card_type表中获取参数卡typeid
		return this.sqlQueryForList(sql,  new Object[]{cCode},null);//cCode客户代码需要关联
	}
	/**
	 * @Description: 功能卡挂失
	 * @param @param cardemployee   
	 * @return void    
	 * @throws
	 */ 
	public void updateLoss(CardEmployee cardemployee) {
		StringBuffer sb = new StringBuffer(
						"update CardEmployee set cardstatus = 3, loss_date =? where id =? ");
		this.update(sb.toString(), new Object[] {cardemployee.getLoss_date(),cardemployee.getId() });
	}
	/**
	 * @Description: 功能卡写卡失败进行数据回滚
	 * @param @param cardemployee   
	 * @return void    
	 * @throws
	 */
	public void delete(CardEmployee cardemployee) {
		StringBuffer sb = new StringBuffer(
		"delete form CardEmployee where asn =? ");
		this.delete(sb.toString(), new Object[] { cardemployee.getAsn() });
	}
	/**
	 * @Description: 通过ASN 查询功能卡
	 * @param @param asn
	 * @param @return   
	 * @return CardEmployee    
	 * @throws
	 */ 
	public CardEmployee queryByAsn(String asn) {
		String hql = "select t from CardEmployee t where to_char(t.asn) = ?";
		return (CardEmployee)this.findForObject(hql,  new Object[]{asn});
	}
	/**
	 * @Description: 解挂
	 * @param @param asn   
	 * @return void    
	 * @throws
	 */ 
	public void updateunLoss(String asn) {
		StringBuffer sb = new StringBuffer(
				"update CardEmployee set cardstatus = 4 edit_date =? where asn =? ");
		this.update(sb.toString(), new Object[] {CardUtil.getNowDate("yyyy-MM-dd HH:mm:ss"),asn });
	}
	/**
	 * 
	 * @Description: TODO
	 * @param @param key
	 * @param @return
	 * @return Role
	 * @throws
	 */
	public CardEmployee get(java.io.Serializable key) {
		return (CardEmployee) get(getReferenceClass(), key);
	}
	/**
	 * 
	 * @Description: TODO
	 * @param @param cardemployee   
	 * @return void    
	 * @throws
	 */
	public void saveOrUpdate(CardEmployee cardemployee) {
		saveOrUpdate((Object) cardemployee);
	}
}
