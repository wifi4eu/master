
package eu.europa.ec.budg.abac.legal_commitment.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageRequestType;


/**
 * <p>Clase Java para LegalCommitmentAmendRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalCommitmentAmendRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}BusinessRuleMessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LegalCommitment" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}LegalCommitmentAmendType"/&gt;
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
@XmlType(name = "LegalCommitmentAmendRequestType", propOrder = {
    "legalCommitment",
    "changeRequestReason"
})
public class LegalCommitmentAmendRequestType
    extends BusinessRuleMessageRequestType
{

    @XmlElement(name = "LegalCommitment", required = true)
    protected LegalCommitmentAmendType legalCommitment;
    @XmlElement(name = "ChangeRequestReason", required = true)
    protected String changeRequestReason;

    /**
     * Obtiene el valor de la propiedad legalCommitment.
     * 
     * @return
     *     possible object is
     *     {@link LegalCommitmentAmendType }
     *     
     */
    public LegalCommitmentAmendType getLegalCommitment() {
        return legalCommitment;
    }

    /**
     * Define el valor de la propiedad legalCommitment.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalCommitmentAmendType }
     *     
     */
    public void setLegalCommitment(LegalCommitmentAmendType value) {
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
