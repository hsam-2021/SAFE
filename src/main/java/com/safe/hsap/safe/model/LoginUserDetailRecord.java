package com.safe.hsap.safe.model;

import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component
public class LoginUserDetailRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String firstName;
	protected String lastName;
	protected String emails;

	public LoginUserDetailRecord() {

	}

	public LoginUserDetailRecord(String firstName, String lastName, String emails) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emails = emails;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

}
