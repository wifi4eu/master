
package eu.europa.ec.budg.abac.legal_commitment.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageRequestType;
import eu.europa.ec.budg.abac.scanned_document.v1.ScannedDocumentType;


/**
 * <p>Clase Java para LegalCommitmentAddScannedDocumentRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalCommitmentAddScannedDocumentRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}BusinessRuleMessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="ChangeRequestReason" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}ChangeRequestReasonType"/&gt;
 *         &lt;element name="ScannedDocument" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}ScannedDocumentType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalCommitmentAddScannedDocumentRequestType", propOrder = {
    "localKey",
    "changeRequestReason",
    "scannedDocument"
})
public class LegalCommitmentAddScannedDocumentRequestType
    extends BusinessRuleMessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "ChangeRequestReason", required = true)
    protected String changeRequestReason;
    @XmlElement(name = "ScannedDocument")
    protected ScannedDocumentType scannedDocument;

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
     * Obtiene el valor de la propiedad scannedDocument.
     * 
     * @return
     *     possible object is
     *     {@link ScannedDocumentType }
     *     
     */
    public ScannedDocumentType getScannedDocument() {
        return scannedDocument;
    }

    /**
     * Define el valor de la propiedad scannedDocument.
     * 
     * @param value
     *     allowed object is
     *     {@link ScannedDocumentType }
     *     
     */
    public void setScannedDocument(ScannedDocumentType value) {
        this.scannedDocument = value;
    }

}
