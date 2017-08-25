package pl.com.ak.command;

import java.security.InvalidParameterException;

public final class SqlCommandFactory {

	private final static String SELECT = "SELECT";
	private final static String UPDATE = "UPDATE";
	private final static String INSERT = "INSERT";
	private final static String DELETE = "DELETE";
	private final static int startIndex = 0;
	private final static int stopIndex = 6;

	private SqlCommandFactory() {
	}

	public static SqlCommand createSqlCommand(final String sql) {
		final String sqlPrefix = getSqlPrefix(sql);
		switch (sqlPrefix) {
		case SELECT:
			return new SqlCommandQuery();
		case UPDATE:
		case INSERT:
		case DELETE:
			return new SqlCommandUpdate();
		default:
			throw new InvalidParameterException(sqlPrefix);
		}
	}

	private static String getSqlPrefix(final String sql) {
		return sql.trim().substring(startIndex, stopIndex).toUpperCase();
	}
}