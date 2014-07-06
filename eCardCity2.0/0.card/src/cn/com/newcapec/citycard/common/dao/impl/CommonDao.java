package cn.com.newcapec.citycard.common.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.com.newcapec.common.dao.impl.BaseDao;
import cn.com.newcapec.common.domain.NameValue;
import cn.com.newcapec.common.util.Constants;
import cn.com.newcapec.citycard.common.dao.ICommonDao;

/**
 * <pre>
 * 功能描述:项目公共DAO接口实现
 *   
 * Author : Wangjian 
 * Date   : 2008-05-08
 * Time   : 16:48:15
 * Version: 1.0
 * </pre>
 */
public class CommonDao extends BaseDao implements ICommonDao{
	/**
	 * <pre>
	 * 功能描述：取得最大排序号
	 * 
	 * @param cls 持久化实体类
	 * @param hasDelFlag 是否有删除标志
	 * 
	 * @return Integer 最大序号
	 * </pre>
	 */
	public Integer getMaxOrderNo(Class cls,Boolean hasDelFlag)
	{
		StringBuilder sb=new StringBuilder("select max(orderNo) from "+cls.getName());
		if(hasDelFlag)
		{
			sb.append(" where del_flag='"+Constants.RECORD_DEL_NOT+"'");
		}
		return (Integer)findObject(sb.toString());
	}
	
	/**
	 * <pre>
	 * 功能描述：执行批量假删除若干条记录
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @return
	 * </pre>
	 */
	public void removeRecords(Class cls,List idList){
		String hql = "update "+cls.getName()+" set del_flag="+Constants.RECORD_DEL+" where id in (:idList)";
		String[] paraNames=new String[]{"idList"};
		Object[] values=new Object[]{idList};
		bulkUpdate(hql, paraNames, values);
	}
	
	/**
	 * <pre>
	 * 功能描述：执行批量删除若干条记录
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @return
	 * </pre>
	 */
	public void delRecordsByPK(Class cls,List idList){
		String hql = "delete "+cls.getName()+" where id in (:idList)";
		delRecords(hql,idList);
	}

	/**
	 * <pre>
	 * 功能描述：执行批量删除若干条记录
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @return
	 * </pre>
	 */
	public void delRecordsByColumn(Class cls,List idList,String column){
		String hql = "delete "+cls.getName()+" where "+column+" in (:idList)";
		delRecords(hql,idList);
	}
	
	private void delRecords(String hql,List idList){
		String[] paraNames=new String[]{"idList"};
		Object[] values=new Object[]{idList};
		bulkUpdate(hql, paraNames, values);
	}
	
	/**
	 * 根据主键得到Object
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param id		pk
	 * @return			object
	 * */
	public Object getObj(Class cls, Serializable id){
		return get(cls, id);
	}

	/**
	 * 查找指定的Object数量
	 * 
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return integer		对象数量
	 */
	public Integer getObjCountByAttr(Class cls,NameValue[] attrColl){
		DetachedCriteria detachedCriteria = generateDetachedCriteria(cls,attrColl);
		return getCountByCriteria(detachedCriteria);
	}
	
	/**
	 * 查找指定的Object列表
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return List 		根据给定的属性返回当前列表
	 */
	public List getObjListByAttr(Class cls,NameValue[] attrColl) {
		DetachedCriteria detachedCriteria = generateDetachedCriteria(cls,attrColl);
		detachedCriteria.addOrder(Order.desc("id"));
		return findByCriteria(detachedCriteria);
	}
	
	/**
	 * 查找指定的Object分页列表
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return List 		根据给定的属性返回当前分页列表
	 */
	public List getObjPaginationListByAttr(Class cls,NameValue[] attrColl, int firstResult, int maxResults) {
		DetachedCriteria detachedCriteria = generateDetachedCriteria(cls,attrColl);
		detachedCriteria.addOrder(Order.desc("id"));
		return getPaginationListByCriteria(detachedCriteria, firstResult, maxResults);
	}

	/**
	 * @param 	cls			对象实例Class
	 * @param 	attrColl		属性键值对集合
	 * @return	DetachedCriteria
	 */
	private DetachedCriteria generateDetachedCriteria(Class<?> cls,NameValue[] attrColl) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(cls);
//		//对于有多对一或多对多的关联查询需要创建别名
//		if(class.getSuperclass().getDeclaredFields()){
//			
//		}
		
		if(attrColl != null && attrColl.length > 0){
			for(int i=0;i<attrColl.length;i++){
				if(attrColl[i]!=null && attrColl[i].getName()!=null && attrColl[i].getValue()!=null){
					//对于值为List的做特殊处理，以后禁用此方式，用指定的关系符代替
					if(attrColl[i].getValue().getClass().getSimpleName().endsWith("List")){
						attrColl[i].setRelation(NameValue.RELATION_IN);
					}
					//等于
					if(attrColl[i].getRelation().equals(NameValue.RELATION_EQ)){
						detachedCriteria.add(Restrictions.eq(String.valueOf(attrColl[i].getName()), attrColl[i].getValue()));
						continue;
					//模糊匹配
					}else if(attrColl[i].getRelation().equals(NameValue.RELATION_LIKE)){
						detachedCriteria.add(Restrictions.like(String.valueOf(attrColl[i].getName()), attrColl[i].getValue()));
						continue;
					//大于
					}else if(attrColl[i].getRelation().equals(NameValue.RELATION_GT)){
						detachedCriteria.add(Restrictions.gt(String.valueOf(attrColl[i].getName()), attrColl[i].getValue()));
						continue;
					//大于等于
					}else if(attrColl[i].getRelation().equals(NameValue.RELATION_GT)){
						detachedCriteria.add(Restrictions.ge(String.valueOf(attrColl[i].getName()), attrColl[i].getValue()));
						continue;
					//小于
					}else if(attrColl[i].getRelation().equals(NameValue.RELATION_LT)){
						detachedCriteria.add(Restrictions.lt(String.valueOf(attrColl[i].getName()), attrColl[i].getValue()));
						continue;
					//小于等于
					}else if(attrColl[i].getRelation().equals(NameValue.RELATION_LE)){
						detachedCriteria.add(Restrictions.le(String.valueOf(attrColl[i].getName()), attrColl[i].getValue()));
						continue;
					//集合
					}else if(attrColl[i].getRelation().equals(NameValue.RELATION_IN)){
						if(attrColl[i].getValue() instanceof Collection){
							detachedCriteria.add(Restrictions.in(String.valueOf(attrColl[i].getName()), (Collection<?>)attrColl[i].getValue()));
							continue;
						}else if(attrColl[i].getValue() instanceof Object[]){
							detachedCriteria.add(Restrictions.in(String.valueOf(attrColl[i].getName()), (Object[])attrColl[i].getValue()));
							continue;
						}
					}
				}
			}
		}
		return detachedCriteria;
	}
}