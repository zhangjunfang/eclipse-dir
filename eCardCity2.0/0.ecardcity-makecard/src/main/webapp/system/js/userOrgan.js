/*保存为指定用户分配的角色信息*/
function fUserAddRole(){
	var oUserHaveRoleList=document.forms[0]['userHaveRoleInfoList'];
	if(!oUserHaveRoleList)
	{
		return;
	}
	var roleIdList=new Array();
	for(var i=0;i<oUserHaveRoleList.options.length;i++)
	{
		roleIdList.push(oUserHaveRoleList.options[i].value);
	}
	var userId=document.forms[0]['TOrgUser.id'].value;
	DwrUserOrganService.saveRoleToUser(userId,roleIdList,function(){
		alert("用户此次分配角色的操作成功!");
	});
}
//监测用户是否重复
var isRepeat=false;
function fCheckUserIsRepeat(userName,isUpdateMode,path){
	if(userName.length>0){
		DwrUserOrganService.checkUserIsRepeat(userName,function(_count){
			if((parseInt(_count)>1 && isUpdateMode) || (parseInt(_count)>0 && !isUpdateMode)){
				isRepeat=true;
				setInnerHTMLById("msg","<img src='"+path+"/common/img/info.gif' border='0' title='该用户已存在!'>");
			}else{
				isRepeat=false;
				setInnerHTMLById("msg","<img src='"+path+"/common/img/right.gif' border='0' title='该用户名可用!'>");
			}
		});
	}
}
//监测部门是否重复
isRepeat=false;
function fCheckDeptIsRepeat(deptName,isUpdateMode,path){
	if(deptName.length>0){
		DwrUserOrganService.checkDeptIsRepeat(deptName,function(_count){
			if((parseInt(_count)>1 && isUpdateMode) || (parseInt(_count)>0 && !isUpdateMode)){
				isRepeat=true;
				setInnerHTMLById("msg","<img src='"+path+"/common/img/info.gif' border='0' title='该名称已存在!'>");
			}else{
				isRepeat=false;
				setInnerHTMLById("msg","<img src='"+path+"/common/img/right.gif' border='0' title='该部门名可用!'>");
			}
		});
	}
}
//获取所有的部门列表
function getAllDept(selObj,selID){
	DwrUserOrganService.getEomsOrganInfoTreeNodeList(function (nodeList){
		if(!nodeList||nodeList.length==0){
			return;
		}
		var oOption = null;
		for(var i=0;i<nodeList.length;i++){
			oOption = new Option(nodeList[i].name, nodeList[i].id, false, false);
			if(nodeList[i].id==selID){
				oOption.setAttribute("selected","true");
			}
			selObj.add(oOption);
		}
	});
}