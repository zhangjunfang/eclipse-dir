package cn.com.newcapec.citycard.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.common.service.impl.BaseService;
import cn.com.newcapec.common.util.StringHelper;
import cn.com.newcapec.citycard.common.po.TOrgDept;
import cn.com.newcapec.citycard.common.po.TOrgMapUserRole;
import cn.com.newcapec.citycard.common.po.TOrgUser;
import cn.com.newcapec.citycard.system.dao.IUserOrganDao;
import cn.com.newcapec.citycard.system.service.IUserOrganService;

/**
 * <pre>
 * 功能描述:用户组织机构服务接口实现
 *   
 * Author : Wangjian 
 * Date   : 2008-06-04
 * Time   : 11:06:15
 * Version: 1.0
 * </pre>
 */
public class UserOrganService extends BaseService implements IUserOrganService {
	private IUserOrganDao userOrganDao;// 用户组织机构管理DAO接口

	public IUserOrganDao getUserOrganDao() {
		return userOrganDao;
	}

	public void setUserOrganDao(IUserOrganDao userOrganDao) {
		this.userOrganDao = userOrganDao;
	}
	
	/**
	 * 查询当前满足查询条件的部门总数
	 * 
	 * @param fId:	父部门ID
	 * @return 根据给定的父部门返回记录总数
	 */
	public Integer getDepCountByFid(Integer fId)
			throws BusinessException {
		assert fId != null;
		return userOrganDao.getObjCountByAttrib(TOrgDept.class, TOrgDept.PROP_PID, fId);
	}
	
	/**
	 * 查询当前满足查询条件的部门列表
	 * 
	 * @param fId:	父部门ID
	 * @return 根据给定的父部门返回部门列表
	 */
	public List<TOrgDept> getDepListByFid(Integer fId,int firstResult, int maxResults)
			throws BusinessException {
		assert fId != null;
		return userOrganDao.getDepListByFid(fId, firstResult, maxResults);
	}
	/**
	 * 查询当前满足查询条件的记录总数
	 * 
	 * @param orgId:
	 *            Integer对象
	 * @return 根据给定的orgId返回记录总数
	 */
	public Integer getTOrgUserCountByQuery(Integer orgId)
			throws BusinessException {
		assert orgId != null;
		return userOrganDao.getObjCountByAttrib(TOrgUser.class, TOrgUser.PROP_FK_DEP, orgId);
	}

	/**
	 * 功能描述:得到组织机构树型目录结点列表
	 * 
	 * @return List<Node> 组织机构树型目录结点列表
	 */
	public List<Node> getEomsOrganInfoTreeNodeList() throws BusinessException {
		List<Node> nodeList = userOrganDao.getEomsOrganInfoTreeNodeList();
		return nodeList;
	}

	/**
	 * 功能描述:得到指定orgID号组织机构所有包含的用户信息列表
	 * 
	 * @return List<TOrgUser> 用户信息列表
	 */
	public List<TOrgUser> getAllUserByOrganId(Integer organId,
			int firstResult, int maxResults) {
		assert organId != null;
		List<TOrgUser> eomsUserInfoList = userOrganDao.getAllUserByOrganId(
				organId, firstResult, maxResults);
		return eomsUserInfoList;
	}
	
	
	/**
	 * 功能描述:给指定用户分配角色
	 * @param userId: 指定的用户ID
	 *        roleIdList: 角色IDList
	 * 
	 */
	public void saveRoleToUser(Integer userId,List <Integer> roleIdList) throws BusinessException{
		assert userId != null;
		userOrganDao.deleteUserHaveRoleByUserId(userId);
		if(roleIdList==null||roleIdList.size()==0)
		{
			return;
		}
		List <TOrgMapUserRole> userRoleInfoList=new ArrayList<TOrgMapUserRole>();
		for(Integer roleId : roleIdList)
		{
			TOrgMapUserRole userRoleInfo = new TOrgMapUserRole();
			userRoleInfo.setFkUser(userId);
			userRoleInfo.setFkRole(roleId);
			userRoleInfoList.add(userRoleInfo);
		}
		baseDao.saveOrUpdateAll(userRoleInfoList);
	}
	/**
	 * 功能描述:给指定用户分配角色
	 * @param userId 用户ID
	 * 
	 */
	public TOrgUser getTOrgUserByPk(Integer userId) throws BusinessException{
		assert userId != null;
		return (TOrgUser)baseDao.get(TOrgUser.class, userId);
	}
	/**
	 * 校验添加重复的用户
	 * 
	 * @param  name		用户名
	 * @return Integer 	查询到的用户数目
	 * @throws BusinessException 业务异常
	 */
	public Integer checkUserIsRepeat(String name) throws BusinessException {
		return userOrganDao.getObjCountByAttrib(TOrgUser.class, TOrgUser.PROP_USER_NAME, name);
	}
	/**
	 * 校验添加重复的部门
	 * 
	 * @param  name		部门名
	 * @return Integer 	查询到的部门数目
	 * @throws BusinessException 业务异常
	 */
	public Integer checkDeptIsRepeat(String name) throws BusinessException {
		return userOrganDao.getObjCountByAttrib(TOrgDept.class, TOrgDept.PROP_DEPT_NAME, name);
	}
	/**
	 * 保存或修改用户，修改用户时不重复加密
	 * 
	 * @param	obj					用户
	 * @return
	 * @throws Exception 
	 */
	public void saveOrUpdateUser(TOrgUser obj)throws Exception{
		assert obj != null;
		String userName = StringUtils.trimToEmpty(obj.getUserName());
		if ((checkUserIsRepeat(userName)>0 && obj.getId()==null) || (checkUserIsRepeat(userName)>1 && obj.getId()!=null)) {
			throw new BusinessException("“"+userName+"”用户已存在！");
		}
		
		if(obj.getId()==null){
			obj.setPassword(StringHelper.convertToMd5(obj.getPassword()));
			baseDao.save(obj);
			return;
		}
		
		if(!getTOrgUserByPk(obj.getId()).getPassword().equals(obj.getPassword())){
			obj.setPassword(StringHelper.convertToMd5(obj.getPassword()));
		}
		baseDao.merge(obj);
	}
	
