package cn.com.newcapec.citycard.picture.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import cn.com.newcapec.common.domain.NameValue;
import cn.com.newcapec.common.page.utils.Page;
import cn.com.newcapec.common.page.utils.PageHelper;
import cn.com.newcapec.common.util.Constants;
import com.opensymphony.xwork2.ActionContext;
import cn.com.newcapec.citycard.common.action.CommonAction;
import cn.com.newcapec.citycard.common.po.TOrgUser;
import cn.com.newcapec.citycard.common.po.TPicture;
import cn.com.newcapec.citycard.picture.service.IPictureService;

/**
 * <p>
 * 药品、药店图片关联设置action
 * 
 * @author: WangJian
 * @version: 1.0
 * February 23, 2013 19:18:23 PM
 * </p>
 */

public class PictureAction extends CommonAction {
	private static final long serialVersionUID = -7270867111522776586L;
	private static final Class<TPicture> cls= TPicture.class;
	private final Log log = LogFactory.getLog(this.getClass());
    private IPictureService pictureService;
    private List objList;
    private Object[] objArr;
	private TPicture picture;
	private String schCondition;
	protected List<String> guid;	//guid集合，用以处理列表的多条删除时候用到

	
	/**
	 * @return the guid
	 */
	public List<String> getGuid() {
		return guid;
	}

	/**
	 * @param guid the guid to set
	 */
	public void setGuid(List<String> guid) {
		this.guid = guid;
	}

	/**
	 * @return the picture
	 */
	public TPicture getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(TPicture picture) {
		this.picture = picture;
	}

	/**
	 * @return the schCondition
	 */
	public String getSchCondition() {
		return schCondition;
	}

	/**
	 * @param schCondition the schCondition to set
	 */
	public void setSchCondition(String schCondition) {
		this.schCondition = schCondition;
	}

	/**
	 * @return the pictureService
	 */
	public IPictureService getPictureService() {
		return pictureService;
	}

	/**
	 * @param pictureService the pictureService to set
	 */
	public void setPictureService(IPictureService pictureService) {
		this.pictureService = pictureService;
	}

	/**
	 * @return the objList
	 */
	public List getObjList() {
		return objList;
	}

	/**
	 * @param objList the objList to set
	 */
	public void setObjList(List objList) {
		this.objList = objList;
	}

	/**
	 * @return the objArr
	 */
	public Object[] getObjArr() {
		return objArr;
	}

	/**
	 * @param objArr the objArr to set
	 */
	public void setObjArr(Object[] objArr) {
		this.objArr = objArr;
	}

	//数字格式化
	public String formatDouble(double s) {
		DecimalFormat fmt = new DecimalFormat("##0.00");
		return fmt.format(s);
	}

