package cn.com.newcapec.citycard.card.dao.impl;

import cn.com.newcapec.citycard.card.dao.ICardDao;
import cn.com.newcapec.common.dao.impl.BaseDao;

/**
 * <p>
 * 获取卡片信息操作的DAO
 * 
 * @Author : Wangjian
 * @Version: 1.0 2014-03-10
 * </p>
 */

public class CardDao extends BaseDao implements ICardDao{
    
    /**
     * 获取当前授权余额
     * @param userID	充值员ID
     * @return Double 	授权月
     */
    public Double getAuthBalanceAmounts(String userID) {
	return 0.00;
    }
    
    /**
     * 获取总收入金额
     * @param userID	充值员ID
     * @return Double 	总收入
     */
    public Double getIncomeAmounts(String userID) {
	return 0.00;
    }
    
    /**
     * 获取总支出金额
     * @param userID	充值员ID
     * @return Double 	总支出
     */
    public Double getPayAmounts(String userID) {
	return 0.00;
    }

    /**
     * 获取已售卡张数
     * @param userID	充值员ID
     * @return Integer 	已售卡总数
     */
    public Integer getSellCardCount(String userID) {
	return 0;
    }
    
    /**
     * 获取已售卡余额
     * @param userID	充值员ID
     * @return Double 	已售卡余额
     */
    public Double getSellCardAmounts(String userID) {
	return 0.00;
    }

    /**
     * 获取钱包充值张数
     * @param userID	充值员ID
     * @return Integer 	钱包充值张数
     */
    public Integer getWalletRechargeCount(String userID) {
	return 0;
    }
    
    /**
     * 获取钱包充值金额
     * @param userID	充值员ID
     * @return Double 	钱包充值金额
     */
    public Double getWalletRechargeAmounts(String userID) {
	return 0.00;
    }
    
    /**
     * 获取充值撤销张数
     * @param userID	充值员ID
     * @return Integer 	钱包充值张数
     */
    public Integer getRechargeRevokeCount(String userID) {
	return 0;
    }
    
    /**
     * 获取充值撤销金额
     * @param userID	充值员ID
     * @return Double 	钱包充值金额
     */
    public Double getRechargeRevokeAmounts(String userID) {
	return 0.00;
    }    

    /**
     * 获取补卡张数
     * @param userID	充值员ID
     * @return Integer 	补卡数
     */
    public Integer getSupplementCardCount(String userID) {
	return 0;
    }
    
    /**
     * 获取冻结金额
     * @param userID	充值员ID
     * @return Double 	补卡金额
     */
    public Double getFreezeAmounts(String userID) {
	return 0.00;
    }    

    /**
     * 获取挂失张数
     * @param userID	充值员ID
     * @return Integer 	挂失张数
     */
    public Integer getLostCardCount(String userID) {
	return 0;
    }
    
    /**
     * 获取解挂卡数目
     * @param userID	充值员ID
     * @return Integer 	解挂张数
     */
    public Integer getUnLostCardCount(String userID) {
	return 0;
    }

    /**
     * 获取有卡销户张数
     * @param userID	充值员ID
     * @return Integer 	有卡销户张数
     */
    public Integer getLogoffCountByCard(String userID) {
	return 0;
    }
    
    /**
     * 获取有卡销户金额
     * @param userID	充值员ID
     * @return Double 	有卡销户金额
     */
    public Double getLogoffAmountsByCard(String userID) {
	return 0.00;
    }

    /**
     * 获取无卡销户张数
     * @param userID	充值员ID
     * @return Integer 	无卡销户张数
     */
    public Integer getLogoffCountByNoCard(String userID) {
	return 0;
    }
    
    /**
     * 获取无卡销户金额
     * @param userID	充值员ID
     * @return Double 	无卡销户金额
     */
    public Double getLogoffAmountsByNoCard(String userID) {
	return 0.00;
    }
    
}
