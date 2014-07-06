package cn.com.newcapec.citycard.picture.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import cn.com.newcapec.common.dao.impl.BaseDao;
import cn.com.newcapec.citycard.picture.dao.IPictureDao;

/**
 * <p>
 * 功能描述:图片关联设置Dao实现类
 *   
 * Author : Wangjian 
 * Date   : 2013-02-23
 * Time   : 22:25:15
 * Version: 1.0
 * </p>
 */

public class PictureDao extends BaseDao implements IPictureDao {
	// 信息，全部，只含有图片的记录
	public static final String PHARMACY_LIST_ALL = "SELECT tmp1.guid, tjbh, mc, xxdz, handtel, picurl FROM (SELECT guid, tjbh, mc, xxdz, handtel"
			+ " FROM s_gl_custom WHERE tjbh LIKE '0371%') AS tmp1 INNER JOIN t_picture ON tmp1.guid = t_picture.guid";
	// 信息
	public static final String PHARMACY_LIST = "SELECT tmp1.guid, tjbh, mc, xxdz, handtel, picurl FROM (SELECT guid, tjbh, mc, xxdz, handtel"
			+ " FROM s_gl_custom WHERE tjbh LIKE '0371%') AS tmp1 LEFT OUTER JOIN t_picture ON tmp1.guid = t_picture.guid WHERE "
			+ "tjbh LIKE ? OR mc LIKE ? OR xxdz LIKE ? OR handtel LIKE ?";
	// 信息，by guid
	public static final String PHARMACY = "SELECT guid, tjbh, mc, xxdz, handtel	FROM s_gl_custom WHERE guid=?";

	// 信息，全部，只含有图片的记录
	public static final String MEDICINE_LIST_ALL = "SELECT s_yw_kck.guid, hh, pm, gg + '/' + pdw AS gg, cd, lsj, c_cjdm, picurl, pzwh" +
			" FROM s_yw_kck INNER JOIN t_picture ON s_yw_kck.guid = t_picture.guid WHERE";
	// 信息，全部，只含有图片的记录，条件
	public static final String MEDICINE_LIST_ALL_CONDITION = " (pm LIKE ? OR cd LIKE ? OR c_sysm LIKE ? OR pzwh LIKE ?)";
	// 信息
	public static final String MEDICINE_LIST = "SELECT s_yw_kck.guid, hh, pm, gg + '/' + pdw AS gg, cd, lsj, c_cjdm, picurl,pzwh,indexpage,recommend FROM s_yw_kck"
			+ " LEFT OUTER JOIN t_picture ON s_yw_kck.guid = t_picture.guid WHERE";
	// 信息，条件
	public static final String MEDICINE_LIST_CONDITION = " (hh LIKE ? OR pm LIKE ? OR gg LIKE ? OR cd LIKE ? OR c_cjdm LIKE ? OR c_sysm LIKE ? OR pzwh LIKE ?)";
	// 信息，by guid
	public static final String MEDICINE = "SELECT guid, hh, pm, gg + '/' + pdw AS gg, cd, lsj, c_cjdm, c_sysm, pzwh	FROM s_yw_kck WHERE guid=?";

	/**
	 * 获取信息总数
	 * 
	 * @param schStr
	 *            检索条件
	 * @return Integer 记录总数
	 */
	public Integer getPharmacyCount(String schStr) {
		if (StringUtils.isNotBlank(schStr)) {
			schStr = "%" + schStr + "%";
			Object[] par = new Object[] { schStr, schStr, schStr, schStr };
			return (Integer) super.getObjectBySQL("SELECT COUNT(*) FROM ("
					+ PHARMACY_LIST + ") AS tmp11", par);
		} else {
			return 0;
		}
	}

	/**
	 * 获取信息
	 * 
	 * @param guid
	 *            标识ID
	 * @return Object[] 记录集
	 */
	public Object[] getPharmacy(String guid) {
		if (StringUtils.isNotBlank(guid)) {
			Object[] par = new Object[] { guid };
			return (Object[]) super.getObjectBySQL(PHARMACY, par);
		} else {
			return null;
		}
	}

	/**
	 * 获取信息列表
	 * 
	 * @param schStr
	 *            检索条件
	 * @param firstResult
	 *            从第几条开始
	 * @param maxResults
	 *            共取几条
	 * @return List 信息列表
	 */
	public List getPharmacyList(String schStr, int firstResult, int maxResults) {
		if (StringUtils.isNotBlank(schStr)) {
			schStr = "%" + schStr + "%";
			Object[] par = new Object[] { schStr, schStr, schStr, schStr };
			return super.getPaginationListBySQL(PHARMACY_LIST, par,
					firstResult, maxResults);
		} else {
			return null;
		}
	}

	/**
	 * 获取全部列表
	 * 
	 * @return Integer 记录总数
	 */
	public Integer getAllPharmacyCount() {
		return (Integer) super.getObjectBySQL("SELECT COUNT(*) FROM ("
				+ PHARMACY_LIST_ALL + ") AS tmp11");
	}
	
