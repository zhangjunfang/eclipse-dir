/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.biz;

import java.util.Map;

import cn.newcapec.framework.core.biz.BaseService;
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.model.ParamLib;

/**
 * @author wj
 * @category 参数模板操作
 * @version 1.0
 * @date 2014年4月1日 上午9:11:47
 */
public interface ParamLibService extends BaseService<ParamLib> {
    /**
     * 获取分页列表
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getPageList(Map<String, Object> paramMap);

}
