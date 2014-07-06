package cn.com.newcapec.citycard.system.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.com.newcapec.common.domain.NameValue;
import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.page.utils.Page;
import cn.com.newcapec.common.page.utils.PageHelper;
import cn.com.newcapec.common.util.Constants;
import cn.com.newcapec.citycard.common.action.CommonAction;
import cn.com.newcapec.citycard.common.po.TOrgDept;
import cn.com.newcapec.citycard.common.po.TOrgUser;
import cn.com.newcapec.citycard.system.service.IRoleInfoService;
import cn.com.newcapec.citycard.system.service.IUserOrganService;

/**
 * <p>
 * 功能描述:用户组织机构Action
 *   
 * Author : Wangjian 
 * Date   : 2008-06-05
 * Time   : 11:15:15
 * Version: 1.0
 * </p>
 */
public class UserOrganAction extends CommonAction {
	private static final long serialVersionUID = -8894181403301296225L;

	private IUserOrganService userOrganService;// 用户组织机构管理服务接口

	private IRoleInfoService roleInfoService; //角色管理服务接口

	private List<TOrgDept> depList; // 部门列表
	
	private List<TOrgUser> eomsUserInfoList; // 用户信息列表
	
	private TOrgUser eomsUserInfo;  //用户信息

	private TOrgDept eomsOrganInfo; // 组织机构对象

	private String pid; //父部门id

	private List<NameValue> userHaveRoleInfoList; //指定用户已经分配的系统角色名值对列表
	
	private List<NameValue> userNoRoleInfoList; //指定用户尚未分配的系统角色名值对列表
	

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public List<TOrgDept> getDepList() {
		return depList;
	}

	public void setDepList(List<TOrgDept> depList) {
		this.depList = depList;
	}

	/**
	 * @return the userOrganService
	 */
	public IUserOrganService getUserOrganService() {
		return userOrganService;
	}

	/**
	 * @param userOrganService
	 *            the userOrganService to set
	 */
	public void setUserOrganService(IUserOrganService userOrganService) {
		this.userOrganService = userOrganService;
	}

	/**
	 * @return the roleInfoService
	 */
	public IRoleInfoService getRoleInfoService() {
		return roleInfoService;
	}

	/**
	 * @param roleInfoService the roleInfoService to set
	 */
	public void setRoleInfoService(IRoleInfoService roleInfoService) {
		this.roleInfoService = roleInfoService;
	}

	/**
	 * @return the eomsUserInfoList
	 */
	public List<TOrgUser> getTOrgUserList() {
		return eomsUserInfoList;
	}

	/**
	 * @param eomsUserInfoList
	 *            the eomsUserInfoList to set
	 */
	public void setTOrgUserList(List<TOrgUser> eomsUserInfoList) {
		this.eomsUserInfoList = eomsUserInfoList;
	}

	/**
	 * @return the eomsOrganInfo
	 */
	public TOrgDept getEomsOrganInfo() {
		return eomsOrganInfo;
	}
	/**
	 * @param eomsOrganInfo the eomsOrganInfo to set
	 */
	public void setEomsOrganInfo(TOrgDept eomsOrganInfo) {
		this.eomsOrganInfo = eomsOrganInfo;
	}

	/**
	 * @return the userHaveRoleInfoList
	 */
	public List<NameValue> getUserHaveRoleInfoList() {
		return userHaveRoleInfoList;
	}

	/**
	 * @param userHaveRoleInfoList the userHaveRoleInfoList to set
	 */
	public void setUserHaveRoleInfoList(List<NameValue> userHaveRoleInfoList) {
		this.userHaveRoleInfoList = userHaveRoleInfoList;
	}

	/**
	 * @return the userNoRoleInfoList
	 */
	public List<NameValue> getUserNoRoleInfoList() {
		return userNoRoleInfoList;
	}

	/**
	 * @param userNoRoleInfoList the userNoRoleInfoList to set
	 */
	public void setUserNoRoleInfoList(List<NameValue> userNoRoleInfoList) {
		this.userNoRoleInfoList = userNoRoleInfoList;
	}
	
	/**
	 * @return the eomsUserInfo
	 */
	public TOrgUser getTOrgUser() {
		return eomsUserInfo;
	}

	/**
	 * @param eomsUserInfo the eomsUserInfo to set
	 */
	public void setTOrgUser(TOrgUser eomsUserInfo) {
		this.eomsUserInfo = eomsUserInfo;
	}
	
	
	private String leftFrame;// 左边导航菜单

	public String getLeftFrame() {
		return leftFrame;
	}

	private String rightFrame;// 右边页面

	public String getRightFrame() {
		return rightFrame;
	}

	/* 用户组织机构主框架 */
	public String listFrame() throws Exception {
		leftFrame = "/system/userOrganInfo_listTree.action";
		rightFrame = "/system/jsp/blank.jsp";
		return "listFrame_success";
	}

	private List<Node> nodeList;// 树型菜单结点列表

	public List<Node> getNodeList() {
		return nodeList;
	}

