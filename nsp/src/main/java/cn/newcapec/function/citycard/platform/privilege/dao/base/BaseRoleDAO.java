package cn.newcapec.function.citycard.platform.privilege.dao.base;

import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;

/**
 * 角色接口实现类
 * 
 * @author andy.li
 * 
 */

@SuppressWarnings("all")
public abstract class BaseRoleDAO extends HibernateEntityDao {

	@Override
	protected Class getReferenceClass() {
		return cn.newcapec.function.citycard.platform.privilege.model.Role.class;
	}

	public BaseRoleDAO() {

	}

	public cn.newcapec.function.citycard.platform.privilege.model.Role cast(Object object) {
		return (cn.newcapec.function.citycard.platform.privilege.model.Role) object;
	}

	public cn.newcapec.function.citycard.platform.privilege.model.Role load(
			java.io.Serializable key) {
		return (cn.newcapec.function.citycard.platform.privilege.model.Role) load(
				getReferenceClass(), key);
	}

	public cn.newcapec.function.citycard.platform.privilege.model.Role get(
			java.io.Serializable key) {
		return (cn.newcapec.function.citycard.platform.privilege.model.Role) get(
				getReferenceClass(), key);
	}

	public java.util.List findAll() {
		return find("from " + getReferenceClass().getName());
	}

	public void save(cn.newcapec.function.citycard.platform.privilege.model.Role role) {
		super.save(role);
	}

	public void saveOrUpdate(cn.newcapec.function.citycard.platform.privilege.model.Role role) {
		saveOrUpdate((Object) role);
	}

	public void update(cn.newcapec.function.citycard.platform.privilege.model.Role role) {
		update((Object) role);
	}

	public void delete(java.io.Serializable id) {
		delete((Object) load(id));
	}

	public void delete(cn.newcapec.function.citycard.platform.privilege.model.Role role) {
		delete((Object) role);
	}

}
