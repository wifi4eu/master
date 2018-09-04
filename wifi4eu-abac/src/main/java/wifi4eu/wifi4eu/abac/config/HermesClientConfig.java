package wifi4eu.wifi4eu.abac.config;

import eu.cec.digit.ecas.client.script.ScriptClient;
import eu.europa.ec.digit.essi.services.central.client.impl.ScriptClientConfigurationHelper;
import generated.hrs.ws.DocumentService;
import generated.hrs.ws.DocumentWebService;
import generated.hrs.ws.FilingPlanService;
import generated.hrs.ws.FilingPlanWebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wifi4eu.wifi4eu.abac.integration.EcasProxyTicketClient;
import wifi4eu.wifi4eu.abac.integration.eris.ErisLogMessageHandler;
import wifi4eu.wifi4eu.abac.integration.hrs.HermesClientSOAPHandler;
import wifi4eu.wifi4eu.abac.integration.hrs.HermesDocumentServiceClient;
import wifi4eu.wifi4eu.abac.integration.hrs.HrsHTTpClient;

import javax.xml.namespace.QName;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class HermesClientConfig {

    private final Logger log = LoggerFactory.getLogger(HermesClientConfig.class);
    public static final int CONNECT_TIMEOUT_MILLIS = 15000;
    public static final int MAX_CONNECTIONS = 2;
    public static final int READ_TIMEOUT_MILLIS = 15000;


    @Value("classpath:/integration/HRS_1.28/DocumentWebServicePS.wsdl")
    private URL documentServiceWSDL;

    @Value("classpath:/integration/HRS_1.28/FilingPlanWebServicePS_1.wsdl")
    private URL filingPlanServiceWSDL;

    @Value("${pdm.integration.hrs.ws.document.endpoint}")
    private String documentServiceEndPoint;

    @Value("${pdm.integration.hrs.ws.filing.endpoint}")
    private String filingPlanServiceEndPoint;

    @Value("${pdm.integration.hrs.ecas.cert.login.service.keyStore.file}")
    String ecasKeyStoreFileName;

    @Value("${pdm.integration.hrs.ecas.cert.login.service.keyStore.password}")
    String ecasKeyStorePassword;

    @Value("${pdm.integration.hrs.ecas.cert.login.service.keyStoreType}")
    String keyStoreType;

    @Value("${pdm.integration.hrs.ecas.cert.login.service.keyStoreProvider}")
    String keyStoreProvider;

    @Value("${pdm.integration.hrs.ecas.cert.login.service.privateKeyAlias}")
    String ecasKeyAlias;

    @Value("${pdm.integration.hrs.ecas.cert.login.service.url}")
    String ecasServerCertLoginUrl;

    @Value("${pdm.integration.hrs.ecas.cert.login.service.additionalTrustedCertificateResourceName}")
    String additionalTrustedCertificateResourceName;

    @Value("${pdm.integration.hrs.service.hermesApplicationId}")
    String hermesApplicationId;

    @Value("${pdm.integration.hrs.service.hermesJobAccount}")
    String hermesJobAccount;

    @Value("${pdm.integration.hrs.http.attachment.endpoint}")
    String hermesHttpServiceEndpoint;

    @Value("${pdm.integration.hrs.service.useFakeTicket}")
    private Boolean useFakeTicket;

    @Value("${pdm.integration.hrs.service.fakeTicket}")
    private String fakeTicket;


    @Autowired
    private ApplicationContext ctx;

    @Bean
    public HrsHTTpClient hrsHTTpClient() throws Exception{

        // load the keyStore:
        InputStream keyStoreInputStream = getClass().getClassLoader().getResourceAsStream(ecasKeyStoreFileName);
        KeyStore keyStore = KeyStore.getInstance(keyStoreType, keyStoreProvider);
        keyStore.load(keyStoreInputStream, ecasKeyStorePassword.toCharArray());
        keyStoreInputStream.close();

        X509Certificate additionalTrustedCert = loadCertificate(additionalTrustedCertificateResourceName);
        List<X509Certificate> additionalTrustedCertificates = new ArrayList<>();
        additionalTrustedCertificates.add(additionalTrustedCert);

        // build a script client:
        ScriptClient scriptClient = new ScriptClient.Builder(keyStore, ecasKeyAlias, ecasKeyStorePassword.toCharArray()).
                connectTimeoutMillis(CONNECT_TIMEOUT_MILLIS).
                ecasServerCertLoginUrl(ecasServerCertLoginUrl).
                maxConnections(MAX_CONNECTIONS).
                verifyHostname(false).
                additionalTrustedCertificates(additionalTrustedCertificates).
                readTimeoutMillis(READ_TIMEOUT_MILLIS).build();

        EcasProxyTicketClient ecasProxyTicketClient = new EcasProxyTicketClient(scriptClient);

        return new HrsHTTpClient(hermesHttpServiceEndpoint, hermesJobAccount, hermesApplicationId, ecasProxyTicketClient, useFakeTicket, fakeTicket);
    }

    @Bean
    public HermesDocumentServiceClient hermesDocumentServiceClient() throws Exception{
        DocumentService documentServicePort = null;
        FilingPlanService filingServicePort = null;

        try {

            DocumentWebService documentWebService = new DocumentWebService(documentServiceWSDL, new QName("http://ec.europa.eu/sg/hrs", "DocumentWebService"));
            FilingPlanWebService filingPlanWebService = new FilingPlanWebService(filingPlanServiceWSDL, new QName("http://ec.europa.eu/sg/hrs", "FilingPlanWebService"));

            documentServicePort = documentWebService.getPort(DocumentService.class);
            filingServicePort = filingPlanWebService.getPort(FilingPlanService.class);

            // load the keyStore:
            InputStream keyStoreInputStream = getClass().getClassLoader().getResourceAsStream(ecasKeyStoreFileName);
            KeyStore keyStore = KeyStore.getInstance(keyStoreType, keyStoreProvider);
            keyStore.load(keyStoreInputStream, ecasKeyStorePassword.toCharArray());
            keyStoreInputStream.close();

            X509Certificate additionalTrustedCert = loadCertificate(additionalTrustedCertificateResourceName);
            List<X509Certificate> additionalTrustedCertificates = new ArrayList<>();
            additionalTrustedCertificates.add(additionalTrustedCert);

            // build a script client:
            ScriptClient scriptClient = new ScriptClient.Builder(keyStore, ecasKeyAlias, ecasKeyStorePassword.toCharArray()).
                    connectTimeoutMillis(CONNECT_TIMEOUT_MILLIS).
                    ecasServerCertLoginUrl(ecasServerCertLoginUrl).
                    maxConnections(MAX_CONNECTIONS).
                    verifyHostname(false).
                    additionalTrustedCertificates(additionalTrustedCertificates).
                    readTimeoutMillis(READ_TIMEOUT_MILLIS).build();

            configurePort(documentServicePort, documentServiceEndPoint, scriptClient);
            configurePort(filingServicePort, filingPlanServiceEndPoint, scriptClient);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return  new HermesDocumentServiceClient(documentServicePort, filingServicePort, hrsHTTpClient());
    }

    private void configurePort(Object port, String serviceEndPoint, ScriptClient scriptClient) {
        Map<String, Object> rc = ((BindingProvider) port).getRequestContext();
        rc.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, serviceEndPoint);

        Binding binding = ((BindingProvider)port).getBinding();
        List<Handler> handlerList = binding.getHandlerChain();
        handlerList.add(new HermesClientSOAPHandler(scriptClient, hermesApplicationId, hermesJobAccount, useFakeTicket, fakeTicket));
        handlerList.add(new ErisLogMessageHandler());
        binding.setHandlerChain(handlerList);

    }

    private static X509Certificate loadCertificate(String additionalTrustedCertificateResourceName) throws IOException, CertificateException, RuntimeException {
        InputStream certificateInputStream = ScriptClientConfigurationHelper.class.getResourceAsStream(additionalTrustedCertificateResourceName);
        if (certificateInputStream == null) {
            throw new RuntimeException("Could not find resource '" + additionalTrustedCertificateResourceName + "'.");
        } else {
            X509Certificate var5;
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
                Certificate certificate = certificateFactory.generateCertificate(certificateInputStream);
                X509Certificate x509Certificate = (X509Certificate)certificate;
                var5 = x509Certificate;
            } finally {
                certificateInputStream.close();
            }

            return var5;
        }
    }
}
