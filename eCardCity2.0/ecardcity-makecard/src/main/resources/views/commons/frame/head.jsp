<%--
  功能描述 ：框架顶部页面
  
  Author : Wangjian
  Date   : 2008-05-05
  Time   : 13:52:07
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<!-- 不缓存页面，间隔20分钟刷新一次页面 -->
		<meta http-equiv="refresh" content="1200">
		<link type="text/css" href="${path}/common/css/top.css" rel="stylesheet">
		<script type="text/javascript">
		function correctPNG() 
		{
			for(var i=0; i<document.images.length; i++)
			{
				var img = document.images[i];
				var imgName = img.src.toUpperCase();
				if (imgName.substring(imgName.length-3, imgName.length) == "png")
				{
					var imgID = (img.id) ? "id='" + img.id + "' " : "";
					var imgClass = (img.className) ? "class='" + img.className + "' " : "";
					var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' ";
					var imgStyle = "display:inline-block;" + img.style.cssText ;
					if (img.align == "left") imgStyle = "float:left;" + imgStyle;
					if (img.align == "right") imgStyle = "float:right;" + imgStyle;
					if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle ;
					var strNewHTML = "<span "+ imgID + imgClass + imgTitle + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";" + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader" + "(src='" + img.src + "', sizingMethod='scale');\"></span>"; 
					img.outerHTML = strNewHTML;
					i = i-1;
				}
			}
		}
		
		 //打印
	    function mainPrint() {
	        parent.mainFrame.focus();
	        parent.mainFrame.window.print();
	    }
		</script>
	</head>
	<body>
		<div id="top">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td id="logo">
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
							codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
							width="322" height="63">
							<param name="movie" value="${path}/common/swf/head.swf">
							<param name="quality" value="high">
							<param name="Wmode" value="transparent">
							<embed src="${path}/common/swf/head.swf" quality="high"
								pluginspage="http://www.macromedia.com/go/getflashplayer"
								type="application/x-shockwave-flash" width="322" height="63" wmode="transparent"></embed>
						</object>
					</td>
					<td width="250">
						<table width="180" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td align="center">
									<a href="${path}/system/jsp/selfUpdate.jsp" title="个人信息修改" target="mainFrame">
									<img src="${path}/common/img/frame/head/user.png" width="30" height="30" border="0">
									</a>
								</td>
								<td align="center">
									<a href="javascript:mainPrint()" title="打印当前页面" >
									<img src="${path}/common/img/frame/head/print.png"
											width="30" height="30" border="0" />
									</a>
								</td>
								<td align="center" title="退出">
									<a title="退出系统" href="javascript:if(window.confirm('您确定要退出系统吗?')){location='${path}/account/account_logout.action';}" target="_top">
									<img src="${path}/common/img/frame/head/exit.png" width="30" height="30"
											border="0" />
									</a>
								</td>
							</tr>
							<tr>
								<td align="center" valign="middle">
									<a href="${path}/system/jsp/selfUpdate.jsp" title="个人信息修改" target="mainFrame">
									<span style="color:#FFFFFF"><s:property value="#session.user.name"/></span>
									</a>
								</td>
								<td align="center" valign="middle">
									<a href="javascript:mainPrint()" title="打印当前页面" >
									<span style="color:#FFFFFF">打印</span>
									</a>
								</td>
								<td align="center" valign="middle">
									<a title="退出系统" href="javascript:if(window.confirm('您确定要退出系统吗?')){location='${path}/account/account_logout.action';}" target="_top">
									<span style="color:#FFFFFF">退出</span>
									</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
<script type="text/javascript">correctPNG();</script>
	</body>
</html>
