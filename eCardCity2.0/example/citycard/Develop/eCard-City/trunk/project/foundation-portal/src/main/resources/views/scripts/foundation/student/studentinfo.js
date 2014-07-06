$(function() {
	var $div = $("#currentDataDiv");
	function init() {
		// 新增按钮
		$(".add").click(function(e) {
			var targetDiv = $(this).attr("data-target");
			var $form = $(targetDiv).find("form");
			$form.resetForm();
		});

		// 保存按钮
		$(".save").click(function() {
			var $form = $(this).closest(".modal-content").find("form");
			if ($(".validation").valid()) {
				$form.ajaxSubmit( {
					url : "add",
					type : "post",
					dataType : "json",
					success : function(result) {
						if (result.success) {
							// 保存成功
					$div.find(".queryForm").find(".search").trigger("click");
					$("#detailModel").modal('hide');
				} else {
					// 保存失败
					$.jBox.alert(result.msg);
				}
			}
				});
			}
		});

		// 修改UI按钮
		$div.find(".edit").click(function() {
			var $tr = $div.find(".table-list tbody .selected_tr");
			var targetDiv = $(this).attr("data-target");
			var $form = $(targetDiv).find("form");
			if ($tr && $tr.length > 0) {
				var id = $tr.attr("id");
				$.ajax( {
					url : "selectById",
					data : {
						id : id
					},
					dataType : "json",
					type : "post",
					success : function(result) {
						if (result.success) {
							$form.resetObjectForm(result.data);
						} else {
							$.jBox.alert(result.msg);
						}

					}
				});
			} else {
				$.jBox.alert('请先选择数据', '提示');
				return false;
			}
		});

		// 取消按钮
		$(".cancel").click(function() {
			var $form = $(this).closest(".modal-content").find("form");
			$div.find(".queryForm").find(".add").trigger("click");
		});

		// 删除按钮
		$div.find(".del").click(function() {
			var $tr = $div.find(".table-list tbody .selected_tr");
			if ($tr && $tr.length > 0) {
				var id = $tr.attr("id");
				function submit(v, h, f) {
					if (v == 'ok') {
						// 删除
				$.ajax( {
					url : "delete",
					data : {
						id : id
					},
					dataType : "json",
					type : "post",
					success : function(result) {
						if (result.success) {
							$div.find(".search").trigger("click");
						} else {
							$.jBox.alert(result.msg);
						}
					}
				});
			}
			return true; // close
		}
		$.jBox.confirm("确认要删除该数据?", "提示", submit);
	} else {
		$.jBox.alert('请先选择数据', '提示');
		return false;
	}
}		);

		// 查询按钮
		$div.find(".search").click(function() {
			search();
		});
		$(".validation").validation();
	}
	init();
	$div.find(".search").trigger("click");
	
	$("#pagenum").keyup(function(event){
		if(event.keyCode==13){
			var pageIndex=$(this).val();
			var index=1;
			if(!isNaN(pageIndex)){
				try {
					index=parseInt(pageIndex);
				} catch (e) {
					index=1;
				}
			}
			gopage(index);
		}
	});
	
	$("#changePagesize").change(function(){
		var pagesize=parseInt($(this).val());
		gopage(1,pagesize);
	});
});

function gofirst(){
	if($("#gofirst").css("cursor")=="not-allowed"){
		return;
	}
	gopage(1);
}
function golast(){
	if($("#golast").css("cursor")=="not-allowed"){
		return;
	}
	var last=parseInt($("#pageCount").text());
	gopage(last);
}
function gonext(){
	if($("#gonext").css("cursor")=="not-allowed"){
		return;
	}
	var pagenum=parseInt($("#pagenum").val());
	gopage(pagenum+1);
}
function gopre(){
	if($("#gopre").css("cursor")=="not-allowed"){
		return;
	}
	var pagenum=parseInt($("#pagenum").val());
	gopage(pagenum-1);
}

function gopage(pageIndex,pageSize){
	var pagecount=parseInt($("#pageCount").text());
	if(pageIndex<1){
		pageIndex=1;
	}
	if(pageIndex>pagecount){
		pageIndex=pagecount;
	}
	$("#pagenum").val(pageIndex);
	$("#offset").val(pageIndex);
	if(pageSize){
		$("#pageSize").val(pageSize);
	}
	search();
}
function changePageStyle(pageIndex,pageCount){
	var disable={'cursor': 'not-allowed','background-color':'#eee'};
	var able={'cursor': 'pointer','background-color':'#fff'};
	if(pageIndex==1){
		$("#gofirst").css(disable);
		$("#gopre").css(disable);
	}else{
		$("#gofirst").css(able);
		$("#gopre").css(able);
	}
	if(pageIndex==pageCount){
		$("#golast").css(disable);
		$("#gonext").css(disable);
	}else{
		$("#golast").css(able);
		$("#gonext").css(able);
	}
}
function search(){
	var $div = $("#currentDataDiv");
	var $form = $div.find(".queryForm");
	$form.ajaxSubmit( {
		url : "studentList",
		dataType : "json",
		type : "post",
		success : function(result) {
			if (result.success) {
				var tbody = $div.find(".table-list tbody");
				tbody.empty();
				$("#listTmpl").tmpl(result.data.items).appendTo(tbody);
				var total=result.data.total;
				var pageSize=$("#pageSize").val();
				var pageCount=Math.ceil(total/pageSize);
				$("#pageCount").text(pageCount);
				
				var pageIndex=parseInt($("#offset").val());
				changePageStyle(pageIndex,pageCount);
			}
		}
	});
}