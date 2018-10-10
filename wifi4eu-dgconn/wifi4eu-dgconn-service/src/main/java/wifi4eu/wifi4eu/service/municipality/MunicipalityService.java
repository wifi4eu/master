package wifi4eu.wifi4eu.service.municipality;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.LogEmailDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.mapper.municipality.MunicipalityCorrespondenceMapper;
import wifi4eu.wifi4eu.common.mapper.municipality.MunicipalityMapper;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.repository.logEmails.LogEmailRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("portalMunicipalityService")
public class MunicipalityService {
    @Autowired
    private MunicipalityMapper municipalityMapper;

    @Autowired
    private MunicipalityRepository municipalityRepository;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private MayorService mayorService;

    @Autowired
    private LogEmailRepository logEmailRepository;

    @Autowired
    private MunicipalityCorrespondenceMapper municipalityCorrespondenceMapper;

    private static final Logger _log = LoggerFactory.getLogger(MayorService.class);

    @Autowired
    PermissionChecker permissionChecker;

    public MunicipalityDTO getMunicipalityById(int municipalityId) {
        Municipality municipality = municipalityRepository.findOne(municipalityId);
        return municipalityMapper.toDTO(municipality);
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
        List<Municipality> municipalities = municipalityRepository.findByLauId(lauId);
        return municipalityMapper.toDTOList(municipalities);
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

    public ResponseDTO getCorrespondenceByMunicipalityId(Integer municipalityId, Pageable pageable) {
        Page<LogEmail> page = logEmailRepository.findAllByMunicipalityId(municipalityId, pageable);
        List<LogEmailDTO> correspondanceDTOS = municipalityCorrespondenceMapper.toDTOList(page.getContent());
        return new ResponseDTO(true, correspondanceDTOS, page.getTotalElements(), null);
    }

}