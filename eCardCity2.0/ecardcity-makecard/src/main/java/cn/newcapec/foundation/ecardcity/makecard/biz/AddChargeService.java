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
 * 充值业务接口类
 * 
 * @author wulimo
 * 
 */
public interface AddChargeService {

	/**
	 * 充值--读卡操作
	 * 
	 * @param param
	 * @return Msg
	 */
	Msg readCardForAddCharge(JSONObject param);

	/**
	 * 充值--充值操作：充值申请
	 * 
	 * @param param
	 * @return
	 */
	Msg reqChashToWallet(JSONObject param);

	/**
	 * 充值--充值操作：充值提交
	 * 
	 * @param param
	 * @return
	 */
	Msg commitChashToWallet(JSONObject param);

}
