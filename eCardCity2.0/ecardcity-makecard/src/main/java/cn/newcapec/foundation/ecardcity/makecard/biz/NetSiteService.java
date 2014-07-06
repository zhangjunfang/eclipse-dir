package cn.newcapec.foundation.ecardcity.makecard.biz;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.newcapec.foundation.ecardcity.makecard.model.Employee;
import cn.newcapec.foundation.ecardcity.makecard.model.NetSite;
import cn.newcapec.framework.core.biz.BaseService;
import cn.newcapec.framework.core.utils.pagesUtils.Page;

/**
 * 网点接口业务接口类
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:48:49
 * @version V1.0
 */
@SuppressWarnings("all")
public interface NetSiteService extends BaseService<NetSite> {


	/**
	 * 根据父节点查询子节点  
	 * @Description: TODO
	 * @param @param id
	 * @param @param orderby
	 * @param @return   
	 * @return Page    
	 * @throws
	 */
	public List<Map<String, Object>> queryByPid(String id,LinkedHashMap<String, String> orderby);

}
