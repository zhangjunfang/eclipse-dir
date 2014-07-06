package cn.newcapec.foundation.ecardcity.makecard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import cn.newcapec.framework.core.handler.springDatebind.CustomDateSerializer;
import cn.newcapec.framework.core.model.CommonModel;

/**
 * 
 * @Description: 黑名单表：system_black 实体类
 * @author 高崇飞
 * @date 2014-4-23 下午01:33:13
 * @version V1.0
 */
@Table(name = "system_black")
@Entity
public class SystemBlack extends CommonModel {
	private static final long serialVersionUID = -3347324002396153840L;
	// 更新用户
	@Column(name = "edit_person", length = 12)
	private String edit_person;
	// 黑名单来源（0：清算平台；1：制卡中心；2：自助；3：记录上传；4：其他）
	@Column(name = "sourcetype", length = 1)
	private String sourcetype;
	// 操作类型 0挂失 1解挂
	@Column(name = "state", length = 1)
	private String state;
	// 卡应用序列号
	@Column(name = "asn", length = 13)
	private String asn;
	// 板本号
	@Column(name = "sn", length = 5)
	private Integer sn;
	// 有效期
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "nousedate")
	private Date nousedate;
	// 生成时间（挂失时间）
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "losscount")
	private Date losscount;
	// 更新日期
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "edit_date")
	private Date edit_date;

	public Date getEdit_date() {
		return edit_date;
	}

	public void setEdit_date(Date edit_date) {
		this.edit_date = edit_date;
	}

	public String getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAsn() {
		return asn;
	}

	public void setAsn(String asn) {
		this.asn = asn;
	}

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public Date getNousedate() {
		return nousedate;
	}

	public void setNousedate(Date nousedate) {
		this.nousedate = nousedate;
	}

	public Date getLosscount() {
		return losscount;
	}

	public void setLosscount(Date losscount) {
		this.losscount = losscount;
	}

	public String getEdit_person() {
		return edit_person;
	}

	public void setEdit_person(String edit_person) {
		this.edit_person = edit_person;
	}
}
