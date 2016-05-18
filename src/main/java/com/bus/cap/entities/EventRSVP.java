package com.bus.cap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 CREATE TABLE capture.Event_RSVP( Event_RSVP_Id MEDIUMINT AUTO_INCREMENT,
 * Event_Id MEDIUMINT, RSVP CHAR(10), Guest_Name CHAR(30) NOT NULL,
 * Guest_Address CHAR(100) NOT NULL, Guest_Email_Address CHAR(50) NOT NULL,
 * Guest_Mobile_Number CHAR(20), No_Of_Guest INT, PRIMARY KEY(Event_RSVP_Id),
 * FOREIGN KEY (Event_Id) REFERENCES Event(Event_Id) );
 * */
@Entity
@Table(name = "Event_RSVP")
public class EventRSVP {
	private Long eventRSVPId;
	private Event event;
	private String RSVP;
	private String guestName;
	private String guestAddress;
	private String guestEmailAddress;
	private String guestMobileNumber;
	private int noOfGuest;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Event_RSVP_Id")
	public Long getEventRSVPId() {
		return eventRSVPId;
	}

	public void setEventRSVPId(Long eventRSVPId) {
		this.eventRSVPId = eventRSVPId;
	}



	@Column(name = "RSVP")
	public String getRSVP() {
		return RSVP;
	}

	public void setRSVP(String RSVP) {
		this.RSVP = RSVP;
	}

	@Column(name = "Guest_Name", nullable=false)
	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	@Column(name = "Guest_Address", nullable=false)
	public String getGuestAddress() {
		return guestAddress;
	}

	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

	@Column(name = "Guest_Email_Address", nullable=false)
	public String getGuestEmailAddress() {
		return guestEmailAddress;
	}

	public void setGuestEmailAddress(String guestEmailAddress) {
		this.guestEmailAddress = guestEmailAddress;
	}
	@Column(name="Guest_Mobile_Number")
	public String getGuestMobileNumber() {
		return guestMobileNumber;
	}

	public void setGuestMobileNumber(String guestMobileNumber) {
		this.guestMobileNumber = guestMobileNumber;
	}

	@Column(name="No_Of_Guest")
	public int getNoOfGuest() {
		return noOfGuest;
	}

	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Event_Id")
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
