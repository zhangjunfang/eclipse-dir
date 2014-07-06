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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.biz.TermMenuService;
import cn.newcapec.function.ecardcity.om.dao.NetSiteDao;
import cn.newcapec.function.ecardcity.om.dao.TermMainMenuDao;
import cn.newcapec.function.ecardcity.om.dao.TermSubMenuDao;
import cn.newcapec.function.ecardcity.om.model.TermMainMenu;
import cn.newcapec.function.ecardcity.om.model.TermSubMenu;

/**
 * @author wj
 * @category 终端菜单服务接口实现
 * @version 1.0
 * @date 2014年4月22日 下午1:40:53
 */
@Service("TermMenuService")
@Transactional
@SuppressWarnings("all")
public class TermMenuServiceImpl implements TermMenuService {
    @Autowired
    private TermMainMenuDao mainDao;
    @Autowired
    private TermSubMenuDao subDao;
    
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    public TermMainMenu get(String arg0) {
	return mainDao.get(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#removeUnused(java.lang.String)
     */
    @Override
    public void removeUnused(String arg0) {
	mainDao.delete(get(arg0));
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(TermMainMenu arg0) {
	mainDao.saveOrUpdate(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.TermMenuService#getPageMenu(java.util.Map)
     */
    @Override
    public Page<?> getPageMenu(Map<String, Object> paramMap) {
	return 	mainDao.getPageIncludeSubMenu(paramMap);
    }
    
    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.TermMenuService#getPageMainMenu(java.util.Map)
     */
    @Override
    public Page<?> getPageMainMenu(Map<String, Object> paramMap) {
	return 	mainDao.getPage(paramMap);
    }
    
    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.TermMenuService#getPageSubMenu(java.util.Map)
     */
    @Override
    public Page<?> getPageSubMenu(Map<String, Object> paramMap) {
	return 	subDao.getPage(paramMap);
    }
    
    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.TermMenuService#delete(java.lang.String[])
     */
    @Override
    public void delete(String[] ids) {
	mainDao.delete(ids);
	subDao.delete(ids);
    }

    @Override
    public List<?> getPermLocListByTerm(String termid) {
	return mainDao.getPermLocListByTerm(termid);
    }

    @Override
    public void deleteByMainMenu(String mainMenu, String termid) {
	mainDao.deleteByMainMenu(mainMenu, termid);
    }

    @Override
    public void saveOrUpdateSubMenu(TermSubMenu subMenu) {
	subDao.saveOrUpdate(subMenu);
    }

}
