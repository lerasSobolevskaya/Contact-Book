package by.sobol.contact.book.project.web.action;

import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.*;

import by.sobol.contact.book.project.web.action.impl.*;

public class ActionManager {

	private ActionManager() {
	}

	public static BaseAction determineAction(String action) {
		BaseAction act = null;
		switch (action) {
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
