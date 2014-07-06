/*消费卡售卡业务交互方法*/
jQuery.ajaxSetup ({cache:false});

/* 页面加载后初始化按钮及输入数字格式化 限制数字输入 */
jQuery(function(){
    var reg = /[\$,%]/g; 
    // 预充值金额
     jQuery("#chargeMoney").keyup(function () {
    	 // toFixed小数点后两位
         var key = parseFloat( String(this.value).replace(reg, '')).toFixed(2);
         if(String(this.value).indexOf(".") > 0){
         	 this.value = isNaN(key) ? 0.00 : key;
         }else{
         	this.value = this.value.replace(/[^\d]/g, '');
         }
         // 应收
         document.getElementById("spCharge").innerHTML=this.value;
         // 找零
         document.getElementById("spRec").innerHTML=(isNaN(jQuery(
			"#recMoney").val()) ? 0.00 : Number(jQuery("#recMoney")
					.val()))-this.value;
         
         if(jQuery("#chargeMoney").val()==""||jQuery("#chargeMoney").val()==null){
     		jQuery("#chargeMoney").focus();
     		jQuery("#tipchargeMoney").html("请输入充值金额");
     	}else if(Number(jQuery("#chargeMoney").val())==0){
     		jQuery("#chargeMoney").focus();
     		jQuery("#tipchargeMoney").html("请输入有效的充值金额");
     	}else{
     		jQuery("#tipchargeMoney").html("");
     	}
     });
     // 实收款
     jQuery("#recMoney").keyup(function () {
         var key = parseFloat( String(this.value).replace(reg, '')).toFixed(2);
         if(String(this.value).indexOf(".") > 0){
         	this.value = isNaN(key) ? 0.00 : key;
         }else{
         	this.value = this.value.replace(/[^\d]/g, '');
         }
         // 应收
         document.getElementById("spCharge").innerHTML=(isNaN(jQuery("#chargeMoney").val()) ? 0.00
					: Number(jQuery("#chargeMoney").val()));
         // 找零
         document.getElementById("spRec").innerHTML=this.value-(isNaN(jQuery("#chargeMoney").val()) ? 0.00
					: Number(jQuery("#chargeMoney").val()));
         if(jQuery("#recMoney").val()==""||jQuery("#recMoney").val()==null){
     		jQuery("#recMoney").focus();
     		jQuery("#tiprecMoney").html("请输入实收金额");
     	}else if(Number(jQuery("#recMoney").val())==0){
     		jQuery("#recMoney").focus();
     		jQuery("#tiprecMoney").html("请输入有效的实收金额");
     	}else{
     		jQuery("#tiprecMoney").html("");
     	}
     });
   // 充值按钮不可用
   jQuery("#btnAdd").hide();
   // 获取及时消息
   onRefreshMsg();
 });

/* 通过OCX调用获取的信息,当次调用值覆盖 */
/* 终端设备读卡器 */
// 终端号数据库中获取的
var termId="";
// 终端读卡器的PSAM卡号
var psamcardno="0";

/* 卡片相关的信息 */
// 卡应用序列号ASN16进制
var asn16="";
// 卡应用序列号ASN10进制
var asn="";
// 卡唯一号 10进制
var snr="";
// 卡类别 1：M1卡 2：CPU卡
var cardKind="";

// 卡片余额Number单位：分
var cardRec=0;
// 卡片消费计数
var cardOpCnt=0;
// 卡片充值计数
var cardSaveOpCnt=0;

// 点击"读卡"按钮提交后台验证后的返回数据
var readData;

