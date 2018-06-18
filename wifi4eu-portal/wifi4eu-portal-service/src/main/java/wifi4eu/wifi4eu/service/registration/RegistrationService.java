package wifi4eu.wifi4eu.service.registration;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.enums.*;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.mapper.registrationWarning.RegistrationWarningMapper;
import wifi4eu.wifi4eu.service.application.ApplicationWarningsChecker;
import wifi4eu.wifi4eu.entity.application.ApplicationIssueUtil;
import wifi4eu.wifi4eu.mapper.registration.RegistrationMapper;
import wifi4eu.wifi4eu.mapper.registration.legal_files.*;
import wifi4eu.wifi4eu.mapper.registration.LegalFileCorrectionReasonMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationIssueUtilRepository;
import wifi4eu.wifi4eu.repository.registration.LegalFileCorrectionReasonRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.legal_files.*;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.warning.RegistrationWarningService;
import wifi4eu.wifi4eu.util.MailService;

import java.util.*;
import java.text.MessageFormat;

@Service("portalRegistrationService")
public class RegistrationService {
    private final Logger _log = LoggerFactory.getLogger(RegistrationService.class);

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
    public RegistrationDTO deleteRegistrationDocuments(RegistrationDTO registrationDTO) {

        RegistrationDTO registrationDBO = registrationMapper.toDTO(registrationRepository.findOne(registrationDTO.getId()));
        if (registrationDBO.getAllFilesFlag() != 1) {
            if (registrationDTO.getLegalFile1() == null) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 1);

                registrationDBO.setLegalFile1Mime(null);
                registrationDBO.setLegalFile1Size(0);
            }

            if (registrationDTO.getLegalFile2() == null) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 2);

                registrationDBO.setLegalFile2Mime(null);
                registrationDBO.setLegalFile2Size(0);
            }

            if (registrationDTO.getLegalFile3() == null) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 3);

                registrationDBO.setLegalFile3Mime(null);
                registrationDBO.setLegalFile3Size(0);
            }

            if (registrationDTO.getLegalFile4() == null) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 4);

                registrationDBO.setLegalFile4Mime(null);
                registrationDBO.setLegalFile4Size(0);
            }
        }
        return registrationMapper.toDTO(registrationRepository.save(registrationMapper.toEntity(registrationDBO)));
    }

    @Transactional
    public RegistrationDTO updateRegistrationDocuments(RegistrationDTO registrationDTO) {

        RegistrationDTO registrationDBO = registrationMapper.toDTO(registrationRepository.findOne(registrationDTO.getId()));

        if (registrationDTO.getLegalFile1() != null && !registrationDTO.getLegalFile1().isEmpty()) {
            LegalFilesDTO legalFilesDTO = new LegalFilesDTO();
            legalFilesDTO.setRegistration(registrationDTO.getId());
            legalFilesDTO.setFileType(FileTypes.LEGALFILE1.getValue());
            legalFilesDTO.setFileData(registrationDTO.getLegalFile1());

            legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));

            //registrationDBO.setLegalFile1Mime();
        }

        if (registrationDTO.getLegalFile2() != null && !registrationDTO.getLegalFile2().isEmpty()) {
            LegalFilesDTO legalFilesDTO = new LegalFilesDTO();
            legalFilesDTO.setRegistration(registrationDTO.getId());
            legalFilesDTO.setFileType(FileTypes.LEGALFILE2.getValue());
            legalFilesDTO.setFileData(registrationDTO.getLegalFile2());

            legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));
        }

        if (registrationDTO.getLegalFile3() != null && !registrationDTO.getLegalFile3().isEmpty()) {
            LegalFilesDTO legalFilesDTO = new LegalFilesDTO();
            legalFilesDTO.setRegistration(registrationDTO.getId());
            legalFilesDTO.setFileType(FileTypes.LEGALFILE3.getValue());
            legalFilesDTO.setFileData(registrationDTO.getLegalFile3());

            legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));
        }

        if (registrationDTO.getLegalFile4() != null && !registrationDTO.getLegalFile4().isEmpty()) {
            LegalFilesDTO legalFilesDTO = new LegalFilesDTO();
            legalFilesDTO.setRegistration(registrationDTO.getId());
            legalFilesDTO.setFileType(FileTypes.LEGALFILE4.getValue());
            legalFilesDTO.setFileData(registrationDTO.getLegalFile4());

            legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));
        }

        registrationDBO.setAllFilesFlag(registrationDTO.getAllFilesFlag());
        registrationDBO.setMailCounter(registrationDTO.getMailCounter());

        return saveRegistration(registrationDBO);
    }

    @Transactional
    public RegistrationDTO deleteRegistration(int registrationId) {
        RegistrationDTO registrationDTO = registrationMapper.toDTO(registrationRepository.findOne(registrationId));
        if (registrationDTO != null) {
            for (ApplicationDTO application : applicationService.getApplicationsByRegistrationId(registrationDTO.getId())) {
                applicationService.deleteApplication(application.getId());
            }
            legalFilesRepository.deleteByRegistration(registrationDTO.getId());
            registrationRepository.delete(registrationMapper.toEntity(registrationDTO));
            return registrationDTO;
        } else {
            return null;
        }
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
}