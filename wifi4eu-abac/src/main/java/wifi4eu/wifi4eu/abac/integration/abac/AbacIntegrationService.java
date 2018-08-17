package wifi4eu.wifi4eu.abac.integration.abac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.repository.BudgetaryCommitmentRepository;
import wifi4eu.wifi4eu.abac.data.repository.LegalCommitmentRepository;
import wifi4eu.wifi4eu.abac.data.repository.LegalEntityRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AbacIntegrationService {

    private static int FIRST_PAGE = 0;

    private final Logger log = LoggerFactory.getLogger(AbacIntegrationService.class);

    @Autowired
    LegalEntityRepository legalEntityRepository;

    @Autowired
    BudgetaryCommitmentRepository budgetaryCommitmentRepository;

    @Autowired
    LegalCommitmentRepository legalCommitmentRepository;

    /**
     * Send the legal entities with status READY_FOR_ABAC, limited to a maximum of @maxRecords
     * @param maxRecords
     */
    public void findAndSendLegalEntitiesReadyToABAC(Integer maxRecords) {
        Pageable pageable = PageRequest.of(FIRST_PAGE, maxRecords);
        List<LegalEntity> legalEntities = legalEntityRepository.findByWfStatusOrderByDateCreated(AbacWorkflowStatus.READY_FOR_ABAC, pageable);

        if (!legalEntities.isEmpty()) {
            log.info(String.format("Found %s legal entities ready to be sent to ABAC...", legalEntities.size()));
        }

        try {
            for (LegalEntity legalEntity : legalEntities) {
                createLegalEntityInAbac(legalEntity);
            }
        } catch (Exception e){
            log.error(String.format("Error sending data to abac: %s", e.getMessage()));
        }

    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    private void createLegalEntityInAbac(LegalEntity legalEntity) {
        try {
            log.info(String.format("Insert legal entity %s into abac", legalEntity.getId()));
            legalEntityRepository.createFinancialLegalEntity(legalEntity.getId());
        } catch (Exception e){
            log.error(String.format("Error sending data to abac: %s", e.getMessage()));
        }
    }

    public void updateLegalEntitiesStatuses() {
        try {
            legalEntityRepository.updateFinancialLegalEntitiesStatuses();
        } catch (Exception e){
            log.error(String.format("Error retrieving data from abac: %s", e.getMessage()));
        }
    }

    public void findAndSendBudgetaryCommitmentsReadyToABAC(Integer max_records_create_legal_entity) {
        List<LegalEntity> legalEntities = legalEntityRepository.findAvailableLegalEntitiesForBudgetaryCommitmentCreation();

        if (!legalEntities.isEmpty()) {
            log.info(String.format("Found %s legal entities with budgetary commitments to be created in ABAC...", legalEntities.size()));
        }

        try {
            for (LegalEntity legalEntity : legalEntities) {
                log.info(String.format("Insert BC for legal entity id %s in ABAC", legalEntity.getId()));
                budgetaryCommitmentRepository.createBudgetaryCommitmentInAbac(legalEntity.getId());
            }
        } catch (Exception e){
            log.error(String.format("Error sending data to abac: %s", e.getMessage()));
        }
    }

    public void updateBudgetaryCommitmentStatuses() {
        try {
            budgetaryCommitmentRepository.updateBudgetaryCommitmentStatuses();
        } catch (Exception e){
            log.error(String.format("Error retrieving data from abac: %s", e.getMessage()));
        }
    }

	public void updateLegalCommitmentStatuses() {
        try {
            legalCommitmentRepository.updateLegalCommitmentStatuses();
        } catch (Exception e){
            log.error(String.format("Error retrieving data from abac: %s", e.getMessage()));
        }
	}
}
