package com.safe.hsap.safe.model;

import java.io.Serializable;
import java.util.Objects;

public class CompositeKeyPassenger implements Serializable {
	private static final long serialVersionUID = 1L;

	private int pId;

	private String passengerType;

	public CompositeKeyPassenger() {

	}

	public CompositeKeyPassenger(int pId, String passengerType) {
		this.pId = pId;
		this.passengerType = passengerType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CompositeKeyPassenger compositeKeyPassenger = (CompositeKeyPassenger) o;
		return pId == compositeKeyPassenger.pId && passengerType.equals(compositeKeyPassenger.passengerType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pId, passengerType);
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

}
