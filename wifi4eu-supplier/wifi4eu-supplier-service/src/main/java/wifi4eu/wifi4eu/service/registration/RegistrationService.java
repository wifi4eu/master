package wifi4eu.wifi4eu.service.registration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.service.installation.InstallationSiteService;
import wifi4eu.wifi4eu.service.user.UserService;

@Service("portalRegistrationService")
public class RegistrationService {
    @Autowired
    RegistrationMapper registrationMapper;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    UserService userService;

    private final Logger _log = LogManager.getLogger(RegistrationService.class);

    public RegistrationDTO getRegistrationByMunicipalityId(int municipalityId) {
        return registrationMapper.toDTO(registrationRepository.findByMunicipalityId(municipalityId));
    }
}