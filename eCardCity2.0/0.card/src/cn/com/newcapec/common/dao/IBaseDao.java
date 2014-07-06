package cn.com.newcapec.common.dao;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 * 功能描述:常用DAO接口定义
 *   
 * Author : Wangjian 
 * Date   : 2007-10-12 
 * Time   : 8:34:58
 * Version:1.0
 * </pre>
 */
public interface IBaseDao{
	/**
	 * <pre>
	 * 功能描述:保存持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * 
	 * @return Serializable 返回持久化对象实例标识 
	 * </pre>
	 */
	public Serializable save(Object entity);

	/**
	 * <pre>
	 * 功能描述:保存或更新持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * </pre>
	 */
	public void saveOrUpdate(Object entity);

	/**
	 * <pre>
	 * 功能描述:保存或更新持久化对象实例集
	 * 
	 * @param entities 持久化对象实例集
	 * </pre>
	 */
	public void saveOrUpdateAll(Collection entities);

	/**
	 * <pre>
	 * 功能描述:更新持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * </pre>
	 */
	public void update(Object entity);

	/**
	 * <pre>
	 * 功能描述:以指定的锁模式更新持久化对象实例
	 *        
	 * 
	 * @param entity 持久化对象实例
	 * @param lockMode 锁模式
	 * </pre>
	 */
	public void update(Object entity, LockMode lockMode);

	/**
	 * <pre>
	 * 功能描述:删除持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * </pre>
	 */
	public void delete(Object entity);

	/**
	 * <pre>
	 * 功能描述:以指定的锁模式删除持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * @param lockMode 锁模式
	 * </pre>
	 */
	public void delete(Object entity, LockMode lockMode);

	/**
	 * <pre>
	 * 功能描述:删除持久化对象实例集
	 * 
	 * @param entities 持久化对象实例集
	 * </pre>
	 */
	public void deleteAll(Collection entities);

	/**
	 * <pre>
	 * 功能描述:取得指定标识的持久化对象实例,若没找到返回null
	 * 
	 * @param entityClass 持久化类
	 * @param id 持久化对象实例标识 
	 * 
	 * @return Object 持久化对象实例
	 * </pre>
	 */
	public Object get(Class entityClass, Serializable id);

	/**
	 * <pre>
	 * 功能描述:以指定的锁模式取得指定标识的持久化对象实例,若没找到返回null
	 *        
	 * @param entityClass 持久化类
	 * @param id 持久化对象实例标识
	 * @param lockMode 锁模式
	 * 
	 * @return Object 持久化对象实例
	 * </pre>
	 */
	public Object get(Class entityClass, Serializable id, LockMode lockMode);

	/**
	 * <pre>
	 * 功能描述:加载指定标识的持久化对象实例,若没找到抛出异常
	 * 
	 * @param entityClass 持久化类
	 * @param id 持久化对象实例标识
	 * 
	 * @return Object 持久化对象实例
	 * </pre>
	 */
	public Object load(Class entityClass, Serializable id);

	/**
	 * <pre>
	 * 功能描述:以指定的锁模式加载指定标识的持久化对象实例,若没找到抛出异常
	 * 
	 * @param entityClass 持久化类
	 * @param id 持久化对象实例标识
	 * @param lockMode 锁模式
	 * 
	 * @return Object 持久化对象实例
	 * </pre>
	 */
	public Object load(Class entityClass, Serializable id, LockMode lockMode);

	/**
	 * <pre>
	 * 功能描述:加载所有持久化对象的实例
	 * 
	 * @param entityClass 持久化类
     *
     * @return List
	 * </pre>
	 */
	public List loadAll(Class entityClass); 
	
	/**
	 * <pre>
	 * 功能描述:刷新持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * </pre>
	 */
	public void refresh(Object entity);

	/**
	 * <pre>
	 * 功能描述:以指定的锁模式刷新持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * @param lockMode 锁模式
	 * </pre>
	 */
	public void refresh(Object entity, LockMode lockMode);

	/**
	 * <pre>
	 * 功能描述:将之前的增删改操作保存到数据库
	 * </pre>
	 */
	public void flush();

	/**
	 * <pre>
	 * 功能描述:取消之前对数据库的增删改操作
	 * </pre>
	 */
	public void clear();

    /**
	 * <pre>
	 * 功能描述:合并持久化对象实例
     *
     * @param entity 持久化对象实例
     *
	 * @return Object 合并后的持久化对象实例
	 * </pre>
	 */
	public Object merge(Object entity);

