package wifi4eu.wifi4eu.service.municipality;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.mapper.municipality.MunicipalityMapper;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service("portalMunicipalityService")
public class MunicipalityService {
    @Autowired
    MunicipalityMapper municipalityMapper;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;

    @Autowired
    MayorService mayorService;

    @Autowired
    MunicipalityService municipalityService;

    private final Logger _log = LogManager.getLogger(MayorService.class);

    public List<MunicipalityDTO> getAllMunicipalities() {
        return municipalityMapper.toDTOList(Lists.newArrayList(municipalityRepository.findAll()));
    }

    public MunicipalityDTO getMunicipalityById(int municipalityId) {
        return municipalityMapper.toDTO(municipalityRepository.findOne(municipalityId));
    }

    @Transactional
    public MunicipalityDTO createMunicipality(MunicipalityDTO municipalityDTO) {
        return municipalityMapper.toDTO(municipalityRepository.save(municipalityMapper.toEntity(municipalityDTO)));
    }

    @Transactional
    public MunicipalityDTO updateMunicipalityDetails(MunicipalityDTO municipalityDTO) {
        MunicipalityDTO municipalitySave = municipalityService.getMunicipalityById(municipalityDTO.getId());

        municipalitySave.setAddress(municipalityDTO.getAddress());
        municipalitySave.setAddressNum(municipalityDTO.getAddressNum());
        municipalitySave.setPostalCode(municipalityDTO.getPostalCode());

        return municipalityMapper.toDTO(municipalityRepository.save(municipalityMapper.toEntity(municipalitySave)));
    }

    @Transactional
    public MunicipalityDTO deleteMunicipality(int municipalityId, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        MunicipalityDTO municipalityDTO = municipalityMapper.toDTO(municipalityRepository.findOne(municipalityId));
        if (municipalityDTO != null) {
            MayorDTO mayor = mayorService.getMayorByMunicipalityId(municipalityDTO.getId());
            if (mayor != null) {
                mayorService.deleteMayor(mayor.getId(), request);
                _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Mayor from this municipality removed");
            } else {
                _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - Mayor from this municipality not found");
            }
            RegistrationDTO registration = registrationService.getRegistrationByMunicipalityId(municipalityDTO.getId());
            if (registration != null) {
                for (ApplicationDTO application : applicationService.getApplicationsByRegistrationId(registration.getId())) {
                    applicationService.deleteApplication(application.getId(), request);
                    _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Application from this municipality removed");
                }
            } else {
                _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - Application from this municipality not found");
            }
            municipalityRepository.delete(municipalityMapper.toEntity(municipalityDTO));
            return municipalityDTO;
        } else {
            return null;
        }
    }

    public List<MunicipalityDTO> getMunicipalitiesByLauId(int lauId) {
        return municipalityMapper.toDTOList(Lists.newArrayList(municipalityRepository.findByLauId(lauId)));
    }

    public List<MunicipalityDTO> getMunicipalitiesByUserId(int userId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        List<MunicipalityDTO> municipalities = new ArrayList<>();
        List<RegistrationDTO> registrations = registrationService.getRegistrationsByUserId(userId);
        for (RegistrationDTO registration : registrations) {
            municipalities.add(getMunicipalityById(registration.getMunicipalityId()));
            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Municipality with id " + registration.getMunicipalityId() + " added to the list");
        }
        return municipalities;
    }

    @Cacheable(value = "portalGetMunicipalitiesCountGroupedByLauId")
    public List<Object> getMunicipalitiesCountGroupedByLauId() {
        return Lists.newArrayList(municipalityRepository.findMunicipalitiesCountGroupedByLauId());
    }

    public Integer getCountDistinctMunicipalities() {
        return municipalityRepository.countDistinctMunicipalities();
    }

    public Integer getCountDistinctMunicipalitiesContainingName(String name) {
        return municipalityRepository.countDistinctMunicipalitiesContainingName(name);
    }

    public Integer getCountDistinctMunicipalitiesThatAppliedCall(Integer callId, String country) {
        if (country == null) {
            country = "%";
        }
        return municipalityRepository.countDistinctMunicipalitiesThatAppliedCall(callId, country);
    }

    public Integer getCountDistinctMunicipalitiesThatAppliedCallContainingName(Integer callId, String country, String name) {
        if (country == null) {
            country = "%";
        }
        return municipalityRepository.countDistinctMunicipalitiesThatAppliedCallContainingName(callId, country, name);
    }
}