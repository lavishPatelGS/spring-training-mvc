package org.groupsoft.training.spring_training_mvc.repository.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.groupsoft.training.spring_training_mvc.model.contact.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ContactUsRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public ContactUs save(ContactUs contactUs) {
		int result = (int) this.hibernateTemplate.save(contactUs);
		if (result != 0) {
			return hibernateTemplate.get(ContactUs.class, contactUs.getId());
		}
		return null;
	}

	@Transactional(readOnly = true)
	public List<ContactUs> loadAll() {
		return (List<ContactUs>) hibernateTemplate.loadAll(ContactUs.class);
	}

}
