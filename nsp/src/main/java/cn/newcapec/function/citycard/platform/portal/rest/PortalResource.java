package cn.newcapec.function.citycard.platform.portal.rest;


import cn.newcapec.framework.core.rest.BaseResource;
import cn.newcapec.framework.core.rest.BaseResourceHandler;
import cn.newcapec.framework.core.rest.BaseResponse;
import cn.newcapec.framework.core.rest.velocity.TemplateEngine;
import cn.newcapec.framework.core.utils.pagesUtils.Page;
import org.apache.velocity.VelocityContext;
import org.restlet.data.CharacterSet;
import org.restlet.data.MediaType;
import org.restlet.resource.StringRepresentation;

import java.util.List;
import java.util.Map;

/**
 * 门户集成基础视图类
 * @author andy.li
 *
 */
@SuppressWarnings("all")
public class PortalResource extends BaseResource implements BaseResourceHandler {
	
	
	//page分页查询类
	protected Page<List<Map<String, Object>>> page = new Page();


}
