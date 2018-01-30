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
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.security.RightRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.text.MessageFormat;
import java.util.*;

@Service
public class BeneficiaryService {
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

    private final Logger _log = LoggerFactory.getLogger(BeneficiaryService.class);

    private List<Integer> municipalitiesLauIdToHold = new ArrayList<>();
    private final String MAYOR = "Mayor";
    private final String REPRESENTATIVE = "Representative";

    @Transactional
    public List<RegistrationDTO> submitBeneficiaryRegistration(BeneficiaryDTO beneficiaryDTO) throws Exception {

        /* Get user from ECAS */
        UserDTO user;
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
        } else {
            /* Deprecated: TODO: remove it */
            user = beneficiaryDTO.getUser();
            String password = "12345678";
            user.setPassword(password);
            isEcasUser = false;
        }

        user.setCreateDate(new Date().getTime());

        UserDTO resUser;
        if (isEcasUser) {
            resUser = userService.saveUserChanges(user);
        } else {
            /*deprecated_: TODO: remove it */
            resUser = userService.createUser(user);
        }

        /* create municipalities and check duplicates */
        List<MunicipalityDTO> resMunicipalities = getMunicipalityList(beneficiaryDTO);

        /* create registrations between user and municipality */
        List<RegistrationDTO> registrations = getRegistrationsList(resUser, beneficiaryDTO, resMunicipalities);

        /* send Activate Account Email*/
        userService.sendActivateAccountMail(resUser);

        /* check Duplicates and crate Threads if apply */
        checkDuplicates(resUser, resMunicipalities);

