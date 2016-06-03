package com.bus.cap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author melchor.t CREATE TABLE capture.Media( Media_Id MEDIUMINT
 *         AUTO_INCREMENT, Album_Id MEDIUMINT, Media_Name CHAR(50) NOT NULL,
 *         Media_Location CHAR(50) NULL, Media_Type CHAR(30) NOT NULL, PRIMARY
 *         KEY(Media_Id), FOREIGN KEY(Album_Id) REFERENCES Album(Album_Id) );
 */

@Entity
@Table(name = "Media")
public class Media {
	private Long mediaId;
	private Album album;
	private String mediaName;
	private String mediaLocation;
	private String mediaType;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Media_Id")
	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId){
		this.mediaId = mediaId;
	}

	@Column(name = "Media_Name", nullable = false)
	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	@Column(name = "Media_Location")
	public String getMediaLocation() {
		return mediaLocation;
	}

	public void setMediaLocation(String mediaLocation) {
		this.mediaLocation = mediaLocation;
	}

	@Column(name = "Media_Type", nullable = false)
	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	@ManyToOne
	@JoinColumn(name = "Album_Id")
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	@Override
	public String toString(){
		StringBuffer print = new StringBuffer("Media[ " + mediaId + " " +mediaName+ " " +mediaLocation+ " " +mediaType + "]");
		if(null != album){
			print.append(album);
		}
		return print.toString();
	}

}
