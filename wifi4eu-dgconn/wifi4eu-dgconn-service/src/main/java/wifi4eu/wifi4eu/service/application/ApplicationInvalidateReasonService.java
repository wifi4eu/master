package wifi4eu.wifi4eu.service.application;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.ApplicationStatus;
import wifi4eu.wifi4eu.common.enums.VoucherAssignmentStatus;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.application.ApplicationInvalidateReason;
import wifi4eu.wifi4eu.entity.application.CorrectionRequestEmail;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;
import wifi4eu.wifi4eu.entity.registration.LegalFiles;
import wifi4eu.wifi4eu.mapper.application.ApplicationInvalidateReasonMapper;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationInvalidateReasonRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.application.CorrectionRequestEmailRepository;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.registration.legal_files.LegalFilesService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.voucher.VoucherService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class ApplicationInvalidateReasonService {

    private static final Logger _log = LogManager.getLogger(ApplicationInvalidateReasonService.class);

    @Autowired
    ApplicationInvalidateReasonRepository applicationInvalidateReasonRepository;

    @Autowired
    ApplicationInvalidateReasonMapper applicationInvalidateReasonMapper;

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    LegalFilesRepository legalFilesRepository;

    public List<ApplicationInvalidateReasonDTO> getInvalidateReasonByApplicationId(Integer applicationId) {
        return applicationInvalidateReasonMapper.toDTOList(applicationInvalidateReasonRepository.findAllByApplicationIdOrderByReason(applicationId));
    }

    public void deleteInvalidateReasonByApplicationId(Integer applicationId){
        applicationInvalidateReasonRepository.deleteInvalidateReasonsByApplicationId(applicationId);
    }

    public List<ApplicationInvalidateReasonDTO> invalidateApplication(InvalidReasonViewDTO invalidReasonViewDTO, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Invalidating application");
        ApplicationDTO applicationDTO = applicationService.getApplicationById(invalidReasonViewDTO.getApplicationId());
        if(applicationDTO == null){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The application does not exist");
            throw new AppException("Incorrect application id");
        }

        List<ApplicationInvalidateReasonDTO> applicationInvalidateReasonDTOS = new ArrayList<>();
        for(Integer integer: invalidReasonViewDTO.getReasons()){
            applicationInvalidateReasonDTOS.add(new ApplicationInvalidateReasonDTO(applicationDTO.getId(), integer));
        }
        applicationDTO.setStatus(ApplicationStatus.KO.getValue());
        applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDTO)));
        List<ApplicationInvalidateReason> invalidateReason = applicationInvalidateReasonRepository.save(applicationInvalidateReasonMapper.toEntityList(applicationInvalidateReasonDTOS));

        /* TODO: The emails are not sent as of the time of this comment, but they will be enabled in the near future.
        RegistrationDTO registration = registrationService.getRegistrationById(invalidatedApplication.getRegistrationId());
        if (registration != null) {
            UserDTO user = userService.getUserById(registration.getUserId());
            MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
            if (user != null && municipality != null) {
                Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                if (user.getLang() != null) {
                    locale = new Locale(user.getLang());
                }
                ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                String subject = bundle.getString("mail.invalidateApplication.subject");
                String msgBody = bundle.getString("mail.invalidateApplication.body");
                msgBody = MessageFormat.format(msgBody, municipality.getName());
                mailService.sendEmail(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
            }
        }
        */
        _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - The application is invalid due the following reasons: " + invalidReasonViewDTO.getReasons().toString());
        return applicationInvalidateReasonMapper.toDTOList(invalidateReason);
    }

    @Transactional
    public ApplicationDTO validateApplication(ApplicationDTO applicationDTO, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Validating application");
        RegistrationDTO registration = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
        if (registration.getAllFilesFlag() != 1) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The application can not be validated due to missing files");
            throw new AppException();
        }
        ApplicationDTO applicationDBO = applicationMapper.toDTO(applicationRepository.findOne(applicationDTO.getId()));
        if (applicationDBO == null) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The application does not exist");
            throw new AppException("Incorrect application id");
        }

        applicationDBO.setStatus(ApplicationStatus.OK.getValue());
        deleteInvalidateReasonByApplicationId(applicationDBO.getId());
        applicationDBO.setAuthorizedPerson(applicationDTO.getAuthorizedPerson());
        ApplicationDTO validatedApplication = applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDBO)));
        /* TODO: The emails are not sent as of the time of this comment, but they will be enabled in the near future.
        RegistrationDTO registration = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
        if (registration != null) {
            UserDTO user = userService.getUserById(registration.getUserId());
            MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
            if (user != null && municipality != null) {
                Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                if (user.getLang() != null) {
                    locale = new Locale(user.getLang());
                }
                ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                String subject = bundle.getString("mail.validateApplication.subject");
                String msgBody = bundle.getString("mail.validateApplication.body");
                msgBody = MessageFormat.format(msgBody, municipality.getName());
                mailService.sendEmail(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
            }
        }
        */
        _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - The application is valid");
        return validatedApplication;
    }

    public Map<String, Boolean> changeStatusApplicationEnabled(Integer applicationId, HttpServletRequest request){
        //TODO Check if status of application can be changed from pending follow up:
        //  Before the email to the applicant is sent for correction of documents:
        //	    Pending follow-up -> Invalid: can be changed freely to invalid, this will clear the reasons for correction already in the database for all documents submitted for that call.
        //	    Pending follow-up -> Valid: can be changed freely to valid, this will clear the reasons for correction already in the database for all documents submitted for that call.
        //  After the email to the applicant is sent for correction of documents:
        //      Before the deadline to resubmit (7 calendar days) has passed:

        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ApplicationDTO applicationDBO = applicationMapper.toDTO(applicationRepository.findOne(applicationId));
        if (applicationDBO == null) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The application does not exist");
            throw new AppException("Incorrect application id");
        }

        Map<String, Boolean> checks = new HashMap<>();

        if(applicationDBO.getStatus() != ApplicationStatus.PENDING_FOLLOWUP.getValue()){
            checks.put("invalidate", false);
            checks.put("validate", false);
            return checks;
        }

        RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationDBO.getRegistrationId());
        List<LogEmailDTO> emails = municipalityService.getCorrespondenceByMunicipalityIdAndAction(registrationDTO.getMunicipalityId(), "sendCorrectionEmails");

        if(emails.size() == 0){
            if(applicationDBO.getStatus() == ApplicationStatus.OK.getValue()){
                checks.put("invalidate", true);
                checks.put("validate", false);
            }
            else if(applicationDBO.getStatus() == ApplicationStatus.KO.getValue()){
                checks.put("invalidate", false);
                checks.put("validate", true);
            }
        }
        else{
            Date sentDate = new Date(emails.get(0).getSentDate());
            Calendar c = Calendar.getInstance();
            c.setTime(sentDate);
            c.add(Calendar.DATE, 7);

            List<LegalFiles> legalFiles = legalFilesRepository.findAllByRegistration(applicationDBO.getRegistrationId());
            boolean valid = true;
            for (LegalFiles legalFile: legalFiles) {
                if(legalFile.getUploadTime().before(c.getTime()) && legalFile.getUploadTime().after(sentDate)){
                    valid = false;
                }
//                else{
//                    valid = true;
//                }
            }
            checks.put("invalidate", valid);
            checks.put("validate", valid);
        }

        return checks;
    }

}
