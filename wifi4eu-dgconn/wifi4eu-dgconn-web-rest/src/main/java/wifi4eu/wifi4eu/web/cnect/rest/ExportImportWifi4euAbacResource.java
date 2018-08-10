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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.exportImport.ExportImportWifi4euAbacService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/exportImport", description = "Export and import registration data")
@RequestMapping("exportImport")
public class ExportImportWifi4euAbacResource {
    @Autowired
    private UserService userService;
    @Autowired
    private ExportImportWifi4euAbacService exportImportWifi4euAbacService;

    private final Logger _log = LoggerFactory.getLogger(ExportImportWifi4euAbacResource.class);

    @ApiOperation(value = "Import LEF and BC validates")
    @RequestMapping(value = "/importLegalEntityFBCValidate", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO importLegalEntityFBCValidate(final HttpServletResponse response) {
        try {
            _log.info("importLegalEntityFBCValidate");
            return new ResponseDTO(exportImportWifi4euAbacService.importLegalEntityFBCValidate(), null, null);
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

//    @ApiOperation(value = "Import LEF and BC validates")
//    @RequestMapping(value = "/importLegalEntityFBCValidate", method = RequestMethod.POST, produces = "application/JSON")
//    @ResponseBody
//    public ResponseDTO importLegalEntityFBCValidate(@RequestBody final String jsonStringFile, final HttpServletResponse response) {
//        try {
//            _log.info("importLegalEntityFBCValidate");
//            JSONArray jsonArray = new JSONArray(jsonStringFile);
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject object = jsonArray.getJSONObject(i);
//                exportImportWifi4euAbacService.importLegalEntityFBCValidate(object.toString());
//            }
//            return new ResponseDTO(true, null, null);
//        } catch (AccessDeniedException ade) {
//            if (_log.isErrorEnabled()) {
//                _log.error("Error with permission on operation.", ade);
//            }
//            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
//        } catch (Exception e) {
//            if (_log.isErrorEnabled()) {
//                _log.error("Error on operation.", e);
//            }
//            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
//        }
//    }

    @ApiOperation(value = "Export Beneficiary Information")
    @RequestMapping(value = "/exportBeneficiaryInformation", method = RequestMethod.GET, produces = "application/zip")
    @ResponseBody
    public ResponseEntity<byte[]> exportBeneficiaryInformation(final HttpServletResponse response) throws Exception {
        _log.info("exportBeneficiaryInformation");
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {
            if (Validator.isNull(userConnected) || userConnected.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            // WIFIFOREU-2498 JSON -> CSV
            ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/zip"));

            String filename = "exportBeneficiaryInformation.zip";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            _log.info("exportBeneficiaryInformation - generating zip file content");
            ByteArrayOutputStream file = exportImportWifi4euAbacService.exportBeneficiaryInformation();
            responseReturn = new ResponseEntity<>(file.toByteArray(), headers, HttpStatus.OK);

            _log.info("exportBeneficiaryInformation - csv file exported successfully");
            return responseReturn;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to export beneficiary information", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The exportBeneficiaryInformation cannot be executed", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

    @ApiOperation(value = "Export registration data")
    @RequestMapping(value = "/exportRegistrationData", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO exportRegistrationData() {
        try {
            _log.info("exportRegistrationData");
            if (userService.getUserByUserContext(UserHolder.getUser()).getType() != 5) {
                throw new AccessDeniedException("");
            }
            exportImportWifi4euAbacService.exportRegistrationData();
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            return new ResponseDTO(false, null, new ErrorDTO(0, null));
        } catch (Exception e) {
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Import registration data")
    @RequestMapping(value = "/importRegistrationData", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO importRegistrationData() {
        try {
            _log.info("importRegistrationData");
            exportImportWifi4euAbacService.importRegistrationData();
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


    @ApiOperation(value = "Export Budgetary Commitment")
    @RequestMapping(value = "/exportBudgetaryCommitment", method = RequestMethod.GET, produces = "text/csv")
    @ResponseBody
    public ResponseEntity<byte[]> exportBudgetaryCommitment(final HttpServletResponse response) throws Exception {
        _log.info("exportBudgetaryCommitment");
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {
            if (Validator.isNull(userConnected) || userConnected.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            // WIFIFOREU-2498 JSON -> CSV
            ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("text/csv"));
            String filename = "exportBudgetaryCommitment.csv";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            _log.info("exportBudgetaryCommitment - generating csv file content");
            String responseData = exportImportWifi4euAbacService.exportBudgetaryCommitment().getData().toString();
            // getBytes(Charset.forName("UTF-8"));
            responseReturn = new ResponseEntity<>(responseData.getBytes(), headers, HttpStatus.OK);

            _log.info("exportBudgetaryCommitment - csv file exported successfully");
            return responseReturn;
        }  catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to export budgetary commitment", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The exportBudgetaryCommitment cannot be executed", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }
}