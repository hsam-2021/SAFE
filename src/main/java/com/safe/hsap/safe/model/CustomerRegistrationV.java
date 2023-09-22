package com.safe.hsap.safe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cusomter_registration_v ", schema = "public")
@NamedQuery(name = "CustomerRegistrationV.findAll", query = "SELECT g FROM CustomerRegistrationV g")
public class CustomerRegistrationV implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "p_id")
	private int pId;

	@Column(name = "p_type")
	private String pType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "p_dob")
	private Date pDob;

	@Column(name = "p_fname")
	private String pFname;

	@Column(name = "p_lname")
	private String pLname;

	@Column(name = "p_gender")
	private String pGender;

	@Column(name = "p_nationality")
	private String pNationality;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "p_pass_expiry")
	private Date pPassExpiry;

	@Column(name = "p_passport_no")
	private String pPassportNo;

	@Column(name = "cust_id")
	private int custId;

	@Column(name = "apt_no")
	private String aptNo;

	@Column(name = "city")
	private String city;

	@Column(name = "contact_num")
	private String contactNum;

	@Column(name = "er_con_cod")
	private int countryCode;

	@Column(name = "cust_email")
	private String custEmail;

	@Column(name = "cst_state")
	private String cstState;

	@Column(name = "c_type")
	private String cType;

	@Column(name = "emer_fname")
	private String emerContactFname;

	@Column(name = "emer_lname")
	private String emerContactLname;

	@Column(name = "street")
	private String street;

	@Column(name = "zip")
	private int zip;

	@Column(name = "asso_airline")
	private String assoAirline;

	@Column(name = "mem_name")
	private String memName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mem_stdate")
	private Date memStdate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mem_enddate")
	private Date memEnddate;

	@Column(name = "ba_cont_no")
	private String baContNo;

	@Column(name = "ba_name")
	private String baName;

	@Column(name = "ba_webadd")
	private String baWebadd;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	public Date getpDob() {
		return pDob;
	}

	public void setpDob(Date pDob) {
		this.pDob = pDob;
	}

	public String getpFname() {
		return pFname;
	}

	public void setpFname(String pFname) {
		this.pFname = pFname;
	}

	public String getpLname() {
		return pLname;
	}

	public void setpLname(String pLname) {
		this.pLname = pLname;
	}

	public String getpGender() {
		return pGender;
	}

	public void setpGender(String pGender) {
		this.pGender = pGender;
	}

	public String getpNationality() {
		return pNationality;
	}

	public void setpNationality(String pNationality) {
		this.pNationality = pNationality;
	}

	public Date getpPassExpiry() {
		return pPassExpiry;
	}

	public void setpPassExpiry(Date pPassExpiry) {
		this.pPassExpiry = pPassExpiry;
	}

	public String getpPassportNo() {
		return pPassportNo;
	}

	public void setpPassportNo(String pPassportNo) {
		this.pPassportNo = pPassportNo;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getAptNo() {
		return aptNo;
	}

	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCstState() {
		return cstState;
	}

	public void setCstState(String cstState) {
		this.cstState = cstState;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getEmerContactFname() {
		return emerContactFname;
	}

	public void setEmerContactFname(String emerContactFname) {
		this.emerContactFname = emerContactFname;
	}

	public String getEmerContactLname() {
		return emerContactLname;
	}

	public void setEmerContactLname(String emerContactLname) {
		this.emerContactLname = emerContactLname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getAssoAirline() {
		return assoAirline;
	}

	public void setAssoAirline(String assoAirline) {
		this.assoAirline = assoAirline;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public Date getMemStdate() {
		return memStdate;
	}

	public void setMemStdate(Date memStdate) {
		this.memStdate = memStdate;
	}

	public Date getMemEnddate() {
		return memEnddate;
	}

	public void setMemEnddate(Date memEnddate) {
		this.memEnddate = memEnddate;
	}

	public String getBaContNo() {
		return baContNo;
	}

	public void setBaContNo(String baContNo) {
		this.baContNo = baContNo;
	}

	public String getBaName() {
		return baName;
	}

	public void setBaName(String baName) {
		this.baName = baName;
	}

	public String getBaWebadd() {
		return baWebadd;
	}

	public void setBaWebadd(String baWebadd) {
		this.baWebadd = baWebadd;
	}

}
