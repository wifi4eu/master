package wifi4eu.wifi4eu.abac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.entity.LegalEntity;

@Service
public class AbacIntegrationService {

    private final Logger log = LoggerFactory.getLogger(AbacIntegrationService.class);

    public void createLegalEntity(LegalEntity legalEntity) {
        log.info(String.format("TODO: insert legal entity %s into abac", legalEntity.getId()));
    }
}
