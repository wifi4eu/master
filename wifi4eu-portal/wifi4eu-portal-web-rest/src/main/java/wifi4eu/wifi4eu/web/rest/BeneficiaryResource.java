package wifi4eu.wifi4eu.web.rest;

import com.google.common.net.InetAddresses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/beneficiary", description = "Beneficiary object REST API services")
@RequestMapping("beneficiary")
public class BeneficiaryResource {
    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private PermissionChecker permissionChecker;

    private final Logger _log = LoggerFactory.getLogger(BeneficiaryResource.class);


    @ApiOperation(value = "Submit beneficiary registration")
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO submitBeneficiaryRegistration(@RequestBody final BeneficiaryDTO beneficiaryDTO,  HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String forwardedHeaderIp = request.getHeader("X-Forwarded-For");
            String ip = "";
            if (forwardedHeaderIp != null) {
                String[] forwardedListIp = forwardedHeaderIp.split(", ");
                ip = forwardedListIp[0];
                if(!InetAddresses.isInetAddress(ip)){
                    ip = "0:0:0:0:0:0:0:1";
                }
            } else {
                ip = request.getRemoteAddr();
            }
            _log.info("submitBeneficiaryRegistration");
            List<RegistrationDTO> resRegistrations = beneficiaryService.submitBeneficiaryRegistration(beneficiaryDTO, ip);
            return new ResponseDTO(true, resRegistrations, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'submitBeneficiaryRegistration' operation.", e);
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
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
    public ResponseDTO findDgconnBeneficiaresList(@RequestParam("offset") final Integer offset, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType, HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(beneficiaryService.findDgconnBeneficiaresList(null, offset, count, orderField, orderType));
            res.setXTotalCount(beneficiaryService.getCountDistinctMunicipalities());
            return res;
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Access denied on 'findDgconnBeneficiaresList' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("can't retrieve beneficiaries", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "findDgconnBeneficiaresListSearchingName")
    @RequestMapping(value = "/findDgconnBeneficiaresListSearchingName", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnBeneficiaresListSearchingName(@RequestParam("name") final String name, @RequestParam("offset") final Integer offset, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType, HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(beneficiaryService.findDgconnBeneficiaresList(name, offset, count, orderField, orderType));
            res.setXTotalCount(beneficiaryService.getCountDistinctMunicipalitiesContainingName(name));
            return res;
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Access denied on 'findDgconnBeneficiaresListSearchingName' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("can't retrieve beneficiaries", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "exportCSVDGConnBeneficiariesList")
    @RequestMapping(value = "/exportCSVDGConnBeneficiariesList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO exportCSVDGConnBeneficiariesList(HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(beneficiaryService.exportCSVDGConnBeneficiariesList());
            res.setXTotalCount(beneficiaryService.getCountDistinctMunicipalities());
            return res;
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'exportCSVDGConnBeneficiariesList' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @ApiOperation(value = "exportCSVDGConnBeneficiariesListSearchingName")
    @RequestMapping(value = "/exportCSVDGConnBeneficiariesListSearchingName", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO exportCSVDGConnBeneficiariesListSearchingName(@RequestParam("name") final String name, HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(beneficiaryService.exportCSVDGConnBeneficiariesListSearchingName(name));
            res.setXTotalCount(beneficiaryService.getCountDistinctMunicipalitiesContainingName(name));
            return res;
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'exportCSVDGConnBeneficiariesListSearchingName' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @ApiOperation(value = "exportExcelDGConnBeneficiariesList")
    @RequestMapping(value = "/exportExcelDGConnBeneficiariesList", method = RequestMethod.POST, headers = "Accept=application/vnd.ms-excel", produces = "application/vnd.ms-excel")
    @ResponseBody
    public ResponseEntity<byte[]> exportExcelDGConnBeneficiariesList(HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
            String filename = "dgconn-beneficiaries.xls";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            responseReturn = new ResponseEntity<>(beneficiaryService.exportExcelDGConnBeneficiariesList(), headers, HttpStatus.OK);
            return responseReturn;
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'exportExcelDGConnBeneficiariesList' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @ApiOperation(value = "exportExcelDGConnBeneficiariesListSearchingName")
    @RequestMapping(value = "/exportExcelDGConnBeneficiariesListSearchingName", method = RequestMethod.POST, headers = "Accept=application/vnd.ms-excel", produces = "application/vnd.ms-excel")
    @ResponseBody
    public ResponseEntity<byte[]> exportExcelDGConnBeneficiariesListSearchingName(@RequestParam("name") final String name, HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
            String filename = "dgconn-beneficiaries.xls";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            responseReturn = new ResponseEntity<>(beneficiaryService.exportExcelDGConnBeneficiariesListContainingName(name), headers, HttpStatus.OK);
            return responseReturn;
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'exportExcelDGConnBeneficiariesListSearchingName' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }
}