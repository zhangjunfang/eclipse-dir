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

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.biz.PrintTemplateService;
import cn.newcapec.function.ecardcity.om.dao.PrintTemplateDao;
import cn.newcapec.function.ecardcity.om.model.PrintTemplate;

/**
 * @author wj
 * @category 打印模板服务接口实现类
 * @version 1.0
 * @date 2014年4月15日 上午9:58:31
 */
@Service("PrintTemplateService")
@Transactional
public class PrintTemplateServiceImpl implements PrintTemplateService {
    @Autowired
    private PrintTemplateDao templateDao;
    
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public PrintTemplate get(String arg0) {
	return templateDao.get(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#removeUnused(java.lang.String)
     */
    @Override
    public void removeUnused(String arg0) {
	templateDao.delete(get(arg0));;
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(PrintTemplate arg0) {
	templateDao.saveOrUpdate(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.PrintTemplateService#getPage(java.util.Map)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Page<?> getPage(Map<String, Object> paramMap) {
	return 	templateDao.getPage(paramMap);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.PrintTemplateService#delete(java.lang.String[])
     */
    @Override
    public void delete(String[] ids) {
	templateDao.delete(ids);
    }

    @Override
    public List<?> getListByType(String type) {
	return templateDao.getListByType(type);
    }

    @Override
    public void deleteByName(String templateName) {
	templateDao.deleteByName(templateName);
    }

    @Override
    public Page<?> getTraderPage(Map<String, Object> paramMap) {
	return 	templateDao.getTraderPage(paramMap);
    }

    @Override
    public boolean copyTemplate(String targetTemplate, String traderID,
	    String sourceTemplate) {
	return 	templateDao.copyTemplate(targetTemplate, traderID, sourceTemplate);
    }

    @Override
    public boolean hasExistsTemplate(String templateType, String traderID) {
	Map<String, Object> param = new HashMap<String, Object>();
	if(StringUtils.isNotBlank(templateType) && StringUtils.isNotBlank(traderID)){
	    param.put("template_type", templateType);
	    param.put("netsiteid", traderID);
	}
	return templateDao.getListByAttr(param, PrintTemplate.class,null).size()>0;
    }
    
    @Override
    public List<?> getListByAttr(Map<String, Object> param,Order[] orders) {
	return templateDao.getListByAttr(param, PrintTemplate.class,orders);
    }
}
