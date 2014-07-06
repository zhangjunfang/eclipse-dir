package cn.com.newcapec.common.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.com.newcapec.common.dao.IBaseDao;

/**
 * <pre>
 * 功能描述:常用DAO接口实现
 *   
 * Author : Wangjian 
 * Date   : 2007-10-12 
 * Time   : 8:54:56
 * Version:1.0
 * </pre>
 */

public class BaseDao extends HibernateDaoSupport implements IBaseDao{

	/**
	 * <pre>
	 * 功能描述:保存持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * 
	 * @return Serializable 返回持久化对象实例标识 
	 * </pre>
	 */
	public Serializable save(Object entity)
	{
		return getHibernateTemplate().save(entity);
	}

	/**
	 * <pre>
	 * 功能描述:保存或更新持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * </pre>
	 */
	public void saveOrUpdate(Object entity)
	{
		getHibernateTemplate().saveOrUpdate(entity);
	}

	/**
	 * <pre>
	 * 功能描述:保存或更新持久化对象实例集
	 * 
	 * @param entities 持久化对象实例集
	 * </pre>
	 */
	public void saveOrUpdateAll(Collection entities)
	{
		getHibernateTemplate().saveOrUpdateAll(entities);
	}

	/**
	 * <pre>
	 * 功能描述:更新持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * </pre>
	 */
	public void update(Object entity)
	{
		getHibernateTemplate().update(entity);
	}

	/**
	 * <pre>
	 * 功能描述:以指定的锁模式更新持久化对象实例
	 *        
	 * 
	 * @param entity 持久化对象实例
	 * @param lockMode 锁模式
	 * </pre>
	 */
	public void update(Object entity, LockMode lockMode)
	{
		getHibernateTemplate().update(entity, lockMode);
	}

	/**
	 * <pre>
	 * 功能描述:删除持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * </pre>
	 */
	public void delete(Object entity)
	{
		getHibernateTemplate().delete(entity);
	}

	/**
	 * <pre>
	 * 功能描述:以指定的锁模式删除持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * @param lockMode 锁模式
	 * </pre>
	 */
	public void delete(Object entity, LockMode lockMode)
	{
		getHibernateTemplate().delete(entity, lockMode);
	}

	/**
	 * <pre>
	 * 功能描述:删除持久化对象实例集
	 * 
	 * @param entities 持久化对象实例集
	 * </pre>
	 */
	public void deleteAll(Collection entities)
	{
		getHibernateTemplate().deleteAll(entities);
	}

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
	public Object get(Class entityClass, Serializable id)
	{
		return getHibernateTemplate().get(entityClass, id);
	}

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
	public Object get(Class entityClass, Serializable id, LockMode lockMode)
	{
		return getHibernateTemplate().get(entityClass, id, lockMode);
	}

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
	public Object load(Class entityClass, Serializable id)
	{
		return getHibernateTemplate().load(entityClass, id);
	}

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
	public Object load(Class entityClass, Serializable id, LockMode lockMode)
	{
		return getHibernateTemplate().load(entityClass, id, lockMode);
	}
	
	/**
	 * <pre>
	 * 功能描述:加载所有持久化对象的实例
	 * 
	 * @param entityClass 持久化类
	 * </pre>
	 */
	public List loadAll(Class entityClass)
	{
		return getHibernateTemplate().loadAll(entityClass);
	}

	/**
	 * <pre>
	 * 功能描述:刷新持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * </pre>
	 */
	public void refresh(Object entity)
	{
		getHibernateTemplate().refresh(entity);
	}

	/**
	 * <pre>
	 * 功能描述:以指定的锁模式刷新持久化对象实例
	 * 
	 * @param entity 持久化对象实例
	 * @param lockMode 锁模式
	 * </pre>
	 */
	public void refresh(Object entity, LockMode lockMode)
	{
		getHibernateTemplate().refresh(entity, lockMode);
	}

	/**
	 * <pre>
	 * 功能描述:将之前的增删改操作保存到数据库
	 * </pre>
	 */
	public void flush()
	{
		getHibernateTemplate().flush();
	}

	/**
	 * <pre>
	 * 功能描述:取消之前对数据库的增删改操作
	 * </pre>
	 */
	public void clear()
	{
		getHibernateTemplate().clear();
	}

    /**
	 * <pre>
	 * 功能描述:合并持久化对象实例
     *
     * @param entity 持久化对象实例
     *
	 * @return Object 合并后的持久化对象实例
	 * </pre>
	 */
	public Object merge(Object entity)
    {
        return getHibernateTemplate().merge(entity);
    }

