package by.sobol.contact.book.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import by.sobol.contact.book.project.dao.UserDao;
import by.sobol.contact.book.project.dao.pool.ConnectionPool;
import by.sobol.contact.book.project.dao.util.AbstractDaoMySQL;
import by.sobol.contact.book.project.domain.User;

public class UserDaoMySqlImpl extends AbstractDaoMySQL implements UserDao {

//	static final Logger LOG = Logger.getLogger(UserDaoMySqlImpl.class);

	@Override
	public List<User> getList() {
		List<User> users = new ArrayList<>();
		Connection connection = ConnectionPool.getInstance().getConnect();
		ResultSet result = null;
		try (Statement statement = connection.createStatement()) {
			result = statement.executeQuery(SELECT_ALL_USERS);
			while (result.next()) {
				users.add(buildUser(result));
			}
		} catch (SQLException ex) {
//			LOG.error(ERROR_IN_USER_DAO_GET_LIST, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
			closeResultSet(result);
		}
		return users;
	}

	@Override
	public void create(User user) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		try (PreparedStatement preparedSt = connection.prepareStatement(CREATE_USER)) {
			preparedSt.setString(1, user.getName());
			preparedSt.setString(2, user.getSurname());
			preparedSt.setString(3, user.getRole());
			preparedSt.setString(4, user.getLogin());
			preparedSt.setString(5, user.getPassword());
//			prepareSt.setInt(2, user.getContactId());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
//			LOG.error(ERROR_IN_USER_DAO_CREATE, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
	}

	@Override
	public User read(int id) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		User user = new User();
		ResultSet result = null;
		try (PreparedStatement preparedSt = connection.prepareStatement(SELECT_USER_BY_ID)) {
			preparedSt.setInt(1, id);
			result = preparedSt.executeQuery();
			while (result.next()) {
				user = buildUser(result);
			}
		} catch (SQLException ex) {
//			LOG.error(ERROR_IN_USER_DAO_READ, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
		return user;
	}

	@Override
	public void update(User user) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		try (PreparedStatement preparedSt = connection.prepareStatement(UPDATE)) {
			preparedSt.setString(1, user.getName());
			preparedSt.setString(2, user.getSurname());
			preparedSt.setInt(3, user.getId());
			// prepareSt.setInt(2, user.getContactId());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
//			LOG.error(ERROR_IN_USER_DAO_UPDATE, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
	}

	@Override
	public void delete(int id) {
		Connection connection = ConnectionPool.getInstance().getConnect();
		try (PreparedStatement preparedSt = connection.prepareStatement(DELETE_USER)) {
			preparedSt.setInt(1, id);
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
//			LOG.error(ERROR_IN_USER_DAO_DELETE, ex);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
	}

	@Override
	public User authorization(User userIn) {
		User user = new User();
		Connection connection = ConnectionPool.getInstance().getConnect();
		ResultSet result = null;
		try (PreparedStatement preparedSt = connection.prepareStatement(SELECT_LOGIN_PASS)) {
			preparedSt.setString(1, userIn.getLogin());
			preparedSt.setString(2, userIn.getPassword());
			result = preparedSt.executeQuery();
			while (result.next()) {
				user = getUserForAuthorization(result);
			}
		} catch (SQLException ex) {
//			LOG.error(ERROR_IN_USER_DAO_CHECK_USER);
		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
		return user;

	}

	private User buildUser(ResultSet result) throws SQLException {
		User user = new User();
		user.setId(result.getInt(USER_ID));
		user.setName(result.getString(USER_NAME));
		user.setContactId(result.getInt(CONTACT_ID));
		user.setSurname(result.getString(USER_SURNAME));
		user.setRole(result.getString(USER_ROLE));
		user.setLogin(result.getString(USER_LOGIN));
		user.setPassword(result.getString(USER_PASSWORD));
		return user;
	}

	private User getUserForAuthorization(ResultSet result) throws SQLException {
		User user = new User();
		user.setId(result.getInt(USER_ID));
		user.setName(result.getString(USER_NAME));
		user.setSurname(result.getString(USER_SURNAME));
		user.setRole(result.getString(USER_ROLE));
		user.setLogin(result.getString(USER_LOGIN));
		user.setPassword(result.getString(USER_PASSWORD));
		return user;
	}

	@Override
	public int createUserTest(User user) {
		int id = 0;
		Connection connection = ConnectionPool.getInstance().getConnect();
		try (PreparedStatement prepareSt = connection.prepareStatement(CREATE_USER,
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			prepareSt.setString(1, user.getName());
			prepareSt.setString(2, user.getSurname());
			prepareSt.setString(3, user.getRole());
			prepareSt.setString(4, user.getLogin());
			prepareSt.setString(5, user.getPassword());
			prepareSt.executeUpdate();
			ResultSet resultSet = prepareSt.getGeneratedKeys();
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException ex) {

		} finally {
			ConnectionPool.getInstance().disconnect(connection);
		}
		return id;

	}
}
