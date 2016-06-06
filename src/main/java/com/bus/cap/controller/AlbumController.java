package com.bus.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bus.cap.entities.Album;
import com.bus.cap.persistence.AlbumDao;

@Controller
public class AlbumController {
	
	@Autowired 
	AlbumDao dao;
	
	@RequestMapping(value="/album/{Id}", method= RequestMethod.GET)
	public ModelAndView eventPage(@PathVariable("Id") Long albumId){
		ModelAndView map = new ModelAndView();
		map.setViewName("album/details");
		Album album = dao.getLoadedAlbum(albumId);
		map.addObject("album", album);
		map.addObject("mediaList", album.getMedia());
		return map;
	}
}
