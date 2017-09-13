
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.SearchMessageRequestType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel1SearchRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel1SearchRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}SearchMessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SearchCriteria" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BudgetaryCommitmentLevel1SearchCriteriaType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel1SearchRequestType", propOrder = {
    "searchCriteria"
})
public class BudgetaryCommitmentLevel1SearchRequestType
    extends SearchMessageRequestType
{

    @XmlElement(name = "SearchCriteria", required = true)
    protected BudgetaryCommitmentLevel1SearchCriteriaType searchCriteria;

    /**
     * Obtiene el valor de la propiedad searchCriteria.
     * 
     * @return
     *     possible object is
     *     {@link BudgetaryCommitmentLevel1SearchCriteriaType }
     *     
     */
    public BudgetaryCommitmentLevel1SearchCriteriaType getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * Define el valor de la propiedad searchCriteria.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetaryCommitmentLevel1SearchCriteriaType }
     *     
     */
    public void setSearchCriteria(BudgetaryCommitmentLevel1SearchCriteriaType value) {
        this.searchCriteria = value;
    }

}
