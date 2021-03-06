package by.sobol.contact.book.project.web.action.impl;

import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.*;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.sobol.contact.book.project.domain.Contacts;
import by.sobol.contact.book.project.domain.User;
import by.sobol.contact.book.project.service.ContactsService;
import by.sobol.contact.book.project.service.factory.ServiceFactory;
import by.sobol.contact.book.project.web.action.ActionAssistant;
import by.sobol.contact.book.project.web.action.BaseAction;

public class AddNewContactsImpl extends ActionAssistant implements BaseAction {

	private ContactsService contactsService = ServiceFactory.getContactsService();

	@Override
	public String chooseAction(HttpServletRequest request) {
		Map<String, String> contactsParams = getRequestContactsParams(request);
		Map<String, String> userParams = getRequestUserParams(request);

		if (validateUserInputData(userParams, request)) {
			Contacts contacts = buildContact(contactsParams, buildUser(userParams, request), request);
			contactsService.addNewContact(contacts);

			List<Contacts> listContacts = contactsService.getAllContacts();
			request.setAttribute(ATTRIBUTE_LIST_CONTACTS, listContacts);
			Map<Integer, User> mapUsers = getUsersForContacts(listContacts);
			request.setAttribute(ATTRIBUTE_MAP_USERS, mapUsers);

			return PAGE_LIST_CONTACTS_JSP;
		}
		return PAGE_FORM_ADD_CONTACTS_JSP;

	}

	private User buildUser(Map<String, String> userParams, HttpServletRequest request) {
		User user = new User();
		user.setName(userParams.get(PARAM_USER_NAME));
		user.setSurname(userParams.get(PARAM_USER_SURNAME));
		user.setPatronymic(userParams.get(PARAM_USER_PATRONYMIC));
		return user;
	}

	private Contacts buildContact(Map<String, String> contactsParams, User user, HttpServletRequest request) {
		Contacts contacts = new Contacts();
		contacts.setPhone(contactsParams.get(PARAM_CONTACT_PHONE));
		contacts.setEmail(contactsParams.get(PARAM_CONTACT_EMAIL));
		contacts.setUser(user);
		return contacts;
	}
}
