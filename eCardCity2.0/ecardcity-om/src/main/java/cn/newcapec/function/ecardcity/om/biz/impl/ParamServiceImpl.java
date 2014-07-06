/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.biz.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.biz.ParamService;
import cn.newcapec.function.ecardcity.om.dao.ParamDao;
import cn.newcapec.function.ecardcity.om.model.Param;

/**
 * @author wj
 * @category 参数操作业务接口实现
 * @version 1.0
 * @date 2014年4月3日 上午8:33:05
 */
@Service("ParamService")
@Transactional
public class ParamServiceImpl implements ParamService {
    @Autowired
    private ParamDao ParamDao;

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Param get(String arg0) {
	return ParamDao.get(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#removeUnused(java.lang.String)
     */
    @Override
    public void removeUnused(String arg0) {
	ParamDao.delete(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(Param arg0) {
	ParamDao.saveOrUpdate(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.ParamService#getPageList(java.util.Map)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Page<?> getSysPageList(Map<String, Object> paramMap) {
	return ParamDao.getSysParamPage(paramMap);
    }
    
    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.ParamService#getPageList(java.util.Map)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Page<?> getCardPageList(Map<String, Object> paramMap) {
	return ParamDao.getCardParamPage(paramMap);
    }

    @Override
    public boolean cardParamsInit(Serializable id, String flag,
	    String sourceParamId) {
	return ParamDao.cardParamsInit(id, flag, sourceParamId);
    }

    @Override
    public List<?> getPramListByType(String type) {
	return ParamDao.getPramListByType(type);
    }
}
