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
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	@GetMapping("/hotels")
	public String HomePage(Model model) {
		List<Hotels> listHotels = service.getListHotels();
		model.addAttribute("listHotels", listHotels);
	     
	    return "hotels";	
		
	}
	
	@RequestMapping("/newhotel")
	public String NewHotelPage(Model model) {
	    Hotels Hotel = new Hotels();
	    model.addAttribute("newhotel", Hotel);
	     
	    return "new_hotel";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveHotels(@ModelAttribute("newhotel") Hotels newhotel) {
	    service.save(newhotel);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditHotelPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_hotel");
	    Hotels Hotel = service.getHotel(id);
	    mav.addObject("hotel",Hotel);
	     
	    return mav;
	}
	
	
	@RequestMapping("/delete/{id}")
	public String deleteHotel(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/";       
	}
	

	
	
	
	

	
	
	
	
}
