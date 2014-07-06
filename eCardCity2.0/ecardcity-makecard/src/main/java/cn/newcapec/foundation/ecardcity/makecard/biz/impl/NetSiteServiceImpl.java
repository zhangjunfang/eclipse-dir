package cn.newcapec.foundation.ecardcity.makecard.biz.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.foundation.ecardcity.makecard.biz.EmployeeService;
import cn.newcapec.foundation.ecardcity.makecard.biz.NetSiteService;
import cn.newcapec.foundation.ecardcity.makecard.dao.EmployeeDAO;
import cn.newcapec.foundation.ecardcity.makecard.dao.NetSiteDAO;
import cn.newcapec.foundation.ecardcity.makecard.model.Employee;
import cn.newcapec.foundation.ecardcity.makecard.model.NetSite;
import cn.newcapec.framework.core.utils.pagesUtils.Page;

/**
 * 网点业务接口实现类
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:48:24
 * @version V1.0
 */
@Service("netsiteService")
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("all")
public class NetSiteServiceImpl implements NetSiteService {

	/* 接口类 */
	@Autowired
	private NetSiteDAO netSiteDAO;

	/* (non-Javadoc)
	 * @see cn.newcapec.framework.core.biz.BaseService#removeUnused(java.lang.String)
	 */
	@Override
	public void removeUnused(String arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.newcapec.foundation.ecardcity.makecard.biz.FuncCardService#queryUserByRoleId(java.lang.String, java.util.LinkedHashMap)
	 */
	@Override
	public List<Map<String, Object>> queryByPid(String id,
			LinkedHashMap<String, String> orderby) {
		List<Map<String, Object>> page = netSiteDAO.queryByPid(id, orderby);
		if (null != page && !page.isEmpty()) {
			return page;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
	 */
	@Override
	public NetSite get(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.newcapec.framework.core.biz.BaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(NetSite arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
