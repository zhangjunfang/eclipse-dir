package cn.com.newcapec.citycard.card.service;

import java.util.List;
import java.util.Map;

import cn.com.newcapec.citycard.common.po.CardAppinfo;
import cn.com.newcapec.citycard.common.po.Customer;
import cn.com.newcapec.citycard.common.po.FareCost;

/**
 * <p>
 * 卡务相关的service
 * 
 * @author: WangJian
 * @version: 1.0 2014-03-10
 * </p>
 */

public interface ICardService {

    /**
     * 获取消费卡当天结算信息
     */
    public abstract boolean getIsSettle();
    
    /**
     * 获取充值员的发卡充值信息
     * @param userID		充值员ID
     * @return List<Map> 	基于Map对象封装的List
     */
    @SuppressWarnings("rawtypes")
    public abstract List<Map> getRechargeableByUser(Integer userID);

    /**
     * 保存客户信息
     * @param 	customer	客户obj
     * @return	boolean		保存成功或失败
     */
    public abstract boolean saveCustomer(Customer customer);
    
    /**
     * 保存客户卡片信息
     * @param 	card		卡片
     * @return	boolean		保存成功或失败
     */
    public abstract boolean saveCard(CardAppinfo card);
    
    /**
     * 保存客户卡片收费信息
     * @param 	fareCost	收费obj
     * @return	boolean		保存成功或失败
     */
    public abstract boolean saveFare(FareCost fareCost);    
}