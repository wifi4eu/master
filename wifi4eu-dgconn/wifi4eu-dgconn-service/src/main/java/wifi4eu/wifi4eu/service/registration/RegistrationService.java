package wifi4eu.wifi4eu.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.LegalFileCorrectionReasonDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalFileDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.LegalFileStatus;
import wifi4eu.wifi4eu.common.enums.LegalFileValidationStatus;
import wifi4eu.wifi4eu.common.enums.RegistrationStatus;
import wifi4eu.wifi4eu.common.enums.RegistrationUsersStatus;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.mapper.registration.LegalFileCorrectionReasonMapper;
import wifi4eu.wifi4eu.common.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.common.mapper.registration.legal_files.LegalFilesMapper;
import wifi4eu.wifi4eu.common.mapper.registrationWarning.RegistrationWarningMapper;
import wifi4eu.wifi4eu.common.mapper.user.UserMapper;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;
import wifi4eu.wifi4eu.repository.logEmails.LogEmailRepository;
import wifi4eu.wifi4eu.repository.registration.LegalFileCorrectionReasonRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.warning.RegistrationWarningService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service("portalRegistrationService")
public class RegistrationService {

    @Autowired
    private RegistrationMapper registrationMapper;

    @Autowired
    private RegistrationWarningMapper registrationWarningMapper;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MunicipalityService municipalityService;

    @Autowired
    private LegalFilesMapper legalFilesMapper;

    @Autowired
    private LegalFilesRepository legalFilesRepository;

    @Autowired
    private LegalFileCorrectionReasonMapper legalFileCorrectionReasonMapper;

    @Autowired
    private RegistrationWarningService registrationWarningService;

    @Autowired
    private LegalFileCorrectionReasonRepository legalFileCorrectionReasonRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private RegistrationUsersRepository registrationUsersRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogEmailRepository logEmailRepository;

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

    public RegistrationDTO invalidateRegistration(int registrationId) {
        RegistrationDTO registrationDBO = registrationMapper.toDTO(registrationRepository.findOne(registrationId));
        registrationDBO.setStatus(RegistrationStatus.KO.getValue());
        return saveRegistration(registrationDBO);
    }

    public RegistrationDTO getRegistrationByMunicipalityId(int municipalityId) {
        return registrationMapper.toDTO(registrationRepository.findByMunicipalityId(municipalityId));
    }

    public Integer getRegistrationIdByMunicipalityId(int municipalityId) {
        return registrationRepository.findIdByMunicipalityId(municipalityId);
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
        LegalFileDTO legalFile = legalFilesMapper.toDTO(legalFilesRepository.findOne(legalFileDTO.getLegalFile()));
        legalFile.setStatus(LegalFileValidationStatus.INVALID.getValue());
        legalFile.setIsNew(LegalFileStatus.RECENT.getValue());
        if (legalFileDTO.getCorrectionReason() == null) {
            legalFileDTO.setRequestCorrection(false);
        }
        legalFilesRepository.save(legalFilesMapper.toEntity(legalFile));
        return legalFileCorrectionReasonMapper.toDTO(legalFileCorrectionReasonRepository.save(legalFileCorrectionReasonMapper.toEntity(legalFileDTO)));
    }

    public RegistrationDTO saveRegistration(RegistrationDTO registrationDTO) {
        return registrationMapper.toDTO(registrationRepository.save(registrationMapper.toEntity(registrationDTO)));
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
            return new ArrayList<>();
        }
        return legalFileCorrectionReasonRepository.findTypeFilesWaitingUploadByRegistration(lastEmailSent.getSentDate(),registrationId);
    }
}