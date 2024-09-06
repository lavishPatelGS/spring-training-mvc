package org.groupsoft.training.spring_training_mvc.service.contact;

import org.groupsoft.training.spring_training_mvc.model.contact.ContactUs;
import org.groupsoft.training.spring_training_mvc.repository.contact.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactUsServiceImpl implements ContactUsService {

	@Autowired
	private ContactUsRepository contactUsRepository;

	@Override
	public ContactUs saveContactUs(ContactUs contactUs) {
		try {
			ContactUs contact = contactUsRepository.save(contactUs);
			System.out.println(contact);
			return contact;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

//	@Override
//	public Optional<ContactUs> getContactUsById(UUID id) {
//		return contactUsRepository.findById(id);
//	}
//
	@Override
	public List<ContactUs> getAllContactUs() {
		return contactUsRepository.loadAll();
	}
//
//	@Override
//	public void deleteContactUs(UUID id) {
//		contactUsRepository.deleteById(id);
//	}
}
