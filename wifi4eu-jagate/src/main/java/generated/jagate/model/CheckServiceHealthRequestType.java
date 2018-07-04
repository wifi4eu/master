
package generated.jagate.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.servicehealth.V1.CheckServiceHealthInType;
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
 * <p>Java class for CheckServiceHealthRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckServiceHealthRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckServiceHealthIn" type="{http://ec.europa.eu/research/fp/model/service-health/V1}CheckServiceHealthInType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckServiceHealthRequestType", propOrder = {
    "checkServiceHealthIn"
})
public class CheckServiceHealthRequestType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "CheckServiceHealthIn")
    protected CheckServiceHealthInType checkServiceHealthIn;

    /**
     * Gets the value of the checkServiceHealthIn property.
     * 
     * @return
     *     possible object is
     *     {@link CheckServiceHealthInType }
     *     
     */
    public CheckServiceHealthInType getCheckServiceHealthIn() {
        return checkServiceHealthIn;
    }

    /**
     * Sets the value of the checkServiceHealthIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckServiceHealthInType }
     *     
     */
    public void setCheckServiceHealthIn(CheckServiceHealthInType value) {
        this.checkServiceHealthIn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CheckServiceHealthRequestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CheckServiceHealthRequestType that = ((CheckServiceHealthRequestType) object);
        {
            CheckServiceHealthInType lhsCheckServiceHealthIn;
            lhsCheckServiceHealthIn = this.getCheckServiceHealthIn();
            CheckServiceHealthInType rhsCheckServiceHealthIn;
            rhsCheckServiceHealthIn = that.getCheckServiceHealthIn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "checkServiceHealthIn", lhsCheckServiceHealthIn), LocatorUtils.property(thatLocator, "checkServiceHealthIn", rhsCheckServiceHealthIn), lhsCheckServiceHealthIn, rhsCheckServiceHealthIn)) {
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
            CheckServiceHealthInType theCheckServiceHealthIn;
            theCheckServiceHealthIn = this.getCheckServiceHealthIn();
            strategy.appendField(locator, this, "checkServiceHealthIn", buffer, theCheckServiceHealthIn);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            CheckServiceHealthInType theCheckServiceHealthIn;
            theCheckServiceHealthIn = this.getCheckServiceHealthIn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "checkServiceHealthIn", theCheckServiceHealthIn), currentHashCode, theCheckServiceHealthIn);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
