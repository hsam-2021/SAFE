package com.safe.hsap.safe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(CompositeKeyPassenger.class)
@Table(name = "amhs_psg", schema = "public")
@NamedQuery(name = "Passenger.findAll", query = "SELECT g FROM Passenger g")
public class Passenger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "amhs_psg_p_id_seq", sequenceName = "amhs_psg_p_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amhs_psg_p_id_seq")
	@Column(name = "p_id")
	private int pId;

	@Id
	@Column(name = "p_type")
	private String passengerType;

	@Column(name = "p_fname")
	private String passengerFirstName;

	@Column(name = "p_lname")
	private String passengerLastName;

	@Column(name = "p_gender")
	private String passengerGender;

	@Column(name = "p_nationality")
	private String passengerNationality;

	@Column(name = "p_passport_no")
	private String passengerPassportNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "p_dob")
	private Date passengerDob;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "p_pass_expiry")
	private Date passengerPassportExpiry;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "passenger")
	@JoinColumns({ @JoinColumn(name = "p_id", referencedColumnName = "p_id"),
			@JoinColumn(name = "p_type", referencedColumnName = "p_type") })
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	public String getPassengerFirstName() {
		return passengerFirstName;
	}

	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public String getPassengerNationality() {
		return passengerNationality;
	}

	public void setPassengerNationality(String passengerNationality) {
		this.passengerNationality = passengerNationality;
	}

	public String getPassengerPassportNo() {
		return passengerPassportNo;
	}

	public void setPassengerPassportNo(String passengerPassportNo) {
		this.passengerPassportNo = passengerPassportNo;
	}

	public Date getPassengerDob() {
		return passengerDob;
	}

	public void setPassengerDob(Date passengerDob) {
		this.passengerDob = passengerDob;
	}

	public Date getPassengerPassportExpiry() {
		return passengerPassportExpiry;
	}

	public void setPassengerPassportExpiry(Date passengerPassportExpiry) {
		this.passengerPassportExpiry = passengerPassportExpiry;
	}

}
