package cn.newcapec.function.citycard.platform.privilege.biz;

import cn.newcapec.function.citycard.platform.privilege.model.UserRole;
import cn.newcapec.framework.core.biz.BaseService;
import cn.newcapec.framework.core.utils.pagesUtils.Page;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("all")
public interface UserRoleService extends BaseService<UserRole> {
	
	public Page queryUserRoles(Map<String, Object> params, LinkedHashMap<String, String> orderby) ;

}
