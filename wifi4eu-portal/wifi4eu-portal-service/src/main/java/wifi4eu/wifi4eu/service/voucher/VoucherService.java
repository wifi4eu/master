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
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;
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
    public ResponseDTO simulateVoucherAssignment(CallDTO callDTO){
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
                    return new ResponseDTO(false, null, null);
                    //return "error";
                }

                List<ApplicationDTO> applicationDTOList = applicationService.getApplicationsByCall(callDTO.getId());
                List<ApplicationDTO> supportLOAlist = new ArrayList<>(applicationDTOList);

                //GET COUNTRIES
                List<NutsDTO> nutsDTOList = nutsService.getNutsByLevel(0);

                HashMap<String, ApplicationDTO> listOfMunicipalitiesForWhichVoucherIsAssigned = new HashMap<>();

                for (NutsDTO nutsDTO: nutsDTOList) {
                    //GET Applications for each country
                    List<ApplicationDTO> applicationsCountry = applicationService.getApplicationByCountry(callDTO.getId(), nutsDTO.getCountryCode());

                    for (ApplicationDTO applicationDTO: applicationsCountry) {

                        if(countryAssignedVouchers.get(nutsDTO.getLabel()) >= countryMininimumVouchersToBeAssigned.get(nutsDTO.getLabel())){
                            removeFromLOA(supportLOAlist, applicationDTO);
                            break;
                        }

                        RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
                        MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());

                        //Check if municipality with the same name have been assigned, if assigned then delete else continue
                        if(listOfMunicipalitiesForWhichVoucherIsAssigned.containsKey(municipalityDTO.getName())) {
                            removeFromLOA(supportLOAlist, applicationDTO);
                            continue;
                        }
                        listOfMunicipalitiesForWhichVoucherIsAssigned.put(municipalityDTO.getName(), applicationDTO);
                        countryAssignedVouchers.put(municipalityDTO.getCountry(), countryAssignedVouchers.get(municipalityDTO.getCountry()) + 1);
                        totalAssignedVouchers += 1;
                        removeFromLOA(supportLOAlist, applicationDTO);
                    }
                }

                /**
                 * 10.	Continue with the LOA to step 11
                 */

                do{
                    for (NutsDTO nutsDTO: nutsDTOList) {
                        //GET Applications for each country
                        List<ApplicationDTO> applicationsCountry = applicationService.getApplicationByCountry(callDTO.getId(), nutsDTO.getCountryCode());

                        for (ApplicationDTO applicationDTO: applicationsCountry) {

                            if(countryAssignedVouchers.get(nutsDTO.getLabel()) >= countryMaximumVouchersToBeAssigned.get(nutsDTO.getLabel())) {
                                removeFromLOA(supportLOAlist, applicationDTO);
                                continue;
                            }
                            RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
                            MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());

                            if(listOfMunicipalitiesForWhichVoucherIsAssigned.containsKey(municipalityDTO.getName())) {
                                removeFromLOA(supportLOAlist, applicationDTO);
                                continue;
                            }
                            listOfMunicipalitiesForWhichVoucherIsAssigned.put(municipalityDTO.getName(), applicationDTO);
                            countryAssignedVouchers.put(municipalityDTO.getCountry(), countryAssignedVouchers.get(municipalityDTO.getCountry()) + 1);
                            totalAssignedVouchers += 1;
                            removeFromLOA(supportLOAlist, applicationDTO);
                        }
                    }
                } while(totalAssignedVouchers < vouchersToBeAssigned && supportLOAlist.size() > 0);
                return new ResponseDTO(true, listOfMunicipalitiesForWhichVoucherIsAssigned, null);
            }
            return new ResponseDTO(false, "Call not exist", null);
        }
        return new ResponseDTO(false, "User not defined", null);
    }

    public void removeFromLOA(List<ApplicationDTO> listLOA, ApplicationDTO applicationDTO){
        for(int i = 0; i < listLOA.size(); i++){
            if(listLOA.get(i).getId() == applicationDTO.getId()){
                listLOA.remove(i);
                break;
            }
        }
    }

}