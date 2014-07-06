
//隐藏鼠标指向连接时地址栏的显示内容
function hideinfo(){ 
 if(event.srcElement.tagName=="A"){//如果触发函数的对象是链接 
//设置状态栏的显示为链接的文本 
    window.status=event.srcElement.innerText 
} 
} 
document.attachEvent("onmouseover",hideinfo);          //鼠标移上时调用 hideinfo 函数 
document.attachEvent("onmousemove",hideinfo);         //鼠标移动时调用 hideinfo 函数 
document.attachEvent("onmousedown",hideinfo);        //鼠标按下时调用 hideinfo 函数 




//------------------------------
//清除控件的值，有多个控件，用“,"分隔
//Ex. onclick="clearValue('user_name[,password[...]]')";
//------------------------------
function clearValue(f){
		objs=f.split(",");
		
		for (i=0;i<objs.length;i++){
			obj=objs[i];
			var tarObj=document.all(obj);		
			if(tarObj!=undefined){
				tarObj.value="";		
			}
		}
	}	
//------------------------------	
//以下几行功能为当鼠标指经过该行时，将该行的颜色变为浅黄色
//------------------------------
var autoColor="";

function mouseMove(obj){
//alert(autoColor);
	autoColor=obj.style.backgroundColor;
	obj.style.backgroundColor="#FFFFCC";
//alert(autoColor);

}

function mouseOut(obj){
//alert(autoColor);
//alert(obj.style.backgroundColor);
	obj.style.backgroundColor=autoColor;
}
//------------------------------
//刷新父窗口
function refreshparent() { 
window.opener.location.reload(); 
}
//------------------------------
//打开窗口
//------------------------------
function openWin(url,width,height){
		
		window.open(url,"_blank","scrollbars =yes,resizable =yes,status =yes,width="+width+",height="+height);
	}
//------------------------------
//打开查询详细内容的页面
//------------------------------
function openLookDetail(url,width,height){
	
	window.open(url,"详细内容","width="+width+",height="+height+",toolbar=0,status=0,menubar=0,left=300,top=100,resize=0,scrollbars =yes");	
	}
//------------------------------
//打开日期对话框
//------------------------------
function openCalendar(obj)
	{
    	var Ret = window.showModalDialog("../../js/calendardlg.htm","","dialogWidth=200px;dialogHeight=210px;status=no;");
		if (Ret)
		{
			if(typeof(obj)=="object")obj.value=Ret;
			else document.all(obj).value=Ret;
		}
	}	
	
//可以控制位置的  dialogTop:number 
function openCalendarbyuser(obj,top,left)
{
	var Ret = window.showModalDialog("/common/html/calendar/calendardlg.htm","","dialogWidth=200px;dialogHeight=210px;dialogTop:"+top+"px;dialogLeft:"+left+"px;status=no;");
		if (Ret)
		{
			if(typeof(obj)=="object")obj.value=Ret;
			else document.all(obj).value=Ret;
		}
}



//返回今天的日期，YYYY-MM-DD格式
function getToday(){
	var s="";
	d = new Date();
	s += (d.getYear()) + "-";
	s += d.getMonth() + 1+ "-";
	s += d.getDate() ;
	return(s);
}

/******************** 
函数名称：StrLenthByByte 
函数功能：计算字符串的字节长度，即英文算一个，中文算两个字节 
函数参数：str,为需要计算长度的字符串 
********************/ 

function StrLenthByByte(str) 
{ 
var len; 
var i; 
len = 0; 
for (i=0;i<str.length;i++) 
{ 
if (str.charCodeAt(i)>255) len+=2; else len++; 
} 
return len; 
} 
//---------------------------------
//检验十六进制数据调用一系列的方法
function isCharsInBagEn (s, bag) 
{ 
	var i,c; 
	for (i = 0; i < s.length; i++) 
	{ 
		c = s.charAt(i);//字符串s中的字符 
		if (bag.indexOf(c) <0) 
		return c; 
	} 
	return ""; //包含该字符，真
} 

