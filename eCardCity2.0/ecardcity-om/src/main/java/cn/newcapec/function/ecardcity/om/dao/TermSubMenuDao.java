/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.dao.base.BaseDao;
import cn.newcapec.function.ecardcity.om.model.TermSubMenu;
import cn.newcapec.function.ecardcity.om.utils.Constant;

/**
 * @author wj
 * @category 终端自定义菜单DAO
 * @version 1.0
 * @date 2014年4月22日 上午11:47:40
 */
@Repository
public class TermSubMenuDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<TermSubMenu> getReferenceClass() {
	return TermSubMenu.class;
    }
    
    /**
     * 查询指定卡类型
     * @param key		ID
     * @return ParamLib		根据给定的ID返回对象
     */
    public TermSubMenu get(Serializable key) {
	return (TermSubMenu) get(getReferenceClass(), key);
    }
    
    /**
     * 批量删除
     * @param ids	卡ID数组
     */
    public void delete(String[] ids) {
	if (ids != null && ids.length > 0) {
	    bulkUpdate(true,"delete from TermSubMenu where main_id in (:main_id)", new String[]{"main_id"},new Object[]{ids});
	}
    }
    
    /**
     * 根据map，查询指定的模板参数分页
     * @param param	 	参数Map
     * @param rtnFlag		返回类型	true:Page，false：List
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getPage(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select * from term_menu_sub where 1=1");
	if (null != paramMap) {
		if (paramMap.containsKey("main_id") && StringUtils.isNotBlank(paramMap.get("main_id").toString())) {
		    sql.append(" and main_id in (:termid) ");
		    param.put("main_id", paramMap.get("main_id"));
		}
		if (paramMap.containsKey("sub_menu") && StringUtils.isNotBlank(paramMap.get("sub_menu").toString())) {
		    sql.append(" and sub_menu like :sub_menu");
		    param.put("sub_menu", Constant.PERCENT_SIGN+paramMap.get("sub_menu")+Constant.PERCENT_SIGN);
		}
	}
	return super.getPageBySQL(sql.toString(), param);
    }
}
