
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.search_criterion.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TextCriterionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TextCriterionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="operator" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionOperatorType"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="value2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "TextCriterionType", propOrder = {
    "operator",
    "value",
    "value2",
    "sort"
})
public class TextCriterionType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TextCriterionOperatorType operator;
    protected String value;
    protected String value2;
    protected SortType sort;

    /**
     * Obtiene el valor de la propiedad operator.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionOperatorType }
     *     
     */
    public TextCriterionOperatorType getOperator() {
        return operator;
    }

    /**
     * Define el valor de la propiedad operator.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionOperatorType }
     *     
     */
    public void setOperator(TextCriterionOperatorType value) {
        this.operator = value;
    }

    /**
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad value2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue2() {
        return value2;
    }

    /**
     * Define el valor de la propiedad value2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue2(String value) {
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
