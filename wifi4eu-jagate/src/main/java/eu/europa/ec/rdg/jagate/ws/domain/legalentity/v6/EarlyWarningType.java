
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
 * <p>Java class for EarlyWarningType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EarlyWarningType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}EarlyWarningCodeType"/>
 *         &lt;element name="validFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="validTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EarlyWarningType", propOrder = {
    "code",
    "validFrom",
    "validTo"
})
public class EarlyWarningType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected EarlyWarningCodeType code;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validFrom;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validTo;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link EarlyWarningCodeType }
     *     
     */
    public EarlyWarningCodeType getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link EarlyWarningCodeType }
     *     
     */
    public void setCode(EarlyWarningCodeType value) {
        this.code = value;
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFrom(XMLGregorianCalendar value) {
        this.validFrom = value;
    }

    /**
     * Gets the value of the validTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidTo() {
        return validTo;
    }

    /**
     * Sets the value of the validTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidTo(XMLGregorianCalendar value) {
        this.validTo = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof EarlyWarningType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final EarlyWarningType that = ((EarlyWarningType) object);
        {
            EarlyWarningCodeType lhsCode;
            lhsCode = this.getCode();
            EarlyWarningCodeType rhsCode;
            rhsCode = that.getCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "code", lhsCode), LocatorUtils.property(thatLocator, "code", rhsCode), lhsCode, rhsCode)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsValidFrom;
            lhsValidFrom = this.getValidFrom();
            XMLGregorianCalendar rhsValidFrom;
            rhsValidFrom = that.getValidFrom();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validFrom", lhsValidFrom), LocatorUtils.property(thatLocator, "validFrom", rhsValidFrom), lhsValidFrom, rhsValidFrom)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsValidTo;
            lhsValidTo = this.getValidTo();
            XMLGregorianCalendar rhsValidTo;
            rhsValidTo = that.getValidTo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validTo", lhsValidTo), LocatorUtils.property(thatLocator, "validTo", rhsValidTo), lhsValidTo, rhsValidTo)) {
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
            EarlyWarningCodeType theCode;
            theCode = this.getCode();
            strategy.appendField(locator, this, "code", buffer, theCode);
        }
        {
            XMLGregorianCalendar theValidFrom;
            theValidFrom = this.getValidFrom();
            strategy.appendField(locator, this, "validFrom", buffer, theValidFrom);
        }
        {
            XMLGregorianCalendar theValidTo;
            theValidTo = this.getValidTo();
            strategy.appendField(locator, this, "validTo", buffer, theValidTo);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            EarlyWarningCodeType theCode;
            theCode = this.getCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "code", theCode), currentHashCode, theCode);
        }
        {
            XMLGregorianCalendar theValidFrom;
            theValidFrom = this.getValidFrom();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validFrom", theValidFrom), currentHashCode, theValidFrom);
        }
        {
            XMLGregorianCalendar theValidTo;
            theValidTo = this.getValidTo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validTo", theValidTo), currentHashCode, theValidTo);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
