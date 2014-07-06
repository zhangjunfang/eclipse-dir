/**
 * 
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.model.Employee;
import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;


/**
 * 
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:20:42
 * @version V1.0
 */
@SuppressWarnings("all")
@Repository("employeeDAO")
public class EmployeeDAO  extends HibernateEntityDao  {

	private static final long serialVersionUID = 7350122404195799135L;
	
	@Override
	protected Class getReferenceClass() {
		return Employee.class;
	}
	/**
	 * @Description: 根据 网点id 查询操作员
	 * @param @param id
	 * @param @param orderby
	 * @param @return   
	 * @return Page    
	 * @throws
	 */ 
	public List<Map<String, Object>> queryByNetsiteId(String id,
			LinkedHashMap<String, String> orderby) {
		String sql = "select * from base_employee t where t.netsite_id = ?";
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
	public Employee get(java.io.Serializable key) {
		return (Employee) get(getReferenceClass(), key);
	}
}
