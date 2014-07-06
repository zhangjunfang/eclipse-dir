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

import cn.newcapec.framework.core.biz.BaseService;
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.model.NetSiteBank;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 网点账号服务接口
 * @version 1.0
 * @date 2014年5月12日 下午2:50:00
 */
public interface NetSiteBankService extends BaseService<NetSiteBank> {
    /**
     * 根据map，查询指定的网点分页
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
     * 批量删除网点账号
     * @param ids	ID数组
     */
    public void delete(String[] ids);
    /**
     * 根据网点ID，查询可用的网点账号
     * @param netSiteId	 	网点ID
     * @return List 		可用的网点账号列表
     */
    public List getListByNetSiteID(String netSiteId);
}
