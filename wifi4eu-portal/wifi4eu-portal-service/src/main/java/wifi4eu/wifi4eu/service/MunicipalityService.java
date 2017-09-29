package wifi4eu.wifi4eu.service;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.mapper.MunicipalityMapper;
import wifi4eu.wifi4eu.repository.MunicipalityRepository;

public class MunicipalityService {
    @Autowired
    MunicipalityMapper municipalityMapper;

    @Autowired
    MunicipalityRepository municipalityRepository;
}