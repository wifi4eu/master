
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.address.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AddressType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="City" type="{http://www.ec.europa.eu/budg/abac/address/v1}CityType"/&gt;
 *         &lt;element name="CountryCode" type="{http://www.ec.europa.eu/budg/abac/country/v1}CodeType"/&gt;
 *         &lt;element name="POBox" type="{http://www.ec.europa.eu/budg/abac/address/v1}POBoxType" minOccurs="0"/&gt;
 *         &lt;element name="PostCode" type="{http://www.ec.europa.eu/budg/abac/address/v1}PostCodeType" minOccurs="0"/&gt;
 *         &lt;element name="StreetNr" type="{http://www.ec.europa.eu/budg/abac/address/v1}StreetNrType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
    "city",
    "countryCode",
    "poBox",
    "postCode",
    "streetNr"
})
@XmlSeeAlso({
    BankAddressType.class,
    BankAccountAddressType.class
})
public abstract class AddressType {

    @XmlElement(name = "City", required = true)
    protected String city;
    @XmlElement(name = "CountryCode", required = true)
    protected String countryCode;
    @XmlElement(name = "POBox")
    protected String poBox;
    @XmlElement(name = "PostCode")
    protected String postCode;
    @XmlElement(name = "StreetNr", required = true)
    protected String streetNr;

    /**
     * Obtiene el valor de la propiedad city.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Define el valor de la propiedad city.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
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
     * Obtiene el valor de la propiedad poBox.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOBox() {
        return poBox;
    }

    /**
     * Define el valor de la propiedad poBox.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOBox(String value) {
        this.poBox = value;
    }

    /**
     * Obtiene el valor de la propiedad postCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Define el valor de la propiedad postCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCode(String value) {
        this.postCode = value;
    }

    /**
     * Obtiene el valor de la propiedad streetNr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNr() {
        return streetNr;
    }

    /**
     * Define el valor de la propiedad streetNr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNr(String value) {
        this.streetNr = value;
    }

}
