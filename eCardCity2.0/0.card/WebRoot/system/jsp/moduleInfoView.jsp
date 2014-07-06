<%--
  功能描述 ：子功能模块详细信息
  
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
		<script type="text/javascript" src='${path}/dwr/engine.js'></script>
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		<script type="text/javascript" src="${path}/common/js/fn.js"></script>
		<script type="text/javascript">
	</script>
	</head>
	<body>
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>

		<!-- 工作区 -->
		<table width="100%" align="center" class="table-list">
				<tr>
					<td>
						<table align="center" class="table-form">
							<tr>
								<td colspan="4" class="table-title">
									子功能模块详细信息显示
								</td>
							</tr>
							<tr>
								<td class="table-list_title">
									模块名称
								</td>
								<td colspan="3"><s:property value="moduleInfo.permName"/></td>
							</tr>
							<tr>
								<td class="table-list_title">
									访问地址
								</td>
								<td colspan="3"><s:property value='moduleInfo.permUrl'/></td>
							</tr>
							<tr>
								<td class="table-list_title">
									备注信息
								</td>
								<td colspan="3">
									<s:property value='moduleInfo.remark'/>
									
								</td>
							</tr>
						</table>


					<!-- 提示 -->
					<%@ include file="/WEB-INF/inc/prompt.inc"%>


				</td>
			</tr>
		</table>
	</body>
</html>


