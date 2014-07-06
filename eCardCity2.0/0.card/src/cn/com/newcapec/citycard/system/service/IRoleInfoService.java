package cn.com.newcapec.citycard.system.service;

import java.util.List;

import cn.com.newcapec.common.domain.NameValue;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.citycard.common.po.TOrgRole;

/**
 * <p>
 * 角色维护的service
 * 
 * @author: Wangjian
 * @version: 1.0 May 29, 2008 03:37:45 AM
 *           </p>
 */
public interface IRoleInfoService {

	/**
	 * 查询当前满足查询条件的记录总数
	 * 
	 * @param roleInfo:
	 *            RoleInfo对象
	 * @return 根据给定的roleInfo返回记录总数
	 */
	public Integer getRoleInfoCountByQuery(TOrgRole roleInfo)
			throws BusinessException;

	/**
	 * 功能描述:得到满足查询条件的角色分页列表
	 * 
	 * @param roleInfo
	 *            查询条件
	 * @param firstResult
	 *            从第几条开始
	 * @param maxResults
	 *            共取几条
	 * @throws BusinessException
	 *             业务异常
	 * @return List 角色类型列表
	 */
	public List<TOrgRole> getRoleInfoListByQuery(TOrgRole roleInfo,
			int firstResult, int maxResults) throws BusinessException;

	/**
	 * 根据主键查询记录的详细信息
	 * 
	 * @param id:
	 *            角色主键
	 * @return RoleInfo: RoleInfo对象
	 */
	public TOrgRole getRoleInfoByPK(int id);

	/**
	 * 保存和修改角色
	 * 
	 * @param obj：角色
	 * @return
	 * @throws BusinessException
	 *             业务异常
	 */
	public void saveOrUpdateRoleInfo(TOrgRole obj) throws BusinessException;

	/**
	 * 功能描述:得到所有的角色
	 * 
	 * 
	 * @return List 角色列表
	 */
	public List<TOrgRole> getRoleInfoList() throws BusinessException;

	/**
	 * 获得所有可用角色名值对列表
	 * 
	 * @author Wangjian
	 * 
	 * @return list 角色名值对列表
	 */
	@SuppressWarnings("unchecked")
	public List <NameValue> getRoleInfoNameValueList();

	/**
	 * 删除所选择的角色
	 * 
	 */
	public void deleteRoleInfo(List<Integer> id)
			throws BusinessException;
	
	/**
	 * 为指定的角色分配功能模块操作权限
	 * @param roleId  角色ID
	 *        moduleIds 封装所分配的权限模块ID的字符串,ID号间以逗号分隔
	 */
	@SuppressWarnings("unchecked")
	public void saveModuleToRole(Integer roleId,String moduleIds) throws BusinessException;
	
	/**
	 * 查找指定的用户已分配的角色列表
	 * @param userId  用户ID
	 * @return List 指定的用户已分配的角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<NameValue> getUserHaveRoleInfoList(Integer userId) throws BusinessException;
	
	/**
	 * 查找指定的用户未分配的角色列表
	 * @param userId  用户ID
	 * @return List 指定的用户未分配的角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<NameValue> getUserNoRoleInfoList(Integer userId) throws BusinessException;
	
}
