<%--
  功能描述 ：框架显示区页面
  
  Author : Wangjian
  Date   : 2008-05-05
  Time   : 14:34:07
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
	</head>
	<frameset cols="*,10" frameborder="no" border="0"  name="viewArea" id="viewArea" framespacing="0">
	  <frame src="${path}/common/frame/menu.jsp" name="menuFrame" id="mainFrame" />
	  <frame src="${path}/common/frame/sizeControl.jsp" name="sizeControlFrame" scrolling="no" noresize="noresize" id="SizeControl" />
	</frameset>
</html>