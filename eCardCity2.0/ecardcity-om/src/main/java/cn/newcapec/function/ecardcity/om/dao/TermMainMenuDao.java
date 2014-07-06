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
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.dao.base.BaseDao;
import cn.newcapec.function.ecardcity.om.model.TermMainMenu;
import cn.newcapec.function.ecardcity.om.utils.Constant;

/**
 * @author wj
 * @category 终端自定义菜单DAO
 * @version 1.0
 * @date 2014年4月22日 上午11:47:40
 */
@Repository
public class TermMainMenuDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<TermMainMenu> getReferenceClass() {
	return TermMainMenu.class;
    }
    
    /**
     * 查询指定卡类型
     * @param key		ID
     * @return ParamLib		根据给定的ID返回对象
     */
    public TermMainMenu get(Serializable key) {
	return (TermMainMenu) get(getReferenceClass(), key);
    }
    
    /**
     * 根据主菜单名称、终端名称删除菜单
     * @param mainMenu	主菜单名称
     * @param termid	终端ID
     */
    public void deleteByMainMenu(String mainMenu,String termid) {
	if (StringUtils.isNotBlank(mainMenu)&&StringUtils.isNotBlank(termid)) {
	    super.bulkUpdate(false,"delete from term_menu_sub where main_id in (select id from term_menu_main where termid=:termid and main_menu=:mainMenu)", new String[]{"termid","mainMenu"},new Object[]{termid,mainMenu});
	    super.bulkUpdate(false,"delete from term_menu_main where termid=:termid and main_menu=:mainMenu", new String[]{"termid","mainMenu"},new Object[]{termid,mainMenu});
	}
    }
    
    /**
     * 批量删除
     * @param ids	卡ID数组
     */
    public void delete(String[] ids) {
	if (ids != null && ids.length > 0) {
	    bulkUpdate(true,"delete from TermMainMenu where id in (:ids)", new String[]{"ids"},new Object[]{ids});
	}
    }
        
    /**
     * 根据map，查询指定的菜单分页（包括主、子菜单）
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getPageIncludeSubMenu(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select a.*,b.sub_id,b.sub_menu,b.sub_trade_type,b.sub_acl_location,b.sub_acl_setting,c.termname,c.siteid from term_menu_main a,term_menu_sub b,term_info c where c.id=a.termid and b.main_id=a.id");
	if (null != paramMap) {
	    //根据商户或终端名称构建子查询
	    if ((paramMap.containsKey("netsiteid") && StringUtils.isNotBlank(paramMap.get("netsiteid").toString()))
		    || (paramMap.containsKey("termName") && StringUtils.isNotBlank(paramMap.get("termName").toString()))) {
		StringBuilder subSql = new StringBuilder("select id from term_info where 1=1");
		if (paramMap.containsKey("netsiteid") && StringUtils.isNotBlank(paramMap.get("netsiteid").toString())) {
		    subSql.append(" and siteid=:siteid");
		    param.put("siteid", paramMap.get("netsiteid"));
		}
		if (paramMap.containsKey("termName") && StringUtils.isNotBlank(paramMap.get("termName").toString())) {
		    subSql.append(" and termname like :termname");
		    param.put("termname",Constant.PERCENT_SIGN + paramMap.get("termName") + Constant.PERCENT_SIGN);
		}
		sql.append(" and a.termid in (");
		sql.append(subSql.toString());
		sql.append(")");
	    }
	    
	    if (paramMap.containsKey("mainMenu") && StringUtils.isNotBlank(paramMap.get("mainMenu").toString())) {
		sql.append(" and a.main_menu like :mainMenu");
		param.put("mainMenu", Constant.PERCENT_SIGN+paramMap.get("mainMenu")+Constant.PERCENT_SIGN);
	    }
	    if (paramMap.containsKey("paramVer") && StringUtils.isNotBlank(paramMap.get("paramVer").toString())) {
		sql.append(" and a.param_ver = :paramVer");
		param.put("paramVer", paramMap.get("paramVer"));
	    }
	    if (paramMap.containsKey("mainId") && StringUtils.isNotBlank(paramMap.get("mainId").toString())) {
		sql.append(" and a.id = :mainId");
		param.put("mainId", paramMap.get("mainId"));
	    }	    
	}
	sql.append(" order by a.id desc,b.sub_id asc");
	return super.getPageBySQL(sql.toString(), param);
    }

    /**
     * 根据map，查询指定的模板参数分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getPage(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select * from term_menu_main where 1=1");
	if (null != paramMap) {
		if (paramMap.containsKey("termid") && StringUtils.isNotBlank(paramMap.get("termid").toString())) {
		    sql.append(" and termid = :termid");
		    param.put("termid", paramMap.get("termid"));
		}
		if (paramMap.containsKey("main_menu") && StringUtils.isNotBlank(paramMap.get("main_menu").toString())) {
		    sql.append(" and main_menu like :main_menu");
		    param.put("main_menu", Constant.PERCENT_SIGN+paramMap.get("main_menu")+Constant.PERCENT_SIGN);
		}
	}
	sql.append(" order by ver_time desc");
	return super.getPageBySQL(sql.toString(), param);
    }
    
    /**
     * 根据termid，查询已用的二级菜单权限位置
     * @param termid	 	终端ID
     * @return List 		已用的权限列表位置
     */
    public List<?> getPermLocListByTerm(String termid) {
	if (StringUtils.isNotBlank(termid)) {
	    Map<String, Object> param = new HashMap<String, Object>();
	    param.put("startLoc",Constant.TERM_MENU_PERMISSION_START_LOC);
	    param.put("termid", termid);
	    String sql = "select a.p_value,a.title_name from base_param a where a.allow_visible='1' and a.p_group='6'"
		+ " and to_number(a.p_value)>=:startLoc"
	    	+ " and instr((select b.used_business from term_info b where b.id=:termid)||',',a.p_value||',')>0"
	    	+ " and a.p_value not in (select c.sub_acl_location from term_menu_sub c where main_id in (select id from term_menu_main where termid=:termid))";
	    return super.getPageBySQL(sql, param).getItems();
	}else{
	    return null;
	}
    }
}
