/**
 * 
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.model.CardMakes;
import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;


/**
 * 
 * @Description: 制卡流水
 * @author  高崇飞
 * @date 2014-4-21 下午03:20:42
 * @version V1.0
 */
@SuppressWarnings("all")
@Repository("cardmakesDAO")
public class CardMakesDAO  extends  HibernateEntityDao {

	private static final long serialVersionUID = 7350122404195799135L;
	@Override
	protected Class getReferenceClass() {
		return CardMakes.class;
	}
	/**
	 * 
	 * @Description: TODO
	 * @param @param key
	 * @param @return
	 * @return Role
	 * @throws
	 */
	public CardMakes get(java.io.Serializable key) {
		return (CardMakes) get(getReferenceClass(), key);
	}
}
