package pl.com.ak;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public final class JdbcTestConnSpringFactory {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void getRecords(final String sql) {
		jdbcTemplate.execute(sql);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
}