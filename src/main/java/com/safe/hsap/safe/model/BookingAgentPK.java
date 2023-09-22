package com.safe.hsap.safe.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

@Embeddable
public class BookingAgentPK implements Serializable {

	private static final long serialVersionUID = 1L;

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
}
