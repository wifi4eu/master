package wifi4eu.wifi4eu.service.registration;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.enums.*;
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
import wifi4eu.wifi4eu.util.MailService;

import java.util.*;
import java.text.MessageFormat;

@Service("portalRegistrationService")
public class RegistrationService {
    private final Logger _log = LoggerFactory.getLogger(RegistrationService.class);

    @Autowired
    RegistrationMapper registrationMapper;

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
    LegalFileCorrectionReasonRepository legalFileCorrectionReasonRepository;

    public List<RegistrationDTO> getAllRegistrations() {
        return registrationMapper.toDTOList(Lists.newArrayList(registrationRepository.findAll()));
    }

    public RegistrationDTO getRegistrationById(int registrationId) {
        return registrationMapper.toDTO(registrationRepository.findOne(registrationId));
    }

    @Transactional
    public RegistrationDTO createRegistration(RegistrationDTO registrationDTO) {
        if (registrationDTO.getId() == 0) {
            registrationDTO.setMailCounter(3);
        }
        return saveRegistration(registrationDTO);
    }

    @Transactional
    public RegistrationDTO deleteRegistrationDocuments(RegistrationDTO registrationDTO){

        RegistrationDTO registrationDBO = registrationMapper.toDTO(registrationRepository.findOne(registrationDTO.getId()));
        if(registrationDBO.getAllFilesFlag() != 1){
            if (registrationDTO.getLegalFile1Mime() == null || registrationDTO.getLegalFile1Size() <= 0) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 1);

                registrationDBO.setLegalFile1Mime(null);
                registrationDBO.setLegalFile1Size(0);
            }

