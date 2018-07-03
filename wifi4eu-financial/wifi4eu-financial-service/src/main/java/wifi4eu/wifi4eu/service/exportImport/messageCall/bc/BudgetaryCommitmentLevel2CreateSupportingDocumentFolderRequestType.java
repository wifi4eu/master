
package wifi4eu.wifi4eu.service.exportImport.messageCall.bc;

import eu.europa.ec.budg.abac.message.v1.MessageRequestType;
import eu.europa.ec.budg.abac.supporting_document.v1.SupportingDocumentFolderType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2CreateSupportingDocumentFolderRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2CreateSupportingDocumentFolderRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="SupportingDocumentFolder" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}SupportingDocumentFolderType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2CreateSupportingDocumentFolderRequestType", propOrder = {
    "localKey",
    "supportingDocumentFolder"
})
public class BudgetaryCommitmentLevel2CreateSupportingDocumentFolderRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "SupportingDocumentFolder", required = true)
    protected SupportingDocumentFolderType supportingDocumentFolder;

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
     * Obtiene el valor de la propiedad supportingDocumentFolder.
     * 
     * @return
     *     possible object is
     *     {@link SupportingDocumentFolderType }
     *     
     */
    public SupportingDocumentFolderType getSupportingDocumentFolder() {
        return supportingDocumentFolder;
    }

    /**
     * Define el valor de la propiedad supportingDocumentFolder.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportingDocumentFolderType }
     *     
     */
    public void setSupportingDocumentFolder(SupportingDocumentFolderType value) {
        this.supportingDocumentFolder = value;
    }

}
