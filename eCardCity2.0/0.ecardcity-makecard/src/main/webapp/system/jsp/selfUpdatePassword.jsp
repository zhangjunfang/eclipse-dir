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
		<script type="text/javascript">	
		function submitForm(f){
			if(!fCheck(f)){return false;}
			if(f.newPwd.value!=f.newPwd2.value){alert("两次输入的新密码不一致，请重新输入！");f.newPwd.focus();return false;}
			return true;
		}
		</script>
	</head>
	<body>
	 
		<!-- 工作区 -->
		<form name="f1" action="${path}/account/account_updatePwd.action" method="post" onSubmit="return submitForm(this);">
			<input type="hidden" name="user.id" value="<s:property value="user.id"/>"/>
			<input type="hidden" name="user.userName" value="<s:property value="user.userName"/>"/>
			<input type="hidden" name="user.name" value="<s:property value="user.name"/>"/>
			<input type="hidden" name="user.code" value="<s:property value="user.code"/>"/>
			<input type="hidden" name="user.fkDep" value="<s:property value="user.fkDep"/>"/>
			<input type="hidden" name="user.valid" value="<s:property value="user.valid"/>"/>
			<input type="hidden" name="user.remark" value="<s:property value="user.remark"/>"/>
			<input type="hidden" name="user.phone" value="<s:property value="user.phone"/>"/>
			<input type="hidden" name="user.email" value="<s:property value="user.email"/>"/>
			<table width="100%" align="center" class="table-list">
				<tr>
					<td>
						<table align="center" class="table-form">
							<tr>
								<td class="table-list_title">旧密码</td>
								<td>
									<input value="" name="user.password" type="password" fTip="旧密码"
										fLength=",25" fType="" /><s:text name="system.required" />

								</td>
							</tr>
							<tr>
								<td class="table-list_title">新密码</td>
								<td>
									<input value="" name="newPwd" type="password" fTip="新密码"
										fLength="6,25" fType="" /><s:text name="system.required" />

								</td>
							</tr>
							<tr>
								<td class="table-list_title">确认新密码</td>
								<td>
									<input value="" name="newPwd2" type="password" fTip="确认的新密码"
										fLength="6,25" fType="" /><s:text name="system.required" />

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

