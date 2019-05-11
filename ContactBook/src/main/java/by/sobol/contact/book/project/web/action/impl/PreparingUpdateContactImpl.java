package by.sobol.contact.book.project.web.action.impl;

import static by.sobol.contact.book.project.web.action.util.HttpRequestParamFormator.formatInt;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.*;
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

public class PreparingUpdateContactImpl extends ActionAssistant implements BaseAction {

	private ContactsService contactsService = ServiceFactory.getContactsService();
	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String chooseAction(HttpServletRequest request) {
		int contactId = formatInt(request.getParameter(PARAM_CONTACT_ID));
	
		Contacts contact = contactsService.getContactById(contactId);
		request.setAttribute(ATTRIBUTE_CONTACTS, contact);
		User user = userService.getUserById(contact.getUserId());
		request.setAttribute("user", user);
		
		List<Contacts> listContacts = contactsService.getAllContacts();
		Map<Integer, User> mapUsers = getUsersForContacts(listContacts);
		request.setAttribute(ATTRIBUTE_MAP_USERS, mapUsers);
		
		return PAGE_FORM_UPDATE_CONTACT_JSP;
	}

}
