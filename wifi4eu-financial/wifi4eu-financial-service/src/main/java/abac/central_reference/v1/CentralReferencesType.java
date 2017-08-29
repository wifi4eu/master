
package abac.central_reference.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CentralReferencesType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CentralReferencesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CentralReference" type="{http://www.ec.europa.eu/budg/abac/central_reference/v1}CentralReferenceType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CentralReferencesType", propOrder = {
    "centralReference"
})
public class CentralReferencesType {

    @XmlElement(name = "CentralReference", required = true)
    protected List<CentralReferenceType> centralReference;

    /**
     * Gets the value of the centralReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the centralReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCentralReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CentralReferenceType }
     * 
     * 
     */
    public List<CentralReferenceType> getCentralReference() {
        if (centralReference == null) {
            centralReference = new ArrayList<CentralReferenceType>();
        }
        return this.centralReference;
    }

}
