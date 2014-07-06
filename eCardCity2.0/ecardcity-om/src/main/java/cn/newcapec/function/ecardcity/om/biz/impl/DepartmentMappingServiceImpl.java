/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.biz.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.function.ecardcity.om.biz.DepartmentMappingService;
import cn.newcapec.function.ecardcity.om.dao.DepartmentMappingDao;
import cn.newcapec.function.ecardcity.om.model.Department;
import cn.newcapec.function.ecardcity.om.model.DepartmentMapping;

/**
 * @author wj
 * @category 部门映射操作Service
 * @version 1.0
 * @date 2014年3月26日 下午4:50:29
 */
@Service("DepartmentMappingService")
@Transactional
@SuppressWarnings("all")
public class DepartmentMappingServiceImpl implements DepartmentMappingService {
    @Autowired
    private DepartmentMappingDao departmentMappingDao;

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public DepartmentMapping get(String arg0) {
	return departmentMappingDao.get(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#removeUnused(java.lang.String)
     */
    @Override
    public void removeUnused(String arg0) {
	departmentMappingDao.delete(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.DepartmentMappingService#saveOrUpdate(cn.newcapec.function.ecardcity.om.model.DepartmentMapping)
     */
    @Override
    public void saveOrUpdate(DepartmentMapping paramT) {
	departmentMappingDao.saveOrUpdate(paramT);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.DepartmentMappingService#getListByDep(java.io.Serializable)
     */
    @Override
    public List<Map<String, Object>> getListByDep(Serializable depId) {
	Map<String, Object> attrMap=new HashMap<String, Object>();
	attrMap.put("dept_id", depId);	
	return getListByAttr(attrMap);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.DepartmentMappingService#deleteByDep(java.io.Serializable)
     */
    @Override
    public void deleteByDep(Serializable depId) {
	departmentMappingDao.deleteByDep(depId);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.DepartmentMappingService#getListByAttr(java.util.Map)
     */
    @Override
    public List<Map<String, Object>> getListByAttr(Map<String, Object> attrMap) {
	return (List<Map<String, Object>>) departmentMappingDao.getListByAttr(attrMap, DepartmentMapping.class,null);
    }
}
