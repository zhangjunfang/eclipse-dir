package cn.com.newcapec.citycard.card.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.newcapec.citycard.card.service.ICardService;
import cn.com.newcapec.citycard.common.dao.ICommonDao;
import cn.com.newcapec.citycard.common.po.CardAppinfo;
import cn.com.newcapec.citycard.common.po.Customer;
import cn.com.newcapec.citycard.common.po.FareCost;
import cn.com.newcapec.common.service.impl.BaseService;

/**
 * <p>
 * 卡务相关的service
 * 
 * @author: WangJian
 * @version: 1.0 2014-03-10
 * </p>
 */

public class CardService extends BaseService implements ICardService{
    protected final Log log = LogFactory.getLog(this.getClass());
    private ICommonDao commonDao;
    private ICommonDao cardDao;
    
    /**
     * @return the commonDao
     */
    public ICommonDao getCommonDao() {
        return commonDao;
    }

    /**
     * @param commonDao the commonDao to set
     */
    public void setCommonDao(ICommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * @return the cardDao
     */
    public ICommonDao getCardDao() {
        return cardDao;
    }

    /**
     * @param cardDao the cardDao to set
     */
    public void setCardDao(ICommonDao cardDao) {
        this.cardDao = cardDao;
    }

    /**
     * 获取消费卡当天结算信息
     */
    public boolean getIsSettle(){
	return false;
    }
    
    /**
     * 获取充值员的发卡充值信息
     * @param userID		充值员ID
     * @return List<Map> 	基于Map对象封装的List
     */
    @SuppressWarnings("rawtypes")
    public List<Map> getRechargeableByUser(Integer userID){
	return null;
    }

    /**
     * 保存客户信息
     * @param 	customer	客户obj
     * @return	boolean		保存成功或失败
     */
    public boolean saveCustomer(Customer customer){
	return false;
    }
    
    /**
     * 保存客户卡片信息
     * @param 	card		卡片
     * @return	boolean		保存成功或失败
     */
    public boolean saveCard(CardAppinfo card){
	return false;
    }
    
    /**
     * 保存客户卡片收费信息
     * @param 	fareCost	收费obj
     * @return	boolean		保存成功或失败
     */
    public boolean saveFare(FareCost fareCost){
	return false;
    }
}