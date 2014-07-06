package cn.com.newcapec.common.page.tags.base;

import javax.servlet.jsp.JspException;
import java.io.IOException;

public abstract class ForwardPageTagBase extends PageTagBase
{
	protected abstract String getPageUrl();

	public int doStartTag() throws JspException
	{
		try
		{
			if (getPageUrl() != null) 
				pageContext.getOut().write("<a href=\"javascript:fGotoPage('" + getPageUrl() + "')\">");
			else 
				pageContext.getOut().write("<a>");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException
	{
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException
	{
		try
		{
			pageContext.getOut().write("</a>");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