    /**
	 * <pre>
	 * 功能描述:持久化瞬时状态的持久化对象实例
     *
     * @param entity 持久化对象实例
	 * </pre>
	 */
	public void persist(Object entity)
    {
        getHibernateTemplate().persist(entity);
    }

    /**
	 * <pre>
	 * 功能描述:检查持久化对象实例是否在当前会话中
     *
     * @param entity 持久化对象实例
     *
     * @return boolean 在,返回true;否则false
	 * </pre>
	 */
	public boolean contains(Object entity)
    {
        return getHibernateTemplate().contains(entity);
    }

    /**
	 * <pre>
	 * 功能描述:从当前会话中移除持久化对象实例
     *
     * @param entity 持久化对象实例
	 * </pre>
	 */
    public void evict(Object entity)
    {
        getHibernateTemplate().evict(entity);
    }

    /**
	 * <pre>
	 * 功能描述:执行HQL查询,迭代结果
     *
     * @param hql HQL
     *
     * @return Iterator 迭代结果
	 * </pre>
	 */
    public Iterator iterate(String hql)
    {
         return getHibernateTemplate().iterate(hql);
    }

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
    public Iterator iterate(final String hql,final Object[] values)
    {
        return getHibernateTemplate().iterate(hql,values);
    }

    /**
	 * <pre>
	 * 功能描述:批量更新
	 * 
	 * @param hql HQL
	 * @return int 批量更新的记录条数
	 * </pre>
	 */
	public int bulkUpdate(String hql)
	{
		return getHibernateTemplate().bulkUpdate(hql);
	}
	
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
	public int bulkUpdate(String hql, Object[] values)
	{
		return getHibernateTemplate().bulkUpdate(hql, values);
	}
	
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
	public int bulkUpdate(final String hql, final String[] paramNames, final Object[] values)
	{
		if (paramNames != null && values != null && paramNames.length != values.length)
		{
			throw new IllegalArgumentException("命名参数和值个数不一致!");
		}
		return (Integer) getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.createQuery(hql);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						applyNamedParameterToQuery(query, paramNames[i], values[i]);
					}
				}
				return query.executeUpdate();
			}
		}, true);
	}

	/**
	 * <pre>
	 * 功能描述:执行基于Hibernate参考对象的查询
	 *  
	 * @param criteria Hibernate参考对象
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List findByCriteria(DetachedCriteria criteria)
	{
		return getHibernateTemplate().findByCriteria(criteria);
	}

	/**
	 * <pre>
	 * 功能描述:执行基于样例参考对象的查询
	 *  
	 * @param exampleEntity 样例参考对象
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List findByExample(Object exampleEntity)
	{
		return getHibernateTemplate().findByExample(exampleEntity);
	}

	/**
	 * <pre>
	 * 功能描述:执行HQL查询
	 *  
	 * @param hql HQL
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List find(String hql)
	{
		return getHibernateTemplate().find(hql);
	}

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
	public List find(String hql, Object[] values)
	{
		return getHibernateTemplate().find(hql, values);
	}

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
	public List findByNamedParam(String hql, String[] paramNames, Object[] values)
	{
		return getHibernateTemplate().findByNamedParam(hql, paramNames, values);
	}

	/**
	 * <pre>
	 * 功能描述:执行命名HQL查询
	 *  
	 * @param queryName HQL名字
	 * 
	 * @return List 查询结果集
	 * </pre>
	 */
	public List findByNamedQuery(String queryName)
	{
		return getHibernateTemplate().findByNamedQuery(queryName);
	}

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
	public List findByNamedQuery(String queryName, Object[] values)
	{
		return getHibernateTemplate().findByNamedQuery(queryName, values);
	}

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
	public List findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values)
	{
		return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName, paramNames, values);
	}

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
	public List getPaginationList(String hql, int firstResult, int maxResults)
	{
		return getPaginationList(hql, null, firstResult, maxResults);
	}

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
	public List getPaginationList(final String hql, final Object[] values, final int firstResult, final int maxResults)
	{
		return (List) getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.createQuery(hql);
				prepareQuery(query);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						query.setParameter(i, values[i]);
					}
				}
				return query.setFirstResult(firstResult).setMaxResults(maxResults).list();
			}
		}, true);
	}

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
	public List getPaginationListByNamedParam(final String hql, final String[] paramNames, final Object[] values,
			final int firstResult, final int maxResults)
	{
		if (paramNames != null && values != null && paramNames.length != values.length)
		{
			throw new IllegalArgumentException("命名参数和值个数不一致!");
		}
		return (List) getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.createQuery(hql);
				prepareQuery(query);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						applyNamedParameterToQuery(query, paramNames[i], values[i]);
					}
				}
				return query.setFirstResult(firstResult).setMaxResults(maxResults).list();
			}
		}, true);
	}

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
	public List getPaginationListByNamedQuery(String queryName, int firstResult, int maxResults)
	{
		return getPaginationListByNamedQuery(queryName, null, firstResult, maxResults);
	}

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
	public List getPaginationListByNamedQuery(final String queryName, final Object[] values, final int firstResult,
			final int maxResults)
	{
		return (List) getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.getNamedQuery(queryName);
				prepareQuery(query);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						query.setParameter(i, values[i]);
					}
				}
				return query.setFirstResult(firstResult).setMaxResults(maxResults).list();
			}
		}, true);
	}

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
	public List getPaginationListByNamedQueryAndNamedParam(final String queryName, final String[] paramNames,
			final Object[] values, final int firstResult, final int maxResults)
	{
		if (paramNames != null && values != null && paramNames.length != values.length)
		{
			throw new IllegalArgumentException("命名参数和值个数不一致!");
		}
		return (List) getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.getNamedQuery(queryName);
				prepareQuery(query);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						applyNamedParameterToQuery(query, paramNames[i], values[i]);
					}
				}
				return query.setFirstResult(firstResult).setMaxResults(maxResults).list();
			}
		}, true);
	}

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
	public List getPaginationListByExample(Object exampleEntity, int firstResult, int maxResults)
	{
		return getHibernateTemplate().findByExample(exampleEntity, firstResult, maxResults);
	}

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
	public List getPaginationListByCriteria(DetachedCriteria criteria, int firstResult, int maxResults)
	{
		return getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	/**
	 * <pre>
	 * 功能描述:执行基于Hibernate参考对象的查询,返回第一个对象,若没有则返回null
	 *  
	 * @param criteria Hibernate参考对象
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObjectByCriteria(final DetachedCriteria criteria)
	{
		return getHibernateTemplate().execute(new HibernateCallback() 
        {   
            public Object doInHibernate(Session session) throws HibernateException 
            {   
            	return criteria.getExecutableCriteria(session)
				            			.setMaxResults(1)
				            			.uniqueResult();   
            }   
        }, true);
	}

	/**
	 * <pre>
	 * 功能描述:执行基于样例参考对象的查询,返回第一个对象,若没有则返回null
	 *  
	 * @param exampleEntity 样例参考对象
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObjectByExample(final Object exampleEntity)
	{
		assert exampleEntity!=null;
		
		return getHibernateTemplate().execute(new HibernateCallback() 
        {   
            public Object doInHibernate(Session session) throws HibernateException 
            {   
            	return session.createCriteria(exampleEntity.getClass())
				                        .add(Example.create(exampleEntity))
				            			.setMaxResults(1)
				            			.uniqueResult();   
            }   
        }, true);
	}

	/**
	 * <pre>
	 * 功能描述:执行HQL查询,返回第一个对象,若没有则返回null
	 *  
	 * @param hql HQL
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObject(String hql)
	{
		return findObject(hql, null);
	}

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
	public Object findObject(final String hql, final Object[] values)
	{
		return getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.createQuery(hql);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						query.setParameter(i, values[i]);
					}
				}
				return query.setMaxResults(1).uniqueResult();
			}
		}, true);
	}

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
	public Object findObjectByNamedParam(final String hql,final String[] paramNames,final Object[] values)
	{
		if (paramNames != null && values != null && paramNames.length != values.length)
		{
			throw new IllegalArgumentException("命名参数和值个数不一致!");
		}
		return getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.createQuery(hql);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						applyNamedParameterToQuery(query, paramNames[i], values[i]);
					}
				}
				return query.setMaxResults(1).uniqueResult();
			}
		}, true);
	}

	/**
	 * <pre>
	 * 功能描述:执行命名HQL查询,返回第一个对象,若没有则返回null
	 *  
	 * @param queryName HQL名字
	 * 
	 * @return Object 查询结果
	 * </pre>
	 */
	public Object findObjectByNamedQuery(String queryName)
	{
		return findObjectByNamedQuery(queryName, null);
	}

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
	public Object findObjectByNamedQuery(final String queryName, final Object[] values)
	{
		return getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.getNamedQuery(queryName);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						query.setParameter(i, values[i]);
					}
				}
				return query.setMaxResults(1).uniqueResult();
			}
		}, true);
	}

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
	public Object findObjectByNamedQueryAndNamedParam(final String queryName,final  String[] paramNames,final  Object[] values)
	{
		if (paramNames != null && values != null && paramNames.length != values.length)
		{
			throw new IllegalArgumentException("命名参数和值个数不一致!");
		}
		return getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.getNamedQuery(queryName);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						applyNamedParameterToQuery(query, paramNames[i], values[i]);
					}
				}
				return query.setMaxResults(1).uniqueResult();
			}
		}, true);
	}

	/**
	 * <pre>
	 * 功能描述:预处理查询
	 *  
	 * @param query Query对象
	 * </pre>
	 */
	protected void prepareQuery(Query query)
	{
		if (getHibernateTemplate().isCacheQueries())
		{
			query.setCacheable(true);
			if (getHibernateTemplate().getQueryCacheRegion() != null)
			{
				query.setCacheRegion(getHibernateTemplate().getQueryCacheRegion());
			}
		}
		if (getHibernateTemplate().getFetchSize() > 0)
		{
			query.setFetchSize(getHibernateTemplate().getFetchSize());
		}
		if (getHibernateTemplate().getMaxResults() > 0)
		{
			query.setMaxResults(getHibernateTemplate().getMaxResults());
		}
		SessionFactoryUtils.applyTransactionTimeout(query, getSessionFactory());
	}

	/**
	 * <pre>
	 * 功能描述:绑定命名参数和值
	 *  
	 * @param query Query对象
	 * @param paramName 参数名集合
	 * @param value 参数值集合
     *
     * @throws HibernateException 
	 * </pre>
	 */
	protected void applyNamedParameterToQuery(Query query, String paramName, Object value) throws HibernateException
	{
		if (value instanceof Collection)
		{
			query.setParameterList(paramName, (Collection) value);
		}
		else if (value instanceof Object[])
		{
			query.setParameterList(paramName, (Object[]) value);
		}
		else
		{
			query.setParameter(paramName, value);
		}
	}
	
	/**
	 * <pre>
	 * 功能描述:执行SQL查询
	 *  
	 * @param sql SQL
	 * 
	 * @return List 结果集
	 * </pre>
	 */
	public List findBySQL(final String sql)
	{
		return findBySQL(sql, null);
	}

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
	public List findBySQL(final String sql, final Object[] values)
	{
		return (List) getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.createSQLQuery(sql);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						query.setParameter(i, values[i]);
					}
				}
				return query.list();
			}
		}, true);
	}
	
	/**
	 * <pre>
	 * 功能描述:执行带占位符的SQL查询
	 *  
	 * @param sql SQL
	 * @param values 参数值集合
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * 
	 * @return List 结果集
	 * </pre>
	 */
	public List findPaginationListBySQL(final String sql, final Object[] values,final int firstResult, final int maxResults)
	{
		return (List) getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.createSQLQuery(sql);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						query.setParameter(i, values[i]);
					}
				}
				return query.setFirstResult(firstResult).setMaxResults(maxResults).list();
			}
		}, true);
	}

	/**
	 * <pre>
	 * 功能描述:执行SQL查询,返回第一个对象
	 *  
	 * @param sql SQL
	 * 
	 * @return Object 查询的第一个对象
	 * </pre>
	 */
	public Object findObjectBySQL(String sql)
	{
		return findObjectBySQL(sql, null);
	}

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
	public Object findObjectBySQL(final String sql, final Object[] values)
	{
		return getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException
			{
				Query query = session.createSQLQuery(sql);
				if (values != null)
				{
					for (int i = 0; i < values.length; i++)
					{
						query.setParameter(i, values[i]);
					}
				}
				return query.setMaxResults(1).uniqueResult();
			}
		}, true);
	}
	
	/**
	 * <pre>
	 * 功能描述:执行QBC count()查询
	 *  
	 * @param detachedCriteria QBC
	 * 
	 * @return Integer count
	 * </pre>
	 */
	public Integer getCountByCriteria(final DetachedCriteria detachedCriteria) 
	{   
        return (Integer) getHibernateTemplate().execute(new HibernateCallback() 
        {   
            public Object doInHibernate(Session session) throws HibernateException 
            {   
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);   
                return criteria.setProjection(Projections.rowCount()).uniqueResult();   
            }   
        }, true);   
    }
}
