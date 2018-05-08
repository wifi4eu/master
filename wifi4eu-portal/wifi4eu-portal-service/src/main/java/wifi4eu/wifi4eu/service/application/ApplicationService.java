package wifi4eu.wifi4eu.service.application;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.enums.ApplicationStatus;
import wifi4eu.wifi4eu.mapper.application.ApplicantListItemMapper;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicantListItemRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;
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
    ApplicantListItemMapper applicantListItemMapper;

    @Autowired
    ApplicantListItemRepository applicantListItemRepository;

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

    @Autowired
    BeneficiaryService beneficiaryService;

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
        List<ApplicationDTO> applications = applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findByCallIdOrderByDateAsc(callId)));
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

    public List<ApplicantListItemDTO> findDgconnApplicantsList(Integer callId, String country, String name, PagingSortingDTO pagingSortingData) {
        List<ApplicantListItemDTO> applicantsList;
        if (country == null) {
            country = "%";
        }
        switch (pagingSortingData.getOrderField()) {
            case "name":
                if (pagingSortingData.getOrderType() == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListContainingNameOrderByNameDesc(callId, country, name, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                            break;
                        }
                    }
                    applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListOrderByNameDesc(callId, country, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListContainingNameOrderByNameAsc(callId, country, name, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                            break;
                        }
                    }
                    applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListOrderByNameAsc(callId, country, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                }
                break;
            case "countryCode":
                if (pagingSortingData.getOrderType() == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListContainingNameOrderByCountryCodeDesc(callId, country, name, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                            break;
                        }
                    }
                    applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListOrderByCountryCodeDesc(callId, country, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListContainingNameOrderByCountryCodeAsc(callId, country, name, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                            break;
                        }
                    }
                    applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListOrderByCountryCodeAsc(callId, country, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                }
                break;
            case "counter":
                if (pagingSortingData.getOrderType() == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListContainingNameOrderByCounterDesc(callId, country, name, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                            break;
                        }
                    }
                    applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListOrderByCounterDesc(callId, country, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListContainingNameOrderByCounterAsc(callId, country, name, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                            break;
                        }
                    }
                    applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListOrderByCounterAsc(callId, country, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                }
                break;
            case "mediation":
                if (pagingSortingData.getOrderType() == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListContainingNameOrderByMediationDesc(callId, country, name, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                            break;
                        }
                    }
                    applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListOrderByMediationDesc(callId, country, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListContainingNameOrderByMediationAsc(callId, country, name, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                            break;
                        }
                    }
                    applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListOrderByMediationAsc(callId, country, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                }
                break;
            default:
                if (pagingSortingData.getOrderType() == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListContainingNameOrderByLauIdDesc(callId, country, name, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                            break;
                        }
                    }
                    applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListOrderByLauIdDesc(callId, country, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListContainingNameOrderByLauIdAsc(callId, country, name, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                            break;
                        }
                    }
                    applicantsList = applicantListItemMapper.toDTOList(applicantListItemRepository.findDgconnApplicantsListOrderByLauIdAsc(callId, country, pagingSortingData.getOffset(), pagingSortingData.getCount()));
                }
                break;
        }
        for (int i = 0; i < applicantsList.size(); i++) {
            ApplicantListItemDTO applicant = applicantsList.get(i);
            if (applicant.getCounter() == 1) {
                List<RegistrationDTO> registrations = registrationService.getRegistrationsByLauId(applicant.getLauId());
                for (RegistrationDTO registration : registrations) {
                    if (registration != null) {
                        applicant.setIssueStatus(registrationService.getRegistrationIssue(registration));
                    }
                }
            } else {
                applicant.setIssueStatus(0);
            }
            applicantsList.set(i, applicant);
        }
        return applicantsList;
    }

    public ApplicationDTO validateApplication(ApplicationDTO applicationDTO) {
        ApplicationDTO validatedApplication = applicationDTO;
        RegistrationDTO registration = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
        if (registration != null) {
            UserDTO user = userService.getUserById(registration.getUserId());
            MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
            if (user != null && municipality != null) {
                List<ApplicationDTO> repeatedApplications = getApplicationsByCallIdAndLauId(applicationDTO.getCallId(), municipality.getLauId());
                for (ApplicationDTO repeatedApplication : repeatedApplications) {
                    if (repeatedApplication.getId() == applicationDTO.getId()) {
                        repeatedApplication.setStatus(ApplicationStatus.OK.getValue());
                        repeatedApplication.setInvalidateReason(null);
                        validatedApplication = applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDTO)));
                        Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                        if (user.getLang() != null) {
                            locale = new Locale(user.getLang());
                        }
                        //Mails deactivated until 1.4.2 phase 2
                        /*ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                        String subject = bundle.getString("mail.validateApplication.subject");
                        String msgBody = bundle.getString("mail.validateApplication.body");
                        msgBody = MessageFormat.format(msgBody, municipality.getName());
                        mailService.sendEmail(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);*/
                    } else {
                        invalidateApplication(repeatedApplication);
                    }
                }
            }
        }
        return validatedApplication;
    }

    public ApplicationDTO invalidateApplication(ApplicationDTO applicationDTO) {
        applicationDTO.setStatus(ApplicationStatus.KO.getValue());
        ApplicationDTO invalidatedApplication = applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDTO)));
        RegistrationDTO registration = registrationService.getRegistrationById(invalidatedApplication.getRegistrationId());
        if (registration != null) {
            UserDTO user = userService.getUserById(registration.getUserId());
            MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
            if (user != null && municipality != null) {
                Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                if (user.getLang() != null) {
                    locale = new Locale(user.getLang());
                }
                //Mails deactivated until 1.4.2 phase 2
                /*ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                String subject = bundle.getString("mail.invalidateApplication.subject");
                String msgBody = bundle.getString("mail.invalidateApplication.body");
                msgBody = MessageFormat.format(msgBody, municipality.getName());
                mailService.sendEmail(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);*/
            }
        }
        return invalidatedApplication;
    }

    public List<ApplicationDTO> getApplicationsByCallId(int callId) {
        return applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findByCallIdOrderByDateAsc(callId)));
    }

    public List<ApplicationDTO> getApplicationsByCallIdAndLauId(int callId, int lauId) {
        List<ApplicationDTO> applications = new ArrayList<>();
        for (ApplicationDTO application : getApplicationsByCallId(callId)) {
            RegistrationDTO registration = registrationService.getRegistrationById(application.getRegistrationId());
            if (registration != null) {
                MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
                if (municipality != null) {
                    if (municipality.getLauId() == lauId) {
                        applications.add(application);
                    }
                }
            }
        }
        return applications;
    }
}