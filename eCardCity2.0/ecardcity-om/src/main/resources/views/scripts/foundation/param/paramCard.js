// 修改
function update(){		
    if(chkCheckbox(document.forms[0],true)){
	var dialog = art.dialog({id:"param",title:"修改参数",lock:true});// init
	// window
	jQuery("#form1").ajaxSubmit({
	    async: false,
	    url:"updateParamUI",
	    type : "post",
	    success:function(data){
		dialog.content(data);
	    }
	});
    }
}
// 参数分页支持
function reloadList(offset){
	var totalpage = jQuery("#totalpage").val();// 总分页数目
	if(offset == 0){  // 点击go触发
		offset = jQuery("#offset").val();
	}
	if(offset > parseInt(totalpage) && parseInt(totalpage) != 0){
		offset = totalpage;
	}
	var params = {offset:offset,cardtype:jQuery("#cardtype").val(),schStr:jQuery("#schStr").val()};// 拼json参数
	jQuery("#pageList").load("listParamUIData", params,null);
}
//添加卡类型
function addCard(){		
	var dialog = art.dialog({id:"param",title:"添加卡类型",lock:true});// init
	// window
	jQuery("#form1").ajaxSubmit({
	    async: false,
	    url:"addCardUI",
	    type : "post",
	    success:function(data){
	    	dialog.content(data);
	    }
	});
}
//修改卡类型
function updateCard(){		
    if(chkCheckbox(document.forms[0],true)){
		var dialog = art.dialog({id:"param",title:"修改卡类型",lock:true});// init
		// window
		jQuery("#form1").ajaxSubmit({
		    async: false,
		    url:"updateCardUI",
		    type : "post",
		    success:function(data){
		    	dialog.content(data);
		    }
		});
    }
}
//删除卡类型
function delCard(){
    if(chkCheckbox(document.forms[0],false)&&window.confirm('该操作将删除选定的卡类型，是否继续？')){
	jQuery("#form1").ajaxSubmit({
        	async: false,
        	url:"delCard",
        	dataType:'json',
        	type : "post",
        	success:function(data){
        	    if(data.success){
					location="listCard?pid="+jQuery("#pid").val();
        	    }else{
        	    	alert(data.msg);
        	    }
        	}
	});
    }
}
//提交卡类型
function submitCard(){
	if (isRepeat) {
		alert('该卡类型已存在！');
	}else if(fCheck(document.forms[0])){
		jQuery("#form1").ajaxSubmit({
			async: false,
			url:"saveCard",
			dataType:'json',
			type : "post",
			success:function(data){
				if(data.success){
					location="listCard?pid="+jQuery("#pid").val();
					art.dialog({id:'param'}).close();
				}else{
				    alert(data.msg);
				}
			}
		});
	}
}
//卡类型分页支持
function reloadListCard(offset){
	var totalpage = jQuery("#totalpage").val();// 总分页数目
	if(offset == 0){  // 点击go触发
		offset = jQuery("#offset").val();
	}
	if(offset > parseInt(totalpage) && parseInt(totalpage) != 0){
		offset = totalpage;
	}
	var params = {offset:offset,groupid:jQuery("#pid").val()};// 拼json参数
	jQuery("#pageList").load("listCardUIData", params,null);
}
//提交参数
function submitParam(){
	if(fCheck(document.forms[0])){
		jQuery("#form1").ajaxSubmit({
			async: false,
			url:"save",
			dataType:'json',
			type : "post",
			success:function(data){
				if(data.success){
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
// 得到卡类型树
function getCardTree(){
    var tmp="";
    jQuery.ajax({
		async: false,
		url : "ajaxGetCardTree",
		type : "post",
		dataType : 'json',
		success : function(data) {
			if (data.success) {
				tmp = eval ("(" + data.data + ")");
				} else {
					alert(data.msg);
			}
		}
	});
	return tmp;
}
//根据大类，得到卡类型列表
function getTypeList(){
    jQuery.ajax({
		async: false,
		url : "ajaxGetTypeList",
		data : {groupid:jQuery("#groupid").val()},
		type : "post",
		dataType : 'json',
		success : function(data) {
			if (data.success) {
					clearAllOptions(document.getElementById("cardFrom"));//清除当前选定的用户表
					var oOption = null;
					var rtnJSONObject = eval ("(" + data.data + ")");
					for(var i in rtnJSONObject){
					    //当前部门上级不能是当前部门及其下级部门
							oOption = new Option(rtnJSONObject[i].cardtypename, rtnJSONObject[i].id, false, false);
							document.getElementById("cardFrom").add(oOption);
					}
			}else {
					alert(data.msg);
			}
		}
	});
}
//检查卡类型是否存在
function cardTypeCheck(name,value){
    var tmp=false;
    jQuery.ajax({
		async: false,
		url : "ajaxGetCardTypeExists",
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