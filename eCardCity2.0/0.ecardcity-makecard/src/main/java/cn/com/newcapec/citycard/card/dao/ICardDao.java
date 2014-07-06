package cn.com.newcapec.citycard.card.dao;

public interface ICardDao {

    /**
     * 获取当前授权余额
     * @param userID	充值员ID
     * @return Double 	授权月
     */
    public abstract Double getAuthBalanceAmounts(String userID);

    /**
     * 获取总收入金额
     * @param userID	充值员ID
     * @return Double 	总收入
     */
    public abstract Double getIncomeAmounts(String userID);

    /**
     * 获取总支出金额
     * @param userID	充值员ID
     * @return Double 	总支出
     */
    public abstract Double getPayAmounts(String userID);

    /**
     * 获取已售卡张数
     * @param userID	充值员ID
     * @return Integer 	已售卡总数
     */
    public abstract Integer getSellCardCount(String userID);

    /**
     * 获取已售卡余额
     * @param userID	充值员ID
     * @return Double 	已售卡余额
     */
    public abstract Double getSellCardAmounts(String userID);

    /**
     * 获取钱包充值张数
     * @param userID	充值员ID
     * @return Integer 	钱包充值张数
     */
    public abstract Integer getWalletRechargeCount(String userID);

    /**
     * 获取钱包充值金额
     * @param userID	充值员ID
     * @return Double 	钱包充值金额
     */
    public abstract Double getWalletRechargeAmounts(String userID);

    /**
     * 获取充值撤销张数
     * @param userID	充值员ID
     * @return Integer 	钱包充值张数
     */
    public abstract Integer getRechargeRevokeCount(String userID);

    /**
     * 获取充值撤销金额
     * @param userID	充值员ID
     * @return Double 	钱包充值金额
     */
    public abstract Double getRechargeRevokeAmounts(String userID);

    /**
     * 获取补卡张数
     * @param userID	充值员ID
     * @return Integer 	补卡数
     */
    public abstract Integer getSupplementCardCount(String userID);

    /**
     * 获取冻结金额
     * @param userID	充值员ID
     * @return Double 	补卡金额
     */
    public abstract Double getFreezeAmounts(String userID);

    /**
     * 获取挂失张数
     * @param userID	充值员ID
     * @return Integer 	挂失张数
     */
    public abstract Integer getLostCardCount(String userID);

    /**
     * 获取解挂卡数目
     * @param userID	充值员ID
     * @return Integer 	解挂张数
     */
    public abstract Integer getUnLostCardCount(String userID);

    /**
     * 获取有卡销户张数
     * @param userID	充值员ID
     * @return Integer 	有卡销户张数
     */
    public abstract Integer getLogoffCountByCard(String userID);

    /**
     * 获取有卡销户金额
     * @param userID	充值员ID
     * @return Double 	有卡销户金额
     */
    public abstract Double getLogoffAmountsByCard(String userID);

    /**
     * 获取无卡销户张数
     * @param userID	充值员ID
     * @return Integer 	无卡销户张数
     */
    public abstract Integer getLogoffCountByNoCard(String userID);

    /**
     * 获取无卡销户金额
     * @param userID	充值员ID
     * @return Double 	无卡销户金额
     */
    public abstract Double getLogoffAmountsByNoCard(String userID);

}