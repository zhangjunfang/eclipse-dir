/* 移动当前选定的Option到目标Select */
function fMoveCurrentOptionToTarget(sourceSel,targetSel){
    if (!(sourceSel && targetSel)) {
	return;
    }
    
    for ( var i = 0; i < sourceSel.options.length; i++) {
	if (sourceSel.options[i].selected) {
	    var oOption = new Option(sourceSel.options[i].text,sourceSel.options[i].value, false, false);
	    targetSel.options[targetSel.length] = oOption;
	    break;
	}
    }
    clearSelectedOptions(sourceSel);
}

/* 移除左边选中的列表项到右边 */
function fMoveSelectedOptionsLeftToRight(oLeft, oRight) {
	if (!(oLeft && oRight)) {
		return;
	}
	if (!hasOptions(oLeft)) {
		return;
	}
	if (oLeft.selectedIndex == -1) {
		oLeft.selectedIndex = 0;
	}
	for ( var i = 0; i < oLeft.options.length; i++) {
		if (oLeft.options[i].selected) {
			var oOption = new Option(oLeft.options[i].text,
					oLeft.options[i].value, false, false);
			oRight.options[oRight.length] = oOption;
		}
	}
	clearSelectedOptions(oLeft);
}

/* 移除左边的所有列表项到右边 */
function fMoveAllOptionsLeftToRight(oLeft, oRight) {
	if (!(oLeft && oRight)) {
		return;
	}
	if (!hasOptions(oLeft)) {
		return;
	}
	for ( var i = 0; i < oLeft.options.length; i++) {
		var oOption = new Option(oLeft.options[i].text, oLeft.options[i].value,
				false, false);
		oRight.options[oRight.length] = oOption;
	}
	clearAllOptions(oLeft);
}

/* 移除右边选中的列表项到左边 */
function fMoveSelectedOptionsRightToLeft(oLeft, oRight) {
	if (!(oLeft && oRight)) {
		return;
	}
	if (!hasOptions(oRight)) {
		return;
	}
	if (oRight.selectedIndex == -1) {
		oRight.selectedIndex = 0;
	}
	for ( var i = 0; i < oRight.options.length; i++) {
		if (oRight.options[i].selected) {
			var oOption = new Option(oRight.options[i].text,
					oRight.options[i].value, false, false);
			oLeft.options[oLeft.length] = oOption;
		}
	}
	clearSelectedOptions(oRight);
}

/* 移除右边的所有列表项到左边 */
function fMoveAllOptionsRightToLeft(oLeft, oRight) {
    alert("test");
	if (!(oLeft && oRight)) {
		return;
	}
	if (!hasOptions(oRight)) {
		return;
	}
	for ( var i = 0; i < oRight.options.length; i++) {
		var oOption = new Option(oRight.options[i].text,
				oRight.options[i].value, false, false);
		oLeft.options[oLeft.length] = oOption;
	}
	clearAllOptions(oRight);
}

/* 清空select所有选中的options */
function clearSelectedOptions(oSelect) {
	if (oSelect) {
		for ( var i = 0; i < oSelect.options.length; i++) {
			if (oSelect.options[i].selected) {
				oSelect.remove(i--);
			}
		}
	}
}

/* 判断select是否有options */
function hasOptions(oSelect) {
	if (oSelect) {
		return oSelect.options.length > 0;
	}
	return false;
}

/* 返回指定Select的Option，用“,”分隔 */
function selectToStr(sel){
    if (!(sel)) {
	return;
    }
    
    var rtnStr="";
    for ( var i = 0; i < sel.options.length; i++) {
	rtnStr+=sel.options[i].value+",";
    }
    return rtnStr.substring(0, rtnStr.length-1);
}

/* 根据源select的option移除目标select的相同option */
function removeTargetOption(sourSel,targetSel){
    for(var i=0;i< targetSel.options.length;i++){
	for(var j=0;j<sourSel.options.length;j++){
	    if(targetSel.options[i].value==sourSel.options[j].value && targetSel.options[i].text==sourSel.options[j].text){
		targetSel.remove(i--);
		break;
	    }
	}
    }
}