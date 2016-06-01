package com.bus.cap.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bus.cap.entities.Event;
import com.bus.cap.persistence.QueryDao;

@Controller
public class EventController {

	@Autowired
	QueryDao dao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(value="/event", method= RequestMethod.GET)
	public String createEventPage(){
		return "event/create";
	}
	
	@RequestMapping(value="/createEvent", method = RequestMethod.POST)
	public String create(@ModelAttribute Event event, ModelMap map){
		try {
			System.out.println("saving event..");
			dao.save(event);
		} catch (Exception e) {
			System.out.println("ASDAS");
			e.printStackTrace();
			return "event/fail";
		}
		map.addAttribute("name", event.getEventName());
		return "event/success";
	}
	
	@RequestMapping(value="/event/{id}", method= RequestMethod.GET)
	public ModelAndView eventPage(@PathVariable("id") Long id){
		ModelAndView map = new ModelAndView();
		map.setViewName("event/details");
		Event event = (Event) dao.get(id, Event.class);
		map.addObject("event",event);
		return map;
	}
	
	@RequestMapping(value="/event/updateEvent", method = RequestMethod.POST)
	public String update(@ModelAttribute Event event, ModelMap map){
		try {
			System.out.println("updating event.. " + event.getEventId());
			dao.update(event);
		} catch (Exception e) {
			System.out.println("ASDAS");
			e.printStackTrace();
			return "event/fail";
		}
		map.addAttribute("name", event.getEventName());
		return "event/success";
	}
}