	/**
	 * 保存或修改部门
	 * 
	 * @param	obj					用户
	 * @return
	 * @throws	BusinessException 	业务异常
	 */
	public void saveOrUpdateDept(TOrgDept obj)throws BusinessException{
		assert obj != null;
		String deptName = StringUtils.trimToEmpty(obj.getDeptName());
		if ((checkDeptIsRepeat(deptName)>0 && obj.getId()==null) || (checkDeptIsRepeat(deptName)>1 && obj.getId()!=null)) {
			throw new BusinessException("“"+deptName+"”部门已存在！");
		}
		
		if(obj.getId()==null){
			baseDao.save(obj);
		}else{
			baseDao.merge(obj);
		}
	}
	
	/**
	 * 删除部门及该部门下属的用户（包括子部门及子部门用户）
	 * 组织为部门、用户两个列表进行删除
	 * 
	 * @param	list				部门列表
	 * @return	List<List<Integer>>	部门列表、用户列表
	 * @throws	BusinessException 	业务异常
	 */
	public List<List<Integer>> delDeptAssociation(List<Integer> list)throws BusinessException{
		List<Integer> deptList=new ArrayList<Integer>(list);
		List<Integer> userList=new ArrayList<Integer>();
		List<Integer> tmpList=null;

		//递归获取子部门
		while((tmpList=getAllSubDep(list)).size()>0){
			deptList.addAll(tmpList);
			list=tmpList; 
		}

		//获取部门所有用户
		List<TOrgUser> currDeptUserList=null;
		for(int i=0;i<deptList.size();i++){
			currDeptUserList=userOrganDao.getAllUserByOrganId(deptList.get(i), -1, -1);
			for(int j=0;j<currDeptUserList.size();j++){
				userList.add(currDeptUserList.get(j).getId());
			}
		}
		
		//释放临时变量
		tmpList=null;
		currDeptUserList=null;
		
		//组装返回
		List<List<Integer>> rtnList=new ArrayList<List<Integer>>(2);
		rtnList.add(deptList);
		rtnList.add(userList);
		return rtnList;
	}

	/**
	 * 递归返回所有部门列表
	 * @param 	list		当前部门的ID列表
	 * @return 	deptList	当前部门及下属子部门的列表
	 */
	private List<Integer> getAllSubDep(List<Integer> list) {
		List<Integer> subList=new ArrayList<Integer>();
		
		//获取子部门
		List<TOrgDept> subDeptList=null;
		for(int i=0;i<list.size();i++){
			subDeptList=userOrganDao.getDepListByFid(list.get(i), -1, -1);
			for(int j=0;j<subDeptList.size();j++){
				subList.add(subDeptList.get(j).getId());
			}
		}
		subDeptList=null;
		return subList;
	}

}
