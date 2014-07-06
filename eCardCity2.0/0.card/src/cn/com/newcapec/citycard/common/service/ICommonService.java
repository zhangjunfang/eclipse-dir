package cn.com.newcapec.citycard.common.service;

import java.util.List;

import cn.com.newcapec.common.domain.NameValue;


/**
 * <pre>
 * 功能描述:项目公共服务接口定义
 *   
 * Author : Wangjian 
 * Date   : 2008-05-09
 * Time   : 08:53:15
 * Version: 1.0
 * </pre>
 */
public interface ICommonService
{
	/**
	 * <pre>
	 * 功能描述：取得最大排序号的下一个序号
	 * 
	 * @param cls 持久化实体类
	 * 
	 * @return Integer 下一个序号
	 * </pre>
	 */
	public Integer getNextOrderNo(Class cls);
	
	/**
	 * <pre>
	 * 功能描述：执行假删除若干条记录
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @return
	 * </pre>
	 */
	public void removeRecords(Class cls,List idList);
	
	/**
	 * <pre>
	 * 功能描述：执行删除若干条记录
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @param column	指定的字段名称
	 * @return
	 * </pre>
	 */
	public void delRecords(Class cls,List idList,String column);
	
	/**
	 * 根据主键得到实体对象
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param id		pk
	 * @return			object
	 * */
	public Object getObj(Class cls, Integer id);

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

	/**
	 * 保存Object
	 * 
	 * @param	obj			Object
	 * @return
	 * @throws Exception 
	 */
	public void saveObj(Object obj) throws Exception;

	/**
	 * 修改Object
	 * 
	 * @param	obj			Object
	 * @return
	 * @throws Exception 
	 */
	public void updateObj(Object obj) throws Exception;
}
