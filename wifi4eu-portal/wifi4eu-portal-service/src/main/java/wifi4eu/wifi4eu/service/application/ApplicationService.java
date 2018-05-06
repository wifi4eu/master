package wifi4eu.wifi4eu.service.application;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.MailService;

import java.text.MessageFormat;
import java.time.DateTimeException;
import java.util.*;

@Service
public class ApplicationService {
    @Value("${mail.server.location}")
    private String baseUrl;

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    MailService mailService;

    @Autowired
    UserService userService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    CallService callService;

    private static final Logger _log = LoggerFactory.getLogger(ApplicationService.class);

    @Deprecated
    public List<ApplicationDTO> getAllApplications() {
        return applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findAll()));
    }

    public ApplicationDTO getApplicationById(int applicationId) {
        return applicationMapper.toDTO(applicationRepository.findOne(applicationId));
    }

    /**
     * Service to register the applications coming from the Queue
     */
    public ApplicationDTO registerApplication(int callId, int userId, int registrationId,
                                              long uploadDocTimestamp, long queueTimestamp) {

        CallDTO callDTO = callService.getCallById(callId);
        UserDTO userDTO = userService.getUserById(userId);
        RegistrationDTO registrationDTO = registrationService.getRegistrationById(registrationId);

        // check all the information provided exists on DB
        if (callDTO != null && userDTO != null && registrationDTO != null) {
            // check the queue date is between start/end of the call
            if (queueTimestamp > callDTO.getStartDate() && queueTimestamp < callDTO.getEndDate()) {
                //check information on the queue is right
                if (registrationDTO.getUploadTime() == uploadDocTimestamp && registrationDTO.getUserId() == userId) {
                    //check if this application was received previously
                    ApplicationDTO applicationDTO = applicationMapper.toDTO(applicationRepository.findByCallIdAndRegistrationId(callId, registrationId));
                    if (applicationDTO == null) {
                        //create the application
                        applicationDTO = new ApplicationDTO();
                        applicationDTO.setCallId(callDTO.getId());
                        applicationDTO.setDate(queueTimestamp);
                        applicationDTO.setRegistrationId(registrationDTO.getId());

                        applicationDTO = applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDTO)));

                        return applicationDTO;
                    } else {
                        _log.error("trying to register an application existent on the DB, callId: "
                                + callId + " userId: " + userId + " registrationId: " + registrationId +
                                " uploadDocTimestamp" + uploadDocTimestamp + "queueTimestamp" + queueTimestamp);
                    }

                } else {
                    _log.error("trying to register an application with incorrect uploadDocTimestamp or userId not match, callId: "
                            + callId + " userId: " + userId + " registrationId: " + registrationId +
                            " uploadDocTimestamp" + uploadDocTimestamp + "queueTimestamp" + queueTimestamp);
                }

            } else {
                _log.error("trying to register an application out of the call period, callId: "
                        + callId + " userId: " + userId + " registrationId: " + registrationId +
                        " uploadDocTimestamp" + uploadDocTimestamp + "queueTimestamp" + queueTimestamp);
            }

        } else {
            _log.error("the information provided is wrong, callId: "
                    + callId + " userId: " + userId + " registrationId: " + registrationId +
                    " uploadDocTimestamp" + uploadDocTimestamp + "queueTimestamp" + queueTimestamp);
        }

        return null;
    }

    @Transactional
    @Deprecated
    public ApplicationDTO createApplication(ApplicationDTO applicationDTO) {
        CallDTO actualCall = callService.getCallById(applicationDTO.getCallId());
        long startCallDate = actualCall.getStartDate();
        long actualDateTime = (new Date()).getTime();
        if (startCallDate > actualDateTime) {
            throw new DateTimeException("The call is not available at the moment");
        }
        RegistrationDTO registration = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
        UserDTO user = null;
        MunicipalityDTO municipality = null;
        if (registration.getAllFilesFlag() == 1) {
            if (registration != null) {
                user = userService.getUserById(registration.getUserId());
                municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
            }
            if (user != null && municipality != null) {
                Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                if (user.getLang() != null) {
                    locale = new Locale(user.getLang());
                }
                ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                String subject = bundle.getString("mail.voucherApply.subject");
                String msgBody = bundle.getString("mail.voucherApply.body");
                msgBody = MessageFormat.format(msgBody, municipality.getName());
                if (!userService.isLocalHost()) {
                    mailService.sendEmail(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
                }
            }
            return applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDTO)));
        }
        return null;
    }

    @Transactional
    @Deprecated
    public ApplicationDTO deleteApplication(int applicationId) {
        ApplicationDTO applicationDTO = applicationMapper.toDTO(applicationRepository.findOne(applicationId));
        if (applicationDTO != null) {
            applicationRepository.delete(applicationMapper.toEntity(applicationDTO));
            return applicationDTO;
        } else {
            return null;
        }
    }

    public List<ApplicationDTO> getApplicationsBySupplierId(int supplierId) {
        return applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findBySupplierId(supplierId)));
    }

    public ApplicationDTO getApplicationByCallIdAndRegistrationId(int callId, int registrationId) {
        return applicationMapper.toDTO(applicationRepository.findByCallIdAndRegistrationId(callId, registrationId));
    }

    public List<ApplicationDTO> getApplicationsByRegistrationId(int registrationId) {
        return applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findByRegistrationId(registrationId)));
    }

    public List<ApplicationVoucherInfoDTO> getApplicationsVoucherInfoByCall(int callId) {
        List<ApplicationVoucherInfoDTO> applicationsVoucherInfo = new ArrayList<>();
        List<ApplicationDTO> applications = applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findByCallId(callId)));
        for (final ApplicationDTO appDTO : applications) {
            RegistrationDTO regDTO = registrationService.getRegistrationById(appDTO.getRegistrationId());
            if (regDTO != null) {
                final MunicipalityDTO munDTO = municipalityService.getMunicipalityById(regDTO.getMunicipalityId());
                if (munDTO != null) {
                    ApplicationVoucherInfoDTO appVoucherInfoItem = new ApplicationVoucherInfoDTO(callId, appDTO.getId(), munDTO.getName(), munDTO.getCountry(), appDTO.isVoucherAwarded());
                    applicationsVoucherInfo.add(appVoucherInfoItem);
                }
            }
        }
        return applicationsVoucherInfo;
    }

    public ApplicationVoucherInfoDTO getApplicationsVoucherInfoByApplication(int applicationId) {
        ApplicationVoucherInfoDTO appVoucherInfoDTO = null;
        ApplicationDTO appDTO = getApplicationById(applicationId);
        if (appDTO != null) {
            RegistrationDTO regDTO = registrationService.getRegistrationById(appDTO.getRegistrationId());
            if (regDTO != null) {
                MunicipalityDTO munDTO = municipalityService.getMunicipalityById(regDTO.getMunicipalityId());
                if (munDTO != null) {
                    appVoucherInfoDTO = new ApplicationVoucherInfoDTO(appDTO.getCallId(), applicationId, munDTO.getName(), munDTO.getCountry(), appDTO.isVoucherAwarded());
                }
            }
        }
        return appVoucherInfoDTO;
    }
}