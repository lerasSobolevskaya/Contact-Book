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

public class GetInfoByPhoneNumberImpl extends ActionAssistant implements BaseAction {

	private static ContactsService contactsService = ServiceFactory.getContactsService();

	@Override
	public String chooseAction(HttpServletRequest request) {
		String phone = request.getParameter(PARAM_CONTACT_PHONE);

		if (validateInputPhoneNum(phone, request)) {
			if (!verifyPhoneNumber(phone)) {
				return PAGE_START_PAGE_JSP;
			}
		}
		Contacts contacts = contactsService.getInfoByPhoneNumber(phone);
		request.setAttribute(ATTRIBUTE_CONTACTS, contacts);
		List<Contacts> listContacts = contactsService.getAllContacts();
		Map<Integer, User> mapUsers = getUsersForContacts(listContacts);
		request.setAttribute(ATTRIBUTE_MAP_USERS, mapUsers);
		return PAGE_INFO_BY_PHONE_NUM_JSP;

	}

}
