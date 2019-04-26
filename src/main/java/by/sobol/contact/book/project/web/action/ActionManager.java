package by.sobol.contact.book.project.web.action;

import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.*;

import by.sobol.contact.book.project.web.action.impl.AddNewUserImpl;
import by.sobol.contact.book.project.web.action.impl.CheckRoleImpl;
import by.sobol.contact.book.project.web.action.impl.DeleteUserImpl;
import by.sobol.contact.book.project.web.action.impl.LookListContactsImpl;
import by.sobol.contact.book.project.web.action.impl.LookListUsersImpl;
import by.sobol.contact.book.project.web.action.impl.PreparingAddUserServiceImpl;
import by.sobol.contact.book.project.web.action.impl.PreparingCheckRoleImpl;
import by.sobol.contact.book.project.web.action.impl.PreparingUpdateUserImpl;
import by.sobol.contact.book.project.web.action.impl.UpdateInfoUserImpl;

public class ActionManager {

	private ActionManager() {
	}

	public static BaseAction determineAction(String action) {
		BaseAction act = null;
		switch (action) {
		case ACTION_LIST_USERS:
			act = new LookListUsersImpl();
			break;
		case ACTION_FORM_ADD_USER:
			act = new PreparingAddUserServiceImpl();
			break;
		case ACTION_FORM_AUTHENTICATION:
			act = new PreparingCheckRoleImpl();
			break;
		case ACTION_CHECK_ROLE:
			act = new CheckRoleImpl();
			break;
		case ACTION_SAVE_NEW_USER:
			act = new AddNewUserImpl();
			break;
		case ACTION_LIST_CONTACTS:
			act = new LookListContactsImpl();
			break;
		case ACTION_DELETE_USER:
			act = new DeleteUserImpl();
			break;
		case ACTION_FORM_UPDATE_USER:
			act = new PreparingUpdateUserImpl();
			break;
		case ACTION_SAVE_UPDATE_USER:
			act = new UpdateInfoUserImpl();
			break;
		}
		return act;
	}

}
