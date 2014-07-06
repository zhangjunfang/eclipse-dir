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
import cn.newcapec.function.ecardcity.om.model.BaseIndustry;
import cn.newcapec.function.ecardcity.om.utils.Constant;

/**
 * @author wj
 * @category 基础行业操作DAO
 * @version 1.0
 * @date 2014年5月4日 下午5:35:41
 */
@Repository
public class BaseIndustryDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<BaseIndustry> getReferenceClass() {
	return BaseIndustry.class;
    }
    
    /**
     * 查询指定网点
     * @param key		ID
     * @return ParamLib		根据给定的ID返回对象
     */
    public BaseIndustry get(Serializable key) {
	return (BaseIndustry) get(getReferenceClass(), key);
    }
    
    /**
     * 批量删除
     * @param ids	ID数组
     */
    public void delete(String[] ids) {
	if (ids != null && ids.length > 0) {
	    bulkUpdate(true,"delete from BaseIndustry where id in (:ids)", new String[]{"ids"},new Object[]{ids});
	}
    }
    
    /**
     * 根据map，查询指定的基础行业分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getPageList(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select a.*,nvl2(a.industry_p,(select b.industryname FROM base_industry b where b.industrycode = a.industry_p),'') industry_p_name from base_industry a where 1=1");
	if (null != paramMap) {
		if (paramMap.containsKey("industrycode") && StringUtils.isNotBlank(paramMap.get("industrycode").toString())) {
		    sql.append(" and a.industrycode = :industrycode");
		    param.put("industrycode", paramMap.get("industrycode"));
		}
		if (paramMap.containsKey("industryname") && StringUtils.isNotBlank(paramMap.get("industryname").toString())) {
		    sql.append(" and (a.industryname like :industryname or a.jpdm like :industryname)");
		    param.put("industryname", Constant.PERCENT_SIGN+paramMap.get("industryname")+Constant.PERCENT_SIGN);
		}
	}
	sql.append(" order by a.industrycode asc");
	return super.getPageBySQL(sql.toString(), param);
    }    
}
