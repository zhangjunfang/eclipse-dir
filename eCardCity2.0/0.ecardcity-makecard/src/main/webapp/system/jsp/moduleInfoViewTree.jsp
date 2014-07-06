<%--
  功能描述 ：模块管理菜单
  
  Author : Wangjian
  Date   : 2008-06-03
  Time   : 11:26:07
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<%@ include file="/WEB-INF/inc/head.inc"%>
	<link type="text/css" href="${path}/common/plugins/tabpage/css/tree.css" rel="stylesheet">
	<script type="text/javascript" src="${path}/common/plugins/tabpage/js/xtree.js"></script>
	<script type="text/javascript">
   	function fGoToPage(url)
   	{
   		parent.rightFrame.location.href=url;
   	}
   	</script>
	<body>
		<table border="0">
			<tr>
				<td nowrap>
					<script type="text/javascript">
                var rootTree = new WebFXTree('系统模块');
				<s:iterator value="nodeList">
					<s:if test="isFolder">
						var node<s:property value="id"/>=new WebFXTreeItem("<s:property value="name"/>",<s:if test="url!=null&&url!=''">"javascript:fGoToPage('${path}<s:property value="url"/>')"</s:if><s:else>null</s:else>,null,null,true);
					</s:if>
					<s:else>
						var node<s:property value="id"/>=new WebFXTreeItem("<s:property value="name"/>",<s:if test="url!=null&&url!=''">"javascript:fGoToPage('${path}<s:property value="url"/>')"</s:if><s:else>null</s:else>);
					</s:else>
					<s:if test="pid==0">
					    rootTree.add(node<s:property value="id"/>);
					</s:if>
					<s:else>
						node<s:property value="pid"/>.add(node<s:property value="id"/>);
					</s:else>
				</s:iterator>

				document.write(rootTree);
                rootTree.expandAll();
            </script>
				</td>
			</tr>
		</table>
	</body>
</html>
