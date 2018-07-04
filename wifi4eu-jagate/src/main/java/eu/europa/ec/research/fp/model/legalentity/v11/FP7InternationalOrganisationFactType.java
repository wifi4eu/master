
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
 * <p>Java class for FP7InternationalOrganisationFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FP7InternationalOrganisationFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InternationalOrganisation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EuropeanInterest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FafaAdheredDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FP7InternationalOrganisationFactType", propOrder = {
    "internationalOrganisation",
    "europeanInterest",
    "fafaAdheredDate"
})
public class FP7InternationalOrganisationFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "InternationalOrganisation")
    protected boolean internationalOrganisation;
    @XmlElement(name = "EuropeanInterest")
    protected Boolean europeanInterest;
    @XmlElement(name = "FafaAdheredDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fafaAdheredDate;

    /**
     * Gets the value of the internationalOrganisation property.
     * 
     */
    public boolean isInternationalOrganisation() {
        return internationalOrganisation;
    }

    /**
     * Sets the value of the internationalOrganisation property.
     * 
     */
    public void setInternationalOrganisation(boolean value) {
        this.internationalOrganisation = value;
    }

    /**
     * Gets the value of the europeanInterest property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEuropeanInterest() {
        return europeanInterest;
    }

    /**
     * Sets the value of the europeanInterest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEuropeanInterest(Boolean value) {
        this.europeanInterest = value;
    }

    /**
     * Gets the value of the fafaAdheredDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFafaAdheredDate() {
        return fafaAdheredDate;
    }

    /**
     * Sets the value of the fafaAdheredDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFafaAdheredDate(XMLGregorianCalendar value) {
        this.fafaAdheredDate = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FP7InternationalOrganisationFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FP7InternationalOrganisationFactType that = ((FP7InternationalOrganisationFactType) object);
        {
            boolean lhsInternationalOrganisation;
            lhsInternationalOrganisation = (true?this.isInternationalOrganisation():false);
            boolean rhsInternationalOrganisation;
            rhsInternationalOrganisation = (true?that.isInternationalOrganisation():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "internationalOrganisation", lhsInternationalOrganisation), LocatorUtils.property(thatLocator, "internationalOrganisation", rhsInternationalOrganisation), lhsInternationalOrganisation, rhsInternationalOrganisation)) {
                return false;
            }
        }
        {
            Boolean lhsEuropeanInterest;
            lhsEuropeanInterest = this.isEuropeanInterest();
            Boolean rhsEuropeanInterest;
            rhsEuropeanInterest = that.isEuropeanInterest();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "europeanInterest", lhsEuropeanInterest), LocatorUtils.property(thatLocator, "europeanInterest", rhsEuropeanInterest), lhsEuropeanInterest, rhsEuropeanInterest)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsFafaAdheredDate;
            lhsFafaAdheredDate = this.getFafaAdheredDate();
            XMLGregorianCalendar rhsFafaAdheredDate;
            rhsFafaAdheredDate = that.getFafaAdheredDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fafaAdheredDate", lhsFafaAdheredDate), LocatorUtils.property(thatLocator, "fafaAdheredDate", rhsFafaAdheredDate), lhsFafaAdheredDate, rhsFafaAdheredDate)) {
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
            boolean theInternationalOrganisation;
            theInternationalOrganisation = (true?this.isInternationalOrganisation():false);
            strategy.appendField(locator, this, "internationalOrganisation", buffer, theInternationalOrganisation);
        }
        {
            Boolean theEuropeanInterest;
            theEuropeanInterest = this.isEuropeanInterest();
            strategy.appendField(locator, this, "europeanInterest", buffer, theEuropeanInterest);
        }
        {
            XMLGregorianCalendar theFafaAdheredDate;
            theFafaAdheredDate = this.getFafaAdheredDate();
            strategy.appendField(locator, this, "fafaAdheredDate", buffer, theFafaAdheredDate);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            boolean theInternationalOrganisation;
            theInternationalOrganisation = (true?this.isInternationalOrganisation():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "internationalOrganisation", theInternationalOrganisation), currentHashCode, theInternationalOrganisation);
        }
        {
            Boolean theEuropeanInterest;
            theEuropeanInterest = this.isEuropeanInterest();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "europeanInterest", theEuropeanInterest), currentHashCode, theEuropeanInterest);
        }
        {
            XMLGregorianCalendar theFafaAdheredDate;
            theFafaAdheredDate = this.getFafaAdheredDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fafaAdheredDate", theFafaAdheredDate), currentHashCode, theFafaAdheredDate);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
