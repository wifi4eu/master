
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * <p>Java class for LawBodyRegistration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LawBodyRegistration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RegistrationAuthority" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegistrationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="RegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SecondaryRegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LawBodyRegistration", propOrder = {
    "registrationAuthority",
    "registrationDate",
    "registrationNumber",
    "secondaryRegistrationNumber"
})
public class LawBodyRegistration
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "RegistrationAuthority", required = true)
    protected String registrationAuthority;
    @XmlElement(name = "RegistrationDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar registrationDate;
    @XmlElement(name = "RegistrationNumber", required = true)
    protected String registrationNumber;
    @XmlElement(name = "SecondaryRegistrationNumber")
    protected String secondaryRegistrationNumber;

    /**
     * Gets the value of the registrationAuthority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    /**
     * Sets the value of the registrationAuthority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationAuthority(String value) {
        this.registrationAuthority = value;
    }

    /**
     * Gets the value of the registrationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the value of the registrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegistrationDate(XMLGregorianCalendar value) {
        this.registrationDate = value;
    }

    /**
     * Gets the value of the registrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Sets the value of the registrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationNumber(String value) {
        this.registrationNumber = value;
    }

    /**
     * Gets the value of the secondaryRegistrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondaryRegistrationNumber() {
        return secondaryRegistrationNumber;
    }

    /**
     * Sets the value of the secondaryRegistrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondaryRegistrationNumber(String value) {
        this.secondaryRegistrationNumber = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LawBodyRegistration)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LawBodyRegistration that = ((LawBodyRegistration) object);
        {
            String lhsRegistrationAuthority;
            lhsRegistrationAuthority = this.getRegistrationAuthority();
            String rhsRegistrationAuthority;
            rhsRegistrationAuthority = that.getRegistrationAuthority();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "registrationAuthority", lhsRegistrationAuthority), LocatorUtils.property(thatLocator, "registrationAuthority", rhsRegistrationAuthority), lhsRegistrationAuthority, rhsRegistrationAuthority)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsRegistrationDate;
            lhsRegistrationDate = this.getRegistrationDate();
            XMLGregorianCalendar rhsRegistrationDate;
            rhsRegistrationDate = that.getRegistrationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "registrationDate", lhsRegistrationDate), LocatorUtils.property(thatLocator, "registrationDate", rhsRegistrationDate), lhsRegistrationDate, rhsRegistrationDate)) {
                return false;
            }
        }
        {
            String lhsRegistrationNumber;
            lhsRegistrationNumber = this.getRegistrationNumber();
            String rhsRegistrationNumber;
            rhsRegistrationNumber = that.getRegistrationNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "registrationNumber", lhsRegistrationNumber), LocatorUtils.property(thatLocator, "registrationNumber", rhsRegistrationNumber), lhsRegistrationNumber, rhsRegistrationNumber)) {
                return false;
            }
        }
        {
            String lhsSecondaryRegistrationNumber;
            lhsSecondaryRegistrationNumber = this.getSecondaryRegistrationNumber();
            String rhsSecondaryRegistrationNumber;
            rhsSecondaryRegistrationNumber = that.getSecondaryRegistrationNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "secondaryRegistrationNumber", lhsSecondaryRegistrationNumber), LocatorUtils.property(thatLocator, "secondaryRegistrationNumber", rhsSecondaryRegistrationNumber), lhsSecondaryRegistrationNumber, rhsSecondaryRegistrationNumber)) {
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
            String theRegistrationAuthority;
            theRegistrationAuthority = this.getRegistrationAuthority();
            strategy.appendField(locator, this, "registrationAuthority", buffer, theRegistrationAuthority);
        }
        {
            XMLGregorianCalendar theRegistrationDate;
            theRegistrationDate = this.getRegistrationDate();
            strategy.appendField(locator, this, "registrationDate", buffer, theRegistrationDate);
        }
        {
            String theRegistrationNumber;
            theRegistrationNumber = this.getRegistrationNumber();
            strategy.appendField(locator, this, "registrationNumber", buffer, theRegistrationNumber);
        }
        {
            String theSecondaryRegistrationNumber;
            theSecondaryRegistrationNumber = this.getSecondaryRegistrationNumber();
            strategy.appendField(locator, this, "secondaryRegistrationNumber", buffer, theSecondaryRegistrationNumber);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theRegistrationAuthority;
            theRegistrationAuthority = this.getRegistrationAuthority();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationAuthority", theRegistrationAuthority), currentHashCode, theRegistrationAuthority);
        }
        {
            XMLGregorianCalendar theRegistrationDate;
            theRegistrationDate = this.getRegistrationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationDate", theRegistrationDate), currentHashCode, theRegistrationDate);
        }
        {
            String theRegistrationNumber;
            theRegistrationNumber = this.getRegistrationNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationNumber", theRegistrationNumber), currentHashCode, theRegistrationNumber);
        }
        {
            String theSecondaryRegistrationNumber;
            theSecondaryRegistrationNumber = this.getSecondaryRegistrationNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "secondaryRegistrationNumber", theSecondaryRegistrationNumber), currentHashCode, theSecondaryRegistrationNumber);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
