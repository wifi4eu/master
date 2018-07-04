
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
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
 * <p>Java class for AbstractLawBody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractLawBody">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LanguageCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="OfficialName" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}LENameString"/>
 *         &lt;element name="Address" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}LegalEntityAddressType"/>
 *         &lt;element name="Acronym" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractLawBody", propOrder = {
    "languageCode",
    "officialName",
    "address",
    "acronym",
    "vat"
})
@XmlSeeAlso({
    PublicLawBody.class,
    PrivateLawBody.class
})
public class AbstractLawBody
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "LanguageCode", required = true)
    protected CodeRefType languageCode;
    @XmlElement(name = "OfficialName", required = true)
    protected String officialName;
    @XmlElement(name = "Address", required = true)
    protected LegalEntityAddressType address;
    @XmlElement(name = "Acronym")
    protected String acronym;
    @XmlElement(name = "VAT")
    protected String vat;

    /**
     * Gets the value of the languageCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getLanguageCode() {
        return languageCode;
    }

    /**
     * Sets the value of the languageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setLanguageCode(CodeRefType value) {
        this.languageCode = value;
    }

    /**
     * Gets the value of the officialName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficialName() {
        return officialName;
    }

    /**
     * Sets the value of the officialName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficialName(String value) {
        this.officialName = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityAddressType }
     *     
     */
    public LegalEntityAddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityAddressType }
     *     
     */
    public void setAddress(LegalEntityAddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the acronym property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * Sets the value of the acronym property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcronym(String value) {
        this.acronym = value;
    }

    /**
     * Gets the value of the vat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVAT() {
        return vat;
    }

    /**
     * Sets the value of the vat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVAT(String value) {
        this.vat = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AbstractLawBody)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AbstractLawBody that = ((AbstractLawBody) object);
        {
            CodeRefType lhsLanguageCode;
            lhsLanguageCode = this.getLanguageCode();
            CodeRefType rhsLanguageCode;
            rhsLanguageCode = that.getLanguageCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "languageCode", lhsLanguageCode), LocatorUtils.property(thatLocator, "languageCode", rhsLanguageCode), lhsLanguageCode, rhsLanguageCode)) {
                return false;
            }
        }
        {
            String lhsOfficialName;
            lhsOfficialName = this.getOfficialName();
            String rhsOfficialName;
            rhsOfficialName = that.getOfficialName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "officialName", lhsOfficialName), LocatorUtils.property(thatLocator, "officialName", rhsOfficialName), lhsOfficialName, rhsOfficialName)) {
                return false;
            }
        }
        {
            LegalEntityAddressType lhsAddress;
            lhsAddress = this.getAddress();
            LegalEntityAddressType rhsAddress;
            rhsAddress = that.getAddress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "address", lhsAddress), LocatorUtils.property(thatLocator, "address", rhsAddress), lhsAddress, rhsAddress)) {
                return false;
            }
        }
        {
            String lhsAcronym;
            lhsAcronym = this.getAcronym();
            String rhsAcronym;
            rhsAcronym = that.getAcronym();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "acronym", lhsAcronym), LocatorUtils.property(thatLocator, "acronym", rhsAcronym), lhsAcronym, rhsAcronym)) {
                return false;
            }
        }
        {
            String lhsVAT;
            lhsVAT = this.getVAT();
            String rhsVAT;
            rhsVAT = that.getVAT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vat", lhsVAT), LocatorUtils.property(thatLocator, "vat", rhsVAT), lhsVAT, rhsVAT)) {
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
            CodeRefType theLanguageCode;
            theLanguageCode = this.getLanguageCode();
            strategy.appendField(locator, this, "languageCode", buffer, theLanguageCode);
        }
        {
            String theOfficialName;
            theOfficialName = this.getOfficialName();
            strategy.appendField(locator, this, "officialName", buffer, theOfficialName);
        }
        {
            LegalEntityAddressType theAddress;
            theAddress = this.getAddress();
            strategy.appendField(locator, this, "address", buffer, theAddress);
        }
        {
            String theAcronym;
            theAcronym = this.getAcronym();
            strategy.appendField(locator, this, "acronym", buffer, theAcronym);
        }
        {
            String theVAT;
            theVAT = this.getVAT();
            strategy.appendField(locator, this, "vat", buffer, theVAT);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            CodeRefType theLanguageCode;
            theLanguageCode = this.getLanguageCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "languageCode", theLanguageCode), currentHashCode, theLanguageCode);
        }
        {
            String theOfficialName;
            theOfficialName = this.getOfficialName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "officialName", theOfficialName), currentHashCode, theOfficialName);
        }
        {
            LegalEntityAddressType theAddress;
            theAddress = this.getAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "address", theAddress), currentHashCode, theAddress);
        }
        {
            String theAcronym;
            theAcronym = this.getAcronym();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acronym", theAcronym), currentHashCode, theAcronym);
        }
        {
            String theVAT;
            theVAT = this.getVAT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vat", theVAT), currentHashCode, theVAT);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
