package wifi4eu.wifi4eu.abac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.repository.LegalEntityRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AbacIntegrationService {

    private static int FIRST_PAGE = 0;

    private final Logger log = LoggerFactory.getLogger(AbacIntegrationService.class);

    @Autowired
    LegalEntityRepository legalEntityRepository;

    /**
     * Send the legal entities with status READY_FOR_ABAC, limited to a maximum of @maxRecords
     * @param maxRecords
     */
    public void findAndSendLegalEntitiesReadyToABAC(Integer maxRecords) {
        Pageable pageable = PageRequest.of(FIRST_PAGE, maxRecords);
        List<LegalEntity> legalEntities = legalEntityRepository.findByWfStatusOrderByDateCreated(AbacWorkflowStatusEnum.READY_FOR_ABAC, pageable);

        if (!legalEntities.isEmpty()) {
            log.info(String.format("Found %s legal entities ready to be sent to ABAC...", legalEntities.size()));
        }

        for (LegalEntity legalEntity: legalEntities) {
            createLegalEntityInAbac(legalEntity);
        }
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createLegalEntityInAbac(LegalEntity legalEntity) {
        log.info(String.format("Insert legal entity %s into abac", legalEntity.getId()));
        legalEntityRepository.createFinancialLegalEntity(legalEntity.getId());
    }

    public void updateLegalEntitiesStatuses() {
        legalEntityRepository.updateFinancialLegalEntitiesStatuses();
    }
}