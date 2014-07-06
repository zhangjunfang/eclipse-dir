<%--
  功能描述 ：角色类型列表
  
  Author : Wangjian
  Date   : 2008-05-28
  Time   : 11:19:20
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
		<script type="text/javascript" src="${path}/common/js/fn.js"></script>
		<script type="text/javascript">
      		 /* 修改数据 */
			function fRoleAddModule(oForm,url)
			{
				var oId=oForm['id'];
				if(!oId)
				{
					return;
				}
				if(!fCheckboxHasChecked(oId))
				{
					alert("请选择您要进行权限分配的角色记录!");
					return;
				}
				var values=fGetCheckboxValue(oId);
				if(values.length!=1)
				{
					alert("只能选择一条角色记录进行权限分配!");
					return;
				}
				location.href=url+values[0];
			}
       </script>
	</head>

	<body>
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>
		<table width="100%" align="center" class="table-list">
			<tr>
				<td bgcolor="#FFFFFF">
					<!--工作区 -->
					
							<form action="${path}/system/roleInfo_list.action" method="post" onSubmit="return formCheck(this)">
						<table align="center" class="table-form">
							<tr>
								<td colspan="3" class="table-title">
									角色查询
								</td>
							</tr>
							<tr>
								<td class="table-list_title">
									角色类型
								</td>
								<td>
									<input name="roleInfo.roleName" type="text" class="input" value="<s:property value="roleInfo.roleName" />"  Tip="角色类型" Isblank="1">
								</td>
								<td>
									<span class="table-button"><input type="submit"
											value="查询" name="B33" class="input"> </span>
								</td>
							</tr>
						</table>
							</form>
					
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td bgcolor="#FFFFFF">
								&nbsp;
							</td>
							<td height="30" bgcolor="#FFFFFF" class="table-button"
								style="text-align: right;">
								<input type="button" value="添加" name="B332" class="input"
									onClick="fAddData('${path}/system/roleInfo_add.action')">
								<input type="button" value="修改" name="update" class="input"
									onClick="fUpdateData(document.form1,'${path}/system/roleInfo_update.action?roleInfo.id=')">
								<input type="button" value="删除" name="delete" class="input"
									onClick="fDeleteData(document.form1,'${path}/system/roleInfo_delete.action')">
								<input type="button" value="分配权限" name="addModule" class="long"
									onClick="fRoleAddModule(document.form1,'${path}/system/roleInfo_addModulePre.action?roleInfo.id=')">
							</td>
						</tr>
					</table>
					<table align="center" class="table-table">
						<tr>
							<td colspan="6" class="table-title">
								角色类型信息
							</td>
						</tr>
						<tr>
							<td class="table-title1" nowrap="nowrap" width="8%"><input type="checkbox"  title="选择/不选择当前页的全部记录"
									onclick="fSelectAll(this,document.forms[1].id)">
							</td>
							<td class="table-title1">
								角色类型
							</td>
							<td width="50%" class="table-title1">
								备注
							</td>
						</tr>
						<form name="form1">
							<s:iterator value="roleInfoList" status="s">
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
										<s:property value="roleName" />
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

