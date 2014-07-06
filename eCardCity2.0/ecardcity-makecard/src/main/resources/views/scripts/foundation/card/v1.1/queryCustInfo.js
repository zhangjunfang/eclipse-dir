/*客户信息查询业务交互方法*/
jQuery.ajaxSetup({
	cache : false
});

/* 页面加载后初始化按钮及输入数字格式化 限制数字输入 */
jQuery(function() {
	// 获取及时消息
	onRefreshMsg();
});

/* 通过OCX调用获取的信息,当次调用值覆盖 */
/* 终端设备读卡器 */
// 终端号数据库中获取的
var termId = "";
// 终端读卡器的psam卡号
var psamcardno = "0";

/* 卡片相关的信息 */
// 卡应用序列号ASN16进制
var asn16 = "";
// 卡唯一号 10进制
var snr = "";
// 卡类别 1：M1卡 2：CPU卡
var cardKind = "";

var pidno = "";// 证件号码

/* 读取终端卡片信息 */
function readTermCard() {
	if (cardOCX == null) {
		alert("读卡器插件加载异常");
		return false;
	}

	/* 打开读卡器，0是成功，其它失败 */
	var openValue = cardOCX.OpenComm();
	if (openValue == 0) {
		/* 获取终端读卡器上的PSAM号 */
		psamcardno = cardOCX.GetTermInfo();
		if (psamcardno == "0") {
			alert("读取SAM卡信息失败");
			cardOCX.CloseComm();
			return false;
		}
		/* 寻卡a-卡类型(4-M1,8-CPU), b-卡唯一号 */
		var findCard = cardOCX.FindCard();
		if (findCard == "" || findCard == null) {
			alert("请放入卡片");
			cardOCX.CloseComm();
			return false;
		} else {
			// 卡类型
			var a = findCard.toString().split("@")[0];
			// 卡唯一号8位十六进制
			var b = findCard.toString().split("@")[1];
			// 进制转换 16to10
			snr = parseInt(b, 16);
			// 卡应用序列号ASN
			var fasn = cardOCX.GetASNandMAC();
			if (a == "4") {
				cardKind = "1";
				// 16位十六进制
				asn16 = fasn.substring(0, 16);
			} else if (a == "8") {
				cardKind = "2";
				// 16位十六进制
				asn16 = fasn.substring(4, 20);
			}
			/* 读取卡片客户信息判断是否为已发的卡片 */
			var rperson = cardOCX.ReadPersonInfo();
			// name 姓名
			var pname = rperson.toString().split("@")[0];
			// 市民卡号（m1卡存在CPU卡空）
			var pcode = rperson.toString().split("@")[1];
			// 证件号码/身份证号
			pidno = rperson.toString().split("@")[2];
			// 客户名称空
			if (pname == "" && (pidno == "" || Number(pidno) == 0)) {
				alert("空卡片(无客户信息)!");
				cardOCX.CloseComm();
				return false;
			} else {
				jQuery("#custName").val(pname);
				jQuery("#custCardNo").val(pcode);
				jQuery("#custIdCardNo").val(pidno);
				cardOCX.CloseComm();
				return true;
			}

		}
	} else {
		alert("打开读卡器端口失败");
		return false;
	}
}
function resetSearch() {
	jQuery("#custName").val("");
	jQuery("#custCardNo").val("");
	jQuery("#custIdCardNo").val("");
	jQuery("#bizSearchList").html('<tr><td colspan="7">无数据!</td></tr>');
	jQuery('#bizSearchContent').show();
}
/* 点击"读卡查询"的操作 */
function readCardQuery() {
	jQuery("#custName").val("");
	jQuery("#custCardNo").val("");
	jQuery("#custIdCardNo").val("");
	if (termId == null || termId == "") {
		alert("无法获取终端信息(或无效的PSAM卡)");
		return;
	}
	if (userId == null || userId == "") {
		alert("获取当前用户信息失败");
		return;
	}
	if (isCanLogin != "1") {
		alert("您无系统登陆权限");
		return;
	}
	if (readTermCard() == false) {
		return;
	}
	if (psamcardno == "0" || snr == "") {
		alert("读卡失败,请检查");
		return;
	}

	var custName = jQuery("#custName").val();
	var custCardNo = jQuery("#custCardNo").val();
	var custIdCardNo = jQuery("#custIdCardNo").val();
	if (custName == "" && custCardNo == "" && custIdCardNo == "") {
		alert("读卡失败,请检查");
		return;
	}
	/* 调用库中信息，读卡查询 */
	var dat = {
		custName : custName,
		custCardNo : custCardNo,
		custIdCardNo : custIdCardNo,
		psamcardno : psamcardno,
		asn16 : asn16,
		snr : snr,
		cardKind : cardKind,
		userId : userId
	};
	jQuery("#form1").ajaxSubmit({
		url : "readCardQuery",
		type : "post",
		data : dat,
		dataType : 'json',
		success : function(result) {
			if (result.success) {
				if (result.msg == "OK") {
					showRCardInfo(result.data);
				} else {
					alert(result.msg);
				}
			} else {
				alert(result.msg);
			}
		},
		error : function(e) {
			alert("系统错误：读卡查询失败");
		}
	});
}

