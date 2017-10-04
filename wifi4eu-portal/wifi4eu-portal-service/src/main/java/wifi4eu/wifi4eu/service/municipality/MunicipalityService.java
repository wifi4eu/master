package wifi4eu.wifi4eu.service.municipality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.mapper.municipality.MunicipalityMapper;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;

@Service
public class MunicipalityService {
    @Autowired
    MunicipalityMapper municipalityMapper;

    @Autowired
    MunicipalityRepository municipalityRepository;
}