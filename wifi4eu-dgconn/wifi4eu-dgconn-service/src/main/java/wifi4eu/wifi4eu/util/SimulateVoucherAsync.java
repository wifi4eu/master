package wifi4eu.wifi4eu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.enums.SelectionStatus;
import wifi4eu.wifi4eu.common.enums.VoucherAssignmentStatus;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.common.mapper.user.UserMapper;
import wifi4eu.wifi4eu.common.mapper.voucher.VoucherAssignmentMapper;
import wifi4eu.wifi4eu.entity.admin.AdminActions;
import wifi4eu.wifi4eu.repository.admin.AdminActionsRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.voucher.SimpleLauService;
import wifi4eu.wifi4eu.service.voucher.SimpleMunicipalityService;
import wifi4eu.wifi4eu.service.voucher.SimpleRegistrationService;
import wifi4eu.wifi4eu.service.voucher.VoucherManagementService;
import wifi4eu.wifi4eu.service.voucher.VoucherService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Scope("prototype")
public class SimulateVoucherAsync implements Runnable {
    @Autowired
    private VoucherAssignmentMapper voucherAssignmentMapper;

    @Autowired
    private CallService callService;

    @Autowired
    private VoucherManagementService voucherManagementService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private VoucherSimulationRepository voucherSimulationRepository;

    @Autowired
    private VoucherAssignmentRepository voucherAssignmentRepository;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private SimpleMunicipalityService simpleMunicipalityService;

    @Autowired
    private SimpleLauService simpleLauService;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private AdminActionsRepository adminActionsRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private SimpleRegistrationService simpleRegistrationService;

    private static final Logger _log = LoggerFactory.getLogger(SimulateVoucherAsync.class);

    private UserDTO userConnected;

    private Integer callId;

    public SimulateVoucherAsync(Integer callId, UserDTO userConnected) {
        this.userConnected = userConnected;
        this.callId = callId;
    }

    @Override
    public void run() {
        AdminActions adminActions = adminActionsRepository.findOneByAction("voucher_simulation");
        try {

            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Executing voucher simulation for call: " + callId);
            HashMap<Integer, SimpleMunicipalityDTO> municipalityHashMap = new HashMap<>();
            HashMap<Integer, SimpleLauDTO> lauHashMap = new HashMap<>();
            HashMap<Integer, SimpleRegistrationDTO> registrationsHashMap = new HashMap<>();
            HashMap<Integer, VoucherSimulationDTO> voucherSimulationDTOHashMap = new HashMap<>();

            if (userConnected != null) {
                CallDTO call = callService.getCallById(callId);
                if (call == null) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Call not exist");
                    throw new AppException("Call not exist");
                }

                if (call.getNumberVouchers() == 0) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Simulation stopped due to number of vouchers to be assigned");
                    adminActions = adminActionsRepository.findOneByAction("Voucher Simulation");
                    throw new AppException("Simulation stopped");
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
                VoucherAssignmentDTO voucherAssignment = voucherService.getVoucherAssignmentByCall(call.getId());
                boolean hasPreList = voucherService.getVoucherAssignmentByCallAndStatus(callId, VoucherAssignmentStatus.PRE_LIST.getValue()) != null;

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
                    throw new AppException("Simulation stopped");
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
                        throw new AppException("Simulation stopped");
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
                                voucherService.removeFromLOA(supportLOAlist, applicationDTO);
                                continue;
                            }
                            if (applicationDTO.getRejected() && hasPreList) {
                                rejectedApplications.add(applicationDTO);
                                voucherService.removeFromLOA(supportLOAlist, applicationDTO);
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
                                    voucherService.removeFromLOA(supportLOAlist, applicationDTO);
                                    continue;
                                }
                                assignedVouchers.put(municipalityDTO.getLau(), applicationDTO);
                                countryCounter.put(country, countryCounter.get(country) + 1);
                                totalAssignedVouchers += 1;
                                voucherService.removeFromLOA(supportLOAlist, applicationDTO);
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
                            voucherService.removeFromLOA(supportLOAlist, applicationDTO);
                            continue;
                        }
                        if (applicationDTO.getRejected() && hasPreList) {
                            rejectedApplications.add(applicationDTO);
                            voucherService.removeFromLOA(supportLOAlist, applicationDTO);
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
                                voucherService.removeFromLOA(supportLOAlist, applicationDTO);
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
                                voucherService.removeFromLOA(supportLOAlist, applicationDTO);
                                continue;
                            }
                            assignedVouchers.put(municipalityDTO.getLau(), applicationDTO);
                            countryCounter.put(lauDTO.getCountry_code(), countryCounter.get(lauDTO.getCountry_code()) + 1);
                            totalAssignedVouchers += 1;
                            voucherService.removeFromLOA(supportLOAlist, applicationDTO);
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

                        if (countryReserveListCounter.get(country) >= numReserveList) {
                            continue;
                        }

                        try {
                            List<ApplicationDTO> applicationsCountry = voucherService.getFirtsApplicationCountry(registrationsHashMap, lauHashMap, municipalityHashMap,
                                    supportLOAlist, country);

                            for (ApplicationDTO application : applicationsCountry) {

                                if (application.getStatus() == 1) {
                                    voucherService.removeFromLOA(supportLOAlist, application);
                                    continue;
                                }
                                if (application.getRejected() && hasPreList) {
                                    rejectedApplications.add(application);
                                    voucherService.removeFromLOA(supportLOAlist, application);
                                    continue;
                                }


                                SimpleRegistrationDTO registrationDTO = registrationsHashMap.get(application.getRegistrationId());

                                if (registrationDTO != null) {
                                    SimpleMunicipalityDTO municipalityDTO = municipalityHashMap.get(registrationDTO.getMunicipalityId());

                                    List<ApplicationDTO> countryApps = countryReserveList.get(country);

                                    if (countryApps == null) {
                                        countryApps = new ArrayList<>();
                                    }

                                    if (assignedVouchers.containsKey(municipalityDTO.getLau()) || voucherService.checkIfApplicationExists(countryApps, application)) {
                                        voucherService.removeFromLOA(supportLOAlist, application);
                                        continue;
                                    }

                                    if (countryReserveListCounter.get(country) >= numReserveList) {
                                        break;
                                    }

                                    countryApps.add(application);
                                    countryReserveList.put(country, countryApps);
                                    countryReserveListCounter.put(country, countryReserveListCounter.get(country) + 1);

                                    voucherService.removeFromLOA(supportLOAlist, application);
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
                voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(voucherAssignment)));
                _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Voucher simulation successfully executed");
                adminActions.setRunning(false);
                adminActions.setEndDate(new Date());
                adminActionsRepository.save(adminActions);
                //update db row to set the admin management task to 0

            } else {
                throw new AppException("User is not defined");
            }
        } catch (Exception ex) {
            if (Validator.isNotNull(adminActions)) {
                adminActions.setAction("voucher_simulation");
                adminActions.setRunning(false);
                adminActions.setUser(userMapper.toEntity(userConnected));
                adminActionsRepository.save(adminActions);
            }
            _log.error("It seems that Spring context is not available", ex.getMessage());
        }
    }
}

