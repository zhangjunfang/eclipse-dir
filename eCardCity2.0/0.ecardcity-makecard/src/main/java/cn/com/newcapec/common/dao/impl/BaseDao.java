package cn.com.newcapec.common.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;

import cn.com.newcapec.common.dao.IBaseDao;

/**
 * <p>
 * 功能描述:常用DAO接口实现
 *   
 * Author : Wangjian 
 * Date   : 2014-03-07 
 * Time   : 8:54:56
 * Version: 2.0
 * </p>
 */
public class BaseDao implements IBaseDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    /**
     * <p>
     * 功能描述:获取session
     * </p>
     */
    private Session getSession() {
	return sessionFactory.getCurrentSession();
    }

    /**
     * <p>
     * 功能描述:绑定命名参数和值
     *  
     * @param query Query对象
     * @param paramName 参数名集合
     * @param value 参数值集合
     * 
     * @throws HibernateException
     * </p>
     */
    @SuppressWarnings("rawtypes")
    private void applyNamedParameterToQuery(Query query, String paramName,
	    Object value) throws HibernateException {
	if (value instanceof Collection) {
	    query.setParameterList(paramName, (Collection) value);
	} else if (value instanceof Object[]) {
	    query.setParameterList(paramName, (Object[]) value);
	} else {
	    query.setParameter(paramName, value);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#save(java.lang.Object)
     */
    @Override
    public Serializable save(Object entity) {
	return getSession().save(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(Object entity) {
	getSession().saveOrUpdate(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#get(java.lang.Class,
     * java.io.Serializable)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public Object get(Class entityClass, Serializable id) {
	return getSession().get(entityClass, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#getAll(java.lang.Class)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getAll(Class entityClass) {
	return getSession().createQuery("from " + entityClass.getSimpleName())
		.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#update(java.lang.Object)
     */
    @Override
    public void update(Object entity) {
	getSession().update(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#delete(java.lang.Object)
     */
    @Override
    public void delete(Object entity) {
	getSession().delete(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#refresh(java.lang.Object)
     */
    @Override
    public void refresh(Object entity) {
	getSession().refresh(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#flush()
     */
    @Override
    public void flush() {
	getSession().flush();
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#clear()
     */
    @Override
    public void clear() {
	getSession().clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#merge(java.lang.Object)
     */
    @Override
    public Object merge(Object entity) {
	return getSession().merge(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#persist(java.lang.Object)
     */
    @Override
    public void persist(Object entity) {
	getSession().persist(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#contains(java.lang.Object)
     */
    @Override
    public boolean contains(Object entity) {
	return getSession().contains(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.com.newcapec.common.dao.impl.IBaseDao#evict(java.lang.Object)
     */
    @Override
    public void evict(Object entity) {
	getSession().evict(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#bulkUpdate(java.lang.String)
     */
    @Override
    public int bulkUpdate(final String hql) {
	Query query = getSession().createQuery(hql);
	return query.executeUpdate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#bulkUpdate(java.lang.String,
     * java.lang.Object[])
     */
    @Override
    public int bulkUpdate(final String hql, final Object[] values) {
	Query query = getSession().createQuery(hql);
	if (values != null) {
	    for (int i = 0; i < values.length; i++) {
		query.setParameter(i, values[i]);
	    }
	}
	return query.executeUpdate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#bulkUpdate(java.lang.String,
     * java.lang.String[], java.lang.Object[])
     */
    @Override
    public int bulkUpdate(final String hql, final String[] paramNames,
	    final Object[] values) {

	if (paramNames != null && values != null
		&& paramNames.length != values.length) {
	    throw new IllegalArgumentException("命名参数和值个数不一致!");
	}
	Query query = getSession().createQuery(hql);
	if (values != null) {
	    for (int i = 0; i < values.length; i++) {
		applyNamedParameterToQuery(query, paramNames[i], values[i]);
	    }
	}
	return query.executeUpdate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getListByCriteria(org.hibernate
     * .criterion.DetachedCriteria)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getListByCriteria(DetachedCriteria criteria) {
	return criteria.getExecutableCriteria(getSession()).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getObjectByCriteria(org.hibernate
     * .criterion.DetachedCriteria)
     */
    @Override
    public Object getObjectByCriteria(final DetachedCriteria criteria) {
	return criteria.getExecutableCriteria(getSession()).setMaxResults(1)
		.uniqueResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getCountsByCriteria(org.hibernate
     * .criterion.DetachedCriteria)
     */
    @Override
    public int getCountsByCriteria(final DetachedCriteria detachedCriteria) {
	return ((Long)detachedCriteria.getExecutableCriteria(getSession()).setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getPaginationListByCriteria(
     * org.hibernate.criterion.DetachedCriteria, int, int)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getPaginationListByCriteria(DetachedCriteria criteria,
	    int firstResult, int maxResults) {
	return criteria.getExecutableCriteria(getSession())
		.setFirstResult(firstResult).setMaxResults(maxResults).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getListByExample(java.lang.Object
     * )
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getListByExample(Object exampleEntity) {

	if (exampleEntity != null) {
	    return getSession().createCriteria(exampleEntity.getClass())
		    .add(Example.create(exampleEntity)).list();
	} else {
	    return null;
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getObjectByExample(java.lang
     * .Object)
     */
    @Override
    public Object getObjectByExample(final Object exampleEntity) {
	if (exampleEntity != null) {
	    return getSession().createCriteria(exampleEntity.getClass())
		    .add(Example.create(exampleEntity)).setMaxResults(1)
		    .uniqueResult();
	} else {
	    return null;
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getPaginationListByExample(java
     * .lang.Object, int, int)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getPaginationListByExample(Object exampleEntity,
	    int firstResult, int maxResults) {
	if (exampleEntity != null) {
	    return getSession().createCriteria(exampleEntity.getClass())
		    .add(Example.create(exampleEntity))
		    .setMaxResults(firstResult).setMaxResults(maxResults)
		    .list();
	} else {
	    return null;
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getListByHQL(java.lang.String)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getListByHQL(String queryName) {
	return getSession().createQuery(queryName).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getListByHQL(java.lang.String
     * ,java.lang.Object[])
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getListByHQL(final String queryName, final Object[] values) {
	Query query = getSession().createQuery(queryName);
	if (values != null) {
	    for (int i = 0; i < values.length; i++) {
		query.setParameter(i, values[i]);
	    }
	}
	return query.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getListByHQL(java.lang.String,
     * java.lang.String[], java.lang.Object[])
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getListByHQL(final String queryName, final String[] paramNames,
	    final Object[] values) {
	if (paramNames != null && values != null
		&& paramNames.length != values.length) {
	    throw new IllegalArgumentException("命名参数和值个数不一致!");
	}
	Query query = getSession().createQuery(queryName);
	if (values != null) {
	    for (int i = 0; i < values.length; i++) {
		applyNamedParameterToQuery(query, paramNames[i], values[i]);
	    }
	}
	return query.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getPaginationListByHQL(java.
     * lang.String, int, int)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getPaginationListByHQL(String queryName, int firstResult,
	    int maxResults) {
	return getPaginationListByHQL(queryName, null, firstResult, maxResults);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getPaginationListByHQL(java.
     * lang.String, java.lang.Object[], int, int)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getPaginationListByHQL(final String queryName,
	    final Object[] values, final int firstResult, final int maxResults) {
	Query query = getSession().createQuery(queryName);
	if (values != null) {
	    for (int i = 0; i < values.length; i++) {
		query.setParameter(i, values[i]);
	    }
	}
	return query.setFirstResult(firstResult).setMaxResults(maxResults)
		.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getPaginationListByHQL(java.
     * lang.String, java.lang.String[], java.lang.Object[], int, int)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getPaginationListByHQL(final String queryName,
	    final String[] paramNames, final Object[] values,
	    final int firstResult, final int maxResults) {
	if (paramNames != null && values != null
		&& paramNames.length != values.length) {
	    throw new IllegalArgumentException("命名参数和值个数不一致!");
	}
	Query query = getSession().createQuery(queryName);
	if (values != null) {
	    for (int i = 0; i < values.length; i++) {
		applyNamedParameterToQuery(query, paramNames[i], values[i]);
	    }
	}
	return query.setFirstResult(firstResult).setMaxResults(maxResults)
		.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getObjectByHQL(java.lang.String)
     */
    @Override
    public Object getObjectByHQL(String queryName) {
	return getObjectByHQL(queryName, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getObjectByHQL(java.lang.String,
     * java.lang.Object[])
     */
    @Override
    public Object getObjectByHQL(final String queryName, final Object[] values) {
	Query query = getSession().createQuery(queryName);
	if (values != null) {
	    for (int i = 0; i < values.length; i++) {
		query.setParameter(i, values[i]);
	    }
	}
	return query.setMaxResults(1).uniqueResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getObjectByHQL(java.lang.String,
     * java.lang.String[], java.lang.Object[])
     */
    @Override
    public Object getObjectByHQL(final String queryName,
	    final String[] paramNames, final Object[] values) {
	if (paramNames != null && values != null
		&& paramNames.length != values.length) {
	    throw new IllegalArgumentException("命名参数和值个数不一致!");
	}
	Query query = getSession().createQuery(queryName);
	if (values != null) {
	    for (int i = 0; i < values.length; i++) {
		applyNamedParameterToQuery(query, paramNames[i], values[i]);
	    }
	}
	return query.setMaxResults(1).uniqueResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getListBySQL(java.lang.String)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getListBySQL(final String sql) {
	return getListBySQL(sql, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getListBySQL(java.lang.String,
     * java.lang.Object[])
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getListBySQL(final String sql, final Object[] values) {
	return getPaginationListBySQL(sql, values, 0, 0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getPaginationListBySQL(java.
     * lang.String, java.lang.Object[], int, int)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getPaginationListBySQL(final String sql, final Object[] values,
	    final int firstResult, final int maxResults) {
	Query query = getSession().createSQLQuery(sql);
	if (values != null) {
	    for (int i = 0; i < values.length; i++) {
		query.setParameter(i, values[i]);
	    }
	}

	if (firstResult > 0 && maxResults > 0) {
	    query.setFirstResult(firstResult).setMaxResults(maxResults);
	}
	return query.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getObjectBySQL(java.lang.String)
     */
    @Override
    public Object getObjectBySQL(String sql) {
	return getObjectBySQL(sql, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.com.newcapec.common.dao.impl.IBaseDao#getObjectBySQL(java.lang.String
     * , java.lang.Object[])
     */
    @Override
    public Object getObjectBySQL(final String sql, final Object[] values) {
	Query query = getSession().createSQLQuery(sql);
	if (values != null) {
	    for (int i = 0; i < values.length; i++) {
		query.setParameter(i, values[i]);
	    }
	}
	return query.list().size() > 0 ? query.list().get(0) : null;
    }
}
