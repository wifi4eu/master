package wifi4eu.wifi4eu.web.rest;

import com.itextpdf.text.DocumentException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ApplicationAuthorizedPersonDTO;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.application.ApplicationAuthorizedPersonService;
import wifi4eu.wifi4eu.service.grantAgreement.GrantAgreementService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/grantAgreement", description = "Grant Agreement REST API services")
@RequestMapping("grantAgreement")
public class GrantAgreementResource {

    Logger _log = LogManager.getLogger(GrantAgreementResource.class);

    @Autowired
    private UserService userService;

    @Autowired
    GrantAgreementService grantAgreementService;

    @Autowired
    ApplicationAuthorizedPersonService applicationAuthorizedPersonService;

    @Autowired
    PermissionChecker permissionChecker;

    @ApiOperation(value = "Download grant agreement pdf without signature")
    @RequestMapping(value = "/exportExcelBeneficiary", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<byte[]> downloadGrantAgreementPdf(@RequestBody GrantAgreementDTO inputGrantAgreement, HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        try {
            if(!permissionChecker.checkIfAuthorizedGrantAgreement(inputGrantAgreement.getApplicationId())){
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = "grantAgreement_" + inputGrantAgreement.getApplicationId() + "_" + inputGrantAgreement.getDocumentLanguage() + ".pdf";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            ByteArrayOutputStream file = grantAgreementService.generateGrantAgreementDocument(inputGrantAgreement);
            return new ResponseEntity<>(file.toByteArray(), headers, HttpStatus.OK);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to download the grant agreement", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Error downloading grant agreement document", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }

    }

    @ApiOperation(value = "Check if user is authorized to sign grant agreement")
    @RequestMapping(value = "authorized/by/application/{applicationId}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean isUserAuthorizedSignGrantAgreement(@PathVariable("applicationId") Integer applicationId) {
        return permissionChecker.checkIfAuthorizedGrantAgreement(applicationId);
    }

    @ApiOperation(value = "Check if lef import is done")
    @RequestMapping(value = "/isLefImportDone/{registrationId}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean isLefImportDone(@PathVariable("registrationId") Integer registrationId) {
        return grantAgreementService.checkIsLefImportDone(registrationId);
    }

    @ApiOperation(value = "Create grant agreement")
    @RequestMapping(value = "/createGrantAgreement", method = RequestMethod.POST)
    @ResponseBody
    public GrantAgreementDTO createGrantAgreement(@RequestBody GrantAgreementDTO inputGrantAgreement) {
        if(!permissionChecker.checkIfAuthorizedGrantAgreement(inputGrantAgreement.getApplicationId())){
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        return grantAgreementService.createGrantAgreement(inputGrantAgreement);
    }


    @ApiOperation(value = "Get grant agreement by applicationId")
    @RequestMapping(value = "/getGrantAgreementByApplicationId/{applicationId}", method = RequestMethod.GET)
    @ResponseBody
    public GrantAgreementDTO getGrantAgreementByApplicationId(@PathVariable("applicationId") Integer applicationId) {

        if(!permissionChecker.checkIfAuthorizedGrantAgreement(applicationId)){
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }

        GrantAgreementDTO grantAgreementDTO = grantAgreementService.getGrantAgreementByApplicationId(applicationId);
        if(Validator.isNotNull(grantAgreementDTO)){
            grantAgreementDTO.setDocumentLocation(null);
            grantAgreementDTO.setDocumentLocationCounterSigned(null);
        }
        return grantAgreementDTO;
    }

    @ApiOperation(value = "Get grant agreement pdf signed by application id")
    @RequestMapping(value = "/signed/{applicationId}/download", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> downloadGrantAgreementPdfSigned(@PathVariable("applicationId") Integer applicationId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        try {
            if (!permissionChecker.checkIfAuthorizedGrantAgreement(applicationId)) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            GrantAgreementDTO grantAgreementDTO = grantAgreementService.getGrantAgreementByApplicationId(applicationId);
            if(Validator.isNotNull(grantAgreementDTO.getDocumentLocation())){
                throw new AppException("");
            }
            byte[] file = grantAgreementService.downloadGrantAgreementSigned(grantAgreementDTO);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = "grant_agreement_" + applicationId + "_" + grantAgreementDTO.getDocumentLanguage() + "_signed.pdf";
            headers.setContentDispositionFormData("filename", filename);
            return new ResponseEntity<>(file, headers, HttpStatus.OK);
        }
        catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to download the counter signed grant agreement", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Error downloading counter signed grant agreement document", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

    @ApiOperation(value = "Get grant agreement pdf countersigned by application id")
    @RequestMapping(value = "/countersigned/{applicationId}/download", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> downloadGrantAgreementCounterSigned(@PathVariable("applicationId") Integer applicationId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {
            if (!permissionChecker.checkIfAuthorizedGrantAgreement(applicationId)) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            GrantAgreementDTO grantAgreementDTO = grantAgreementService.getGrantAgreementByApplicationId(applicationId);
            if(Validator.isNotNull(grantAgreementDTO.getDocumentLocationCounterSigned())){
                throw new AppException("");
            }
            byte[] file = grantAgreementService.downloadGrantAgreementCounterSigned(grantAgreementDTO);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = "grant_agreement_" + applicationId + "_" + grantAgreementDTO.getDocumentLanguage() + "_signed.pdf";
            headers.setContentDispositionFormData("filename", filename);
            return new ResponseEntity<>(file, headers, HttpStatus.OK);
        }
        catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to download the counter signed grant agreement", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Error downloading counter signed grant agreement document", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }
}