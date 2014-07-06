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
 * 终端信息
 * 
 * @author wulimo
 * 
 */
@Table(name = "term_info")
@Entity
public class TermInfo extends CommonModel {
	private static final long serialVersionUID = 3906676794034474253L;

	@Column(name = "termid")
	private Long termid;
	@Column(name = "termname", length = 20)
	private String termname;
	@Column(name = "merchantcode", length = 8)
	private String merchantcode;
	@Column(name = "poscode", length = 20)
	private String poscode;
	@Column(name = "isuse", length = 1)
	private String isuse;
	@Column(name = "paramgroupid", length = 32)
	private String paramgroupid;

	/**
	 * 终端类型：1 读卡器 2 出纳机 3 圈存机 4 营业机 5 综合缴费
	 */
	@Column(name = "typeid", length = 32)
	private String typeid;
	@Column(name = "status", length = 1)
	private String status;
	/** 最后一次采集数据时间 */
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastcollectdate")
	private Date lastcollectdate;
	@Column(name = "psamcardno")
	private Long psamcardno;
	/** 最后一次修改时间 */
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastcollectdate")
	private Date lastupdatedate;
	@Column(name = "collectid", length = 12)
	private String collectid;
	@Column(name = "siteid", length = 12)
	private String siteid;
	@Column(name = "isauth", length = 1)
	private String isauth;
	@Column(name = "workingkey", length = 16)
	private String workingkey;
	@Column(name = "kekcode", length = 16)
	private String kekcode;
	@Column(name = "appid", length = 5)
	private Long appid;
	@Column(name = "kekencryptkey", length = 16)
	private String kekencryptkey;
	@Column(name = "isdelete", length = 1)
	private String isdelete;
	@Column(name = "ver")
	private Long ver;

	public Long getTermid() {
		return termid;
	}

	public void setTermid(Long termid) {
		this.termid = termid;
	}

	public String getTermname() {
		return termname;
	}

	public void setTermname(String termname) {
		this.termname = termname;
	}

	public String getMerchantcode() {
		return merchantcode;
	}

	public void setMerchantcode(String merchantcode) {
		this.merchantcode = merchantcode;
	}

	public String getPoscode() {
		return poscode;
	}

	public void setPoscode(String poscode) {
		this.poscode = poscode;
	}

	public String getIsuse() {
		return isuse;
	}

	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}

	public String getParamgroupid() {
		return paramgroupid;
	}

	public void setParamgroupid(String paramgroupid) {
		this.paramgroupid = paramgroupid;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastcollectdate() {
		return lastcollectdate;
	}

	public void setLastcollectdate(Date lastcollectdate) {
		this.lastcollectdate = lastcollectdate;
	}

	public Long getPsamcardno() {
		return psamcardno;
	}

	public void setPsamcardno(Long psamcardno) {
		this.psamcardno = psamcardno;
	}

	public Date getLastupdatedate() {
		return lastupdatedate;
	}

	public void setLastupdatedate(Date lastupdatedate) {
		this.lastupdatedate = lastupdatedate;
	}

	public String getCollectid() {
		return collectid;
	}

	public void setCollectid(String collectid) {
		this.collectid = collectid;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getIsauth() {
		return isauth;
	}

	public void setIsauth(String isauth) {
		this.isauth = isauth;
	}

	public String getWorkingkey() {
		return workingkey;
	}

	public void setWorkingkey(String workingkey) {
		this.workingkey = workingkey;
	}

	public String getKekcode() {
		return kekcode;
	}

	public void setKekcode(String kekcode) {
		this.kekcode = kekcode;
	}

	public Long getAppid() {
		return appid;
	}

	public void setAppid(Long appid) {
		this.appid = appid;
	}

	public String getKekencryptkey() {
		return kekencryptkey;
	}

	public void setKekencryptkey(String kekencryptkey) {
		this.kekencryptkey = kekencryptkey;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public Long getVer() {
		return ver;
	}

	public void setVer(Long ver) {
		this.ver = ver;
	}

}
