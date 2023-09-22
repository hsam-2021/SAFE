package com.safe.hsap.safe.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class CustomerRegistrationRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	private int pId;
	private String pType;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date pDob;
	private String pFname;
	private String pLname;
	private String pGender;
	private String pNationality;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date pPassExpiry;
	private String pPassportNo;
	private int custId;
	private String aptNo;
	private String city;
	private String contactNum;
	private int countryCode;
	private String custEmail;
	private String cstState;
	private String cType;
	private String emerContactFname;
	private String emerContactLname;
	private String street;
	private int zip;
	private String assoAirline;
	private String memName;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date memStdate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date memEnddate;
	private String baContNo;
	private String baName;
	private String baWebadd;

	public CustomerRegistrationRecord() {

	}

	public CustomerRegistrationRecord(int pId, String pType, Date pDob, String pFname, String pLname, String pGender,
			String pNationality, Date pPassExpiry, String pPassportNo, int custId, String aptNo, String city,
			String contactNum, int countryCode, String custEmail, String cstState, String cType,
			String emerContactFname, String emerContactLname, String street, int zip, String assoAirline,
			String memName, Date memStdate, Date memEnddate, String baContNo, String baName, String baWebadd) {
		this.pId = pId;
		this.pType = pType;
		this.pDob = pDob;
		this.pFname = pFname;
		this.pLname = pLname;
		this.pGender = pGender;
		this.pNationality = pNationality;
		this.pPassExpiry = pPassExpiry;
		this.pPassportNo = pPassportNo;
		this.custId = custId;
		this.aptNo = aptNo;
		this.city = city;
		this.contactNum = contactNum;
		this.countryCode = countryCode;
		this.custEmail = custEmail;
		this.cstState = cstState;
		this.cType = cType;
		this.emerContactFname = emerContactFname;
		this.emerContactLname = emerContactLname;
		this.street = street;
		this.zip = zip;
		this.assoAirline = assoAirline;
		this.memName = memName;
		this.memStdate = memStdate;
		this.memEnddate = memEnddate;
		this.baContNo = baContNo;
		this.baName = baName;
		this.baWebadd = baWebadd;
	}

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
