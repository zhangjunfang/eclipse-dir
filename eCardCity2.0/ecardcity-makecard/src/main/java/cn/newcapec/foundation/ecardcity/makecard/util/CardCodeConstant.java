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
 * @category 定义卡务编码Code相关的常量
 * @version 1.0
 * @date
 */
public class CardCodeConstant {

	/**
	 * 0001 民族
	 */
	public static final String CODE_DICT_NATION = "0001";

	/**
	 * 0003 证件名称
	 */
	public static final String CODE_DICT_CERTIFICATETYPE = "0003";
	/**
	 * 0006 国家和地区代码
	 */
	public static final String CODE_DICT_COUNTRY = "0006";
	/**
	 * 0008 性别
	 */
	public static final String CODE_DICT_SEX = "0008";
	/**
	 * 0008 性别 男
	 */
	public static final String CODE_DICT_SEX1 = "1";
	/**
	 * 0008 性别 女
	 */
	public static final String CODE_DICT_SEX0 = "0";

	/**
	 * 0024 市民卡大类信息表 卡大类（00：普通卡，01：福利卡,02、管理卡,03:其他）
	 */
	public static final String CODE_DICT_CARDTYPEGROUP = "0024";
	/**
	 * 0028 终端类型(1读卡器 2 出纳机 3 圈存机 4 营业机 5 综合缴费)
	 */
	public static final String CODE_DICT_TERMTYPEGROUP = "0028";

	/**
	 * 市民卡大类（00：普通卡，01：福利卡,02、管理卡,03:其他）
	 */
	public static final String CODE_CARDTYPEGROUP_0 = "0";
	/**
	 * 市民卡大类（00：普通卡，01：福利卡,02、管理卡,03:其他）
	 */
	public static final String CODE_CARDTYPEGROUP_1 = "1";
	/**
	 * 市民卡大类（00：普通卡，01：福利卡,02、管理卡,03:其他）
	 */
	public static final String CODE_CARDTYPEGROUP_2 = "2";
	/**
	 * 市民卡大类（00：普通卡，01：福利卡,02、管理卡,03:其他）
	 */
	public static final String CODE_CARDTYPEGROUP_3 = "3";

	// 交易种类 编码////////////////////////////////////////////////////////
	/**
	 * 0015 交易种类 字典对应编码
	 */
	public static final String CODE_DICT_BUSINESSTYPE = "0015";
	/**
	 * 交易种类编码值 1消费
	 */
	public static final String CODE_DICT_BUSINESSTYPE_1 = "1";
	/**
	 * 交易种类编码值 2存款
	 */
	public static final String CODE_DICT_BUSINESSTYPE_2 = "2";
	/**
	 * 交易种类编码值 3取款
	 */
	public static final String CODE_DICT_BUSINESSTYPE_3 = "3";
	/**
	 * 交易种类编码值 4冻结金额
	 */
	public static final String CODE_DICT_BUSINESSTYPE_4 = "4";

	// 交易科目类编码///////////////////////////////////////////////////////////////

	/**
	 * 科目代码：PC钱包充值-1001：PC电子钱包充值
	 */
	public static final String ACCCODE_ADDCHARGE_CASHADD = "1001";
	/**
	 * 科目代码：PC钱包充值-1006：PC电子钱包支票充值
	 */
	public static final String ACCCODE_ADDCHARGE_COSTADD = "1006";
	/**
	 * 科目代码：PC钱包充值-1001：PC电子钱包充值
	 */
	public static final String ACCCODE_ADDCHARGE_CASHADD_DESC = "PC电子钱包充值";
	/**
	 * 科目代码：PC钱包充值-1006：PC电子钱包支票充值
	 */
	public static final String ACCCODE_ADDCHARGE_COSTADD_DESC = "PC电子钱包支票充值";

	/**
	 * 科目代码：在线充值-1002：PC在线账户充值
	 */
	public static final String ACCCODE_ADDCHARGE_ONLINE = "1002";
	/**
	 * 科目代码：在线充值-1007：PC在线账户支票充值
	 */
	public static final String ACCCODE_ADDCHARGE_ONLINECOST = "1007";
	/**
	 * 科目代码：在线充值-1002：PC在线账户充值
	 */
	public static final String ACCCODE_ADDCHARGE_ONLINE_DESC = "PC在线账户充值";
	/**
	 * 科目代码：在线充值-1007：PC在线账户支票充值
	 */
	public static final String ACCCODE_ADDCHARGE_ONLINECOST_DESC = "PC在线账户支票充值";

	/**
	 * 科目代码：钱包取款-2101：电子钱包取款
	 */
	public static final String ACCCODE_LOADCHARGE_CASH = "2101";
	/**
	 * 科目代码：在线账户取款-2102：在线账户取款
	 */
	public static final String ACCCODE_LOADCHARGE_ONLINE = "2102";
	/**
	 * 科目代码：钱包取款-2101：电子钱包取款
	 */
	public static final String ACCCODE_LOADCHARGE_CASH_DESC = "电子钱包取款";
	/**
	 * 科目代码：在线账户取款-2102：在线账户取款
	 */
	public static final String ACCCODE_LOADCHARGE_ONLINE_DESC = "在线账户取款";

	/**
	 * 科目代码：电子钱包充值撤销-2103：电子钱包充值撤销
	 */
	public static final String ACCCODE_QUASH_ADDCHARGE_CASHADD = "2103";
	/**
	 * 科目代码：电子钱包充值撤销-2103：电子钱包充值撤销
	 */
	public static final String ACCCODE_QUASH_ADDCHARGE_CASHADD_DESC = "电子钱包充值撤销";
	/**
	 * 科目代码：消费纠错-1010：消费纠错
	 */
	public static final String ACCCODE_CASHCONSUME_CORRECT = "1010";
	/**
	 * 科目代码：消费纠错-1010：消费纠错
	 */
	public static final String ACCCODE_CASHCONSUME_CORRECT_DESC = "消费纠错";

	/**
	 * 科目代码：售卡-3001：开户卡成本费
	 */
	public static final String ACCCODE_SELLCARD_NEWCARDFARE = "3001";
	/**
	 * 科目代码：售卡-3001：开户卡成本费
	 */
	public static final String ACCCODE_SELLCARD_NEWCARDFARE_DESC = "开户卡成本费";

	/**
	 * 科目代码：售卡-3101：新卡手续费
	 */
	public static final String ACCCODE_SELLCARD_OPPFARE = "3101";
	/**
	 * 科目代码：售卡-3101：新卡手续费
	 */
	public static final String ACCCODE_SELLCARD_OPPFARE_DESC = "新卡手续费";
	/**
	 * 科目代码：售卡-3005：工本附加费
	 */
	public static final String ACCCODE_SELLCARD_CARDTAOFARE = "3005";
	/**
	 * 科目代码：售卡-3005：工本附加费
	 */
	public static final String ACCCODE_SELLCARD_CARDTAOFARE_DESC = "工本附加费";

	/**
	 * 科目代码：冻结金额领款-5001：冻结金额领款
	 */
	public static final String ACCCODE_FROZEN_GETFARE = "5001";
	/**
	 * 科目代码：冻结金额领款-5001：冻结金额领款
	 */
	public static final String ACCCODE_FROZEN_GETFARE_DESC = "冻结金额领款";

}