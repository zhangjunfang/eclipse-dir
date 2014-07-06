var grid_rootpath;
function includeFile() {
    //根据引用js文件路径取rootpath值
    for (var i = 0; i < document.scripts.length; i++) {
        grid_rootpath = document.scripts[i].src + "";
        var t = grid_rootpath.indexOf("grid.js");
        if (t != -1) {
            grid_rootpath = grid_rootpath.slice(0, t);
            break;
        }
    }
    //加入对sortTable.js的引用
    var __script__ = document.documentElement.children[0].appendChild(document.createElement('script'));
    __script__.type = 'text/javascript';
    __script__.src = grid_rootpath + 'sortTable.js';
    //加入对css的引用
    var __link__ = document.documentElement.children[0].appendChild(document.createElement('link'));
    __link__.type = 'text/css';
    __link__.rel = 'stylesheet';
    __link__.href = grid_rootpath + 'grid.css';
}
//includeFile();

//降序排列图片位置变量
var IMG_DESC = grid_rootpath + 'images/desc.gif';
//升序排列图片位置变量
var IMG_ASC = grid_rootpath + 'images/asc.gif';
//加深的提示背景
var IMG_HIT = grid_rootpath + 'images/titletdline_bg_s.gif';
//grid索引，用于同一个页面创建多个Grid对象
var index = 0 ;

/*
 * oColumnList = new Grid()
 * Default constructor
 */
function Grid() {
    /* public properties */
    //是否能够多选行
    this.multiple = true;
    //排序列，内部用
    this.sortCol = -1;
    //降序排序
    this.sortDescending = 0;
    //错误信息
    this.error = '';
    //已选择的行数组
    this.selectedRows = [];
    //奇偶行是否用不同颜色显示，此开关打开时，添加删除行ie会自动关闭，原因目前不明
    this.colorEvenRows = true;
    //列是否允许调整宽度
    this.resizeColumns = true;
    //表体body列是否随表头head列的宽度实时调整列宽
    this.bodyColResize = true;
    //用户定义的对象变量名的字符串形式
    this.selfName = '';
    //是否排序开关
    this.sortFlag = true;
    //显示右键菜单
    this.showMenu = false;
    //是否能增减行，只控制键盘事件和右键菜单
    this.addSubRow = false;
     //序号的起始数
    this.startNum = 1
    //用户输入数据错误标志，
    this.inputError = false;
    //grid是否可编辑，该标志由程序更加html代码设置，用于对编辑快捷键的控制
    this.editFlag = false;
    //在grid最后一个编辑框失去焦点时，页面焦点聚到grid外的其他元素上
    this.nextFocus = null;
    //设置gird的高度为 maxViewRow行记录，不设置，默认高度按container高度走
    this.maxViewRow = -1
    //对gird的单元格统一加的累计宽度值
    this.widthAddValue = 20;
    //排序类型,数组，存放类型有'String','Number','None','Date','CaseInsensitiveString'
    this.sortTypes =[];
    //数据列的显示位置，页面用户将要排序的列序号(从0开始)作为数组传入，没有传入的列序号，将(通过把列宽置为0)被隐藏
    //如：o.colPos=[0,4,3,2]
    //    o.colPos=[4,2,3,1]
    // 注意：1.在o.bind(...)调用之前对此赋值,不需要排序和隐藏列的功能不要赋值此属性
    //       2.列号一定要在  0 和 列数减一 之间，grid对此不校验，可能会出错。
    this.colPos = [];
    //添加行时，是否复制上一行的数据。ture-复制，false-不复制，默认false
    this.isAddRowWithData=false;
    //新增行时按照哪一行(首行或末行或选择的行的第一行)进行复制  （默认按首行复制）
    // false －首行复制 ； true － 末行复制 ；null - 按选择行复制（如果选择多行，复制选择的第一行，没选择行 则复制首行）
    //此参数在o.bind前后都可以设置。
    this.isAddRowWithLast = false;
    //在设置完只读单元格后，当前的编辑框是否下移到下一个可编辑框上，默认为移动
    this.isMoveFocusAfterSetReadOnly = true;
    //哪些列是多行select  ,如:o.mutiSelectPos=[2,3]
    this.mutiSelectPos = [];

    /* events */
    this.onresize = null;
    this.onsort = null;
    this.onselect = null;
    this.onAddRow = null;
    this.onRemoveRow = null;
    this.onGridBlur = null;      //Grid失去焦点时触发函数, Added by likey, Date: 2006-04-20


    /* private properties */
    //Container容器
    this._eCont = null;
    //Head 容器
    this._eHead = null;
    //left 容器
    this._eLeft = null;
    //body 容器
    this._eBody = null;
    //head 表格
    this._eHeadTable = null;
    //left 表格
    this._eLeftTable = null;
    //body 表格
    this._eBodyTable = null;
    //head 列集合
    this._eHeadCols = null;
    //暂时为1列
    this._eLeftCols = null;
    //body 的列集合
    this._eBodyCols = null;
    //用于调整Left行高
    this._eBodyRows = null;

    //当前处于编辑状态的单元格
    this._eEditTd = null;
    //第一个可编辑td
    this._eFistEditTd = null;
    //内部用的全局变量,用于左右键移动单元格的递归函数调用中
    this.__tempTd = null;
    //上次施动者td
    this._preLinkerTd = null;

    //右键菜单
    this._eMenu = null;

    this._eDataTable = null;
    //保存列的一些设置数据信息的数组
    this._eDataCols = null;

    this._activeHeaders = null;
    this._rows = 0;
    this._cols = 0;

    this._defaultLeftWidth = 40;

}

/*
 * iError = bind(eContainer, eBody ,eMenu)加入右键菜单支持
 * Binds column list to an existing HTML structure. Use create
 * to generate the strucutr automatically.
*/
Grid.prototype.bind = function(eCont, eBody, eMenu) {
    try {
        this._eCont = eCont;
        this._eBody = eBody;
        this._eBodyTable = this._eBody.getElementsByTagName('table')[0];
        this._eBodyRows = this._eBodyTable.tBodies[0].rows;

        this._rows = this._eBodyRows.length;
        this._cols = this._eBodyTable.tHead.rows[0].cells.length;

        //check for bind
        //如果tbody内容为空，动态生成一行。如果tbody内容的列和thead的列不对应，给出提示
        this._check();

        //init for head
        //生成head头，内容从body的thead中提出
        this._initHead();

        //init for data and body
        //初始化data，并对需要编辑功能的body进行初始化，显示
        if (this._eBodyTable.tHead.rows[1] != null) {
            this._initDataAndBody();
            //add by hezhenfeng
            this._initLinker();
        }

        //init for list
        //初始化序号列
        this._initList();

        //init for menu
        //初始化右键显示菜单
        this._initMenu(eMenu);

        //  this._eCont.style.display="block";
        //初始化显示布局
        this._initLayout();

        //调整大小，其他初始化
        this._init();


    } catch(oe) {
        this.error = '无法bind，请查证： ' + oe.message;
        alert(this.error);
        return 1;
    }
    return 0;
};

/**
* check for bind
* 如果tbody内容为空，动态生成一行。如果tbody内容的列和thead的列不对应，给出提示
*/
Grid.prototype._check = function () {
    if (this._rows == 0) {
        var t_tr = document.createElement("tr");
        for (var i = 0; i < this._cols; i++) {
            var t_td = document.createElement("td");
            t_td.innerHTML = "&nbsp;";
            t_tr.appendChild(t_td);
        }
        this._eBodyTable.tBodies[0].appendChild(t_tr);
        this._eBodyCols = this._eBodyTable.tBodies[0].rows[0].cells;
    } else {
        this._eBodyCols = this._eBodyTable.tBodies[0].rows[0].cells;
        if (this._cols != this._eBodyCols.length) {
            alert("初始化的表头列数和表体列数不一致，请查证程序！\n表头："+ this._cols +"列，表体："+ this._eBodyCols.length +"列")
            return;
        }
    }
     if(this.colPos.length>0){
        //如果用户定义了colPos，则对表格列进行排序，并根据colPos在_initLayout方法中隐藏列
        var _rs = this._eBodyTable.rows;
        for(var i=0;i<_rs.length;i++){
            //排序方法：1.将td的引用放到数组_cs中
            //          2.根据colPos数组的列序号，从_cs数组中取出单元格追加到当前行中
            //          3.将不在colPos数组中列（隐藏列），追加到当前行尾，并在_initLayout方法中，将列宽置为0px，从而隐藏。
            var _cs = [];
            for(var j=0;j<this._cols;j++)_cs[j]=_rs[i].cells[j];
            for(var k=0;k<this.colPos.length;k++){
                _rs[i].appendChild(_cs[this.colPos[k]]);
            }
            for(;k<this._cols;k++){
                _rs[i].appendChild(_rs[i].cells[0]);
            }
        }
    }
}

