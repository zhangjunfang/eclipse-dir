package cn.com.newcapec.citycard.content.action;

import cn.com.newcapec.common.util.Constants;
import cn.com.newcapec.citycard.common.po.TContent;

/**
 * <p>
 * 网站公告的action
 * 
 * @author: WangJian
 * @version: 1.0
 * January 13, 2013 17:18:23 PM
 * </p>
 */

public class BulletinAction extends ContentAction {
	private static final long serialVersionUID = -3325509146357472558L;

	public BulletinAction(){
		if(getObj()==null ){
			TContent obj=new TContent();
			setObj(obj);
		}
		getObj().setChannelId(Constants.CONTENT_BULLETIN_ID);
		setLogTitle(Constants.CONTENT_BULLETIN);
	}
}