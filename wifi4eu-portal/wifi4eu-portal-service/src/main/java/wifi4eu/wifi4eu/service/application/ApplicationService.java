package wifi4eu.wifi4eu.service.application;

import java.text.MessageFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.ApplicationStatus;
import wifi4eu.wifi4eu.common.enums.LegalFileStatus;
import wifi4eu.wifi4eu.common.enums.LegalFileValidationStatus;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.application.ApplicationIssueUtil;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.mapper.application.ApplicantListItemMapper;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.mapper.application.CorrectionRequestEmailMapper;
import wifi4eu.wifi4eu.mapper.municipality.MunicipalityMapper;
import wifi4eu.wifi4eu.mapper.registration.legal_files.LegalFilesMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.application.ApplicantListItemRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationIssueUtilRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.application.CorrectionRequestEmailRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.repository.warning.RegistrationWarningRepository;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.voucher.VoucherService;
import wifi4eu.wifi4eu.util.ExcelExportGenerator;

@Service
public class ApplicationService {
    private static final Logger _log = LogManager.getLogger(ApplicationService.class);

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

    @Autowired
    RegistrationWarningRepository registrationWarningRepository;

    @Autowired
    CorrectionRequestEmailMapper correctionRequestEmailMapper;

    @Autowired
    CorrectionRequestEmailRepository correctionRequestEmailRepository;

    @Autowired
    VoucherService voucherService;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    BeneficiaryService beneficiaryService;

    @Autowired
    ApplicationIssueUtilRepository applicationIssueUtilRepository;

    @Autowired
    RegistrationUsersRepository registrationUsersRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MunicipalityMapper municipalityMapper;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    LegalFilesRepository legalFilesRepository;

    @Autowired
    LegalFilesMapper legalFilesMapper;

    public ApplicationDTO getApplicationById(int applicationId) {
        return applicationMapper.toDTO(applicationRepository.findOne(applicationId));
    }

    /**
     * Service to register the applications coming from the Queue
     */
    public ApplicationDTO registerApplication(int callId, int userId, int registrationId, int municipalityId,
                                              long uploadDocTimestamp, long queueTimestamp, HttpServletRequest request) {
        _log.debug("Registering application");
        CallDTO callDTO = callService.getCallById(callId);
        UserDTO userDTO = userService.getUserById(userId);
        RegistrationDTO registrationDTO = registrationService.getRegistrationById(registrationId);
        MunicipalityDTO municipalityDTO = municipalityMapper.toDTO(municipalityRepository.findOne(municipalityId));
        // check all the information provided exists on DB
        if (callDTO != null && userDTO != null && registrationDTO != null && municipalityDTO != null) {
            _log.debug("All information provided exists");
            // check the queue date is between start/end of the call
            if (queueTimestamp >= callDTO.getStartDate() && queueTimestamp <= callDTO.getEndDate()) {
                _log.debug("The queue is from the specified call");
                //check information on the queue is right
                //if (registrationDTO.getUploadTime() == uploadDocTimestamp) {
                _log.debug("All the information of this queue is right");
                //check if this application was received previously
                ApplicationDTO applicationDTO = applicationMapper.toDTO(applicationRepository.findByCallIdAndRegistrationId(callId, registrationId));
                if (applicationDTO == null || applicationDTO.getDate() > queueTimestamp) {
                    //create the application
                    if (applicationDTO == null) {
                        applicationDTO = new ApplicationDTO();
                        applicationDTO.setRegistrationId(registrationDTO.getId());
                        applicationDTO.setCallId(callDTO.getId());
                        _log.debug("New application created");
                    }
                    applicationDTO.setDate(queueTimestamp);
                    applicationDTO = applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDTO)));
                    _log.info("Application " + applicationDTO.getId() + " created successfully");
                    return applicationDTO;
                } else {
                    _log.error("Trying to register an application existent on the DB, callId: "
                            + callId + " userId: " + userId + " registrationId: " + registrationId +
                            " uploadDocTimestamp" + uploadDocTimestamp + "queueTimestamp" + queueTimestamp);
                    return applicationDTO;
                }
            } else {
                _log.error("Trying to register an application with incorrect uploadDocTimestamp, callId: "
                        + callId + " userId: " + userId + " registrationId: " + registrationId +
                        " uploadDocTimestamp" + uploadDocTimestamp + "queueTimestamp" + queueTimestamp);
            }
        } else {
            _log.error("Trying to register an application out of the call period, callId: "
                    + callId + " userId: " + userId + " registrationId: " + registrationId +
                    " uploadDocTimestamp" + uploadDocTimestamp + "queueTimestamp" + queueTimestamp);
        }
