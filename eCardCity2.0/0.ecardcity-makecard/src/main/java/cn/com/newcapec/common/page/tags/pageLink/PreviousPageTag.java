package cn.com.newcapec.common.page.tags.pageLink;

import cn.com.newcapec.common.page.tags.base.ForwardPageTagBase;

public class PreviousPageTag extends ForwardPageTagBase
{
	private static final long serialVersionUID = 7859168853169539277L;

	protected String getPageUrl()
	{
		if (page.getCurrentPage() == page.getPreviousPage()) 
			return null;
		return 
			this.pu.getPreviousPageUrl();
	}

}