/**
* 初始化head
*/
Grid.prototype._initHead = function () {
    //程序生成head域，其head内容从body表thead中取得
    this._eCont.insertAdjacentHTML('afterBegin', "<div id='head_" + (++index) + "' class='grid-head'><table cellspacing='0' cellpadding='0'><tr></tr></table></div>");
    this._eHead = document.getElementById("head_" + index);
    this._eHeadTable = this._eHead.children[0];
    //将body表中的head第一行赋值给head表中
    for (var i = 0; i < this._cols; i++) {
        var cell = this._eHeadTable.tBodies[0].rows[0].insertCell();
        var srcCell = this._eBodyTable.tHead.rows[0].cells[i];
        cell.innerHTML = '<div nowrap style="width:100%;over-flow:hidden;">' + srcCell.innerHTML + '<img></div>';
        cell.align = (srcCell.align != "")?srcCell.align:"center";
        if(srcCell.hit=="true")cell.style.backgroundImage = 'url('+IMG_HIT+')';
        if(srcCell.sortType!=null)this.sortTypes[i] = srcCell.sortType;
    }
    this._eHeadCols = this._eHeadTable.tBodies[0].rows[0].cells;
}

/**
* 初始化Data和body内容
*/
Grid.prototype._initDataAndBody = function () {
    //生成数据列的一些设置信息
    //生成colsData域，用于保存列的一些设置数据
    this._eCont.insertAdjacentHTML('afterBegin', "<div id='data_" + (index) + "' style='display:none;'><table></table></div>");
    this._eDataTable = document.getElementById("data_" + index).getElementsByTagName('table')[0];
    this._eDataCols = (this._eDataTable.tBodies[0].appendChild(this._eBodyTable.tHead.rows[1]) ).cells;
    //将列数据的设置信息，赋值到data表的行中

    //对_eDataCols进行设置.如日期控件
    for (var i = 0; i < this._cols; i++) {
        var node = this._eDataCols[i].children[0];
        //对该node加入日期的校验函数;
        if (node != null && node.dataType != null && node.dataType.toLowerCase() == 'calendar')
            node.checkFun = "if(!(this.value.match(/^\\s+$/))&&this.value!=''&&!(this.value.match(/^(\\d{4})(-)((0?[1-9])|(1[0-2]))(-)((0?[1-9])|((1|2)[0-9])|(3(0|1)))$/))) {alert('日期格式必须是YYYY-MM-DD');this.value='';" + this.selfName + ".inputError=true;}";
    }
    //end for

    //初始化bodyTable的内容，已作显示用
    for (var i = 0; i < this._rows; i++) {
        for (var j = 0; j < this._cols; j++) {
            var bodyCellNode = this._eBodyRows[i].cells[j];
            if (bodyCellNode.children[0] == null) {
                if (bodyCellNode.innerText == '')bodyCellNode.innerHTML = '&nbsp;';
                continue;
            }
            if (bodyCellNode.children[0].type != 'hidden') continue;
            var key = bodyCellNode.children[0].value;
            var node = this._eDataCols[j].children[0];
            if (node != null) {
                if (node.alignType != null) {//对数据编辑及显示的对齐方式进行设置
                    bodyCellNode.align = node.style.textAlign = node.alignType;
                }
                if (node.tagName == 'SELECT') {//如果是select,取hidden域key值对应的name值来显示
                    //添加多个select ，联动不考虑
                    if(this._eDataCols[j].children[i]!=null&&this._eDataCols[j].children[i].tagName == 'SELECT') node=this._eDataCols[j].children[i];
                    node.value = key;
                    key = (node.selectedIndex != -1 )?node.options[node.selectedIndex].innerText:'';
                }//end if for select
                key = (key != '')?key:'&nbsp;';
                if(bodyCellNode.readonly=="true"){
                    bodyCellNode.innerHTML = '<div nowrap class="grid-edit" ><span>' + key + '</span>' + bodyCellNode.innerHTML + '</div>';
                    continue;
                }
                if (this._eEditTd == null) {//设置第一个可编辑的单元格作为当前编辑单元格
                    this._eFistEditTd=this._eEditTd = bodyCellNode;
                    this.editFlag = true;
                    this._eEditTd.firstType=true;
                }
                bodyCellNode.innerHTML = '<div nowrap class="grid-edit" ><span>' + key + '</span>' + bodyCellNode.innerHTML + '</div>';
                bodyCellNode.children[0].flag=true;
            } else {
                bodyCellNode.innerHTML = '<div nowrap class="grid-edit"><span>' + key + '</span>' + bodyCellNode.innerHTML + '</div>';
            }
        }
        //end for j
    }
    //end for i

}

/*
初始化所有的的关联
*/
Grid.prototype._initLinker = function()
{
    for (var i = 0; i < this._rows; i++) {
        for (var j = 0; j < this._cols; j++) {
            var bodyCellNode = this._eBodyRows[i].cells[j];
            var node = this._eDataCols[j].children[0];
            if (node != null) {
                if (node.tagName == 'SELECT') {
                    if (node.linkItems != null) {
                        var items = node.linkItems.split(",");
                        for (var k = 0; k < items.length; k++) {
                            var colItems;
                            if ((colItems = document.getElementsByName(items[k])).length == 0) {
                                alert("该元素的 linkItems 属性有误,请查证");
                                break;
                            }

                            var needClearTd = colItems[i].parentElement.parentElement;
                            //第i行
                            needClearTd.linker = bodyCellNode;
                        }
                    }//node.linkItems !=null
                } //select
            } //node!=null

        }
    }
}


/**
* 初始化布局
*/
Grid.prototype._initLayout = function () {
    //根据bodytTable的thead第一行的表头确定表格的布局方式
    if (this._eBodyTable.tHead.rows[0].cells[0].width != ""){
        this.widthAddValue = 0;
        this.isSetWidth = true;
    //    this._eBodyTable.style.tableLayout = 'fixed';
    }else{
        this.isSetWidth = false;
    }

    //如果页面中bodyTable中没有colgroup元素，创建bodyTable的colgroup元素
    var eColGroup = document.createElement('colgroup');
    for (var i = 0; i < this._cols; i++) {
        eCol = document.createElement('col');
        if(!this.isSetWidth){
            eCol.style.width = (this._eBodyCols[i].offsetWidth + this.widthAddValue) + 'px';
        }else {
            //果表头设置有值，按表头走
            eCol.style.width = this._eBodyTable.tHead.rows[0].cells[i].width;
        }
        //根据用户定义的colPos对不需要显示的列进行隐藏
        if(this.colPos.length>0 && i>=this.colPos.length)eCol.style.width='0px';
        eColGroup.appendChild(eCol);
    }
    this._eBodyTable.insertBefore(eColGroup);

    this._eBodyTable.style.tableLayout = 'fixed';

    //remove 掉 bodyTable 的thead表头
    this._eBodyTable.removeChild(this._eBodyTable.tHead);
}

/**
* 初始化左边序号列
*/
Grid.prototype._initList = function () {
    //创建左上角的序号显示
    var strHead = "<div id='corn_" + index + "' class='grid-head' style='z-index:2'><table cellspacing='0' cellpadding='0' width='" + this._defaultLeftWidth + "' ><tr><td align='center'>序号</td></tr></table></div>";

    //序号列
    strHead += "<div id='left_" + index + "' class='grid-left'><table cellspacing='0' cellpadding='0' width='" + this._defaultLeftWidth + "'><tbody>";
    if (this._rows == 0) {
        strHead += "<tr><td align='center'>0</td></tr>";
        this._rows = 1;
    } else {
        for (var i = 0; i < this._rows; i++) {    //_ebodyRows 初始化时，第一行为表头
            strHead += "<tr><td align='center'>" + (this.startNum + i) + "</td></tr>";
        }
    }

    strHead += "</tbody></table></div>";
    this._eCont.insertAdjacentHTML("afterBegin", strHead);
    this._eLeft = document.getElementById("left_" + index);
    this._eLeftTable = this._eLeft.children[0];
}

/**
* 初始化右键菜单
*/
Grid.prototype._initMenu = function (eMenu) {
    //右键菜单功能的添加
    if ((eMenu != null) || this.addSubRow) {
        if (eMenu != null) {
            this.showMenu = true;
            this._eMenu = this._eCont.insertAdjacentElement("afterEnd", eMenu);
        } else {
            this._eCont.insertAdjacentHTML("afterEnd", "<div id='menu_" + index + "'></div>");
            this._eMenu = document.getElementById("menu_" + index);
        }
        this._eMenu.className = 'grid-menu';
        this._eMenu.attachEvent('onclick', jumpToTarget);
        this._eMenu.attachEvent('onmouseout', lowLightItem);
        this._eMenu.attachEvent('onmouseover', highLightItem);
        if (this._eMenu.children != null) {
            for (var i = 0; i < this._eMenu.children.length; i++) {
                if (this._eMenu.children[i].getElementsByTagName('hr').length == 0)this._eMenu.children[i].className = 'grid-menuitem';
            }
        }
        var menustr = (this.addSubRow)?"<div class='grid-menuitem' command='" + this.selfName + ".addRow();'>添加行</DIV>"
                + "<div class='grid-menuitem' command='" + this.selfName + ".removeRange(" + this.selfName + ".getSelectedRange());'>删除行</DIV>"
                + "<div class='grid-menuitem' command='" + this.selfName + ".selectRange( 0 ," + this.selfName + ".getRowCount() - 1 );'>全选行</DIV>":"";

        this._eMenu.insertAdjacentHTML("afterBegin", menustr);
    }
}
/*
 * void _init()
 * Initializes column list, called by create and bind
*/
Grid.prototype._init = function() {

    this.calcSize();

    this._assignEventHandlers();

    if (this.colorEvenRows) {
        this._colorEvenRows();
    }
    this._stl = new SortableTable(this._eBodyTable,this.sortTypes);
}

