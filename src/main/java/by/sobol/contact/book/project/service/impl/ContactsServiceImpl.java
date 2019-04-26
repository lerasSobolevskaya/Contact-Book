package by.sobol.contact.book.project.service.impl;

import java.util.List;

import by.sobol.contact.book.project.dao.ContactsDao;
import by.sobol.contact.book.project.dao.factory.DaoFactory;
import by.sobol.contact.book.project.domain.Contacts;
import by.sobol.contact.book.project.service.ContactsService;

public class ContactsServiceImpl implements ContactsService {

	private ContactsDao contactsDao = DaoFactory.getContactsDao();

	@Override
	public List<Contacts> getAllContacts() {
		return contactsDao.getList();
	}

	@Override
	public void addNewContact(Contacts contact) {
		contactsDao.create(contact);
	}

	@Override
	public Contacts getContactById(int id) {
		return contactsDao.read(id);
	}

	@Override
	public void updateContactInfo(Contacts contact) {
		contactsDao.update(contact);
	}

	@Override
	public void deleteContact(int id) {
		contactsDao.delete(id);
	}

	@Override
	public void createContactTest(Contacts contact) {
		contactsDao.createContactTest(contact);
		
	}

}
