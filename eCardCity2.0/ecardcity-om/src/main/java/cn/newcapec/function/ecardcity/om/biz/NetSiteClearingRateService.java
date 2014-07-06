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
import cn.newcapec.function.ecardcity.om.model.NetSiteClearingRate;

/**
 * @author wj
 * @category 网点费率设置服务接口
 * @version 1.0
 * @date 2014年5月15日 下午5:50:00
 */
public interface NetSiteClearingRateService extends BaseService<NetSiteClearingRate> {
    /**
     * 根据map，查询指定的列表
     * @param param	 	参数Map
     * @return List 		根据给定的map返回分页列表
     */
    public List<?> getList(Map<String, Object> paramMap);
    /**
     * 根据网点ID，查询指定的网点结算费率设置数据，没有则返回null
     * @param netSiteId	 		网点ID
     * @return NetSiteClearingRate 	网点结算费率设置对象
     */
    public NetSiteClearingRate getByNetSiteID(String netSiteId);
}
