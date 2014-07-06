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
import cn.newcapec.function.ecardcity.om.model.TermInfo;

/**
 * @author wj
 * @category 终端服务接口
 * @version 1.0
 * @date 2014年4月22日 下午18:05:10
 */
public interface TermInfoService extends BaseService<TermInfo> {
    /**
     * 根据map，查询指定的模板参数分页
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
     * 批量删除模板参数
     * @param ids	ID数组
     */
    public void delete(String[] ids);
    /**
     * 根据termid，查询该终端可用的业务类型位置
     * @param termid	 	终端ID
     * @return String 		终端业务类型编号，逗号分隔
     */
    public String getBusinessTypeByTerm(String termid);    
}
