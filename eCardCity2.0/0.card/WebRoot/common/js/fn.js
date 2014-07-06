/***************************************
初始化Ajax http_request
***************************************/
var http_request = false;
function createXMLHttpRequest() {
    http_request = false;
    //开始初始化XMLHttpRequest对象
    if(window.XMLHttpRequest) { //Mozilla 浏览器
        http_request = new XMLHttpRequest();
        if (http_request.overrideMimeType) {//设置MiME类别
            http_request.overrideMimeType('text/html');
        }
    }
    else if (window.ActiveXObject) { // IE浏览器
        try {
            http_request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                http_request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {}
        }
    }
    if (!http_request) { // 异常，创建对象实例失败
        window.alert("不能创建XMLHttpRequest对象实例.");
        return false;
    }    
}
/***************************************
两个select之间进行copy
***************************************/
function selectcopy(source,target){
	target.length=0;
	for(var i=0;i<source.length;i++){
		var opt = source.options[i];
			target.options[target.options.length] = new Option(opt.text,opt.value,0,0);
	}
}

/***************************************
日历响应事件函数
***************************************/
function callCalendar(varobj){
	var showx = event.screenX - event.offsetX - 4 - 10 ; // + deltaX;
	var showy = event.screenY - event.offsetY -168; // + deltaY;
	retval = window.showModalDialog("/common/js/calendar/calendar.htm", "", "dialogWidth:197px; dialogHeight:210px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no;");
	if( retval != null ){
 		varobj.value = retval;
	}
}
/***************************************
判断是否有效的日期格式
***************************************/
function isDate(field){
	var splitStr="-";
	field.value=trim(field.value);
	var a=new Date(field.value);
	var myDay=a.getFullYear()+splitStr+(a.getMonth()+1)+splitStr+ a.getDate();
	if(myday!=field.value){
		alert("请输入有效的日期，格式为：yyyy-mm-dd！"); 
		field.focus();
		return false;
	}
	return true; 
}

/***************************************
比较两个日期的间隔天数
***************************************/
function dateCompare(startDate,endDate){
//	if(isDate(startDate) && isDate(endDate)){
		var miStart = Date.parse(startDate.value.replace(/\-/g, '/'));
		var miEnd = Date.parse(endDate.value.replace(/\-/g, '/'));
		var delayDay=(miEnd-miStart)/(1000*24*3600);
		if(delayDay<0){
			alert("“结束时间”不能在“开始时间”之前！");
			startDate.focus();
			return false;
		}
		return true;
	//}
}
/***************************************
是否选择所有记录
***************************************/
function chkAll(obj,chkName){
	for(var i=0; i<obj.form.elements.length; i++){
		if(FormName.elements[i].type=="checkbox" && FormName.elements[i].name==chkName){
			FormName.elements[i].checked=obj.checked;
		}
	}
}
/***************************************
检测CheckBox的选择是否有效
***************************************/
function checkboxSelect(FormName,isupdate){
	var total=0,count=0;
	for(var i=0; i<FormName.elements.length; i++){
		if(FormName.elements[i].type=="checkbox" && FormName.elements[i].name!=''){
			if(FormName.elements[i].checked){
				count++;
			}
			total++;
		}
	}
	if(total>0){
		if(count==0){
			alert('请选择可操作的记录！');
			return false;
		}
		if(isupdate==1 && count!=1){
			alert('一次只能操作一条记录！');
			return false;
		}
		return true;
	}else{
		return false;
	}
}
/***************************************
去掉字符串首空格
***************************************/
function ltrim(str){ 
	return str.replace(/^\s*/, ""); 
} 
/***************************************
去掉字符串尾空格
***************************************/
function rtrim(str){ 
	return str.replace(/\s*$/, ""); 
} 
/***************************************
去掉字符串首尾空格
***************************************/
function trim(str){
	return rtrim(ltrim(str));	
}
//判断是否正整数
function isPositiveNum(str){
    var reg=/^[0-9]*[1-9][0-9]*$/g;
	return reg.exec(str);
}
//判断是否正数
function isPositiveFloat(str){
	var reg=/^[0-9]+(\.[0-9]+)?$/g;
	return reg.exec(str);
}
//判断是否是货币以 *.00格式显示
function IsPositiveMoney(str){
	var reg=/^[0-9]+(\.[0-9]{1,2})?$/g;
	return reg.exec(str);
}
/***************************************
表单有效性验证
***************************************/
function formCheck(form){
	var formElement;
	for(var i=0; i<form.elements.length; i++){
		formElement=form.elements[i];
		//alert(formElement.value);
		if(!formElementCheck(formElement)){
			return false;
		}
	}
	return true;
}
/***************************************
表单文本框有效性验证,依据
Isblank		1:允许为空	0：拒绝为空
Maxlength	1:可输入字符串的最大长度
Tip			表单框提示标识
***************************************/
function formElementCheck(formElement){
	if(formElement.type=="text" || formElement.type=="password" || formElement.type=="textarea" || formElement.type=="select-one" ){
		//去除首尾空格
		formElement.value=trim(formElement.value);
		//判断是否为空
		if(formElement.Isblank=="0" && formElement.value.length==0){
			alert("“"+formElement.Tip+"”不能为空！");
			formElement.focus();
			return false;
		}
		//判断是否为正整数
		if(formElement.IsPositiveNum=="1"){
			if(formElement.Isblank=="0" || (formElement.Isblank!="0" && formElement.value!='')){
				if(!isPositiveNum(formElement.value)){
					alert("“"+formElement.Tip+"”为正整数！");
					formElement.focus();
					return false;
				}
			}
		}
		//判断是否为正数(正浮点数)
		if(formElement.IsPositiveFloat=="1"){
			if(formElement.Isblank=="0" || (formElement.Isblank!="0" && formElement.value!='')){
				if(!isPositiveFloat(formElement.value)){
					alert("“"+formElement.Tip+"”为正小数或正整数！");
					formElement.focus();
					return false;
				}
			}
		}
	
		//判断输入的货币是否是.00格式
		if(formElement.Isblank=="0" && formElement.IsPositiveMoney=="1"){
			if(formElement.Isblank=="0" || (formElement.Isblank!="0" && formElement.value!='')){
				if(!IsPositiveMoney(formElement.value)){
					alert("“"+formElement.Tip+"”为货币格式！");
					formElement.focus();
					return false;
				}
			}
		}


		//判断长度是否大于限制
		if(formElement.value.length!=0 && formElement.value.length>formElement.Maxlength){
			alert("“"+formElement.Tip+"”长度不能大于"+formElement.Maxlength+"！");
			formElement.focus();
			return false;
		}
	}
	return true;
}
/***************************************
鼠标移到该行时显示的颜色和指针
***************************************/
function MoveOver(color){
	window.event.srcElement.parentElement.style.backgroundColor = color;
	window.event.srcElement.parentElement.style.cursor = "hand";
}
/***************************************
鼠标移开该行时显示的颜色
***************************************/
function MouseOut(color){
	window.event.srcElement.parentElement.style.backgroundColor = color;
}
/***************************************
打开弹出式窗口
***************************************/
function openPopWindow(varUrl){		
	window.open(varUrl, "", "width=775,height=450,scrollbars=yes,resizable=yes,status=yes");
}

