package wifi4eu.wifi4eu.abac.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import wifi4eu.wifi4eu.abac.service.ImportDataService;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "wifi4eu.wifi4eu.abac.data.repository")
public class PersistenceConfig implements TransactionManagementConfigurer {

	private final Logger log = LoggerFactory.getLogger(PersistenceConfig.class);

	@Value("${spring.datasource.jndi-name}")
	private String dataSourceJNDIName;

	@Bean(name = "dataSource", destroyMethod = "")
	DataSource dataSource() {
		DataSource dataSource = null;
		JndiTemplate jndi = new JndiTemplate();
		try {
			dataSource = (DataSource) jndi.lookup(dataSourceJNDIName);
		} catch (NamingException e) {
			log.error("DataSource {} not found", dataSourceJNDIName);
			e.printStackTrace();
		}
		return dataSource;
	}

	@Bean(name = "entityManagerFactory")
	@DependsOn({ "dataSource" })
	EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("wifi4eu.wifi4eu.abac.data.entity");

		Properties jpaProperties = new Properties();

		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		jpaProperties.put("hibernate.hbm2ddl.auto", "none");
		jpaProperties.put("hibernate.show_sql", "false");
		jpaProperties.put("hibernate.format_sql", "true");

		jpaProperties.put("hibernate.id.new_generator_mappings", "false");
		jpaProperties.put("hibernate.generate_statistics", "false");
		jpaProperties.put("hibernate.bytecode.use_reflection_optimizer", "true");
		jpaProperties.put("hibernate.enable_lazy_load_no_trans", "true");

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		entityManagerFactoryBean.afterPropertiesSet();

		return entityManagerFactoryBean.getObject();
	}

	@Bean
	PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}
}
