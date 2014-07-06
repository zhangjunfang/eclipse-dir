//连带参数在内的分页支持
function reloadList(offset){
	var totalpage = jQuery("#totalpage").val();//总分页数目
	if(offset == 0){  //点击go触发
		offset = jQuery("#offset").val();
	}
	if(offset > parseInt(totalpage) && parseInt(totalpage) != 0){
		offset = totalpage;
	}
	var netsiteid=jQuery("#wdid").val().trim();
	var bankname=jQuery("#wdyh").val().trim();
	var params = {offset:offset,netsiteid:netsiteid,bankname:bankname};// 拼json参数
	jQuery("#pageList").load("listNetsiteBankData", params,null);
}
//添加
function add(){		
    var dialog = art.dialog({id:"netsite",title:"添加网点账号",lock:true});//init window
	    jQuery("#form1").ajaxSubmit({
		async: false,
		url:"addNetsiteBank",
		type : "post",
		success:function(data){
		    dialog.content(data);
		}
    });
}
//修改
function update(){
    if(chkCheckbox(document.forms[0],true)){
		var dialog = art.dialog({id:"netsite",title:"修改网点账号",lock:true});//init window
		jQuery("#form1").ajaxSubmit({
		    async: false,
		    url:"updateNetsiteBank",
		    type : "post",
		    success:function(data){
		    	dialog.content(data);
		    }
		});
    }
}
//删除
function del(){
    if(chkCheckbox(document.forms[0],false)&&window.confirm('该操作将删除选定的网点账号，是否继续？')){
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