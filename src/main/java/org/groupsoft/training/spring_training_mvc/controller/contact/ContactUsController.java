package org.groupsoft.training.spring_training_mvc.controller.contact;

import java.util.List;

import org.groupsoft.training.spring_training_mvc.model.contact.ContactUs;
import org.groupsoft.training.spring_training_mvc.service.contact.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
@RequestMapping("/contact")
public class ContactUsController {

	@Autowired
	private ContactUsService contactUsService;

	@ModelAttribute
	public void commonDataForModel(Model model) {
		List<ContactUs> contacts = contactUsService.getAllContactUs();
		System.out.println(contacts);
		if (contacts != null) {
			model.addAttribute("contacts", contacts);
		}
	}

	@RequestMapping("/")
	public String home(Model model) {
		System.out.println("Contact Page");
		return "contact";
	}

	@RequestMapping(path = "/submitContact", method = RequestMethod.POST)
	public String submitContact(@ModelAttribute ContactUs contactus) {
		contactUsService.saveContactUs(contactus);
		return "redirect:/contact";
	}
}
