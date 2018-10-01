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

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootServletInitializer.class);

	@Autowired
	private Environment environment;

	@Autowired
	private MasterCommitter masterCommitter;

	@Value("${mode}")
	private String mode;

	@Value("${server.port}")
	private String serverPort;

	@Override
	public void run(String... args) throws IOException {
		Config.init(environment);

		if (Modes.commit.name().equals(this.mode)) {
			LOG.info("### Running in commit mode on port {}", this.serverPort);
			startCommit();
		} else if (Modes.read.name().equals(this.mode)) {
			LOG.info("### Running in read mode on port {}", this.serverPort);
			startRead();
		} else {
			// default if no mode is set
			LOG.info("### Running in read mode (no mode defined) on port {}", this.serverPort);
			startRead();
		}
	}

	/**
	 * Method to start the process in read mode.
	 * 
	 * @throws IOException
	 */
	private void startRead() throws IOException {
		QueueConsumer conn = new QueueConsumer();
		Thread thread = new Thread(conn);
		thread.start();
	}

	/**
	 * Method to start the process in commit mode.
	 */
	private void startCommit() {
		this.masterCommitter.commit();
	}

	public static void main(String[] args) throws IOException {
		SpringApplication app = new SpringApplication(App.class);
		app.run(args);
	}
}