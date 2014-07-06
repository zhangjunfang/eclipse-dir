<%--
  功能描述 ：刷新父页面
  
  Author : Wangjian
  Date   : 2008-05-26
  Time   : 15:25:27
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<%@ include file="/WEB-INF/inc/head.inc"%>
	<script type="text/javascript">
	window.onload=function()
	{
		parent.location.href=parent.location.href;
	}	
	</script>
</head>
<body>
</body>
</html>