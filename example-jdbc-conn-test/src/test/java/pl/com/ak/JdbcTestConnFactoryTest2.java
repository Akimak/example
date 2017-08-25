package pl.com.ak;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.com.ak.JdbcTestConnSpringFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dataaccess-spring-config.xml" })
public class JdbcTestConnFactoryTest2 {

	@Autowired
	private JdbcTestConnSpringFactory jdbcTestConnSpringFactory;

	@Test
	@Ignore
	public void test() {
		try {
			jdbcTestConnSpringFactory.getRecords("SELECT * FROM EVENT");
		} catch (DataAccessException dataAccessException) {	
		}
	}

	public void setJdbcTestConnSpringFactory(final JdbcTestConnSpringFactory jdbcTestConnSpringFactory) {
		this.jdbcTestConnSpringFactory = jdbcTestConnSpringFactory;
	}
}
