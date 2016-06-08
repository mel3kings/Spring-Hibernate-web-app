package com.bus.cap.controller;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bus.cap.constants.Constant;
import com.bus.cap.entities.Customer;
import com.bus.cap.persistence.QueryDao;

@Controller
public class CustomerController {
	private final static Logger log = Logger.getLogger(CustomerController.class);
	
	@Autowired
	QueryDao dao;
	
	@RequestMapping(value={"/customer", "/customer/{id}"}, method= RequestMethod.GET)
	public ModelAndView home(@PathVariable Map<String, String> pathVariables){
		ModelAndView mv = new ModelAndView();
		if(pathVariables.containsKey("id")){
			mv.addObject("customer", dao.get(pathVariables.get("id"), Customer.class));
			mv.setViewName("customer/detail");
		}	else{
			mv.setViewName("customer/create");	
		}	
		return mv;
	}
	
	@RequestMapping(value={"/createCustomer","/customer/updateCustomer"}, method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute Customer customer, ModelMap map) {
		ModelAndView mv = new ModelAndView();
		try {
			customer.setCustomerType("PARENT");
			dao.save(customer);
			mv.addObject("customer", customer);
			mv.addObject("message" , Constant.SUCCESS);
			mv.setViewName("customer/success");
		} catch (Exception ex) {
			log.error("Error saving customer", ex);
			mv.addObject("message" , Constant.FAIL);	
			mv.setViewName("customer/fail");
		}
		return mv;
	}
	
	@RequestMapping(value="/customer/deleteCustomer/{id}", method=RequestMethod.POST)
	public ModelAndView delete(@PathVariable Map<String, String> pathVariables){
		ModelAndView mv = new ModelAndView();
		try {
			if(pathVariables.containsKey("id")){
				dao.delete(pathVariables.get("id"), Customer.class);
			}			
			mv.setViewName("customer/success");
			mv.addObject("message", Constant.DELETE);
		} catch (SQLException e) {
			log.error("Error deleting customer", e);
			mv.setViewName("customer/fail");
			mv.addObject("message", Constant.FAIL);
		}
		return mv;
	}

}