/*
 * void _assignEventHandlers()
 * Assigns event handlers to the grid elements, called by bind.
*/
Grid.prototype._assignEventHandlers = function() {
    var oThis = this;
    //添加size调整事件
    this._eCont.onresize = function () {
        oThis.calcSize();
    }
    this._eCont.onclick = function(e) {
        return oThis._click(e);
    }
    if (this.showMenu) {//进行右键菜单的处理
        this._eMenu.oncontextmenu = function () {
            return false;
        }
        this._eCont.oncontextmenu = function () {
            return oThis._showMenu();
        }
        document.body.attachEvent("onclick", function () {
            oThis._hideMenu();
        });
    }
    if (this.resizeColumns) {
        this._eHead.onmousedown = function(e) {
            oThis._mouseDown(e);
        }
        this._eHead.onmousemove = function(e) {
            oThis._mouseMove(e);
        }
    }
    this._eCont.onmouseup = function(e) {
        oThis._mouseUp(e);
    }
    this._eBody.onmousemove = function(e) {
        oThis._eBody.style.cursor = 'default';
        this._activeHeaders = null;
    }
/*    this._eCont.onselectstart = function(e) {//不让整个控件中的元素能被选中，但编辑框元素可以被选中
        var edit = (e)?e.target:window.event.srcElement;
        if (edit.tagName == 'INPUT' || edit.tagName == 'SELECT')return true;
        return false;
    }*/
    this._eBody.onscroll = function() {//对滚动事件的控制
        oThis._eHead.scrollLeft = oThis._eBody.scrollLeft;
        oThis._eLeft.scrollTop = oThis._eBody.scrollTop;
    };
    this._eCont.onkeydown = function(e) {
        var el = (e)?e.target:window.event.srcElement;
        var key = (e)?e.keyCode:window.event.keyCode;
        //处理键盘事件
        return oThis._handleRowKey(key, event.ctrlKey, event.shiftKey);
    };
};


/* void calcSize()
 * Used to calculate the desired size of the grid and size it accordingly.
 */

Grid.prototype.calcSize = function() {
    if (this._eCont.offsetWidth >= 4) {
        if(this.maxViewRow != -1){
            //如果设置了maxViewRow,grid高度按maxViewRow的方式走
            var t = (this._rows <= this.maxViewRow)?this._rows:this.maxViewRow;
            this._eCont.style.height = (t * 22 + 41)  + 'px';
        }

        var pt = this._eHead.offsetHeight;
        //body paddingTop
        var pl = this._eLeft.offsetWidth;

        /* Size body */
        //计算body容器的高度
        this._eBody.style.height = this._eCont.clientHeight + 'px';
        //计算body容器的宽度
        this._eBody.style.width = this._eCont.clientWidth + 'px';
        this._eBody.style.paddingTop = ( pt ) + 'px';
        this._eBody.style.paddingLeft = (pl ) + 'px';

        //如果bodyTable的长度过短，则拉伸
        // if(this._eBodyTable.clientWidth < this._eBody.clientWidth - pl) this._eBodyTable.style.width = this._eBody.clientWidth - pl + 'px' ;

        /* Size header */
        this._eHead.style.width = (this._eBody.clientWidth  ) + 'px';
        this._eHead.style.paddingLeft = pl + 'px';

        /* Size Left */
        this._eLeft.style.height = (this._eBody.clientHeight ) + 'px';
        this._eLeft.style.paddingTop = pt + 'px';

        /*
        * 对齐left和body行，left向body行对齐
        */
        /*        if (this._eBodyRows) {
            for (var i = 0; i < this._rows; i++) {
                this._eLeftTable.tBodies[0].rows[i].style.height = (this._eBodyRows[i].offsetHeight ) + 'px';
            }
        }*/

        /* Size columns
        *对齐head和body的列，head列向body列对应
        */
        if (this._eBodyCols) {
            for (var i = 0; i < this._cols; i++) {
                this._eHeadCols[i].style.width = (this._eBodyCols[i].offsetWidth ) + 'px';
            }
        }
    }

};


/**
* Method : reloadData(rowIndex,colIndex,asynFlag)
* 参数1：rowIndex（可选）-第几行
* 参数2：colIndex（可选）-第几列
* 参数3：asynFlag（可选）-异步标志 true、false,当reloadData是通过iframe中的调用函数触发的，会产生不同步现象，此时参数为true
* 描述：reload数据，如果页面中用js将hidden值改变，通过调用此函数，来保持数据与显示内容一致
*      该方法根据参数来load哪个单元格，或第几行，或第几列，或全部load
*
*/
Grid.prototype.reloadData = function (rowIndex, colIndex,asynFlag) {
    if (rowIndex != null && colIndex != null) {
        //load单元格
        this._reloadData(rowIndex, colIndex,asynFlag);
    } else if (rowIndex != null && colIndex == null) {
        //load行
        for (var j = 0; j < this._cols; j++) {
            this._reloadData(rowIndex, j,asynFlag);
        }
    } else if (rowIndex == null && colIndex != null) {
        //load列
        for (var i = 0; i < this._rows; i++) {
            this._reloadData(i, colIndex,asynFlag);
        }
    } else {
        //全部load
        for (var i = 0; i < this._rows; i++) {
            for (var j = 0; j < this._cols; j++) {
                this._reloadData(i, j,asynFlag);
            }
        }
    }//end else
}
Grid.prototype._reloadData = function (i, j,asynFlag) {
    var divNode = this._eBodyRows[i].cells[j].children[0];
    if (divNode != null && divNode.children.length >= 2) {
        if (divNode.children[1].type == 'hidden') {
            var key = divNode.children[1].value;
            if (this._eEditTd != null && this._eEditTd==this._eBodyRows[i].cells[j] && this._eEditTd.children[0].flag==false && asynFlag){

                this._eEditTd.edit.value=key;
                this._eEditTd.edit.select();
                return;
            }
            var node = this._eDataCols[j].children[0];
            if (node != null) {
                if (node.tagName == 'SELECT') {//如果是select,取hidden域key值对应的name值来显示
                     //添加多个select ，联动不考虑
                    if(this._eDataCols[j].children[i]!=null&&this._eDataCols[j].children[i].tagName == 'SELECT') node=this._eDataCols[j].children[i];
                    node.value = key;
                    key = (node.selectedIndex != -1 )?node.options[node.selectedIndex].innerText:'';
                }//end if for select
                key = (key != '')?key:'&nbsp;';
            }//end if node
            divNode.children[0].innerHTML = key;
        }
    }
}

/**
* Method : setReadOnly(rowIndex,colIndex)
* 参数1：rowIndex（可选）-第几行
* 参数2：colIndex（可选）-第几列
* 描述：设置只读单元格
*      该方法根据参数来set哪个单元格，或第几行，或第几列，或全部set
*
*/
Grid.prototype.setReadOnly = function (rowIndex, colIndex) {
    this.setOrUnSetReadOnly(rowIndex, colIndex,true);
}
/**
* Method : unSetReadOnly(rowIndex,colIndex)
* 参数1：rowIndex（可选）-第几行
* 参数2：colIndex（可选）-第几列
* 描述：恢复单元格为编辑状态
*      该方法根据参数来set哪个单元格，或第几行，或第几列，或全部set
*
*/
Grid.prototype.unSetReadOnly = function (rowIndex, colIndex) {
    this.setOrUnSetReadOnly(rowIndex, colIndex,false);
}
Grid.prototype.setOrUnSetReadOnly = function (rowIndex, colIndex,flag) {
    if (rowIndex != null && colIndex != null) {
        //set单元格
        this._setReadOnly(rowIndex, colIndex,flag);
    } else if (rowIndex != null && colIndex == null) {
        //set行
        for (var j = 0; j < this._cols; j++) {
            this._setReadOnly(rowIndex, j,flag);
        }
    } else if (rowIndex == null && colIndex != null) {
        //set列
        for (var i = 0; i < this._rows; i++) {
            this._setReadOnly(i, colIndex,flag);
        }
    } else {
        //全部set
        for (var i = 0; i < this._rows; i++) {
            for (var j = 0; j < this._cols; j++) {
                this._setReadOnly(i, j,flag);
            }
        }
    }//end else
}
Grid.prototype._setReadOnly = function (i,j,flag) {
    var curTd = this._eBodyRows[i].cells[j];
    var divNode = curTd.children[0];
    if(divNode !=null ){
        if(flag){
            if(divNode.flag != null){
                if(curTd== this._eEditTd&& divNode.flag!=true){this.focusNextEditDiv();}
                divNode.removeAttribute('flag');divNode.unFlag='';}
        }else{
            if(divNode.unFlag != null){divNode.removeAttribute('unFlag');divNode.flag=true}
        }
    }
}

