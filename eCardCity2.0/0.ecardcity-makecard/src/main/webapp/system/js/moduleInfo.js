/*校验同一父模块下子模块名称是否重复*/

var repeat=false;

function fCheckModuleInfoIsRepeat(obj,id,defaultValue)
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
	DwrModuleInfoService.checkModuleInfoIsRepeat(obj.value,id,function (exist)
	{
		if(exist)
		{
			repeat=true;
			setInnerHTMLById("msg","<img src='"+getContextPath()+"/common/img/info.gif' border='0' title='同一父模块下名称重复!'>");
		}
		else
		{
			repeat=false;
			setInnerHTMLById("msg","<img src='"+getContextPath()+"/common/img/right.gif' border='0' title='名称可用!'>");
		}
	});
}

function fCheckTheForm(oForm)
{
	if(repeat)
	{
		alert("同一父模块下名称重复!");
		return false;
	}
	return formCheck(oForm);
}