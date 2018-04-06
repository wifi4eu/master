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
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.service.exportImport.ExportImportRegistrationDataService;
import wifi4eu.wifi4eu.service.user.UserService;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/exportImport", description = "Export and import registration data")
@RequestMapping("exportImport")
public class ExportImportRegistrationDataResource {
    @Autowired
    private UserService userService;
    @Autowired
    private ExportImportRegistrationDataService exportImportRegistrationDataService;

    private final Logger _log = LoggerFactory.getLogger(ExportImportRegistrationDataResource.class);

    @ApiOperation(value = "Export registration data")
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    //public ResponseDTO exportRegistrationData(@RequestBody HttpServletRequest request) {
        //public ResponseDTO exportRegistrationData(HttpServletRequest response) {
        public ResponseDTO exportRegistrationData() {
        try {
            _log.info("exportRegistrationData");
            if (userService.getUserByUserContext(UserHolder.getUser()).getType() != 5) {
                throw new AccessDeniedException("");
            }
            exportImportRegistrationDataService.exportRegistrationData();
            return new ResponseDTO(true, null, null);
           //Si retorno el excel directamente me lo bajará?
           //return new ResponseDTO(true, excel, null);
        } catch (AccessDeniedException ade) {
            //response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, null));
        } catch (Exception e) {
            //response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }

//        try {
//            _log.info("exportRegistrationData");
//            exportImportRegistrationDataService.exportRegistrationData();
//            return new ResponseDTO(true, null, null);
//            //Si retorno el excel directamente me lo bajará?
//            //return new ResponseDTO(true, excel, null);
//        } catch (Exception e) {
//            if (_log.isErrorEnabled()) {
//                _log.error("Error on 'submitBeneficiaryRegistration' operation.", e);
//            }
//            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
//        }
    }

    @ApiOperation(value = "Import registration data")
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
     //public ResponseDTO importRegistrationData(@RequestBody HttpServletRequest request) {
        //public ResponseDTO importRegistrationData(HttpServletRequest response) {
        public ResponseDTO importRegistrationData() {

        try {
            _log.info("importRegistrationData");
            exportImportRegistrationDataService.importRegistrationData();
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'createMayor' operation.", ade);
            }
            //response.sendError(HttpStatus.FORBIDDEN.value());
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createMayor' operation.", e);
            }
            //response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
//        try {
//            _log.info("importRegistrationData");
//            exportImportRegistrationDataService.importRegistrationData();
//            return new ResponseDTO(true, null, null);
//            //Si retorno el excel directamente me lo bajará?
//            //return new ResponseDTO(true, excel, null);
//        } catch (Exception e) {
//            if (_log.isErrorEnabled()) {
//                _log.error("Error on 'submitBeneficiaryRegistration' operation.", e);
//            }
//            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
//        }
    }

}