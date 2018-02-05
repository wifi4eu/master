package wifi4eu.wifi4eu.service.registration;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.enums.RegistrationStatus;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.MailService;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
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
        List<RegistrationDTO> registrations = getRegistrationsByUserId(userId);
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
                Locale locale = userService.initLocale();
                ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                String subject = bundle.getString("mail.dgConn.requestDocuments.subject");
                String msgBody = bundle.getString("mail.dgConn.requestDocuments.body");
                String additionalInfoUrl = userService.getBaseUrl() + "beneficiary-portal/additional-info";
                msgBody = MessageFormat.format(msgBody, additionalInfoUrl);
                if (!userService.isLocalHost()) {
                    mailService.sendEmail(user.getEmail(), MailService.FROM_ADDRESS, subject, msgBody);
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
}