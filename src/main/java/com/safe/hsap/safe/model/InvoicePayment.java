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
@Table(name = "amhs_pmt", schema = "public")
@NamedQuery(name = "InvoicePayment.findAll", query = "SELECT g FROM InvoicePayment g")
public class InvoicePayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pm_id")
	@SequenceGenerator(name = "amhs_pmt_id_seq", sequenceName = "amhs_pmt_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amhs_pmt_id_seq")
	private int pmId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pmt_date")
	private Date pmtDate;

	@Column(name = "pmt_amt")
	private float pmtAmt;

	@Column(name = "card_no")
	private String cardNo;

	@Column(name = "card_fname")
	private String cardFname;

	@Column(name = "card_mname")
	private String cardMname;

	@Column(name = "card_lname")
	private String cardLname;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "card_expiry")
	private Date cardExpiry;

	@Column(name = "pay_type")
	private String payType;

	@Column(name = "inv_num")
	private int invNum;

	public int getPmId() {
		return pmId;
	}

	public void setPmId(int pmId) {
		this.pmId = pmId;
	}

	public Date getPmtDate() {
		return pmtDate;
	}

	public void setPmtDate(Date pmtDate) {
		this.pmtDate = pmtDate;
	}

	public float getPmtAmt() {
		return pmtAmt;
	}

	public void setPmtAmt(float pmtAmt) {
		this.pmtAmt = pmtAmt;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardFname() {
		return cardFname;
	}

	public void setCardFname(String cardFname) {
		this.cardFname = cardFname;
	}

	public String getCardMname() {
		return cardMname;
	}

	public void setCardMname(String cardMname) {
		this.cardMname = cardMname;
	}

	public String getCardLname() {
		return cardLname;
	}

	public void setCardLname(String cardLname) {
		this.cardLname = cardLname;
	}

	public Date getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public int getInvNum() {
		return invNum;
	}

	public void setInvNum(int invNum) {
		this.invNum = invNum;
	}

}
