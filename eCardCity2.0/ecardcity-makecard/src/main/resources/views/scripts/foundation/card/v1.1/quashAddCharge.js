/*充值撤销业务交互方法*/
jQuery.ajaxSetup({
	cache : false
});

/* 页面加载后初始化按钮及输入数字格式化 限制数字输入 */
jQuery(function() {
	// 撤销按钮不可用
   jQuery("#btnQuash").hide();
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
// 卡应用序列号ASN10进制
var asn = "";
// 卡唯一号 10进制
var snr = "";
// 卡类别 1：M1卡 2：CPU卡
var cardKind = "";

// 卡片余额Number单位：分
var cardRec=0;
// 卡片消费计数
var cardOpCnt=0;
// 卡片充值计数
var cardSaveOpCnt=0;

var pidno="";// 证件号码
var cardmac16="";
// 点击"读卡"按钮提交后台验证后的返回数据
var readData;

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
				// 8位16进制
				cardmac16 = fasn.substring(16, 24);
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
			// var pcode = rperson.toString().split("@")[1];
			// 证件号码/身份证号
			pidno = rperson.toString().split("@")[2];
			// 客户名称空
			if (pname == "" && (pidno == "" || Number(pidno) == 0)) {
				alert("空卡片(无客户信息)!");
				cardOCX.CloseComm();
				return false;
			}
			
			// 获取卡片钱包余额及操作计数
			// GetTktInfo2(主钱包)空-失败, a@b@c...-成功: 余额, 消费计数, 充值计数,
			var fopStr=cardOCX.GetTktInfo2(1);
			if(fopStr!=""&&fopStr.length>2){
				// 卡片余额Number单位：分
				cardRec = fopStr.toString().split("@")[0];
				// 卡片消费计数
				cardOpCnt=fopStr.toString().split("@")[1];
				// 卡片充值计数
				cardSaveOpCnt= fopStr.toString().split("@")[2];
			}
		}
	} else {
		alert("打开读卡器端口失败");
		return false;
	}

	/* 关闭端口读卡器 */
	cardOCX.CloseComm();
	return true;
}

