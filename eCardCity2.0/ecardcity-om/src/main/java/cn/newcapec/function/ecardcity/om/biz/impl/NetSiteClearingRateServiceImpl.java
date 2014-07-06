/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.function.ecardcity.om.biz.NetSiteClearingRateService;
import cn.newcapec.function.ecardcity.om.dao.NetSiteClearingRateDao;
import cn.newcapec.function.ecardcity.om.model.NetSiteClearingRate;

/**
 * @author wj
 * @category 网点费率设置服务实现
 * @version 1.0
 * @date 2014年5月15日 下午6:35:15
 */
@Service("NetSiteClearingRateService")
@Transactional
public class NetSiteClearingRateServiceImpl implements NetSiteClearingRateService {
    @Autowired
    private NetSiteClearingRateDao objDao;
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public NetSiteClearingRate get(String arg0) {
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
    public void saveOrUpdate(NetSiteClearingRate arg0) {
	objDao.saveOrUpdate(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteClearingRateService#getList(java.util.Map)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public List<?> getList(Map<String, Object> paramMap) {
	return (List<Map<String, Object>>) objDao.getListByAttr(paramMap, NetSiteClearingRate.class,new Order[]{Order.asc("netsiteid")});
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.NetSiteClearingRateService#getByNetSiteID(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public NetSiteClearingRate getByNetSiteID(String netSiteId) {
	Map<String, Object> attrMap=new HashMap<String, Object>();
	attrMap.put("netsiteid", netSiteId);
	List list=objDao.getListByAttr(attrMap, NetSiteClearingRate.class, null);
	if(list.size()==1){
	    return (NetSiteClearingRate)list.get(0);
	}
	return null;
    }
}
