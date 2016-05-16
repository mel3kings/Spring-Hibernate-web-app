package com.bus.cap.entities;

public class EventRSVP {
	private Long eventId;
	private String RSVP;
	private String guestName;
	private String guestAddress;
	private String guestEmailAddress;
	private String guestMobileNumber;
	private int noOfGuest;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getRSVP() {
		return RSVP;
	}

	public void setRSVP(String rSVP) {
		RSVP = rSVP;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestAddress() {
		return guestAddress;
	}

	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

	public String getGuestEmailAddress() {
		return guestEmailAddress;
	}

	public void setGuestEmailAddress(String guestEmailAddress) {
		this.guestEmailAddress = guestEmailAddress;
	}

	public String getGuestMobileNumber() {
		return guestMobileNumber;
	}

	public void setGuestMobileNumber(String guestMobileNumber) {
		this.guestMobileNumber = guestMobileNumber;
	}

	public int getNoOfGuest() {
		return noOfGuest;
	}

	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}
}
