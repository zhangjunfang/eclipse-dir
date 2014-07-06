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
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Cache-Control" content="no-store"/>
	<meta http-equiv="Pragma" content="no-cache"/>
	<meta http-equiv="Expires" content="0"/>
	<meta name="keywords" content="一卡通  城市一卡通" />
	<meta name="description" content="卡务平台-城市一卡通V2.0-郑州新开普电子股份有限公司" />
	<title>卡务平台-城市一卡通V2.0</title>
    