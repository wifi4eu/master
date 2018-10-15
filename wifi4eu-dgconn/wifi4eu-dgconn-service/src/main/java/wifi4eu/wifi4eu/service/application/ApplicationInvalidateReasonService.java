package wifi4eu.wifi4eu.service.application;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.ApplicationStatus;
import wifi4eu.wifi4eu.common.enums.VoucherAssignmentStatus;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.application.ApplicationInvalidateReason;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;
import wifi4eu.wifi4eu.mapper.application.ApplicantAuthorizedPersonMapper;
import wifi4eu.wifi4eu.mapper.application.ApplicationInvalidateReasonMapper;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationAuthorizedPersonRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationInvalidateReasonRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.application.CorrectionRequestEmailRepository;
import wifi4eu.wifi4eu.repository.logEmails.LogEmailRepository;
import wifi4eu.wifi4eu.repository.registration.LegalFileCorrectionReasonRepository;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;
import wifi4eu.wifi4eu.repository.voucher.SimpleMunicipalityRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class ApplicationInvalidateReasonService {

    private static final Logger _log = LogManager.getLogger(ApplicationInvalidateReasonService.class);

    //requirement: after a request for correction is sent, cannot validate or invalidate for 2 days
    private static final Integer UPLOAD_DOCUMENT_CORRECTION_DEADLINE = 2;

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

    @Autowired
    SimpleMunicipalityRepository simpleMunicipalityRepository;

    @Autowired
    VoucherSimulationRepository voucherSimulationRepository;

    @Autowired
    ApplicantAuthorizedPersonMapper applicant_authorizedPersonMapper;

    @Autowired
    ApplicationAuthorizedPersonRepository application_authorizedPersonRepository;

    @Autowired
    LogEmailRepository logEmailRepository;

    public List<ApplicationInvalidateReasonDTO> getInvalidateReasonByApplicationId(Integer applicationId) {
        return applicationInvalidateReasonMapper.toDTOList(applicationInvalidateReasonRepository.findAllByApplicationIdOrderByReason(applicationId));
    }

    public void deleteInvalidateReasonByApplicationId(Integer applicationId){
        applicationInvalidateReasonRepository.deleteInvalidateReasonsByApplicationId(applicationId);
    }

    public void updateVoucherSimulationNumDuplicates(ApplicationDTO applicationDTO){
        Integer lauId = simpleMunicipalityRepository.findLauFromApplication(applicationDTO.getId());

        List<Application> applicationDTOS = applicationRepository.findByCallIdAndLauIdAndStatus(applicationDTO.getCallId(), lauId, ApplicationStatus.OK.getValue());

        List<Integer> applicationIDS = new ArrayList<>();
        for (Application appDTO: applicationDTOS) {
            applicationIDS.add(appDTO.getId());
        }

        if(!applicationDTOS.isEmpty()){
            VoucherSimulation vs = voucherSimulationRepository.findVoucherSimulationByApplicationId(applicationIDS, applicationDTO.getCallId(), VoucherAssignmentStatus.SIMULATION.getValue());

            if(Validator.isNotNull(vs)){
                vs.setNumApplications(applicationDTOS.size());
                voucherSimulationRepository.save(vs);
            }
        }
    }

    /**
     *	It is only possible to invalidate an applications if the status is one of the following:
     *     HOLD(0)
     *     OK(2)
     *     PENDING_FOLLOWUP(3)
     *
     * @param status
     * @return
     */
    private boolean isPossibleInvalidateApplication(int status) {
    	return (ApplicationStatus.HOLD.getValue() == status) || (ApplicationStatus.OK.getValue() == status) || (ApplicationStatus.PENDING_FOLLOWUP.getValue() == status);
    }

    /**
     *	It is only possible to validate an applications if the status is one of the following:
     *     HOLD(0)
     *     KO(1)
     *     PENDING_FOLLOWUP(3)
     *
     * @param status
     * @return
     */
    private boolean isPossibleValidateApplication(int status) {
    	return (ApplicationStatus.HOLD.getValue() == status) || (ApplicationStatus.KO.getValue() == status) || (ApplicationStatus.PENDING_FOLLOWUP.getValue() == status);
    }

    public List<ApplicationInvalidateReasonDTO> invalidateApplication(InvalidReasonViewDTO invalidReasonViewDTO, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Invalidating application");

        ApplicationDTO applicationDTO = applicationService.getApplicationById(invalidReasonViewDTO.getApplicationId());
        if (applicationDTO == null) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The application does not exist");
            throw new AppException("Incorrect application id");
        } else if (!isPossibleInvalidateApplication(applicationDTO.getStatus())) {
            // Stop here if the application is not in a suitable status
        	_log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The application cannot be invalidated");
        	throw new AppException("The application is cannot be invalidated because is not in the correct status");
        }
        if(voucherSimulationRepository.checkIfApplicationIsFreeze(applicationDTO.getId(), applicationDTO.getCallId(), VoucherAssignmentStatus.FREEZE_LIST.getValue()) >= 1){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Application can't be invalidated because is in freeze list");
            throw new AppException("Application can't be invalidated because is in freeze list");
        }

        List<ApplicationInvalidateReasonDTO> applicationInvalidateReasonDTOS = new ArrayList<>();
        for(Integer integer: invalidReasonViewDTO.getReasons()){
            applicationInvalidateReasonDTOS.add(new ApplicationInvalidateReasonDTO(applicationDTO.getId(), integer));
        }
        applicationDTO.setStatus(ApplicationStatus.KO.getValue());
        legalFileCorrectionReasonRepository.deleteLegalFileCorrectionByRegistrationId(applicationDTO.getRegistrationId());
        applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDTO)));
        applicationService.changeStatusRegistrationDocuments(applicationDTO.getId());

        updateVoucherSimulationNumDuplicates(applicationDTO);

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
        ApplicationDTO applicationDBO = applicationMapper.toDTO(applicationRepository.findOne(applicationDTO.getId()));
        if (applicationDBO == null) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The application does not exist");
            throw new AppException("Incorrect application id");
        } else if (!isPossibleValidateApplication(applicationDTO.getStatus())) {
            // Stop here if the application is not in a suitable status
        	_log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The application cannot be validated");
        	throw new AppException("The application is cannot be invalidated because is not in the correct status");
        }

        applicationDBO.setStatus(ApplicationStatus.OK.getValue());
        deleteInvalidateReasonByApplicationId(applicationDBO.getId());
        if (applicationDTO.getAuthorizedPerson() != null) {
            ApplicationAuthorizedPersonDTO authorizedPersonDTO = new ApplicationAuthorizedPersonDTO();
            authorizedPersonDTO.setAuthorized_person(applicationDTO.getAuthorizedPerson());
            authorizedPersonDTO.setApplicationId(applicationDTO.getId());
            applicant_authorizedPersonMapper.toDTO(application_authorizedPersonRepository.save(applicant_authorizedPersonMapper.toEntity(authorizedPersonDTO)));
        }
        legalFileCorrectionReasonRepository.deleteLegalFileCorrectionByRegistrationId(applicationDBO.getRegistrationId());
        ApplicationDTO validatedApplication = applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDBO)));
        applicationService.changeStatusRegistrationDocuments(applicationDTO.getId());
        /* TODO: The emails are not sent as of the time of this comment, but they will be enabled in the near future.
        updateVoucherSimulationNumDuplicates(applicationDTO);
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
        ApplicationDTO applicationDTO = applicationMapper.toDTO(applicationRepository.findOne(applicationId));
        if (applicationDTO == null) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The application does not exist");
            throw new AppException("Incorrect application id");
        }

        Map<String, Boolean> checks = new HashMap<>();
        boolean valid = false;
        // Has the municipality been notified by email of request for changes
        // If user has uploaded all the requested documents and it's before the deadline, disable buttons
        LogEmail logEmail = logEmailRepository.findLastEmailsSendCorrectionNotUploadedYet(applicationDTO.getId(), Constant.LOG_EMAIL_ACTION_SEND_CORRECTION_EMAILS);
        if (logEmail != null) {
            Calendar deadline = Calendar.getInstance();
            deadline.setTime(new Date(logEmail.getSentDate()));
            deadline.add(Calendar.DATE, UPLOAD_DOCUMENT_CORRECTION_DEADLINE);
            Date currentTime = Calendar.getInstance().getTime();
            // Have more than 7 days overcome since the last request
            if (currentTime.before(deadline.getTime())) {
                valid = true;
            }
        }
        checks.put("invalidate", valid);
        checks.put("validate", valid);
        return checks;
    }

}
