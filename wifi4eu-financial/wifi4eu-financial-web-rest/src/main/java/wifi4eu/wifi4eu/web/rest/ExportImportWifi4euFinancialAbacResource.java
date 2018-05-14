package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.exportImport.ExportImportWifi4euFinancialAbacService;
import wifi4eu.wifi4eu.service.security.UserService;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/exportImport", description = "Export and import registration data")
@RequestMapping("exportImport")
public class ExportImportWifi4euFinancialAbacResource {
    @Autowired
    private UserService userService;
    @Autowired
    private ExportImportWifi4euFinancialAbacService exportImportWifi4euFinancialAbacService;

    private final Logger _log = LoggerFactory.getLogger(ExportImportWifi4euFinancialAbacResource.class);


    @ApiOperation(value = "Import Legal Entity File")
    @RequestMapping(value = "/importLegalEntityF", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO importLegalEntityF() {
        try {
            _log.info("importLegalEntityF");
            exportImportWifi4euFinancialAbacService.importLegalEntityF();
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on operation.", ade);
            }
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }

    @ApiOperation(value = "Import Budgetary Commitment")
    @RequestMapping(value = "/importBudgetaryCommitment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO importBudgetaryCommitment() {
        try {
            _log.info("importBudgetaryCommitment");
            exportImportWifi4euFinancialAbacService.importBudgetaryCommitment();
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on operation.", ade);
            }
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }

    @ApiOperation(value = "Export LEF and BC Validates")
    @RequestMapping(value = "/exportLegalEntityFBCValidate", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO exportLegalEntityFBCValidate() {
        try {
            _log.info("exportLegalEntityFBCValidate");
//            if (userService.getUserByUserContext(UserHolder.getUser()).getType() != 5) {
//                throw new AccessDeniedException("");
//            }
            exportImportWifi4euFinancialAbacService.exportLegalEntityFBCValidate();
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            return new ResponseDTO(false, null, new ErrorDTO(0, null));
        } catch (Exception e) {
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

}