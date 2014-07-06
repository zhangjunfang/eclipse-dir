package cn.com.newcapec.common.page.tags.pageLogic;

import cn.com.newcapec.common.page.tags.base.PageTagBase;

import javax.servlet.jsp.JspException;

public class IsNotFirstPageTag extends PageTagBase
{
	private static final long serialVersionUID = 7943819825404356830L;

	public int doStartTag() throws JspException
	{
		if (this.page.getCurrentPage() > 1) 
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
