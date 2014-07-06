/*移除左边选中的列表项到右边*/
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

/* 清空select所有options */
function clearAllOptions(oSelect) {
	if (oSelect) {
		var ops = oSelect.options;
		while (ops.length > 0) {
			oSelect.remove(ops.length - 1);
		}
	}
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