<%--
  功能描述 ：IP承载网地日志查询及列表
  
  Author : Wangjian
  Date   : 2008-05-10
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
		<script type='text/javascript'
			src='${path}/common/plugins/My97DatePicker/WdatePicker.js'></script>
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		<script type="text/javascript" src="${path}/common/js/fn.js"></script>
		<script language="javaScript">
		window.onload=function(){
		document.forms[0]['TLogSearch.module'].value='<s:property value="TLogSearch.module" />';
		document.forms[0]['TLogSearch.action'].value="<s:property value='TLogSearch.action'/>";
	    }
		function submitCheck(flag,form){
			switch(flag){
				case 1://查询
					form.action="logInfoList.action";
					if(!formCheck(form)){
						return false;
					}
					break;
				case 2://导出
					form.action="logInfoExport.action";
					break;
				case 3://删除
					if(checkboxSelect(form,0) && window.confirm("确定要删除选中的记录吗？")){
						form.action="logInfoDelete.action";
					}else{
						return false;
					}
					break;
			}
			form.submit();
		}
	</script>
	</head>
	<body>
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>
		<table width="100%" align="center" class="table-list">
			<tr>
				<td bgcolor="#FFFFFF">
					<!-- 查询条件 -->
						<form action="${path}/system/logInfoList.action" method="post"
							onSubmit="return submitCheck(1,this);">
					<table align="center" class="table-form">
						<tr>
							<td colspan="7" class="table-title">
								用户操作日志查询
							</td>
						</tr>
						<tr>
							<td class="table-list_title">
								开始时间
							</td>
							<td>
								<input type="text" name="TLogSearch.startDate"
									value="<s:date name="TLogSearch.startDate" format="yyyy-MM-dd" />"
									class="Wdate" onClick="WdatePicker()"
									onChange="fPickDate(this,this.form['TLogSearch.endDate'],true)"
									readonly="readonly" style="width: 150px">
							</td>
							<td class="table-list_title">
								结束时间
							</td>
							<td>
								<input type="text" name="TLogSearch.endDate"
									value="<s:date name="TLogSearch.endDate" format="yyyy-MM-dd"/>"
									class="Wdate" onClick="WdatePicker()"
									onChange="fPickDate(this.form['TLogSearch.startDate'],this,false)"
									readonly="readonly" style="width: 150px">
							</td>
							<td class="table-list_title">
								操作员
							</td>
							<td>
								<input name="TLogSearch.operator" type="text"
									class="input-short" Maxlength="25" Tip="操作员" Isblank="1"
									value="<s:property value='TLogSearch.operator'/>">
							</td>
							<td rowspan="2">
								<span class="table-button"> <input type="submit"
										name="s1" value="查询" class="input" /> </span>
							</td>
						</tr>
						<tr>
							<td class="table-list_title">
								操作模块
							</td>
							<td>
								<select name="TLogSearch.module" class="common-select">
									<option value="">
										全部
									</option>
									<s:iterator value="moduleMap">
										<option value="<s:property value='value'/>"
											<s:if test="value==TLogSearch.module"><s:property value="' selected=true'"/></s:if>>
											<s:property value="value" />
										</option>
									</s:iterator>
								</select>
							</td>
							<td class="table-list_title">
								操作动作
							</td>
							<td>
								<select name="TLogSearch.action" class="common-select">
									<option value="">
										全部
									</option>
									<s:iterator value="actionMap">
										<option value="<s:property value='value'/>"
											<s:if test="value==TLogSearch.action"><s:property value="' selected=true'"/></s:if>>
											<s:property value="value" />
										</option>
									</s:iterator>
								</select>
							</td>
							<td class="table-list_title">
								IP地址
							</td>
							<td>
								<input name="TLogSearch.ip" type="text"
									class="input-short" Maxlength="15" Tip="操作员" Isblank="1"
									value="<s:property value='TLogSearch.ip'/>">
							</td>
						</tr>
					</table>
						</form>

					<!-- 列表区 -->
						<form>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td bgcolor="#FFFFFF">
								&nbsp;
							</td>
							<td height="30" bgcolor="#FFFFFF" class="table-button"
								style="text-align: right;">
								<input type="button" value="导出" name="update" class="input"
									onClick="return submitCheck(2,document.forms[0]);">
								<input type="button" value="删除" name="delete" class="input"
									onClick="return submitCheck(3,this.form);">
							</td>
						</tr>
					</table>
					<table align="center" class="table-table">
						<tr>
							<td colspan="8" class="table-title">
								用户操作日志列表
							</td>
						</tr>
						<tr>
							<td class="table-title1" nowrap="nowrap">
								<div align="center" title="选择/不选择当前页的全部记录"><input type="checkbox"
										onclick="fSelectAll(this,document.forms[1].id)">
								</div>
							</td>
							<td class="table-title1" nowrap="nowrap">
								操作员
							</td>
							<td class="table-title1" nowrap="nowrap">
								操作模块
							</td>
							<td class="table-title1" nowrap="nowrap">
								操作动作
							</td>
							<td class="table-title1" nowrap="nowrap">
								操作内容
							</td>
							<td class="table-title1" nowrap="nowrap">
								IP地址
							</td>
							<td class="table-title1" nowrap="nowrap">
								操作时间
							</td>
						</tr>
						<s:iterator value="tLogList" status="s">
							<tr
								<s:if test="#s.odd">class='t1' onmouseout="this.className='t1'"</s:if>
								<s:else>class='t2' onmouseout="this.className='t2'"</s:else>
								onmousemove="this.className = 't3';">
								<td>
									<div align="center">
										<input type="checkbox" name="id"
											value="<s:property value="id" />">
									</div>
								</td>
								<td nowrap="nowrap">
									&nbsp;
									<s:property value="operator" />
								</td>
								<td>
									&nbsp;
									<s:property value="module" />
								</td>
								<td>
									&nbsp;
									<s:property value="action" />
								</td>
								<td>
									&nbsp;
									<s:property value="logContent" />
								</td>
								<td>
									&nbsp;
									<s:property value="ip" />
								</td>
								<td nowrap="nowrap">
									&nbsp;
									<s:date name="logDate" format="yyyy-MM-dd HH:mm:ss" />
								</td>
							</tr>
						</s:iterator>
					</table>
						</form>

				<!-- 分页 -->
				<%@ include file="/WEB-INF/inc/page.inc"%>
				</td>
			</tr>
		</table>
	</body>
</html>
