package by.sobol.contact.book.project.web.action;

import static by.sobol.contact.book.project.web.action.util.RequestParamValidator.*;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.sobol.contact.book.project.domain.Contacts;
import by.sobol.contact.book.project.domain.User;
import by.sobol.contact.book.project.resources.Resources;
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

	protected boolean validateContactInputData(Map<String, String> requestParams, HttpServletRequest request) {
		boolean result = true;
		if (!validatePhoneNumber(requestParams.get(PARAM_CONTACT_PHONE))) {
			request.setAttribute(INVALID_CONTACT_PHONE_NUM, Resources.getMessage(INVALID_CONTACT_PHONE_NUM, request));
			result = false;
		} else {
			request.setAttribute(PARAM_CONTACT_PHONE, requestParams.get(PARAM_CONTACT_PHONE));
		}
		if (!validateEmail(requestParams.get(PARAM_CONTACT_EMAIL))) {
			request.setAttribute(INVALID_CONTACT_EMAIL, Resources.getMessage(INVALID_CONTACT_EMAIL, request));
			result = false;
		} else {
			request.setAttribute(PARAM_CONTACT_EMAIL, requestParams.get(PARAM_CONTACT_EMAIL));
		}
		return result;
	}

	protected boolean validateInputPhoneNum(String phone, HttpServletRequest request) {
		boolean result = true;
		Contacts contacts = new Contacts();
		phone = request.getParameter(PARAM_CONTACT_PHONE);
		if (!phone.equals(contacts.getPhone())) {
			request.setAttribute(CONTACT_PHONE_NUM_DONT_EXIST,
					Resources.getMessage(CONTACT_PHONE_NUM_DONT_EXIST, request));
		}
		if (!validatePhoneNumber(phone)) {
			request.setAttribute(INVALID_CONTACT_PHONE_NUM, Resources.getMessage(INVALID_CONTACT_PHONE_NUM, request));
		} else {
			request.setAttribute(PARAM_CONTACT_PHONE, phone);
		}
		return result;
	}

	protected boolean validateInputEmail(String email, HttpServletRequest request) {
		email = request.getParameter(PARAM_CONTACT_EMAIL);
		boolean result = true;
		if (validateEmail(email)) {
			request.setAttribute(INVALID_CONTACT_EMAIL, Resources.getMessage(INVALID_CONTACT_EMAIL, request));
		} else {
			request.setAttribute(PARAM_CONTACT_EMAIL, email);
		}
		return result;
	}

	protected boolean validateUserInputData(Map<String, String> requestParams, HttpServletRequest request) {
		boolean result = true;
		if (!validateUserName(requestParams.get(PARAM_USER_NAME))) {
			request.setAttribute(INVALID_USER_NAME, Resources.getMessage(INVALID_USER_NAME, request));
			result = false;
		} else {
			request.setAttribute(PARAM_USER_NAME, requestParams.get(PARAM_USER_NAME));
		}
		if (!validateUserSurname(requestParams.get(PARAM_USER_SURNAME))) {
			request.setAttribute(INVALID_USER_SURNAME, Resources.getMessage(INVALID_USER_SURNAME, request));
			result = false;
		} else {
			request.setAttribute(PARAM_USER_SURNAME, requestParams.get(PARAM_USER_SURNAME));
		}
		if (!validateUserPatronymic(requestParams.get(PARAM_USER_PATRONYMIC))) {
			request.setAttribute(INVALID_USER_PATRONYMIC, Resources.getMessage(INVALID_USER_PATRONYMIC, request));
			result = false;
		} else {
			request.setAttribute(PARAM_USER_PATRONYMIC, requestParams.get(PARAM_USER_PATRONYMIC));
		}
		return result;
	}

	protected static boolean verifyPhoneNumber(String phoneNum) {
		Contacts contacts = contactsService.getInfoByPhoneNumber(phoneNum);
		if (phoneNum.equals(contacts.getPhone())) {
			return true;
		} else {
			return false;
		}
	}

	protected static boolean verifyEmail(String email) {
		Contacts emailFromDB = contactsService.getInfoByEmail(email);
		if (email.equals(emailFromDB.getEmail())) {
			return true;
		} else {
			return false;
		}
	}
}
