
package generated.jagate.ws.domain.base.v2;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for SoaResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoaResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReturnCode" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="soaResponseMessage" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}SoaResponseMessageType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoaResponseType", propOrder = {
    "returnCode",
    "soaResponseMessage"
})
public class SoaResponseType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ReturnCode")
    protected long returnCode;
    protected List<SoaResponseMessageType> soaResponseMessage;

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
     * Gets the value of the soaResponseMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soaResponseMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoaResponseMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoaResponseMessageType }
     * 
     * 
     */
    public List<SoaResponseMessageType> getSoaResponseMessage() {
        if (soaResponseMessage == null) {
            soaResponseMessage = new ArrayList<SoaResponseMessageType>();
        }
        return this.soaResponseMessage;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SoaResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SoaResponseType that = ((SoaResponseType) object);
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
            List<SoaResponseMessageType> lhsSoaResponseMessage;
            lhsSoaResponseMessage = (((this.soaResponseMessage!= null)&&(!this.soaResponseMessage.isEmpty()))?this.getSoaResponseMessage():null);
            List<SoaResponseMessageType> rhsSoaResponseMessage;
            rhsSoaResponseMessage = (((that.soaResponseMessage!= null)&&(!that.soaResponseMessage.isEmpty()))?that.getSoaResponseMessage():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "soaResponseMessage", lhsSoaResponseMessage), LocatorUtils.property(thatLocator, "soaResponseMessage", rhsSoaResponseMessage), lhsSoaResponseMessage, rhsSoaResponseMessage)) {
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
            List<SoaResponseMessageType> theSoaResponseMessage;
            theSoaResponseMessage = (((this.soaResponseMessage!= null)&&(!this.soaResponseMessage.isEmpty()))?this.getSoaResponseMessage():null);
            strategy.appendField(locator, this, "soaResponseMessage", buffer, theSoaResponseMessage);
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
            List<SoaResponseMessageType> theSoaResponseMessage;
            theSoaResponseMessage = (((this.soaResponseMessage!= null)&&(!this.soaResponseMessage.isEmpty()))?this.getSoaResponseMessage():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "soaResponseMessage", theSoaResponseMessage), currentHashCode, theSoaResponseMessage);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
