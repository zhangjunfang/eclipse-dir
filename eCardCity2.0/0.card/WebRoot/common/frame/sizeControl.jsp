<%--
  功能描述 ：框架控制条页面
  
  Author : Wangjian
  Date   : 2008-05-05
  Time   : 14:18:07
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<link type="text/css" href="${path}/common/css/frame.css" rel="stylesheet">
		<script type="text/javascript" src="${path}/common/js/frame/frame.js"></script>
	</head>
	<body class="left-vertical-body-background"
		onLoad="MM_preloadImages('${path}/common/img/frame/hideLeft.gif')">
		<table width="9" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="9" background="${path}/common/img/frame/size_arrow.jpg">
					<div id="image">
						<a href="javascript:hideViewArea();"> <img
								src="${path}/common/img/frame/hideLeft.gif" name="leftImage" width="7"
								height="65" border="0" id="leftImage"
								onMouseOver="MM_swapImage('leftImage','','${path}/common/img/frame/hideLeftOver.gif',1)"
								onMouseOut="MM_swapImgRestore()">
						</a>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
