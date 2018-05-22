package wifi4eu.wifi4eu.service.voucher;

import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.location.Lau;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;
import wifi4eu.wifi4eu.entity.voucherManagement.VoucherManagement;
import wifi4eu.wifi4eu.mapper.voucher.VoucherAssignmentMapper;
import wifi4eu.wifi4eu.mapper.voucher.VoucherSimulationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.voucher.util.VoucherAssignmentUtil;

import java.util.*;

@Service("portalVoucherService")
public class VoucherService {
    @Autowired
    VoucherAssignmentMapper voucherAssignmentMapper;

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
    RegistrationService registrationService;

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

    @Transactional
    public VoucherAssignmentDTO createVoucherAssignment(VoucherAssignmentDTO voucherAssignmentDTO) {
        VoucherAssignment voucherAssignment = voucherAssignmentRepository
                .save(voucherAssignmentMapper.toEntity(voucherAssignmentDTO));
        return voucherAssignmentMapper.toDTO(voucherAssignment);
    }

    public void updateVoucherAssignment() {

    }

    public ResponseDTO getVoucherSimulationByVoucherAssignment(int voucherAssignmentId, String country, Pageable pageable) {
        Page<VoucherSimulation> simulationPaged;
        if (country.equals("All")) {
            simulationPaged = voucherSimulationRepository.findAllByVoucherAssignmentOrdered(voucherAssignmentId, pageable);
        } else {
            simulationPaged = voucherSimulationRepository.findAllByVoucherAssignmentInCountryOrdered(voucherAssignmentId, country, pageable);
        }
        List<VoucherSimulationDTO> listSimulation = voucherSimulationMapper.toDTOList(Lists.newArrayList(simulationPaged.getContent()));
        return new ResponseDTO(true, listSimulation, simulationPaged.getTotalElements(), null);
    }

