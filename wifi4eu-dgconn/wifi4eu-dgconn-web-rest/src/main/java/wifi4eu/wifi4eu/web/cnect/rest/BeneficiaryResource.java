package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;
import wifi4eu.wifi4eu.service.grantAgreement.GrantAgreementService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.web.authorisation.DashboardUsersOnly;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/beneficiary", description = "Beneficiary object REST API services")
@RequestMapping("beneficiary")
public class BeneficiaryResource {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private UserService userService;

    @Autowired
    private GrantAgreementService grantAgreementService;

    private static final Logger _log = LoggerFactory.getLogger(BeneficiaryResource.class);

    @ApiOperation(value = "getBeneficiaryListItem")
    @RequestMapping(value = "/getBeneficiaryListItem", method = RequestMethod.GET)
    @ResponseBody
    public BeneficiaryListItemDTO getBeneficiaryListItem() {
        return new BeneficiaryListItemDTO();
    }

    @ApiOperation(value = "findDgconnBeneficiaresList")
    @RequestMapping(value = "/findDgconnBeneficiaresList", method = RequestMethod.POST)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO findDgconnBeneficiaresList(@RequestParam("offset") final Integer offset, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting DGConn beneficiaries by offset " + offset + ", count" + count + ", order field" + orderField + " and order type " + orderType);
        try {
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(beneficiaryService.findDgconnBeneficiaresList(null, offset, count, orderField, orderType));
            res.setXTotalCount(beneficiaryService.getCountDistinctMunicipalities());
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- DGConn Beneficiaries retrieved successfully");
            return res;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- DGConn Beneficiaries cannot been retrieved", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "findDgconnBeneficiaresListSearchingName")
    @RequestMapping(value = "/findDgconnBeneficiaresListSearchingName", method = RequestMethod.POST)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO findDgconnBeneficiaresListSearchingName(@RequestParam("name") final String name, @RequestParam("offset") final Integer offset, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting DGConn beneficiaries by searching name " + name + ",offset " + offset + ", count" + count + ", order field" + orderField + " and order type " + orderType);
        try {
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(beneficiaryService.findDgconnBeneficiaresList(name, offset, count, orderField, orderType));
            res.setXTotalCount(beneficiaryService.getCountDistinctMunicipalitiesContainingName(name));
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- DGConn Beneficiaries retrieved successfully");
            return res;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- DGConn Beneficiaries cannot been retrieved", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "exportCSVDGConnBeneficiariesList")
    @RequestMapping(value = "/exportCSVDGConnBeneficiariesList", method = RequestMethod.POST)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO exportCSVDGConnBeneficiariesList() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Exporting CSV from DGConn beneficiaries");

        ResponseDTO res = new ResponseDTO(true, null, null);
        res.setData(beneficiaryService.exportCSVDGConnBeneficiariesList());
        res.setXTotalCount(beneficiaryService.getCountDistinctMunicipalities());
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- CSV exported successfully");
        return res;
    }

    @ApiOperation(value = "exportCSVDGConnBeneficiariesListSearchingName")
    @RequestMapping(value = "/exportCSVDGConnBeneficiariesListSearchingName", method = RequestMethod.POST)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO exportCSVDGConnBeneficiariesListSearchingName(@RequestParam("name") final String name) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Exporting CSV from DGConn beneficiaries by searching name " + name);

        ResponseDTO res = new ResponseDTO(true, null, null);
        res.setData(beneficiaryService.exportCSVDGConnBeneficiariesListSearchingName(name));
        res.setXTotalCount(beneficiaryService.getCountDistinctMunicipalitiesContainingName(name));
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- CSV exported successfully");
        return res;
    }

    @ApiOperation(value = "exportExcelDGConnBeneficiariesList")
    @RequestMapping(value = "/exportExcelDGConnBeneficiariesList", method = RequestMethod.POST, headers = "Accept=application/vnd.ms-excel", produces = "application/vnd.ms-excel")
    @ResponseBody
    @DashboardUsersOnly
    public ResponseEntity<byte[]> exportExcelDGConnBeneficiariesList() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Exporting Excel from DGConn beneficiaries");

        ResponseEntity<byte[]> responseReturn = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        String filename = "dgconn-beneficiaries.xls";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        responseReturn = new ResponseEntity<>(beneficiaryService.exportExcelDGConnBeneficiariesList(), headers, HttpStatus.OK);
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Excel exported successfully");
        return responseReturn;
    }

    @ApiOperation(value = "exportExcelDGConnBeneficiariesListSearchingName")
    @RequestMapping(value = "/exportExcelDGConnBeneficiariesListSearchingName", method = RequestMethod.POST, headers = "Accept=application/vnd.ms-excel", produces = "application/vnd.ms-excel")
    @ResponseBody
    @DashboardUsersOnly
    public ResponseEntity<byte[]> exportExcelDGConnBeneficiariesListSearchingName(@RequestParam("name") final String name) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Exporting Excel from DGConn beneficiaries by searching name" + name);

        ResponseEntity<byte[]> responseReturn = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        String filename = "dgconn-beneficiaries.xls";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        responseReturn = new ResponseEntity<>(beneficiaryService.exportExcelDGConnBeneficiariesListContainingName(name), headers, HttpStatus.OK);
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Excel exported successfully");
        return responseReturn;
    }

    @ApiOperation(value = "Get beneficiaries from final list by call")
    @RequestMapping(value = "/finalBeneficiaries/call/{callId}", method = RequestMethod.GET)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO getBeneficiariesFromFinalList(@PathVariable("callId") final Integer callId,
                                                     @RequestParam("countryCode") final String countryCode,
                                                     @RequestParam("municipality") final String municipality,
                                                     @RequestParam("page") final Integer page,
                                                     @RequestParam("size") final Integer size,
                                                     @RequestParam("field") final String field,
                                                     @RequestParam("sortDirection") final String sortDirection) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO responseDTO = beneficiaryService.findBeneficiariesFromFinalList(callId, countryCode, municipality, page, size, field, sortDirection);
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Beneficiaries from final list retrieved successfully");
        return responseDTO;
    }

    @ApiOperation(value = "Download PDF grant agreement by beneficiaryId")
    @RequestMapping(value = "exportBeneficiaryPdfGrantAgreement", method = RequestMethod.GET)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseEntity<byte[]> exportBeneficiaryPdfGrantAgreement(@RequestParam("registrationId") final Integer registrationId, @RequestParam("callId") Integer callId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "grantAgreementPdf.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        GrantAgreementDTO grantAgreementDTO = grantAgreementService.getGrantAgreementByCallAndRegistrationId(registrationId, callId);
        byte[] file = grantAgreementService.downloadGrantAgreementSigned(grantAgreementDTO);
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - PDF Grant Agreement generated correctly");
        return new ResponseEntity<>(file, headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Cancel beneficiary by registration ID")
    @RequestMapping(value = "cancel/registration/{registrationId}", method = RequestMethod.GET)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO cancelBeneficiaryFromRegistrationId(@PathVariable("registrationId") final Integer registrationId, @RequestParam("reason") final String reason, @RequestParam("callId") final Integer callId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO responseDTO = beneficiaryService.cancelBeneficiaryFromRegistrationId(registrationId, reason, callId);
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Beneficiary cancelled correctly");
        return responseDTO;
    }

}