/* 显示读卡后的信息 */
function showRCardInfo(dt) {
	jQuery('#bizSearchContent').show();
	var doc = "";
	for ( var a = 0; a < dt.length; a++) {
		var cardNo = Number(dt[a].CITYCARDNO);
		if (dt.length == 1) {
			jQuery("#custCardNo").val(cardNo);
		}
		if (a % 2 == 0) {
			doc += "<tr class='t3'>";
		} else {
			doc += "<tr class='ld-defalcolor'>";
		}
		doc += "<td>" + dt[a].NAME + "</td>";
		doc += "<td>" + (dt[a].SEX == '1' ? "男" : "女") + "</td>";
		doc += "<td>" + dt[a].CITYCARDNO + "</td>";
		doc += "<td>" + dt[a].IDCARDNO + "</td>";
		doc += "<td>" + dt[a].EDITDT + "</td>";
		doc += "<td>" + getState(dt[a].CARDSTATUS) + "</td>";
		doc += "<td><a class='blue' title='查看详情' style='cursor:pointer;' ";
		doc += " onclick='showCustDetail(" + dt[a].CUSTOMERID + "," + cardNo
				+ ")'>详情</a></td>";
		doc += "</tr>";
	}
	if (doc.length > 0) {
		jQuery("#bizSearchList").html(doc);
	} else {
		jQuery("#bizSearchList").html('<tr><td colspan="7">无数据</td></tr>');
	}
}

function getState(flag) {
	var st = "";
	switch (flag) {
	case "0":
		st = "睡眠";
		break;
	case "1":
		st = "正常";
		break;
	case "3":
		st = "挂失";
		break;
	default:
		st = "";
		break;
	}
	return st;
}

/**
 * 模糊查询
 */
function searchCustList(startPage, endPage) {
	var custName = jQuery("#custName").val();
	var custCardNo = jQuery("#custCardNo").val();
	var custIdCardNo = jQuery("#custIdCardNo").val();
	if (custName == "" && custCardNo == "" && custIdCardNo == "") {
		// alert("请输入查询条件");
		// return;
	}
	/* 调用库中信息，读卡查询 */
	var dat = {
		custName : custName,
		custCardNo : custCardNo,
		custIdCardNo : custIdCardNo,
		userId : userId,
		startPage : startPage,
		endPage : endPage
	};
	jQuery("#form1").ajaxSubmit({
		url : "searchCustList",
		type : "post",
		data : dat,
		dataType : 'json',
		success : function(result) {
			if (result.success) {
				showSearchCardInfo(result.data);
			} else {
				alert(result.msg);
			}
		},
		error : function(e) {
			alert("系统错误：查询失败");
		}
	});
}

function showSearchCardInfo(dt) {
	jQuery('#bizSearchContent').show();
	if (dt == null || dt.totalCount == 0) {
		jQuery("#bizSearchList").html('<tr><td colspan="7">无数据!</td></tr>');
	} else {
		var totalCount = Number(dt.totalCount);
		var startPage = Number(dt.startPage);
		var endPage = Number(dt.endPage);
		var currList = dt.currList;
		var doc = "";
		for ( var a = 0; a < currList.length; a++) {
			var cardNo = Number(currList[a].CITYCARDNO);
			if (a % 2 == 0) {
				doc += "<tr class='t3'>";
			} else {
				doc += "<tr class='ld-defalcolor'>";
			}
			doc += "<td>" + currList[a].NAME + "</td>";
			doc += "<td>" + (currList[a].SEX == '1' ? "男" : "女") + "</td>";
			doc += "<td>" + currList[a].CITYCARDNO + "</td>";
			doc += "<td>" + currList[a].IDCARDNO + "</td>";
			doc += "<td>" + currList[a].EDITDT + "</td>";
			doc += "<td>" + getState(currList[a].CARDSTATUS) + "</td>";
			doc += "<td><a class='blue' title='查看详情' style='cursor:pointer;' ";
			if (currList[a].APPID.length == 32) {
				doc += " onclick='showCustDetail(" + currList[a].CUSTOMERID
						+ "," + cardNo + ")'>详情</a></td>";
			} else {
				doc += " onclick=''></a></td>";
			}

			doc += "</tr>";
		}
		var page = "<tr class='ld-defalcolor'>";
		page += "<td colspan='7'>共" + totalCount + "条记录&nbsp;&nbsp;";
		if (totalCount > 10) {
			var start = 1;
			var end = 10;
			for ( var p = 1; start < totalCount; p++) {
				if (startPage != start) {
					// 当前页不加载,避免重新点击加载
					page += "&nbsp;<a class='blue' title='第"
							+ p
							+ "页' style='cursor:pointer;' onclick='searchCustList("
							+ start + "," + end + ")'>" + p + "</a>";
				}
				start = start + 10;
				end = end + 10;
				if (p > 50) {
					break;
				}
			}
		}
		page += "</td></tr>";
		doc += page;
		jQuery("#bizSearchList").html(doc);
	}
}
/**
 * 查看详情
 */
function showCustDetail(custId, cardNo) {
	jQuery.post('showCustDetail', {
		userId : userId,
		custId : custId,
		cardNo : cardNo
	}, function(data) {
		$.dialog({
			id : 'custdetailwin',
			title : '客户详细信息',
			content : data,
			lock : true,
			init : function() {
				/*
				 * $('#custCon0').show(); $('#custCon1').hide();
				 */
			}
		});
	});
}