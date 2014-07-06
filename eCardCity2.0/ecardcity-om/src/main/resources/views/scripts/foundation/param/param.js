function add(){		//添加
    var dialog = art.dialog({id:"param",title:"添加模板",lock:true});//init window
    jQuery("#form1").ajaxSubmit({
	async: false,
	url:"addParamLibUI",
	type : "post",
	success:function(data){
	    dialog.content(data);
	}
    });
}

function update(){		//修改
    if(chkCheckbox(document.forms[0],true)){
	var dialog = art.dialog({id:"param",title:"修改模板",lock:true});//init window
	jQuery("#form1").ajaxSubmit({
	    async: false,
	    url:"updateParamLibUI",
	    type : "post",
	    success:function(data){
		dialog.content(data);
	    }
	});
    }
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
//	var libGroup=getValuesByObjs(document.getElementsByName("p_lib_group"),",");
	var libGroup=jQuery("#p_lib_group").val();
	var params = {offset:offset,p_lib_group:libGroup,schStr:jQuery("#schStr").val()};//拼json参数
	jQuery("#pageList").load("listParamLibUIData", params,null);
}

function submit(){	// 提交
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