package wifi4eu.wifi4eu.service.municipality;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.MunicipalityValidator;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;
import wifi4eu.wifi4eu.mapper.municipality.MunicipalityCorrespondenceMapper;
import wifi4eu.wifi4eu.mapper.municipality.MunicipalityMapper;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.repository.invitationContacts.InvitationContactRepository;
import wifi4eu.wifi4eu.repository.logEmails.LogEmailRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.warning.RegistrationWarningService;

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
    RegistrationWarningService registrationWarningService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    LogEmailRepository logEmailRepository;

    @Autowired
    MunicipalityCorrespondenceMapper municipalityCorrespondenceMapper;

    @Autowired
    InvitationContactRepository invitationContactRepository;

    private final Logger _log = LogManager.getLogger(MayorService.class);

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    RegistrationUsersRepository registrationUsersRepository;

    @Autowired
    CallRepository callRepository;

    @Autowired
    LauService lauService;

    @Autowired
    NutsService nutsService;

    public List<MunicipalityDTO> getAllMunicipalities() {
        return municipalityMapper.toDTOList(Lists.newArrayList(municipalityRepository.findAll()));
    }

    public MunicipalityDTO getMunicipalityById(int municipalityId) {
        return municipalityMapper.toDTO(municipalityRepository.findOne(municipalityId));
    }

    /**
     * This service is used only on the beneficiary-portal/installations page.
     * We need to allow only to return the municipalities that the user is associated with.
     *
     * @param municipalityId
     * @return
     */
    public ResponseDTO getUsersMunicipalityById(Integer municipalityId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving users from municipality with id " + municipalityId);
        ResponseDTO response = new ResponseDTO();
        MunicipalityDTO municipality = getMunicipalityById(municipalityId);
        if (checkPermissions(municipalityId)) {
            response.setSuccess(true);
            response.setData(municipality);
        } else {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to access");
            return permissionChecker.getAccessDeniedResponse();
        }
        return response;
    }

    public boolean checkPermissions(int idMunicipality) throws AccessDeniedException {
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());

            //we check that this user has a relation to this installation site's municipality
            RegistrationDTO registrationDTO = registrationService.getRegistrationByUserAndMunicipality(userDTO.getId(), idMunicipality);
            if (registrationDTO == null) {
                throw new AccessDeniedException("403 FORBIDDEN");
            }

            //then we check if user logged in is a beneficiary and has permissions to access this municipality and registration
            permissionChecker.checkBeneficiaryPermission(userDTO.getType(), idMunicipality, registrationDTO.getId());

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    public MunicipalityDTO saveMunicipality(MunicipalityDTO municipalityDTO) {
        return municipalityMapper.toDTO(municipalityRepository.save(municipalityMapper.toEntity(municipalityDTO)));
    }

    @Transactional
    public MunicipalityDTO updateMunicipalityDetails(MunicipalityDTO municipalityDTO) throws Exception {
        MunicipalityValidator.validateMunicipality(municipalityDTO, lauService.getLauById(municipalityDTO.getLauId()), nutsService.getNutsByLevel(0));
        MunicipalityDTO municipalitySave = municipalityService.getMunicipalityById(municipalityDTO.getId());

        municipalitySave.setAddress(municipalityDTO.getAddress());
        municipalitySave.setAddressNum(municipalityDTO.getAddressNum());
        municipalitySave.setPostalCode(municipalityDTO.getPostalCode());

        return municipalityMapper.toDTO(municipalityRepository.save(municipalityMapper.toEntity(municipalitySave)));
    }

    @Transactional
    public long countMunicipalitiesByUserId(long idUser) {
        return municipalityRepository.countMunicipalitiesByUserId(idUser);
    }

    @Transactional
    public boolean deleteMunicipalityById(int id) {
        if (municipalityRepository.findOne(id) != null) {
            municipalityRepository.delete(id);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean isMunicipalityEditable(int municipalityId) {
        Integer firstQuery = municipalityRepository.checkMunicipalityEditPermission(municipalityId);
        if (firstQuery > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public void deleteInvitationsByRegistrationId(Integer registrationId) {
        invitationContactRepository.delete(invitationContactRepository.findByIdRegistration(registrationId));
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
                deleteInvitationsByRegistrationId(registration.getId());
                registrationUsersRepository.delete(registrationUsersRepository.findByRegistrationId(registration.getId()));
                List<RegistrationWarningDTO> registrationWarningDTOs = registrationWarningService.getWarningsByRegistrationId(registration.getId());
                if (registrationWarningDTOs.size() > 0) {
                    registrationWarningService.deleteWarningFromRegistration(registrationWarningDTOs);
                }
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
            MunicipalityDTO mun = getMunicipalityById(registration.getMunicipalityId());
            if (mun != null) {
                municipalities.add(mun);
            }
            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Municipality with id " + registration.getMunicipalityId() + " " +
                    "added to the list");
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

    public ResponseDTO getCorrespondenceByMunicipalityId(Integer municipalityId, Pageable pageable) {
        Page<LogEmail> page = logEmailRepository.findAllByMunicipalityId(municipalityId, pageable);
        List<LogEmailDTO> correspondanceDTOS = municipalityCorrespondenceMapper.toDTOList(page.getContent());
        return new ResponseDTO(true, correspondanceDTOS, page.getTotalElements(), null);
    }
}