/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.dao.base.BaseDao;
import cn.newcapec.function.ecardcity.om.model.NetSite;
import cn.newcapec.function.ecardcity.om.utils.Constant;

/**
 * @author wj
 * @category 网点操作DAO
 * @version 1.0
 * @date 2014年4月17日 下午2:35:41
 */
@Repository
public class NetSiteDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<NetSite> getReferenceClass() {
	return NetSite.class;
    }
    
    /**
     * 查询指定网点
     * @param key		ID
     * @return ParamLib		根据给定的ID返回对象
     */
    public NetSite get(Serializable key) {
	return (NetSite) get(getReferenceClass(), key);
    }
    
    /**
     * 批量删除
     * @param ids	ID数组
     */
    public void delete(String[] ids) {
	if (ids != null && ids.length > 0) {
	    bulkUpdate(true,"update NetSite set status='"+Constant.RECORD_DEL+"' where id in (:ids)", new String[]{"ids"},new Object[]{ids});
	}
    }
    
    /**
     * 根据map，查询指定的网点分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getPage(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select a.*,decode(a.netid_p,'0','',(select b.netname FROM net_site b where b.netid = a.netid_p)) p_name from net_site a where status='"+Constant.RECORD_DEL_NOT+"'");
	if (null != paramMap) {
	    	//网点ID
	    	if (paramMap.containsKey("netid") && StringUtils.isNotBlank(paramMap.get("netid").toString())) {
	    	    sql.append(" and a.netid=:netid ");
	    	    param.put("netid", paramMap.get("netid"));
	    	}
	    	//网点名称、网点简称
	    	if (paramMap.containsKey("netname") && StringUtils.isNotBlank(paramMap.get("netname").toString())) {
	    	    sql.append(" and (a.netname like :netname or a.netjp like :netname)");
	    	    param.put("netname", Constant.PERCENT_SIGN+paramMap.get("netname")+Constant.PERCENT_SIGN);
	    	}
	    	//网点种类：直属（网点），代理（商户）
		if (paramMap.containsKey("netkind") && StringUtils.isNotBlank(paramMap.get("netkind").toString())) {
		    sql.append(" and a.netkind = :netkind ");
		    param.put("netkind", paramMap.get("netkind"));
		}
	    	//网点状态
		if (paramMap.containsKey("netstatus") && StringUtils.isNotBlank(paramMap.get("netstatus").toString())) {
		    sql.append(" and a.netstatus = :netstatus ");
		    param.put("netstatus", paramMap.get("netstatus"));
		}
	    	//网点类型：充值网点，综合网点
		if (paramMap.containsKey("nettype") && StringUtils.isNotBlank(paramMap.get("nettype").toString())) {
		    sql.append(" and a.nettype = :nettype ");
		    param.put("nettype", paramMap.get("nettype"));
		}
		//联系人
		if (paramMap.containsKey("likeman") && StringUtils.isNotBlank(paramMap.get("likeman").toString())) {
		    sql.append(" and a.likeman=:likeman ");
		    param.put("likeman", paramMap.get("likeman"));
		}
	}
	sql.append(" order by sort_num asc");
	return super.getPageBySQL(sql.toString(), param);
    }
    
    /**
     * 指定根据行业编号查询当前网点该行业下的最大编号
     * 
     * @param industryCode	行业编号
     * @return Integer		当前最大的行业编码，没有返回0
     */
    public synchronized int getMaxNetSiteID(String industryCode) {
	BigDecimal rtn=(BigDecimal)super.sqlFindObject("select nvl(max(to_number(netid)),0) netid from net_site t where netid like ?",new Object[]{industryCode+Constant.PERCENT_SIGN});
	return rtn.intValue();
    }
}
