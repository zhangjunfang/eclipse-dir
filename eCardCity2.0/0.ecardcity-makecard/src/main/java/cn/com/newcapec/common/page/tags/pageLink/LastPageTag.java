package cn.com.newcapec.common.page.tags.pageLink;

import cn.com.newcapec.common.page.tags.base.ForwardPageTagBase;

public class LastPageTag extends ForwardPageTagBase
{
	private static final long serialVersionUID = 6066425717008290134L;

	protected String getPageUrl()
	{
		if (page.getCurrentPage() == page.getLastPage()) 
			return null;
		return 
			this.pu.getLastPageUrl();
	}

}
