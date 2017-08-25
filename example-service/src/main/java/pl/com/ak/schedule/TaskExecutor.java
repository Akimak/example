package pl.com.ak.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import pl.com.ak.service.RunSqlService;
import pl.com.ak.service.dto.ParamSqlServiceDTO;

public class TaskExecutor {

	private static final Logger log = LoggerFactory.getLogger(TaskExecutor.class);

	@Autowired
	private RunSqlService runSqlService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private ParamSqlServiceDTO parameterDTO;

	public void run () {
		log.info("Start TaskExecutor");
		runSqlService.runSqlService(parameterDTO, jdbcTemplate);
		log.info("Stop TaskExecutor");
	}

	public void setParameterDTOs(final ParamSqlServiceDTO parameterDTO) {
		this.parameterDTO = parameterDTO;
	}
	
	public void setRunSqlService(final RunSqlService runSqlService) {
		this.runSqlService = runSqlService;
	}

	public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}