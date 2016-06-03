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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/***
 * CREATE TABLE capture.Album( Album_Id MEDIUMINT AUTO_INCREMENT,
 * Customer_User_Id CHAR(20), Location CHAR(40) NOT NULL, Title CHAR(50) NOT
 * NULL, Name CHAR(50) NOT NULL, Description CHAR(200) NULL, Date TIMESTAMP,
 * PRIMARY KEY(Album_Id), FOREIGN KEY(Customer_User_Id) REFERENCES
 * Customer(User_Id) );
 * */
@Entity
@Table(name = "Album")
public class Album {
	private Long albumId;
	private Customer customer;
	private String location;
	private String title;
	private String name;
	private String description;
	private Date date;
	private List<Media> media;
	private Event event;
	private List<Comment> comment;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Album_Id")
	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	@Column(name = "Location", nullable = false)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "Title", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Date", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToOne
	@JoinColumn(name = "Customer_User_Id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToMany(fetch =FetchType.LAZY, mappedBy="album")
	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Album_Id", insertable=false, updatable=false)
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@OneToMany(fetch= FetchType.LAZY, mappedBy="album")
	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString(){
		StringBuffer printout = new StringBuffer("Album[" + albumId + " " + location + " " + title + " " +name+ " " +description+ " " +date + "]");
		if(null != customer){
			printout.append(customer);
		} 
		if(null != event){
			printout.append(event);
		}
		return printout.toString();
	}

}