/**
* Method : setFocus(rowIndex,colIndex)
* 参数1：tdObj_or_RowIndex （必选）- 要聚焦的单元格对象 或 第几行
* 参数2：colIndex（可选）-第几列 （当第一个参数为数字类型的话，此参数必选）
* 描述：焦点聚焦到可编辑的单元格上
*
*/
Grid.prototype.setFocus = function ( tdObj_or_RowIndex, colIndex) {
    var td = null;
    if(typeof(tdObj_or_RowIndex)=='object'){
        td = tdObj_or_RowIndex
    }else if(typeof(tdObj_or_RowIndex)=='number' && typeof(colIndex)=='number') {
       try{ td = this._eBodyRows[tdObj_or_RowIndex].cells[colIndex];}catch(e){};
    }
    if(td==null){alert('调用grid的setFocus函数参数错误,检测程序');return}
    var divNode = td.children[0];
    if(divNode !=null && divNode.flag!=null){
        this.setData();//最后一个单元格复位
        this._eEditTd = td;
        this.editData();
       // this._eEditTd.edit.focus()
    }
}
/*
* iErrorCode = selectRow(iRowIndex, bMultiple)
* Selects the row identified by the sequence number supplied,
*
* If bMultiple is specified and multi-select is allowed the
* the previously selected row will not be deselected. If the
* specified row is already selected it will be deselected.
*/
Grid.prototype.selectRow = function(iRowIndex, bMultiple) {
    if ((iRowIndex < 0) || (iRowIndex > this._rows - 1)) {
        this.error = 'Unable to select row, index out of range.';
        return 1;
    }
    var eRows = this._eBodyTable.tBodies[0].rows;
    var bSelect = true;
    /* Normal click */
    if ((!bMultiple) || (!this.multiple)) {
        /* Deselect previously selected rows */
        while (this.selectedRows.length) {
            eRows[this.selectedRows[0]].className = (this.selectedRows[0] & 1)?'odd':'even';
            this.selectedRows.splice(0, 1);
        }
    }
    else {
        /* Control + Click */
        for (var i = 0; i < this.selectedRows.length; i++) {
            if (this.selectedRows[i] == iRowIndex) {
                /* Deselect clicked row */
                eRows[this.selectedRows[i]].className = (i & 1)?'odd':'even';
                this.selectedRows.splice(i, 1);
                bSelect = false;
                break;
            }
        }
    }

    if (bSelect) {
        /* Select clicked row */
        this.selectedRows.push(iRowIndex);
        eRows[iRowIndex].className = 'selected';
    }

    /*
     var a = (eRows[iRowIndex].offsetTop + this._eHead.offsetHeight) + eRows[iRowIndex].offsetHeight + 1;
     var b = (this._eBody.clientHeight + this._eBody.scrollTop);
     if (a > b) {
         this._eBody.scrollTop = (a - this._eBody.clientHeight);
     }
     var c = eRows[iRowIndex].offsetTop;
     var d = this._eBody.scrollTop;
     if (c < d) {
         this._eBody.scrollTop = c;
     }
     */


    //	this._eEditTd = eRows(this.selectedRows[this.selectedRows.length - 1]).cells[this._eEditTd.cellIndex];

    /* Call onselect if defined */
    if (this.onselect) {
        this.onselect(this.selectedRows);
    }

    return 0;
};

/*
 * iErrorCode = selectRange(iRowIndex[])
 * iErrorCode = selectRange(iFromRowIndex, iToRowIndex)
 * Selects all rows between iFromRowIndex and iToRowIndex.
 */
Grid.prototype.selectRange = function(a, b) {
    var aRowIndex;
    if (typeof a == 'number') {
        aRowIndex = new Array();
        for (var i = a; i <= b; i++) {
            aRowIndex.push(i);
        }
        for (var i = b; i <= a; i++) {
            aRowIndex.push(i);
        }
    }
    else {
        aRowIndex = a;
    }

    for (var i = 0; i < aRowIndex.length; i++) {
        if ((aRowIndex[i] < 0) || (aRowIndex[i] > this._rows - 1)) {
            this.error = 'Unable to select rows, index out of range.';
            return 1;
        }
    }

    /* Deselect previously selected rows */
    var eRows = this._eBodyTable.tBodies[0].rows;
    while (this.selectedRows.length) {
        eRows[this.selectedRows[0]].className = (this.selectedRows[0] & 1)?'odd':'even';
        this.selectedRows.splice(0, 1);
    }

    /* Select all rows indicated by range */
    var bMatch;
    for (var i = 0; i < aRowIndex.length; i++) {
        bMatch = false;
        for (var j = 0; j < this.selectedRows.length; j++) {
            if (this.selectedRows[j] == aRowIndex[i]) {
                bMatch = true;
                break;
            }
        }
        if (!bMatch) {
            /* Select row */
            this.selectedRows.push(aRowIndex[i]);
            eRows[aRowIndex[i]].className = 'selected';
        }
    }

    /* Call onselect if defined */
    if (this.onselect) {
        this.onselect(this.selectedRows);
    }

    return 0;
};

/*
 * void resize(iWidth, iHeight)
 * Resize the grid to the given dimensions, the outer (border) size is given, not the inner (content) size.
 */
Grid.prototype.resize = function(w, h) {
    this._eCont.style.width = w + 'px';
    this._eCont.style.height = h + 'px';
    this.calcSize();

    /* Call onresize if defined */
    if (this.onresize) {
        this.onresize();
    }
};


/*
 * iErrorCode = addRow(aRowData)
 * Appends supplied row to the column list.
 */
Grid.prototype.addRow = function() {
    this._addRow();
    var result = 0;
    if(this.onAddRow){
       result = this.onAddRow(this._eBodyTable.tBodies[0].rows[this._rows-1]);
    }
    //选择末行
    this.selectRow(this._rows-1);
    if(result == -1)return -1;
    //   this.calcSize();
    return 0;
};

/*
 * iErrorCode = addRows(aData)
 * Appends supplied rows to the column list.
 */
Grid.prototype.addRows = function() {
    var result = 0;
    for (var i = 0; i < aData.length; i++) {
        this._addRow();
        if(this.onAddRow){
            this.onAddRow(this._eBodyTable.tBodies[0].rows[this._rows-1]);
        }
    }
    if(result == -1)return -1;
    //   this.calcSize();
    return 0;
};

/*
 * void _colorEvenRows()
 * Changes the color of even rows (usually to light yellow) to make it easier to read.
 * Also updates the id column to a sequence counter rather than the row ids.
 */
Grid.prototype._colorEvenRows = function() {
    if (this._eBodyTable.tBodies.length) {
        var nodes = this._eBodyTable.tBodies[0].rows;
        for (var i = 0; i < nodes.length; i++) {
            if (nodes[i].className != 'selected') {
                nodes[i].className = (i & 1)?'odd':'even';
            }
        }
    }
};

/*
 * iErrorCode = _addRow(aRowData)
 */
Grid.prototype._addRow = function() {
    this.setData();//将最后一个处于编辑的单元格复位
    var t_i=0;
    if (this.isAddRowWithLast){
        t_i = this._rows-1;
    }else if(this.isAddRowWithLast==null){
        if(this.selectedRows[0] != null) t_i= this.selectedRows[0];
    }
    var addRow = this._eBodyTable.tBodies[0].appendChild(this._eBodyTable.tBodies[0].rows[t_i].cloneNode(true));
    //	var addRow = this._eBodyTable.tBodies[0].appendChild( this._eDataBlankRow.cloneNode(true) );
    addRow.className = '';
    if(!this.isAddRowWithData){
        //清空新增行所有隐藏域
        var row = addRow;
        for (var k = 0; k < row.all.length; k++) {
            if (row.all[k].tagName == 'INPUT' && row.all[k].type == 'hidden') {
                row.all[k].value = '';
            }
        }
        //清空新增行所有标签显示
        for (var i = 0; i < this._cols; i++) {
            var t = addRow.cells[i].children[0];
            if (t != null && t.tagName == 'DIV') {
                t.children[0].innerHTML = '&nbsp;';
            //    t.children[1].value = '';
            }
        }
    }
    this._rows = this._eBodyTable.tBodies[0].rows.length;
    var leftAddNode = this._eLeftTable.tBodies[0].appendChild(this._eLeftTable.tBodies[0].rows[0].cloneNode(true));
    leftAddNode.cells[0].innerText = "" + this._rows;
    if (this.colorEvenRows) {
        this._colorEvenRows();
    }
    return 0;
};

/*
 * iErrorCode = removeRow(iRowIndex)
 * Appends supplied row to the grid.
 */
Grid.prototype.removeRow = function(iRowIndex) {
    /* Remove row */
    var rc = this._removeRow(iRowIndex);
    if (rc) {
        return rc;
    }

    /* Update row counter and select previous row, if any */
    this._rows--;
    this.selectRow((iRowIndex > 1)?iRowIndex - 1:0);

    /* Recolor rows, if needed */
    if (this.colorEvenRows) {
        this._colorEvenRows();
    }
    //   this.calcSize();

    /* Call onselect if defined */
    if (this.onselect) {
        this.onselect(this.selectedRows);
    }
    /* Call onRemoveRow if defined */
    if(this.onRemoveRow){
        //changed by Likey,2006-04-27
        this.onRemoveRow(iRowIndex);
    }
    return 0;
};

/*
 * iErrorCode = removeRange(iRowIndex[],null,showHit)
 * iErrorCode = removeRange(iFirstRowIndex, iLastRowIndex,showHit)
 * Appends supplied row to the grid.
 */
