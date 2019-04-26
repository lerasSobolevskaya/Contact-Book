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
import static by.sobol.contact.book.project.web.action.util.HttpRequestParamFormator.formatInt;

public class UpdateInfoUserImpl extends ActionAssistant implements BaseAction {

	private UserService userService = ServiceFactory.getUserService();
	private ContactsService contactsService = ServiceFactory.getContactsService();

	@Override
	public String chooseAction(HttpServletRequest request) {
		int userId = formatInt(request.getParameter(PARAM_USER_ID));
		int contactId = formatInt(request.getParameter(PARAM_CONTACT_ID));
		String name = request.getParameter(PARAM_USER_NAME);
		String surname = request.getParameter(PARAM_USER_SURNAME);
		String email = request.getParameter(PARAM_CONTACT_EMAIL);
		String phone = request.getParameter(PARAM_CONTACT_PHONE);
		
		User user = new User();
		user.setId(userId);
		user.setName(name);
		user.setSurname(surname);
		userService.updateInfoUser(user);

		Contacts contact = new Contacts();
		contact.setId(contactId);
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setUserId(userId);
		contactsService.updateContactInfo(contact);

		List<User> users = userService.getAllUsers();
		request.setAttribute(ATTRIBUTE_LIST_USERS, users);
		Map<Integer, Contacts> mapContacts = getContactsForUsers(users);
		request.setAttribute(ATTRIBUTE_CONTACTS_USERS, mapContacts);
		return PAGE_LIST_USERS_JSP;
	}

}
