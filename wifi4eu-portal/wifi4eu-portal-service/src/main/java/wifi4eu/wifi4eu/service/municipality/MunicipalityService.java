package wifi4eu.wifi4eu.service.municipality;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.mapper.municipality.MunicipalityMapper;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import java.security.Permission;
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
    MayorService mayorService;

    @Autowired
    UserService userService;

    @Autowired
    PermissionChecker permissionChecker;

    public List<MunicipalityDTO> getAllMunicipalities() {
        return municipalityMapper.toDTOList(Lists.newArrayList(municipalityRepository.findAll()));
    }

    public MunicipalityDTO getMunicipalityById(int municipalityId) {
        return municipalityMapper.toDTO(municipalityRepository.findOne(municipalityId));
    }

    /**
     * This service is used only on the beneficiary-portal/installations page.
     * We need to allow only to return the municipalities that the user is associated with.
     * @param municipalityId
     * @return
     */
    public ResponseDTO getUsersMunicipalityById(Integer municipalityId, int userId) {
        ResponseDTO response = new ResponseDTO();
        MunicipalityDTO municipality = getMunicipalityById(municipalityId);
        List<RegistrationDTO> registrations = municipality.getRegistrations();
        if (registrations.size() == 1 && registrations.get(0).getUserId() == userId) {
            response.setSuccess(true);
            response.setData(municipality);
        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(403, "shared.error.notallowed"));
        }

        return response;
    }

    @Transactional
    public MunicipalityDTO createMunicipality(MunicipalityDTO municipalityDTO) {
        return municipalityMapper.toDTO(municipalityRepository.save(municipalityMapper.toEntity(municipalityDTO)));
    }

    @Transactional
    public MunicipalityDTO deleteMunicipality(int municipalityId) {
        MunicipalityDTO municipalityDTO = municipalityMapper.toDTO(municipalityRepository.findOne(municipalityId));
        if (municipalityDTO != null) {
            MayorDTO mayor = mayorService.getMayorByMunicipalityId(municipalityDTO.getId());
            if (mayor != null) {
                mayorService.deleteMayor(mayor.getId());
            }
            RegistrationDTO registration = registrationService.getRegistrationByMunicipalityId(municipalityDTO.getId());
            if (registration != null) {
                for (ApplicationDTO application : applicationService.getApplicationsByRegistrationId(registration.getId())) {
                    applicationService.deleteApplication(application.getId());
                }
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
        List<MunicipalityDTO> municipalities = new ArrayList<>();
        List<RegistrationDTO> registrations = registrationService.getRegistrationsByUserId(userId);
        for (RegistrationDTO registration : registrations) {
            municipalities.add(getMunicipalityById(registration.getMunicipalityId()));
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
}