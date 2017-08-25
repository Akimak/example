package pl.com.ak.command;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import pl.com.ak.service.dto.ParamSqlCommandDTO;
import pl.com.ak.util.ConsolePrinter;
import pl.com.ak.util.DateUtil;
import pl.com.ak.util.FilePrinter;
import pl.com.ak.util.Printer;

public abstract class SqlCommand {
	
	public void run(final File destDir, final JdbcTemplate jdbcTemplate, final ParamSqlCommandDTO paramSqlCommand)
			throws SQLException, IOException {

		Assert.notNull(destDir);
		Assert.notNull(jdbcTemplate);
		Assert.notNull(paramSqlCommand);
		Assert.notNull(paramSqlCommand.getSql());

		final String sql = paramSqlCommand.getSql();
		final String fileName = paramSqlCommand.getFileName();
		final Printer printer = getPrinter(destDir, fileName);
		printer.println("sql:" + sql);
		runSql(printer, sql, jdbcTemplate);
	}

	abstract void runSql(Printer printer, String sql, JdbcTemplate jdbcTemplate) throws SQLException, IOException;

	private Printer getPrinter(final File destDir, final String fileName) throws IOException {
		if (StringUtils.isEmpty(fileName)) {
			return new ConsolePrinter();
		} else {
			return new FilePrinter(getSqlFileResult(destDir, fileName));
		}
	}

	private File getSqlFileResult(final File destDir, final String fileName) {
		final String fileNameWithDate = getFileWithDateTime(fileName);
		return new File(destDir, fileNameWithDate);
	}

	private String getFileWithDateTime(final String fileName) {
		return DateUtil.getDateTime() + "_" + fileName;
	}
}