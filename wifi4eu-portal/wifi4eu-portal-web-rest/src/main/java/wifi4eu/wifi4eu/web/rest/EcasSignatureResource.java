package wifi4eu.wifi4eu.web.rest;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import eu.cec.digit.ecas.client.constants.RequestConstant;
import eu.cec.digit.ecas.client.signature.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.service.grantAgreement.GrantAgreementService;
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
    UserService userService;

    @ApiOperation(value = "Sign grant agreement pdf")
    @RequestMapping(value = "/signGrantAgreement", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ModelAndView signature(@RequestBody GrantAgreementDTO grantAgreementDTO, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = null;
        try {
            GrantAgreementDTO grantAgreement = grantAgreementService.getGrantAgreementById(grantAgreementDTO.getId());

            if (grantAgreement == null) {
                grantAgreement = grantAgreementService.initializeGrantAgreement(grantAgreementDTO);
            }

            response.sendRedirect(ecasSignatureUtil.doWhenSignatureRequired(request, grantAgreement.getId().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mav;
    }

    @ApiOperation(value = "Handle callback signature grant agreement")
    @RequestMapping(value = "/handleSignature/{documentId}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<byte[]> handleSignature(HttpServletRequest request, @PathVariable(value = "documentId") String hdsDocumentId, HttpServletResponse response) throws IOException {
        ModelAndView mav = null;
        String signatureId = request.getParameter("signatureId");

        try {

            HttpHeaders headers = new HttpHeaders();
            //headers.setContentType(MediaType.parseMediaType("application/pdf"));
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = "grantAgreementPdf.pdf";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            return new ResponseEntity<>(ecasSignatureUtil.writeSignature(signatureId, request, hdsDocumentId).toByteArray(), headers, HttpStatus.OK);

            //mav = new ModelAndView("redirect:" + userService.getBaseUrl());
        } catch (Exception ex) {

        }

        return null;
    }

}