	// 获取药店信息列表
	public String pharmacy() throws Exception {
		int total=pictureService.getPharmacyCount(schCondition);
		try{
			Page page = PageHelper.getPage(ServletActionContext.getRequest(), total, Constants.DEFAULT_PAGE_NUM);
			objList=pictureService.getPharmacyList(schCondition, page.getFirstResult()-1,page.getPageListNum());
		}catch(Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		return "PHARMACY_LIST";
	}
	// 添加药店图片信息，检索外库和本库该条记录信息
	public String pharmacyAddPre() throws Exception {
		try {
			objArr=pictureService.getPharmacy(guid.get(0));
			NameValue[] attrColl={new NameValue(picture.PROP_GUID,guid.get(0))};
			List tmpList=super.getObjList(cls, attrColl);
			if(tmpList.size()>0){
				picture=(TPicture)tmpList.get(0);
			}
		}catch(Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		return "PHARMACY_ADD";
	}
	// 添加并设置药店图片信息
	public String pharmacyAdd() throws Exception {
		try {
			picture.setUpdateuser(((TOrgUser)ActionContext.getContext().getSession().get(Constants.SESSION_USER)).getUserName());
			picture.setUpdatetime(Calendar.getInstance().getTime());
			picture.setCategory(Constants.PICTURE_PHARMACY);
			super.updateObj(picture);
    		//日志
    		logInfo.setAction((String)logAction.getDatas().get("ADD"));
    		logInfo.setLogContent(logInfo.getAction()+"：GUID为“"+picture.getGuid()+"”的药店图片信息。");
    		logInfo.setModule((String)logModule.getDatas().get("PICTURE_PHARMACY"));
    		logInfoService.saveTLog(logInfo);
		}catch(Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		guid=new ArrayList<String>();
		guid.add(picture.getGuid());
		return pharmacyAddPre();
		//		return "PHARMACY_ADD_SUCCESS";
	}
	/* 批量删除已设置的药品图片记录 */
	public String pharmacyDel() throws Exception {
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("DELETE"));
		logInfo.setLogContent(logInfo.getAction()+"："+guid.size()+"条药店图片信息。");
		logInfo.setModule((String)logModule.getDatas().get("PICTURE_PHARMACY"));
		try {
			//TODO 删除对应的图片
			pictureService.delPicture(cls, guid);
			logInfoService.saveTLog(logInfo);
			//再次获取列表
			pharmacy();
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
				log.error(e.getMessage(), e.getCause());
			}
    		prompt = e.getMessage();// 页面显示消息
		}
		return "PHARMACY_LIST";
	}	
	
	
	// 获取药品信息列表
	public String medicine() throws Exception {
		int total=pictureService.getMedicineCount(schCondition);
		try{
			Page page = PageHelper.getPage(ServletActionContext.getRequest(), total, Constants.DEFAULT_PAGE_NUM);
			objList=pictureService.getMedicineList(schCondition, page.getFirstResult()-1,page.getPageListNum());
		}catch(Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		return "MEDICINE_LIST";
	}

	// 添加药品图片信息，检索外库和本库该条记录信息
	public String medicineAddPre() throws Exception {
		try {
			objArr=pictureService.getMedicine(guid.get(0));
			NameValue[] attrColl={new NameValue(picture.PROP_GUID,guid.get(0))};
			List tmpList=super.getObjList(cls, attrColl);
			if(tmpList.size()>0){
				picture=(TPicture)tmpList.get(0);
			}
		}catch(Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		return "MEDICINE_ADD";
	}
	// 添加并设置药品图片信息
	public String medicineAdd() throws Exception {
		try {
			picture.setUpdateuser(((TOrgUser)ActionContext.getContext().getSession().get(Constants.SESSION_USER)).getUserName());
			picture.setUpdatetime(Calendar.getInstance().getTime());
			picture.setCategory(Constants.PICTURE_MEDICINE);
			super.updateObj(picture);
    		//日志
    		logInfo.setAction((String)logAction.getDatas().get("ADD"));
    		logInfo.setLogContent(logInfo.getAction()+"：GUID为“"+picture.getGuid()+"”的药品图片信息。");
    		logInfo.setModule((String)logModule.getDatas().get("PICTURE_MEDICINE"));
    		logInfoService.saveTLog(logInfo);
		}catch(Exception e){
			if (log.isDebugEnabled()){
				log.debug(e.getMessage(),e.getCause());
			}
		}
		guid=new ArrayList<String>();
		guid.add(picture.getGuid());
		return medicineAddPre();
		//		return "MEDICINE_ADD_SUCCESS";
	}
	
	/* 批量设置的药品首页呈现记录 */
	public String medicineSetIndex() throws Exception {
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("SETINDEX"));
		logInfo.setLogContent(logInfo.getAction()+"："+guid.size()+"条药品图片信息。");
		logInfo.setModule((String)logModule.getDatas().get("PICTURE_MEDICINE"));
		try{
			NameValue[] attrColl={new NameValue(picture.PROP_GUID,guid)};
			List<TPicture> tmpList=super.getObjList(cls, attrColl);
			for(TPicture picture:tmpList){
				picture.setIndexpage(Constants.STATE_VALID);
				picture.setUpdateuser(((TOrgUser)ActionContext.getContext().getSession().get(Constants.SESSION_USER)).getUserName());
				picture.setUpdatetime(Calendar.getInstance().getTime());
				super.updateObj(picture);
			}
			logInfoService.saveTLog(logInfo);
			//再次获取列表
			medicine();
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
				log.error(e.getMessage(), e.getCause());
			}
    		prompt = e.getMessage();// 页面显示消息
		}
		return "MEDICINE_LIST";
	}
	
	/* 批量设置的药品首页分类列表推荐记录 */
	public String medicineSetRecommend() throws Exception {
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("SETRECOMMEND"));
		logInfo.setLogContent(logInfo.getAction()+"："+guid.size()+"条药品图片信息。");
		logInfo.setModule((String)logModule.getDatas().get("PICTURE_MEDICINE"));
		try{
			NameValue[] attrColl={new NameValue(picture.PROP_GUID,guid)};
			List<TPicture> tmpList=super.getObjList(cls, attrColl);
			for(TPicture picture:tmpList){
				picture.setRecommend(Constants.STATE_VALID);
				picture.setUpdateuser(((TOrgUser)ActionContext.getContext().getSession().get(Constants.SESSION_USER)).getUserName());
				picture.setUpdatetime(Calendar.getInstance().getTime());
				super.updateObj(picture);
			}
			logInfoService.saveTLog(logInfo);
			//再次获取列表
			medicine();
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
				log.error(e.getMessage(), e.getCause());
			}
    		prompt = e.getMessage();// 页面显示消息
		}
		return "MEDICINE_LIST";
	}
	
	/* 批量删除已设置的药品图片记录 */
	public String medicineDel() throws Exception {
		//添加日志，动作/内容/模块/用户
		logInfo.setAction((String)logAction.getDatas().get("DELETE"));
		logInfo.setLogContent(logInfo.getAction()+"："+guid.size()+"条药品图片信息。");
		logInfo.setModule((String)logModule.getDatas().get("PICTURE_MEDICINE"));
		try {
			//TODO 删除对应的图片
			pictureService.delPicture(cls, guid);
			logInfoService.saveTLog(logInfo);
			//再次获取列表
			medicine();
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
				log.error(e.getMessage(), e.getCause());
			}
    		prompt = e.getMessage();// 页面显示消息
		}
		return "MEDICINE_LIST";
	}		
}