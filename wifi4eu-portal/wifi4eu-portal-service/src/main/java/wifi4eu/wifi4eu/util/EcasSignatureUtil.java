package wifi4eu.wifi4eu.util;

import com.microsoft.azure.storage.blob.SharedAccessBlobPermissions;
import com.microsoft.azure.storage.blob.SharedAccessBlobPolicy;
import eu.cec.digit.ecas.client.constants.RequestConstant;
import eu.cec.digit.ecas.client.signature.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.azureblobstorage.AzureBlobStorage;
import wifi4eu.wifi4eu.common.azureblobstorage.AzureBlobStorageUtils;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.service.grantAgreement.GrantAgreementService;
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

    public String constructSignatureHDSCallbackUrl(HttpServletRequest request, String downloadRequestId, String documentToBeSigned) {
        return "http://localhost:8080/wifi4eu/api/signature/handleSignature/" + downloadRequestId + "/" + documentToBeSigned;
    }

    /**
     * Buld the url to redirect the user to the ECAS Signature page for the specific Document.
     *
     * @param request
     * @param documentToBeSigned
     * @param downloadRequestId
     * @return String
     * //* @throws HdsException
     */
    //DocumentBean documentToBeSigned
    public String doWhenSignatureRequired(HttpServletRequest request, String documentToBeSigned, String downloadRequestId) /*throws HdsException*/ {

        //UserBean userBean = RequestExtractorUtil.getUser(request);
        //_log.info(String.format("Document with HERMES ID %s needs to be signed. Download request ID: %s. Signing user is %s", documentToBeSigned.getHermesDocId(), downloadRequestId, userBean.getEcasId()));


        String callBackUrlToHds = constructSignatureHDSCallbackUrl(request, downloadRequestId, documentToBeSigned.toString());
        String description = "test"; //String.format(FORM_NOTIF_TEMPLATE, documentToBeSigned.getAresRef(), documentToBeSigned.getCreationFormNotifDate());

        Message msg = new SimpleTextMessage(constructXmlToSign());

        //construct signature for ecas
        UserConfirmationSignatureRequest signatureRequest = new UserConfirmationSignatureRequestImpl.Builder()
                .service(callBackUrlToHds)
                .displayedDescription(description)
                .reason("REASON")
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

    public void createDoc() {
//        Document document = new Document();
//        outputStream = new ByteArrayOutputStream();
//        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
//        document.open();
//
//        writer.setPageEmpty(false);
//
//        String docName = "This pdf will show the Grant Agreement of the registration";
//        document.addTitle(docName);
//        document.addSubject(docName);
//
//        document.add(new Paragraph(signString));

//            cb.saveState();
//            ColumnText ct = new ColumnText(writer.getDirectContent());
//            Font font = new Font(BaseFont.createFont());
//            int rectWidth = 80;
//            float maxFontSize = getMaxFontSize(BaseFont.createFont(), "text", rectWidth, 80);
//            font.setSize(maxFontSize);
//            ct.setText(new Phrase(signString, font));
//            ct.setSimpleColumn(10, 10, 10 + rectWidth, 10 + 70);
//            ct.go();
//
//            // draw the rect
//            cb.setColorStroke(BaseColor.BLUE);
//            cb.rectangle(10, 10, rectWidth , 70);
//            cb.stroke();
//            cb.restoreState();

//        document.close();

//            PdfReader reader = new PdfReader("C:\\test_pdf.pdf");
//            PdfDictionary dict = reader.getPageN(2);
//            PdfObject object = dict.getDirectObject(PdfName.CONTENTS);
//            if (object instanceof PRStream) {
//                PRStream stream = (PRStream)object;
//                byte[] data = PdfReader.getStreamBytes(stream);
//                String dd = new String(data);
//                dd = dd.replace("SIGNATURE", "HELLO WORLD");
//                stream.setData(dd.getBytes());
//            }
//            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("C:\\des.p"));
//            stamper.close();
//            reader.close();

//            for (int i=1; i<=reader.getNumberOfPages(); i++){
//
//                // get object for writing over the existing content;
//                // you can also use getUnderContent for writing in the bottom layer
//                PdfContentByte over = stamper.getOverContent(i);
//
//                // write text
//                over.beginText();
//                over.setTextMatrix(107, 740);   // set x,y position (0,0 is at the bottom left)
//                over.showText("I can write at page " + i);  // set text
//                over.endText();
//
//                // draw a red circle
//                over.setRGBColorStroke(0xFF, 0x00, 0x00);
//                over.setLineWidth(5f);
//                over.ellipse(250, 450, 350, 550);
//                over.stroke();
//            }

//
//            for (int i = 1; i <= pages; i++) {
//
//                String textFromPage = PdfTextExtractor.getTextFromPage(reader, i);
//
//                System.out.println(textFromPage);
//            }

//            stamper.close();
//            reader.close();

    }

    public ByteArrayOutputStream writeSignature(String signatureId, HttpServletRequest request, String downloadRequestId, String hdsDocumentId) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
        try {
            String callBackUrlToHds = constructSignatureHDSCallbackUrl(request, downloadRequestId, hdsDocumentId);

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

            GrantAgreementDTO grantAgreement = grantAgreementService.getGrantAgreementById(Integer.parseInt(hdsDocumentId));
            grantAgreement.setSignatureId(signatureId);

            outputStream = grantAgreementService.generateGrantAgreementPdfSigned(grantAgreement, signString);

            byte[] data = outputStream.toByteArray();

            SharedAccessBlobPolicy policy = azureBlobStorageUtils.createSharedAccessPolicy(EnumSet.of(SharedAccessBlobPermissions.READ), 20);

            String downloadURL = azureBlobStorage.getDocumentWithTokenAzureStorage("grant_agreement_" + hdsDocumentId + ".pdf", data, policy);

            grantAgreement.setDocumentLocation(downloadURL);
            grantAgreement.setDateSignature(new Date());
            grantAgreementService.createGrantAgreement(grantAgreement);

//            PdfObject object = dict.getDirectObject(PdfName.CONTENTS);
//            if (object instanceof PRStream) {
//                PRStream stream = (PRStream)object;
//                byte[] data = PdfReader.getStreamBytes(stream);
//                String dd = new String(data);
//                dd = dd.replace("SIGNATURE", "HELLO WORLD");
//                stream.setData(dd.getBytes());
//            }
//            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("C:\\des.p"));
//            stamper.close();
//            reader.close();

        } catch (Exception ex) {

        }

        return outputStream;
    }

}
