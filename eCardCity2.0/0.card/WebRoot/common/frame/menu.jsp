<%--
  功能描述 ：框架导航页面
  
  Author : Wangjian
  Date   : 2008-05-05
  Time   : 14:18:07
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	<%@ include file="/WEB-INF/inc/head.inc"%>
	<link type="text/css" href="${path}/common/css/tree.css" rel="stylesheet">
   	<script type="text/javascript" src="${path}/common/js/frame/xtree.js"></script>
   	<script type="text/javascript" src="${path}/common/js/frame/frame.js"></script> 
	</head>
	<div id="pageTitle"></div>
	<body>
	<table border="0">
    <tr>
        <td nowrap>
            <script type="text/javascript">
                var rootTree = new WebFXTree('城市通V2.0');
                var _tmp;
				<s:iterator value="#session.menu">
					<s:if test="isFolder">
						var node<s:property value="id"/>=new WebFXTreeItem("<s:property value="name"/>",<s:if test="url!=null&&url!=''">"javascript:toURL('<s:property value="name"/>','${path}<s:property value="url"/>')"</s:if><s:else>null</s:else>,null,null,true);
					</s:if>
					<s:else>
						var node<s:property value="id"/>=new WebFXTreeItem("<s:property value="name"/>",<s:if test="url!=null&&url!=''">"javascript:toURL('<s:property value="name"/>','${path}<s:property value="url"/>')"</s:if><s:else>null</s:else>);
					</s:else>
					<s:if test="pid==0">
					    rootTree.add(node<s:property value="id"/>);
					    _tmp=node<s:property value="id"/>;
					</s:if>
					<s:else>
						node<s:property value="pid"/>.add(node<s:property value="id"/>);
					</s:else>
				</s:iterator>

				document.write(rootTree);
                _tmp.expand();
                rootTree.expand();
            </script>
	        </td>
	    </tr>
	</table>
	</body>
</html>	