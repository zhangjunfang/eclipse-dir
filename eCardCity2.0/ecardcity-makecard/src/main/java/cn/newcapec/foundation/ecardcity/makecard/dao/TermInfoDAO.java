/**
 * 
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.model.TermInfo;
import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;


/**
 * 
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:20:42
 * @version V1.0
 */
@SuppressWarnings("all")
@Repository("terminfoDAO")
public class TermInfoDAO  extends  HibernateEntityDao {

	private static final long serialVersionUID = 7350122404195799135L;
	@Override
	protected Class getReferenceClass() {
		return TermInfo.class;
	}
	/**
	 * 
	 * @Description: TODO
	 * @param @param key
	 * @param @return
	 * @return Role
	 * @throws
	 */
	public TermInfo get(java.io.Serializable key) {
		return (TermInfo) get(getReferenceClass(), key);
	}
	/**
	 * 
	 * @Description: 校验终端
	 * @param @param id
	 * @param @return   
	 * @return CardPsam    
	 * @throws
	 */
	public TermInfo queryTermInfoByPsam(String psamno) { 
		String sql = "select t from TermInfo t where t.psamcardno= ? and t.isuse = 1";
		return (TermInfo)this.findForObject(sql,  new Object[]{psamno});
	}
}
