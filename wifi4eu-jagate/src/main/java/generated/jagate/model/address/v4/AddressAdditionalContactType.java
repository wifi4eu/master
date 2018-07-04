
package generated.jagate.model.address.v4;

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
 * <p>Java class for AddressAdditionalContactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressAdditionalContactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Phone" type="{http://ec.europa.eu/research/fp/model/address/V4}PhoneType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://ec.europa.eu/research/fp/model/address/V4}FaxType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://ec.europa.eu/research/fp/model/address/V4}EmailType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressAdditionalContactType", propOrder = {
    "phone",
    "fax",
    "email"
})
public class AddressAdditionalContactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Phone")
    protected List<PhoneType> phone;
    @XmlElement(name = "Fax")
    protected List<FaxType> fax;
    @XmlElement(name = "Email")
    protected List<EmailType> email;

    /**
     * Gets the value of the phone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneType }
     * 
     * 
     */
    public List<PhoneType> getPhone() {
        if (phone == null) {
            phone = new ArrayList<PhoneType>();
        }
        return this.phone;
    }

    /**
     * Gets the value of the fax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FaxType }
     * 
     * 
     */
    public List<FaxType> getFax() {
        if (fax == null) {
            fax = new ArrayList<FaxType>();
        }
        return this.fax;
    }

    /**
     * Gets the value of the email property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the email property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmailType }
     * 
     * 
     */
    public List<EmailType> getEmail() {
        if (email == null) {
            email = new ArrayList<EmailType>();
        }
        return this.email;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AddressAdditionalContactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AddressAdditionalContactType that = ((AddressAdditionalContactType) object);
        {
            List<PhoneType> lhsPhone;
            lhsPhone = (((this.phone!= null)&&(!this.phone.isEmpty()))?this.getPhone():null);
            List<PhoneType> rhsPhone;
            rhsPhone = (((that.phone!= null)&&(!that.phone.isEmpty()))?that.getPhone():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "phone", lhsPhone), LocatorUtils.property(thatLocator, "phone", rhsPhone), lhsPhone, rhsPhone)) {
                return false;
            }
        }
        {
            List<FaxType> lhsFax;
            lhsFax = (((this.fax!= null)&&(!this.fax.isEmpty()))?this.getFax():null);
            List<FaxType> rhsFax;
            rhsFax = (((that.fax!= null)&&(!that.fax.isEmpty()))?that.getFax():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fax", lhsFax), LocatorUtils.property(thatLocator, "fax", rhsFax), lhsFax, rhsFax)) {
                return false;
            }
        }
        {
            List<EmailType> lhsEmail;
            lhsEmail = (((this.email!= null)&&(!this.email.isEmpty()))?this.getEmail():null);
            List<EmailType> rhsEmail;
            rhsEmail = (((that.email!= null)&&(!that.email.isEmpty()))?that.getEmail():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "email", lhsEmail), LocatorUtils.property(thatLocator, "email", rhsEmail), lhsEmail, rhsEmail)) {
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
            List<PhoneType> thePhone;
            thePhone = (((this.phone!= null)&&(!this.phone.isEmpty()))?this.getPhone():null);
            strategy.appendField(locator, this, "phone", buffer, thePhone);
        }
        {
            List<FaxType> theFax;
            theFax = (((this.fax!= null)&&(!this.fax.isEmpty()))?this.getFax():null);
            strategy.appendField(locator, this, "fax", buffer, theFax);
        }
        {
            List<EmailType> theEmail;
            theEmail = (((this.email!= null)&&(!this.email.isEmpty()))?this.getEmail():null);
            strategy.appendField(locator, this, "email", buffer, theEmail);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<PhoneType> thePhone;
            thePhone = (((this.phone!= null)&&(!this.phone.isEmpty()))?this.getPhone():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "phone", thePhone), currentHashCode, thePhone);
        }
        {
            List<FaxType> theFax;
            theFax = (((this.fax!= null)&&(!this.fax.isEmpty()))?this.getFax():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fax", theFax), currentHashCode, theFax);
        }
        {
            List<EmailType> theEmail;
            theEmail = (((this.email!= null)&&(!this.email.isEmpty()))?this.getEmail():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "email", theEmail), currentHashCode, theEmail);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
