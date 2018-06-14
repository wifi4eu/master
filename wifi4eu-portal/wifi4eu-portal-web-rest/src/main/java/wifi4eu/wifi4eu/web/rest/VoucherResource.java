package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ResponseHeader;
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
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.VoucherAssignmentAuxiliarDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherAssignmentDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.voucher.VoucherService;
import wifi4eu.wifi4eu.service.voucher.util.ScenariosService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/voucher", description = "Application object REST API services")
@RequestMapping("voucher")
public class VoucherResource {
    @Autowired
    VoucherService voucherService;

    @Autowired
    ScenariosService scenariosService;

    @Autowired
    UserService userService;

    @Autowired
    PermissionChecker permissionChecker;

    Logger _log = LogManager.getLogger(VoucherResource.class);

    @ApiOperation(value = "Get all the voucher assignment")
    @RequestMapping(value = "/assignments", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<VoucherAssignmentDTO> allVoucherAssignments() {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: allVoucherAssignments");
            }
            return voucherService.getAllVoucherAssignment();
        }
        catch (AccessDeniedException e){
            _log.error(e.getMessage());
            return null;
        }
        catch (Exception e){
            _log.error(e.getMessage(), e);
            return null;
        }
    }

    @ApiOperation(value = "Get voucher assignment by id")
    @RequestMapping(value = "/assignments/{assignmentId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public VoucherAssignmentDTO getVoucherAssignmentById(@PathVariable("assignmentId") final Integer assignmentId) {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getVoucherAssignmentById");
            }
            return voucherService.getVoucherAssignmentById(assignmentId);
        }
        catch (AccessDeniedException e){
            _log.error(e.getMessage());
            return null;
        }
        catch (Exception e){
            _log.error(e.getMessage(), e);
            return null;
        }
    }

    @ApiOperation(value = "Get voucher assignment by call")
    @RequestMapping(value = "/assignment/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public VoucherAssignmentDTO getVoucherAssignmentByCall(@PathVariable("callId") final Integer callId) {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getVoucherAssignmentByCall");
            }
            return voucherService.getVoucherAssignmentByCall(callId);
        }
        catch (AccessDeniedException e){
            _log.error(e.getMessage());
            return null;
        }
        catch (Exception e){
            _log.error(e.getMessage(), e);
            return null;
        }
    }

    @ApiOperation(value = "Get voucher assignment by call")
    @RequestMapping(value = "/assignmentaux/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public VoucherAssignmentAuxiliarDTO getVoucherAssignmentAuxiliarByCall(@PathVariable("callId") final Integer callId) {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getVoucherAssignmentAuxiliarByCall");
            }
            return voucherService.getVoucherAssignmentAuxiliarByCall(callId);
        }
        catch (AccessDeniedException e){
            _log.error(e.getMessage());
            return null;
        }
        catch (Exception e){
            _log.error(e.getMessage(), e);
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
                                                               @RequestParam("direction") String direction) {

        try{
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getVoucherSimulationByVoucherAssignment");
            }

            Pageable pageable;

            if (direction.equals("ASC") || direction.equals("asc")) {
                pageable = new PageRequest(page, size, Direction.ASC, field);
            } else {
                pageable = new PageRequest(page, size, Direction.DESC, field);
            }
            _log.info("ECAS Username: " + userService.getUserByUserContext(UserHolder.getUser()).getEcasUsername() + " - Success on retrieving simulation by voucher assignment: " + assignmentId);
            return voucherService.getVoucherSimulationByVoucherAssignment(assignmentId, country, municipality, pageable);
        }
        catch (AccessDeniedException e){
            _log.error("ECAS Username: " + userService.getUserByUserContext(UserHolder.getUser()).getEcasUsername() + " - You have no permissions to retrieve simulation by voucher assignment: " + assignmentId, e.getMessage());
            return new ResponseDTO(false, null, null);
        }
        catch (Exception e){
            _log.error("ECAS Username: " + userService.getUserByUserContext(UserHolder.getUser()).getEcasUsername() + " - Voucher  Voucher simulation cannot be executed", e.getMessage());
            return new ResponseDTO(false, null, null);
        }

    }

    @ApiOperation(value = "Create voucher assignment")
    @RequestMapping(value = "/assignment/simulate", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO simulateVoucherAssignment(@RequestBody final Integer callId) {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: simulateVoucherAssignment");
            }
            _log.log(Level.getLevel("BUSINESS"),"ECAS Username: " + userService.getUserByUserContext(UserHolder.getUser()).getEcasUsername() + " - Success on voucher simulation");
            return voucherService.simulateVoucherFast(callId);
        }
        catch (AccessDeniedException e){
            _log.error("ECAS Username: " + userService.getUserByUserContext(UserHolder.getUser()).getEcasUsername() + " - You have no permissions to run voucher simulation", e.getMessage());
            return new ResponseDTO(false, null, null);
        }
        catch (Exception e){
            _log.error("ECAS Username: " + userService.getUserByUserContext(UserHolder.getUser()).getEcasUsername() + " - Voucher simulation cannot be executed", e.getMessage());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Export voucher simulation")
    @RequestMapping(value = "/exportExcel/assignment/{assignmentId}/simulation", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> exportExcelVoucherSimulation(@PathVariable("assignmentId") final Integer assignmentId,
                                                               @RequestParam("country") String country,
                                                               @RequestParam("municipality") String municipality,
                                                               @RequestParam("page") Integer page,
                                                               @RequestParam("size") Integer size,
                                                               @RequestParam("field") String field,
                                                               @RequestParam("direction") String direction,
                                                          HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: exportExcelVoucherSimulation");
            }

            Pageable pageable;

            if (direction.equals("ASC") || direction.equals("asc")) {
                pageable = new PageRequest(page, Integer.MAX_VALUE, Direction.ASC, field);
            } else {
                pageable = new PageRequest(page, Integer.MAX_VALUE, Direction.DESC, field);
            }

            ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
            String filename = "dgconn-voucher-simulation.xls";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            responseReturn = new ResponseEntity<>(voucherService.exportVoucherSimulation(assignmentId, country, municipality, pageable), headers, HttpStatus.OK);
            _log.info("ECAS Username: " + userService.getUserByUserContext(UserHolder.getUser()).getEcasUsername() + " - Success on downloading voucher simulations excel");
            return responseReturn;
        }catch (AccessDeniedException e){
            _log.error("ECAS Username: " + userService.getUserByUserContext(UserHolder.getUser()).getEcasUsername() + " -  You have no permissions to download excel file", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
        catch (Exception e){
            _log.error("ECAS Username: " + userService.getUserByUserContext(UserHolder.getUser()).getEcasUsername() + " -  Voucher simulation excel cannot been retrieved", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

}