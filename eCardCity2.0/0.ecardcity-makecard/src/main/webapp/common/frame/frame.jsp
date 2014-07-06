<%--
  功能描述 ：主框架页面
  
  Author : Wangjian
  Date   : 2008-05-05
  Time   : 12:41:07
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
	</head>
	<frameset rows="63,*" cols="*" framespacing="0" frameborder="yes" border="0">
	    <frame name="headFrame" src="${path}/common/frame/head.jsp" scrolling="no" noresize marginwidth="0" marginheight="0">
	    <frameset name="main" id="main" rows="*" cols="180,*" framespacing="0" frameborder="no" border="0">
	        <frame name="viewFrame" id="viewFrame" src="${path}/common/frame/viewFrame.jsp" frameborder="0" scrolling="0">
	        <frame name="mainFrame" id="mainFrame" src="${path}/common/frame/main.jsp">
	    </frameset>
	</frameset>
</html>