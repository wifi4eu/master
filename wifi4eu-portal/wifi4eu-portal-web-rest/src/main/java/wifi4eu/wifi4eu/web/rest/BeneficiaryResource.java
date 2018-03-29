package wifi4eu.wifi4eu.web.rest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryListDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/beneficiary", description = "Beneficiary object REST API services")
@RequestMapping("beneficiary")
public class BeneficiaryResource {
    @Autowired
    private BeneficiaryService beneficiaryService;

    private final Logger _log = LoggerFactory.getLogger(BeneficiaryResource.class);


    @ApiOperation(value = "Submit beneficiary registration")
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO submitBeneficiaryRegistration(@RequestBody final BeneficiaryDTO beneficiaryDTO,  HttpServletRequest request) {
        try {
            String forwardedHeaderIp = request.getHeader("X-Forwarded-For");
            String ip = "";
            if(forwardedHeaderIp != null) {
                String[] forwardedListIp = forwardedHeaderIp.split(", ");
                ip = forwardedListIp[0];
            }
            _log.info("submitBeneficiaryRegistration");
            List<RegistrationDTO> resRegistrations = beneficiaryService.submitBeneficiaryRegistration(beneficiaryDTO, ip);
            return new ResponseDTO(true, resRegistrations, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'submitBeneficiaryRegistration' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get issue type of beneficiary registrations")
    @RequestMapping(value = "/beneficiary/issue", method = RequestMethod.POST, consumes = {"application/json"})
    @ResponseBody
    public ResponseDTO getIssueTypeBeneficiaryRegistrations(@RequestBody final String jsonString) {
        try {
            Gson g = new Gson();
            RegistrationDTO[] registrationsArray = g.fromJson(jsonString, RegistrationDTO[].class);
            List<RegistrationDTO> registrationList = new ArrayList<>(Arrays.asList(registrationsArray));
            _log.info("getIssueTypeBeneficiaryRegistrations");
            return new ResponseDTO(true, beneficiaryService.getIssueType(registrationList), null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getIssueTypeBeneficiaryRegistrations' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Submit beneficiary registration")
    @RequestMapping(value = "/beneficiary-dto", method = RequestMethod.GET)
    @ResponseBody
    public BeneficiaryListDTO getBeneficiaryListDTO() {
        return new BeneficiaryListDTO();
    }

    @ApiOperation(value = "Get beneficiary registration with lau")
    @RequestMapping(value = "/beneficiary-list", method = RequestMethod.GET)
    @ResponseBody
    public List<BeneficiaryListDTO> getBeneficiaryRegistrations() {
        return beneficiaryService.getListBeneficiaryTable();
    }

}