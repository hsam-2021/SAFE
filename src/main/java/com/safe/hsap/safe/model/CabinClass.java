package com.safe.hsap.safe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "amhs_cc", schema = "public")
@NamedQuery(name = "CabinClass.findAll", query = "SELECT g FROM CabinClass g")
public class CabinClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cabin_id")
	private int cabinId;

	@Column(name = "cabin_type")
	private String cabinType;

	public int getCabinId() {
		return cabinId;
	}

	public void setCabinId(int cabinId) {
		this.cabinId = cabinId;
	}

	public String getCabinType() {
		return cabinType;
	}

	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}

}
