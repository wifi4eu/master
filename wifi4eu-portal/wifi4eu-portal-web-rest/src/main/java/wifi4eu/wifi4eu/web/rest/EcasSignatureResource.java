package wifi4eu.wifi4eu.web.rest;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import eu.cec.digit.ecas.client.constants.RequestConstant;
import eu.cec.digit.ecas.client.signature.*;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping(value = "/v2/sign/{applicationId}", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<byte[]>  signature2(@PathVariable("applicationId") Integer applicationId, HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = "grantAgreementPdf.pdf";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            GrantAgreement grantAgreement = grantAgreementService.getGrantAgreementByApplicationId(applicationId);
            if(grantAgreement == null){
                grantAgreement = grantAgreementService.initializeGrantAgreement(applicationId);
            }
            return new ResponseEntity<>(grantAgreementService.generateGrantAgreementPdf(applicationId, grantAgreement).toByteArray(), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/sign/{applicationId}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView signature(@PathVariable("applicationId") Integer applicationId, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = null;
        try {

            GrantAgreement grantAgreement = grantAgreementService.getGrantAgreementByApplicationId(applicationId);

            if(grantAgreement == null){
                grantAgreement = grantAgreementService.initializeGrantAgreement(applicationId);
            }

            response.sendRedirect(ecasSignatureUtil.doWhenSignatureRequired(request, grantAgreement.getId().toString(), "3312dad"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping(value = "/handleSignature/{downloadRequestId}/{documentId}", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<byte[]> handleSignature(HttpServletRequest request, @PathVariable(value = "downloadRequestId") String downloadRequestId, @PathVariable(value = "documentId") String hdsDocumentId, HttpServletResponse response) throws IOException {
        ModelAndView mav = null;
        String signatureId = request.getParameter("signatureId");

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = "grantAgreementPdf.pdf";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            return new ResponseEntity<>(ecasSignatureUtil.writeSignature(signatureId, request, downloadRequestId, hdsDocumentId).toByteArray(), headers, HttpStatus.OK);

            //mav = new ModelAndView("redirect:" + userService.getBaseUrl());
        }
        catch (Exception ex){

        }

        return null;
    }

//    /**
//     * This is the callback handler called by the ECAS signature page if the user effectively signed the document.
//     * <p>
//     * <p>This method update the DocumentAccess entry in HDS database with the signature result and calls IAM to update the signing date on the corresponding Formal Notification.
//     *
//     * @param request
//     * @param downloadRequestId
//     * @param hdsDocumentId
//     * @return
//     */
//    @RequestMapping(value = "/handleSignature/{downloadRequestId}/{documentId}", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView handleSignature(HttpServletRequest request, @PathVariable(value = "downloadRequestId") String downloadRequestId, @PathVariable(value = "documentId") String hdsDocumentId) {
//        UserBean user = RequestExtractorUtil.getUser(request);
//        String signatureId = request.getParameter("signatureId");
//
//        _log.info(String.format("Handle signature for request %s in document %s and user %s", downloadRequestId, hdsDocumentId, user.getEcasId()));
//
//        ModelAndView mav = null;
//        ErrorMessageBean errorBean = null;
//        DownloadRequestBean requestBean = null;
//
//        try {
//            String callBackUrlToHds = RequestExtractorUtil.constructSignatureHDSCallbackUrl(request, downloadRequestId, hdsDocumentId);
//
//            requestBean = hdsDownloadRequestService.findDownloadRequestById(Long.valueOf(downloadRequestId));
//            SignatureClient client = new SignatureClient();
//            client.configure(request);
//
//            // get the signed message from ecas
//            UserConfirmationMessage signature = client.getSignatureFactory().getUserConfirmationSignatureService().getSignedUserConfirmationMessage(callBackUrlToHds, signatureId);
//
//            // verify the signature (and parse)
//            VerifiedUserConfirmationMessage verifiedUserConfirmationMessage = client.getSignatureVerifier().verifySignedUserConfirmationMessage(signature);
//            SignatureInfo signatureInfo = verifiedUserConfirmationMessage.getUserConfirmationSignature().getSignatureInfo();
//
//            // store the signature returned from ecas and call IAM to update the signature date
//            DocumentBean docBean = hdsDownloadRequestService.findDocumentById(Long.valueOf(hdsDocumentId));
//            docBean.setSignatureId(signatureId);
//            docBean.setSignatureProof(verifiedUserConfirmationMessage.getText());
//            hdsDownloadRequestService.updateSignatureForDocumentInRequestId(docBean, user.getEcasId());
//
//            String url = RequestExtractorUtil.constructBaseUrl(request) + "/download/" + EncrypterUtils.EncrypteEncodeId(downloadRequestId);
//            mav = new ModelAndView("redirect:" + url);
//        } catch (Exception ex) {
//            _log.error(String.format("Generic Error handling ecas signature. Reason %s", ex.getMessage()));
//            errorBean = hdsDownloadRequestService.transformException(ex);
//            mav = getErrorView(
//                    "error",
//                    null,
//                    getViewObject("errorBean", errorBean),
//                    getViewObject("documentIds", hdsDocumentId));
//        } finally {
//            updateRequestWithErrorCode(requestBean, errorBean);
//        }
//        return mav;
//    }
}

