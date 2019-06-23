package by.sobol.contact.book.project.web.action;

import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ACTION_CHECK_ROLE;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ACTION_DELETE_CONTACTS;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ACTION_FORM_ADD_CONTACTS;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ACTION_FORM_AUTHENTICATION;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ACTION_FORM_UPDATE_CONTACTS;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ACTION_GET_INFO_BY_EMAIL;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ACTION_GET_INFO_BY_PHONE_NUM;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ACTION_LIST_CONTACTS;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ACTION_SAVE_NEW_CONTACTS;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ACTION_SAVE_UPDATE_CONTACTS;

import by.sobol.contact.book.project.web.action.impl.AddNewContactsImpl;
import by.sobol.contact.book.project.web.action.impl.CheckRoleImpl;
import by.sobol.contact.book.project.web.action.impl.DeleteContactsImpl;
import by.sobol.contact.book.project.web.action.impl.GetInfoByEmailImpl;
import by.sobol.contact.book.project.web.action.impl.GetInfoByPhoneNumberImpl;
import by.sobol.contact.book.project.web.action.impl.LookListContactsImpl;
import by.sobol.contact.book.project.web.action.impl.PreparingAddContactsImpl;
import by.sobol.contact.book.project.web.action.impl.PreparingCheckRoleImpl;
import by.sobol.contact.book.project.web.action.impl.PreparingUpdateContactImpl;
import by.sobol.contact.book.project.web.action.impl.UpdateInfoContactsImpl;

public class ActionManager {

	private ActionManager() {
	}

	public static BaseAction determineAction(String action) {
		BaseAction act = null;
		switch (action) {
		case ACTION_GET_INFO_BY_EMAIL:
			act = new GetInfoByEmailImpl();
			break;
		case ACTION_GET_INFO_BY_PHONE_NUM:
			act = new GetInfoByPhoneNumberImpl();
			break;
		case ACTION_FORM_ADD_CONTACTS:
			act = new PreparingAddContactsImpl();
			break;
		case ACTION_SAVE_NEW_CONTACTS :
			act = new AddNewContactsImpl();
			break;
		case ACTION_DELETE_CONTACTS:
			act = new DeleteContactsImpl();
			break;
		case ACTION_FORM_UPDATE_CONTACTS:
			act = new PreparingUpdateContactImpl();
			break;
		case ACTION_SAVE_UPDATE_CONTACTS:
			act = new UpdateInfoContactsImpl();
			break;
		case ACTION_FORM_AUTHENTICATION:
			act = new PreparingCheckRoleImpl();
			break;
		case ACTION_CHECK_ROLE:
			act = new CheckRoleImpl();
			break;
		case ACTION_LIST_CONTACTS:
			act = new LookListContactsImpl();
			break;
		}
		return act;
	}

}
