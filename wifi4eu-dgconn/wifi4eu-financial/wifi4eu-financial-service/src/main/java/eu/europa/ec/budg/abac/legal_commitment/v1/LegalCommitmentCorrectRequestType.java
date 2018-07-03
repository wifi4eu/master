
package eu.europa.ec.budg.abac.legal_commitment.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageRequestType;


/**
 * <p>Clase Java para LegalCommitmentCorrectRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalCommitmentCorrectRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}BusinessRuleMessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LegalCommitment" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}LegalCommitmentWritableType"/&gt;
 *         &lt;element name="ChangeRequestReason" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}ChangeRequestReasonType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalCommitmentCorrectRequestType", propOrder = {
    "legalCommitment",
    "changeRequestReason"
})
public class LegalCommitmentCorrectRequestType
    extends BusinessRuleMessageRequestType
{

    @XmlElement(name = "LegalCommitment", required = true)
    protected LegalCommitmentWritableType legalCommitment;
    @XmlElement(name = "ChangeRequestReason", required = true)
    protected String changeRequestReason;

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

}
