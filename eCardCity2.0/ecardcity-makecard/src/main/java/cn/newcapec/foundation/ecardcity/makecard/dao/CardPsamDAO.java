/**
 * 
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.model.CardPsam;
import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;


/**
 * 
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:20:42
 * @version V1.0
 */
@SuppressWarnings("all")
@Repository("cardpsamDAO")
public class CardPsamDAO  extends  HibernateEntityDao {

	private static final long serialVersionUID = 7350122404195799135L;
	@Override
	protected Class getReferenceClass() {
		return CardPsam.class;
	}
	/**
	 * 
	 * @Description: TODO
	 * @param @param key
	 * @param @return
	 * @return Role
	 * @throws
	 */
	public CardPsam get(java.io.Serializable key) {
		return (CardPsam) get(getReferenceClass(), key);
	}
	/**
	 * 
	 * @Description: 校验sam卡
	 * @param @param id
	 * @param @return   
	 * @return CardPsam    
	 * @throws
	 */
	public CardPsam queryByPsam(String psamno) {
		String sql = "select t from  CardPsam t where t.samcardno= ? and t.state = 1";
		return (CardPsam)this.findForObject(sql,  new Object[]{psamno});
	}
}
