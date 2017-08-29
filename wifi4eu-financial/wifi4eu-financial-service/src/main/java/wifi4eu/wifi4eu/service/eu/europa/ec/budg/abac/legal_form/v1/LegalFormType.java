
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_form.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LegalFormType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalFormType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/legal_form/v1}LegalFormCodeType"/&gt;
 *         &lt;element name="CountryCode" type="{http://www.ec.europa.eu/budg/abac/country/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/legal_form/v1}LegalFormDescriptionType"/&gt;
 *         &lt;element name="OnlineFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}OnlineFlagType"/&gt;
 *         &lt;element name="ValidFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}ValidFlagType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalFormType", propOrder = {
    "code",
    "countryCode",
    "description",
    "onlineFlag",
    "validFlag"
})
public class LegalFormType {

    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "OnlineFlag")
    protected boolean onlineFlag;
    @XmlElement(name = "ValidFlag")
    protected boolean validFlag;

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
     * Obtiene el valor de la propiedad countryCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Define el valor de la propiedad countryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
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
     * Obtiene el valor de la propiedad onlineFlag.
     * 
     */
    public boolean isOnlineFlag() {
        return onlineFlag;
    }

    /**
     * Define el valor de la propiedad onlineFlag.
     * 
     */
    public void setOnlineFlag(boolean value) {
        this.onlineFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad validFlag.
     * 
     */
    public boolean isValidFlag() {
        return validFlag;
    }

    /**
     * Define el valor de la propiedad validFlag.
     * 
     */
    public void setValidFlag(boolean value) {
        this.validFlag = value;
    }

}
