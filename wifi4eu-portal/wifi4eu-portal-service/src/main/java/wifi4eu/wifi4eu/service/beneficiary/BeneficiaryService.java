package wifi4eu.wifi4eu.service.beneficiary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.RegistrationStatus;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryListItem;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.mapper.beneficiary.BeneficiaryListItemMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.beneficiary.BeneficiaryListItemRepository;
import wifi4eu.wifi4eu.repository.security.RightRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.ExcelExportGenerator;
import wifi4eu.wifi4eu.util.MailService;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.*;

@Service
public class BeneficiaryService {
    @Autowired
    BeneficiaryListItemMapper beneficiaryListItemMapper;

    @Autowired
    BeneficiaryListItemRepository beneficiaryListItemRepository;

    @Autowired
    UserService userService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    ThreadService threadService;

    @Autowired
    UserThreadsService userThreadsService;

    @Autowired
    MayorService mayorService;

    @Autowired
    LauService lauService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    RightRepository rightRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    MailService mailService;

    private final Logger _log = LoggerFactory.getLogger(BeneficiaryService.class);

    private List<Integer> municipalitiesLauIdToHold = new ArrayList<>();
    private final String MAYOR = "Mayor";
    private final String REPRESENTATIVE = "Representative";

    @Transactional
    public List<RegistrationDTO> submitBeneficiaryRegistration(BeneficiaryDTO beneficiaryDTO, String ip) throws Exception {

        /* Get user from ECAS */
        UserDTO user = new UserDTO();
        UserContext userContext = UserHolder.getUser();
        boolean isEcasUser = false;

        if (userContext != null) {
            /* user from ECAS */
            user = userService.getUserByUserContext(userContext);
            user.setName(beneficiaryDTO.getUser().getName());
            user.setSurname(beneficiaryDTO.getUser().getSurname());
            user.setAddress(beneficiaryDTO.getUser().getAddress());
            user.setAddressNum(beneficiaryDTO.getUser().getAddressNum());
            user.setPostalCode(beneficiaryDTO.getUser().getPostalCode());
            user.setEmail(beneficiaryDTO.getUser().getEmail());
            user.setType(beneficiaryDTO.getUser().getType());
            isEcasUser = true;
        }

        user.setCreateDate(new Date().getTime());
        user.setLang(beneficiaryDTO.getLang());

        UserDTO resUser = new UserDTO();
        if (isEcasUser) {
            resUser = userService.saveUserChanges(user);
        }

        /* create municipalities and check duplicates */
        List<MunicipalityDTO> resMunicipalities = getMunicipalityList(beneficiaryDTO);

        /* create registrations between user and municipality */
        List<RegistrationDTO> registrations = getRegistrationsList(resUser, beneficiaryDTO, resMunicipalities, ip);

        /* send Activate Account Email*/
        userService.sendActivateAccountMail(resUser);

        /*send request for documents email*/
        registrationService.requestLegalDocuments(registrations.get(0).getId());

        /* check Duplicates and crate Threads if apply */
        checkDuplicates(resUser, resMunicipalities);

        return registrations;
    }

    private List<RegistrationDTO> getRegistrationsList(UserDTO userDTO, BeneficiaryDTO beneficiaryDTO, List<MunicipalityDTO> resMunicipalities, String ip) {
        List<RegistrationDTO> registrations = new ArrayList<>();
        for (int i = 0; i < resMunicipalities.size(); i++) {
            MunicipalityDTO municipality = resMunicipalities.get(i);
            MayorDTO mayor = beneficiaryDTO.getMayors().get(i);
            mayor.setMunicipalityId(municipality.getId());

            /* create mayor */
            MayorDTO mayorDtoOutput = mayorService.createMayor(mayor);
            permissionChecker.addTablePermissions(userDTO, Integer.toString(mayorDtoOutput.getId()),
                    RightConstants.MAYORS_TABLE, "[MAYORS] - id: " + mayor.getId() + " - Email: " + mayor.getEmail() + " - Municipality Id: " + mayor.getMunicipalityId());

            /* create registration */
            RegistrationDTO registration = generateNewRegistration(REPRESENTATIVE, municipality, userDTO.getId());
            registration.setIpRegistration(ip);
            registration.setAssociationName(beneficiaryDTO.getAssociationName());
            registration.setOrganisationId(beneficiaryDTO.getOrganisationId());
            RegistrationDTO registrationDtoOutput = registrationService.createRegistration(registration);
            registrations.add(registrationDtoOutput);

            permissionChecker.addTablePermissions(userDTO, Integer.toString(registrationDtoOutput.getId()),
                    RightConstants.REGISTRATIONS_TABLE, "[REGISTRATIONS] - id: " + registration.getId() + " - Role: " + registration.getRole() + " - Municipality Id: " + registration.getMunicipalityId());
        }
        return registrations;
    }

