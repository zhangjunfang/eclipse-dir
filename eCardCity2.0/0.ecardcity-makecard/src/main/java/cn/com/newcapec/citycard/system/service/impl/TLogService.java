package cn.com.newcapec.citycard.system.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.common.service.impl.BaseService;
import cn.com.newcapec.common.util.Constants;
import cn.com.newcapec.common.util.DateHelper;
import cn.com.newcapec.common.util.HttpServletHelper;
import com.opensymphony.xwork2.ActionContext;
import cn.com.newcapec.citycard.common.po.TLog;
import cn.com.newcapec.citycard.common.po.TOrgUser;
import cn.com.newcapec.citycard.system.domain.TLogSearch;
import cn.com.newcapec.citycard.system.service.ITLogService;
import cn.com.newcapec.citycard.system.util.CreateExcel;

/**
 * <p>
 * 日志维护的service
 * 
 * @author: WangJian
 * @version: 1.0
 * June 9, 2008 17:34:03 PM
 * </p>
 */
public class TLogService extends BaseService implements ITLogService{
	/* (non-Javadoc)
	 * @see cn.com.newcapec.citycard.system.service.impl.ITLogService#getRecordCount(cn.com.newcapec.citycard.system.domain.TLogSearch)
	 */
    public int getRecordCount(TLogSearch obj) throws BusinessException{
		DetachedCriteria dc = generateQueryDetachedCriteria(obj);
    	return baseDao.getCountsByCriteria(dc);
    }
	
    /* (non-Javadoc)
	 * @see cn.com.newcapec.citycard.system.service.impl.ITLogService#getTLogPageList(cn.com.newcapec.citycard.system.domain.TLogSearch, int, int)
	 */
    public List getTLogPageList(TLogSearch obj,int firstResult, int maxResults){
		DetachedCriteria dc = generateQueryDetachedCriteria(obj);
		dc.addOrder(Order.desc(TLog.PROP_ID));
    	return baseDao.getPaginationListByCriteria(dc, firstResult, maxResults);
    }

    /* (non-Javadoc)
	 * @see cn.com.newcapec.citycard.system.service.impl.ITLogService#getTLogByPK(int)
	 */
    public TLog getTLogByPK(int id){
    	return (TLog)baseDao.get(TLog.class,id);
    }
    
    /* (non-Javadoc)
	 * @see cn.com.newcapec.citycard.system.service.impl.ITLogService#saveTLog(cn.com.newcapec.citycard.common.po.TLog)
	 */
    public void saveTLog(TLog obj) throws Exception{
    	//当前时间
    	obj.setLogDate(Calendar.getInstance().getTime());
    	//当前IP
    	obj.setIp(HttpServletHelper.getIP(ActionContext.getContext(), true));
    	
    	//删除标记
    	if(StringUtils.isBlank(obj.getDelFlag())){
    		obj.setDelFlag(Constants.RECORD_DEL_NOT);
    	}
    	
    	//用户
    	if(StringUtils.isBlank(obj.getOperator())){
    		obj.setOperator(((TOrgUser)HttpServletHelper.getSessionValue(ActionContext.getContext(), Constants.SESSION_USER)).getUserName());
    	}
    	
    	try{
    		baseDao.saveOrUpdate(obj);
    	}catch (Exception e){
			log.error(e.getMessage());
			throw e;
		}
    }
    
    /* (non-Javadoc)
	 * @see cn.com.newcapec.citycard.system.service.impl.ITLogService#exportTLog(cn.com.newcapec.citycard.system.domain.TLogSearch)
	 */
    public int exportTLog(TLogSearch obj) throws Exception{
    	
		DetachedCriteria dc = generateQueryDetachedCriteria(obj);
		dc.addOrder(Order.desc(TLog.PROP_ID));
		List list = baseDao.getListByCriteria(dc);
		CreateExcel ce = new CreateExcel();
		try{
			ce.writeDataToExcel(list);
		}catch(Exception e)
		{
			throw e;
		}
		return list.size();
    }
    /**
	 * 根据查询条件生成DetachedCriteria
	 * 
	 * @param	obj:		query的条件对象
	 * @return	DetachedCriteria
	 * */
	private DetachedCriteria generateQueryDetachedCriteria(TLogSearch obj) {
		DetachedCriteria dc = DetachedCriteria.forClass(TLog.class);
		if(obj!=null){
			//查询指定操作员的
			if(StringUtils.isNotBlank(obj.getOperator())){
				dc.add(Restrictions.like(TLog.PROP_OPERATOR, "%"+obj.getOperator()+"%"));
			}
			//查询指定操作模块的
			if(StringUtils.isNotBlank(obj.getModule())){
				dc.add(Restrictions.like(TLog.PROP_MODULE, "%"+obj.getModule()+"%"));
			}
			//查询指定操作动作的
			if(StringUtils.isNotBlank(obj.getAction())){
				dc.add(Restrictions.like(TLog.PROP_ACTION, "%"+obj.getAction()+"%"));
			}
			//查询指定IP地址的
			if(StringUtils.isNotBlank(obj.getIp())){
				dc.add(Restrictions.like(TLog.PROP_IP,"%"+obj.getIp()+"%"));
			}
			//查询指定时间段的，有开始时间
			if(obj.getStartDate()!=null){
				dc.add(Restrictions.ge(TLog.PROP_LOG_DATE,DateHelper.parseDate(DateHelper.formatDate(obj.getStartDate(),DateHelper.SHORT_DATE_FORMAT)+" 00:00:00", DateHelper.FULL_DATE_FORMAT)));
			}
			//查询指定时间段的，有结束时间
			if(obj.getEndDate()!=null){
				dc.add(Restrictions.le(TLog.PROP_LOG_DATE,DateHelper.parseDate(DateHelper.formatDate(obj.getEndDate(),DateHelper.SHORT_DATE_FORMAT)+" 23:59:59", DateHelper.FULL_DATE_FORMAT)));
			}
		}
		dc.add(Restrictions.ne(TLog.PROP_DEL_FLAG,Constants.RECORD_DEL));
		return dc;
	}
	public static void main(String args[]){
//		java.util.Date tmp=Calendar.getInstance().getTime();
//		String aaa=cn.com.newcapec.common.util.DateHelper.formatDate(tmp, cn.com.newcapec.common.util.DateHelper.FULL_DATE_FORMAT);
//		System.out.println(tmp);
//		System.out.println(aaa);
		List<Object> a=new ArrayList<Object>();
		List<String> aa=new ArrayList<String>();
		aa.add("123");
		aa.add("qwe");
		
		String[] bb=new String[3];
		bb[0]="asd";
		bb[1]="asd";
		bb[2]="asd";
		a.add(aa);
		a.add(bb);
		
		System.out.println("aa instanceof ArrayList:"+ (a.get(0) instanceof ArrayList));
		System.out.println("aa instanceof List:"+ (a.get(0) instanceof List));
		System.out.println("aa instanceof Collection:"+ (a.get(0) instanceof Collection));
		System.out.println("aa instanceof Object[]:"+ (a.get(0) instanceof Object[]));
		System.out.println("aa instanceof String[]:"+ (a.get(0) instanceof String[]));

		System.out.println("bb instanceof ArrayList:"+ (a.get(1) instanceof ArrayList));
		System.out.println("bb instanceof List:"+ (a.get(1) instanceof List));
		System.out.println("bb instanceof Collection:"+ (a.get(1) instanceof Collection));
		System.out.println("bb instanceof Object[]:"+ (a.get(1) instanceof Object[]));
		System.out.println("bb instanceof String[]:"+ (a.get(1) instanceof String[]));
	}
}
