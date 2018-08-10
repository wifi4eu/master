package wifi4eu.wifi4eu.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.io.IOException;

import javax.sql.DataSource;


@SpringBootApplication
public class App extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private Environment environment;

	@Autowired
	private MasterCommitter masterCommitter;

	@Override
	public void run(String... args) throws Exception {

		Config.init(environment);
		
		this.masterCommitter.commit1();
		
/*
		QueueConsumer conn = new QueueConsumer();

		Thread thread = new Thread(conn);

		thread.start();
*/
	}

	public static void main(String[] args) throws IOException {

		SpringApplication.run(App.class, args);
	}


//	@Bean
//	public DataSource dataSource() {
//	        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//	        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
//	        dataSourceBuilder.url("jdbc:sqlite:journal");
//	        return dataSourceBuilder.build();   
//	}

}




