package wifi4eu.jagate;

import com.sun.xml.ws.client.BindingProviderProperties;
import generated.jagate.model.CheckBankAccountFormatRequestType;
import generated.jagate.model.CheckBankAccountFormatResponseType;
import generated.jagate.ws.service.BankAccountException;
import generated.jagate.ws.service.BankAccountServiceV5;
import generated.jagate.ws.service.IBankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import weblogic.jws.jaxws.ClientPolicyFeature;
import weblogic.jws.jaxws.policy.InputStreamPolicySource;
import weblogic.wsee.security.unt.ClientUNTCredentialProvider;
import weblogic.xml.crypto.wss.WSSecurityContext;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceFeature;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class BankAccountServiceV5Client implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(BankAccountServiceV5Client.class);
    
    private static final int TIMEOUT = 60000;

    @Value("classpath:/jagate/wsdls/bankaccount/v5/BankAccount.wsdl")
    private URL serviceWSDL;
    
    @Value("classpath:/jagate/Policies/digestUsernameToken2007.xml.policy")
    private String policy;

    @Value("${bankaccount.service.ws.endpoint}")
    private String endPoint;

    @Value("${bankaccount.service.ws.username}")
    private String username;

    @Value("${bankaccount.service.ws.passwd}")
    private String passwd;

    private ApplicationContext ctx;

    private IBankAccountService port;

    @PostConstruct
    public void init() {
        try {

            QName qName = new QName("http://ec.europa.eu/rdg/jagate/ws/bankaccount/v5", "BankAccountServiceV5");
            BankAccountServiceV5 bankAccountService = new BankAccountServiceV5(serviceWSDL, qName);

            port = bankAccountService.getPort(IBankAccountService.class, getWebServiceFeatures(policy));

            configurePort(port);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    private void configurePort(Object port) {
        Map<String, Object> rc = ((BindingProvider) port).getRequestContext();
        rc.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endPoint);
        
        List<ClientUNTCredentialProvider> credProviders = new ArrayList<ClientUNTCredentialProvider>();
        credProviders.add(new ClientUNTCredentialProvider(username.getBytes(), passwd.getBytes()));
        rc.put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credProviders);
        rc.put(BindingProviderProperties.CONNECT_TIMEOUT, TIMEOUT);
        rc.put(BindingProviderProperties.REQUEST_TIMEOUT, TIMEOUT);
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
    

    public CheckBankAccountFormatResponseType checkBankAccountFormat(CheckBankAccountFormatRequestType request) throws BankAccountException {
        return port.checkBankAccountFormat(request);
    }
    

}
