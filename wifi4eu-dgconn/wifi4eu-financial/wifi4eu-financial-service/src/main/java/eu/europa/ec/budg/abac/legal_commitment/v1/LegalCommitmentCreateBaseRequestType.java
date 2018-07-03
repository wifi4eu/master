
package eu.europa.ec.budg.abac.legal_commitment.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageRequestType;
import eu.europa.ec.budg.abac.workflow.v1.VisaType;


/**
 * <p>Clase Java para LegalCommitmentCreateBaseRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalCommitmentCreateBaseRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}BusinessRuleMessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LegalCommitment" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}LegalCommitmentCreateType"/&gt;
 *         &lt;element name="Visa" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}VisaType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalCommitmentCreateBaseRequestType", propOrder = {
    "legalCommitment",
    "visa"
})
public class LegalCommitmentCreateBaseRequestType
    extends BusinessRuleMessageRequestType
{

    @XmlElement(name = "LegalCommitment", required = true)
    protected LegalCommitmentCreateType legalCommitment;
    @XmlElement(name = "Visa")
    protected VisaType visa;

    /**
     * Obtiene el valor de la propiedad legalCommitment.
     * 
     * @return
     *     possible object is
     *     {@link LegalCommitmentCreateType }
     *     
     */
    public LegalCommitmentCreateType getLegalCommitment() {
        return legalCommitment;
    }

    /**
     * Define el valor de la propiedad legalCommitment.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalCommitmentCreateType }
     *     
     */
    public void setLegalCommitment(LegalCommitmentCreateType value) {
        this.legalCommitment = value;
    }

    /**
     * Obtiene el valor de la propiedad visa.
     * 
     * @return
     *     possible object is
     *     {@link VisaType }
     *     
     */
    public VisaType getVisa() {
        return visa;
    }

    /**
     * Define el valor de la propiedad visa.
     * 
     * @param value
     *     allowed object is
     *     {@link VisaType }
     *     
     */
    public void setVisa(VisaType value) {
        this.visa = value;
    }

}
