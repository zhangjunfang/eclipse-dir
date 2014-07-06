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
import cn.newcapec.function.ecardcity.om.model.PrintTemplate;
import cn.newcapec.function.ecardcity.om.utils.Constant;

/**
 * @author wj
 * @category 打印模板操作DAO
 * @version 1.0
 * @date 2014年4月14日 下午5:35:41
 */
@Repository
public class PrintTemplateDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<PrintTemplate> getReferenceClass() {
	return PrintTemplate.class;
    }
    
    /**
     * 查询指定卡类型
     * @param key		ID
     * @return ParamLib		根据给定的ID返回对象
     */
    public PrintTemplate get(Serializable key) {
	return (PrintTemplate) get(getReferenceClass(), key);
    }
    
    /**
     * 批量删除
     * @param ids	卡ID数组
     */
    public void delete(String[] ids) {
	if (ids != null && ids.length > 0) {
	    bulkUpdate(true,"delete from PrintTemplate where id in (:ids)", new String[]{"ids"},new Object[]{ids});
	}
    }

    /**
     * 根据模板名称删除模板参数
     * @param templateName	模板名称
     */
    public void deleteByName(String templateName) {
	if (StringUtils.isNotBlank(templateName)) {
	    super.bulkUpdate(true,"delete from PrintTemplate where template_name = (:templateName)", new String[]{"templateName"},new Object[]{templateName});
	}
    }
    
    /**
     * 根据map，查询指定的模板参数分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page getPage(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select * from base_print_template where 1=1");
	if (null != paramMap) {
		if (paramMap.containsKey("template_type") && StringUtils.isNotBlank(paramMap.get("template_type").toString())) {
		    sql.append(" and template_type = :template_type ");
		    param.put("template_type", paramMap.get("template_type"));
		}
		if (paramMap.containsKey("template_name") && StringUtils.isNotBlank(paramMap.get("template_name").toString())) {
		    sql.append(" and template_name=:template_name ");
		    param.put("template_name", paramMap.get("template_name"));
		}
	}
	sql.append(" order by line_no");

	return super.getPageBySQL(sql.toString(), param);
    }
    /**
     * 根据map，查询商户分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page getTraderPage(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select template_name,template_type,netsiteid from base_print_template where length(netsiteid)>0");
	if (null != paramMap) {
	    if (paramMap.containsKey("netsiteid") && StringUtils.isNotBlank(paramMap.get("netsiteid").toString())) {
		sql.append(" and netsiteid = :netsiteid ");
		param.put("netsiteid", paramMap.get("netsiteid"));
	    }
	    if (paramMap.containsKey("template_type") && StringUtils.isNotBlank(paramMap.get("template_type").toString())) {
		sql.append(" and template_type = :template_type ");
		param.put("template_type", paramMap.get("template_type"));
	    }
	    if (paramMap.containsKey("template_name") && StringUtils.isNotBlank(paramMap.get("template_name").toString())) {
		sql.append(" and template_name like :template_name ");
		param.put("template_name", Constant.PERCENT_SIGN+paramMap.get("template_name")+Constant.PERCENT_SIGN);
	    }
	}
	sql.append(" group by template_name,template_type,netsiteid order by netsiteid");

	return super.getPageBySQL(sql.toString(), param);
    }
    
    /**
     * 根据map，查询指定的模板列表
     * @param type	 	模板类型
     * @return Page 		根据给定的map返回列表
     */
    public List<?> getListByType(String type) {
	if (StringUtils.isNotBlank(type)) {
	    String sql = "select template_name from base_print_template where (netsiteid is null) and (template_type=?) group by template_name";
	    return super.sqlQueryForList(sql, new Object[]{type}, null);
	}
	return null;
    }

    /**
     * 根据模板进行参数复制
     * 
     * @param targetTemplate	目标模板
     * @param traderID		目标商户
     * @param sourceTemplate	源模板
     * @return Boolean
     */
    public boolean copyTemplate(String targetTemplate,String traderID,String sourceTemplate) {
	StringBuilder sql=new StringBuilder("insert into base_print_template (id,template_name,template_type,netsiteid,line_no,print_title,print_param,control_symbol)");
	sql.append(" (select lower(rawtohex(sys_guid())),:targetTemplate,template_type,:traderID,line_no,print_title,print_param,control_symbol from base_print_template where template_name=:sourceTemplate)");
	return super.bulkUpdate(false,sql.toString(), new String[]{"targetTemplate","traderID","sourceTemplate"},new Object[]{targetTemplate,traderID,sourceTemplate})>0;
    }    
}
