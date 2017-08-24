
package eu.europa.ec.budg.abac.legal_entity.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MailingAddressType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MailingAddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AddressName" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}NameType"/&gt;
 *         &lt;element name="City" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}CityType"/&gt;
 *         &lt;element name="ContactName" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}NameType" minOccurs="0"/&gt;
 *         &lt;element name="ContactTitle" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}TitleType" minOccurs="0"/&gt;
 *         &lt;element name="CountryCode" type="{http://www.ec.europa.eu/budg/abac/country/v1}CodeType"/&gt;
 *         &lt;element name="County" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}CountyType" minOccurs="0"/&gt;
 *         &lt;element name="EMailAddress" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}EMailAddressType" minOccurs="0"/&gt;
 *         &lt;element name="Fax" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}FaxType" minOccurs="0"/&gt;
 *         &lt;element name="LanguageCode" type="{http://www.ec.europa.eu/budg/abac/language/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="LineNumber" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}LineNumberType"/&gt;
 *         &lt;element name="POBox" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}POBoxType" minOccurs="0"/&gt;
 *         &lt;element name="PostCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}PostCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}RemarksType"/&gt;
 *         &lt;element name="StreetNr" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}StreetNrType"/&gt;
 *         &lt;element name="Telephone" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}TelephoneType" minOccurs="0"/&gt;
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
@XmlType(name = "MailingAddressType", propOrder = {
    "addressName",
    "city",
    "contactName",
    "contactTitle",
    "countryCode",
    "county",
    "eMailAddress",
    "fax",
    "languageCode",
    "lineNumber",
    "poBox",
    "postCode",
    "remarks",
    "streetNr",
    "telephone",
    "validFlag"
})
public class MailingAddressType {

    @XmlElement(name = "AddressName", required = true)
    protected String addressName;
    @XmlElement(name = "City", required = true)
    protected String city;
    @XmlElement(name = "ContactName")
    protected String contactName;
    @XmlElement(name = "ContactTitle")
    protected String contactTitle;
    @XmlElement(name = "CountryCode", required = true)
    protected String countryCode;
    @XmlElement(name = "County")
    protected String county;
    @XmlElement(name = "EMailAddress")
    protected String eMailAddress;
    @XmlElement(name = "Fax")
    protected String fax;
    @XmlElement(name = "LanguageCode")
    protected String languageCode;
    @XmlElement(name = "LineNumber", required = true)
    protected BigInteger lineNumber;
    @XmlElement(name = "POBox")
    protected String poBox;
    @XmlElement(name = "PostCode")
    protected String postCode;
    @XmlElement(name = "Remarks", required = true)
    protected String remarks;
    @XmlElement(name = "StreetNr", required = true)
    protected String streetNr;
    @XmlElement(name = "Telephone")
    protected String telephone;
    @XmlElement(name = "ValidFlag")
    protected boolean validFlag;

    /**
     * Obtiene el valor de la propiedad addressName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * Define el valor de la propiedad addressName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressName(String value) {
        this.addressName = value;
    }

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
     * Obtiene el valor de la propiedad contactName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Define el valor de la propiedad contactName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Obtiene el valor de la propiedad contactTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactTitle() {
        return contactTitle;
    }

    /**
     * Define el valor de la propiedad contactTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactTitle(String value) {
        this.contactTitle = value;
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
     * Obtiene el valor de la propiedad county.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounty() {
        return county;
    }

    /**
     * Define el valor de la propiedad county.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounty(String value) {
        this.county = value;
    }

    /**
     * Obtiene el valor de la propiedad eMailAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMailAddress() {
        return eMailAddress;
    }

    /**
     * Define el valor de la propiedad eMailAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMailAddress(String value) {
        this.eMailAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad fax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Define el valor de la propiedad fax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Obtiene el valor de la propiedad languageCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * Define el valor de la propiedad languageCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageCode(String value) {
        this.languageCode = value;
    }

    /**
     * Obtiene el valor de la propiedad lineNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLineNumber() {
        return lineNumber;
    }

    /**
     * Define el valor de la propiedad lineNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLineNumber(BigInteger value) {
        this.lineNumber = value;
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
     * Obtiene el valor de la propiedad remarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define el valor de la propiedad remarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
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

    /**
     * Obtiene el valor de la propiedad telephone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Define el valor de la propiedad telephone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
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
