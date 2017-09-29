package wifi4eu.wifi4eu.service;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.mapper.RegistrationMapper;
import wifi4eu.wifi4eu.repository.RegistrationRepository;

public class RegistrationService {
    @Autowired
    RegistrationMapper registrationMapper;

    @Autowired
    RegistrationRepository registrationRepository;
}