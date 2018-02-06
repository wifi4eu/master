
package eu.europa.ec.budg.abac.country.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CountryType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CountryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/country/v1}CodeType"/&gt;
 *         &lt;element name="CurrencyIso3Code" type="{http://www.ec.europa.eu/budg/abac/country/v1}CurrencyCodeType" minOccurs="0"/&gt;
 *         &lt;element name="IsPartOfEu" type="{http://www.ec.europa.eu/budg/abac/country/v1}IsPartOfEuType"/&gt;
 *         &lt;element name="Name" type="{http://www.ec.europa.eu/budg/abac/country/v1}NameType"/&gt;
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
@XmlType(name = "CountryType", propOrder = {
    "code",
    "currencyIso3Code",
    "isPartOfEu",
    "name",
    "validFlag"
})
public class CountryType {

    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "CurrencyIso3Code")
    protected String currencyIso3Code;
    @XmlElement(name = "IsPartOfEu")
    protected boolean isPartOfEu;
    @XmlElement(name = "Name", required = true)
    protected String name;
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
     * Obtiene el valor de la propiedad currencyIso3Code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyIso3Code() {
        return currencyIso3Code;
    }

    /**
     * Define el valor de la propiedad currencyIso3Code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyIso3Code(String value) {
        this.currencyIso3Code = value;
    }

    /**
     * Obtiene el valor de la propiedad isPartOfEu.
     * 
     */
    public boolean isIsPartOfEu() {
        return isPartOfEu;
    }

    /**
     * Define el valor de la propiedad isPartOfEu.
     * 
     */
    public void setIsPartOfEu(boolean value) {
        this.isPartOfEu = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
