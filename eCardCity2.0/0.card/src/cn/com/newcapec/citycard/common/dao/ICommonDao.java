package cn.com.newcapec.citycard.common.dao;

import java.io.Serializable;
import java.util.List;

import cn.com.newcapec.common.dao.IBaseDao;
import cn.com.newcapec.common.domain.NameValue;

/**
 * <pre>
 * 功能描述:项目公共DAO接口定义
 *   
 * Author : Wangjian 
 * Date   : 2008-05-08
 * Time   : 16:47:15
 * Version: 1.0
 * </pre>
 */
public interface ICommonDao extends IBaseDao{
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
	public Integer getMaxOrderNo(Class cls,Boolean hasDelFlag);
	
	/**
	 * <pre>
	 * 功能描述：执行批量假删除若干条记录
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @return
	 * </pre>
	 */
	public void removeRecords(Class cls,List idList);
	
	/**
	 * <pre>
	 * 功能描述：执行批量删除若干条记录，根据主键
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @return
	 * </pre>
	 */
	public void delRecordsByPK(Class cls,List idList);
	
	/**
	 * <pre>
	 * 功能描述：执行批量删除若干条记录，根据指定字段
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @return
	 * </pre>
	 */
	public void delRecordsByColumn(Class cls,List idList,String column);
	
	/**
	 * 根据主键得到Object
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param id		pk
	 * @return			object
	 * */
	public Object getObj(Class cls, Serializable id);

	/**
	 * 查找指定的Object数量
	 * 
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return integer		对象数量
	 */
	public Integer getObjCountByAttr(Class cls, NameValue[] attrColl);

	/**
	 * 查找指定的Object列表
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return List 		根据给定的属性返回当前列表
	 */
	public List getObjListByAttr(Class cls, NameValue[] attrColl);

	/**
	 * 查找指定的Object分页列表
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return List 		根据给定的属性返回当前分页列表
	 */
	public List getObjPaginationListByAttr(Class cls, NameValue[] attrColl,
			int firstResult, int maxResults);

}
