package cn.com.newcapec.citycard.picture.service;

import java.util.List;
/**
 * <p>
 * 药品、药店图片关联设置的service
 * 
 * @author: WangJian
 * @version: 1.0
 * February 22, 2013 17:34:03 PM
 * </p>
 */

public interface IPictureService {

	/**
	 * 获取药店信息总数
	 * @param 	schStr			检索条件
	 * @return	Integer			记录总数
	 */
	public Integer getPharmacyCount(String schStr);

	/**
	 * 获取药店信息列表
	 * @param 	schStr			检索条件
	 * @param 	firstResult 	从第几条开始
	 * @param 	maxResults 		共取几条
	 * @return	List			药店信息列表
	 */
	public List getPharmacyList(String schStr, int firstResult, int maxResults);

	/**
	 * 获取药品总数
	 * @param 	schStr			检索条件
	 * @return	Integer			记录总数
	 */
	public Integer getMedicineCount(String schStr);

	/**
	 * 获取药品信息列表
	 * @param 	schStr			检索条件
	 * @param 	firstResult 	从第几条开始
	 * @param 	maxResults 		共取几条
	 * @return	List			药店信息列表
	 */
	public List getMedicineList(String schStr, int firstResult, int maxResults);

	/**
	 * 获取药店信息
	 * @param 	guid			标识ID
	 * @return	Object[]		记录集
	 */
	public Object[] getPharmacy(String guid);

	/**
	 * 获取药品信息
	 * @param 	guid			标识ID
	 * @return	Object[]		记录集
	 */
	public Object[] getMedicine(String guid);

	/**
	 * <pre>
	 * 功能描述：执行删除若干条图片记录
	 * @param cls 		持久化实体类
	 * @param guidList	guid集合
	 * @return
	 * </pre>
	 */
	public void delPicture(Class cls, List guidList);

	/**
	 * 获取全部药店信息记录数
	 * @return	int				记录数
	 */
	public int getAllPharmacyCount();
	
	/**
	 * 获取全部药店信息列表
	 * @return	List			药店信息列表
	 */
	public List getAllPharmacyList();

	/**
	 * 获取全部药店列表，带分页
	 * @param firstResult	从第几条开始
	 * @param maxResults	共取几条
	 * @return List 药店信息列表
	 */
	public List getAllPharmacyPageList(int firstResult, int maxResults);

	/**
	 * 获取符合条件的全部药品记录数
	 * @param 	schStr			检索条件
	 * @return	int				记录数
	 */
	public int getAllMedicineCount(String schStr);

	/**
	 * 获取符合条件的全部药品分页列表
	 * @param 	schStr			检索条件
	 * @param 	firstResult 	从第几条开始
	 * @param 	maxResults 		共取几条
	 * @return	List			药品信息列表
	 */
	public List getAllMedicinePageList(String schStr, int firstResult, int maxResults);


}