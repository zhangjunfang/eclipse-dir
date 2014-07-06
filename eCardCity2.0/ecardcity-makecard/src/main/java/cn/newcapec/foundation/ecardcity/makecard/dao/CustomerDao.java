/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.dao;

import org.springframework.stereotype.Repository;

import cn.newcapec.foundation.ecardcity.makecard.model.Customer;
import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;

/**
 * 客户数据操作类
 * 
 * @author wulimo
 * 
 */
@Repository
@SuppressWarnings("all")
public class CustomerDao extends HibernateEntityDao {

	@Override
	protected Class getReferenceClass() {
		return Customer.class;
	}

	public Customer cast(Object object) {
		return (Customer) object;
	}

	public Customer get(java.io.Serializable key) {
		return (Customer) get(getReferenceClass(), key);
	}

	public java.util.List findAll() {
		return find("from " + getReferenceClass().getName());
	}

	public void save(Customer Customer) {
		super.save(Customer);
	}

	public void saveOrUpdate(Customer Customer) {
		saveOrUpdate((Object) Customer);
	}

	public void update(Customer Customer) {
		update((Object) Customer);
	}

	public void delete(java.io.Serializable id) {
		delete((Object) get(id));
	}

	public void delete(Customer Customer) {
		delete((Object) Customer);
	}

}
