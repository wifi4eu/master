
package eu.europa.ec.budg.abac.legal_commitment.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.ares_document.v1.AresDocumentType;
import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageRequestType;


/**
 * <p>Clase Java para LegalCommitmentAddAresDocumentRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalCommitmentAddAresDocumentRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}BusinessRuleMessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="ChangeRequestReason" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}ChangeRequestReasonType"/&gt;
 *         &lt;element name="AresDocument" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}AresDocumentType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalCommitmentAddAresDocumentRequestType", propOrder = {
    "localKey",
    "changeRequestReason",
    "aresDocument"
})
public class LegalCommitmentAddAresDocumentRequestType
    extends BusinessRuleMessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "ChangeRequestReason", required = true)
    protected String changeRequestReason;
    @XmlElement(name = "AresDocument", required = true)
    protected AresDocumentType aresDocument;

    /**
     * Obtiene el valor de la propiedad localKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalKey() {
        return localKey;
    }

    /**
     * Define el valor de la propiedad localKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalKey(String value) {
        this.localKey = value;
    }

    /**
     * Obtiene el valor de la propiedad changeRequestReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeRequestReason() {
        return changeRequestReason;
    }

    /**
     * Define el valor de la propiedad changeRequestReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeRequestReason(String value) {
        this.changeRequestReason = value;
    }

    /**
     * Obtiene el valor de la propiedad aresDocument.
     * 
     * @return
     *     possible object is
     *     {@link AresDocumentType }
     *     
     */
    public AresDocumentType getAresDocument() {
        return aresDocument;
    }

    /**
     * Define el valor de la propiedad aresDocument.
     * 
     * @param value
     *     allowed object is
     *     {@link AresDocumentType }
     *     
     */
    public void setAresDocument(AresDocumentType value) {
        this.aresDocument = value;
    }

}
