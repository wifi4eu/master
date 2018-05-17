package wifi4eu.wifi4eu.service.registration;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.cns.CNSManager;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.enums.RegistrationStatus;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.supplier.Supplier;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.MailService;

import java.util.*;
import java.text.MessageFormat;

@Service("portalRegistrationService")
public class RegistrationService {
    @Autowired
    RegistrationMapper registrationMapper;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;

    @Autowired
    MailService mailService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    UserThreadsService userThreadsService;

    @Autowired
    ThreadService threadService;

    @Autowired
    CNSManager cnsManager;

    @Autowired
    ApplicationRepository applicationRepository;

    public List<RegistrationDTO> getAllRegistrations() {
        return registrationMapper.toDTOList(Lists.newArrayList(registrationRepository.findAll()));
    }

    public RegistrationDTO getRegistrationById(int registrationId) {
        return registrationMapper.toDTO(registrationRepository.findOne(registrationId));
    }

    @Transactional
    public RegistrationDTO createRegistration(RegistrationDTO registrationDTO) {
        return registrationMapper.toDTO(registrationRepository.save(registrationMapper.toEntity(registrationDTO)));
    }

    @Transactional
    public ResponseDTO confirmOrRejectInstallationAndSendCNS(Map<String, Object> map) {
        ResponseDTO response = new ResponseDTO();
        if (!map.isEmpty()) {
           if (map.containsKey("id") && map.containsKey("wifiIndicator") && map.containsKey("beneficiaryIndicator")) {
               Registration registration = registrationRepository.findOne((int) map.get("id"));
               if (registration != null && registration.isWifiIndicator()) {
                    boolean wifiIndicator= (boolean) map.get("wifiIndicator");
                    boolean beneficiaryIndicator= (boolean) map.get("beneficiaryIndicator");

                   //we save the new indicators
                   registration.setWifiIndicator(wifiIndicator);
                   registration.setBeneficiaryIndicator(beneficiaryIndicator);
                   registrationRepository.save(registration);

                   //sending CNS
                   String beneficiaryName = registration.getMunicipality().getName();
                   Iterable<Application> applicationList = applicationRepository.findByRegistrationId(registration
                           .getId());
                   Supplier supplier = applicationList.iterator().next().getSupplier();
                   String name = supplier.getName();
                   String email = supplier.getContactEmail();

                   //if beneficiary indicator and wifi indicator are true we send a confirmation email
                   if (beneficiaryIndicator && wifiIndicator) {
                       cnsManager.sendInstallationConfirmationFromBeneficiary(email, name, beneficiaryName);
                   } else if (!beneficiaryIndicator && !wifiIndicator) {
                       //if beneficiary indicator and wifi indicator are false we send a rejection email
                       User user = registration.getUser();
                       String ccName = user.getName();
                       String ccEmail = user.getEmail();
                       cnsManager.sendInstallationRejectionFromBeneficiary(email, name, beneficiaryName, ccEmail,
                               ccName);
                   }

                   //if everything goes ok it's a success
                   response.setSuccess(true);
                   response.setData("Beneficiary Indicator updated successfully");
               } else {
                   response.setSuccess(false);
                   response.setData("Error querying municipality - registration");
                   response.setError(new ErrorDTO(404, "error.404.beneficiaryNotFound"));
               }
           }else {
               response.setSuccess(false);
               response.setError(new ErrorDTO(400, "error.400.invalidFields"));
           }
        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(400, "error.400.noData"));

        }
        return response;
    }

    @Transactional
    public RegistrationDTO deleteRegistration(int registrationId) {
        RegistrationDTO registrationDTO = registrationMapper.toDTO(registrationRepository.findOne(registrationId));
        if (registrationDTO != null) {
            for (ApplicationDTO application : applicationService.getApplicationsByRegistrationId(registrationDTO.getId())) {
                applicationService.deleteApplication(application.getId());
            }
            registrationRepository.delete(registrationMapper.toEntity(registrationDTO));
            return registrationDTO;
        } else {
            return null;
        }
    }

    public List<RegistrationDTO> getRegistrationsByUserId(int userId) {
        return registrationMapper.toDTOList(Lists.newArrayList(registrationRepository.findByUserId(userId)));
    }

    public RegistrationDTO getRegistrationByMunicipalityId(int municipalityId) {
        return registrationMapper.toDTO(registrationRepository.findByMunicipalityId(municipalityId));
    }

    public RegistrationDTO getRegistrationByUserAndMunicipality(int userId, int municipalityId) {
        return registrationMapper.toDTO(registrationRepository.findByUserIdAndMunicipalityId(userId, municipalityId));
    }

    public boolean checkIfRegistrationIsKO(int userId) {
        List<RegistrationDTO> registrations = registrationMapper.toDTOList(
                Lists.newArrayList(
                        registrationRepository.findByUserId(userId)));
        for (RegistrationDTO registration : registrations) {
            if (registration.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public boolean requestLegalDocuments(int registrationId) {
        RegistrationDTO registration = getRegistrationById(registrationId);
        if (registration != null) {
            UserDTO user = userService.getUserById(registration.getUserId());
            if (user != null) {
                Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                if (user.getLang() != null) {
                    locale = new Locale(user.getLang());
                }
                ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                String subject = bundle.getString("mail.dgConn.requestDocuments.subject");
                String msgBody = bundle.getString("mail.dgConn.requestDocuments.body");
                String additionalInfoUrl = userService.getBaseUrl() + "beneficiary-portal/additional-info";
                msgBody = MessageFormat.format(msgBody, additionalInfoUrl);
                if (!userService.isLocalHost()) {
                    mailService.sendEmail(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
                }
                return true;
            }
        }
        return false;
    }

    @Transactional
    public boolean assignLegalEntity(int registrationId) {
        RegistrationDTO registration = getRegistrationById(registrationId);
        if (registration != null) {
            MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
            List<MunicipalityDTO> municipalities = municipalityService.getMunicipalitiesByLauId(municipality.getLauId());
            for (MunicipalityDTO municipalityItem : municipalities) {
                RegistrationDTO registrationItem = getRegistrationByMunicipalityId(municipalityItem.getId());
                if (registrationItem != null) {
                    registrationItem.setStatus(RegistrationStatus.KO.getValue());
                    if (registrationItem.getId() == registration.getId()) {
                        registrationItem.setStatus(RegistrationStatus.OK.getValue());
                    }
                    createRegistration(registrationItem);
                }
            }
            return true;
        }
        return false;
    }

    public RegistrationDTO getRegistrationByUserThreadId(int userThreadId) {
        UserThreadsDTO userThreadDTO = userThreadsService.getUserThreadsById(userThreadId);
        ThreadDTO threadDTO = threadService.getThreadById(userThreadDTO.getThreadId());
        UserDTO userDTO = userService.getUserById(userThreadDTO.getUserId());
        List<RegistrationDTO> registrations = getRegistrationsByUserId(userDTO.getId());
        for (RegistrationDTO registration : registrations) {
            MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
            if (threadDTO.getReason().equals(String.valueOf(municipality.getLauId()))) {
                return registration;
            };
        }
        return null;
    }

    public List<RegistrationDTO> getRegistrationsByIp(String ip) {
        return registrationMapper.toDTOList(Lists.newArrayList(registrationRepository.findByIpRegistration(ip)));
    }
}