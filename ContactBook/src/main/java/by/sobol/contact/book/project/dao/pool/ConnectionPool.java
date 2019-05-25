package by.sobol.contact.book.project.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;
import static by.sobol.contact.book.project.dao.util.AbstractDaoMySQL.*;

public class ConnectionPool {

	private static final Logger LOG = Logger.getLogger(ConnectionPool.class);

	private static final int MAX_CONN_COUNT = 32;

	private static final String DB_CONFIG = "db_config";
	private static final String DB_LOGIN = "db.login";
	private static final String DB_URL = "db.url";
	private static final String DB_PASS = "db.password";
	private static final String DB_DRIVER = "db.driver";

	private static final ResourceBundle RB = ResourceBundle.getBundle(DB_CONFIG);
	private static final String URL = RB.getString(DB_URL);
	private static final String LOGIN = RB.getString(DB_LOGIN);
	private static final String DRIVER = RB.getString(DB_DRIVER);
	private static final String PASS = RB.getString(DB_PASS);

	private BlockingQueue<Connection> availableConnections = new ArrayBlockingQueue<Connection>(MAX_CONN_COUNT);
	private BlockingQueue<Connection> usedConnections = new ArrayBlockingQueue<Connection>(MAX_CONN_COUNT);

	private static ConnectionPool instance;

	public static ConnectionPool getInstance() {
		if (instance == null) {
			synchronized (ConnectionPool.class) {
				if (instance == null) {
					instance = new ConnectionPool();
				}
			}
		}
		return instance;
	}

	private ConnectionPool() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException ex) {
			LOG.error(ERROR_IN_POOL_DRIVER, ex);
		}
		fillPool();
	}

	private void fillPool() {
		for (int i = 0; i < MAX_CONN_COUNT; i++) {
			availableConnections.add(createConnection());
		}
	}

	public Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, LOGIN, PASS);
		} catch (SQLException ex) {
			LOG.error(ERROR_IN_CREATE_CONN, ex);
		}
		return connection;
	}

	public Connection getConnect() {
		Connection connect = null;
		if (!availableConnections.isEmpty()) {
			try {
				connect = availableConnections.take();
				usedConnections.add(connect);
			} catch (InterruptedException ex) {
				LOG.error(ERROR_IN_GET_CONNECT, ex);
			}
			return connect;
		}
		return null;
	}

	public void disconnect(Connection connection) {
		if (!usedConnections.isEmpty()) {
			if (usedConnections.remove(connection)) {
				availableConnections.add(connection);
			}
		} else {
			throw new NullPointerException(ERROR_IN_POOL_DISCONENCT);
		}
	}
}