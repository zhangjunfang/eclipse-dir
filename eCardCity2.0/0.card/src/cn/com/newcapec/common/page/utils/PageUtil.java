package cn.com.newcapec.common.page.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class PageUtil
{
	public static boolean isExceptParameter(String para)
	{
		List exceptParameterList = PageConfiger.getInstance().getExceptParameterList();
		return exceptParameterList != null && exceptParameterList.size() > 0 && exceptParameterList.contains(para);
	}

	HttpServletRequest request;

	Page page = null;

	private String url;
	private String parameter;
	private String uri;

	private String previousPageUrl;

	private String nextPageUrl;

	private String firstPageUrl;

	private String lastPageUrl;

	public PageUtil()
	{
	}

	public PageUtil(HttpServletRequest request)
	{
		this.request = request;
		this.parseUri();
	}

	public HttpServletRequest getRequest()
	{
		return request;
	}

	public void setRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	public String getParameter()
	{
		return parameter;
	}

	public void setParameter(String parameter)
	{
		this.parameter = parameter;
	}

	public String getUri()
	{
		return uri;
	}

	public void setUri(String uri)
	{
		this.uri = uri;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getFirstPageUrl()
	{
		return firstPageUrl;
	}

	public void setFirstPageUrl(String fpUrl)
	{
		this.firstPageUrl = fpUrl;
	}

	public String getLastPageUrl()
	{
		return lastPageUrl;
	}

	public void setLastPageUrl(String lpUrl)
	{
		this.lastPageUrl = lpUrl;
	}

	public String getNextPageUrl()
	{
		return nextPageUrl;
	}

	public void setNextPageUrl(String npUrl)
	{
		this.nextPageUrl = npUrl;
	}

	public String getPreviousPageUrl()
	{
		return previousPageUrl;
	}

	public void setPreviousPageUrl(String ppUrl)
	{
		this.previousPageUrl = ppUrl;
	}

	public Page getPage()
	{
		return page;
	}

	public void parseUri()
	{

		page = (Page) request.getAttribute(Page.PAGE_NAME_IN_REQUEST_ATTRIBUTE);
		if (page == null) 
			page = new PageImpl();
		this.previousPageUrl = page.getPreviousPageUrl();
		this.nextPageUrl = page.getNextPageUrl();
		this.firstPageUrl = page.getFirstPageUrl();
		this.lastPageUrl = page.getLastPageUrl();
	}
}
