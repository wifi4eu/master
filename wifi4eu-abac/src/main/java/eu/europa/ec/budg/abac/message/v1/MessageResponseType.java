
package eu.europa.ec.budg.abac.message.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.legal_entity.v2.LegalEntityCheckDuplicateResponseType;
import eu.europa.ec.budg.abac.legal_entity.v2.LegalEntityGetResponseType;
import eu.europa.ec.budg.abac.organisation.v1.OrganisationGetFirstAncestorForWorkflowResponseType;
import eu.europa.ec.budg.abac.organisation.v1.OrganisationGetResponseType;


/**
 * <p>Clase Java para MessageResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MessageResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageHeader" type="{http://www.ec.europa.eu/budg/abac/message/v1}MessageHeaderType"/&gt;
 *         &lt;element name="MessageFault" type="{http://www.ec.europa.eu/budg/abac/message/v1}MessageFaultType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageResponseType", propOrder = {
    "messageHeader",
    "messageFault"
})
@XmlSeeAlso({
    LegalEntityGetResponseType.class,
    LegalEntityCheckDuplicateResponseType.class,
    FindMessageResponseType.class,
    BusinessRuleMessageResponseType.class,
    SearchMessageResponseType.class,
    OrganisationGetResponseType.class,
    OrganisationGetFirstAncestorForWorkflowResponseType.class
})
public class MessageResponseType {

    @XmlElement(name = "MessageHeader", required = true)
    protected MessageHeaderType messageHeader;
    @XmlElement(name = "MessageFault")
    protected MessageFaultType messageFault;

    /**
     * Obtiene el valor de la propiedad messageHeader.
     * 
     * @return
     *     possible object is
     *     {@link MessageHeaderType }
     *     
     */
    public MessageHeaderType getMessageHeader() {
        return messageHeader;
    }

    /**
     * Define el valor de la propiedad messageHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageHeaderType }
     *     
     */
    public void setMessageHeader(MessageHeaderType value) {
        this.messageHeader = value;
    }

    /**
     * Obtiene el valor de la propiedad messageFault.
     * 
     * @return
     *     possible object is
     *     {@link MessageFaultType }
     *     
     */
    public MessageFaultType getMessageFault() {
        return messageFault;
    }

    /**
     * Define el valor de la propiedad messageFault.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageFaultType }
     *     
     */
    public void setMessageFault(MessageFaultType value) {
        this.messageFault = value;
    }

}
