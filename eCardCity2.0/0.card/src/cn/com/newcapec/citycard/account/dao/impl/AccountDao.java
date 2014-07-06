package cn.com.newcapec.citycard.account.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.com.newcapec.common.dao.impl.BaseDao;
import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.common.util.DateHelper;
import cn.com.newcapec.common.util.HttpServletHelper;
import com.opensymphony.xwork2.ActionContext;
import cn.com.newcapec.citycard.account.dao.IAccountDao;
import cn.com.newcapec.citycard.common.po.TOrgMapUserRole;
import cn.com.newcapec.citycard.common.po.TOrgUser;

/**
 * <pre>
 * 功能描述:帐号管理DAO接口实现
 *   
 * Author : Wangjian 
 * Date   : 2013-09-23
 * Time   : 13:16:14
 * Version: 1.0
 * </pre>
 */
public class AccountDao extends BaseDao implements IAccountDao {
	
	/**
	 * 功能描述:取得指定帐号的用户信息
	 * 
	 * @param username 帐号
	 * 
	 * @return TOrgUser 用户信息
	 * */
	public TOrgUser getUserByUsername(String username) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(TOrgUser.class);
		detachedCriteria.add(Restrictions.eq(TOrgUser.PROP_USER_NAME, username));
		TOrgUser euser = (TOrgUser) findObjectByCriteria(detachedCriteria);
		return euser;
	}

	/**
	 * 根据用户ID得到他是否在系统中已分配角色信息
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	public Integer getRoleCountByUserId(Integer userId) {
		return getCountByCriteria(DetachedCriteria.forClass(TOrgMapUserRole.class)
				.add(Restrictions.eq(TOrgMapUserRole.PROP_FK_USER, userId)));
	}
	
	/**
	 * 根据用户ID得到所在部门(包括父级节点)的状态
	 * 追溯到最顶级部门的状态，如果某一部门的状态为禁止登录
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	public Boolean getDepValid(Integer userId) {
		List<Object[]> depList=getFDep(userId);
		int expDate=0,today=Integer.parseInt(DateHelper.formatDate(new Date(), DateHelper.yyyyMMdd));
		for(Object[] m:depList){
			if((String.valueOf(m[1]).equals("0"))){//无效
				return false;
			}
			try{
				expDate=Integer.parseInt(DateHelper.formatDate((Date)m[2], DateHelper.yyyyMMdd));
			}catch(Exception e){
				e.printStackTrace();
			}
			if(today>expDate){
				return false;
			}
		}
		
		return true;
	}
    /**
	 * 根据用户ID得到所在部门(包括父级节点)的IP登录信息
     * @param userId
     * @return
     * @throws BusinessException
     */
    public Boolean getIPAuth(Integer userId){
		List<Object[]> depList=getFDep(userId);
		String currIP=HttpServletHelper.getIP(ActionContext.getContext(), true);
		boolean ipValid;
		for(Object[] m:depList){
			if(!String.valueOf(m[3]).equalsIgnoreCase("null") && StringUtils.isNotBlank(String.valueOf(m[3]))){//限制登录IP
				ipValid=false;
				String[] ipAuth=((String)m[3]).split(",");
				for(String ip:ipAuth){
					if(ip.equals(currIP)){
						ipValid=true;
						break;
					}
				}
				if(!ipValid){
					return false;
				}
			}
		}
		
		return true;
    }
	/**
	 * 功能描述:得到用户可操作的模块
	 * 
	 * @param userId 用户ID号
	 * 
	 * @return NodeList 用户可操作的功能菜单结点列表
	 * */
	@SuppressWarnings("unchecked")
	public List<Node> getNodeListByUserId(Integer userId) {
		String sql = "select id, perm_name, perm_url, pid, remark from t_org_permission where id in ( select rmInfo.fk_permission from t_org_map_role_permission rmInfo,t_org_map_user_role urInfo where rmInfo.fk_role=urInfo.fk_role and urInfo.fk_user="
				+ userId
				+ ") start with pid=0 connect by prior id=pid order siblings by id asc";
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
			} else {
				node.setIsFolder(false);
				node.setUrl(m[2].toString());
			}

			nodeList.add(node);
		}
		return nodeList;
	}
	
	/**
	 * 根据用户ID得到所在部门(id，状态，有效期，登录ip)
	 * @param userId
	 * @return List
	 */
	private List<Object[]> getFDep(Integer userId) {
		String sql = "select id, valid, expiry_date, login_ip from t_org_dept where id=(SELECT fk_dep FROM t_org_user where id="
				+ userId
				+ ") start with pid=0 connect by prior id=pid order siblings by id asc";
		List<Object[]> depList = findBySQL(sql);
		return depList;
	}
}
