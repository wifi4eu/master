package wifi4eu.wifi4eu.web.rest;

import com.itextpdf.text.DocumentException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.grantAgreement.GrantAgreementService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/grantAgreement", description = "Grant Agreement REST API services")
@RequestMapping("grantAgreement")
public class GrantAgreementResource {
    @Autowired
    private UserService userService;

    @Autowired
    GrantAgreementService grantAgreementService;

    @ApiOperation(value = "Confirm or request revision of installation report")
    @RequestMapping(value = "/exportExcelBeneficiary", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<byte[]> downloadGrantAgreementPdf(@RequestBody GrantAgreementDTO inputGrantAgreement, HttpServletRequest request) throws IOException, DocumentException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        if (userConnected == null || userConnected.getType() == 1) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "grantAgreementPdf_" + inputGrantAgreement.getDocumentLanguage() + ".pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ByteArrayOutputStream file = grantAgreementService.generateGrantAgreementPdf(inputGrantAgreement);
        return new ResponseEntity<>(file.toByteArray(), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Create grant agreement")
    @RequestMapping(value = "/createGrantAgreement", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public GrantAgreementDTO createGrantAgreement(@RequestBody GrantAgreementDTO inputGrantAgreement) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        if (userConnected == null || userConnected.getType() == 1 || userConnected.getType() == 5) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }

        return grantAgreementService.createGrantAgreement(inputGrantAgreement);
    }


}