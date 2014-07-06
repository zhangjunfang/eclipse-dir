/*校验角色类型是否重复*/

var repeat=false;

function fCheckRoleInfoIsRepeat(obj,defaultValue)
{
	obj.value=obj.value.trim();
	if(obj.value.length==0)
	{
		repeat=false;
		setInnerHTMLById("msg","");
		if(defaultValue&&defaultValue.length>0)
		{
			obj.value=defaultValue;
		}
		return;
	}
	if(defaultValue&&defaultValue.length>0&&obj.value==defaultValue)
	{
		repeat=false;
		setInnerHTMLById("msg","");
		return;
	}
	DwrRoleInfoService.checkRoleInfoIsRepeat(obj.value,function (exist)
	{
		if(exist)
		{
			repeat=true;
			setInnerHTMLById("msg","<img src='"+getContextPath()+"/common/img/info.gif' border='0' title='角色类型名称重复!'>");
		}
		else
		{
			repeat=false;
			setInnerHTMLById("msg","<img src='"+getContextPath()+"/common/img/right.gif' border='0' title='角色类型名称可用!'>");
		}
	});
}

function fCheckTheForm(oForm)
{
	if(repeat)
	{
		alert("角色类型名称重复");
		return false;
	}
	return formCheck(oForm);
}