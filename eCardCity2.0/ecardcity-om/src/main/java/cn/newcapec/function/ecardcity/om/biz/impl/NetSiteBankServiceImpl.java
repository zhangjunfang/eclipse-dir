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

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.framework.core.exception.BaseException;
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.biz.NetSiteBankService;
import cn.newcapec.function.ecardcity.om.dao.BaseEmployeeDao;
import cn.newcapec.function.ecardcity.om.dao.NetSiteBankDao;
import cn.newcapec.function.ecardcity.om.model.NetSiteBank;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 网点账号服务接口实现类
 * @version 1.0
 * @date 2014年5月12日 下午2:54:50
 */
@Service("NetSiteBankService")
@Transactional
public class NetSiteBankServiceImpl implements NetSiteBankService {
    @Autowired
    private NetSiteBankDao objDao;
    @Autowired
    private BaseEmployeeDao empDao;
    
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    public NetSiteBank get(String arg0) {
	return objDao.get(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#removeUnused(java.lang.String)
     */
    @Override
    public void removeUnused(String arg0) {
	objDao.delete(get(arg0));;
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(NetSiteBank arg0) {
	objDao.saveOrUpdate(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteBankService#getPage(java.util.Map)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Page<?> getPage(Map<String, Object> paramMap) {
	return 	objDao.getPage(paramMap);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteBankService#getList(java.util.Map)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public List<?> getList(Map<String, Object> paramMap) {
	return (List<Map<String, Object>>) objDao.getListByAttr(paramMap, NetSiteBank.class,new Order[]{Order.desc("edit_date")});
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteBankService#delete(java.lang.String[])
     */
    @Override
    public void delete(String[] ids) {
	NetSiteBank tmp=null;
	for(String id:ids){
	    if(empDao.getByNetbank(id)){
		tmp=get(id);
		log.error("开户账号为"+tmp.getOpen_account()+"的账号信息已被分配，请先解除分配，再删除该账号信息！");
		throw new BaseException("开户账号为"+tmp.getOpen_account()+"的账号信息已被分配，请先解除分配，再删除该账号信息！");
	    }
	}
	objDao.delete(ids);
    }
    
    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteBankService#isExists(KeyValue[])
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public boolean isExists(KeyValue[] keyValueArr) {
	return objDao.isExistsByAttr(NetSiteBank.class, keyValueArr);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteBankService#getListByNetSiteID(String)
     */
    @Override
    public List getListByNetSiteID(String netSiteId) {
	return objDao.getListByNetSiteID(netSiteId);
    }    
}
