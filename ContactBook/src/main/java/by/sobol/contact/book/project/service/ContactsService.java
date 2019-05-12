package by.sobol.contact.book.project.service;

import java.util.List;

import by.sobol.contact.book.project.domain.Contacts;

public interface ContactsService {

	List<Contacts> getAllContacts();

	int addNewContact(Contacts contact);

	Contacts getContactById(int id);

	void updateContactInfo(Contacts contact);

	void deleteContact(int id);

	Contacts getInfoByPhoneNumber(String contactPhoneNum);
	
	Contacts getInfoByEmail(String email);

}
