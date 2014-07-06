package cn.com.newcapec.citycard.common.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.newcapec.common.domain.NameValue;
import cn.com.newcapec.citycard.common.dao.ICommonDao;
import cn.com.newcapec.citycard.common.service.ICommonService;

/**
 * <pre>
 * 功能描述:项目公共服务接口实现
 *   
 * Author : Wangjian 
 * Date   : 2008-05-09
 * Time   : 08:53:15
 * Version: 1.0
 * </pre>
 */
public class CommonService implements ICommonService{
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private ICommonDao commonDao;//项目公共DAO接口

	public void setCommonDao(ICommonDao commonDao)
	{
		this.commonDao = commonDao;
	}
	
	/**
	 * 根据主键得到实体对象
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param id		pk
	 * @return			object
	 * */
	public Object getObj(Class cls, Integer id){
		assert id!=null;
		return commonDao.getObj(cls, id);
	}

	/**
	 * <pre>
	 * 功能描述：取得最大排序号的下一个序号
	 * 
	 * @param cls 持久化实体类
	 * 
	 * @return Integer 下一个序号
	 * </pre>
	 */
	public Integer getNextOrderNo(Class cls)
	{
		assert cls!=null;
		if(!hasOrderNoField(cls))
		{
			return null;
		}
		try
		{
			Integer maxOrderNo=(Integer)commonDao.getMaxOrderNo(cls,hasDelFlagField(cls));
			return maxOrderNo==null?1:maxOrderNo+1;
		}
		catch(Exception e)
		{
			if(log.isInfoEnabled())
			{
				log.info(e.getMessage());
			}
			return null;
		}
	}
	
	/**
	 * <pre>
	 * 功能描述：检查实体类是否有getOrderNo方法,并且返回值是否为整型
	 * 
	 * @param cls 持久化实体类
	 * 
	 * @return Boolean 实体类有getOrderNo方法,并且返回值为整型返回true;否则false
	 * </pre>
	 */
	private Boolean hasOrderNoField(Class cls)
	{
		try
		{
			Class returnType=cls.getMethod("getOrderNo", new Class[]{}).getReturnType();
			if(!(Integer.class.equals(returnType)||int.class.equals(returnType)))
			{
				if(log.isInfoEnabled())
				{
					log.info(cls.getName()+"方法getOrderNo()返回值非整型");
				}
				return false;
			}
			return true;
		}
		catch(Exception e)
		{
			if(log.isInfoEnabled())
			{
				log.info(cls.getName()+"缺少getOrderNo()方法");
			}
			return false;
		}
	}
	
	/**
	 * <pre>
	 * 功能描述：检查实体类是否有getDelFlag方法,并且返回值是否为字符串
	 * 
	 * @param cls 持久化实体类
	 * 
	 * @return Boolean 实体类有getDelFlag方法,并且返回值为整型返回true;否则false
	 * </pre>
	 */
	private Boolean hasDelFlagField(Class cls)
	{
		try
		{
			Class returnType=cls.getMethod("getDelFlag", new Class[]{}).getReturnType();
			if(!String.class.equals(returnType))
			{
				if(log.isInfoEnabled())
				{
					log.info(cls.getName()+"方法getDelFlag()返回值非String类型");
				}
				return false;
			}
			return true;
		}
		catch(Exception e)
		{
			if(log.isInfoEnabled())
			{
				log.info(cls.getName()+"缺少getDelFlag()方法");
			}
			return false;
		}
	}
	
	/**
	 * <pre>
	 * 功能描述：执行假删除若干条记录
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @return
	 * </pre>
	 */
	public void removeRecords(Class cls,List idList){
		assert cls!=null&&idList!=null&&idList.size()>0;
		try{
			commonDao.removeRecords(cls, idList);
		}catch (Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
	}
	
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
	public void delRecords(Class cls,List idList,String column){
		assert cls!=null&&idList!=null&&idList.size()>0;
		try{
			if(column==null){
				commonDao.delRecordsByPK(cls, idList);
			}else{
				commonDao.delRecordsByColumn(cls, idList, column);
			}
		}catch (Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
	}

	/**
	 * 查找指定的Object数量
	 * 
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return integer		对象数量
	 */
	public Integer getObjCountByAttr(Class cls,NameValue[] attrColl){
		assert cls != null;
		Integer ct=null;
		try{
			ct=commonDao.getObjCountByAttr(cls, attrColl);
		}catch (Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		return ct;
	}
	
	/**
	 * 查找指定的Object列表
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return List 		根据给定的属性返回当前列表
	 */
	public List getObjListByAttr(Class cls,NameValue[] attrColl) {
		assert cls != null;
		List list=null;
		try{
			list=commonDao.getObjListByAttr(cls, attrColl);
		}catch (Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		return list;
	}
	
	/**
	 * 查找指定的Object分页列表
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return List 		根据给定的属性返回当前分页列表
	 */
	public List getObjPaginationListByAttr(Class cls,NameValue[] attrColl, int firstResult, int maxResults) {
		assert cls != null;
		List pageList=null;
		try{
			pageList=commonDao.getObjPaginationListByAttr(cls, attrColl, firstResult, maxResults);
		}catch (Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		return pageList;
	}

	/**
	 * 保存Object
	 * 
	 * @param	obj			Object
	 * @return
	 * @throws Exception 
	 */
	public void saveObj(Object obj)throws Exception{
		assert obj != null;
		commonDao.save(obj);
	}	

	/**
	 * 修改Object
	 * 
	 * @param	obj			Object
	 * @return
	 * @throws Exception 
	 */
	public void updateObj(Object obj)throws Exception{
		assert obj != null;
		commonDao.merge(obj);
	}	
}
