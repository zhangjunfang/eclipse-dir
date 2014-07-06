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
import cn.newcapec.function.ecardcity.om.model.TermInfo;

/**
 * @author wj
 * @category 终端操作DAO
 * @version 1.0
 * @date 2014年4月17日 下午2:35:41
 */
@Repository
public class TermInfoDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<TermInfo> getReferenceClass() {
	return TermInfo.class;
    }
    
    /**
     * 查询指定网点
     * @param key		ID
     * @return ParamLib		根据给定的ID返回对象
     */
    public TermInfo get(Serializable key) {
	return (TermInfo) get(getReferenceClass(), key);
    }
    
    /**
     * 批量删除
     * @param ids	ID数组
     */
    public void delete(String[] ids) {
	if (ids != null && ids.length > 0) {
	    bulkUpdate(true,"delete from TermInfo where id in (:ids)", new String[]{"ids"},new Object[]{ids});
	}
    }
    
    /**
     * 根据map，查询指定的模板参数分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page getPage(Map<String, Object> paramMap) {
//	Map<String, Object> param = new HashMap<String, Object>();
//	StringBuilder sql = new StringBuilder("select * from base_print_template where 1=1");
//	if (null != paramMap) {
//		if (paramMap.containsKey("template_type") && StringUtils.isNotBlank(paramMap.get("template_type").toString())) {
//		    sql.append(" and template_type = :template_type ");
//		    param.put("template_type", paramMap.get("template_type"));
//		}
//		if (paramMap.containsKey("template_name") && StringUtils.isNotBlank(paramMap.get("template_name").toString())) {
//		    sql.append(" and template_name=:template_name ");
//		    param.put("template_name", paramMap.get("template_name"));
//		}
//		if (paramMap.containsKey("netsiteid") && StringUtils.isNotBlank(paramMap.get("netsiteid").toString())) {
//		    sql.append(" and netsiteid = :netsiteid ");
//		    param.put("netsiteid", paramMap.get("netsiteid"));
//		}		
//	}
//	sql.append(" order by line_no");
//
//	return super.getPageBySQL(sql.toString(), param);
	return null;
    }
    /**
     * 根据termid，查询该终端可用的业务类型位置
     * @param termid	 	终端ID
     * @return String 		终端业务类型编号，逗号分隔
     */
    public String getBusinessTypeByTerm(String termid){
	if (StringUtils.isNotBlank(termid)) {
	    Map<String, Object> param = new HashMap<String, Object>();
	    param.put("termid", termid);
	    String sql = "select a.used_business from term_info_param a,term_info b where a.poscode=b.poscode and b.id=:termid";
	    return super.getPageBySQL(sql, param).getItems().get(0).toString();
	}else{
	    return null;
	}
    }
    
}
