package wifi4eu.wifi4eu.abac.integration.essi;

import com.cryptolog.mss.client.PDFWidgetDescription;
import eu.europa.ec.digit.essi.common.util.ConfigurationProperties;
import eu.europa.ec.digit.essi.services.central.client.ClientConfiguration;
import eu.europa.ec.digit.essi.services.central.client.PadesSigner;
import eu.europa.ec.digit.essi.services.central.client.PdfSignatureField;
import eu.europa.ec.digit.essi.services.central.client.SigningResult;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.User;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.awt.*;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

@Service
public class EssiService {

    private final Logger log = LoggerFactory.getLogger(EssiService.class);

    @Resource(name = "essi-client-config")
    private Properties essiClientConfigProperties;

    private ClientConfiguration essiClientConfiguration;

    @PostConstruct
    public void init() throws Exception {
        log.info("Initializing the ESSI service");

        try {
            ConfigurationProperties configProperties = ConfigurationProperties.fromProperties(essiClientConfigProperties,"EreceiptProperty Files");
            InputStream keyStore = this.getClass().getClassLoader().getResourceAsStream(essiClientConfigProperties.getProperty("scriptUser.keyStoreResourceName"));
            this.essiClientConfiguration = ClientConfiguration.getConfiguration(configProperties, IOUtils.toByteArray(keyStore));
        } catch (Exception e) {
            throw new RuntimeException(String.format("Could not initialize ESSI Legacy Client. Reason %s", e.getMessage()));
        }
    }

    public byte[] signDocument(Document document, User currentUser, User officerAppointed) throws Exception {



        String sinatureDetails = (currentUser.getUserName().equalsIgnoreCase(officerAppointed.getUserName()))
                                    ? String.format("Digitally signed by %s %s\nDN:\nemail=%s\no=European Commission\nDate: %s", currentUser.getLastName(), currentUser.getFirstName(), currentUser.getEmail(), new Date())
                                    : String.format("Digitally signed by %s %s\n on behalf of\n %s %s \nDN:\nemail=%s\no=European Commission\nDate: %s", currentUser.getLastName(), currentUser.getFirstName(), officerAppointed.getLastName(), officerAppointed.getFirstName(), currentUser.getEmail(), new Date());


        PadesSigner psigner = new PadesSigner(essiClientConfiguration);

        PDFWidgetDescription.Text officerNameText = new PDFWidgetDescription.Text(new PDFWidgetDescription.Position(0, -50, 70, 150), String.format("%s\n%s", currentUser.getLastName(), currentUser.getFirstName()));
        officerNameText.setFont(new Font("Arial", Font.BOLD, 15));

        PDFWidgetDescription.Text officerDetailsText = new PDFWidgetDescription.Text(new PDFWidgetDescription.Position(70, -50, 100, 150), sinatureDetails);
        officerDetailsText.setFont(new Font("Verdana", Font.ITALIC, 6));

        PDFWidgetDescription pdfWidgetDescription = new PDFWidgetDescription();
        pdfWidgetDescription.addText(officerNameText);
        pdfWidgetDescription.addText(officerDetailsText);
        pdfWidgetDescription.setPosition(new PDFWidgetDescription.Position(/*x*/320, /*y*/150, /*width*/200, /*height*/100));
        psigner.setPdfSignatureField(new PdfSignatureField(PdfSignatureField.Policy.NEW_IF_NO_EXISTING, /*page*/7, "For the Agency", pdfWidgetDescription));

        SigningResult signingResult = psigner.signWithResult(document.getData());
        byte[] signedDocument = signingResult.getSignature();
        String requestId = signingResult.getRequestId();

        return signedDocument;
    }
}
