package com.bus.cap.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bus.cap.entities.Admin;
import com.bus.cap.entities.Business;
import com.bus.cap.persistence.QueryDao;

@Controller
public class RegistrationController {

	private static final Logger log = Logger.getLogger(RegistrationController.class);
	
	@Autowired
	QueryDao dao;
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public String registerPage(){
		log.info("Redirecting to registration page");
		return "register/create";
	}
	
	@RequestMapping(value="/submitRegister", method = RequestMethod.POST)
	public String registration(@ModelAttribute Admin admin, ModelMap map){
		try {
			admin.setRole("ADMIN");
			dao.save(admin);
		} catch (Exception e) {
			log.error("Error occured during save registration", e);
			return "register/registrationFail";
		}
		map.addAttribute("name", admin.getUserName());
		return "register/successs";
	}
	
}
