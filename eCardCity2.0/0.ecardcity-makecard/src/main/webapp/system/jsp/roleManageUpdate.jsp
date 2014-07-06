<%--
  功能描述 ：修改角色类型
  
  Author : Wangjian
  Date   : 2008-05-30
  Time   : 05:51:20
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="/page-tag"%>

<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<link type="text/css" rel="stylesheet"
			href="${path}/common/css/main.css">
		<script type="text/javascript"
			src='${path}/dwr/interface/DwrRoleInfoService.js'></script>
		<script type="text/javascript" src='${path}/dwr/engine.js'></script>
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		<script type="text/javascript" src="${path}/common/js/fn.js"></script>
		<script type="text/javascript"
			src="${path}/system/js/roleInfo.js"></script>

	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="table-location">
			<tr>
				<td height=25>
					<img src="${path}/common/img/frame/web_icon01.gif" width="11"
						height="8" align="absmiddle">
					当前位置：角色管理
				</td>
			</tr>
		</table>
		<form
			action="${path}/system/roleInfo_updateNext.action"
			method="post" name="form1" onsubmit="return fCheckTheForm(this);">

			<input type="hidden" name="roleInfo.id"
				value="<s:property value="roleInfo.id"/>" />
			<table width="100%" align="center" class="table-list">
				<tr>
					<td>
						<table align="center" class="table-form">
							<tr>
								<td colspan="2" class="table-title">
									角色类型修改
								</td>
							</tr>
							<tr>
								<td class="table-list_title">
									角色类型
								</td>
								<td>
									<input name="roleInfo.roleName" type="text"
										class="input"
										value="<s:property value="roleInfo.roleName"/>"
										Maxlength="30" Isblank="0" Tip="角色类型"
										onblur="fCheckRoleInfoIsRepeat(this,'<s:property value="roleInfo.roleName"/>')">
									<span id="msg"></span><s:text name="system.required"/>
								</td>
							</tr>
							<tr>
								<td class="table-list_title">
									备注
								</td>
								<td>
									<input name="roleInfo.remark" type="text"
										class="input"
										value="<s:property value="roleInfo.remark"/>"
										 Isblank="1"
										 Tip="备注信息">
								</td>
							</tr>
						</table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td class="table-button">
									说明：其中带<s:text name="system.required"/>号为必填项
									<input type="submit" value="提交" name="submit" class="input">
									<input type="reset" value="重置" name="reset">
								</td>
							</tr>
						</table>

					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