	/* 组织机构管理树 */
	public String listTree() throws Exception {
		try {
			nodeList = userOrganService.getEomsOrganInfoTreeNodeList();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "listTree_success";
	}

	/* 根据组织机构的ID号获取其包含用户信息列表 */
	public String listAllUserByOrgid() throws Exception {
		try {
			// 分页总数
			int total = userOrganService
					.getTOrgUserCountByQuery(eomsOrganInfo.getId());
			Page page = PageHelper.getPage(ServletActionContext.getRequest(),
					total, Constants.DEFAULT_PAGE_NUM);

			eomsUserInfoList = userOrganService.getAllUserByOrganId(
					eomsOrganInfo.getId(), page.getFirstResult() - 1, page
							.getPageListNum());
			rightFrame = "/system/jsp/organUserList.jsp";
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "listAllUser_success";
	}
	
	/* 根据组织机构的FID号获取其包含子部门列表 */
	public String listAllDeptByFather() throws Exception {
		Object obj=null;
		try {
			obj=getObjByPk(TOrgDept.class, eomsOrganInfo.getPid());
			if(obj!=null){
				eomsOrganInfo=(TOrgDept)obj;
			}
			int total = userOrganService.getDepCountByFid(eomsOrganInfo.getId());// 分页总数
			Page page = PageHelper.getPage(ServletActionContext.getRequest(), total, Constants.DEFAULT_PAGE_NUM);
			depList = userOrganService.getDepListByFid(eomsOrganInfo.getId(), page.getFirstResult()-1, page.getPageListNum());
			rightFrame = "/system/jsp/deptList.jsp";
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "listDept_success";
	}

	/* 给指定用户预分配系统操作角色 */
	public String addRolePre() throws Exception {
		try {
			eomsUserInfo = userOrganService.getTOrgUserByPk(id.get(0));
			userHaveRoleInfoList = roleInfoService.getUserHaveRoleInfoList(id.get(0));
			userNoRoleInfoList = roleInfoService.getUserNoRoleInfoList(id.get(0));
			} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "userAddRole_pre";
	}


	/* 编辑前查询用户 */
	public String editUserPre() throws Exception {
		try {
			if(act.equals("update")){
				eomsUserInfo=userOrganService.getTOrgUserByPk(id.get(0));
			}
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
			prompt = e.getMessage();// 页面显示消息
	    	return listAllUserByOrgid();
		}
		return "editUser_pre";
	}
	
	/* 保存用户 */
	public String saveUser() throws Exception {
		//添加日志，动作/内容/模块/用户
		if(act.equals("add")){
			logInfo.setAction((String)logAction.getDatas().get("ADD"));
		}else{
			logInfo.setAction((String)logAction.getDatas().get("UPDATE"));
		}
		logInfo.setLogContent(logInfo.getAction()+"：“"+ eomsUserInfo.getUserName()+"”用户。");
		logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN_ORG")+"_用户管理");
    	try {
    		userOrganService.saveOrUpdateUser(eomsUserInfo);
    		logInfoService.saveTLog(logInfo);
    	} catch (Exception e) {
    		if (log.isErrorEnabled()) {
    			log.error(e.getMessage(), e.getCause());
    		}
    		prompt = e.getMessage();// 页面显示消息
    		return "saveUser_failure";
    	}
    	return "saveUser_success";
	}
	
	/* 批量删除用户 */
	public String delUser() throws Exception {
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("DELETE"));
		logInfo.setLogContent(logInfo.getAction()+"："+id.size()+"条用户信息。");
		logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN_ORG")+"_用户管理");
		try {
			super.delRecordsByPK(TOrgUser.class);
			logInfoService.saveTLog(logInfo);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "saveUser_success";
	}
	
	/* 编辑前查询部门 */
	public String editDeptPre() throws Exception {
		try {
			if(act.equals("update")){
				eomsOrganInfo=(TOrgDept)getObjByPk(TOrgDept.class, id.get(0));
			}
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
			prompt = e.getMessage();// 页面显示消息
	    	return listAllDeptByFather();
		}
		return "editDept_pre";
	}
	
	/* 保存用户 */
	public String saveDept() throws Exception {
		//添加日志，动作/内容/模块/用户
		if(act.equals("add")){
			logInfo.setAction((String)logAction.getDatas().get("ADD"));
		}else{
			logInfo.setAction((String)logAction.getDatas().get("UPDATE"));
		}
		logInfo.setLogContent(logInfo.getAction()+"：“"+ eomsOrganInfo.getDeptName()+"”部门。");
		logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN_ORG")+"_部门管理");
    	try {
    		userOrganService.saveOrUpdateDept(eomsOrganInfo);
    		logInfoService.saveTLog(logInfo);
    		eomsOrganInfo.setPid(Integer.parseInt(pid));
    	} catch (Exception e) {
    		if (log.isErrorEnabled()) {
    			log.error(e.getMessage(), e.getCause());
    		}
    		prompt = e.getMessage();// 页面显示消息
    		return "saveDept_failure";
    	}
    	return "saveDept_success";
	}

	/* 批量删除部门 */
	public String delDept() throws Exception {
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("DELETE"));
		logInfo.setLogContent(logInfo.getAction()+"："+id.size()+"条部门（子部门及部门用户未计数）信息。");
		logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN_ORG")+"_部门管理");
    	List<List<Integer>> rtnList=null;
    	try {
    		rtnList=userOrganService.delDeptAssociation(id);
    		//删除用户
    		super.setId(rtnList.get(1));
			super.delRecordsByPK(TOrgUser.class);
			
			//删除部门
    		super.setId(rtnList.get(0));
			super.delRecordsByPK(TOrgDept.class);
			//保存日志
			logInfoService.saveTLog(logInfo);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
				log.error(e.getMessage(), e.getCause());
			}
		}
		
		rtnList=null;
		return "saveDept_success";
	}
}
