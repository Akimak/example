package pl.com.ak.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import pl.com.ak.service.dto.ParamSqlServiceDTO;;

@Service
public class RunSqlService {

	@Autowired
	private RunSqlCommands runSqlCommands;

	private static final Logger log = LoggerFactory.getLogger(RunSqlService.class);

	public void runSqlService(final ParamSqlServiceDTO paramSqlServiceDTO, final JdbcTemplate jdbcTemplate) {
		Assert.notNull(paramSqlServiceDTO);
		Assert.notNull(jdbcTemplate);
		final Connection connection = getConnection(jdbcTemplate);
		Boolean autoCommit = null;
		try {
			synchronized (this) {
				autoCommit = connection.getAutoCommit();
				connection.setAutoCommit(false);
				runSqlCommands.start(paramSqlServiceDTO, jdbcTemplate);
				connection.commit();
			}
		} catch (final SQLException exception) {
			log.info("sqlException={}", exception);
			throw new RuntimeException(exception);
		} finally {
			try {
				if (autoCommit != null) {
					connection.setAutoCommit(autoCommit);
				}
				connection.close();
			} catch (final SQLException sqlException) {
				log.info("sqlException={}", sqlException);
				throw new RuntimeException(sqlException);
			}
		}
	}

	public void setRunSqlCommands(final RunSqlCommands runSqlCommands) {
		this.runSqlCommands = runSqlCommands;
	}

	private Connection getConnection(final JdbcTemplate jdbcTemplate) {
		Connection connection = null;
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
		} catch (final SQLException sqlException) {
			log.info("sqlException={}", sqlException);
			throw new RuntimeException(sqlException);
		}
		return connection;
	}
}