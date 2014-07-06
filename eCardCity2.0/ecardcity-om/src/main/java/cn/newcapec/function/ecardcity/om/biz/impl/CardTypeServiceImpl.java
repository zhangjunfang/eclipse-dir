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
import cn.newcapec.function.ecardcity.om.biz.CardTypeService;
import cn.newcapec.function.ecardcity.om.dao.CardTypeDao;
import cn.newcapec.function.ecardcity.om.model.CardType;
import cn.newcapec.function.ecardcity.om.model.Department;

/**
 * @author wj
 * @category 卡类型操作biz实现类
 * @version 1.0
 * @date 2014年4月9日 下午12:03:16
 */
@Service("CardTypeService")
@Transactional
public class CardTypeServiceImpl implements CardTypeService {
    @Autowired
    private CardTypeDao cartTypeDao;

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#get(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public CardType get(String arg0) {
	return cartTypeDao.get(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#removeUnused(java.lang.String)
     */
    @Override
    public void removeUnused(String arg0) {
	cartTypeDao.delete(get(arg0));;
    }

    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.biz.BaseService#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(CardType arg0) {
	cartTypeDao.saveOrUpdate(arg0);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.CardTypeService#getListByGroup(java.lang.String)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public List<?> getListByGroup(String group) {
	return 	cartTypeDao.getListByGroup(group);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.CardTypeService#getPageList(java.util.Map)
     */
    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public Page<?> getPageList(Map<String, Object> paramMap) {
	return 	cartTypeDao.getPage(paramMap);
    }

    /* (non-Javadoc)
     * @see cn.newcapec.function.ecardcity.om.biz.CardTypeService#delete(java.lang.String[])
     */
    @Override
    public void delete(String[] ids) {
	for(String id:ids){
	    if(cartTypeDao.hasQuoteCardType(id)){
		log.error("ID为"+id+"的卡类型已被使用，无法删除！");
		throw new BaseException("ID为"+id+"的卡类型已被使用，无法删除！");
	    }
	}
	cartTypeDao.delete(ids);
    }

    @Override
    @Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
    public List<Map<String, Object>> getListByAttr(Map<String, Object> attrMap) {
	return (List<Map<String, Object>>) cartTypeDao.getListByAttr(attrMap, CardType.class,new Order[]{Order.asc("id")});
    }    
}
