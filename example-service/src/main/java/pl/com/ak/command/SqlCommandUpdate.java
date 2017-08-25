package pl.com.ak.command;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import pl.com.ak.util.Printer;

public class SqlCommandUpdate extends SqlCommand {

	@Override
	void runSql(final Printer printer, final String sql, final JdbcTemplate jdbcTemplate) throws SQLException, IOException {		
		final int i = jdbcTemplate.update(sql);
		printer.println("record affected: " + i);
	}
}
