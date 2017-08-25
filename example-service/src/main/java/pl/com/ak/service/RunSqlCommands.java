package pl.com.ak.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import pl.com.ak.command.SqlCommand;
import pl.com.ak.command.SqlCommandFactory;
import pl.com.ak.service.dto.ParamSqlCommandDTO;
import pl.com.ak.service.dto.ParamSqlServiceDTO;

@Service
public class RunSqlCommands {

	private static final Logger log = LoggerFactory.getLogger(RunSqlCommands.class);

	public void start(final ParamSqlServiceDTO paramSqlServiceDTO, final JdbcTemplate jdbcTemplate)
			throws SQLException {
		final String destDir = paramSqlServiceDTO.getDestDir();
		final File file = new File(destDir);
		for (final ParamSqlCommandDTO paramSqlCommandDTO : paramSqlServiceDTO.getParamSqlCommDTOs()) {
			runSqlCommand(file, jdbcTemplate, paramSqlCommandDTO);
		}
	}

	private void runSqlCommand(final File destDir, final JdbcTemplate jdbcTemplate,
			final ParamSqlCommandDTO paramSqlCommandDTO) throws SQLException {
		final String sql = paramSqlCommandDTO.getSql();
		final SqlCommand sqlCommand = SqlCommandFactory.createSqlCommand(sql);
		try {
			sqlCommand.run(destDir, jdbcTemplate, paramSqlCommandDTO);
		} catch (final IOException e) {
			log.info("IOException={}", e);
			throw new RuntimeException(e);
		}
	}
}