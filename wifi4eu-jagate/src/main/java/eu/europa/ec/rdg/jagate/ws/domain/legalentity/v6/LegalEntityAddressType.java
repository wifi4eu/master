
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

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
 * <p>Java class for LegalEntityAddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityAddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Street" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}StreetType"/>
 *         &lt;element name="Street2" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}StreetType" minOccurs="0"/>
 *         &lt;element name="Street3" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}StreetType" minOccurs="0"/>
 *         &lt;element name="PoBox" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="Region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntityAddressType", propOrder = {
    "street",
    "street2",
    "street3",
    "poBox",
    "postalCode",
    "city",
    "region",
    "country"
})
public class LegalEntityAddressType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Street", required = true)
    protected String street;
    @XmlElement(name = "Street2")
    protected String street2;
    @XmlElement(name = "Street3")
    protected String street3;
    @XmlElement(name = "PoBox")
    protected String poBox;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "City", required = true)
    protected String city;
    @XmlElement(name = "Region")
    protected String region;
    @XmlElement(name = "Country", required = true)
    protected CodeRefType country;

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
     * Gets the value of the street2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * Sets the value of the street2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet2(String value) {
        this.street2 = value;
    }

    /**
     * Gets the value of the street3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet3() {
        return street3;
    }

    /**
     * Sets the value of the street3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet3(String value) {
        this.street3 = value;
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
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setCountry(CodeRefType value) {
        this.country = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LegalEntityAddressType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LegalEntityAddressType that = ((LegalEntityAddressType) object);
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
            String lhsStreet2;
            lhsStreet2 = this.getStreet2();
            String rhsStreet2;
            rhsStreet2 = that.getStreet2();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "street2", lhsStreet2), LocatorUtils.property(thatLocator, "street2", rhsStreet2), lhsStreet2, rhsStreet2)) {
                return false;
            }
        }
        {
            String lhsStreet3;
            lhsStreet3 = this.getStreet3();
            String rhsStreet3;
            rhsStreet3 = that.getStreet3();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "street3", lhsStreet3), LocatorUtils.property(thatLocator, "street3", rhsStreet3), lhsStreet3, rhsStreet3)) {
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
            CodeRefType lhsCountry;
            lhsCountry = this.getCountry();
            CodeRefType rhsCountry;
            rhsCountry = that.getCountry();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "country", lhsCountry), LocatorUtils.property(thatLocator, "country", rhsCountry), lhsCountry, rhsCountry)) {
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
            String theStreet2;
            theStreet2 = this.getStreet2();
            strategy.appendField(locator, this, "street2", buffer, theStreet2);
        }
        {
            String theStreet3;
            theStreet3 = this.getStreet3();
            strategy.appendField(locator, this, "street3", buffer, theStreet3);
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
            CodeRefType theCountry;
            theCountry = this.getCountry();
            strategy.appendField(locator, this, "country", buffer, theCountry);
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
            String theStreet2;
            theStreet2 = this.getStreet2();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "street2", theStreet2), currentHashCode, theStreet2);
        }
        {
            String theStreet3;
            theStreet3 = this.getStreet3();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "street3", theStreet3), currentHashCode, theStreet3);
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
            CodeRefType theCountry;
            theCountry = this.getCountry();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "country", theCountry), currentHashCode, theCountry);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
