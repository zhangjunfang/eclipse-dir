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
import cn.newcapec.function.ecardcity.om.model.Department;

/**
 * @author wj
 * @category 部门操作DAO
 * @version 1.0
 * @date 2014年3月18日 下午1:49:09
 */
@Repository
@SuppressWarnings("all")
public class DepartmentDao extends BaseDao {
    public static final String SQL_DEP_INCLUDE_CHILDREN= "select t.*,decode(t.pid,'0','',(select b.dept_name FROM base_dept b where b.id = t.pid)) p_name from base_dept t start with pid=? connect by prior id=pid order siblings by id asc";
    public static final String SQL_DEP_EXCLUDE_CHILDREN= "select * from base_dept where id not in ( select id from base_dept start with id=? connect by prior id=pid ) order by id";

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<Department> getReferenceClass() {
	return Department.class;
    }
    
    /**
     * 查询指定部门
     * @param key		ID
     * @return Department	根据给定的ID返回当前组织机构中部门对象
     */
    public Department get(java.io.Serializable key) {
	return (Department) get(getReferenceClass(), key);
    }
    
    /**
     * includeChildren=true，则查询当前满足PID条件的子部门列表；includeChildren=false，则查询全部部门并排除当前满足PID条件的子部门列表
     * @param pid 		父部门ID
     * @param includeChildren 	是否包含子部门
     * @return List 		根据给定的fatherID返回部门对象列表
     */
    public List<Map<String, Object>> getListByFather(Serializable pid,boolean includeChildren) {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("pid", pid);
	if(includeChildren){
	    return super.sqlQueryForList(SQL_DEP_INCLUDE_CHILDREN, new Object[]{pid}, null);
	}else{
	    return super.sqlQueryForList(SQL_DEP_EXCLUDE_CHILDREN, new Object[]{pid}, null);
	}
    }
    
    /**
     * includeChildren=true，则查询当前满足PID条件的子部门页面；includeChildren=false，则查询全部部门并排除当前满足PID条件的子部门页面
     * @param pid 		父部门ID
     * @param includeChildren 	是否包含子部门
     * @return Page 		根据给定的fatherID返回部门对象列表
     */
    public Page getPageByFather(Serializable pid,boolean includeChildren) {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("pid", pid);
	if(includeChildren){
	    return super.sqlQueryForPage(SQL_DEP_INCLUDE_CHILDREN, new Object[]{pid}, null);
	}else{
	    return super.sqlQueryForPage(SQL_DEP_EXCLUDE_CHILDREN, new Object[]{pid}, null);
	}
    }

    /**
     * 删除部门
     * @param ids	部门ID
     */
    public void delete(java.io.Serializable id) {
	super.delete(get(id));
    }
    
    /**
     * 批量删除部门
     * @param ids	部门ID数组
     */
    public void delete(String[] ids) {
	if (ids != null && ids.length > 0) {
	    bulkUpdate(true,"delete from Department where id in (:ids)", new String[]{"ids"},new Object[]{ids});
	}
    }
    
    /**
     * 指定ID号的部门下是否有子部门
     * 
     * @param id	ID号
     * @return Boolean 	指定ID号的部门下是否有子部门
     */
    public Boolean hasChildrenDept(Serializable id) {
	BigDecimal rtn=(BigDecimal)super.sqlFindObject("select count(*) from ("+SQL_DEP_INCLUDE_CHILDREN+")",new Object[]{id});
	return rtn.intValue()>0;
    }
}
