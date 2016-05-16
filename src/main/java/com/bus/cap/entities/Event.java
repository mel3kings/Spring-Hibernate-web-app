package com.bus.cap.entities;

import java.util.Date;

public class Event {
	private Long eventId;
	private Long eventAlbumId;
	private String customerUserId;
	private String eventName;
	private String eventLocation;
	private String eventCity;
	private Date eventDateTime;
	private String eventHashTag;
	private String eventDescription;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getEventAlbumId() {
		return eventAlbumId;
	}

	public void setEventAlbumId(Long eventAlbumId) {
		this.eventAlbumId = eventAlbumId;
	}

	public String getCustomerUserId() {
		return customerUserId;
	}

	public void setCustomerUserId(String customerUserId) {
		this.customerUserId = customerUserId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}

	public Date getEventDateTime() {
		return eventDateTime;
	}

	public void setEventDateTime(Date eventDateTime) {
		this.eventDateTime = eventDateTime;
	}

	public String getEventHashTag() {
		return eventHashTag;
	}

	public void setEventHashTag(String eventHashTag) {
		this.eventHashTag = eventHashTag;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
}
