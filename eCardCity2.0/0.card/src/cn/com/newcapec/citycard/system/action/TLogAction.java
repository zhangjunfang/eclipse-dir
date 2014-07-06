package cn.com.newcapec.citycard.system.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import cn.com.newcapec.common.excel.util.DateHelper;
import cn.com.newcapec.common.page.utils.Page;
import cn.com.newcapec.common.page.utils.PageHelper;
import cn.com.newcapec.common.util.Constants;
import cn.com.newcapec.citycard.common.action.CommonAction;
import cn.com.newcapec.citycard.common.po.TLog;
import cn.com.newcapec.citycard.common.po.TOrgUser;
import cn.com.newcapec.citycard.system.domain.TLogSearch;
import cn.com.newcapec.citycard.system.service.ITLogService;

/**
 * <p>
 * 日志管理的action
 * 
 * @author: WangJian
 * @version: 1.0
 * June 9, 2008 17:18:23 PM
 * </p>
 */

public class TLogAction extends CommonAction {
	private static final long serialVersionUID = 912672490233645935L;
	private final Log log = LogFactory.getLog(this.getClass());
    private List logInfoList;		    						//日志列表
    private TLogSearch logInfoSearch;						//日志对象

	/**
	 * @return the logInfoService
	 */
	public ITLogService getTLogService() {
		return logInfoService;
	}

	/**
	 * @param logInfoService the logInfoService to set
	 */
	public void setTLogService(ITLogService logInfoService) {
		this.logInfoService = logInfoService;
	}

	/**
	 * @return the logInfoList
	 */
	public List getTLogList() {
		return logInfoList;
	}

	/**
	 * @param logInfoList the logInfoList to set
	 */
	public void setTLogList(List logInfoList) {
		this.logInfoList = logInfoList;
	}

	/**
	 * @return the logInfoSearch
	 */
	public TLogSearch getTLogSearch() {
		return logInfoSearch;
	}

	/**
	 * @param logInfoSearch the logInfoSearch to set
	 */
	public void setTLogSearch(TLogSearch logInfoSearch) {
		this.logInfoSearch = logInfoSearch;
	}
	
	public Map getActionMap(){   
		return logAction.getDatas();//操作动作Map
	}
	
	public Map getModuleMap(){      
		return logModule.getDatas();//操作模块Map
	}

	/* 日志分页列表 */
	public String logInfoList() throws Exception{
		//分页总数
		int total=logInfoService.getRecordCount(logInfoSearch);
		try{
			Page page = PageHelper.getPage(ServletActionContext.getRequest(), total, Constants.DEFAULT_PAGE_NUM);
			logInfoList=logInfoService.getTLogPageList(logInfoSearch,page.getFirstResult()-1,page.getPageListNum());
		}catch(Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		return SUCCESS;
	}

	/* 日志导出 */
	public String logInfoExport() throws Exception{
		try{
			int list_size = logInfoService.exportTLog(logInfoSearch);
			
			//添加日志，动作/内容/模块/用户
			logInfo.setAction((String)logAction.getDatas().get("EXPORT"));
			logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN")+"_日志管理");
			if(null != logInfoSearch){
				StringBuffer content = new StringBuffer();
				content.append(logInfo.getAction()).append("：");
				if(StringUtils.isNotBlank(logInfoSearch.getOperator())){					
					content.append(logInfoSearch.getOperator());
				}else{
					content.append("所有用户");
				}
				if(null != logInfoSearch.getStartDate()){
					content.append(DateHelper.formatDate(logInfoSearch.getStartDate(), DateHelper.SHORT_DATE_FORMAT)).append(" 00:00:00")
					.append("之后");
				}
				if(null != logInfoSearch.getEndDate()){
					content.append(DateHelper.formatDate(logInfoSearch.getEndDate(), DateHelper.SHORT_DATE_FORMAT)).append(" 23:59:59")
					.append("之前");
				}
				if(null != logInfoSearch.getIp()){
					content.append("，IP地址为：“");
					content.append(logInfoSearch.getIp());
					content.append("”");
				}
				content.append("的全部操作日志 共").append(list_size).append("条记录");
				logInfo.setLogContent(content.toString());
			}else{
				logInfo.setLogContent(logInfo.getAction()+"：所有用户的全部操作日志 共"+list_size+"条记录");
			}
			logInfoService.saveTLog(logInfo);  //保存操作日志
		}catch (Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		return NONE;
	}
	
	/* 日志删除 */
	public String logInfoDelete() throws Exception{
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("DELETE"));
		logInfo.setLogContent(logInfo.getAction()+"："+id.size()+"条用户操作日志记录。");
		logInfo.setModule((String)logModule.getDatas().get("SYSTEM_ADMIN")+"_日志管理");
    	
		try{
			super.delFlagRecords(TLog.class);
			logInfoService.saveTLog(logInfo);  //保存操作日志
		}catch (Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		return SUCCESS;
	}
}