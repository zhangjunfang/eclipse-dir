package cn.com.newcapec.citycard.system.dao;

import java.util.List;

import cn.com.newcapec.common.domain.NameValue;
import cn.com.newcapec.citycard.common.po.TOrgRole;

/**
 * <p>
 * 角色操作类用到的特殊DAO
 * 
 * @author: Wangjian
 * @version: 1.0 May 28, 2008 09:38:33 AM
 *           </p>
 */
public interface IRoleInfoDao {

	/**
	 * 查询当前满足查询条件的记录总数
	 * 
	 * @param roleInfo:
	 *            RoleInfo对象
	 * @return 根据给定的roleInfo返回记录总数
	 */
	public Integer getRoleInfoCountByQuery(TOrgRole roleInfo);

	/**
	 * 功能描述:检索重复角色的记录数
	 * 
	 * @param RoleInfo
	 *            角色
	 * 
	 * @return Integer 重复角色的记录数
	 */
	public Integer getRoleInfoCountByName(String roleName);

	/**
	 * 功能描述:得到满足查询条件的角色分页列表
	 * 
	 * @param roleInfo 查询条件
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条 
	 * 
	 * @return List 角色类型列表
	 * */
	public List<TOrgRole> getRoleInfoListByQuery(TOrgRole roleInfo,
			int firstResult, int maxResults);

	/**
	 * 功能描述:得到所有的角色
	 * 
	 * 
	 * @return List 角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<TOrgRole> getRoleInfoList();

	/**
	 * 获得所有可用角色名值对列表
	 * 
	 * @author Wangjian
	 *
	 * @return list 角色名值对列表
	 */
	@SuppressWarnings("unchecked")
	public List getRoleInfoNameValueList();
	
	
	/**
	 * 删除指定的角色记录
	 * 
	 */
	public void deleteRoleInfoByIdList(List <Integer> idList);
	
	
	/**
	 * 查找指定的用户已分配的角色列表
	 * @param userId  用户ID
	 * @return List 指定的用户已分配的角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<NameValue> getUserHaveRoleInfoListByUserId(Integer userId);

	/**
	 * 查找指定的用户未分配的角色列表
	 * @param userId  用户ID
	 * @return List 指定的用户未分配的角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<NameValue> getUserNoRoleInfoListByUserId(Integer userId);
}
