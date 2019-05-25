package by.sobol.contact.book.project.dao.util;

public class AbstractDaoMySQL {

	public static final String ERROR_IN_BASE_DAO_CLOSE_RESULT_SET = "Can't close ResultSet in closeResultSet(result) method in BaseDao.class";

	public static final String ERROR_IN_POOL_DRIVER = "Driver not found in ConnectionPool.class ";
	public static final String ERROR_IN_POOL_DISCONENCT = "Error in method disconnect(connection) in ConnetionPool.class";
	public static final String ERROR_IN_CREATE_CONN = "Error in method createConnection() in ConnetionPool.class";
	public static final String ERROR_IN_GET_CONNECT = "Error in method getConnect() in ConnetionPool.class";

	protected static final String ERROR_IN_USER_DAO_GET_LIST = "Error in getList() method in UserDaoMySqlImpl.class ";
	protected static final String ERROR_IN_USER_DAO_CREATE = "Error in create(user) method in UserDaoMySqlImpl.class ";
	protected static final String ERROR_IN_USER_DAO_READ = "Error in read(id) method in UserDaoMySqlImpl.class  ";
	protected static final String ERROR_IN_USER_DAO_UPDATE = "Error in update(user) method in UserDaoMySqlImpl.class";
	protected static final String ERROR_IN_USER_DAO_DELETE = "Error in delete(id) method in UserDaoMySqlmplclass";
	protected static final String ERROR_IN_USER_DAO_CHECK_USER = "Error in checkRole(userIn) method in UserDaoMySqlmplclass";

	protected static final String ERROR_IN_CONTACTS_DAO_CREATE = "Error in create(contact) method in ContactsDaoMySqlImpl.class";
	protected static final String ERROR_IN_CONTACTS_DAO_GET_LIST = "Error in getList() method in ContactsDaoMySqlImpl.class";
	protected static final String ERROR_IN_CONTACTS_DAO_UPDATE = "Error in update(contact) method in ContactsDaoMySqlImpl.class";
	protected static final String ERROR_IN_CONTACTS_DAO_DELETE = "Error in delete() method in ContactsDaoMySqlImpl.class";
	protected static final String ERROR_IN_CONTACTS_DAO_READ = "Error in read(id) method in ContactsDaoMySqlImpl.class";
	protected static final String ERROR_IN_CONTACTS_DAO_INFO_BY_EMAIL = "Error in getInfoByEmail(email) method in ContactsDaoMySqlImpl.class";
	protected static final String ERROR_IN_CONTACTS_DAO_INFO_BY_PHONE = "Error in getInfoByPhoneNumber(contactPhoneNum) method in ContactsDaoMySqlImpl.class";

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
	protected static final String GET_INFO_BY_PNONE_NUMBER = "SELECT contact.contact_id, contact.email, contact.phone, contact.user_id, user.user_id, user.name, user.surname, user.patronymic FROM contacts contact LEFT OUTER JOIN users user ON user.user_id=contact.user_id WHERE phone=?";
	protected static final String GET_INFO_BY_EMAIL = "SELECT contact.contact_id, contact.phone, contact.email, contact.user_id, user.user_id, user.name, user.surname, user.patronymic FROM contacts contact LEFT OUTER JOIN users user ON contact.user_id=user.user_id WHERE email=? ";

}
