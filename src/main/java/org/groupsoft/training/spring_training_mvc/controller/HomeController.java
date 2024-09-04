package org.groupsoft.training.spring_training_mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		String userName = System.getProperty("user.name");
		model.addAttribute("userName", userName);
		
		Map<String, String> navLinks = new HashMap<>();
		navLinks.put("Home", "home.jsp");
		navLinks.put("Sign In", "signin.jsp");
		navLinks.put("Sign Up", "signup.jsp");
		model.addAttribute("navLinks", navLinks);

		Map<String, String> sideBarLinks = new HashMap<>();
		sideBarLinks.put("Profile", "welcome.jsp");
		sideBarLinks.put("About Us", "aboutus.jsp");
		sideBarLinks.put("Terms & Conditions", "terms.jsp");
		sideBarLinks.put("Contact Us", "contact.jsp");
		model.addAttribute("sideBarLinks", sideBarLinks);

		System.out.println("Home Page");
		return "welcome";
	}

	@RequestMapping("/welcome")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		String userName = System.getProperty("user.name");
		model.addObject("userName", userName);
		
		Map<String, String> navLinks = new HashMap<>();
		navLinks.put("Home", "home.jsp");
		navLinks.put("Sign In", "signin.jsp");
		navLinks.put("Sign Up", "signup.jsp");
		model.addObject("navLinks", navLinks);

		Map<String, String> sideBarLinks = new HashMap<>();
		sideBarLinks.put("Profile", "welcome.jsp");
		sideBarLinks.put("About Us", "aboutus.jsp");
		sideBarLinks.put("Terms & Conditions", "terms.jsp");
		sideBarLinks.put("Contact Us", "contact.jsp");
		model.addObject("sideBarLinks", sideBarLinks);

		System.out.println("Home Page");
		model.setViewName("welcome");
		return model;
	}

}
