/**
 Title:框架控制所需要的JS代码
 author:侯博
 date:2005年07-07日
 */

//var rootpath = "/TopIcms";
var webroot = document.location.href;
webroot = webroot.substring(webroot.indexOf('//') + 2, webroot.length);
webroot = webroot.substring(webroot.indexOf('/') + 1, webroot.length);
webroot = webroot.substring(0, webroot.indexOf('/'));
var rootpath = '/' + webroot;

/*以下几个方法是利Dreamweaver自动产生的代码，主要用于控制图片的变换效果*/
function MM_preloadImages() { //v3.0
    var d = document;
    if (d.images) {
        if (!d.MM_p) d.MM_p = new Array();
        var i,j = d.MM_p.length,a = MM_preloadImages.arguments;
        for (i = 0; i < a.length; i++)
            if (a[i].indexOf("#") != 0) {
                d.MM_p[j] = new Image;
                d.MM_p[j++].src = a[i];
            }
    }
}

function MM_swapImgRestore() { //v3.0
    var i,x,a = document.MM_sr;
    for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++) x.src = x.oSrc;
}

function MM_findObj(n, d) { //v4.01
    var p,i,x;
    if (!d) d = document;
    if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
        d = parent.frames[n.substring(p + 1)].document;
        n = n.substring(0, p);
    }
    if (!(x = d[n]) && d.all) x = d.all[n];
    for (i = 0; !x && i < d.forms.length; i++) x = d.forms[i][n];
    for (i = 0; !x && d.layers && i < d.layers.length; i++) x = MM_findObj(n, d.layers[i].document);
    if (!x && d.getElementById) x = d.getElementById(n);
    return x;
}

function MM_swapImage() { //v3.0
    var i,j = 0,x,a = MM_swapImage.arguments;
    document.MM_sr = new Array;
    for (i = 0; i < (a.length - 2); i += 3)
        if ((x = MM_findObj(a[i])) != null) {
            document.MM_sr[j++] = x;
            if (!x.oSrc) x.oSrc = x.src;
            x.src = a[i + 2];
        }
}

//隐藏整个视图区
function hideViewArea() {
	top.document.getElementById("main").cols = "6,*";
	parent.document.getElementById("viewArea").cols = "0,6";
    var imageId = top.viewFrame.sizeControlFrame.document.getElementById("image");
    var imgSrc = "<a href=" + "javascript:showViewArea();" + "><img src='../" + "img/frame/showRight.gif' name='leftImage' width='7' height='50' border='0' id='leftImage' onMouseOver=" + " MM_swapImage('leftImage','','../" + "img/frame/showRightOver.gif',1)" + " onMouseOut=" + " MM_swapImgRestore()" + "></a>";
    imageId.innerHTML = imgSrc;
}

//显示整个视图区
function showViewArea() {
    top.main.cols = "180,*";
    top.viewFrame.viewArea.cols = "170,6";
    var imageId = top.viewFrame.sizeControlFrame.document.getElementById("image");
    var imgSrc = "<a href=" + "javascript:hideViewArea();" + "><img src='../" + "img/frame/hideLeft.gif' name='leftImage' width='7' height='50' border='0' id='leftImage' onMouseOver=" + " MM_swapImage('leftImage','','../" + "img/frame/hideLeftOver.gif',1)" + " onMouseOut=" + " MM_swapImgRestore()" + "></a>";
    imageId.innerHTML = imgSrc;
}


//菜单转向时把页面标题提到headFrame中去，然后在改变主页面的href地址
function toURL(name, url) {
    //把页面标题提交到Head页面中
    //top.headFrame.pageTitle.value = name;
    pageTitle.value = name;
    //清空导航栏，并隐藏
    //clearNavList();
    //跳转页面
    top.mainFrame.location.href = url;
}

//布局框架页面中提取headFrame中题的值
function getPageTitle() {
    var pageTitleStr = top.headFrame.pageTitle.value;
    var pageTitleId = document.getElementById("pageTitle");
    pageTitleId.innerHTML = pageTitleStr;
}

//导航栏上的资料入口
function navToURL(url) {
    //    top.headFrame.isShowNav.value = 'true';
    top.mainFrame.location.href = url;
}


/** -----------------导航栏使用的函数--------------------- **/
//checks browser and sets up layers accordingly
//var path = "default/images/navigate/";
var path = rootpath + "/frame/" + "default/images/navigate/";
//imgArray 是一个二维数组：[imgName,on_img_src,off_img_src]
var imgArray = [
        ["img1",path + "tab1_on.gif", path + "tab1_off.gif"] ,
        ["img2",path + "tab2_on.gif", path + "tab2_off.gif"] ]

//显示导航栏中的第一个面板，并隐藏其他面板
function showOne() {
    initnavigate();
    updateTabs('img1');
    showLayer('one');
    hideLayer('two');
    showNavigateView();
}

