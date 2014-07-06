/**
 * 
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.model.CardEmployee;
import cn.newcapec.foundation.ecardcity.makecard.model.Employee;
import cn.newcapec.foundation.ecardcity.makecard.model.NetSite;
import cn.newcapec.foundation.ecardcity.makecard.model.SystemBlack;
import cn.newcapec.foundation.ecardcity.makecard.util.CardUtil;
import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;


/**
 * 
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:20:42
 * @version V1.0
 */
@SuppressWarnings("all")
@Repository("SystemBlackDAO")
public class SystemBlackDAO  extends  HibernateEntityDao {

	private static final long serialVersionUID = 7350122404195799135L;
	@Override
	protected Class getReferenceClass() {
		return SystemBlack.class;
	}
	/**
	 * @Description: 查询 --待用
	 * @param @param id
	 * @param @param orderby
	 * @param @return   
	 * @return Page    
	 * @throws
	 */ 
	public List<Map<String, Object>> queryByPid(String id, LinkedHashMap<String, String> orderby) {
		String sql = "select * from system_black where netid_p = ?";
		return this.sqlQueryForList(sql, new Object[]{id}, orderby);
	}
	/**
	 * @Description: 更新 解挂
	 * @param @param asn   
	 * @return void    
	 * @throws
	 */ 
	public void updateunLoss(String asn) {
		StringBuffer sb = new StringBuffer(
				"update SystemBlack set state = 1 edit_date =? where asn =? ");
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
	public SystemBlack get(java.io.Serializable key) {
		return (SystemBlack) get(getReferenceClass(), key);
	}
	/**
	 * 
	 * @Description: TODO
	 * @param @param cardemployee   
	 * @return void    
	 * @throws
	 */
	public void saveOrUpdate(SystemBlack systemblack) {
		saveOrUpdate((Object) systemblack);
	}
	
}
