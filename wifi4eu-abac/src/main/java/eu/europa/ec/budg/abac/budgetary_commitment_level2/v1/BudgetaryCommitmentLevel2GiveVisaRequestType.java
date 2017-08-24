
package eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.MessageRequestType;
import eu.europa.ec.budg.abac.workflow.v1.VisaType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2GiveVisaRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2GiveVisaRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="Visa" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}VisaType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2GiveVisaRequestType", propOrder = {
    "localKey",
    "visa"
})
public class BudgetaryCommitmentLevel2GiveVisaRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "Visa", required = true)
    protected VisaType visa;

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
