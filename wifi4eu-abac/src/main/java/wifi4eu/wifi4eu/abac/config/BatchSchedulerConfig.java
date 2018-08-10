package wifi4eu.wifi4eu.abac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import wifi4eu.wifi4eu.abac.service.AbacIntegrationService;
import wifi4eu.wifi4eu.abac.service.LegalEntityService;

@Configuration
@EnableScheduling
@ConditionalOnProperty(prefix = "batch.scheduler", name="enabled", havingValue="true", matchIfMissing = false)
public class BatchSchedulerConfig {

    @Value("${batch.scheduler.maxrecords}")
    private Integer MAX_RECORDS_CREATE;

    @Autowired
    AbacIntegrationService abacIntegrationService;

    @Scheduled(cron = "${batch.legalentity.create.crontable}")
    public void createLegalEntitiesInABAC() {
		abacIntegrationService.findAndSendLegalEntitiesReadyToABAC(MAX_RECORDS_CREATE);
    }

    @Scheduled(cron = "${batch.budgetarycommitment.create.crontable}")
    public void createBudgetaryCommitmentsInABAC() {
        abacIntegrationService.findAndSendBudgetaryCommitmentsReadyToABAC(MAX_RECORDS_CREATE);
    }

    @Scheduled(cron = "${batch.legalentity.checkstatus.crontable}")
    public void checkLegalEntityCreationStatus() {
    	abacIntegrationService.updateLegalEntitiesStatuses();
    }

    @Scheduled(cron = "${batch.legalentity.checkstatus.crontable}")
    public void checkBudgetaryCommitmentStatus() {
        abacIntegrationService.updateBudgetaryCommitmentStatuses();
    }
}
