/**
 * 系统名称 ：城市一卡通综合管理平台
 * 开发组织 ：城市一卡通事业部
 * 版权所属 ：新开普电子股份有限公司
 * (C) Copyright  Corporation 2014  All Rights Reserved.
 * 本内容仅限于郑州新开普电子股份有限公司内部使用，版权保护，未经过授权拷贝使用将追究法律责任
 */
package cn.newcapec.function.ecardcity.om.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @author wj
 * @category z-tree的后台bean
 * @version 1.0
 * @date 2014年4月10日 下午10:37:30
 */
public class TreeView implements Serializable{
    	private static final long serialVersionUID = 8167507052150298533L;
	private String id;
    	private String pId;
    	private String url;
    	private String name;
    	private String target;
    	private boolean open;
    	private List<TreeView> children;
	/**
	 * @return the id
	 */
	public String getId() {
	    return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
	    this.id = id;
	}
	/**
	 * @return the pId
	 */
	public String getpId() {
	    return pId;
	}
	/**
	 * @param pId the pId to set
	 */
	public void setpId(String pId) {
	    this.pId = pId;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
	    return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
	    this.url = url;
	}
	/**
	 * @return the name
	 */
	public String getName() {
	    return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
	    this.name = name;
	}
	/**
	 * @return the target
	 */
	public String getTarget() {
	    return target;
	}
	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
	    this.target = target;
	}
	/**
	 * @return the open
	 */
	public boolean isOpen() {
	    return open;
	}
	/**
	 * @param open the open to set
	 */
	public void setOpen(boolean open) {
	    this.open = open;
	}
	/**
	 * @return the nodes
	 */
	public List<TreeView> getNodes() {
	    return children;
	}
	/**
	 * @param nodes the nodes to set
	 */
	public void setNodes(List<TreeView> children) {
	    this.children = children;
	}

}
