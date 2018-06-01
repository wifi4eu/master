package wifi4eu.wifi4eu.service.voucher;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.location.Lau;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.voucher.SimpleRegistration;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;
import wifi4eu.wifi4eu.mapper.voucher.VoucherAssignmentAuxiliarMapper;
import wifi4eu.wifi4eu.mapper.voucher.VoucherAssignmentMapper;
import wifi4eu.wifi4eu.mapper.voucher.VoucherSimulationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentAuxiliarRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.ExcelExportGenerator;
import wifi4eu.wifi4eu.util.VoucherSimulationExportGenerator;

import java.util.*;

@Service("portalVoucherService")
public class VoucherService {

    private Logger _log = LoggerFactory.getLogger(this.getClass());

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
    VoucherManagementService voucherManagementService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    VoucherSimulationRepository voucherSimulationRepository;

    @Autowired
    VoucherAssignmentRepository voucherAssignmentRepository;

    @Autowired
    VoucherAssignmentAuxiliarRepository voucherAssignmentAuxiliarRepository;

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
    LauService lauService;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    NutsService nutsService;

    public List<VoucherAssignmentDTO> getAllVoucherAssignment() {
        return voucherAssignmentMapper.toDTOList(Lists.newArrayList(voucherAssignmentRepository.findAll()));
    }

    public VoucherAssignmentDTO getVoucherAssignmentById(int voucherAssignmentId) {
        return voucherAssignmentMapper.toDTO(voucherAssignmentRepository.findOne(voucherAssignmentId));
    }

    public VoucherAssignmentDTO getVoucherAssignmentByCall(int callId) {
        return voucherAssignmentMapper.toDTO(voucherAssignmentRepository.findByCallId(callId));
    }

    public VoucherAssignmentAuxiliarDTO getVoucherAssignmentAuxiliarByCall(int callId) {
        return voucherAssignmentAuxiliarMapper.toDTO(voucherAssignmentAuxiliarRepository.findByCallIdAux(callId));
    }

    @Transactional
    public VoucherAssignmentDTO createVoucherAssignment(VoucherAssignmentDTO voucherAssignmentDTO) {
        VoucherAssignment voucherAssignment = voucherAssignmentRepository
                .save(voucherAssignmentMapper.toEntity(voucherAssignmentDTO));
        return voucherAssignmentMapper.toDTO(voucherAssignment);
    }

    public void updateVoucherAssignment() {

    }

    public ResponseDTO getVoucherSimulationByVoucherAssignment(int voucherAssignmentId, String country, String municipality, Pageable pageable) {
        Page<VoucherSimulation> simulationPaged = null;
        if (country.equals("All")) {
            simulationPaged = voucherSimulationRepository.findAllByVoucherAssignmentOrdered(voucherAssignmentId, pageable);
        }
        if(!municipality.equalsIgnoreCase("All")){
            simulationPaged = voucherSimulationRepository.findAllByVoucherAssignmentAndMunicipalityOrderedByEuRank(voucherAssignmentId, municipality, pageable);
        }

        if(!country.equalsIgnoreCase("All") && !municipality.equalsIgnoreCase("All")){
            simulationPaged = voucherSimulationRepository.findAllByVoucherAssignmentAndMunicipalityInCountryOrderedByEuRank(voucherAssignmentId, country, municipality, pageable);
        }

        List<VoucherSimulationDTO> listSimulation = voucherSimulationMapper.toDTOList(Lists.newArrayList(simulationPaged.getContent()));
        for (VoucherSimulationDTO voucherSimulation : listSimulation) {
            MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(voucherSimulation.getMunicipality());
            voucherSimulation.setMunicipalityName(municipalityDTO.getName());
            voucherSimulation.setLau(municipalityDTO.getLauId());
        }
        return new ResponseDTO(true, listSimulation, simulationPaged.getTotalElements(), null);
    }

    public byte[] exportVoucherSimulation(int voucherAssignmentId, String country, String municipalityName, Pageable pageable) {

        List<VoucherSimulationDTO> simulationDTOS = (List<VoucherSimulationDTO>) getVoucherSimulationByVoucherAssignment(voucherAssignmentId, country, municipalityName, pageable).getData();

        VoucherSimulationExportGenerator excelExportGenerator = new VoucherSimulationExportGenerator(simulationDTOS, VoucherSimulationDTO.class);
        return excelExportGenerator.exportExcelFile("voucher_simulation").toByteArray();
    }

