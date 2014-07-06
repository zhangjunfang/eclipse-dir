package cn.com.newcapec.common.page.tags.pageLink;

import cn.com.newcapec.common.page.tags.base.PageTagBase;
import cn.com.newcapec.common.page.utils.Page;

import javax.servlet.jsp.JspException;
import java.io.IOException;

public class GotoPageSelectTag extends PageTagBase
{

	private static final long serialVersionUID = 1953718825216251605L;

	public int doStartTag() throws JspException
	{
		StringBuffer  selectHTML= new StringBuffer();
		try
		{
			selectHTML.append("<script type=\"text/javascript\">\n");
			selectHTML.append(("    var _pageNo=" + page.getCurrentPage() + ";\n"));
			selectHTML.append(("    document.write(\"<select id=\\\"_selectPage\\\" onchange=\\\"fGotoPage('"
					+ page.getPageUrlWithoutPageNo() + Page.PAGE_NO_PARAMETER_STRING + "='+this.value)\\\">\");\n"));
			selectHTML.append(("    for(var i=1;i<=" + page.getPageCount() + ";i++)\n"));
			selectHTML.append("    {\n");
			selectHTML.append("	      if(_pageNo==i)\n");
			selectHTML.append("		      document.write(\"<option value=\"+i+\" selected>\"+i+\"</option>\");\n");
			selectHTML.append("	      else\n");
			selectHTML.append("		      document.write(\"<option value=\"+i+\">\"+i+\"</option>\");\n");
			selectHTML.append("    }\n");
			selectHTML.append("    document.write(\"</select>\");\n");
			selectHTML.append("    \n");
			selectHTML.append("</script>");

			pageContext.getOut().write(selectHTML.toString());
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
		return EVAL_PAGE;
	}

}
