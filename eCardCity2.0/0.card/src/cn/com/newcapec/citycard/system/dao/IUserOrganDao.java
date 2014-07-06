package cn.com.newcapec.citycard.system.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.citycard.common.po.TOrgDept;
import cn.com.newcapec.citycard.common.po.TOrgUser;

/**
 * <pre>
 * 功能描述:用户组织结构Dao接口定义
 *   
 * Author : Wangjian 
 * Date   : 2008-06-05
 * Time   : 08:25:15
 * Version: 1.0
 * </pre>
 */

public interface IUserOrganDao {
	/**
	 * 查询当前满足查询条件的记录列表
	 * 如果firstResult==-1 && maxResults==-1，则取所有符合条件的记录
	 * @param fId 		父部门ID
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * @return List 	根据给定的fId返回当前组织机构中部门对象
	 */
	public List<TOrgDept> getDepListByFid(Integer fId, int firstResult, int maxResults);

		/**
	 * 查询当前满足查询条件的记录总数
	 * 
	 * @param orgId:
	 *            Integer对象
	 * @return 根据给定的orgId返回当前组织机构中用户记录总数
	 */
	//public Integer getTOrgUserCountByQuery(Integer orgId);

	/**
	 * 功能描述:得到组织机构树型目录结点列表
	 * 
	 * @return List<Node> 组织机构树型目录结点列表
	 */
	public List<Node> getEomsOrganInfoTreeNodeList();

	/**
	 * 功能描述:得到指定orgID号组织机构所有包含的用户信息列表
	 * 如果firstResult==-1 && maxResults==-1，则取所有符合条件的记录
	 * @param fId 		父部门ID
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * @return List<TOrgUser> 用户信息列表
	 */
	public List<TOrgUser> getAllUserByOrganId(Integer organId,
			int firstResult, int maxResults);
	
	/**
	 * 功能描述:删除指定用户原来分配的角色信息
	 * @param userId 指定的用户ID号
	 */
	public void deleteUserHaveRoleByUserId(Integer userId);

	/**
	 * 查找指定的Object数量
	 * 
	 * @param attribName	对象属性名字
	 * @param attribValue	对象属性值
	 * @return integer		对象数量
	 */
	public Integer getObjCountByAttrib(Class cls, String attribName, Object attribValue);
}