    /**
	 * <pre>
	 * 功能描述:持久化瞬时状态的持久化对象实例
     *
     * @param entity 持久化对象实例
	 * </pre>
	 */
	public void persist(Object entity);

    /**
	 * <pre>
	 * 功能描述:检查持久化对象实例是否在当前会话中
     *
     * @param entity 持久化对象实例
     *
     * @return boolean 在,返回true;否则false
	 * </pre>
	 */
	public boolean contains(Object entity);

    /**
	 * <pre>
	 * 功能描述:从当前会话中移除持久化对象实例
     *
     * @param entity 持久化对象实例
	 * </pre>
	 */
    public void evict(Object entity);

    /**
	 * <pre>
	 * 功能描述:执行HQL查询,迭代结果
     *
     * @param hql HQL
     *
     * @return Iterator 迭代结果
	 * </pre>
	 */
    public Iterator iterate(String hql);

    /**
	 * <pre>
     * 功能描述:执行带占位符的HQL查询,迭代结果
	 *
	 * @param hql HQL
	 * @param values 参数值集合
     *
     * @return Iterator 迭代结果
	 * </pre>
	 */
    public Iterator iterate(String hql,Object[] values);

    /**
	 * <pre>
	 * 功能描述:批量更新
	 * 
	 * @param hql HQL
	 * @return int 批量更新的记录条数
	 * </pre>
	 */
	public int bulkUpdate(String hql);

	/**
	 * <pre>
	 * 功能描述:带占位符批量更新
	 * 
	 * @param hql HQL
	 * @param values 参数值集
	 * 
	 * @return int 批量更新的记录条数
	 * </pre>
	 */
	public int bulkUpdate(String hql, Object[] values);
	
	/**
	 * <pre>
	 * 功能描述:带命名参数批量更新
	 * 
	 * @param hql HQL
	 * @param paramNames 参数名集合 
     * @param values 参数值集合 
	 * 
	 * @return int 批量更新的记录条数
	 * </pre>
	 */
	public int bulkUpdate(final String hql, final String[] paramNames, final Object[] values);

