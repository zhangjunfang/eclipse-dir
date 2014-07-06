package cn.newcapec.foundation.ecardcity.makecard.biz;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.newcapec.foundation.ecardcity.makecard.model.Employee;
import cn.newcapec.framework.core.biz.BaseService;

/**
 * 职员接口业务接口类
 * @Description: TODO
 * @author  高崇飞
 * @date 2014-4-21 下午03:48:49
 * @version V1.0
 */
public interface EmployeeService extends BaseService<Employee> {

	
	/**
	 * 根据 网点id 查询操作员
	 * @Description: TODO
	 * @param @param id
	 * @param @param orderby
	 * @param @return   
	 * @return Page    
	 * @throws
	 */
	public List<Map<String, Object>> queryByNetsiteId(String id,
			LinkedHashMap<String, String> orderby);

}
