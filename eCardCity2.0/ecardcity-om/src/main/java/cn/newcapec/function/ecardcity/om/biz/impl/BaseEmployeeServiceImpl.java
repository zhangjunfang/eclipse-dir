/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.biz.impl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.biz.BaseEmployeeService;
import cn.newcapec.function.ecardcity.om.dao.BaseEmployeeDao;
import cn.newcapec.function.ecardcity.om.model.BaseEmployee;
import cn.newcapec.function.ecardcity.om.model.NetSiteBank;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 操作员服务实现
 * @version 1.0
 * @date 2014年5月13日 下午5:06:43
 */
@Service("BaseEmployeeService")
@Transactional
@SuppressWarnings("all")
public class BaseEmployeeServiceImpl implements BaseEmployeeService {
    @Autowired
    private BaseEmployeeDao objDao ;
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public BaseEmployee get(String arg0) {
	return objDao.get(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#removeUnused(java.lang.String)
     */
    @Override
    public void removeUnused(String arg0) {
	objDao.delete(get(arg0));
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(BaseEmployee arg0) {
	objDao.saveOrUpdate(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.BaseEmployeeService#getPage(java.util.Map)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Page<?> getPage(Map<String, Object> paramMap) {
	return objDao.getPage(paramMap);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.BaseEmployeeService#getList(java.util.Map)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public List<?> getList(Map<String, Object> paramMap) {
	return (List<Map<String, Object>>) objDao.getListByAttr(paramMap, BaseEmployee.class,null);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.BaseEmployeeService#isExists(cn.newcapec.function.ecardcity.om.utils.KeyValue[])
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public boolean isExists(KeyValue[] keyValueArr) {
	return objDao.isExistsByAttr(BaseEmployee.class, keyValueArr);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.BaseEmployeeService#delete(java.lang.String[])
     */
    @Override
    public void delete(String[] ids) {
	objDao.delete(ids);
    }
    
    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.BaseEmployeeService#getUsersFliterEployee(JSONArray)
     */
    @Override
    public JSONArray getUsersFliterEployee(JSONArray users) {
	return objDao.getUsersFliterEployee(users);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.BaseEmployeeService#getMaxEmpID()
     */
    @Override
    public int getMaxEmpID() {
	return objDao.getMaxEmpID();
    }
}