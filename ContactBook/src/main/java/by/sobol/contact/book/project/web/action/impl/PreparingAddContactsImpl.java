package by.sobol.contact.book.project.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.sobol.contact.book.project.web.action.BaseAction;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.PAGE_FORM_ADD_CONTACTS_JSP;

public class PreparingAddContactsImpl implements BaseAction{
	
	@Override
	public String chooseAction(HttpServletRequest request) {
//		return PAGE_FORM_ADD_CONTACTS_JSP;
		return "/jsp/testCreate.jsp";
	}


}
