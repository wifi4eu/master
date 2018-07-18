package wifi4eu.wifi4eu.abac;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import wifi4eu.wifi4eu.abac.repository.LegalEntityRepository;

/*
 * @ ComponentScan
 * @ SpringBootApplication
 * @ EnableJpaRepositories(basePackageClasses = LegalEntityRepository.class)
 * @ EntityScan(basePackageClasses = LegalEntity.class)
 */

public class SpringRestConfiguration {
}

/*
@Configuration
@EnableWebMvc
@ComponentScan("wifi4eu.wifi4eu.abac")
// @ EnableJpaRepositories(basePackageClasses = LegalEntityRepository.class,
// entityManagerFactoryRef = "emf")
@EnableJpaRepositories(basePackageClasses = LegalEntityRepository.class)
@EnableTransactionManagement
public class SpringRestConfiguration extends WebMvcConfigurerAdapter {

	private final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.html");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*")
						.allowCredentials(true);
			}
		};
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "wifi4eu.wifi4eu.abac.repository" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		return em;
	}

	@Bean
	public DataSource dataSource() throws NamingException {		
		// if (jndiDatasource != null && !jndiDatasource.isEmpty()) { return
		// (DataSource) new JndiTemplate().lookup(jndiDatasource); } return null;
		// 
		return (DataSource) new JndiTemplate().lookup("jdbc/Wifi4euAbacDataSource");
		// return (DataSource) new
		// JndiTemplate().lookup(env.getProperty("spring.datasource.jndi"));
		
		 //DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 //dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 //dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jpa");
		 //dataSource.setUsername("tutorialuser");
		 //dataSource.setPassword("tutorialmy5ql"); return dataSource;		 
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

}
*/

/*
 * @Configuration
 * 
 * @EnableWebMvc
 * 
 * @ComponentScan(basePackages = "wifi4eu.wifi4eu.abac.rest") public class
 * SpringRestConfiguration extends WebMvcConfigurerAdapter {
 * 
 * @Bean public WebMvcConfigurer corsConfigurer() { return new
 * WebMvcConfigurerAdapter() {
 * 
 * @Override public void addCorsMappings(CorsRegistry registry) {
 * registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").
 * allowedHeaders("*").allowCredentials(true); } }; } }
 */
