package cn.newcapec.foundation.ecardcity.makecard.biz.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.foundation.ecardcity.makecard.biz.EmployeeService;
import cn.newcapec.foundation.ecardcity.makecard.dao.EmployeeDAO;
import cn.newcapec.foundation.ecardcity.makecard.model.Employee;
import cn.newcapec.framework.core.utils.pagesUtils.Page;

/**
 * 职员业务接口实现类
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:48:24
 * @version V1.0
 */
@Service("employeeService")
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("all")
public class EmployeeServiceImpl implements EmployeeService {

	/* 接口类 */
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public void removeUnused(String arg0) {
		
	}

	@Override
	public List<Map<String, Object>> queryByNetsiteId(String id,
			LinkedHashMap<String, String> orderby) {
		List<Map<String, Object>> page = employeeDAO.queryByNetsiteId(id ,orderby);
		if (null != page && !page.isEmpty()){
			return page;
		}
		return null;
	}

	
	@Override
	public void saveOrUpdate(Employee arg0) {
		
		
	}

	/* (non-Javadoc)
	 * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
	 */
	@Override
	public Employee get(String id) {
		return employeeDAO.get(id);
	}
	
}