//        } else {
//            _log.error("The information provided is wrong, callId: "
//                    + callId + " userId: " + userId + " registrationId: " + registrationId +
//                    " uploadDocTimestamp" + uploadDocTimestamp + "queueTimestamp" + queueTimestamp);
//        }
        return null;
    }

    @Transactional
    @Deprecated
    public ApplicationDTO createApplication(ApplicationDTO applicationDTO, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Creating application");
        CallDTO actualCall = callService.getCallById(applicationDTO.getCallId());
        long startCallDate = actualCall.getStartDate();
        long actualDateTime = (new Date()).getTime();
        if (startCallDate > actualDateTime) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The call is not available at the moment");
            throw new DateTimeException("The call is not available at the moment");
        }
        RegistrationDTO registration = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
        if (registration.getAllFilesFlag() == 1) {
            if (applicationDTO.getId() != 0) {
                _log.warn("Call to a create method with id set, the value has been removed ({})", applicationDTO.getId());
                applicationDTO.setId(0);
            }
            ApplicationDTO application = applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDTO)));
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Application created");
            return application;
        }
        return null;
    }


    public void sendCreateApplicationEmail(User user, Municipality municipality, int applicationId) {
        Locale locale = new Locale(UserConstants.DEFAULT_LANG);
        if (user.getLang() != null) {
            locale = new Locale(user.getLang());
        } else {
            _log.warn("SCHEDULED TASK: Create Application Emails - The user " + user.getEcasUsername() + " has not specified a language");
        }

        MailData mailData = MailHelper.buildMailCreateApplication(
                user.getEcasEmail(), MailService.FROM_ADDRESS,
                municipality.getId(), municipality.getName(), "createApplication", locale);
        mailService.sendMail(mailData, true);
        _log.log(Level.getLevel("BUSINESS"), "SCHEDULED TASK: Create Application Emails - Email sent to " + user.getEcasEmail() + " for the " + "application id: " + applicationId);
    }

    @Transactional
    @Deprecated
    public ApplicationDTO deleteApplication(int applicationId, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Removing application");
        ApplicationDTO applicationDTO = applicationMapper.toDTO(applicationRepository.findOne(applicationId));
        if (applicationDTO != null) {
            applicationRepository.delete(applicationMapper.toEntity(applicationDTO));
            return applicationDTO;
        } else {
            return null;
        }
    }

    public ApplicationDTO getApplicationByCallIdAndRegistrationId(int callId, int registrationId) {
        return applicationMapper.toDTO(applicationRepository.findByCallIdAndRegistrationId(callId, registrationId));
    }

    public ApplicationDTO getVoucherApplicationByCallIdAndRegistrationId(int callId, int registrationId) {
        return applicationMapper.toDTO(applicationRepository.findVoucherApplicationByCallIdAndRegistrationId(callId, registrationId));
    }

    public List<ApplicationDTO> getApplicationsByRegistrationId(int registrationId) {
        return applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findByRegistrationId(registrationId)));
    }


    public ApplicationDTO getApplicationByRegistrationId(int registrationId) {
        return applicationMapper.toDTO(applicationRepository.findTopByRegistrationIdOrderByDateDesc(registrationId));
    }

    public List<ApplicationDTO> applicationsByListOfMunicipalities(Integer userId) {
        return applicationMapper.toDTOList(applicationRepository.findApplicationsByMunicipalities(userId));
    }

    public List<ApplicationVoucherInfoDTO> getApplicationsVoucherInfoByCall(int callId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving applications' voucher information");
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

    public Integer countApplicationsNotInvalidated(int callId) {
        return applicationRepository.findApplicationsNotInvalidated(callId);
    }

    public List<ApplicationDTO> findByCallIdOrderByDateBeforeCallDateAsc(int callId, long startDate) {
        return applicationMapper.toDTOList(applicationRepository.findByCallIdOrderByDateBAsc(callId, startDate));
    }

    public List<ApplicationDTO> getApplicationByCallAndCountry(int callId, String country, long date) {
        return applicationMapper.toDTOList(applicationRepository.findApplicationsByCountry(callId, country, date));
    }

    public Integer countApplicationWithSameMunicipalityName(int lauId, int callId, long date) {
        return applicationRepository.countApplicationsBySameMunicipality(lauId, callId, date);
    }

    public List<ApplicantListItemDTO> findDgconnApplicantsList(Integer callId, String country, String name, PagingSortingDTO pagingSortingData) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving applicants");
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
        return applicantsList;
    }

    public List<ApplicationDTO> getApplicationsByCallIdAndLauId(int callId, int lauId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving applications");
        return applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findByCallIdAndLauIdOrderByDateAsc(callId, lauId)));
    }

    public byte[] exportExcelDGConnApplicantsList(Integer callId, String country) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Exporting excel");
        PagingSortingDTO pagingSortingData = new PagingSortingDTO(0,
                municipalityService.getCountDistinctMunicipalitiesThatAppliedCall(callId, country), "lauId", 1);
        List<ApplicantListItemDTO> applicants = findDgconnApplicantsList(callId, country, null, pagingSortingData);

        ExcelExportGenerator excelExportGenerator = new ExcelExportGenerator(applicants, ApplicantListItemDTO.class);
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Excel exported");
        return excelExportGenerator.exportExcelFile("applicants").toByteArray();
    }

    public byte[] exportExcelDGConnApplicantsListContainingName(Integer callId, String country, String name) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Exporting excel");
        int pageSize = municipalityService.getCountDistinctMunicipalitiesThatAppliedCallContainingName(callId, country, name);
        PagingSortingDTO pagingSortingData = new PagingSortingDTO(0, pageSize, "lauId", 1);
        List<ApplicantListItemDTO> applicants = findDgconnApplicantsList(callId, country, name, pagingSortingData);

        ExcelExportGenerator excelExportGenerator = new ExcelExportGenerator(applicants, ApplicantListItemDTO.class);
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Excel exported");
        return excelExportGenerator.exportExcelFile("applicants").toByteArray();
    }

    public CorrectionRequestEmailDTO sendCorrectionEmails(Integer callId) throws Exception {
        List<ApplicationIssueUtil> applications = applicationIssueUtilRepository.findApplicationIssueUtilByCallAndStatus(callId, ApplicationStatus.PENDING_FOLLOWUP.getValue());
        CorrectionRequestEmailDTO correctionRequest = null;
        CorrectionRequestEmailDTO lastCorrectionRequestEmail = getLastCorrectionRequestEmailInCall(callId);
        Integer buttonPressedCounter;
        if (lastCorrectionRequestEmail != null) {
            buttonPressedCounter = lastCorrectionRequestEmail.getButtonPressedCounter() + 1;
        } else {
            buttonPressedCounter = 1;
        }
        if (!applications.isEmpty()) {
            for (ApplicationIssueUtil application : applications) {
                Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                if (application.getUserLang() != null) {
                    locale = new Locale(application.getUserLang());
                }

                // TODO move this logic to MailHelper.java
                ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                String subject = bundle.getString("mail.correctionRequestEmail.subject");
                String msgBody = bundle.getString("mail.correctionRequestEmail.body");
                String[] correctionReasons = new String[6];
                correctionReasons[0] = bundle.getString("mail.correctionRequestEmail.reason1");
                correctionReasons[1] = bundle.getString("mail.correctionRequestEmail.reason2");
                correctionReasons[2] = bundle.getString("mail.correctionRequestEmail.reason3");
                correctionReasons[3] = bundle.getString("mail.correctionRequestEmail.reason4");
                correctionReasons[4] = bundle.getString("mail.correctionRequestEmail.reason5");
                correctionReasons[5] = bundle.getString("mail.correctionRequestEmail.reason6");
                String[] documentTypes = {"", "", "", ""};
                List<LegalFileCorrectionReasonDTO> legalFilesCorrectionReasons = registrationService.getLegalFilesByRegistrationId(application.getRegistrationId());
                for (LegalFileCorrectionReasonDTO legalFileCorrectionReason : legalFilesCorrectionReasons) {
                    String emailString = "";
                    switch (legalFileCorrectionReason.getType()) {
                        case 1:
                            emailString = bundle.getString("mail.correctionRequestEmail.type1");
                            documentTypes[0] = MessageFormat.format(emailString, correctionReasons[legalFileCorrectionReason.getCorrectionReason()]);
                            break;
                        case 2:
                            emailString = bundle.getString("mail.correctionRequestEmail.type3");
                            documentTypes[1] = MessageFormat.format(emailString, correctionReasons[legalFileCorrectionReason.getCorrectionReason()]);
                            break;
                        case 3:
                            emailString = bundle.getString("mail.correctionRequestEmail.type2");
                            documentTypes[2] = MessageFormat.format(emailString, correctionReasons[legalFileCorrectionReason.getCorrectionReason()]);
                            break;
                        case 4:
                            emailString = bundle.getString("mail.correctionRequestEmail.type4");
                            documentTypes[3] = MessageFormat.format(emailString, correctionReasons[legalFileCorrectionReason.getCorrectionReason()]);
                            break;
                    }
                }
                msgBody = MessageFormat.format(msgBody, documentTypes);
                Registration registration = registrationRepository.findOne(application.getRegistrationId());
                if (registration != null) {
                    MailData mailData = new MailData(application.getUserEcasEmail(), MailService.FROM_ADDRESS,
                            subject, msgBody, locale,
                            registration.getMunicipality().getId(), Constant.LOG_EMAIL_ACTION_SEND_CORRECTION_EMAILS, true);
                    mailService.sendMail(mailData, false);
                }
            }
            correctionRequest = new CorrectionRequestEmailDTO(null, callId, new Date().getTime(), buttonPressedCounter);
            correctionRequest = correctionRequestEmailMapper.toDTO(correctionRequestEmailRepository.save(correctionRequestEmailMapper.toEntity(correctionRequest)));
        }
        return correctionRequest;
    }

    public CorrectionRequestEmailDTO getLastCorrectionRequestEmailInCall(Integer callId) {
        List<CorrectionRequestEmailDTO> correctionRequests = correctionRequestEmailMapper.toDTOList(correctionRequestEmailRepository.findAllByCallIdOrderByDateDesc(callId));
        if (!correctionRequests.isEmpty()) {
            return correctionRequests.get(0);
        } else {
            return null;
        }
    }

    public boolean checkIfCorrectionRequestEmailIsAvailable(Integer callId) {
        CallDTO call = callService.getCallById(callId);
        if (call != null) {
            long currentTime = new Date().getTime();
            if (call.getStartDate() < currentTime && call.getEndDate() > currentTime) {
                List<ApplicationDTO> pendingFollowupApps = applicationMapper.toDTOList(applicationRepository.findByCallIdAndStatus(call.getId(), ApplicationStatus.PENDING_FOLLOWUP.getValue()));
                if (!pendingFollowupApps.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public ApplicationDTO rejectApplicationVoucherAssigment(int applicationId) {
        ApplicationDTO applicationDTO = getApplicationById(applicationId);
        if (applicationDTO == null) {
            throw new AppException("Application not found with id: " + applicationId);
        }

        VoucherAssignmentAuxiliarDTO voucherAssignmentAuxiliar = voucherService.getVoucherAssignmentAuxiliarByCall
                (applicationDTO.getCallId());
        if (voucherAssignmentAuxiliar == null || !voucherAssignmentAuxiliar.getHasPreListSaved()) {
            throw new AppException("Pre List hasn't been saved for the call of the application with id: " +
                    applicationId);
        }

        applicationDTO.setRejected(true);
        return applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDTO)));
    }

    public ApplicationDTO selectApplicationVoucherAssigment(int applicationId) {
        ApplicationDTO applicationDTO = getApplicationById(applicationId);
        if (applicationDTO == null) {
            throw new AppException("Application not found with id: " + applicationId);
        }

        VoucherAssignmentAuxiliarDTO voucherAssignmentAuxiliar = voucherService.getVoucherAssignmentAuxiliarByCall
                (applicationDTO.getCallId());
        if (voucherAssignmentAuxiliar == null || !voucherAssignmentAuxiliar.getHasPreListSaved()) {
            throw new AppException("Pre List hasn't been saved for the call of the application with id: " +
                    applicationId);
        }

        applicationDTO.setRejected(false);
        return applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDTO)));
    }


    @Transactional
    public ResponseDTO changeStatusRegistrationDocuments(Integer applicationId) {
        ApplicationDTO applicationDTO = applicationMapper.toDTO(applicationRepository.findOne(applicationId));
        List<LegalFileDTO> legalFileDTOS = legalFilesMapper.toDTOList(legalFilesRepository.findByRegistration(applicationDTO.getRegistrationId()));
        if (!legalFileDTOS.isEmpty()) {
            for (LegalFileDTO legalFileDTO : legalFileDTOS) {
                if (legalFileDTO.getIsNew() == LegalFileStatus.RECENT.getValue()) {
                    legalFileDTO.setIsNew(LegalFileStatus.OLD.getValue());
                }
                if (legalFileDTO.getIsNew() == LegalFileStatus.NEW.getValue()) {
                    if (applicationDTO.getStatus() == ApplicationStatus.KO.getValue()) {
                        legalFileDTO.setStatus(LegalFileValidationStatus.INVALID.getValue());
                    } else if (applicationDTO.getStatus() == ApplicationStatus.OK.getValue()) {
                        legalFileDTO.setStatus(LegalFileValidationStatus.VALID.getValue());
                    }
                    legalFileDTO.setIsNew(LegalFileStatus.RECENT.getValue());
                }
                legalFilesRepository.save(legalFilesMapper.toEntity(legalFileDTO));
            }
        }
        return new ResponseDTO(true, "success", null);
    }

}