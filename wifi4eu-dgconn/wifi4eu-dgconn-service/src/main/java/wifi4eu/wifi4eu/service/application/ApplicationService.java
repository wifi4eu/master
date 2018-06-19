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
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.entity.application.ApplicationIssueUtil;
import wifi4eu.wifi4eu.entity.warnings.RegistrationWarning;
import wifi4eu.wifi4eu.mapper.application.ApplicantListItemMapper;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.mapper.application.CorrectionRequestEmailMapper;
import wifi4eu.wifi4eu.repository.application.ApplicantListItemRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationIssueUtilRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.application.CorrectionRequestEmailRepository;
import wifi4eu.wifi4eu.repository.warning.RegistrationWarningRepository;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.voucher.VoucherService;
import wifi4eu.wifi4eu.util.ExcelExportGenerator;
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

    @Autowired
    RegistrationWarningRepository registrationWarningRepository;

    @Autowired
    CorrectionRequestEmailMapper correctionRequestEmailMapper;

    @Autowired
    CorrectionRequestEmailRepository correctionRequestEmailRepository;

    @Autowired
    VoucherService voucherService;

    private static final Logger _log = LoggerFactory.getLogger(ApplicationService.class);

    @Autowired
    BeneficiaryService beneficiaryService;

    @Autowired
    ApplicationIssueUtilRepository applicationIssueUtilRepository;

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
            if (queueTimestamp / 1000000000 > callDTO.getStartDate() && queueTimestamp / 1000000000 < callDTO.getEndDate()) {
                //check information on the queue is right
                if (registrationDTO.getUploadTime() == uploadDocTimestamp && registrationDTO.getUserId() == userId) {
                    //check if this application was received previously
                    ApplicationDTO applicationDTO = applicationMapper.toDTO(applicationRepository.findByCallIdAndRegistrationId(callId, registrationId));
                    if (applicationDTO == null || applicationDTO.getDate() > queueTimestamp) {
                        //create the application
                        if (applicationDTO == null) {
                            applicationDTO = new ApplicationDTO();
                            applicationDTO.setRegistrationId(registrationDTO.getId());
                            applicationDTO.setCallId(callDTO.getId());
                        }

                        applicationDTO.setDate(queueTimestamp);

                        applicationDTO = applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDTO)));

                        return applicationDTO;
                    } else {
                        _log.error("trying to register an application existent on the DB, callId: "
                                + callId + " userId: " + userId + " registrationId: " + registrationId +
                                " uploadDocTimestamp" + uploadDocTimestamp + "queueTimestamp" + queueTimestamp);
                        return applicationDTO;
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

    public ApplicationDTO getApplicationByRegistrationId(int callId, int registrationsId) {
        return applicationMapper.toDTO(applicationRepository.findByCallIdAndRegistrationId(callId, registrationsId));
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

    public List<ApplicationDTO> getApplicationsByRegistrationNotInvalidated(int callId) {
        return applicationMapper.toDTOList(applicationRepository.findApplicationsByRegistrationNotInvalidated(callId));
    }

    public Integer countApplicationsNotInvalidated(int callId) {
        return applicationRepository.findApplicationsNotInvalidated(callId);
    }

    public List<ApplicationDTO> getApplicationsByCallFiFoOrder(int callId) {
        return applicationMapper.toDTOList(applicationRepository.findByCallIdOrderByDateAsc(callId));
    }

    public List<ApplicationDTO> findByCallIdOrderByDateBeforeCallDateAsc(int callId, long startDate) {
        return applicationMapper.toDTOList(applicationRepository.findByCallIdOrderByDateBAsc(callId, startDate));

    }

    public List<ApplicationDTO> getApplicationByCallAndCountry(int callId, String country, long date) {
        return applicationMapper.toDTOList(applicationRepository.findApplicationsByCountry(callId, country, date));
    }

    public List<ApplicationDTO> getApplicationsCountryNameCall(int callId, String country) {
        return applicationMapper.toDTOList(applicationRepository.findApplicationsCountry(country, callId));
    }

    public List<Integer> getApplicationsIdByCountryAndNameAndCall(int callId, String country, long date) {
        return applicationRepository.findIdApplications(country, callId, date);
    }

    public Integer countApplicationWithSameMunicipalityName(int lauId, int callId, long date) {
        return applicationRepository.countApplicationsBySameMunicipality(lauId, callId, date);
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

       // setIssues(applicantsList);

        return applicantsList;
    }

    private void setIssues(List<ApplicantListItemDTO> applicantsList) {

      for(ApplicantListItemDTO applicantListItemDTO : applicantsList){
          List<Integer> warnings = registrationWarningRepository.findAllByLauId(applicantListItemDTO.getLauId());
          applicantListItemDTO.setIssueStatus(warnings);
      }
  }

    public ApplicationDTO validateApplication(ApplicationDTO applicationDTO) {
        RegistrationDTO registration = registrationService.getRegistrationById(applicationDTO.getRegistrationId());

        if (registration.getAllFilesFlag() != 1) {
            throw new AppException();
        }
        ApplicationDTO applicationDBO = applicationMapper.toDTO(applicationRepository.findOne(applicationDTO.getId()));
        if (applicationDBO == null) {
            throw new AppException("Incorrect application id");
        }

        applicationDBO.setStatus(ApplicationStatus.OK.getValue());
        applicationDBO.setInvalidateReason(null);
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
        return validatedApplication;
    }

    public ApplicationDTO invalidateApplication(ApplicationDTO applicationDTO) {
        ApplicationDTO applicationDBO = applicationMapper.toDTO(applicationRepository.findOne(applicationDTO.getId()));
        if (applicationDBO == null) {
            throw new AppException("Incorrect application id");
        }
        applicationDBO.setStatus(ApplicationStatus.KO.getValue());
        applicationDBO.setInvalidateReason(applicationDTO.getInvalidateReason());
        ApplicationDTO invalidatedApplication = applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDBO)));
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
        return invalidatedApplication;
    }

    public ApplicationDTO sendLegalDocumentsCorrection(ApplicationDTO application) {
        ApplicationDTO applicationDB = applicationMapper.toDTO(applicationRepository.findOne(application.getId()));
        List<LegalFileCorrectionReasonDTO> legalFiles = registrationService.getLegalFilesByRegistrationId(applicationDB.getRegistrationId());
        boolean pendingFollowup = false;
        for (LegalFileCorrectionReasonDTO legalFile : legalFiles) {
            if (legalFile.getRequestCorrection() && legalFile.getCorrectionReason() != null) {
                pendingFollowup = true;
                break;
            }
        }
        RegistrationDTO registration = registrationService.getRegistrationById(applicationDB.getRegistrationId());
        if (pendingFollowup) {
            registration.setAllFilesFlag(0);
            applicationDB.setStatus(ApplicationStatus.PENDING_FOLLOWUP.getValue());
        } else {
            registration.setAllFilesFlag(1);
            applicationDB.setStatus(ApplicationStatus.HOLD.getValue());
        }
        applicationDB.setInvalidateReason(null);
        registrationService.saveRegistration(registration);
        return applicationMapper.toDTO(applicationRepository.save(applicationMapper.toEntity(applicationDB)));
    }

    public List<ApplicationDTO> getApplicationsByCallId(int callId) {
        return applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findByCallIdOrderByDateAsc(callId)));
    }

    public List<ApplicationDTO> getApplicationsByCallIdAndLauId(int callId, int lauId) {
        List<ApplicationDTO> applications = new ArrayList<>();
        for (ApplicationDTO application : getApplicationsByCallIdAndLauIdCustom(callId, lauId)) {
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

    //Optimal
    private List<ApplicationDTO> getApplicationsByCallIdAndLauIdCustom(int callId, int lauId) {
        return applicationMapper.toDTOList(Lists.newArrayList(applicationRepository.findByCallIdAndLauIdOrderByDateAsc(callId, lauId)));
    }

    public byte[] exportExcelDGConnApplicantsList(Integer callId, String country) {
        int totalCount = municipalityService.getCountDistinctMunicipalitiesThatAppliedCall(callId, country);
        int pageSize = totalCount;
        PagingSortingDTO pagingSortingData = new PagingSortingDTO(0, pageSize, "lauId", 1);
        List<ApplicantListItemDTO> applicants = findDgconnApplicantsList(callId, country, null, pagingSortingData);
        ExcelExportGenerator excelExportGenerator = new ExcelExportGenerator(applicants, ApplicantListItemDTO.class);
        return excelExportGenerator.exportExcelFile("applicants").toByteArray();
    }

    public byte[] exportExcelDGConnApplicantsListContainingName(Integer callId, String country, String name) {
        int totalCount = municipalityService.getCountDistinctMunicipalitiesThatAppliedCallContainingName(callId, country, name);
        int pageSize = totalCount;
        PagingSortingDTO pagingSortingData = new PagingSortingDTO(0, pageSize, "lauId", 1);
        List<ApplicantListItemDTO> applicants = findDgconnApplicantsList(callId, country, name, pagingSortingData);
        ExcelExportGenerator excelExportGenerator = new ExcelExportGenerator(applicants, ApplicantListItemDTO.class);
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
                mailService.sendEmail(application.getUserEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
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

}