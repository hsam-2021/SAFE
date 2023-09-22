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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "transaction_records_v", schema = "public")
@NamedQuery(name = "TransactionRecordsV.findAll", query = "SELECT g FROM TransactionRecordsV g")
public class TransactionRecordsV implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cust_id")
	private int custId;

	@Id
	@Column(name = "p_id")
	private int pId;

	@Column(name = "p_fname")
	private String pFname;

	@Column(name = "p_lname")
	private String pLname;

	@Column(name = "p_gender")
	private String pGender;

	@Column(name = "p_nationality")
	private String nationality;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "p_pass_expiry")
	private Date pPassExpiry;

	@Column(name = "p_passport_no")
	private String pPassportNo;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "p_dob")
	private Date pDob;

	@Column(name = "inv_amt")
	private float invAmt;

	@Column(name = "pmt_amt")
	private float pmtAmt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "inv_date")
	private Date invDate;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pmt_date")
	private Date pmtDate;

	@Column(name = "pay_type")
	private String payType;

	@Column(name = "flight_details")
	private String flightDetails;

	@Column(name = "plan")
	private String plan;

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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	public Date getpDob() {
		return pDob;
	}

	public void setpDob(Date pDob) {
		this.pDob = pDob;
	}

	public float getInvAmt() {
		return invAmt;
	}

	public void setInvAmt(float invAmt) {
		this.invAmt = invAmt;
	}

	public float getPmtAmt() {
		return pmtAmt;
	}

	public void setPmtAmt(float pmtAmt) {
		this.pmtAmt = pmtAmt;
	}

	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public Date getPmtDate() {
		return pmtDate;
	}

	public void setPmtDate(Date pmtDate) {
		this.pmtDate = pmtDate;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(String flightDetails) {
		this.flightDetails = flightDetails;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

}