Grid.prototype.removeRange = function(a, b ,showHit) {
    var _index;
    if (this._eEditTd != null) _index = this._eEditTd.cellIndex;
    var aRowIndex = new Array();
    if (typeof a == 'number') {
        for (var i = a; i <= b; i++) {
            aRowIndex.push(i);
        }
    }
    else {
        for (var i = 0; i < a.length; i++) {
            aRowIndex.push(a[i]);
        }
        aRowIndex.sort(compareNumericDesc);
    }
    //删除时弹出确认窗口
    if (aRowIndex.length == 0)return;
    if(showHit==null){
         if(!window.confirm('确定要删除选定的' + aRowIndex.length + '行记录吗?'))return;
    }

    for (var i = 0; i < aRowIndex.length; i++) {
        /* Remove row */
        var rc = this._removeRow(aRowIndex[i]);
        if (rc) {
            return rc;
        }
        /* Update row counter and select previous row, if any */
        this._rows--;
    }
    //删除行，如果没有选定的行，则选定删除前的上一行
    if (this.selectedRows.length == 0) this.selectRow(( (aRowIndex[aRowIndex.length - 1] == 0)?1:aRowIndex[aRowIndex.length - 1] ) - 1);

    //如果_eBodyCols被删除，对bodyCols重新赋值
    if (this._eBodyCols.length == 0) this._eBodyCols = this._eBodyTable.tBodies[0].rows[0].cells;


    //删除行后，对编辑的单元格进行处理
    if (this._eEditTd !=null && this._eEditTd.parentElement.rowIndex == -1) {
        this._eEditTd = this._eBodyTable.tBodies[0].rows[0].cells[_index];
    }

    /* Recolor rows, if needed */
    if (this.colorEvenRows) {
        this._colorEvenRows();
    }
    //  this.calcSize();

    /* Call onselect if defined */
    if (this.onselect) {
        this.onselect(this.selectedRows);
    }
    /* Call onRemoveRow if defined */
    if(this.onRemoveRow){
        this.onRemoveRow();
    }
    return 0;
};

/*
 * iErrorCode = _removeRow(iRowIndex)
 */
Grid.prototype._removeRow = function(iRowIndex) {
    if (this._rows == 1) {
       // alert("最后一行不能删除");                                                    +
        var row = this._eBodyTable.tBodies[0].rows[0];
          //清空删除行所有隐藏域
        for (var k = 0; k < row.all.length; k++) {
            if (row.all[k].tagName == 'INPUT' && row.all[k].type == 'hidden') {
                row.all[k].value = '';
            }
        }
        //清空删除行所有标签显示
        for (var i = 0; i < this._cols; i++) {
            var t = row.cells[i].children[0];
            if (t != null && t.tagName == 'DIV') {
                t.children[0].innerHTML = '&nbsp;';
            }
        }
        this._rows++;
        return 0;
    }
    if ((iRowIndex < 0) || (iRowIndex > this._rows - 1)) {
        this.error = 'Unable to remove row, row index out of range.';
        return 1;
    }

    /* Remove from selected */
    for (var i = this.selectedRows.length - 1; i >= 0; i--) {
        if (this.selectedRows[i] == iRowIndex) {
            this.selectedRows.splice(i, 1);
        }
    }

    this._eBodyTable.tBodies[0].removeChild(this._eBodyTable.tBodies[0].rows[iRowIndex]);
    //	this._eLeftTable.tBodies[0].removeChild(this._eLeftTable.tBodies[0].rows[iRowIndex]); //移走所在行的Left行
    this._eLeftTable.tBodies[0].removeChild(this._eLeftTable.tBodies[0].rows[this._eLeftTable.tBodies[0].rows.length - 1]);
    //移走Left的最后一行
    //删除多行select，该行对应的select
    for(var i=0;i<this.mutiSelectPos.length;i++){
       this.updateSelect(null,this.mutiSelectPos[i],iRowIndex);
    }
    return 0;
};

/*
 * iRowIndex getSelectedRow()
 * Returns the index of the selected row or -1 if no row is selected.
 */
Grid.prototype.getSelectedRow = function() {
    return (this.selectedRows.length)?this.selectedRows[this.selectedRows.length - 1]:-1;
};

/*
 * iRowIndex[] getSelectedRange()
 * Returns an array with the row index of all selecteds row or null if no row is selected.
 */
Grid.prototype.getSelectedRange = function() {
    return (this.selectedRows.length)?this.selectedRows:-1;
};

/*
 * iRows getRowCount()
 * Returns the nummer of rows.
 */
Grid.prototype.getRowCount = function() {
    return this._rows;
};

/*
 * iRows getColumnCount()
 * Returns the nummer of columns.
 */
Grid.prototype.getColumnCount = function() {
    return this._cols;
};

/*
 * sValue = getCellValue(iRowIndex, iColumnIndex)
 * Returns the content of the specified cell.
 */
Grid.prototype.getCellValue = function(iRowIndex, iColIndex) {
    if ((iRowIndex < 0) || (iRowIndex > this._rows - 1)) {
        this.error = 'Unable to get cell value , row index out of range.';
        return null;
    }
    if ((iColIndex < 0) || (iColIndex > this._cols - 1)) {
        this.error = 'Unable to get cell value , row index out of range.';
        return null;
    }

    return this._eBodyTable.tBodies[0].rows[iRowIndex].cells[iColIndex].innerHTML;
};


/*
 * iError = setCellValue(iRowIndex, iColumnIndex, sValue)
 * Sets the content of the specified cell.
 */
Grid.prototype.setCellValue = function(iRowIndex, iColIndex, sValue) {
    if ((iRowIndex < 0) || (iRowIndex > this._rows - 1)) {
        this.error = 'Unable to get cell value , row index out of range.';
        return 1;
    }
    if ((iColIndex < 0) || (iColIndex > this._cols - 1)) {
        this.error = 'Unable to get cell value , row index out of range.';
        return 2;
    }

    this._eBodyTable.tBodies[0].rows[iRowIndex].cells[iColIndex].innerHTML = sValue;
    this.calcSize();
    return 0;
};

/*
 * void setSortTypes(sSortType[]) {
 * Sets the column data types, used for sorting.
 * Valid options: Number, Date, String, CaseInsensitiveString
 */
Grid.prototype.setSortTypes = function(aSortTypes) {
    this._stl.setSortTypes(aSortTypes);
}

/*
 * void sort(iColumnIndex, [bDescending])
 * Sorts the grid by the specified column (zero based index) and, optionally, in the specified direction.
 */
Grid.prototype.sort = function(iCol, bDesc) {
    /* Hide arrow from header for column currently sorted by */
    if (this.sortCol != -1) {
        var eImg = this._eHeadTable.tBodies[0].rows[0].cells[this.sortCol].getElementsByTagName('img')[0];
        eImg.style.display = 'none';
    }

    /* Determine sort direction */
    if (bDesc == null) {
        bDesc = false;
        if ((!this.sortDescending) && (iCol == this.sortCol)) {
            bDesc = true;
        }
    }

    /* Indicate sorting using arrow in header */
    var eImg = this._eHeadTable.tBodies[0].rows[0].cells[iCol].getElementsByTagName('img')[0];
    eImg.src = (bDesc)?IMG_DESC:IMG_ASC;
    eImg.style.display = 'inline';

    /* Perform sort operation */
    this._stl.sort(iCol, bDesc);
    this.sortCol = iCol;
    this.sortDescending = bDesc;

    /* Update row coloring */
    if (this.colorEvenRows) {
        this._colorEvenRows();
    }

    /* Update selection */
    var nodes = this._eBodyTable.tBodies[0].rows;
    var len = nodes.length;
    var a = new Array();
    for (var i = 0; i < len; i++) {
        if (nodes[i].className == 'selected') {
            a.push(i);
        }
    }
    this.selectRange(a);

    /*
      * As the header cell may have grown to accommodate the sorting indicator
      * we set the width of the body columns
      */
    this._sizeBodyAccordingToHeader();

    /* Call onsort if defined */
    if (this.onsort) {
        this.onsort(this.sortCol, this.sortDescending);
    }

};

/*
 * void _handleRowKey(iKeyCode)
 * Key handler for events on row level.
 */
