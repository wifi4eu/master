package wifi4eu.wifi4eu.abac.service;

import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.entity.AbacLefStatus;
import wifi4eu.wifi4eu.abac.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.repository.AbacRequestRepository;
import wifi4eu.wifi4eu.abac.repository.AbacStatusRepository;
import wifi4eu.wifi4eu.abac.repository.LegalEntityRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AbacIntegrationService {

    private final Logger log = LoggerFactory.getLogger(AbacIntegrationService.class);

    @Autowired
    LegalEntityRepository legalEntityRepository;

    @Autowired
    AbacStatusRepository abacStatusRepository;

    @Autowired
    AbacRequestRepository abacRequestRepository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createLegalEntityInAbac(LegalEntity legalEntity) {
        log.info(String.format("Insert legal entity %s into abac", legalEntity.getId()));
        legalEntityRepository.createFinancialLegalEntity(legalEntity.getId());
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public List<AbacLefStatus> getLegalEntityCreationStatus() {

        Set<AbacWorkflowStatusEnum> statusesWaitingAbac = new HashSet<>();
        statusesWaitingAbac.add(AbacWorkflowStatusEnum.WAITING_FOR_ABAC);
        statusesWaitingAbac.add(AbacWorkflowStatusEnum.WAITING_APPROVAL);

        Set<String> abacRequestKeys = abacRequestRepository.findByLegalEntityWfStatusIn(statusesWaitingAbac);

        List<AbacLefStatus> abacLefStatuses = new ArrayList<>();
        if (!abacRequestKeys.isEmpty()) {
            log.info(String.format("Found %s requests waiting for ABAC to create them", abacRequestKeys.toArray().length));
            abacLefStatuses = abacStatusRepository.findByLocObjForeignIdIn(abacRequestKeys);
        }
        return abacLefStatuses;
    }

    @Transactional(dontRollbackOn = {SQLGrammarException.class, Exception.class})
    public void killDBLink() {
        try {
            abacStatusRepository.killDBLink();
        } catch (Exception e) {
            //log.error(e.getMessage());
        }
    }

}
