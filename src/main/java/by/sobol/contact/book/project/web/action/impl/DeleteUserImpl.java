package by.sobol.contact.book.project.web.action.impl;

import static by.sobol.contact.book.project.web.action.util.HttpRequestParamFormator.formatInt;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ATTRIBUTE_LIST_USERS;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.PAGE_LIST_USERS_JSP;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.PARAM_USER_ID;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ATTRIBUTE_CONTACTS_USERS;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.sobol.contact.book.project.domain.Contacts;
import by.sobol.contact.book.project.domain.User;
import by.sobol.contact.book.project.service.UserService;
import by.sobol.contact.book.project.service.factory.ServiceFactory;
import by.sobol.contact.book.project.web.action.ActionAssistant;
import by.sobol.contact.book.project.web.action.BaseAction;

public class DeleteUserImpl extends ActionAssistant implements BaseAction {

	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String chooseAction(HttpServletRequest request) {
		int id = formatInt(request.getParameter(PARAM_USER_ID));
		userService.deleteUser(id);
		List<User> users = userService.getAllUsers();
		request.setAttribute(ATTRIBUTE_LIST_USERS, users);
		Map<Integer, Contacts> userContactsMap = getContactsForUsers(users);
		request.setAttribute(ATTRIBUTE_CONTACTS_USERS, userContactsMap);
		return PAGE_LIST_USERS_JSP;
	}

}
