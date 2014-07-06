/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import cn.newcapec.function.ecardcity.om.dao.base.BaseDao;
import cn.newcapec.function.ecardcity.om.model.Dict;
import cn.newcapec.function.ecardcity.om.model.DictCategory;

/**
 * @author wj
 * @category 字典处理类
 * @version 1.0
 * @date 2014年4月9日 下午3:14:32
 */
@Repository
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DictionaryUtil extends BaseDao{
    /** 字典map */
    private static Map<String, Object> dictMap=null;
    
    /** 全局单例 */	
//    private static DictionaryUtil dict = new DictionaryUtil();
    static boolean inited=false;
    
    /** 获取map */
    @PostConstruct
    public synchronized Map<String, Object> getDictMap() {
	    if (dictMap == null) {
		generateDictMap();
	    }
	return dictMap;
    }
    
    /** 初始化map */
    private void generateDictMap() {
	dictMap = new HashMap<String, Object>();
	List<DictCategory> categoryList = getDictCategoryList();
	Map<String, Object> param = null;
	List list = null;
	for (DictCategory category : categoryList) {
	    param = new HashMap<String, Object>();
	    param.put("c_code", category.getC_code());
	    list = getListByAttr(param, Dict.class, new Order[]{Order.asc("sort_num")});
	    if (list != null && list.size() > 0) {
		dictMap.put(category.getC_code(), list);
	    }
	    log.info(category.getC_code() + "-" + category.getC_name()
		    + "字典加载成功！");
	}
    }
    
    /**获取字典类别列表*/
    @SuppressWarnings("unchecked")
    private List<DictCategory> getDictCategoryList(){
	Map<String, Object> param = new HashMap<String, Object>();
	param.put("allow_memory","1");
	return (List<DictCategory>) super.getListByAttr(param, DictCategory.class, new Order[]{Order.asc("sort_num")});	
    }
//
//    /** 获取实例 */
//    public static DictionaryUtil getInstance() {
//	return dict;
//    }
}
