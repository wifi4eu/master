
package eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CommitmentPositionsGetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CommitmentPositionsGetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BudgetaryCommitmentLevel2Position" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BudgetaryCommitmentLevel2PositionGetType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommitmentPositionsGetType", propOrder = {
    "budgetaryCommitmentLevel2Position"
})
public class CommitmentPositionsGetType {

    @XmlElement(name = "BudgetaryCommitmentLevel2Position", required = true)
    protected List<BudgetaryCommitmentLevel2PositionGetType> budgetaryCommitmentLevel2Position;

    /**
     * Gets the value of the budgetaryCommitmentLevel2Position property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the budgetaryCommitmentLevel2Position property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBudgetaryCommitmentLevel2Position().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BudgetaryCommitmentLevel2PositionGetType }
     * 
     * 
     */
    public List<BudgetaryCommitmentLevel2PositionGetType> getBudgetaryCommitmentLevel2Position() {
        if (budgetaryCommitmentLevel2Position == null) {
            budgetaryCommitmentLevel2Position = new ArrayList<BudgetaryCommitmentLevel2PositionGetType>();
        }
        return this.budgetaryCommitmentLevel2Position;
    }

}
