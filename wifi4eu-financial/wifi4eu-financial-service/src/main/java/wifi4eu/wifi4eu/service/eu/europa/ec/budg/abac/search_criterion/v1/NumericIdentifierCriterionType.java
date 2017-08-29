
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.search_criterion.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para NumericIdentifierCriterionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="NumericIdentifierCriterionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="operator" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}NumericIdentifierCriterionOperatorType"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="value2" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
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
@XmlType(name = "NumericIdentifierCriterionType", propOrder = {
    "operator",
    "value",
    "value2",
    "sort"
})
public class NumericIdentifierCriterionType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected NumericIdentifierCriterionOperatorType operator;
    protected BigInteger value;
    protected BigInteger value2;
    protected SortType sort;

    /**
     * Obtiene el valor de la propiedad operator.
     * 
     * @return
     *     possible object is
     *     {@link NumericIdentifierCriterionOperatorType }
     *     
     */
    public NumericIdentifierCriterionOperatorType getOperator() {
        return operator;
    }

    /**
     * Define el valor de la propiedad operator.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericIdentifierCriterionOperatorType }
     *     
     */
    public void setOperator(NumericIdentifierCriterionOperatorType value) {
        this.operator = value;
    }

    /**
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValue(BigInteger value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad value2.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValue2() {
        return value2;
    }

    /**
     * Define el valor de la propiedad value2.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValue2(BigInteger value) {
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
