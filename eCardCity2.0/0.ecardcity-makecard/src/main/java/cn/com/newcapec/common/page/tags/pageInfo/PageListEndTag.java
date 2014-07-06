package cn.com.newcapec.common.page.tags.pageInfo;

import cn.com.newcapec.common.page.tags.base.PageInfoTagBase;

public class PageListEndTag extends PageInfoTagBase
{
	private static final long serialVersionUID = -186678037853861630L;

	protected Object getPageInfo()
	{
		return page.getFirstResult() + page.getCurrentPageListNum() - 1;
	}
}
