package by.sobol.contact.book.project.web.action;

import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.sobol.contact.book.project.domain.Contacts;
import by.sobol.contact.book.project.domain.User;
import by.sobol.contact.book.project.service.ContactsService;
import by.sobol.contact.book.project.service.UserService;
import by.sobol.contact.book.project.service.factory.ServiceFactory;

public class ActionAssistant {

	private static ContactsService contactsService = ServiceFactory.getContactsService();
	private static UserService userService = ServiceFactory.getUserService();

	protected static Map<Integer, Contacts> getContactsForUsers(List<User> listUsers) {
		Map<Integer, Contacts> userContactsMap = new HashMap<>();
		for (User user : listUsers) {
			int contactId = user.getContactId();
			Contacts contact = contactsService.getContactById(contactId);
			userContactsMap.put(user.getId(), contact);
		}
		return userContactsMap;
	}

	protected static Map<Integer, User> getUsersForContacts(List<Contacts> listContacts) {
		Map<Integer, User> contactsUsersMap = new HashMap<>();
		for (Contacts contacts : listContacts) {
			int userId = contacts.getUserId();
			User user = userService.getUserById(userId);
			contactsUsersMap.put(contacts.getId(), user);
		}
		return contactsUsersMap;
	}

	protected Map<String, String> getRequestContactsParams(HttpServletRequest request) {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put(PARAM_CONTACT_ID, request.getParameter(PARAM_CONTACT_ID));
		requestParams.put(PARAM_CONTACT_PHONE, request.getParameter(PARAM_CONTACT_PHONE));
		requestParams.put(PARAM_CONTACT_EMAIL, request.getParameter(PARAM_CONTACT_EMAIL));
		requestParams.put(PARAM_USER_ID, request.getParameter(PARAM_USER_ID));
		return requestParams;
	}

	protected Map<String, String> getRequestUserParams(HttpServletRequest request) {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put(PARAM_USER_ID, request.getParameter(PARAM_USER_ID));
		requestParams.put(PARAM_USER_NAME, request.getParameter(PARAM_USER_NAME));
		requestParams.put(PARAM_USER_SURNAME, request.getParameter(PARAM_USER_SURNAME));
		requestParams.put(PARAM_USER_PATRONYMIC, request.getParameter(PARAM_USER_PATRONYMIC));
		return requestParams;
	}

}
