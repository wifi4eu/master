
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.prefinancing_clearing.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PrefinancingClearingsWithEuroType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PrefinancingClearingsWithEuroType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PrefinancingClearing" type="{http://www.ec.europa.eu/budg/abac/prefinancing_clearing/v1}PrefinancingClearingWithEuroType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrefinancingClearingsWithEuroType", propOrder = {
    "prefinancingClearing"
})
public class PrefinancingClearingsWithEuroType {

    @XmlElement(name = "PrefinancingClearing", required = true)
    protected List<PrefinancingClearingWithEuroType> prefinancingClearing;

    /**
     * Gets the value of the prefinancingClearing property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prefinancingClearing property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrefinancingClearing().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrefinancingClearingWithEuroType }
     * 
     * 
     */
    public List<PrefinancingClearingWithEuroType> getPrefinancingClearing() {
        if (prefinancingClearing == null) {
            prefinancingClearing = new ArrayList<PrefinancingClearingWithEuroType>();
        }
        return this.prefinancingClearing;
    }

}
