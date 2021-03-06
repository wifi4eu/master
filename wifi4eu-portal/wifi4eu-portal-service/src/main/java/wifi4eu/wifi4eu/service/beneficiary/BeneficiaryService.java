package wifi4eu.wifi4eu.service.beneficiary;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.model.UserHistoryActionDTO;
import wifi4eu.wifi4eu.common.dto.model.UserRegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserThreadsDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.InvitationContactStatus;
import wifi4eu.wifi4eu.common.enums.RegistrationStatus;
import wifi4eu.wifi4eu.common.enums.UserHistoryActionList;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.common.utils.MunicipalityValidator;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryListItem;
import wifi4eu.wifi4eu.entity.invitationContacts.InvitationContact;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.mapper.beneficiary.BeneficiaryListItemMapper;
import wifi4eu.wifi4eu.mapper.history_action.UserHistoryActionMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.beneficiary.BeneficiaryListItemRepository;
import wifi4eu.wifi4eu.repository.history_action.UserHistoryActionRepository;
import wifi4eu.wifi4eu.repository.invitationContacts.InvitationContactRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.ExcelExportGenerator;
import wifi4eu.wifi4eu.util.RegistrationUtils;

@Service
public class BeneficiaryService {

    @Autowired
    BeneficiaryListItemMapper beneficiaryListItemMapper;

    @Autowired
    BeneficiaryListItemRepository beneficiaryListItemRepository;

    @Autowired
    UserHistoryActionMapper userHistoryActionMapper;

    @Autowired
    UserHistoryActionRepository userHistoryActionRepository;

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
    NutsService nutsService;

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    MailService mailService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    RegistrationUsersRepository registrationUsersRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    InvitationContactRepository invitationContactRepository;

    @Autowired
    RegistrationUtils registrationUtils;

    private final Logger _log = LogManager.getLogger(BeneficiaryService.class);

    private List<Integer> municipalitiesLauIdToHold = new ArrayList<>();
    private final String MAYOR = "Mayor";
    private final String REPRESENTATIVE = "Representative";

    @Transactional
    public List<RegistrationDTO> submitBeneficiaryRegistration(BeneficiaryDTO beneficiaryDTO, String ip, HttpServletRequest request) throws Exception {
        /* Validate municipalities */
        for (MunicipalityDTO municipalityDTO : beneficiaryDTO.getMunicipalities()) {
            MunicipalityValidator.validateMunicipality(municipalityDTO, lauService.getLauById(municipalityDTO.getLauId()),
                    nutsService.getNutsByLevel(0));
        }

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
            user.setEcasEmail(beneficiaryDTO.getUser().getEcasEmail());
            user.setCity(beneficiaryDTO.getUser().getCity());
            user.setCountry(beneficiaryDTO.getUser().getCountry());
            user.setType(3);
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
        List<RegistrationDTO> registrations = getRegistrationsList(resUser, beneficiaryDTO, resMunicipalities, ip, request);

        /* send Activate Account Email*/
        userService.sendActivateAccountMail(resUser);

        /*send request for documents email*/
        registrationService.requestLegalDocuments(registrations.get(0).getId());

        /* check Duplicates and crate Threads if apply */
        checkDuplicates(resUser, resMunicipalities);

        return registrations;
    }

    @Transactional
    public List<RegistrationDTO> submitNewMunicipalities(BeneficiaryDTO beneficiaryDTO, String ip, HttpServletRequest request) throws Exception {
        /* Get user from ECAS */
        UserDTO user = new UserDTO();
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        boolean isEcasUser = false;

        /* Validate municipalities */
        for (MunicipalityDTO municipalityDTO : beneficiaryDTO.getMunicipalities()) {
            MunicipalityValidator.validateMunicipality(municipalityDTO, lauService.getLauById(municipalityDTO.getLauId()),
                    nutsService.getNutsByLevel(0));

            List<RegistrationDTO> registrationDTOList = registrationService.getRegistrationsByUserId(userConnected.getId());
            for (RegistrationDTO registration : registrationDTOList) {
                MunicipalityDTO municipality = municipalityService.getMunicipalityById(registration.getMunicipalityId());
                if (municipality.getLauId() == municipalityDTO.getLauId()) {
                    throw new Exception("");
                }

            }
        }

        /* create municipalities and check duplicates */
        List<MunicipalityDTO> resMunicipalities = getMunicipalityList(beneficiaryDTO);

        /* create registrations between user and municipality */
        List<RegistrationDTO> registrations = getRegistrationsList(userConnected, beneficiaryDTO, resMunicipalities, ip, request);

        /*send request for documents email*/
        registrationService.requestLegalDocuments(registrations.get(0).getId());

        /* check Duplicates and crate Threads if apply */
        checkDuplicates(userConnected, resMunicipalities);

        return registrations;
    }

