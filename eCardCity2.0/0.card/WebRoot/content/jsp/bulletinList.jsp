<%--
  功能描述 ：医药资讯列表
  
  Author : Wangjian
  Date   : 2013-01-13
  Time   : 19:09:20
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="/page-tag"%>
<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<link type="text/css" rel="stylesheet" href="${path}/common/css/main.css">
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		<script type="text/javascript" src="${path}/common/js/fn2.js"></script>
	</head>

	<body>
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>

		<form name="form1" method="post">
			<input type="hidden" name="obj.channelId" value="<s:property value="obj.channelId"/>" />
			<table width="100%" align="center" class="table-list">
				<tr>
					<td bgcolor="#FFFFFF">
						<!--工作区 -->
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="30" bgcolor="#FFFFFF" class="table-button" style="text-align: right;">
									<input type="button" value="添加" name="add" 
										onClick="this.form.action='${path}/content/bulletin_editPre.action?act=add';this.form.submit();">
									<input type="button" value="修改" name="update" 
										onClick="this.form.action='${path}/content/bulletin_editPre.action?act=update';if(chkCheckbox(this.form,true)){this.form.submit();}">
									<input type="button" value="删除" name="delete" 
										onClick="this.form.action='${path}/content/bulletin_del.action';if(chkCheckbox(this.form,false)&&window.confirm('该操作将删除选定的记录信息，是否继续？')){this.form.submit();}">
								</td>
							</tr>
						</table>
						<table align="center" class="table-table">
							<tr>
								<td colspan="7" class="table-title">网站公告</td>
							</tr>
							<tr>
								<td class="table-title1" nowrap="nowrap" width="8%">
									<input type="checkbox" title="选择/不选择当前页的全部记录" name="ckid" onclick="chkAll(this,'id');">
								</td>
								<td class="table-title1" nowrap>标题</td>
								<td class="table-title1" nowrap>点击次数</td>
								<td class="table-title1" nowrap>来源</td>
								<td class="table-title1" nowrap>状态</td>
								<td class="table-title1" nowrap>编辑</td>
								<td class="table-title1" nowrap>编辑时间</td>
							</tr>

							<s:iterator value="objList" status="s">
								<tr onClick="" 
									<s:if test="#s.odd">class='t1' onMouseout="this.className='t1'"</s:if>
									<s:else>class='t2' oMmouseout="this.className='t2'"</s:else>
									onMousemove="this.className='t3';">
									<td style="text-align: center;">
										<input type="checkbox" name="id" value="<s:property value="id"/>">
									</td>
									<td><a href="${path}/content/bulletin_view.action?id=<s:property value='id'/>" target="_blank"><s:property value="cTitle" /></a></td>
									<td><s:property value="hit" /></td>
									<td>&nbsp;<s:property value="source" /></td>
									<td><s:if test="state==1">有效</s:if><s:else>无效</s:else></td>
									<td>&nbsp;<s:property value="updateuser" /></td>
									<td><s:date name="updatetime" format="yyyy-MM-dd HH:mm:ss" /></td>
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

