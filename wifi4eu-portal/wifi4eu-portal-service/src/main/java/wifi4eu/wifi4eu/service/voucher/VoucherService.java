package wifi4eu.wifi4eu.service.voucher;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.mapper.voucher.VoucherAssignmentMapper;
import wifi4eu.wifi4eu.mapper.voucher.VoucherSimulationMapper;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;

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
    public VoucherAssignmentDTO createVoucherAssignment(VoucherAssignmentDTO voucherAssignmentDTO){
        VoucherAssignment voucherAssignment = voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(voucherAssignmentDTO));
        return voucherAssignmentMapper.toDTO(voucherAssignment);
    }

    public void updateVoucherAssignment(){

    }

    public List<VoucherSimulationDTO> getVoucherSimulationByVoucherAssignment(int voucherAssignmentId) {
        return voucherSimulationMapper.toDTOList(Lists.newArrayList(voucherSimulationRepository.findAllByVoucherAssignment(voucherAssignmentId)));
    }

    @Transactional
    public void simulateVoucherAssignment(CallDTO callDTO){
        UserContext userContext = UserHolder.getUser();

        if(userContext != null){
            CallDTO existCall = callService.getCallById(callDTO.getId());
            if(existCall != null){
                UserDTO userDTO = userService.getUserByUserContext(userContext);

                HashMap<String, Integer> countryMaximumVouchersToBeAssigned = new HashMap<>();
                HashMap<String, Integer> countryMininimumVouchersToBeAssigned = new HashMap<>();
                HashMap<String, Integer> countryAssignedVouchers = new HashMap<>();
                Integer totalAssignedVouchers = 0;
                List<VoucherManagementDTO> voucherManagements = voucherManagementService.getVoucherManagementByCall(callDTO.getId());
                int vouchersToBeAssigned = callDTO.getBudget() / callDTO.getBudgetVoucher();

                VoucherAssignmentDTO assignmentDTO = new VoucherAssignmentDTO();
                assignmentDTO.setCall(callDTO);
                assignmentDTO.setStatus(1);
                assignmentDTO.setExecutionDate(new Date().getTime());
                assignmentDTO.setUser(userDTO);

                VoucherAssignmentDTO voucherAssignment = getVoucherAssignmentByCall(callDTO.getId());

                if(voucherAssignment == null){
                    voucherAssignment = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(assignmentDTO)));
                }

                boolean maximumMinimum = true;

                for (VoucherManagementDTO voucherManagement: voucherManagements) {
                    if(voucherManagement.getMaximum() == 0 || voucherManagement.getMinimum() == 0){
                        maximumMinimum = false;
                        break;
                    }
                    countryMaximumVouchersToBeAssigned.put(voucherManagement.getMember_state().toUpperCase(), voucherManagement.getMaximum());
                    countryMininimumVouchersToBeAssigned.put(voucherManagement.getMember_state().toUpperCase(), voucherManagement.getMinimum());
                    countryAssignedVouchers.put(voucherManagement.getMember_state().toUpperCase(), 0);
                }
                if(!maximumMinimum){
                    //return "error";
                }

                //FIFO Applications by call
                List<ApplicationDTO> applicationDTOList = applicationService.getApplicationsByCall(callDTO.getId());

                //GET COUNTRIES
                List<NutsDTO> nutsDTOList = nutsService.getNutsByLevel(0);

                //HashMap for store municipalities assigned
                HashMap<String, MunicipalityDTO> listOfMunicipalitiesForWhichVoucherisAssigned = new HashMap<>();
                for (NutsDTO nutsDTO: nutsDTOList) {
                    //GET Applications for each country
                    List<ApplicationDTO> applicationsCountry = applicationService.getApplicationByCountry(callDTO.getId(), nutsDTO.getCountryCode());

                    for (ApplicationDTO applicationDTO: applicationsCountry) {
                        RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
                        MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());

                        //Check if municipality with the same name have been assigned, if assigned then delete else continue
                        if(listOfMunicipalitiesForWhichVoucherisAssigned.containsKey(municipalityDTO.getName())) {
                            removeFromLOA(applicationDTOList, applicationDTO);
                            continue;
                        }
                        listOfMunicipalitiesForWhichVoucherisAssigned.put(municipalityDTO.getName(), municipalityDTO);
                        countryAssignedVouchers.put(municipalityDTO.getCountry(), countryAssignedVouchers.get(municipalityDTO.getCountry()) + 1);
                        totalAssignedVouchers += 1;
                        removeFromLOA(applicationDTOList, applicationDTO);

                        if(countryAssignedVouchers.get(municipalityDTO.getCountry()) >= countryMininimumVouchersToBeAssigned.get(municipalityDTO.getCountry())){
                            break;
                        }
                    }
                }


                /**
                 * 9.	Once this is done every country can have a number of vouchers assigned
                 * that is between 0 and the minimum for that country (CountryMininimumVouchersToBeAssigned)
                 */


                for (String countryKey : countryAssignedVouchers.keySet()) {
                    countryAssignedVouchers.get(countryKey);
                    if(countryAssignedVouchers.get(countryKey) >= countryMininimumVouchersToBeAssigned.get(countryKey)){
                        // OK
                    }
                    else{
                        // Below mininimum
                    }
                }

                /**
                 * 10.	Continue with the LOA to step 11
                 */


               /*  do{
                    System.out.println("HELLO");
                }while(totalAssignedVouchers <= vouchersToBeAssigned); */


            }

        }

    }

    public void removeFromLOA(List<ApplicationDTO> listLOA, ApplicationDTO applicationDTO){
        for(int i = 0; i < listLOA.size(); i++){
            if(listLOA.get(i).equals(applicationDTO)){
                listLOA.remove(i);
                break;
            }
        }
    }

    public ResponseDTO simulateVoucherAssignment2(CallDTO callDTO){
        if(callDTO == null){
            return new ResponseDTO(false, "call not found" , new ErrorDTO(1, null));
        }
        Date todayDate = new Date();
        Date callEndDate = new Date(callDTO.getEndDate());
        if(!callEndDate.before(todayDate)){
            return new ResponseDTO(false, "call not closed", new ErrorDTO(2, null));
        }
        ArrayList<Map> simulation = new ArrayList<>();
        ArrayList<String> countryList = new ArrayList<>();
        ArrayList<Integer> countApplications = new ArrayList<>();
        List<List<LauDTO>> listLaus = new ArrayList<>();
        List<ApplicationDTO> applicationDTOS = applicationService.getApplicationsByCall(callDTO.getId());
        for(ApplicationDTO applicationDTO: applicationDTOS){
            RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
            MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());
            LauDTO lauDTO = lauService.getLauById(municipalityDTO.getLauId());
            if(!countryList.contains(municipalityDTO.getCountry())){
                countryList.add(municipalityDTO.getCountry());
                countApplications.add(1);
                List<LauDTO> lauDTOS = new ArrayList<>();
                lauDTOS.add(lauDTO);
                listLaus.add(lauDTOS);
            }
            else{
                int index = countryList.indexOf(municipalityDTO.getCountry());
                int numApp = countApplications.get(index);
                numApp+=1;
                countApplications.set(index, numApp);
                boolean exist = false;
                List<LauDTO> laList = new ArrayList<>(listLaus.get(index));
                for(LauDTO lauDTO1: laList){
                    if(lauDTO1.getId() == lauDTO.getId()){
                        exist = true;
                        break;
                    }
                }
                if(!exist){
                    laList.add(lauDTO);
                }
                listLaus.set(index, laList);
            }
        }
        int currentVouchersApplied = 0;
        if(countryList.size() > 0){
            for(int i = 0; i < countryList.size(); i++){
                if(!(countApplications.get(i) >= 15 && countApplications.get(i) <= 80)){
                    if(countApplications.get(i) < 15){
                        return new ResponseDTO(false, "under 15 applications for " + countryList.get(i), new ErrorDTO(3, null));
                    }
                    else if(countApplications.get(i) > 80){
                        return new ResponseDTO(false, "above 80 applications for " + countryList.get(i) , new ErrorDTO(4, null));
                    }
                }
                Map<String, Object> countryMap = new HashMap<>();
                countryMap.put("country", countryList.get(i));
                countryMap.put("municipalities", listLaus.get(i));
                countryMap.put("applied", countApplications.get(i));
                simulation.add(countryMap);
                currentVouchersApplied += countApplications.get(i);
                if(currentVouchersApplied > 1000){
                    return new ResponseDTO(false, "applied voucher exceeds 1000", new ErrorDTO(4, null));
                }
            }
        }
        return new ResponseDTO(true, simulation, null);
    }

}