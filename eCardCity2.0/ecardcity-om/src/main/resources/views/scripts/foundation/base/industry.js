//连带参数在内的分页支持
function reloadList(offset){
	var totalpage = jQuery("#totalpage").val();//总分页数目
	if(offset == 0){  //点击go触发
		offset = jQuery("#offset").val();
	}
	if(offset > parseInt(totalpage) && parseInt(totalpage) != 0){
		offset = totalpage;
	}
	var industrycode=jQuery("#hydm").val().trim();
	var industryname=jQuery("#hymc").val().trim();
	var params = {offset:offset,industrycode:industrycode,industryname:industryname};// 拼json参数
	jQuery("#pageList").load("listIndustryData", params,null);
}
//添加
function add(){		
    var dialog = art.dialog({id:"industry",title:"添加行业",lock:true});//init window
	    jQuery("#form1").ajaxSubmit({
		async: false,
		url:"addIndustry",
		type : "post",
		success:function(data){
		    dialog.content(data);
		}
    });
}
//修改
function update(){
    if(chkCheckbox(document.forms[0],true)){
		var dialog = art.dialog({id:"industry",title:"修改行业",lock:true});//init window
		jQuery("#form1").ajaxSubmit({
		    async: false,
		    url:"updateIndustry",
		    type : "post",
		    success:function(data){
		    	dialog.content(data);
		    }
		});
    }
}
//删除
function del(){
    if(chkCheckbox(document.forms[0],false)&&window.confirm('该操作将删除选定的基础行业数据，是否继续？')){
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
		alert('该行业已存在！');
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
function getIndustryExists(name,value){
    var tmp=false;
    jQuery.ajax({
		async: false,
		url : "ajaxGetIndustryExists",
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