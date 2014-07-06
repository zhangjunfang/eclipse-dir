package cn.com.newcapec.citycard.system.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.common.page.utils.Page;
import cn.com.newcapec.common.page.utils.PageHelper;
import cn.com.newcapec.common.util.Constants;
import cn.com.newcapec.citycard.common.action.CommonAction;
import cn.com.newcapec.citycard.common.po.TOrgRole;
import cn.com.newcapec.citycard.common.po.TOrgUser;
import cn.com.newcapec.citycard.system.service.IModuleInfoService;
import cn.com.newcapec.citycard.system.service.IRoleInfoService;

/**
 * <p>
 * 角色维护的action
 * 
 * @author: Wangjian
 * @version: 1.0 May 29, 2008 03:01:45 AM
 *           </p>
 */

public class RoleInfoAction extends CommonAction {
	private static final long serialVersionUID = 8970540543068982517L;
	private List<TOrgRole> roleInfoList; // 角色的列表
	private List <Node> nodeList; //功能菜单列表,用于对指定角色分配使用
	private IRoleInfoService roleInfoService; // 角色的service
	private IModuleInfoService moduleInfoService; //模块的service
	private TOrgRole roleInfo; // 角色的对象
	private String moduleIds; //前台传来的保存分配给指定角色功能菜单ID的字符串

	/**
	 * @return the RoleInfoService
	 */
	public IRoleInfoService getRoleInfoService() {
		return roleInfoService;
	}

	/**
	 * @param RoleInfoService
	 *            the RoleInfoService to set
	 */
	public void setRoleInfoService(IRoleInfoService roleInfoService) {
		this.roleInfoService = roleInfoService;
	}

	/**
	 * @return the RoleInfoList
	 */
	public List<TOrgRole> getRoleInfoList() {
		return roleInfoList;
	}

	/**
	 * @param RoleInfoList
	 *            the RoleInfoList to set
	 */
	public void setRoleInfoList(List<TOrgRole> roleInfoList) {
		this.roleInfoList = roleInfoList;
	}

	/**
	 * @return the RoleInfo
	 */
	public TOrgRole getRoleInfo() {
		return roleInfo;
	}

	/**
	 * @param RoleInfo
	 *            the RoleInfo to set
	 */
	public void setRoleInfo(TOrgRole roleInfo) {
		this.roleInfo = roleInfo;
	}

	

	/**
	 * @return the nodeList
	 */
	public List<Node> getNodeList() {
		return nodeList;
	}

	/**
	 * @param nodeList the nodeList to set
	 */
	public void setNodeList(List<Node> nodeList) {
		this.nodeList = nodeList;
	}

	/**
	 * @return the moduleInfoService
	 */
	public IModuleInfoService getModuleInfoService() {
		return moduleInfoService;
	}

	/**
	 * @param moduleInfoService the moduleInfoService to set
	 */
	public void setModuleInfoService(IModuleInfoService moduleInfoService) {
		this.moduleInfoService = moduleInfoService;
	}
	
	

	/**
	 * @return the moduleIds
	 */
	public String getModuleIds() {
		return moduleIds;
	}

	/**
	 * @param moduleIds the moduleIds to set
	 */
	public void setModuleIds(String moduleIds) {
		this.moduleIds = moduleIds;
	}

	/* 角色分页列表 */
	public String list() throws Exception {

		try {
			// 分页总数
			int total = roleInfoService.getRoleInfoCountByQuery(roleInfo);
			Page page = PageHelper.getPage(ServletActionContext.getRequest(),
					total, Constants.DEFAULT_PAGE_NUM);

			roleInfoList = roleInfoService.getRoleInfoListByQuery(roleInfo,
					page.getFirstResult() - 1, page.getPageListNum());
		} catch (Exception e) {
			e.printStackTrace();
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "list_success";
	}

	/* 角色预添加 */
	public String add() throws Exception {
		return "add_pre";
	}

	/* 角色添加保存 */
	public String addNext() throws Exception {
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("ADD"));
		logInfo.setLogContent(logInfo.getAction()+"：“"+ roleInfo.getRoleName().trim() +"”角色。");
		logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN_ORG")+"_角色管理");
    	try {
			roleInfo.setRoleName(roleInfo.getRoleName().trim());
			roleInfoService.saveOrUpdateRoleInfo(roleInfo);
			logInfoService.saveTLog(logInfo);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());// 角色重复异常
			}
			if (e instanceof BusinessException) {
				prompt = e.getMessage();// 页面显示消息
			} else {
				prompt = "出错了,请和管理员联系!";
			}
			return "add_failure";
		}
		return "add_success";
	}

	/* 角色预修改 */
	public String update() throws Exception {
		try {
			roleInfo = roleInfoService.getRoleInfoByPK(roleInfo.getId());
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "update_pre";
	}

	/* 角色修改 */
	public String updateNext() throws Exception {
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("UPDATE"));
		logInfo.setLogContent(logInfo.getAction()+"：“"+ roleInfo.getRoleName().trim() +"”角色。");
		logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN_ORG")+"_角色管理");
    	try {
			roleInfo.setRoleName(roleInfo.getRoleName().trim());
			roleInfoService.saveOrUpdateRoleInfo(roleInfo);
			logInfoService.saveTLog(logInfo);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
			if (e instanceof BusinessException) {
				prompt = e.getMessage();// 页面显示消息
			} else {
				prompt = "出错了,请和管理员联系!";
			}
			return roleInfo.getId() == null ? "add_failure" : "update_failure";
		}

		return "update_success";
	}

	/* 多条角色数据批量删除 */
	public String delete() throws Exception {
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("DELETE"));
		logInfo.setLogContent(logInfo.getAction()+"："+id.size()+"条角色记录。");
		logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN_ORG")+"_角色管理");
		try {
			roleInfoService.deleteRoleInfo(id);
			logInfoService.saveTLog(logInfo);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "delete_success";
	}

	/* 角色详情 */
	public String get() throws Exception {
		try {
			roleInfo = roleInfoService.getRoleInfoByPK(roleInfo.getId());
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "view_success";
	}

	/**
	 * 做针对角色分配权限的准备
	 */
	public String addModulePre() throws Exception {
		try {
			roleInfo = roleInfoService.getRoleInfoByPK(roleInfo.getId());
			nodeList = moduleInfoService.getModuleInfoTreeNodeByRole(roleInfo.getId());
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "addModule_pre";
	}

	/**
	 * 对角色分配权限
	 */
	public String addModule() throws Exception {
		try {
			roleInfoService.saveModuleToRole(roleInfo.getId(),moduleIds);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "addModule_success";
	}
}
