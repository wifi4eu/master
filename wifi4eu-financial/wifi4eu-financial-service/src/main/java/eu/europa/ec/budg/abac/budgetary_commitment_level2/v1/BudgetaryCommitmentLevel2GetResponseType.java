
package eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.MessageResponseType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2GetResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2GetResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BudgetaryCommitmentLevel2" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BudgetaryCommitmentLevel2GetType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2GetResponseType", propOrder = {
    "budgetaryCommitmentLevel2"
})
public class BudgetaryCommitmentLevel2GetResponseType
    extends MessageResponseType
{

    @XmlElement(name = "BudgetaryCommitmentLevel2")
    protected BudgetaryCommitmentLevel2GetType budgetaryCommitmentLevel2;

    /**
     * Obtiene el valor de la propiedad budgetaryCommitmentLevel2.
     * 
     * @return
     *     possible object is
     *     {@link BudgetaryCommitmentLevel2GetType }
     *     
     */
    public BudgetaryCommitmentLevel2GetType getBudgetaryCommitmentLevel2() {
        return budgetaryCommitmentLevel2;
    }

    /**
     * Define el valor de la propiedad budgetaryCommitmentLevel2.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetaryCommitmentLevel2GetType }
     *     
     */
    public void setBudgetaryCommitmentLevel2(BudgetaryCommitmentLevel2GetType value) {
        this.budgetaryCommitmentLevel2 = value;
    }

}
