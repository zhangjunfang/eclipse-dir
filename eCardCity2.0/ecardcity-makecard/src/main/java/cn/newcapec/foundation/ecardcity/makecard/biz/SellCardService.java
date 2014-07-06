/**
 * 
 */
package cn.newcapec.foundation.ecardcity.makecard.biz;

import java.io.Serializable;
import java.util.List;

import net.sf.json.JSONObject;
import cn.newcapec.foundation.ecardcity.makecard.model.CardType;
import cn.newcapec.foundation.ecardcity.makecard.model.Customer;
import cn.newcapec.framework.core.biz.BaseService;
import cn.newcapec.framework.core.rest.Msg;

/**
 * 售卡业务接口类
 * 
 * @author wulimo
 * 
 */
public interface SellCardService extends BaseService<Customer> {
	/**
	 * 主键删除客户信息
	 * 
	 * @param id
	 */
	public void delCustomer(Serializable id);

	/**
	 * 获取客户新账号
	 * 
	 * @return
	 */
	public long getCustomerNxetID();

	/**
	 * 身份证号查询客户
	 * 
	 * @param idCardNo
	 * @return
	 */
	public Customer getCustomerByIDCardNo(String idCardNo);

	/**
	 * 市民卡号是否被占用
	 * 
	 * @param cityCardNo
	 * @return
	 */
	public boolean isUsedCityCardNo(String cityCardNo);

	/**
	 * 卡唯一号验证此卡片是否已发卡
	 * 
	 * @param snr
	 * @return
	 */
	public boolean isSelledCard(String snr);

	/**
	 * 该用户是否已持有该类型卡片
	 * 
	 * @param custId
	 * @param cardKind
	 * @param cardType
	 * @return
	 */
	public boolean isSelledKindCard(String custId, String cardKind,
			String cardType);

	/**
	 * 售卡读卡验证
	 * 
	 * @param param
	 * @return
	 */
	public Msg readCardForSellCard(JSONObject param);

	/**
	 * 售卡申请
	 * 
	 * @param param
	 * @return
	 */
	public Msg reqSellChard(JSONObject param);

	/**
	 * 售卡提交
	 * 
	 * @param param
	 * @return
	 */
	public Msg commitSellChard(JSONObject param);

	/**
	 * 生成市民卡号
	 * 
	 * @param custId
	 * @param asn16
	 * @return
	 */
	public String getNewCityCardNo(long custId, String asn16);

	/**
	 * 发卡的卡类型(卡小类型、卡用途)
	 * 
	 * @return
	 */

	List<CardType> getSellCardTypes();

	/**
	 * 获取字典列表
	 * 
	 * @param code
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getDictListByCode(String code);
}
