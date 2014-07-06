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

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.biz.NetSiteService;
import cn.newcapec.function.ecardcity.om.dao.NetSiteDao;
import cn.newcapec.function.ecardcity.om.model.NetSite;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 网点接口实现类
 * @version 1.0
 * @date 2014年4月17日 下午2:58:31
 */
@Service("NetSiteService")
@Transactional
public class NetSiteServiceImpl implements NetSiteService {
    @Autowired
    private NetSiteDao objDao;
    
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public NetSite get(String arg0) {
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
    public void saveOrUpdate(NetSite arg0) {
	objDao.saveOrUpdate(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteService#getPage(java.util.Map)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Page<?> getPage(Map<String, Object> paramMap) {
	return 	objDao.getPage(paramMap);
    }
    
    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteService#getList(java.util.Map)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public List<?> getList(Map<String, Object> paramMap) {
	return (List<Map<String, Object>>) objDao.getListByAttr(paramMap, NetSite.class,new Order[]{Order.asc("sort_num")});
    }
    
    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteService#delete(java.lang.String[])
     */
    @Override
    public void delete(String[] ids) {
	objDao.delete(ids);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteService#isExists(KeyValue[])
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public boolean isExists(KeyValue[] keyValueArr) {
	return objDao.isExistsByAttr(NetSite.class, keyValueArr);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteService#isExists(KeyValue[])
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public int getMaxNetSiteID(String industryCode) {
	return objDao.getMaxNetSiteID(industryCode);
    }
}
