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
import cn.newcapec.function.ecardcity.om.model.BaseIndustry;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 基础行业信息Service接口
 * @version 1.0
 * @date 2014年5月5日 下午1:49:02
 */
public interface BaseIndustryService extends BaseService<BaseIndustry> {
    /**
     * 根据map，查询指定的基础行业分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getPageList(Map<String, Object> paramMap);
    
    /**
     * 批量删除
     * @param ids	ID数组
     */
    public void delete(String[] ids);
    /**
     * 根据属性查找列表
     * @param map	属性Map
     */
    public List<Map<String, Object>> getListByAttr(Map<String, Object> attrMap);
    /**
     * 根据条件查询是否有存在的记录
     * @param keyValueArr	KeyValue数组
     * @return boolean		是否存在
     */
    public boolean isExists(KeyValue[] keyValueArr);    
}