function isInEnglish(s) 
{ 
	var errorChar; 
	var badChar = "ABCDEF"; 
	errorChar = isCharsInBagEn( s, badChar) 
	if (errorChar != "" ) 
	{ 
		//alert("请重新输入英文\n"); 
		return false; 
	} 
	return true; 
} 
function isnum(s) 
{ 
	var errorChar; 
	var badChar = "0123456789"; 
	errorChar = isCharsInBagEn( s, badChar) 
	if (errorChar != "" ) 
	{ 
	//alert("请重新输入英文\n"); 
	return false; 
	} 
	return true;
}

function chek16Num(s)
{
	var i,strs;
	for (i = 0; i < s.length; i++) 
	{
		strs = s.charAt(i);//字符串s中的字符
		//alert("strs="+strs);
		if(!(isInEnglish(strs)||isnum(strs)))
		{
			return false;	
			break;
		}						
	}	
	return true;
}
//*********************************
//校验DDF信息
function checkDDF(s)
{
	var ddfs=s.split("-");	
	var i=ddfs.length;
	/*alert("i=="+i);
	alert("ddfs[i-1]=="+ddfs[i-1]);
	alert("ddfs[i-2]=="+ddfs[i-2]);*/
	
	
	if(!(i==3||i==4))
	{
		alert("DDF信息数据格式:S1-S2-N1-N2或S1-N1-N2(其中N1，N2必须为数字,N1取值范围:1-12,N2取值范围:1-8)！");
		return false;		
	}
	
	//N1
	var n1=ddfs[i-2];
	if(!(n1>=1&&n1<=12))
	{
		alert("N1取值范围:1~12！");
		return false;		
	}
	//N2
	var n2=ddfs[i-1];	
	if(!(n2>=1&&n2<=8))
	{
		alert("N2取值范围:1~8");
		return false;
	}	
	
	return true;
}
//*********************************

//*********************************
//校验网元为关口局的端口的DDF信息,
function checkDDFOfDport(s)
{
	var ddfs=s.split("-");	
	var i=ddfs.length;
	/*alert("i=="+i);
	alert("ddfs[i-1]=="+ddfs[i-1]);
	alert("ddfs[i-2]=="+ddfs[i-2]);*/
	
	
	if(!(i==3||i==4))
	{
		alert("DDF信息数据格式:S1-S2-N1-N2或S1-N1-N2(其中N1，N2必须为数字,N1取值范围:1-16,N2取值范围:1-8)！");
		return false;		
	}
	
	//N1
	var n1=ddfs[i-2];
	if(!(n1>=1&&n1<=16))
	{
		alert("N1取值范围:1~16！");
		return false;		
	}
	//N2
	var n2=ddfs[i-1];	
	if(!(n2>=1&&n2<=8))
	{
		alert("N2取值范围:1~8");
		return false;
	}	
	
	return true;
}
//*********************************

//--------------------------------
//author: 胡烨
//显示一个提示信息，信息显示在页面左上角，红底白字
//Ex.显示信息：
//StateWindow.showMsg("正在读取，请稍候...");   
//隐藏信息：
//StateWindow.hideMsg();
//--------------------------------
function StateWindow(){
	
}
	StateWindow._div;
	
	StateWindow.init=function(){
		var divHtml="<div id='_stateMsgDiv' name='_stateMsgDiv' style='position: absolute; left: 0px; top: 0px; width: 100%;  display:'>"+
			"</div>";
		StateWindow._div=document.createElement(divHtml);
		document.body.appendChild(StateWindow._div);
		
		var tableHtml=
			"			<table align='left' class='' style='background-color:'  cellpadding=3 align='center' border='0' cellpadding='1' bgcolor='#ff0000'>"+
			"				<tr>"+
			"					<td bgcolor='#ff0000' id='_msgTd' name='_msgTd' style='color: #FFFFFF;font-size: 14px'></td>"+
			"				</tr>"+
			"			</table>"
		StateWindow._div.innerHTML=tableHtml;
	}
	
	
	StateWindow.showMsg=function (msg){
		if(StateWindow._div==undefined)StateWindow.init();
		$("_msgTd").innerText=msg;
		StateWindow._div.style.display="";
	}
	
	StateWindow.hideMsg=function (){
		StateWindow._div=$("_stateMsgDiv");
		if(StateWindow._div==undefined)return ;
		StateWindow._div.style.display="none";
	}
	
	
	
