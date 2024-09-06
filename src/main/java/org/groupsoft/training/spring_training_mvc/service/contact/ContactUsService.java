package org.groupsoft.training.spring_training_mvc.service.contact;

import java.util.List;

import org.groupsoft.training.spring_training_mvc.model.contact.ContactUs;
import org.springframework.stereotype.Service;

@Service
public interface ContactUsService {
	ContactUs saveContactUs(ContactUs contactUs);

//	Optional<ContactUs> getContactUsById(UUID id);
//
	List<ContactUs> getAllContactUs();
//
//	void deleteContactUs(UUID id);
}
