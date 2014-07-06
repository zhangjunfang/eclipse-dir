//得到无参数的URL
function getUrlNoParam(url)
{
	if(!url||url.length==0)
	{
		return "";
	}
	var idx=url.indexOf('?');
	if(idx==-1)
	{
		return url;
	}
	return url.substring(0,idx);
}

//得到URL的参数对
function getUrlParams(url)
{
	var params=new Array();
	if(!url||url.length==0)
	{
		return params;
	}
	var idx=url.indexOf('?');
	if(idx==-1)
	{
		return params;
	}
	url=url.substr(idx+1);
	var nameValues=url.split('&');
	for(var i=0;i<nameValues.length;i++)
	{
		var nameValue=nameValues[i];
		if(nameValue&&nameValue.length>0)
		{
			var idxEq=nameValue.indexOf('=');
			if(idxEq>-1)
			{
				params.push({name:nameValue.substr(0,idxEq),value:nameValue.substr(idxEq+1)});
			}
		}
	}
	return params;
}

//将URLGET请求转化为POST请求
function fGotoPage(url)
{
	var oForm=document.createElement("FORM");
	oForm.setAttribute("action",getUrlNoParam(url));
	oForm.setAttribute("method","post");
	var params=getUrlParams(url);
	for(var i=0;i<params.length;i++)
	{
		var oInput=document.createElement("INPUT");
		oInput.setAttribute("type","hidden");
		oInput.setAttribute("name",params[i].name);
		oInput.setAttribute("value",params[i].value);
		oForm.appendChild(oInput);
	}
	document.body.appendChild(oForm);
	oForm.submit();
}