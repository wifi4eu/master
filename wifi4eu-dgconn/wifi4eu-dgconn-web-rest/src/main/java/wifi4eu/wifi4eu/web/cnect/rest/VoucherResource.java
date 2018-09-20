package wifi4eu.wifi4eu.web.cnect.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherAssignmentAuxiliarDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherAssignmentDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.voucher.VoucherService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/voucher", description = "Application object REST API services")
@RequestMapping("voucher")
public class VoucherResource {
    Logger _log = LogManager.getLogger(VoucherResource.class);

    @Autowired
    VoucherService voucherService;

    @Autowired
    UserService userService;

    @Autowired
    PermissionChecker permissionChecker;

    @ApiOperation(value = "Get if application is in freeze list")
    @RequestMapping(value = "/in-freeze/application/{applicationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO checkIfApplicationInFreeze(@PathVariable("applicationId") final Integer applicationId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving all the voucher assignments");
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: checkIfApplicationInFreeze");
            }
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setData(voucherService.checkIfApplicationInFreeze(applicationId));
            responseDTO.setSuccess(true);
            responseDTO.setError(null);
            return responseDTO;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to retrieve all the voucher assignments", ade.getMessage());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The voucher assignments cannot been retrieved", e);
            return null;
        }
    }

    @ApiOperation(value = "Get if application is in simulation list")
    @RequestMapping(value = "/in-simulation/application/{applicationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO checkIfApplicationInSimulation(@PathVariable("applicationId") final Integer applicationId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving all the voucher assignments");
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: checkIfApplicationInSimulation");
            }
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setData(voucherService.checkIfApplicationInSimulation(applicationId));
            responseDTO.setSuccess(true);
            responseDTO.setError(null);
            return responseDTO;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to retrieve all the voucher assignments", ade.getMessage());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The voucher assignments cannot been retrieved", e);
            return null;
        }
    }

    @ApiOperation(value = "Get all the voucher assignment")
    @RequestMapping(value = "/assignments", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<VoucherAssignmentDTO> allVoucherAssignments() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving all the voucher assignments");
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: allVoucherAssignments");
            }
            return voucherService.getAllVoucherAssignment();
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to retrieve all the voucher assignments", ade.getMessage());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The voucher assignments cannot been retrieved", e);
            return null;
        }
    }

    @ApiOperation(value = "Get voucher assignment by id")
    @RequestMapping(value = "/assignments/{assignmentId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public VoucherAssignmentDTO getVoucherAssignmentById(@PathVariable("assignmentId") final Integer assignmentId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving the voucher assignment with id " + assignmentId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getVoucherAssignmentById");
            }
            return voucherService.getVoucherAssignmentById(assignmentId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to retrieve the voucher assignment", ade.getMessage());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The voucher assignment cannot been retrieved", e);
            return null;
        }
    }

    @ApiOperation(value = "Get voucher assignment by call")
    @RequestMapping(value = "/assignment/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public VoucherAssignmentDTO getVoucherAssignmentByCall(@PathVariable("callId") final Integer callId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving the voucher assignment by call id " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getVoucherAssignmentByCall");
            }
            return voucherService.getVoucherAssignmentByCall(callId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to retrieve the voucher assignment", ade.getMessage());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The voucher assignment cannot been retrieved", e);
            return null;
        }
    }

    @ApiOperation(value = "Get voucher assignment by call")
    @RequestMapping(value = "/assignmentaux/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public VoucherAssignmentAuxiliarDTO getVoucherAssignmentAuxiliarByCall(@PathVariable("callId") final Integer callId, HttpServletResponse httpServletResponse, HttpServletRequest request) {
        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        httpServletResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving the voucher assignment by call id " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getVoucherAssignmentAuxiliarByCall");
            }
            VoucherAssignmentAuxiliarDTO response = voucherService.getVoucherAssignmentAuxiliarByCall(callId);
            return response;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to retrieve the voucher assignment", ade.getMessage());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The voucher assignment cannot been retrieved", e);
            return null;
        }
    }


    @ApiOperation(value = "Get voucher simulation by voucher assignment")
    @RequestMapping(value = "/assignment/{assignmentId}/simulation", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getVoucherSimulationByVoucherAssignment(@PathVariable("assignmentId") final Integer assignmentId,
                                                               @RequestParam("country") String country,
                                                               @RequestParam("municipality") String municipality,
                                                               @RequestParam("page") Integer page,
                                                               @RequestParam("size") Integer size,
                                                               @RequestParam("field") String field,
                                                               @RequestParam("direction") String direction, HttpServletResponse httpServletResponse) {

        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        httpServletResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving voucher simulation by assignment id " + assignmentId + ", country "
                + country + ", municiaplity " + municipality + ", page " + page + ", size " + size + ", field " + field + " and direction " + direction);

        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getVoucherSimulationByVoucherAssignment");
            }
            Pageable pageable;
            if (direction.equals("ASC") || direction.equals("asc")) {
                pageable = new PageRequest(page, size, Direction.ASC, field);
            } else {
                pageable = new PageRequest(page, size, Direction.DESC, field);
            }
            ResponseDTO response = voucherService.getVoucherSimulationByVoucherAssignment(assignmentId, country, municipality, pageable);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Success on retrieving simulation by this voucher assignment");
            return response;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to retrieve simulation by this voucher assignment", ade.getMessage());
            return new ResponseDTO(false, null, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Voucher simulation cannot be executed", e);
            return new ResponseDTO(false, null, null);
        }

    }

    @ApiOperation(value = "Create voucher assignment")
    @RequestMapping(value = "/assignment/simulate", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO simulateVoucherAssignment(@RequestBody final Integer callId, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Creating voucher assignment");
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: simulateVoucherAssignment");
            }
            ResponseDTO response = voucherService.simulateVoucherFast(callId);
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Success on voucher simulation");
            return response;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to run voucher simulation", ade.getMessage());
            return new ResponseDTO(false, null, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Voucher simulation cannot be executed", e);
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Check pre-selected list enabled")
    @RequestMapping(value = "/assignment/{assignmentId}/check-prelist-enabled", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public boolean checkSavePreSelectionEnabled(@PathVariable("assignmentId") final Integer assignmentId, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Checking pre-selected list with assignment id " + assignmentId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: checkSavePreSelectionEnabled");
            }
            boolean checkResponse = voucherService.checkSavePreSelectionEnabled(assignmentId);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Success on checking pre-selection list");
            return checkResponse;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to check pre-selected list", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return false;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Pre-selected list cannot been checked", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return false;
        }
    }

    @ApiOperation(value = "Save simulation to pre-selected list")
    @RequestMapping(value = "/assignment/save-prelist", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO savePreListSimulation(@RequestParam("assignmentId") Integer assignmentId, @RequestParam("callId") Integer callId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Saving simulation to pre-selected list with assignment id " + assignmentId + " and call id " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: savePreListSimulation");
            }
            VoucherAssignmentDTO result = voucherService.savePreListSimulation(assignmentId, callId);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Success on saving simulation");
            return new ResponseDTO(true, result, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to save simulation", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Simulation cannot been saved", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Send notifications  to applicants")
    @RequestMapping(value = "/assignment/send-notifications", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO sendNotificationForApplicants(@RequestParam("psswdNotification") final String psswdNotification, @RequestBody final Integer callId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Sending notification to applicants on call id " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: sendNotificationForApplicants");
            }
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - The process of sending notifications has started successfully");
            return voucherService.sendNotificationForApplicants(psswdNotification, callId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to send notifications", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Notifications cannot been sent", e);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return new ResponseDTO(false, null, null);
    }

    @ApiOperation(value = "Freeze simulation list")
    @RequestMapping(value = "/assignment/freeze-simulation-list", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO saveFreezeListSimulation(@RequestParam("freezePsswd") final String freezePsswd, @RequestParam("assignmentId") Integer assignmentId, @RequestParam("callId") Integer callId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Freezing simulation list with assignment id " + assignmentId + " and call id " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: saveFreezeListSimulation");
            }
            VoucherAssignmentDTO result = voucherService.saveFreezeListSimulation(freezePsswd, assignmentId, callId);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Success on freezing simulation list");
            return new ResponseDTO(true, result, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to freeze simulation", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Simulations cannot been frozen", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }


    @ApiOperation(value = "Get voucher assignment auxiliar by call and status")
    @RequestMapping(value = "/assignment/call/{callId}/status/{status}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public VoucherAssignmentAuxiliarDTO getVoucherAssignmentByCallAndStatus(@PathVariable("callId") Integer callId, @PathVariable("status") Integer status, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving voucher assignment auxiliar on call id " + callId + " and status " + status);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getVoucherAssignmentByCallAndStatus");
            }
            VoucherAssignmentAuxiliarDTO voucherResponse = voucherService.getVoucherAssignmentByCallAndStatus(callId, status);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Success on retrieving voucher assignment auxiliar");
            return voucherResponse;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to retrieve voucher assignment auxiliar", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Voucher assignment auxiliar cannot been retrieved", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

    @ApiOperation(value = "Export voucher simulation")
    @RequestMapping(value = "/exportExcel/assignment/{assignmentId}/simulation", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> exportExcelVoucherSimulation(@PathVariable("assignmentId") final Integer assignmentId,
                                                               @RequestParam("country") String country,
                                                               @RequestParam("municipality") String municipality,
                                                               @RequestParam("field") String field,
                                                               @RequestParam("direction") String direction,
                                                               HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Exporting voucher simulation by assignment id "
                + assignmentId + ", country " + country + ", municipality " + municipality + ", field " + field + " and direction " + direction);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: exportExcelVoucherSimulation");
            }
            Pageable pageable;
            if (direction.equals("ASC") || direction.equals("asc")) {
                pageable = new PageRequest(0, Integer.MAX_VALUE, Direction.ASC, field);
            } else {
                pageable = new PageRequest(0, Integer.MAX_VALUE, Direction.DESC, field);
            }
            ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
            String filename = "dgconn-voucher-simulation.xls";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            responseReturn = new ResponseEntity<>(voucherService.exportVoucherSimulation(assignmentId, country, municipality, pageable), headers, HttpStatus.OK);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Success on downloading voucher simulations excel");
            return responseReturn;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " -  You have no permissions to download the excel file", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " -  Voucher simulation excel cannot been retrieved", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @ApiOperation(value = "Check freeze list is enabled")
    @RequestMapping(value = "/assignment/check-freeze-enabled/by/call/{callId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Boolean> checkApplicationAreValidForFreezeList(@PathVariable("callId") final Integer callId, @RequestParam("timestamp") final Long timestamp,
                                                                         HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Checking if freeze list is enabled by call ID " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: checkApplicationAreValidForFreezeList");
            }
            Boolean enabled = voucherService.checkApplicationAreValidForFreezeList(callId);
            return new ResponseEntity<>(enabled, HttpStatus.OK);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " -  You have no permissions to check if freeze list is enabled", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception ex) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " -  Error checking if freeze list is enabled" + ex.getMessage(), ex);
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }

    }

}