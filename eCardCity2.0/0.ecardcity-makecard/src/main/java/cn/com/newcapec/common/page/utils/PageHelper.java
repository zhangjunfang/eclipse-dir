package cn.com.newcapec.common.page.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;


public class PageHelper
{

	public static Page getPage(HttpServletRequest request, int listCount, int pageNo, int pageListNum)
	{
		PageImpl page = new PageImpl();
		page.setListCount(listCount);
		page.setCurrentPage(pageNo);
		if (pageListNum <= 0)
		{
			pageListNum = PageConfiger.getInstance().getPageListNum();
		}
		page.setPageListNum(pageListNum);
		page.account();
		page.setRequestURI(request.getRequestURI());
		request.setAttribute(Page.PAGE_NAME_IN_REQUEST_ATTRIBUTE, page);
		parseUri(request, page);
		return page;
	}

	public static Page getPage(HttpServletRequest request, int listCount, int pageListNum)
	{
		String sPageNo = request.getParameter(Page.PAGE_NO_PARAMETER_STRING);
		Integer oPageNo = null;
		if (sPageNo != null && !sPageNo.equals(""))
		{
			try
			{
				oPageNo = Integer.valueOf(sPageNo);
			}
			catch (NumberFormatException e)
			{
				oPageNo =null;
			}
		}
		if (oPageNo != null) return getPage(request, listCount, oPageNo, pageListNum);
		return getPage(request, listCount, 0, pageListNum);
	}

	private static void parseUri(HttpServletRequest request, Page page)
	{
		page = (Page) request.getAttribute(Page.PAGE_NAME_IN_REQUEST_ATTRIBUTE);
		String uri = page.getRequestURI();
		StringBuffer paraStr = new StringBuffer();
		Map paras = request.getParameterMap();
		Set set = paras.keySet();
		for (Object obj:set)
		{
			String para = (String) obj;
			if (para != null && !para.equals(Page.PAGE_NO_PARAMETER_STRING) && !PageUtil.isExceptParameter(para))
			{
				paraStr.append(para);
				paraStr.append("=");
				paraStr.append(request.getParameter(para));
				paraStr.append("&");
			}
		}
		page.setPreviousPageUrl(uri + "?" + paraStr.toString() + Page.PAGE_NO_PARAMETER_STRING + "="
				+ page.getPreviousPage());
		page.setNextPageUrl(uri + "?" + paraStr.toString() + Page.PAGE_NO_PARAMETER_STRING + "=" + page.getNextPage());
		page.setFirstPageUrl(uri + "?" + paraStr.toString() + Page.PAGE_NO_PARAMETER_STRING + "="
						+ page.getFirstPage());
		page.setLastPageUrl(uri + "?" + paraStr.toString() + Page.PAGE_NO_PARAMETER_STRING + "=" + page.getLastPage());

		page.setPageUrlWithoutPageNo(uri + "?" + paraStr.toString());

	}


	protected static String getUrl(HttpServletRequest request)
	{

		StringBuffer paraStr = new StringBuffer();
		Map paras = request.getParameterMap();

		Set set = paras.keySet();
		for (Object obj:set)
		{
			String para = (String) obj;
			if (para != null && !para.equals(Page.PAGE_NO_PARAMETER_STRING) && !PageUtil.isExceptParameter(para))
			{
				paraStr.append(para);
				paraStr.append("=");
				paraStr.append(request.getParameter(para));
				paraStr.append("&");
			}
		}
		return request.getRequestURI() + "?" + paraStr.toString();
	}

}
