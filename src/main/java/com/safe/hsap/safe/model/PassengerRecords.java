package com.safe.hsap.safe.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class PassengerRecords implements Serializable {
	private static final long serialVersionUID = 1L;
	private int custId;
	private int pId;
	private String fname;
	private String lname;
	private String gender;
	private String nationality;
	private String passportNo;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date passExpiry;
	private String custEmail;

	public PassengerRecords() {

	}

	public PassengerRecords(int custId, int pId, String fname, String lname, String gender, String nationality,
			String passportNo, Date dob, Date passExpiry, String custEmail) {
		super();
		this.custId = custId;
		this.pId = pId;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.nationality = nationality;
		this.passportNo = passportNo;
		this.dob = dob;
		this.passExpiry = passExpiry;
		this.custEmail = custEmail;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getPassExpiry() {
		return passExpiry;
	}

	public void setPassExpiry(Date passExpiry) {
		this.passExpiry = passExpiry;
	}

}
