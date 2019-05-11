package by.sobol.contact.book.project.dao.factory;

import by.sobol.contact.book.project.dao.ContactsDao;
import by.sobol.contact.book.project.dao.UserDao;
import by.sobol.contact.book.project.dao.impl.ContactsDaoMySqlImpl;
import by.sobol.contact.book.project.dao.impl.UserDaoMySqlImpl;

public class DaoFactory {

	public static UserDao getUserDao() {
		return new UserDaoMySqlImpl();

	}

	public static ContactsDao getContactsDao() {
		return new ContactsDaoMySqlImpl();
	}

}
