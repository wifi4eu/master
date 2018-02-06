
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CommitmentPositionsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CommitmentPositionsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BudgetaryCommitmentLevel1Position" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BudgetaryCommitmentLevel1PositionCreateType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommitmentPositionsType", propOrder = {
    "budgetaryCommitmentLevel1Position"
})
public class CommitmentPositionsType {

    @XmlElement(name = "BudgetaryCommitmentLevel1Position", required = true)
    protected List<BudgetaryCommitmentLevel1PositionCreateType> budgetaryCommitmentLevel1Position;

    /**
     * Gets the value of the budgetaryCommitmentLevel1Position property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the budgetaryCommitmentLevel1Position property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBudgetaryCommitmentLevel1Position().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BudgetaryCommitmentLevel1PositionCreateType }
     * 
     * 
     */
    public List<BudgetaryCommitmentLevel1PositionCreateType> getBudgetaryCommitmentLevel1Position() {
        if (budgetaryCommitmentLevel1Position == null) {
            budgetaryCommitmentLevel1Position = new ArrayList<BudgetaryCommitmentLevel1PositionCreateType>();
        }
        return this.budgetaryCommitmentLevel1Position;
    }

}
