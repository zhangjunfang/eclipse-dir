<%--
  功能描述 ：错误页面(调试所用)
  
  Author : Wangjian
  Date   : 2007-10-12
  Time   : 16:43:40
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
	<title>错误页面</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" /> 
    <script type="text/javascript">
        function showOrHiddenDebugInfo()
        {
            var odebugId = document.getElementById("debugId");
            var omsgId = document.getElementById("msgId");
            if (odebugId.style.display == "none")
            {
                odebugId.style.display = "block";
                omsgId.innerHTML = "隐藏调试信息";
            }
            else
            {
                odebugId.style.display = "none";
                omsgId.innerHTML = "显示调试信息";
            }
        }
    </script>
</head>
<body>
出错啦!&nbsp;&nbsp;<a href="javascript:showOrHiddenDebugInfo()" id="msgId">显示调试信息</a>
<br>
<br>
    <div id="debugId" style="display:none;">
        错误堆栈信息：
        <pre>
        <%
            exception.printStackTrace(new PrintWriter(out));
        %>
        </pre>    
    </div>
</body>
</html>