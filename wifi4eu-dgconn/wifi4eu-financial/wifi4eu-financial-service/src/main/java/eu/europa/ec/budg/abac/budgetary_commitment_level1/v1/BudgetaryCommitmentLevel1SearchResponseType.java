
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.SearchMessageResponseType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel1SearchResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel1SearchResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}SearchMessageResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BudgetaryCommitmentLevel1" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BudgetaryCommitmentLevel1SearchType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel1SearchResponseType", propOrder = {
    "budgetaryCommitmentLevel1"
})
public class BudgetaryCommitmentLevel1SearchResponseType
    extends SearchMessageResponseType
{

    @XmlElement(name = "BudgetaryCommitmentLevel1")
    protected List<BudgetaryCommitmentLevel1SearchType> budgetaryCommitmentLevel1;

    /**
     * Gets the value of the budgetaryCommitmentLevel1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the budgetaryCommitmentLevel1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBudgetaryCommitmentLevel1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BudgetaryCommitmentLevel1SearchType }
     * 
     * 
     */
    public List<BudgetaryCommitmentLevel1SearchType> getBudgetaryCommitmentLevel1() {
        if (budgetaryCommitmentLevel1 == null) {
            budgetaryCommitmentLevel1 = new ArrayList<BudgetaryCommitmentLevel1SearchType>();
        }
        return this.budgetaryCommitmentLevel1;
    }

}
