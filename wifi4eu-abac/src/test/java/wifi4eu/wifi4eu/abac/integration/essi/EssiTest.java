package wifi4eu.wifi4eu.abac.integration.essi;

import com.cryptolog.mss.client.PDFWidgetDescription;
import eu.europa.ec.digit.essi.common.util.ConfigurationProperties;
import eu.europa.ec.digit.essi.services.central.client.ClientConfiguration;
import eu.europa.ec.digit.essi.services.central.client.PadesSigner;
import eu.europa.ec.digit.essi.services.central.client.PdfSignatureField;
import eu.europa.ec.digit.essi.services.central.client.SigningResult;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
public class EssiTest {

    @Test
    public void testClient() throws Exception {
//        Resource resource = new ClassPathResource("essi-client-config.properties");
//        PersistedProperty essiClientConfigProperties = PropertiesLoaderUtils.loadProperties(resource);
//        ConfigurationProperties configProperties = ConfigurationProperties.fromProperties(essiClientConfigProperties,"EreceiptProperty Files");
//        InputStream keyStore = new FileInputStream("C:\\PGM\\tmp\\WIFI\\ForAndreiAlexandruDigitG1\\certificate\\j92ape7.p12");
//        ClientConfiguration essiClientConfiguration = ClientConfiguration.getConfiguration(configProperties, IOUtils.toByteArray(keyStore));
//
//
//        PadesSigner psigner = new PadesSigner(essiClientConfiguration);
//
//        PDFWidgetDescription.Text officerNameText = new PDFWidgetDescription.Text(new PDFWidgetDescription.Position(0, -50, 70, 150), "ANDREI\nAlexandru");
//        officerNameText.setFont(new Font("Arial", Font.BOLD, 15));
//
//        PDFWidgetDescription.Text officerDetailsText = new PDFWidgetDescription.Text(new PDFWidgetDescription.Position(70, -50, 100, 150), "Digitally signed by ANDREI Alexandru\nDN:\nemail=Alexandru.ANDREI@ext.ec.europa.eu\no=European Commission\nDate: 2018.08.29 13:58:01");
//        officerDetailsText.setFont(new Font("Verdana", Font.ITALIC, 6));
//
//        PDFWidgetDescription pdfWidgetDescription = new PDFWidgetDescription();
//        pdfWidgetDescription.addText(officerNameText);
//        pdfWidgetDescription.addText(officerDetailsText);
//        pdfWidgetDescription.setPosition(new PDFWidgetDescription.Position(/*x*/320, /*y*/150, /*width*/200, /*height*/100));
//        psigner.setPdfSignatureField(new PdfSignatureField(PdfSignatureField.Policy.NEW_IF_NO_EXISTING, /*page*/7, "For the Agency", pdfWidgetDescription));
//
//        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("grant_agreement_signed_example_2018.07.30.pdf");
//        byte[] document = IOUtils.toByteArray(is);
//
//        SigningResult signingResult = psigner.signWithResult(document);
//        byte[] signedDocument = signingResult.getSignature();
//        String requestId = signingResult.getRequestId();
//
//        try (FileOutputStream fos = new FileOutputStream("c://PGM//tmp/WIFI//test_signed1.pdf")) {
//            fos.write(signedDocument);
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }

    }
}
