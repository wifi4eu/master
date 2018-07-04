
package generated.jagate.ws.domain.base.v2;

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
 * <p>Java class for BaseRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseRequestMessageType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}AbstractMessageType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}Callback" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRequestMessageType", propOrder = {
    "callback"
})
public class BaseRequestMessageType
    extends AbstractMessageType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Callback")
    protected CallbackType callback;

    /**
     * Gets the value of the callback property.
     * 
     * @return
     *     possible object is
     *     {@link CallbackType }
     *     
     */
    public CallbackType getCallback() {
        return callback;
    }

    /**
     * Sets the value of the callback property.
     * 
     * @param value
     *     allowed object is
     *     {@link CallbackType }
     *     
     */
    public void setCallback(CallbackType value) {
        this.callback = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BaseRequestMessageType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final BaseRequestMessageType that = ((BaseRequestMessageType) object);
        {
            CallbackType lhsCallback;
            lhsCallback = this.getCallback();
            CallbackType rhsCallback;
            rhsCallback = that.getCallback();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "callback", lhsCallback), LocatorUtils.property(thatLocator, "callback", rhsCallback), lhsCallback, rhsCallback)) {
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
        super.appendFields(locator, buffer, strategy);
        {
            CallbackType theCallback;
            theCallback = this.getCallback();
            strategy.appendField(locator, this, "callback", buffer, theCallback);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            CallbackType theCallback;
            theCallback = this.getCallback();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "callback", theCallback), currentHashCode, theCallback);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
