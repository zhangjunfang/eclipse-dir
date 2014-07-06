package cn.newcapec.foundation.ecardcity.makecard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.newcapec.framework.core.model.CommonModel;

/**
 * 
 * @Description: PASM 表实体
 * @author 高崇飞
 * @date 2014-4-21 下午02:46:41
 * @version V1.0
 */
@Entity
@Table(name = "card_psam")
public class CardPsam extends CommonModel {

	private static final long serialVersionUID = -693841966186554489L;
	/* PSAM卡号:samcardname转换成的数字 */
	@Column(name = "samcardno")
	private String samcardno;
	/* PSAM卡号，来源于密钥系统的原始终端编号数据，6字节的数字 */
	@Column(name = "samcardname")
	private String samcardname;
	/* 密钥系统的PSAM卡序列号（发卡流水号），4字节的数字 */
	@Column(name = "samcardsn")
	private String samcardsn;
	/* PSAM卡编号：10个字节的应用代码，公司自定义规则 */
	@Column(name = "samcardsnr")
	private String samcardsnr;
	/* 状态：0-初始状态，1-正在使用，10-挂失，11-损坏。12-注销 */
	@Column(name = "state")
	private String state;
	/* 卡上的有效起始日期 */
	@Column(name = "startdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;
	/* 卡上的有效截止日期 */
	@Column(name = "enddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;
	/* 挂失日期 */
	@Column(name = "lossdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lossdate;
	/* 挂失时记录编号 */
	@Column(name = "lossrecno")
	private String lossrecno;
	/* 最后一次更新日期 */
	@Column(name = "lastupdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastupdate;
	/* PSAM卡登记入库日期 */
	@Column(name = "createdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	/* 出厂打引号 */
	@Column(name = "printcode")
	private String printcode;
	/* 版本 */
	@Column(name = "ver")
	private String ver;
	/* 0为导入，1为手工录入，2为采集上传 */
	@Column(name = "addtype")
	private String addtype;
	/* 0消费终端sam卡类型，-1制卡中心sam卡类型 */
	@Column(name = "samcardtype")
	private String samcardtype;

	public String getSamcardno() {
		return samcardno;
	}

	public void setSamcardno(String samcardno) {
		this.samcardno = samcardno;
	}

	public String getSamcardname() {
		return samcardname;
	}

	public void setSamcardname(String samcardname) {
		this.samcardname = samcardname;
	}

	public String getSamcardsn() {
		return samcardsn;
	}

	public void setSamcardsn(String samcardsn) {
		this.samcardsn = samcardsn;
	}

	public String getSamcardsnr() {
		return samcardsnr;
	}

	public void setSamcardsnr(String samcardsnr) {
		this.samcardsnr = samcardsnr;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getLossdate() {
		return lossdate;
	}

	public void setLossdate(Date lossdate) {
		this.lossdate = lossdate;
	}

	public String getLossrecno() {
		return lossrecno;
	}

	public void setLossrecno(String lossrecno) {
		this.lossrecno = lossrecno;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getPrintcode() {
		return printcode;
	}

	public void setPrintcode(String printcode) {
		this.printcode = printcode;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getAddtype() {
		return addtype;
	}

	public void setAddtype(String addtype) {
		this.addtype = addtype;
	}

	public String getSamcardtype() {
		return samcardtype;
	}

	public void setSamcardtype(String samcardtype) {
		this.samcardtype = samcardtype;
	}

}