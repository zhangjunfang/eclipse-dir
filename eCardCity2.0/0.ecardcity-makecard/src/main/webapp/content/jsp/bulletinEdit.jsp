<%--
  功能描述 ：添加医药资讯
  
  Author : Wangjian
  Date   : 2013-01-13
  Time   : 04:31:20
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<link type="text/css" rel="stylesheet" href="${path}/common/css/main.css">
		<script type="text/javascript" src='${path}/dwr/engine.js'></script>
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		<script type="text/javascript" src="${path}/common/js/fn2.js"></script>
	</head>
	<body>
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>

		<!-- 工作区 -->
		<form name="f1" action="${path}/content/bulletin_save.action" method="post" onSubmit="return fCheck(this);">
			<input type="hidden" name="act" value="<s:property value="act"/>"/>
			<input type="hidden" name="obj.id" value="<s:property value="obj.id"/>"/>
			<input type="hidden" name="obj.hit" value="<s:property value="obj.hit"/>"/>
			<input type="hidden" name="obj.channelId" value="<s:property value="obj.channelId"/>"/>
			<table width="100%" align="center" class="table-list">
				<tr>
					<td>
						<table align="center" class="table-form">
							<tr>
								<s:if test="act=='add'">
									<td colspan="6" class="table-title">网站公告添加</td>
								</s:if>
								<s:else>
									<td colspan="6" class="table-title">网站公告修改</td>
								</s:else>
							</tr>
							<tr>
								<td class="table-list_title">状态</td>
								<td>
									<s:if test="obj==null || obj.id==null || obj.state==1">
										<input class="radiobutton" type="radio" name="obj.state" value="1" checked="true"/>有效
										&nbsp;&nbsp;&nbsp;
										<input class="radiobutton" type="radio" name="obj.state" value="0"/>无效
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</s:if>
									<s:else>
										<input class="radiobutton" type="radio" name="obj.state" value="1"/>有效
										&nbsp;&nbsp;&nbsp;
										<input class="radiobutton" type="radio" name="obj.state" value="0" checked="true"/>无效
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</s:else>
								</td>
								<td class="table-list_title">来源</td>
								<td>
									<input value="<s:property value="obj.source"/>" name="obj.source" type="text" fTip="来源" fLength=",30" fType=""/>
								</td>
								<td class="table-list_title">编辑</td>
								<td>
									<input value="<s:property value="obj.updateuser"/>" name="obj.updateuser" type="text" fTip="编辑" fLength=",25" fType=""/>
								</td>
							</tr>
							<tr>
								<td class="table-list_title">标题</td>
								<td colspan="5">
									<input class="input-longer" value="<s:property value="obj.cTitle"/>" name="obj.cTitle" type="text" fTip="标题" fLength="5,30" fType=""/><s:text name="system.required" />
								</td>
							</tr>
							<tr>
								<td class="table-list_title">内容</td>
								<td colspan="5">
									<FCK:editor instanceName="obj.cContent" width="96.5%" height="380px">
										<jsp:attribute name="value"><s:property value="obj.cContent" escape="false"/></jsp:attribute>
									</FCK:editor>
								</td>
							</tr>
						</table>

						<!-- 提示 -->
						<%@ include file="/WEB-INF/inc/prompt.inc"%>

						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td class="table-button">
									说明：其中带
									<s:text name="system.required"/>号为必填项
									<input type="submit" value="提交" name="submit1">
									<input type="reset" value="重置" name="reset1">
								</td>
							</tr>
						</table>

					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

