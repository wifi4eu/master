
package eu.europa.ec.research.fp.model.document.v5;

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
 * <p>Java class for SendersRecipients complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendersRecipients">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Senders" type="{http://ec.europa.eu/research/fp/model/document/V5}SenderType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Recipients" type="{http://ec.europa.eu/research/fp/model/document/V5}RecipientType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendersRecipients", propOrder = {
    "senders",
    "recipients"
})
public class SendersRecipients
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Senders")
    protected List<SenderType> senders;
    @XmlElement(name = "Recipients")
    protected List<RecipientType> recipients;

    /**
     * Gets the value of the senders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the senders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSenders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SenderType }
     * 
     * 
     */
    public List<SenderType> getSenders() {
        if (senders == null) {
            senders = new ArrayList<SenderType>();
        }
        return this.senders;
    }

    /**
     * Gets the value of the recipients property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recipients property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecipients().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecipientType }
     * 
     * 
     */
    public List<RecipientType> getRecipients() {
        if (recipients == null) {
            recipients = new ArrayList<RecipientType>();
        }
        return this.recipients;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SendersRecipients)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SendersRecipients that = ((SendersRecipients) object);
        {
            List<SenderType> lhsSenders;
            lhsSenders = (((this.senders!= null)&&(!this.senders.isEmpty()))?this.getSenders():null);
            List<SenderType> rhsSenders;
            rhsSenders = (((that.senders!= null)&&(!that.senders.isEmpty()))?that.getSenders():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "senders", lhsSenders), LocatorUtils.property(thatLocator, "senders", rhsSenders), lhsSenders, rhsSenders)) {
                return false;
            }
        }
        {
            List<RecipientType> lhsRecipients;
            lhsRecipients = (((this.recipients!= null)&&(!this.recipients.isEmpty()))?this.getRecipients():null);
            List<RecipientType> rhsRecipients;
            rhsRecipients = (((that.recipients!= null)&&(!that.recipients.isEmpty()))?that.getRecipients():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recipients", lhsRecipients), LocatorUtils.property(thatLocator, "recipients", rhsRecipients), lhsRecipients, rhsRecipients)) {
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
            List<SenderType> theSenders;
            theSenders = (((this.senders!= null)&&(!this.senders.isEmpty()))?this.getSenders():null);
            strategy.appendField(locator, this, "senders", buffer, theSenders);
        }
        {
            List<RecipientType> theRecipients;
            theRecipients = (((this.recipients!= null)&&(!this.recipients.isEmpty()))?this.getRecipients():null);
            strategy.appendField(locator, this, "recipients", buffer, theRecipients);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<SenderType> theSenders;
            theSenders = (((this.senders!= null)&&(!this.senders.isEmpty()))?this.getSenders():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "senders", theSenders), currentHashCode, theSenders);
        }
        {
            List<RecipientType> theRecipients;
            theRecipients = (((this.recipients!= null)&&(!this.recipients.isEmpty()))?this.getRecipients():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recipients", theRecipients), currentHashCode, theRecipients);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
