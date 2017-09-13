
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.MessageResponseType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel1GetResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel1GetResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BudgetaryCommitmentLevel1" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BudgetaryCommitmentLevel1GetType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel1GetResponseType", propOrder = {
    "budgetaryCommitmentLevel1"
})
public class BudgetaryCommitmentLevel1GetResponseType
    extends MessageResponseType
{

    @XmlElement(name = "BudgetaryCommitmentLevel1")
    protected BudgetaryCommitmentLevel1GetType budgetaryCommitmentLevel1;

    /**
     * Obtiene el valor de la propiedad budgetaryCommitmentLevel1.
     * 
     * @return
     *     possible object is
     *     {@link BudgetaryCommitmentLevel1GetType }
     *     
     */
    public BudgetaryCommitmentLevel1GetType getBudgetaryCommitmentLevel1() {
        return budgetaryCommitmentLevel1;
    }

    /**
     * Define el valor de la propiedad budgetaryCommitmentLevel1.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetaryCommitmentLevel1GetType }
     *     
     */
    public void setBudgetaryCommitmentLevel1(BudgetaryCommitmentLevel1GetType value) {
        this.budgetaryCommitmentLevel1 = value;
    }

}
