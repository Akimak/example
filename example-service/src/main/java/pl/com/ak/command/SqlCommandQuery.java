package pl.com.ak.command;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.JdbcTemplate;

import pl.com.ak.util.Printer;

public class SqlCommandQuery extends SqlCommand {

	@Override
	void runSql(final Printer printer, final String sql, final JdbcTemplate jdbcTemplate)
			throws SQLException, IOException {

		try (final Statement stmt = jdbcTemplate.getDataSource().getConnection().createStatement()) {
			final ResultSet rs = stmt.executeQuery(sql);
			final ResultSetMetaData rsmd = rs.getMetaData();
			final int numberOfColumns = rsmd.getColumnCount();

			for (int i = 1; i <= numberOfColumns; i++) {
				if (i > 1) {
					printer.print(",  ");
				}
				final String columnName = rsmd.getColumnName(i);
				printer.print(columnName);
			}
			printer.println("");
			printColTypes(printer, rsmd);

			while (rs.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					if (i > 1) {
						printer.print(",  ");
					}
					final String columnValue = rs.getString(i);
					printer.print(columnValue);
				}
				printer.println("");
			}
		}
	}

	private void printColTypes(final Printer printer, final ResultSetMetaData rsmd) throws SQLException, IOException {
		final int columns = rsmd.getColumnCount();
		for (int i = 1; i <= columns; i++) {
			final int jdbcType = rsmd.getColumnType(i);
			final String name = rsmd.getColumnTypeName(i);
			printer.print("Column " + i + " is JDBC type " + jdbcType);
			printer.println(", which the DBMS calls " + name);
		}
	}
}