    /*@Transactional*/
    public ResponseDTO simulateVoucherAssignment(int callId) {
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

            List<ApplicationDTO> listOfApplications = applicationService.getApplicationsByCallFiFoOrder(call.getId());

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

            /* if(numReserveList == null){
              numReserveList = 0;
            } */

            /* List<ApplicationDTO> assignedVouchers = new ArrayList<>(); */

            // String => name municipality, Application of the municipality
            HashMap<String, ApplicationDTO> assignedVouchers = new HashMap<>();

            // String => Country_code == 'ES' OR 'DE', List of applications in reserved list of each country
            HashMap<String, List<ApplicationDTO>> countryReserveList = new HashMap<>();

            // String => Country_code == 'ES' OR 'DE', Integer => counter each country
            HashMap<String, Integer> countryCounter = new HashMap<>();
            HashMap<String, Integer> countryReserveListCounter = new HashMap<>();

            int totalAssignedVouchers = 0;

            // Fill maximums and minimums for each country
            List<VoucherManagementDTO> voucherManagements = voucherManagementService.getVoucherManagementByCall(call.getId());

            for (VoucherManagementDTO voucherManagement : voucherManagements) {
                if (voucherManagement.getMaximum() == 0 || voucherManagement.getMinimum() == 0) {
                    return new ResponseDTO(false, "Simulation stopped", null);
                }
                countryReserveListCounter.put(voucherManagement.getCountryCode().toUpperCase(), 0);
                countryMax.put(voucherManagement.getCountryCode().toUpperCase(), voucherManagement.getMaximum());
                countryMin.put(voucherManagement.getCountryCode().toUpperCase(), voucherManagement.getMinimum());
            }

            for (String country : participatingCountries) {
                country = country.toUpperCase();
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
                        if (assignedVouchers.containsKey(municipalityDTO.getName())) {
                            removeFromLOA(supportLOAlist, applicationDTO);
                            continue;
                        }
                        assignedVouchers.put(municipalityDTO.getName(), applicationDTO);
                        countryCounter.put(country, countryCounter.get(country) + 1);
                        totalAssignedVouchers += 1;
                        removeFromLOA(supportLOAlist, applicationDTO);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            int y = 0;
            for (ApplicationDTO applicationDTO : listOfApplications) {

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
                    if (country.equalsIgnoreCase("no")) {
                        country = country.toUpperCase();
                    }

                    if (assignedVouchers.containsKey(municipalityDTO.getName())) {
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

                    assignedVouchers.put(municipalityDTO.getName(), applicationDTO);
                    countryCounter.put(lauDTO.getCountryCode(), countryCounter.get(lauDTO.getCountryCode()) + 1);
                    totalAssignedVouchers += 1;
                    removeFromLOA(supportLOAlist, applicationDTO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (!supportLOAlist.isEmpty()) {

                for (String country : participatingCountries) {
                    if (country.equalsIgnoreCase("no")) {
                        country = country.toUpperCase();
                    }

                    if (countryReserveListCounter.get(country) < numReserveList) {
                        break;
                    }

                    List<ApplicationDTO> applicationsCountry = getFirtsApplicationCountry(supportLOAlist, country);

                    for (ApplicationDTO application : applicationsCountry) {

                        if (!checkApplicationIsValid(application)) {
                            removeFromLOA(supportLOAlist, application);
                            continue;
                        }

                        RegistrationDTO registrationDTO = registrationService.getRegistrationById(application.getRegistrationId());
                        MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());

                        /**
                         * Check if the municipality of this applicant
                         * is already in the list AssignedVouchers or in the Country_ReserveList
                         */

                        List<ApplicationDTO> countryApps = countryReserveList.get(country);

                        if (assignedVouchers.containsKey(municipalityDTO.getName()) || checkIfApplicationExists(countryApps, application)) {
                            removeFromLOA(supportLOAlist, application);
                            continue;
                        }

                        countryApps.add(application);
                        countryReserveList.put(country, countryApps);

                        /* countryReserveList.add(application); */
                        countryReserveListCounter.put(country, countryReserveListCounter.get(country) + 1);

                        /**
                         * Check if the number of assigned vouchers to this country
                         * reserve list is equal to the Country_ReserveList_Counter
                         */

                        if (countryReserveListCounter.get(country) == countryCounter.get(country)) {
                            continue;
                        }

                        removeFromLOA(supportLOAlist, application);
                    }
                }
            }

            List<List<ApplicationDTO>> generalOutput = new ArrayList<>();
            List<ApplicationDTO> mainListOutput = new ArrayList<>(assignedVouchers.values());
            Set<VoucherSimulationDTO> simulations = new HashSet<>();

            List<ApplicationDTO> reserveListCompleted = new ArrayList<>();

            for (List<ApplicationDTO> applications : countryReserveList.values()) {
                for (ApplicationDTO applicationDTO : applications) {
                    reserveListCompleted.add(applicationDTO);
                }
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
            for (ApplicationDTO applicationAssigned : mainListOutput) {

                RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationAssigned.getRegistrationId());
                MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());

                int num = applicationService.countApplicationWithSameMunicipalityName(municipalityDTO.getLauId(), call.getId());

                List<ApplicationDTO> applicationDTOS2 = applicationService.getApplicationsCountryNameCall(call.getId(), municipalityDTO.getCountry());

                VoucherSimulationDTO simulation = new VoucherSimulationDTO();
                simulation.setCountry(municipalityDTO.getCountry());
                simulation.setApplication(applicationAssigned);
                simulation.setVoucherAssignment(voucherAssignment.getId());
                simulation.setNumApplications(num);
                simulation.setMunicipality(municipalityDTO);
                simulation.setIssues(1);
                simulation.setEuRank(i);
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
                simulation.setMunicipality(municipalityDTO);
                simulation.setIssues(1);
                simulation.setEuRank(i);
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
    }

    public List<ApplicationDTO> getFirtsApplicationCountry(List<ApplicationDTO> apps, String country) {
        List<ApplicationDTO> appCountry = new ArrayList<>();
        for (ApplicationDTO application : apps) {
            RegistrationDTO registrationDTO = registrationService.getRegistrationById(application.getRegistrationId());
            MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());
            LauDTO lauDTO = lauService.getLauById(municipalityDTO.getLauId());

            if (lauDTO.getCountryCode().equals(country)) {
                appCountry.add(application);
            }
        }
        return appCountry;
    }

    public int getPositionInCountry(List<ApplicationDTO> applicationsCountry, ApplicationDTO application) {
        int index = 0;
        for (ApplicationDTO applicationCountry : applicationsCountry) {
            if (applicationCountry.getId() == application.getId()) {
                return index;
            }
            index++;
        }
        return -1;
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