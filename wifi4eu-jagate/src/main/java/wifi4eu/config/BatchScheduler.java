package wifi4eu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import wifi4eu.service.JagateService;

@Configuration
@EnableAsync
@EnableScheduling
public class BatchScheduler {
	
	@Autowired JagateService jagateService;
	
    @Scheduled(cron = "${batch.jagate.cron}")
	public void createLegalEntities() {
    	jagateService.createLegalEntities();
    }

}
