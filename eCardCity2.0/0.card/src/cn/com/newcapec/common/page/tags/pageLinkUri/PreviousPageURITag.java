package cn.com.newcapec.common.page.tags.pageLinkUri;

import cn.com.newcapec.common.page.tags.base.PageInfoTagBase;

public class PreviousPageURITag extends PageInfoTagBase
{

	private static final long serialVersionUID = -1704110104500699390L;

	protected Object getPageInfo()
	{
		return pu.getPreviousPageUrl();
	}

}
