/*即时消息区域方法*/
jQuery.ajaxSetup({
	cache : false
});
/* 当前页面加载的读卡器OCX */
var cardOCX = document.getElementById('readCardOCX');

/* 页面加载及时消息时，在控制器中获取session中的当前登录用户Id */
var userId;
var userName;
// 售卡的小类型
var saleCardtype;
// 充值的卡小类型
var cashCardtype;
// 是否可登陆系统
var isCanLogin;

/* 打印及时消息的内容 */

function onMsgPrint() {
	var docStr = document.getElementById("msgDiv0").innerHTML;
	docStr += document.getElementById("msgDiv1").innerHTML;
	window.document.write(docStr);
	window.document.close();
	window.print();
	window.close();
	// 重置当前页面
	location.reload();
}

/* 获取及时消息(页面刷新或点击刷新时调用) */
function onRefresh() {
	if (cardOCX == null) {
		alert("读卡器插件加载异常");
		return;
	}
	// 打开读卡器，0是成功，其它失败
	var openValue = cardOCX.OpenComm();

	if (openValue == 0) {
		// 获取终端读卡器上的PSAM号
		psamcardno = cardOCX.GetTermInfo();
	} else {
		// 打开读卡器端口失败
		alert("打开读卡器端口失败(或无读卡设备)");
		return;
	}
	// 关闭读卡器
	cardOCX.CloseComm();

	if (psamcardno == "0") {
		alert("无法获取终端PSAM卡信息");
		return;
	}
	// 提交获取及时消息
	var msgurl = "";
	var urlstr = location.toString();
	if (urlstr.length > 10) {
		var arr = urlstr.split("/");
		for ( var i = 0; i < arr.length - 2; i++) {
			var c = arr[i];
			msgurl += c + '/';
		}
	}
	jQuery("#form0").ajaxSubmit(
			{
				url : msgurl + "consumeCard/getBizTotalMsg",
				type : "post",
				data : {
					psamcardno : psamcardno
				},
				dataType : 'json',
				success : function(result) {
					if (result.success) {
						if (result.data == null) {
							alert("无法获取终端信息(或无效的PSAM卡)");
							return;
						}
						var dt = eval("(" + result.data + ")");
						if (dt.termId == null || dt.msgForm == null) {
							return;
						}
						termId = dt.termId;
						userId = dt.userId;
						userName = dt.msgForm.userName;

						var auth = dt.msgForm.isUseAuth == "0" ? "未启用授权"
								: dt.msgForm.currOddFare;
						saleCardtype = dt.msgForm.saleCardtype;
						cashCardtype = dt.msgForm.cashCardtype;
						isCanLogin = dt.msgForm.isCanLogin;
						jQuery("#currOddFare").html("当前授权余额：" + auth);
						jQuery("#costMoney").val(auth);
						jQuery("#currCntIn").html(
								"总收入金额：" + dt.msgForm.currCntIn);
						jQuery("#currCntOut").html(
								"总支出金额：" + dt.msgForm.currCntOut);
						jQuery("#currSellCardNum").html(
								"售卡张数：" + dt.msgForm.currSellCardNum);
						jQuery("#currSellCardCash").html(
								"售卡收费金额：" + dt.msgForm.currSellCardCash);
						jQuery("#currAddChargeNum").html(
								"钱包充值张数：" + dt.msgForm.currAddChargeNum);
						jQuery("#currAddChargeCash").html(
								"钱包充值金额：" + dt.msgForm.currAddChargeCash);
						jQuery("#currUnAddChargeNum").html(
								"充值撤销张数：" + dt.msgForm.currUnAddChargeNum);
						jQuery("#currPutRightNum").html(
								"消费纠错张数：" + dt.msgForm.currPutRightNum);
						jQuery("#currRenewCardNum").html(
								"补卡张数：" + dt.msgForm.currRenewCardNum);
						jQuery("#currCardLossNum").html(
								"挂失张数：" + dt.msgForm.currCardLossNum);
						jQuery("#currHasCardLogoutNum").html(
								"有卡销户张数：" + dt.msgForm.currHasCardLogoutNum);
						jQuery("#currNoCardLogoutNum").html(
								"无卡销户张数：" + dt.msgForm.currNoCardLogoutNum);
						jQuery("#currUnAddChargeCash").html(
								"充值撤销金额：" + dt.msgForm.currUnAddChargeCash);
						jQuery("#currPutRightCash").html(
								"消费纠错金额：" + dt.msgForm.currPutRightCash);
						jQuery("#currNoCardLogoutCash").html(
								"无卡销户金额：" + dt.msgForm.currNoCardLogoutCash);
						jQuery("#currHasCardLogoutCash").html(
								"有卡销户金额：" + dt.msgForm.currHasCardLogoutCash);
						jQuery("#currCardUnLossNum").html(
								"解挂张数：" + dt.msgForm.currCardUnLossNum);
						jQuery("#currGetFrozenCash").html(
								"领取冻结金额：" + dt.msgForm.currGetFrozenCash);
					} else {
						alert(result.msg);
					}
				}
			});
}