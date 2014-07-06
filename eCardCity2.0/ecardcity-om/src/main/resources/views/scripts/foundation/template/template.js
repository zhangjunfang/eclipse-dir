function getLineNo(){
	var lineNoElement=document.getElementsByName("line_no");
	var lineNoArray=new Array();
	var currMax=0;
	if(lineNoElement.length>0){
		for(var i=0;i<lineNoElement.length;i++){
			lineNoArray[i]=lineNoElement[i].value;
		}
		currMax=Math.max.apply(Math, lineNoArray);
	}
	for(var i=1;i<=currMax;i++){
		if(jQuery.inArray(i,eval("["+lineNoArray+"]"))<0){
			return i;
		}
	}
	return (parseInt(currMax)+1);
}
//添加param行
function addPara(){
	var lineNo=getLineNo();
	var row="<tr><input type='hidden' name='line_no' value='"+lineNo+"'><td>"+lineNo+"</td>";//行号
	row+="<td><select name='symbol_1' size='1'><option value='0' selected>0</option><option value='1'>1</option>" +
			"<option value='2'>2</option><option value='3'>3</option></select></td>";//字体大小
	row+="<td><select name='symbol_2' size='1'><option value='0'>0</option><option value='1' selected>1</option>" +
			"<option value='2'>2</option><option value='3'>3</option><option value='4'>4</option>" +
			"<option value='5'>5</option><option value='6'>6</option><option value='7'>7</option>" +
			"<option value='8'>8</option><option value='9'>9</option><option value='10'>10</option>" +
			"<option value='11'>11</option><option value='12'>12</option><option value='13'>13</option>" +
			"<option value='14'>14</option><option value='15'>15</option></select></td>";//字体灰度
	row+="<td><select name='symbol_3' size='1'><option value='0' selected>0</option><option value='1'>1</option>" +
			"<option value='2'>2</option><option value='3'>3</option><option value='4'>4</option>" +
			"<option value='5'>5</option><option value='6'>6</option><option value='7'>7</option>" +
			"<option value='8'>8</option><option value='9'>9</option><option value='10'>10</option>" +
			"<option value='11'>11</option><option value='12'>12</option><option value='13'>13</option>" +
			"<option value='14'>14</option><option value='15'>15</option></select></td>";//字间距
	row+="<td><select name='symbol_4' size='1'><option value='0' selected>0</option><option value='1'>1</option>" +
			"<option value='2'>2</option><option value='3'>3</option><option value='4'>4</option>" +
			"<option value='5'>5</option><option value='6'>6</option><option value='7'>7</option>" +
			"<option value='8'>8</option><option value='9'>9</option><option value='10'>10</option>" +
			"<option value='11'>11</option><option value='12'>12</option><option value='13'>13</option>" +
			"<option value='14'>14</option><option value='15'>15</option></select></td>";//行间距
	row+="<td><input type='text' style='width:130px;' name='print_title'  placeholder='该行打印显示标题' fTip='显示标题' fLength='0,30' fType=''/></td>";//显示标题
	row+="<td><select id='print_param' name='print_param' size='1'>"+paraStrs+"</select></td>";//参数值列表
	row+="<td><a id='del' onClick='jQuery(this).parent().parent().remove();' class='ld-btn ld-huise' style='cursor:pointer;'><img src='"+delImg+"'/>删除</a></td>";//删除按钮
	row+="</tr>";
	jQuery("#tb1 tr:last").after(row);
}
//添加
function add(){		
    var dialog = art.dialog({id:"param",title:"添加模板",lock:true});//init window
	    jQuery("#form1").ajaxSubmit({
		async: false,
		url:"addTemplate",
		type : "post",
		success:function(data){
		    dialog.content(data);
		}
    });
}
//修改
function update(){
	var dialog = art.dialog({id:"param",title:"修改模板",lock:true});//init window
	jQuery("#form1").ajaxSubmit({
	    async: false,
	    url:"updateTemplate",
	    type : "post",
		data : {template_type:jQuery("#templateType").val(),template_name:jQuery("#templateName").val()},
	    success:function(data){
	    	dialog.content(data);
	    }
	});
}
//连带参数在内的分页支持
function reloadList(offset){
	var totalpage = jQuery("#totalpage").val();//总分页数目
	if(offset == 0){  //点击go触发
		offset = jQuery("#offset").val();
	}
	if(offset > parseInt(totalpage) && parseInt(totalpage) != 0){
		offset = totalpage;
	}
	
	var params = {offset:offset,template_name:jQuery("#templateName").val()};//拼json参数
	jQuery("#pageList").load("listTemplateData", params,null);
}
//提交
function submit(){
	if (isRepeat) {
		alert('该名称的打印模板已存在！');
	} else if(fCheck(document.forms[0])){
		jQuery("#form1").ajaxSubmit({
			async: false,
			url:"save",
			dataType:'json',
			type : "post",
			success:function(data){
				if(data.success){
					getTemplateList(data.data);//刷新该类型下的列表模板，防止改名造成的不一致
				    reloadList(function(){
				    	art.dialog({id:'param'}).close();
				    });
				}else{
				    alert(data.msg);
				}
			}
		});
	}
}
//根据类型，得到模板列表
function getTemplateList(EleValue){
    jQuery.ajax({
		async: false,
		url : "ajaxGetTemplateList",
		data : {templateType:jQuery("#templateType").val()},
		type : "post",
		dataType : 'json',
		success : function(data) {
			if (data.success) {
				var oOption = null;
				clearAllOptions(document.getElementById("templateName"));
				var rtnJSONObject = eval("("+data.data +")");
				for(var i in rtnJSONObject){
					if(undefined!=EleValue && EleValue==rtnJSONObject[i].TEMPLATE_NAME){
						oOption = new Option(rtnJSONObject[i].TEMPLATE_NAME, rtnJSONObject[i].TEMPLATE_NAME, false, true);
					}else{
						oOption = new Option(rtnJSONObject[i].TEMPLATE_NAME, rtnJSONObject[i].TEMPLATE_NAME, false, false);
					}
					document.getElementById("templateName").add(oOption);
				}
			}else {
				alert(data.msg);
			}
		}
	});
}
//检查模板名称是否存在
function templateCheck(name,value){
    var tmp=false;
    jQuery.ajax({
		async: false,
		url : "ajaxTemplateCheck",
		data : {attrName:name,attrValue:value},
		type : "post",
		dataType : 'json',
		success : function(data) {
			if (data.success) {
			    tmp=data.data;
				} else {
					alert(data.msg);
			}
		}
	});
	return tmp;
}