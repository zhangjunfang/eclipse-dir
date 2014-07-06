package cn.com.newcapec.citycard.content.action;

import cn.com.newcapec.common.util.Constants;
import cn.com.newcapec.citycard.common.po.TContent;

/**
 * <p>
 * 内容管理action
 * 
 * @author: WangJian
 * @version: 1.0
 * January 13, 2013 17:18:23 PM
 * </p>
 */

public class InfoAction extends ContentAction {
	private static final long serialVersionUID = 5155707486679267340L;
	private Integer arg;
	
	/**
	 * @return the arg
	 */
	public Integer getArg() {
		return arg;
	}
	/**
	 * @param arg the arg to set
	 */
	public void setArg(Integer arg) {
		this.arg = arg;
	}
	
	/* 根据栏目ID，获取列表 */
	public String list() throws Exception{
		if(getObj()==null ){
			TContent obj=new TContent();
			setObj(obj);
		}
		
		if(arg==Constants.INFO_US_COMPANY_ID){
			setLogTitle(Constants.INFO_US_COMPANY);
		}else if(arg==Constants.INFO_US_CONTACT_ID){
			setLogTitle(Constants.INFO_US_CONTACT);
		}else if(arg==Constants.INFO_WGJS_ID){
			setLogTitle(Constants.INFO_WGJS);
		}else if(arg==Constants.INFO_YSBH_ID){
			setLogTitle(Constants.INFO_YSBH);
		}else if(arg==Constants.INFO_TSWQ_ID){
			setLogTitle(Constants.INFO_TSWQ);
		}else if(arg==Constants.INFO_KFZX_ID){
			setLogTitle(Constants.INFO_KFZX);
		}else if(arg==Constants.INFO_CJWT_ID){
			setLogTitle(Constants.INFO_CJWT);
		}else if(arg==Constants.INFO_SPSS_ID){
			setLogTitle(Constants.INFO_SPSS);
		}else if(arg==Constants.INFO_THH_ID){
			setLogTitle(Constants.INFO_THH);
		}else if(arg==Constants.INFO_GYS_ID){
			setLogTitle(Constants.INFO_GYS);
		}
		getObj().setChannelId(arg);

		String a=super.list();
		
		//第一次没有取到相应记录，先手工增加一条
		if(super.getObjList()==null || super.getObjList().size()==0){
			super.setAct(Constants.ACT_ADD);
			super.getObj().setState(Constants.STATE_VALID);
			super.getObj().setCtitle(getLogTitle());
			super.save();
			super.list();
		}
		return a;
	}
}