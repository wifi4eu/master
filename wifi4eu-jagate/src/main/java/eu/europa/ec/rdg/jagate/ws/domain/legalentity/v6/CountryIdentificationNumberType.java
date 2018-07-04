
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
 * <p>Java class for CountryIdentificationNumberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CountryIdentificationNumberType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identificationNumber" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="identificationType" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}CountryIdentificationDocumentType"/>
 *         &lt;element name="country" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountryIdentificationNumberType", propOrder = {
    "identificationNumber",
    "identificationType",
    "country"
})
public class CountryIdentificationNumberType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String identificationNumber;
    @XmlElement(required = true)
    protected CountryIdentificationDocumentType identificationType;
    @XmlElement(required = true)
    protected CodeRefType country;

    /**
     * Gets the value of the identificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Sets the value of the identificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationNumber(String value) {
        this.identificationNumber = value;
    }

    /**
     * Gets the value of the identificationType property.
     * 
     * @return
     *     possible object is
     *     {@link CountryIdentificationDocumentType }
     *     
     */
    public CountryIdentificationDocumentType getIdentificationType() {
        return identificationType;
    }

    /**
     * Sets the value of the identificationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryIdentificationDocumentType }
     *     
     */
    public void setIdentificationType(CountryIdentificationDocumentType value) {
        this.identificationType = value;
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
        if (!(object instanceof CountryIdentificationNumberType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CountryIdentificationNumberType that = ((CountryIdentificationNumberType) object);
        {
            String lhsIdentificationNumber;
            lhsIdentificationNumber = this.getIdentificationNumber();
            String rhsIdentificationNumber;
            rhsIdentificationNumber = that.getIdentificationNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "identificationNumber", lhsIdentificationNumber), LocatorUtils.property(thatLocator, "identificationNumber", rhsIdentificationNumber), lhsIdentificationNumber, rhsIdentificationNumber)) {
                return false;
            }
        }
        {
            CountryIdentificationDocumentType lhsIdentificationType;
            lhsIdentificationType = this.getIdentificationType();
            CountryIdentificationDocumentType rhsIdentificationType;
            rhsIdentificationType = that.getIdentificationType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "identificationType", lhsIdentificationType), LocatorUtils.property(thatLocator, "identificationType", rhsIdentificationType), lhsIdentificationType, rhsIdentificationType)) {
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
            String theIdentificationNumber;
            theIdentificationNumber = this.getIdentificationNumber();
            strategy.appendField(locator, this, "identificationNumber", buffer, theIdentificationNumber);
        }
        {
            CountryIdentificationDocumentType theIdentificationType;
            theIdentificationType = this.getIdentificationType();
            strategy.appendField(locator, this, "identificationType", buffer, theIdentificationType);
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
            String theIdentificationNumber;
            theIdentificationNumber = this.getIdentificationNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "identificationNumber", theIdentificationNumber), currentHashCode, theIdentificationNumber);
        }
        {
            CountryIdentificationDocumentType theIdentificationType;
            theIdentificationType = this.getIdentificationType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "identificationType", theIdentificationType), currentHashCode, theIdentificationType);
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
