package wifi4eu.wifi4eu.apply.dbConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
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
@EnableJpaRepositories(
	entityManagerFactoryRef = "localEntityManagerFactory",
	transactionManagerRef = "localTransactionManager",
	basePackages = { "wifi4eu.wifi4eu.apply.localEntity" }
)
public class LocalDbConfig {
	
    @Value( "${wifi4eu.localdb.url}" )
	private String localdbUrl;

	@Primary
	@Bean(name = "localDataSource")
	public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        dataSourceBuilder.url(this.localdbUrl);
        
        return dataSourceBuilder.build();   
	}

	@Primary
	@Bean(name = "localEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean localEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("localDataSource") DataSource dataSource) {
		
		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "create-drop");
		properties.put("hibernate.dialect", "wifi4eu.wifi4eu.apply.SQLiteDialect");

		LocalContainerEntityManagerFactoryBean container = builder.dataSource(dataSource)
				.packages("wifi4eu.wifi4eu.apply.localEntity")
				.persistenceUnit("local")
				.properties(properties)
				.build();
		
		return container;
	}

	@Primary
	@Bean(name = "localTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("localEntityManagerFactory") EntityManagerFactory 
			localEntityManagerFactory) {
		return new JpaTransactionManager(localEntityManagerFactory);
	}


}
