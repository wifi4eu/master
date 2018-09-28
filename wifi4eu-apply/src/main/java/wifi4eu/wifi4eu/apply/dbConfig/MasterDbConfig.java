package wifi4eu.wifi4eu.apply.dbConfig;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "masterEntityManagerFactory",
  transactionManagerRef = "masterTransactionManager",
  basePackages = { "wifi4eu.wifi4eu.apply.masterEntity" }
)
public class MasterDbConfig {
	
	@Value("${wifi4eu.masterdb.user}")
	private String user;

	@Value("${wifi4eu.masterdb.password}")
	private char[] password;
	
	@Value("${wifi4eu.masterdb.url}")
	private String masterDBUrl;

	@Value("${wifi4eu.masterdb.driver}")
	private String masterDBDriver;

	@Bean(name = "masterDataSource")
	public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(this.masterDBUrl);
        dataSourceBuilder.username(this.user);
        dataSourceBuilder.password(String.valueOf(this.password));
        dataSourceBuilder.url(this.masterDBUrl);
        
        DataSource ds = (DataSource) dataSourceBuilder.build(); 
        // TODO review ds.setConnectionTestQuery("SELECT 1");

        return ds;   
	}
	  
	@Bean(name = "masterEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("masterDataSource") DataSource dataSource) {
		
		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");

		LocalContainerEntityManagerFactoryBean container = builder.dataSource(dataSource)
				.packages("wifi4eu.wifi4eu.apply.masterEntity")
				.persistenceUnit("master")
				.properties(properties)
				.build();
		
		return container;
				
	}

	@Bean(name = "masterTransactionManager")
	public PlatformTransactionManager masterTransactionManager(@Qualifier("masterEntityManagerFactory") EntityManagerFactory
			masterEntityManagerFactory) {
		return new JpaTransactionManager(masterEntityManagerFactory);
	}	

}
