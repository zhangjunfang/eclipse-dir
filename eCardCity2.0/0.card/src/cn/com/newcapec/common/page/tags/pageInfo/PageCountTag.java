package cn.com.newcapec.common.page.tags.pageInfo;

import cn.com.newcapec.common.page.tags.base.PageInfoTagBase;

public class PageCountTag extends PageInfoTagBase
{

	private static final long serialVersionUID = -8810697807054181232L;

	protected Object getPageInfo()
	{
		return page.getPageCount();
	}

}
