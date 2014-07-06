package cn.com.newcapec.citycard.system.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.com.newcapec.common.dao.impl.BaseDao;
import cn.com.newcapec.common.domain.NameValue;
import cn.com.newcapec.citycard.common.po.TOrgMapUserRole;
import cn.com.newcapec.citycard.common.po.TOrgRole;
import cn.com.newcapec.citycard.system.dao.IRoleInfoDao;

/**
 * <p>
 * 角色操作类用到的特殊DAO
 * 
 * @author: Wangjian
 * @version: 1.0 May 8, 2008 10:34:33 
 */
public class RoleInfoDao extends BaseDao implements IRoleInfoDao {

	/**
	 * 查询当前满足查询条件的记录总数
	 * 
	 * @param roleInfo:
	 *            RoleInfo对象
	 * @return 根据给定的roleInfo返回记录总数
	 */
	public Integer getRoleInfoCountByQuery(TOrgRole roleInfo) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(TOrgRole.class);
		if (null != roleInfo) {
			String roleName = roleInfo.getRoleName();
			detachedCriteria.add(Restrictions.like(TOrgRole.PROP_ROLE_NAME,
					roleName.trim(), MatchMode.ANYWHERE));
		}
//		detachedCriteria.addOrder(Order.asc(TOrgRole.PROP_ID));
		return getCountByCriteria(detachedCriteria);
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
	 * 
	 * @return List 角色类型列表
	 */
	@SuppressWarnings("unchecked")
	public List<TOrgRole> getRoleInfoListByQuery(TOrgRole roleInfo,
			int firstResult, int maxResults) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(TOrgRole.class);
		if (null != roleInfo) {
			String roleName = roleInfo.getRoleName();
			detachedCriteria.add(Restrictions.like(TOrgRole.PROP_ROLE_NAME,
					roleName.trim(), MatchMode.ANYWHERE));
		}
		detachedCriteria.addOrder(Order.asc(TOrgRole.PROP_ID));
		return this.getPaginationListByCriteria(detachedCriteria, firstResult,
				maxResults);
	}

	/**
	 * 功能描述:检索重复角色的记录数
	 * 
	 * @param RoleInfo
	 *            角色
	 * 
	 * @return Integer 重复角色的记录数
	 */
	public Integer getRoleInfoCountByName(String roleName) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(
				TOrgRole.class).add(
				Restrictions.eq(TOrgRole.PROP_ROLE_NAME, roleName));
		return getCountByCriteria(detachedCriteria);
	}

	/**
	 * 功能描述:得到所有的角色
	 * 
	 * 
	 * @return List 角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<TOrgRole> getRoleInfoList() {
		return loadAll(TOrgRole.class);
	}

	/**
	 * 获得所有可用角色名值对列表
	 * 
	 * @author Wangjian
	 * 
	 * @return list 角色名值对列表
	 */
	@SuppressWarnings("unchecked")
	public List getRoleInfoNameValueList() {
		return find(getRoleInfoNameValueList);
	}

	private static final String getRoleInfoNameValueList = "select new cn.com.newcapec.common.domain.NameValue(roleName,id) from TOrgRole order by id";

	/**
	 * 判断角色用户表中是否有相应角色的用户存在
	 * 
	 * @return 根据给定的idList返回记录总数
	 */
	public Integer checkUserRoleInfoCountByIdList(List<Integer> idList) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(
				TOrgMapUserRole.class).add(
				Restrictions.in(TOrgMapUserRole.PROP_FK_ROLE, idList));
		return getCountByCriteria(detachedCriteria);
	}

	/**
	 * 删除指定的角色记录
	 * 
	 * @param idList
	 *            角色名称ID列表
	 */
	@SuppressWarnings("unchecked")
	public void deleteRoleInfoByIdList(List idList) {

		if (checkUserRoleInfoCountByIdList(idList) > 0) {
			bulkUpdate(deleteUserRoleByIdList, new String[] { "idList" },
					new Object[] { idList });
		}
		bulkUpdate(deleteRoleByIdList, new String[] { "idList" },
				new Object[] { idList });
	}

	private static final String deleteUserRoleByIdList = "delete TOrgMapUserRole where fkRole in (:idList)";

	private static final String deleteRoleByIdList = "delete TOrgRole where id in (:idList)";

	/**
	 * 查找指定的用户已分配的角色列表
	 * @param userId  用户ID
	 * @return List 指定的用户已分配的角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<NameValue> getUserHaveRoleInfoListByUserId(Integer userId){
		return find(getUserHaveRoleInfoListByUserId,new Object[]{userId});
	}
	
	private static final String getUserHaveRoleInfoListByUserId = "select new cn.com.newcapec.common.domain.NameValue(roleName,id) from TOrgRole where " 
		                                                        +"  id in (select fkRole from TOrgMapUserRole where fkUser=?) order by id";

	/**
	 * 查找指定的用户未分配的角色列表
	 * @param userId  用户ID
	 * @return List 指定的用户未分配的角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<NameValue> getUserNoRoleInfoListByUserId(Integer userId){
		return find(getUserNoRoleInfoListByUserId,new Object[]{userId});
	}
	
	private static final String getUserNoRoleInfoListByUserId = "select new cn.com.newcapec.common.domain.NameValue(roleName,id) from TOrgRole where " 
        +"  id not in (select fkRole from TOrgMapUserRole where fkUser=?) order by id";

}
