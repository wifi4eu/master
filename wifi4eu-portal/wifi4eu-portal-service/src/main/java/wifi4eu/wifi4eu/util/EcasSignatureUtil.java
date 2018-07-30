package wifi4eu.wifi4eu.util;

import com.microsoft.azure.storage.blob.SharedAccessBlobPermissions;
import com.microsoft.azure.storage.blob.SharedAccessBlobPolicy;
import eu.cec.digit.ecas.client.constants.RequestConstant;
import eu.cec.digit.ecas.client.signature.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.azureblobstorage.AzureBlobStorage;
import wifi4eu.wifi4eu.common.azureblobstorage.AzureBlobStorageUtils;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.service.grantAgreement.GrantAgreementService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.EnumSet;

@Service
public class EcasSignatureUtil {

    private final Logger _log = LogManager.getLogger(EcasSignatureUtil.class);

    @Autowired
    UserService userService;

    @Autowired
    AzureBlobStorage azureBlobStorage;

    @Autowired
    AzureBlobStorageUtils azureBlobStorageUtils;

    @Autowired
    GrantAgreementService grantAgreementService;

    @Autowired
    PermissionChecker permissionChecker;

    /**
     * Sample Snippets to interact with the EU Login Signature Service.
     * <p>
     * doWhenSignatureRequired -> Contains the configuration of a transaction request using the UserConfirmationSignatureRequest. Notice the callBackUrlToHds variable that is used to generate the signatureRequest
     * and to compose the final EU Login URL to which the user is redirected (it is added as value of the service query parameter). callBackUrlToHds will contain
     * the URL of the application callback URL that will be invoked automatically from EU Login Signature Page when the user sign effectively the transaction.
     * <p>
     * handleSignature -> Is the callback URL handler. EU Login will redirect to the corresponding URL appending an additional query parameter "signatureId" that needs to be used together with the url value
     * to validate the EU Login Signature to get the Signed Message.
     **/

    public String constructSignatureHDSCallbackUrl(HttpServletRequest request, String documentToBeSigned) {
        String url = userService.getBaseUrl().substring(0, userService.getBaseUrl().indexOf("#"));
        url += "api/signature/handleSignature/" + documentToBeSigned;
        return url;
    }

    /**
     * Buld the url to redirect the user to the ECAS Signature page for the specific Document.
     *
     * @param request
     * @param grantAgreementDTO
     * @return String
     * //* @throws HdsException
     */
    //DocumentBean documentToBeSigned
    public String doWhenSignatureRequired(HttpServletRequest request, GrantAgreementDTO grantAgreementDTO) /*throws HdsException*/ {

        //UserBean userBean = RequestExtractorUtil.getUser(request);
        //_log.info(String.format("Document with HERMES ID %s needs to be signed. Download request ID: %s. Signing user is %s", documentToBeSigned.getHermesDocId(), downloadRequestId, userBean.getEcasId()));


        String callBackUrlToHds = constructSignatureHDSCallbackUrl(request, grantAgreementDTO.getId().toString());
        String description = "Signature of grant agreement"; //String.format(FORM_NOTIF_TEMPLATE, documentToBeSigned.getAresRef(), documentToBeSigned.getCreationFormNotifDate());

        Message msg = new SimpleTextMessage(constructXmlToSign());

        //construct signature for ecas
        UserConfirmationSignatureRequest signatureRequest = new UserConfirmationSignatureRequestImpl.Builder()
                .service(callBackUrlToHds)
                .displayedDescription(description)
                .reason("Signature of grant agreement")
                .message(msg)
                .userCommentPresence(UserCommentPresence.NOT_ALLOWED)
                .build();

        StringBuffer signaturePageUrl = new StringBuffer("");
        try {
            SignatureClient client = new SignatureClient();
            client.configure(request);
            String signatureRequestId = client.getSignatureFactory().getUserConfirmationSignatureService().getSignatureRequestId(signatureRequest);

            //build the url to the ecas server signature page
            signaturePageUrl = new StringBuffer(client.getSignatureFactory().getSignatureConfig().getSignatureUrl());
            signaturePageUrl.append("?");
            signaturePageUrl.append(RequestConstant.SIGNATURE_REQUEST_ID).append("=").append(signatureRequestId);
            signaturePageUrl.append("&").append(RequestConstant.SERVICE).append("=").append(callBackUrlToHds);

        } catch (Exception signitureEx) {
            // _log.warn(String.format("Error when requesting ecas signature for downloadRequestId %s and user %s. Reason %s", downloadRequestId, userBean.getEcasId(), signitureEx.getMessage()));
            throw new AppException("Exception while creating ecas signature " + signitureEx.getMessage());
            //throw new EcasSignatureException("Exception while creating ecas signature " + signitureEx.getMessage());
        }

        _log.info("Redirecting to ECAS signature : " + signaturePageUrl.toString());
        return signaturePageUrl.toString();
    }

