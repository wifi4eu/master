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
import wifi4eu.wifi4eu.common.enums.ApplicationStatus;
import wifi4eu.wifi4eu.common.enums.FileTypes;
import wifi4eu.wifi4eu.common.enums.RegistrationStatus;
import wifi4eu.wifi4eu.common.enums.RegistrationUsersStatus;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.registration.LegalFile;
import wifi4eu.wifi4eu.entity.registration.LegalFileCorrectionReason;import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;
import wifi4eu.wifi4eu.entity.supplier.Supplier;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.mapper.registration.LegalFileCorrectionReasonMapper;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.mapper.registration.legal_files.LegalFilesMapper;
import wifi4eu.wifi4eu.mapper.registrationWarning.RegistrationWarningMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationIssueUtilRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.registration.LegalFileCorrectionReasonRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.call.CallService;
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

    @Autowired
    RegistrationUsersRepository registrationUsersRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CallService callService;

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
        RegistrationUsers registrationUsers = new RegistrationUsers();
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        if (registrationDTO.getId() == 0) {
            registrationDTO.setMailCounter(3);
        }
        RegistrationDTO registrationCreated = saveRegistration(registrationDTO);
        registrationUsers.setUserId(userConnected.getId());
        registrationUsers.setRegistrationId(registrationCreated.getId());
        registrationUsers.setMain(1);
        registrationUsers.setStatus(RegistrationUsersStatus.REGISTERED.getValue());
        registrationUsers.setCreationDate(new Date());
        registrationUsers.setContactEmail(userConnected.getEcasEmail());
        registrationUsersRepository.save(registrationUsers);
        registrationWarningService.createWarningsByRegistration(registrationCreated);
        return registrationCreated;
    }


    @Transactional
    public ResponseDTO uploadRegistrationDocuments(Integer registrationID, List<LegalFileDTO> legalFile, HttpServletRequest request) throws Exception {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        if(!legalFile.isEmpty()){
            for( int i = 0 ; i < legalFile.size() ; i++){
                uploadDocument(registrationID, legalFile.get(i), userConnected, RequestIpRetriever.getIp(request));
            }
        }

        Registration registration = registrationRepository.findOne(registrationID);
        if (hasRegistrationRequiredFiles(registrationID)) {
            registration.setAllFilesFlag(1);
        } else {
            registration.setAllFilesFlag(0);
        }
        registrationRepository.save(registration);

        //if user doesn't have any documents as requested for correction we put its status on HOLD
        //this is only relevant if the registration has applied to a call!
        if (hasOneUserWithoutCorrectionRequest(registrationUsersRepository
                .findByRegistrationId(registrationID), registrationID)) {

            //three cases
            //1. if last closed call exists it's in the revision period so the status is set automatically to HOLD
            //2. if last closed call is null then check if some other call is open
            //2.1 if there's a call going on the user should not be able to edit the documents if he's applied
            // if he's not applied there's no application
            //2.2  if there's no call going on we set the status to HOLD

            CallDTO lastCall = callService.getLastCallClosed();
            if(lastCall != null) {
                Application applicationDB = applicationRepository.findTopByRegistrationIdAndCallId(registrationID, lastCall.getId());
                if (applicationDB != null && applicationDB.getStatus() == ApplicationStatus.PENDING_FOLLOWUP.getValue()) {
                    applicationDB.setStatus(ApplicationStatus.HOLD.getValue());
                    applicationRepository.save(applicationDB);
                    _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected
                            .getEcasUsername() + " - Changing applicant status for HOLD, as it doesn't have any more documents as requested for " +
                            "correction. Application id: " + applicationDB.getId() + ". Registration id: " + registrationID);
                }
            } else {
                CallDTO currentCall = callService.getCurrentCall();
                if(currentCall == null){
                    //do nothing there's no application

                } else {
                    //call going on
                    //pending to define when it's allowed to upload documents
                }
            }
        }
        return new ResponseDTO(true, "sucess", null);
    }

    private void uploadDocument (Integer registrationID, LegalFileDTO legalFile, UserDTO userConnected, String ip) throws Exception {
        String legalFileToUpload = legalFile.getFileData();
        if (legalFileToUpload != null) {
            String base64 = LegalFilesService.getBase64Data(legalFileToUpload);
            if(base64 != null && !base64.isEmpty()) {
                byte[] byteArray = Base64.getMimeDecoder().decode(base64);
                String extension = LegalFilesService.getValidFileExtension(legalFileToUpload);
                if (byteArray.length > 1024000) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File size cannot bet greater than 1 MB");
                    throw new Exception("File size cannot bet greater than 1 MB.");
                } else if (extension == null) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File must have a valid extension");
                    throw new Exception("File must have a valid extension.");
                } else if (legalFile.getFileName().isEmpty()) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File doesn't have a name");
                    throw new Exception("File must have a valid extension.");
                } else{
                    //file name also comes from front input
                    legalFile.setId(0);
                    legalFile.setRegistration(registrationID);
                    legalFile.setFileData(LegalFilesService.getBase64Data(legalFileToUpload));
                    legalFile.setUploadTime(new Date());
                    legalFile.setFileMime(LegalFilesService.getMimeType(legalFileToUpload));
                    legalFile.setFileSize(byteArray.length);
                    legalFile.setUserId(userConnected.getId());
                    legalFilesRepository.save(legalFilesMapper.toEntity(legalFile));
                    _log.log(Level.getLevel("BUSINESS"), "[ " + ip + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Updated legal " +
                            "document number type:" + legalFile.getFileType());

                    LegalFileCorrectionReason legalFilesCorrectionReasons = legalFileCorrectionReasonRepository
                            .findLastCorrectionByRegistrationAndUserAndType(legalFile.getRegistration(), userConnected.getId(), legalFile.getFileType());
                    if(legalFilesCorrectionReasons != null) {
                        legalFilesCorrectionReasons.setCorrectionReason(null);
                        legalFilesCorrectionReasons.setRequestCorrection(false);
                        legalFileCorrectionReasonRepository.save(legalFilesCorrectionReasons);
                    }
                }
            }else{
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Trying to upload a file its data is in incorrect format");
                throw new Exception("Data is in incorrect format");
            }
        } else{
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Trying to upload a file that is empty");
            throw new Exception("File is empty");
        }
    }

    /**
     * True if there's at least one user associated with this registration has no file requested for correction
     * @param users
     * @param registrationId
     * @return
     */
    private boolean hasOneUserWithoutCorrectionRequest(List<RegistrationUsers> users, Integer registrationId) {
        for (int i = 0; i < users.size(); i++) {
            if (legalFileCorrectionReasonRepository.findLastLegalFilesByRegistrationAndUserCorrection(registrationId, users.get(i).getUserId()).isEmpty()) {
                return true;
            }
        }
        return false;
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
            if (registrationUsersRepository.findByUserIdAndRegistrationId(userDTO.getId(), registration.getId()) == null) {
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
        String lang = userUtils.getUserLangByUserId(supplierService.getUserIdFromSupplier(supplier.getId()));
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
                User user = userRepository.findMainUserFromRegistration(registration.getId());
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
            UserDTO user = userMapper.toDTO(userRepository.findMainUserFromRegistration(registrationId));
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
                    mailService.sendEmail(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody, registration.getMunicipalityId(), "requestLegalDocuments");
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
        UserDTO user = userMapper.toDTO(userRepository.findMainUserFromRegistration(registrationDTO.getId()));
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

    public boolean checkUserWithRegistration(Integer registrationId, Integer userId){
        if(registrationUsersRepository.findByUserIdAndRegistrationId(userId, registrationId) != null){
            return true;
        }
        return false;
    }

    public List<UserDTO> getUsersFromRegistration(Integer registrationId){
        List<UserDTO> users = userMapper.toDTOList(userRepository.findUsersByRegistrationId(registrationId));
        return users;
    }

    /**
     * Checks if registration has required files ( type 1 and 3 ) to be able to apply. Independent of user
     *
     * If it doesn't have the required file return false. if has required files and has correction request for that file return false too.
     * If it has the required files and has no correction request for those files, returns true
     * @param registrationID
     * @return
     */
    public boolean hasRegistrationRequiredFiles(Integer registrationID) {
        boolean hasFilesUploaded = !legalFilesRepository.findLastRequiredLegalFilesByRegistration(registrationID).isEmpty();
        boolean hasCorrectionRequestedForRequiredFiles = !legalFileCorrectionReasonRepository.findLastRequiredLegalFilesCorrectionByRegistration
                (registrationID).isEmpty();

        if(!hasFilesUploaded || hasCorrectionRequestedForRequiredFiles){
            return false;
        }
        return true;
    }

    /**
     * Gets all documents that belong to that user and the mayor documents as well.
     * If type is not null it returns all documents uploaded for that type.
     * @param registrationId
     * @param type
     * @param userId
     * @return
     */
    public List<LegalFileDTO> getHistoryDocuments(Integer registrationId, Integer type, Integer userId) {
        if (type == null || type == 0) {
            return legalFilesMapper.toDTOList(legalFilesRepository.findHistoryAll(registrationId, userId));
        }
        if (type == 1 || type == 3) {
            return legalFilesMapper.toDTOList(legalFilesRepository.findHistoryRequiredType(registrationId, type));
        }
        return legalFilesMapper.toDTOList(legalFilesRepository.findHistoryForType(registrationId, userId, type));
    }


}