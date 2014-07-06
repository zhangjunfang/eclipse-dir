package cn.com.newcapec.citycard.system.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.common.service.impl.BaseService;
import cn.com.newcapec.citycard.common.po.TOrgPermission;
import cn.com.newcapec.citycard.system.dao.IModuleInfoDao;
import cn.com.newcapec.citycard.system.service.IModuleInfoService;

/**
 * <pre>O
 * 功能描述:模块管理服务接口实现
 *   
 * Author : Wangjian 
 * Date   : 2008-06-03
 * Time   : 10:25:15
 * Version: 1.0
 * </pre>
 */
public class ModuleInfoService extends BaseService implements
		IModuleInfoService {
	private IModuleInfoDao moduleInfoDao;// 菜单管理DAO接口

	public IModuleInfoDao getModuleInfoDao() {
		return moduleInfoDao;
	}

	public void setModuleInfoDao(IModuleInfoDao moduleInfoDao) {
		this.moduleInfoDao = moduleInfoDao;
	}

	/**
	 * 查询当前满足查询条件的记录总数
	 * 
	 * @param parentId:
	 *            Integer对象
	 * @return 根据给定的parentId返回记录总数
	 */
	public Integer getModuleInfoCountByQuery(Integer parentId)
			throws BusinessException {
		return moduleInfoDao.getModuleInfoCountByQuery(parentId);
	}

	/**
	 * 功能描述:得到功能模块树型目录结点列表
	 * 
	 * @return List<Node> 功能模块树型目录结点列表
	 */
	public List <Node> getModuleInfoTreeNodeList() throws BusinessException {
		List <Node> moduleInfoMenuNodeList = moduleInfoDao
				.getModuleInfoTreeNodeList();

		return moduleInfoMenuNodeList;
	}

	/**
	 * 功能描述:得到指定ID号功能模块所有包含的子模块列表
	 * 
	 * @return List<ModuleInfo> 子模块列表
	 */
	public List<TOrgPermission> getAllChildNodeById(Integer parentId,
			int firstResult, int maxResults) throws BusinessException {
		assert parentId != null;
		List<TOrgPermission> moduleInfoList = moduleInfoDao.getAllChildNodeById(
				parentId, firstResult, maxResults);
		return moduleInfoList;
	}

	/**
	 * 校验同一父模块中添加重复的子功能模块
	 * 
	 * @param moduleName
	 *            子模块名称
	 * @param parentId
	 *            父模块ID号
	 * @return
	 * @throws BusinessException
	 *             业务异常
	 */
	public Boolean checkModuleInfoIsRepeat(String moduleName, Integer parentId)
			throws BusinessException {
		assert moduleName != null;
		assert parentId != null;
		return moduleInfoDao
				.getModuleInfoCountByNameAndId(moduleName, parentId) > 0;
	}

	/**
	 * 保存或修改模块
	 * 
	 * @param obj：模块
	 * @return
	 * @throws BusinessException
	 *             业务异常
	 */
	public void saveOrUpdateModuleInfo(TOrgPermission moduleInfo)
			throws BusinessException {
		assert moduleInfo != null;
		Integer id = moduleInfo.getId();
		String moduleName = moduleInfo.getPermName();
		if (StringUtils.isBlank(moduleName)) {
			throw new BusinessException("模块名称不能为空");
		}
		if (id == null) {
			if (checkModuleInfoIsRepeat(moduleName, moduleInfo.getPid())) {
				throw new BusinessException("同一父模块中子功能模块重复");
			}
			baseDao.save(moduleInfo);
			return;
		}

		TOrgPermission tmpModuleInfo = getModuleInfoByPK(id);
		if (!moduleName.equals(tmpModuleInfo.getPermName())
				&& checkModuleInfoIsRepeat(moduleName, moduleInfo.getPid())) {
			throw new BusinessException("同一父模块中子功能模块重复");
		}
		tmpModuleInfo.setPermName(moduleName);
		tmpModuleInfo.setPermUrl(moduleInfo.getPermUrl());
		tmpModuleInfo.setPid(moduleInfo.getPid());
		tmpModuleInfo.setRemark(moduleInfo.getRemark());
		baseDao.update(tmpModuleInfo);
	}

	/**
	 * 根据主键查询记录的详细信息
	 * 
	 * @param id:
	 *            ModuleInfo主键
	 * @return ModuleInfo: ModuleInfo对象
	 */
	public TOrgPermission getModuleInfoByPK(int id) {
		return (TOrgPermission) baseDao.get(TOrgPermission.class, id);
	}

	/**
	 * 删除所选择的模块
	 * 
	 */
	public void deleteModuleInfo(List<Integer> idList) throws BusinessException {
		assert idList != null && idList.size() > 0;
		moduleInfoDao.deleteModuleInfo(idList);
	}

	/**
	 * 功能描述:得到已分配或未分配给指定角色的模块管理树型目录结点列表
	 * 
	 * @return List<Node> 已分配或未分配给指定角色的模块管理树型目录结点列表
	 */
	public List<Node> getModuleInfoTreeNodeByRole(Integer roleId) throws BusinessException {
		assert roleId != null;
		return moduleInfoDao.getModuleInfoTreeNodeListByRole(roleId);
	}

}
