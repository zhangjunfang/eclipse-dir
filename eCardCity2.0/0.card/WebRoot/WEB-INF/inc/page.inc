<%--
  功能描述 ：分页标签
  
  Author : WangJian
  Date   : 2008-05-09
  Time   : 14:49:27
  Version: 1.0
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="page" uri="/page-tag"%>
<script type="text/javascript" src="${path}/common/js/form.js"></script>
<div align="right" style="height: 25px;">
	(第<page:currentPageNum />/<page:pageCount />页&nbsp;共<page:listCount />条)
	<page:isNotFirstPage>
		<page:firstPage>第一页</page:firstPage>
		<page:previousPage>上一页</page:previousPage>
	</page:isNotFirstPage>
	<page:isFirstPage>第一页&nbsp;上一页</page:isFirstPage>
	<page:isNotLastPage>
		<page:nextPage>下一页</page:nextPage>
		<page:lastPage>最后一页</page:lastPage>
	</page:isNotLastPage>
	<page:isLastPage>下一页&nbsp;最后一页</page:isLastPage>
	跳转到第<page:selectPage />页
</div>
	