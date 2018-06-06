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
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.location.Lau;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.voucher.SimpleRegistration;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignmentAuxiliar;
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
        VoucherAssignmentAuxiliarDTO voucherAssignmentAuxiliarDTO = voucherAssignmentAuxiliarMapper.toDTO(voucherAssignmentAuxiliarRepository.findByCallIdAndStatusAux(callId, 1));
        if(voucherAssignmentAuxiliarDTO == null){
            throw new AppException("Voucher assigment not found for call id: " + callId);
        }

        VoucherAssignmentAuxiliarDTO voucherAssignmentPreList = voucherAssignmentAuxiliarMapper.toDTO(voucherAssignmentAuxiliarRepository.findByCallIdAndStatusAux(callId, 2));

        voucherAssignmentAuxiliarDTO.setHasPreListSaved(voucherAssignmentPreList != null);
        if(voucherAssignmentPreList != null){
            voucherAssignmentAuxiliarDTO.setPreListExecutionDate(voucherAssignmentPreList.getExecutionDate());
        }
        return voucherAssignmentAuxiliarDTO;
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

        if((municipality.equalsIgnoreCase("All") || municipality.isEmpty()) && (country.equalsIgnoreCase("All"))){
            simulationPaged = voucherSimulationRepository.findAllByVoucherAssignmentOrdered(voucherAssignmentId, pageable);
        }
        else if((!municipality.equalsIgnoreCase("All") && !municipality.isEmpty()) && (country.equalsIgnoreCase("All"))){
            simulationPaged = voucherSimulationRepository.findAllByVoucherAssignmentAndMunicipalityOrderedByEuRank(voucherAssignmentId, municipality, pageable);
        }
        else if((municipality.equalsIgnoreCase("All") || municipality.isEmpty()) && (!country.equalsIgnoreCase("All"))){
            simulationPaged = voucherSimulationRepository.findAllByVoucherAssignmentInCountryOrdered(voucherAssignmentId, country, pageable);
        }
        else if((!municipality.equalsIgnoreCase("All") && !municipality.isEmpty()) && (!country.equalsIgnoreCase("All"))){
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

    public List<VoucherSimulationDTO> getVoucherSimulationsByVoucherAssigmentId(int voucherAssignmentId){
        return voucherSimulationMapper.toDTOList(voucherSimulationRepository.findAllByVoucherAssignmentOrderByEuRank(voucherAssignmentId));
    }

    public boolean checkSavePreSelectionEnabled(int voucherAssignmentId){

        List<VoucherSimulationDTO> simulationList = getVoucherSimulationsByVoucherAssigmentId(voucherAssignmentId);

        for (VoucherSimulationDTO simulation: simulationList) {
            if(simulation.getNumApplications() > 1) {
                return false;
            }
            if(simulation.getApplication().getStatus() != 2){
                return false;
            }
        }
        return true;
    }

    @Transactional
    public List<VoucherSimulationDTO> savePreListSimulation(int voucherAssignmentId, int callId){
        if(checkSavePreSelectionEnabled(voucherAssignmentId)){

            VoucherAssignmentAuxiliarDTO auxiliarDTO = voucherAssignmentAuxiliarMapper.toDTO(voucherAssignmentAuxiliarRepository.findByCallIdAndStatusAux(callId, 1));
            if(auxiliarDTO == null){
              throw new AppException("Voucher assigment not found");
            }
            List<VoucherSimulationDTO> simulationList = getVoucherSimulationsByVoucherAssigmentId(auxiliarDTO.getId());

            VoucherAssignmentDTO voucherAssignment = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.findByCallIdAndStatusEquals(callId, 2));

            if(voucherAssignment != null){
                //voucherAssignmentRepository.delete(voucherAssignmentMapper.toEntity(voucherAssignment));
                throw new AppException("Existing Pre-selection list for callId: " + callId);
            }

            voucherAssignment = new VoucherAssignmentDTO();
            voucherAssignment.setCall(callService.getCallById(callId));
            voucherAssignment.setUser(userService.getUserByUserContext(UserHolder.getUser()));
            voucherAssignment.setExecutionDate(new Date().getTime());

            voucherAssignment.setStatus(2);

            Set<VoucherSimulationDTO> simulationsPreSave = new HashSet<>();

            VoucherAssignmentDTO result = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(voucherAssignment))) ;

            for (VoucherSimulationDTO voucherSimulation : simulationList) {
                VoucherSimulationDTO voucherSimulationDTO = new VoucherSimulationDTO();
                voucherSimulationDTO.setApplication(voucherSimulation.getApplication());
                voucherSimulationDTO.setCountry(voucherSimulation.getCountry());
                voucherSimulationDTO.setCountryRank(voucherSimulation.getCountryRank());
                voucherSimulationDTO.setEuRank(voucherSimulation.getEuRank());
                voucherSimulationDTO.setIssues(voucherSimulation.getIssues());
                voucherSimulationDTO.setLau(voucherSimulation.getLau());
                voucherSimulationDTO.setMunicipality(voucherSimulation.getMunicipality());
                voucherSimulationDTO.setMunicipalityName(voucherSimulation.getMunicipalityName());
                voucherSimulationDTO.setNumApplications(voucherSimulation.getNumApplications());
                voucherSimulationDTO.setSelectionStatus(voucherSimulation.getSelectionStatus());
                voucherSimulationDTO.setRejected(voucherSimulation.getRejected());
                voucherSimulationDTO.setVoucherAssignment(result.getId());
                simulationsPreSave.add(voucherSimulationDTO);
            }

            result.setVoucherSimulations(simulationsPreSave);

            result = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(result)));

            voucherSimulationRepository.updateApplicationsInVoucherSimulationByVoucherAssignment(1, result.getId());

            return getVoucherSimulationsByVoucherAssigmentId(result.getId());
        }else{
            throw new AppException("Error saving pre-selected list");
        }
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

            if(_log.isInfoEnabled()){
                _log.info("START - Assigning minimum vouchers");
            }

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
                        if(applicationDTO.getRejected()){
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
                    if (_log.isWarnEnabled()) {
                        _log.warn("Error assigning minimum of vouchers to country: " + e.getMessage());
                    }
                }
            }

            if(_log.isInfoEnabled()){
                _log.info("END - Assigning minimum vouchers");
                _log.info("START - Assigning maximum vouchers");
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
                    if(applicationDTO.getRejected()){
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

            if(_log.isInfoEnabled()){
                _log.info("END - Assigning maximum vouchers");
                _log.info("START - Filling reserve list");
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
                            if(application.getRejected()){
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

            if(_log.isInfoEnabled()){
                _log.info("END - Filling reserve list");
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

            for(ApplicationDTO rejectedApplication: rejectedApplications){
                SimpleRegistrationDTO registrationDTO = registrationsHashMap.get(rejectedApplication.getRegistrationId());
                SimpleMunicipalityDTO municipalityDTO = municipalityHashMap.get(registrationDTO.getMunicipalityId());

                int num = applicationService.countApplicationWithSameMunicipalityName(municipalityDTO.getLau(), call.getId(), dateNanoSeconds);

                VoucherSimulationDTO simulation = new VoucherSimulationDTO();
                simulation.setApplication(rejectedApplication);
                simulation.setCountry(municipalityDTO.getCountry());
                simulation.setVoucherAssignment(voucherAssignment.getId());
                simulation.setNumApplications(num);
                simulation.setMunicipality(municipalityDTO.getId());
                simulation.setIssues(registrationService.getIssues(registrationService.getRegistrationIssue(municipalityDTO.getLau())));
                simulation.setEuRank(Integer.MAX_VALUE);
                simulation.setSelectionStatus(2);
                simulation.setCountryRank(Integer.MAX_VALUE);
                simulations.add(simulation);
            }

            if(_log.isInfoEnabled()){
                _log.info("START - Saving simulation to database");
            }

            voucherAssignment.setVoucherSimulations(simulations);
            VoucherAssignmentDTO res = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(voucherAssignment)));

            if(_log.isInfoEnabled()){
                _log.info("END - Saving simulation to database");
            }

            return new ResponseDTO(true, res.getVoucherSimulations(), null);
        }
        return new ResponseDTO(false, "User not defined", null);
    }

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

                try {
                    SimpleLauDTO lauDTO = lausMap.get(municipalityDTO.getLau());


                    if (lauDTO.getCountry_code().equals(country)) {
                        appCountry.add(application);
                    }
                } catch (Exception ex){
                    _log.warn(ex.getMessage());
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