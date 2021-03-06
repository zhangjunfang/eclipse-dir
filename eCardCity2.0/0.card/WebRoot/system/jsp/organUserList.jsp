<%--
  功能描述 ：指定的部门用户信息列表
  
  Author : Wangjian
  Date   : 2008-06-05
  Time   : 14:09:20
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
		<script type="text/javascript" src="${path}/common/js/fn2.js"></script>
	</head>

	<body>
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>

		<form name="form1" method="post">
			<input type="hidden" name="eomsOrganInfo.id" value="<s:property value="eomsOrganInfo.id"/>" />
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
									<input type="button" value="添加" name="add" 
										onClick="this.form.action='${path}/system/userOrganInfo_editUserPre.action?act=add';this.form.submit();">
									<input type="button" value="修改" name="update" 
										onClick="this.form.action='${path}/system/userOrganInfo_editUserPre.action?act=update';if(chkCheckbox(this.form,true)){this.form.submit();}">
									<input type="button" value="删除" name="delete" 
										onClick="this.form.action='${path}/system/userOrganInfo_delUser.action';if(chkCheckbox(this.form,false)&&window.confirm('该操作将删除选定的用户信息，是否继续？')){this.form.submit();}">
									<input type="button" value="分配角色" name="addModule" class="long"
										onClick="this.form.action='${path}/system/userOrganInfo_addRolePre.action';if(chkCheckbox(this.form,true)){this.form.submit();}">
									<input type="button" value="部门管理" name="addModule" class="long"
										onClick="location.href='${path}/system/userOrganInfo_listAllDeptByFather.action?eomsOrganInfo.pid=<s:property value="eomsOrganInfo.id"/>';">
								</td>
							</tr>
						</table>
						<table align="center" class="table-table">
							<tr>
								<td colspan="8" class="table-title">
									部门用户信息
								</td>
							</tr>
							<tr>
								<td class="table-title1" nowrap="nowrap" width="8%">
									<input type="checkbox" title="选择/不选择当前页的全部记录"
										name="ckid" onclick="chkAll(this,'id');">
								</td>
								<td class="table-title1" nowrap>
									用户名
								</td>
								<td class="table-title1" nowrap>
									姓名
								</td>
								<td class="table-title1" nowrap>
									工号
								</td>
								<td class="table-title1" nowrap>
									电话
								</td>
								<td class="table-title1" nowrap>
									电子信箱
								</td>
								<td class="table-title1" nowrap>
									所属部门
								</td>
								<td class="table-title1" nowrap>
									状态
								</td>
							</tr>

							<s:iterator value="tOrgUserList" status="s">
								<tr
									<s:if test="#s.odd">class='t1' onmouseout="this.className='t1'"</s:if>
									<s:else>class='t2' onmouseout="this.className='t2'"</s:else>
									onmousemove="this.className = 't3'">
									<td style="text-align: center;">
										<input type="checkbox" name="id"
											value="<s:property value="id" />">
									</td>
									<td>
										<s:property value="userName" />
									</td>
									<td>
										<s:property value="name" />
									</td>
									<td>
										<s:property value="code" />
									</td>
									<td>
										&nbsp;
										<s:property value="phone" />
									</td>
									<td>
										&nbsp;
										<a href="mailto:<s:property value="email" />" target="_blank"><s:property
												value="email" />
										</a>
									</td>
									<td>
										<s:property value="dept.deptName" />
									</td>
									<td>
										<s:if test="valid==1">有效</s:if>
										<s:else>无效</s:else>
									</td>
								</tr>
							</s:iterator>
						</table>
						<!--分页-->
						<%@ include file="/WEB-INF/inc/page.inc"%>
					</td>
				</tr>
			</table>
							</form>
	</body>

</html>

