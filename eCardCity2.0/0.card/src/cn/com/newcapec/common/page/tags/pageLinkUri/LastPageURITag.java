package cn.com.newcapec.common.page.tags.pageLinkUri;

import cn.com.newcapec.common.page.tags.base.PageInfoTagBase;

public class LastPageURITag extends PageInfoTagBase
{
	private static final long serialVersionUID = 6351487725313687548L;

	protected Object getPageInfo()
	{
		return pu.getLastPageUrl();
	}

}
