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

    public List<BeneficiaryListItemDTO> findDgconnBeneficiaresList(String name, int offset, int count, String orderField, int orderType) throws Exception {
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
                        beneficiary.setIssueStatus(registrationService.getRegistrationIssue(registration));
                    }
                }
            } else {
                beneficiary.setIssueStatus(0);
            }
            beneficiariesList.set(i, beneficiary);
        }
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