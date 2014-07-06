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
		<script type="text/javascript" src="${path}/system/js/userOrgan.js"></script>
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		<script type="text/javascript" src="${path}/common/js/fn2.js"></script>
	</head>
	<body> 
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>

		<!-- 工作区 -->
		<form name="f1" action="${path}/system/userOrganInfo_saveUser.action" method="post" onSubmit="if(isRepeat){alert('该用户已存在！');return false;}else{return fCheck(this);}">
			<input type="hidden" name="act" value="<s:property value="act"/>"/>
			<input type="hidden" name="TOrgUser.id" value="<s:property value="TOrgUser.id"/>"/>
			<input type="hidden" name="eomsOrganInfo.id" value="<s:property value="eomsOrganInfo.id"/>"/>
			<table width="100%" align="center" class="table-list">
				<tr>
					<td>
						<table align="center" class="table-form">
							<tr>
								<s:if test="act=='add'">
									<td colspan="4" class="table-title">
										用户添加
									</td>
								</s:if>
								<s:else>
									<td colspan="4" class="table-title">
										用户修改
									</td>
								</s:else>
							</tr>
							<tr>
								<td class="table-list_title">用户名</td>
								<td>
									<s:if test="act=='add'">
									<input value="<s:property value="TOrgUser.userName"/>" name="TOrgUser.userName" type="text" fTip="用户名" fLength="5,25" fType="word" onBlur="this.value=this.value.trim();fCheckUserIsRepeat(this.value,false,'${path}');"/><s:text name="system.required" /><span id="msg"></span>
									</s:if>
									<s:else>
									<input value="<s:property value="TOrgUser.userName"/>" name="TOrgUser.userName" type="text" fTip="用户名" fLength="5,25" fType="word" onBlur="this.value=this.value.trim();fCheckUserIsRepeat(this.value,true,'${path}');"/><s:text name="system.required" /><span id="msg"></span>
									</s:else>
								</td>
								<td class="table-list_title">密码</td>
								<td>
									<input value="<s:property value="TOrgUser.password"/>" name="TOrgUser.password" type="password" fTip="密码"
										fLength="6,25" fType="" /><s:text name="system.required" />
								</td>
							</tr>
							<tr>
								<td class="table-list_title">姓名</td>
								<td>
									<input value="<s:property value="TOrgUser.name"/>" name="TOrgUser.name" type="text" fTip="姓名"
										fLength="1,25" fType="" /><s:text name="system.required" />
								</td>
								<td class="table-list_title">工号</td>
								<td>
									<input value="<s:property value="TOrgUser.code"/>" name="TOrgUser.code" type="text" fTip="工号"
										fLength="1,25" fType="num" /><s:text name="system.required" />
								</td>
							</tr>
							<tr>
								<td class="table-list_title">电话</td>
								<td>
									<input value="<s:property value="TOrgUser.phone"/>" name="TOrgUser.phone" type="text" fTip="电话"
										fLength=",20" fType="phone" />
								</td>
								<td class="table-list_title">电子信箱</td>
								<td>
									<input value="<s:property value="TOrgUser.email"/>" name="TOrgUser.email" type="text" fTip="电子信箱"
										fLength=",20" fType="email" />
								</td>
							</tr>
							<tr>
								<td class="table-list_title">所属部门</td>
								<td>
								<select name="TOrgUser.fkDep" class="common-select" style="width:200px">
								</select>
								</td>
								<td class="table-list_title">状态</td>
								<td>
									<s:if test="TOrgUser==null || TOrgUser.valid==1">
										<input class="radiobutton" type="radio" name="TOrgUser.valid" value="1" checked="true"/>有效
										&nbsp;&nbsp;&nbsp;
										<input class="radiobutton" type="radio" name="TOrgUser.valid" value="0"/>无效
									</s:if>
									<s:else>
										<input class="radiobutton" type="radio" name="TOrgUser.valid" value="1"/>有效
										&nbsp;&nbsp;&nbsp;
										<input class="radiobutton" type="radio" name="TOrgUser.valid" value="0" checked="true"/>无效
									</s:else>
								</td>
							</tr>
							<tr>
								<td class="table-list_title">备注</td>
								<td colspan="3">
									<textarea class="text-area" cols="65" rows="5" name="TOrgUser.remark" fTip="备注" fLength=",100" fType=""><s:property value="TOrgUser.remark"/></textarea>
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
		<script language="javaScript">
		var id="<s:property value="eomsOrganInfo.id"/>";
		<s:if test="TOrgUser.fkDep!=''">
			id="<s:property value="TOrgUser.fkDep"/>";
		</s:if>
		getAllDept(document.getElementsByName("TOrgUser.fkDep")[0],id);
		</script>
	</body>
</html>

