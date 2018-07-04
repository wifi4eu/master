
package eu.europa.ec.research.fp.model.legalentity.v11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import generated.jagate.model.coderef.V3.CodeRefType;
import generated.jagate.modelperson.v4.PersonIdentificationType;
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
 * <p>Java class for IndividualRegistrationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualRegistrationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identification" type="{http://ec.europa.eu/research/fp/model/person/V4}PersonIdentificationType"/>
 *         &lt;element name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="BirthPlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BirthCountryCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualRegistrationType", propOrder = {
    "identification",
    "birthDate",
    "birthPlace",
    "birthCountryCode"
})
public class IndividualRegistrationType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Identification", required = true)
    protected PersonIdentificationType identification;
    @XmlElement(name = "BirthDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDate;
    @XmlElement(name = "BirthPlace", required = true)
    protected String birthPlace;
    @XmlElement(name = "BirthCountryCode", required = true)
    protected CodeRefType birthCountryCode;

    /**
     * Gets the value of the identification property.
     * 
     * @return
     *     possible object is
     *     {@link PersonIdentificationType }
     *     
     */
    public PersonIdentificationType getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonIdentificationType }
     *     
     */
    public void setIdentification(PersonIdentificationType value) {
        this.identification = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the birthPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthPlace() {
        return birthPlace;
    }

    /**
     * Sets the value of the birthPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthPlace(String value) {
        this.birthPlace = value;
    }

    /**
     * Gets the value of the birthCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getBirthCountryCode() {
        return birthCountryCode;
    }

    /**
     * Sets the value of the birthCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setBirthCountryCode(CodeRefType value) {
        this.birthCountryCode = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof IndividualRegistrationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IndividualRegistrationType that = ((IndividualRegistrationType) object);
        {
            PersonIdentificationType lhsIdentification;
            lhsIdentification = this.getIdentification();
            PersonIdentificationType rhsIdentification;
            rhsIdentification = that.getIdentification();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "identification", lhsIdentification), LocatorUtils.property(thatLocator, "identification", rhsIdentification), lhsIdentification, rhsIdentification)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsBirthDate;
            lhsBirthDate = this.getBirthDate();
            XMLGregorianCalendar rhsBirthDate;
            rhsBirthDate = that.getBirthDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "birthDate", lhsBirthDate), LocatorUtils.property(thatLocator, "birthDate", rhsBirthDate), lhsBirthDate, rhsBirthDate)) {
                return false;
            }
        }
        {
            String lhsBirthPlace;
            lhsBirthPlace = this.getBirthPlace();
            String rhsBirthPlace;
            rhsBirthPlace = that.getBirthPlace();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "birthPlace", lhsBirthPlace), LocatorUtils.property(thatLocator, "birthPlace", rhsBirthPlace), lhsBirthPlace, rhsBirthPlace)) {
                return false;
            }
        }
        {
            CodeRefType lhsBirthCountryCode;
            lhsBirthCountryCode = this.getBirthCountryCode();
            CodeRefType rhsBirthCountryCode;
            rhsBirthCountryCode = that.getBirthCountryCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "birthCountryCode", lhsBirthCountryCode), LocatorUtils.property(thatLocator, "birthCountryCode", rhsBirthCountryCode), lhsBirthCountryCode, rhsBirthCountryCode)) {
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
            PersonIdentificationType theIdentification;
            theIdentification = this.getIdentification();
            strategy.appendField(locator, this, "identification", buffer, theIdentification);
        }
        {
            XMLGregorianCalendar theBirthDate;
            theBirthDate = this.getBirthDate();
            strategy.appendField(locator, this, "birthDate", buffer, theBirthDate);
        }
        {
            String theBirthPlace;
            theBirthPlace = this.getBirthPlace();
            strategy.appendField(locator, this, "birthPlace", buffer, theBirthPlace);
        }
        {
            CodeRefType theBirthCountryCode;
            theBirthCountryCode = this.getBirthCountryCode();
            strategy.appendField(locator, this, "birthCountryCode", buffer, theBirthCountryCode);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            PersonIdentificationType theIdentification;
            theIdentification = this.getIdentification();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "identification", theIdentification), currentHashCode, theIdentification);
        }
        {
            XMLGregorianCalendar theBirthDate;
            theBirthDate = this.getBirthDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "birthDate", theBirthDate), currentHashCode, theBirthDate);
        }
        {
            String theBirthPlace;
            theBirthPlace = this.getBirthPlace();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "birthPlace", theBirthPlace), currentHashCode, theBirthPlace);
        }
        {
            CodeRefType theBirthCountryCode;
            theBirthCountryCode = this.getBirthCountryCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "birthCountryCode", theBirthCountryCode), currentHashCode, theBirthCountryCode);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
