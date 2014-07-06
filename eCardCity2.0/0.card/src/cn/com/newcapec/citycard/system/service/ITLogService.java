package cn.com.newcapec.citycard.system.service;

import java.util.List;

import cn.com.newcapec.common.exception.BusinessException;
import cn.com.newcapec.citycard.common.po.TLog;
import cn.com.newcapec.citycard.system.domain.TLogSearch;

public interface ITLogService {

	/**
	 * 根据DetachedCriteria查询符合条件的记录数
	 * 
	 * @param	
	 * @param obj:					TLogSearch对象
	 * @throws BusinessException	业务异常
	 * */
	public abstract int getRecordCount(TLogSearch obj)
			throws BusinessException;

	/**
	 * 得到满足查询条件的日志分页列表
	 * 
	 * @param obj:				TLogSearch对象
	 * @param firstResult:		从第几条开始
	 * @param maxResults:		共取几条 
	 * @return List:			带分页的IP地址规划表别列表
	 * */
	public abstract List getTLogPageList(TLogSearch obj, int firstResult,
			int maxResults);

	/**
	 * 根据主键查询记录的详细信息
	 * 
	 * @param id:				TLog主键
	 * @return TLog:			TLog对象
	 * */
	public abstract TLog getTLogByPK(int id);

	/**
	 * 保存日志
	 * 
	 * @param	obj：				TLog
	 * @return	
	 * @throws BusinessException	业务异常
	 * */
	public abstract void saveTLog(TLog obj) throws Exception;

	/**
	 * 导出日志
	 * 
	 * @param	obj：				TLogSearch
	 * @return	int
	 * @throws BusinessException	业务异常
	 * */
	public abstract int exportTLog(TLogSearch obj) throws Exception;

}