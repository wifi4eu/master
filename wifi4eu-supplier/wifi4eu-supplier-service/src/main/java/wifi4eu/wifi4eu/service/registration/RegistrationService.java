package wifi4eu.wifi4eu.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;

@Service("portalRegistrationService")
public class RegistrationService {
    @Autowired
    RegistrationMapper registrationMapper;

    @Autowired
    RegistrationRepository registrationRepository;

    public RegistrationDTO getRegistrationByMunicipalityId(int municipalityId) {
        //we only use this method to verify if the user has permissions.
        //So we don't need to log this.
        return registrationMapper.toDTO(registrationRepository.findByMunicipalityId(municipalityId));
    }
}