
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.search_criterion.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para NumberCriterionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="NumberCriterionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="operator" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}NumberCriterionOperatorType"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="value2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
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
@XmlType(name = "NumberCriterionType", propOrder = {
    "operator",
    "value",
    "value2",
    "sort"
})
public class NumberCriterionType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected NumberCriterionOperatorType operator;
    @XmlElement(required = true)
    protected BigDecimal value;
    protected BigDecimal value2;
    protected SortType sort;

    /**
     * Obtiene el valor de la propiedad operator.
     * 
     * @return
     *     possible object is
     *     {@link NumberCriterionOperatorType }
     *     
     */
    public NumberCriterionOperatorType getOperator() {
        return operator;
    }

    /**
     * Define el valor de la propiedad operator.
     * 
     * @param value
     *     allowed object is
     *     {@link NumberCriterionOperatorType }
     *     
     */
    public void setOperator(NumberCriterionOperatorType value) {
        this.operator = value;
    }

    /**
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad value2.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue2() {
        return value2;
    }

    /**
     * Define el valor de la propiedad value2.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue2(BigDecimal value) {
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
