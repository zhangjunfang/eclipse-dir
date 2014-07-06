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
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.dao.base.BaseDao;
import cn.newcapec.function.ecardcity.om.model.DictCategory;
import cn.newcapec.function.ecardcity.om.model.Param;
import cn.newcapec.function.ecardcity.om.utils.Constant;

/**
 * @author wj
 * @category 参数DAO
 * @version 1.0
 * @date 2014年4月3日 上午10:15:41
 */
@Repository
@SuppressWarnings("all")
public class ParamDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<Param> getReferenceClass() {
	return Param.class;
    }
    
    /**
     * 查询指定部门
     * @param key		ID
     * @return Param		根据给定的ID返回对象
     */
    public Param get(java.io.Serializable key) {
	return (Param) get(getReferenceClass(), key);
    }
    
    /**
     * 根据map，查询指定的参数分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page getSysParamPage(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select * from base_param where allow_visible='1' and (cardtype='' or cardtype is null)");
	if (null != paramMap) {
	    //参数类型
	    if (paramMap.containsKey("p_group") && StringUtils.isNotBlank(paramMap.get("p_group").toString())) {
		String[] paraArr = paramMap.get("p_group").toString().split(",");
		sql.append(" and p_group in (:p_group)");
		param.put("p_group", paraArr);
	    }

	    if (paramMap.containsKey("schStr") && StringUtils.isNotBlank(paramMap.get("schStr").toString())) {
		sql.append(" and (p_name like :schStr or title_name like :schStr or p_desc like :schStr)");
		param.put("schStr", Constant.PERCENT_SIGN+paramMap.get("schStr")+Constant.PERCENT_SIGN);
	    }
	}
	sql.append(" order by sort_num");
	return super.getPageBySQL(sql.toString(), param);
    }
    
    /**
     * 根据map，查询指定的参数分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page getCardParamPage(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select * from base_param where allow_visible='1' and (p_group='' or p_group is null)");
	if (null != paramMap) {
	    //卡类型
	    if (paramMap.containsKey("cardtype") && StringUtils.isNotBlank(paramMap.get("cardtype").toString())) {
		String[] paraArr = paramMap.get("cardtype").toString().split(",");
		sql.append(" and cardtype in (:cardtype)");
		param.put("cardtype", paraArr);
	    }

	    if (paramMap.containsKey("schStr") && StringUtils.isNotBlank(paramMap.get("schStr").toString())) {
		sql.append(" and (p_name like :schStr or title_name like :schStr or p_desc like :schStr)");
		param.put("schStr", Constant.PERCENT_SIGN+paramMap.get("schStr")+Constant.PERCENT_SIGN);
	    }
	}
	sql.append(" order by sort_num");
	return super.getPageBySQL(sql.toString(), param);
    }
    
    /**
     * 根据给定的类型返回参数列表
     * 
     * @param type		卡类型ID号
     * @return List
     */
    public List getPramListByType(String type) {
	Map<String, Object> param = new HashMap<String, Object>();
	param.put("allow_visible","1");
	param.put("p_group",type);
	return super.getListByAttr(param, Param.class, new Order[]{Order.asc("sort_num")});	
    }
    /**
     * 根据给定的方式进行卡类型参数初始化
     * 
     * @param id		卡类型ID号
     * @param flag		方式，1:从模板，2:从已有卡
     * @param sourceParamId	模板ID，或已有卡类型ID
     * @return Boolean
     */
    public boolean cardParamsInit(Serializable id,String flag,String sourceParamId) {
	StringBuilder sql=new StringBuilder("insert into base_param (id,cardtype,p_group,p_name,p_value,p_value_type,p_code,title_name,p_desc,allow_edit,allow_visible,sort_num,notes,ver)");
	if(flag.equals("1")){//从模板
	    sql.append(" (select lower(rawtohex(sys_guid())),:id,'',p_name,p_value,p_value_type,p_code,title_name,p_desc,allow_edit,allow_visible,sort_num,notes,ver from base_param_lib where p_lib_group=:sourceParamId)");
	}else{//从已有卡
	    sql.append(" (select lower(rawtohex(sys_guid())),:id,'',p_name,p_value,p_value_type,p_code,title_name,p_desc,allow_edit,allow_visible,sort_num,notes,ver from base_param where cardtype=:sourceParamId)");
	}
	return super.bulkUpdate(false,sql.toString(), new String[]{"id","sourceParamId"},new Object[]{id,sourceParamId})>0;
    }
}