    private List<RegistrationDTO> getRegistrationsList(UserDTO userDTO, BeneficiaryDTO beneficiaryDTO, List<MunicipalityDTO> resMunicipalities, String ip, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        List<RegistrationDTO> registrations = new ArrayList<>();
        for (int i = 0; i < resMunicipalities.size(); i++) {
            MunicipalityDTO municipality = resMunicipalities.get(i);
            MayorDTO mayor = beneficiaryDTO.getMayors().get(i);
            mayor.setMunicipalityId(municipality.getId());

            /* create mayor */
            MayorDTO mayorDtoOutput = mayorService.saveMayor(mayor, request);
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
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - List is retrieved correctly");
        return registrations;
    }

    private void checkDuplicates(UserDTO userDTO, List<MunicipalityDTO> municipalityDTOs) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        for (MunicipalityDTO municipalityDTO : municipalityDTOs) {
            List<MunicipalityDTO> municipalitiesWithSameLau = municipalityService.getMunicipalitiesByLauId(municipalityDTO.getLauId());
            permissionChecker.addTablePermissions(userDTO, Integer.toString(municipalityDTO.getId()),
                    RightConstants.MUNICIPALITIES_TABLE, "[MUNICIPALITIES] - id: " + municipalityDTO.getId() + " - Country: " + municipalityDTO.getCountry() + " - Lau Id: " + municipalityDTO.getLauId());

            if (municipalitiesWithSameLau.size() > 1) {
                Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                if (userDTO.getLang() != null) {
                    locale = new Locale(userDTO.getLang());
                }
                
                MailData mailData = MailHelper.buildMailMultipleRegistrations(
                		userDTO.getEcasEmail(), MailService.FROM_ADDRESS, municipalityDTO.getId(), "checkDuplicates", locale);
            	mailService.sendMail(mailData, true);
                _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Email sent to " + userDTO.getEcasEmail());

                if (municipalitiesWithSameLau.size() <= 10) {
                    for (MunicipalityDTO municipality : municipalitiesWithSameLau) {
                        RegistrationDTO registrationDTO = registrationService.getRegistrationByMunicipalityId(municipality.getId());
                        if (registrationDTO == null) {
                            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Registration from the municipality with id " + municipality.getId() + " does not exist");
                            continue;
                        }
                        UserDTO userRegistration = userMapper.toDTO(userRepository.findMainUserFromRegistration(registrationDTO.getId()));
                        if (userRegistration == null || userRegistration.getId() == userDTO.getId()) {
                            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Registration from the municipality with id " + municipality.getId() + " does not exist");
                            continue;
                        }
                        locale = new Locale(userRegistration.getLang());
                        
                        MailData mailDataIn = MailHelper.buildMailMultipleRegistrations(
                        		userRegistration.getEcasEmail(), MailService.FROM_ADDRESS, municipalityDTO.getId(), "checkDuplicates", locale);
                    	mailService.sendMail(mailDataIn, true);
                        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Email sent to " + userRegistration.getEcasEmail());
                    }
                }

                /* verificamos que existe el thread */
                ThreadDTO threadDTO = threadService.getThreadByTypeAndReason(1, String.valueOf(municipalityDTO.getLauId()));

                if (threadDTO == null) {
                    /* creamos el thread */
                    threadDTO = new ThreadDTO();
                    threadDTO.setTitle(municipalityDTO.getName());
                    threadDTO.setType(Constant.THREAD_REASON_LAU);
                    threadDTO.setReason(String.valueOf(municipalityDTO.getLauId()));
                    threadDTO = threadService.createThread(threadDTO);
                    _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Thread " + threadDTO.getId() + " created");

                    /* Añado todos los user threads */
                    for (MunicipalityDTO conflictMunicipality : municipalitiesWithSameLau) {
                        RegistrationDTO conflictRegistrationDTO = registrationService.getRegistrationByMunicipalityId(conflictMunicipality.getId());
                        if (conflictRegistrationDTO != null) {
                            UserThreadsDTO userThreadsDTO = new UserThreadsDTO();
                            userThreadsDTO.setUserId(userRepository.findMainUserFromRegistration(conflictRegistrationDTO.getId()).getId());
                            userThreadsDTO.setThreadId(threadDTO.getId());
                            userThreadsService.createUserThreads(userThreadsDTO);
                            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - User thread " + threadDTO.getId() + " added");
                        }
                    }
                } else {
                    /* añado el nuevo user thread */
                    UserThreadsDTO userThreadsDTO = new UserThreadsDTO();
                    userThreadsDTO.setUserId(userDTO.getId());
                    userThreadsDTO.setThreadId(threadDTO.getId());
                    userThreadsDTO = userThreadsService.createUserThreads(userThreadsDTO);
                    _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Thread " + threadDTO.getId() + " added");
                }
            }
            /* change registration status to Hold on conflict Registrations*/
            updateRegistrationStatusToHold(municipalitiesWithSameLau);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Duplicates checked");
            //municipalitiesLauIdToHold.add(municipality.getLauId());
        }
    }

