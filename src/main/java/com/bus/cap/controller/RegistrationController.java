package com.bus.cap.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bus.cap.entities.Admin;
import com.bus.cap.persistence.QueryDao;

@Controller
public class RegistrationController {

	@Autowired
	QueryDao dao;
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public String registerPage(){
		return "register/registrationPage";
	}
	
	@RequestMapping(value="/submitRegister", method = RequestMethod.POST)
	public String registration(@ModelAttribute Admin admin, ModelMap map){
		try {
			admin.setRole("ADMIN");
			dao.save(admin);
		} catch (Exception e) {
			System.out.println("ASDAS");
			e.printStackTrace();
			return "register/registrationFail";
		}
		map.addAttribute("name", admin.getUserName());
		return "register/registrationSuccess";
	}
	
}
