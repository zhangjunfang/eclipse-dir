<%--
  功能描述 ：标题栏
  
  Author : wangjian
  Date   : 2008-05-08
  Time   : 10:53:27
  Version: 1.0
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="${path}/common/img/frame/web_icon01.gif" width="11" height="8" align="middle"> 当前位置：
	  <script type="text/javascript">
	  var title=top.viewFrame.menuFrame.pageTitle.value;
	  document.write(title==undefined?"":title);
	  </script>	
	  </td>
    </tr>
 </table>