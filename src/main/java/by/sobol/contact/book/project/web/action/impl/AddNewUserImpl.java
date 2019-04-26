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

public class AddNewUserImpl extends ActionAssistant implements BaseAction {

	private UserService userService = ServiceFactory.getUserService();
	private ContactsService contactsServiice = ServiceFactory.getContactsService();

	@Override
	public String chooseAction(HttpServletRequest request) {
		String name = request.getParameter(PARAM_USER_NAME);
		String surname = request.getParameter(PARAM_USER_SURNAME);
		String email = request.getParameter(PARAM_CONTACT_EMAIL);
		String phone = request.getParameter(PARAM_CONTACT_PHONE);

		
		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		int id = userService.createUserTest(user);
		

		Contacts contacts = new Contacts();
		contacts.setEmail(email);
		contacts.setPhone(phone);
		contacts.setUserId(id);

		contactsServiice.createContactTest(contacts);

		List<User> users = userService.getAllUsers();
		request.setAttribute(ATTRIBUTE_LIST_USERS, users);
		Map<Integer, Contacts> userContactsMap = getContactsForUsers(users);
		request.setAttribute(ATTRIBUTE_CONTACTS_USERS, userContactsMap);
		return PAGE_LIST_USERS_JSP;
	}

}