//显示导航栏中的第二个面板，并隐藏其他面板
function showTwo() {
    initnavigate();
    updateTabs('img2');
    showLayer('two');
    hideLayer('one');
    showNavigateView();
}

function showLayer(layerName) {
    if (top.viewFrame.navigateFrame.document.layers) {
        eval(layerRef + layerName + '.style.display="block"');
    } else {
        eval('top.viewFrame.navigateFrame.document.getElementById(' + "'" + layerName + "'" + ').style.display = "block"');
    }
}

function hideLayer(layerName) {
    if (top.viewFrame.navigateFrame.document.layers) {
        eval(layerRef + layerName + '.style.display="none"');
    } else {
        eval('top.viewFrame.navigateFrame.document.getElementById(' + "'" + layerName + "'" + ').style.display = "none"');
    }
}

function initnavigate() {
    if (top.viewFrame.navigateFrame.document.layers) {
        layerRef = "top.viewFrame.navigateFrame.document.layers.";
    }
    if (top.viewFrame.navigateFrame.document.images) {
    }
}

function updateTabs(imgName) {
    with (top.viewFrame.navigateFrame) {
        if (document.images) {
            for (var i = 0; i < imgArray.length; i++) {
                if (imgArray[i][0] == imgName) {
                    document.all(imgArray[i][0]).src = imgArray[i][1];
                } else {
                    document.all(imgArray[i][0]).src = imgArray[i][2];
                }
            }
        }
    }

}


/**-------------------错误提示使用的函数-----------------**/
//聚焦到错误域中
function errorFocus(errId) {
    top.mainFrame.document.all(errId).focus();
}

//填充错误信息到错误提示面板中
function fillError() {
    var tdiv = top.viewFrame.navigateFrame.document.getElementById('error_id');
    //为解决机构管理（aaf）中的js错误，在2006年3月31日被迫在此进行修改
    //原来代码为：tdiv.innerHTML = top.mainFrame.document.all("__errorInfo").innerHTML;
    //wangpu
    tdiv.innerHTML = document.all("__errorInfo").innerHTML;
}

//填充导航列表到导航面板中
function fillNavList() {
    var tdiv = top.viewFrame.navigateFrame.document.getElementById('nav_id');
    tdiv.innerHTML = top.mainFrame.document.all("__nav_id").innerHTML;
}

//填充导航列表，并显示导航列表
function fillNavAndShow() {
    //填充导航栏导航内容
    fillNavList();
    //显示导航栏
    showOne();
    //设置导航栏状态为隐藏状态
    top.headFrame.isShowNav.value = "true";
}

//清空导航栏列表，并隐藏
function clearNavList() {
    var tdiv = top.viewFrame.navigateFrame.document.getElementById('nav_id');
    tdiv.innerHTML = "";
    //设置导航栏状态为隐藏状态
    top.headFrame.isShowNav.value = "false";
    //隐藏导航栏
    hideNavigateView();
}


//从错误提示面板中清空错误信息,并显示导航面板
function clearError() {
    var tdiv = top.viewFrame.navigateFrame.document.getElementById('error_id');
    tdiv.innerHTML = "";
    if (top.headFrame.isShowNav.value == "true") {
        //显示导航面板
        showOne();
    } else {//隐藏导航栏
        hideNavigateView();
    }
}

function fillJsErrorAndShow(errs) {
    var tdiv = top.viewFrame.navigateFrame.document.getElementById('error_id');
    var strHtml = "<TABLE cellSpacing=0 cellPadding=0 width='100%' align=center border=0>";
    for (var i = 0; i < errs.length; i++) {
        strHtml += "<TR>";
        strHtml += "<TD><IMG src='" + rootpath + "/frame/default/images/navigate/error_light.gif'></TD>";
        strHtml += "<TD class='TD_guide_line_test'><A href=\"javascript:errorFocus('" + errs[i][0] + "');\">" + errs[i][1] + "</A></TD>";
        strHtml += "</TR>";
    }
    strHtml += "</TABLE>";
    tdiv.innerHTML = strHtml;
    showTwo();
    window.attachEvent("onunload", clearError);
}

//显示等待页面
function _showWait() {
    var win = top.headFrame;
    if (win == null)return;
    if (win._wait != null)return;
    win._wait = win.showModelessDialog(rootpath + "/page/frame/Loading.jsp", window, "dialogTop:550px;dialogLeft:750px;dialogHeight: 100px; dialogWidth: 200px; center: yes; help: no; scroll: no; status: no;");
    ;
}
//隐藏等待页面
function _hiddenWait() {
    var win = top.headFrame;
    if (win == null)return;
    if (win._wait != null) {
        if (!win._wait.closed)win._wait.close();
        win._wait = null;
    }
}
//先清，后添事件，防止添加重复事件
//清事件
//window.detachEvent("onload",_hiddenWait);
//window.detachEvent("onunload",_showWait);
////添加事件
//window.attachEvent("onload",_hiddenWait);
//window.attachEvent("onunload",_showWait);