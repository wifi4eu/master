package wifi4eu.wifi4eu.service.voucher;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.SelectionStatus;
import wifi4eu.wifi4eu.common.enums.VoucherAssignmentStatus;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.admin.AdminActions;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignmentAuxiliar;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.mapper.voucher.VoucherAssignmentAuxiliarMapper;
import wifi4eu.wifi4eu.mapper.voucher.VoucherAssignmentMapper;
import wifi4eu.wifi4eu.mapper.voucher.VoucherSimulationMapper;
import wifi4eu.wifi4eu.repository.admin.AdminActionsRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentAuxiliarRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.INEAPermissionChecker;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.warning.RegistrationWarningService;
import wifi4eu.wifi4eu.util.SavePreselectionListAsync;
import wifi4eu.wifi4eu.util.SendNotificationsAsync;
import wifi4eu.wifi4eu.util.VoucherSimulationExportGenerator;

import javax.annotation.PostConstruct;
import java.util.*;

@Service("portalVoucherService")
public class VoucherService {

    private Logger _log = LogManager.getLogger(this.getClass());

    @Autowired
    VoucherAssignmentMapper voucherAssignmentMapper;

    @Autowired
    VoucherAssignmentAuxiliarMapper voucherAssignmentAuxiliarMapper;

    @Autowired
    VoucherSimulationMapper voucherSimulationMapper;

    @Autowired
    CallService callService;

    @Autowired
    UserService userService;

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    VoucherManagementService voucherManagementService;

    @Autowired
    RegistrationWarningService registrationWarningService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    VoucherSimulationRepository voucherSimulationRepository;

    @Autowired
    VoucherAssignmentRepository voucherAssignmentRepository;

    @Autowired
    VoucherAssignmentAuxiliarRepository voucherAssignmentAuxiliarRepository;

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    private SimpleRegistrationService simpleRegistrationService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    SimpleMunicipalityService simpleMunicipalityService;

    @Autowired
    SimpleLauService simpleLauService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    ApplicationContext context;

    @Autowired
    TaskExecutor taskExecutor;

    @Autowired
    AdminActionsRepository adminActionsRepository;

    @PostConstruct
    public void init() {
        AdminActions adminActions = adminActionsRepository.findOneByAction("voucher_send_notifications");
        if (Validator.isNotNull(adminActions)) {
            adminActions.setAction("voucher_send_notifications");
            adminActions.setStartDate(null);
            adminActions.setRunning(false);
            adminActions.setEndDate(null);
            adminActionsRepository.save(adminActions);
        }
    }

    public List<VoucherAssignmentDTO> getAllVoucherAssignment() {
        return voucherAssignmentMapper.toDTOList(Lists.newArrayList(voucherAssignmentRepository.findAll()));
    }

    public VoucherAssignmentDTO getVoucherAssignmentById(int voucherAssignmentId) {
        return voucherAssignmentMapper.toDTO(voucherAssignmentRepository.findOne(voucherAssignmentId));
    }

    public VoucherAssignmentDTO getVoucherAssignmentByCall(int callId) {
        return voucherAssignmentMapper.toDTO(voucherAssignmentRepository.findByCallId(callId));
    }

    public VoucherAssignmentAuxiliarDTO getVoucherAssignmentByCallAndStatus(int callId, int status) {
        return voucherAssignmentAuxiliarMapper.toDTO(voucherAssignmentAuxiliarRepository.findByCallIdAndStatusAux(callId, status));
    }

    public int checkIfApplicationInFreeze(Integer applicationId) {
        ApplicationDTO applicationDTO = applicationService.getApplicationById(applicationId);
        return voucherSimulationRepository.checkIfApplicationIsFreeze(applicationDTO.getId(), applicationDTO.getCallId(), VoucherAssignmentStatus.FREEZE_LIST.getValue());
    }

    public int checkIfApplicationInSimulation(Integer applicationId) {
        ApplicationDTO applicationDTO = applicationService.getApplicationById(applicationId);
        return voucherSimulationRepository.checkIfSimulationExistByCallId(applicationDTO.getCallId(), VoucherAssignmentStatus.SIMULATION.getValue(), VoucherAssignmentStatus.PRE_LIST.getValue());
    }