	/**
	 * 获取全部列表
	 * @param firstResult	从第几条开始
	 * @param maxResults	共取几条
	 * @return List 信息列表
	 */
	public List getAllPharmacyList(int firstResult, int maxResults) {
		if(firstResult==0&&maxResults==0){
			return super.getListBySQL(PHARMACY_LIST_ALL);
		}else{
			return super.getPaginationListBySQL(PHARMACY_LIST_ALL,null,firstResult, maxResults);
		}
	}
	
	/**
	 * 获取信息
	 * 
	 * @param guid
	 *            标识ID
	 * @return Object[] 记录集
	 */
	public Object[] getMedicine(String guid) {
		if (StringUtils.isNotBlank(guid)) {
			Object[] par = new Object[] { guid };
			return (Object[]) super.getObjectBySQL(MEDICINE, par);
		} else {
			return null;
		}
	}

	/**
	 * 获取总数
	 * 
	 * @param schStr
	 *            检索条件
	 * @return Integer 记录总数
	 */
	public Integer getMedicineCount(String schStr) {
		if (StringUtils.isNotBlank(schStr)) {
			String SQL=genMedicineSQL(schStr,MEDICINE_LIST,MEDICINE_LIST_CONDITION);
			Object[] par = genStringArgements(schStr, SQL);
			return (Integer) super.getObjectBySQL("SELECT COUNT(*) FROM ("
					+ SQL + ") AS tmp11", par);
		} else {
			return 0;
		}
	}

	/**
	 * 获取信息列表
	 * 
	 * @param schStr
	 *            检索条件
	 * @param firstResult
	 *            从第几条开始
	 * @param maxResults
	 *            共取几条
	 * @return List 信息列表
	 */
	public List getMedicineList(String schStr, int firstResult, int maxResults) {
		if (StringUtils.isNotBlank(schStr)) {
			
			String SQL=genMedicineSQL(schStr,MEDICINE_LIST,MEDICINE_LIST_CONDITION);
			Object[] par = genStringArgements(schStr, SQL);
			
			return super.getPaginationListBySQL(SQL, par,
					firstResult, maxResults);
		} else {
			return null;
		}
	}

	/**
	 * 获取符合条件的全部信息总数
	 * 
	 * @param schStr	检索条件
	 * @return Integer 	记录总数
	 */
	public Integer getAllMedicineCount(String schStr) {
		if (StringUtils.isNotBlank(schStr)) {
			
			String SQL=genMedicineSQL(schStr,MEDICINE_LIST_ALL,MEDICINE_LIST_ALL_CONDITION);
			Object[] par = genStringArgements(schStr, SQL);

			return (Integer) super.getObjectBySQL("SELECT COUNT(*) FROM ("
					+ SQL + ") AS tmp11", par);
		} else {
			return 0;
		}
	}
	
	/**
	 * 获取符合条件的全部信息
	 * 
	 * @param schStr 		检索条件
	 * @param firstResult	从第几条开始
	 * @param maxResults	共取几条
	 * @return List  		信息列表
	 */
	public List getAllMedicineList(String schStr, int firstResult, int maxResults) {
		if (StringUtils.isNotBlank(schStr)) {
			
			String SQL=genMedicineSQL(schStr,MEDICINE_LIST_ALL,MEDICINE_LIST_ALL_CONDITION);
			Object[] par = genStringArgements(schStr, SQL);

			return super.getPaginationListBySQL(SQL, par,
					firstResult, maxResults);
		} else {
			return null;
		}
	}
	
	/**
	 * <p>
	 * 功能描述：执行批量删除若干条图片记录
	 * @param cls 		持久化实体类
	 * @param guidList	guid集合
	 * @return
	 * </p>
	 */
	public void delPic(Class cls, List guidList) {
		String hql = "delete " + cls.getName() + " where guid in (:guidList)";
		String[] paraNames = new String[] { "guidList" };
		Object[] values = new Object[] { guidList };
		super.bulkUpdate(hql, paraNames, values);
	}
	
	/**
	 * <p>
	 * 功能描述：根据关键字生成SQL
	 * @param schStr 		查询关键字
	 * @param selStr		SELECT语句
	 * @param whereStr		WHERE条件
	 * @return
	 * </p>
	 */
	private static String genMedicineSQL(String schStr,String selStr,String whereStr){
		String[] keyWords=schStr.split("\\s");
		String rtnStr=selStr;
		for(int i=0;i<keyWords.length;i++){
			if(i>0){
				rtnStr+=" AND ";
			}
			rtnStr+=whereStr;
		}
		return rtnStr;
	}
	/**
	 * <p>
	 * 功能描述：	根据关键字及SQL生产参数数组
	 * @param 		schStr 		查询关键字
	 * @param 		sqlStr		完整SQL语句
	 * @return		Object[]
	 * </p>
	 */
	private static Object[] genStringArgements(String schStr, String sqlStr) {
		//关键字数组
		String[] keyWords=schStr.split("\\s");
		//每个where条件多少个参数
		int ctArg=StringUtils.countMatches(sqlStr, "?")/keyWords.length;
		//参数数组
		Object[] par = new Object[ctArg*keyWords.length];
		for(int i=0;i<keyWords.length;i++){
			for(int j=i*ctArg;j<(i+1)*ctArg;j++){
				par[j]="%"+keyWords[i]+"%";
			}
		}
		return par;
	}

}
