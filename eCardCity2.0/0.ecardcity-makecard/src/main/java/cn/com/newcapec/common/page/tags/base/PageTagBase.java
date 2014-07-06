package cn.com.newcapec.common.page.tags.base;

import cn.com.newcapec.common.page.utils.Page;
import cn.com.newcapec.common.page.utils.PageUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class PageTagBase extends BodyTagSupport
{
	private static final long serialVersionUID = 7716076810363817137L;

	protected PageUtil pu;

	protected Page page;

	public void setPageContext(PageContext pageContext)
	{
		super.setPageContext(pageContext);
		pu = new PageUtil((HttpServletRequest) pageContext.getRequest());
		page = pu.getPage();
	}

	public int doAfterBody() throws JspException
	{
		return super.doAfterBody();
	}

	public int doEndTag() throws JspException
	{
		return super.doEndTag();
	}

	public int doStartTag() throws JspException
	{
		return super.doStartTag();
	}

}