Grid.prototype._handleRowKey = function(iKeyCode, bCtrl, bShift) {
    var iActiveRow = -1;
    if (this.selectedRows.length != 0) {
        iActiveRow = this.selectedRows[this.selectedRows.length - 1];
    }
    if ((!bCtrl) && (!bShift)) {
        if (iKeyCode == 13) {                       //回车下移编辑框
            if(!this.focusNextEditDiv()){
                this.restoreCell();
                if(this.nextFocus != null){
                    var item = document.getElementById(this.nextFocus);
                    if(item==null) item = document.getElementsByName(this.nextFocus)[0];
                    if(item!=null){
                        if(item.tagName=='INPUT')item.select()
                          else item.focus();
                    }
                }
                if(this.onGridBlur != null){
                    this.onGridBlur();
                }
                return false;
            }
        }
        else if (iKeyCode == 33) {                   // Page Up
            if (iActiveRow > 10) {
                this.selectRow(iActiveRow - 10);
            }
            else {
                this.selectRow(0);
            }
        }
        else if (iKeyCode == 34) {              // Page Down
            if (iActiveRow < this._rows - 10) {
                this.selectRow(iActiveRow + 10);
            }
            else {
                this.selectRow(this._rows - 1);
            }
        }
        else if (iKeyCode == 36) {                     // Home
            this.selectRow(0);
        }
        else if (iKeyCode == 35) {                     //End
            this.selectRow(this._rows - 1);
        }
    } else if (bCtrl && bShift) {
        if (iKeyCode == 38) {                            // Ctrl +  Up ,mutiple select
            if (iActiveRow > 0) {
                this.selectRow(iActiveRow - 1, true);
            }
            else {
                this.selectRow(0);
            }
        }
        else if (iKeyCode == 40) {                       // Ctrl + Down
            if (iActiveRow < this._rows - 1) {
                this.selectRow(iActiveRow + 1, true);
            }
        }
    } else if (bCtrl) {
        if (iKeyCode == 39) {          //       Ctril + right,右移编辑框
            this.focusNextEditDiv();
        }
        else if (iKeyCode == 37) {     //       Ctril + left,左移编辑框
            this.focusPreEditDiv();
        }
        else if (iKeyCode == 38) {     //       Ctril + up,上移编辑框
            this.focusUpEditDiv();
        }
        else if (iKeyCode == 40) {     //       Ctril + down,下移编辑框
            this.focusDownEditDiv();
        }else {
            if (this.addSubRow) {
                if (iKeyCode == 45) {         // Ctrl + Insert
                    this.addRow();
                }
                else if (iKeyCode == 46) {   // Ctrl + Delete
                    this.removeRange(this.getSelectedRange());
                }
            }
        }
    } else if (bShift) {
        if (iKeyCode == 38) {                                                      // Up
            if (iActiveRow > 0) {
                this.selectRow(iActiveRow - 1);
            }
            else {
                this.selectRow(0);
            }
        }
        else if (iKeyCode == 40) {                                                 // Down
            if (iActiveRow < this._rows - 1) {
                this.selectRow(iActiveRow + 1);
            }
        }
    }
    return true;
};

/*
 * Event Handlers
 */

Grid.prototype._mouseMove = function(e) {
    var el = (e)?e.target:window.event.srcElement;
    var x = (e)?e.pageX:window.event.x + this._eBody.scrollLeft;

    if ((this._activeHeaders) && (this._activeHeaders[0])) {
        /*
           * User is resizing a column, determine and set new size
           * based on the original size and the difference between
           * the current mouse position and the one that was recorded
           * once the resize operation was started.
           * _activeHeaders: 0: 1:需要调整的列td; 2:需要调整的列td宽度; 3:上次鼠标移动的X位置; 4:未调整前的表eHeadTable宽度offsetWidth;
           */
        var w = this._activeHeaders[2] + x - this._activeHeaders[3];
        //需要调整的td列的宽度＝以前的列宽 + (当前鼠标位置和上次的偏移差)
        var tw = ((w - this._activeHeaders[2]) + this._activeHeaders[4]) + 1;
        //需要调整的表宽度 = 鼠标移动量 + 以前的表宽度 + 调整量
        //	document.title = ((w - this._activeHeaders[2]) + this._activeHeaders[4])+1 + ' ' + this._eHeadTable.offsetWidth;
        if (w > 5) {
            this._eHeadTable.style.width = tw + 'px';
            this._activeHeaders[1].style.width = w + 'px';
            if (this.bodyColResize) {//实时调整bodyTable的列宽
                this._eBodyTable.style.width = tw + 'px';
                this._eBodyTable.getElementsByTagName('colgroup')[0].getElementsByTagName('col')[this._activeHeaders[1].cellIndex].style.width = w + 'px';
            }
        }
    } else if ((el.tagName == 'TD') && (el.parentNode.parentNode.parentNode.parentNode.className == 'grid-head')) {
        /*
           * The cursor is on top of a header cell, check if it's near the edge,
           * and in that case set the mouse cursor to 'e-resize'.
           */
        this._checkHeaderResize(el, x);
    } else {
        this._activeHeaders = null;
        this._eHeadTable.style.cursor = 'default';
    }
    /*    if (this._eLeft.clientHeight != this._eBody.clientHeight) {
        this._eLeft.style.height = (this._eBody.clientHeight) + 'px';
        this._eLeft.scrollTop = this._eBody.scrollTop;
    }*/

};


Grid.prototype._mouseDown = function(e) {
    var el = (e)?e.target:window.event.srcElement;
    var x = (e)?e.pageX:window.event.x + this._eBody.scrollLeft;

    this._checkHeaderResize(el, x);
    if ((this._activeHeaders) && (el.tagName == 'TD') && (el.parentNode.parentNode.parentNode.parentNode.className == 'grid-head')) {
        /*
           * Cursor is near the edge of a header cell and the
           * left mouse button is down, start resize operation.
           */
        this._activeHeaders[0] = true;
        if (this.bodyColResize) {
            this._sizeBodyAccordingToHeader();
        }
    }
};

Grid.prototype._mouseUp = function(e) {
    var el = (e)?e.target:window.event.srcElement;
    var x = (e)?e.pageX:window.event.x + this._eBody.scrollLeft;

    if (this._activeHeaders) {
        if (this._activeHeaders[0]) {
            this._sizeBodyAccordingToHeader();
            //拖拉列之后，鼠标抬起，重新调整body和head的列，使其对应
            this._checkHeaderResize(el, x);
        }
        this._activeHeaders = null;
    }
    else if ((el.parentElement.tagName == 'TD') && (el.parentNode.parentNode.parentNode.parentNode.parentNode.className == 'grid-head')) {
        if (this.sortFlag){
            //由于grid经过排序，grid中radio，checkbox按钮选中状态会丢失
            //此处采用取出状态，排序，再设置状态的方式来恢复

            //取选中状态的radio或checkbox
            var cs = getCheckedsFromRows(this._eBodyRows);
            //sort
            this.sort(el.parentElement.cellIndex);
            //设置状态
            for(var i=0;i<cs.length;i++){
                cs[i].checked=true;
            }
        }
    }
};

Grid.prototype._click = function(e) {
    var el = (e)?e.target:window.event.srcElement;
    if (el.tagName == 'IMG') {
        el = el.parentNode;
    }
    if (el.tagName == 'DIV') {
        el = el.parentNode;
    }
    if (el.tagName == 'SPAN') {
        el = el.parentNode.parentNode;
    }
    if ((el.tagName == 'TD') && (el.parentNode.parentNode.parentNode.parentNode.className == 'grid-body')) {
        if (((e)?e.shiftKey:window.event.shiftKey) && (this.selectedRows.length) && (this.multiple)) {
            this.selectRange(this.selectedRows[this.selectedRows.length - 1], el.parentNode.rowIndex);
        }
        else {
            this.selectRow(el.parentNode.rowIndex, (e)?e.ctrlKey:window.event.ctrlKey);
        }
        //添加编辑函数
        if (el.children[0] != null && el.children[0].flag != null) {
            if(this._eEditTd.firstType==true){  //如果是第一次点击的话
                this._eEditTd.removeAttribute('firstType');
                if (this._eEditTd != el){ this._eEditTd = el; this.editData();}
                else if (this._eEditTd.children[0].flag==true)this.editData();
            }  else
            if (this._eEditTd != el) {
                if (this.setData()==false) return;
                this._eEditTd = el;
                this.editData();
            } else if (this._eEditTd.children[0].flag==true)this.editData();
        }else{
          this.setData();
        }
    } else {
        if (el.tagName == 'SELECT' || el.tagName == 'INPUT')return;
        this.setData();
    }
    return true;
};


/*
 * Event handler helpers
 */

Grid.prototype._checkHeaderResize = function(el, x) {
    /*
      * Checks if the mouse cursor is near the edge of a header
      * cell, in that case the cursor is set to 'e-resize' and
      * the _activeHeaders collection is created containing a
      * references to the active header cell, the current mouse
      * position and the cells original width.
      */
    if ((el.tagName != 'TD') || (el.parentNode.parentNode.parentNode.parentNode.className != 'grid-head')) {
        return;
    }
    if (el.tagName == 'IMG') {
        el = el.parentNode;
    }
    var prev = el.previousSibling;
    var next = el.nextSibling;
    var left = getLeftPos(el);
    var right = left + el.offsetWidth;
    var l = (x - 5) - left;
    var r = right - x;
    if ((l < 5) && (prev)) {
        this._eHeadTable.style.cursor = 'e-resize';
        this._activeHeaders = [false, prev, prev.offsetWidth - 5, x, this._eHeadTable.offsetWidth];
    }
    else if (r < 5) {
        this._eHeadTable.style.cursor = 'e-resize';
        this._activeHeaders = [false, el, el.offsetWidth - 5, x, this._eHeadTable.offsetWidth];
    }
    else if (this._activeHeaders) {
        this._activeHeaders = null;
        this._eHeadTable.style.cursor = 'default';
    }

}

Grid.prototype._sizeBodyAccordingToHeader = function() {
    /*
      * The overflow porperty on table columns is only effective if the
      * table type is set to fixed thus this function changes the table
      * type to fixed and sets the width of each body column to size of
      * the corresponding header column.
      */
    this._eBodyTable.style.width = this._eHeadTable.offsetWidth + 'px';
    this._eBodyTable.style.tableLayout = 'fixed';
    var aCols = this._eBodyTable.getElementsByTagName('colgroup')[0].getElementsByTagName('col');
    for (var i = 0; i < this._cols; i++) {
        aCols[i].style.width = (this._eHeadCols[i].offsetWidth ) + 'px';
    }
}


