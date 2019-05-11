package by.sobol.contact.book.project.service.factory;

import by.sobol.contact.book.project.service.ContactsService;
import by.sobol.contact.book.project.service.UserService;
import by.sobol.contact.book.project.service.impl.ContactsServiceImpl;
import by.sobol.contact.book.project.service.impl.UserServiceImpl;

public class ServiceFactory {

	public static UserService getUserService() {
		return new UserServiceImpl();
	}
	
	public static ContactsService getContactsService() {
		return new ContactsServiceImpl();
	}

}
