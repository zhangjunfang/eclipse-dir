package cn.com.newcapec.citycard.system.dao;


import java.util.List;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.citycard.common.po.TOrgPermission;

/**
 * <p>
 * 功能描述:模块管理Dao接口定义
 *   
 * Author : Wangjian 
 * Date   : 2008-06-03
 * Time   : 10:25:15
 * Version: 1.0
 * </p>
 */

public interface IModuleInfoDao {

	/**
	 * 查询当前满足查询条件的记录总数
	 * 
	 * @param parentId:
	 *            Integer对象
	 * @return 根据给定的parentId返回记录总数
	 */
	public Integer getModuleInfoCountByQuery(Integer parentId);

	/**
	 * 功能描述:得到模块管理树型目录结点列表
	 * 
	 * @return List <Node> 模块管理树型目录结点列表
	 */
	public List <Node> getModuleInfoTreeNodeList();

	/**
	 * 功能描述:得到指定角色的模块管理树型目录结点列表
	 * 
	 * @return List<Node> 指定角色的模块管理树型目录结点列表
	 */
	public List <Node> getModuleInfoTreeNodeListByRole(Integer roleId);

	/**
	 * 功能描述:得到指定ID号功能模块所有包含的子模块列表
	 * 
	 * @return List<ModuleInfo> 子模块列表
	 */
	public List<TOrgPermission> getAllChildNodeById(Integer parentId,
			int firstResult, int maxResults);

	/**
	 * 校验同一父模块中添加重复的子功能模块
	 * 
	 * @param moduleName
	 *            子模块名称
	 * @param parentId
	 *            父模块ID号
	 * @return 重复的记录数
	 */
	public Integer getModuleInfoCountByNameAndId(String moduleName,
			Integer parentId);

	/**
	 * 删除所选择的模块
	 * 
	 */
	public void deleteModuleInfo(List<Integer> idList);

}