    /**
     * Prepares the XML Payload to be signed in ECAS
     **/
    public String constructXmlToSign() {
        StringBuffer buff = new StringBuffer("<grant-agreements-sign-request>");
        buff.append("<grant-agreement><number>123456789</number></grant-agreement>");
        buff.append("<registrationId>");
        buff.append("");
        buff.append("</registrationId>");
        buff.append("<municipalityName>");
        buff.append("");
        buff.append("</municipalityName>");
        buff.append("<documentRegistrationNumber>");
        buff.append("");
        buff.append("</documentRegistrationNumber>");
        buff.append("<creationDateTime>");
        buff.append(new Date().toString());
        buff.append("</creationDateTime>");
        buff.append("</grant-agreements-sign-request>");

        return buff.toString();
    }

    public ByteArrayOutputStream writeSignature(String signatureId, HttpServletRequest request, String hdsDocumentId) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());

        GrantAgreementDTO grantAgreement = grantAgreementService.getGrantAgreementById(Integer.parseInt(hdsDocumentId));

        if(!permissionChecker.checkIfAuthorizedGrantAgreement(grantAgreement.getApplicationId())){
            throw new AccessDeniedException("The user is not authorized to sign grant agreement");
        }

        try {
            grantAgreement.setSignatureId(signatureId);

            String callBackUrlToHds = constructSignatureHDSCallbackUrl(request, hdsDocumentId);

            SignatureClient client = new SignatureClient();
            client.configure(request);

            // get the signed message from ecas
            UserConfirmationMessage signature = client.getSignatureFactory().getUserConfirmationSignatureService().getSignedUserConfirmationMessage(callBackUrlToHds, signatureId);

            // verify the signature (and parse)
            VerifiedUserConfirmationMessage verifiedUserConfirmationMessage = client.getSignatureVerifier().verifySignedUserConfirmationMessage(signature);
            SignatureInfo signatureInfo = verifiedUserConfirmationMessage.getUserConfirmationSignature().getSignatureInfo();

            String signatureProof = verifiedUserConfirmationMessage.getText();

            _log.info("signatureId" + signatureId);
            _log.info("XML" + signatureProof);

            String signString = userDTO.getName() + " " + userDTO.getSurname() + " signed as Legal Representative of the Beneficiary on " + new Date().toString() + "  (transaction id " +
                    "" + signatureId + ")";

            outputStream = grantAgreementService.generateGrantAgreementPdfSigned(grantAgreement, signString);

            byte[] data = outputStream.toByteArray();

            SharedAccessBlobPolicy policy = azureBlobStorageUtils.createSharedAccessPolicy(EnumSet.of(SharedAccessBlobPermissions.READ), 20);

            String downloadURL = azureBlobStorage.getDocumentWithTokenAzureStorage("grant_agreement_" + hdsDocumentId + ".pdf", data, policy);

            grantAgreement.setDocumentLocation(downloadURL);
            grantAgreement.setDateSignature(new Date());
            grantAgreementService.saveGrantAgreementSignature(grantAgreement);

        } catch (Exception ex) {

        }

        return outputStream;
    }

}
