package org.springframework.data.jpa.showcase;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Oliver Gierke
 */
@ContextConfiguration
@Transactional
public abstract class AbstractShowcaseTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Configuration
	@EnableAutoConfiguration
	@ComponentScan
	static class TestConfig {

	}

	@BeforeTransaction
	public void setupData() throws Exception {

		deleteFromTables("account", "customer");
		executeSqlScript("classpath:data.sql", false);
	}
}
