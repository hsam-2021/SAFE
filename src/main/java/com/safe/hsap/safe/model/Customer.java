package com.safe.hsap.safe.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "amhs_cst", schema = "public")
@NamedQuery(name = "Customer.findAll", query = "SELECT g FROM Customer g")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cust_id")
	@SequenceGenerator(name = "amhs_cst_id_seq", sequenceName = "amhs_cst_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amhs_cst_id_seq")
	private int custId;

	@Column(name = "street")
	private String street;

	@Column(name = "apt_no")
	private String aptNo;

	@Column(name = "city")
	private String city;

	@Column(name = "cst_state")
	private String custState;

	@Column(name = "country")
	private String country;

	@Column(name = "zip")
	private int zip;

	@Column(name = "cust_email")
	private String custEmail;

	@Column(name = "contact_num")
	private String contactNum;

	@Column(name = "er_con_cod")
	private int countryCodePhone;

	@Column(name = "emer_contact_no")
	private String emergencyContactNum;

	@Column(name = "emer_fname")
	private String emergencyContactFirstName;

	@Column(name = "emer_lname")
	private String emergencyContactLasttName;

	@Column(name = "c_type")
	private String customerType;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "p_id", referencedColumnName = "p_id"),
			@JoinColumn(name = "p_type", referencedColumnName = "p_type") })
	private Passenger passenger;

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getCustState() {
		return custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getEmergencyContactNum() {
		return emergencyContactNum;
	}

	public void setEmergencyContactNum(String emergencyContactNum) {
		this.emergencyContactNum = emergencyContactNum;
	}

	public int getCountryCodePhone() {
		return countryCodePhone;
	}

	public void setCountryCodePhone(int countryCodePhone) {
		this.countryCodePhone = countryCodePhone;
	}

	public String getEmergencyContactFirstName() {
		return emergencyContactFirstName;
	}

	public void setEmergencyContactFirstName(String emergencyContactFirstName) {
		this.emergencyContactFirstName = emergencyContactFirstName;
	}

	public String getEmergencyContactLasttName() {
		return emergencyContactLasttName;
	}

	public void setEmergencyContactLasttName(String emergencyContactLasttName) {
		this.emergencyContactLasttName = emergencyContactLasttName;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
}
