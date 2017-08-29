
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.early_warning.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EarlyWarningSubCodeType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EarlyWarningSubCodeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}CodeType"/&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}DescriptionType"/&gt;
 *         &lt;element name="MaximumValidity" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}MaximumValidityType"/&gt;
 *         &lt;element name="Requestor" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}RequestorType"/&gt;
 *         &lt;element name="Severity" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}SeverityType"/&gt;
 *         &lt;element name="SubCode" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}SubCodeType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EarlyWarningSubCodeType", propOrder = {
    "code",
    "description",
    "maximumValidity",
    "requestor",
    "severity",
    "subCode"
})
public class EarlyWarningSubCodeType {

    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "MaximumValidity", required = true)
    protected BigInteger maximumValidity;
    @XmlElement(name = "Requestor", required = true)
    protected String requestor;
    @XmlElement(name = "Severity")
    protected int severity;
    @XmlElement(name = "SubCode", required = true)
    protected String subCode;

    /**
     * Obtiene el valor de la propiedad code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Define el valor de la propiedad code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad maximumValidity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumValidity() {
        return maximumValidity;
    }

    /**
     * Define el valor de la propiedad maximumValidity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaximumValidity(BigInteger value) {
        this.maximumValidity = value;
    }

    /**
     * Obtiene el valor de la propiedad requestor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestor() {
        return requestor;
    }

    /**
     * Define el valor de la propiedad requestor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestor(String value) {
        this.requestor = value;
    }

    /**
     * Obtiene el valor de la propiedad severity.
     * 
     */
    public int getSeverity() {
        return severity;
    }

    /**
     * Define el valor de la propiedad severity.
     * 
     */
    public void setSeverity(int value) {
        this.severity = value;
    }

    /**
     * Obtiene el valor de la propiedad subCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubCode() {
        return subCode;
    }

    /**
     * Define el valor de la propiedad subCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubCode(String value) {
        this.subCode = value;
    }

}
