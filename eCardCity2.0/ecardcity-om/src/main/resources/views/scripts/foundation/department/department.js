function add(){		//添加
    var dialog = art.dialog({id:"addDep",title:"添加部门",lock:true});//init window
    jQuery("#form1").ajaxSubmit({
	async: false,
	url:"addDepUI",
	type : "post",
	success:function(data){
	    dialog.content(data);
	}
    });
}

function update(){		//修改
    if(chkCheckbox(document.forms[0],true)){
	var dialog = art.dialog({id:"addDep",title:"修改部门",lock:true});//init window
	jQuery("#form1").ajaxSubmit({
	    async: false,
	    url:"updateDepUI",
	    type : "post",
	    success:function(data){
		dialog.content(data);
	    }
	});
    }
}

function del(){		// 删除
    if(chkCheckbox(document.forms[0],false)&&window.confirm('该操作将删除选定部门，是否继续？')){
	jQuery("#form1").ajaxSubmit({
        	async: false,
        	url:"del",
        	dataType:'json',
        	type : "post",
        	success:function(data){
        	    if(data.success){
        		location="listDepUI?parentid="+jQuery("#parentid").val();
        	    }else{
        		alert(data.msg);
        	    }
        	}
	});
    }
}
//连带参数在内的分页支持
function reloadListDep(offset){
	var totalpage = jQuery("#totalpage").val();//总分页数目
	if(offset == 0){  //点击go触发
		offset = jQuery("#offset").val();
	}
	if(offset > parseInt(totalpage) && parseInt(totalpage) != 0){
		offset = totalpage;
	}
	var params = {offset:offset,parentid: jQuery("#parentid").val()};//拼json参数
	jQuery("#pageList").load("listDepUIData", params,null);
}