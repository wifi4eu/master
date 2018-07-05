package wifi4eu.jagate;

import com.sun.xml.ws.client.BindingProviderProperties;
import generated.jagate.model.CreateLegalEntityRequestType;
import generated.jagate.model.CreateLegalEntityResponseType;
import generated.jagate.ws.service.ILegalEntityService;
import generated.jagate.ws.service.LegalEntityServiceV6;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import weblogic.jws.jaxws.ClientPolicyFeature;
import weblogic.jws.jaxws.policy.InputStreamPolicySource;
import weblogic.wsee.security.unt.ClientUNTCredentialProvider;
import weblogic.xml.crypto.wss.WSSecurityContext;
import wifi4eu.jagate.util.SoapServiceLogHandler;

import javax.annotation.PostConstruct;
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

@Service
public class LegalEntityServiceV6Client implements ApplicationContextAware {

	private static final Logger logger = LoggerFactory.getLogger(LegalEntityServiceV6Client.class);


    @Value("classpath:jagate/wsdls/legalentity/v6/LegalEntity.wsdl")
    private URL jagateLegalEntityWSDL;

    @Value("classpath:/jagate/Policies/digestUsernameToken2007.xml.policy")
    private String policy;

    @Value("${financiallegalentity.service.ws.username}")
    private String userName;

    @Value("${financiallegalentity.service.ws.endpoint}")
    private String endPoint;

    @Value("${financiallegalentity.service.ws.passwd}")
    private String passwd;

	@Value("${financiallegalentity.service.ws.timeout}")
	private int timeout;

	private static final String JAGATE_REQUEST_ID_PREFIX = "JAG.";


    private ApplicationContext ctx;

    private ILegalEntityService port;



    @PostConstruct
    public void init() {

        try {
        	QName qName = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6", "LegalEntityServiceV6");
        	LegalEntityServiceV6 legalEntityService = new LegalEntityServiceV6(jagateLegalEntityWSDL, qName);
            port = legalEntityService.getPort(ILegalEntityService.class, getWebServiceFeatures(policy));
            configurePort(port);

            /*BindingProvider bindProv = (BindingProvider) port;
            java.util.List<Handler> handlers = bindProv.getBinding().getHandlerChain();
            handlers.add(new SoapServiceLogHandler());
            bindProv.getBinding().setHandlerChain(handlers);*/

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }


	public String requestFelCreation(CreateLegalEntityRequestType creationRequest) throws Exception {

		CreateLegalEntityResponseType creationResponse = port.createLegalEntity(creationRequest);
		return creationResponse.getLocalObjectForeignId();
	}


	private void configurePort(Object port) {
        Map<String, Object> rc = ((BindingProvider) port).getRequestContext();
        rc.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endPoint);
        List<ClientUNTCredentialProvider> credProviders = new ArrayList<ClientUNTCredentialProvider>();
        credProviders.add(new ClientUNTCredentialProvider(userName.getBytes(), passwd.getBytes()));
        rc.put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credProviders);
        rc.put(BindingProviderProperties.CONNECT_TIMEOUT, timeout);
        rc.put(BindingProviderProperties.REQUEST_TIMEOUT, timeout);

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
