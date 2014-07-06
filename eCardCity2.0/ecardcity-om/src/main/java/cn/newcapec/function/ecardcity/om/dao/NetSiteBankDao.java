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
import cn.newcapec.function.ecardcity.om.model.NetSiteBank;
import cn.newcapec.function.ecardcity.om.utils.Constant;

/**
 * @author wj
 * @category 网点账号操作DAO
 * @version 1.0
 * @date 2014年5月12日 下午2:35:41
 */
@Repository
public class NetSiteBankDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<NetSiteBank> getReferenceClass() {
	return NetSiteBank.class;
    }
    
    /**
     * 查询指定网点账号
     * @param key		ID
     * @return ParamLib		根据给定的ID返回对象
     */
    public NetSiteBank get(Serializable key) {
	return (NetSiteBank) get(getReferenceClass(), key);
    }
    
    /**
     * 批量删除
     * @param ids	ID数组
     */
    public void delete(String[] ids) {
	if (ids != null && ids.length > 0) {
	    bulkUpdate(true,"delete from NetSiteBank where id in (:ids)", new String[]{"ids"},new Object[]{ids});
	}
    }
    
    /**
     * 根据map，查询指定的网点账号分页
     * @param  paramMap	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getPage(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select a.*,b.netname from net_site_bank a,net_site b where a.netsiteid=b.id and b.status='"+Constant.RECORD_DEL_NOT+"'");
	if (null != paramMap) {
	    	//网点ID
	    	if (paramMap.containsKey("netsiteid") && StringUtils.isNotBlank(paramMap.get("netsiteid").toString())) {
	    	    sql.append(" and b.id=:netsiteid ");
	    	    param.put("netsiteid", paramMap.get("netsiteid"));
	    	}
	    	//网点账号银行
		if (paramMap.containsKey("bankname") && StringUtils.isNotBlank(paramMap.get("bankname").toString())) {
		    sql.append(" and a.bankname = :bankname ");
		    param.put("bankname", paramMap.get("bankname"));
		}
	}
	sql.append(" order by a.edit_date desc");
	return super.getPageBySQL(sql.toString(), param);
    }
    
    /**
     * 根据网点ID，查询可用的网点账号
     * @param netSiteId	 	网点ID
     * @return List 		可用的网点账号列表
     */
    public List getListByNetSiteID(String netSiteId) {
	StringBuilder sql = new StringBuilder("select a.id,a.bankname,a.open_account,nvl(a.transfer_account,' ') transfer_account from net_site_bank a");
	sql.append(" where a.netsiteid=? and a.public_account=?");
	return super.sqlQueryForList(sql.toString(), new Object[]{netSiteId,Constant.NETSITE_BANK_PUBLIC_ACCOUNT_NOT}, null);
    }    
}
