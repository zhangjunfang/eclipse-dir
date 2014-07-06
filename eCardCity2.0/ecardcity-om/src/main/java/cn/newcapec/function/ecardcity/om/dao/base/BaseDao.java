/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.dao.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.BasicTransformerAdapter;

import cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao;
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.framework.core.utils.pagesUtils.PageContext;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 通用操作DAO
 * @version 1.0
 * @date 2014年3月26日 上午10:49:09
 */
@SuppressWarnings("all")
public class BaseDao extends HibernateEntityDao {

    /**
     * 功能描述:根据sql查询分页
     * 
     * @param args
     *            命名map
     * @return Page 返回page
     */
    public Page getPageBySQL(String sql, Map<String, Object> args) {
	Query query = getSession().createSQLQuery(sql);
	if(args!=null){
	    Iterator<Entry<String, Object>> iter = args.entrySet().iterator();
	    Map.Entry<String, Object> entry = null;
	    while (iter.hasNext()) {
		entry = iter.next();
		applyNamedParameterToQuery(query, String.valueOf(entry.getKey()),entry.getValue());
	    }
	}
	Page page = new Page();
	List list = query
		.setFirstResult(
			PageContext.getOffset().intValue() > 0 ? (PageContext
				.getOffset().intValue() - 1)
				* PageContext.getPagesize().intValue()
				: PageContext.getOffset().intValue())
		.setMaxResults(PageContext.getPagesize().intValue())
		.setResultTransformer(
			new UpperCasedAliasToEntityMapResultTransformer())
		.list();
	long count = countBySql(sql, args);
	page.setTotal((int) count);
	page.setItems(list);
	return page;
    }

    /**
     * 功能描述:查询满足给定属性的对象列表
     * 
     * @param attrMap
     *              属性Map
     * @param  Orders
     * 		            排序号
     * @return List 返回对象列表
     */
    public List<?> getListByAttr(Map<String, Object> attrMap, Class<?> cls,Order[] Orders) {
	DetachedCriteria detachedCriteria = DetachedCriteria.forClass(cls);
	if(attrMap!=null){
	    Iterator<Entry<String, Object>> iter = attrMap.entrySet().iterator();
	    Map.Entry<String, Object> entry = null;
	    while (iter.hasNext()) {
		entry = iter.next();
		detachedCriteria.add(Restrictions.eq(
		String.valueOf(entry.getKey()), entry.getValue()));
	    }
	}
	if(Orders!=null&&Orders.length>0){
	    for(Order order:Orders){
		detachedCriteria.addOrder(order);
	    }
	}
	return findByCriteria(detachedCriteria);
    }

    /**
     * 功能描述:带命名的参数集合批量更新和删除
     * 
     * @param hqlFlag
     *            true:HQL, false:SQL
     * @param queryString
     *            HQL或SQL
     * @param paramNames
     *            参数名集合 （元素:String）
     * @param values
     *            参数值集合（元素：String、List、Collection）
     * @return int 批量更新的记录条数
     */
    public int bulkUpdate(final boolean hqlFlag,final String queryString, final String[] paramNames,
	    final Object[] values) {
	if (paramNames != null && values != null
		&& paramNames.length != values.length) {
	    throw new IllegalArgumentException("命名参数和值个数不一致!");
	}
	Query query = null;
	if (hqlFlag) {
	    query = getSession().createQuery(queryString);
	} else {
	    query = getSession().createSQLQuery(queryString);
	}
	if (values != null) {
	    for (int i = 0; i < values.length; i++) {
		applyNamedParameterToQuery(query, paramNames[i], values[i]);
	    }
	}
	return query.executeUpdate();
    }

