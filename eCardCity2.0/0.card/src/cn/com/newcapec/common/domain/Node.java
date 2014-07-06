package cn.com.newcapec.common.domain;

import java.io.Serializable;

/**
 * <pre>
 * 功能描述: 树型目录结点
 *   
 * Author : Wangjian 
 * Date	  : 2008-05-22
 * Time   : 14:04:15
 * Version:1.0
 * </pre>
 */
public class Node implements Serializable
{
	private static final long serialVersionUID = 1730466910528197856L;
	
	private String id;//ID
	private String name;//名称
	private String url;//URL
	private String pid;//上级结点ID
	private Boolean isFolder;//是否为目录结点
	private Boolean isChecked;//此结点是否已分配,用于生成分配功能模块时的菜单树
	
	public Node()
	{
	}

	public Node(String id, String name, String url, String pid,Boolean isFolder,Boolean isChecked)
	{
		this.id = id;
		this.name = name;
		this.url = url;
		this.pid = pid;
		this.isFolder=isFolder;
		this.isChecked=isChecked;
	}
	
	public Boolean getIsFolder()
	{
		return isFolder;
	}

	public void setIsFolder(Boolean isFolder)
	{
		this.isFolder = isFolder;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPid()
	{
		return pid;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
	
	
	
	/**
	 * @return the isChecked
	 */
	public Boolean getIsChecked() {
		return isChecked;
	}

	/**
	 * @param isChecked the isChecked to set
	 */
	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	/**
	 * 重载比较NODE对象相等的方法
	 * @修改人:Wangjian
	 * @date 2008-06-10
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.newcapec.common.domain.Node)) return false;
		else {
			cn.com.newcapec.common.domain.Node node = (cn.com.newcapec.common.domain.Node) obj;
			if (null == this.getId() || null == node.getId()) return false;
			else return (this.getId().equals(node.getId()));
		}
	}
}
