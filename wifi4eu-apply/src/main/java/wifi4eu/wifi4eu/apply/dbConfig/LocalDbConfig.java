package wifi4eu.wifi4eu.apply.dbConfig;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "localEntityManagerFactory", transactionManagerRef = "localTransactionManager", basePackages = {
		"wifi4eu.wifi4eu.apply.localEntity" })
public class LocalDbConfig {

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootServletInitializer.class);

	@Value("${wifi4eu.localdb.uri}")
	private String url;

	private String driver = "org.sqlite.JDBC";

	private String dialect = "wifi4eu.wifi4eu.apply.SQLiteDialect";

	@Primary
	@Bean(name = "localDataSource")
	public DataSource dataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(this.driver);
		dataSourceBuilder.url(this.url);

		DataSource ds = (DataSource) dataSourceBuilder.build();
		// TODO review ds.setConnectionTestQuery("SELECT 1");

		return ds;
	}

	@Primary
	@Bean(name = "localEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean localEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("localDataSource") DataSource dataSource) {

		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto", "none");
		// previously it was configured as "create", but it deletes the existing contents

		LocalContainerEntityManagerFactoryBean container = builder.dataSource(dataSource)
				.packages("wifi4eu.wifi4eu.apply.localEntity").persistenceUnit("local").properties(properties).build();

		return container;
	}

	@Primary
	@Bean(name = "localTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("localEntityManagerFactory") EntityManagerFactory localEntityManagerFactory) {
		return new JpaTransactionManager(localEntityManagerFactory);
	}
}