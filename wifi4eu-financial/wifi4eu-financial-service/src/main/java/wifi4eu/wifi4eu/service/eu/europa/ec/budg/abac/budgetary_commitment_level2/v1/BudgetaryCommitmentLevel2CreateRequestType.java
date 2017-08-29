
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1.MessageRequestType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.workflow.v1.VisaType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2CreateRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2CreateRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BudgetaryCommitmentLevel2" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BudgetaryCommitmentLevel2CreateType"/&gt;
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
@XmlType(name = "BudgetaryCommitmentLevel2CreateRequestType", propOrder = {
    "budgetaryCommitmentLevel2",
    "visa"
})
public class BudgetaryCommitmentLevel2CreateRequestType
    extends MessageRequestType
{

    @XmlElement(name = "BudgetaryCommitmentLevel2", required = true)
    protected BudgetaryCommitmentLevel2CreateType budgetaryCommitmentLevel2;
    @XmlElement(name = "Visa")
    protected VisaType visa;

    /**
     * Obtiene el valor de la propiedad budgetaryCommitmentLevel2.
     * 
     * @return
     *     possible object is
     *     {@link BudgetaryCommitmentLevel2CreateType }
     *     
     */
    public BudgetaryCommitmentLevel2CreateType getBudgetaryCommitmentLevel2() {
        return budgetaryCommitmentLevel2;
    }

    /**
     * Define el valor de la propiedad budgetaryCommitmentLevel2.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetaryCommitmentLevel2CreateType }
     *     
     */
    public void setBudgetaryCommitmentLevel2(BudgetaryCommitmentLevel2CreateType value) {
        this.budgetaryCommitmentLevel2 = value;
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
