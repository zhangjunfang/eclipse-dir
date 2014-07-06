package cn.com.newcapec.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IBaseDao {

    /**
     * <p>
     * 功能描述:保存持久化对象实例
     * 
     * @param entity 持久化对象实例
     * 
     * @return Serializable 返回持久化对象实例标识
     * </p>
     */
    public abstract Serializable save(Object entity);

    /**
     * <p>
     * 功能描述:保存或更新持久化对象实例
     * 
     * @param entity 持久化对象实例
     * </p>
     */
    public abstract void saveOrUpdate(Object entity);

    /**
     * <p>
     * 功能描述:取得指定标识的持久化对象实例,若没找到返回null
     * 
     * @param entityClass 持久化类
     * @param id 持久化对象实例标识 
     * 
     * @return Object 持久化对象实例
     * </p>
     */
    public abstract Object get(Class entityClass, Serializable id);

    /**
     * <p>
     * 功能描述:取得指定标识的所有持久化实例
     * 
     * @param entityClass 持久化类
     * @param id 持久化对象实例标识 
     * 
     * @return List 持久化对象实例
     * </p>
     */
    public abstract List getAll(Class entityClass);

    /**
     * <p>
     * 功能描述:更新持久化对象实例
     * 
     * @param entity 持久化对象实例
     * </p>
     */
    public abstract void update(Object entity);

    /**
     * <p>
     * 功能描述:删除持久化对象实例
     * 
     * @param entity 持久化对象实例
     * </p>
     */
    public abstract void delete(Object entity);

    /**
     * <p>
     * 功能描述:刷新持久化对象实例
     * 
     * @param entity 持久化对象实例
     * </p>
     */
    public abstract void refresh(Object entity);

    /**
     * <p>
     * 功能描述:将之前的增删改操作保存到数据库
     * </p>
     */
    public abstract void flush();

    /**
     * <p>
     * 功能描述:取消之前对数据库的增删改操作
     * </p>
     */
    public abstract void clear();

    /**
     * <p>
     * 功能描述:合并持久化对象实例
     * 
     * @param entity 持久化对象实例
     * 
     * @return Object 合并后的持久化对象实例
     * </p>
     */
    public abstract Object merge(Object entity);

    /**
     * <p>
     * 功能描述:持久化瞬时状态的持久化对象实例
     * 
     * @param entity 持久化对象实例
     * </p>
     */
    public abstract void persist(Object entity);

    /**
     * <p>
     * 功能描述:检查持久化对象实例是否在当前会话中
     * 
     * @param entity 持久化对象实例
     * 
     * @return boolean 在,返回true;否则false
     * </p>
     */
    public abstract boolean contains(Object entity);

    /**
     * <p>
     * 功能描述:从当前会话中移除持久化对象实例
     * 
     * @param entity 持久化对象实例
     * </p>
     */
    public abstract void evict(Object entity);

    /**
     * <p>
     * 功能描述:批量更新
     * 
     * @param hql HQL
     * 
     * @return int 批量更新的记录条数
     * </p>
     */
    public abstract int bulkUpdate(String hql);

    /**
     * <p>
     * 功能描述:带参数批量更新
     * 
     * @param hql HQL
     * @param values 参数值集合 
     * 
     * @return int 批量更新的记录条数
     * </p>
     */
    public abstract int bulkUpdate(String hql, Object[] values);

    /**
     * <p>
     * 功能描述:带命名参数批量更新
     * 
     * @param hql HQL
     * @param paramNames 参数名集合 
     * @param values 参数值集合 
     * 
     * @return int 批量更新的记录条数
     * </p>
     */
    public abstract int bulkUpdate(String hql, String[] paramNames,
	    Object[] values);

    /**
     * <p>
     * 功能描述:执行基于Hibernate参考对象的查询
     *  
     * @param criteria Hibernate参考对象
     * 
     * @return List 查询结果集
     * </p>
     */
    public abstract List getListByCriteria(DetachedCriteria criteria);

    /**
     * <p>
     * 功能描述:执行基于Hibernate参考对象的查询,返回第一个对象,若没有则返回null
     *  
     * @param criteria Hibernate参考对象
     * 
     * @return Object 查询结果
     * </p>
     */
    public abstract Object getObjectByCriteria(DetachedCriteria criteria);

    /**
     * <p>
     * 功能描述:执行QBC count()查询
     *  
     * @param detachedCriteria QBC
     * 
     * @return Integer count
     * </p>
     */
    public abstract int getCountsByCriteria(
	    DetachedCriteria detachedCriteria);

    /**
     * <p>
     * 功能描述:执行基于DetachedCriteria的分页查询
     *  
     * @param criteria Hibernate参考对象
     * @param firstResult 从第几条开始
     * @param maxResults 共取几条
     * 
     * @return List 查询结果集
     * </p>
     */
    public abstract List getPaginationListByCriteria(DetachedCriteria criteria,
	    int firstResult, int maxResults);

    /**
     * <p>
     * 功能描述:执行基于样例参考对象的查询
     *  
     * @param exampleEntity 样例参考对象
     * 
     * @return List 查询结果集
     * </p>
     */
    public abstract List getListByExample(Object exampleEntity);

    /**
     * <p>
     * 功能描述:执行基于样例参考对象的查询,返回第一个对象,若没有则返回null
     *  
     * @param exampleEntity 样例参考对象
     * 
     * @return Object 查询结果
     * </p>
     */
    public abstract Object getObjectByExample(Object exampleEntity);

    /**
     * <p>
     * 功能描述:执行基于样例参考对象的分页查询
     *  
     * @param exampleEntity 样例参考对象
     * @param firstResult 从第几条开始
     * @param maxResults 共取几条
     * 
     * @return List 查询结果集
     * </p>
     */
    public abstract List getPaginationListByExample(Object exampleEntity,
	    int firstResult, int maxResults);

    /**
     * <p>
     * 功能描述:执行HQL查询
     *  
     * @param queryName 命名HQL
     * 
     * @return List 查询结果集
     * </p>
     */
    public abstract List getListByHQL(String queryName);

    /**
     * <p>
     * 功能描述:执行带占位符的命名HQL查询
     *  
     * @param queryName 命名HQL
     * @param values 参数值集合
     * 
     * @return List 查询结果集
     * </p>
     */
    public abstract List getListByHQL(String queryName,Object[] values);

    /**
     * <p>
     * 功能描述:执行带命名参数的命名HQL查询
     *  
     * @param queryName 命名HQL
     * @param paramNames 参数名集合 
     * @param values 参数值集合
     * 
     * @return List 查询结果集
     * </p>
     */
    public abstract List getListByHQL(String queryName,
	    String[] paramNames, Object[] values);
    /**
     * <p>
     * 功能描述:执行HQL分页查询
     *  
     * @param queryName 命名HQL
     * @param firstResult 从第几条开始
     * @param maxResults 共取几条
     * 
     * @return List 查询结果集
     * </p>
     */
    public abstract List getPaginationListByHQL(String queryName,
	    int firstResult, int maxResults);

    /**
     * <p>
     * 功能描述:执行带占位符的命名HQL分页查询
     *  
     * @param queryName 命名HQL
     * @param values 参数值集合
     * @param firstResult 从第几条开始
     * @param maxResults 共取几条
     * 
     * @return List 查询结果集
     * </p>
     */
    public abstract List getPaginationListByHQL(String queryName,
	    Object[] values, int firstResult, int maxResults);

    /**
     * <p>
     * 功能描述:执行带命名参数的命名HQL分页查询
     *  
     * @param queryName 命名HQL
     * @param paramNames 参数名集合 
     * @param values 参数值集合
     * @param firstResult 从第几条开始
     * @param maxResults 共取几条
     * 
     * @return List 查询结果集
     * </p>
     */
    public abstract List getPaginationListByHQL(String queryName,
	    String[] paramNames, Object[] values, int firstResult,
	    int maxResults);

    /**
     * <p>
     * 功能描述:执行命名HQL查询,返回第一个对象,若没有则返回null
     *  
     * @param queryName HQL名字
     * 
     * @return Object 查询结果
     * </p>
     */
    public abstract Object getObjectByHQL(String queryName);

    /**
     * <p>
     * 功能描述:执行带占位符的命名HQL查询,返回第一个对象,若没有则返回null
     *  
     * @param queryName HQL名字
     * @param values 参数值集合
     * 
     * @return Object 查询结果
     * </p>
     */
    public abstract Object getObjectByHQL(String queryName, Object[] values);

    /**
     * <p>
     * 功能描述:执行带命名参数的命名HQL查询,返回第一个对象,若没有则返回null
     *  
     * @param queryName HQL名字
     * @param paramNames 参数名集合
     * @param values 参数值集合
     * 
     * @return Object 查询结果
     * </p>
     */
    public abstract Object getObjectByHQL(String queryName,
	    String[] paramNames, Object[] values);

    /**
     * <p>
     * 功能描述:执行SQL查询
     *  
     * @param sql SQL
     * 
     * @return List 结果集
     * </p>
     */
    public abstract List getListBySQL(String sql);

    /**
     * <p>
     * 功能描述:执行带占位符的SQL分页查询
     *  
     * @param sql SQL
     * @param values 参数值集合
     * 
     * @return List 结果集
     * </p>
     */
    public abstract List getListBySQL(String sql, Object[] values);

    /**
     * <p>
     * 功能描述:执行带占位符的SQL分页查询
     *  
     * @param sql SQL
     * @param values 参数值集合
     * @param firstResult 从第几条开始
     * @param maxResults 共取几条
     * 
     * @return List 结果集
     * </p>
     */
    public abstract List getPaginationListBySQL(String sql, Object[] values,
	    int firstResult, int maxResults);

    /**
     * <p>
     * 功能描述:执行SQL查询,返回第一个对象
     *  
     * @param sql SQL
     * 
     * @return Object 查询的第一个对象
     * </p>
     */
    public abstract Object getObjectBySQL(String sql);

    /**
     * <p>
     * 功能描述:执行带占位符的SQL查询,返回第一个对象
     *  
     * @param sql SQL
     * @param values 参数值集合
     * 
     * @return Object 查询的第一个对象
     * </p>
     */
    public abstract Object getObjectBySQL(String sql, Object[] values);

}