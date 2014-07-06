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
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.model.Param;

/**
 * @author wj
 * @category 参数操作
 * @version 1.0
 * @date 2014年4月2日 上午12:11:47
 */
public interface ParamService extends BaseService<Param> {
    /**
     * 获取系统参数分页列表
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getSysPageList(Map<String, Object> paramMap);
    
    /**
     * 获取卡参数分页列表
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getCardPageList(Map<String, Object> paramMap);

    /**
     * 根据给定的方式进行卡类型参数初始化
     * 
     * @param id		卡类型ID号
     * @param flag		方式，1:从模板，2:从已有卡
     * @param sourceParamId	模板ID，或已有卡类型ID
     * @return Boolean
     */
    public boolean cardParamsInit(Serializable id,String flag,String sourceParamId);
    /**
     * 根据给定的类型返回参数列表
     * 
     * @param type		卡类型ID号
     * @return List
     */
    public List<?> getPramListByType(String type);
    
}
