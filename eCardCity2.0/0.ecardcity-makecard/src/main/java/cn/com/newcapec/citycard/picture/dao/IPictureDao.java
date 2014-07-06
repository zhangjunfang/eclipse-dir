package cn.com.newcapec.citycard.picture.dao;


import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * 功能描述:图片关联设置Dao接口定义
 *   
 * Author : Wangjian 
 * Date   : 2013-02-03
 * Time   : 22:25:15
 * Version: 1.0
 * </p>
 */

public interface IPictureDao {

	/**
	 * 获取信息总数
	 * @param 	schStr			检索条件
	 * @return	Integer			记录总数
	 */
	public Integer getPharmacyCount(String schStr);

	/**
	 * 获取信息列表
	 * @param 	schStr			检索条件
	 * @param 	firstResult 	从第几条开始
	 * @param 	maxResults 		共取几条
	 * @return	List			信息列表
	 */
	public List getPharmacyList(String schStr, int firstResult, int maxResults);

	/**
	 * 获取总数
	 * @param 	schStr			检索条件
	 * @return	Integer			记录总数
	 */
	public Integer getMedicineCount(String schStr);

	/**
	 * 获取信息列表
	 * @param 	schStr			检索条件
	 * @param 	firstResult 	从第几条开始
	 * @param 	maxResults 		共取几条
	 * @return	List			信息列表
	 */
	public List getMedicineList(String schStr, int firstResult, int maxResults);

	/**
	 * 获取信息
	 * @param 	guid			标识ID
	 * @return	Object[]		记录集
	 */
	public Object[] getPharmacy(String guid);

	/**
	 * 获取信息
	 * @param 	guid			标识ID
	 * @return	Object[]		记录集
	 */
	public Object[] getMedicine(String guid);

	/**
	 * <p>
	 * 功能描述：执行批量删除若干条图片记录
	 * @param cls 		持久化实体类
	 * @param guidList	guid集合
	 * @return
	 * </p>
	 */
	public void delPic(Class cls, List guidList);

	/**
	 * 获取全部列表
	 * @param firstResult	从第几条开始
	 * @param maxResults	共取几条
	 * @return List 信息列表
	 */
	public List getAllPharmacyList(int firstResult, int maxResults);

	/**
	 * 获取全部列表
	 * 
	 * @return Integer 记录总数
	 */
	public Integer getAllPharmacyCount();

	/**
	 * 获取符合条件的全部信息总数
	 * 
	 * @param schStr	检索条件
	 * @return Integer 	记录总数
	 */
	public Integer getAllMedicineCount(String schStr);

	/**
	 * 获取符合条件的全部信息
	 * 
	 * @param schStr 		检索条件
	 * @param firstResult	从第几条开始
	 * @param maxResults	共取几条
	 * @return List  		信息列表
	 */
	public List getAllMedicineList(String schStr, int firstResult, int maxResults);

}
