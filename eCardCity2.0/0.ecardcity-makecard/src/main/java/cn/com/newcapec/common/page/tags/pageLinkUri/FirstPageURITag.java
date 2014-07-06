package cn.com.newcapec.common.page.tags.pageLinkUri;

import cn.com.newcapec.common.page.tags.base.PageInfoTagBase;

public class FirstPageURITag extends PageInfoTagBase
{

	private static final long serialVersionUID = 5208101788936782345L;

	protected Object getPageInfo()
	{
		return pu.getFirstPageUrl();
	}

}
