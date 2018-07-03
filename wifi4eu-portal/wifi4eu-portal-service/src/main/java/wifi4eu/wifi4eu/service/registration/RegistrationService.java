package wifi4eu.wifi4eu.service.registration;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.cns.CNSManager;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.FileTypes;
import wifi4eu.wifi4eu.common.enums.RegistrationStatus;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.supplier.Supplier;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.mapper.registration.LegalFileCorrectionReasonMapper;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.mapper.registration.legal_files.LegalFilesMapper;
import wifi4eu.wifi4eu.mapper.registrationWarning.RegistrationWarningMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationIssueUtilRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.registration.LegalFileCorrectionReasonRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.legal_files.LegalFilesService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.warning.RegistrationWarningService;
import wifi4eu.wifi4eu.util.MailService;
import wifi4eu.wifi4eu.util.UserUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.*;

@Service("portalRegistrationService")
public class RegistrationService {
    private final Logger _log = LogManager.getLogger(RegistrationService.class);

    @Autowired
    RegistrationMapper registrationMapper;

    @Autowired
    RegistrationWarningMapper registrationWarningMapper;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    ApplicationIssueUtilRepository applicationIssueUtilRepository;

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
    LauService lauService;

    @Autowired
    MayorService mayorService;

    @Autowired
    LegalFilesMapper legalFilesMapper;

    @Autowired
    LegalFilesRepository legalFilesRepository;

    @Autowired
    LegalFileCorrectionReasonMapper legalFileCorrectionReasonMapper;

    @Autowired
    RegistrationWarningService registrationWarningService;

    @Autowired
    LegalFileCorrectionReasonRepository legalFileCorrectionReasonRepository;

    @Autowired
    CNSManager cnsManager;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    UserUtils userUtils;

    @Autowired
    SupplierService supplierService;

    @Autowired
    SupplierMapper supplierMapper;

    public List<RegistrationDTO> getAllRegistrations() {
        return registrationMapper.toDTOList(Lists.newArrayList(registrationRepository.findAll()));
    }


    public RegistrationDTO getRegistrationById(int registrationId) {
        Registration registration = registrationRepository.findOne(registrationId);
        RegistrationDTO registrationDTO = registrationMapper.toDTO(registration);
        registrationDTO.setRegistrationWarningDTOList(registrationWarningMapper.toDTOList(registration.getRegistrationWarningList()));
        return registrationDTO;
    }

    @Transactional
    public RegistrationDTO createRegistration(RegistrationDTO registrationDTO) {
        if (registrationDTO.getId() == 0) {
            registrationDTO.setMailCounter(3);
        }
        RegistrationDTO registrationCreated = saveRegistration(registrationDTO);
        registrationWarningService.createWarningsByRegistration(registrationCreated);
        return registrationCreated;
    }

    @Transactional
    public RegistrationDTO deleteRegistrationDocuments(RegistrationDTO registrationDTO, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        RegistrationDTO registrationDBO = registrationMapper.toDTO(registrationRepository.findOne(registrationDTO.getId()));
        if (registrationDBO.getAllFilesFlag() != 1) {
            if (registrationDTO.getLegalFile1Mime() == null || registrationDTO.getLegalFile1Size() <= 0) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 1);
                _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Deleted legal document number 1");
                registrationDBO.setLegalFile1Mime(null);
                registrationDBO.setLegalFile1Size(0);
            }

