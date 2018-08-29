
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * Classification info associated to a document whose security classification is either EU_RESTRAINED or EURA_RESTRICTED
 * 
 * <p>Java class for Classification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Classification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="deadline" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="expiryEvent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Classification", propOrder = {
    "deadline",
    "expiryEvent"
})
public class Classification
    implements Equals, HashCode, ToString
{

    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deadline;
    protected String expiryEvent;

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Classification)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Classification that = ((Classification) object);
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
            XMLGregorianCalendar theDeadline;
            theDeadline = this.getDeadline();
            strategy.appendField(locator, this, "deadline", buffer, theDeadline);
        }
        {
            String theExpiryEvent;
            theExpiryEvent = this.getExpiryEvent();
            strategy.appendField(locator, this, "expiryEvent", buffer, theExpiryEvent);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
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
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
