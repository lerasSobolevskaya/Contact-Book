package by.sobol.contact.book.project.web.action.impl;

import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ATTRIBUTE_LIST_CONTACTS;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.PAGE_LIST_CONTACTS_JSP;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ATTRIBUTE_USERS_CONTACTS;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.sobol.contact.book.project.domain.Contacts;
import by.sobol.contact.book.project.domain.User;
import by.sobol.contact.book.project.service.ContactsService;
import by.sobol.contact.book.project.service.factory.ServiceFactory;
import by.sobol.contact.book.project.web.action.ActionAssistant;
import by.sobol.contact.book.project.web.action.BaseAction;

public class LookListContactsImpl extends ActionAssistant implements BaseAction {

	private ContactsService contactsService = ServiceFactory.getContactsService();

	@Override
	public String chooseAction(HttpServletRequest request) {
		List<Contacts> contactsList = contactsService.getAllContacts();
		request.setAttribute(ATTRIBUTE_LIST_CONTACTS, contactsList);
		Map<Integer, User> contactsUsersMap = getUsersForContacts(contactsList);
		request.setAttribute(ATTRIBUTE_USERS_CONTACTS, contactsUsersMap);
		return PAGE_LIST_CONTACTS_JSP;
	}

}
