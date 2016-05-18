package com.bus.cap.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author melchor.t CREATE TABLE capture.Event( Event_Id MEDIUMINT
 *         AUTO_INCREMENT, Event_Album_Id MEDIUMINT, Customer_User_Id CHAR(20),
 *         Event_Name CHAR(50) NOT NULL, Event_Location CHAR(50) NOT NULL,
 *         Event_City CHAR(30) NULL, Event_Time TIMESTAMP, Event_Hashtag
 *         CHAR(30) NULL, Event_Description CHAR(200) NULL, PRIMARY
 *         KEY(Event_Id), FOREIGN KEY(Event_Album_Id) REFERENCES Album(Album_Id)
 *         );
 */

@Entity
@Table(name = "Event")
public class Event {
	private Long eventId;
	private List<Album> album;
	private List<EventRSVP> eventRsvp;
	private String customerUserId;
	private String eventName;
	private String eventLocation;
	private String eventCity;
	private Date eventDateTime;
	private String eventHashTag;
	private String eventDescription;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Event_Id")
	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	@Column(name = "Customer_User_Id")
	public String getCustomerUserId() {
		return customerUserId;
	}

	public void setCustomerUserId(String customerUserId) {
		this.customerUserId = customerUserId;
	}

	@Column(name = "Event_Name", nullable = false)
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Column(name = "Event_Location", nullable = false)
	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	@Column(name = "Event_City")
	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}

	@Column(name = "Event_Time")
	public Date getEventDateTime() {
		return eventDateTime;
	}

	public void setEventDateTime(Date eventDateTime) {
		this.eventDateTime = eventDateTime;
	}

	@Column(name = "Event_Hashtag")
	public String getEventHashTag() {
		return eventHashTag;
	}

	public void setEventHashTag(String eventHashTag) {
		this.eventHashTag = eventHashTag;
	}

	@Column(name = "Event_Description")
	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	@JoinColumn(name = "Event_Album_Id")
	@OneToMany(fetch = FetchType.LAZY)
	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
	public List<EventRSVP> getEventRsvp() {
		return eventRsvp;
	}

	public void setEventRsvp(List<EventRSVP> eventRsvp) {
		this.eventRsvp = eventRsvp;
	}
}
