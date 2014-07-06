/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.biz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * 客户信息查询接口类
 * 
 * @author wulimo
 * 
 */
public interface QueryCustInfoService {

	/**
	 * 读卡查询
	 * 
	 * @param param
	 * @return Msg
	 */
	@SuppressWarnings("rawtypes")
	List readCardQuery(JSONObject param);

	/**
	 * 模糊搜索
	 * 
	 * @param param
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map searchCustList(JSONObject param);

	/**
	 * 查看客户详情
	 * 
	 * @param param
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map getCustDetail(JSONObject param);
}
