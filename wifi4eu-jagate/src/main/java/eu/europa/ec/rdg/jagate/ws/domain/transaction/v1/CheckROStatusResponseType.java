
package eu.europa.ec.rdg.jagate.ws.domain.transaction.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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
 * <p>Java class for CheckROStatusResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckROStatusResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recoveryOrderStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckROStatusResponseType", propOrder = {
    "recoveryOrderStatus"
})
public class CheckROStatusResponseType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String recoveryOrderStatus;

    /**
     * Gets the value of the recoveryOrderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecoveryOrderStatus() {
        return recoveryOrderStatus;
    }

    /**
     * Sets the value of the recoveryOrderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecoveryOrderStatus(String value) {
        this.recoveryOrderStatus = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CheckROStatusResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CheckROStatusResponseType that = ((CheckROStatusResponseType) object);
        {
            String lhsRecoveryOrderStatus;
            lhsRecoveryOrderStatus = this.getRecoveryOrderStatus();
            String rhsRecoveryOrderStatus;
            rhsRecoveryOrderStatus = that.getRecoveryOrderStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recoveryOrderStatus", lhsRecoveryOrderStatus), LocatorUtils.property(thatLocator, "recoveryOrderStatus", rhsRecoveryOrderStatus), lhsRecoveryOrderStatus, rhsRecoveryOrderStatus)) {
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
            String theRecoveryOrderStatus;
            theRecoveryOrderStatus = this.getRecoveryOrderStatus();
            strategy.appendField(locator, this, "recoveryOrderStatus", buffer, theRecoveryOrderStatus);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theRecoveryOrderStatus;
            theRecoveryOrderStatus = this.getRecoveryOrderStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recoveryOrderStatus", theRecoveryOrderStatus), currentHashCode, theRecoveryOrderStatus);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