            if (registrationDTO.getLegalFile2Mime() == null || registrationDTO.getLegalFile2Size() <= 0) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 2);
                _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Deleted legal document number 3");
                registrationDBO.setLegalFile2Mime(null);
                registrationDBO.setLegalFile2Size(0);
            }

            if (registrationDTO.getLegalFile3Mime() == null || registrationDTO.getLegalFile3Size() <= 0) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 3);
                _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Deleted legal document number 2");
                registrationDBO.setLegalFile3Mime(null);
                registrationDBO.setLegalFile3Size(0);
            }

            if (registrationDTO.getLegalFile4Mime() == null || registrationDTO.getLegalFile4Size() <= 0) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 4);
                _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Deleted legal document number 4");
                registrationDBO.setLegalFile4Mime(null);
                registrationDBO.setLegalFile4Size(0);
            }
        }
        return registrationMapper.toDTO(registrationRepository.save(registrationMapper.toEntity(registrationDBO)));
    }

    @Transactional
    public RegistrationDTO updateRegistrationDocuments(RegistrationDTO registrationDTO, HttpServletRequest request) throws Exception {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        RegistrationDTO registrationDBO = registrationMapper.toDTO(registrationRepository.findOne(registrationDTO.getId()));
        Long currentTime = new Date().getTime();
        String lf1 = registrationDTO.getLegalFile1Mime();
        if (lf1 != null) {
            byte[] lf1ByteArray = Base64.getMimeDecoder().decode(LegalFilesService.getBase64Data(lf1));
            String lf1Extension = LegalFilesService.getValidFileExtension(lf1);
            if (lf1ByteArray.length > 1024000) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File size cannot bet greater than 1 MB");
                throw new Exception("File size cannot bet greater than 1 MB.");
            } else if (lf1Extension == null) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File must have a valid extension");
                throw new Exception("File must have a valid extension.");
            } else {
                LegalFilesDTO legalFilesDTO = legalFilesMapper.toDTO(legalFilesRepository.findByRegistrationAndFileType(registrationDBO.getId(), FileTypes.LEGALFILE1.getValue()));
                if (legalFilesDTO == null) {
                    legalFilesDTO = new LegalFilesDTO();
                }
                legalFilesDTO.setRegistration(registrationDBO.getId());
                legalFilesDTO.setFileType(FileTypes.LEGALFILE1.getValue());
                legalFilesDTO.setFileData(LegalFilesService.getBase64Data(lf1));
                legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));
                registrationDBO.setLegalFile1Mime(LegalFilesService.getMimeType(lf1));
                registrationDBO.setLegalFile1Size(lf1ByteArray.length);
                registrationDBO.setUploadTime(currentTime);
                _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Updated legal document number 1");
            }
        }
        String lf2 = registrationDTO.getLegalFile2Mime();
        if (lf2 != null) {
            byte[] lf2ByteArray = Base64.getMimeDecoder().decode(LegalFilesService.getBase64Data(lf2));
            String lf2Extension = LegalFilesService.getValidFileExtension(lf2);
            if (lf2ByteArray.length > 1024000) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File size cannot bet greater than 1 MB");
                throw new Exception("File size cannot bet greater than 1 MB.");
            } else if (lf2Extension == null) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File must have a valid extension");
                throw new Exception("File must have a valid extension.");
            } else {
                LegalFilesDTO legalFilesDTO = legalFilesMapper.toDTO(legalFilesRepository.findByRegistrationAndFileType(registrationDBO.getId(), FileTypes.LEGALFILE2.getValue()));
                if (legalFilesDTO == null) {
                    legalFilesDTO = new LegalFilesDTO();
                }
                legalFilesDTO.setRegistration(registrationDBO.getId());
                legalFilesDTO.setFileType(FileTypes.LEGALFILE2.getValue());
                legalFilesDTO.setFileData(LegalFilesService.getBase64Data(lf2));
                legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));
                registrationDBO.setLegalFile2Mime(LegalFilesService.getMimeType(lf2));
                registrationDBO.setLegalFile2Size(lf2ByteArray.length);
                registrationDBO.setUploadTime(currentTime);
                _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Updated legal document number 2");
            }
        }
        String lf3 = registrationDTO.getLegalFile3Mime();
        if (lf3 != null) {
            byte[] lf3ByteArray = Base64.getMimeDecoder().decode(LegalFilesService.getBase64Data(lf3));
            String lf3Extension = LegalFilesService.getValidFileExtension(lf3);
            if (lf3ByteArray.length > 1024000) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File size cannot bet greater than 1 MB");
                throw new Exception("File size cannot bet greater than 1 MB.");
            } else if (lf3Extension == null) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File must have a valid extension");
                throw new Exception("File must have a valid extension.");
            } else {
                LegalFilesDTO legalFilesDTO = legalFilesMapper.toDTO(legalFilesRepository.findByRegistrationAndFileType(registrationDBO.getId(), FileTypes.LEGALFILE3.getValue()));
                if (legalFilesDTO == null) {
                    legalFilesDTO = new LegalFilesDTO();
                }
                legalFilesDTO.setRegistration(registrationDBO.getId());
                legalFilesDTO.setFileType(FileTypes.LEGALFILE3.getValue());
                legalFilesDTO.setFileData(LegalFilesService.getBase64Data(lf3));
                legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));
                registrationDBO.setLegalFile3Mime(LegalFilesService.getMimeType(lf3));
                registrationDBO.setLegalFile3Size(lf3ByteArray.length);
                registrationDBO.setUploadTime(currentTime);
                _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Updated legal document number 3");
            }
        }
        String lf4 = registrationDTO.getLegalFile4Mime();
        if (lf4 != null) {
            byte[] lf4ByteArray = Base64.getMimeDecoder().decode(LegalFilesService.getBase64Data(lf4));
            String lf4Extension = LegalFilesService.getValidFileExtension(lf4);
            if (lf4ByteArray.length > 1024000) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File size cannot bet greater than 1 MB");
                throw new Exception("File size cannot bet greater than 1 MB.");
            } else if (lf4Extension == null) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File must have a valid extension");
                throw new Exception("File must have a valid extension.");
            } else {
                LegalFilesDTO legalFilesDTO = legalFilesMapper.toDTO(legalFilesRepository.findByRegistrationAndFileType(registrationDBO.getId(), FileTypes.LEGALFILE4.getValue()));
                if (legalFilesDTO == null) {
                    legalFilesDTO = new LegalFilesDTO();
                }
                legalFilesDTO.setRegistration(registrationDBO.getId());
                legalFilesDTO.setFileType(FileTypes.LEGALFILE4.getValue());
                legalFilesDTO.setFileData(LegalFilesService.getBase64Data(lf4));
                legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));
                registrationDBO.setLegalFile4Mime(LegalFilesService.getMimeType(lf4));
                registrationDBO.setLegalFile4Size(lf4ByteArray.length);
                registrationDBO.setUploadTime(currentTime);
                _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Updated legal document number 4");
            }
        }
        if (checkAllFilesFlag(registrationDBO)) {
            registrationDBO.setAllFilesFlag(1);
            registrationDBO.setMailCounter(0);
        } else {
            registrationDBO.setAllFilesFlag(0);
            registrationDBO.setMailCounter(3);
        }
        return saveRegistration(registrationDBO);
    }


    public ResponseDTO confirmOrRejectInstallationAndSendCNS(Map<String, Object> map, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO response = new ResponseDTO();
        if (!map.isEmpty()) {
            if (map.containsKey("id") && map.containsKey("beneficiaryIndicator")) {
                Registration registration = registrationRepository.findOne((int) map.get("id"));

                if (!checkPermissionsRegistrations(registration)){
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to confirm or reject");
                    return permissionChecker.getAccessDeniedResponse();
                }

                // take origin submitted date
                if (registration != null && registration.getInstallationSiteSubmission() != null) {
                    boolean beneficiaryIndicator = (boolean) map.get("beneficiaryIndicator");

                    if (beneficiaryIndicator) {
                        registration.setInstallationSiteConfirmation(new java.sql.Date(new Date().getTime()));
                        _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Installation site confirmed");
                    } else {
                        registration.setInstallationSiteRejection(new java.sql.Date(new Date().getTime()));
                        _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Installation site rejected");
                    }
                    // we save the new indicators
                    if (sendEmailOnConfirmOrReject(registration)) {
                        registrationRepository.save(registration);
                        //if everything goes ok it's a success
                        response.setSuccess(true);
                        MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipality().getId());
                        response.setData(municipality);
                        return response;
                    }

                } else {
                    response.setSuccess(false);
                    response.setData("Error querying municipality - registration");
                    response.setError(new ErrorDTO(404, "error.404.beneficiaryNotFound"));
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The beneficiary is not found");
                }
            }
            response.setSuccess(false);
            response.setError(new ErrorDTO(400, "error.400.invalidFields"));
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The fields are invalid");
        } else {
            response.setSuccess(false);
            response.setError(new ErrorDTO(400, "error.400.noData"));
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Data not found");
        }
        return response;
    }

    private boolean checkPermissionsRegistrations(Registration registration) {
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            permissionChecker.checkBeneficiaryPermission(userDTO.getType(), registration.getMunicipality().getId(), registration.getId());
            if (registration.getUser().getId() != userDTO.getId()) {
                throw new AccessDeniedException("403 FORBIDDEN");
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /* Method called when the user confirms/rejects the installation report. This method sends the CNS email to the
     * supplier.
     *
     * @param registration
     * @return
     */
    private boolean sendEmailOnConfirmOrReject(Registration registration) {
        //sending CNS
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Sending email for registration with id " + registration.getId());
        String beneficiaryName = registration.getMunicipality().getName();
        Iterable<Application> applicationList = applicationRepository.findByRegistrationId(registration
                .getId());
        Supplier supplier = supplierMapper.toEntity(supplierService.getSupplierById(applicationList.iterator().next().getSupplierId()));
        String name = supplier.getName();
        String email = supplier.getContactEmail();
        Locale locale = new Locale(UserConstants.DEFAULT_LANG);
        String lang = userUtils.getUserLangByUserId(supplier.getUser().getId());
        if (lang != null) {
            _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - No language specified, using the default language");
            locale = new Locale(lang);
        }
        //if beneficiary indicator and wifi indicator are true we send a confirmation email
        if (registration.getInstallationSiteConfirmation() != null) {
            cnsManager.sendInstallationConfirmationFromBeneficiary(email, name, beneficiaryName, locale);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Confirmation email for registration " + registration.getId() + " sent to " + email);
            return true;
        } else {
            Date dateSubmission = registration.getInstallationSiteSubmission();
            Date dateReject = registration.getInstallationSiteRejection();
            if (dateSubmission.before(dateReject)) {
                // if rejection date is bigger than submission date, send email
                User user = registration.getUser();
                String ccName = user.getName();
                String ccEmail = user.getEmail();
                cnsManager.sendInstallationRejectionFromBeneficiary(email, name, beneficiaryName, ccEmail,
                        ccName, locale);
                _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Rejection email for registration " + registration.getId() + " sent to " + email);
                return true;
            }
        }
        return false;
    }


    @Transactional
    public RegistrationDTO deleteRegistration(int registrationId, HttpServletRequest request) {
        RegistrationDTO registrationDTO = registrationMapper.toDTO(registrationRepository.findOne(registrationId));
        if (registrationDTO != null) {
            for (ApplicationDTO application : applicationService.getApplicationsByRegistrationId(registrationDTO.getId())) {
                applicationService.deleteApplication(application.getId(), request);
            }
            legalFilesRepository.deleteByRegistration(registrationDTO.getId());
            registrationRepository.delete(registrationMapper.toEntity(registrationDTO));
            return registrationDTO;
        } else {
            return null;
        }
    }


    public RegistrationDTO invalidateRegistration(int registrationId) {
        RegistrationDTO registrationDBO = registrationMapper.toDTO(registrationRepository.findOne(registrationId));
        registrationDBO.setStatus(RegistrationStatus.KO.getValue());
        return saveRegistration(registrationDBO);
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
                String additionalInfoUrl = userService.getBaseUrl() + "beneficiary-portal/voucher";
                msgBody = MessageFormat.format(msgBody, additionalInfoUrl);
                _log.info("additionalInfoUrl: " + additionalInfoUrl + " msgBody: " + msgBody + " language: " + locale.getLanguage());
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

    public RegistrationDTO getRegistrationByUserThreadId(int threadId, int userId) {
        ThreadDTO threadDTO = threadService.getThreadById(threadId);
        List<RegistrationDTO> registrations = getRegistrationsByUserId(userId);
        for (RegistrationDTO registration : registrations) {
            MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
            if (threadDTO.getReason().equals(String.valueOf(municipality.getLauId()))) {
                return registration;
            }
        }
        return null;
    }

    public List<RegistrationDTO> getRegistrationsByIp(String ip) {
        return registrationMapper.toDTOList(Lists.newArrayList(registrationRepository.findByIpRegistration(ip)));
    }

    public List<RegistrationDTO> getRegistrationsByLauId(int lauId) {
        List<MunicipalityDTO> municipalities = municipalityService.getMunicipalitiesByLauId(lauId);
        List<RegistrationDTO> registrations = new ArrayList<>();
        for (MunicipalityDTO municipality : municipalities) {
            registrations.add(getRegistrationByMunicipalityId(municipality.getId()));
        }
        return registrations;
    }

    public List<LegalFileCorrectionReasonDTO> getLegalFilesByRegistrationId(Integer registrationId) {
        return legalFileCorrectionReasonMapper.toDTOList(legalFileCorrectionReasonRepository.findByRegistrationIdOrderByTypeAsc(registrationId));
    }

    @Transactional
    public LegalFileCorrectionReasonDTO saveLegalFile(LegalFileCorrectionReasonDTO legalFileDTO) {
        return legalFileCorrectionReasonMapper.toDTO(legalFileCorrectionReasonRepository.save(legalFileCorrectionReasonMapper.toEntity(legalFileDTO)));
    }

    public RegistrationDTO saveRegistration(RegistrationDTO registrationDTO) {
        return registrationMapper.toDTO(registrationRepository.save(registrationMapper.toEntity(registrationDTO)));
    }

    public boolean checkIfMayor(RegistrationDTO registrationDTO) {
        UserDTO user = userService.getUserById(registrationDTO.getUserId());
        MayorDTO mayor = mayorService.getMayorByMunicipalityId(registrationDTO.getMunicipalityId());
        if (user != null && mayor != null) {
            if (mayor.getName().equals(user.getName()) && mayor.getSurname().equals(user.getSurname())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean checkAllFilesFlag(RegistrationDTO registrationDTO) {
        boolean allFilesFlag = false;
        boolean lf1Exists = false;
        if (legalFilesRepository.findByRegistrationAndFileType(registrationDTO.getId(), FileTypes.LEGALFILE1.getValue()) != null) {
            lf1Exists = true;
        }
        boolean lf2Exists = false;
        if (legalFilesRepository.findByRegistrationAndFileType(registrationDTO.getId(), FileTypes.LEGALFILE2.getValue()) != null) {
            lf2Exists = true;
        }
        boolean lf3Exists = false;
        if (legalFilesRepository.findByRegistrationAndFileType(registrationDTO.getId(), FileTypes.LEGALFILE3.getValue()) != null) {
            lf3Exists = true;
        }
        boolean lf4Exists = false;
        if (legalFilesRepository.findByRegistrationAndFileType(registrationDTO.getId(), FileTypes.LEGALFILE4.getValue()) != null) {
            lf4Exists = true;
        }
        if (checkIfMayor(registrationDTO)) {
            if (lf1Exists && lf3Exists) {
                allFilesFlag = true;
            }
        } else {
            if (lf1Exists && lf2Exists && lf3Exists && lf4Exists) {
                allFilesFlag = true;
            }
        }
        return allFilesFlag;
    }
}