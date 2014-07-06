/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.dao.base.BaseDao;
import cn.newcapec.function.ecardcity.om.model.CardType;

/**
 * @author wj
 * @category 卡类型操作DAO
 * @version 1.0
 * @date 2014年4月9日 上午10:23:41
 */
@Repository
public class CardTypeDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<CardType> getReferenceClass() {
	return CardType.class;
    }
    
    /**
     * 查询指定卡类型
     * @param key		ID
     * @return ParamLib		根据给定的ID返回对象
     */
    public CardType get(java.io.Serializable key) {
	return (CardType) get(getReferenceClass(), key);
    }
    
    /**
     * 批量删除卡类型
     * @param ids	卡类型ID数组
     */
    public void delete(String[] ids) {
	if (ids != null && ids.length > 0) {
	    bulkUpdate(true,"delete from CardType where id in (:ids)", new String[]{"ids"},new Object[]{ids});
	}
    }
    
    /**
     * 根据类别，查询指定的卡类型列表
     * @param group	 	分类标识，如果为空，返回全部卡类型列表
     * @return List 		返回map列表
     */
    public List<?> getListByGroup(String group) {
	Map<String, Object> param = new HashMap<String, Object>();
	if(StringUtils.isNotBlank(group)){
	    param.put("groupid", group);
	}
	Order[] orders={Order.asc("groupid"),Order.asc("sort_num")};
	return super.getListByAttr(param, getReferenceClass(),orders);
    }
    
    /**
     * 根据map，查询指定的卡类型分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page getPage(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select * from card_type where 1=1");
	if (null != paramMap) {
		if (paramMap.containsKey("groupid") && StringUtils.isNotBlank(paramMap.get("groupid").toString())) {
		    sql.append(" and groupid = :groupid ");
		    param.put("groupid", paramMap.get("groupid"));
		}
	}
	sql.append(" order by sort_num");

	return super.getPageBySQL(sql.toString(), param);
    }
    
    /**
     * 指定ID号的卡是否被引用
     * 
     * @param id	ID号
     * @return Boolean
     */
    public boolean hasQuoteCardType(Serializable id) {
	Object[] ids=new Object[]{id};
	BigDecimal rtn1=(BigDecimal)super.sqlFindObject("select count(*) from card_appinfo where cardtype=?",ids);
	BigDecimal rtn2=(BigDecimal)super.sqlFindObject("select count(*) from card_makes where cardtype=?",ids);
	BigDecimal rtn3=(BigDecimal)super.sqlFindObject("select count(*) from card_employee where cardtype=?",ids);
	return rtn1.intValue() > 0 || rtn2.intValue() > 0 || rtn3.intValue() > 0;
    }
}
