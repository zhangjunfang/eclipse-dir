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

import cn.newcapec.framework.core.biz.BaseService;
import cn.newcapec.function.ecardcity.om.model.DepartmentMapping;

/**
 * @author wj
 * @category 部门操作Service
 * @version 1.0
 * @date 2014年3月18日 下午4:07:39
 */
@SuppressWarnings("all")
public interface DepartmentMappingService extends BaseService<DepartmentMapping> {
    /**
     * 根据部门获取映射记录
     * @param depId 		部门ID
     * @return List 		部门用户映射列表
     */
    public List<Map<String, Object>> getListByDep(Serializable depId);
    
    /**
     * 根据对象属性获取映射记录
     * @param  attrMap 		MAP
     * @return List 		部门用户映射列表
     */
    public List<Map<String, Object>> getListByAttr(Map<String, Object> attrMap);
    
    /**
     * 保存映射记录
     * @param id
     * @return
     */
    public void saveOrUpdate(DepartmentMapping paramT);
    
    /**
     * 保存映射记录
     * @param id
     * @return
     */

    /**
     * 根据部门批量删除映射记录
     * @param ids	部门ID数组
     */
    public void deleteByDep(Serializable depId);
    
}