//--------------------------------
//author: 胡烨
//选择所有复选框
//checkboxes 要改变状态的复选框名称，必须是同一个名字
//要点击的复选框对象
//Ex. onclick="selectAllCheckBoexes("boxes",this);
//--------------------------------
function selectAllCheckBoexes(checkboxes,selectKey)
{
	
	ccs=document.all[checkboxes];
	if(ccs!=undefined){
	
		l=ccs.length;
		bb=selectKey.checked;
		if (l==undefined){
			if(ccs.checked==!bb)ccs.click();
		}else{
			for (i=0;i<l;i++){
				if(ccs[i].checked==!bb)ccs[i].click();
			}
		}
	}
} 
//--------------------------
function fnCheckTime() {   
     var startDate=document.all.startDate.value;
	 var endDate=document.all.endDate.value;
	 //当前日期
	 	var  alldate=new Date();
		var n_month= alldate.getMonth()+1;
		var n_date = alldate.getDate();
		if( n_month<10 )
		  {	n_month = "0"+n_month;
		  		//alert (n_month);
		  }
		 if ( n_date<10  )
		  {
			   n_date = "0"+ n_date;
			   //	alert (n_date);
		  } 		  
		  n_dateTime = alldate.getFullYear()+"-"+ n_month+"-"+ n_date;
		  //alert ( "n_dateTime="+n_dateTime);
	 
		 if(startDate==""&&endDate!="")
		 {
			 alert("请选择开始日期！");
			 document.all.startDate.focus();
			 return false;
		 }
			 if(startDate!=""&&endDate=="")
		 {
			 alert("请选择截止日期！");
			 document.all.endDate.focus();
			 return false;
		 }
		 if ( startDate>n_dateTime ) 
		 {
		 		alert("您选择的开始日期不能大于当天日期！");
				document.all.startDate.focus();
				 return false;
		 }
		 if ( endDate>n_dateTime ) 
		 {
		 		alert("您选择的截止日期不能大于当天日期！");
				document.all.endDate.focus();
				 return false;
		 }
		 if( startDate>endDate )
		 {
		 		alert("选择开始日期不能大于截止日期！");
				document.all.startDate.focus();
			 	return false;	
		 }
		 return true;		 	 		
    }    
	//-------------------------
	function fucCheckNUM(NUM)
	{
		var i,j,strTemp;
		strTemp="0123456789";
		if ( NUM.length== 0)
			return 0
		for (i=0;i<NUM.length;i++)
		{
			j=strTemp.indexOf(NUM.charAt(i));    
			if (j==-1)
			{
			//说明有字符不是数字
				return 0;
			}
		}
		//说明是数字
		return 1;
	} 
	//-----------------
	//检查ip地址
	function isip(s){ 
		var check=function(v){try{return (v<=255 && v>=0)}catch(x){return false}}; 
		var re=s.split(".") 
		return (re.length==4)?(check(re[0]) && check(re[1]) && check(re[2]) && 
		check(re[3])):false 
	} 
	
	
	
	//--------------
	//检查eamil
	function ismail(mail) 
      { 
        return(new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/).test(mail)); 

      } 
	
	
	
	
	//最后一次选择的网元
	var LAST_SELECT_NE;
	//最后一次选择的网元相应的城市对象
	var LAST_SELECT_CITY;
	//最后一次选择的网元相就在的站点对象
	var LAST_SELECT_STATION;

	//最后一次选择的端口
	var LAST_SELECT_PORT;
	//最后一次选择的信令端口
	var LAST_SELECT_LINKPORT;
	
	/*
	 * 选择中继端口，选择框根据用户权限对网元过滤
	 * neName      “网元名称”输入框的name
	 * neId        “网元ID”输入框的name
	 * portName    “端口名称”输入框的name
	 * portId      “端口ID”输入框的name
	 */
	function selectPortDialogFilter(neName,neId,portName,portId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp?privFilter=privFilter","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var port=reval.port;
			var city=reval.city;
			var station=reval.station;


			if(ne!=undefined&&port!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_PORT=port;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;

				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				var portNameObj=document.all(portName);
				var portIdObj=document.all(portId);
				
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
				if(port.portNo!=undefined&&portNameObj!=undefined)portNameObj.value=port.portNo;
				if(port.portId!=undefined&&portIdObj!=undefined)portIdObj.value=port.portId;
				
				
			}
			
			
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_PORT=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}
	}
	
	/*
	 * 选择中继端口
	 * neName      “网元名称”输入框的name
	 * neId        “网元ID”输入框的name
	 * portName    “端口名称”输入框的name
	 * portId      “端口ID”输入框的name
	 */
	function selectPortDialog(neName,neId,portName,portId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var port=reval.port;
			var city=reval.city;
			var station=reval.station;

			if(ne!=undefined&&port!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_PORT=port;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;

				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				var portNameObj=document.all(portName);
				var portIdObj=document.all(portId);
				
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
				if(port.portNo!=undefined&&portNameObj!=undefined)portNameObj.value=port.portNo;
				if(port.portId!=undefined&&portIdObj!=undefined)portIdObj.value=port.portId;
				
				
			}
			
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_PORT=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}

	}
	
	/*
	 * 选择信令端口，选择框根据用户权限对网元过滤
	 * neName      “网元名称”输入框的name
	 * neId        “网元ID”输入框的name
	 * portName    “信令端口名称”输入框的name
	 * portId      “信令端口ID”输入框的name
	 */
	function selectLinkPortDialogFilter(neName,neId,portName,portId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp?privFilter=privFilter","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var port=reval.linkPort;
			var city=reval.city;
			var station=reval.station;

			if(ne!=undefined&&port!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_LINKPORT=port;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;


				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				var portNameObj=document.all(portName);
				var portIdObj=document.all(portId);
				
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
				if(port.linkModuleNo!=undefined&&portNameObj!=undefined)portNameObj.value=port.linkModuleNo;
				if(port.linkPortId!=undefined&&portIdObj!=undefined)portIdObj.value=port.linkPortId;
				
				
			}
			
			
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_LINKPORT=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}
	}
	
	/*
	 * 选择信令端口
	 * neName      “网元名称”输入框的name
	 * neId        “网元ID”输入框的name
	 * portName    “端口名称”输入框的name
	 * portId      “端口ID”输入框的name
	 */
	function selectLinkPortDialog(neName,neId,portName,portId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var port=reval.linkPort;
			var city=reval.city;
			var station=reval.station;

			if(ne!=undefined&&port!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_LINKPORT=port;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;

				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				var portNameObj=document.all(portName);
				var portIdObj=document.all(portId);
				
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
				if(port.portNo!=undefined&&portNameObj!=undefined)portNameObj.value=port.portNo;
				if(port.portId!=undefined&&portIdObj!=undefined)portIdObj.value=port.portId;
				
				
			}
			
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_LINKPORT=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}
	}
	
	
	
	/*
	 * 选网元，选择框根据用户权限过滤网元列表
	 * neName      “网元名称”输入框的name
	 * neId        “网元ID”输入框的name
	 * portName    “端口名称”输入框的name
	 * portId      “端口ID”输入框的name
	 */
	function selectNeDialogFilter(neName,neId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp?privFilter=privFilter","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var city=reval.city;
			var station=reval.station;

			if(ne.neId!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;
				
				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
			}else{
				LAST_SELECT_NE=undefined;
			}
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}
	}
	
	
	/*
	 * 选网元
	 * neName      “网元名称”输入框的name
	 * neId        “网元ID”输入框的name
	 * portName    “端口名称”输入框的name
	 * portId      “端口ID”输入框的name
	 */
	function selectNeDialog(neName,neId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var city=reval.city;
			var station=reval.station;

			if(ne.neId!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;
				
				
				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
			}else{
				LAST_SELECT_NE=undefined;
			}
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}
	}
