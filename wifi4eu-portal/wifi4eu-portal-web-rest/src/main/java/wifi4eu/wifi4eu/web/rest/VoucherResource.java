package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.voucher.VoucherService;
import wifi4eu.wifi4eu.service.voucher.util.ScenariosService;

import java.util.List;

import javax.annotation.Nullable;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/voucher", description = "Application object REST API services")
@RequestMapping("voucher")
public class VoucherResource {
    @Autowired
    VoucherService voucherService;

    @Autowired
    ScenariosService scenariosService;

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
    public ResponseDTO getVoucherSimulationByVoucherAssignment(@PathVariable("assignmentId") final Integer assignmentId, @Nullable @RequestParam("country") String country,
      @RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("field") String field, @RequestParam("direction") String direction) {
        
        Pageable pageable = new PageRequest(page, size);

        if(direction.equals("ASC") || direction.equals("asc")){
          pageable = new PageRequest(page, size, Direction.ASC, field);
        }else{
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
            return voucherService.simulateVoucherFast(callId);
        } catch (Exception e) {
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }


    @ApiOperation(value = "READ EXCEL")
    @RequestMapping(value = "/excel/scenario/{indexScenario}/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO readExcelScenario(@PathVariable("indexScenario") final Integer indexScenario, @PathVariable("callId") Integer callId){
        try{
            scenariosService.readScenarioExcel(indexScenario, callId);
            return new ResponseDTO();
        }catch (Exception e){
            _log.debug("ERROR reading excel");
        }
        return new ResponseDTO();
    }
}