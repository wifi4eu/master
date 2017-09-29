package wifi4eu.wifi4eu.service;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.mapper.ApplicationMapper;
import wifi4eu.wifi4eu.repository.ApplicationRepository;

public class ApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    ApplicationRepository applicationRepository;
}