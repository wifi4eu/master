
package generated.jagate.model.address.v4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.coderef.V3.CodeRefType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for PostalAddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostalAddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HouseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PoBox" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cedex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NutsCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
 *         &lt;element name="Office" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostalAddressType", propOrder = {
    "street",
    "houseNumber",
    "poBox",
    "postalCode",
    "cedex",
    "city",
    "region",
    "nutsCode",
    "office",
    "additionalInformation",
    "countryCode"
})
public class PostalAddressType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Street")
    protected String street;
    @XmlElement(name = "HouseNumber")
    protected String houseNumber;
    @XmlElement(name = "PoBox")
    protected String poBox;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "Cedex")
    protected String cedex;
    @XmlElement(name = "City", required = true)
    protected String city;
    @XmlElement(name = "Region")
    protected String region;
    @XmlElement(name = "NutsCode")
    protected CodeRefType nutsCode;
    @XmlElement(name = "Office")
    protected String office;
    @XmlElement(name = "AdditionalInformation")
    protected String additionalInformation;
    @XmlElement(name = "CountryCode", required = true)
    protected CodeRefType countryCode;

    /**
     * Gets the value of the street property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Gets the value of the houseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets the value of the houseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseNumber(String value) {
        this.houseNumber = value;
    }

    /**
     * Gets the value of the poBox property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoBox() {
        return poBox;
    }

    /**
     * Sets the value of the poBox property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoBox(String value) {
        this.poBox = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the cedex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCedex() {
        return cedex;
    }

    /**
     * Sets the value of the cedex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCedex(String value) {
        this.cedex = value;
    }

    /**
     * Gets the value of the city property.
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
     * Sets the value of the city property.
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
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the nutsCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getNutsCode() {
        return nutsCode;
    }

    /**
     * Sets the value of the nutsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setNutsCode(CodeRefType value) {
        this.nutsCode = value;
    }

    /**
     * Gets the value of the office property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffice() {
        return office;
    }

    /**
     * Sets the value of the office property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffice(String value) {
        this.office = value;
    }

    /**
     * Gets the value of the additionalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets the value of the additionalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalInformation(String value) {
        this.additionalInformation = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setCountryCode(CodeRefType value) {
        this.countryCode = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PostalAddressType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PostalAddressType that = ((PostalAddressType) object);
        {
            String lhsStreet;
            lhsStreet = this.getStreet();
            String rhsStreet;
            rhsStreet = that.getStreet();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "street", lhsStreet), LocatorUtils.property(thatLocator, "street", rhsStreet), lhsStreet, rhsStreet)) {
                return false;
            }
        }
        {
            String lhsHouseNumber;
            lhsHouseNumber = this.getHouseNumber();
            String rhsHouseNumber;
            rhsHouseNumber = that.getHouseNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "houseNumber", lhsHouseNumber), LocatorUtils.property(thatLocator, "houseNumber", rhsHouseNumber), lhsHouseNumber, rhsHouseNumber)) {
                return false;
            }
        }
        {
            String lhsPoBox;
            lhsPoBox = this.getPoBox();
            String rhsPoBox;
            rhsPoBox = that.getPoBox();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "poBox", lhsPoBox), LocatorUtils.property(thatLocator, "poBox", rhsPoBox), lhsPoBox, rhsPoBox)) {
                return false;
            }
        }
        {
            String lhsPostalCode;
            lhsPostalCode = this.getPostalCode();
            String rhsPostalCode;
            rhsPostalCode = that.getPostalCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "postalCode", lhsPostalCode), LocatorUtils.property(thatLocator, "postalCode", rhsPostalCode), lhsPostalCode, rhsPostalCode)) {
                return false;
            }
        }
        {
            String lhsCedex;
            lhsCedex = this.getCedex();
            String rhsCedex;
            rhsCedex = that.getCedex();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cedex", lhsCedex), LocatorUtils.property(thatLocator, "cedex", rhsCedex), lhsCedex, rhsCedex)) {
                return false;
            }
        }
        {
            String lhsCity;
            lhsCity = this.getCity();
            String rhsCity;
            rhsCity = that.getCity();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "city", lhsCity), LocatorUtils.property(thatLocator, "city", rhsCity), lhsCity, rhsCity)) {
                return false;
            }
        }
        {
            String lhsRegion;
            lhsRegion = this.getRegion();
            String rhsRegion;
            rhsRegion = that.getRegion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "region", lhsRegion), LocatorUtils.property(thatLocator, "region", rhsRegion), lhsRegion, rhsRegion)) {
                return false;
            }
        }
        {
            CodeRefType lhsNutsCode;
            lhsNutsCode = this.getNutsCode();
            CodeRefType rhsNutsCode;
            rhsNutsCode = that.getNutsCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nutsCode", lhsNutsCode), LocatorUtils.property(thatLocator, "nutsCode", rhsNutsCode), lhsNutsCode, rhsNutsCode)) {
                return false;
            }
        }
        {
            String lhsOffice;
            lhsOffice = this.getOffice();
            String rhsOffice;
            rhsOffice = that.getOffice();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "office", lhsOffice), LocatorUtils.property(thatLocator, "office", rhsOffice), lhsOffice, rhsOffice)) {
                return false;
            }
        }
        {
            String lhsAdditionalInformation;
            lhsAdditionalInformation = this.getAdditionalInformation();
            String rhsAdditionalInformation;
            rhsAdditionalInformation = that.getAdditionalInformation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "additionalInformation", lhsAdditionalInformation), LocatorUtils.property(thatLocator, "additionalInformation", rhsAdditionalInformation), lhsAdditionalInformation, rhsAdditionalInformation)) {
                return false;
            }
        }
        {
            CodeRefType lhsCountryCode;
            lhsCountryCode = this.getCountryCode();
            CodeRefType rhsCountryCode;
            rhsCountryCode = that.getCountryCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "countryCode", lhsCountryCode), LocatorUtils.property(thatLocator, "countryCode", rhsCountryCode), lhsCountryCode, rhsCountryCode)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            String theStreet;
            theStreet = this.getStreet();
            strategy.appendField(locator, this, "street", buffer, theStreet);
        }
        {
            String theHouseNumber;
            theHouseNumber = this.getHouseNumber();
            strategy.appendField(locator, this, "houseNumber", buffer, theHouseNumber);
        }
        {
            String thePoBox;
            thePoBox = this.getPoBox();
            strategy.appendField(locator, this, "poBox", buffer, thePoBox);
        }
        {
            String thePostalCode;
            thePostalCode = this.getPostalCode();
            strategy.appendField(locator, this, "postalCode", buffer, thePostalCode);
        }
        {
            String theCedex;
            theCedex = this.getCedex();
            strategy.appendField(locator, this, "cedex", buffer, theCedex);
        }
        {
            String theCity;
            theCity = this.getCity();
            strategy.appendField(locator, this, "city", buffer, theCity);
        }
        {
            String theRegion;
            theRegion = this.getRegion();
            strategy.appendField(locator, this, "region", buffer, theRegion);
        }
        {
            CodeRefType theNutsCode;
            theNutsCode = this.getNutsCode();
            strategy.appendField(locator, this, "nutsCode", buffer, theNutsCode);
        }
        {
            String theOffice;
            theOffice = this.getOffice();
            strategy.appendField(locator, this, "office", buffer, theOffice);
        }
        {
            String theAdditionalInformation;
            theAdditionalInformation = this.getAdditionalInformation();
            strategy.appendField(locator, this, "additionalInformation", buffer, theAdditionalInformation);
        }
        {
            CodeRefType theCountryCode;
            theCountryCode = this.getCountryCode();
            strategy.appendField(locator, this, "countryCode", buffer, theCountryCode);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theStreet;
            theStreet = this.getStreet();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "street", theStreet), currentHashCode, theStreet);
        }
        {
            String theHouseNumber;
            theHouseNumber = this.getHouseNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "houseNumber", theHouseNumber), currentHashCode, theHouseNumber);
        }
        {
            String thePoBox;
            thePoBox = this.getPoBox();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "poBox", thePoBox), currentHashCode, thePoBox);
        }
        {
            String thePostalCode;
            thePostalCode = this.getPostalCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "postalCode", thePostalCode), currentHashCode, thePostalCode);
        }
        {
            String theCedex;
            theCedex = this.getCedex();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cedex", theCedex), currentHashCode, theCedex);
        }
        {
            String theCity;
            theCity = this.getCity();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "city", theCity), currentHashCode, theCity);
        }
        {
            String theRegion;
            theRegion = this.getRegion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "region", theRegion), currentHashCode, theRegion);
        }
        {
            CodeRefType theNutsCode;
            theNutsCode = this.getNutsCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nutsCode", theNutsCode), currentHashCode, theNutsCode);
        }
        {
            String theOffice;
            theOffice = this.getOffice();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "office", theOffice), currentHashCode, theOffice);
        }
        {
            String theAdditionalInformation;
            theAdditionalInformation = this.getAdditionalInformation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "additionalInformation", theAdditionalInformation), currentHashCode, theAdditionalInformation);
        }
        {
            CodeRefType theCountryCode;
            theCountryCode = this.getCountryCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "countryCode", theCountryCode), currentHashCode, theCountryCode);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
