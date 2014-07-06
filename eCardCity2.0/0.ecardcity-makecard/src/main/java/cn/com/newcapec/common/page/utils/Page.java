package cn.com.newcapec.common.page.utils;

public interface Page
{

	public static final String PAGE_NO_PARAMETER_STRING = "_pageNo";

	public static final String PAGE_NAME_IN_REQUEST_ATTRIBUTE = "_PAGEOBJECT";

	public void account();

	public int getCurrentPage();

	public void setCurrentPage(int currentPage);

	public int getListCount();

	public void setListCount(int listCount);

	public int getPageCount();

	public void setPageCount(int pageCount);

	public int getPageListNum();

	public void setPageListNum(int pageListNum);

	public int getCurrentPageListNum();

	public void setCurrentPageListNum(int currentPageListNum);

	public int getFirstPage();

	public void setFirstPage(int firstPage);

	public int getLastPage();

	public void setLastPage(int lastPage);

	public int getNextPage();

	public void setNextPage(int nextPage);

	public int getPreviousPage();

	public void setPreviousPage(int previousPage);

	public int getFirstResult();

	public void setFirstResult(int firstResult);

	public String getRequestURI();

	public void setRequestURI(String requestUri);

	public String getFirstPageUrl();

	public void setFirstPageUrl(String fpUrl);

	public String getLastPageUrl();

	public void setLastPageUrl(String lpUrl);

	public String getNextPageUrl();

	public void setNextPageUrl(String npUrl);

	public String getPreviousPageUrl();

	public void setPreviousPageUrl(String ppUrl);

	public String getPageUrlWithoutPageNo();

	public void setPageUrlWithoutPageNo(String url);

}