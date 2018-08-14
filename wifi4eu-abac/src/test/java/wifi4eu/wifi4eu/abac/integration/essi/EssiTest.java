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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
public class EssiTest {

    @Test
    public void testClient() throws Exception {
        Resource resource = new ClassPathResource("essi-client-config.properties");
        Properties essiClientConfigProperties = PropertiesLoaderUtils.loadProperties(resource);
        ConfigurationProperties configProperties = ConfigurationProperties.fromProperties(essiClientConfigProperties,"EreceiptProperty Files");
        InputStream keyStore = new FileInputStream("C:\\PGM\\tmp\\WIFI\\ForAndreiAlexandruDigitG1\\certificate\\j92ape7.p12");
        ClientConfiguration essiClientConfiguration = ClientConfiguration.getConfiguration(configProperties, IOUtils.toByteArray(keyStore));


        PadesSigner psigner = new PadesSigner(essiClientConfiguration);
        PDFWidgetDescription pdfWidgetDescription = new PDFWidgetDescription();
        PDFWidgetDescription.Text text = new PDFWidgetDescription.Text(new PDFWidgetDescription.Position(100, 100), "Visible signature test");
        pdfWidgetDescription.addText(text);
        pdfWidgetDescription.setPosition(new PDFWidgetDescription.Position(/*x*/50, /*y*/50, /*width*/200, /*height*/100));
        psigner.setPdfSignatureField(new PdfSignatureField(PdfSignatureField.Policy.NEW_IF_NO_EXISTING, /*page*/7, "For the Agency", pdfWidgetDescription));

        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("grant_agreement_signed_example_2018.07.30.pdf");
        byte[] document = IOUtils.toByteArray(is);

        SigningResult signingResult = psigner.signWithResult(document);
        byte[] signedDocument = signingResult.getSignature();
        String requestId = signingResult.getRequestId();

        try (FileOutputStream fos = new FileOutputStream("c://PGM//tmp/WIFI//test_signed1.pdf")) {
            fos.write(signedDocument);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
