<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    <%--
      功能描述 ：登录页面
      
      Author : Wangjian
      Date   : 2008-06-23
      Time   : 15:47:22
      Version: 1.0
    --%>
<!DOCTYPE html>
    <head>
        <%@ include file="/WEB-INF/inc/head.inc"%>
        <link href="${path}/common/css/login.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">
			function changeValidateCode(obj) {   
				var timenow = new Date().getTime();   
				obj.src="${path}/account/account_generate.action?d="+timenow;   
			}
            function checkLoginForm(fm){
                var oError = document.getElementById("error");
                if(fm['account.username'].value.length == 0){
                    oError.innerHTML = "请输入用户名!";
                    fm['account.username'].focus();
                    return false;
                }
                if(fm['account.password'].value.length == 0){
                    oError.innerHTML = "请输入密码!";
                    fm['account.password'].focus();
                    return false;
                }
                if(fm['account.rand'].value.length == 0){
                    oError.innerHTML = "请输入验证码!";
                    fm['account.rand'].focus();
                    return false;
                }
                return true;
            }
            
            window.onload=function(){
            	document.getElementsByName("account.username")[0].focus();
                if(top.location.href!=location.href){
                    top.location.href=location.href;
                }
            }
        </script>
    </head>

    <body>
        <form action="${path}/account/account_login.action" method="post" onsubmit="return checkLoginForm(this);">  
        <table width="920" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    		<tr><td><b><i><font size="13px" color="#000000">欢迎使用城市一卡通 V2.0</font></i></b></td></tr>
                    		<tr><td>&nbsp;</td></tr>
                        <tr>
                            <td valign="middle">
                                <table width="98%" border="0" cellspacing="0" cellpadding="0" style="font-size: 12px;">
                                    <tr align="left">
                                    	<td colspan="2">
											<span id="error" style="color: red;"><s:property value="account.prompt"/></span>
										</td>
                                    </tr>
                                    <tr height="28">
                                        <td width="60" style="color:#0000ff">用户名：</td>
                                        <td><input style="width:162px;" length="25" type="text" name="account.username" value="<s:property value='account.username'/>" placeholder="请输入用户名"/></td>
                                    </tr>
                                    <tr height="28" style="color:#0000ff">
                                        <td width="60">密&nbsp;&nbsp;&nbsp;码：</td>
                                        <td><input style="width:162px;" length="25" type="password" name="account.password" value="<s:property value='account.password'/>" placeholder="请输入密码"/></td>
                                    </tr>
                                    <tr height="28" style="color:#0000ff">
                                        <td width="60">验证码：</td>
                                        <td><input style="width:90px;vertical-align:bottom;" length="6" type="text" name="account.rand" placeholder="请输入验证码"/>&nbsp;&nbsp;<img valign="bottom" src="${path}/account/account_generate.action" onclick="changeValidateCode(this)" title="点击图片刷新验证码"/></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" align="left"  style="padding-left:75px" class="table-button">
                                            <table>
                                                <tr>
                                                    <td><input name="Submit" type="submit" style="background-image:url(${path}/common/img/login04.jpg);" class="login01" value="&nbsp;&nbsp;&nbsp;&nbsp;登录"/></td>
                                                    <td><input name="Submit" type="reset" style="background-image:url(${path}/common/img/login04.jpg);" class="login01" value="&nbsp;&nbsp;&nbsp;&nbsp;重置"/></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>