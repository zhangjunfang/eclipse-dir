package cn.com.newcapec.common.page.tags.pageInfo;

import cn.com.newcapec.common.page.tags.base.PageInfoTagBase;

public class PageListStartTag extends PageInfoTagBase
{
	private static final long serialVersionUID = -3756122918969594896L;

	protected Object getPageInfo()
	{
		return page.getFirstResult();
	}

}
