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
public class PackageController {
	
	@Autowired
	private PackageService service;
	
	@GetMapping("/packages")
	public String HomePage(Model model) {
		List<Packages> listPackages = service.getListPackages();
		model.addAttribute("listPackages", listPackages);
	     
	    return "packages";
	}
	
	
	@RequestMapping("/newpackage")
	public String NewProductPage(Model model) {
	    Packages Package = new Packages();
	    model.addAttribute("newpackage", Package);
	     
	    return "new_package";
	}
	
	@RequestMapping(value = "/savePackage", method = RequestMethod.POST)
	public String savePackage(@ModelAttribute("newpackage") Packages newpackage) {
	    service.save(newpackage);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/editpackage/{id}")
	public ModelAndView showEditPackagePage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_package");
	    Packages Package = service.getPackage(id);
	    mav.addObject("package",Package);
	     
	    return mav;
	}
	
	@RequestMapping("/deletepackage/{id}")
	public String deletePackage(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/";       
	}
	
	

	

	
}
