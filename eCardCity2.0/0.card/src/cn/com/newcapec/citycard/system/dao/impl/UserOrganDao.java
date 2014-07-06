package cn.com.newcapec.citycard.system.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.com.newcapec.common.dao.impl.BaseDao;
import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.citycard.common.po.TOrgDept;
import cn.com.newcapec.citycard.common.po.TOrgUser;
import cn.com.newcapec.citycard.system.dao.IUserOrganDao;

/**
 * <pre>
 * 功能描述:用户组织结构Dao定义
 *   
 * Author : Wangjian 
 * Date   : 2008-06-05
 * Time   : 08:25:15
 * Version: 1.0
 * </pre>
 */

public class UserOrganDao extends BaseDao implements IUserOrganDao {

	/**
	 * 查询当前满足查询条件的记录列表
	 * 如果firstResult==-1 && maxResults==-1，则取所有符合条件的记录
	 * @param fId 		父部门ID
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * @return List 	根据给定的fId返回当前组织机构中部门对象
	 */
	public List<TOrgDept> getDepListByFid(Integer fId, int firstResult, int maxResults) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TOrgDept.class);
		detachedCriteria.add(Restrictions.eq(TOrgDept.PROP_PID, fId));
//		detachedCriteria.addOrder(Order.desc(TOrgDept.PROP_ID));
		List<TOrgDept> depList=null;
		if(firstResult==-1 && maxResults==-1){
			depList = super.findByCriteria(detachedCriteria);
		}else{
			depList = super.getPaginationListByCriteria(detachedCriteria, firstResult, maxResults);
		}
		return depList;
	}

	/**
	 * 功能描述:得到组织机构树型目录结点列表
	 * 
	 * @return List<Node> 组织机构树型目录结点列表
	 */
	@SuppressWarnings("unchecked")
	public List<Node> getEomsOrganInfoTreeNodeList() {
		String sql = "select id, dept_name, code, pid, remark from t_org_dept start with pid=0 connect by prior id=pid order siblings by id asc";
		List eomsOrganInfoList = findBySQL(sql);
		List<Node> nodeList = new ArrayList();
		Iterator iterator = eomsOrganInfoList.iterator();
		Node node=null;
		while (iterator.hasNext()) {
			Object[] m = (Object[]) iterator.next();
			node = new Node();
			node.setName((String) m[1]);
			node.setId(m[0].toString());
			node.setPid(null == m[3] ? null : m[3].toString());
			if (isHaveChildOrgan(Integer.parseInt(m[0].toString()))) {
				node.setIsFolder(true);
				node
				.setUrl("/system/userOrganInfo_listAllDeptByFather.action?eomsOrganInfo.pid="
						+ Integer.parseInt(m[0].toString()));
			} else {
				node.setIsFolder(false);
				node
						.setUrl("/system/userOrganInfo_listAllUserByOrgid.action?eomsOrganInfo.id="
								+ Integer.parseInt(m[0].toString()));
			}

			nodeList.add(node);
		}
		return nodeList;
	}

	/**
	 * 功能描述:得到指定orgID号组织机构所有包含的用户信息列表
	 * 如果firstResult==-1 && maxResults==-1，则取所有符合条件的记录
	 * @param fId 		父部门ID
	 * @param firstResult 从第几条开始
	 * @param maxResults 共取几条
	 * @return List<TOrgUser> 用户信息列表
	 */
	public List<TOrgUser> getAllUserByOrganId(Integer organId, int firstResult,
			int maxResults) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(TOrgUser.class);
		detachedCriteria.add(Restrictions.eq(TOrgUser.PROP_FK_DEP, organId));
		detachedCriteria.addOrder(Order.desc(TOrgUser.PROP_ID));
		List<TOrgUser> userList=null;
		if(firstResult==-1 && maxResults==-1){
			userList = super.findByCriteria(detachedCriteria);
		}else{
			userList = super.getPaginationListByCriteria(detachedCriteria, firstResult, maxResults);
		}
		return userList;
	}

	/**
	 * 功能描述:指定ID号的组织机构下是否有子机构
	 * 
	 * @param orgId
	 *            Integer 组织机构ID号
	 * @return Boolean 指定ID号的组织机构下是否有子机构
	 */
	public Boolean isHaveChildOrgan(Integer orgId) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(TOrgDept.class);
		detachedCriteria.add(Restrictions.eq(TOrgDept.PROP_PID, orgId));
		return getCountByCriteria(detachedCriteria) > 0;
	}

	/**
	 * 功能描述:删除指定用户原来分配的角色信息
	 * @param userId 指定的用户ID号
	 */
	public void deleteUserHaveRoleByUserId(Integer userId) {
		bulkUpdate(deleteUserHaveRoleByUserId, new Object[] { userId });
	}

	public static final String deleteUserHaveRoleByUserId = "delete TOrgMapUserRole where fkUser=?";

	/**
	 * 查找指定的Object数量
	 * 
	 * @param attribName	对象属性名字
	 * @param attribValue	对象属性值
	 * @return integer		对象数量
	 */
	public Integer getObjCountByAttrib(Class cls,String attribName, Object attribValue){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(cls).add(Restrictions.eq(attribName, attribValue));
		return getCountByCriteria(detachedCriteria);
	}

}