//=====================编辑功能函数=================================//
//2005-06-21 为了解决select的联动不同步问题
//改变显示回写方式,采用首次编辑插入,回写隐藏,再次编辑时,改写编辑框的显示状态来重新显示
//上述方法解决不了联动的问题
//2005-06-22 仍采用以前方法(插入编辑框编辑,编辑完删除编辑框)解决联动问题
//方法:施动者采用linkItems属性来获取受动者信息,并设置受动者的施动者linker属性
//     受动者获取焦点时判断上次施动者是否其自身的施动者,是则正常编辑,不是则重新跳转到其自身的施动者上以联动,再回调到自身上编辑

//显示编辑框，供编辑数据
Grid.prototype.editData = function () {
    var dataCol,edit;
    divNode = this._eEditTd.children[0];
    //如果该单元格可编辑,则进行编辑
    if (divNode.flag) {
        divNode.flag = false;
        //联动: 如果该编辑框的施动者存在,并且上次联动的施动者不是次编辑框的施动者,则进行以下处理
        if ((this._preLinkerTd == null && this._eEditTd.linker != null) || (this._eEditTd.linker != null && this._preLinkerTd.parentElement.rowIndex != this._eEditTd.linker.parentElement.rowIndex)) {
            var originalTd = this._eEditTd;
            this._eEditTd = this._eEditTd.linker;
            dataCol = this._eDataCols[this._eEditTd.cellIndex].children;
            edit = dataCol[0];
            //此edit是源select，这里需要在id上加上'_v'为连动做准备，连动后，需要去处源select的id上的"_v"
            (edit.id != "") ? edit.id = edit.id + '_v':'';
            edit.value = this._eEditTd.children[0].children[1].value;
             // 触发onblur事件
            if(edit.alt!=null && edit.alt != ""){
                eval('function __fireOnLost__(it) { ' + edit.alt.replace(/this/ig, 'it') + '}');
                 __fireOnLost__(edit);
             }else{
               edit.fireEvent('onblur')
            }
            this._preLinkerTd = this._eEditTd;
            this._eEditTd = originalTd;
            if(edit.id.indexOf('_v'))edit.id = edit.id.substring(0,edit.id.length-2);
        }

        divNode.children[0].innerHTML = '';
        dataCol = this._eDataCols[divNode.parentNode.cellIndex].children;
         //添加多个select ，联动不考虑
        var t_data=this._eDataCols[divNode.parentNode.cellIndex].children[divNode.parentNode.parentNode.rowIndex];
        var t_data2=dataCol[0];
        if(t_data!=null&&t_data.tagName == 'SELECT') t_data2=t_data;
        this._eEditTd.edit = edit = divNode.appendChild(t_data2.cloneNode(true));
        /**以隐藏域的形式设置 2005-06-21 ,
          if (this._eEditTd.edit == null) {
              this._eEditTd.edit = edit = divNode.appendChild(dataCol[0].cloneNode(true));
          } else {
              edit = this._eEditTd.edit;edit.style.display='inline';
          }/* */

        /** 追加其他元素 *
          for ( var i = 1; i < dataCol.length; i++) {
              divNode.appendChild(dataCol[i].cloneNode(true));
          }/* */

        edit.value = divNode.children[1].value;
        (edit.id != "") ? edit.id = edit.id + '_v':'';
        if (edit.tagName == 'INPUT') {
            edit.select();
            if (edit.dataType != null && edit.dataType.toLowerCase() == 'calendar') {
                edit.onclick = function () {
                    showcalendar(this);
                };
                edit.onkeydown = function () {
                    if (String.fromCharCode(event.keyCode) == 'D') {
                        if (window.calendar == null || window.calendar.hidden) showcalendar(this);
                        edit.value = window.calendar.date.print(window.calendar.params.ifFormat);
                    }
                }
            }
        } else if (edit.tagName == 'SELECT') {
            edit.focus();
            /**当编辑框为select时，设置焦点时焦点会自动丢失（原因搞不清楚）。这里加入下述代码来控制*/
            edit.__blurType = true;
            edit.ondeactivate = function () {
                try {
                    if (event.toElement.tagName == 'BODY' && this.__blurType) {
                        this.__blurType = false;
                        edit.focus();
                    }
                } catch(e) {
                }
            };
            /* */
        }
        edit.noKeyDown="true";
    }
}
//获取编辑框中的数据
Grid.prototype.setData = function () {
    if(this._eEditTd == null || this._eEditTd.children[0].flag==true|| this._eEditTd.children[0].flag==null ||this._eEditTd.edit==null){return null;}
    var divNode = this._eEditTd.children[0];
    var edit = this._eEditTd.edit;
    var t_value,changeFlag = false;
    //用于判断当前编辑内容值是否改变

    if (edit.instantCheck != null && edit.instantCheck == 'true' && edit.emptyMsg != null) {//对数据是否为空的校验
        if (edit.emptyMsg == '' || edit.emptyMsg.match(/^\s+$/)) edit.emptyMsg = '要输入或选择的内容不能为空';
        if (edit.value == '' || edit.value.match(/^\s+$/)) {
            alert(edit.emptyMsg);
            if (edit.tagName == 'INPUT')edit.select(); else  edit.focus();
            return false;
        }
    }
    if (edit.instantCheck != null && edit.instantCheck == 'true' && edit.checkFun != null) {//执行自定义的校验函数，或js代码
        eval('function __checkFun__(it) { ' + edit.checkFun.replace(/this/ig, 'it') + '}');
        __checkFun__(edit);
        if (this.inputError) {
            this.inputError = false;
            if (edit.tagName == 'INPUT')edit.select(); else  edit.focus();
            return false;
        }
    }

    //判断编辑的值是否改变,改变的话,设置span的显示,和hidden的值
    if (edit.tagName == 'INPUT') {
        divNode.children[0].innerHTML = (edit.value != '')?edit.value:'&nbsp;';
    } else if (edit.tagName == 'SELECT') {
        divNode.children[0].innerHTML = (edit.selectedIndex != -1)?edit.options[edit.selectedIndex].innerText:'&nbsp;';
    }
    t_value = edit.value;
    if (divNode.children[1].value != t_value) {
        divNode.children[1].value = t_value.trim();
        changeFlag = true;
    }
    //判断是否有联动项,有则为联动做准备,并判断编辑值是否改变,改变则清空受动者的值,
    if (edit.linkItems != null) {
        var items = edit.linkItems.split(",");
        for (var i = 0; i < items.length; i++) {
            var colItems;
            if ((colItems = document.getElementsByName(items[i])).length == 0) {
                alert("该元素的 linkItems 属性有误,请查证");
                break;
            }
            var needClearTd = colItems[this._eEditTd.parentElement.rowIndex].parentElement.parentElement;
            needClearTd.linker = this._preLinkerTd = this._eEditTd;
            if (changeFlag) {//清空受动者的值
                needClearTd.children[0].children[0].innerHTML = '&nbsp;';
                needClearTd.children[0].children[1].value = '';
            }
        }
    }

   // edit.fireEvent('onblur');//触发onblur事件
   if(edit.alt!=null && edit.alt != ""){
       eval('function __fireOnLost__(it) { ' + edit.alt.replace(/this/ig, 'it') + '}');
        __fireOnLost__(edit);
   }else{
       edit.fireEvent('onblur')
   }
    if (edit.tagName == 'INPUT') {
        (edit.value == '')?edit.value = ' ':'';
        edit.select();
    }
    if (window.calendar != null) {
        window.calendar.hide();
    }
    divNode.removeChild(edit);
    //    edit.style.display = 'none';
    divNode.flag = true;
    return true;
}

//恢复最后一个编辑单元成显示状态
Grid.prototype.restoreCell = function (){
    if (this.setData()){
        this._eEditTd = this._eFistEditTd;
        this._eEditTd.children[0].flag = true;
    }
}

