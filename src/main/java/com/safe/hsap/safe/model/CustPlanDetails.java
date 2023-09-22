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
@Table(name = "amhs_cins", schema = "public")
@NamedQuery(name = "CustPlanDetails.findAll", query = "SELECT g FROM CustPlanDetails g")
public class CustPlanDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "amhs_cins_id_seq", sequenceName = "amhs_cins_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amhs_cins_id_seq")
	private int id;

	@Column(name = "amhs_isrpl_plan_id")
	private int planId;

	@Column(name = "amhs_cst_cust_id")
	private int custId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "i_date")
	private Date selectDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public Date getSelectDate() {
		return selectDate;
	}

	public void setSelectDate(Date selectDate) {
		this.selectDate = selectDate;
	}

}
