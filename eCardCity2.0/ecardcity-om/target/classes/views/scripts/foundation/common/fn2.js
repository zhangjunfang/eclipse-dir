/***************************************
两个select之间进行copy
***************************************/
function selectCopy(source,target){
	target.length=0;
	for(var i=0;i<source.length;i++){
		var opt = source.options[i];
			target.options[target.options.length] = new Option(opt.text,opt.value,0,0);
	}
}
/***************************************
判断是否有效的日期格式
***************************************/
function isDate(field,splitFlag){
	field.value=trimLR(field.value);
	var a=new Date(field.value);
	var myDay=a.getFullYear()+splitFlag+(a.getMonth()+1)+splitFlag+ a.getDate();
	if(myday!=field.value){
		alert("请输入有效的日期，格式为：yyyy"+splitFlag+"mm"+splitFlag+"dd！"); 
		field.focus();
		return false;
	}
	return true; 
}

/***************************************
比较两个日期的间隔天数
***************************************/
function dateCompare(startDate,endDate){
	var miStart = Date.parse(startDate.value.replace(/\-/g, '/'));
	var miEnd = Date.parse(endDate.value.replace(/\-/g, '/'));
	var delayDay=(miEnd-miStart)/(1000*24*3600);
	if(delayDay<0){
		alert("“结束时间”不能在“开始时间”之前！");
		startDate.focus();
		return false;
	}
	return true;
}
/***************************************
是否选择所有记录
***************************************/
function chkAll(obj,chkName){
	for(var i=0;i<obj.form.elements.length;i++){
		if(obj.form.elements[i].type.toLowerCase()=="checkbox" && obj.form.elements[i].name==chkName){
			obj.form.elements[i].checked=obj.checked;
		}
	}
}
/***************************************
检测CheckBox的选择是否有效
***************************************/
function chkCheckbox(FormName,isupdate){
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
		if(isupdate && count!=1){
			alert('一次只能操作一条记录！');
			return false;
		}
		return true;
	}else{
		return false;
	}
}
//将选定的多个checkbox值用逗号连接为字符串
function convertChkToStr(chkElements){
	var rtnStr="";
	for(var i=0;i<chkElements.length;i++){
		if(chkElements[i].checked){
			rtnStr+=",";
			rtnStr+=chkElements[i].value;
		}
	}
	return rtnStr.substring(1, rtnStr.length);
}
//去掉字符串首尾空格
String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
};
//去掉字符串首尾空格
function trimLR(str){
	return str.replace(/^\s*/, "").replace(/\s*$/, ""); 
}
//判断是否IP地址
function isIP(str){
//	var reg=/^[1-255]\.[0-255]\.[0-255]\.[0-255]$/;
	var reg=/^([1-9]|[1-9]\d|1\d\d|2[0-5][0-5])((\.)(\d|[1-9]\d|1\d\d|2[0-5][0-5])){3}$/;
	return reg.test(str);
}
//判断是否E-mail
function isEmail(str){
	var reg=/^([^\s]+)\@([^\s]+)\.([a-zA-Z]{2,})$/;
	return reg.test(str);
}
//判断是否电话
function isPhone(str){
	var regPhone=/(^[1-9]\d{7}$)|(^0[1-9]\d{1,2}[\-|\s|\.][1-9]\d{6,7}$)/;
	var regMobile=/^0?1\d{10}$/;
	return (regPhone.test(str) || regMobile.test(str));
}
//判断是否邮编
function isPost(str){
	var reg=/^[1-9]\d{5}$/;
	return reg.test(str);
}
//判断是否身份证号
function isId(str){
	var reg=/^\d{17}[0-9|X|x]$/;
	return reg.test(str);
}
//判断是否中文，包括中文符号
function isChinese(str){
	var reg=/^[\u4E00-\u9FA5\-\_a-zA-Z]+$/;
	return reg.test(str);
}
//判断是否字母
function isChar(str){
    var reg=/^[a-zA-Z]+$/;
	return reg.test(str);
}
//判断是否单词（包括大小写字母、数字、-、_、.）
function isWord(str){
    var reg=/^[a-zA-Z][a-zA-Z0-9\-\_\.]+$/;
	return reg.test(str);
}
//判断是否数字
function isNum(str){
    var reg=/^\d+$/g;
	return reg.test(str);
}
//判断是否整数
function isInt(str){
    var reg1=/^[1-9]+[0-9]*$/g;
    var reg2=/^0$/g;
	return reg1.test(str) || reg2.test(str);
}
//判断是否实数
function isReal(str){
    var reg=/^[-+]?[0-9]+(\.[0-9]*)?$/g;
	return reg.test(str);
}
//判断是否时间
function isTime(str){
    var reg=/^(\d{1,2}\:\d{2})$/g;
	return reg.test(str);
}
//判断是否经纬度
function isLatitudeLongitude(str){
    var reg=/^(-?\d+\.\d+)\,(-?\d+\.\d+)$/g;
	return reg.test(str);
}
/***************************************
表单有效性验证
***************************************/
function fCheck(form){
	var formElement;
	for(var i=0; i<form.elements.length; i++){
		formElement=form.elements[i];
		if(!fElementCheck(formElement)){
			return false;
		}
	}
	return true;
}
/***************************************
表单文本框有效性验证,依据
fTip:
		表单提示框名称
fLength:
		()不验证m长度
		(m)只能m长度
		(m,)最少m长度
		(,n)最大n长度
		(m,n)最少m长度，最大n长度，n>m
fType:
		()不验证
		(ip)IP验证
		(char)字符验证
		(word)单词验证
		(num)数字验证
		(int)整数验证
		(real)实数验证
		(phone)电话验证
		(email)电子邮件验证
		(post)邮编验证
		(id)身份证验证
		(chinese)中文验证
		(time)时间验证
		(latitude-longitude)经纬度验证
***************************************/
function fElementCheck(ele){
	var tp=ele.type.toLowerCase();
	if(tp=="text" || tp=="password" || tp=="textarea" || tp=="select-one" ){
		//去除首尾空格
		ele.value=trimLR(ele.value);
		var tip=ele.getAttribute("fTip")!=null?ele.getAttribute("fTip"):"";
		//判断类型
		if(ele.getAttribute("fType")!=null && ele.value.length>0 && ele.getAttribute("fType").length>0){
				if(ele.getAttribute("fType")=="ip" && !isIP(ele.value)){
				alert("“"+tip+"”值不是有效的IP地址格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="char" && !isChar(ele.value)){
				alert("“"+tip+"”值不是有效的字符(英文大小写字母)格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="word" && !isWord(ele.value)){
				alert("“"+tip+"”值不是有效的字符格式(以字母开头的可包含字母及‘数字_-.’)格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="num" && !isNum(ele.value)){
				alert("“"+tip+"”值不是有效的数字格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="int" && !isInt(ele.value)){
				alert("“"+tip+"”值不是有效的整数格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="real" && !isReal(ele.value)){
				alert("“"+tip+"”值不是有效的实数格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="phone" && !isPhone(ele.value)){
				alert("“"+tip+"”值不是有效的电话号码格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="email" && !isEmail(ele.value)){
				alert("“"+tip+"”值不是有效的E-Mail地址格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="post" && !isPost(ele.value)){
				alert("“"+tip+"”值不是有效的邮编格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="id" && !isId(ele.value)){
				alert("“"+tip+"”值不是有效的身份证格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="chinese" && !isChinese(ele.value)){
				alert("“"+tip+"”值不是有效的汉字格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="latitude-longitude" && !isLatitudeLongitude(ele.value)){
				alert("“"+tip+"”值不是有效的经纬度格式！");
				ele.focus();
				return false;
			}
			if(ele.getAttribute("fType")=="time" && !isTime(ele.value)){
				alert("“"+tip+"”值不是有效的时间格式！");
				ele.focus();
				return false;
			}
		}
		
		//判断长度
		if(ele.getAttribute("fLength")!=null && ele.getAttribute("fLength").length>0){
			if(/^(\d+)$/.test(ele.getAttribute("fLength")) && ele.value.length!=RegExp.$1){
				alert("“"+tip+"”值长度只能为"+RegExp.$1+"！");
				ele.focus();
				return false;
			}
			if(/^(\d+)\,$/.test(ele.getAttribute("fLength")) && ele.value.length<RegExp.$1){
				alert("“"+tip+"”值长度最小为"+RegExp.$1+"！");
				ele.focus();
				return false;
			}
			if(/^\,(\d+)$/.test(ele.getAttribute("fLength")) && ele.value.length>RegExp.$1){
				alert("“"+tip+"”值长度最大为"+RegExp.$1+"！");
				ele.focus();
				return false;
			}
			if(/^(\d+)\,(\d+)$/.test(ele.getAttribute("fLength")) && (ele.value.length<RegExp.$1 || ele.value.length>RegExp.$2)){
				alert("“"+tip+"”值长度必须为"+RegExp.$1+"和"+RegExp.$2+"之间！");
				ele.focus();
				return false;
			}
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

function printit(){
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