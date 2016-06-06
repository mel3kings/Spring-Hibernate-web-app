package com.bus.cap.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bus.cap.entities.Album;
import com.bus.cap.entities.Event;

@Repository
public class AlbumDao{
	
	@Autowired
	QueryDao dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Album getLoadedAlbum(Long albumId){
		Album album = (Album)dao.get(albumId, Album.class);
		Event e = album.getEvent();
		album.getMedia().size();
		return album;
	}

}
