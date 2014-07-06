/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.foundation.ecardcity.makecard.util;

/**
 * @author wulimo
 * @category 卡务自定义提示信息常量
 * @version 1.0
 * @date
 */
public class CardTipConstant {
	public static final String TIP_IS_OK = "OK";

	public static final String TIP_GET_SYSCURRUSER_FAIL = "无法获取当前用户信息,请重新登陆！";
	public static final String TIP_DONOT_CAN_OP_CARD = "您无此类卡片操作权限！";

	public static final String TIP_GET_BIZTOTAL_FAIL = "获取及时统计消息失败！";
	public static final String TIP_WEBSERVICE_REQ_FAIL = "ECardPreService请求失败！";

	public static final String TIP_ADDCHARDE_READCARD_FAIL = "充值读卡验证失败！";
	public static final String TIP_ADDCHARDE_REQCHASHTOWALLET_FAIL = "充值申请失败！";
	public static final String TIP_ADDCHARDE_COMMITCHASHTOWALLET_FAIL = "充值提交失败！";
	public static final String TIP_ADDCHARDE_READCARDREQ_FAIL = "读卡请求失败！";
	public static final String TIP_ADDCHARDE_REQPRINT_FAIL = "充值打印请求失败！";

	public static final String TIP_ADDCHARDE_NOT_THIS_TERM = "无法获取终端设备信息！";
	public static final String TIP_ADDCHARDE_NETSTATUS_STOP = "当前网点已停用！";

	public static final String TIP_ADDCHARDE_GET_CUSTCARD_FAIL = "无法获取卡信息！";
	public static final String TIP_ADDCHARDE_CUSTCARDSTATUS_NOT_NOR = "当前卡非正常状态！";
	public static final String TIP_ADDCHARDE_GET_CUST_FAIL = "获取客户信息失败！";

	public static final String TIP_SELLCARD_ISUSED = "此卡已在系统登记使用！";
	public static final String TIP_SELLCARD_READCARD_FAIL = "售卡读卡验证失败！";
	public static final String TIP_SELLCARD_REQ_FAIL = "售卡申请失败！";
	public static final String TIP_SELLCARD_COMMIT_FAIL = "售卡提交失败！";
	public static final String TIP_SELLCARD_REQ_CARDNO_USED = "售卡申请失败(客户卡号已被使用)！";
	public static final String TIP_SELLCARD_REQ_CUST_HAVE_KINDCARD = "售卡申请失败(当前客户已持有此类型卡片)！";
	public static final String TIP_SELLCARD_REQ_CUST_SAVECUST_FAIL = "售卡申请失败(保存客户信息失败)！";
	public static final String TIP_SELLCARD_COMMIT_SAVEAPP_FAIL = "售卡提交失败(生成卡应用信息失败)！";

	public static final String TIP_TERM_IS_DEL = "终端设备已删除！";
	public static final String TIP_TERM_IS_STOP = "终端设备未启用！";
	public static final String TIP_TERM_NOT_MATCH_PSAM = "终端设备PSAM卡不匹配！";
	public static final String TIP_TERM_NOT_AUTH = "终端设备未启用授权！";
	public static final String TIP_SYS_NOT_PSAM = "无法获取终端PSAM卡信息！";
	public static final String TIP_PSAMSTATUS_NOT_NOR = "当前PSAM卡无效！";

	public static final String TIP_CURRENTUSER_NO_LOGINPRIVIT = "当前用户无系统登录权限";
	public static final String TIP_CURRENTUSER_NO_CASHADD = "当前用户无充值权限";
	public static final String TIP_CURRENTUSER_GET_CASHADD_PRIVT_FAULT = "获取用户充值权限失败";
	public static final String TIP_CURR_NET_ODDFARE_NEED = "当前网点授权余额不足";

	public static final String TIP_QUASHADDCHARGE_GETAPPLYINFO_FAULT = "获取充值计划信息失败";
	public static final String TIP_QUASHADDCHARGE_NO_ADDINFO = "没有充值信息";
	public static final String TIP_QUASHADDCHARGE_GETINFO_FAULT = "获取充值信息失败";
	public static final String TIP_QUASHADDCHARGE_CORRECT_FLAG_ERR = "充值记录数据异常(撤销标记错)";
	public static final String TIP_QUASHADDCHARGE_HAVE_UNSETILADDINFO = "充值撤销失败(存在充值未决信息)";
	public static final String TIP_QUASHADDCHARGE_CARDANDDB_OPCNT_NOTSAME = "充值撤销失败(卡库消费计数不一致)";

	public static final String TIP_QUASHADDCHARGE_REQFAULT = "充值撤销申请失败";
	public static final String TIP_QUASHADDCHARGE_REQFAULT_PWDERR = "充值撤销申请失败(撤销密码错)";
	public static final String TIP_QUASHADDCHARGE_REQFAULT_GETCHRKEYERR = "充值撤销申请失败(获取充值密钥失败)";

	public static final String TIP_QUASHADDCHARGE_COMMITFAULT = "充值撤销提交失败";

	public static final String TIP_QUERYCUST_FAULT = "查询客户信息异常";
	public static final String TIP_QUERYCUST_NORS = "没有找到客户信息";

}