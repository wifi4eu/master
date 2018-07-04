
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * <p>Java class for NaturalPersonBirthDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NaturalPersonBirthDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CountryOfBirthCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="CityOfBirth" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaturalPersonBirthDataType", propOrder = {
    "countryOfBirthCode",
    "dateOfBirth",
    "cityOfBirth"
})
public class NaturalPersonBirthDataType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "CountryOfBirthCode", required = true)
    protected CodeRefType countryOfBirthCode;
    @XmlElement(name = "DateOfBirth", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfBirth;
    @XmlElement(name = "CityOfBirth", required = true)
    protected String cityOfBirth;

    /**
     * Gets the value of the countryOfBirthCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getCountryOfBirthCode() {
        return countryOfBirthCode;
    }

    /**
     * Sets the value of the countryOfBirthCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setCountryOfBirthCode(CodeRefType value) {
        this.countryOfBirthCode = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the cityOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityOfBirth() {
        return cityOfBirth;
    }

    /**
     * Sets the value of the cityOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityOfBirth(String value) {
        this.cityOfBirth = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof NaturalPersonBirthDataType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final NaturalPersonBirthDataType that = ((NaturalPersonBirthDataType) object);
        {
            CodeRefType lhsCountryOfBirthCode;
            lhsCountryOfBirthCode = this.getCountryOfBirthCode();
            CodeRefType rhsCountryOfBirthCode;
            rhsCountryOfBirthCode = that.getCountryOfBirthCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "countryOfBirthCode", lhsCountryOfBirthCode), LocatorUtils.property(thatLocator, "countryOfBirthCode", rhsCountryOfBirthCode), lhsCountryOfBirthCode, rhsCountryOfBirthCode)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDateOfBirth;
            lhsDateOfBirth = this.getDateOfBirth();
            XMLGregorianCalendar rhsDateOfBirth;
            rhsDateOfBirth = that.getDateOfBirth();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateOfBirth", lhsDateOfBirth), LocatorUtils.property(thatLocator, "dateOfBirth", rhsDateOfBirth), lhsDateOfBirth, rhsDateOfBirth)) {
                return false;
            }
        }
        {
            String lhsCityOfBirth;
            lhsCityOfBirth = this.getCityOfBirth();
            String rhsCityOfBirth;
            rhsCityOfBirth = that.getCityOfBirth();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cityOfBirth", lhsCityOfBirth), LocatorUtils.property(thatLocator, "cityOfBirth", rhsCityOfBirth), lhsCityOfBirth, rhsCityOfBirth)) {
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
            CodeRefType theCountryOfBirthCode;
            theCountryOfBirthCode = this.getCountryOfBirthCode();
            strategy.appendField(locator, this, "countryOfBirthCode", buffer, theCountryOfBirthCode);
        }
        {
            XMLGregorianCalendar theDateOfBirth;
            theDateOfBirth = this.getDateOfBirth();
            strategy.appendField(locator, this, "dateOfBirth", buffer, theDateOfBirth);
        }
        {
            String theCityOfBirth;
            theCityOfBirth = this.getCityOfBirth();
            strategy.appendField(locator, this, "cityOfBirth", buffer, theCityOfBirth);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            CodeRefType theCountryOfBirthCode;
            theCountryOfBirthCode = this.getCountryOfBirthCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "countryOfBirthCode", theCountryOfBirthCode), currentHashCode, theCountryOfBirthCode);
        }
        {
            XMLGregorianCalendar theDateOfBirth;
            theDateOfBirth = this.getDateOfBirth();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateOfBirth", theDateOfBirth), currentHashCode, theDateOfBirth);
        }
        {
            String theCityOfBirth;
            theCityOfBirth = this.getCityOfBirth();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cityOfBirth", theCityOfBirth), currentHashCode, theCityOfBirth);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
