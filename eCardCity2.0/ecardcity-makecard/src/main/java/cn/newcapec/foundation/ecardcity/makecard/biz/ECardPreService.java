/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.biz;

import net.sf.json.JSONObject;
import cn.newcapec.framework.core.rest.Msg;

/**
 * 密钥前置服务公共业务接口类
 * 
 * @author wulimo
 * 
 */
public interface ECardPreService {

	/**
	 * 前台调用城市密钥前置服务的接口
	 * 
	 * @param param
	 * @return
	 */
	Msg getECardPreServiceCity(JSONObject param);

}
