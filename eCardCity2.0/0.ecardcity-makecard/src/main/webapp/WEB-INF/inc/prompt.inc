<%--
  功能描述 ：信息提示
  
  Author : wangjian
  Date   : 2008-05-09
  Time   : 10:24:27
  Version: 1.0
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<s:if test="prompt!=null">
<div align="left" style="margin-left: 20px;height: 25px;color: red;">
	<s:property value="prompt"/>
</div>
</s:if>