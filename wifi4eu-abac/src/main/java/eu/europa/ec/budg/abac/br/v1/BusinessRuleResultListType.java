
package eu.europa.ec.budg.abac.br.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BusinessRuleResultListType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BusinessRuleResultListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BusinessRuleResult" type="{http://www.ec.europa.eu/budg/abac/br/v1}BusinessRuleResultType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessRuleResultListType", propOrder = {
    "businessRuleResult"
})
public class BusinessRuleResultListType {

    @XmlElement(name = "BusinessRuleResult", required = true)
    protected List<BusinessRuleResultType> businessRuleResult;

    /**
     * Gets the value of the businessRuleResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the businessRuleResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusinessRuleResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BusinessRuleResultType }
     * 
     * 
     */
    public List<BusinessRuleResultType> getBusinessRuleResult() {
        if (businessRuleResult == null) {
            businessRuleResult = new ArrayList<BusinessRuleResultType>();
        }
        return this.businessRuleResult;
    }

}
