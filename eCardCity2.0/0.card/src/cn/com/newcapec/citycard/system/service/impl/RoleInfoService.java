package cn.com.newcapec.citycard.system.service.impl;

import java.util.List;

import cn.com.newcapec.common.domain.NameValue;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.common.service.impl.BaseService;
import cn.com.newcapec.citycard.common.po.TOrgMapRolePermission;
import cn.com.newcapec.citycard.common.po.TOrgRole;
import cn.com.newcapec.citycard.system.dao.IRoleInfoDao;
import cn.com.newcapec.citycard.system.service.IRoleInfoService;


/**
 * <p>
 * 角色维护的service
 * 
 * @author: Wangjian
 * @version: 1.0 May 8, 2008 10:37:45 AM
 *           </p>
 */
public class RoleInfoService extends BaseService implements IRoleInfoService {

	/**
	 * 角色的dao，根据接口进行依赖注入
	 */
	private IRoleInfoDao roleInfoDao;

	public IRoleInfoDao getRoleInfoDao() {
		return roleInfoDao;
	}

	public void setRoleInfoDao(IRoleInfoDao roleInfoDao) {
		this.roleInfoDao = roleInfoDao;
	}

	/**
	 * 查询当前满足查询条件的记录总数
	 * 
	 * @param roleInfo:
	 *            TOrgRole对象
	 * @return 根据给定的TOrgRole返回记录总数
	 */
	public Integer getRoleInfoCountByQuery(TOrgRole roleInfo)
			throws BusinessException {
		return roleInfoDao.getRoleInfoCountByQuery(roleInfo);
	}

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
			int firstResult, int maxResults) throws BusinessException {
		return roleInfoDao.getRoleInfoListByQuery(roleInfo, firstResult,
				maxResults);
	}

	/**
	 * 根据主键查询记录的详细信息
	 * 
	 * @param id:
	 *            RoleInfo主键
	 * @return RoleInfo: RoleInfo对象
	 */
	public TOrgRole getRoleInfoByPK(int id) {
		return (TOrgRole) baseDao.get(TOrgRole.class, id);
	}

	/**
	 * 校验添加重复的角色
	 * 
	 * @param roleName角色类别名称
	 * @return
	 * @throws BusinessException
	 *             业务异常
	 */
	public Boolean checkRoleInfoIsRepeat(String roleName)
			throws BusinessException {
		return roleInfoDao.getRoleInfoCountByName(roleName) > 0;
	}

	/**
	 * 保存或修改角色
	 * 
	 * @param obj：角色
	 * @return
	 * @throws BusinessException
	 *             业务异常
	 */
	public void saveOrUpdateRoleInfo(TOrgRole roleInfo)
			throws BusinessException {
		assert roleInfo != null;
		Integer id = roleInfo.getId();
		String roleName = roleInfo.getRoleName();
		if (null == roleName || roleName.length() == 0) {
			throw new BusinessException("角色不能为空");
		}
		if (id == null) {
			if (checkRoleInfoIsRepeat(roleName)) {
				throw new BusinessException("角色重复");
			}
			baseDao.save(roleInfo);
			return;
		}

		TOrgRole tmpRoleInfo = getRoleInfoByPK(id);
		if (!roleName.equals(tmpRoleInfo.getRoleName())
				&& checkRoleInfoIsRepeat(roleName)) {
			throw new BusinessException("角色重复");
		}
		tmpRoleInfo.setRoleName(roleName);
		tmpRoleInfo.setRemark(roleInfo.getRemark());
		baseDao.update(tmpRoleInfo);
	}

	/**
	 * 功能描述:得到所有的角色
	 * 
	 * 
	 * @return List 角色列表
	 */
	public List<TOrgRole> getRoleInfoList() throws BusinessException {
		return roleInfoDao.getRoleInfoList();
	}

	/**
	 * 获得所有可用角色名值对列表
	 * 
	 * @author Wangjian
	 * 
	 * @return list 角色名值对列表
	 */
	@SuppressWarnings("unchecked")
	public List<NameValue> getRoleInfoNameValueList() {
		return roleInfoDao.getRoleInfoNameValueList();
	}

	/**
	 * 删除所选择的角色
	 * 
	 */
	public void deleteRoleInfo(List<Integer> idList) throws BusinessException {
		assert idList != null && idList.size() > 0;
		roleInfoDao.deleteRoleInfoByIdList(idList);
	}

	/**
	 * 为指定的角色分配功能模块操作权限
	 * 
	 * @param roleId
	 *            角色ID moduleIds 封装所分配的权限模块ID的字符串,ID号间以逗号分隔
	 */
	public void saveModuleToRole(Integer roleId, String moduleIds)
			throws BusinessException {
		assert roleId != null;
		//assert moduleIds != null;
		String[] ids = null;
		if( null != moduleIds ){
			ids = moduleIds.split(",");
		}
		String delOldHql = "delete TOrgMapRolePermission where fkRole=" + roleId;
		baseDao.bulkUpdate(delOldHql);
		if (null != ids && ids.length != 0) {
			for (int i = 0; i < ids.length; i++) {
				TOrgMapRolePermission roleModuleInfo = new TOrgMapRolePermission();
				roleModuleInfo.setFkRole(roleId);
				roleModuleInfo.setFkPermission(Integer.parseInt(ids[i].trim()));
				baseDao.save(roleModuleInfo);
			}
		}

	}

	/**
	 * 查找指定的用户已分配的角色列表
	 * @param userId  用户ID
	 * @return List 指定的用户已分配的角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<NameValue> getUserHaveRoleInfoList(Integer userId)
			throws BusinessException{
		assert userId != null;
		return roleInfoDao.getUserHaveRoleInfoListByUserId(userId);
	}

	/**
	 * 查找指定的用户未分配的角色列表
	 * @param userId  用户ID
	 * @return List 指定的用户未分配的角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<NameValue> getUserNoRoleInfoList(Integer userId)
			throws BusinessException{
		assert userId != null;
		return roleInfoDao.getUserNoRoleInfoListByUserId(userId);
	}
}
