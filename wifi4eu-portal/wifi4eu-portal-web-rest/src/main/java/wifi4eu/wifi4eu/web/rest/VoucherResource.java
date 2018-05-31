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
        return voucherService.getAllVoucherAssignment();
    }

    @ApiOperation(value = "Get voucher assignment by id")
    @RequestMapping(value = "/assignments/{assignmentId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public VoucherAssignmentDTO getVoucherAssignmentById(@PathVariable("assignmentId") final Integer assignmentId) {
        return voucherService.getVoucherAssignmentById(assignmentId);
    }

    @ApiOperation(value = "Get voucher assignment by call")
    @RequestMapping(value = "/assignment/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public VoucherAssignmentDTO getVoucherAssignmentByCall(@PathVariable("callId") final Integer callId) {
        return voucherService.getVoucherAssignmentByCall(callId);
    }

    @ApiOperation(value = "Get voucher assignment by call")
    @RequestMapping(value = "/assignmentaux/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public VoucherAssignmentAuxiliarDTO getVoucherAssignmentAuxiliarByCall(@PathVariable("callId") final Integer callId) {
        return voucherService.getVoucherAssignmentAuxiliarByCall(callId);
    }


    @ApiOperation(value = "Get voucher assignment by call")
    @RequestMapping(value = "/assignment/{assignmentId}/simulation", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getVoucherSimulationByVoucherAssignment(@PathVariable("assignmentId") final Integer assignmentId, @Nullable @RequestParam("country") String country,
                                                               @RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("field") String field, @RequestParam("direction") String direction) {

        Pageable pageable = new PageRequest(page, size);

        if (direction.equals("ASC") || direction.equals("asc")) {
            pageable = new PageRequest(page, size, Direction.ASC, field);
        } else {
            pageable = new PageRequest(page, size, Direction.DESC, field);
        }

        return voucherService.getVoucherSimulationByVoucherAssignment(assignmentId, country, pageable);
    }

    @ApiOperation(value = "Create voucher assignment")
    @RequestMapping(value = "/assignments", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createVoucherAssignment(@RequestBody final VoucherAssignmentDTO voucherAssignmentDTO) {
        try {
            VoucherAssignmentDTO voucherAssignment = voucherService.createVoucherAssignment(voucherAssignmentDTO);
            return new ResponseDTO(true, voucherAssignment, null);
        } catch (Exception e) {
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
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
                throw new AccessDeniedException("");
            }

            return voucherService.simulateVoucherFast(callId);
        } catch (Exception e) {
            _log.error(e.getMessage(), e);
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Export voucher simulation")
    @RequestMapping(value = "/exportExcel/assignment/{assignmentId}/simulation", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> exportExcelVoucherSimulation(@PathVariable("assignmentId") final Integer assignmentId, @Nullable @RequestParam("country") String country,
                                                          @RequestParam("page") Integer page, @RequestParam("size") Integer size,
                                                          @RequestParam("field") String field, @RequestParam("direction") String direction,
                                                          HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }

            Pageable pageable = new PageRequest(page, Integer.MAX_VALUE);

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
            responseReturn = new ResponseEntity<>(voucherService.exportVoucherSimulation(assignmentId, country, pageable), headers, HttpStatus.OK);
            return responseReturn;
        }catch (AccessDeniedException e){
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'exportVoucherSimulation' operation.", e);
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

    @ApiOperation(value = "READ EXCEL")
    @RequestMapping(value = "/excel/scenario/{indexScenario}/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO readExcelScenario(@PathVariable("indexScenario") final Integer indexScenario, @PathVariable("callId") Integer callId) {
        try {
            scenariosService.readScenarioExcel(indexScenario, callId);
            return new ResponseDTO();
        } catch (Exception e) {
            _log.debug("ERROR reading excel");
        }
        return new ResponseDTO();
    }
}