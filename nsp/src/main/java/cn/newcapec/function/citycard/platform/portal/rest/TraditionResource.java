package cn.newcapec.function.citycard.platform.portal.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.newcapec.framework.core.context.HttpNewcapecContextFactory;
import cn.newcapec.framework.core.context.Keys;
import cn.newcapec.framework.core.exception.BaseException;
import cn.newcapec.framework.core.model.BaseAccount;
import cn.newcapec.framework.core.rest.BaseRequest;
import cn.newcapec.framework.core.rest.BaseResponse;
import cn.newcapec.framework.core.utils.httpUtils.WebUtils;
import cn.newcapec.framework.core.utils.pagesUtils.SystemContext;
import cn.newcapec.function.citycard.platform.privilege.biz.MenuService;
import cn.newcapec.function.citycard.platform.privilege.biz.ResourceService;
import cn.newcapec.function.citycard.platform.privilege.model.Menu;

/**
 * 传统模式视图资源类
 * 
 * @author andy.li
 * 
 */

@Component
@Scope("prototype")
@SuppressWarnings("all")
public class TraditionResource extends PortalResource {
	private String index;
	

	public String getIndex() {
		
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	/* 资源业务类 */
	@Autowired
	private MenuService menuService;
	@Autowired
	private ResourceService resourceService;
	// 排序参数
	private LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();

	/**
	 * 首页
	 * 
	 * @param request
	 * @param response
	 */
	public void index(BaseRequest request, BaseResponse response) {
		String url = "/function/citycard/platform/portal/v1.0/tradition/pagelet/index.html";
		try {
			HttpSession session = WebUtils
					.getSession(request.getOrginRequest());
//			User user = (User) session.getAttribute("user");
			
			BaseAccount user = (BaseAccount)HttpNewcapecContextFactory.getContext(WebUtils.getRequests(request.getOrginRequest())).getAttribute(5, Keys.USER);
			
 			if (null != user) {
				SystemContext.setPagesize(Integer.MAX_VALUE);
				Map<String, Object> rootParams = new HashMap<String, Object>();
				rootParams.put("parent_id", -1);
				//获取用户的所有资源（缺少根菜单）
				String id =user.getOperatorId();
				List list  = resourceService.queryResorucesByUserid(id);
				if(!list.isEmpty()){
					Set set = new HashSet();
					for (int i = 0; i < list.size(); i++) {
						Iterator it = list.iterator();
						while (it.hasNext()) {
							Map map = (Map) it.next();
							for (Iterator<String> keys = map.keySet().iterator(); keys
							.hasNext();) {
								String key = (String) keys.next();
								if("MENU_ID".equals(key)){
									String value = map.get(key).toString();
									set.add("'" + value + "'");
								}
							}
						}
					}
					if(!set.isEmpty()){
						//获得所有登录用户的菜单信息
						List<Menu> menusList  = menuService.queryCascadeMenus(set.toArray(), orderby);
						//获取根节点
						List<Menu> rootMenu = new ArrayList();
						List<Menu> noRootMenu = new ArrayList();
						if(null!=menusList && menusList.size()>0){
							for(int i =0;i<menusList.size();i++){
								Menu menu = menusList.get(i);
								if(null!=menu && "-1".equals(menu.getParentId())){
									if(null!=rootMenu && rootMenu.size()>0){
										for(Menu menu2 : rootMenu){
											if(!menu2.getId().equals(menu.getId())){
												rootMenu.add(menu);
											}
										}
									}else{
										rootMenu.add(menu);
									}
								}else{
									noRootMenu.add(menu);
								}
							}
						}
				
						getNewcapectViewContext().put("rootMenu", rootMenu);
                        getNewcapectViewContext().put("noRootMenu", noRootMenu);
					}
				}
				response.toHtml(url, getNewcapectViewContext());
			}else{
				throw new BaseException("系统登录失败！");
			}

		} catch (Exception e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
			if (e instanceof BaseException) {
				throw (BaseException) e;
			} else {
				throw new BaseException("传统模式视图资源类不存在！", e);
			}
 		}
	}

}
