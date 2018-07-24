package wifi4eu.wifi4eu.abac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.repository.LegalEntityRepository;

@Service
public class AbacIntegrationService {

    private final Logger log = LoggerFactory.getLogger(AbacIntegrationService.class);

    @Autowired
    LegalEntityRepository legalEntityRepository;

    public void createLegalEntityInAbac(LegalEntity legalEntity) {
        log.info(String.format("Insert legal entity %s into abac", legalEntity.getId()));
        legalEntityRepository.createFinancialLegalEntity(legalEntity.getId());
    }

    public String checkLegalEntityCreationStatus(LegalEntity legalEntity) {
        log.info(String.format("TODO: check status of legal entity %s in abac", legalEntity.getId()));
        return AbacWorkflowStatusEnum.ABAC_FINISH.toString();
    }
}
