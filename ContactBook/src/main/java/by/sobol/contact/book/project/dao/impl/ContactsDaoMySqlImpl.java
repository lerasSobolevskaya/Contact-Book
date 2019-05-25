package by.sobol.contact.book.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.sobol.contact.book.project.dao.ContactsDao;
import by.sobol.contact.book.project.dao.pool.ConnectionPool;
import by.sobol.contact.book.project.dao.util.AbstractDaoMySQL;
import by.sobol.contact.book.project.domain.Contacts;

public class ContactsDaoMySqlImpl extends AbstractDaoMySQL implements ContactsDao {

	public static final Logger LOG = Logger.getLogger(ContactsDaoMySqlImpl.class);

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
			LOG.error(ERROR_IN_CONTACTS_DAO_GET_LIST);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
			closeResultSet(result);
		}
		return contacts;
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
			LOG.error(ERROR_IN_CONTACTS_DAO_READ, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
			closeResultSet(result);
		}
		return contact;
	}

	@Override
	public Contacts getInfoByPhoneNumber(String contactPhoneNum) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		ResultSet result = null;
		Contacts infoByContact = new Contacts();
		try (PreparedStatement prepareSt = connection.prepareStatement(GET_INFO_BY_PNONE_NUMBER)) {
			prepareSt.setString(1, contactPhoneNum);
			result = prepareSt.executeQuery();
			while (result.next()) {
				infoByContact = buildContacts(result);
			}
		} catch (SQLException ex) {
			LOG.error(ERROR_IN_CONTACTS_DAO_INFO_BY_PHONE, ex);
			closeResultSet(result);
		}
		return infoByContact;
	}

	@Override
	public void update(Contacts contact) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		try (PreparedStatement preparedSt = connection.prepareStatement(UPDATE_CONTACT)) {
			preparedSt.setString(1, contact.getPhone());
			preparedSt.setString(2, contact.getEmail());
			preparedSt.setInt(3, contact.getId());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			LOG.error(ERROR_IN_CONTACTS_DAO_UPDATE, ex);
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
			LOG.error(ERROR_IN_CONTACTS_DAO_DELETE, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
	}

	@Override
	public int create(Contacts contact) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		ResultSet result = null;
		int id = 0;
		try (PreparedStatement prepareSt = connection.prepareStatement(CREATE_CONTACT,
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			prepareSt.setString(1, contact.getPhone());
			prepareSt.setString(2, contact.getEmail());
			prepareSt.setInt(3, contact.getUserId());
			prepareSt.executeUpdate();
			result = prepareSt.getGeneratedKeys();
			while (result.next()) {
				id = result.getInt(0);
			}
		} catch (SQLException ex) {
			LOG.error(ERROR_IN_CONTACTS_DAO_CREATE, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
			closeResultSet(result);
		}
		return id;
	}

	@Override
	public Contacts getInfoByEmail(String email) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		Contacts infoByEmail = new Contacts();
		ResultSet result = null;
		try (PreparedStatement prepareSt = connection.prepareStatement(GET_INFO_BY_EMAIL)) {
			prepareSt.setString(1, email);
			result = prepareSt.executeQuery();
			while (result.next()) {
				infoByEmail = buildContacts(result);
			}
		} catch (SQLException ex) {
			LOG.error(ERROR_IN_CONTACTS_DAO_INFO_BY_EMAIL, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
			closeResultSet(result);
		}

		return infoByEmail;
	}

	private Contacts buildContacts(ResultSet result) throws SQLException {
		Contacts contacts = new Contacts();
		contacts.setId(result.getInt(CONTACT_ID));
		contacts.setEmail(result.getString(CONTACT_EMAIL));
		contacts.setPhone(result.getString(CONTACT_PHONE));
		contacts.setUserId(result.getInt(USER_ID));
		return contacts;
	}
}
