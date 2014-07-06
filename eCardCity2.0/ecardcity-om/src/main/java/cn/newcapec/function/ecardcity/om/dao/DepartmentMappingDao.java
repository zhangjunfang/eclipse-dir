/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.dao.base.BaseDao;
import cn.newcapec.function.ecardcity.om.model.DepartmentMapping;

/**
 * @author wj
 * @category 部门映射操作DAO
 * @version 1.0
 * @date 2014年3月26日 下午1:49:09
 */
@Repository
@SuppressWarnings("all")
public class DepartmentMappingDao extends BaseDao {

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<DepartmentMapping> getReferenceClass() {
	return DepartmentMapping.class;
    }
    
    /**
     * 查询指定部门映射
     * @param key		ID
     * @return DepartmentMapping	根据给定的ID返回当前组织机构中部门对象
     */
    public DepartmentMapping get(java.io.Serializable key) {
	return (DepartmentMapping) get(getReferenceClass(), key);
    }
    
    /**
     * 删除部门映射
     * @param ids	部门映射ID
     */
    public void delete(java.io.Serializable id) {
	delete(get(id));
    }
    
    /**
     * 根据部门删除部门映射
     * @param id	部门ID
     */
    public void deleteByDep(java.io.Serializable id) {
	if (id != null ) {
	    super.bulkUpdate(true,"delete from DepartmentMapping where dept_id in (:depid)", new String[]{"depid"},new Object[]{id});
	}
    }
    
    /**
     * 指定ID号的部门下是否有子部门
     * 
     * @param id	部门ID号
     * @return Boolean 	指定ID号的部门下是否有部门映射记录
     */
    public Boolean hasDeptMappingByDep(Serializable id) {
	BigDecimal rtn=(BigDecimal)super.sqlFindObject("select count(*) from base_dept_mapping where dept_id=?",new Object[]{id});
	return rtn.intValue()>0;
    }

}
