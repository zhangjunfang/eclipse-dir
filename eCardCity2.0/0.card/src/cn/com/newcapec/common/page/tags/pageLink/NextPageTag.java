package cn.com.newcapec.common.page.tags.pageLink;

import cn.com.newcapec.common.page.tags.base.ForwardPageTagBase;

public class NextPageTag extends ForwardPageTagBase
{
	private static final long serialVersionUID = -13508501907139055L;

	protected String getPageUrl()
	{
		if (page.getCurrentPage() == page.getNextPage()) 
			return null;
		return 
			this.pu.getNextPageUrl();
	}

}
