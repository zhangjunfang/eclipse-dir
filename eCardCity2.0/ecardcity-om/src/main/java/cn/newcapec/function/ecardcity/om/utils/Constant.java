/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.utils;

/**
 * @author wj
 * @category 当前类描述
 * @version 1.0
 * @date 2014年3月24日 下午4:57:23
 */
public class Constant {
	public static final String SESSION_USER = "user";		// 登录系统后session中保存的用户信息
	public static final String SESSION_MENU = "menu";		// 登录系统后session中保存菜单信息
	
	public static final String ACT_ADD = "add";			//action为添加
	public static final String ACT_UPDATE = "update";		//action为修改

	public static final String RECORD_DEL = "1"; 			// 记录删除的标记
	public static final String RECORD_DEL_NOT = "0";		// 记录未删除的标记

	public static final String STATE_VALID = "1";			//状态，有效
	public static final String STATE_INVALID = "0";			//状态，无效
	
	public static final String NETSITE_TYPE_COMPOSITE = "2";	//网点类型，综合网点
	public static final String NETSITE_TYPE_CONSUME = "1";		//网点类型，消费网点
	public static final String NETSITE_TYPE_RECHARGE = "0";		//网点类型，充值网点

	public static final String NETSITE_KIND_AGENT = "1";		//网点种类，代理（商户）
	public static final String NETSITE_KIND_DIRECT = "0";		//网点种类，直属

	public static final String NETSITE_BANK_PUBLIC_ACCOUNT = "1";		//网点账号性质：对公
	public static final String NETSITE_BANK_PUBLIC_ACCOUNT_NOT = "0";	//网点账号性质：非对公
	
	
	public static final String RECORD_USED_INVALID = "0";		//是否使用：0-禁用，
	public static final String RECORD_USED_VALID = "1";		//1-启用
	public static final String RECORD_USED_PAUSE = "2";		//2-维修停用
	public static final String RECORD_USED_DAMAGE = "3";		//3-损坏
	public static final String RECORD_USED_NOT = "4";		//4：改成非启用状态后，不可以再启用
	
	public static final String PERCENT_SIGN = "%";			//%,like操作用到

	public static final String DIC_BANK = "0014";		//银行
	public static final String DIC_CARD_BIG_TYPE = "0024";		//卡类别
	public static final String DIC_CARD_BIG_TYPE_COMMON = "1";	//卡类别,普通卡
	public static final String DIC_LIB_PARAM_TYPE = "0018";		//模版参数类别
	public static final String DIC_SYS_PARAM_TYPE = "0019";		//系统参数类别
	public static final String DIC_PRINT_PARAM_TYPE = "0026";	//终端打印模板类型
	public static final String DIC_TERM_TRADE_TYPE = "0027";	//终端交易类型
	public static final String DIC_SYS_PRINT_PARAM_CODE = "7";	//系统打印参数字典值

	public static final String PARAM_TERM_GENERAL = "6";		//终端通用参数
	public static final Integer TERM_MENU_PERMISSION_START_LOC = 6;	//自定义菜单可用权限列表起始位置

}