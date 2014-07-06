/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.biz;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.newcapec.function.ecardcity.om.model.Department;
import cn.newcapec.framework.core.biz.BaseService;
import cn.newcapec.framework.core.utils.pagesUtils.Page;

/**
 * @author wj
 * @category 部门操作Service
 * @version 1.0
 * @date 2014年3月18日 下午4:07:39
 */
@SuppressWarnings("all")
public interface DepartmentService extends BaseService<Department> {
    /**
     * 保存部门
     * @param id
     * @return
     */
    public void saveOrUpdate(Department paramT);
    
    /**
     * 查询当前满足查询条件的子部门列表，包含当前部门的子部门
     * @param pid 		父部门ID
     * @return List 		根据给定的fatherID返回部门对象列表
     */
    public List<Map<String, Object>> getListByFatherIncludeChildren(Serializable pid);
    
    /**
     * 查询当前满足查询条件的子部门列表，不包含当前部门的子部门
     * @param pid 		父部门ID
     * @return List 		根据给定的fatherID返回部门对象列表
     */
    public List<Map<String, Object>> getListByFatherExcludeChildren(Serializable pid);

    /**
     * 查询当前满足查询条件的子部门页面，包含当前部门的子部门
     * @param pid 		父部门ID
     * @return Page 		根据给定的fatherID返回部门对象列表
     */
    public Page getPageByFatherIncludeChildren(Serializable pid);
    
    /**
     * 查询当前满足查询条件的子部门页面，不包含当前部门的子部门
     * @param pid 		父部门ID
     * @return Page 		根据给定的fatherID返回部门对象列表
     */
    public Page getPageByFatherExcludeChildren(Serializable pid);
    
    /**
     * 批量删除部门
     * @param ids	部门ID数组
     */
    public void delete(String[] ids);
    
    /**
     * 根据属性查找部门列表
     * @param map	属性Map
     */
    public List<Map<String, Object>> getListByAttr(Map<String, Object> attrMap);
}
