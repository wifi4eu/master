
package generated.jagate.model.base.V1;

import java.math.BigInteger;
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
 * Timer keeping count of time spent on a certain task
 * 
 * <p>Java class for ClockType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClockType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TargetTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Running" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DaysSpent" type="{http://ec.europa.eu/research/fp/model/base/V1}CountType"/>
 *         &lt;element name="DaysLeft" type="{http://ec.europa.eu/research/fp/model/base/V1}CountType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClockType", propOrder = {
    "id",
    "description",
    "startTime",
    "targetTime",
    "running",
    "daysSpent",
    "daysLeft"
})
public class ClockType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Id", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger id;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "StartTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(name = "TargetTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar targetTime;
    @XmlElement(name = "Running")
    protected boolean running;
    @XmlElement(name = "DaysSpent", required = true)
    protected BigInteger daysSpent;
    @XmlElement(name = "DaysLeft", required = true)
    protected BigInteger daysLeft;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartTime(XMLGregorianCalendar value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the targetTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTargetTime() {
        return targetTime;
    }

    /**
     * Sets the value of the targetTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTargetTime(XMLGregorianCalendar value) {
        this.targetTime = value;
    }

    /**
     * Gets the value of the running property.
     * 
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Sets the value of the running property.
     * 
     */
    public void setRunning(boolean value) {
        this.running = value;
    }

    /**
     * Gets the value of the daysSpent property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDaysSpent() {
        return daysSpent;
    }

    /**
     * Sets the value of the daysSpent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDaysSpent(BigInteger value) {
        this.daysSpent = value;
    }

    /**
     * Gets the value of the daysLeft property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDaysLeft() {
        return daysLeft;
    }

    /**
     * Sets the value of the daysLeft property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDaysLeft(BigInteger value) {
        this.daysLeft = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ClockType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ClockType that = ((ClockType) object);
        {
            BigInteger lhsId;
            lhsId = this.getId();
            BigInteger rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                return false;
            }
        }
        {
            String lhsDescription;
            lhsDescription = this.getDescription();
            String rhsDescription;
            rhsDescription = that.getDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsStartTime;
            lhsStartTime = this.getStartTime();
            XMLGregorianCalendar rhsStartTime;
            rhsStartTime = that.getStartTime();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "startTime", lhsStartTime), LocatorUtils.property(thatLocator, "startTime", rhsStartTime), lhsStartTime, rhsStartTime)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsTargetTime;
            lhsTargetTime = this.getTargetTime();
            XMLGregorianCalendar rhsTargetTime;
            rhsTargetTime = that.getTargetTime();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "targetTime", lhsTargetTime), LocatorUtils.property(thatLocator, "targetTime", rhsTargetTime), lhsTargetTime, rhsTargetTime)) {
                return false;
            }
        }
        {
            boolean lhsRunning;
            lhsRunning = (true?this.isRunning():false);
            boolean rhsRunning;
            rhsRunning = (true?that.isRunning():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "running", lhsRunning), LocatorUtils.property(thatLocator, "running", rhsRunning), lhsRunning, rhsRunning)) {
                return false;
            }
        }
        {
            BigInteger lhsDaysSpent;
            lhsDaysSpent = this.getDaysSpent();
            BigInteger rhsDaysSpent;
            rhsDaysSpent = that.getDaysSpent();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "daysSpent", lhsDaysSpent), LocatorUtils.property(thatLocator, "daysSpent", rhsDaysSpent), lhsDaysSpent, rhsDaysSpent)) {
                return false;
            }
        }
        {
            BigInteger lhsDaysLeft;
            lhsDaysLeft = this.getDaysLeft();
            BigInteger rhsDaysLeft;
            rhsDaysLeft = that.getDaysLeft();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "daysLeft", lhsDaysLeft), LocatorUtils.property(thatLocator, "daysLeft", rhsDaysLeft), lhsDaysLeft, rhsDaysLeft)) {
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
            BigInteger theId;
            theId = this.getId();
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            strategy.appendField(locator, this, "description", buffer, theDescription);
        }
        {
            XMLGregorianCalendar theStartTime;
            theStartTime = this.getStartTime();
            strategy.appendField(locator, this, "startTime", buffer, theStartTime);
        }
        {
            XMLGregorianCalendar theTargetTime;
            theTargetTime = this.getTargetTime();
            strategy.appendField(locator, this, "targetTime", buffer, theTargetTime);
        }
        {
            boolean theRunning;
            theRunning = (true?this.isRunning():false);
            strategy.appendField(locator, this, "running", buffer, theRunning);
        }
        {
            BigInteger theDaysSpent;
            theDaysSpent = this.getDaysSpent();
            strategy.appendField(locator, this, "daysSpent", buffer, theDaysSpent);
        }
        {
            BigInteger theDaysLeft;
            theDaysLeft = this.getDaysLeft();
            strategy.appendField(locator, this, "daysLeft", buffer, theDaysLeft);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            BigInteger theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            XMLGregorianCalendar theStartTime;
            theStartTime = this.getStartTime();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "startTime", theStartTime), currentHashCode, theStartTime);
        }
        {
            XMLGregorianCalendar theTargetTime;
            theTargetTime = this.getTargetTime();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "targetTime", theTargetTime), currentHashCode, theTargetTime);
        }
        {
            boolean theRunning;
            theRunning = (true?this.isRunning():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "running", theRunning), currentHashCode, theRunning);
        }
        {
            BigInteger theDaysSpent;
            theDaysSpent = this.getDaysSpent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "daysSpent", theDaysSpent), currentHashCode, theDaysSpent);
        }
        {
            BigInteger theDaysLeft;
            theDaysLeft = this.getDaysLeft();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "daysLeft", theDaysLeft), currentHashCode, theDaysLeft);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
