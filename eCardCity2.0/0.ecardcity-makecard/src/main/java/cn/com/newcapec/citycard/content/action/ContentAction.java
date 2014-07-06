package cn.com.newcapec.citycard.content.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import cn.com.newcapec.common.domain.NameValue;
import cn.com.newcapec.common.page.utils.Page;
import cn.com.newcapec.common.page.utils.PageHelper;
import cn.com.newcapec.common.util.Constants;
import com.opensymphony.xwork2.ActionContext;
import cn.com.newcapec.citycard.common.action.CommonAction;
import cn.com.newcapec.citycard.common.po.TContent;
import cn.com.newcapec.citycard.common.po.TOrgUser;
import cn.com.newcapec.citycard.content.service.IContentService;

/**
 * <p>
 * 内容管理action
 * 
 * @author: WangJian
 * @version: 1.0
 * January 13, 2013 17:18:23 PM
 * </p>
 */

public class ContentAction extends CommonAction {
	private static final long serialVersionUID = -6717049148517704556L;
	private static final Class<TContent> cls= TContent.class;
	private final Log log = LogFactory.getLog(this.getClass());
    private IContentService contentService;
    private List objList;
    private TContent obj;
    private String logTitle;//内容中的日志标题

	public String getLogTitle() {
		return logTitle;
	}

	public void setLogTitle(String logTitle) {
		this.logTitle = logTitle;
	}

	public IContentService getContentService() {
		return contentService;
	}

	public void setContentService(IContentService contentService) {
		this.contentService = contentService;
	}

	public List getObjList() {
		return objList;
	}

	public void setObjList(List objList) {
		this.objList = objList;
	}
	
	public TContent getObj() {
		return obj;
	}

	public void setObj(TContent obj) {
		this.obj = obj;
	}

	/* 查看Obj */
	public String view() throws Exception {
		try {
			obj=(TContent)super.getObjByPk(cls,id.get(0));
			//更新点击次数
			obj.setHit(obj.getHit()+1);
			super.updateObj(obj);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
			prompt = e.getMessage();// 页面显示消息
//	    	return Constants.EDIT_PRE_FAILURE;
		}
		return Constants.VIEW_SUCCESS;
	}

	/* 根据栏目ID，获取列表 */
	public String list() throws Exception{
		NameValue[] attrColl={new NameValue(obj.PROP_CHANNEL_ID,obj.getChannelId())};
		int total=super.getObjCount(cls, attrColl);
		try{
			Page page = PageHelper.getPage(ServletActionContext.getRequest(), total, Constants.DEFAULT_PAGE_NUM);
			objList=super.getObjPaginationList(cls, attrColl, page.getFirstResult()-1,page.getPageListNum());
		}catch(Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		return Constants.LIST_SUCCESS;
	}

	/* 编辑前查询Obj */
	public String editPre() throws Exception {
		try {
			if(act.equals(Constants.ACT_UPDATE)){
				obj=(TContent)super.getObjByPk(cls,id.get(0));
			}else{
	    		obj.setUpdateuser(((TOrgUser)ActionContext.getContext().getSession().get(Constants.SESSION_USER)).getName());
			}
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.error(e.getMessage(), e.getCause());
			}
			prompt = e.getMessage();// 页面显示消息
	    	return Constants.EDIT_PRE_FAILURE;
		}
		return Constants.EDIT_PRE_SUCCESS;
	}
	
	/* 保存Obj */
	public String save() throws Exception {
		//添加日志，动作/内容/模块/用户
    	try {
    		obj.setUpdatetime(Calendar.getInstance().getTime());
    		if(act.equals(Constants.ACT_ADD)){
    			obj.setHit(0);
    			logInfo.setAction((String)logAction.getDatas().get("ADD"));
    			super.saveObj(obj);
    		}else{
    			logInfo.setAction((String)logAction.getDatas().get("UPDATE"));
    			super.updateObj(obj);
    		}
    		logInfo.setLogContent(logInfo.getAction()+"：标题为“"+StringUtils.abbreviate(obj.getCtitle(),20)+"”的"+logTitle+"记录。");
    		logInfo.setModule(logTitle);
    		logInfoService.saveTLog(logInfo);
    	} catch (Exception e) {
    		if (log.isErrorEnabled()) {
    			log.error(e.getMessage(), e.getCause());
    		}
    		prompt = e.getMessage();// 页面显示消息
    		return Constants.EDIT_FAILURE;
    	}
    	return Constants.EDIT_SUCCESS;
	}
	
	/* 批量删除用户 */
	public String del() throws Exception {
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("DELETE"));
		logInfo.setLogContent(logInfo.getAction()+"："+id.size()+"条"+logTitle+"记录。");
		logInfo.setModule(logTitle);
		try {
			super.delRecordsByPK(cls);
			logInfoService.saveTLog(logInfo);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
				log.error(e.getMessage(), e.getCause());
			}
    		prompt = e.getMessage();// 页面显示消息
		}
		return Constants.EDIT_SUCCESS;
	}
}