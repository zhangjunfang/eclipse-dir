package cn.com.newcapec.citycard.system.service;

import java.util.List;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.citycard.common.po.TOrgPermission;

/**
 * <p>
 * 功能描述:模块管理服务接口定义
 *   
 * Author : Wangjian 
 * Date   : 2008-06-03
 * Time   : 10:11:15
 * Version: 1.0
 * </p>
 */
public interface IModuleInfoService {

	/**
	 * 查询当前满足查询条件的记录总数
	 * 
	 * @param parentId:
	 *            Integer对象
	 * @return 根据给定的parentId返回记录总数
	 */
	public Integer getModuleInfoCountByQuery(Integer parentId)
			throws BusinessException;

	/**
	 * 功能描述:得到模块管理树型目录结点列表
	 * 
	 * @return List<Node> 模块管理树型目录结点列表
	 */
	public List<Node> getModuleInfoTreeNodeList() throws BusinessException;

	/**
	 * 功能描述:得到已分配或未分配给指定角色的模块管理树型目录结点列表
	 * 
	 * @return List<Node> 已分配或未分配给指定角色的模块管理树型目录结点列表
	 */
	public List<Node> getModuleInfoTreeNodeByRole(Integer roleId) throws BusinessException;

	/**
	 * 功能描述:得到指定ID号功能模块所有包含的子模块列表
	 * 
	 * @return List<ModuleInfo> 子模块列表
	 */
	public List<TOrgPermission> getAllChildNodeById(Integer parentId,
			int firstResult, int maxResults) throws BusinessException;

	/**
	 * 保存或修改模块
	 * 
	 * @param obj：模块
	 * @return
	 * @throws BusinessException
	 *             业务异常
	 */
	public void saveOrUpdateModuleInfo(TOrgPermission moduleInfo)
			throws BusinessException;

	/**
	 * 根据主键查询记录的详细信息
	 * 
	 * @param id:
	 *            ModuleInfo主键
	 * @return ModuleInfo: ModuleInfo对象
	 */
	public TOrgPermission getModuleInfoByPK(int id);

	/**
	 * 删除所选择的模块
	 * 
	 */
	public void deleteModuleInfo(List<Integer> id) throws BusinessException;

}
