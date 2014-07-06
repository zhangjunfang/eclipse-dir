<%--
  功能描述 ：公共头文件
  
  Author : wangjian
  Date   : 2008-05-09
  Time   : 15:03:27
  Version: 1.0
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
request.setAttribute("path",request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath());//init system context path
%>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="not-ie" lang="en">
<!--<![endif]-->
	<meta http-equiv="X-UA-Compatible" content="edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Cache-Control" content="no-store"/>
	<meta http-equiv="Pragma" content="no-cache"/>
	<meta http-equiv="Expires" content="0"/>
	<meta name="keywords" content="一卡通  城市一卡通" />
	<meta name="description" content="卡务平台-城市一卡通V2.0-郑州新开普电子股份有限公司" />
	<title>卡务平台-城市一卡通V2.0</title>