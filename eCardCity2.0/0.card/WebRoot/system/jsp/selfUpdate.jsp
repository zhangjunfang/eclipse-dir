<%--
  功能描述 ：添加用户
  
  Author : Wangjian
  Date   : 2013-01-01
  Time   : 04:31:20
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<link type="text/css" rel="stylesheet"
			href="${path}/common/css/main.css">
		<link type="text/css" rel="stylesheet"
			href="${path}/common/css/tab.webfx.css">
		<script type="text/javascript" src="${path}/common/js/tabpane.js"></script>
		<script type="text/javascript">
	window.onload=function()
	{
		if(tp1.getSelectedIndex()!=0)
		{
			tp1.setSelectedIndex(0);
		}
	}
	
	function SetCwinHeight(o)
	{
		if (document.getElementById)
		{
		   if (o && !window.opera)
		   {
			    if (o.contentDocument && o.contentDocument.body.offsetHeight)
			    {
			     	o.height = o.contentDocument.body.offsetHeight+50;
			    }
			    else if(o.Document && o.Document.body.scrollHeight)
			    {
			     	o.height = o.Document.body.scrollHeight+50;
			    }
		   }
		}
	}
	</script>
	</head>
	<body>

		<!-- 标题 -->
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="table-location">
			<tr>
				<td height=25 bgcolor="#FFFFFF">
					<img src="${path}/common/img/frame/web_icon01.gif" width="11"
						height="8" align="middle">
					当前位置： 个人信息修改
				</td>
			</tr>
		</table>

		<!-- 工作区 -->
		<br/>
		<div class="tab-pane" id="tabPane1">
			<script type="text/javascript">
				var tp1 = new WebFXTabPane(document.getElementById("tabPane1"));
			</script>
			<div class="tab-page" id="tabPage1">
				<h2 class="tab">
					个人资料修改
				</h2>
				<iframe onload="SetCwinHeight(this);"
					src="${path}/account/account_updateSelfPre.action" width="100%"
					scrolling="auto" frameborder="0" marginwidth="0" marginheight="0"></iframe>
			</div>
			<script type="text/javascript">
							tp1.addTabPage(document.getElementById('tabPage1'));
						</script>

			<div class="tab-page" id="tabPage2">
				<h2 class="tab">
					密码修改
				</h2>
				<iframe onload="SetCwinHeight(this);"
					src="${path}/account/account_updatePwdPre.action" width="100%"
					scrolling="auto" frameborder="0" marginwidth="0" marginheight="0"></iframe>
			</div>
			<script type="text/javascript">
							tp1.addTabPage(document.getElementById('tabPage2'));
						</script>

		</div>
	</body>
</html>

