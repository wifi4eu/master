package wifi4eu.wifi4eu.web.rest;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import eu.cec.digit.ecas.client.constants.RequestConstant;
import eu.cec.digit.ecas.client.signature.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wifi4eu.wifi4eu.common.dto.model.ApplicationAuthorizedPersonDTO;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.service.application.ApplicationAuthorizedPersonService;
import wifi4eu.wifi4eu.service.grantAgreement.GrantAgreementService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.EcasSignatureUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/signature", description = "Signature object REST API services")
@RequestMapping("signature")
public class EcasSignatureResource {

    private final Logger _log = LogManager.getLogger(EcasSignatureResource.class);

    @Autowired
    EcasSignatureUtil ecasSignatureUtil;

    @Autowired
    GrantAgreementService grantAgreementService;

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    ApplicationAuthorizedPersonService applicationAuthorizedPersonService;

    @Autowired
    UserService userService;

    @ApiOperation(value = "Sign grant agreement pdf")
    @RequestMapping(value = "/signGrantAgreement", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseDTO signature(@RequestBody GrantAgreementDTO grantAgreementDTO, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        String url = "";
        try {
            GrantAgreementDTO grantAgreement = grantAgreementService.getGrantAgreementById(grantAgreementDTO.getId());

            if(!permissionChecker.checkIfAuthorizedGrantAgreement(grantAgreementDTO.getApplicationId())){
                throw new AccessDeniedException("The user is not authorized to sign grant agreement");
            }

            if (grantAgreement == null) {
                grantAgreement = grantAgreementService.initializeGrantAgreement(grantAgreementDTO);
            }else{
                if(grantAgreement.getDateSignature() != null){
                    throw new AppException("Grant agreement already signed");
                }
            }

            url = ecasSignatureUtil.doWhenSignatureRequired(request, grantAgreement);
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Signature process started");
            return new ResponseDTO(true, url, null);
        }
        catch (AccessDeniedException ade){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to download the grant agreement", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
        catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Error on grant agreement signature", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

    @ApiOperation(value = "Handle callback signature grant agreement")
    @RequestMapping(value = "/handleSignature/{documentId}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public GrantAgreementDTO handleSignature(HttpServletRequest request, @PathVariable(value = "documentId") String grantAgreementId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        String signatureId = request.getParameter("signatureId");

        try {
            GrantAgreementDTO grantAgreement = grantAgreementService.getGrantAgreementById(Integer.parseInt(grantAgreementId));

            if(!permissionChecker.checkIfAuthorizedGrantAgreement(grantAgreement.getApplicationId())){
                throw new AccessDeniedException("The user is not authorized to sign grant agreement");
            }

            GrantAgreementDTO grantAgreementDTO = ecasSignatureUtil.writeSignature(signatureId, request, grantAgreementId, grantAgreement);
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Grant agreement signed successfully");
            String url = userService.getServerSchemes().concat("://").concat(userService.getServerAddress()).concat("/wifi4eu/#/beneficiary-portal/my-voucher/grant-agreement");
            response.sendRedirect(url);
            return grantAgreementDTO;
        } catch (AccessDeniedException ade){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to handle the callback for grant agreement", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Error on callback grant agreement signature", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

}

