package by.sobol.contact.book.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.sobol.contact.book.project.dao.ContactsDao;
import by.sobol.contact.book.project.dao.pool.ConnectionPool;
import by.sobol.contact.book.project.dao.util.AbstractDaoMySQL;
import by.sobol.contact.book.project.domain.Contacts;
import by.sobol.contact.book.project.domain.User;

public class ContactsDaoMySqlImpl extends AbstractDaoMySQL implements ContactsDao {

//	public static final Logger LOG = Logger.getLogger(ContactsDaoMySqlImpl.class);

	@Override
	public List<Contacts> getList() {
		List<Contacts> contacts = new ArrayList<>();
		Connection connection = ConnectionPool.getInstance().getConnect();
		ResultSet result = null;
		try (Statement statement = connection.createStatement()) {
			result = statement.executeQuery(SELECT_ALL_CONTACTS_TEST);
			while (result.next()) {
				contacts.add(buildContacts(result));
			}
		} catch (SQLException ex) {
//			LOG.error(ERROR_IN_CONTACTS_DAO_GET_LIST);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
		return contacts;
	}

	@Override
	public void create(Contacts contact) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		try (PreparedStatement preparedSt = connection.prepareStatement(CREATE_CONTACT)) {
			preparedSt.setString(1, contact.getPhone());
			preparedSt.setString(2, contact.getEmail());
			preparedSt.setObject(3, contact.getUser());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
//			LOG.error(ERROR_IN_CONTACTS_DAO_CREATE);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
	}

	@Override
	public Contacts read(int id) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		Contacts contact = new Contacts();
		ResultSet result = null;
		try (PreparedStatement preparedSt = connection.prepareStatement(SELECT_CONTACT_BY_ID)) {
			preparedSt.setInt(1, id);
			result = preparedSt.executeQuery();
			while (result.next()) {
				contact = buildContacts(result);
			}
		} catch (SQLException ex) {
//			LOG.error(ERROR_IN_CONTACTS_DAO_READ, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
		return contact;
	}

	@Override
	public void update(Contacts contact) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		try (PreparedStatement preparedSt = connection.prepareStatement(UPDATE_CONTACT)) {
			preparedSt.setString(1, contact.getEmail());
			preparedSt.setString(2, contact.getPhone());
			preparedSt.setInt(3, contact.getId());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
//			LOG.error(ERROR_IN_CONTACTS_DAO_UPDATE, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
	}

	@Override
	public void delete(int id) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		try (PreparedStatement preparedSt = connection.prepareStatement(DELETE_CONTACT)) {
			preparedSt.setInt(1, id);
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
//			LOG.error(ERROR_IN_CONTACTS_DAO_DELETE, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
	}

	private Contacts buildContacts(ResultSet result) throws SQLException {
		Contacts contacts = new Contacts();
		contacts.setId(result.getInt(CONTACT_ID));
		contacts.setEmail(result.getString(CONTACT_EMAIL));
		contacts.setPhone(result.getString(CONTACT_PHONE));
		contacts.setUser(new User(result.getInt(USER_ID)));
		return contacts;
	}

	@Override
	public int createContactTest(Contacts contact) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		int id = 0;
		try (PreparedStatement prepareSt = connection.prepareStatement(CREATE_CONTACT,
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			prepareSt.setString(1, contact.getPhone());
			prepareSt.setString(2, contact.getEmail());
			prepareSt.setObject(3, contact.getUserId());
			prepareSt.executeUpdate();
			ResultSet resultSet = prepareSt.getGeneratedKeys();
			while (resultSet.next()) {
				id = resultSet.getInt(0);
			}
		} catch (SQLException ex) {

		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
		return id;
	}

}
