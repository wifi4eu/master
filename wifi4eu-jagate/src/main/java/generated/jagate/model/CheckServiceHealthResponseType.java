
package generated.jagate.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.servicehealth.V1.CheckServiceHealthOutType;
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
 * <p>Java class for CheckServiceHealthResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckServiceHealthResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckServiceHealthOut" type="{http://ec.europa.eu/research/fp/model/service-health/V1}CheckServiceHealthOutType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckServiceHealthResponseType", propOrder = {
    "checkServiceHealthOut"
})
public class CheckServiceHealthResponseType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "CheckServiceHealthOut", required = true)
    protected CheckServiceHealthOutType checkServiceHealthOut;

    /**
     * Gets the value of the checkServiceHealthOut property.
     * 
     * @return
     *     possible object is
     *     {@link CheckServiceHealthOutType }
     *     
     */
    public CheckServiceHealthOutType getCheckServiceHealthOut() {
        return checkServiceHealthOut;
    }

    /**
     * Sets the value of the checkServiceHealthOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckServiceHealthOutType }
     *     
     */
    public void setCheckServiceHealthOut(CheckServiceHealthOutType value) {
        this.checkServiceHealthOut = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CheckServiceHealthResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CheckServiceHealthResponseType that = ((CheckServiceHealthResponseType) object);
        {
            CheckServiceHealthOutType lhsCheckServiceHealthOut;
            lhsCheckServiceHealthOut = this.getCheckServiceHealthOut();
            CheckServiceHealthOutType rhsCheckServiceHealthOut;
            rhsCheckServiceHealthOut = that.getCheckServiceHealthOut();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "checkServiceHealthOut", lhsCheckServiceHealthOut), LocatorUtils.property(thatLocator, "checkServiceHealthOut", rhsCheckServiceHealthOut), lhsCheckServiceHealthOut, rhsCheckServiceHealthOut)) {
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
            CheckServiceHealthOutType theCheckServiceHealthOut;
            theCheckServiceHealthOut = this.getCheckServiceHealthOut();
            strategy.appendField(locator, this, "checkServiceHealthOut", buffer, theCheckServiceHealthOut);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            CheckServiceHealthOutType theCheckServiceHealthOut;
            theCheckServiceHealthOut = this.getCheckServiceHealthOut();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "checkServiceHealthOut", theCheckServiceHealthOut), currentHashCode, theCheckServiceHealthOut);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
