package com.safe.hsap.safe.repository;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "customer_passenger_records_v", schema = "public")
@NamedQuery(name = "CustomerPassengerMappingV.findAll", query = "SELECT g FROM CustomerPassengerMappingV g")
public class CustomerPassengerMappingV implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "p_id")
	private int pId;

	@Column(name = "cust_id")
	private int custId;

	@Column(name = "p_fname")
	private String fname;

	@Column(name = "p_lname")
	private String lname;

	@Column(name = "p_gender")
	private String gender;

	@Column(name = "p_dob")
	private Date dob;

	@Column(name = "apt_no")
	private int aptNo;

	@Column(name = "city")
	private String city;

	@Column(name = "contact_num")
	private String contactNum;

	@Column(name = "country")
	private String country;

	@Column(name = "p_nationality")
	private String nationality;

	@Column(name = "p_pass_expiry")
	private Date passExpiry;

	@Column(name = "p_passport_no")
	private String passportNo;

	@Column(name = "cust_email")
	private String custEmail;

	@Column(name = "cst_state")
	private String cstState;

	@Column(name = "c_type")
	private String cType;

	@Column(name = "emer_fname")
	private String emerFname;

	@Column(name = "emer_lname")
	private String emerLname;

	@Column(name = "emer_contact_no")
	private String emerContactNo;

	@Column(name = "street")
	private String street;

	@Column(name = "zip")
	private int zip;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAptNo() {
		return aptNo;
	}

	public void setAptNo(int aptNo) {
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getPassExpiry() {
		return passExpiry;
	}

	public void setPassExpiry(Date passExpiry) {
		this.passExpiry = passExpiry;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
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

	public String getEmerFname() {
		return emerFname;
	}

	public void setEmerFname(String emerFname) {
		this.emerFname = emerFname;
	}

	public String getEmerLname() {
		return emerLname;
	}

	public void setEmerLname(String emerLname) {
		this.emerLname = emerLname;
	}

	public String getEmerContactNo() {
		return emerContactNo;
	}

	public void setEmerContactNo(String emerContactNo) {
		this.emerContactNo = emerContactNo;
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

}
