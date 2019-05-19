package by.sobol.contact.book.project.web.action.impl;

import static by.sobol.contact.book.project.web.action.util.HttpRequestParamFormator.formatInt;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ATTRIBUTE_LIST_CONTACTS;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ATTRIBUTE_MAP_USERS;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.PAGE_LIST_CONTACTS_JSP;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.PARAM_USER_ID;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.sobol.contact.book.project.domain.Contacts;
import by.sobol.contact.book.project.domain.User;
import by.sobol.contact.book.project.service.ContactsService;
import by.sobol.contact.book.project.service.UserService;
import by.sobol.contact.book.project.service.factory.ServiceFactory;
import by.sobol.contact.book.project.web.action.ActionAssistant;
import by.sobol.contact.book.project.web.action.BaseAction;

public class DeleteContactsImpl extends ActionAssistant implements BaseAction {

	private ContactsService contactsService = ServiceFactory.getContactsService();
	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String chooseAction(HttpServletRequest request) {
		Contacts contacts  = new Contacts();
		int id = formatInt(request.getParameter(PARAM_USER_ID));
		contacts.setUserId(id);
		userService.deleteUser(id);

		List<Contacts> listContacts = contactsService.getAllContacts();
		request.setAttribute(ATTRIBUTE_LIST_CONTACTS, listContacts);
		Map<Integer, User> mapUsers = getUsersForContacts(listContacts);
		request.setAttribute(ATTRIBUTE_MAP_USERS, mapUsers);
		return PAGE_LIST_CONTACTS_JSP;
	}

}
