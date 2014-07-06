package cn.com.newcapec.common.page.utils;


public class PageImpl implements Page
{
	private int listCount = 0;

	private int pageListNum = 10;

	private int pageCount = 0;

	private int currentPage = 0;

	private int currentPageListNum = 0;

	private int firstPage = 0;

	private int previousPage = 0;

	private int nextPage = 0;

	private int lastPage = 0;

	private int firstResult = 0;

	private String requestURI = null;

	private String previousPageUrl;

	private String nextPageUrl;

	private String firstPageUrl;

	private String lastPageUrl;

	private String pageUrlWithoutPageNo;

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getListCount()
	{
		return listCount;
	}

	public void setListCount(int listCount)
	{
		this.listCount = listCount;
	}

	public int getPageCount()
	{
		return pageCount;
	}

	public void setPageCount(int pageCount)
	{
		this.pageCount = pageCount;
	}

	public int getPageListNum()
	{
		return pageListNum;
	}

	public void setPageListNum(int pageListNum)
	{
		this.pageListNum = pageListNum;
	}

	public int getCurrentPageListNum()
	{
		return currentPageListNum;
	}

	public void setCurrentPageListNum(int currentPageListNum)
	{
		this.currentPageListNum = currentPageListNum;
	}

	public int getFirstPage()
	{
		return firstPage;
	}

	public void setFirstPage(int firstPage)
	{
		this.firstPage = firstPage;
	}

	public int getLastPage()
	{
		return lastPage;
	}

	public void setLastPage(int lastPage)
	{
		this.lastPage = lastPage;
	}

	public int getNextPage()
	{
		return nextPage;
	}

	public void setNextPage(int nextPage)
	{
		this.nextPage = nextPage;
	}

	public int getPreviousPage()
	{
		return previousPage;
	}

	public void setPreviousPage(int previousPage)
	{
		this.previousPage = previousPage;
	}

	public int getFirstResult()
	{
		return firstResult;
	}

	public void setFirstResult(int firstResult)
	{
		this.firstResult = firstResult;
	}

	public String getRequestURI()
	{
		return requestURI;
	}

	public void setRequestURI(String requestURI)
	{
		this.requestURI = requestURI;
	}

	public String getFirstPageUrl()
	{
		return firstPageUrl;
	}

	public void setFirstPageUrl(String firstPageUrl)
	{
		this.firstPageUrl = firstPageUrl;
	}

	public String getLastPageUrl()
	{
		return lastPageUrl;
	}

	public void setLastPageUrl(String lastPageUrl)
	{
		this.lastPageUrl = lastPageUrl;
	}

	public String getNextPageUrl()
	{
		return nextPageUrl;
	}

	public void setNextPageUrl(String nextPageUrl)
	{
		this.nextPageUrl = nextPageUrl;
	}

	public String getPreviousPageUrl()
	{
		return previousPageUrl;
	}

	public void setPreviousPageUrl(String previousPageUrl)
	{
		this.previousPageUrl = previousPageUrl;
	}

	public String getPageUrlWithoutPageNo()
	{
		return pageUrlWithoutPageNo;
	}

	public void setPageUrlWithoutPageNo(String pageUrlWithoutPageNo)
	{
		this.pageUrlWithoutPageNo = pageUrlWithoutPageNo;
	}

	public void account()
	{
		if (this.pageListNum <= 0)
		{
			this.pageListNum = 20;
		}
		int t0PageCount = (this.listCount / this.pageListNum);
		int tPageCount = t0PageCount;
		int tCountLost = (this.listCount % this.pageListNum);
		if (tPageCount == 0)
		{
			tPageCount = 1;
		}
		if (tCountLost > 0)
		{
			if (t0PageCount > 0) tPageCount += 1;
		}
		this.pageCount = tPageCount;
		if (this.currentPage < 1) this.currentPage = 1;
		if (this.currentPage > this.pageCount) this.currentPage = this.pageCount;
		if (this.currentPage == tPageCount && tCountLost > 0)
		{
			this.currentPageListNum = tCountLost;
		}
		else
		{
			this.currentPageListNum = this.pageListNum;
		}
		this.firstResult = (this.currentPage - 1) * this.pageListNum + 1;
		this.firstPage = 1;
		this.lastPage = this.pageCount;
		this.previousPage = this.currentPage - 1;
		this.nextPage = this.currentPage + 1;
		if (this.previousPage < this.firstPage) this.previousPage = this.firstPage;
		if (this.nextPage > this.lastPage) this.nextPage = this.lastPage;

	}

}