    private RegistrationDTO generateNewRegistration(final String role, final MunicipalityDTO municipality, final int userId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        RegistrationDTO registration = new RegistrationDTO();
        RegistrationUsers registrationUsers = new RegistrationUsers();
        registration.setRole(role);
        registration.setMunicipalityId(municipality.getId());

        registration.setStatus(generateRegistrationStatus(municipality));
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - New registration generated");
        return registration;
    }

    private int generateRegistrationStatus(MunicipalityDTO aMunicipalityDTO) {
        if (municipalitiesLauIdToHold.contains(aMunicipalityDTO.getLauId())) {
            return RegistrationStatus.HOLD.getValue();
        } else {
            return RegistrationStatus.OK.getValue();
        }
    }

    private List<MunicipalityDTO> getMunicipalityList(final BeneficiaryDTO beneficiaryDTO) throws Exception {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        List<MunicipalityDTO> resMunicipalities = new ArrayList<>();
        for (MunicipalityDTO municipality : beneficiaryDTO.getMunicipalities()) {
            /* search for other users registered on the same municipality */

            MunicipalityDTO municipalityDtoOutput = municipalityService.saveMunicipality(municipality);
            resMunicipalities.add(municipalityDtoOutput);
            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Municipality " + municipalityDtoOutput.getId() + " added to the list");
        }
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Municipalities retrieved correctly");
        return resMunicipalities;
    }

    /**
     * The update registration status to hold
     */
    private void updateRegistrationStatusToHold(List<MunicipalityDTO> municipalitiesWithSameLau) {
        final String LOG_STATUS_2_HOLD = "Registration Id {0} updated to the status HOLD";

        /* put all the registrations for a given municipality on Hold*/
        for (MunicipalityDTO aMunicipality : municipalitiesWithSameLau) {
            RegistrationDTO registration = registrationService.getRegistrationByMunicipalityId(aMunicipality.getId());
            if (registration != null) {
                registration.setStatus(RegistrationStatus.HOLD.getValue());
                registrationService.saveRegistration(registration);
                _log.info(MessageFormat.format(LOG_STATUS_2_HOLD, registration.getId()));
            }
        }
    }

    public List<BeneficiaryListItemDTO> findDgconnBeneficiaresList(String name, int offset, int count, String orderField, int orderType) throws Exception {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
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
        for (int i = 0; i < beneficiariesList.size(); i++) {
            BeneficiaryListItemDTO beneficiary = beneficiariesList.get(i);
            if (beneficiary.getCounter() == 1) {
                List<RegistrationDTO> registrations = registrationService.getRegistrationsByLauId(beneficiary.getLauId());
                for (RegistrationDTO registration : registrations) {
                    if (registration != null) {
                        // beneficiary.setIssueStatus(registrationService.getRegistrationIssue(registration));
                    }
                }
            } else {
                beneficiary.setIssueStatus(0);
            }
            beneficiariesList.set(i, beneficiary);
        }
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Beneficiaries retrieved correctly");
        return beneficiariesList;
    }

    public Integer getCountDistinctMunicipalities() {
        return municipalityService.getCountDistinctMunicipalities();
    }

