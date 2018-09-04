package wifi4eu.wifi4eu.abac.integration.hrs;

import eu.cec.digit.ecas.client.logging.Logger;
import eu.cec.digit.ecas.client.resolver.logging.ClientFactory;
import eu.cec.digit.ecas.client.script.ScriptClient;
import eu.cec.digit.ecas.client.webservices.EcasSOAPConstants;
import eu.cec.digit.ecas.client.webservices.ScriptClientSOAPHandler;
import generated.hrs.ws.model.Header;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public class HermesClientSOAPHandler implements SOAPHandler<SOAPMessageContext>{

    private static final Logger LOG = ClientFactory.getInstance().getLogger(HermesClientSOAPHandler.class);
    private final ScriptClient scriptClient;
    private final String applicationId;
    private final String jobUser;
    private final Boolean useFakeTicket;
    private final String fakeTicket;

    public HermesClientSOAPHandler(ScriptClient scriptClient, String applicationId, String jobUser, Boolean useFakeTicket, String fakeTicket) {
        if (null == scriptClient) {
            throw new IllegalArgumentException("scriptClient cannot be null");
        } else {
            this.scriptClient = scriptClient;
            this.applicationId = applicationId;
            this.jobUser = jobUser;
            this.useFakeTicket = useFakeTicket;
            this.fakeTicket = fakeTicket;
        }
    }

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void destroy() {
    }

    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outboundProperty = (Boolean)context.get("javax.xml.ws.handler.message.outbound");
        if (outboundProperty) {
            String serviceTicket = null;
            String targetService = (String)context.get("javax.xml.ws.service.endpoint.address");

            try {
                serviceTicket = (useFakeTicket) ? fakeTicket : this.scriptClient.getServiceTicket(targetService);
            } catch (IOException var9) {
                this.processGetServiceTicketException(var9);
            }

            if (null == serviceTicket) {
                throw new RuntimeException("Unable to obtain a Service Ticket (check the ScriptClient configuration)");
            }

            try {
                SOAPMessage message = context.getMessage();
                SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
                if (null == envelope.getHeader()) {
                    envelope.addHeader();
                }

                SOAPElement firstNode = (SOAPElement)envelope.getBody().getChildElements().next();
                SOAPElement requestNode = (SOAPElement)firstNode.getChildElements(new QName("http://ec.europa.eu/sg/hrs/types", "request")).next();

                firstNode.removeContents();

                SOAPElement headerNode = firstNode.addChildElement(new QName("http://ec.europa.eu/sg/hrs/types", "header"));
                SOAPElement userName = headerNode.addChildElement(new QName("http://ec.europa.eu/sg/hrs/types", "userName"));
                userName.setValue(jobUser);
                SOAPElement ticket = headerNode.addChildElement(new QName("http://ec.europa.eu/sg/hrs/types", "ticket"));
                ticket.setValue(serviceTicket);
                SOAPElement applicationIdElement = headerNode.addChildElement(new QName("http://ec.europa.eu/sg/hrs/types", "applicationId"));
                applicationIdElement.setValue(applicationId);

                firstNode.addChildElement(requestNode);


                message.saveChanges();
                if (LOG.isInfoEnabled()) {
                    LOG.info("ServiceTicket obtained for \"" + targetService + "\" starts with \"" + serviceTicket.substring(0, serviceTicket.length() / 2) + "\"");
                }
            } catch (SOAPException var8) {
                throw new RuntimeException(var8);
            }
        }

        return true;
    }

    private void processGetServiceTicketException(Exception ex) {
        throw new RuntimeException(ex);
    }

    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    public void close(MessageContext context) {
    }

    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }
}