/* 点击"读卡"的操作 */
function clickReadCard() {
	if(termId==null||termId==""){
		alert("无法获取终端信息(或无效的PSAM卡)");
		return ;
	}
	if(userId==null||userId==""){
		alert("获取当前用户信息失败");
		return ;
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

	/* 调用库中信息，验证是否可充值 */
	var dat = {
		pidno : pidno,
		psamcardno : psamcardno,
		asn16 : asn16,
		snr : snr,
		cardKind : cardKind,
		cardRec : cardRec,
		cardOpCnt : cardOpCnt,
		cardSaveOpCnt : cardSaveOpCnt,
		userId : userId,
		cashCardtype : cashCardtype
	};
	jQuery("#form1").ajaxSubmit({
		url : "readCardAndQuery",
		type : "post",
		data : dat,
		dataType : 'json',
		success : function(result) {
			if (result.success) {
				if (result.msg == "OK") {
					var dt = eval("(" + result.data + ")");
					readData = result.data;
					// TEST模拟卡片测试数据-------
					cardOpCnt=dt.custCardInfo.opcount;
					cardSaveOpCnt=dt.custCardInfo.saveopcount;
					cardRec=Number(dt.custCardInfo.oddfare)*100;
					// TEST模拟卡片测试数据-------
					showRCardInfo(dt);
				} else {
					alert(result.msg);
				}
			} else {
				jQuery("#btnQuash").hide();
				alert(result.msg);
			}
		},
		error : function(e) {
			alert("系统错误：读卡失败");
		}
	});
}

/* 显示读卡后的信息 */
function showRCardInfo(dt) {
	if (dt.addUserInfo == null || dt.customer == null
			|| dt.custCardInfo == null || dt.saveObj == null) {
		return;
	}

	// 设置客户信息
	asn = dt.custCardInfo.asn;
	jQuery("#custName").val(dt.customer.name);
	jQuery("#custSex").val(dt.customer.sex == "0" ? "女" : "男");
	jQuery("#correctFlag").val(dt.saveObj.correct == "0" ? "未撤销" : "已撤销");

	jQuery("#cardNo").val(dt.custCardInfo.citycardno);
	jQuery("#idCardNo").val(pidno);
	jQuery("#cardFare").val(dt.custCardInfo.oddfare);

	jQuery("#opDate").val(dt.opDate);
	jQuery("#opCodeDesc").val(dt.saveObj.dscrp);
	jQuery("#opFare").val(dt.opfare);

	jQuery("#opNetName").val(dt.addUserInfo.netname);
	jQuery("#opTermName").val(
			dt.addUserInfo.poscode + "/" + dt.addUserInfo.termname);
	jQuery("#opUserName").val(dt.addUserInfo.userName);
	
	jQuery("#quashUser").val(userName);
	
	jQuery("#quashConfirmDiv").show();
	jQuery("#searchpwd").focus();
	jQuery("#btnQuash").show();
}

var tac;
/* tac校验的时间，充值日期19位字符串 */
var tacdt;

/* 点击撤销按钮 */
function clickQuash(){
	if(psamcardno=="0"||asn==""||snr==""){
		alert("请先读卡");
		return ;
	}
	if(jQuery("#correctFlag").val()=="已撤销"){
		alert("当前卡最后一笔充值已撤销,请查询");
		return ;
	}
	
	if(Number(jQuery("#opFare").val())<=0){
		alert("交易金额无效");
		jQuery("#opFare").focus();
		return ;
	}
	if(jQuery("#searchpwd").val()==""){
		alert("请输入撤销密码");
		jQuery("#searchpwd").focus();
		return ;
	}
	if(jQuery("#searchpwd").val().length!=6){
		alert("请输入6位撤销密码");
		jQuery("#searchpwd").focus();
		return ;
	}
	
	
	/* 打开读卡器重新读卡验证：是否为读卡时的那一张卡 */
	// ///////////////////////////////////////////////////////
	var openValue = cardOCX.OpenComm(); 
	if(openValue==0){
		/* OCX调用：获取终端读卡器上的PSAM号 */
		psamcardno=cardOCX.GetTermInfo();
		if(psamcardno=="0"){
			alert("读取SAM卡信息失败");
			cardOCX.CloseComm();
			return ;
		}
		/* 寻卡a-卡类型(4-M1,8-CPU), b-卡唯一号 */
		var findCard=cardOCX.FindCard();
		if(findCard==""||findCard==null){
			alert("请放入卡片");
			cardOCX.CloseComm();
			return ;
		}else{
			// 卡唯一号
			var a=findCard.toString().split("@")[0];
			// 8位十六进制
			var b=findCard.toString().split("@")[1];
			// 进制转换 16to10
			var rsnr=parseInt(b,16);
			var rckind="";
			if(a=="4"){
				rckind="1";
			}else if(a=="8"){
				rckind="2";
			}
			// 是否同一张卡
			if(rsnr==snr&&rckind==cardKind){
				// 卡片余额操作计数验证，防止读卡后有其他操作之后再点击撤销
				var rcardRec=cardOCX.GetEPoddFare();// 卡片余额Number单位：分
				if(cardRec!=rcardRec){
					// alert("当前卡信息验证失败,请先重新点击'读卡'");
					cardOCX.CloseComm();
					// return false;
				}
			}else{
				alert("不是同一张卡，请放入原卡片");
				cardOCX.CloseComm();
				return ;
			}
		}
	}else{
		alert("打开读卡器端口失败");
		return ;
	}
	
	/* 充值撤销申请，撤销密码校验 */
	jQuery(document).ready(function(){
		if(confirm("您确定要充值进行撤销操作?")){
		    jQuery("#btnQuash").hide();
		    var dat = {
		    		readData:readData,
		    		cardmac16 : cardmac16,
					searchpwd:jQuery("#searchpwd").val()
				};
			// 充值撤销申请处理
			jQuery("#form1").ajaxSubmit({
				url:"reqQuashAdd",
				type:"post",
				data:dat,
				dataType:'json',
				success:function(result){
					if(result.success){
						if(result.msg=="OK"){
							// 返回申请结果
							reqData=result.data;
							var dt= eval("(" + result.data + ")");
							tacdt=dt.tacdt;
							// 客户端充值写卡
							if(writeTermCard()){
								// 判断充值写卡的结果
								 if(wcardOpCnt==(Number(cardOpCnt)+1)&&wcardRec==Number(cardRec)-Number(Number(jQuery("#opFare").val())*100)){
									// 写卡成功
									 commitQuashAdd("Y");
								}else{
									// 写卡失败
									commitQuashAdd("N");
								} 
							}else{
								// 终端写卡异常
								commitQuashAdd("E"); 
							}
						}else{
							alert(result.msg);
						}
					}else{
						alert(result.msg);
					}
				},
				error:function(e){
					alert("系统错误：充值申请失败");
					// 重置当前页面
					location.reload();
				}
			});
		}
	});
	
}

var reqData;// 撤销申请数据

// 充值写卡后：卡片余额Number单位：分
var wcardRec=0;
// 充值写卡后：卡片消费计数
var wcardOpCnt=0;
// 充值写卡后：卡片充值计数
var wcardSaveOpCnt=0;

/* 调用充值终端写卡 */
function writeTermCard(){
	if (cardOCX == null) {
		// alert("读卡器插件加载异常");
		return false;
	}
	// 打开读卡器，0是成功，其它失败
	var openValue = cardOCX.OpenComm(); 
	if(openValue==0){
		// 获取终端读卡器上的PSAM号
		var wpsamcardno=cardOCX.GetTermInfo();
		if(wpsamcardno=="0"||wpsamcardno!=psamcardno){
			// alert("无法获取读取SAM卡信息");
			cardOCX.CloseComm();
			return false;
		}
		
		// 寻卡a-卡类型(4-M1,8-CPU), b-卡唯一号
		var findCard=cardOCX.FindCard();
		if(findCard==""||findCard==null){
			// alert("寻卡失败请放入卡片");
			cardOCX.CloseComm();
			return false;
		}else{
			// 卡唯一号
			var a=findCard.toString().split("@")[0];
			// 8位十六进制
			var b=findCard.toString().split("@")[1];
			// 进制转换 16to10
			var wsnr=parseInt(b,16);
			var wckind="";
			if(a=="4"){
				wckind="1";
			}else if(a=="8"){
				wckind="2";
			}
			// 是否同一张卡
			if(wsnr==snr&&wckind==cardKind){
				var dt= eval("(" + reqData + ")");
				// M1卡需要设置充值密钥
				if(cardKind=="1"){
					if(dt.preKeyObj!=null){
						 var xml=dt.preKeyObj.soapResponseData; 
						 var code=jQuery(xml).find("GetTopUpKeyResult").html();
						 if(code==-13||code==100){ 
							var chrgKey= jQuery(xml).find("chrgKey").html();
							var rskey=cardOCX.SetChrgKey(chrgKey);
							if(rskey=="0"){
								// 成功
							}else{
								// alert("设置充值密钥失败");
								cardOCX.CloseComm();
								return false; 
							}
						 }else{ 
							  var errMsg= jQuery(xml).find("out_msg").html();
							  // alert("密钥系统请求失败:"+errMsg+"[code="+code+"]");
							  cardOCX.CloseComm();
							  return false; 
						} 
					}else{
						// alert("获取充值密钥失败");
						cardOCX.CloseComm();
						return false;
					}
						
				}
				
				// 卡片充值撤销操作
				var objNo=1;
				var curFare=Number(cardRec);
				var opFare=Number(jQuery("#opFare").val())*100;
				var newFare=curFare-opFare;
				var empNo=userId;
				var devNo=psamcardno;
			    // dt时间 生成的19位固定值所有充值记录都用此值，empNo充值员编号，devNo设备编号
				
				// 传psan卡号（CPU卡不需要）
			    // 空-失败, 其它-tac
				// tac=cardOCX.PurchasePurchase(long objNo,long curFare,ong
				// opFare,long newFare,BSTR dt,BSTR empNo,BSTR devNo);
			   tac="tac0000212";
			   
			   // 充值操作因异常重新获取Tac
			   if(tac=="-10"){
			    	// 重新获取Tac
			    	// tac=cardOCX.ChrgTac();
			    }
			    
			    // 充值正确返回Tac
			    if(tac.length>3){
			    	// 继续调用密钥系统TAC校验，确认充值成功
					/*
					 * var isOK=service.checkTac(BSTR tacdt, BSTR mac2, BSTR
					 * empNo, BSTR devNo); if(isOK){ commitChashToWallet("Y");
					 * }else{ commitChashToWallet("N"); }
					 */
			    	// Tac校验成功，更改写卡的操作计数及余额
			    	// return true;
			    }else{
			    	// 充值无返回Tac：重新读卡更改写卡的操作计数及余额
			    	// 获取卡片钱包余额及操作计数
					// GetTktInfo2(主钱包)空-失败, a@b@c...-成功: 余额, 消费计数, 充值计数,
					var fopStr=cardOCX.GetTktInfo2(1);
					if(fopStr!=""&&fopStr.length>2){
						// 卡片余额Number单位：分
						// wcardRec = fopStr.toString().split("@")[0];
						// 卡片消费计数
						// wcardOpCnt=opStr.toString().split("@")[1];
						// 卡片充值计数
						// wcardSaveOpCnt= fopStr.toString().split("@")[2];
						// cardOCX.CloseComm();
						// return true;
					}
			    }
			    
			    // TEST模拟卡片测试数据-------
				wcardOpCnt=Number(cardOpCnt)+1;
				wcardSaveOpCnt=Number(cardSaveOpCnt);
				wcardRec=Number(cardRec)-Number(Number(jQuery("#opFare").val())*100);// 分
				// TEST模拟卡片测试数据-------
				cardOCX.CloseComm();
				return true;
			}else{
				// alert("卡片不一致");
				cardOCX.CloseComm();
				return false;
			}
		}
	}else{
		// alert("打开读卡器端口失败");
		return false;
	}
}
/* 充值撤销提交 */
function commitQuashAdd(flag){
	jQuery("#form1").ajaxSubmit({
		url:"commitQuashAdd",
		type:"post",
		data: {reqData:reqData,writeFlag:flag,tac:tac,wcardRec:wcardRec,wcardOpCnt:wcardOpCnt,wcardSaveOpCnt:wcardSaveOpCnt},
		dataType:'json',
		success:function(result){
			// 返回充值提交结果，数据封装打印信息
			if(result.success){
				// 充值完成
				// 调用打印弹出窗口
				// toPrintPage(result.data);
				var dt= eval("(" + result.data + ")");
				// alert(dt);
				var docStr = "";
			    docStr=dt.netName+"\n";
			    docStr+="==========================================\n";
			    docStr+="户名:"+dt.custName+"\n";
			    docStr+="卡号:"+dt.custCardNo+"\n";
			    docStr+="交易类型:"+dt.opType+"\n";
			    docStr+="交易金额:"+dt.opFare+"\n";
			    docStr+="交易时间:"+dt.opTime+"\n";
			    docStr+="交易应答:"+dt.opOK+"\n\n";
			    docStr+="商户名称(代码):"+dt.merchantCode+"\n";
			    docStr+="终端名称(编号):"+dt.termCode+"\n";
			    docStr+="操作员:"+dt.userName+"\n";
			    docStr+="流水号:"+dt.planId+"\n";
			    docStr+="客户签名：\n\n";
			    docStr+="==========================================\n";
			    docStr+="备注:请当面核对账务，请妥善保存凭条";
			    
			    alert(docStr);
				// location.href=location.href+"Print&printData="+dt;
			    // 打印窗口要换成页面的url
			    var newWindow=window.open(location.href+"Print","_blank");
			    newWindow.document.write(docStr);
			    newWindow.document.close();
			    newWindow.print();
			    newWindow.close();
			}else{
				alert(result.msg);
			}
			
			// 重置当前页面
			location.reload();
		},
		error:function(e){
			alert("系统错误：充值提交失败");
			// 重置当前页面
			location.reload();
		}
	});
}

