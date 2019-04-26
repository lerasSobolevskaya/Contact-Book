package by.sobol.contact.book.project.web.action.util;

public class WebControllerConstantPool {

	public static final String REAUEST_PARAM_COMMAND = "command";

	public static final String ACTION_LIST_USERS = "listUsers";
	public static final String ACTION_FORM_ADD_USER = "formAddUser";
	public static final String ACTION_FORM_AUTHENTICATION = "formAuthentication";
	public static final String ACTION_CHECK_ROLE = "checkRole";
	public static final String ACTION_SAVE_NEW_USER = "saveNewUser";
	public static final String ACTION_LIST_CONTACTS = "listContacts";
	public static final String ACTION_DELETE_USER = "deleteUser";
	public static final String ACTION_FORM_UPDATE_USER = "formUpdateUser";
	public static final String ACTION_SAVE_UPDATE_USER= "saveUserUpdate";

	public static final String ATTRIBUTE_LIST_USERS = "listUsers";
	public static final String ATTRIBUTE_CONTACTS_USERS = "userContacts";
	public static final String ATTRIBUTE_LIST_CONTACTS= "listContacts";
	public static final String ATTRIBUTE_USERS_CONTACTS = "contactsUsers";

	public static final String PAGE_START_PAGE = "/jsp/startPage.jsp";
	public static final String PAGE_FORM_ADD_USER = "/jsp/admin/formAddUser.jsp";
	public static final String PAGE_FORM_UPDATE_USER = "/jsp/admin/formUpdateUser.jsp";

	public static final String PARAM_USER_LOGIN = "login";
	public static final String PARAM_USER_PASSWORD = "password";
	public static final String PARAM_USER_ROLE_ADMIN = "admin";
	public static final String PARAM_USER_SURNAME = "surname";
	public static final String PARAM_USER_NAME = "name";
	public static final String PARAM_USER_ID = "user_id";

	public static final String PARAM_CONTACT_ID = "contact_id";
	public static final String PARAM_CONTACT_EMAIL = "email";
	public static final String PARAM_CONTACT_PHONE = "phone";

	public static final String PAGE_LIST_USERS_JSP = "/jsp/admin/listUsers.jsp";
	public static final String PAGE_ADMIN = "/jsp/admin/admin.jsp";
	public static final String PAGE_INDEX = "index.jsp";
	public static final String PAGE_AUTHORIZATION_FORM = "/jsp/admin/authorizationForm.jsp";
	public static final String PAGE_LIST_CONTACTS_JSP = "/jsp/admin/listContacts.jsp";
}