	/**
	 * <pre>
	 * 功能描述:执行基于Hibernate参考对象的查询
	 *  
	 * @param criteria Hibernate参考对象
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List findByCriteria(DetachedCriteria criteria);

	/**
	 * <pre>
	 * 功能描述:执行基于样例参考对象的查询
	 *  
	 * @param exampleEntity 样例参考对象
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List findByExample(Object exampleEntity);

	/**
	 * <pre>
	 * 功能描述:执行HQL查询
	 *  
	 * @param hql HQL
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List find(String hql);

	/**
	 * <pre>
	 * 功能描述:执行带占位符的HQL查询
	 *  
	 * @param hql HQL
	 * @param values 参数值集合
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List find(String hql, Object[] values);

	/**
	 * <pre>
	 * 功能描述:执行带命名参数的HQL查询
	 *  
	 * @param hql HQL
	 * @param paramNames 参数名集合
	 * @param values 参数值集合
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List findByNamedParam(String hql, String[] paramNames, Object[] values);

	/**
	 * <pre>
	 * 功能描述:执行命名HQL查询
	 *  
	 * @param queryName HQL名字
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List findByNamedQuery(String queryName);

	/**
	 * <pre>
	 * 功能描述:执行带占位符的命名HQL查询
	 *  
	 * @param queryName HQL名字
	 * @param values 参数值集合
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List findByNamedQuery(String queryName, Object[] values);

	/**
	 * <pre>
	 * 功能描述:执行带命名参数的命名HQL查询
	 *  
	 * @param queryName HQL名字
	 * @param paramNames 参数名集合
	 * @param values 参数值集合
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values);

	/**
	 * <pre>
	 * 功能描述:执行HQL分页查询
	 *  
	 * @param hql HQL
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List getPaginationList(String hql, int firstResult, int maxResults);

	/**
	 * <pre>
	 * 功能描述:执行带占位符的HQL分页查询
	 *  
	 * @param hql HQL
	 * @param values 参数值集合
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List getPaginationList(String hql, Object[] values, int firstResult, int maxResults);

	/**
	 * <pre>
	 * 功能描述:执行带命名参数的HQL分页查询
	 *  
	 * @param hql HQL
	 * @param paramNames 参数名集合 
	 * @param values 参数值集合
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List getPaginationListByNamedParam(String hql, String[] paramNames, Object[] values, int firstResult,
			int maxResults);

	/**
	 * <pre>
	 * 功能描述:执行命名HQL分页查询
	 *  
	 * @param queryName 命名HQL
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List getPaginationListByNamedQuery(String queryName, int firstResult, int maxResults);

	/**
	 * <pre>
	 * 功能描述:执行带占位符的命名HQL分页查询
	 *  
	 * @param queryName 命名HQL
	 * @param values 参数值集合
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List getPaginationListByNamedQuery(String queryName, Object[] values, int firstResult, int maxResults);

	/**
	 * <pre>
	 * 功能描述:执行带命名参数的命名HQL分页查询
	 *  
	 * @param queryName 命名HQL
	 * @param paramNames 参数名集合 
	 * @param values 参数值集合
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List getPaginationListByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values,
			int firstResult, int maxResults);

	/**
	 * <pre>
	 * 功能描述:执行基于样例参考对象的分页查询
	 *  
	 * @param exampleEntity 样例参考对象
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List getPaginationListByExample(Object exampleEntity, int firstResult, int maxResults);

	/**
	 * <pre>
	 * 功能描述:执行基于Hibernate参考对象的分页查询
	 *  
	 * @param criteria Hibernate参考对象
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List getPaginationListByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);

	/**
	 * <pre>
	 * 功能描述:执行基于Hibernate参考对象的查询,返回第一个对象,若没有则返回null
	 *  
	 * @param criteria Hibernate参考对象
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObjectByCriteria(DetachedCriteria criteria);

	/**
	 * <pre>
	 * 功能描述:执行基于样例参考对象的查询,返回第一个对象,若没有则返回null
	 *  
	 * @param exampleEntity 样例参考对象
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObjectByExample(Object exampleEntity);

	/**
	 * <pre>
	 * 功能描述:执行HQL查询,返回第一个对象,若没有则返回null
	 *  
	 * @param hql HQL
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObject(String hql);

	/**
	 * <pre>
	 * 功能描述:执行带占位符的HQL查询,返回第一个对象,若没有则返回null
	 *  
	 * @param hql HQL
	 * @param values 参数值集合
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObject(String hql, Object[] values);

	/**
	 * <pre>
	 * 功能描述:执行带命名参数的HQL查询,返回第一个对象,若没有则返回null
	 *  
	 * @param hql HQL
	 * @param paramNames 参数名集合
	 * @param values 参数值集合
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObjectByNamedParam(String hql, String[] paramNames, Object[] values);

	/**
	 * <pre>
	 * 功能描述:执行命名HQL查询,返回第一个对象,若没有则返回null
	 *  
	 * @param queryName HQL名字
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObjectByNamedQuery(String queryName);

	/**
	 * <pre>
	 * 功能描述:执行带占位符的命名HQL查询,返回第一个对象,若没有则返回null
	 *  
	 * @param queryName HQL名字
	 * @param values 参数值集合
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObjectByNamedQuery(String queryName, Object[] values);

	/**
	 * <pre>
	 * 功能描述:执行带命名参数的命名HQL查询,返回第一个对象,若没有则返回null
	 *  
	 * @param queryName HQL名字
	 * @param paramNames 参数名集合
	 * @param values 参数值集合
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObjectByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values);
	
	/**
	 * <pre>
	 * 功能描述:执行SQL查询
	 *  
	 * @param sql SQL
	 * 
	 * @return List 结果集
	 * </pre>
	 */
	public List findBySQL(String sql);
	
	/**
	 * <pre>
	 * 功能描述:执行带占位符的SQL查询
	 *  
	 * @param sql SQL
	 * @param values 参数值集合
	 * 
	 * @return List 结果集
	 * </pre>
	 */
	public List findBySQL(String sql,Object[] values);
	
	/**
	 * <pre>
	 * 功能描述:执行SQL查询,返回第一个对象
	 *  
	 * @param sql SQL
	 * 
	 * @return Object 查询的第一个对象
	 * </pre>
	 */
	public Object findObjectBySQL(String sql);
	
	/**
	 * <pre>
	 * 功能描述:执行带占位符的SQL查询,返回第一个对象
	 *  
	 * @param sql SQL
	 * @param values 参数值集合
	 * 
	 * @return Object 查询的第一个对象
	 * </pre>
	 */
	public Object findObjectBySQL(String sql,Object[] values);
	
	/**
	 * <pre>
	 * 功能描述:执行QBC count()查询
	 *  
	 * @param detachedCriteria QBC
	 * 
	 * @return Integer count
	 * </pre>
	 */
	public Integer getCountByCriteria(DetachedCriteria detachedCriteria);
}
