
package abac.message.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1 package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MessageFault_QNAME = new QName("http://www.ec.europa.eu/budg/abac/message/v1", "MessageFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MessageFaultType }
     * 
     */
    public MessageFaultType createMessageFaultType() {
        return new MessageFaultType();
    }

    /**
     * Create an instance of {@link MessageFaultType.MessageFaultDetail }
     * 
     */
    public MessageFaultType.MessageFaultDetail createMessageFaultTypeMessageFaultDetail() {
        return new MessageFaultType.MessageFaultDetail();
    }

    /**
     * Create an instance of {@link BusinessRuleMessageResponseType }
     * 
     */
    public BusinessRuleMessageResponseType createBusinessRuleMessageResponseType() {
        return new BusinessRuleMessageResponseType();
    }

    /**
     * Create an instance of {@link ConcurrentAccessMessageResponseType }
     * 
     */
    public ConcurrentAccessMessageResponseType createConcurrentAccessMessageResponseType() {
        return new ConcurrentAccessMessageResponseType();
    }

    /**
     * Create an instance of {@link FindMessageResponseType }
     * 
     */
    public FindMessageResponseType createFindMessageResponseType() {
        return new FindMessageResponseType();
    }

    /**
     * Create an instance of {@link MessageHeaderType }
     * 
     */
    public MessageHeaderType createMessageHeaderType() {
        return new MessageHeaderType();
    }

    /**
     * Create an instance of {@link MessageResponseType }
     * 
     */
    public MessageResponseType createMessageResponseType() {
        return new MessageResponseType();
    }

    /**
     * Create an instance of {@link SearchMessageResponseType }
     * 
     */
    public SearchMessageResponseType createSearchMessageResponseType() {
        return new SearchMessageResponseType();
    }

    /**
     * Create an instance of {@link MessageFaultType.MessageFaultDetail.Program }
     * 
     */
    public MessageFaultType.MessageFaultDetail.Program createMessageFaultTypeMessageFaultDetailProgram() {
        return new MessageFaultType.MessageFaultDetail.Program();
    }

    /**
     * Create an instance of {@link MessageFaultType.MessageFaultDetail.XsdValidationFailure }
     * 
     */
    public MessageFaultType.MessageFaultDetail.XsdValidationFailure createMessageFaultTypeMessageFaultDetailXsdValidationFailure() {
        return new MessageFaultType.MessageFaultDetail.XsdValidationFailure();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/message/v1", name = "MessageFault")
    public JAXBElement<MessageFaultType> createMessageFault(MessageFaultType value) {
        return new JAXBElement<MessageFaultType>(_MessageFault_QNAME, MessageFaultType.class, null, value);
    }

}
