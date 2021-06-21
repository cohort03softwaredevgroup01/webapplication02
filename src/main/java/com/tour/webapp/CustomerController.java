package com.tour.webapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customers")
	public String HomePage(Model model) {
		List<Customers> listCustomers = service.getListCustomers();
		model.addAttribute("listCustomers", listCustomers);
	     
	    return "customers";
	}
	
	@RequestMapping("/newcustomer")
	public String NewCustomerPage(Model model) {
	    Customers Customer = new Customers();
	    model.addAttribute("newcustomer", Customer);
	     
	    return "new_customer";
	}
	
	
	@RequestMapping(value = "/savecustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("newcustomer") Customers newcustomer) {
	    service.save(newcustomer);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/editcustomer/{email}")
	public ModelAndView showEditCustomerPage(@PathVariable(name = "email") String email) {
	    ModelAndView mav = new ModelAndView("edit_customer");
	    Customers Customer = service.getCustomer(email);
	    mav.addObject("customer",Customer);
	     
	    return mav;
	}
	
	@RequestMapping("/deletecustomer/{email}")
	public String deleteCustomer(@PathVariable(name = "email") String email) {
	    service.delete(email);
	    return "redirect:/";       
	}
	
	
}