    @Transactional
    public ResponseDTO simulateVoucherFast(int callId) {

        HashMap<Integer, SimpleMunicipalityDTO> municipalityHashMap = new HashMap<>();
        HashMap<Integer, SimpleLauDTO> lauHashMap = new HashMap<>();
        HashMap<Integer, SimpleRegistrationDTO> registrationsHashMap = new HashMap<>();

        UserContext userContext = UserHolder.getUser();

        if (userContext != null) {
            CallDTO call = callService.getCallById(callId);
            if (call == null) {
                return new ResponseDTO(false, "Call not exist", null);
            }

            if (call.getNumberVouchers() == 0) {
                return new ResponseDTO(false, "Simulation stopped", null);
            }

            UserDTO userDTO = userService.getUserByUserContext(userContext);

            /**
             * Counters of algorithm
             *
             */

            int callNr = call.getId();
            int vouchersToBeAssigned = call.getNumberVouchers();

            // String => Country_code == 'ES' OR 'DE', Integer => counter each country
            HashMap<String, Integer> countryMin = new HashMap<>();
            HashMap<String, Integer> countryMax = new HashMap<>();

            // Countries extracted from list of applications in FIFO order
            List<String> participatingCountries = new ArrayList<>();

           // List<ApplicationDTO> listOfApplications = applicationService.getApplicationsByCallFiFoOrder(call.getId());
            long dateNanoSeconds =  call.getStartDate() * 1000000;
            List<ApplicationDTO> listOfApplications = applicationService.findByCallIdOrderByDateBeforeCallDateAsc(call.getId(), dateNanoSeconds);

            Map<Integer, Integer> applicationsIndexes = new HashMap<>(listOfApplications.size());

            int index = 0;
            for (ApplicationDTO application : listOfApplications) {
                applicationsIndexes.put(application.getId(), index);
                index++;
            }

            List<SimpleMunicipalityDTO> municipalities = simpleMunicipalityService.getAllMunicipalities();
            List<SimpleLauDTO> laus = simpleLauService.getAllLausFromApplications();
            List<SimpleRegistrationDTO> registrations = simpleRegistrationService.findAll();

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

            //for (ApplicationDTO applicationDTO : listOfApplications) {

            //    RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
            //    if(registrationDTO != null){
            //registrationsHashMap.put(registrationDTO.getId(), registrationDTO);
            //MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());
            //municipalityHashMap.put(municipalityDTO.getId(), municipalityDTO);
            //LauDTO lauDTO = lauService.getLauById(municipalityDTO.getLauId());
            //lauHashMap.put(lauDTO.getId(), lauDTO);

            //if (!participatingCountries.contains(lauDTO.getCountryCode())) {
            //    participatingCountries.add(lauDTO.getCountryCode());
            //}
            //    } else {
            //        _log.info("Incorrect application " + applicationDTO.getId());
            //   }
            //}

            int nrParticipatingCountries = participatingCountries.size();
            if (participatingCountries.isEmpty()) {
                return new ResponseDTO(false, "Simulation stopped", null);
            }

            int numReserveList = call.getReserve();

            /* if(numReserveList == null){
              numReserveList = 0;
            } */

            /* List<ApplicationDTO> assignedVouchers = new ArrayList<>(); */

            // String => name municipality, Application of the municipality
            HashMap<Integer, ApplicationDTO> assignedVouchers = new HashMap<>();

            // String => Country_code == 'ES' OR 'DE', List of applications in reserved list of each country
            HashMap<String, List<ApplicationDTO>> countryReserveList = new HashMap<>();

            // String => Country_code == 'ES' OR 'DE', Integer => counter each country
            HashMap<String, Integer> countryCounter = new HashMap<>();
            HashMap<String, Integer> countryReserveListCounter = new HashMap<>();

            HashMap<String, List<MunicipalityDTO>> countryTest = new HashMap<>();

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
                    if (_log.isWarnEnabled()) {
                        _log.warn("Error assigning minimum of vouchers to country: " + e.getMessage());
                    }
                }
            }

