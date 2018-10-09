package wifi4eu.wifi4eu.service.audit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.audit.AuditDataDTO;
import wifi4eu.wifi4eu.common.mapper.audit.AuditMapper;
import wifi4eu.wifi4eu.repository.audit.AuditRepository;

@Service
public class AuditService {

    private final static Logger _log = Logger.getLogger(AuditService.class);

    @Autowired
    AuditRepository auditRepository;

    @Autowired
    AuditMapper auditMapper;

    @Transactional
    public void createAuditData(AuditDataDTO auditDataDTO){
        
        _log.info("Saving auditData: " + auditDataDTO.toString());
        auditRepository.save(auditMapper.toEntity(auditDataDTO));
    }
}
