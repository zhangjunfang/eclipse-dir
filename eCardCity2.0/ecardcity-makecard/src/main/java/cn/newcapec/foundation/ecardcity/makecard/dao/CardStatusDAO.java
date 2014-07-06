/**
 * 
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.model.CardEmployee;
import cn.newcapec.foundation.ecardcity.makecard.model.CardStatus;
import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;


/**
 * 
 * @Description: 卡状态变化
 * @author  高崇飞
 * @date 2014-5-20 下午03:20:42
 * @version V1.0
 */
@SuppressWarnings("all")
@Repository("cardstatusDAO")
public class CardStatusDAO  extends HibernateEntityDao{

	private static final long serialVersionUID = 7350122404195799135L;
	@Override
	protected Class getReferenceClass() {
		return CardStatus.class;
	}
	/**
	 * 
	 * @Description: TODO
	 * @param @param key
	 * @param @return
	 * @return Role
	 * @throws
	 */
	public CardStatus get(java.io.Serializable key) {
		return (CardStatus) get(getReferenceClass(), key);
	}
	/**
	 * 
	 * @Description: TODO
	 * @param @param cardemployee   
	 * @return void    
	 * @throws
	 */
	public void saveOrUpdate(CardStatus cardstatus) {
		saveOrUpdate((Object) cardstatus);
	}
	/**
	 * @Description: 功能卡写卡失败进行数据回滚
	 * @param @param cardemployee   
	 * @return void    
	 * @throws
	 */
	public void delete(CardStatus cardstatus) {
		StringBuffer sb = new StringBuffer(
					"delete form CardStatus where asn =? ");
			this.delete(sb.toString(), new Object[] { cardstatus.getAsn() });
	}
}
