
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.prefinancing_clearing.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PrefinancingClearingsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PrefinancingClearingsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PrefinancingClearing" type="{http://www.ec.europa.eu/budg/abac/prefinancing_clearing/v1}PrefinancingClearingType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrefinancingClearingsType", propOrder = {
    "prefinancingClearing"
})
public class PrefinancingClearingsType {

    @XmlElement(name = "PrefinancingClearing", required = true)
    protected List<PrefinancingClearingType> prefinancingClearing;

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
     * {@link PrefinancingClearingType }
     * 
     * 
     */
    public List<PrefinancingClearingType> getPrefinancingClearing() {
        if (prefinancingClearing == null) {
            prefinancingClearing = new ArrayList<PrefinancingClearingType>();
        }
        return this.prefinancingClearing;
    }

}