    public Integer getCountDistinctMunicipalitiesContainingName(String name) {
        return municipalityService.getCountDistinctMunicipalitiesContainingName(name);
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
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
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
            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Beneficiary " + beneficiaryListItem.getName() + " added to the list");
        }
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - CSV generated");
        return sb.toString();
    }

    public ResponseDTO invitateContactBeneficiary(UserDTO userConnected, int idMunicipality, String newContactEmail) {
        ResponseDTO responseDTO = new ResponseDTO();
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new municipality contact - START");
        if (Validator.isNotNull(idMunicipality) && Validator.isNotNull(newContactEmail) && !newContactEmail.isEmpty() 
          && Validator.isNotNull(registrationRepository.findByMunicipalityId(idMunicipality)) 
          && Validator.isNotNull(registrationService.getRegistrationByUserAndMunicipality(userConnected.getId(), idMunicipality))) {
            if (Validator.isNull(invitationContactRepository.findByEmailInvitedAndIdUserRequestNotIn(newContactEmail, userConnected.getId())) 
              && registrationUtils.enableInvitateContactByUserIdRequested(newContactEmail)) {
                InvitationContact invitationContact = invitationContactRepository.findByEmailInvitedAndIdUserRequest(newContactEmail, userConnected.getId());
                Date today = new Date();
                if (Validator.isNull(invitationContact)) {
                    invitationContact = new InvitationContact();
                    invitationContact.setEmailInvited(newContactEmail);
                    invitationContact.setIdRegistration(registrationRepository.findByMunicipalityId(idMunicipality).getId());
                    invitationContact.setIdUserRequest(userConnected.getId());
                    invitationContact.setType((int) Constant.ROLE_REPRESENTATIVE);
                    invitationContact.setStatus(InvitationContactStatus.PENDING.getValue());
                    invitationContact.setCreateDate(today);
                } else if (invitationContact.getIdRegistration().intValue() != registrationRepository.findByMunicipalityId(idMunicipality).getId().intValue()) {
                    // same user, same email invited, different municipality
                    _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new municipality contact - This user has already been invitated. Please, try another user email");
                    responseDTO.setSuccess(false);
                    responseDTO.setData("This user has already been invitated. Please, try another user email");
                    responseDTO.setError(new ErrorDTO(400, "shared.profile.addContact.exists"));
                    return responseDTO;
                }

                invitationContact.setLastModified(today);
                Locale locale = userConnected.getLang() == null ? new Locale(UserConstants.DEFAULT_LANG) : new Locale(userConnected.getLang());
                MunicipalityDTO municipality = municipalityService.getMunicipalityById(idMunicipality);
                String municipalityName = municipality.getName();
                String userName = userConnected.getName() + ' ' + userConnected.getSurname();
                String additionalInfoUrl = userService.getEcasUrl() + "/cas/eim/external/register.cgi?email=";
                String registrationUrl = userService.getServerAddress() + "/wifi4eu/#/beneficiary-portal/profile";
                MailData mailData = MailHelper.buildMailNewUserBeneficiary(
                		newContactEmail, MailService.FROM_ADDRESS, 
                		userName, municipalityName, additionalInfoUrl, newContactEmail, registrationUrl, locale);
                mailService.sendMail(mailData, false);

                invitationContactRepository.save(invitationContact);
                _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new municipality contact - Successfully");
                responseDTO.setSuccess(true);
                responseDTO.setData("shared.email.sent");
            } else {
                _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new municipality contact - This user has already been invitated. Please, try another user email");
                responseDTO.setSuccess(false);
                responseDTO.setData("This user has already been invitated. Please, try another user email");
                responseDTO.setError(new ErrorDTO(400, "shared.profile.addContact.exists"));
            }
        } else {
            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new municipality contact - Some fields are null or empty. Please, complete all the fields");
            responseDTO.setSuccess(false);
            responseDTO.setData("Some fields are null or empty. Please, complete all the fields");
            responseDTO.setError(new ErrorDTO(400, "shared.profile.addContact.emptyOrNull"));
        }
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new municipality contact - END");
        return responseDTO;
    }

    public boolean checkContactEmailWithMunicipality(String email, Integer municipalityId) {
        return registrationUsersRepository.findByContactEmailAndMunicipality(email, municipalityId) != null;
    }

    public List<UserHistoryActionDTO> getUserHistoryActionsByUserIdAnCallId(Integer userId, Integer callId) {
        List<UserHistoryActionDTO> actions = new ArrayList<>();
        List<UserHistoryActionDTO> lfActions = userHistoryActionMapper.toDTOList(userHistoryActionRepository.findLegalFilesActionsHistoryByUserId(userId));
        for (UserHistoryActionDTO lfAction : lfActions) {
            lfAction.setActionPerformed(UserHistoryActionList.SUPPORTING_DOCUMENTS_UPLOADED.getActionPerformed());
            actions.add(lfAction);
        }
        List<UserHistoryActionDTO> appActions = userHistoryActionMapper.toDTOList(userHistoryActionRepository.findApplicationActionsHistoryByUserIdAndCallId(userId, callId));
        for (UserHistoryActionDTO appAction : appActions) {
            appAction.setActionPerformed(UserHistoryActionList.APPLICATION_SUBMITTED.getActionPerformed());
            actions.add(appAction);
        }
        return actions;
    }
}