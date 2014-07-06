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
					getClearingRate();
				    alert(data.msg);
				}else{
				    alert(data.msg);
				}
			}
		});
	}
}
//根据网点得到网点账号列表
function getClearingRate(){
    jQuery.ajax({
		async: false,
		url : "ajaxGetClearingRate",
		data : {netsiteid:jQuery("#netsiteid").val()},
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data.success) {
				var rtnJSONObject = eval ("(" + data.data + ")");
				if(rtnJSONObject.flag=="0"){
					document.getElementById("flag0").checked=true;
					jQuery('#feepersale').attr('disabled',false);
					jQuery('#currencyrates').attr('disabled',true);
					jQuery('#currencyrates').val('0');
				}else{
					document.getElementById("flag1").checked=true;
					jQuery('#feepersale').attr('disabled',true);
					jQuery('#currencyrates').attr('disabled',false);
					jQuery('#feepersale').val('0');
				}
				
				jQuery("#id").val(rtnJSONObject.id);
				jQuery("#feepersale").val(rtnJSONObject.feepersale);
				jQuery("#currencyrates").val(rtnJSONObject.currencyrates);
				jQuery("#transferratesofbank").val(rtnJSONObject.transferratesofbank);
				jQuery("#edit_person").text(rtnJSONObject.edit_person);
				jQuery("#edit_date").text(rtnJSONObject.edit_date);
				jQuery(":text").formatCurrency({
					//positiveFormat: '%s%n',
					//negativeFormat: '%s-%n',
					decimalSymbol: '.',
					digitGroupSymbol: ',',
					dropDecimals: false,
					groupDigits: false,
					symbol: ''
				});
			}else {
				alert(data.msg);
			}
		}
	});
}