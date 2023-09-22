package com.safe.hsap.safe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "amhs_sreq", schema = "public")
@NamedQuery(name = "SpecialRequest.findAll", query = "SELECT g FROM SpecialRequest g")
public class SpecialRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "req_id")
	private int reqId;

	@Column(name = "req_type")
	private String reqType;

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

}
