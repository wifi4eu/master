package wifi4eu.wifi4eu.abac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

/*
@ SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
*/

import wifi4eu.wifi4eu.abac.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.repository.LegalEntityRepository;

@ComponentScan
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

	private final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	@Bean
	public CommandLineRunner demo(LegalEntityRepository repository) {
		return (args) -> {
			// save a couple of legal entities
			repository.save(new LegalEntity(Integer.valueOf(1), "entity1", "es", "Barcelona", "SPAIN", "ES",
					"main street", "1", "08040"));
			repository.save(new LegalEntity(Integer.valueOf(2), "entity2", "es", "Madrid", "SPAIN", "ES", "main street",
					"2", "08040"));

			// fetch all legal entities
			log.info("Legal entities found with findAll():");
			log.info("-------------------------------");
			for (LegalEntity item : repository.findAll()) {
				log.info(item.toString());
			}
			log.info("");

			// fetch an individual legal entity by ID
			repository.findById(Integer.valueOf(1)).ifPresent(item -> {
				log.info("Legal entities found with findById(1):");
				log.info("--------------------------------");
				log.info(item.toString());
				log.info("");
			});

		};
	}
}