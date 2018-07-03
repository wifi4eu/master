package wifi4eu;

import static java.lang.System.exit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import wifi4eu.adapter.AbacClient;
import wifi4eu.service.BatchService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired BatchService batchService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    	System.out.println("Started");
    	batchService.startSynchronization();
    	System.out.println("Finished");
    	
        exit(0);
    }
    
	@Bean
	public Jaxb2Marshaller marshaller() {
		
		return null;
		/*
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml	
		marshaller.setContextPath("financial-legal-entity-v6.wsdl");
		return marshaller;*/
	}

	@Bean
	public AbacClient abacClient(Jaxb2Marshaller marshaller) {
		return null;
		/*
		AbacClient client = new AbacClient();
		client.setDefaultUri("http://158.167.240.93:1041/RDGServices/FinancialLegalEntity/v6");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
		*/
	}	    
}