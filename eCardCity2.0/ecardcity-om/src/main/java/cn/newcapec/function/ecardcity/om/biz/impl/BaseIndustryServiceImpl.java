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
import cn.newcapec.function.ecardcity.om.biz.BaseIndustryService;
import cn.newcapec.function.ecardcity.om.dao.BaseIndustryDao;
import cn.newcapec.function.ecardcity.om.model.BaseIndustry;
import cn.newcapec.function.ecardcity.om.model.NetSite;
import cn.newcapec.function.ecardcity.om.utils.KeyValue;

/**
 * @author wj
 * @category 基础行业信息Service实现
 * @version 1.0
 * @date 2014年5月5日 下午2:20:58
 */
@Service("BaseIndustryService")
@Transactional
@SuppressWarnings("all")
public class BaseIndustryServiceImpl implements BaseIndustryService {
    @Autowired
    private BaseIndustryDao objDao ;
    
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    public BaseIndustry get(String arg0) {
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
    public void saveOrUpdate(BaseIndustry arg0) {
	objDao.saveOrUpdate(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.BaseIndustryService#getPageList(java.util.Map)
     */
    @Override
    public Page<?> getPageList(Map<String, Object> paramMap) {
	return objDao.getPageList(paramMap);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.BaseIndustryService#delete(java.lang.String[])
     */
    @Override
    public void delete(String[] ids) {
	BaseIndustry tmp=null;
	StringBuilder sb=new StringBuilder();
	for(String id:ids){
	    tmp=get(id);
	    if(tmp.getReserved().equals("1")){
		sb.append("“");
		sb.append(tmp.getIndustryname());
		sb.append("("+tmp.getIndustrycode()+")");
		sb.append("”");
		sb.append("是保留行业，故不能删除该行业！");
		log.error(sb.toString());
		throw new BaseException(sb.toString());
	    }
	}
	objDao.delete(ids);
    }

    @Override
    public List<Map<String, Object>> getListByAttr(Map<String, Object> attrMap) {
	return (List<Map<String, Object>>) objDao.getListByAttr(attrMap, BaseIndustry.class,new Order[]{Order.asc("id")});
    }
    
    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.BaseIndustryService#isExists(KeyValue[])
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public boolean isExists(KeyValue[] keyValueArr) {
	return objDao.isExistsByAttr(BaseIndustry.class, keyValueArr);
    }    
}