package wifi4eu.wifi4eu.abac.config;

import com.sun.xml.ws.fault.ServerSOAPFaultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.enums.DocumentWorkflowStatus;
import wifi4eu.wifi4eu.abac.integration.abac.AbacIntegrationService;
import wifi4eu.wifi4eu.abac.service.DocumentService;
import wifi4eu.wifi4eu.abac.service.LegalCommitmentService;
import wifi4eu.wifi4eu.abac.service.LegalEntityService;
import wifi4eu.wifi4eu.abac.service.NotificationService;

import javax.xml.ws.soap.SOAPFaultException;
import java.util.List;

@Configuration
@EnableScheduling
@ConditionalOnProperty(prefix = "batch.scheduler", name="enabled", havingValue="true", matchIfMissing = false)
public class BatchSchedulerConfig {

    private final Logger log = LoggerFactory.getLogger(BatchSchedulerConfig.class);

    @Value("${batch.scheduler.maxrecords}")
    private Integer MAX_RECORDS_CREATE;

    @Autowired
    AbacIntegrationService abacIntegrationService;

    @Autowired
    LegalCommitmentService legalCommitmentService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    LegalEntityService legalEntityService;

    @Autowired
    DocumentService documentService;

    @Scheduled(cron = "${batch.legalentity.create.crontable}")
    public void createLegalEntitiesInABAC() {
        //check-update the LE status for ABAC (change from IMPORTED to READY_FOR_ABAC)
        legalEntityService.checkLegalEntityReadyForAbac();
        //submit LE to ABAC
		abacIntegrationService.findAndSendLegalEntitiesReadyToABAC(MAX_RECORDS_CREATE);
    }

    @Scheduled(cron = "${batch.budgetarycommitment.create.crontable}")
    public void createBudgetaryCommitmentsInABAC() {
        abacIntegrationService.findAndSendBudgetaryCommitmentsReadyToABAC(MAX_RECORDS_CREATE);
    }

    @Scheduled(cron = "${batch.legalcommitment.create.crontable}")
    public void createLegalCommitmentsInABAC() {
        abacIntegrationService.findAndSendLegalCommitmentsReadyToABAC();
    }

    @Scheduled(cron = "${batch.abac.checkstatus.crontable}")
    public void checkAbacStatuses() {

        abacIntegrationService.updateLegalEntitiesStatuses();
        abacIntegrationService.updateBudgetaryCommitmentStatuses();
        abacIntegrationService.updateLegalCommitmentStatuses();
    }

    @Scheduled(cron = "${batch.legalcommitment.countersign.crontable}")
    public void counterSignGrantAgreements() {
        legalCommitmentService.findAndCounterSignGrantAgreements();
    }

    @Scheduled(cron = "${notifications.batch.crontable}")
    public void sendNotifications() {
        notificationService.notifyLegalEntityProcessFinished();
        notificationService.notifyBudgetaryCommitmentProcessFinished();
        notificationService.notifyLegalCommitmentProcessFinished();
    }

    @Scheduled(cron = "${batch.documents.ares.upload}")
    @Transactional( propagation = Propagation.REQUIRES_NEW )
    public void uploadDocumentsInAres() {

        Pageable pageable = PageRequest.of(0, MAX_RECORDS_CREATE);
        List<Document> documents = documentService.getDocumentsByStatus(DocumentWorkflowStatus.IMPORTED, pageable);

        if (!documents.isEmpty()) {
            log.info("Found {} documents ready to be sent to ARES...", documents.size());
        }


            for (Document document : documents) {
                try {
                    documentService.addDocumentInAres(document);
                }catch (SOAPFaultException e){
                    log.error("Error sending document to ARES: {}", e.getMessage(), e);
                    documentService.updateStatusInNewTransaction(document, DocumentWorkflowStatus.ARES_ERROR);
                } catch (Exception e){
                    log.error("Error sending document to ARES: {}", e.getMessage(), e);
                    documentService.updateStatusInNewTransaction(document, DocumentWorkflowStatus.ARES_ERROR);
                }
            }

    }
}
