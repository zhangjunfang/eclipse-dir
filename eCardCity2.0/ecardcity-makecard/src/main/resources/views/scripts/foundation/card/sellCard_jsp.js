/*消费卡充值业务交互方法*/
jQuery.ajaxSetup({
	cache : false
});

/* 页面加载后初始化按钮及输入数字格式化限制数字输入 */
jQuery(function() {
	var reg = /[\$,%]/g;
	// 充值金额
	jQuery("#chargeMoney").keyup(
			function() {
				// this.value = this.value.replace(/[^\d]/g,
				// '').replace(/(\d{3})(?=\d)/g, "$1,");
				// toFixed小数点后两位
				var key = parseFloat(String(this.value).replace(reg, ''))
						.toFixed(2); 
				if (String(this.value).indexOf(".") > 0) {
					this.value = isNaN(key) ? 0.00 : key;
				} else {
					this.value = this.value.replace(/[^\d]/g, '');
				}
				var cardCost = jQuery("#cardCost").val();
				var manageCost = jQuery("#manageCost").val();
				var cardTaoCoat = jQuery("#cardTaoCoatTxt").val();
				var cost = Number(cardCost) + Number(manageCost)
						+ Number(cardTaoCoat);
				// 应收
				document.getElementById("spCharge").innerHTML = this.value
						+ cost;
				// 找零
				document.getElementById("spRec").innerHTML = (isNaN(jQuery(
						"#recMoney").val()) ? 0.00 : Number(jQuery("#recMoney")
						.val()))
						- this.value - cost;
			});
	// 实收款项
	jQuery("#recMoney").keyup(
			function() {
				var key = parseFloat(String(this.value).replace(reg, ''))
						.toFixed(2);
				if (String(this.value).indexOf(".") > 0) {
					this.value = isNaN(key) ? 0.00 : key;
				} else {
					this.value = this.value.replace(/[^\d]/g, '');
				}
				var cardCost = jQuery("#cardCost").val();
				var manageCost = jQuery("#manageCost").val();
				var cardTaoCoat = jQuery("#cardTaoCoatTxt").val();
				var cost = Number(cardCost) + Number(manageCost)
						+ Number(cardTaoCoat);
				// 应收
				document.getElementById("spCharge").innerHTML = (isNaN(jQuery(
						"#chargeMoney").val()) ? 0.00 : Number(jQuery(
						"#chargeMoney").val()))
						+ cost;
				// 找零
				document.getElementById("spRec").innerHTML = this.value
						- cost
						- (isNaN(jQuery("#chargeMoney").val()) ? 0.00
								: Number(jQuery("#chargeMoney").val()));
			});
	// 售卡按钮不可用
	jQuery("#btnSell").attr("disabled", true);
	// 表单必填验证：
	jQuery("#form1").validation();
	jQuery("#form2").validation();
	// 获取及时消息
	onRefresh();
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

// M1卡片MAC
var cardmac16="";
var cardmac="";

// 点击"读卡"按钮提交后台验证后的返回数据
var readData;

/* 读取终端卡片信息 */
function readTermCard(){
	if (cardOCX == null) {
		alert("读卡器插件加载异常");
		return false;
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
			// 进制转换 16to10
			snr=parseInt(b,16);
			// 卡应用序列号ASN
			var fasn=cardOCX.GetASNandMAC();
			if(a=="4"){
				cardKind="1";
				// 16位十六进制
				asn16=fasn.substring(0,16);
				// 8位16进制
				cardmac16=fasn.substring(16,24);
			}else if(a=="8"){
				cardKind="2";
				// 16位十六进制
				asn16=fasn.substring(4,20);
			}
			
			/* 读取卡片客户信息判断是否为已发的卡片 */
			var rperson=cardOCX.ReadPersonInfo();
			// name 姓名
			var pname=rperson.toString().split("@")[0];
			// 市民卡号（m1卡存在CPU卡空）
			// var pcode=rperson.toString().split("@")[1];
			// 证件号码/身份证号
			var pidno=rperson.toString().split("@")[2];
			// 客户名称空
			if(pname==""&&(pidno==""||Number(pidno)==0)){
				// 空卡片
			}else{
				 alert("此卡片不是空卡[name=("+pname+")idno=("+pidno+")]!");
				 cardOCX.CloseComm();
				 return false;
			}
		}
	}else{
		alert("打开读卡器端口失败");
		return false;
	}
	
	/* 关闭端口读卡器 */
	cardOCX.CloseComm();
	return true;
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
	// 重置读卡数据
	resetReadCardInfo();
	
	// 读卡
	if(readTermCard()==false){
		return ;
	}
	if(psamcardno=="0"||snr==""){
		alert("读卡失败,请检查");
		return ;
	}
	
	/* Java：调用库中信息，验证是否可售卡 */
	var dat = {
			psamcardno : psamcardno,
			asn16 : asn16,
			snr : snr,
			cardKind : cardKind,
			userId : userId,
			saleCardtype : saleCardtype
		};
	jQuery("#form0").ajaxSubmit({
		url:"readCardForSellCard",
		type:"post",
		data:dat,
		dataType:'json',
		success:function(result){
			if(result.success){
				if(result.msg=="OK"){
					var dt= eval("(" + result.data + ")");
					readData=result.data;
					asn=dt.asn;
					jQuery("#cardno").val(dt.cityCardNo);
					jQuery("#onlineAccount").html("ZXZH"+dt.cityCardNo);
					jQuery("#name").focus();
					// 费用
					jQuery("#chargeMoney").val("0.00");
					if(cardKind=="1"){
						jQuery("#cardCost").val("10.00");
						jQuery("#manageCost").val("25.00");
					}
					if(cardKind=="2"){
						jQuery("#cardCost").val("20.00");
						jQuery("#manageCost").val("25.00");
					}
					jQuery("#btnSell").attr("disabled",false);
				}else{
					alert(result.msg);
				}
			}else{
				alert(result.msg);
			}
		},
		error:function(e){
			alert("系统错误：读卡失败");
		}
	}); 
}

/* 刷新重置读卡数据 */
function resetReadCardInfo(){
	if(asn16==""){
		return ;
	}
	jQuery("#cardno").val("");
	jQuery("#onlineAccount").val("");
	readData=null;
}

/* 身份证号生成生日 */
function onBirth(){
	var idcardno=jQuery("#idcardno").val();
	if(idcardno.length==18){
		var id17=idcardno.substring(0,17);
		var id18=idcardno.substring(16,17);
		var y=idcardno.substring(6,10);
		var m=idcardno.substring(10,12);
		var d=idcardno.substring(12,14);
		if(m>12||d>31){
		}else if(!isNaN(id17)){
			jQuery("#birthday").val(""+y+"-"+m+"-"+d);
		}
	}else{
	}
}

/* 读取身份证信息 */
function clickIDCard(){
	alert("没有相关读卡器和OCX，建设中...");
}

/* 验证售卡必填项 */
function checkIsCanSellCard(){
	
	if(psamcardno=="0"||asn==""||snr==""){
		alert("请先读卡");
		return false;
	}
	if(jQuery("#cardno").val()==""||jQuery("#cardno").val()=="0"){
		jQuery("#cardno").focus();
		return false;
	}
	if(jQuery("#name").val()==""){
		jQuery("#name").focus();
		return false;
	}
	
	var tel=jQuery("#telephone").val();
	if(tel==""||isNaN(tel)){
		jQuery("#telephone").focus();
		return false;
	}
	
	// 证件号码验证、生日自动填写
	var idcardno=jQuery("#idcardno").val();
	if(idcardno.length==18){
		var id17=idcardno.substring(0,17);
		var id18=idcardno.substring(16,17);
		var y=idcardno.substring(6,10);
		var m=idcardno.substring(10,12);
		var d=idcardno.substring(12,14);
		if(m>12||d>31){
			alert("证件号码无效");
			jQuery("#idcardno").focus();
			return false;
		}
		if(!isNaN(id17)){
			jQuery("#birthday").val(""+y+"-"+m+"-"+d);
		}
	}else{
		jQuery("#idcardno").focus();
		return false;
	}
	
	// 收费信息
	var cardCost=jQuery("#cardCost").val();
	var manageCost=jQuery("#manageCost").val();
	var chargeMoney=jQuery("#chargeMoney").val();
	var recMoney=jQuery("#recMoney").val();
	var cardTaoCoat = jQuery("#cardTaoCoatTxt").val();
	
	if(isNaN(cardCost)){
		jQuery("#cardCost").focus();
		return false;
	}
	if(isNaN(manageCost)){
		jQuery("#manageCost").focus();
		return false;
	}
	if(isNaN(chargeMoney)){
		jQuery("#chargeMoney").focus();
		return false;
	}
	if(isNaN(recMoney)){
		jQuery("#recMoney").focus();
		return false;
	}
	
	var cost = Number(cardCost) + Number(manageCost)+ Number(cardTaoCoat)+Number(chargeMoney);
	if(Number(recMoney)<cost){
		jQuery("#recMoney").focus();
		return false;
	}
	return true;
}
/* 验证售卡的卡片和读卡验证时的卡是否为同一张 */
function isTheSameCard(){
	if(readData==null){
		alert("请先点击'读卡'");
		return false;
	}
	var dt= eval("(" + readData + ")");
	if(dt.custId==""||dt.cityCardNo==""||psamcardno=="0"||asn==""||snr==""){
		alert("请先点击'读卡'");
		return false;
	}
	
	if(dt.cardKind!=cardKind||dt.asn!=asn){
		alert("请放入原卡片");
		return false;
	}
	if(dt.psamcardno!=psamcardno){
		alert("终端检查失败,请重新'读卡'操作");
		location.reload();// 刷新页面
		return false;
	}
	return true;
}

/* 点击售卡实现的业务 */
function clickSell(){
	/* 验证必填项 */
	if(checkIsCanSellCard()==false){
		return ;
	}
	
	/* 调用OCX再次读卡，覆盖上一次读卡的结果(终端、卡片) */
	readTermCard();
	
	/* 判断两次读卡是否一致 */
	if(isTheSameCard()==false){
		return ;
	}
	
	/* 获取TAC、MAC等信息,用于密钥系统验证 */
	// 测试的
	var tac="tac0000212";
	// 收费信息
	var cardCost=jQuery("#cardCost").val();
	var manageCost=jQuery("#manageCost").val();
	var chargeMoney=jQuery("#chargeMoney").val();
	var cardTaoCoat = jQuery("#cardTaoCoatTxt").val();
	// 请求参数
	var dat= {readData:readData,cardCost:cardCost,manageCost:manageCost,chargeMoney:chargeMoney,cardTaoCoat:cardTaoCoat,tac:tac};
	$("#form1").ajaxSubmit({
		url:"reqSellChard",
		type:"post",
		dataType:'json',
		data: dat,
		success:function(result){
			var dt= eval("(" + result.data + ")");
			reqData=result.data;
			if(result.success){
				if(result.msg=="OK"){
					// 客户端售卡写卡
					if(writeTermCard()==true){
						// 判断售卡写卡的结果
						// 写卡成功
						commitToSellCard("Y");
					}else{
						// 终端写卡异常
						commitToSellCard("N"); 
					}
				}else{
					// 直接返回
					alert(result.msg);
					// commitToSellCard("E");
				}
			}else{
				// commitToSellCard("E");
				alert(result.msg);
			}
		},
		error:function(e){
			alert("系统错误：售卡请求失败");
		}
	});		    
}

/* 获取发卡充值密钥 */
function getTopUpKey(cardmac,asn){
	return "";
}	

/* 调用终端写卡 */
function writeTermCard(){
	if (cardOCX == null) {
		alert("读卡器插件加载异常");
		return false;
	}
	// 打开读卡器，0是成功，其它失败
	var openValue = cardOCX.OpenComm(); 
	if(openValue==0){
		
		// 系统参数设置卡类型
		var isM1=Number((cardKind=="1")?1:0);
        cardOCX.SetCompCardType(isM1);
		
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
			// 是同一张卡片
			if(wsnr==snr&&wckind==cardKind){
				var dt= eval("(" + reqData + ")");
				
				// M1卡获取密钥、设置卡片密钥
				if(cardKind=="1"){
					cardmac=parseInt(cardmac16,16);
					// var chrKey=GetTopUpKey(cardmac,asn);
					// var keyRS=cardOCX.SetChrgKey(chrKey);
					/*
					 * if(keyRS!=0){ alert("设置卡片密钥失败"); return false; }
					 */
				}
				
				// 更新卡片信息
				var now=new Date();
				var m=Number(now.getMonth()+1)>=10?(now.getMonth()+1):("0"+(now.getMonth()+1));
				var d=now.getDate()>=10?now.getDate():("0"+now.getDate());
				// 发行日期，YYYY-MM-DD
				var pubDate=""+now.getFullYear()+"-"+m+"-"+d;
				// 启用日期，YYYY-MM-DD
				var useDate=pubDate;
				// 有效日期，YYYY-MM-DD
				var validDate=""+(now.getFullYear()+50)+"-"+m+"-"+d;
				// 年检开始日期，YYYY-MM-DD
				var ycSDate=""+(now.getFullYear()+20)+"-01-01";
				// 年检结束日期，YYYY-MM-DD
				var ycEDate=""+(now.getFullYear()+20)+"-12-31";
				 // 卡类别，0-普通卡(>0)
				var cardClass=Number(cardKind);
				// 启用标志，1-未启用，2-启用，3-停用，4-黑名单
				var useFlag=2;
				// 黑名单标志
				var blFlag=0;
				// 押金，单位：元
				var forgift=30;
				// 不记名标记，默认0-记名，1-不记名
				var nidFlag=Number(dt.nidFlag);
				// 月票启用标志：
				// B0-B1:电子钱包状态，0：禁用，非0：启用。
				// B2-B3:月票钱包状态，0：禁用，非0：启用。
				// B4-B5:次卡钱包状态，0：禁用，非0：启用。
				// B6-B7: 0：月卡，1：季卡，2：半年卡，3：年卡。
				var tktFlag=Number(00000000);
				// 年检适用类型，0-无须年检，1-钱包，2-月票，4-次卡，可以相加组合
				var ycType=0;
				 // 帐号
				var custId=Number(dt.custId);
				// 持卡序号
                var cardSn=Number(dt.makeCard.cardsn); 
                // 售卡：传参
				var sale0=cardOCX.RegAndSale0(custId,cardSn,pubDate,useDate,validDate,ycSDate,ycEDate,cardClass,useFlag,blFlag,forgift,nidFlag,tktFlag,ycType);
				if(sale0==0){
					// 版本
					var ver=1;
					// 性别
		            var sex=Number(dt.sex);
		            // 民族
		            var nation=Number(dt.nation);
		            // 证件类型
		            var idType=Number(dt.certificateid);
		            // 国家
                    var country=Number(dt.country);
                    // 消费日期
                    var consumeDate=""+m+""+d;
                    // 姓名
                    var name=dt.name;
                    // 卡号code 市民卡号
                    var cardNo=dt.cardno;
                    // 身份证号码/证件号码
                    var idCardNo=dt.idcardno;
                    // 制卡日期
                    var makeDt=""+pubDate;
                    // 消费密码--查询密码--交易密码(写卡片不验证)
                    var consumePWD="000000";
                    // 个人密码--卡片的个人身份密码(写卡片不验证)
                    var asPwd=consumePWD;
                    // 应用锁定时间YYYY-MM-DD HH:MM:SS
                    var appLockTime=validDate+" 12:59:00";
                    // 卡冻结时间 YYYY-MM-DD HH:MM:SS
                    var cardIdleTime=appLockTime;
                    // 市民卡类型(大类)：00：普通卡，01：福利卡,02、管理卡,03:其他
                    var cardtype=Number(dt.cardtypebig);
					// 市民卡用途(关联小类)：
                    // 普通卡：21 B卡 22 A卡 23 AB卡 24 C 卡 25 D卡 26 E 卡
		            // 公交管理卡：1司机卡 2线路设置卡 3票价卡 4签点卡 5管理卡（充值、登陆等）6采集卡 7调度卡
		            var cardFunc=Number(dt.cardtype);
		            // 主卡类型（小额支付扩展预留）
		          	var typeMaster=0;
		          	// 副卡类型（小额支付扩展预留）
		            var typeSlave=0;
		            // 售卡：传参并提交的动作
					var sale1=cardOCX.RegAndSale1(ver,sex,nation,0,0,idType,country,"000000",0,0,consumeDate,name,cardNo,idCardNo,"0",makeDt,consumePWD,asPwd,"err",appLockTime,cardIdleTime,0, cardtype,cardFunc,typeMaster,typeSlave);
		            if(sale1==0){
		            	// 写卡成功
		            	cardOCX.CloseComm();
		            	return true;
		            }else{
		            	// 写卡失败
		            	var wcard=cardOCX.GetSysMsg();
		            	// alert(wcard);
		            	cardOCX.CloseComm();
		            	return false;
		            }
				}
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

// 提交数据
var reqData;// 售卡申请后返回的数据
function commitToSellCard(flag){
	var dat= {reqData:reqData,writeFlag:flag,psamcardno:psamcardno};
	jQuery("#form2").ajaxSubmit({
		url:"commitSellChard",	
		type:"post",
		data:dat,
		dataType:'json',
		success:function(result){
			// 返回充值提交结果，数据封装打印信息
			if(result.success){
				// 充值完成
				// 调用打印弹出窗口
				var dt= eval("(" + result.data + ")");
				if(dt.writeFlag=="Y"&&result.msg=="OK"){
					alert("售卡成功!");
					// 重置当前页面
					location.reload();
				}else{
					alert("售卡失败!");
					// 重置当前页面
					location.reload();
				}
				// alert(dt);
				/*
				 * var docStr = ""; docStr=dt.netName+"\n";
				 * docStr+="==========================================\n";
				 * docStr+="户名:"+dt.custName+"\n";
				 * docStr+="卡号:"+dt.custCardNo+"\n";
				 * docStr+="交易类型:"+dt.opType+"\n";
				 * docStr+="交易金额:"+dt.opFare+"\n";
				 * docStr+="交易时间:"+dt.opTime+"\n";
				 * docStr+="交易应答:"+dt.opOK+"\n\n";
				 * docStr+="商户名称(代码):"+dt.merchantCode+"\n";
				 * docStr+="终端名称(编号):"+dt.termCode+"\n";
				 * docStr+="操作员:"+dt.userName+"\n";
				 * docStr+="流水号:"+dt.planId+"\n"; docStr+="客户签名：\n\n";
				 * docStr+="==========================================\n";
				 * docStr+="备注:请当面核对账务，请妥善保存凭条";
				 * 
				 * alert(docStr);
				 */
			}else{
				alert(result.msg);
				// 重置当前页面
				location.reload();
			}
		},
		error:function(e){
			alert("系统错误：充值提交失败");
			// 重置当前页面
			location.reload();
		}
	});
}
