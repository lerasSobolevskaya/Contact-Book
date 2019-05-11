package by.sobol.contact.book.project.web.action.impl;

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

public class AddNewContactsImpl extends ActionAssistant implements BaseAction {

	private ContactsService contactsService = ServiceFactory.getContactsService();
	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String chooseAction(HttpServletRequest request) {
		String phone = request.getParameter(PARAM_CONTACT_PHONE);
		String email = request.getParameter(PARAM_CONTACT_EMAIL);
		String name = request.getParameter(PARAM_USER_NAME);
		String surname = request.getParameter(PARAM_USER_SURNAME);
		String patronymic = request.getParameter(PARAM_USER_PATRONYMIC);
		
		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setPatronymic(patronymic);
		int newUser = userService.addNewUser(user);
		
		Contacts contacts = new Contacts();
		contacts.setPhone(phone);
		contacts.setEmail(email);
		contacts.setUserId(newUser);
		contactsService.addNewContact(contacts);

		List<Contacts> listContacts = contactsService.getAllContacts();
		request.setAttribute(ATTRIBUTE_LIST_CONTACTS, listContacts);
		Map<Integer, User> mapUsers = getUsersForContacts(listContacts);
		request.setAttribute(ATTRIBUTE_MAP_USERS, mapUsers);

		return PAGE_LIST_CONTACTS_JSP;
	}

}
