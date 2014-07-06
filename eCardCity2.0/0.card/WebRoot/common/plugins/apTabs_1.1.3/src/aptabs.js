/*--------------------------------------------------------------------------*/
/*																			*/
/*  apTabs, version 1.1.0													*/
/*  (c) 2008 Armel Pingault													*/	
/*																			*/
/*  apTabs this site is licensed under a Creative Commons License.			*/
/*	For details, see http://creativecommons.org/licenses/by-sa/3.0/			*/
/*																			*/
/*--------------------------------------------------------------------------*/
 
var apTabs = {
	
	// Customization
	
	tagName: 'H2',		// Tag name for the tab, must be uppercase
	path: 'image/skin/ap/',	// Path to the images
	tabWidth: 148,		// Speed of the scroll
	contentPadding:10,	// Content padding
	scrollSpeed: 200,	// Speed of the scroll
	defaultWidth:600,	// Default width
	defaultHeight:400,	// Default height
	defaultTabContentMinHeight:371,//Default TabContent Height
	defaultTab:1,		// Default active tab: 1 = 1st tab, 2 = 2nd tab, ...
	maxTabLength:6,    //Default loading tabContent
	contentShadow:' <div  style="filter: alpha(opacity=50);background-color: #CCCCFF;z-index: 99998;width: 100%;">  <div style="z-index: 9999999;">    ' +
                            ' <table style="width: 100%; height: 50%; border-collapse: collapse;border:10px;color:red;"> ' +
                            '         <tr>                <td style="text-align: center;" id="loadingTd">          ' +
                            '   <img alt="正在加载" src="image/skin/ap/progress.gif" width="214" height="15"/></td>          ' +
                            ' </tr>       </table> </div>   </div>',
     contentLoadIoc:'<img alt="正在加载" src="image/skin/ap/loading.gif" />请稍后...',
	
	// End of customization
	
	version: '1.1.0',
	requiredPrototype: '1.6.0',
	img: [],
	scrollTmp: 0,
	timeOut: 0,
	dispalyArray: null,//已经加载的保单号
    hideArray: null,//未加载的保单号
	load: function() {
		
		apTabs.init();		

		$$('.apTabs').each(function(e) {
									
			e.style.width	= parseInt(e.style.width) - 2 || apTabs.defaultWidth;
			//e.style.height	= parseInt(e.style.height) - 2 || apTabs.defaultHeight;
			apTabs.defaultTabContentMinHeight = parseInt(e.style.minHeight) - 29 || parseInt(e.style.height) - 29 || apTabs.defaultTabContentMinHeight;
			//标题栏的最外层
			var tabsWrapper = new Element('div', {
				'class': 'tabsWrapper',
				'style': 'background-image:url(' + apTabs.img['tabsBg'].src + ')'
			});
			e.insert(tabsWrapper);
			//左边的滚动条
			var imgPrev = new Element('img', {
				'class': 'scrollLeft',
				'src': apTabs.img['scrollLeftInactive'].src,
				'width': 18
			});
			imgPrev.onclick = function() {
				apTabs.scroll(e, 'left');
			};
			imgPrev.onmouseover = function() {
				if (imgPrev.src.include('scrollLeftActive')) {
					imgPrev.src = apTabs.img['scrollLeftOver'].src;
				}
			};
			imgPrev.onmouseout = function() {
				if (imgPrev.src.include('scrollLeftOver')) {
					imgPrev.src = apTabs.img['scrollLeftActive'].src;
				}
			};
			tabsWrapper.insert(imgPrev);
			//除两边的滚动条外的标题栏外层
			var tabContentsOuter = new Element('div', {
				'class': 'tabContentsOuter',
				'style': 'width:' + (parseInt(e.style.width) - 36) + 'px;background-image:url(' + apTabs.img['line'].src + ')'
			});
			tabsWrapper.insert(tabContentsOuter);
			//除两边的滚动条外的标题栏内层
			var tabContentsInner = new Element('div', {
				'class': 'tabContentsInner'
			});
			tabContentsOuter.insert(tabContentsInner);
			//右边的滚动条
			var imgNext = new Element('img', {
				'class': 'scrollRight',
				'src': apTabs.img['scrollRightInactive'].src,
				'width': 18
			});
			imgNext.onclick = function() {
				apTabs.scroll(e, 'right');
			};
			imgNext.onmouseover = function() {
				if (imgNext.src.include('scrollRightActive')) {
					imgNext.src = apTabs.img['scrollRightOver'].src;
				}
			};
			imgNext.onmouseout = function() {
				if (imgNext.src.include('scrollRightOver')) {
					imgNext.src = apTabs.img['scrollRightActive'].src;
				}
			};
			tabsWrapper.insert(imgNext);
			//给题栏内层添加一个UL
			tabContentsInner.insert(new Element('ul', {
				'class': 'tabLabels'
			}));
			//内容层
			e.insert(new Element('div', {
				'class': 'tabsContent'
			}));
			
			e.childElements().each(function(elt) {
				if (elt.tagName == apTabs.tagName) {
					var content = elt.next().innerHTML;
					var contentType = 'html';
					if (elt.next().hasClassName('ajax')) {
						contentType = 'ajax';
						content = elt.next().firstChild.innerText;
					}
					else if (elt.next().hasClassName('iframe')) contentType = 'iframe';
					var key = elt.getAttribute('key');
					apTabs.add(e, {
						title: elt.innerHTML,
						type: contentType,
						content: content,
						loading:false,
						key:key,
						close: (elt.className == 'noclose') ? false : true
					});
					elt.next().remove();
				}
			});	

			e.childElements().each(function(elt) {
				if (elt.tagName == apTabs.tagName) {
					elt.remove();
				}
			});
			
			//apTabs.show(e, e.down('.tabLabels').childNodes[apTabs.defaultTab - 1]);
			apTabs.show(e, e.down('.tabLabels').childNodes[0]);
			apTabs.updateScrollButtons(e);			
		});
	},

	init: function() {
		var agt = navigator.userAgent.toLowerCase();
		apTabs.is_op  = (agt.indexOf("opera") != -1);
		apTabs.is_ie  = (agt.indexOf("msie") != -1) && document.all && !apTabs.is_op;
		apTabs.is_ie6 = (agt.indexOf("msie 6") != -1) && document.all && !apTabs.is_op;
		
		apTabs.checkRequiredPrototype(); // http://script.aculo.us/

		apTabs.preload();		
	},

	/* http://script.aculo.us/ */
	checkRequiredPrototype: function() {
		if ((typeof Prototype == 'undefined') || 
			(typeof Element == 'undefined') || 
			(typeof Element.Methods=='undefined') ||
			(apTabs.convertVersionString(Prototype.Version) <
			 apTabs.convertVersionString(apTabs.requiredPrototype)))
		throw("apTabs requires the Prototype JavaScript framework >= " + apTabs.requiredPrototype);
	},
	
	/* http://script.aculo.us/ */
	convertVersionString : function (versionString) {
		var r = versionString.split('.');
		return parseInt(r[0])*100000 + parseInt(r[1])*1000 + parseInt(r[2]);
	},
	
	preload: function() {		
		apTabs.img = new Array();		
		['tabsBg', 'line',
		 'scrollLeftActive','scrollLeftInactive','scrollLeftOver',
		 'scrollRightActive','scrollRightInactive','scrollRightOver',
		 'tabLeftActive','tabLeftInactive','tabLeftOver',
		 'tabRightActive','tabRightInactive','tabRightOver',
		 'closeActive','closeInactive','closeOver'].each(function(i) {
			apTabs.img[i] = new Image();
			apTabs.img[i].src = apTabs.path + i + '.gif';
		});
	},
	
	add: function(e, tab) {
		var newTab = false;
		//当点页面手动添加一个页签
		if (typeof(e) == 'string') {
			e = $(e);
			newTab = true;			
		}

		var tabLabel = new Element('li', {
			'class': 'tabLabelActive',
			'style': 'width:' + apTabs.tabWidth + 'px',
			'key': tab.key
		});
		tabLabel.onmouseover = function() {
			if (!tabLabel.firstChild.style.backgroundImage.include('tabLeftOver')) {
				tabLabel.firstChild.style.backgroundImage = 'url(' + apTabs.img['tabLeftActive'].src + ')';
				tabLabel.lastChild.style.backgroundImage = 'url(' + apTabs.img['tabRightActive'].src + ')';
			}
		};
		tabLabel.onmouseout = function() {
			if (!tabLabel.firstChild.style.backgroundImage.include('tabLeftOver')) {
				tabLabel.firstChild.style.backgroundImage = 'url(' + apTabs.img['tabLeftInactive'].src + ')';
				tabLabel.lastChild.style.backgroundImage = 'url(' + apTabs.img['tabRightInactive'].src + ')';
			}
		};
		
		//标题DIV.
		var tabLabelA = new Element('div', {
			'class': 'tabLabelLeft'
		}).update(tab.title);
		tabLabelA.onclick = function() {
			apTabs.show(e, tabLabelA.parentNode);
		};		
		tabLabel.insert(tabLabelA);	
		
		//标题右则的图片
		var tabLabelClose = new Element('div', {
			'class': 'tabLabelRight',
			'style': 'background-image:url(' + apTabs.img['tabRightInactive'].src + ')'
		});
		tabLabel.insert(tabLabelClose);
		//关闭按钮DIV
		if (typeof(tab.close) == 'undefined' || tab.close == true) {
			var closeImg = new Element('img', {
				'src': apTabs.img['closeInactive'].src,
				'style': 'margin-top:6px'
			});
			closeImg.onclick = function() {
				apTabs.remove(e, closeImg.parentNode.parentNode);
			};
			closeImg.onmouseover = function() {
				closeImg.src = apTabs.img['closeOver'].src;
			};
			closeImg.onmouseout = function() {
				//如果当前关闭按钮的父类是高亮的,哪么它就是高亮的
				if (closeImg.parentNode.style.backgroundImage.include('tabRightOver')) {
					closeImg.src = apTabs.img['closeActive'].src;
				}else {
					closeImg.src = apTabs.img['closeInactive'].src;
				}
			};
			tabLabelClose.insert(closeImg);
		}

		e.down('.tabLabels').insert(tabLabel);
		//计算标题的宽度
		tabLabelA.style.width = parseInt(tabLabel.getWidth() - 5 - 23) + 'px';

		apTabs.updateScrollButtons(e);
		//内容DIV
	   	var tabContent = new Element('div', {
			'class': 'tabContent',
			'style': 'min-height: '+apTabs.defaultTabContentMinHeight+'px;'
		});

		//apTabs.hideAll(e);
		e.down('.tabsContent').appendChild(tabContent);
		
		if (tab.html) {
			tab.type = 'html';
			tab.content = tab.html;
		}
		else if (tab.ajax) {
			tab.type = 'ajax';
			tab.content = tab.ajax;
		}
		else if (tab.iframe) {
			tab.type = 'iframe';
			tab.content = tab.iframe;
		}
		/**
		 * 计算应该加载前多少个保单,
		 * 两个集合:dispalyArray是用于保单已经加载过的保单号
		 * hideArray:还没有加载过后保单集合
		 * 会根据保单号+key来组合成唯一的Key
		 */
		  if(!apTabs.dispalyArray) apTabs.dispalyArray = new Hash();
            var dp = apTabs.dispalyArray.keys(); 
            if(dp.length == apTabs.maxTabLength){
                if(!apTabs.hideArray) apTabs.hideArray = new Hash();
                var key = tabLabelA.innerText+tab.key;
                apTabs.hideArray.set(key.toLowerCase(),tab);
            }else{
            	var key = tabLabelA.innerText+tab.key;
                apTabs.dispalyArray.set(key.toLowerCase(),tab);
        		if (tab.type == 'html') {
        				tabContent.innerHTML = tab.content;
        		} else if (tab.type == 'ajax') {//ajax请求
        			tabContent.innerHTML=apTabs.contentShadow;
					if(tabContent.firstElementChild){
						tabContent.firstElementChild.style.height=apTabs.defaultTabContentMinHeight+"px";
					}else{
						tabContent.firstChild.style.height=apTabs.defaultTabContentMinHeight+"px";
					}
                    if(dp.length==0){//第一保单同步
                       /* pf.ajaxSubmitAsyn(tab.content, null, function(transport) {
                                var jsonObj = transport.responseText;
                                tabContent.style.padding= apTabs.contentPadding + "px";
                                tabContent.innerHTML = jsonObj;
                            });*/
                    }else{
						/*
        				pf.ajaxSubmit(tab.content, null, function(transport) {
        						var jsonObj = transport.responseText;
        						tabContent.style.padding=  apTabs.contentPadding + "px";
        						tabContent.innerHTML = jsonObj;
        					});*/
                    }
        		} else if (tab.type == 'iframe') {
        			var iframeHeight = parseInt(e.style.height) - 29;
        			var iframeWidth = (apTabs.is_ie6) ? parseInt(e.style.width) - 2 : parseInt(e.style.width);
        			tabContent.setStyle({
        			  padding: '0px',
        			  height: eval(parseInt(tabContent.style.height) + apTabs.contentPadding * 2) + 'px'
        			});
        			tabContent.innerHTML = '<iframe width="' + iframeWidth + '" height="' + iframeHeight + '" margin="0" padding="0" frameborder="0" src="' + tab.content + '"></iframe>';
        		}
		  }

		apTabs.setLabelInnerWidth(e);
		
		if (newTab) {
			apTabs.hideNewTab(tabLabel,tabContent,e);
		}
		apTabs.updateScrollButtons(e);
	},
	hideNewTab: function(tabTitle,tabContent,e){
		tabTitle.firstChild.style.backgroundImage = 'url(' + apTabs.img['tabLeftInactive'].src + ')';
		tabTitle.lastChild.style.backgroundImage = 'url(' + apTabs.img['tabRightInactive'].src + ')';
		if (tabTitle.lastChild.firstChild) {
			tabTitle.lastChild.firstChild.src = apTabs.img['closeInactive'].src;
		}
		tabContent.hide();

	},
	remove: function(e, tab) {
		
		var id = tab.previousSiblings().length;

		// If closing current tab
		if (tab.className == 'tabLabelActive') {
			if (tab.next()) {
				apTabs.show(e, tab.next());
			} else if (tab.previous()) {
				apTabs.show(e, tab.previous());
			}
		}

		tab.remove();
		e.lastChild.childNodes[id].remove();
		
		apTabs.setLabelInnerWidth(e);
		apTabs.updateScrollButtons(e);
	},
	/***
	 * 显示而签
	 * 计算当前页签
	 * 如果显示就不加载了
	 * 如果
	 * @param {} e
	 * @param {} tab
	 */
	show: function(e, tab) {
		if (typeof(e) == 'string') e = $(e);
		if (e.className != 'apTabs') e = e.up('.apTabs');
		if (typeof(tab) != 'object') tab = e.down('.tabLabels').childElements()[tab - 1];
		apTabs.hideAll(e);
		tab.firstChild.style.backgroundImage = 'url(' + apTabs.img['tabLeftOver'].src + ')';
		tab.lastChild.style.backgroundImage = 'url(' + apTabs.img['tabRightOver'].src + ')';
		if (tab.lastChild.firstChild) {
			tab.lastChild.firstChild.src = apTabs.img['closeActive'].src;
		}
		/**
		 * 从当前显示的标题栏中拿出保单号和key
		 * 检查保单号+key是否在未加载的保单集合中.
		 * 如果在就加载此保单的详细信息
		 * 在保单详细信息加载之后,从救驾保单集合中把该保单移除.
		 * 加入已加载保单集合.
		 */
		e.lastChild.childNodes[tab.previousSiblings().length].show();
		if(apTabs.hideArray){
			var key = tab.firstChild.innerText+tab.getAttribute('key');
    		var loadTab  = apTabs.hideArray.get(key.toLowerCase());
    		if( e.lastChild.childNodes[tab.previousSiblings().length].innerText == ''&& loadTab /*&& loadTab.loading == false*/){
    			//loadTab.loading=true;
    			apTabs.hideArray.set(key,loadTab);
    			e.lastChild.childNodes[tab.previousSiblings().length].innerHTML=apTabs.contentShadow;
				if(e.lastChild.childNodes[tab.previousSiblings().length].firstElementChild){
					e.lastChild.childNodes[tab.previousSiblings().length].firstChild.style.height = apTabs.defaultTabContentMinHeight+"px";
				}else{
					e.lastChild.childNodes[tab.previousSiblings().length].firstChild.style.height = apTabs.defaultTabContentMinHeight+"px";
				}
    			
    			pf.ajaxSubmit(loadTab.content, null, function(transport) {
    				        apTabs.hideArray.unset(key);
    				        //loadTab.loading=false;
                            apTabs.dispalyArray.set(key,loadTab);
    						var jsonObj = transport.responseText;
    						e.lastChild.childNodes[tab.previousSiblings().length].style.padding=apTabs.contentPadding+"px";
    						e.lastChild.childNodes[tab.previousSiblings().length].innerHTML= jsonObj;
    					});
    		}
		}
	},
	
	hideAll: function(e) {
		e.down('.tabLabels').childElements().each(function(tab) {
			tab.firstChild.style.backgroundImage = 'url(' + apTabs.img['tabLeftInactive'].src + ')';
			tab.lastChild.style.backgroundImage = 'url(' + apTabs.img['tabRightInactive'].src + ')';
		});

		e.down('.tabsContent').childElements().each(function(div) {
			div.hide();
		});
	},
	/**
	*计算左，右移动的速度．
	如果添加一个页签，要从前的页签一个一个往后移动，这样才有移动效果
	如果往右边移动，只加上当前的移动速度
	如果往左边移动，减去当前的移动速度
	*
	*/
	scroll: function(e, w) {
		//获取内标题栏的宽度
		var tabWidth = (w == 'last') ? apTabs.getNbTabs(e) * apTabs.getTabWidth(e) : apTabs.getTabWidth(e);
		if(w == 'left' && e.down('.scrollRight').style.display =='none' )tabWidth = tabWidth-18;
		if (apTabs.scrollTmp < tabWidth ) {
			//计算移动速度
			scrollSpeed = (tabWidth - apTabs.scrollTmp < apTabs.scrollSpeed) ? tabWidth - apTabs.scrollTmp : apTabs.scrollSpeed ;
			//如果到最左边,移动速度为负的scrollSpeed
			if (w == 'left') scrollSpeed = -scrollSpeed ;
			//隐藏左边的宽度
			e.down('.tabContentsOuter').scrollLeft = e.down('.tabContentsOuter').scrollLeft + scrollSpeed;
			//累加移动的长度
			apTabs.scrollTmp += apTabs.scrollSpeed;
			//循环计算
			apTabs.timeOut = setTimeout(function(){apTabs.scroll(e, w)}, 10);
		} else {
			apTabs.scrollTmp = 0;
			clearTimeout(apTabs.timeOut);
			apTabs.updateScrollButtons(e);
		}
	},
	//获取LU中第一个LI的宽度,也就是第一个标题的宽度
	getTabWidth: function(e) {
		return (e.down('.tabLabels').firstChild) ? e.down('.tabLabels').firstChild.getWidth() : 0 ;
	},
	//获取标题栏内的宽度(标题栏内的宽度=标题栏个数*标题栏的宽度)
	setLabelInnerWidth: function(e) {
		e.down('.tabContentsInner').style.width = (apTabs.getNbTabs(e) * apTabs.getTabWidth(e)) + 'px';
	},
	//获取LU中Li的个数,也就标题的数量
	getNbTabs: function(e) {
		return e.down('.tabLabels').childNodes.length;
	},
	
	//计算显示左右的滚动条以及外标题栏的宽度
	updateScrollButtons: function(e) {
		
		var leftScroll	= e.down('.scrollLeft');
		var rightScroll	= e.down('.scrollRight');
		var apTabsWidth =  parseInt(e.style.width);
		if (parseInt(e.down('.tabContentsOuter').style.width) < parseInt(e.down('.tabContentsInner').style.width)) {
			if (e.down('.tabContentsOuter').scrollLeft == 0) {
				//leftScroll.src = apTabs.img['scrollLeftInactive'].src;
				leftScroll.style.display='none';
				rightScroll.src = apTabs.img['scrollRightActive'].src;
				rightScroll.style.display='block';
				e.down('.tabContentsOuter').style.width= apTabsWidth - rightScroll.width+'px';
			}
			else if (parseInt(e.down('.tabContentsOuter').style.width) + 
					 parseInt(e.down('.tabContentsOuter').scrollLeft) ==
					 parseInt(e.down('.tabContentsInner').style.width)) {
				if (!leftScroll.src.include('scrollLeftOver')) {
					leftScroll.src = apTabs.img['scrollLeftActive'].src;
					leftScroll.style.display='block';
				}
				//rightScroll.src = apTabs.img['scrollRightInactive'].src;
				rightScroll.style.display='none';
				e.down('.tabContentsOuter').style.width = apTabsWidth - leftScroll.width + 'px';
			}
			else {
				if (!leftScroll.src.include('scrollLeftOver')) {
					leftScroll.src = apTabs.img['scrollLeftActive'].src;
					leftScroll.style.display='block';
				}
				if (!rightScroll.src.include('scrollRightOver')) {
					rightScroll.src = apTabs.img['scrollRightActive'].src;
					rightScroll.style.display='block';
				}
				e.down('.tabContentsOuter').style.width= apTabsWidth - leftScroll.width-rightScroll.width+'px';
			}
		} else {
			//leftScroll.src = apTabs.img['scrollLeftInactive'].src;
			leftScroll.style.display='none';
			//rightScroll.src = apTabs.img['scrollRightInactive'].src;
			rightScroll.style.display='none';
			e.down('.tabContentsOuter').style.width= apTabsWidth +'px';
		}
	}
};

Event.observe(window, 'load', function() {
	apTabs.load();
});