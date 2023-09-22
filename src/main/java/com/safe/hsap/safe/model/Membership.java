package com.safe.hsap.safe.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "amhs_mem", schema = "public")
@NamedQuery(name = "Membership.findAll", query = "SELECT g FROM Membership g")
public class Membership implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MembershipPK mem_id;

	@Column(name = "mem_name")
	private String membershipName;

	@Column(name = "asso_airline")
	private String assoicatedAirline;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mem_stdate")
	private Date membershipStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mem_enddate")
	private Date membershipEndtDate;

	public MembershipPK getMem_id() {
		return mem_id;
	}

	public void setMem_id(MembershipPK mem_id) {
		this.mem_id = mem_id;
	}

	public String getMembershipName() {
		return membershipName;
	}

	public void setMembershipName(String membershipName) {
		this.membershipName = membershipName;
	}

	public String getAssoicatedAirline() {
		return assoicatedAirline;
	}

	public void setAssoicatedAirline(String assoicatedAirline) {
		this.assoicatedAirline = assoicatedAirline;
	}

	public Date getMembershipStartDate() {
		return membershipStartDate;
	}

	public void setMembershipStartDate(Date membershipStartDate) {
		this.membershipStartDate = membershipStartDate;
	}

	public Date getMembershipEndtDate() {
		return membershipEndtDate;
	}

	public void setMembershipEndtDate(Date membershipEndtDate) {
		this.membershipEndtDate = membershipEndtDate;
	}

}
