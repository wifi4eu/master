package wifi4eu.wifi4eu.service.voucher;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;
import wifi4eu.wifi4eu.entity.voucherManagement.VoucherManagement;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.mapper.voucher.VoucherAssignmentMapper;
import wifi4eu.wifi4eu.mapper.voucher.VoucherSimulationMapper;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("portalVoucherService")
public class VoucherService {
    @Autowired
    VoucherAssignmentMapper voucherAssignmentMapper;

    @Autowired
    VoucherSimulationMapper voucherSimulationMapper;

    @Autowired
    UserService userService;

    @Autowired
    VoucherManagementService voucherManagementService;

    @Autowired
    VoucherSimulationRepository voucherSimulationRepository;

    @Autowired
    VoucherAssignmentRepository voucherAssignmentRepository;

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
            UserDTO userDTO = userService.getUserByUserContext(userContext);
            VoucherAssignmentDTO assignmentDTO = new VoucherAssignmentDTO();
            assignmentDTO.setCall(callDTO);
            assignmentDTO.setStatus(1);
            assignmentDTO.setExecutionDate(new Date().getTime());
            assignmentDTO.setUser(userDTO);

            List<VoucherManagementDTO> voucherManagements = voucherManagementService.getVoucherManagementByCall(callDTO.getId());

            for (VoucherManagementDTO voucherManagement: voucherManagements) {
                System.out.println(voucherManagement.getMinimum() + ", "+ voucherManagement.getMaximum());
            }

            VoucherAssignment voucherAssignment = voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(assignmentDTO));
            System.out.println(voucherAssignment.getId());

        }

    }

}