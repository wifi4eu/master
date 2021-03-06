package wifi4eu.wifi4eu.service.registration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalFileCorrectionReasonDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalFileDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.RegistrationStatus;
import wifi4eu.wifi4eu.common.enums.RegistrationUsersStatus;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;
import wifi4eu.wifi4eu.entity.registration.Registration;
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
import wifi4eu.wifi4eu.repository.logEmails.LogEmailRepository;
import wifi4eu.wifi4eu.repository.registration.LegalFileCorrectionReasonRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.warning.RegistrationWarningService;
import wifi4eu.wifi4eu.util.UserUtils;

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
    MailService mailService;

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
    LogEmailRepository logEmailRepository;

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

     public ResponseDTO confirmOrRejectInstallationAndSendCNS(Map<String, Object> map, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO response = new ResponseDTO();
        if (!map.isEmpty()) {
            if (map.containsKey("id") && map.containsKey("beneficiaryIndicator")) {
                Registration registration = registrationRepository.findOne((int) map.get("id"));

                if (!checkPermissionsRegistrations(registration)) {
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
            UserDTO user = permissionChecker.checkBeneficiaryPermission();
            if (registrationUsersRepository.findByUserIdAndRegistrationId(user.getId(), registration.getId()) == null) {
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

        Integer userId = supplierService.getUserIdFromSupplier(supplier.getId());
        if(userId != 0) {
            String lang = userUtils.getUserLangByUserId(userId);
            _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - No language specified, using the default language");
            locale = new Locale(lang);
        }
        //if beneficiary indicator and wifi indicator are true we send a confirmation email
        if (registration.getInstallationSiteConfirmation() != null) {
            MailData mailData = MailHelper.buildMailInstallationConfirmationFromBeneficiary(email, name, beneficiaryName, locale);
        	mailService.sendMail(mailData, true);
        	
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
                
                MailData mailDataSupplier = MailHelper.buildMailInstallationRejectionFromBeneficiary(email, name, beneficiaryName, locale);
            	mailService.sendMail(mailDataSupplier, true);
                MailData mailDataUser = MailHelper.buildMailInstallationRejectionFromBeneficiary(ccEmail, ccName, beneficiaryName, locale);
            	mailService.sendMail(mailDataUser, true);
                
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

                String additionalInfoUrl = userService.getBaseUrl() + "beneficiary-portal/voucher";
                MailData mailData = MailHelper.buildMailRequestSupportingDocumentsForRegistration(
                		user.getEcasEmail(), MailService.FROM_ADDRESS, additionalInfoUrl, 
                		registration.getMunicipalityId(), "requestLegalDocuments", locale);
            	mailService.sendMail(mailData, false);

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
    public LegalFileCorrectionReasonDTO saveLegalFile(LegalFileCorrectionReasonDTO legalFileDTO) throws Exception {
        legalFileDTO.setRequestCorrectionDate(new Date().getTime());
        if (legalFileDTO.getCorrectionReason() == null) {
            legalFileDTO.setRequestCorrection(false);
        }

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

    public boolean checkUserWithRegistration(Integer registrationId, Integer userId) {
        if (registrationUsersRepository.findByUserIdAndRegistrationId(userId, registrationId) != null) {
            return true;
        }
        return false;
    }

    /**
     * Gets all documents independent of user and type.
     * If type is not null it returns all documents uploaded for that type.
     * @param registrationId
     * @return
     */
    public List<LegalFileDTO> getHistoryDocuments(Integer registrationId) {
        return legalFilesMapper.toDTOList(legalFilesRepository.findHistoryAll(registrationId));
    }

    private List<UserDTO> findUsersFromRegistration(Integer registrationId){
        return userMapper.toDTOList(userRepository.findUsersFromRegistration(registrationId));
    }

    public void clearCorrectionReason(LegalFileCorrectionReasonDTO legalFileCorrectionReasonDTO, UserDTO userDTO){
        if ((legalFileCorrectionReasonDTO.getType() == 1) || (legalFileCorrectionReasonDTO.getType() == 3)){
            legalFileCorrectionReasonRepository.clearCorrectionReason(legalFileCorrectionReasonDTO.getRegistrationId(),legalFileCorrectionReasonDTO.getType());

        }else  if ((legalFileCorrectionReasonDTO.getType() == 2) || (legalFileCorrectionReasonDTO.getType() == 4)){
            List<LegalFileCorrectionReasonDTO> legalFileCorrectionReasonDTOList =  legalFileCorrectionReasonMapper.toDTOList(legalFileCorrectionReasonRepository.getByRegistrationIdAndTypeAndUserId(legalFileCorrectionReasonDTO.getRegistrationId(),legalFileCorrectionReasonDTO.getType(),userDTO.getId()));
            for (LegalFileCorrectionReasonDTO lfcDTO: legalFileCorrectionReasonDTOList){
                lfcDTO.setRequestCorrection(false);
                lfcDTO.setCorrectionReason(null);
            }

            legalFileCorrectionReasonRepository.save(legalFileCorrectionReasonMapper.toEntityList(legalFileCorrectionReasonDTOList));
        }
    }

    public List<Integer> findTypeFilesWaitingUploadByRegistration(Integer registrationId){
        LogEmail lastEmailSent = logEmailRepository.findTopByActionOrderBySentDateDesc(Constant.LOG_EMAIL_ACTION_SEND_CORRECTION_EMAILS);
        if(lastEmailSent == null){
            return new ArrayList<Integer>();
        }
        return legalFileCorrectionReasonRepository.findTypeFilesWaitingUploadByRegistration(lastEmailSent.getSentDate(),registrationId);
    }

    private Long getDateOfLogEmail(LogEmail logEmail){
        return logEmail == null ? 0 : logEmail.getSentDate();
    }
}