    public VoucherAssignmentAuxiliarDTO getVoucherAssignmentAuxiliarByCall(int callId) {
        VoucherAssignmentAuxiliarDTO voucherAssignmentAuxiliarDTO = voucherAssignmentAuxiliarMapper.toDTO(voucherAssignmentAuxiliarRepository.findByCallIdAndStatusAux(callId, 1));
        if (voucherAssignmentAuxiliarDTO == null) {
            throw new AppException("Voucher assigment not found for call id: " + callId);
        }

        VoucherAssignmentAuxiliarDTO voucherAssignmentPreList = voucherAssignmentAuxiliarMapper.toDTO(voucherAssignmentAuxiliarRepository.findByCallIdAndStatusAux(callId, 2));

        voucherAssignmentAuxiliarDTO.setHasPreListSaved(voucherAssignmentPreList != null);
        if (voucherAssignmentPreList != null) {
            voucherAssignmentAuxiliarDTO.setPreListExecutionDate(voucherAssignmentPreList.getExecutionDate());
        }

        VoucherAssignmentAuxiliarDTO voucherAssignmentFreezeList = voucherAssignmentAuxiliarMapper.toDTO(voucherAssignmentAuxiliarRepository.findByCallIdAndStatusAux(callId, 3));
        voucherAssignmentAuxiliarDTO.setHasFreezeListSaved(voucherAssignmentFreezeList != null);
        if (voucherAssignmentFreezeList != null) {
            voucherAssignmentAuxiliarDTO.setFreezeLisExecutionDate(voucherAssignmentFreezeList.getExecutionDate());
            voucherAssignmentAuxiliarDTO.setNotifiedDate(voucherAssignmentFreezeList.getNotifiedDate());
        }

        return voucherAssignmentAuxiliarDTO;
    }

    public ResponseDTO getVoucherSimulationByVoucherAssignment(int voucherAssignmentId, String country, String municipality, Pageable pageable) {
        _log.debug("ECAS Username: " + userService.getUserByUserContext(UserHolder.getUser()).getEcasUsername() + " - Retrieving voucher simulations - voucherAssignment: " + voucherAssignmentId + "municipality: " + municipality + ", country: " + country);
        Page<VoucherSimulation> simulationPaged = null;
        List<VoucherSimulationDTO> listSimulation = new ArrayList<>();
        int totalElements = 0;
        String sortDirection = "ASC";
        if (pageable.getSort().getOrderFor("municipalityName") != null) {
            sortDirection = pageable.getSort().getOrderFor("municipalityName").getDirection().name();
        }

        if (country.isEmpty() || country.equalsIgnoreCase("All")) {
            country = "";
        }
        if (municipality.isEmpty() || municipality.equalsIgnoreCase("All")) {
            municipality = "";
        }
        if (pageable.getSort().getOrderFor("municipalityName") != null) {
            listSimulation = voucherSimulationMapper.toDTOList(voucherSimulationRepository.findAllByVoucherAssignmentAndMunicipalityInCountryOrderedByMunicipalityName(voucherAssignmentId, municipality, country, pageable.getOffset(), pageable.getPageSize(), sortDirection));
            totalElements = voucherSimulationRepository.countAllByVoucherAssignmentAndMunicipalityInCountry(voucherAssignmentId, municipality, country);
        } else if (pageable.getSort().getOrderFor("issues") != null) {
            sortDirection = pageable.getSort().getOrderFor("issues").getDirection().name();
            if (sortDirection == "ASC") {
                listSimulation = voucherSimulationMapper.toDTOList(voucherSimulationRepository.findAllByVoucherAssignmentAndMunicipalityInCountryOrderedByIssuesAsc(voucherAssignmentId, municipality, country, pageable.getOffset(), pageable.getPageSize(), sortDirection));
            } else {
                listSimulation = voucherSimulationMapper.toDTOList(voucherSimulationRepository.findAllByVoucherAssignmentAndMunicipalityInCountryOrderedByIssuesDesc(voucherAssignmentId, municipality, country, pageable.getOffset(), pageable.getPageSize(), sortDirection));
            }
            totalElements = voucherSimulationRepository.countAllByVoucherAssignmentAndMunicipalityInCountry(voucherAssignmentId, municipality, country);
        } else {
            simulationPaged = voucherSimulationRepository.findAllByVoucherAssignmentAndMunicipalityInCountryOrderedByEuRank(voucherAssignmentId, country, municipality, pageable);
            listSimulation = voucherSimulationMapper.toDTOList(Lists.newArrayList(simulationPaged.getContent()));
        }
        for (VoucherSimulationDTO voucherSimulation : listSimulation) {
            List<RegistrationWarningDTO> warningList = registrationWarningService.getWarningsByRegistrationId(voucherSimulation.getApplication().getRegistrationId());
            SimpleMunicipalityDTO simpleMunicipalityDTO = simpleMunicipalityService.getMunicipalityById(voucherSimulation.getMunicipality());
            voucherSimulation.setMunicipalityName(simpleMunicipalityDTO.getName());
            voucherSimulation.setLau(simpleMunicipalityDTO.getLau());
            voucherSimulation.setRegistrationWarningDTO(warningList);
        }
        if (pageable.getSort().getOrderFor("municipalityName") != null || pageable.getSort().getOrderFor("issues") != null) {
            return new ResponseDTO(true, listSimulation, (long) totalElements, null);
        }
        return new ResponseDTO(true, listSimulation, simulationPaged.getTotalElements(), null);
    }

