
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
 * <p>Java class for RecoveriesByPartnerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecoveriesByPartnerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="localObjectForeignId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recoveryOrderAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecoveriesByPartnerType", propOrder = {
    "localObjectForeignId",
    "recoveryOrderAmount"
})
public class RecoveriesByPartnerType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String localObjectForeignId;
    protected double recoveryOrderAmount;

    /**
     * Gets the value of the localObjectForeignId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalObjectForeignId() {
        return localObjectForeignId;
    }

    /**
     * Sets the value of the localObjectForeignId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalObjectForeignId(String value) {
        this.localObjectForeignId = value;
    }

    /**
     * Gets the value of the recoveryOrderAmount property.
     * 
     */
    public double getRecoveryOrderAmount() {
        return recoveryOrderAmount;
    }

    /**
     * Sets the value of the recoveryOrderAmount property.
     * 
     */
    public void setRecoveryOrderAmount(double value) {
        this.recoveryOrderAmount = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RecoveriesByPartnerType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RecoveriesByPartnerType that = ((RecoveriesByPartnerType) object);
        {
            String lhsLocalObjectForeignId;
            lhsLocalObjectForeignId = this.getLocalObjectForeignId();
            String rhsLocalObjectForeignId;
            rhsLocalObjectForeignId = that.getLocalObjectForeignId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "localObjectForeignId", lhsLocalObjectForeignId), LocatorUtils.property(thatLocator, "localObjectForeignId", rhsLocalObjectForeignId), lhsLocalObjectForeignId, rhsLocalObjectForeignId)) {
                return false;
            }
        }
        {
            double lhsRecoveryOrderAmount;
            lhsRecoveryOrderAmount = (true?this.getRecoveryOrderAmount(): 0.0D);
            double rhsRecoveryOrderAmount;
            rhsRecoveryOrderAmount = (true?that.getRecoveryOrderAmount(): 0.0D);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recoveryOrderAmount", lhsRecoveryOrderAmount), LocatorUtils.property(thatLocator, "recoveryOrderAmount", rhsRecoveryOrderAmount), lhsRecoveryOrderAmount, rhsRecoveryOrderAmount)) {
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
            String theLocalObjectForeignId;
            theLocalObjectForeignId = this.getLocalObjectForeignId();
            strategy.appendField(locator, this, "localObjectForeignId", buffer, theLocalObjectForeignId);
        }
        {
            double theRecoveryOrderAmount;
            theRecoveryOrderAmount = (true?this.getRecoveryOrderAmount(): 0.0D);
            strategy.appendField(locator, this, "recoveryOrderAmount", buffer, theRecoveryOrderAmount);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theLocalObjectForeignId;
            theLocalObjectForeignId = this.getLocalObjectForeignId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "localObjectForeignId", theLocalObjectForeignId), currentHashCode, theLocalObjectForeignId);
        }
        {
            double theRecoveryOrderAmount;
            theRecoveryOrderAmount = (true?this.getRecoveryOrderAmount(): 0.0D);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recoveryOrderAmount", theRecoveryOrderAmount), currentHashCode, theRecoveryOrderAmount);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
