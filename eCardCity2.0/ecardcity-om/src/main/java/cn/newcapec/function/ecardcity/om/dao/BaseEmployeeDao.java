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
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.dao.base.BaseDao;
import cn.newcapec.function.ecardcity.om.model.BaseEmployee;
import cn.newcapec.function.ecardcity.om.utils.Constant;

/**
 * @author wj
 * @category 网点操作员操作DAO
 * @version 1.0
 * @date 2014年5月12日 下午2:35:41
 */
@Repository
public class BaseEmployeeDao extends BaseDao {
    /* (non-Javadoc)
     * @see cn.newcapec.framework.core.dao.hibernate.HibernateEntityDao#getReferenceClass()
     */
    @Override
    protected Class<BaseEmployee> getReferenceClass() {
	return BaseEmployee.class;
    }
    
    /**
     * 查询指定操作员
     * @param key		ID
     * @return ParamLib		根据给定的ID返回对象
     */
    public BaseEmployee get(Serializable key) {
	return (BaseEmployee) get(getReferenceClass(), key);
    }
    
    /**
     * 批量删除
     * @param ids	ID数组
     */
    public void delete(String[] ids) {
	if (ids != null && ids.length > 0) {
	    bulkUpdate(true,"update BaseEmployee set status='"+Constant.RECORD_DEL+"' where id in (:ids)", new String[]{"ids"},new Object[]{ids});
	}
    }
    
    /**
     * 根据map，查询指定的操作员分页
     * @param param	 	参数Map
     * @return Page 		根据给定的map返回列表
     */
    public Page<?> getPage(Map<String, Object> paramMap) {
	Map<String, Object> param = new HashMap<String, Object>();
	StringBuilder sql = new StringBuilder("select a.*,b.netname,c.bankname,c.open_account,c.transfer_account"
		+ " from base_employee a, net_site b, net_site_bank c"
		+ " where a.status='"+Constant.RECORD_DEL_NOT+"' and a.netsite_id=b.id and a.bank_id=c.id and b.status='"+Constant.RECORD_DEL_NOT+"'");
	if (null != paramMap) {
	    //网点ID
	    if (paramMap.containsKey("netsite_id") && StringUtils.isNotBlank(paramMap.get("netsite_id").toString())) {
		sql.append(" and a.netsite_id=:netsite_id ");
		param.put("netsite_id", paramMap.get("netsite_id"));
	    }
	}
	sql.append(" order by a.netsite_id,a.empid desc");
	return super.getPageBySQL(sql.toString(), param);
    }

    /**
     * 查询是否有操作员，根据网点账号
     * @param bankId		网点账号
     * @return ParamLib		是否有该网点的操作员
     */
    public boolean getByNetbank(Serializable bankId) {
	Map<String, Object> attrMap=new HashMap<String, Object>();
	attrMap.put("bank_id", bankId);
	return super.getListByAttr(attrMap, BaseEmployee.class, null).size()>0;
    }

    /**
     * 根据给定的JSON格式用户表，排除操作员表中已经存在的用户
     * @param users		JSON格式的用户数组
     * @return JSONArray	排除操作员表中已存在用户后的JSON格式的用户数组
     */
    public JSONArray getUsersFliterEployee(JSONArray users) {
	//获取当前已用的操作员用户
	StringBuilder sql = new StringBuilder("select user_id from base_employee");
	List<Map<String,Object>> list=(List<Map<String,Object>>)super.sqlQueryForList(sql.toString(), null, null);
	
	JSONObject user=null;
	for(int i=0;i<users.toArray().length;i++){
	    user=users.getJSONObject(i);
	    for(Map<String,Object> map:list){
		if(user.getString("user_id").equals(map.get("USER_ID"))){
		    users.remove(i);
		    break;
		}
	    }
	}
	return users;
    }
    
    /**
     * 查询的最大empID
     * 
     * @return Integer		当前最大的empID
     */
    public synchronized int getMaxEmpID() {
	BigDecimal rtn=(BigDecimal)super.sqlFindObject("select nvl(max(to_number(empid)),0) empid from base_employee",null);
	return rtn.intValue();
    }
}
