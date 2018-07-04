
package generated.jagate.model.person.V2;

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
 * <p>Java class for PersonIdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonIdentificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentificationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IdentificationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ValidUntil" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonIdentificationType", propOrder = {
    "identificationType",
    "identificationNumber",
    "validUntil"
})
public class PersonIdentificationType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "IdentificationType", required = true)
    protected String identificationType;
    @XmlElement(name = "IdentificationNumber", required = true)
    protected String identificationNumber;
    @XmlElement(name = "ValidUntil")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validUntil;

    /**
     * Gets the value of the identificationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationType() {
        return identificationType;
    }

    /**
     * Sets the value of the identificationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationType(String value) {
        this.identificationType = value;
    }

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
     * Gets the value of the validUntil property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidUntil() {
        return validUntil;
    }

    /**
     * Sets the value of the validUntil property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidUntil(XMLGregorianCalendar value) {
        this.validUntil = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PersonIdentificationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PersonIdentificationType that = ((PersonIdentificationType) object);
        {
            String lhsIdentificationType;
            lhsIdentificationType = this.getIdentificationType();
            String rhsIdentificationType;
            rhsIdentificationType = that.getIdentificationType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "identificationType", lhsIdentificationType), LocatorUtils.property(thatLocator, "identificationType", rhsIdentificationType), lhsIdentificationType, rhsIdentificationType)) {
                return false;
            }
        }
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
            XMLGregorianCalendar lhsValidUntil;
            lhsValidUntil = this.getValidUntil();
            XMLGregorianCalendar rhsValidUntil;
            rhsValidUntil = that.getValidUntil();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validUntil", lhsValidUntil), LocatorUtils.property(thatLocator, "validUntil", rhsValidUntil), lhsValidUntil, rhsValidUntil)) {
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
            String theIdentificationType;
            theIdentificationType = this.getIdentificationType();
            strategy.appendField(locator, this, "identificationType", buffer, theIdentificationType);
        }
        {
            String theIdentificationNumber;
            theIdentificationNumber = this.getIdentificationNumber();
            strategy.appendField(locator, this, "identificationNumber", buffer, theIdentificationNumber);
        }
        {
            XMLGregorianCalendar theValidUntil;
            theValidUntil = this.getValidUntil();
            strategy.appendField(locator, this, "validUntil", buffer, theValidUntil);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theIdentificationType;
            theIdentificationType = this.getIdentificationType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "identificationType", theIdentificationType), currentHashCode, theIdentificationType);
        }
        {
            String theIdentificationNumber;
            theIdentificationNumber = this.getIdentificationNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "identificationNumber", theIdentificationNumber), currentHashCode, theIdentificationNumber);
        }
        {
            XMLGregorianCalendar theValidUntil;
            theValidUntil = this.getValidUntil();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validUntil", theValidUntil), currentHashCode, theValidUntil);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
