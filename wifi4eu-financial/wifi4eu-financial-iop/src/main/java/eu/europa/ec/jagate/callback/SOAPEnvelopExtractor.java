package eu.europa.ec.jagate.callback;

import eu.europa.ec.rdg.efp.domain.event.v1_0.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.jms.Message;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPMessage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class SOAPEnvelopExtractor {

    private static final Logger LOG = LoggerFactory.getLogger(SOAPEnvelopExtractor.class);

    protected static final String NOTIFY_TAG_V1 = "notify";
    protected static final String NOTIFY_TAG_V2 = "Notify";
    protected static final String NOTIFICATION_INTERFACES_NAMESPACE = "http://ec.europa.eu/rdg/efp/services/notification/interfaces/v1_0";
    protected static final String TMP_NOTIFICATION_INTERFACES_NAMESPACE_4_JAGATE = "http://ec.europa.eu/research/fp/services/event-notification/interfaces/V2";

    public SOAPEnvelopExtractor() {
    }

    private static JAXBContext jaxbContext;

    @SuppressWarnings("rawtypes")
	public EventType extractEvent(Message message) throws Exception
    {
        if ((message instanceof TextMessage))
        {
              InputStream messageIs = new BufferedInputStream(new ByteArrayInputStream(((TextMessage)message).getText().getBytes("UTF-8")));
              MessageFactory mf11 = MessageFactory.newInstance("SOAP 1.1 Protocol");
              SOAPMessage soapMessage = mf11.createMessage(new MimeHeaders(), messageIs);
              SOAPBody soapBody = soapMessage.getSOAPBody();
              NodeList nodelist = (NodeList) soapBody.getElementsByTagNameNS(NOTIFICATION_INTERFACES_NAMESPACE, NOTIFY_TAG_V1);              
              final Object unmarshalled = extractFromNode(nodelist);
              if (unmarshalled instanceof eu.europa.ec.rdg.efp.services.notification.interfaces.v1_0.Notify) {
                  return ((eu.europa.ec.rdg.efp.services.notification.interfaces.v1_0.Notify) unmarshalled).getEvent();
              } 
              else if ((unmarshalled instanceof JAXBElement)) {
                  return (EventType)((JAXBElement)unmarshalled).getValue();
              }
              else {
                  throw new Exception("Incorrect event received: events should be instances of "
                          + eu.europa.ec.rdg.efp.services.notification.interfaces.v1_0.Notify.class + " and not "
                          + unmarshalled.getClass());
              }
        }
        throw new Exception("Message is not a TextMessage, received a " + message.getClass().getCanonicalName() + " instead");
   }
    
    public final static Object extractFromNotifyTemplateV1(final String soapMessageInUTF8) throws Exception {
        final InputStream messageIs = new BufferedInputStream(new ByteArrayInputStream(soapMessageInUTF8.getBytes("UTF-8")));
        final MessageFactory mf11 = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        final SOAPMessage soapMessage = mf11.createMessage(new MimeHeaders(), messageIs);

        final SOAPBody soapBody = soapMessage.getSOAPBody();

        NodeList nodelist = (NodeList) soapBody
                .getElementsByTagNameNS(NOTIFICATION_INTERFACES_NAMESPACE, NOTIFY_TAG_V1);

        final Object unmarshalled = extractFromNode(nodelist);
        
        if (unmarshalled instanceof eu.europa.ec.rdg.efp.services.notification.interfaces.v1_0.Notify) {
            return ((eu.europa.ec.rdg.efp.services.notification.interfaces.v1_0.Notify) unmarshalled).getEvent();
        } else {
            throw new Exception("Incorrect event received: events should be instances of "
                    + eu.europa.ec.rdg.efp.services.notification.interfaces.v1_0.Notify.class + " and not "
                    + unmarshalled.getClass());
        }
        
    }
    
    public final static Object extractFromNotifyTemplateV2(final String soapMessageInUTF8) throws Exception {
        final InputStream messageIs = new BufferedInputStream(new ByteArrayInputStream(soapMessageInUTF8.getBytes("UTF-8")));
        final MessageFactory mf11 = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        final SOAPMessage soapMessage = mf11.createMessage(new MimeHeaders(), messageIs);

        final SOAPBody soapBody = soapMessage.getSOAPBody();

        NodeList nodelist = (NodeList) soapBody.getElementsByTagNameNS(TMP_NOTIFICATION_INTERFACES_NAMESPACE_4_JAGATE,
                NOTIFY_TAG_V2);

        final Object unmarshalled = extractFromNode(nodelist);

        if (unmarshalled instanceof eu.europa.ec.research.fp.services.event_notification.interfaces.v2.Notify) {
            return ((eu.europa.ec.research.fp.services.event_notification.interfaces.v2.Notify) unmarshalled).getEvent();
        } else {
            throw new Exception("Incorrect event received: events should be instances of "
                    + eu.europa.ec.research.fp.services.event_notification.interfaces.v2.Notify.class + " and not "
                    + unmarshalled.getClass());
        }
    }

    public final static Object extractFromNode(NodeList nodelist) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        Document evntDoc = null;

        try {
            db = dbf.newDocumentBuilder();
            evntDoc = db.newDocument();
            evntDoc.appendChild(evntDoc.importNode(nodelist.item(0), true));
        } catch (ParserConfigurationException ex) {
            LOG.warn("extractEvent(..) - error when extracting event from EDA message!.", ex);
        }

        final Unmarshaller unmarshaller = getJaxbContext().createUnmarshaller();

        final Object unmarshalled = unmarshaller.unmarshal(evntDoc);

        return unmarshalled;
    }
    
    // lazy loading jaxb context which is threadsafe
    private static JAXBContext getJaxbContext() throws Exception {
        if (jaxbContext == null) {
            //The classes that could be deserialized must be mentionned here after.
            jaxbContext = JAXBContext.newInstance(

            		eu.europa.ec.rdg.efp.services.notification.interfaces.v1_0.Notify.class,
            		eu.europa.ec.rdg.efp.domain.event.v1_0.EventType.class,
            		eu.europa.ec.rdg.efp.domain.event.v1_0.EventBodyType.class,
            		eu.europa.ec.rdg.efp.domain.event.legalentity.factupdate_event.v11.LegalEntityFactUpdateEvent.class,
            		eu.europa.ec.rdg.efp.domain.event.legalentity.fact_update_request_event.v6.LegalEntityFactUpdateRequestEvent.class,

                    // ABAC events
                    eu.europa.ec.research.fp.services.event_notification.interfaces.v2.Notify.class,
                    eu.europa.ec.research.fp.model.eventbase.v1.EventBodyType.class,
                    eu.europa.ec.research.fp.model.eventbase.v1.EventType.class,
                    eu.europa.ec.rdg.jagate.ws.domain.event.bankaccount.created.v5.BankAccountCreatedEvent.class
            		);
        }
        return jaxbContext;
    }
	
}
