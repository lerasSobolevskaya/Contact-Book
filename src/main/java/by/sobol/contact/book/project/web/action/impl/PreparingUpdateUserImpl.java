package by.sobol.contact.book.project.web.action.impl;

import static by.sobol.contact.book.project.web.action.util.HttpRequestParamFormator.formatInt;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.PAGE_FORM_UPDATE_USER;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.PARAM_USER_ID;

import javax.servlet.http.HttpServletRequest;

import by.sobol.contact.book.project.service.UserService;
import by.sobol.contact.book.project.service.factory.ServiceFactory;
import by.sobol.contact.book.project.web.action.BaseAction;

public class PreparingUpdateUserImpl implements BaseAction {

	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String chooseAction(HttpServletRequest request) {
		Integer userId = formatInt(request.getParameter(PARAM_USER_ID));
		userService.getUserById(userId);
		return PAGE_FORM_UPDATE_USER;
	}

}
