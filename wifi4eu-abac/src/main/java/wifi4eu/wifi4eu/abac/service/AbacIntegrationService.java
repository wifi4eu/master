package wifi4eu.wifi4eu.abac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.entity.AbacRequest;
import wifi4eu.wifi4eu.abac.entity.AbacLefStatus;
import wifi4eu.wifi4eu.abac.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.repository.AbacRequestRepository;
import wifi4eu.wifi4eu.abac.repository.AbacStatusRepository;
import wifi4eu.wifi4eu.abac.repository.LegalEntityRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AbacIntegrationService {

    private final Logger log = LoggerFactory.getLogger(AbacIntegrationService.class);

    @Autowired
    LegalEntityRepository legalEntityRepository;

    @Autowired
    AbacRequestRepository abacRequestRepository;

    @Autowired
    AbacStatusRepository abacStatusRepository;

    public void createLegalEntityInAbac(LegalEntity legalEntity) {
        log.info(String.format("Insert legal entity %s into abac", legalEntity.getId()));
        legalEntityRepository.createFinancialLegalEntity(legalEntity.getId());
    }

    public void checkAndUpdateLegalEntityCreationStatus() {

        Set<AbacWorkflowStatusEnum> statusesWaitingAbac = new HashSet<>();
        statusesWaitingAbac.add(AbacWorkflowStatusEnum.WAITING_FOR_ABAC);
        statusesWaitingAbac.add(AbacWorkflowStatusEnum.ABAC_PROCESSED_WAITING_APPROVAL);

        List<AbacRequest> abacRequests = abacRequestRepository.findByLegalEntityWfStatusIn(statusesWaitingAbac);

        if (!abacRequests.isEmpty()) {
            log.info(String.format("Found %s requests waiting for ABAC to create them", abacRequests.size()));
        }

        for(AbacRequest abacRequest : abacRequests) {
            AbacLefStatus abacStatus = abacStatusRepository.findByLocObjForeignId(abacRequest.getlLocObjFk());
            log.info(String.format("status of legal entity %s in abac is %s", abacRequest.getLegalEntity().getId(), abacStatus.getStatus()));

            abacRequest.getLegalEntity().setWfStatus(abacStatus.getStatus());
            legalEntityRepository.save(abacRequest.getLegalEntity());
        }
    }
}