            for (ApplicationDTO applicationDTO : new ArrayList<>(supportLOAlist)) {
                try {
                    if (totalAssignedVouchers >= vouchersToBeAssigned || supportLOAlist.size() == 0) {
                        break;
                    }

                    if (applicationDTO.getStatus() == 1) {
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
                                    countryReserveList.put(country, new ArrayList<ApplicationDTO>());
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
                    if (_log.isWarnEnabled()) {
                        _log.warn("Error assigning maximum of vouchers to country: " + e.getMessage());
                    }
                }
            }

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
                        List<ApplicationDTO> applicationsCountry = getFirtsApplicationCountry(registrationsHashMap, lauHashMap, municipalityHashMap,
                                supportLOAlist, country);

                        for (ApplicationDTO application : applicationsCountry) {

                            if (application.getStatus() == 1) {
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

                                //                            if (countryReserveListCounter.get(country) == countryCounter.get(country)) {
                                //                                continue;
                                //                            }

                                removeFromLOA(supportLOAlist, application);
                            }
                        }
                    } catch (Exception e) {
                        if (_log.isWarnEnabled()) {
                            _log.warn("Error assigning reserve of vouchers to country: " + e.getMessage());
                        }
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

            VoucherAssignmentDTO voucherAssignment = getVoucherAssignmentByCall(call.getId());

            if (voucherAssignment == null) {
                voucherAssignment = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(assignmentDTO)));
            }
            else{
                voucherSimulationRepository.deleteVoucherSimulationByVoucherAssignment(voucherAssignment.getId());

                voucherAssignment.setCall(call);
                voucherAssignment.setUser(userDTO);
                voucherAssignment.setVoucherSimulations(null);
                voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(voucherAssignment));
            }



            for (ApplicationDTO applicationAssigned : mainListOutput) {

                SimpleRegistrationDTO registrationDTO = registrationsHashMap.get(applicationAssigned.getRegistrationId());
                SimpleMunicipalityDTO municipalityDTO = municipalityHashMap.get(registrationDTO.getMunicipalityId());

                int num = applicationService.countApplicationWithSameMunicipalityName(municipalityDTO.getLau(), call.getId(), dateNanoSeconds);

                List<Integer> listOfIds = applicationService.getApplicationsIdByCountryAndNameAndCall(call.getId(), municipalityDTO.getCountry(), dateNanoSeconds);

                VoucherSimulationDTO simulation = new VoucherSimulationDTO();
                simulation.setCountry(municipalityDTO.getCountry());
                simulation.setApplication(applicationAssigned);
                simulation.setVoucherAssignment(voucherAssignment.getId());
                simulation.setNumApplications(num);
                simulation.setMunicipality(municipalityDTO.getId());
                simulation.setIssues(registrationService.getIssues(registrationService.getRegistrationIssue(municipalityDTO.getLau())));
                simulation.setEuRank(applicationsIndexes.get(applicationAssigned.getId()) + 1);
                simulation.setSelectionStatus(0);
                simulation.setCountryRank(listOfIds.indexOf(applicationAssigned.getId()) + 1);
                simulations.add(simulation);
            }

            for (ApplicationDTO reservedApplication : reserveListCompleted) {
                SimpleRegistrationDTO registrationDTO = registrationsHashMap.get(reservedApplication.getRegistrationId());
                SimpleMunicipalityDTO municipalityDTO = municipalityHashMap.get(registrationDTO.getMunicipalityId());

                int num = applicationService.countApplicationWithSameMunicipalityName(municipalityDTO.getLau(), call.getId(), dateNanoSeconds);

                List<Integer> listOfIds = applicationService.getApplicationsIdByCountryAndNameAndCall(call.getId(), municipalityDTO.getCountry(), dateNanoSeconds);

                VoucherSimulationDTO simulation = new VoucherSimulationDTO();
                simulation.setApplication(reservedApplication);
                simulation.setCountry(municipalityDTO.getCountry());
                simulation.setVoucherAssignment(voucherAssignment.getId());
                simulation.setNumApplications(num);
                simulation.setMunicipality(municipalityDTO.getId());
                simulation.setIssues(registrationService.getIssues(registrationService.getRegistrationIssue(municipalityDTO.getLau())));
                simulation.setEuRank(applicationsIndexes.get(reservedApplication.getId()) + 1);
                simulation.setSelectionStatus(1);
                simulation.setCountryRank(listOfIds.indexOf(reservedApplication.getId()) + 1);
                simulations.add(simulation);
            }

            voucherAssignment.setVoucherSimulations(simulations);
            VoucherAssignmentDTO res = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(voucherAssignment)));

            return new ResponseDTO(true, res.getVoucherSimulations(), null);
        }
        return new ResponseDTO(false, "User not defined", null);
    }


    /*@Transactional*/
    /*public ResponseDTO simulateVoucherAssignment(int callId) {
        UserContext userContext = UserHolder.getUser();

        if (userContext != null) {
            CallDTO call = callService.getCallById(callId);
            if (call == null) {
                return new ResponseDTO(false, "Call not exist", null);
            }

            if (call.getNumberVouchers() == 0) {
                return new ResponseDTO(false, "Simulation stopped", null);
            }

            UserDTO userDTO = userService.getUserByUserContext(userContext);

            */

    /**
     * Counters of algorithm
     *//*

            int callNr = call.getId();
            int vouchersToBeAssigned = call.getNumberVouchers();

            // String => Country_code == 'ES' OR 'DE', Integer => counter each country
            HashMap<String, Integer> countryMin = new HashMap<>();
            HashMap<String, Integer> countryMax = new HashMap<>();

            // Countries extracted from list of applications in FIFO order
            List<String> participatingCountries = new ArrayList<>();

            Map<ApplicationDTO> listOfApplications = applicationService.getApplicationsByCallFiFoOrder(call.getId());

            for (ApplicationDTO applicationDTO : listOfApplications) {
                RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
                MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());
                LauDTO lauDTO = lauService.getLauById(municipalityDTO.getLauId());
                if (!participatingCountries.contains(lauDTO.getCountryCode())) {
                    participatingCountries.add(lauDTO.getCountryCode());
                }
            }

            int nrParticipatingCountries = participatingCountries.size();
            if (participatingCountries.isEmpty()) {
                return new ResponseDTO(false, "Simulation stopped", null);
            }

            int numReserveList = call.getReserve();

            *//* if(numReserveList == null){
              numReserveList = 0;
            } *//*

     *//* List<ApplicationDTO> assignedVouchers = new ArrayList<>(); *//*

            // String => name municipality, Application of the municipality
            HashMap<Integer, ApplicationDTO> assignedVouchers = new HashMap<>();

            // String => Country_code == 'ES' OR 'DE', List of applications in reserved list of each country
            HashMap<String, List<ApplicationDTO>> countryReserveList = new HashMap<>();

            // String => Country_code == 'ES' OR 'DE', Integer => counter each country
            HashMap<String, Integer> countryCounter = new HashMap<>();
            HashMap<String, Integer> countryReserveListCounter = new HashMap<>();

            HashMap<String, List<MunicipalityDTO>> countryTest = new HashMap<>();

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
                country = country.toUpperCase().trim();
                countryCounter.put(country, 0);
            }

            // List of applications cloned to use in the algorithm
            List<ApplicationDTO> supportLOAlist = new ArrayList<>(listOfApplications);

            for (String country : participatingCountries) {

                try {

                    if (country.equalsIgnoreCase("no")) {
                        country = country.toUpperCase();
                    }

                    //GET Applications for each country
                    List<ApplicationDTO> applicationsCountry = applicationService.getApplicationByCallAndCountry(callId, country);

                    for (ApplicationDTO applicationDTO : applicationsCountry) {

                        if (applicationDTO.getStatus() == 1) {
                            removeFromLOA(supportLOAlist, applicationDTO);
                            continue;
                        }

                        if (countryCounter.get(country) >= countryMin.get(country)) {
                            //removeFromLOA(supportLOAlist, applicationDTO);
                            break;
                        }

                        RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
                        MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());

                        //Check if municipality with the same name have been assigned, if assigned then delete else continue
                        if (assignedVouchers.containsKey(municipalityDTO.getLauId())) {
                            removeFromLOA(supportLOAlist, applicationDTO);
                            continue;
                        }
                        List<MunicipalityDTO> lis = countryTest.get(country);
                        lis.add(municipalityDTO);
                        assignedVouchers.put(municipalityDTO.getLauId(), applicationDTO);
                        countryTest.put(country, lis);
                        countryCounter.put(country, countryCounter.get(country) + 1);
                        totalAssignedVouchers += 1;
                        removeFromLOA(supportLOAlist, applicationDTO);
                    }
                } catch (Exception e) {
                    if(_log.isErrorEnabled()){
                        _log.error("Error assigning minimum of vouchers to country", e);
                    }
                }
            }

            for (ApplicationDTO applicationDTO : new ArrayList<>(supportLOAlist)) {
                try {
                    if (totalAssignedVouchers >= vouchersToBeAssigned || supportLOAlist.size() == 0) {
                        break;
                    }

                    if (applicationDTO.getStatus() == 1) {
                        removeFromLOA(supportLOAlist, applicationDTO);
                        continue;
                    }

                    RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
                    MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());
                    LauDTO lauDTO = lauService.getLauById(municipalityDTO.getLauId());

                    String country = lauDTO.getCountryCode();
                    country = country.trim();
                    if (country.equalsIgnoreCase("no")) {
                        country = country.toUpperCase();
                    }

                    if (assignedVouchers.containsKey(municipalityDTO.getLauId())) {
                        removeFromLOA(supportLOAlist, applicationDTO);
                        continue;
                    }

                    if (countryCounter.get(country) >= countryMax.get(country)) {
                        int numReserveCountry = countryReserveListCounter.get(country);

                        if (numReserveCountry < numReserveList) {
                            if (countryReserveList.get(country) == null) {
                                countryReserveList.put(country, new ArrayList<ApplicationDTO>());
                            }
                            List<ApplicationDTO> countryApps = new ArrayList<>(countryReserveList.get(country));
                            countryApps.add(applicationDTO);
                            countryReserveList.put(country, countryApps);
                            countryReserveListCounter.put(lauDTO.getCountryCode(), countryReserveListCounter.get(country) + 1);
                        }
                        removeFromLOA(supportLOAlist, applicationDTO);
                        continue;
                    }
                    assignedVouchers.put(municipalityDTO.getLauId(), applicationDTO);
                    List<MunicipalityDTO> lis = countryTest.get(country);
                    lis.add(municipalityDTO);
                    countryTest.put(country, lis);
                    countryCounter.put(lauDTO.getCountryCode(), countryCounter.get(lauDTO.getCountryCode()) + 1);
                    totalAssignedVouchers += 1;
                    removeFromLOA(supportLOAlist, applicationDTO);
                } catch (Exception e) {
                    if(_log.isErrorEnabled()){
                        _log.error("Error assigning maximum of vouchers to country", e);
                    }
                }
            }

            if (!supportLOAlist.isEmpty()) {
                for (String country : participatingCountries) {
                    country = country.trim();
                    if (country.equalsIgnoreCase("no")) {
                        country = country.toUpperCase();
                    }

                    if (countryReserveListCounter.get(country) >= numReserveList) {
                        continue;
                    }

                    try{
                        List<ApplicationDTO> applicationsCountry = new ArrayList<>();

                        for (ApplicationDTO application : applicationsCountry) {

                            if (application.getStatus() == 1) {
                                removeFromLOA(supportLOAlist, application);
                                continue;
                            }

                            RegistrationDTO registrationDTO = registrationService.getRegistrationById(application.getRegistrationId());
                            MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());

                            List<ApplicationDTO> countryApps = countryReserveList.get(country);

                            if(countryApps == null){
                                countryApps = new ArrayList<>();
                            }

                            if (assignedVouchers.containsKey(municipalityDTO.getLauId()) || checkIfApplicationExists(countryApps, application)) {
                                removeFromLOA(supportLOAlist, application);
                                continue;
                            }

                            if (countryReserveListCounter.get(country) >= numReserveList) {
                                break;
                            }

                            countryApps.add(application);
                            countryReserveList.put(country, countryApps);
                            countryReserveListCounter.put(country, countryReserveListCounter.get(country) + 1);

//                            if (countryReserveListCounter.get(country) == countryCounter.get(country)) {
//                                continue;
//                            }

                            removeFromLOA(supportLOAlist, application);
                        }
                    }
                    catch (Exception e){
                        if(_log.isErrorEnabled()){
                            _log.error("Error assigning reserve of vouchers to country", e);
                        }
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

            VoucherAssignmentDTO voucherAssignment = getVoucherAssignmentByCall(call.getId());

            if (voucherAssignment == null) {
                voucherAssignment = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(assignmentDTO)));
            }

            int i = 1;
            int countryIt = 0;
            for (ApplicationDTO applicationAssigned : mainListOutput) {

                RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationAssigned.getRegistrationId());
                MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());

                if(municipalityDTO.getCountry().equalsIgnoreCase("ITALIA") || municipalityDTO.getCountry().equalsIgnoreCase("ITALIA ")){
                    System.out.println("Italy municipality name" + municipalityDTO.getName());
                }

                int num = applicationService.countApplicationWithSameMunicipalityName(municipalityDTO.getLauId(), call.getId());

                List<ApplicationDTO> applicationDTOS2 = applicationService.getApplicationsCountryNameCall(call.getId(), municipalityDTO.getCountry());

                VoucherSimulationDTO simulation = new VoucherSimulationDTO();
                simulation.setCountry(municipalityDTO.getCountry());
                simulation.setApplication(applicationAssigned);
                simulation.setVoucherAssignment(voucherAssignment.getId());
                simulation.setNumApplications(num);
                simulation.setMunicipality(municipalityDTO.getId());
                simulation.setIssues(1);
                simulation.setEuRank(positionInApplicationList(listOfApplications, applicationAssigned) + 1);
                simulation.setSelectionStatus(0);
                simulation.setCountryRank(getPositionInCountry(applicationDTOS2, applicationAssigned) + 1);
                simulations.add(simulation);
                i++;
            }

            for (ApplicationDTO reservedApplication : reserveListCompleted) {
                RegistrationDTO registrationDTO = registrationService.getRegistrationById(reservedApplication.getRegistrationId());
                MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());

                int num = applicationService.countApplicationWithSameMunicipalityName(municipalityDTO.getLauId(), call.getId());

                List<ApplicationDTO> applicationDTOS2 = applicationService.getApplicationsCountryNameCall(call.getId(), municipalityDTO.getCountry());

                VoucherSimulationDTO simulation = new VoucherSimulationDTO();
                simulation.setApplication(reservedApplication);
                simulation.setCountry(municipalityDTO.getCountry());
                simulation.setVoucherAssignment(voucherAssignment.getId());
                simulation.setNumApplications(num);
                simulation.setMunicipality(municipalityDTO.getId());
                simulation.setIssues(1);
                simulation.setEuRank(positionInApplicationList(listOfApplications, reservedApplication) + 1);
                simulation.setSelectionStatus(1);
                simulation.setCountryRank(getPositionInCountry(applicationDTOS2, reservedApplication) + 1);
                simulations.add(simulation);
                i++;
            }

            voucherAssignment.setVoucherSimulations(simulations);
            VoucherAssignmentDTO res = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(voucherAssignment)));

            return new ResponseDTO(true, res.getVoucherSimulations(), null);
        }
        return new ResponseDTO(false, "User not defined", null);
    }*/
    public Integer positionInApplicationList(List<ApplicationDTO> applicationsInput, ApplicationDTO applicationInput) {
        int index = 0;
        for (ApplicationDTO application : applicationsInput) {
            if (application.getId() == applicationInput.getId()) {
                return index;
            }
            index++;
        }

        return -1;


    }

    public List<ApplicationDTO> getFirtsApplicationCountry(HashMap<Integer, SimpleRegistrationDTO> registrationsMap,
                                                           HashMap<Integer, SimpleLauDTO> lausMap,
                                                           HashMap<Integer, SimpleMunicipalityDTO> municipalitiesMap,
                                                           List<ApplicationDTO> apps, String country) {
        List<ApplicationDTO> appCountry = new ArrayList<>();
        for (ApplicationDTO application : apps) {
            SimpleRegistrationDTO registrationDTO = registrationsMap.get(application.getRegistrationId());
            if (registrationDTO != null) {
                SimpleMunicipalityDTO municipalityDTO = municipalitiesMap.get(registrationDTO.getMunicipalityId());
                SimpleLauDTO lauDTO = lausMap.get(municipalityDTO.getLau());

                if (lauDTO.getCountry_code().equals(country)) {
                    appCountry.add(application);
                }
            }
        }
        return appCountry;
    }

    public int getPositionInCountry(List<Integer> applicationsCountry, Integer application) {
        int index = applicationsCountry.indexOf(application);
        /*for (Integer applicationCountry : applicationsCountry) {
            if (applicationCountry == application) {
                return index;
            }
            index++;
        }*/
        return index;
    }

    public boolean checkApplicationIsValid(ApplicationDTO applicationDTO) {
        if (applicationDTO.getStatus() == 3) {
            return false;
        }
        return true;
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

}