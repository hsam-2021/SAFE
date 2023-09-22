package com.safe.hsap.safe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "flight_details_v", schema = "public")
@NamedQuery(name = "FlightDetailsV.findAll", query = "SELECT g FROM FlightDetailsV g")
public class FlightDetailsV implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "fl_id")
	private int flId;

	@Column(name = "flight_details")
	private String flightDetails;

	public int getFlId() {
		return flId;
	}

	public void setFlId(int flId) {
		this.flId = flId;
	}

	public String getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(String flightDetails) {
		this.flightDetails = flightDetails;
	}
}
