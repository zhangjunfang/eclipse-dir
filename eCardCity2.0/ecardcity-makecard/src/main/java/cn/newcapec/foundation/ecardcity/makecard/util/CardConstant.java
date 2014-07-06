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
 * @category 定义卡务常量
 * @version 1.0
 * @date
 */
public class CardConstant {
	public static final String STATUS_STOP = "0";

	/**
	 * 结果是否 0：否、1：是
	 */
	public static final String RS_IS = "1";
	/**
	 * 结果是否 0：否、1：是
	 */
	public static final String RS_NOTIS = "0";

	/**
	 * 终端网点状态 0：停用、1：正常
	 */
	public static final String STATUS_NOR = "1";
	/**
	 * NETTYPE网点类型 0-充值网点 1-综合网点
	 */
	public static final String NETTYPE_ADD = "0";
	/**
	 * NETTYPE网点类型 0-充值网点 1-综合网点
	 */
	public static final String NETTYPE_ALL = "1";
	/**
	 * NETKIND网点种类 网点种类 0-直属 1-代理
	 */
	public static final String NETKIND_SELF = "0";
	/**
	 * NETKIND网点种类 网点种类 0-直属 1-代理
	 */
	public static final String NETKIND_NOSELF = "1";

	/**
	 * PSAM卡状态 0-初始状态 1-正在使用 10-挂失 11-损坏 12-注销
	 */
	public static final String PSAMSTATUS_START = "0";
	/**
	 * PSAM卡状态 0-初始状态 1-正在使用 10-挂失 11-损坏 12-注销
	 */
	public static final String PSAMSTATUS_NOR = "1";
	/**
	 * PSAM卡状态 0-初始状态 1-正在使用 10-挂失 11-损坏 12-注销
	 */
	public static final String PSAMSTATUS_LOSSED = "10";
	/**
	 * PSAM卡状态 0-初始状态 1-正在使用 10-挂失 11-损坏 12-注销
	 */
	public static final String PSAMSTATUS_DAID = "11";
	/**
	 * PSAM卡状态 0-初始状态 1-正在使用 10-挂失 11-损坏 12-注销
	 */
	public static final String PSAMSTATUS_LOGINOUT = "12";
	/**
	 * 卡介质类型 1-M1卡 2-CPU卡
	 */
	public static final String CARDKIND_M1 = "1";
	/**
	 * 卡介质类型 1-M1卡 2-CPU卡
	 */
	public static final String CARDKIND_CPU = "1";
	/**
	 * 缴费记录状态 0x00-正常记录 0x01-灰色记录 0x02-MAC校验错
	 */
	public static final String FARESTATUS_OPCODE_NOR = "0x00";
	/**
	 * 缴费记录状态 0x00-正常记录 0x01-灰色记录 0x02-MAC校验错
	 */
	public static final String FARESTATUS_OPCODE_GRAY = "0x01";
	/**
	 * 缴费记录状态 0x00-正常记录 0x01-灰色记录 0x02-MAC校验错
	 */
	public static final String FARESTATUS_OPCODE_MACERR = "0x02";

	/**
	 * 卡状态，根据字典类别查找并引用【原：0：睡眠、1：正常、3：挂失】
	 */
	public static final String CUST_CARDSTATUS_START = "0";
	/**
	 * 卡状态，根据字典类别查找并引用【原：0：睡眠、1：正常、3：挂失】
	 */
	public static final String CUST_CARDSTATUS_NOR = "1";
	/**
	 * 卡状态，根据字典类别查找并引用【原：0：睡眠、1：正常、3：挂失】
	 */
	public static final String CUST_CARDSTATUS_LOSS = "3";
	/**
	 * 发卡类型 0新发卡1补卡2换卡
	 */
	public static final String SELLCARED_TYPE_PTY0 = "0";
	/**
	 * 发卡类型 0新发卡1补卡2换卡
	 */
	public static final String SELLCARED_TYPE_PTY1 = "1";
	/**
	 * 发卡类型 0新发卡1补卡2换卡
	 */
	public static final String SELLCARED_TYPE_PTY2 = "2";
	/**
	 * 补卡转款标记（补卡、换卡，老卡上的金额是否转入新卡）0：没有转 1：已转入
	 */
	public static final String RESELLCARED_IS_NOT_PUTIN = "0";
	/**
	 * 补卡转款标记（补卡、换卡，老卡上的金额是否转入新卡）0：没有转 1：已转入
	 */
	public static final String RESELLCARED_IS_PUTIN = "1";
	/**
	 * 是否需要年检 0：不需要 1：需要
	 */
	public static final String YEAR_CHECK_NO_NEED = "0";
	/**
	 * 是否需要年检 0：不需要 1：需要
	 */
	public static final String YEAR_CHECK_NEED = "1";

	/**
	 * 钱包类型 1电子钱包2在线钱包
	 */
	public static final String WALLETTYPE_DEFAULT1 = "1";
	/**
	 * 钱包类型 1电子钱包2在线钱包
	 */
	public static final String WALLETTYPE_ONLINE1 = "2";
	/**
	 * 卡写卡成功或失败（Y成功N失败）E写卡异常
	 */
	public static final String WRITECARD_IS_YES = "Y";
	/**
	 * 卡写卡成功或失败（Y成功N失败）E写卡异常
	 */
	public static final String WRITECARD_IS_NO = "N";
	/**
	 * 卡写卡成功或失败（Y成功N失败）E写卡异常
	 */
	public static final String WRITECARD_IS_EXCEPTION = "E";

	/**
	 * 网点授权额度变化标识：-1 减少 0 不变 1 增加
	 */
	public static final String NET_AUTHCHANGE_DIR_CUT = "-1";
	/**
	 * 网点授权额度变化标识：-1 减少 0 不变 1 增加
	 */
	public static final String NET_AUTHCHANGE_DIR_NOR = "0";
	/**
	 * 网点授权额度变化标识：-1 减少 0 不变 1 增加
	 */
	public static final String NET_AUTHCHANGE_DIR_ADD = "1";

	/**
	 * data 标示数据未删除
	 */
	public static final String DATA_ISNOT_DELETED = "0";
	/**
	 * data 标示数据已删除
	 */
	public static final String DATA_IS_DELETED = "1";
	/**
	 * 请求成功、失败
	 */
	public static final String REQ_IS_SUNCESS = "成功";
	/**
	 * 请求成功、失败
	 */
	public static final String REQ_IS_FAIL = "失败";
	/**
	 * 卡片应用标识：0：历史 1：正常
	 */
	public static final String CARD_FLAG_NOR = "1";
	/**
	 * 卡片应用标识：0：历史 1：正常
	 */
	public static final String CARD_FLAG_HIS = "0";
	/**
	 * 撤销标识：0-未撤销1-已撤销
	 */
	public static final String QUASH_ADDCHARGE_IS_CORRECT = "1";
	/**
	 * 撤销标识：0-未撤销1-已撤销
	 */
	public static final String QUASH_ADDCHARGE_NOT_CORRECT = "0";

}