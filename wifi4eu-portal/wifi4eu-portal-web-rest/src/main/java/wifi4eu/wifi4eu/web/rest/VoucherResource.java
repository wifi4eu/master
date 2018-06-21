package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.*;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignmentAuxiliar;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.voucher.VoucherService;
import wifi4eu.wifi4eu.service.voucher.util.ScenariosService;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletResponse;

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
    PermissionChecker permissionChecker;

    Logger _log = LoggerFactory.getLogger(VoucherResource.class);

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
    public VoucherAssignmentAuxiliarDTO getVoucherAssignmentAuxiliarByCall(@PathVariable("callId") final Integer callId, HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        httpServletResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.

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


    @ApiOperation(value = "Get voucher assignment by call")
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

            return voucherService.getVoucherSimulationByVoucherAssignment(assignmentId, country, municipality, pageable);
        }
        catch (AccessDeniedException e){
            _log.error(e.getMessage());
            return new ResponseDTO(false, null, null);
        }
        catch (Exception e){
            _log.error(e.getMessage(), e);
            return new ResponseDTO(false, null, null);
        }

    }

    @ApiOperation(value = "Create voucher assignment")
    @ResponseHeader(name = "Cache-control", response = String.class, description = "no-cache")
    @RequestMapping(value = "/assignment/simulate", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO simulateVoucherAssignment(@RequestBody final Integer callId) {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: simulateVoucherAssignment");
            }

            return voucherService.simulateVoucherFast(callId);
        }
        catch (AccessDeniedException e){
            _log.error(e.getMessage());
            return new ResponseDTO(false, null, null);
        }
        catch (Exception e){
            _log.error(e.getMessage(), e);
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Check pre-selected list enabled")
    @RequestMapping(value = "/assignment/{assignmentId}/check-prelist-enabled", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public boolean checkSavePreSelectionEnabled(@PathVariable("assignmentId") final Integer assignmentId, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.

        try{
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: checkSavePreSelectionEnabled");
            }
            return voucherService.checkSavePreSelectionEnabled(assignmentId);
        }
        catch (AccessDeniedException adex){
            if(_log.isWarnEnabled()){
                _log.warn(adex.getMessage());
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return false;
        }catch (Exception ex){
            if(_log.isWarnEnabled()){
                _log.warn(ex.getMessage());
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return false;
        }
    }

    @ApiOperation(value = "Save simulation to pre-selected list")
    @RequestMapping(value = "/assignment/save-prelist", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO savePreListSimulation(@RequestParam("assignmentId") Integer assignmentId, @RequestParam("callId") Integer callId, HttpServletResponse response) throws IOException {
        try{
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: savePreListSimulation");
            }
            VoucherAssignmentDTO result = voucherService.savePreListSimulation(assignmentId, callId);
            return new ResponseDTO(true, result, null);
        }
        catch (AccessDeniedException adex){
            if(_log.isWarnEnabled()){
                _log.warn(adex.getMessage());
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }catch (Exception ex){
            if(_log.isWarnEnabled()){
                _log.warn(ex.getMessage());
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Send notifications  to applicants")
    @RequestMapping(value = "/assignment/send-notifications", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO sendNotificationForApplicants(@RequestBody final Integer callId, HttpServletResponse response) throws IOException {

        try{
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: sendNotificationForApplicants");
            }
            voucherService.sendNotificationForApplicants(callId);
            return new ResponseDTO(true, null, null);
        }
        catch (AccessDeniedException ade){
            if(_log.isWarnEnabled()){
                _log.warn(ade.getMessage());
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        catch (Exception e){
            if(_log.isWarnEnabled()){
                _log.warn("Error on 'sendNotificationForApplicants' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return new ResponseDTO(false, null, null);
    }

    @ApiOperation(value = "Freeze simulation list")
    @RequestMapping(value = "/assignment/freeze-simulation-list", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO saveFreezeListSimulation(@RequestParam("assignmentId") Integer assignmentId, @RequestParam("callId") Integer callId, HttpServletResponse response) throws IOException {
        try{
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: saveFreezeListSimulation");
            }
            VoucherAssignmentDTO result = voucherService.saveFreezeListSimulation(assignmentId, callId);
            return new ResponseDTO(true, result, null);
        }
        catch (AccessDeniedException adex){
            if(_log.isWarnEnabled()){
                _log.warn(adex.getMessage());
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }catch (Exception ex){
            if(_log.isWarnEnabled()){
                _log.warn(ex.getMessage());
            }
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

        try{
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getVoucherAssignmentByCallAndStatus");
            }
            return voucherService.getVoucherAssignmentByCallAndStatus(callId, status);
        }
        catch (AccessDeniedException adex){
            if(_log.isWarnEnabled()){
                _log.warn(adex.getMessage());
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }catch (Exception ex){
            if(_log.isWarnEnabled()){
                _log.warn(ex.getMessage());
            }
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
            return responseReturn;
        }catch (AccessDeniedException e){
            if (_log.isErrorEnabled()) {
                _log.error(e.getMessage());
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
        catch (Exception e){
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'exportVoucherSimulation' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

}