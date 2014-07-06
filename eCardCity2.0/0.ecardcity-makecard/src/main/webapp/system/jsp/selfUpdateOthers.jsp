<%--
  功能描述 ：添加用户
  
  Author : Wangjian
  Date   : 2013-01-01
  Time   : 04:31:20
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="/page-tag"%>

<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<link type="text/css" rel="stylesheet" href="${path}/common/css/main.css">
		<script type="text/javascript" src='${path}/dwr/interface/DwrUserOrganService.js'></script>
		<script type="text/javascript" src='${path}/dwr/engine.js'></script>
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		<script type="text/javascript" src="${path}/common/js/fn2.js"></script>
	</head>
	<body>

		<!-- 工作区 -->
		<form name="f1" action="${path}/account/account_updateSelf.action" method="post" onSubmit="return fCheck(this);">
			<input type="hidden" name="user.id" value="<s:property value="user.id"/>"/>
			<input type="hidden" name="user.userName" value="<s:property value="user.userName"/>"/>
			<input type="hidden" name="user.password" value="<s:property value="user.password"/>"/>
			<input type="hidden" name="user.fkDep" value="<s:property value="user.fkDep"/>"/>
			<input type="hidden" name="user.valid" value="<s:property value="user.valid"/>"/>
			<input type="hidden" name="user.remark" value="<s:property value="user.remark"/>"/>
			<input type="hidden" name="dept" value="<s:property value="dept"/>"/>
			<table width="100%" align="center" class="table-list">
				<tr>
					<td>
						<table align="center" class="table-form">
							<tr>
								<td class="table-list_title">用户名</td>
								<td colspan="3"><b><s:property value="user.userName"/></b></td>
							</tr>
							<tr>	
								<td class="table-list_title">姓名</td>
								<td>
									<input value="<s:property value="user.name"/>" name="user.name" type="text" fTip="姓名"
										fLength="1,25" fType="" /><s:text name="system.required" />
								</td>
								<td class="table-list_title">工号</td>
								<td>
									<input value="<s:property value="user.code"/>" name="user.code" type="text" fTip="工号"
										fLength="1,25" fType="num" /><s:text name="system.required" />
								</td>
							</tr>
							<tr>
								<td class="table-list_title">电话</td>
								<td>
									<input value="<s:property value="user.phone"/>" name="user.phone" type="text" fTip="电话"
										fLength=",20" fType="phone" />
								</td>
								<td class="table-list_title">电子信箱</td>
								<td>
									<input value="<s:property value="user.email"/>" name="user.email" type="text" fTip="电子信箱"
										fLength=",20" fType="email" />
								</td>
							</tr>
							<tr>
								<td class="table-list_title">所属部门</td>
								<td><s:property value="dept"/></td>
								<td class="table-list_title">状态</td>
								<td>
									<s:if test="user.valid==1">有效</s:if>
									<s:else>无效</s:else>
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

