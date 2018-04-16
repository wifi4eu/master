package wifi4eu.wifi4eu.service.municipality;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.mapper.municipality.MunicipalityMapper;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;

import java.util.ArrayList;
import java.util.List;

@Service("supplierMunicipalityService")
public class MunicipalityService {

    @Autowired
    MunicipalityMapper municipalityMapper;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    ApplicationService applicationService;

    public MunicipalityDTO getMunicipalityById(int municipalityId) {
        return municipalityMapper.toDTO(municipalityRepository.findOne(municipalityId));
    }

    public List<MunicipalityDTO> getMunicipalitiesBySupplierId(int supplierId) {
        List<MunicipalityDTO> municipalities = new ArrayList<>();
        List<ApplicationDTO> applications = applicationService.getApplicationsBySupplierId(supplierId);
        for (ApplicationDTO application : applications){
            RegistrationDTO registration = registrationService.getRegistrationById(application.getRegistrationId());
            municipalities.add(getMunicipalityById(registration.getMunicipalityId()));
        }
        return municipalities;
    }

}