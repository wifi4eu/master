
package generated.hrs.ws.model;

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
 * <p>Java class for SendersToAdd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendersToAdd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sender" type="{http://ec.europa.eu/sg/hrs/types}CurrentEntityToAdd" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendersToAdd", propOrder = {
    "sender"
})
public class SendersToAdd
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<CurrentEntityToAdd> sender;

    /**
     * Gets the value of the sender property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sender property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSender().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrentEntityToAdd }
     * 
     * 
     */
    public List<CurrentEntityToAdd> getSender() {
        if (sender == null) {
            sender = new ArrayList<CurrentEntityToAdd>();
        }
        return this.sender;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SendersToAdd)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SendersToAdd that = ((SendersToAdd) object);
        {
            List<CurrentEntityToAdd> lhsSender;
            lhsSender = (((this.sender!= null)&&(!this.sender.isEmpty()))?this.getSender():null);
            List<CurrentEntityToAdd> rhsSender;
            rhsSender = (((that.sender!= null)&&(!that.sender.isEmpty()))?that.getSender():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sender", lhsSender), LocatorUtils.property(thatLocator, "sender", rhsSender), lhsSender, rhsSender)) {
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
            List<CurrentEntityToAdd> theSender;
            theSender = (((this.sender!= null)&&(!this.sender.isEmpty()))?this.getSender():null);
            strategy.appendField(locator, this, "sender", buffer, theSender);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<CurrentEntityToAdd> theSender;
            theSender = (((this.sender!= null)&&(!this.sender.isEmpty()))?this.getSender():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sender", theSender), currentHashCode, theSender);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
