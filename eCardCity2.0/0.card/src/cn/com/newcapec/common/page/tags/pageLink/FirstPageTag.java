package cn.com.newcapec.common.page.tags.pageLink;

import cn.com.newcapec.common.page.tags.base.ForwardPageTagBase;

public class FirstPageTag extends ForwardPageTagBase
{

	private static final long serialVersionUID = -3628640703715307757L;

	protected String getPageUrl()
	{
		if (page.getCurrentPage() == page.getFirstPage()) 
			return null;
		return 
			this.pu.getFirstPageUrl();
	}

}