            if (registrationDTO.getLegalFile2Mime() == null || registrationDTO.getLegalFile2Size() <= 0) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 2);

                registrationDBO.setLegalFile2Mime(null);
                registrationDBO.setLegalFile2Size(0);
            }

            if (registrationDTO.getLegalFile3Mime() == null || registrationDTO.getLegalFile3Size() <= 0) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 3);

                registrationDBO.setLegalFile3Mime(null);
                registrationDBO.setLegalFile3Size(0);
            }

            if (registrationDTO.getLegalFile4Mime() == null || registrationDTO.getLegalFile4Size() <= 0) {
                legalFilesRepository.deleteByRegistrationAndFileType(registrationDTO.getId(), 4);

                registrationDBO.setLegalFile4Mime(null);
                registrationDBO.setLegalFile4Size(0);
            }
        }
        return registrationMapper.toDTO(registrationRepository.save(registrationMapper.toEntity(registrationDBO)));
    }

    @Transactional
    public RegistrationDTO updateRegistrationDocuments(RegistrationDTO registrationDTO){
        RegistrationDTO registrationDBO = registrationMapper.toDTO(registrationRepository.findOne(registrationDTO.getId()));
        Long currentTime = new Date().getTime();

        if (registrationDTO.getLegalFile1Mime() != null && !registrationDTO.getLegalFile1Mime().isEmpty() && registrationDTO.getLegalFile1Size() > 0) {
            LegalFilesDTO legalFilesDTO = new LegalFilesDTO();
            legalFilesDTO.setRegistration(registrationDTO.getId());
            legalFilesDTO.setFileType(FileTypes.LEGALFILE1.getValue());
            legalFilesDTO.setFileData(registrationDTO.getLegalFile1Mime());
            legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));
            registrationDBO.setLegalFile1Size(registrationDBO.getLegalFile1Size());
            registrationDBO.setUploadTime(currentTime);
        }

        if (registrationDTO.getLegalFile2Mime() != null && !registrationDTO.getLegalFile2Mime().isEmpty() && registrationDTO.getLegalFile2Size() > 0) {
            LegalFilesDTO legalFilesDTO = new LegalFilesDTO();
            legalFilesDTO.setRegistration(registrationDTO.getId());
            legalFilesDTO.setFileType(FileTypes.LEGALFILE2.getValue());
            legalFilesDTO.setFileData(registrationDTO.getLegalFile2Mime());
            legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));
            registrationDBO.setLegalFile2Size(registrationDBO.getLegalFile2Size());
            registrationDBO.setUploadTime(currentTime);
        }

        if (registrationDTO.getLegalFile3Mime() != null && !registrationDTO.getLegalFile3Mime().isEmpty() && registrationDTO.getLegalFile3Size() > 0) {
            LegalFilesDTO legalFilesDTO = new LegalFilesDTO();
            legalFilesDTO.setRegistration(registrationDTO.getId());
            legalFilesDTO.setFileType(FileTypes.LEGALFILE3.getValue());
            legalFilesDTO.setFileData(registrationDTO.getLegalFile3Mime());
            legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));
            registrationDBO.setLegalFile3Size(registrationDBO.getLegalFile3Size());
            registrationDBO.setUploadTime(currentTime);
        }

        if (registrationDTO.getLegalFile4Mime() != null && !registrationDTO.getLegalFile4Mime().isEmpty() && registrationDTO.getLegalFile4Size() > 0) {
            LegalFilesDTO legalFilesDTO = new LegalFilesDTO();
            legalFilesDTO.setRegistration(registrationDTO.getId());
            legalFilesDTO.setFileType(FileTypes.LEGALFILE4.getValue());
            legalFilesDTO.setFileData(registrationDTO.getLegalFile4Mime());
            legalFilesRepository.save(legalFilesMapper.toEntity(legalFilesDTO));
            registrationDBO.setLegalFile4Size(registrationDBO.getLegalFile4Size());
            registrationDBO.setUploadTime(currentTime);
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

    public boolean registrationHasWarning1(RegistrationDTO registration) {
        boolean warning1 = false;
        MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
        if (municipality != null) {
            LauDTO lau = lauService.getLauById(municipality.getLauId());
            MayorDTO mayor = mayorService.getMayorByMunicipalityId(municipality.getId());
            if (registration != null && mayor != null && lau != null) {
                UserDTO user = userService.getUserById(registration.getUserId());
                if (user.getEmail() != null && user.getEcasEmail() != null && mayor.getEmail() != null) {
                    switch (lau.getCountryCode().toUpperCase()) {
                        case "AT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".at") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".at") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".at")) {
                                warning1 = true;
                            }
                            break;
                        case "BE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".be") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".be") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".be")) {
                                warning1 = true;
                            }
                            break;
                        case "BG":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".bg") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".bg") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".bg")) {
                                warning1 = true;
                            }
                            break;
                        case "HR":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".hr") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".hr") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".hr")) {
                                warning1 = true;
                            }
                            break;
                        case "CY":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".cy") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".cy") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".cy")) {
                                warning1 = true;
                            }
                            break;
                        case "CZ":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".cz") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".cz") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".cz")) {
                                warning1 = true;
                            }
                            break;
                        case "DK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".dk") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".dk") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".dk")) {
                                warning1 = true;
                            }
                            break;
                        case "EE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ee") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".ee") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".ee")) {
                                warning1 = true;
                            }
                            break;
                        case "FI":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".fi") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".fi") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".fi")) {
                                warning1 = true;
                            }
                            break;
                        case "FR":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".fr") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".fr") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".fr")) {
                                warning1 = true;
                            }
                            break;
                        case "DE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".de") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".de") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".de")) {
                                warning1 = true;
                            }
                            break;
                        case "EL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".el") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".el") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".el")) {
                                warning1 = true;
                            }
                            break;
                        case "HU":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".hu") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".hu") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".hu")) {
                                warning1 = true;
                            }
                            break;
                        case "IS":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".is") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".is") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".is")) {
                                warning1 = true;
                            }
                            break;
                        case "IE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ie") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".ie") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".ie")) {
                                warning1 = true;
                            }
                            break;
                        case "IT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".it") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".it") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".it")) {
                                warning1 = true;
                            }
                            break;
                        case "LV":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lv") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".lv") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".lv")) {
                                warning1 = true;
                            }
                            break;
                        case "LT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lt") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".lt") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".lt")) {
                                warning1 = true;
                            }
                            break;
                        case "LU":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lu") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".lu") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".lu")) {
                                warning1 = true;
                            }
                            break;
                        case "MT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".mt") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".mt") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".mt")) {
                                warning1 = true;
                            }
                            break;
                        case "NL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".nl") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".nl") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".nl")) {
                                warning1 = true;
                            }
                            break;
                        case "NO":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".no") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".no") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".no")) {
                                warning1 = true;
                            }
                            break;
                        case "PL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".pl") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".pl") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".pl")) {
                                warning1 = true;
                            }
                            break;
                        case "PT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".pt") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".pt") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".pt")) {
                                warning1 = true;
                            }
                            break;
                        case "RO":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ro") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".ro") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".ro")) {
                                warning1 = true;
                            }
                            break;
                        case "SK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".sk") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".sk") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".sk")) {
                                warning1 = true;
                            }
                            break;
                        case "SI":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".si") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".si") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".si")) {
                                warning1 = true;
                            }
                            break;
                        case "ES":
                            if (!(
                                    user.getEmail().trim().toLowerCase().endsWith(".es") ||
                                            user.getEmail().trim().toLowerCase().endsWith(".cat") ||
                                            user.getEmail().trim().toLowerCase().endsWith(".gal") ||
                                            user.getEmail().trim().toLowerCase().endsWith(".eus")
                            ) || !(
                                    user.getEcasEmail().trim().toLowerCase().endsWith(".es") ||
                                            user.getEcasEmail().trim().toLowerCase().endsWith(".cat") ||
                                            user.getEcasEmail().trim().toLowerCase().endsWith(".gal") ||
                                            user.getEcasEmail().trim().toLowerCase().endsWith(".eus")
                            ) || !(
                                    mayor.getEmail().trim().toLowerCase().endsWith(".es") ||
                                            mayor.getEmail().trim().toLowerCase().endsWith(".cat") ||
                                            mayor.getEmail().trim().toLowerCase().endsWith(".gal") ||
                                            mayor.getEmail().trim().toLowerCase().endsWith(".eus")
                            )) {
                                warning1 = true;
                            }
                            break;
                        case "SE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".se") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".se") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".se")) {
                                warning1 = true;
                            }
                            break;
                        case "UK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".uk") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".uk") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".uk")) {
                                warning1 = true;
                            }
                            break;
                    }
                }
            }
        }
        return warning1;
    }

    public boolean registrationHasWarning2(RegistrationDTO registration) {
        boolean warning2 = false;
        MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
        if (municipality != null && registration != null) {
            List<RegistrationDTO> ipRegistrations = getRegistrationsByIp(registration.getIpRegistration());
            for (RegistrationDTO ipRegistration : ipRegistrations) {
                MunicipalityDTO ipMunicipality = municipalityService.getMunicipalityById(ipRegistration.getMunicipalityId());
                if (ipRegistration.getId() != registration.getId() && ipMunicipality.getLauId() == municipality.getLauId()) {
                    warning2 = true;
                }
            }
        }
        return warning2;
    }

    public boolean registrationHasWarning3(RegistrationDTO registration) {
        boolean warning3 = false;
        MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
        if (municipality != null) {
            LauDTO lau = lauService.getLauById(municipality.getLauId());
            MayorDTO mayor = mayorService.getMayorByMunicipalityId(municipality.getId());
            if (registration != null && mayor != null && lau != null) {
                UserDTO user = userService.getUserById(registration.getUserId());
                if (user.getEmail() != null && user.getEcasEmail() != null && mayor.getEmail() != null) {
                    switch (lau.getCountryCode().toUpperCase()) {
                        case "AT":
                            if (!(user.getLang().toLowerCase().equals("de"))) {
                                warning3 = true;
                            }
                            break;
                        case "BE":
                            if (!(user.getLang().toLowerCase().equals("de") ||
                                    user.getLang().toLowerCase().equals("nl") ||
                                    user.getLang().toLowerCase().equals("fr"))) {
                                warning3 = true;
                            }
                            break;
                        case "BG":
                            if (!(user.getLang().toLowerCase().equals("bg"))) {
                                warning3 = true;
                            }
                            break;
                        case "HR":
                            if (!(user.getLang().toLowerCase().equals("hr"))) {
                                warning3 = true;
                            }
                            break;
                        case "CY":
                            if (!(user.getLang().toLowerCase().equals("el"))) {
                                warning3 = true;
                            }
                            break;
                        case "CZ":
                            if (!(user.getLang().toLowerCase().equals("cs"))) {
                                warning3 = true;
                            }
                            break;
                        case "DK":
                            if (!(user.getLang().toLowerCase().equals("da"))) {
                                warning3 = true;
                            }
                            break;
                        case "EE":
                            if (!(user.getLang().toLowerCase().equals("et"))) {
                                warning3 = true;
                            }
                            break;
                        case "FI":
                            if (!(user.getLang().toLowerCase().equals("fi") ||
                                    user.getLang().toLowerCase().equals("sv"))) {
                                warning3 = true;
                            }
                            break;
                        case "FR":
                            if (!(user.getLang().toLowerCase().equals("fr"))) {
                                warning3 = true;
                            }
                            break;
                        case "DE":
                            if (!(user.getLang().toLowerCase().equals("de"))) {
                                warning3 = true;
                            }
                            break;
                        case "EL":
                            if (!(user.getLang().toLowerCase().equals("el"))) {
                                warning3 = true;
                            }
                            break;
                        case "HU":
                            if (!(user.getLang().toLowerCase().equals("hu"))) {
                                warning3 = true;
                            }
                            break;
                        case "IS":
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                warning3 = true;
                            }
                            break;
                        case "IE":
                            if (!(user.getLang().toLowerCase().equals("en") ||
                                    user.getLang().toLowerCase().equals("ga"))) {
                                warning3 = true;
                            }
                            break;
                        case "IT":
                            if (!(user.getLang().toLowerCase().equals("it"))) {
                                warning3 = true;
                            }
                            break;
                        case "LV":
                            if (!(user.getLang().toLowerCase().equals("lv"))) {
                                warning3 = true;
                            }
                            break;
                        case "LT":
                            if (!(user.getLang().toLowerCase().equals("lt"))) {
                                warning3 = true;
                            }
                            break;
                        case "LU":
                            if (!(user.getLang().toLowerCase().equals("fr") ||
                                    user.getLang().toLowerCase().equals("de"))) {
                                warning3 = true;
                            }
                            break;
                        case "MT":
                            if (!(user.getLang().toLowerCase().equals("mt") ||
                                    user.getLang().toLowerCase().equals("en"))) {
                                warning3 = true;
                            }
                            break;
                        case "NL":
                            if (!(user.getLang().toLowerCase().equals("nl"))) {
                                warning3 = true;
                            }
                            break;
                        case "NO":
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                warning3 = true;
                            }
                            break;
                        case "PL":
                            if (!(user.getLang().toLowerCase().equals("pl"))) {
                                warning3 = true;
                            }
                            break;
                        case "PT":
                            if (!(user.getLang().toLowerCase().equals("pt"))) {
                                warning3 = true;
                            }
                            break;
                        case "RO":
                            if (!(user.getLang().toLowerCase().equals("ro"))) {
                                warning3 = true;
                            }
                            break;
                        case "SK":
                            if (!(user.getLang().toLowerCase().equals("sk"))) {
                                warning3 = true;
                            }
                            break;
                        case "SI":
                            if (!(user.getLang().toLowerCase().equals("sl"))) {
                                warning3 = true;
                            }
                            break;
                        case "ES":
                            if (!(user.getLang().toLowerCase().equals("es"))) {
                                warning3 = true;
                            }
                            break;
                        case "SE":
                            if (!(user.getLang().toLowerCase().equals("sv"))) {
                                warning3 = true;
                            }
                            break;
                        case "UK":
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                warning3 = true;
                            }
                            break;
                    }
                }
            }
        }
        return warning3;
    }

    public Integer getRegistrationIssue(RegistrationDTO registration) {
        Integer issueType = 0;
        if (registrationHasWarning1(registration)) {
            issueType = 1;
        }
        if (registrationHasWarning3(registration)) {
            issueType = 3;
        }
        return issueType;
    }

    public List<ApplicationIssueUtil> getRegistrationIssue(Integer lauId) {
        List<ApplicationIssueUtil> applicationIssueUtils = applicationIssueUtilRepository.findApplicationIssueUtilByLauId(lauId);

        if (applicationIssueUtils.size() > 1) { //We have more than one applicant per lau, check status
            //if status is KO remove from the list
            applicationIssueUtils.removeIf(applicationIssueUtil -> applicationIssueUtil.getStatus() == ApplicationStatus.KO.getValue());
        }

        return applicationIssueUtils;
    }

    public Integer getIssues(List<ApplicationIssueUtil> applicationIssueUtilList){

        if(applicationIssueUtilList.size() == 1){

            Integer issueType = 0;
            if (ApplicationWarningsChecker.registrationHasWarning1(applicationIssueUtilList.get(0))) {
                issueType = 1;
            }
            if (ApplicationWarningsChecker.registrationHasWarning3(applicationIssueUtilList.get(0))) {
                issueType = 3;
            }
            return issueType;

        } else {
            return 0;
        }
    }

    public Integer getStatus(List<ApplicationIssueUtil> applicationIssueUtilList){

        if(applicationIssueUtilList.size() == 1){
            return applicationIssueUtilList.get(0).getStatus();
        } else {
            return -1;
        }
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