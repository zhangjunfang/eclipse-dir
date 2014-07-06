package cn.com.newcapec.citycard.system.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;

import cn.com.newcapec.common.dao.impl.BaseDao;
import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.citycard.common.po.TOrgPermission;
import cn.com.newcapec.citycard.system.dao.IModuleInfoDao;

/**
 * <pre>
 * 功能描述:模块管理Dao实现类
 *   
 * Author : Wangjian 
 * Date   : 2008-06-03
 * Time   : 10:25:15
 * Version: 1.0
 * </pre>
 */

public class ModuleInfoDao extends BaseDao implements IModuleInfoDao {

	/**
	 * 查询当前满足查询条件的记录总数
	 * 
	 * @param parentId:
	 *            Integer对象
	 * @return 根据给定的parentId返回记录总数
	 */
	public Integer getModuleInfoCountByQuery(Integer parentId) {
		return getCountByCriteria(DetachedCriteria.forClass(TOrgPermission.class)
				.add(Restrictions.eq(TOrgPermission.PROP_PID,parentId)));
	}

	/**
	 * 功能描述:得到模块管理树型目录结点列表
	 * 
	 * @return List <Node> 模块管理树型目录结点列表
	 */
	@SuppressWarnings("unchecked")
	public List<Node> getModuleInfoTreeNodeList() {
		String sql = "select id, perm_name, perm_url, pid, remark from t_org_permission start with pid=0 connect by prior id=pid order siblings by id asc";
		List moduleInfoList = findBySQL(sql);
		List<Node> nodeList = new ArrayList();
		Iterator iterator = moduleInfoList.iterator();
		while (iterator.hasNext()) {
			Object[] m = (Object[]) iterator.next();
			Node node = new Node();
			String name = (String) m[1];
			node.setName(name);
			node.setId(m[0].toString());
			node.setPid(null == m[3] ? null : m[3].toString());
			if(StringUtils.isBlank(ObjectUtils.toString(m[2]))){
				node.setIsFolder(true);
				node
						.setUrl("/system/moduleInfo_listAllChildNodeByIdNoFresh.action?parentId="
								+ Integer.parseInt(m[0].toString()));
			} else {
				node.setIsFolder(false);
				node
						.setUrl("/system/moduleInfo_viewModuleById.action?moduleInfo.id="
								+ Integer.parseInt(m[0].toString()));
			}

			nodeList.add(node);
		}
		return nodeList;
	}

	/**
	 * 功能描述:得到指定角色的模块管理树型目录结点列表
	 * 
	 * @return List<Node> 指定角色的模块管理树型目录结点列表
	 */
	@SuppressWarnings("unchecked")
	public List<Node> getModuleInfoTreeNodeListByRole(Integer roleId) {
		/** 得到指定的角色所拥有的功能模块列表 */
		
		String sql = "select id, perm_name, perm_url, pid, remark from t_org_permission where id in (select fk_permission FROM t_org_map_role_permission where fk_role="+roleId+") start with pid=0 connect by prior id=pid order siblings by id asc";
		List moduleInfoList = findBySQL(sql);
		List<Node> roleHaveNodeList = new ArrayList();
		List<Node> allNodeList = new ArrayList();
		Iterator iterator = moduleInfoList.iterator();
		while (iterator.hasNext()) {
			Object[] m = (Object[]) iterator.next();
			Node node = new Node();
			String name = (String) m[1];
			node.setName(name);
			node.setId(m[0].toString());
			node.setPid(null == m[3] ? null : m[3].toString());

			roleHaveNodeList.add(node);
		}
		
		/** 得到系统中所有模块功能列表 */
		allNodeList = getModuleInfoTreeNodeList();
		
		/** FOR循环进行判断,在所有模块功能列表中把指定用户拥有的功能模块置标记,用于前台显示时默认处于选中状态 */
		for( Node node : roleHaveNodeList){
			int i = allNodeList.indexOf(node);
			if( i != -1 ){
				allNodeList.get(i).setIsChecked(true);
			}
		}
		return allNodeList;

	}

	/**
	 * 功能描述:得到指定ID号功能模块所有包含的子模块列表
	 * 
	 * @return List<ModuleInfo> 子模块列表
	 */
	@SuppressWarnings("unchecked")
	public List<TOrgPermission> getAllChildNodeById(Integer parentId,
			int firstResult, int maxResults) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(TOrgPermission.class);
		detachedCriteria.add(Restrictions.eq(TOrgPermission.PROP_PID,
				parentId));
		detachedCriteria.addOrder(Order.asc(TOrgPermission.PROP_ID));
		List<TOrgPermission> moduleInfoList = this.getPaginationListByCriteria(
				detachedCriteria, firstResult, maxResults);
		return moduleInfoList;
	}

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
			Integer parentId) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(TOrgPermission.class);
		detachedCriteria.add(Restrictions.eq(TOrgPermission.PROP_PERM_NAME,
				moduleName));
		detachedCriteria.add(Restrictions.eq(TOrgPermission.PROP_PID,
				parentId));
		return this.getCountByCriteria(detachedCriteria);
	}

	/**
	 * 判断要删除的模块是否包含子模块，如有要先删除子模块
	 * 
	 * @return 根据给定的idList返回记录总数
	 */
	public Integer checkChildModuleCountByIdList(List<Integer> idList) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(
				TOrgPermission.class).add(
				Restrictions.in(TOrgPermission.PROP_PID, idList));
		return getCountByCriteria(detachedCriteria);
	}

	/**
	 * 删除指定的模块记录
	 * 
	 * @param idList
	 *            模块ID列表
	 */
	@SuppressWarnings("unchecked")
	public void deleteModuleInfo(List idList) {

		if (checkChildModuleCountByIdList(idList) > 0) {
			bulkUpdate(deleteChildModuleByIdList, new String[] { "idList" },
					new Object[] { idList });
		}
		bulkUpdate(deleteModuleByIdList, new String[] { "idList" },
				new Object[] { idList });
	}

	private static final String deleteChildModuleByIdList = "delete TOrgPermission where pid in (:idList)";

	private static final String deleteModuleByIdList = "delete TOrgPermission where id in (:idList)";

}
