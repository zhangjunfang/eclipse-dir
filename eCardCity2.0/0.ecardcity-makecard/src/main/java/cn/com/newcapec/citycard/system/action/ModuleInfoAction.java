package cn.com.newcapec.citycard.system.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.com.newcapec.common.domain.Node;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.common.page.utils.Page;
import cn.com.newcapec.common.page.utils.PageHelper;
import cn.com.newcapec.common.util.Constants;
import cn.com.newcapec.citycard.common.action.CommonAction;
import cn.com.newcapec.citycard.common.po.TOrgPermission;
import cn.com.newcapec.citycard.common.po.TOrgUser;
import cn.com.newcapec.citycard.system.service.IModuleInfoService;

/**
 * <p>
 * 功能描述:模块管理Action
 *   
 * Author : Wangjian 
 * Date   : 2008-06-03
 * Time   : 11:04:15
 * Version: 1.0
 * </p>
 */
public class ModuleInfoAction extends CommonAction {
	private static final long serialVersionUID = -8894181403301296225L;

	private IModuleInfoService moduleInfoService;// 模块管理服务接口

	private TOrgPermission moduleInfo; // 模块信息

	private List<TOrgPermission> moduleInfoList; // 模块信息列表

	private Integer parentId; // 父模块ID号
	


	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public TOrgPermission getModuleInfo() {
		return moduleInfo;
	}

	public void setModuleInfo(TOrgPermission moduleInfo) {
		this.moduleInfo = moduleInfo;
	}

	public List<TOrgPermission> getModuleInfoList() {
		return moduleInfoList;
	}

	public void setModuleInfoList(List<TOrgPermission> moduleInfoList) {
		this.moduleInfoList = moduleInfoList;
	}

	public void setModuleInfoService(IModuleInfoService moduleInfoService) {
		this.moduleInfoService = moduleInfoService;
	}

	private String leftFrame;// 左边导航菜单

	public String getLeftFrame() {
		return leftFrame;
	}

	private String rightFrame;// 右边页面

	public String getRightFrame() {
		return rightFrame;
	}

	/* 菜单管理主框架 */
	public String listFrame() throws Exception {
		leftFrame = "/system/moduleInfo_listTree.action";
		rightFrame = "/system/jsp/blank.jsp";
		return "listFrame_success";
	}

	private List<Node> nodeList;// 树型菜单结点列表

	public List<Node> getNodeList() {
		return nodeList;
	}

	/* 菜单管理树 */
	public String listTree() throws Exception {
		try {
			nodeList = moduleInfoService.getModuleInfoTreeNodeList();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "listTree_success";
	}

	/* 根据菜单的ID号获取其下层一级的功能菜单列表 */
	public String listAllChildNodeById() throws Exception {
		try {
			// 分页总数
			int total = moduleInfoService.getModuleInfoCountByQuery(parentId);
			Page page = PageHelper.getPage(ServletActionContext.getRequest(),
					total, Constants.DEFAULT_PAGE_NUM);

			moduleInfoList = moduleInfoService.getAllChildNodeById(parentId,
					page.getFirstResult() - 1, page.getPageListNum());
			rightFrame = "/system/jsp/moduleInfoViewMain.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "listAllChildNode_success";
	}
	
	
	/* 根据菜单的ID号获取其下层一级的功能菜单列表 */
	public String listAllChildNodeByIdNoFresh() throws Exception {
		try {
			// 分页总数
			int total = moduleInfoService.getModuleInfoCountByQuery(parentId);
			Page page = PageHelper.getPage(ServletActionContext.getRequest(),
					total, Constants.DEFAULT_PAGE_NUM);

			moduleInfoList = moduleInfoService.getAllChildNodeById(parentId,
					page.getFirstResult() - 1, page.getPageListNum());
			rightFrame = "/system/jsp/moduleInfoViewMain.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "listAllChildNodeByIdNoFresh_success";
	}

	/* 模块预添加 */
	public String add() throws Exception {
		rightFrame = "/system/jsp/moduleInfoAdd.jsp";
		return "add_pre";
	}

	/* 子模块添加 */
	public String addNext() throws Exception {
		
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("ADD"));
		logInfo.setLogContent(logInfo.getAction()+"：“"+ moduleInfo.getPermName().trim() +"”功能模块。");
		logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN_ORG")+"_模块管理");
    	
		try {
			parentId = moduleInfo.getPid();
			moduleInfo.setPermName(moduleInfo.getPermName().trim());
			if( null != moduleInfo.getPermUrl()){
				moduleInfo.setPermUrl(moduleInfo.getPermUrl().trim());
			}
			if( null != moduleInfo.getRemark()){
				moduleInfo.setRemark(moduleInfo.getRemark().trim());
			}
			moduleInfoService.saveOrUpdateModuleInfo(moduleInfo);
			
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

	/* 模块预修改 */
	public String update() throws Exception {
		try {
			moduleInfo = moduleInfoService
					.getModuleInfoByPK(moduleInfo.getId());
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "update_pre";
	}

	/* 模块修改 */
	public String updateNext() throws Exception {
		
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("UPDATE"));
		logInfo.setLogContent(logInfo.getAction()+"：“"+ moduleInfo.getPermName().trim() +"”功能模块。");
		logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN_ORG")+"_模块管理");
    	
		try {
			parentId = moduleInfo.getPid();
			moduleInfo.setPermName(moduleInfo.getPermName().trim());
			if( null != moduleInfo.getPermUrl()){
				moduleInfo.setPermUrl(moduleInfo.getPermUrl().trim());
			}
			if( null != moduleInfo.getRemark()){
				moduleInfo.setRemark(moduleInfo.getRemark().trim());
			}
			moduleInfoService.saveOrUpdateModuleInfo(moduleInfo);
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
			return moduleInfo.getId() == null ? "add_failure"
					: "update_failure";
		}

		return "update_success";
	}

	/* 多条模块数据批量删除 */
	public String delete() throws Exception {
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("DELETE"));
		logInfo.setLogContent(logInfo.getAction()+"："+id.size()+"条功能模块记录。");
		logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN_ORG")+"_模块管理");
		try {
			moduleInfoService.deleteModuleInfo(id);
			logInfoService.saveTLog(logInfo);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "delete_success";
	}
	
	
	/* 模块详情 */
	public String viewModuleById() throws Exception {
		try {
			rightFrame = "/system/jsp/moduleInfoView.jsp";
			moduleInfo = moduleInfoService.getModuleInfoByPK(moduleInfo.getId());
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
		}
		return "view_success";
	}

}
