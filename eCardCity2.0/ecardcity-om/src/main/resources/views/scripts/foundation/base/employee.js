//连带参数在内的分页支持
function reloadList(offset){
	var totalpage = jQuery("#totalpage").val();//总分页数目
	if(offset == 0){  //点击go触发
		offset = jQuery("#offset").val();
	}
	if(offset > parseInt(totalpage) && parseInt(totalpage) != 0){
		offset = totalpage;
	}
	var netsite_id=jQuery("#wdid").val().trim();
	var params = {offset:offset,netsite_id:netsite_id};// 拼json参数
	jQuery("#pageList").load("listEmployeeData", params,null);
}
//添加
function add(){		
    var dialog = art.dialog({id:"netsite",title:"添加网点操作员",lock:true});//init window
	    jQuery("#form1").ajaxSubmit({
		async: false,
		url:"addEmployee",
		type : "post",
		success:function(data){
		    dialog.content(data);
		}
    });
}
//修改
function update(){
    if(chkCheckbox(document.forms[0],true)){
		var dialog = art.dialog({id:"netsite",title:"修改网点操作员",lock:true});//init window
		jQuery("#form1").ajaxSubmit({
		    async: false,
		    url:"updateEmployee",
		    type : "post",
		    success:function(data){
		    	dialog.content(data);
		    }
		});
    }
}
//删除
function del(){
    if(chkCheckbox(document.forms[0],false)&&window.confirm('该操作将删除选定的网点操作员，是否继续？')){
    	jQuery("#form1").ajaxSubmit({
        	async: false,
        	url:"del",
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
//提交
function submit(){
	if(fCheck(document.forms[0])){
		jQuery("#form1").ajaxSubmit({
			async: false,
			url:"save",
			dataType:'json',
			type : "post",
			success:function(data){
				if(data.success){
				    reloadList(function(){
				    	art.dialog({id:'netsite'}).close();
				    });
				}else{
				    alert(data.msg);
				}
			}
		});
	}
}
//根据网点得到网点账号列表
function getBankList(currBank){
    jQuery.ajax({
		async: false,
		url : "ajaxGetNetsiteBankList",
		data : {netsite_id:jQuery("#netsiteid").val()},
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data.success) {
				var str="";
				var rtnJSONObject = eval ("(" + data.data + ")");
				for(var i in rtnJSONObject){
					str+="<input type='radio' name='bank_id' value='"+rtnJSONObject[i].ID+"'";
					if(currBank==rtnJSONObject[i].ID){
						str+=" checked";
					}
					str+=">";
					str+="银行："+rtnJSONObject[i].BANKNAME+"&nbsp;&nbsp;&nbsp;";
					str+="开户账号："+rtnJSONObject[i].OPEN_ACCOUNT+"&nbsp;&nbsp;&nbsp;";
					str+="转账账号："+rtnJSONObject[i].TRANSFER_ACCOUNT+"<br/>";
				}
				jQuery("#bank").html(str);
			}else {
				alert(data.msg);
			}
		}
	});
}