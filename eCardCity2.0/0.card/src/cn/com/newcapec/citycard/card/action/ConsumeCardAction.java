package cn.com.newcapec.citycard.card.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.newcapec.citycard.common.action.CommonAction;

/**
 * <p>
 * 消费卡管理Action
 * @author: WangJians
 * @version: 1.0
 * 2014/2/26 14:26
 * </p>
 */

public class ConsumeCardAction extends CommonAction {
	private static final long serialVersionUID = -6216679466130486479L;
	private final Log log = LogFactory.getLog(this.getClass());

	// 当前用户售卡信息读取
	public String getCurrUserCardInfo() throws Exception {
		return "USER_CARD_INFO";
	}
}