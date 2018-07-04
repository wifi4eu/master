
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
 * <p>Java class for AbstractNaturalBody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractNaturalBody">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}NaturalPersonNameGroup"/>
 *         &lt;element name="address" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}LegalEntityAddressType"/>
 *         &lt;element name="LanguageCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractNaturalBody", propOrder = {
    "familyName",
    "firstName",
    "address",
    "languageCode"
})
@XmlSeeAlso({
    NaturalBodyExMemberOfPersonnel.class,
    NaturalBodyMemberOfPersonnelExcluded.class
})
public class AbstractNaturalBody
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "FamilyName", required = true)
    protected String familyName;
    @XmlElement(name = "FirstName", required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected LegalEntityAddressType address;
    @XmlElement(name = "LanguageCode", required = true)
    protected CodeRefType languageCode;

    /**
     * Gets the value of the familyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Sets the value of the familyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyName(String value) {
        this.familyName = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AbstractNaturalBody)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AbstractNaturalBody that = ((AbstractNaturalBody) object);
        {
            String lhsFamilyName;
            lhsFamilyName = this.getFamilyName();
            String rhsFamilyName;
            rhsFamilyName = that.getFamilyName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "familyName", lhsFamilyName), LocatorUtils.property(thatLocator, "familyName", rhsFamilyName), lhsFamilyName, rhsFamilyName)) {
                return false;
            }
        }
        {
            String lhsFirstName;
            lhsFirstName = this.getFirstName();
            String rhsFirstName;
            rhsFirstName = that.getFirstName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "firstName", lhsFirstName), LocatorUtils.property(thatLocator, "firstName", rhsFirstName), lhsFirstName, rhsFirstName)) {
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
            CodeRefType lhsLanguageCode;
            lhsLanguageCode = this.getLanguageCode();
            CodeRefType rhsLanguageCode;
            rhsLanguageCode = that.getLanguageCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "languageCode", lhsLanguageCode), LocatorUtils.property(thatLocator, "languageCode", rhsLanguageCode), lhsLanguageCode, rhsLanguageCode)) {
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
            String theFamilyName;
            theFamilyName = this.getFamilyName();
            strategy.appendField(locator, this, "familyName", buffer, theFamilyName);
        }
        {
            String theFirstName;
            theFirstName = this.getFirstName();
            strategy.appendField(locator, this, "firstName", buffer, theFirstName);
        }
        {
            LegalEntityAddressType theAddress;
            theAddress = this.getAddress();
            strategy.appendField(locator, this, "address", buffer, theAddress);
        }
        {
            CodeRefType theLanguageCode;
            theLanguageCode = this.getLanguageCode();
            strategy.appendField(locator, this, "languageCode", buffer, theLanguageCode);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theFamilyName;
            theFamilyName = this.getFamilyName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "familyName", theFamilyName), currentHashCode, theFamilyName);
        }
        {
            String theFirstName;
            theFirstName = this.getFirstName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "firstName", theFirstName), currentHashCode, theFirstName);
        }
        {
            LegalEntityAddressType theAddress;
            theAddress = this.getAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "address", theAddress), currentHashCode, theAddress);
        }
        {
            CodeRefType theLanguageCode;
            theLanguageCode = this.getLanguageCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "languageCode", theLanguageCode), currentHashCode, theLanguageCode);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
