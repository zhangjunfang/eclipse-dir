//连带参数在内的分页支持
function reloadList(offset){
	var totalpage = jQuery("#totalpage").val();//总分页数目
	if(offset == 0){  //点击go触发
		offset = jQuery("#offset").val();
	}
	if(offset > parseInt(totalpage) && parseInt(totalpage) != 0){
		offset = totalpage;
	}
	var netid=jQuery("#wdid").val().trim();
	var netname=jQuery("#wdmc").val().trim();
	var netkind=jQuery("#wdzl").val();
	var nettype=jQuery("#wdlx").val();
	var netstatus=jQuery("#wdzt").val();
	var params = {offset:offset,netid:netid,netname:netname,netkind:netkind,nettype:nettype,netstatus:netstatus};// 拼json参数
	jQuery("#pageList").load("listNetsiteData", params,null);
}
//添加
function add(){		
    var dialog = art.dialog({id:"industry",title:"添加网点",lock:true});//init window
	    jQuery("#form1").ajaxSubmit({
		async: false,
		url:"addNetsite",
		type : "post",
		success:function(data){
		    dialog.content(data);
		}
    });
}
//修改
function update(){
    if(chkCheckbox(document.forms[0],true)){
		var dialog = art.dialog({id:"industry",title:"修改网点",lock:true});//init window
		jQuery("#form1").ajaxSubmit({
		    async: false,
		    url:"updateNetsite",
		    type : "post",
		    success:function(data){
		    	dialog.content(data);
		    }
		});
    }
}
//删除
function del(){
    if(chkCheckbox(document.forms[0],false)&&window.confirm('该操作将删除选定的网点信息，是否继续？')){
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
	if (isRepeat) {
		alert('该网点已存在！');
	} else if(fCheck(document.forms[0])){
		jQuery("#form1").ajaxSubmit({
			async: false,
			url:"save",
			dataType:'json',
			type : "post",
			success:function(data){
				if(data.success){
				    reloadList(function(){
				    	art.dialog({id:'industry'}).close();
				    });
				}else{
				    alert(data.msg);
				}
			}
		});
	}
}
//检查模板名称是否存在
function getNetsiteExists(name,value){
    var tmp=false;
    jQuery.ajax({
		async: false,
		url : "ajaxGetNetsiteExists",
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