package cn.com.newcapec.common.page.tags.pageInfo;

import cn.com.newcapec.common.page.tags.base.PageInfoTagBase;

public class CurrentPageNumTag extends PageInfoTagBase
{
	private static final long serialVersionUID = -1203096562257106899L;

	protected Object getPageInfo()
	{
		return page.getCurrentPage();
	}

}
