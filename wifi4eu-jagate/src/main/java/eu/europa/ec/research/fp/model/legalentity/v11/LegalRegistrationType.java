
package eu.europa.ec.research.fp.model.legalentity.v11;

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
 * <p>Java class for LegalRegistrationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LegalRegistrationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SecondRegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegistrationAuthority" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegistrationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalRegistrationType", propOrder = {
    "registrationNumber",
    "secondRegistrationNumber",
    "registrationAuthority",
    "registrationDate"
})
public class LegalRegistrationType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "RegistrationNumber", required = true)
    protected String registrationNumber;
    @XmlElement(name = "SecondRegistrationNumber")
    protected String secondRegistrationNumber;
    @XmlElement(name = "RegistrationAuthority")
    protected String registrationAuthority;
    @XmlElement(name = "RegistrationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar registrationDate;

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
     * Gets the value of the secondRegistrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondRegistrationNumber() {
        return secondRegistrationNumber;
    }

    /**
     * Sets the value of the secondRegistrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondRegistrationNumber(String value) {
        this.secondRegistrationNumber = value;
    }

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LegalRegistrationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LegalRegistrationType that = ((LegalRegistrationType) object);
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
            String lhsSecondRegistrationNumber;
            lhsSecondRegistrationNumber = this.getSecondRegistrationNumber();
            String rhsSecondRegistrationNumber;
            rhsSecondRegistrationNumber = that.getSecondRegistrationNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "secondRegistrationNumber", lhsSecondRegistrationNumber), LocatorUtils.property(thatLocator, "secondRegistrationNumber", rhsSecondRegistrationNumber), lhsSecondRegistrationNumber, rhsSecondRegistrationNumber)) {
                return false;
            }
        }
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
            String theRegistrationNumber;
            theRegistrationNumber = this.getRegistrationNumber();
            strategy.appendField(locator, this, "registrationNumber", buffer, theRegistrationNumber);
        }
        {
            String theSecondRegistrationNumber;
            theSecondRegistrationNumber = this.getSecondRegistrationNumber();
            strategy.appendField(locator, this, "secondRegistrationNumber", buffer, theSecondRegistrationNumber);
        }
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
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theRegistrationNumber;
            theRegistrationNumber = this.getRegistrationNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationNumber", theRegistrationNumber), currentHashCode, theRegistrationNumber);
        }
        {
            String theSecondRegistrationNumber;
            theSecondRegistrationNumber = this.getSecondRegistrationNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "secondRegistrationNumber", theSecondRegistrationNumber), currentHashCode, theSecondRegistrationNumber);
        }
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
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
