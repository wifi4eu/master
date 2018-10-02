package wifi4eu.wifi4eu.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.common.dto.model.AdminActionsDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherAssignmentDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherSimulationDTO;
import wifi4eu.wifi4eu.common.enums.VoucherAssignmentStatus;
import wifi4eu.wifi4eu.mapper.voucher.VoucherAssignmentMapper;
import wifi4eu.wifi4eu.mapper.voucher.VoucherSimulationMapper;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.admin.AdminActionsService;
import wifi4eu.wifi4eu.service.call.CallService;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Scope("prototype")
public class SavePreselectionListAsync implements Runnable{

    private final Logger _log = LogManager.getLogger(SavePreselectionListAsync.class);

    private int callId;
    private int voucherAssignmentAuxiliarId;
    private UserDTO userDTO;

    public SavePreselectionListAsync(int callId, int voucherAssignmentAuxiliarId, UserDTO userDTO) {
        this.callId = callId;
        this.voucherAssignmentAuxiliarId = voucherAssignmentAuxiliarId;
        this.userDTO = userDTO;
    }

    @Autowired
    CallService callService;

    @Autowired
    VoucherAssignmentMapper voucherAssignmentMapper;

    @Autowired
    VoucherAssignmentRepository voucherAssignmentRepository;

    @Autowired
    VoucherSimulationRepository voucherSimulationRepository;

    @Autowired
    VoucherSimulationMapper voucherSimulationMapper;

    @Autowired
    AdminActionsService adminActionsService;

    @Override
    public void run() {

        AdminActionsDTO adminActionsDTO = adminActionsService.startByActionName(AdminAction.PRE_SELECT_LIST.getValue(), userDTO);

        try{
            VoucherAssignmentDTO voucherAssignment = new VoucherAssignmentDTO();
            voucherAssignment.setCall(callService.getCallById(callId));
            voucherAssignment.setUser(userDTO);
            voucherAssignment.setExecutionDate(new Date().getTime());

            voucherAssignment.setStatus(VoucherAssignmentStatus.PRE_LIST.getValue());

            Set<VoucherSimulationDTO> simulationsPreSave = new HashSet<>();

            VoucherAssignmentDTO result = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(voucherAssignment)));

            List<VoucherSimulationDTO> simulationList = voucherSimulationMapper.toDTOList(voucherSimulationRepository.findAllByVoucherAssignmentOrderByEuRank(voucherAssignmentAuxiliarId));

            for (VoucherSimulationDTO voucherSimulation : simulationList) {
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
                voucherSimulationDTO.setRejected(voucherSimulation.getRejected());
                voucherSimulationDTO.setVoucherAssignment(result.getId());
                simulationsPreSave.add(voucherSimulationDTO);
            }

            result.setVoucherSimulations(simulationsPreSave);

            result = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(result)));

            voucherSimulationRepository.updateApplicationsInVoucherSimulationByVoucherAssignment(1, result.getId());
            adminActionsService.endOK(adminActionsDTO);

        }catch (Exception ex){
            _log .error("ECAS Username: " + userDTO.getEcasUsername() + " - Cannot save preselect list",
                    ex.getMessage());

            adminActionsService.endWithError(adminActionsDTO, AdminAction.PRE_SELECT_LIST.getValue(), userDTO);
        }
    }
}