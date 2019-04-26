package by.sobol.contact.book.project.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.sobol.contact.book.project.domain.Contacts;
import by.sobol.contact.book.project.domain.User;
import by.sobol.contact.book.project.service.ContactsService;
import by.sobol.contact.book.project.service.UserService;
import by.sobol.contact.book.project.service.factory.ServiceFactory;

public class ActionAssistant {

	private static ContactsService contactsService = ServiceFactory.getContactsService();
	private static UserService userService = ServiceFactory.getUserService();

	protected static Map<Integer, Contacts> getContactsForUsers(List<User> usersList) {
		Map<Integer, Contacts> userContactsMap = new HashMap<>();
		for (User user : usersList) {
			int contactId = user.getContactId();
			Contacts contact = contactsService.getContactById(contactId);
			userContactsMap.put(user.getId(), contact);
		}
		return userContactsMap;
	}

	protected static Map<Integer, User> getUsersForContacts(List<Contacts> contactsList) {
		Map<Integer, User> contactsUsersMap = new HashMap<>();
		for (Contacts contacts : contactsList) {
			int userId = contacts.getUser().getId();
			User user = userService.getUserById(userId);
			contactsUsersMap.put(contacts.getId(), user);
		}
		return contactsUsersMap;
	}
}
