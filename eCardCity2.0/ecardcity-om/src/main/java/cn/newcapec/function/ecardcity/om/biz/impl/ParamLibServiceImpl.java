/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.biz.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.biz.ParamLibService;
import cn.newcapec.function.ecardcity.om.dao.ParamLibDao;
import cn.newcapec.function.ecardcity.om.model.ParamLib;

/**
 * @author wj
 * @category 参数模板操作业务接口实现
 * @version 1.0
 * @date 2014年4月1日 上午9:23:04
 */
@Service("ParamLibService")
@Transactional
public class ParamLibServiceImpl implements ParamLibService {
    @Autowired
    private ParamLibDao paramLibDao;

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public ParamLib get(String arg0) {
	return paramLibDao.get(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#removeUnused(java.lang.String)
     */
    @Override
    public void removeUnused(String arg0) {
	paramLibDao.delete(get(arg0));
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(ParamLib arg0) {
	paramLibDao.saveOrUpdate(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.ParamLibService#getPageList(java.util.Map)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Page<?> getPageList(Map<String, Object> paramMap) {
	return paramLibDao.getPage(paramMap);
    }

}
