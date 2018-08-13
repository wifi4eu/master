package wifi4eu.wifi4eu.abac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.WebApplicationInitializer;

@ComponentScan
@SpringBootApplication
@EnableJpaRepositories(basePackages = "wifi4eu.wifi4eu.abac.data.repository")
@EntityScan(basePackages = "wifi4eu.wifi4eu.abac.data.entity")
//@PropertySource("classpath:wifi4eu.properties")
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

	private final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class).properties("spring.config.name:wifi4eu");
	}

}