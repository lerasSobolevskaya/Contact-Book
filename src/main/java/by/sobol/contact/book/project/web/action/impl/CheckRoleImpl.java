package by.sobol.contact.book.project.web.action.impl;

import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.*;
import static by.sobol.contact.book.project.web.action.util.RequestParamValidator.validateLoginAndPass;

import javax.servlet.http.HttpServletRequest;

import by.sobol.contact.book.project.domain.User;
import by.sobol.contact.book.project.service.UserService;
import by.sobol.contact.book.project.service.factory.ServiceFactory;
import by.sobol.contact.book.project.web.action.BaseAction;

public class CheckRoleImpl implements BaseAction {

	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String chooseAction(HttpServletRequest request) {
		String login = request.getParameter(PARAM_USER_LOGIN);
		String password = request.getParameter(PARAM_USER_PASSWORD);
		validateLoginAndPass(login, password);
		User user = userService.authorization(login, password);
		if (user != null) {
			if (user.getRole().equals(PARAM_USER_ROLE_ADMIN)) {
				return PAGE_ADMIN;
			}
		}

		return PAGE_INDEX;
	}

}