    private void checkDuplicates(UserDTO userDTO, List<MunicipalityDTO> municipalityDTOs) {

        for (MunicipalityDTO municipalityDTO : municipalityDTOs) {
            List<MunicipalityDTO> municipalitiesWithSameLau = municipalityService.getMunicipalitiesByLauId(municipalityDTO.getLauId());
            permissionChecker.addTablePermissions(userDTO, Integer.toString(municipalityDTO.getId()),
                    RightConstants.MUNICIPALITIES_TABLE, "[MUNICIPALITIES] - id: " + municipalityDTO.getId() + " - Country: " + municipalityDTO.getCountry() + " - Lau Id: " + municipalityDTO.getLauId());


            if (municipalitiesWithSameLau.size() > 1) {
                Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                if (userDTO.getLang() != null) {
                    locale = new Locale(userDTO.getLang());
                }
                ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                String subject = bundle.getString("mail.discussionMunicipality.subject");
                String msgBody = bundle.getString("mail.discussionMunicipality.body");
                if (!userService.isLocalHost()) {
                    mailService.sendEmailAsync(userDTO.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
                }

                if (municipalitiesWithSameLau.size() <= 10) {
                    for (MunicipalityDTO municipality : municipalitiesWithSameLau) {
                        RegistrationDTO registrationDTO = registrationService.getRegistrationByMunicipalityId(municipality.getId());
                        if (registrationDTO == null) {
                            continue;
                        }
                        UserDTO userRegistration = userService.getUserById(registrationDTO.getUserId());
                        if (userRegistration.getId() == userDTO.getId() || userRegistration == null) {
                            continue;
                        }
                        locale = new Locale(userRegistration.getLang());
                        bundle = ResourceBundle.getBundle("MailBundle", locale);
                        subject = bundle.getString("mail.discussionMunicipality.subject");
                        msgBody = bundle.getString("mail.discussionMunicipality.body");
                        if (!userService.isLocalHost()) {
                            mailService.sendEmailAsync(userRegistration.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
                        }

                    }
                }

                if (municipalitiesWithSameLau.size() <= 10) {
                    for (MunicipalityDTO municipality : municipalitiesWithSameLau) {
                        RegistrationDTO registrationDTO = registrationService.getRegistrationByMunicipalityId(municipality.getId());
                        if (registrationDTO == null) {
                            continue;
                        }
                        UserDTO userRegistration = userService.getUserById(registrationDTO.getUserId());
                        if (userRegistration.getId() == userDTO.getId() || userRegistration == null) {
                            continue;
                        }
                        locale = new Locale(userRegistration.getLang());
                        bundle = ResourceBundle.getBundle("MailBundle", locale);
                        subject = bundle.getString("mail.discussionMunicipality.subject");
                        msgBody = bundle.getString("mail.discussionMunicipality.body");
                        if (!userService.isLocalHost()) {
                            mailService.sendEmailAsync(userRegistration.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
                        }

                    }
                }

                /* verificamos que existe el thread */

                ThreadDTO threadDTO = threadService.getThreadByTypeAndReason(1, String.valueOf(municipalityDTO.getLauId()));

                if (threadDTO == null) {
                    /* creamos el thrad */
                    threadDTO = new ThreadDTO();
                    threadDTO.setTitle(municipalityDTO.getName());
                    threadDTO.setType(Constant.THREAD_REASON_LAU);
                    threadDTO.setReason(String.valueOf(municipalityDTO.getLauId()));
                    threadDTO = threadService.createThread(threadDTO);

                    /* Añado todos los user threads */
                    for (MunicipalityDTO conflictMunicipality : municipalitiesWithSameLau) {
                        RegistrationDTO conflictRegistrationDTO = registrationService.getRegistrationByMunicipalityId(conflictMunicipality.getId());
                        if (conflictRegistrationDTO != null) {
                            UserThreadsDTO userThreadsDTO = new UserThreadsDTO();
                            userThreadsDTO.setUserId(conflictRegistrationDTO.getUserId());
                            userThreadsDTO.setThreadId(threadDTO.getId());
                            userThreadsService.createUserThreads(userThreadsDTO);
                        }
                    }
                } else {
                    /* añado el nuevo user thread */
                    UserThreadsDTO userThreadsDTO = new UserThreadsDTO();
                    userThreadsDTO.setUserId(userDTO.getId());
                    userThreadsDTO.setThreadId(threadDTO.getId());
                    userThreadsDTO = userThreadsService.createUserThreads(userThreadsDTO);
                }

            }

            /* change registration status to Hold on conflict Registrations*/
            updateRegistrationStatusToHold(municipalitiesWithSameLau);
            //municipalitiesLauIdToHold.add(municipality.getLauId());

        }
    }

    private RegistrationDTO generateNewRegistration(final String role, final MunicipalityDTO municipality, final int userId) {
        RegistrationDTO registration = new RegistrationDTO();
        registration.setRole(role);
        registration.setMunicipalityId(municipality.getId());
        registration.setUserId(userId);
        registration.setStatus(generateRegistrationStatus(municipality));
        return registration;
    }

    private int generateRegistrationStatus(MunicipalityDTO aMunicipalityDTO) {
        if (municipalitiesLauIdToHold.contains(aMunicipalityDTO.getLauId())) {
            return RegistrationStatus.HOLD.getValue();
        } else {
            return RegistrationStatus.OK.getValue();
        }
    }

    private List<MunicipalityDTO> getMunicipalityList(final BeneficiaryDTO beneficiaryDTO) {
        List<MunicipalityDTO> resMunicipalities = new ArrayList<>();
        for (MunicipalityDTO municipality : beneficiaryDTO.getMunicipalities()) {
            /* search for other users registered on the same municipality */

            MunicipalityDTO municipalityDtoOutput = municipalityService.createMunicipality(municipality);
            resMunicipalities.add(municipalityDtoOutput);
        }
        return resMunicipalities;
    }


    /**
     * The update registration status to hold
     */
    private void updateRegistrationStatusToHold(List<MunicipalityDTO> municipalitiesWithSameLau) {
        final String LOG_STATUS_2_HOLD = "Registraion Id {0} updated to the status HOLD";

        /* put all the registrations for a given municiaplity on Hold*/
        for (MunicipalityDTO aMunicipality : municipalitiesWithSameLau) {
            RegistrationDTO registration = registrationService.getRegistrationByMunicipalityId(aMunicipality.getId());
            if (registration != null) {
                registration.setStatus(RegistrationStatus.HOLD.getValue());
                registrationService.createRegistration(registration);
                _log.info(MessageFormat.format(LOG_STATUS_2_HOLD, registration.getId()));
            }
        }
    }

    public Integer setIssueToDgconnBeneficiary(Integer lauId) {
        Integer issueType = 0;
//        boolean duplicated = false;
        LauDTO lau = lauService.getLauById(lauId);
        List<MunicipalityDTO> municipalities = municipalityService.getMunicipalitiesByLauId(lauId);
//        if (municipalities.size() > 1) {
//            duplicated = true;
//        }
        for (MunicipalityDTO municipality : municipalities) {
            MayorDTO mayor = mayorService.getMayorByMunicipalityId(municipality.getId());
            RegistrationDTO registration = registrationService.getRegistrationByMunicipalityId(municipality.getId());
            if (registration != null && mayor != null) {
                UserDTO user = userService.getUserById(registration.getUserId());
                if (user != null) {
                    switch (lau.getCountryCode().toUpperCase()) {
                        case "AT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".at") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".at") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".at")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("de"))) {
                                issueType = 3;
                            }
                            break;
                        case "BE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".be") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".be") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".be")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("de") ||
                                    user.getLang().toLowerCase().equals("nl") ||
                                    user.getLang().toLowerCase().equals("fr"))) {
                                issueType = 3;
                            }
                            break;
                        case "BG":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".bg") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".bg") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".bg")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("bg"))) {
                                issueType = 3;
                            }
                            break;
                        case "HR":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".hr") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".hr") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".hr")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("hr"))) {
                                issueType = 3;
                            }
                            break;
                        case "CY":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".cy") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".cy") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".cy")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("el"))) {
                                issueType = 3;
                            }
                            break;
                        case "CZ":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".cz") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".cz") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".cz")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("cs"))) {
                                issueType = 3;
                            }
                            break;
                        case "DK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".dk") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".dk") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".dk")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("da"))) {
                                issueType = 3;
                            }
                            break;
                        case "EE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ee") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".ee") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".ee")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("et"))) {
                                issueType = 3;
                            }
                            break;
                        case "FI":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".fi") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".fi") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".fi")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("fi") ||
                                    user.getLang().toLowerCase().equals("sv"))) {
                                issueType = 3;
                            }
                            break;
                        case "FR":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".fr") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".fr") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".fr")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("fr"))) {
                                issueType = 3;
                            }
                            break;
                        case "DE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".de") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".de") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".de")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("de"))) {
                                issueType = 3;
                            }
                            break;
                        case "EL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".el") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".el") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".el")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("el"))) {
                                issueType = 3;
                            }
                            break;
                        case "HU":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".hu") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".hu") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".hu")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("hu"))) {
                                issueType = 3;
                            }
                            break;
                        case "IS":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".is") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".is") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".is")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                issueType = 3;
                            }
                            break;
                        case "IE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ie") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".ie") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".ie")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("en") ||
                                    user.getLang().toLowerCase().equals("ga"))) {
                                issueType = 3;
                            }
                            break;
                        case "IT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".it") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".it") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".it")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("it"))) {
                                issueType = 3;
                            }
                            break;
                        case "LV":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lv") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".lv") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".lv")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("lv"))) {
                                issueType = 3;
                            }
                            break;
                        case "LT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lt") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".lt") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".lt")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("lt"))) {
                                issueType = 3;
                            }
                            break;
                        case "LU":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".lu") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".lu") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".lu")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("fr") ||
                                    user.getLang().toLowerCase().equals("de"))) {
                                issueType = 3;
                            }
                            break;
                        case "MT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".mt") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".mt") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".mt")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("mt") ||
                                    user.getLang().toLowerCase().equals("en"))) {
                                issueType = 3;
                            }
                            break;
                        case "NL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".nl") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".nl") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".nl")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("nl"))) {
                                issueType = 3;
                            }
                            break;
                        case "NO":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".no") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".no") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".no")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                issueType = 3;
                            }
                            break;
                        case "PL":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".pl") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".pl") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".pl")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("pl"))) {
                                issueType = 3;
                            }
                            break;
                        case "PT":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".pt") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".pt") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".pt")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("pt"))) {
                                issueType = 3;
                            }
                            break;
                        case "RO":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".ro") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".ro") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".ro")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("ro"))) {
                                issueType = 3;
                            }
                            break;
                        case "SK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".sk") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".sk") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".sk")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("sk"))) {
                                issueType = 3;
                            }
                            break;
                        case "SI":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".si") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".si") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".si")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("sl"))) {
                                issueType = 3;
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
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("es"))) {
                                issueType = 3;
                            }
                            break;
                        case "SE":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".se") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".se") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".se")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("sv"))) {
                                issueType = 3;
                            }
                            break;
                        case "UK":
                            if (!user.getEmail().trim().toLowerCase().endsWith(".uk") ||
                                    !user.getEcasEmail().trim().toLowerCase().endsWith(".uk") ||
                                    !mayor.getEmail().trim().toLowerCase().endsWith(".uk")) {
                                issueType = 1;
                            }
                            if (!(user.getLang().toLowerCase().equals("en"))) {
                                issueType = 3;
                            }
                            break;
                    }

                    //ToDo: replace it with a count strategy, in case there are a lot of items with the same ip
                    /*
                    List<RegistrationDTO> ipRegistrations = registrationService.getRegistrationsByIp(registration.getIpRegistration());
                    for (RegistrationDTO ipRegistration : ipRegistrations) {
                        MunicipalityDTO ipMunicipality = municipalityService.getMunicipalityById(ipRegistration.getMunicipalityId());
                        if (ipRegistration.getId() != registration.getId() &&
                                ipMunicipality.getLauId() == municipality.getLauId()) {
                            issueType = 2;
                        }
                    }
                    */
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
        return issueType;
    }

    public List<BeneficiaryListItemDTO> findDgconnBeneficiaresList(String name, int offset, int count, String orderField, int orderType) {
        List<BeneficiaryListItemDTO> beneficiariesList;
        switch (orderField) {
            case "name":
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByNameDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByNameDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByNameAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByNameAsc(offset, count));
                }
                break;
            case "countryCode":
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByCountryCodeDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByCountryCodeDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByCountryCodeAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByCountryCodeAsc(offset, count));
                }
                break;
            case "counter":
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByCounterDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByCounterDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByCounterAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByCounterAsc(offset, count));
                }
                break;
            case "status":
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByStatusDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByStatusDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByStatusAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByStatusAsc(offset, count));
                }
                break;
            case "mediation":
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByMediationDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByMediationDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByMediationAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByMediationAsc(offset, count));
                }
                break;
            default:
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByLauIdDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByLauIdDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByLauIdAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByLauIdAsc(offset, count));
                }
                break;
        }
        List<BeneficiaryListItemDTO> finalList = new ArrayList<>();
        for (BeneficiaryListItemDTO item : beneficiariesList) {
            item.setIssueStatus(setIssueToDgconnBeneficiary(item.getLauId()));
            if (item.getIssueStatus() != null) {
                finalList.add(item);
            }
        }
        return finalList;
    }

    public Integer getCountDistinctMunicipalities() {
        return municipalityService.getCountDistinctMunicipalities();
    }

    public Integer getCountDistinctMunicipalitiesContainingName(String name) {
        return municipalityService.getCountDistinctMunicipalitiesContainingName(name);
    }

    public int getIssueType(List<RegistrationDTO> registrationDTOList) {
        String validPattern = "^[a-z0-9_-]+(?:\\.[a-z0-9_-]+)*@(?:[a-z0-9]{2,6}?\\.)+(|com|net|info|org|eu|bg|cs|da|de|el|es|et|fi|fr|ga|hr|hu|it|lt|lv|mt|nl|pl|pt|ro|sk|sl|sv|uk|ie|is|no)?$";

        int numDuplicated = 0;
        int numInvalids = 0;
        int numResolved = 0;
        int typeIssue = -1;
        for (RegistrationDTO registrationDTO : registrationDTOList) {
            UserDTO userDTO = userService.getUserById(registrationDTO.getUserId());
            if (!userDTO.getEcasEmail().matches(validPattern)) {
                typeIssue = 1;
                break;
            }
            switch (registrationDTO.getStatus()) {
                case 0:
                    numDuplicated += 1;
                    break;
                case 1:
                    numInvalids += 1;
                    break;
                case 2:
                    numResolved += 1;
                    break;
            }
        }

        if ((numResolved + numInvalids) == registrationDTOList.size() && numResolved > 0) {
            typeIssue = 3;
        } else if (numDuplicated > 1) {
            typeIssue = 2;
        } else if (numInvalids == registrationDTOList.size()) {
            typeIssue = 4;
        } else {
            if (typeIssue != 1) {
                typeIssue = 0;
            }
        }
        if (checkIpDuplicated(registrationDTOList) && typeIssue != 3 && typeIssue != 4) {
            typeIssue = 1;
        }
        return typeIssue;
    }

    public boolean checkIpDuplicated(List<RegistrationDTO> registrationDTOList) {
        Map<String, Integer> mapIps = new HashMap<>();
        for (RegistrationDTO registrationDTO : registrationDTOList) {
            if (mapIps.containsKey(registrationDTO.getIpRegistration())) {
                return true;
            }
            mapIps.put(registrationDTO.getIpRegistration(), 1);
        }
        return false;
    }

    public MunicipalityDetailsDTO getMunicipalityDetailsByMunicipalityId(int municipalityId) {
        MunicipalityDetailsDTO munDetails = new MunicipalityDetailsDTO();
        MunicipalityDTO municipality = municipalityService.getMunicipalityById(municipalityId);
        if (municipality != null) {
            munDetails.setMunicipality(municipality);
            LauDTO lau = lauService.getLauById(municipality.getLauId());
            MayorDTO mayor = mayorService.getMayorByMunicipalityId(municipality.getId());
            if (lau != null) {
                munDetails.setLau(lau);
            }
            if (mayor != null) {
                munDetails.setMayor(mayor);
            }
            RegistrationDTO registration = registrationService.getRegistrationByMunicipalityId(municipality.getId());
            if (registration != null) {
                munDetails.setRegistration(registration);
                List<ApplicationDTO> applications = applicationService.getApplicationsByRegistrationId(registration.getId());
                if (applications != null) {
                    munDetails.setApplications(applications);
                }
            }
        }
        return munDetails;
    }

    public List<MunicipalityDetailsDTO> getMunicipalitiesDetailsByLauId(int lauId) {
        List<MunicipalityDetailsDTO> munsDetails = new ArrayList<>();
        LauDTO lau = lauService.getLauById(lauId);
        if (lau != null) {
            List<MunicipalityDTO> municipalities = municipalityService.getMunicipalitiesByLauId(lauId);
            for (MunicipalityDTO municipality : municipalities) {
                if  (municipality != null) {
                    MunicipalityDetailsDTO munDetails = getMunicipalityDetailsByMunicipalityId(municipality.getId());
                    munsDetails.add(munDetails);
                }
            }
        }
        return munsDetails;
    }

    public List<MunicipalityDetailsDTO> getAppliedMunicipalitiesDetailsByLauIdAndCallId(int lauId, int callId) {
        List<MunicipalityDetailsDTO> finalMunsDetails = new ArrayList<>();
        List<MunicipalityDetailsDTO> munsDetails = getMunicipalitiesDetailsByLauId(lauId);
        for (MunicipalityDetailsDTO munDetails : munsDetails) {
            if (munDetails.getApplications() != null) {
                for (ApplicationDTO application : munDetails.getApplications()) {
                    if (application.getCallId() == callId) {
                        finalMunsDetails.add(munDetails);
                    }
                }
            }
        }
        return finalMunsDetails;
    }

    public String exportCSVDGConnBeneficiariesList() {
        int totalCount = getCountDistinctMunicipalities();
        int pageSize = totalCount;
        List<BeneficiaryListItem> beneficiaries = beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByLauIdAsc(0, pageSize);
        return generateCSVBeneficiaries(beneficiaries, true);
    }

    public String exportCSVDGConnBeneficiariesListSearchingName(String name) {
        int totalCount = getCountDistinctMunicipalitiesContainingName(name);
        int pageSize = totalCount;
        List<BeneficiaryListItem> beneficiaries = beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByLauIdAsc(name, 0, pageSize);
        return generateCSVBeneficiaries(beneficiaries, true);
    }

    public byte[] exportExcelDGConnBeneficiariesList() {
        int totalCount = getCountDistinctMunicipalities();
        int pageSize = totalCount;
        List<BeneficiaryListItem> beneficiaries = beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByLauIdAsc(0, pageSize);
        ExcelExportGenerator excelExportGenerator = new ExcelExportGenerator(beneficiaries, BeneficiaryListItem.class);
        return excelExportGenerator.exportExcelFile("beneficiaries").toByteArray();
    }

    public byte[] exportExcelDGConnBeneficiariesListContainingName(String name) {
        int totalCount = getCountDistinctMunicipalitiesContainingName(name);
        int pageSize = totalCount;
        List<BeneficiaryListItem> beneficiaries = beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByLauIdAsc(name, 0, pageSize);
        ExcelExportGenerator excelExportGenerator = new ExcelExportGenerator(beneficiaries, BeneficiaryListItem.class);
        return excelExportGenerator.exportExcelFile("beneficiaries").toByteArray();
    }

    private String generateCSVBeneficiaries(List<BeneficiaryListItem> beneficiaryListItems, boolean columnHeaders) {
        StringBuilder sb = new StringBuilder();
        if (columnHeaders) {
            sb.append("Name,LauID,CountryCode,NumberRegistrations,Status,Mediation,IssueStatus,");
            sb.append("\n");
        }
        for (BeneficiaryListItem beneficiaryListItem : beneficiaryListItems) {
            sb.append(beneficiaryListItem.getName());
            sb.append(",");
            sb.append(beneficiaryListItem.getLauId());
            sb.append(",");
            sb.append(beneficiaryListItem.getCountryCode());
            sb.append(",");
            if (beneficiaryListItem.getStatus()) {
                sb.append("Applied");
            } else {
                sb.append("Registered");
            }
            sb.append(",");
            if (beneficiaryListItem.getMediation()) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append(",");
            sb.append(beneficiaryListItem.getIssueStatus());
            sb.append(",");
            sb.append("\n");
        }
        return sb.toString();
    }
}