package cn.com.newcapec.common.page.tags.pageInfo;

import cn.com.newcapec.common.page.tags.base.PageInfoTagBase;

public class PageListNumTag extends PageInfoTagBase
{

	private static final long serialVersionUID = -2354742751842418173L;

	protected Object getPageInfo()
	{
		return page.getPageListNum();
	}

}
