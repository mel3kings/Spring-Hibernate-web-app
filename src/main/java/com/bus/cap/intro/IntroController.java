package com.bus.cap.intro;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bus.cap.entities.Admin;
import com.bus.cap.entities.Business;
import com.bus.cap.persistence.QueryDao;

@Controller
public class IntroController {
	@Autowired
	QueryDao dao;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "index";
	}
	
	@RequestMapping(value = "/test/{name}", method =RequestMethod.GET)
	public ModelAndView sampleHibernateOperations(@PathVariable("name") String name){
		try{
			System.out.println("CHECKING DAO" + dao);
			Business b = new Business();
			b.setBusinessName(name);
			b.setBusinessCity("Makati City");
			b.setDescription("Testing account");
			b.setBusinessAddress("Business Address");
			List list = dao.query(name, "businessName", new Business());
			if(null != list){
				Admin ad = new Admin();
				ad.setBusiness(b);
				ad.setEmail("email@foo.com");
				ad.setMobileNumber("1234-1234");
				ad.setPassword("password");
				ad.setRole("ADMIN");
				ad.setTelephoneNumber("12345");
				ad.setUserId("ID");
				ad.setUserName("Sysadmin");
				dao.save(ad);	
			}else{
				dao.save(b);
			}	
		}catch(SQLException sql){
			//handle error here
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("message", "Saving Done for " + name);
		return model;
	}
	
}
