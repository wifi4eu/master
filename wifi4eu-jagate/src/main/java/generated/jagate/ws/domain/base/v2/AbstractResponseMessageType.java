
package generated.jagate.ws.domain.base.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
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
 * <p>Java class for AbstractResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractResponseMessageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReturnCode" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Message" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}MessageType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractResponseMessageType", propOrder = {
    "returnCode",
    "message"
})
@XmlSeeAlso({
    BaseResponseMessageType.class
})
public abstract class AbstractResponseMessageType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ReturnCode")
    protected long returnCode;
    @XmlElement(name = "Message", required = true)
    protected List<MessageType> message;

    /**
     * Gets the value of the returnCode property.
     * 
     */
    public long getReturnCode() {
        return returnCode;
    }

    /**
     * Sets the value of the returnCode property.
     * 
     */
    public void setReturnCode(long value) {
        this.returnCode = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the message property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageType }
     * 
     * 
     */
    public List<MessageType> getMessage() {
        if (message == null) {
            message = new ArrayList<MessageType>();
        }
        return this.message;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AbstractResponseMessageType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AbstractResponseMessageType that = ((AbstractResponseMessageType) object);
        {
            long lhsReturnCode;
            lhsReturnCode = (true?this.getReturnCode(): 0L);
            long rhsReturnCode;
            rhsReturnCode = (true?that.getReturnCode(): 0L);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "returnCode", lhsReturnCode), LocatorUtils.property(thatLocator, "returnCode", rhsReturnCode), lhsReturnCode, rhsReturnCode)) {
                return false;
            }
        }
        {
            List<MessageType> lhsMessage;
            lhsMessage = (((this.message!= null)&&(!this.message.isEmpty()))?this.getMessage():null);
            List<MessageType> rhsMessage;
            rhsMessage = (((that.message!= null)&&(!that.message.isEmpty()))?that.getMessage():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "message", lhsMessage), LocatorUtils.property(thatLocator, "message", rhsMessage), lhsMessage, rhsMessage)) {
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
            long theReturnCode;
            theReturnCode = (true?this.getReturnCode(): 0L);
            strategy.appendField(locator, this, "returnCode", buffer, theReturnCode);
        }
        {
            List<MessageType> theMessage;
            theMessage = (((this.message!= null)&&(!this.message.isEmpty()))?this.getMessage():null);
            strategy.appendField(locator, this, "message", buffer, theMessage);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            long theReturnCode;
            theReturnCode = (true?this.getReturnCode(): 0L);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "returnCode", theReturnCode), currentHashCode, theReturnCode);
        }
        {
            List<MessageType> theMessage;
            theMessage = (((this.message!= null)&&(!this.message.isEmpty()))?this.getMessage():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "message", theMessage), currentHashCode, theMessage);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
