package cn.newcapec.function.citycard.platform.privilege.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.function.citycard.platform.privilege.biz.DepartmentRoleService;
import cn.newcapec.function.citycard.platform.privilege.dao.DepartmentRoleDAO;
import cn.newcapec.function.citycard.platform.privilege.model.DepartmentRole;

/**
 * 权限部门业务接口实现类
 * @author andy.li
 *
 */
@Service("departmentRoleService")
@Transactional
@SuppressWarnings("all")
public class DepartmentRoleServiceImpl   implements DepartmentRoleService {

	@Autowired
	 DepartmentRoleDAO departmentRoleDAO;
	
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public DepartmentRole get(String id) {
		return departmentRoleDAO.get(id);
	}

	@Override
	public void removeUnused(String id) {
		departmentRoleDAO.delete(id);
	}

	@Override
	public void saveOrUpdate(DepartmentRole entity) {
		departmentRoleDAO.saveOrUpdate(entity);
	}

	@Override
	public void deleteDepartmentRoleByRoleId(String roleid) {
		departmentRoleDAO.deleteDepartmentRoleByRoleId(roleid);
	}

}
