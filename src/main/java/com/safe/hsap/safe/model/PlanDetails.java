package com.safe.hsap.safe.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "amhs_isrpl", schema = "public")
@NamedQuery(name = "PlanDetails.findAll", query = "SELECT g FROM PlanDetails g")
public class PlanDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "plan_id")
	private int planId;

	@Column(name = "plan_name")
	private String planName;

	@Column(name = "plan_description")
	private String planDescription;

	@Column(name = "cost")
	private float cost;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	
}
