package cn.com.newcapec.citycard.common.action;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import cn.com.newcapec.common.domain.NameValue;
import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.common.util.BaseDataHelper;
import cn.com.newcapec.common.util.HttpServletHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.com.newcapec.citycard.common.po.TLog;
import cn.com.newcapec.citycard.common.service.ICommonService;
import cn.com.newcapec.citycard.system.service.ITLogService;

/**
 * <pre>
 * 功能描述:项目公共Action
 *   
 * Author : Wangjian 
 * Date   : 2008-05-08
 * Time   : 14:47:15
 * Version: 1.0
 * </pre>
 */
public class CommonAction extends ActionSupport{
	private static final long serialVersionUID = -8235898437446285705L;
	protected final Log log = LogFactory.getLog(this.getClass());
	protected ICommonService commonService;//项目公共服务接口
	protected String prompt;//提示
	protected Integer orderNo;//排序号
	protected String act;//动作，添加、删除（add、update）

	//数字格式化
	public String formatDouble(double s) {
		DecimalFormat fmt = new DecimalFormat("##0.00");
		return fmt.format(s);
	}
	public void setCommonService(ICommonService commonService){
		this.commonService = commonService;
	}

	public String getPrompt(){
		return prompt;
	}

	public void setPrompt(String prompt){
		this.prompt = prompt;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public Integer getOrderNo(){
		return orderNo;
	}
	
	/**
	 * <pre>
	 * 功能描述：设置下一个排序号
	 * 
	 * @param cls 持久化实体类
	 * </pre>
	 */
	protected void setNextOrderNo(Class cls){
		orderNo=commonService.getNextOrderNo(cls);
	}
	
	/**
	 * id集合，用以处理列表的多条更新时候用到
	 * */
	protected List<Integer> id;
	public List<Integer> getId() {
		return id;
	}
	public void setId(List<Integer> id) {
		this.id = id;
	}
	
	/**
	 * <pre>
	 * 功能描述：执行假删除若干条记录
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @return
	 * </pre>
	 */
	protected void delFlagRecords(Class cls){
		commonService.removeRecords(cls, id);
	}

	/**
	 * <pre>
	 * 功能描述：执行删除若干条记录，根据主键集合
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @return
	 * </pre>
	 */
	protected void delRecordsByPK(Class cls){
		commonService.delRecords(cls, id,null);
	}
	
	/**
	 * <pre>
	 * 功能描述：执行删除若干条记录，根据指定的字段及集合
	 * @author Wangjian
	 * @param cls 		持久化实体类
	 * @param idList	id集合
	 * @return
	 * </pre>
	 */
	protected void delRecords(Class cls,List values,String columnName){
		commonService.delRecords(cls, values, columnName);
	}	
	/**
	 * <pre>
	 * 获取Request对象
	 * @author Wangjian
	 * @return	HttpServletRequest
	 *  <pre>
	 */
	protected HttpServletRequest getRequest(){
		return HttpServletHelper.getRequest(ActionContext.getContext());
	}
	
	/**
	 * <pre>
	 * 获取Session对象
	 * @author Wangjian
	 * @return	HttpSession
	 *  <pre>
	 */
	protected HttpSession getSession(){
		return HttpServletHelper.getSession(ActionContext.getContext());
	}
	
	/**
	 * <pre>
	 * 获取Request中的参数值
	 * @author Wangjian
	 * @param para
	 * @return
	 * String
	 *  <pre>
	 */
	protected String getParameter(String para){
		return HttpServletHelper.getReqyestParameter(ActionContext.getContext(),para);
	}
	

	/**
	 * 向session设置值
	 * @param key
	 * @param value
	 * void
	 *  
	 */
	protected void setSessionValue(String key,String value){
		HttpServletHelper.setSessionValue(ActionContext.getContext(), key, value);
	}
	

	/**
	 * 获取session中的参数值
	 * @param key
	 * @return
	 * String
	 *  
	 */
	protected String getSessionValue(String key){
		return (String)HttpServletHelper.getSessionValue(ActionContext.getContext(), key);
	}
	
	protected BaseDataHelper logAction;						//日志动作类型
    protected BaseDataHelper logModule;						//日志模块类型
    protected TLog logInfo;								//日志po
    protected ITLogService logInfoService;				//日志service
	/**
	 * @return the logActionHelper
	 */
	public BaseDataHelper getLogAction() {
		return logAction;
	}

	/**
	 * @param logActionHelper the logActionHelper to set
	 */
	public void setLogAction(BaseDataHelper logAction) {
		this.logAction = logAction;
	}


	/**
	 * @return the logModule
	 */
	public BaseDataHelper getLogModule() {
		return logModule;
	}

	/**
	 * @param logModule the logModule to set
	 */
	public void setLogModule(BaseDataHelper logModule) {
		this.logModule = logModule;
	}

	/**
	 * @return the logInfo
	 */
	public TLog getTLog() {
		return logInfo;
	}

	/**
	 * @param logInfo the logInfo to set
	 */
	public void setTLog(TLog logInfo) {
		this.logInfo = logInfo;
	}

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
	 * 功能描述:根据PK得到Obj
	 * @param id 	PK
	 * 
	 */
	public Object getObjByPk(Class cls,Integer id) throws BusinessException{
		return commonService.getObj(cls, id);
	}

	/**
	 * 查找指定的Object数量
	 * 
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return integer		对象数量
	 */
	public Integer getObjCount(Class cls,NameValue[] attrColl){
		return commonService.getObjCountByAttr(cls, attrColl);
	}
	
	/**
	 * 查找指定的Object列表
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return List 		根据给定的属性返回当前列表
	 */
	public List getObjList(Class cls,NameValue[] attrColl) {
		return commonService.getObjListByAttr(cls, attrColl);
	}
	
	/**
	 * 查找指定的Object分页列表
	 * @param cls			对象实例Class
	 * @param attrColl		属性键值对集合
	 * @return List 		根据给定的属性返回当前分页列表
	 */
	public List getObjPaginationList(Class cls,NameValue[] attrColl, int firstResult, int maxResults) {
		return commonService.getObjPaginationListByAttr(cls, attrColl, firstResult, maxResults);
	}
	
	/**
	 * 保存Object
	 * 
	 * @param	obj			Object
	 * @return
	 * @throws Exception 
	 */
	public void saveObj(Object obj)throws Exception{
		commonService.saveObj(obj);
	}

	/**
	 * 修改Object
	 * 
	 * @param	obj			Object
	 * @return
	 * @throws Exception 
	 */
	public void updateObj(Object obj)throws Exception{
		commonService.updateObj(obj);
	}	
}
