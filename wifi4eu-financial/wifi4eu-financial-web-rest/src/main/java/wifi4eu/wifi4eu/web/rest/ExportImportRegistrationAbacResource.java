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
import wifi4eu.wifi4eu.service.exportImport.ExportImportRegistrationAbacService;
import wifi4eu.wifi4eu.service.security.UserService;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/exportImport", description = "Export and import registration data")
@RequestMapping("exportImport")
public class ExportImportRegistrationAbacResource {
    @Autowired
    private UserService userService;
    @Autowired
    private ExportImportRegistrationAbacService exportImportRegistrationAbacService;

    private final Logger _log = LoggerFactory.getLogger(ExportImportRegistrationAbacResource.class);


    @ApiOperation(value = "Import Legal Entity File")
    @RequestMapping(value = "/importLEF", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO importLegalEntityF() {
        try {
            _log.info("importLegalEntityF");
            exportImportRegistrationAbacService.importLegalEntityF();
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
    @RequestMapping(value = "/importBC", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO importBudgetaryCommitment() {
        try {
            _log.info("importBudgetaryCommitment");
            exportImportRegistrationAbacService.importBudgetaryCommitment();
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
    @RequestMapping(value = "/exportLEFBCValidate", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO exportLegalEntityFBCValidate() {
        try {
            _log.info("exportLegalEntityFBCValidate");
//            if (userService.getUserByUserContext(UserHolder.getUser()).getType() != 5) {
//                throw new AccessDeniedException("");
//            }
            exportImportRegistrationAbacService.exportLegalEntityFBCValidate();
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            return new ResponseDTO(false, null, new ErrorDTO(0, null));
        } catch (Exception e) {
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

}