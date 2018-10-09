package wifi4eu.wifi4eu.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.SelectionStatus;
import wifi4eu.wifi4eu.common.enums.VoucherAssignmentStatus;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.entity.admin.AdminActions;
import wifi4eu.wifi4eu.common.mapper.user.UserMapper;
import wifi4eu.wifi4eu.common.mapper.voucher.VoucherAssignmentAuxiliarMapper;
import wifi4eu.wifi4eu.common.mapper.voucher.VoucherAssignmentMapper;
import wifi4eu.wifi4eu.common.mapper.voucher.VoucherSimulationMapper;
import wifi4eu.wifi4eu.repository.admin.AdminActionsRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentAuxiliarRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.security.INEAPermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.voucher.VoucherService;

import java.util.*;

/**
 * Created by rgarcita on 11/02/2017.
 */
@Component
@Scope("prototype")
public class FreezeListAsync implements Runnable {

    @Autowired
    VoucherAssignmentAuxiliarRepository voucherAssignmentAuxiliarRepository;

    @Autowired
    VoucherAssignmentAuxiliarMapper voucherAssignmentAuxiliarMapper;

    @Autowired
    VoucherSimulationMapper voucherSimulationMapper;

    @Autowired
    VoucherSimulationRepository voucherSimulationRepository;

    @Autowired
    VoucherAssignmentMapper voucherAssignmentMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CallService callService;

    @Autowired
    UserService userService;

    @Autowired
    VoucherService voucherService;

    @Autowired
    AdminActionsRepository adminActionsRepository;

    @Autowired
    VoucherAssignmentRepository voucherAssignmentRepository;

    public final static String FROM_ADDRESS = "no-reply@wifi4eu.eu";
    public final static String NO_ACTION = "NO ACTION LOGGED";

    private final Logger _log = LogManager.getLogger(FreezeListAsync.class);

    private UserDTO userConnected;

    private Integer callId;

    private Integer voucherAssignmentId;

    public FreezeListAsync(Integer voucherAssignmentId, Integer callId, UserDTO userConnected) {
        this.userConnected = userConnected;
        this.callId = callId;
        this.voucherAssignmentId = voucherAssignmentId;
    }

    @Override
    public void run() {
        AdminActions adminActions = adminActionsRepository.findOneByAction("freeze_voucher");
        try {

            CallDTO callDTO = callService.getCallById(callId);
            if (callDTO == null) {
                throw new AppException("Call not exists");
            }
            if (!voucherService.checkApplicationAreValidForFreezeList(callId)) {
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
            freezeVoucherAssignment.setUser(userConnected);
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
            voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(result));
            adminActions.setRunning(false);
            adminActions.setEndDate(new Date());
            adminActionsRepository.save(adminActions);

        } catch (Exception ex) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot freeze voucher",
                    ex.getMessage());
            if (Validator.isNotNull(adminActions)) {
                adminActions.setAction("freeze_voucher");
                adminActions.setStartDate(null);
                adminActions.setRunning(false);
                adminActions.setEndDate(null);
                adminActions.setUser(userMapper.toEntity(userConnected));
                adminActionsRepository.save(adminActions);
            }
        }
    }

}
