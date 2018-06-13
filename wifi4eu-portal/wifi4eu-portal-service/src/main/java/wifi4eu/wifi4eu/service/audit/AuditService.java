package wifi4eu.wifi4eu.service.audit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.audit.AuditDataDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.mapper.audit.AuditMapper;
import wifi4eu.wifi4eu.repository.audit.AuditRepository;
import wifi4eu.wifi4eu.service.user.UserService;

@Service
public class AuditService {

    @Autowired
    UserService userService;

    private final static Logger _log = LogManager.getLogger(AuditService.class);

    UserContext userContext = UserHolder.getUser();
    UserDTO userConnected = userService.getUserByUserContext(userContext);

    @Autowired
    AuditRepository auditRepository;

    @Autowired
    AuditMapper auditMapper;

    @Transactional
    public void createAuditData(AuditDataDTO auditDataDTO){
        
        _log.info("User ID: " + userConnected.getId() + " - Saving auditData: " + auditDataDTO.toString());
        auditRepository.save(auditMapper.toEntity(auditDataDTO));
    }
}
