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
import wifi4eu.wifi4eu.entity.registration.LegalFile;
import wifi4eu.wifi4eu.entity.registration.LegalFileCorrectionReason;
import wifi4eu.wifi4eu.entity.registration.LegalFiles;
import wifi4eu.wifi4eu.mapper.application.ApplicationInvalidateReasonMapper;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationInvalidateReasonRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.application.CorrectionRequestEmailRepository;
import wifi4eu.wifi4eu.repository.registration.LegalFileCorrectionReasonRepository;
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

    @Autowired
    LegalFileCorrectionReasonRepository legalFileCorrectionReasonRepository;

    @Autowired
    CorrectionRequestEmailRepository correctionRequestEmailRepository;

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
        legalFileCorrectionReasonRepository.deleteLegalFileCorrectionByRegistrationId(applicationDTO.getRegistrationId());
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
        legalFileCorrectionReasonRepository.deleteLegalFileCorrectionByRegistrationId(applicationDBO.getRegistrationId());
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
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ApplicationDTO applicationDBO = applicationMapper.toDTO(applicationRepository.findOne(applicationId));
        if (applicationDBO == null) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The application does not exist");
            throw new AppException("Incorrect application id");
        }

        Map<String, Boolean> checks = new HashMap<>();

        if(applicationDBO.getStatus() != ApplicationStatus.PENDING_FOLLOWUP.getValue()){
            checks.put("invalidate", applicationDBO.getStatus() == ApplicationStatus.OK.getValue());
            checks.put("validate", applicationDBO.getStatus() == ApplicationStatus.KO.getValue());
            return checks;
        }

        RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationDBO.getRegistrationId());
        List<LogEmailDTO> emails = municipalityService.getCorrespondenceByMunicipalityIdAndAction(registrationDTO.getMunicipalityId(), "sendCorrectionEmails");

        if(emails.isEmpty()){
            checks.put("invalidate", applicationDBO.getStatus() == ApplicationStatus.OK.getValue());
            checks.put("validate", applicationDBO.getStatus() == ApplicationStatus.KO.getValue());
        }
        else{
            Date sentDate = new Date(emails.get(0).getSentDate());

            List<LegalFiles> legalFiles = legalFilesRepository.findAllByRegistration(applicationDBO.getRegistrationId());
            for(LegalFiles legalFile: legalFiles){
                if(legalFile.getUploadTime().after(sentDate)){
                    checks.put("invalidate", applicationDBO.getStatus() == ApplicationStatus.OK.getValue());
                    checks.put("validate", applicationDBO.getStatus() == ApplicationStatus.KO.getValue());
                    return checks;
                }
            }

            Calendar c = Calendar.getInstance();
            c.setTime(sentDate);
            // Date plus 7 days (deadline)
            c.add(Calendar.DATE, 7);

            boolean valid = true;
            List<LegalFileCorrectionReason> legalFileCorrectionReasons = legalFileCorrectionReasonRepository.findByRegistrationIdOrderByTypeAsc(applicationDBO.getRegistrationId());
            for (LegalFileCorrectionReason legalFileCorrectionReason: legalFileCorrectionReasons) {
                if(legalFileCorrectionReason.getRequestCorrection()){
                    if(legalFileCorrectionReason.getRequestCorrectionDate().before(c.getTime()) && legalFileCorrectionReason.getRequestCorrectionDate().after(sentDate)){
                        valid = false;
                    }
                }
            }
            checks.put("invalidate", valid);
            checks.put("validate", valid);
        }
        return checks;
    }

}