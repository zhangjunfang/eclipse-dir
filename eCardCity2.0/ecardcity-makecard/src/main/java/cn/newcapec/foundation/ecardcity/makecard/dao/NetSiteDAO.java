/**
 * 
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.model.Employee;
import cn.newcapec.foundation.ecardcity.makecard.model.NetSite;
import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;


/**
 * 
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:20:42
 * @version V1.0
 */
@SuppressWarnings("all")
@Repository("netsiteDAO")
public class NetSiteDAO  extends  HibernateEntityDao {

	private static final long serialVersionUID = 7350122404195799135L;
	@Override
	protected Class getReferenceClass() {
		return NetSite.class;
	}
	/**
	 * @Description: 根据父节点查询子节点
	 * @param @param id
	 * @param @param orderby
	 * @param @return   
	 * @return Page    
	 * @throws
	 */ 
	public List<Map<String, Object>> queryByPid(String id, LinkedHashMap<String, String> orderby) {
//		String sql = "select * from net_site where netid_p = ?";
		String sql = "select * from net_site start with netid_p = ? "
                   + "connect by prior id = netid_p "
                   + "order siblings by id asc";
		return this.sqlQueryForList(sql, new Object[]{id}, orderby);
	}
	/**
	 * 
	 * @Description: TODO
	 * @param @param key
	 * @param @return
	 * @return Role
	 * @throws
	 */
	public NetSite get(java.io.Serializable key) {
		return (NetSite) get(getReferenceClass(), key);
	}
}
