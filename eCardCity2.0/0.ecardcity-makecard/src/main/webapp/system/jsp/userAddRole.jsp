<%--
  功能描述 ：用户分配角色
  
  Author : Wangjian
  Date   : 2008-06-20
  Time   : 09:36:27
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<link type="text/css" rel="stylesheet"
			href="${path}/common/css/main.css">
		<script type="text/javascript"
			src='${path}/dwr/interface/DwrUserOrganService.js'></script>
		<script type="text/javascript" src='${path}/dwr/engine.js'></script>
		<script type="text/javascript" src="${path}/common/js/moveOptions.js"></script>
		<script type="text/javascript" src="${path}/system/js/userOrgan.js"></script>
	</head>
	<body>
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>

		<!-- 工作区 -->
		<br><br>
		<table width="60%" align="center">
			<tr>
				<td bgcolor="#FFFFFF">
					<form>
						<table border="0" align="center" cellspacing="0">
							<tr>
								<td>
									<div>
										用户
										<s:property value="TOrgUser.name" />
										未分配的角色
									</div>
									<div>
										<select name="userNoRoleInfoList" style="width: 200px;"
											size="15" multiple="multiple">
											<s:iterator value="userNoRoleInfoList">
												<option value="<s:property value="value"/>">
													<s:property value="name" />
												</option>
											</s:iterator>
										</select>
									</div>
								</td>
								<td width="40" class="table-button">
									<input type="button" value="&gt;"
										name="moveSelectedOptionsLeftToRight"
										onclick="fMoveSelectedOptionsLeftToRight(document.forms[0]['userNoRoleInfoList'],document.forms[0]['userHaveRoleInfoList'])">
									<br>
									<br>
									<input type="button" value="&gt;&gt;"
										name="moveAllOptionsLeftToRight"
										onclick="fMoveAllOptionsLeftToRight(document.forms[0]['userNoRoleInfoList'],document.forms[0]['userHaveRoleInfoList'])">
									<br>
									<br>
									<input type="button" value="&lt;"
										name="moveSelectedOptionsRightToLeft"
										onclick="fMoveSelectedOptionsRightToLeft(document.forms[0]['userNoRoleInfoList'],document.forms[0]['userHaveRoleInfoList'])">
									<br>
									<br>
									<input type="button" value="&lt;&lt;"
										name="moveAllOptionsRightToLeft"
										onclick="fMoveAllOptionsRightToLeft(document.forms[0]['userNoRoleInfoList'],document.forms[0]['userHaveRoleInfoList'])">
								</td>
								<td>
									<div>
										用户
										<s:property value="TOrgUser.name" />
										已分配的角色
									</div>
									<div>
										<select name="userHaveRoleInfoList" style="width: 200px;"
											size="15" multiple="multiple">
											<s:iterator value="userHaveRoleInfoList">
												<option value="<s:property value="value"/>">
													<s:property value="name" />
												</option>
											</s:iterator>
										</select>
									</div>
								</td>
							</tr>
						</table>
						<br>
						<table align="center" cellpadding="0" cellspacing="6"
							class="table-button">
							<tr>
								<td>
									<input type="hidden" name="TOrgUser.id"
										value="<s:property value='TOrgUser.id'/>">
									<input name="Save" type="button" value="保存" onclick="return fUserAddRole()">
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>
