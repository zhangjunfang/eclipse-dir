/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.biz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import cn.newcapec.framework.core.biz.BaseService;
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.model.BaseEmployee;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 操作员服务接口
 * @version 1.0
 * @date 2014年5月13日 下午4:50:00
 */
public interface BaseEmployeeService extends BaseService<BaseEmployee> {
    /**
     * 根据map，查询指定的操作员分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回分页列表
     */
    public Page<?> getPage(Map<String, Object> paramMap);
    /**
     * 根据map，查询指定的列表
     * @param param	 	参数Map
     * @return List 		根据给定的map返回分页列表
     */
    public List<?> getList(Map<String, Object> paramMap);
    /**
     * 根据条件查询是否有存在的记录
     * @param keyValueArr	KeyValue数组
     * @return boolean		是否存在
     */
    public boolean isExists(KeyValue[] keyValueArr);
    /**
     * 批量删除操作员账号
     * @param ids	ID数组
     */
    public void delete(String[] ids);
    /**
     * 根据给定的JSON格式用户表，排除操作员表中已经存在的用户
     * @param users		JSON格式的用户数组
     * @return JSONArray	排除操作员表中已存在用户后的JSON格式的用户数组
     */
    public JSONArray getUsersFliterEployee(JSONArray users);
    /**
     * 查询的最大empID
     * @return Integer		当前最大的empID
     */
    public int getMaxEmpID();    
}
