
package generated.jagate.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.MailingAddressType;
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
 * <p>Java class for GetMailingAddressesByPicResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMailingAddressesByPicResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mailingAddressType" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}MailingAddressType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMailingAddressesByPicResponseType", propOrder = {
    "mailingAddressType"
})
public class GetMailingAddressesByPicResponseType
    implements Equals, HashCode, ToString
{

    protected List<MailingAddressType> mailingAddressType;

    /**
     * Gets the value of the mailingAddressType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mailingAddressType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMailingAddressType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MailingAddressType }
     * 
     * 
     */
    public List<MailingAddressType> getMailingAddressType() {
        if (mailingAddressType == null) {
            mailingAddressType = new ArrayList<MailingAddressType>();
        }
        return this.mailingAddressType;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetMailingAddressesByPicResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetMailingAddressesByPicResponseType that = ((GetMailingAddressesByPicResponseType) object);
        {
            List<MailingAddressType> lhsMailingAddressType;
            lhsMailingAddressType = (((this.mailingAddressType!= null)&&(!this.mailingAddressType.isEmpty()))?this.getMailingAddressType():null);
            List<MailingAddressType> rhsMailingAddressType;
            rhsMailingAddressType = (((that.mailingAddressType!= null)&&(!that.mailingAddressType.isEmpty()))?that.getMailingAddressType():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mailingAddressType", lhsMailingAddressType), LocatorUtils.property(thatLocator, "mailingAddressType", rhsMailingAddressType), lhsMailingAddressType, rhsMailingAddressType)) {
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
            List<MailingAddressType> theMailingAddressType;
            theMailingAddressType = (((this.mailingAddressType!= null)&&(!this.mailingAddressType.isEmpty()))?this.getMailingAddressType():null);
            strategy.appendField(locator, this, "mailingAddressType", buffer, theMailingAddressType);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<MailingAddressType> theMailingAddressType;
            theMailingAddressType = (((this.mailingAddressType!= null)&&(!this.mailingAddressType.isEmpty()))?this.getMailingAddressType():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mailingAddressType", theMailingAddressType), currentHashCode, theMailingAddressType);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
