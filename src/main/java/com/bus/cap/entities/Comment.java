package com.bus.cap.entities;

import java.util.Date;

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
 * CREATE TABLE capture.Comment( Comment_Id MEDIUMINT AUTO_INCREMENT, Album_Id
 * MEDIUMINT, User_Id CHAR(50), Comment CHAR(255), Comment_Date TIMESTAMP,
 * PRIMARY KEY(Comment_Id), FOREIGN KEY(Album_Id) REFERENCES Album(Album_Id) );
 * 
 * */
@Entity
@Table(name = "Comment")
public class Comment {
	private Long commentId;
	private Album album;
	private Long albumid;
	private String userId;
	private String comment;
	private Date commentDate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Comment_Id")
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getAlbumid() {
		return albumid;
	}

	public void setAlbumid(Long albumid) {
		this.albumid = albumid;
	}

	@Column(name = "User_Id", nullable = false)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "Comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "Comment_Date")
	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Album_Id")
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	@Override
	public String toString(){
		StringBuffer print = new StringBuffer("Comment[" + commentId + " " + albumid + " " + userId + " " + comment + " " 
				+ commentDate+ "]");
		return print.toString();
	}
}
