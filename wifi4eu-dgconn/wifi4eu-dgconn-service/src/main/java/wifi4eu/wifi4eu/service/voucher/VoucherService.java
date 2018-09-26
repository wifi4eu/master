package wifi4eu.wifi4eu.service.voucher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.google.common.collect.Lists;

import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationWarningDTO;
import wifi4eu.wifi4eu.common.dto.model.SimpleLauDTO;
import wifi4eu.wifi4eu.common.dto.model.SimpleMunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.SimpleRegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherAssignmentAuxiliarDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherAssignmentDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherManagementDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherSimulationDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.SelectionStatus;
import wifi4eu.wifi4eu.common.enums.VoucherAssignmentStatus;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.admin.AdminActions;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignmentAuxiliar;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
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
import wifi4eu.wifi4eu.util.FreezeListAsync;
import wifi4eu.wifi4eu.util.SendNotificationsAsync;
import wifi4eu.wifi4eu.util.SimulateVoucherAsync;
import wifi4eu.wifi4eu.util.VoucherSimulationExportGenerator;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
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

    @Autowired
    private UserMapper userMapper;

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

    public List<VoucherSimulationDTO> getVoucherSimulationsByVoucherAssigmentId(int voucherAssignmentId) {
        return voucherSimulationMapper.toDTOList(voucherSimulationRepository.findAllByVoucherAssignmentOrderByEuRank(voucherAssignmentId));
    }

    public boolean checkSavePreSelectionEnabled(int voucherAssignmentId) {
        return voucherSimulationRepository.checkIfSimulationIsValid(voucherAssignmentId) == 0;
    }

    @Transactional
    public ResponseDTO saveFreezeListSimulation(String freezePsswd, int voucherAssignmentId, int callId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        if (!INEAPermissionChecker.freezePsswd.equals(freezePsswd)) {
            return new ResponseDTO(false, null, new ErrorDTO(20, "dgConn.voucherAssignment.error.incorrectPassword"));
        }
        AdminActions adminActions = adminActionsRepository.findOneByAction("freeze_voucher");
        if (Validator.isNull(adminActions)) {
            adminActions = new AdminActions();
            adminActions.setAction("freeze_voucher");
            adminActions.setStartDate(new Date());
            adminActions.setRunning(true);
            adminActions.setUser(userMapper.toEntity(userConnected));
            adminActions = adminActionsRepository.save(adminActions);
        } else {
            if (adminActions.isRunning()) {
                throw new AppException("Freeze List is running...");
            }
            adminActions.setStartDate(new Date());
            adminActions.setRunning(true);
            adminActions.setEndDate(null);
            adminActions.setUser(userMapper.toEntity(userConnected));
            adminActions = adminActionsRepository.save(adminActions);
        }
        // Let the task executor manage the execution of the new thread to send the mails
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Lanunched freeze voucher simulations, starting thread...");
        taskExecutor.execute(context.getBean(FreezeListAsync.class, voucherAssignmentId, callId, userConnected));
        return new ResponseDTO(true, null, null);

    }

    @Transactional
    public ResponseDTO savePreListSimulation(String savePrelistPsswd, int voucherAssignmentId, int callId) {
        CallDTO callDTO = callService.getCallById(callId);

        if (!INEAPermissionChecker.savePrelistPsswd.equals(savePrelistPsswd)) {
            return new ResponseDTO(false, null, new ErrorDTO(20, "dgConn.voucherAssignment.error.incorrectPassword"));
        }

        if (callDTO == null) {
            throw new AppException("Call not exists");
        }

        if (checkSavePreSelectionEnabled(voucherAssignmentId)) {

            VoucherAssignmentAuxiliarDTO auxiliarDTO = voucherAssignmentAuxiliarMapper.toDTO(voucherAssignmentAuxiliarRepository.findByCallIdAndStatusAux(callId, 1));
            if (auxiliarDTO == null) {
                throw new AppException("Voucher assigment not found");
            }
            List<VoucherSimulationDTO> simulationList = getVoucherSimulationsByVoucherAssigmentId(auxiliarDTO.getId());

            VoucherAssignmentDTO voucherAssignment = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.findByCallIdAndStatusEquals(callId, 2));

            if (voucherAssignment != null) {
                //voucherAssignmentRepository.delete(voucherAssignmentMapper.toEntity(voucherAssignment));
                throw new AppException("Existing Pre-selection list for callId: " + callId);
            }

            voucherAssignment = new VoucherAssignmentDTO();
            voucherAssignment.setCall(callService.getCallById(callId));
            voucherAssignment.setUser(userService.getUserByUserContext(UserHolder.getUser()));
            voucherAssignment.setExecutionDate(new Date().getTime());

            voucherAssignment.setStatus(VoucherAssignmentStatus.PRE_LIST.getValue());

            Set<VoucherSimulationDTO> simulationsPreSave = new HashSet<>();

            VoucherAssignmentDTO result = voucherAssignmentMapper.toDTO(voucherAssignmentRepository.save(voucherAssignmentMapper.toEntity(voucherAssignment)));

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
            return new ResponseDTO(true, result, null);
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
        AdminActions adminActions = null;
        //create row in db to keep the process blocked
        adminActions = adminActionsRepository.findOneByAction("voucher_simulation");
        if (Validator.isNull(adminActions)) {
            adminActions = new AdminActions();
            adminActions.setAction("voucher_simulation");
            adminActions.setStartDate(new Date());
            adminActions.setRunning(true);
            adminActions.setUser(userMapper.toEntity(userConnected));
            adminActions = adminActionsRepository.save(adminActions);
        } else {
            if (adminActions.isRunning()) {
                throw new AppException("Voucher Simulation is running...");
            }
            adminActions.setStartDate(new Date());
            adminActions.setRunning(true);
            adminActions.setEndDate(null);
            adminActions.setUser(userMapper.toEntity(userConnected));
            adminActions = adminActionsRepository.save(adminActions);
        }

        // Let the task executor manage the execution of the new thread to send the mails
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Generating simulation...");
        taskExecutor.execute(context.getBean(SimulateVoucherAsync.class, callId, userConnected));
        return new ResponseDTO(true, null, null);
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
            return new ResponseDTO(false, null, new ErrorDTO(20, "dgConn.voucherAssignment.error.incorrectPassword"));
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