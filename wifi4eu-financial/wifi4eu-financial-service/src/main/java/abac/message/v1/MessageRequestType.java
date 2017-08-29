
package abac.message.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import abac.legal_entity.v2.LegalEntityCreateBankAccountRequestType;
import abac.legal_entity.v2.LegalEntityCreateMailingAddressRequestType;
import abac.legal_entity.v2.LegalEntityCreateResponsibleUserRequestType;
import abac.legal_entity.v2.LegalEntityGetRequestType;
import abac.organisation.v1.OrganisationGetRequestType;
import abac.legal_entity.v2.LegalEntityCheckCreateRequestType;
import abac.legal_entity.v2.LegalEntityCheckDuplicateRequestType;
import abac.legal_entity.v2.LegalEntityCheckModifyRequestType;
import abac.legal_entity.v2.LegalEntityCreateAresDocumentRequestType;
import abac.legal_entity.v2.LegalEntityCreateRequestType;
import abac.legal_entity.v2.LegalEntityCreateScannedDocumentRequestType;
import abac.legal_entity.v2.LegalEntityModifyBankAccountRequestType;
import abac.legal_entity.v2.LegalEntityModifyMailingAddressRequestType;
import abac.organisation.v1.OrganisationGetFirstAncestorForWorkflowRequestType;


/**
 * <p>Clase Java para MessageRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MessageRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageHeader" type="{http://www.ec.europa.eu/budg/abac/message/v1}MessageHeaderType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="debug" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageRequestType", propOrder = {
    "messageHeader"
})
@XmlSeeAlso({
    LegalEntityGetRequestType.class,
    LegalEntityCreateRequestType.class,
    LegalEntityCreateAresDocumentRequestType.class,
    LegalEntityCreateBankAccountRequestType.class,
    LegalEntityCreateMailingAddressRequestType.class,
    LegalEntityCreateResponsibleUserRequestType.class,
    LegalEntityCreateScannedDocumentRequestType.class,
    LegalEntityCheckCreateRequestType.class,
    LegalEntityCheckDuplicateRequestType.class,
    LegalEntityCheckModifyRequestType.class,
    LegalEntityModifyBankAccountRequestType.class,
    LegalEntityModifyMailingAddressRequestType.class,
    FindMessageRequestType.class,
    BusinessRuleMessageRequestType.class,
    SearchMessageRequestType.class,
    OrganisationGetRequestType.class,
    OrganisationGetFirstAncestorForWorkflowRequestType.class
})
public abstract class MessageRequestType {

    @XmlElement(name = "MessageHeader", required = true)
    protected MessageHeaderType messageHeader;
    @XmlAttribute(name = "debug")
    protected Boolean debug;

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
     * Obtiene el valor de la propiedad debug.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDebug() {
        if (debug == null) {
            return false;
        } else {
            return debug;
        }
    }

    /**
     * Define el valor de la propiedad debug.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebug(Boolean value) {
        this.debug = value;
    }

}
