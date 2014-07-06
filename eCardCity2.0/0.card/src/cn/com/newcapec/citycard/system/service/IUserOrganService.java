package cn.com.newcapec.citycard.system.service;

import java.util.List;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.citycard.common.po.TOrgDept;
import cn.com.newcapec.citycard.common.po.TOrgUser;

/**
 * <pre>
 * 功能描述:用户组织机构服务接口定义
 *   
 * Author : Wangjian 
 * Date   : 2008-06-05
 * Time   : 11:00:15
 * Version: 1.0
 * </pre>
 */
public interface IUserOrganService {


	/**
	 * 校验添加重复的部门
	 * 
	 * @param  name		部门名
	 * @return Integer 	查询到的部门数目
	 * @throws BusinessException 业务异常
	 */
	public Integer checkDeptIsRepeat(String name) throws BusinessException;
	
	/**
	 * 查询当前满足查询条件的部门总数
	 * 
	 * @param fId:	父部门ID
	 * @return 根据给定的父部门返回记录总数
	 */
	public Integer getDepCountByFid(Integer fId) throws BusinessException;
	
	/**
	 * 查询当前满足查询条件的部门列表
	 * 
	 * @param fId:	父部门ID
	 * @return 根据给定的父部门返回部门列表
	 */
	public List<TOrgDept> getDepListByFid(Integer fId,int firstResult, int maxResults) throws BusinessException;
	
	/**
	 * 查询当前满足查询条件的记录总数
	 * 
	 * @param orgId:
	 *            Long对象
	 * @return 根据给定的orgId返回记录总数
	 */
	public Integer getTOrgUserCountByQuery(Integer orgId)
			throws BusinessException;

	/**
	 * 功能描述:得到组织机构树型目录结点列表
	 * 
	 * @return List<Node> 组织机构树型目录结点列表
	 */
	public List<Node> getEomsOrganInfoTreeNodeList() throws BusinessException;

	/**
	 * 功能描述:得到指定orgID号组织机构所有包含的用户信息列表
	 * 
	 * @return List<TOrgUser> 用户信息列表
	 */
	public List<TOrgUser> getAllUserByOrganId(Integer organId,
			int firstResult, int maxResults);
	
	
	/**
	 * 功能描述:给指定用户分配角色
	 * @param userId: 指定的用户ID
	 *        roleIdList: 角色IDList
	 * 
	 */
	public void saveRoleToUser(Integer userid,List <Integer> roleIdList) throws BusinessException;
	
	
	/**
	 * 功能描述:给指定用户分配角色
	 * @param userId 用户ID
	 * 
	 */
	public TOrgUser getTOrgUserByPk(Integer userId) throws BusinessException;
	
	/**
	 * 保存或修改用户
	 * 
	 * @param	obj					用户
	 * @return
	 * @throws	BusinessException 	业务异常
	 */
	public void saveOrUpdateUser(TOrgUser obj)throws Exception;
	
	/**
	 * 保存或修改部门
	 * 
	 * @param	obj					部门
	 * @return
	 * @throws	BusinessException 	业务异常
	 */
	public void saveOrUpdateDept(TOrgDept obj)throws BusinessException;
	
	/**
	 * 删除部门及该部门下属的用户（包括子部门及子部门用户）
	 * 
	 * @param	list				部门列表
	 * @return	List<List<Integer>>	部门列表、用户列表
	 * @throws	BusinessException 	业务异常
	 */
	public List<List<Integer>> delDeptAssociation(List<Integer> list)throws BusinessException;
	
}
