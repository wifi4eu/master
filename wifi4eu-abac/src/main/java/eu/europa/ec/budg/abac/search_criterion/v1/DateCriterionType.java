
package eu.europa.ec.budg.abac.search_criterion.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para DateCriterionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DateCriterionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="operator" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}DateCriterionOperatorType"/&gt;
 *         &lt;element name="value" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="value2" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="sort" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}SortType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateCriterionType", propOrder = {
    "operator",
    "value",
    "value2",
    "sort"
})
public class DateCriterionType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DateCriterionOperatorType operator;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar value;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar value2;
    protected SortType sort;

    /**
     * Obtiene el valor de la propiedad operator.
     * 
     * @return
     *     possible object is
     *     {@link DateCriterionOperatorType }
     *     
     */
    public DateCriterionOperatorType getOperator() {
        return operator;
    }

    /**
     * Define el valor de la propiedad operator.
     * 
     * @param value
     *     allowed object is
     *     {@link DateCriterionOperatorType }
     *     
     */
    public void setOperator(DateCriterionOperatorType value) {
        this.operator = value;
    }

    /**
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValue(XMLGregorianCalendar value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad value2.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValue2() {
        return value2;
    }

    /**
     * Define el valor de la propiedad value2.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValue2(XMLGregorianCalendar value) {
        this.value2 = value;
    }

    /**
     * Obtiene el valor de la propiedad sort.
     * 
     * @return
     *     possible object is
     *     {@link SortType }
     *     
     */
    public SortType getSort() {
        return sort;
    }

    /**
     * Define el valor de la propiedad sort.
     * 
     * @param value
     *     allowed object is
     *     {@link SortType }
     *     
     */
    public void setSort(SortType value) {
        this.sort = value;
    }

}
