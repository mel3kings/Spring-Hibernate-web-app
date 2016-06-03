package com.bus.cap.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bus.cap.entities.Album;
import com.bus.cap.persistence.QueryDao;

@Controller
public class AlbumController {
	
	@Autowired 
	QueryDao dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@RequestMapping(value="/album/{Id}", method= RequestMethod.GET)
	public ModelAndView eventPage(@PathVariable("Id") Long albumId){
		ModelAndView map = new ModelAndView();
		map.setViewName("album/details");
		Album album= dao.getAlbum(albumId);
		return map;
	}
}
