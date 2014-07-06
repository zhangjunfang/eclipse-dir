package cn.com.newcapec.common.page.tags.base;

import javax.servlet.jsp.JspException;
import java.io.IOException;

public abstract class PageInfoTagBase extends PageTagBase
{

	protected abstract Object getPageInfo();

	public int doEndTag() throws JspException
	{
		try
		{
			pageContext.getOut().write(getPageInfo().toString());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}
