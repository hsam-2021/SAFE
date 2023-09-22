package com.safe.hsap.safe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "amhs_inv", schema = "public")
@NamedQuery(name = "InvoiceDetails.findAll", query = "SELECT g FROM InvoicePayment g")
public class InvoiceDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "inv_num")
	@SequenceGenerator(name = "amhs_inv_id_seq", sequenceName = "amhs_inv_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amhs_inv_id_seq")
	private int invNum;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "inv_date")
	private Date invDate;

	@Column(name = "inv_amt")
	private float invAmt;

	@Column(name = "cust_id")
	private int CustId;

	public int getInvNum() {
		return invNum;
	}

	public void setInvNum(int invNum) {
		this.invNum = invNum;
	}

	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public float getInvAmt() {
		return invAmt;
	}

	public void setInvAmt(float invAmt) {
		this.invAmt = invAmt;
	}

	public int getCustId() {
		return CustId;
	}

	public void setCustId(int custId) {
		CustId = custId;
	}

}
