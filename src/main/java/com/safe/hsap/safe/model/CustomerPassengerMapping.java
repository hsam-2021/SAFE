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
@Table(name = "amhs_cst_psg_map", schema = "public")
@NamedQuery(name = "CustomerPassengerMapping.findAll", query = "SELECT g FROM CustomerPassengerMapping g")
public class CustomerPassengerMapping implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "amhs_cst_psg_map_id_seq", sequenceName = "amhs_cst_psg_map_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amhs_cst_psg_map_id_seq")
	private int id;

	@Column(name = "p_id")
	private int pId;

	@Column(name = "cust_id")
	private int custId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

}
