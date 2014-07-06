//连带参数在内的分页支持
function reloadList(offset){
	var totalpage = jQuery("#totalpage").val();//总分页数目
	if(offset == 0){  //点击go触发
		offset = jQuery("#offset").val();
	}
	if(offset > parseInt(totalpage) && parseInt(totalpage) != 0){
		offset = totalpage;
	}
	var netsiteid=jQuery("#netsiteid").val();
	var termName=jQuery("#termName").val().trim();
	var mainMenu=jQuery("#mainMenu").val().trim();
	var paramVer=jQuery("#paramVer").val().trim();
	var params = {offset:offset,netsiteid:netsiteid,termName:termName,mainMenu:mainMenu,paramVer:paramVer};// 拼json参数
	jQuery("#pageList").load("listMenuData", params,null);
}
//添加
function add(){		
    var dialog = art.dialog({id:"param",title:"添加终端自定义菜单",lock:true});//init window
	    jQuery("#form1").ajaxSubmit({
		async: false,
		url:"addMenu",
		type : "post",
		success:function(data){
		    dialog.content(data);
		}
    });
}
//修改
function update(){
    if(chkCheckbox(document.forms[0],true)){
		var dialog = art.dialog({id:"param",title:"修改终端自定义菜单",lock:true});//init window
		jQuery("#form1").ajaxSubmit({
		    async: false,
		    url:"updateMenu",
		    type : "post",
		    success:function(data){
		    	dialog.content(data);
		    }
		});
    }
}
//删除
function del(){
    if(chkCheckbox(document.forms[0],false)&&window.confirm('该操作将删除选定的自定义菜单（包括一级菜单及全部二级菜单），是否继续？')){
    	jQuery("#form1").ajaxSubmit({
        	async: false,
        	url:"delMenu",
        	dataType:'json',
        	type : "post",
        	success:function(data){
        	    if(data.success){
        	    	reloadList();
        	    }else{
        	    	alert(data.msg);
        	    }
        	}
    	});
    }
}
//生成行号
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
//生成按键1---8
function generateOption(selectedValue){
	var str="";
	for(var i=1;i<9;i++){
		if(selectedValue==i){
			str+="<option value='"+i+"' selected>"+i+"</option>";
		}else{
			str+="<option value='"+i+"'>"+i+"</option>";
		}
	}
	return str;
}
//添加子菜单行
function addSubMenu(){
	var lineNo=getLineNo();
	if(lineNo>8){
		window.alert("最多只能有8个二级菜单！");
		return;
	}
	var row="<tr><input type='hidden' name='line_no' value='"+lineNo+"'>";//行号
	row+="<td><input type='text' style='width:15px;' value='"+lineNo+"' name='sub_id' size='2' fTip='二级菜单编号' fLength='1,2' fType='num'/><span class='red'>*</span></td>";//编号
	row+="<td><input type='text' style='width:50px;' name='sub_menu' size='8' fTip='二级菜单名称' fLength='1,8' fType=''/><span class='red'>*</span></td>";//名称
	row+="<td>"+lineNo+"</td>";//响应一级菜单按键
	row+="<td><select name='sub_trade_type' size='1'>"+paraTradeTypeStrs+"</select></td>";//交易类型
	row+="<td><select name='sub_acl_location' size='1'>"+paraPermLocStrs+"</select></td>";//权限列表位置
	row+="<td><select name='sub_acl_setting' size='1'><option value='1'>只允许先刷卡</option>" +
		 "<option value='2'>只允许先输号码</option><option value='3'>刷卡和输号码都允许</option></select></td>";//刷卡设置
	row+="<td><a id='del' onClick='jQuery(this).parent().parent().remove();' class='ld-btn ld-huise' style='cursor:pointer;'><img src='"+delImg+"'/>删除</a></td>";//删除按钮
	row+="</tr>";
	jQuery("#tb1 tr:last").after(row);
}

//提交复制模板
function submitAdd(){
	if (isRepeat) {
		alert('该名称的打印模板已存在！');
	} else if(fCheck(document.forms[0])){
		jQuery("#form1").ajaxSubmit({
			async: false,
			url:"saveMenuAdd",
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

//根据终端得到已用的权限位置列表
function getPermLocList(){
	jQuery('#tb1 tr:gt(0)').remove();//选择的终端改变时，要删除已生成的二级菜单
    jQuery.ajax({
		async: false,
		url : "ajaxGetPermLocList",
		data : {termid:jQuery("#termid").val()},
		type : "post",
		dataType : 'json',
		success : function(data) {
			if (data.success) {
				var rtnJSONObject = eval ("(" + data.data + ")");
				paraPermLocStrs="";
				for(var i in rtnJSONObject){
					paraPermLocStrs+="<option value='"+rtnJSONObject[i].P_VALUE+"'>"+rtnJSONObject[i].TITLE_NAME+"</option>";
				}
			}else {
				alert(data.msg);
			}
		}
	});
}
//根据商户得到终端列表
function getTermList(){
    jQuery.ajax({
		async: false,
		url : "ajaxGetTermList",
		data : {netsiteid:jQuery("#netsiteid").val()},
		type : "post",
		dataType : 'json',
		success : function(data) {
			if (data.success) {
				var oOption = null;
				clearAllOptions(document.getElementById("termid"));
				var rtnJSONObject = eval ("(" + data.data + ")");
				for(var i in rtnJSONObject){
					oOption = new Option(rtnJSONObject[i].termname, rtnJSONObject[i].id, false, false);
					document.getElementById("termid").add(oOption);
				}
				getPermLocList();//重新获取权限位置列表
			}else {
				alert(data.msg);
			}
		}
	});
}
//检查模板名称是否存在
function menuCheck(name,value){
    var tmp=false;
    jQuery.ajax({
		async: false,
		url : "ajaxMenuCheck",
		data : {termid:jQuery("#termid").val(),attrName:name,attrValue:value},
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