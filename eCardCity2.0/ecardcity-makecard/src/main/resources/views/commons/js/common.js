//Define global base path
var _location = (window.location+'').split('/'); 
var _basePath = _location[0]+'//'+_location[2]+'/'+_location[3]; 
var _metronicPath=_basePath+"/commons/plugins/metronic2.0.2/";
//alert("_metronicPath--->"+_metronicPath);

function getContextPath() {
    return "..";
}

/* show or didden DIV */
function showOrHiddenDiv(divId) {
    var oDivId = document.getElementById(divId);
    if (oDivId) {
	oDivId.style.display = (oDivId.style.display == "none" ? "block"
		: "none");
    }
}

/* 显示DIV */
function showDiv(divId) {
    var oDivId = document.getElementById(divId);
    if (oDivId) {
	oDivId.style.display = "block";
    }
}

/* 隐藏DIV */
function hiddenDiv(divId) {
    var oDivId = document.getElementById(divId);
    if (oDivId) {
	oDivId.style.display = "none";
    }
}

/* 显示SELECT元素 */
function showElement(id) {
    var oId = document.getElementById(id);
    if (oId) {
	oId.style.visibility = "visible";
    }
}

/* 隐藏SELECT元素 */
function hiddenElement(id) {
    var oId = document.getElementById(id);
    if (oId) {
	oId.style.visibility = "hidden";
    }
}

/* 弹出窗口 */
function newWin(url, winName, width, height) {
    var top = (window.screen.height - height) / 2;
    var left = (window.screen.width - width) / 2;
    window.open(url, winName,
	    "scrollbars=yes,toolbar=no,location=no,direction=no,resizeable=no,width="
		    + width + " ,height=" + height + ",top=" + top + ",left="
		    + left);
}

/* 设置innerHTML */
function setInnerHTMLById(id, value) {
    var oId = document.getElementById(id);
    if (oId) {
	oId.innerHTML = value;
    }
}

/* 只能输入数字 */
function InputOnlyNumber(evt) {
    var oEvent = evt ? evt : window.event;
    var keyCode = oEvent.keyCode;
    if (!((keyCode >= 48 && keyCode <= 57) || (keyCode >= 96 && keyCode <= 105)
	    || keyCode == 8 || keyCode == 9 || keyCode == 13 || keyCode == 37 || keyCode == 39)) {
	if (oEvent.preventDefault) {
	    oEvent.preventDefault();
	} else {
	    oEvent.returnValue = false;
	}
    }
}

/* 清空select options */
function clearOptions(oSelect) {
    if (oSelect) {
	var ops = oSelect.options;
	while (ops.length > 0) {
	    oSelect.remove(ops.length - 1);
	}
    }
}

/* 清空TBody */
function clearTBody(oTbodyId) {
    if (oTbodyId) {
	while (oTbodyId.rows.length > 0) {
	    oTbodyId.deleteRow(oTbodyId.rows.length - 1);
	}
    }
}

/* fmt:yyyy-MM-dd */
function fmtDate(date) {
    if (!date) {
	return "";
    }
    var yyyy = date.getYear();
    if (yyyy < 1900) {
	yyyy += 1900;
    }
    var MM = date.getMonth() + 1;
    if (MM < 10) {
	MM = "0" + MM;
    }
    var dd = date.getDate();
    if (dd < 10) {
	dd = "0" + dd;
    }
    return yyyy + "-" + MM + "-" + dd;
}

/* fmt:yyyy-MM-dd HH:mm:ss */
function fmtDateTime(date) {
    if (!date) {
	return "";
    }
    var yyyy = date.getYear();
    if (yyyy < 1900) {
	yyyy += 1900;
    }
    var MM = date.getMonth() + 1;
    if (MM < 10) {
	MM = "0" + MM;
    }
    var dd = date.getDate();
    if (dd < 10) {
	dd = "0" + dd;
    }
    var HH = date.getHours();
    if (HH < 10) {
	HH = "0" + HH;
    }
    var mm = date.getMinutes();
    if (mm < 10) {
	mm = "0" + mm;
    }
    var ss = date.getSeconds();
    if (ss < 10) {
	ss = "0" + ss;
    }
    return yyyy + "-" + MM + "-" + dd + " " + HH + ":" + mm + ":" + ss;
}

/* 全选 */
function fSelectAll(obj, list) {
    if (!(obj && list)) {
	return;
    }
    if (list.length) {
	for (var i = 0; i < list.length; i++) {
	    list[i].checked = obj.checked;
	}
    } else {
	list.checked = obj.checked;
    }
}

/* 复选框是否有选中的 */
function fCheckboxHasChecked(oCheckbox) {
    if (!oCheckbox) {
	return false;
    }
    if (oCheckbox.length) {
	for (var i = 0; i < oCheckbox.length; i++) {
	    if (oCheckbox[i].checked) {
		return true;
	    }
	}
	return false;
    } else {
	return oCheckbox.checked;
    }
}

/* 返回复选框选中的值 */
function fGetCheckboxValue(oCheckbox) {
    var values = new Array();
    if (!oCheckbox) {
	return values;
    }
    if (oCheckbox.length) {
	for (var i = 0; i < oCheckbox.length; i++) {
	    if (oCheckbox[i].checked) {
		values.push(oCheckbox[i].value);
	    }
	}
    } else {
	if (oCheckbox.checked) {
	    values.push(oCheckbox.value);
	}
    }
    return values;
}

