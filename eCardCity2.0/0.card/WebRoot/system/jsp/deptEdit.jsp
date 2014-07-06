<%--
  功能描述 ：编辑部门
  
  Author : Wangjian
  Date   : 2013-09-00
  Time   : 15:31:20
  Version: 2.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="/page-tag"%>

<html>
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<link type="text/css" rel="stylesheet" href="${path}/common/css/main.css">
		<script type="text/javascript" src='${path}/common/plugins/My97DatePicker/WdatePicker.js'></script>
		<script type="text/javascript" src='${path}/dwr/interface/DwrUserOrganService.js'></script>
		<script type="text/javascript" src='${path}/dwr/engine.js'></script>
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		<script type="text/javascript" src="${path}/common/js/fn2.js"></script>
		<script type="text/javascript" src="${path}/system/js/userOrgan.js"></script>
		<script language="javaScript">
			//有效期输入框开关
			function disableExpiryDate(sel){
				var objExDate=document.getElementById("expiryDate_display");
				if(sel.value=="1"){
					objExDate.style.display="";
				}else{
					objExDate.style.display="none";
				}
			}
			//提交检测
			function submitCheck(frmObj){
				//IP域
				var ipObj=document.getElementsByName("eomsOrganInfo.loginIp")[0];
				ipObj.value=trimLR(ipObj.value);
				var ips=(ipObj.value).split(",");
				var ipValid=true;
				if(ipObj.value.length!=0){
					for(var i=0;i<ips.length;i++){
						ipValid=ipValid&&isIP(ips[i]);
						if(ipValid==false){
							alert("“"+ipObj.getAttribute("fTip")+"”值不是有效的IP地址格式！");
							ipObj.focus();
							return false;
						}
					}
				}
				//有效期
				var objValid=document.getElementsByName("eomsOrganInfo.valid")[0];
				var objExDate=document.getElementsByName("eomsOrganInfo.expiryDate")[0];
				if(objValid.value=="1"&&objExDate.value.length==0){
					alert("请输入有效期！");
					objExDate.focus();
					return false;
				}
				//表单
				return fCheck(frmObj);
			}
		</script>
	</head>
	<body> 
		<!-- 标题 -->
		<%@ include file="/WEB-INF/inc/title.inc"%>

		<!-- 工作区 -->
		<form name="f1" action="${path}/system/userOrganInfo_saveDept.action" method="post" onSubmit="if(isRepeat){alert('该部门已存在！');return false;}else{return submitCheck(this);}">
			<input type="hidden" name="act" value="<s:property value="act"/>"/>
			<input type="hidden" name="pid" value="<s:property value="eomsOrganInfo.pid"/>"/>
			<input type="hidden" name="eomsOrganInfo.id" value="<s:property value="eomsOrganInfo.id"/>"/>
			<table width="100%" align="center" class="table-list">
				<tr>
					<td>
						<table align="center" class="table-form">
							<tr>
								<s:if test="act=='add'">
									<td colspan="4" class="table-title">
										部门添加
									</td>
								</s:if>
								<s:else>
									<td colspan="4" class="table-title">
										部门修改
									</td>
								</s:else>
							</tr>
							<tr>
								<td class="table-list_title">名称</td>
								<td>
									<s:if test="act=='add'">
									<input value="<s:property value="eomsOrganInfo.deptName"/>" name="eomsOrganInfo.deptName" type="text" fTip="名称" fLength="3,25" fType="chinese" onBlur="this.value=this.value.trim();fCheckDeptIsRepeat(this.value,false,'${path}');"/><s:text name="system.required" /><span id="msg"></span>
									</s:if>
									<s:else>
									<input value="<s:property value="eomsOrganInfo.deptName"/>" name="eomsOrganInfo.deptName" type="text" fTip="名称" fLength="5,25" fType="chinese" onBlur="this.value=this.value.trim();fCheckDeptIsRepeat(this.value,true,'${path}');"/><s:text name="system.required" /><span id="msg"></span>
									</s:else>
								</td>
								<td class="table-list_title">编码</td>
								<td>
									<input value="<s:property value="eomsOrganInfo.code"/>" name="eomsOrganInfo.code" type="text" fTip="编码"
										fLength="5,25" fType="word" /><s:text name="system.required" />
								</td>
							</tr>
							<tr>
								<td class="table-list_title">上级部门</td>
								<td><select name="eomsOrganInfo.pid" class="common-select" style="width:200px"></select></td>
								<td class="table-list_title">联系地址</td>
								<td>
									<input value="<s:property value="eomsOrganInfo.address"/>" name="eomsOrganInfo.address" type="text" fTip="联系地址" fLength=",50" fType=""/>
								</td>
							</tr>
							<tr>
								<td class="table-list_title">状态</td>
								<td>
									<select name="eomsOrganInfo.valid" class="common-select" style="width:90px" onChange="disableExpiryDate(this);">
										<option value="1" <s:if test="eomsOrganInfo==null || eomsOrganInfo.valid==1">selected="true"</s:if>>有效</option>
										<option value="0" <s:if test="eomsOrganInfo.valid==0">selected="true"</s:if>>无效</option>
									</select>
									<span id="expiryDate_display">
										&nbsp;&nbsp;有效期至
										<input type="text" name="eomsOrganInfo.expiryDate"
											value="<s:date name="eomsOrganInfo.expiryDate" format="yyyy-MM-dd" />"
											class="Wdate" onClick="WdatePicker()"
											readonly="readonly" style="width:85px"><s:text name="system.required"/>
									</span>
								</td>
								<td class="table-list_title">限制登录IP</td>
								<td>
									<input value="<s:property value="eomsOrganInfo.loginIp"/>" name="eomsOrganInfo.loginIp" type="text" fTip="限制登录IP" fLength=",100" fType=""/><span class="red">多个IP地址用“,”分隔，不填写表示不限制</span>
								</td>								
							</tr>
							<tr>
								<td class="table-list_title">联系电话</td>
								<td>
									<input value="<s:property value="eomsOrganInfo.phone"/>" name="eomsOrganInfo.phone" type="text" fTip="电话" fLength=",20" fType="phone" />
								</td>
								<td class="table-list_title">电子信箱</td>
								<td>
									<input value="<s:property value="eomsOrganInfo.email"/>" name="eomsOrganInfo.email" type="text" fTip="电子信箱" fLength=",20" fType="email" />
								</td>
							</tr>
							<tr>
								<td class="table-list_title">备注</td>
								<td colspan="3">
									<textarea class="text-area" cols="65" rows="5" name="eomsOrganInfo.remark" fTip="备注" fLength=",100" fType=""><s:property value="eomsOrganInfo.remark"/></textarea>
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
			var id="<s:property value="eomsOrganInfo.pid"/>";
			getAllDept(document.getElementsByName("eomsOrganInfo.pid")[0],id);
			
			disableExpiryDate(document.getElementsByName("eomsOrganInfo.valid")[0]);
		</script>
	</body>
</html>