    /**
     * 功能描述:依据属性查找是否存在记录
     * 
     * @param cls 	对象实例Class
     * @param attrColl 	属性键值对集合
     * @return boolean 	是否存在
     */
    public boolean isExistsByAttr(Class<?> cls,KeyValue[] attrColl) {
	DetachedCriteria dc = generateDetachedCriteria(cls,attrColl);
        dc.setProjection(Projections.rowCount());
	return ((Long)super.findByCriteria(dc).get(0))>0;
    }
    /**
     * @param cls 对象实例Class
     * @param attrColl 属性键值对集合
     * @return DetachedCriteria
     */
    private DetachedCriteria generateDetachedCriteria(Class<?> cls, KeyValue[] attrColl) {
	DetachedCriteria detachedCriteria = DetachedCriteria.forClass(cls);
	if (attrColl != null && attrColl.length > 0) {
	    for (int i = 0; i < attrColl.length; i++) {
		if (attrColl[i] != null && attrColl[i].getName() != null
			&& attrColl[i].getValue() != null) {
		    // 等于
		    if (attrColl[i].getRelation().equals(KeyValue.RELATION_EQ)) {
			detachedCriteria.add(Restrictions.eq(
				String.valueOf(attrColl[i].getName()),
				attrColl[i].getValue()));
			continue;
		    // 不等于
		    } else if (attrColl[i].getRelation().equals(KeyValue.RELATION_NE)) {
			detachedCriteria.add(Restrictions.ne(
			String.valueOf(attrColl[i].getName()),
			attrColl[i].getValue()));
			continue;
		    // 模糊匹配
		    } else if (attrColl[i].getRelation().equals(
			    KeyValue.RELATION_LIKE)) {
			detachedCriteria.add(Restrictions.like(
				String.valueOf(attrColl[i].getName()),
				attrColl[i].getValue()));
			continue;
		    // 大于
		    } else if (attrColl[i].getRelation().equals(
			    KeyValue.RELATION_GT)) {
			detachedCriteria.add(Restrictions.gt(
				String.valueOf(attrColl[i].getName()),
				attrColl[i].getValue()));
			continue;
		    // 大于等于
		    } else if (attrColl[i].getRelation().equals(
			    KeyValue.RELATION_GE)) {
			detachedCriteria.add(Restrictions.ge(
				String.valueOf(attrColl[i].getName()),
				attrColl[i].getValue()));
			continue;
		    // 小于
		    } else if (attrColl[i].getRelation().equals(
			    KeyValue.RELATION_LT)) {
			detachedCriteria.add(Restrictions.lt(
				String.valueOf(attrColl[i].getName()),
				attrColl[i].getValue()));
			continue;
		    // 小于等于
		    } else if (attrColl[i].getRelation().equals(
			    KeyValue.RELATION_LE)) {
			detachedCriteria.add(Restrictions.le(
				String.valueOf(attrColl[i].getName()),
				attrColl[i].getValue()));
			continue;
		    // 集合
		    } else if (attrColl[i].getRelation().equals(
			    KeyValue.RELATION_IN)) {
			if (attrColl[i].getValue() instanceof Collection) {
			    detachedCriteria.add(Restrictions.in(
				    String.valueOf(attrColl[i].getName()),
				    (Collection<?>) attrColl[i].getValue()));
			    continue;
			} else if (attrColl[i].getValue() instanceof Object[]) {
			    detachedCriteria.add(Restrictions.in(
				    String.valueOf(attrColl[i].getName()),
				    (Object[]) attrColl[i].getValue()));
			    continue;
			}
		    }
		}
	    }
	}
	return detachedCriteria;
    }
	
    /**
     * 功能描述:根据sql查询记录总数
     * 
     * @param params
     *            命名map
     * @return long 返回数值
     */
    private long countBySql(String strSql, Map params) {
	strSql = "select count(*) as num from (" + strSql + ") ";
	SQLQuery query = getSession().createSQLQuery(strSql);
	Iterator<Entry<String, Object>> iter = params.entrySet().iterator();
	Map.Entry<String, Object> entry = null;
	while (iter.hasNext()) {
	    entry = iter.next();
	    applyNamedParameterToQuery(query, String.valueOf(entry.getKey()),
		    entry.getValue());
	}
	Integer totalCount = Integer.valueOf(0);
	Object count = query.uniqueResult();
	if ((count instanceof BigDecimal)) {
	    totalCount = Integer.valueOf(null == count ? 0
		    : ((BigDecimal) count).intValue());
	} else if ((count instanceof BigInteger)) {
	    totalCount = Integer.valueOf(null == count ? 0
		    : ((BigInteger) count).intValue());
	}
	return totalCount.intValue();
    }

    /**
     * 功能描述:绑定命名参数和值
     * 
     * @param query
     *            Query对象
     * @param paramName
     *            参数名集合
     * @param value
     *            参数值集合
     */
    protected void applyNamedParameterToQuery(Query query, String paramName,
	    Object value) {
	if (value instanceof Collection) {
	    query.setParameterList(paramName, (Collection<?>) value);
	} else if (value instanceof Object[]) {
	    query.setParameterList(paramName, (Object[]) value);
	} else {
	    query.setParameter(paramName, value);
	}
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected Class getReferenceClass() {
	return null;
    }

    private static class UpperCasedAliasToEntityMapResultTransformer extends
	    BasicTransformerAdapter implements Serializable {
	public Object transformTuple(Object[] tuple, String[] aliases) {
	    Map result = new HashMap(tuple.length);
	    for (int i = 0; i < tuple.length; i++) {
		String alias = aliases[i];
		if (alias != null) {
		    result.put(alias.toUpperCase(), tuple[i]);
		}
	    }
	    return result;
	}
    }
}