        return registrations;
    }

    private List<RegistrationDTO> getRegistrationsList(UserDTO userDTO, BeneficiaryDTO beneficiaryDTO, List<MunicipalityDTO> resMunicipalities) {
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
                        List<RegistrationDTO> registrationDTOs = registrationService.getRegistrationsByMunicipalityId(conflictMunicipality.getId());
                        for (RegistrationDTO conflictRegistrationDTO : registrationDTOs) {
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
            List<RegistrationDTO> registrations = registrationService.getRegistrationsByMunicipalityId(aMunicipality.getId());
            for (RegistrationDTO aRegistrationDTO : registrations) {
                aRegistrationDTO.setStatus(RegistrationStatus.HOLD.getValue());
                registrationService.createRegistration(aRegistrationDTO);

                _log.info(MessageFormat.format(LOG_STATUS_2_HOLD, aRegistrationDTO.getId()));
            }
        }
    }

    public List<BeneficiaryListDTO> getListBeneficiaryTable() {
        /* Gets all municipalities */
        List<MunicipalityDTO> municipalityDTOSList = municipalityService.getAllMunicipalities();

        /* Array of municipality names for check duplicates */
        List<String> municipalities = new ArrayList<>();

        List<BeneficiaryListDTO> beneficiaryListDTOS = new ArrayList<>();

        /* Iterate in municipality list */
        for(MunicipalityDTO municipalityDTO: municipalityDTOSList){
            List<RegistrationDTO> listRegistrations = registrationService.getRegistrationsByMunicipalityId(municipalityDTO.getId());
            BeneficiaryListDTO beneficiaryListDTO = new BeneficiaryListDTO();
            LauDTO lauDTO = lauService.getLauById(municipalityDTO.getLauId());

            /* Checks that the municipality name is in the municipalities array */
            if(municipalities.contains(municipalityDTO.getName())){
                /* Get index in the array */
                int index = municipalities.indexOf(municipalityDTO.getName());

                /* Fills beneficiaryListDTO object with one exisiting in BeneficiaryListDTO list in that position */
                beneficiaryListDTO = beneficiaryListDTOS.get(index);

                /* Increments number of registrations because it's the same lau */
                beneficiaryListDTO.setNumRegistrations(beneficiaryListDTO.getNumRegistrations()+1);

                /* Update object in the position of the list of BeneficiaryListDTO */
                beneficiaryListDTOS.set(index, beneficiaryListDTO);

                /* Adds registrations left in the DTO */
                List<RegistrationDTO> regs = beneficiaryListDTO.getRegistrations();
                for(RegistrationDTO reg: listRegistrations){
                    if(!regs.contains(reg)){
                        regs.add(reg);
                    }
                }
                beneficiaryListDTO.setRegistrations(regs);
            }
            else{
                municipalities.add(municipalityDTO.getName());
                beneficiaryListDTO.setNumRegistrations(1);
                beneficiaryListDTO.setLau(lauDTO);
                beneficiaryListDTO.setRegistrations(listRegistrations);
                beneficiaryListDTOS.add(beneficiaryListDTO);
            }
        }
        getIssueOfRegistration(beneficiaryListDTOS);
        for (BeneficiaryListDTO beneficiaryListDTO: beneficiaryListDTOS){
            for(RegistrationDTO registrationDTO: beneficiaryListDTO.getRegistrations()){
                beneficiaryListDTO.setStatus(getStatusApplicationByRegistration(registrationDTO.getId()));
            }
            beneficiaryListDTO.setMediation(getMediationStatusByLau(beneficiaryListDTO.getLau().getId()));
        }

        return beneficiaryListDTOS;
    }

    public boolean getStatusApplicationByRegistration(int registrationId){
        /* Get all applications with a registration id */
        List<ApplicationDTO> applicationDTOList = applicationService.getApplicationsByRegistrationId(registrationId);
        /* Return true if a application exist (one or more), return false if doesn't have any record */
        if(applicationDTOList.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void getIssueOfRegistration(List<BeneficiaryListDTO> beneficiaryListDTOList){
        /* INVALID -> TODOS LOS REGISTRATIONS TIENE STATUS 1 */

        /* RESOLVED -> UNA 2 DEMAS 1 */

        /* DUPLICATED -> MAS DE UNA 0*/

        /* WARNING -> .eu .com .net .info .28 paises */

        /* NADA -> */

        String validPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.(?:[A-Z]{2,}|com|net|info|org|eu" +
                "|bg|cs|da|de|el|es|et|fi|fr|ga|hr|hu|it|lt|lv|mt|nl|pl|pt|ro|sk|sl|sv|uk|ie|is|no))*$";

        for(BeneficiaryListDTO beneficiaryListDTO: beneficiaryListDTOList){

            int numDuplicated = 0;
            int numInvalids = 0;
            int numResolved = 0;

            for(RegistrationDTO registrationDTO: beneficiaryListDTO.getRegistrations()){
                UserDTO userDTO = userService.getUserById(registrationDTO.getUserId());
                if(!userDTO.getEcasEmail().matches(validPattern)){
                    beneficiaryListDTO.setIssue(1);
                    break;
                }
                switch (registrationDTO.getStatus()){
                    case 0:
                        numDuplicated += 1;
                        break;
                    case 1:
                        numInvalids += 1;
                        break;
                    case 2:
                        numResolved += 1;

                }
            }

            if((numResolved + numInvalids) == beneficiaryListDTO.getRegistrations().size() && numResolved > 0){
                beneficiaryListDTO.setIssue(3);
            }
            else if(numDuplicated > 1){
                beneficiaryListDTO.setIssue(2);
            }
            else if(numInvalids == beneficiaryListDTO.getRegistrations().size()){
                beneficiaryListDTO.setIssue(4);
            }
            else{
                if(beneficiaryListDTO.getIssue() != null) {
                    beneficiaryListDTO.setIssue(1);
                }
                else{
                    beneficiaryListDTO.setIssue(0);
                }
            }
        }
    }

    public boolean getMediationStatusByLau(int laudId) {
        String lauIdParsed = String.valueOf(laudId);
        /* Return only threads with type 1 (LAU) and with a specific laud id */
        ThreadDTO threadDTO = threadService.getThreadByTypeAndReason(Constant.THREAD_REASON_LAU, lauIdParsed);
        if(threadDTO != null){
            return threadDTO.isMediation();
        }
        else{
            return false;
        }
    }

    public List<BeneficiaryDTO> getBeneficiariesByThreadId(int threadId) {
        List<BeneficiaryDTO> beneficiaries = new ArrayList<>();
        ThreadDTO thread = threadService.getThreadById(threadId);
        List<MunicipalityDTO> municipalities = municipalityService.getMunicipalitiesByLauId(Integer.parseInt(thread.getReason()));
        for (MunicipalityDTO municipality : municipalities) {
            System.out.println("MUNICIPALITY whatever");
            BeneficiaryDTO beneficiary = new BeneficiaryDTO();
            List<RegistrationDTO> registrations = registrationService.getRegistrationsByMunicipalityId(municipality.getId());
            for (RegistrationDTO registration : registrations) {
                System.out.println("REGISTRATION something");
                if (registration.getRole().equals(REPRESENTATIVE)) {
                    System.out.println("Let's set the user");
                    beneficiary.setUser(userService.getUserById(registration.getUserId()));
                }
            }
            List<MunicipalityDTO> municipalityList = new ArrayList<>();
            municipalityList.add(municipality);
            beneficiary.setMunicipalities(municipalityList);
            if (registrations.size() > 1) {
                beneficiary.setRepresentsMultipleMunicipalities(true);
            } else {
                beneficiary.setRepresentsMultipleMunicipalities(false);
            }
            beneficiaries.add(beneficiary);
        }
        return beneficiaries;
    }
}