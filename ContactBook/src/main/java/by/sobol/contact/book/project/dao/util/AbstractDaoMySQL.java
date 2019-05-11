package by.sobol.contact.book.project.dao.util;

public class AbstractDaoMySQL {

	public static final String ERROR_IN_POOL_DRIVER = "Driver not found in ConnectionPool.class ";
	public static final String ERROR_IN_POOL_DISCONENCT = "Connection is not in the usedConnections queue";

	protected static final String ERROR_IN_USER_DAO_GET_LIST = "Error in getList() method in UserDaoMySqlImpl.class ";
	protected static final String ERROR_IN_USER_DAO_CREATE = "Error in create() method in UserDaoMySqlImpl.class ";
	protected static final String ERROR_IN_USER_DAO_READ = "Error in read() method in UserDaoMySqlImpl.class  ";
	protected static final String ERROR_IN_USER_DAO_UPDATE = "Error in update() method in UserDaoMySqlImpl.class";
	protected static final String ERROR_IN_USER_DAO_DELETE = "Error in delete() method in UserDaoMySqlmplclass";
	protected static final String ERROR_IN_USER_DAO_CHECK_USER = "Error in checkRole() method in UserDaoMySqlmplclass";

	protected static final String ERROR_IN_CONTACTS_DAO_CREATE = "Error in create() method in ContactsDaoMySqlImpl.class";
	protected static final String ERROR_IN_CONTACTS_DAO_GET_LIST = "Error in getList() method in ContactsDaoMySqlImpl.class";
	protected static final String ERROR_IN_CONTACTS_DAO_UPDATE = "Error in update() method in ContactsDaoMySqlImpl.class";
	protected static final String ERROR_IN_CONTACTS_DAO_DELETE = "Error in delete() method in ContactsDaoMySqlImpl.class";
	protected static final String ERROR_IN_CONTACTS_DAO_READ = "Error in read() method in ContactsDaoMySqlImpl.class";

	protected static final String USER_ID = "user_id";
	protected static final String USER_NAME = "name";
	protected static final String USER_SURNAME = "surname";
	protected static final String USER_ROLE = "role";
	protected static final String USER_LOGIN = "login";
	protected static final String USER_PASSWORD = "password";
	protected static final String USER_PATRONYMIC = "patronymic";

	protected static final String CONTACT_ID = "contact_id";
	protected static final String CONTACT_EMAIL = "email";
	protected static final String CONTACT_PHONE = "phone";

	protected static final String INSERT_INTO_CONTACTS_USERS = "INSERT INTO contacts_users (user_id, contact_id) VALUES (?,?)";

	protected static final String SELECT_ALL_USERS = "SELECT user.user_id, user.name, user.surname, user.patronymic, user.role, user.login, user.password, contact.contact_id, contact.phone, contact.email, contact.user_id FROM users user LEFT OUTER JOIN contacts contact ON user.user_id=contact.user_id";
	protected static final String SELECT_USER_BY_ID = "SELECT user.user_id, user.name, user.surname, user.patronymic, user.role, user.login, user.password, contact.contact_id, contact.phone, contact.email, contact.user_id FROM users user LEFT OUTER JOIN contacts contact ON contact.user_id=contact.user_id WHERE user.user_id=?";
	protected static final String CREATE_USER = "INSERT INTO users (name, surname, role, login, password, patronymic) VALUES (?,?,?,?,?,?)";
	protected static final String UPDATE_USER = "UPDATE users SET name=?, surname=?, patronymic=? WHERE user_id=?";
	protected static final String DELETE_USER = "DELETE FROM users WHERE user_id=?";
	protected static final String SELECT_LOGIN_PASS = "SELECT user.user_id, user.name, user.surname, user.patronymic,  user.role, user.login, user.password, contact.email, contact.phone, contact.user_id FROM users user LEFT OUTER JOIN contacts contact ON user.user_id=contact.user_id WHERE login=? AND password=?";
	protected static final String SELECT_PASS = "SELECT name, surname, role, login, password FROM users WHERE login=? AND password=?";

	protected static final String SELECT_ALL_CONTACTS_TEST = "SELECT contact.contact_id, contact.email, contact.phone, contact.user_id, user.user_id, user.name, user.surname, user.patronymic, user.role, user.login, user.password FROM contacts contact LEFT OUTER JOIN users user ON contact.user_id=user.user_id";

	protected static final String SELECT_CONTACT_BY_ID = "SELECT contact.contact_id, contact.phone, contact.email,contact.user_id, user.user_id, user.name, user.surname, user.patronymic, user.role, user.login,user.password FROM contacts contact LEFT OUTER JOIN users user ON contact.user_id=user.user_id WHERE contact.contact_id = ?";
	protected static final String CREATE_CONTACT = "INSERT INTO contacts (phone, email, user_id) VALUES (?,?,?)";
	protected static final String UPDATE_CONTACT = "UPDATE contacts SET phone=?, email=? WHERE contact_id=?";
	protected static final String DELETE_CONTACT = "DELETE FROM contacts WHERE contact_id=?";
}
