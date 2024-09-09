package org.groupsoft.training.spring_training_mvc.repository.contact;

import java.util.List;

import org.groupsoft.training.spring_training_mvc.exception.DatabaseException;
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
		try {
			int result = (int) this.hibernateTemplate.save(contactUs);
			if (result != 0) {
				return hibernateTemplate.get(ContactUs.class, contactUs.getId());
			}
		} catch (Exception ex) {
			DatabaseException.handleSQLException(ex, "Email already exists: " + contactUs.getEmail());
		}

		return null;
	}

	@Transactional(readOnly = true)
	public List<ContactUs> loadAll() {
		return (List<ContactUs>) hibernateTemplate.loadAll(ContactUs.class);
	}

}
