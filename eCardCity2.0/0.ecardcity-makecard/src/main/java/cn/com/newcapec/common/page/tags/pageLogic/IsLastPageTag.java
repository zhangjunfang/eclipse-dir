package cn.com.newcapec.common.page.tags.pageLogic;

import cn.com.newcapec.common.page.tags.base.PageTagBase;

import javax.servlet.jsp.JspException;

public class IsLastPageTag extends PageTagBase
{
	private static final long serialVersionUID = 4519070981749578139L;

	public int doStartTag() throws JspException
	{
		if (this.page.getCurrentPage() == page.getLastPage()) 
			return EVAL_BODY_INCLUDE;
		return SKIP_BODY;
	}

	public int doAfterBody() throws JspException
	{
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException
	{
		return EVAL_PAGE;
	}

}
