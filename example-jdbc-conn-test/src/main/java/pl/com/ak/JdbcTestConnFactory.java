package pl.com.ak;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JdbcTestConnFactory {

	private static final Logger log = Logger.getLogger(JdbcTestConnFactory.class);
	private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static final String URL_BASE = "jdbc:postgresql://localhost:5432/monitoring";
	private static final String USERNAME = "monitoring";
	private static final String PASSWORD = "monitoring";

	private JdbcTestConnFactory() {
	}

	public static Connection newConnection() throws SQLException {
		return newConnection(URL_BASE);
	}

	public static Connection newConnection(final String urlBase) throws SQLException {
		Assert.state(StringUtils.isNotEmpty(urlBase));
		return getConnection(urlBase);
	}

	private static Connection getConnection(final String urlBase) {
		final String url = URL_BASE;
		final String username = USERNAME;
		final String password = PASSWORD;
		try {
			Class.forName(DRIVER_CLASS_NAME);
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			log.error("error={}", e);
		}
		return null;
	}
}