/* 读取终端卡片信息 */
function readTermCard(){
	if (cardOCX == null) {
		alert("读卡器插件加载异常");
		return;
	}
	/* 打开读卡器，0是成功，其它失败 */
	var openValue = cardOCX.OpenComm(); 
	if(openValue==0){
		/* 获取终端读卡器上的PSAM号 */
		psamcardno=cardOCX.GetTermInfo();
		if(psamcardno=="0"){
			alert("读取SAM卡信息失败");
			cardOCX.CloseComm();
			return false;
		}
		/* 寻卡a-卡类型(4-M1,8-CPU), b-卡唯一号 */
		var findCard=cardOCX.FindCard();
		if(findCard==""||findCard==null){
			alert("请放入卡片");
			cardOCX.CloseComm();
			return false;
		}else{
			// 卡类型
			var a=findCard.toString().split("@")[0];
			// 卡唯一号8位十六进制
			var b=findCard.toString().split("@")[1];
			// 进制转换16to10
			snr=parseInt(b,16);
			// 卡应用序列号ASN
			var fasn=cardOCX.GetASNandMAC();
			if(a=="4"){
				cardKind="1";
				// 16位十六进制的ASN
				asn16=fasn.substring(0,16);
			}else if(a=="8"){
				cardKind="2";
				// 16位十六进制的ASN
				asn16=fasn.substring(4,20);
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
	}else{
		alert("打开读卡器端口失败");
		return false;
	}
	// 关闭端口读卡器
	cardOCX.CloseComm();
	return true;
}

/* 刷新重置客户信息 */
function reShowForm1(){
	if(jQuery("#customerName").val()==""){
		return ;
	}
	/* 设置客户信息 */
	jQuery("#customerName").val("");
	jQuery("#customerSex").val("");
	jQuery("#cardNo").val("");
	jQuery("#ewalletNo").val("");
	
	jQuery("#chargeMoney").val("");
	jQuery("#recMoney").val("");
	
	
	/* 设置充值按钮不可用 */
	jQuery("#btnAdd").hide();
	readData=null;
	jQuery("#btnRead").focus();
}

/* 点击"读卡"的操作 */
function clickReadCard(){
	if(termId==null||termId==""){
		alert("无法获取终端信息(或无效的PSAM卡)");
		return ;
	}
	if(userId==null||userId==""){
		alert("获取当前用户信息失败");
		return ;
	}
	if(isCanLogin!="1"){
		alert("您无系统登陆权限");
		return;
	}
	if(readTermCard()==false){
		return ;
	}
	if(psamcardno=="0"||snr==""){
		alert("读卡失败,请检查");
		return ;
	}
	
	/* 调用库中信息，验证是否可充值 (充值未决处理) */
	var dat = {
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
		url:"readCardForAddCharge",
		type:"post",
		data:dat,
		dataType:'json',
		success:function(result){
			if(result.success){
				if(result.msg=="OK"){
					var dt= eval("(" + result.data + ")");
					readData=result.data;
					// TEST模拟卡片测试数据-------
					cardOpCnt=dt.cardInfoForm.opcount;
					cardSaveOpCnt=dt.cardInfoForm.saveopcount;
					cardRec=Number(dt.cardInfoForm.oddfare)*100;
					// TEST模拟卡片测试数据-------
					showRCardInfo(dt);
				}else{
					alert(result.msg);
				}
			}else{
				/* 设置充值按钮不可用 */
		    	jQuery("#btnAdd").hide();
				alert(result.msg);
			}
		},
		error:function(e){
			alert("系统错误：读卡失败");
		}
	});
}

/* 显示读卡后的信息 */
function showRCardInfo(dt){
	if(dt.acUserNetForm==null||dt.customer==null){
		return ;
	}
	/* JS：显示客户信息、授权余额、充值按钮设置为可用 */
	var auth=dt.acUserNetForm.isuseauth=="0"?"未启用授权":dt.acUserNetForm.curoddfare;
	jQuery("#currOddFare").html("当前授权余额："+auth);
	jQuery("#costMoney").val(auth);
	// 设置客户信息
	jQuery("#customerName").val(dt.customer.name);
	jQuery("#customerSex").val(dt.customer.sex=="0"?"女":"男");
	jQuery("#cardNo").val(dt.cardInfoForm.citycardno);
	asn=dt.cardInfoForm.asn;
	// 卡片钱包余额：分TO元
	var reg=/[\$,%]/g;
	var ycardRec=parseFloat(String(Number(cardRec)/100).replace(reg, '')).toFixed(2);
	jQuery("#ewalletNo").val(ycardRec);
	// 设置充值按钮可用
	jQuery("#btnAdd").show();
	jQuery("#chargeMoney").focus();
}

/* 验证收费信息填写项 */
function checkRecCash(){
	if(psamcardno=="0"||asn==""||snr==""){
		alert("请先读卡");
		return false;
	}
	if(jQuery("#chargeMoney").val()==""||jQuery("#chargeMoney").val()==null){
		jQuery("#chargeMoney").focus();
		return false;
	}
	if(jQuery("#recMoney").val()==""||jQuery("#recMoney").val()==null){
		jQuery("#recMoney").focus();
		return false;
	}
	if(jQuery("#chargeMoney").val()=="0"){
		jQuery("#chargeMoney").val("");
		jQuery("#chargeMoney").focus();
		return false;
	}
	if(jQuery("#recMoney").val()=="0"){
		jQuery("#recMoney").val("");
		jQuery("#recMoney").focus();
		return false;
	}
	if(Number(jQuery("#chargeMoney").val())>Number(jQuery("#costMoney").val())){
		alert("当前授权余额不足,请核对");
		jQuery("#chargeMoney").focus();
		return false;
	}
	if(Number(jQuery("#chargeMoney").val())>Number(jQuery("#recMoney").val())){
		alert("充值金额不能大于应收金额,请核对");
		jQuery("#recMoney").focus();
		return false;
	}
	return true;
}

/* OCX调用预充值产生的 */
var mac1;
/* 调用密钥验证checkMac产生的(M1卡就是mac1不需要调用)---终端充值写卡时用 */
var mac2;
/* 终端充值写卡时成功返回的值 */
var tac;
/* tac校验的时间，充值日期19位字符串 */
var tacdt;
/* 点击充值按钮的操作 */
function clickAdd(){
	// 验证必填项
	if(checkRecCash()==false){
		return ;
	}
	
	/* 打开读卡器重新读卡验证：是否为读卡时的那一张卡、mac验证 */
	// ///////////////////////////////////////////////////////
	/* OCX调用：打开读卡器，0是成功，其它失败 */
	var openValue = cardOCX.OpenComm(); 
	if(openValue==0){
		/* OCX调用：获取终端读卡器上的PSAM号 */
		psamcardno=cardOCX.GetTermInfo();
		if(psamcardno=="0"){
			alert("读取SAM卡信息失败");
			return false;
		}
		/* 寻卡a-卡类型(4-M1,8-CPU), b-卡唯一号 */
		var findCard=cardOCX.FindCard();
		if(findCard==""||findCard==null){
			alert("请放入卡片");
			return false;
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
					/*
					 * alert("当前卡信息验证失败,请先重新点击'读卡'"); cardOCX.CloseComm();
					 * return false;
					 */
				}
				
				if(jQuery("#customerName").val()==""||psamcardno=="0"||asn==""||snr==""){
					alert("请先点击'读卡'");
					cardOCX.CloseComm();
					return false;
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
	
	/* 预充值操作 */
	var opFare=Number(jQuery("#chargeMoney").val())*100;
	// 空-失败, a@b@c...-成功: SAM卡终端编号, 当前余额, 充值计数, 随机数, mac1, 密钥版本, 算法标识
	// 参数objNo钱包号默认1-主钱包，2-补助钱包，kid密钥索引默认1，opFare要充值的金额：分为单位
	var fchrInit=cardOCX.ChargeInit(1,1,opFare);
	// 预充值结果解析
	if(fchrInit!=""&&fchrInit!=null){
		var a0=fchrInit.toString().split("@")[0];// SAM卡终端编号
		var a1=fchrInit.toString().split("@")[1];// 当前余额
		var a2=fchrInit.toString().split("@")[2];// 充值计数
		var a3=fchrInit.toString().split("@")[3];// 随机数
		var a4=fchrInit.toString().split("@")[4];// mac1
		var a5=fchrInit.toString().split("@")[5];// 密钥版本
		var a6=fchrInit.toString().split("@")[6];// 算法标识
		mac1=a4;
		if(mac1==""){
			cardOCX.CloseComm();
			alert("预充值失败(获取mac1错)");
			return ;
		}
		
		if(cardKind=="1"){
			mac2=mac1;
		}
		if(cardKind=="2"){
			// 调用密钥系统CheckMac校验，返回Mac2
			/*
			 * var dat=
			 * {method:"CheckMac",pAuthID:4,ASN:asn,Rand:a3,NoteCase:0,OddFare:a1,OpCount:a2,OpFare:opFare,PosCode:a0,mac1:mac1};
			 * $("#form0").ajaxSubmit({ url:"reqECardPreServiceCity",
			 * dataType:'json', data: dat, success:function(result){
			 * if(result.success){ if(result.msg=="OK"){ if(result.data!=null){
			 * var xml=result.data.soapResponseData; var
			 * opdate=result.data.opdate; var code=
			 * jQuery(xml).find("CheckMacResult").html();
			 * if(code==-13||code==100){ mac2= jQuery(xml).find("MAC").html();
			 * }else{ var errMsg= jQuery(xml).find("out_msg").html();
			 * alert("密钥系统请求失败:"+errMsg+"[code="+code+"]"); return; } //
			 * alert(code+"\n"+mac2+"\n"+opdate+"\n"+errMsg); } }else{
			 * alert(result.msg); return; } }else{ alert(result.msg); return; } },
			 * error:function(e){ alert("系统错误：密钥系统请求失败"); return; } });
			 */
			mac2=mac1;
			/*
			 * if(mac2==mac1){ alert("系统错误：密钥系统请求失败"); return; }
			 */
		}
	}else{
		cardOCX.CloseComm();
		alert("预充值失败");
		return ;
	}
	
	/* OCX调用：关闭端口读卡器 */
	cardOCX.CloseComm();
	// /////////////////////////////////////////////////////////////////////
	
	
	/* 充值申请，充值金额二次确认 */
	jQuery(document).ready(function(){
		if(confirm("请再次确定充值金额："+jQuery("#chargeMoney").val()+"元.\n您确定要充值操作?")){
			// 封装读卡数据、充值数据
			// 充值按钮不可用
		    jQuery("#btnAdd").hide();
			// 充值申请处理
			jQuery("#form1").ajaxSubmit({
				url:"reqChashToWallet",
				type:"post",
				data: {readData:readData,chargeMoney:jQuery("#chargeMoney").val(),useCardCoat:$("#useCardCoat").attr("checked")?"1":"0",mac1:mac1,mac2:mac2,tacdt:tacdt},
				dataType:'json',
				success:function(result){
					if(result.success){
						if(result.msg=="OK"){
							// 返回申请结果
							var dt= eval("(" + result.data + ")");
							tacdt=dt.tacdt;// 统一的19位申请时间串
							reqData=result.data;
							// 客户端充值写卡
							if(writeTermCard()){
								// 判断充值写卡的结果
								 if(wcardSaveOpCnt==(Number(cardSaveOpCnt)+1)&&wcardRec==Number(cardRec)+Number(Number(jQuery("#chargeMoney").val())*100)){
									// 写卡成功
									commitChashToWallet("Y");
								}else{
									// 写卡失败
									commitChashToWallet("N");
								} 
							}else{
								// 终端写卡异常
								 commitChashToWallet("E"); 
							}
						}else{
							// 验证不通过直接返回
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
				// 读卡和点击充值存在时间差,防止读卡后有其他操作(和读卡时卡片余额对比)
				var fcardRec=cardOCX.GetEPoddFare();
				if(Number(fcardRec)!=Number(cardRec)){
					// alert("当前卡信息验证失败,请先重新点击'读卡'");
					// cardOCX.CloseComm();
					// return false;
				}
				
			    // dt时间 生成的19位固定值所有充值记录都用此值，empNo充值员编号，devNo设备编号
				// 传psan卡号（CPU卡不需要）
			    // 空-失败, 其它-tac
				// tac=cardOCX.Charge( BSTR dt, BSTR mac2, BSTR empNo, BSTR
				// devNo);
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
						cardOCX.CloseComm();
						// return true;
					}
			    }
			    
			    // TEST模拟卡片测试数据-------
				wcardOpCnt=cardOpCnt;
				wcardSaveOpCnt=Number(cardSaveOpCnt)+1;
				wcardRec=Number(cardRec)+Number(Number(jQuery("#chargeMoney").val())*100);// 分
				// TEST模拟卡片测试数据-------
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


// 充值申请后返回的数据
var reqData;

/* 充值提交 */
function commitChashToWallet(flag){
	jQuery("#form1").ajaxSubmit({
		url:"commitChashToWallet",
		type:"post",
		data: {reqData:reqData,useCardCoat:$("#useCardCoat").attr("checked")?"1":"0",writeFlag:flag,tac:tac,wcardRec:wcardRec,wcardOpCnt:wcardOpCnt,wcardSaveOpCnt:wcardSaveOpCnt},
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