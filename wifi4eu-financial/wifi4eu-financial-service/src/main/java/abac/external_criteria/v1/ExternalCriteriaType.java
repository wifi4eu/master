
package abac.external_criteria.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ExternalCriteriaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ExternalCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExternalCriteriaCode" type="{http://www.ec.europa.eu/budg/abac/external_criteria_code/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalCriteriaTypeCode" type="{http://www.ec.europa.eu/budg/abac/external_criteria_type/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalCriteriaValue" type="{http://www.ec.europa.eu/budg/abac/external_criteria/v1}ValueType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalCriteriaType", propOrder = {
    "externalCriteriaCode",
    "externalCriteriaTypeCode",
    "externalCriteriaValue"
})
public class ExternalCriteriaType {

    @XmlElement(name = "ExternalCriteriaCode")
    protected String externalCriteriaCode;
    @XmlElement(name = "ExternalCriteriaTypeCode")
    protected String externalCriteriaTypeCode;
    @XmlElement(name = "ExternalCriteriaValue")
    protected String externalCriteriaValue;

    /**
     * Obtiene el valor de la propiedad externalCriteriaCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalCriteriaCode() {
        return externalCriteriaCode;
    }

    /**
     * Define el valor de la propiedad externalCriteriaCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalCriteriaCode(String value) {
        this.externalCriteriaCode = value;
    }

    /**
     * Obtiene el valor de la propiedad externalCriteriaTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalCriteriaTypeCode() {
        return externalCriteriaTypeCode;
    }

    /**
     * Define el valor de la propiedad externalCriteriaTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalCriteriaTypeCode(String value) {
        this.externalCriteriaTypeCode = value;
    }

    /**
     * Obtiene el valor de la propiedad externalCriteriaValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalCriteriaValue() {
        return externalCriteriaValue;
    }

    /**
     * Define el valor de la propiedad externalCriteriaValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalCriteriaValue(String value) {
        this.externalCriteriaValue = value;
    }

}
