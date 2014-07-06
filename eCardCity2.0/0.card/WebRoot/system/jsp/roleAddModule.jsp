<%--
  功能描述 ：为角色分配可操作功能模块的权限
  
  Author : Wangjian
  Date   : 2008-06-05
  Time   : 16:21:27
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<link type="text/css" rel="stylesheet"
			href="${path}/common/css/main.css">
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		<script type="text/javascript" src="${path}/common/js/fn.js"></script>
		<link type="text/css" rel="stylesheet"
			href="${path}/common/plugins/dtree/css/dtree.css">
		<script type="text/javascript"
			src="${path}/common/plugins/dtree/js/dtreeCheckBoxEdit.js"></script>
	</head>


	<body>
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>
		<!-- 工作区 -->
		<table width="100%" align="center" class="table-list">
			<tr>
				<td bgcolor="#FFFFFF">
					<table width="100%" class="title_table1">
						<tr>
							<td colspan="6" align="left" width="80%">角色“<s:property value="roleInfo.roleName" />”分配权限</td>

						</tr>
					</table>
					<table align="center" class="table-form">

						<tr>
							<td colspan="6" align="left">
								功能模块
							</td>
						</tr>
						<tr>
							<td align="center" colspan="6">
							  <form method="post" name="form1">
							  	<input type="hidden" name="roleInfo.id" value="<s:property value="roleInfo.id" />">
								<table border="0" align="center" cellspacing="0">
									<tr>
										<td nowrap>
											<script type="text/javascript">
									                var rootTree = new dTree('rootTree');
									                rootTree.add('0','-1','菜单功能模块');
									                
									                <s:iterator value="nodeList">
														<s:if test="isChecked">
														    rootTree.add('<s:property value="id"/>','<s:if test="pid!=null"><s:property value="pid"/></s:if><s:else>0</s:else>','<s:property value="name"/>',null,'.','.','../common/plugins/dtree/img/page.gif','../common/plugins/dtree/img/page.gif','.',true);
														</s:if>
														<s:else>
															rootTree.add('<s:property value="id"/>','<s:if test="pid!=null"><s:property value="pid"/></s:if><s:else>0</s:else>','<s:property value="name"/>');
														</s:else>
													</s:iterator>
													
													document.write(rootTree);
									                rootTree.openAll();
									            </script>
										</td>
									</tr>
								</table>
							  </form>
							</td>
						</tr>


						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="30%" class="pizhu">
									&nbsp;
								</td>
								<td height="30" style="padding-right: 300px;"
									class="table-button">
									<input type="submit" value="提交" name="Submit"
										onclick="submitForm();">
									<input type="button" value="返回" name="return"
										onclick="javascript:history.go(-1);">
								</td>
							</tr>
						</table>
					</table>
				</td>
			</tr>
		</table>
	</body>

	<script type="text/javascript">
		function submitForm(){
		    var ids = "";
			var form = document.form1;
			for (var i=0; i<form.elements.length; i++) {
				var element = form.elements[i];
				if (element.name == "moduleIds" && element.type=='checkbox'){
					if( element.checked == true ){
						ids = ids + element.value + ",";
					}
				}
			}		
			//alert(ids);
			form.action="${path}/system/roleInfo_addModule.action";
			form.submit();
		}
	</script>
</html>
