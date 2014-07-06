/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.biz.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.framework.core.exception.BaseException;
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.biz.DepartmentService;
import cn.newcapec.function.ecardcity.om.dao.DepartmentDao;
import cn.newcapec.function.ecardcity.om.dao.DepartmentMappingDao;
import cn.newcapec.function.ecardcity.om.model.Department;

/**
 * @author wj
 * @category 部门实体业务实现类
 * @version 1.0
 * @date 2014年3月19日 上午9:11:54
 */
@Service("DepartmentService")
@Transactional
@SuppressWarnings("all")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private DepartmentMappingDao departmentMappingDao;
	
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Department get(String arg0) {
	return departmentDao.get(arg0);
    }
    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.DepartmentService#saveOrUpdate(cn.newcapec.function.ecardcity.om.model.Department)
     */
    @Override
    public void saveOrUpdate(Department paramT) {
	departmentDao.saveOrUpdate(paramT);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#removeUnused(java.lang.String)
     */
    @Override
    public void removeUnused(String arg0) {
	this.delete(new String[]{arg0});
    }
    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.DepartmentService#delete(java.lang.String[])
     */
    @Override
    public void delete(String[] ids) {
	for(String id:ids){
	    if(departmentDao.hasChildrenDept(id)){
		log.error("ID为"+id+"的部门下有子部门，请先删除子部门！");
		throw new BaseException("ID为"+id+"的部门下有子部门，请先删除子部门！");
	    }
	    if(departmentMappingDao.hasDeptMappingByDep(id)){
		log.error("ID为"+id+"的部门下有用户，请先删除用户！");
		throw new BaseException("ID为"+id+"的部门下有用户，请先删除用户！");
	    }
	}
	departmentDao.delete(ids);
    }

    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public List<Map<String, Object>> getListByFatherIncludeChildren(
	    Serializable pid) {
	return departmentDao.getListByFather(pid, true);
    }

    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public List<Map<String, Object>> getListByFatherExcludeChildren(
	    Serializable pid) {
	return departmentDao.getListByFather(pid, false);
    }

    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Page getPageByFatherIncludeChildren(Serializable pid) {
	return departmentDao.getPageByFather(pid, true);
    }

    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Page getPageByFatherExcludeChildren(Serializable pid) {
	return departmentDao.getPageByFather(pid, false);
    }
    
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public List<Map<String, Object>> getListByAttr(Map<String, Object> attrMap) {
	return (List<Map<String, Object>>) departmentDao.getListByAttr(attrMap, Department.class,new Order[]{Order.asc("id")});
    }
}
