/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author wj
 * @category NSP产品平台提供的基础交互数据
 * @version 1.0
 * @date 2014年5月14日 下午1:37:30
 */
public class PlatformUsersData {
    /**
     * 产生用户表
     * 
     * @return	JSONArray	JSON格式的字符串数组
     */
    public static JSONArray getAllUsers(){
//	JSONObject json=new JSONObject();
//	String userStr="{\"users\":["
//		+ "{\"user_id\":\"11\",\"login_name\":\"zhangsan\",\"user_name\":\"张三\"},"
//		+ "{\"user_id\":\"22\",\"login_name\":\"lisi\",\"user_name\":\"李四\"},"
//		+ "{\"user_id\":\"33\",\"login_name\":\"wangwu\",\"user_name\":\"王五\"},"
//		+ "{\"user_id\":\"44\",\"login_name\":\"lixiaobai\",\"user_name\":\"李小白\"},"
//		+ "{\"user_id\":\"55\",\"login_name\":\"zhangzhicheng\",\"user_name\":\"张志成\"},"
//		+ "{\"user_id\":\"66\",\"login_name\":\"dalaohu\",\"user_name\":\"大老虎\"},"
//		+ "{\"user_id\":\"77\",\"login_name\":\"bisheng\",\"user_name\":\"毕昇\"},"
//		+ "{\"user_id\":\"88\",\"login_name\":\"panxia\",\"user_name\":\"潘霞\"},"
//		+ "{\"user_id\":\"99\",\"login_name\":\"simachangkong\",\"user_name\":\"司马长空\"},"
//		+ "{\"user_id\":\"1010\",\"login_name\":\"liuqing\",\"user_name\":\"刘青\"}]}";
//	return userStr;
	
	List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
	Map<String, Object> map=null;
	for(int i=1;i<21;i++){
	    map=new HashMap<String, Object>();
	    map.put("user_id", i);
	    map.put("login_name", "zhangsan"+i);
	    map.put("user_name", "张三"+i);
	    list.add(map);
	}
	return JSONArray.fromObject(list);
    }
    
    /**
     * 根据给定的user_id取得用户表的该JSONObject
     * 
     * @param	userID		用户ID
     * @return	JSONObject	JSON格式的字符串数组
     */
    public static JSONObject getUser(String userID){
	JSONArray arr=getAllUsers();
	JSONObject user=null;
	for(int i=0;i<arr.toArray().length;i++){
	    user=arr.getJSONObject(i);
	    if(user.getString("user_id").equals(userID)){
		return user;
	    }
	}
	return null;
    }
}
