
package abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import abac.message.v1.MessageRequestType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2ModifyRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2ModifyRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BudgetaryCommitmentLevel2" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BudgetaryCommitmentLevel2WritableType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2ModifyRequestType", propOrder = {
    "budgetaryCommitmentLevel2"
})
public class BudgetaryCommitmentLevel2ModifyRequestType
    extends MessageRequestType
{

    @XmlElement(name = "BudgetaryCommitmentLevel2", required = true)
    protected BudgetaryCommitmentLevel2WritableType budgetaryCommitmentLevel2;

    /**
     * Obtiene el valor de la propiedad budgetaryCommitmentLevel2.
     * 
     * @return
     *     possible object is
     *     {@link BudgetaryCommitmentLevel2WritableType }
     *     
     */
    public BudgetaryCommitmentLevel2WritableType getBudgetaryCommitmentLevel2() {
        return budgetaryCommitmentLevel2;
    }

    /**
     * Define el valor de la propiedad budgetaryCommitmentLevel2.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetaryCommitmentLevel2WritableType }
     *     
     */
    public void setBudgetaryCommitmentLevel2(BudgetaryCommitmentLevel2WritableType value) {
        this.budgetaryCommitmentLevel2 = value;
    }

}
