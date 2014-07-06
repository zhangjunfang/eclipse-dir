<%--
  功能描述 ：新闻公告查看
  
  Author : Wangjian
  Date   : 2013-01-16
  Time   : 04:31:20
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<link rel="stylesheet" type="text/css" href="${path}/web/css/basic.css" />
		<link rel="stylesheet" type="text/css" href="${path}/web/css/home.css" />
		<link rel="stylesheet" type="text/css" href="${path}/web/css/wrap.css" />
		<link rel="stylesheet" type="text/css" href="${path}/web/css/result.css" />
		<link rel="stylesheet" type="text/css" href="${path}/web/css/view.css" />
	</head>
<body>
	<div id="wrap">
		<div id="centerbox_548">	
			<div class="newsshow">
				<div class="newsshow_cot">
					<h1 class="newstitle"><s:property value="obj.cTitle"/><span>作者:<s:property value="obj.updateuser" />&nbsp;&nbsp;发布时间：<s:date name="obj.updatetime" format="yyyy年MM月dd日HH:mm" />&nbsp;&nbsp;<s:if test="obj.source!=null&&obj.source!=''">文章来源:<s:property value="obj.source" /></s:if></span></h1>
					<div class="newsshowcotbox" >
						<s:property value="obj.cContent" escape="false"/>
					</div>
				</div>
			</div>
			<div style="float:right;"><a href="#" class="client_txt_title"><font style="color:#fff;">回顶部</font></a></div>
		</div>
		<div class="b10px"></div>
	</div>
</body>
</html>