//焦点下移函数
//每调用一次，焦点由当前单元格调到下一个可以编辑的单元格上
//最后一个单元格返回false
Grid.prototype.focusNextEditDiv = function () {
    if (!this.editFlag) return;//如果不可编辑则直接返回
    if (this._eEditTd.firstType == true) {//这里是判断第一次向第一个元素定位.
        this._eEditTd.removeAttribute('firstType');
        this.editData();
        return true;
    }
    this.__tempTd = this._eEditTd;
    var _isNext = this.__focusNextEditDiv();
    if (_isNext) {
        if (!this._eEditTd.children[0].flag && this.setData()==false) {
            this._eEditTd.edit.focus();
            return true;
        }
        if(this.__tempTd.children[0].unFlag==''){ //有unFlag标志，说明进行了setReadOnly操作，此时判断光标应该处于什么位置
             if(this.isMoveFocusAfterSetReadOnly==false){
                 this.editData();this._eEditTd.edit.focus();return true;
             } else {this._eEditTd = this.__tempTd; return this.focusNextEditDiv(); }
        }
        this._eEditTd = this.__tempTd;
      //  if(this._eEditTd.children[0].unFlag==''){ this.focusNextEditDiv(); }
        this.editData();
    }else {  //_isNext==null 说明新增过只读行，此时焦点仍聚焦到以前的编辑框上
        if(_isNext==null){ this.editData();this._eEditTd.edit.focus();return true;}
        return false;
    }
    return true;
}
Grid.prototype.__focusNextEditDiv = function () {
    var curTr = this.__tempTd.parentElement;
    if (this.__tempTd.nextSibling == null) {
        if ((curTr.nextSibling) == null ) {
            if(!this.addSubRow)return false;
            if (!window.confirm('新增一行新记录吗?')) return false;
            if(this.addRow()==-1) return null;   //addRow 说明新增的行为只读行
        }
        curTr = curTr.nextSibling;
        this.__tempTd = curTr.cells[0];
    } else {
        this.__tempTd = this.__tempTd.nextSibling;
    }
    if (this.__tempTd.children[0] != null && this.__tempTd.children[0].flag != null
            && this._eDataCols[this.__tempTd.cellIndex].children[0] != null //跳过展示的单元格
            && this._eDataCols[this.__tempTd.cellIndex].children[0].type!='hidden') {
        return true;
    }
    return this.__focusNextEditDiv();
}

//焦点上移函数
//每调用一次，焦点由当前单元格调到上一个可以编辑的单元格上
Grid.prototype.focusPreEditDiv = function () {
    if (!this.editFlag) return;   //如果不可编辑,直接返回
    this.__tempTd = this._eEditTd;
    //设置临时单元格,由临时单元格进行递归函数调用
    if (this.__focusPreEditDiv()) { //如果获取成功,移动编辑框.
        if (this.setData()==false) {
            this._eEditTd.edit.focus();
            return;
        }
        this._eEditTd = this.__tempTd;
        this.editData();
    }
    ;
}
Grid.prototype.__focusPreEditDiv = function () {
    var curTr = this.__tempTd.parentElement;
    if (this.__tempTd.previousSibling == null) {
        if ((curTr.previousSibling) == null) return false;
        curTr = curTr.previousSibling;
        this.__tempTd = curTr.lastChild;
    }
    else this.__tempTd = this.__tempTd.previousSibling;
    if (this.__tempTd.children[0] != null && this.__tempTd.children[0].flag != null) return true;
    return this.__focusPreEditDiv();
}
Grid.prototype.focusUpEditDiv = function () {
    if (!this.editFlag) return;//如果不可编辑,直接返回
    var curTr = this._eEditTd.parentElement;
    if ((curTr = curTr.previousSibling) == null)return;//如果到达第一行,直接返回
    if (this.setData()==false) {
        this._eEditTd.edit.focus();
        return;
    }//不是第一行,当前单元格置数
    this._eEditTd = curTr.cells[this._eEditTd.cellIndex];
    //编辑格设置到上一行
    this.editData();
    //设置为编辑状态
}

Grid.prototype.focusDownEditDiv = function () {
    if (!this.editFlag) return;
    var curTr = this._eEditTd.parentElement;
    if ((curTr = curTr.nextSibling) == null) return;
    if (this.setData()==false) {
        this._eEditTd.edit.focus();
        return;
    }
    this._eEditTd = curTr.cells[this._eEditTd.cellIndex];
    this.editData();
}


//grid表单数据提交时的检查.提交时必须调用
//主要根据checkFun来检查由input框输入的值,和select框是否为空
//去处页面空白行,
Grid.prototype.check = function () {
    var edit;
    this.setData();//将最后一个处于编辑的单元格复位
    for (var i = 0; i < this._rows; i++) {
        for (var j = 0; j < this._cols; j++) {
            if (this._eDataCols == null || (edit = this._eDataCols[j].children[0]) == null)continue;
            var td = this._eBodyTable.tBodies[0].rows[i].cells[j];
            if (td.children[0] != null && td.children[0].children[1] != null) { //隐藏域不为空
                if (edit.emptyMsg != null) { //对数据是否为空的校验
                    if (edit.emptyMsg == '' || edit.emptyMsg.match(/^\s+$/)) edit.emptyMsg = '要输入或选择的内容不能为空';
                    if (td.children[0].children[1].value == '' || td.children[0].children[1].value.match(/^\s+$/)) {
                        alert(edit.emptyMsg);
                        this._eEditTd = td;
                        this.editData();
                        return false;
                    }
                }//end if  数据为空校验结束

                if (edit.checkFun != null) { //对数据的自定义校验
                    eval('function __checkFun__(it) { ' + edit.checkFun.replace(/this/ig, 'it') + '}');
                    __checkFun__(td.children[0].children[1]);
                    if (this.inputError) {
                        this.inputError = false;
                        this._eEditTd = td;
                        this.editData();
                        return false;
                    }
                }//end if 数据自定义校验 结束
            }//end if td.children[0].children[1] exist
        }
        //end  j;
    }
    //end  i;

    return true;
}

//=====================右键菜单的添加===========================//

Grid.prototype._showMenu = function () {
    var rightedge = document.body.clientWidth - event.clientX;
    var bottomedge = document.body.clientHeight - event.clientY;
    if (rightedge < this._eMenu.offsetWidth) {
        this._eMenu.style.left = document.body.scrollLeft + event.clientX - this._eMenu.offsetWidth;
    } else {
        this._eMenu.style.left = document.body.scrollLeft + event.clientX;
    }
    if (bottomedge < this._eMenu.offsetHeight) {
        this._eMenu.style.top = document.body.scrollTop + event.clientY - this._eMenu.offsetHeight;
    } else {
        this._eMenu.style.top = document.body.scrollTop + event.clientY;
    }
    this._eMenu.style.visibility = "visible";
    return false
}
Grid.prototype._hideMenu = function() {
    this._eMenu.style.visibility = "hidden";
}
function highLightItem() {
    if (event.srcElement.className == "grid-menuitem") {
        event.srcElement.style.backgroundColor = "highlight";
        event.srcElement.style.color = "white";
    }
}
function lowLightItem() {
    if (event.srcElement.className == "grid-menuitem") {
        event.srcElement.style.backgroundColor = "";
        event.srcElement.style.color = "#000000";
    }
}
function jumpToTarget() {
    if (event.srcElement.className == "grid-menuitem") {
        if (event.srcElement.url != undefined) {
            if (event.srcElement.getAttribute("target") != null)
                window.open(event.srcElement.url, event.srcElement.getAttribute("target"));
            else
                window.location = event.srcElement.url
        } else if (event.srcElement.command != undefined) {
            eval(event.srcElement.command + "");
        }
    }
}
//=======================grid 辅助函数===================/
/**
*   对可编辑的多个select进行更新
* param: sel      要更新的select对像 (当sel==null时，删除该select)
* param: colIndex 更新哪一列   （从0开始）
* param: rowIndex 更新哪一行上select对像 （从0开始）
*
*/
Grid.prototype.updateSelect = function (sel,colIndex,rowIndex) {
    //更新策略：隔行select，中间的select用第一个填充
    if (rowIndex < 0) {
        alert("rowIndex:"+rowIndex+"不能 < 0");
        return false;
    }
    if(colIndex==-1) return;
    if(typeof(sel)=='string'){ sel=document.createElement(sel); }
    var cell = this._eDataCols[colIndex];
    var items = cell.children;
    //删除select
    if(sel==null){
        if(items[rowIndex]!=null)cell.removeChild(items[rowIndex]);
        return true;
    }
    if(items.length ==0){
        cell.appendChild(document.createElement('<select/>'))
    }
    if (rowIndex == items.length) {//新增
        cell.appendChild(sel);
    } else { //修改
        for(var i=items.length;i<=rowIndex;i++){
            cell.appendChild(items[0].cloneNode(true));
        }
        var item = items[rowIndex];
        item.insertAdjacentElement("afterEnd",sel);
        cell.removeChild(item);
    }
    return true;
}
//========================帮助函数========================/

/*
 * 获取元素相对父容器的left偏移量
 */
function getLeftPos(_el) {
    var x = 0;
    for (var el = _el; el; el = el.offsetParent) {
        x += el.offsetLeft;
    }
    return x;
}

/*
* 数字比较器
*/
function compareNumericDesc(n1, n2) {
    if (Number(n1) < Number(n2)) {
        return 1;
    }
    if (Number(n1) > Number(n2)) {
        return -1;
    }
    return 0;
}

/*
 * 从rows中获取选中按钮的数组
 * 只从<tr><td><radio..></td></tr>处取radio
 */
function getCheckedsFromRows(rows){
    if(rows.length==0)return new Array();
    var t = rows[0].cells[0].children[0];
    var r = new Array();
    if(t!=null && (t.type=="radio" || t.type=="checkbox") ){
        for(var i=0;i<rows.length;i++){
            t= rows[i].cells[0].children[0];
            if(t!=null && t.checked)r[r.length]=t;
        }
    }
    return r;
}

/*
 * String类中加入trim空格函数
 */
String.prototype.trim = function (){
     return  this.replace(/(^\s*)|(\s*$)/g,  "");
}

function createSelect(name,id,d){
    var sel = document.createElement("<select name='"+name+"' id='"+id+"'></select>");
    for(var i=0;i<d.length;i++){
        sel.add(new Option(d[i][1],d[i][0]))
    }
    return sel;
}
