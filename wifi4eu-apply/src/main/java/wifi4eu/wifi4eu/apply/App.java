package wifi4eu.wifi4eu.apply;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class App extends SpringBootServletInitializer implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;

	@Autowired
	private MasterCommitter masterCommitter;
	
	@Value("${mode}")
	private String mode;

	@Value("${test.property}")
	private String injectedValue;
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("****************************************");
		System.out.println("#########################################");
		System.out.println("# INIT ");
		System.out.println("#########################################");
		
		Config.init(environment);
		
		System.out.println("#########################################");
		System.out.println("#########################################");
		System.out.println("# config # " + Config.getEnvironment("test.property"));
		System.out.println("# injected # " + injectedValue );
		System.out.println("#########################################");
		System.out.println("#########################################");

		if (Modes.read.name().equals(this.mode)) {
			QueueConsumer conn = new QueueConsumer();

			Thread thread = new Thread(conn);

			thread.start();
			
		} else if (Modes.commit.name().equals(this.mode)) {
			this.masterCommitter.commit();

		}
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(App.class, args);
	}
}