/* 单选是否选中 */
function fRadioIsChecked(oRadio) {
    if (!oRadio) {
	return false;
    }
    if (oRadio.length) {
	for (var i = 0; i < oRadio.length; i++) {
	    if (oRadio[i].checked) {
		return true;
	    }
	}
	return false;
    } else {
	return oRadio.checked;
    }
}

/* 返回单选选中的值 */
function fGetRadioValue(oRadio) {
    if (!oRadio) {
	return null;
    }
    if (oRadio.length) {
	for (var i = 0; i < oRadio.length; i++) {
	    if (oRadio[i].checked) {
		return oRadio[i].value;
	    }
	}
    } else {
	if (oRadio.checked) {
	    return oRadio.value;
	}
    }
    return null;
}

/* add string trim() */
String.prototype.trim = function() {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
};

/* trimBlank() */
function trimBlank(str) {
    if (str.length == 0) {
	return "";
    }
    while (str.charAt(0) == " ") {
	str = str.substr(1);
    }
    while (str.charAt(str.length - 1) == " ") {
	str = str.substring(0, str.length - 1);
    }
    return str;
}

/* 添加数据 */
function fAddData(url) {
    location.href = url;
}

/* 修改数据 */
function fUpdateData(oForm, url) {
    var oId = oForm['id'];
    if (!oId) {
	return;
    }
    if (!fCheckboxHasChecked(oId)) {
	alert("请选择您要修改的记录!");
	return;
    }
    var values = fGetCheckboxValue(oId);
    if (values.length != 1) {
	alert("只能选择一条记录!");
	return;
    }
    location.href = url + values[0];
}

/* 导出数据 */
function fExportData(oForm, url) {
    var oId = oForm['id'];
    if (!oId) {
	return;
    }
    if (!fCheckboxHasChecked(oId)) {
	alert("请选择您要导出的记录!");
	return;
    }
    var values = fGetCheckboxValue(oId);
    if (values.length != 1) {
	alert("只能选择一条记录!");
	return;
    }
    location.href = url + values[0];
}

/* 删除数据 */
function fDeleteData(oForm, url) {
    var oId = oForm['id'];
    if (!oId) {
	return;
    }
    if (!fCheckboxHasChecked(oId)) {
	alert("请选择您要删除的记录!");
	return;
    }
    if (!confirm("您确定要删除这些记录吗?")) {
	return;
    }
    oForm.action = url;
    oForm.method = "post";
    oForm.submit();
}

/* 校验IP地址是否合法 */
function checkIPAddr(ipAddr) {
    var reg = /^(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})$/;
    return ipAddr.match(reg) != null && RegExp.$1 <= 255 && RegExp.$1 >= 0
	    && RegExp.$2 <= 255 && RegExp.$2 >= 0 && RegExp.$3 <= 255
	    && RegExp.$3 >= 0 && RegExp.$4 <= 255 && RegExp.$4 >= 0
}

/* 若数字的长度小于指定的长度前补零 */
function fillZero(str, length) {
    var len = length - str.length;
    if (len <= 0) {
	return str;
    }
    var sb = new Array();
    for (var i = 0; i < len; i++) {
	sb.push("0");
    }
    sb.push(str);
    return sb.join("");
}

/* 将管理地址转换为网络地址 */
function changeManageAddrToNetAddr(manageAddr, cityCode) {
    var sb = new Array();
    var addr = manageAddr.split('.');
    for (var i = 0; i < addr.length; i++) {
	sb.push(fillZero(addr[i], 3));
    }
    var tmpAddr = sb.join("");
    return "86:" + cityCode + ":" + tmpAddr.substring(0, 4) + ":"
	    + tmpAddr.substring(4, 8) + ":" + tmpAddr.substr(8) + ":00"
}

/* 得到字符串的字节长度 */
function fGetByteLen(str) {
    if (!str) {
	return 0;
    }
    var len = str.length;
    var count = len;
    for (var i = 0; i < len; i++) {
	if (str.charCodeAt(i) < 0 || str.charCodeAt(i) > 255) {
	    count++;
	}
    }
    return count;
}

/* 比较开始时间是否在结束时间之后 */
function fPickDate(startDate, endDate, flag) {
    if (startDate.value.length == 0 || endDate.value.length == 0) {
	return false;
    }
    var start = parseInt(startDate.value.replace(/[-]/g, ""));
    var end = parseInt(endDate.value.replace(/[-]/g, ""));
    if (start > end) {
	window.alert("开始时间应在结束时间之后！");
	flag ? startDate.value = '' : endDate.value = '';
    }
}

/* 校验网段是否合法 */
function checkNetAddr(netAddr) {
    var reg = /^(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\/(\d{1,2})$/;
    return netAddr.match(reg) != null && RegExp.$1 <= 255 && RegExp.$1 >= 0
	    && RegExp.$2 <= 255 && RegExp.$2 >= 0 && RegExp.$3 <= 255
	    && RegExp.$3 >= 0 && RegExp.$4 <= 255 && RegExp.$4 >= 0
	    && RegExp.$5 <= 32 && RegExp.$5 >= 0
}
