/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cn.newcapec.function.ecardcity.om.dao.base.BaseDao;
import cn.newcapec.function.ecardcity.om.model.NetSiteClearingRate;

/**
 * @author wj
 * @category 网点结算费率设置DAO
 * @version 1.0
 * @date 2014年5月15日 下午6:35:41
 */
@Repository
public class NetSiteClearingRateDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<NetSiteClearingRate> getReferenceClass() {
	return NetSiteClearingRate.class;
    }
    
    /**
     * 查询指定网点费率，根据ID
     * @param key		ID
     * @return ParamLib		根据给定的ID返回对象
     */
    public NetSiteClearingRate get(Serializable key) {
	return (NetSiteClearingRate) get(getReferenceClass(), key);
    }
}
