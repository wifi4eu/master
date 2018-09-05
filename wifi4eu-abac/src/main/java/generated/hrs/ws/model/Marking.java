
package generated.hrs.ws.model;

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
 * <p>Java class for Marking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Marking">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://ec.europa.eu/sg/hrs/types}MarkerType"/>
 *         &lt;element name="deadline" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="expiryEvent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personConcerned" type="{http://ec.europa.eu/sg/hrs/types}CurrentEntityToAdd" minOccurs="0"/>
 *         &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Marking", propOrder = {
    "value",
    "deadline",
    "expiryEvent",
    "personConcerned",
    "service"
})
public class Marking
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected MarkerType value;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deadline;
    protected String expiryEvent;
    protected CurrentEntityToAdd personConcerned;
    protected String service;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link MarkerType }
     *     
     */
    public MarkerType getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkerType }
     *     
     */
    public void setValue(MarkerType value) {
        this.value = value;
    }

    /**
     * Gets the value of the deadline property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeadline() {
        return deadline;
    }

    /**
     * Sets the value of the deadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeadline(XMLGregorianCalendar value) {
        this.deadline = value;
    }

    /**
     * Gets the value of the expiryEvent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryEvent() {
        return expiryEvent;
    }

    /**
     * Sets the value of the expiryEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryEvent(String value) {
        this.expiryEvent = value;
    }

    /**
     * Gets the value of the personConcerned property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentEntityToAdd }
     *     
     */
    public CurrentEntityToAdd getPersonConcerned() {
        return personConcerned;
    }

    /**
     * Sets the value of the personConcerned property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentEntityToAdd }
     *     
     */
    public void setPersonConcerned(CurrentEntityToAdd value) {
        this.personConcerned = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Marking)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Marking that = ((Marking) object);
        {
            MarkerType lhsValue;
            lhsValue = this.getValue();
            MarkerType rhsValue;
            rhsValue = that.getValue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "value", lhsValue), LocatorUtils.property(thatLocator, "value", rhsValue), lhsValue, rhsValue)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDeadline;
            lhsDeadline = this.getDeadline();
            XMLGregorianCalendar rhsDeadline;
            rhsDeadline = that.getDeadline();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "deadline", lhsDeadline), LocatorUtils.property(thatLocator, "deadline", rhsDeadline), lhsDeadline, rhsDeadline)) {
                return false;
            }
        }
        {
            String lhsExpiryEvent;
            lhsExpiryEvent = this.getExpiryEvent();
            String rhsExpiryEvent;
            rhsExpiryEvent = that.getExpiryEvent();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "expiryEvent", lhsExpiryEvent), LocatorUtils.property(thatLocator, "expiryEvent", rhsExpiryEvent), lhsExpiryEvent, rhsExpiryEvent)) {
                return false;
            }
        }
        {
            CurrentEntityToAdd lhsPersonConcerned;
            lhsPersonConcerned = this.getPersonConcerned();
            CurrentEntityToAdd rhsPersonConcerned;
            rhsPersonConcerned = that.getPersonConcerned();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "personConcerned", lhsPersonConcerned), LocatorUtils.property(thatLocator, "personConcerned", rhsPersonConcerned), lhsPersonConcerned, rhsPersonConcerned)) {
                return false;
            }
        }
        {
            String lhsService;
            lhsService = this.getService();
            String rhsService;
            rhsService = that.getService();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "service", lhsService), LocatorUtils.property(thatLocator, "service", rhsService), lhsService, rhsService)) {
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
            MarkerType theValue;
            theValue = this.getValue();
            strategy.appendField(locator, this, "value", buffer, theValue);
        }
        {
            XMLGregorianCalendar theDeadline;
            theDeadline = this.getDeadline();
            strategy.appendField(locator, this, "deadline", buffer, theDeadline);
        }
        {
            String theExpiryEvent;
            theExpiryEvent = this.getExpiryEvent();
            strategy.appendField(locator, this, "expiryEvent", buffer, theExpiryEvent);
        }
        {
            CurrentEntityToAdd thePersonConcerned;
            thePersonConcerned = this.getPersonConcerned();
            strategy.appendField(locator, this, "personConcerned", buffer, thePersonConcerned);
        }
        {
            String theService;
            theService = this.getService();
            strategy.appendField(locator, this, "service", buffer, theService);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            MarkerType theValue;
            theValue = this.getValue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "value", theValue), currentHashCode, theValue);
        }
        {
            XMLGregorianCalendar theDeadline;
            theDeadline = this.getDeadline();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deadline", theDeadline), currentHashCode, theDeadline);
        }
        {
            String theExpiryEvent;
            theExpiryEvent = this.getExpiryEvent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "expiryEvent", theExpiryEvent), currentHashCode, theExpiryEvent);
        }
        {
            CurrentEntityToAdd thePersonConcerned;
            thePersonConcerned = this.getPersonConcerned();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "personConcerned", thePersonConcerned), currentHashCode, thePersonConcerned);
        }
        {
            String theService;
            theService = this.getService();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "service", theService), currentHashCode, theService);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
