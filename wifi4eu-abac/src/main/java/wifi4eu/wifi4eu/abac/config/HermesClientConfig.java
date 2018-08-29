package wifi4eu.wifi4eu.abac.config;

import eu.cec.digit.ecas.client.script.ScriptClient;
import eu.cec.digit.ecas.client.webservices.ScriptClientSOAPHandler;
import generated.hrs.ws.DocumentService;
import generated.hrs.ws.DocumentWebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wifi4eu.wifi4eu.abac.integration.hrs.HermesDocumentServiceClient;

import javax.xml.namespace.QName;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
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
    private URL serviceWSDL;

    @Value("${pdm.integration.hrs.ws.endpoint}")
    private String endPoint;

    @Value("${pdm.integration.ecas.cert.login.service.keyStore.file}")
    String keyStoreFileName;

    @Value("${pdm.integration.ecas.cert.login.service.keyStore.password}")
    String keyStorePassword;

    @Value("jks")
    String keyStoreType;

    @Value("${pdm.integration.ecas.cert.login.service.cert.alias}")
    String keyAlias;

    @Value("${pdm.integration.ecas.cert.login.service.cert.trusted.alias}")
    String keyTrustedAlias;

    @Value("${pdm.integration.ecas.cert.login.service.url}")
    String ecasServerCertLoginUrl;

    @Autowired
    private ApplicationContext ctx;

    @Bean
    public HermesDocumentServiceClient hermesDocumentServiceClient() throws Exception{
        DocumentService port = null;

        try {

            QName qName = new QName("http://ec.europa.eu/sg/hrs", "CoreServices");
            DocumentWebService CoreServices = new DocumentWebService(serviceWSDL, qName);

            port = CoreServices.getPort(DocumentService.class);

            // load the keyStore:
            InputStream keyStoreInputStream = getClass().getClassLoader().getResourceAsStream(keyStoreFileName);
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(keyStoreInputStream, keyStorePassword.toCharArray());
            keyStoreInputStream.close();

            X509Certificate additionalTrustedCert = (X509Certificate)keyStore.getCertificate(keyTrustedAlias);
            List<X509Certificate> additionalTrustedCertificates = new ArrayList<>();
            additionalTrustedCertificates.add(additionalTrustedCert);

            // build a script client:
            ScriptClient scriptClient = new ScriptClient.Builder(keyStore, keyAlias, keyStorePassword.toCharArray()).
                    connectTimeoutMillis(CONNECT_TIMEOUT_MILLIS).
                    ecasServerCertLoginUrl(ecasServerCertLoginUrl).
                    maxConnections(MAX_CONNECTIONS).
                    verifyHostname(false).
                    additionalTrustedCertificates(additionalTrustedCertificates).
                    readTimeoutMillis(READ_TIMEOUT_MILLIS).build();

            configurePort(port, scriptClient);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return  new HermesDocumentServiceClient(port);
    }

    private void configurePort(Object port, ScriptClient scriptClient) {
        Map<String, Object> rc = ((BindingProvider) port).getRequestContext();
        rc.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endPoint);

        Binding binding = ((BindingProvider)port).getBinding();
        List<Handler> handlerList = binding.getHandlerChain();
        handlerList.add(new ScriptClientSOAPHandler(scriptClient));
        binding.setHandlerChain(handlerList);
    }
}
