<%--
  功能描述 ：菜单管理主框架
  
  Author : Wangjian
  Date   : 2008-06-3
  Time   : 09:12:30
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
	</head>
	<frameset rows="*" cols="170,*" framespacing="0" frameborder="no" border="0">
	  <frame src="${path}<s:property value="leftFrame"/>" name="leftFrame" id="leftFrame" scrolling="auto" />
	  <frame src="${path}<s:property value="rightFrame"/>" name="rightFrame" id="rightFrame" scrolling="auto"/>
	</frameset>
</html>