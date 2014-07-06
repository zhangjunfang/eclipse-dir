package cn.newcapec.foundation.ecardcity.makecard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import cn.newcapec.framework.core.handler.springDatebind.CustomDateDeserializer;
import cn.newcapec.framework.core.handler.springDatebind.CustomDateSerializer;
import cn.newcapec.framework.core.model.CommonModel;

/**
 * 客户实体类
 * 
 * @author wangjian
 * 
 */
@Table(name = "customer")
@Entity
public class Customer extends CommonModel {
	private static final long serialVersionUID = -7308119212639431688L;

	@Column(name = "customerid")
	private Long customerid;
	@Column(name = "status", length = 32)
	private String status;
	@Column(name = "sex", length = 32)
	private String sex;
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "nation", length = 32)
	private String nation;
	@Column(name = "country", length = 32)
	private String country;
	@Column(name = "certificateid", length = 32)
	private String certificateid;
	@Column(name = "idcardno", length = 18)
	private String idcardno;
	@Column(name = "jpdm", length = 20)
	private String jpdm;
	@Column(name = "ver", length = 5)
	private Integer ver;
	@Column(name = "address", length = 100)
	private String address;
	@Column(name = "email", length = 50)
	private String email;
	@Column(name = "telephone", length = 13)
	private String telephone;
	@Column(name = "postcode", length = 6)
	private String postcode;
	@Column(name = "rremark", length = 200)
	private String rremark;
	@Column(name = "edit_person", length = 32)
	private String edit_person;

	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	/** 生日日期 */
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthday")
	private Date birthday;
	/** 编辑日期 */
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "edit_date")
	private Date edit_date;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nation
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * @param nation
	 *            the nation to set
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * @return the certificateid
	 */
	public String getCertificateid() {
		return certificateid;
	}

	/**
	 * @param certificateid
	 *            the certificateid to set
	 */
	public void setCertificateid(String certificateid) {
		this.certificateid = certificateid;
	}

	/**
	 * @return the idcardno
	 */
	public String getIdcardno() {
		return idcardno;
	}

	/**
	 * @param idcardno
	 *            the idcardno to set
	 */
	public void setIdcardno(String idcardno) {
		this.idcardno = idcardno;
	}

	/**
	 * @return the jpdm
	 */
	public String getJpdm() {
		return jpdm;
	}

	/**
	 * @param jpdm
	 *            the jpdm to set
	 */
	public void setJpdm(String jpdm) {
		this.jpdm = jpdm;
	}

	/**
	 * @return the ver
	 */
	public Integer getVer() {
		return ver;
	}

	/**
	 * @param ver
	 *            the ver to set
	 */
	public void setVer(Integer ver) {
		this.ver = ver;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode
	 *            the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the rremark
	 */
	public String getRremark() {
		return rremark;
	}

	/**
	 * @param rremark
	 *            the rremark to set
	 */
	public void setRremark(String rremark) {
		this.rremark = rremark;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the edit_person
	 */
	public String getEdit_person() {
		return edit_person;
	}

	/**
	 * @param edit_person
	 *            the edit_person to set
	 */
	public void setEdit_person(String edit_person) {
		this.edit_person = edit_person;
	}

	/**
	 * @return the edit_date
	 */
	public Date getEdit_date() {
		return edit_date;
	}

	/**
	 * @param edit_date
	 *            the edit_date to set
	 */
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setEdit_date(Date edit_date) {
		this.edit_date = edit_date;
	}

}
