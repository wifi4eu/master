package wifi4eu.wifi4eu.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;

@Service
public class RegistrationService {
    @Autowired
    RegistrationMapper registrationMapper;

    @Autowired
    RegistrationRepository registrationRepository;
}