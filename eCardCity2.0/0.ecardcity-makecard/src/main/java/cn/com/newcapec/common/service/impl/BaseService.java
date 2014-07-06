package cn.com.newcapec.common.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.newcapec.common.dao.IBaseDao;
import cn.com.newcapec.common.service.IBaseService;

/**
 * <p>
 * 功能描述:公共服务接口实现
 *   
 * Author : Wangjian 
 * Date   : 2008-05-08
 * Time   : 15:03:15
 * Version: 1.0
 * </p>
 */
public class BaseService implements IBaseService
{
	protected final Log log = LogFactory.getLog(this.getClass());
	
	protected IBaseDao baseDao;//公共DAO接口
	
	public void setBaseDao(IBaseDao baseDao){
		this.baseDao=baseDao;
	}
}
