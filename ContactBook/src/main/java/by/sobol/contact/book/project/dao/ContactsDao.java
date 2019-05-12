package by.sobol.contact.book.project.dao;

import by.sobol.contact.book.project.domain.Contacts;

public interface ContactsDao extends BaseDao<Contacts> {

	Contacts getInfoByPhoneNumber(String phoneNum);
	Contacts getInfoByEmail(String email);
	
}
