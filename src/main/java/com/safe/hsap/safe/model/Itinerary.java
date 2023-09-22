package com.safe.hsap.safe.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "amhs_it", schema = "public")
@NamedQuery(name = "Itinerary.findAll", query = "SELECT g FROM Itinerary g")
public class Itinerary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "itiner_id")
	@SequenceGenerator(name = "amhs_it_id_seq", sequenceName = "amhs_it_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amhs_it_id_seq")
	private int itinerId;

	@Column(name = "cabin_id")
	private int cabinId;

	@Column(name = "req_id")
	private int reqId;

	@Column(name = "meal_id")
	private int mealId;

	@Column(name = "p_id")
	private int pId;

	@Column(name = "fl_id")
	private int flId;

	@Column(name = "p_type")
	private String pType;

	public int getItinerId() {
		return itinerId;
	}

	public void setItinerId(int itinerId) {
		this.itinerId = itinerId;
	}

	public int getCabinId() {
		return cabinId;
	}

	public void setCabinId(int cabinId) {
		this.cabinId = cabinId;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getFlId() {
		return flId;
	}

	public void setFlId(int flId) {
		this.flId = flId;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

}
