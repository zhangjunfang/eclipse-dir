/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.dao.base.BaseDao;
import cn.newcapec.function.ecardcity.om.model.Department;
import cn.newcapec.function.ecardcity.om.model.ParamLib;
import cn.newcapec.function.ecardcity.om.utils.Constant;

/**
 * @author wj
 * @category 参数组模板DAO
 * @version 1.0
 * @date 2014年3月31日 下午4:15:41
 */
@Repository
@SuppressWarnings("all")
public class ParamLibDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<ParamLib> getReferenceClass() {
	return ParamLib.class;
    }
    
    /**
     * 查询指定参数模板
     * @param key		ID
     * @return ParamLib		根据给定的ID返回对象
     */
    public ParamLib get(java.io.Serializable key) {
	return (ParamLib) get(getReferenceClass(), key);
    }
    
    /**
     * 根据map，查询指定的参数模板分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page getPage(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select * from base_param_lib t where allow_visible='1'");
	if (null != paramMap) {
		if (paramMap.containsKey("p_lib_group") && StringUtils.isNotBlank(paramMap.get("p_lib_group").toString())) {
		    String[] paraArr=paramMap.get("p_lib_group").toString().split(",");
		    sql.append(" and p_lib_group in (:p_lib_group)");
		    param.put("p_lib_group", paraArr);
		}
		if (paramMap.containsKey("schStr") && StringUtils.isNotBlank(paramMap.get("schStr").toString())) {
		    sql.append(" and (p_name like :schStr or title_name like :schStr or p_desc like :schStr)");
		    param.put("schStr", Constant.PERCENT_SIGN+paramMap.get("schStr")+Constant.PERCENT_SIGN);
		}
	}
	sql.append(" order by sort_num");

	return super.getPageBySQL(sql.toString(), param);
    }
}