    public byte[] exportVoucherSimulation(int voucherAssignmentId, String country, String municipalityName, Pageable pageable) {
        _log.debug("ECAS Username: " + userService.getUserByUserContext(UserHolder.getUser()).getEcasUsername() + " - Downloading excel voucher simulation with parameters - voucherAssignment: " + voucherAssignmentId + "municipality: " + municipalityName + ", country: " + country);
        List<VoucherSimulationDTO> simulationDTOS = (List<VoucherSimulationDTO>) getVoucherSimulationByVoucherAssignment(voucherAssignmentId, country, municipalityName, pageable).getData();
        VoucherAssignmentDTO voucherAssignmentDTO = getVoucherAssignmentById(voucherAssignmentId);

        VoucherSimulationExportGenerator excelExportGenerator = new VoucherSimulationExportGenerator(simulationDTOS, voucherAssignmentDTO, VoucherSimulationDTO.class);
        return excelExportGenerator.exportExcelFile("voucher_simulation").toByteArray();
    }

    public boolean checkSavePreSelectionEnabled(int voucherAssignmentId) {
        return voucherSimulationRepository.checkIfSimulationIsValid(voucherAssignmentId) == 0;
    }

    @Transactional
    public VoucherAssignmentDTO saveFreezeListSimulation(String freezePsswd, int voucherAssignmentId, int callId) {

        if (!INEAPermissionChecker.freezePsswd.equals(freezePsswd)) {
            throw new AppException("Wrong password");
        }

        CallDTO callDTO = callService.getCallById(callId);

        if (callDTO == null) {
            throw new AppException("Call not exists");
        }

        if (!checkApplicationAreValidForFreezeList(callId)) {
            throw new AppException("Not all applications are validated to save the freeze list");
        }

        VoucherAssignmentAuxiliarDTO voucherAssignmentAuxiliarDTO = voucherAssignmentAuxiliarMapper.toDTO(voucherAssignmentAuxiliarRepository.findByCallIdAndStatusAux(callDTO.getId(), VoucherAssignmentStatus.FREEZE_LIST.getValue()));

        if (voucherAssignmentAuxiliarDTO != null) {
            throw new AppException("Freeze list already exist for call " + callId);
        }

        List<VoucherSimulationDTO> simulationDTOS = voucherSimulationMapper.toDTOList(voucherSimulationRepository.findAllByVoucherAssignmentAndStatusOrderByEuRank(voucherAssignmentId));
        Set<VoucherSimulationDTO> simulationDTOSet = new HashSet<>();

        VoucherAssignmentDTO freezeVoucherAssignment = new VoucherAssignmentDTO();
        freezeVoucherAssignment.setStatus(VoucherAssignmentStatus.FREEZE_LIST.getValue());
        freezeVoucherAssignment.setExecutionDate(new Date().getTime());
        freezeVoucherAssignment.setUser(userService.getUserByUserContext(UserHolder.getUser()));
        freezeVoucherAssignment.setCall(callDTO);

        VoucherAssignmentDTO result = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(freezeVoucherAssignment)));

        for (VoucherSimulationDTO voucherSimulation : simulationDTOS) {
            VoucherSimulationDTO voucherSimulationDTO = new VoucherSimulationDTO();
            voucherSimulationDTO.setApplication(voucherSimulation.getApplication());
            voucherSimulationDTO.setCountry(voucherSimulation.getCountry());
            voucherSimulationDTO.setCountryRank(voucherSimulation.getCountryRank());
            voucherSimulationDTO.setEuRank(voucherSimulation.getEuRank());
            voucherSimulationDTO.setLau(voucherSimulation.getLau());
            voucherSimulationDTO.setMunicipality(voucherSimulation.getMunicipality());
            voucherSimulationDTO.setMunicipalityName(voucherSimulation.getMunicipalityName());
            voucherSimulationDTO.setNumApplications(voucherSimulation.getNumApplications());
            voucherSimulationDTO.setSelectionStatus(voucherSimulation.getSelectionStatus());
            if (voucherSimulation.getSelectionStatus() == SelectionStatus.MAIN_LIST.getValue()) {
                voucherSimulationDTO.setSelectionStatus(SelectionStatus.SELECTED.getValue());
            }
            voucherSimulationDTO.setRejected(voucherSimulation.getRejected());
            voucherSimulationDTO.setVoucherAssignment(result.getId());
            if (voucherSimulationDTO.getSelectionStatus() != SelectionStatus.REJECTED.getValue()) {
                simulationDTOSet.add(voucherSimulationDTO);
            }
        }

        result.setVoucherSimulations(simulationDTOSet);
        return voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(result)));
    }

    @Transactional
    public void savePreListSimulation(int voucherAssignmentId, int callId) {
        CallDTO callDTO = callService.getCallById(callId);

        if (callDTO == null) {
            throw new AppException("Call not exists");
        }

        if (checkSavePreSelectionEnabled(voucherAssignmentId)) {

            VoucherAssignmentAuxiliarDTO auxiliarDTO = voucherAssignmentAuxiliarMapper.toDTO(voucherAssignmentAuxiliarRepository.findByCallIdAndStatusAux(callId, 1));
            if (auxiliarDTO == null) {
                throw new AppException("Voucher assigment not found");
            }

            VoucherAssignmentDTO voucherAssignment = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.findByCallIdAndStatusEquals(callId, SelectionStatus.REJECTED.getValue()));

            if (voucherAssignment != null) {
                throw new AppException("Existing Pre-selection list for callId: " + callId);
            }

            taskExecutor.execute(context.getBean(SavePreselectionListAsync.class, callId, auxiliarDTO.getId()));
        } else {
            throw new AppException("Error saving pre-selected list");
        }
    }

    public Boolean checkApplicationAreValidForFreezeList(int callId) {
        if (getVoucherAssignmentByCallAndStatus(callId, VoucherAssignmentStatus.PRE_LIST.getValue()) != null) {
            return voucherSimulationRepository.checkApplicationAreValidForFreezeList(callId);
        }
        return false;
    }

    @Transactional
    public ResponseDTO simulateVoucherFast(int callId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Executing voucher simulation for call: " + callId);
        HashMap<Integer, SimpleMunicipalityDTO> municipalityHashMap = new HashMap<>();
        HashMap<Integer, SimpleLauDTO> lauHashMap = new HashMap<>();
        HashMap<Integer, SimpleRegistrationDTO> registrationsHashMap = new HashMap<>();
        HashMap<Integer, VoucherSimulationDTO> voucherSimulationDTOHashMap = new HashMap<>();

        if (userContext != null) {
            CallDTO call = callService.getCallById(callId);
            if (call == null) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Call not exist");
                return new ResponseDTO(false, "Call not exist", null);
            }

            if (call.getNumberVouchers() == 0) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Simulation stopped due to number of vouchers to be assigned");
                return new ResponseDTO(false, "Simulation stopped", null);
            }
            UserDTO userDTO = userConnected;
            int callNr = call.getId();
            int vouchersToBeAssigned = call.getNumberVouchers();

            // String => Country_code == 'ES' OR 'DE', Integer => counter each country
            HashMap<String, Integer> countryMin = new HashMap<>();
            HashMap<String, Integer> countryMax = new HashMap<>();

            // Countries extracted from list of applications in FIFO order
            List<String> participatingCountries = new ArrayList<>();

            // List<ApplicationDTO> listOfApplications = applicationService.getApplicationsByCallFiFoOrder(call.getId());
            long dateNanoSeconds = call.getStartDate();
            List<ApplicationDTO> listOfApplications = applicationService.findByCallIdOrderByDateBeforeCallDateAsc(call.getId(), dateNanoSeconds);

            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Initializing municipalities, laus & registrations");

            List<SimpleMunicipalityDTO> municipalities = simpleMunicipalityService.getAllMunicipalities();
            List<SimpleLauDTO> laus = simpleLauService.getAllLausFromApplications();
            List<SimpleRegistrationDTO> registrations = simpleRegistrationService.findAll();
            VoucherAssignmentDTO voucherAssignment = getVoucherAssignmentByCall(call.getId());
            boolean hasPreList = getVoucherAssignmentByCallAndStatus(callId, VoucherAssignmentStatus.PRE_LIST.getValue()) != null;

            if (voucherAssignment != null && hasPreList) {
                for (VoucherSimulationDTO simulationDTO : voucherAssignment.getVoucherSimulations()) {
                    voucherSimulationDTOHashMap.put(simulationDTO.getApplication().getId(), simulationDTO);
                }
            }

            for (SimpleMunicipalityDTO mun : municipalities) {
                municipalityHashMap.put(mun.getId(), mun);
            }

            for (SimpleRegistrationDTO reg : registrations) {
                registrationsHashMap.put(reg.getId(), reg);
            }

            for (SimpleLauDTO lau : laus) {
                lauHashMap.put(lau.getId(), lau);
                if (!participatingCountries.contains(lau.getCountry_code()) && lau.getCountry_code() != null) {
                    participatingCountries.add(lau.getCountry_code());
                }
            }

            int nrParticipatingCountries = participatingCountries.size();
            if (participatingCountries.isEmpty()) {
                return new ResponseDTO(false, "Simulation stopped", null);
            }

            int numReserveList = call.getReserve();

            // String => name municipality, Application of the municipality
            HashMap<Integer, ApplicationDTO> assignedVouchers = new HashMap<>();

            // String => Country_code == 'ES' OR 'DE', List of applications in reserved list of each country
            HashMap<String, List<ApplicationDTO>> countryReserveList = new HashMap<>();

            // String => Country_code == 'ES' OR 'DE', Integer => counter each country
            HashMap<String, Integer> countryCounter = new HashMap<>();
            HashMap<String, Integer> countryReserveListCounter = new HashMap<>();

            HashMap<String, List<MunicipalityDTO>> countryTest = new HashMap<>();

            List<ApplicationDTO> rejectedApplications = new ArrayList<>();

            int totalAssignedVouchers = 0;

            // Fill maximums and minimums for each country
            List<VoucherManagementDTO> voucherManagements = voucherManagementService.getVoucherManagementByCall(call.getId());

            for (VoucherManagementDTO voucherManagement : voucherManagements) {
                if (voucherManagement.getMaximum() == 0 || voucherManagement.getMinimum() == 0) {
                    return new ResponseDTO(false, "Simulation stopped", null);
                }
                countryTest.put(voucherManagement.getCountryCode().toUpperCase(), new ArrayList<>());
                countryReserveListCounter.put(voucherManagement.getCountryCode().toUpperCase(), 0);
                countryMax.put(voucherManagement.getCountryCode().toUpperCase(), voucherManagement.getMaximum());
                countryMin.put(voucherManagement.getCountryCode().toUpperCase(), voucherManagement.getMinimum());
            }

            for (String country : participatingCountries) {
                if (country != null) {
                    country = country.toUpperCase().trim();
                    countryCounter.put(country, 0);
                }
            }

            // List of applications cloned to use in the algorithm
            List<ApplicationDTO> supportLOAlist = new ArrayList<>(listOfApplications);
            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Assigning minimum vouchers");

            for (String country : participatingCountries) {

                try {

                    if (country.equalsIgnoreCase("no")) {
                        country = country.toUpperCase();
                    }

                    //GET Applications for each country
                    List<ApplicationDTO> applicationsCountry = applicationService.getApplicationByCallAndCountry(callId, country, dateNanoSeconds);

                    for (ApplicationDTO applicationDTO : applicationsCountry) {

                        if (applicationDTO.getStatus() == 1) {
                            removeFromLOA(supportLOAlist, applicationDTO);
                            continue;
                        }
                        if (applicationDTO.getRejected() && hasPreList) {
                            rejectedApplications.add(applicationDTO);
                            removeFromLOA(supportLOAlist, applicationDTO);
                            continue;
                        }

                        if (countryCounter.get(country) >= countryMin.get(country)) {
                            //removeFromLOA(supportLOAlist, applicationDTO);
                            break;
                        }

                        SimpleRegistrationDTO registrationDTO = registrationsHashMap.get(applicationDTO.getRegistrationId());

                        if (registrationDTO != null) {
                            SimpleMunicipalityDTO municipalityDTO = municipalityHashMap.get(registrationDTO.getMunicipalityId());

                            //Check if municipality with the same name have been assigned, if assigned then delete else continue
                            if (assignedVouchers.containsKey(municipalityDTO.getLau())) {
                                removeFromLOA(supportLOAlist, applicationDTO);
                                continue;
                            }
                            assignedVouchers.put(municipalityDTO.getLau(), applicationDTO);
                            countryCounter.put(country, countryCounter.get(country) + 1);
                            totalAssignedVouchers += 1;
                            removeFromLOA(supportLOAlist, applicationDTO);
                        }
                    }
                } catch (Exception e) {
                    _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - Error assigning minimum of vouchers to country", e.getMessage());
                }
            }

            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Assigning maximum vouchers");

            for (ApplicationDTO applicationDTO : new ArrayList<>(supportLOAlist)) {
                try {
                    if (totalAssignedVouchers >= vouchersToBeAssigned || supportLOAlist.size() == 0) {
                        break;
                    }

                    if (applicationDTO.getStatus() == 1) {
                        removeFromLOA(supportLOAlist, applicationDTO);
                        continue;
                    }
                    if (applicationDTO.getRejected() && hasPreList) {
                        rejectedApplications.add(applicationDTO);
                        removeFromLOA(supportLOAlist, applicationDTO);
                        continue;
                    }

                    SimpleRegistrationDTO registrationDTO = registrationsHashMap.get(applicationDTO.getRegistrationId());

                    if (registrationDTO != null) {
                        SimpleMunicipalityDTO municipalityDTO = municipalityHashMap.get(registrationDTO.getMunicipalityId());
                        SimpleLauDTO lauDTO = lauHashMap.get(municipalityDTO.getLau());

                        String country = lauDTO.getCountry_code();
                        country = country.trim();
                        if (country.equalsIgnoreCase("no")) {
                            country = country.toUpperCase();
                        }

                        if (assignedVouchers.containsKey(municipalityDTO.getLau())) {
                            removeFromLOA(supportLOAlist, applicationDTO);
                            continue;
                        }

                        if (countryCounter.get(country) >= countryMax.get(country)) {
                            int numReserveCountry = countryReserveListCounter.get(country);

                            if (numReserveCountry < numReserveList) {
                                if (countryReserveList.get(country) == null) {
                                    countryReserveList.put(country, new ArrayList<>());
                                }
                                List<ApplicationDTO> countryApps = new ArrayList<>(countryReserveList.get(country));
                                countryApps.add(applicationDTO);
                                countryReserveList.put(country, countryApps);
                                countryReserveListCounter.put(lauDTO.getCountry_code(), countryReserveListCounter.get(country) + 1);
                            }
                            removeFromLOA(supportLOAlist, applicationDTO);
                            continue;
                        }
                        assignedVouchers.put(municipalityDTO.getLau(), applicationDTO);
                        countryCounter.put(lauDTO.getCountry_code(), countryCounter.get(lauDTO.getCountry_code()) + 1);
                        totalAssignedVouchers += 1;
                        removeFromLOA(supportLOAlist, applicationDTO);
                    }
                } catch (Exception e) {
                    _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - Error assigning maximum of vouchers to country", e.getMessage());
                }
            }

            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Filling reserve list");
            if (!supportLOAlist.isEmpty()) {
                for (String country : participatingCountries) {
                    country = country.trim();
                    if (country.equalsIgnoreCase("no")) {
                        country = country.toUpperCase();
                    }

                    if (countryReserveListCounter.get(country) == null || countryReserveListCounter.get(country) >= numReserveList) {
                        continue;
                    }

                    try {
                        List<ApplicationDTO> applicationsCountry = getFirtsApplicationCountry(registrationsHashMap, lauHashMap, municipalityHashMap,
                                supportLOAlist, country);

                        for (ApplicationDTO application : applicationsCountry) {

                            if (application.getStatus() == 1) {
                                removeFromLOA(supportLOAlist, application);
                                continue;
                            }
                            if (application.getRejected() && hasPreList) {
                                rejectedApplications.add(application);
                                removeFromLOA(supportLOAlist, application);
                                continue;
                            }


                            SimpleRegistrationDTO registrationDTO = registrationsHashMap.get(application.getRegistrationId());

                            if (registrationDTO != null) {
                                SimpleMunicipalityDTO municipalityDTO = municipalityHashMap.get(registrationDTO.getMunicipalityId());

                                List<ApplicationDTO> countryApps = countryReserveList.get(country);

                                if (countryApps == null) {
                                    countryApps = new ArrayList<>();
                                }

                                if (assignedVouchers.containsKey(municipalityDTO.getLau()) || checkIfApplicationExists(countryApps, application)) {
                                    removeFromLOA(supportLOAlist, application);
                                    continue;
                                }

                                if (countryReserveListCounter.get(country) >= numReserveList) {
                                    break;
                                }

                                countryApps.add(application);
                                countryReserveList.put(country, countryApps);
                                countryReserveListCounter.put(country, countryReserveListCounter.get(country) + 1);

                                removeFromLOA(supportLOAlist, application);
                            }
                        }
                    } catch (Exception e) {
                        _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - Error assigning reserve of vouchers to country", e.getMessage());
                    }
                }
            }

            List<List<ApplicationDTO>> generalOutput = new ArrayList<>();
            List<ApplicationDTO> mainListOutput = new ArrayList<>(assignedVouchers.values());
            Set<VoucherSimulationDTO> simulations = new HashSet<>();

            List<ApplicationDTO> reserveListCompleted = new ArrayList<>();

            for (List<ApplicationDTO> applications : countryReserveList.values()) {
                reserveListCompleted.addAll(applications);
            }

            Collections.sort(mainListOutput, (o1, o2) -> {
                if (o1.getDate() > o2.getDate()) {
                    return 1;
                } else if (o1.getDate() < o2.getDate()) {
                    return -1;
                } else {
                    return 0;
                }
            });

            Collections.sort(reserveListCompleted, (o1, o2) -> {
                if (o1.getDate() > o2.getDate()) {
                    return 1;
                } else if (o1.getDate() < o2.getDate()) {
                    return -1;
                } else {
                    return 0;
                }
            });

            VoucherAssignmentDTO assignmentDTO = new VoucherAssignmentDTO();
            assignmentDTO.setCall(call);
            assignmentDTO.setStatus(1);
            assignmentDTO.setExecutionDate(new Date().getTime());
            assignmentDTO.setUser(userDTO);


            if (voucherAssignment == null) {
                voucherAssignment = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(assignmentDTO)));
            } else {
                voucherSimulationRepository.deleteVoucherSimulationByVoucherAssignment(voucherAssignment.getId());

                voucherAssignment.setCall(call);
                voucherAssignment.setUser(userDTO);
                voucherAssignment.setVoucherSimulations(null);
                voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(voucherAssignment));
            }


            HashMap<String, Integer> countryRankCounter = new HashMap<>();
            List<ApplicationDTO> ids = new ArrayList<>();
            int i = 1;
            for (ApplicationDTO applicationAssigned : mainListOutput) {

                SimpleRegistrationDTO registrationDTO = registrationsHashMap.get(applicationAssigned.getRegistrationId());
                SimpleMunicipalityDTO municipalityDTO = municipalityHashMap.get(registrationDTO.getMunicipalityId());

                int num = applicationService.countApplicationWithSameMunicipalityName(municipalityDTO.getLau(), call.getId(), dateNanoSeconds);

                countryRankCounter.put(municipalityDTO.getCountry(), countryRankCounter.getOrDefault(municipalityDTO.getCountry(), 0) + 1);

                if (voucherSimulationDTOHashMap.size() > 0 && hasPreList) {
                    Integer status;
                    if (voucherSimulationDTOHashMap.get(applicationAssigned.getId()) != null) {
                        status = voucherSimulationDTOHashMap.get(applicationAssigned.getId()).getSelectionStatus();
                        if (status == SelectionStatus.RESERVE_LIST.getValue()) {
                            applicationAssigned.setPreSelectedFlag(false);
                            ids.add(applicationAssigned);
                        }
                    }
                }

                VoucherSimulationDTO simulation = new VoucherSimulationDTO();
                simulation.setCountry(municipalityDTO.getCountry());
                simulation.setApplication(applicationAssigned);
                simulation.setVoucherAssignment(voucherAssignment.getId());
                simulation.setNumApplications(num);
                simulation.setMunicipality(municipalityDTO.getId());
                simulation.setEuRank(i);
                simulation.setSelectionStatus(0);
                simulation.setCountryRank(countryRankCounter.get(municipalityDTO.getCountry()));
                simulations.add(simulation);
                i++;
            }

            for (ApplicationDTO reservedApplication : reserveListCompleted) {
                SimpleRegistrationDTO registrationDTO = registrationsHashMap.get(reservedApplication.getRegistrationId());
                SimpleMunicipalityDTO municipalityDTO = municipalityHashMap.get(registrationDTO.getMunicipalityId());

                int num = applicationService.countApplicationWithSameMunicipalityName(municipalityDTO.getLau(), call.getId(), dateNanoSeconds);

                countryRankCounter.put(municipalityDTO.getCountry(), countryRankCounter.getOrDefault(municipalityDTO.getCountry(), 0) + 1);

                VoucherSimulationDTO simulation = new VoucherSimulationDTO();
                simulation.setApplication(reservedApplication);
                simulation.setCountry(municipalityDTO.getCountry());
                simulation.setVoucherAssignment(voucherAssignment.getId());
                simulation.setNumApplications(num);
                simulation.setMunicipality(municipalityDTO.getId());
                simulation.setEuRank(i);
                simulation.setSelectionStatus(1);
                simulation.setCountryRank(countryRankCounter.get(municipalityDTO.getCountry()));
                simulations.add(simulation);
                i++;
            }

            for (ApplicationDTO rejectedApplication : rejectedApplications) {
                SimpleRegistrationDTO registrationDTO = registrationsHashMap.get(rejectedApplication.getRegistrationId());
                SimpleMunicipalityDTO municipalityDTO = municipalityHashMap.get(registrationDTO.getMunicipalityId());

                int num = applicationService.countApplicationWithSameMunicipalityName(municipalityDTO.getLau(), call.getId(), dateNanoSeconds);

                countryRankCounter.put(municipalityDTO.getCountry(), countryRankCounter.getOrDefault(municipalityDTO.getCountry(), 0) + 1);

                VoucherSimulationDTO simulation = new VoucherSimulationDTO();
                simulation.setApplication(rejectedApplication);
                simulation.setCountry(municipalityDTO.getCountry());
                simulation.setVoucherAssignment(voucherAssignment.getId());
                simulation.setNumApplications(num);
                simulation.setMunicipality(municipalityDTO.getId());
                simulation.setEuRank(Integer.MAX_VALUE);
                simulation.setSelectionStatus(2);
                simulation.setCountryRank(Integer.MAX_VALUE);
                simulations.add(simulation);
                i++;
            }

            if (ids.size() > 0) {
                try {
                    _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Marking applications as NEW");
                    applicationRepository.save(applicationMapper.toEntityList(ids));
                } catch (Exception ex) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Error updating applications" + ex.getMessage(), ex);
                }
            }

            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Saving simulation to database");

            voucherAssignment.setVoucherSimulations(simulations);
            VoucherAssignmentDTO res = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(voucherAssignment)));
            VoucherAssignmentAuxiliarDTO voucher = new VoucherAssignmentAuxiliarDTO();
            voucher.setId(res.getId());
            voucher.setStatus(res.getStatus());
            voucher.setExecutionDate(res.getExecutionDate());
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Voucher simulation successfully executed");
            return new ResponseDTO(true, voucher, null);
        }
        return new ResponseDTO(false, "User not defined", null);
    }

    public List<ApplicationDTO> getFirtsApplicationCountry(HashMap<Integer, SimpleRegistrationDTO> registrationsMap,
                                                           HashMap<Integer, SimpleLauDTO> lausMap,
                                                           HashMap<Integer, SimpleMunicipalityDTO> municipalitiesMap,
                                                           List<ApplicationDTO> apps, String country) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        List<ApplicationDTO> appCountry = new ArrayList<>();
        for (ApplicationDTO application : apps) {
            SimpleRegistrationDTO registrationDTO = registrationsMap.get(application.getRegistrationId());
            if (registrationDTO != null) {
                SimpleMunicipalityDTO municipalityDTO = municipalitiesMap.get(registrationDTO.getMunicipalityId());

                try {
                    SimpleLauDTO lauDTO = lausMap.get(municipalityDTO.getLau());
                    if (lauDTO.getCountry_code().equals(country)) {
                        appCountry.add(application);
                    }
                } catch (Exception e) {
                    _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - Error retrieving application by country", e.getMessage());
                }
            }
        }
        return appCountry;
    }

    public void removeFromLOA(List<ApplicationDTO> listLOA, ApplicationDTO applicationDTO) {
        for (int i = 0; i < listLOA.size(); i++) {
            if (listLOA.get(i).getId() == applicationDTO.getId()) {
                listLOA.remove(i);
                break;
            }
        }
    }

    public boolean checkIfApplicationExists(List<ApplicationDTO> listAppsCountry, ApplicationDTO application) {
        for (ApplicationDTO applicationCountry : listAppsCountry) {
            if (applicationCountry.getId() == application.getId()) {
                return true;
            }
        }
        return false;
    }

    public ResponseDTO sendNotificationForApplicants(String psswdNotification, int callId) {
        if (!INEAPermissionChecker.notificationsPsswd.equals(psswdNotification)) {
            throw new AppException("Wrong password");
        }
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        if (!permissionChecker.checkIfDashboardUser()) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }

        VoucherAssignmentAuxiliar voucherAssignment = voucherAssignmentAuxiliarRepository
                .findByCallIdAndStatusAux(callId, VoucherAssignmentStatus.FREEZE_LIST.getValue());

        if (voucherAssignment.getNotifiedDate() != null) {
            return new ResponseDTO(false, voucherAssignment, null);
        } else {
            AdminActions adminActions = adminActionsRepository.findOneByAction("voucher_send_notifications");
            if (adminActions != null && adminActions.isRunning()) {
                return new ResponseDTO(false, adminActions, null);
            }
        }

        // Let the task executor manage the execution of the new thread to send the mails
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Launched notification for applicants, starting thread...");
        taskExecutor.execute(context.getBean(SendNotificationsAsync.class, callId, userConnected));
        return new ResponseDTO(true, null, null);
    }

}