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

import org.hibernate.criterion.Order;

import cn.newcapec.framework.core.biz.BaseService;
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.model.PrintTemplate;

/**
 * @author wj
 * @category 打印模板服务接口
 * @version 1.0
 * @date 2014年4月15日 上午9:51:10
 */
public interface PrintTemplateService extends BaseService<PrintTemplate> {
    /**
     * 根据map，查询指定的模板参数分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回分页列表
     */
    public Page<?> getPage(Map<String, Object> paramMap);
    /**
     * 批量删除模板参数
     * @param ids	ID数组
     */
    public void delete(String[] ids);
    /**
     * 根据模板名称删除模板参数
     * @param templateName	模板名称
     */
    public void deleteByName(String templateName);
    
    /**
     * 根据map，查询指定的模板列表
     * @param type	 	模板类型
     * @return Page 		根据给定的map返回列表
     */
    public List<?> getListByType(String type);
    /**
     * 根据map，查询商户分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getTraderPage(Map<String, Object> paramMap);
    /**
     * 根据模板进行参数复制
     * 
     * @param targetTemplate	目标模板
     * @param traderID		目标商户
     * @param sourceTemplate	源模板
     * @return Boolean
     */
    public boolean copyTemplate(String targetTemplate,String traderID,String sourceTemplate);
    
    /**
     * 判断该商户下是否存在该类型的打印模板
     * 
     * @param templateType	当前模板
     * @param traderID		商户
     * @return Boolean
     */
    public boolean hasExistsTemplate(String templateType,String traderID);
    
    /**
     * 根据属性获取模板列表
     * 
     * @param param		参数Map
     * @param orders		排序字段
     * @return List
     */
    public List<?> getListByAttr(Map<String, Object> param,Order[] orders);
}
