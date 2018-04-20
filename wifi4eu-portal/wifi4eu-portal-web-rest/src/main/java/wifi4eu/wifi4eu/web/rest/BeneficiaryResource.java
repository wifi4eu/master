package wifi4eu.wifi4eu.web.rest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.net.InetAddresses;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.*;
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
                if(!InetAddresses.isInetAddress(ip)){
                    ip = "0:0:0:0:0:0:0:1";
                }
            }
            else{
                ip = request.getRemoteAddr();
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

    @ApiOperation(value = "getBeneficiaryListItem")
    @RequestMapping(value = "/getBeneficiaryListItem", method = RequestMethod.GET)
    @ResponseBody
    public BeneficiaryListItemDTO getBeneficiaryListItem() {
        return new BeneficiaryListItemDTO();
    }

    @ApiOperation(value = "findDgconnBeneficiaresList")
    @RequestMapping(value = "/findDgconnBeneficiaresList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnBeneficiaresList(@RequestParam("offset") final Integer offset, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType) {
        try {
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(beneficiaryService.findDgconnBeneficiaresList(null, offset, count, orderField, orderType));
            res.setXTotalCount(beneficiaryService.getCountDistinctMunicipalities());
            return res;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("can't retrieve beneficiaries", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "findDgconnBeneficiaresListSearchingName")
    @RequestMapping(value = "/findDgconnBeneficiaresListSearchingName", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnBeneficiaresListSearchingName(@RequestParam("name") final String name, @RequestParam("offset") final Integer offset, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType) {
        try {
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(beneficiaryService.findDgconnBeneficiaresList(name, offset, count, orderField, orderType));
            res.setXTotalCount(beneficiaryService.getCountDistinctMunicipalitiesContainingName(name));
            return res;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("can't retrieve beneficiaries", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }
}