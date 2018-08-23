package wifi4eu.wifi4eu.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
@EnableTransactionManagement
public class App extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private Environment environment;

	@Autowired
	private MasterCommitter masterCommitter;
	
	@Value("${mode}")
	private String mode;

	@Override
	public void run(String... args) throws Exception {

		Config.init(environment);

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