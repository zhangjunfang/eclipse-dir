<%--
  功能描述 ：添加子功能模块
  
  Author : Wangjian
  Date   : 2008-06-03
  Time   : 17:19:20
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
			src='${path}/dwr/interface/DwrModuleInfoService.js'></script>
		<script type="text/javascript" src='${path}/dwr/engine.js'></script>
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		<script type="text/javascript" src="${path}/common/js/fn.js"></script>
		<script type="text/javascript" src="${path}/system/js/moduleInfo.js"></script>
		<script type="text/javascript">
	</script>
	</head>
	<body>
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>

		<!-- 工作区 -->
		<form action="${path}/system/moduleInfo_addNext.action" method="post"
			onSubmit="return fCheckTheForm(this);">

			<input type="hidden" name="moduleInfo.pid"
				value="<s:property value="parentId" />" />
			<table width="100%" align="center" class="table-list">
				<tr>
					<td>
						<table align="center" class="table-form">
							<tr>
								<td colspan="2" class="table-title">
									子功能模块添加
								</td>
							</tr>
							<tr>
								<td class="table-list_title">模块名称</td>
								<td>
									<input name="moduleInfo.permName" type="text" value="<s:property value="moduleInfo.permName"/>" Maxlength="25" Isblank="0" Tip="模块名称" onblur="fCheckModuleInfoIsRepeat(this,<s:property value="parentId" />)">
									<span id="msg"></span>
									<s:text name="system.required" />
								</td>
							</tr>
							<tr>
								<td class="table-list_title">访问地址</td>
								<td>
									<input name="moduleInfo.permUrl" type="text" value="<s:property value='moduleInfo.permUrl'/>" Isblank="1" Maxlength="80" Tip="访问地址">菜单或子菜单（非叶子节点）该项无须填写
								</td>
							</tr>
							<tr>
								<td class="table-list_title">备注信息</td>
								<td>
									<textarea name="moduleInfo.remark" cols="60" rows="3" Tip="备注信息"  Isblank="1" Maxlength="100" ><s:property value="moduleInfo.remark"/></textarea>
								</td>
							</tr>
						</table>

						<!-- 提示 -->
						<%@ include file="/WEB-INF/inc/prompt.inc"%>

						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td class="pizhu" width="30%">
									说明：其中带<s:text name="system.required"/>号为必填项
								</td>
								<td class="table-button">
									<input type="submit" value="提交" name="B333" class="input">
									<input type="reset" value="重置" name="Reset">
								</td>
							</tr>
						</table>

					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


