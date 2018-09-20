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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.exportImport.ExportImportWifi4euAbacService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.ByteArrayOutputStream;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/exportImport", description = "Export and import registration data")
@RequestMapping("exportImport")
public class ExportImportWifi4euAbacResource {

    private final Logger _log = LoggerFactory.getLogger(ExportImportWifi4euAbacResource.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ExportImportWifi4euAbacService exportImportWifi4euAbacService;


    @RequestMapping(value = "/importLegalEntityFBCValidate", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO importLegalEntityFBCValidate(@Validated @NotNull @RequestParam("importFile") MultipartFile file) {
        try {
            _log.debug("importLegalEntityFBCValidate: file size = {}", file.getSize());

            boolean success = exportImportWifi4euAbacService.importLegalEntityFBCValidate(file.getInputStream());

            _log.debug("Import of the LEF result: {}", success);

            return new ResponseDTO(success, null, null);
        } catch (AccessDeniedException ade) {
            _log.error("Error with permission on operation.", ade);
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            _log.error("Error on operation.", e);
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }

    @RequestMapping(value = "/importBudgetaryCommitment", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO importBudgetaryCommitment(@Validated @NotNull @RequestParam("importFile") MultipartFile file) {
        _log.debug("importBudgetaryCommitment: file size = {}", file.getSize());

        return new ResponseDTO(true);
    }

    @RequestMapping(value = "/importLegalCommitment", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO importLegalCommitment(@Validated @NotNull @RequestParam("importFile") MultipartFile file) {
        _log.debug("importLegalCommitment: file size = {}", file.getSize());

        return new ResponseDTO(true);
    }

    @ApiOperation(value = "Export Beneficiary Information")
    @RequestMapping(value = "/exportBeneficiaryInformation", method = RequestMethod.GET, produces = "application/zip")
    @ResponseBody
    public ResponseEntity<byte[]> exportBeneficiaryInformation(final HttpServletResponse response) throws Exception {
        _log.debug("exportBeneficiaryInformation");
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {
            if (Validator.isNull(userConnected) || userConnected.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/zip"));

            String filename = "exportBeneficiaryInformation.zip";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            _log.debug("exportBeneficiaryInformation - generating zip file content");
            ByteArrayOutputStream file = exportImportWifi4euAbacService.exportBeneficiaryInformation();
            ResponseEntity<byte[]> responseReturn = new ResponseEntity<>(file.toByteArray(), headers, HttpStatus.OK);

            _log.info("exportBeneficiaryInformation - csv file exported successfully");
            return responseReturn;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to export beneficiary information", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The exportBeneficiaryInformation cannot be executed", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
        }
        return null;
    }

    @ApiOperation(value = "Export Budgetary Commitment")
    @RequestMapping(value = "/exportBudgetaryCommitment", method = RequestMethod.GET, produces = "text/csv")
    @ResponseBody
    public ResponseEntity<byte[]> exportBudgetaryCommitment(final HttpServletResponse response) throws Exception {
        _log.debug("exportBudgetaryCommitment");
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {
            if (Validator.isNull(userConnected) || userConnected.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("text/csv"));
            String filename = "exportBudgetaryCommitment.csv";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            _log.info("exportBudgetaryCommitment - generating csv file content");
            String responseData = exportImportWifi4euAbacService.exportBudgetaryCommitment().getData().toString();
            // getBytes(Charset.forName("UTF-8"));
            ResponseEntity<byte[]> responseReturn = new ResponseEntity<>(responseData.getBytes(), headers, HttpStatus.OK);

            _log.info("exportBudgetaryCommitment - csv file exported successfully");
            return responseReturn;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to export budgetary commitment", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The exportBudgetaryCommitment cannot be executed", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
        }
        return null;
    }

    @ApiOperation(value = "Export Beneficiary Information")
    @RequestMapping(value = "/exportLegalCommitment", method = RequestMethod.GET, produces = "application/zip")
    @ResponseBody
    public ResponseEntity<byte[]> exportLegalCommitment(final HttpServletResponse response) throws Exception {
        _log.debug("exportLegalCommitment");
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {
            if (Validator.isNull(userConnected) || userConnected.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/zip"));

            String filename = "exportLegalCommitment.zip";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            _log.debug("exportLegalCommitment - generating zip file content");
            ByteArrayOutputStream file = exportImportWifi4euAbacService.exportLegalCommitment();
            ResponseEntity<byte[]> responseReturn = new ResponseEntity<>(file.toByteArray(), headers, HttpStatus.OK);

            _log.info("exportLegalCommitmentInformation - csv file exported successfully");
            return responseReturn;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to export legal commitment", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The exportLegalCommitment cannot be executed", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
        }
        return null;
    }

    @Deprecated
    @ApiOperation(value = "Export registration data")
    @RequestMapping(value = "/exportRegistrationData", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO exportRegistrationData() {
        try {
            _log.debug("exportRegistrationData");

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

    @Deprecated
    @ApiOperation(value = "Import registration data")
    @RequestMapping(value = "/importRegistrationData", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO importRegistrationData() {
        try {
            _log.debug("importRegistrationData");

            exportImportWifi4euAbacService.importRegistrationData();

            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            _log.error("Error with permission on operation.", ade);
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            _log.error("Error on operation.", e);
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }
}