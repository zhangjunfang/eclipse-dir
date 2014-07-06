package cn.com.newcapec.common.page.tags.pageInfo;

import cn.com.newcapec.common.page.tags.base.PageInfoTagBase;

public class ListCountTag extends PageInfoTagBase
{

	private static final long serialVersionUID = -8137360089485245675L;

	protected Object getPageInfo()
	{
		return page.getListCount();
	}

}
