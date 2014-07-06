package cn.newcapec.foundation.ecardcity.makecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.newcapec.framework.core.model.CommonModel;

/**
 * 
 * @Description: 卡类型实体
 * @author 高崇飞
 * @date 2014-4-21 下午02:46:41
 * @version V1.0
 */
@Entity
@Table(name = "card_type")
public class CardType extends CommonModel {

	private static final long serialVersionUID = -693841966186554489L;

	/* 卡小类型 */
	@Column(name = "typeid")
	private Long typeid;
	/* 卡类别，根据字典类别查找并引用 */
	@Column(name = "groupid")
	private String groupid;
	/* 小类名称 */
	@Column(name = "cardtypename")
	private String cardtypename;
	/* 排序ID，越小越优先。 */
	@Column(name = "sort_num")
	private String sort_num;
	/* 描述 */
	@Column(name = "description")
	private String description;
	/* 信息变更版本号 */
	@Column(name = "ver")
	private String ver;

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getCardtypename() {
		return cardtypename;
	}

	public void setCardtypename(String cardtypename) {
		this.cardtypename = cardtypename;
	}

	public String getSort_num() {
		return sort_num;
	}

	public void setSort_num(String sort_num) {
		this.sort_num = sort_num;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}
}
