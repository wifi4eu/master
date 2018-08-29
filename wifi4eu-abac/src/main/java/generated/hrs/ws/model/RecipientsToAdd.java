
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
 * <p>Java class for RecipientsToAdd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecipientsToAdd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recipient" type="{http://ec.europa.eu/sg/hrs/types}RecipientToAdd" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecipientsToAdd", propOrder = {
    "recipient"
})
public class RecipientsToAdd
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<RecipientToAdd> recipient;

    /**
     * Gets the value of the recipient property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recipient property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecipient().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecipientToAdd }
     * 
     * 
     */
    public List<RecipientToAdd> getRecipient() {
        if (recipient == null) {
            recipient = new ArrayList<RecipientToAdd>();
        }
        return this.recipient;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RecipientsToAdd)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RecipientsToAdd that = ((RecipientsToAdd) object);
        {
            List<RecipientToAdd> lhsRecipient;
            lhsRecipient = (((this.recipient!= null)&&(!this.recipient.isEmpty()))?this.getRecipient():null);
            List<RecipientToAdd> rhsRecipient;
            rhsRecipient = (((that.recipient!= null)&&(!that.recipient.isEmpty()))?that.getRecipient():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recipient", lhsRecipient), LocatorUtils.property(thatLocator, "recipient", rhsRecipient), lhsRecipient, rhsRecipient)) {
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
            List<RecipientToAdd> theRecipient;
            theRecipient = (((this.recipient!= null)&&(!this.recipient.isEmpty()))?this.getRecipient():null);
            strategy.appendField(locator, this, "recipient", buffer, theRecipient);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<RecipientToAdd> theRecipient;
            theRecipient = (((this.recipient!= null)&&(!this.recipient.isEmpty()))?this.getRecipient():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recipient", theRecipient), currentHashCode, theRecipient);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
