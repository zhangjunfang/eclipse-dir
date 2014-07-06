package cn.com.newcapec.common.page.tags.pageLinkUri;

import cn.com.newcapec.common.page.tags.base.PageInfoTagBase;

public class NextPageURITag extends PageInfoTagBase
{
	private static final long serialVersionUID = 5695679532763154035L;

	protected Object getPageInfo()
	{
		return pu.getNextPageUrl();
	}

}
