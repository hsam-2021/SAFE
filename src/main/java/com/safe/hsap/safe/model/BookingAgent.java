package com.safe.hsap.safe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "amhs_ba", schema = "public")
@NamedQuery(name = "BookingAgent.findAll", query = "SELECT g FROM BookingAgent g")
public class BookingAgent implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BookingAgentPK ba_id;

	@Column(name = "ba_name")
	private String bookingAgentName;

	@Column(name = "ba_webadd")
	private String bookingAgentWebAdd;

	@Column(name = "ba_cont_no")
	private String bookingAgentContactNo;

	public BookingAgentPK getBa_id() {
		return ba_id;
	}

	public void setBa_id(BookingAgentPK ba_id) {
		this.ba_id = ba_id;
	}

	public String getBookingAgentName() {
		return bookingAgentName;
	}

	public void setBookingAgentName(String bookingAgentName) {
		this.bookingAgentName = bookingAgentName;
	}

	public String getBookingAgentWebAdd() {
		return bookingAgentWebAdd;
	}

	public void setBookingAgentWebAdd(String bookingAgentWebAdd) {
		this.bookingAgentWebAdd = bookingAgentWebAdd;
	}

	public String getBookingAgentContactNo() {
		return bookingAgentContactNo;
	}

	public void setBookingAgentContactNo(String bookingAgentContactNo) {
		this.bookingAgentContactNo = bookingAgentContactNo;
	}

}