//对Email格式验证
function checkEmail(objEmail) {
	 var emailStr=objEmail.value;
   if (emailStr.length == 0) {
       return true;
   }
   var emailPat=/^(.+)@(.+)$/;
   var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]";
   var validChars="\[^\\s" + specialChars + "\]";
   var quotedUser="(\"[^\"]*\")";
   var ipDomainPat=/^(\d{1,3})[.](\d{1,3})[.](\d{1,3})[.](\d{1,3})$/;
   var atom=validChars + '+';
   var word="(" + atom + "|" + quotedUser + ")";
   var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
   var domainPat=new RegExp("^" + atom + "(\\." + atom + ")*$");
   var matchArray=emailStr.match(emailPat);
   if (matchArray == null) {
    	alert('Email格式错误！');
    	objEmail.focus();
       return false;
   }
   var user=matchArray[1];
   var domain=matchArray[2];
   if (user.match(userPat) == null) {
   		 alert('Email格式错误！');
    	objEmail.focus();  		
       return false;
   }
   var IPArray = domain.match(ipDomainPat);
   if (IPArray != null) {
       for (var i = 1; i <= 4; i++) {
          if (IPArray[i] > 255) {
    				 alert('Email格式错误！');              
    				 objEmail.focus();  		
             return false;
          }
       }
       return true;
   }
   var domainArray=domain.match(domainPat);
   if (domainArray == null) {
    	 alert('Email格式错误');                     	
    	 objEmail.focus();  		
       return false;
   }
   var atomPat=new RegExp(atom,"g");
   var domArr=domain.match(atomPat);
   var len=domArr.length;
   if ((domArr[domArr.length-1].length < 2) ||
       (domArr[domArr.length-1].length > 3)) {
    	 alert('Email格式错误！');           	
    	 objEmail.focus();  		
       return false;
   }
   if (len < 2) {
    	alert('Email格式错误！');       	
    	objEmail.focus();  		
       return false;
   }
   return true;
}

//防止重复提交
function check(objsub){		
    objsub.disabled='true';
    return true;
}


/***************************************
打印
***************************************/
function SetPrintSettings() {
// -- advanced features
factory.printing.SetMarginMeasure(2) // measure margins in inches
factory.SetPageRange(false, 1, 3) // need pages from 1 to 3
factory.printing.printer = "HP DeskJet 870C"
factory.printing.copies = 2
factory.printing.collate = true
factory.printing.paperSize = "A4"
factory.printing.paperSource = "Manual feed"

// -- basic features
factory.printing.header = "This is MeadCo"
factory.printing.footer = "Advanced Printing by ScriptX"
factory.printing.portrait = false
factory.printing.leftMargin = 1.0
factory.printing.topMargin = 1.0
factory.printing.rightMargin = 1.0
factory.printing.bottomMargin = 1.0
}



function printsetup(){
// 打印页面设置
wb.execwb(8,1);
}
function printpreview(){
// 打印页面预览
document.getElementById('printTable').style.display='none';
wb.execwb(7,1);
window.location.href=window.location.href;
window.location.reload;
//location.reload();

}

function printit()
{
//if (confirm('确定打印吗？')) {
document.getElementById('printTable').style.display='none';	
wb.execwb(6,6)
window.location.href=window.location.href;
window.location.reload;
//location.reload();	
//}
}
/***************************************
转换数字为中文
***************************************/
function number2chinese(num){
	var tmp="";
	switch(num){
	    case 0:
	    	tmp="〇";
	        break;
	    case 1:
	    	tmp="一";
	        break;
	    case 2:
	    	tmp="二";
	        break;
	    case 3:
	    	tmp="三";
	        break;
	    case 4:
	    	tmp="四";
	        break;
	    case 5:
	    	tmp="五";
	        break;
	    case 6:
	    	tmp="六";
	        break;
	    case 7:
	    	tmp="七";
	        break;
	    case 8:
	    	tmp="八";
	        break;
	    case 9:
	    	tmp="九";
	        break;
	    case 10:
	    	tmp="十";
	        break;
	    default:
	    	tmp=num;
	    	break;
	}
	return tmp;
}
