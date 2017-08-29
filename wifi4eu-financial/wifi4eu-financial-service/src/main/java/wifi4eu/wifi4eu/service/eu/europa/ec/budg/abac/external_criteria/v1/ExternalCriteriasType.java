
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.external_criteria.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ExternalCriteriasType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ExternalCriteriasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExternalCriteria" type="{http://www.ec.europa.eu/budg/abac/external_criteria/v1}ExternalCriteriaType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalCriteriasType", propOrder = {
    "externalCriteria"
})
public class ExternalCriteriasType {

    @XmlElement(name = "ExternalCriteria", required = true)
    protected List<ExternalCriteriaType> externalCriteria;

    /**
     * Gets the value of the externalCriteria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalCriteria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalCriteria().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalCriteriaType }
     * 
     * 
     */
    public List<ExternalCriteriaType> getExternalCriteria() {
        if (externalCriteria == null) {
            externalCriteria = new ArrayList<ExternalCriteriaType>();
        }
        return this.externalCriteria;
    }

}
