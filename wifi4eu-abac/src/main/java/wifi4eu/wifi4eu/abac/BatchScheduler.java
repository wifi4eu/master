package wifi4eu.wifi4eu.abac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import wifi4eu.wifi4eu.abac.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.service.AbacIntegrationService;

@Configuration
@EnableScheduling
public class BatchScheduler {

    @Autowired
    AbacIntegrationService abacIntegrationService;
	
    @Scheduled(cron = "${batch.jagate.cron}")
	public void createLegalEntities() {
        LegalEntity legalEntity = new LegalEntity();
        legalEntity.setId(1);
    abacIntegrationService.createLegalEntity(legalEntity);
    }
}
