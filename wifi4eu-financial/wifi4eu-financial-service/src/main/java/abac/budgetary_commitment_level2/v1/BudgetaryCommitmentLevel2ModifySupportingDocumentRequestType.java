
package abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import abac.message.v1.MessageRequestType;
import abac.supporting_document.v1.SupportingDocumentType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2ModifySupportingDocumentRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2ModifySupportingDocumentRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="SupportingDocument" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}SupportingDocumentType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2ModifySupportingDocumentRequestType", propOrder = {
    "localKey",
    "supportingDocument"
})
public class BudgetaryCommitmentLevel2ModifySupportingDocumentRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "SupportingDocument", required = true)
    protected SupportingDocumentType supportingDocument;

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
     * Obtiene el valor de la propiedad supportingDocument.
     * 
     * @return
     *     possible object is
     *     {@link SupportingDocumentType }
     *     
     */
    public SupportingDocumentType getSupportingDocument() {
        return supportingDocument;
    }

    /**
     * Define el valor de la propiedad supportingDocument.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportingDocumentType }
     *     
     */
    public void setSupportingDocument(SupportingDocumentType value) {
        this.supportingDocument = value;
    }

}
