<%--
  功能描述 ：子功能模块列表
  
  Author : Wangjian
  Date   : 2008-06-03
  Time   : 16:51:20
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
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		
		<script type="text/javascript">
			function fDeleteModule(oForm,url)
			{
				var oId=oForm['id'];
				if(!oId)
				{
					return;
				}
				if(!fCheckboxHasChecked(oId))
				{
					alert("请选择您要删除的模块记录!");
					return;
				}
				if(!confirm("如果这些模块含有子模块也将一起被删除，是否继续?"))
				{
					return;
				}
				oForm.action=url;
				oForm.method="post";
				oForm.submit();
			}
		</script>

	</head>

	<body <% if(request.getParameter("fresh")== null){ %>onload="parent.leftFrame.location.reload();" <%}%>>
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>
		<table width="100%" align="center" class="table-list">
			<tr>
				<td bgcolor="#FFFFFF">
					<!--工作区 -->
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td bgcolor="#FFFFFF">
								&nbsp;

							</td>
							<td height="30" bgcolor="#FFFFFF" class="table-button"
								style="text-align: right;">
								<input type="button" value="添加" name="B332" class="input"
									onClick="fAddData('${path}/system/moduleInfo_add.action?parentId=<s:property value="parentId" />')">
								<input type="button" value="修改" name="update" class="input"
									onClick="fUpdateData(document.form1,'${path}/system/moduleInfo_update.action?parentId=<s:property value="parentId" />&moduleInfo.id=')">
								<input type="button" value="删除" name="delete" class="input"
									onClick="fDeleteModule(document.form1,'${path}/system/moduleInfo_delete.action?parentId=<s:property value="parentId" />')">
							</td>
						</tr>
					</table>
					<table align="center" class="table-table">
						<tr>
							<td colspan="6" class="table-title">
								子模块维护信息
							</td>
						</tr>
						<tr>
							<td class="table-title1" nowrap="nowrap" width="8%">
								<input type="checkbox" title="选择/不选择当前页的全部记录"
									onclick="fSelectAll(this,document.form1.id)">
							</td>
							<td class="table-title1">
								模块名称
							</td>
							<td class="table-title1">
								访问地址
							</td>
							<td class="table-title1">
								备注信息
							</td>
						</tr>
						<form name="form1">
							<s:iterator value="moduleInfoList" status="s">
								<tr
									<s:if test="#s.odd">class='t1' onmouseout="this.className='t1'"</s:if>
									<s:else>class='t2' onmouseout="this.className='t2'"</s:else>
									onmousemove="this.className = 't3'">
									<td style="text-align: center;">
										<input type="checkbox" name="id"
											value="<s:property value="id" />">
									</td>
									<td>
										&nbsp;
										<s:property value="permName" />
									</td>
									<td>
										&nbsp;
										<s:property value="permUrl" />
									</td>
									<td>
										&nbsp;
										<s:property value="remark" />
									</td>
								</tr>
							</s:iterator>
						</form>
					</table>

					<!--分页-->
					<%@ include file="/WEB-INF/inc/page.inc"%>
				</td>
			</tr>
		</table>
	</body>

</html>

