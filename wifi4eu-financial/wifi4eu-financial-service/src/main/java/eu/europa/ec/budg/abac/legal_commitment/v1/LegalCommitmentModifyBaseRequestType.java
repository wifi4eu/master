
package eu.europa.ec.budg.abac.legal_commitment.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageRequestType;


/**
 * <p>Clase Java para LegalCommitmentModifyBaseRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalCommitmentModifyBaseRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}BusinessRuleMessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LegalCommitment" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}LegalCommitmentWritableType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalCommitmentModifyBaseRequestType", propOrder = {
    "legalCommitment"
})
public class LegalCommitmentModifyBaseRequestType
    extends BusinessRuleMessageRequestType
{

    @XmlElement(name = "LegalCommitment", required = true)
    protected LegalCommitmentWritableType legalCommitment;

    /**
     * Obtiene el valor de la propiedad legalCommitment.
     * 
     * @return
     *     possible object is
     *     {@link LegalCommitmentWritableType }
     *     
     */
    public LegalCommitmentWritableType getLegalCommitment() {
        return legalCommitment;
    }

    /**
     * Define el valor de la propiedad legalCommitment.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalCommitmentWritableType }
     *     
     */
    public void setLegalCommitment(LegalCommitmentWritableType value) {
        this.legalCommitment = value;
    }

}
