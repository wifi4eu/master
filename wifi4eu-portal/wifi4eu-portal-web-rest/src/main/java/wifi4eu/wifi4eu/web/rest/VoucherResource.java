package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.voucher.VoucherService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/voucher", description = "Application object REST API services")
@RequestMapping("voucher")
public class VoucherResource {
    @Autowired
    VoucherService voucherService;

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
    @RequestMapping(value = "/assignment/{assignmentId}/simulation", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<VoucherSimulationDTO> getVoucherSimulationByVoucherAssignment(@PathVariable("assignmentId") final Integer assignmentId) {
        return voucherService.getVoucherSimulationByVoucherAssignment(assignmentId);
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
    public ResponseDTO simulateVoucherAssignment(@RequestBody final CallDTO callDTO) {
        try {
            voucherService.simulateVoucherAssignment(callDTO);
            return new ResponseDTO(true, null, null);
        } catch (Exception e) {
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }
}