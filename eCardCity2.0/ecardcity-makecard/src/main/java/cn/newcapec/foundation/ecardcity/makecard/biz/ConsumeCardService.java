/**
 * 
 */
package cn.newcapec.foundation.ecardcity.makecard.biz;

import cn.newcapec.framework.core.rest.Msg;

/**
 * 消费卡公共业务接口类
 * 
 * @author wulimo
 * 
 */
public interface ConsumeCardService  {
     
	/**
	 * 获取及时统计消息
	 * 
	 * @param param
	 * @return
	 */
	Msg getBizTotalMsg(Long psamcardno,String userId);
}
