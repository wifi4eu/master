
package abac.search_criterion.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SortType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SortType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="ascending" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="descending" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortType", propOrder = {
    "ascending",
    "descending"
})
public class SortType {

    protected Byte ascending;
    protected Byte descending;

    /**
     * Obtiene el valor de la propiedad ascending.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getAscending() {
        return ascending;
    }

    /**
     * Define el valor de la propiedad ascending.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setAscending(Byte value) {
        this.ascending = value;
    }

    /**
     * Obtiene el valor de la propiedad descending.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getDescending() {
        return descending;
    }

    /**
     * Define el valor de la propiedad descending.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setDescending(Byte value) {
        this.descending = value;
    }

}
