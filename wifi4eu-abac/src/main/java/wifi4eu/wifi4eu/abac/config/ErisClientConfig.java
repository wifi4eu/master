package wifi4eu.wifi4eu.abac.config;

import eu.europa.ec.research.fp.services.document_management.v5.DocumentManagementService;
import eu.europa.ec.research.fp.services.document_management.v5.IDocumentManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import weblogic.jws.jaxws.ClientPolicyFeature;
import weblogic.jws.jaxws.policy.InputStreamPolicySource;
import weblogic.wsee.security.unt.ClientUNTCredentialProvider;
import weblogic.xml.crypto.wss.WSSecurityContext;
import wifi4eu.wifi4eu.abac.integration.eris.ErisLogMessageHandler;
import wifi4eu.wifi4eu.abac.integration.eris.ErisWebserviceClient;
import wifi4eu.wifi4eu.abac.service.ImportDataService;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.handler.Handler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Configuration
public class ErisClientConfig {

    private final Logger log = LoggerFactory.getLogger(ErisClientConfig.class);


    @Value("classpath:/integration/document-management/V5/DocumentManagementService.wsdl")
    private URL documentManagementServiceWSDL;

    @Value("classpath:/integration/policies/digestUsernameToken2007.xml.policy")
    private String policy;

    @Value("${integration.eris.ws.username}")
    private String username;

    @Value("${integration.eris.ws.uri}")
    private String endpoint;

    @Value("${integration.eris.ws.passwd}")
    private String passwd;

    @Autowired
    private ApplicationContext ctx;

    @Bean
    public ErisWebserviceClient erisWebserviceClient() throws Exception{
        IDocumentManagementService port = null;

        try {
            QName qName = new QName("http://ec.europa.eu/research/fp/services/document-management/V5", "DocumentManagementService");
            DocumentManagementService documentManagementService = new DocumentManagementService(documentManagementServiceWSDL, qName);
            port = documentManagementService.getPort(IDocumentManagementService.class, getWebServiceFeatures(policy));

            configurePort(port);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return new ErisWebserviceClient(port);
    }

    private void configurePort(Object port) {
        Map<String, Object> rc = ((BindingProvider) port).getRequestContext();
        rc.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
        List<ClientUNTCredentialProvider> credProviders = new ArrayList<ClientUNTCredentialProvider>();
        credProviders.add(new ClientUNTCredentialProvider(username.getBytes(), passwd.getBytes()));
        rc.put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credProviders);

        BindingProvider bindProv = (BindingProvider) port;
        java.util.List<Handler> handlers = bindProv.getBinding().getHandlerChain();
        handlers.add(new ErisLogMessageHandler());
        bindProv.getBinding().setHandlerChain(handlers);
    }

    protected WebServiceFeature[] getWebServiceFeatures(String policyPath) throws IOException {
        List<WebServiceFeature> out = new LinkedList<WebServiceFeature>();
        ClientPolicyFeature clientPolicyFeature = new ClientPolicyFeature();
        Resource policyResource = ctx.getResource(policyPath);
        InputStream policyResourceInputStream = policyResource.getInputStream();
        clientPolicyFeature.setEffectivePolicy(new InputStreamPolicySource(policyResourceInputStream));
        out.add(clientPolicyFeature);
        return out.toArray(new WebServiceFeature[out.size()]);
    }

}
