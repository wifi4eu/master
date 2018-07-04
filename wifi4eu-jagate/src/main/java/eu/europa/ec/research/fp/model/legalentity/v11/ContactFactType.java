
package eu.europa.ec.research.fp.model.legalentity.v11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.modelperson.v4.PersonType;
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
 * <p>Java class for ContactFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContactFactType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/research/fp/model/person/V4}PersonType">
 *       &lt;sequence>
 *         &lt;element name="ContactType" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ContactType"/>
 *         &lt;element name="EcasUserId" type="{http://ec.europa.eu/research/fp/model/base/V1}ECUserIdType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactFactType", propOrder = {
    "contactType",
    "ecasUserId"
})
public class ContactFactType
    extends PersonType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ContactType", required = true)
    protected String contactType;
    @XmlElement(name = "EcasUserId")
    protected String ecasUserId;

    /**
     * Gets the value of the contactType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactType() {
        return contactType;
    }

    /**
     * Sets the value of the contactType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactType(String value) {
        this.contactType = value;
    }

    /**
     * Gets the value of the ecasUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcasUserId() {
        return ecasUserId;
    }

    /**
     * Sets the value of the ecasUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcasUserId(String value) {
        this.ecasUserId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ContactFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ContactFactType that = ((ContactFactType) object);
        {
            String lhsContactType;
            lhsContactType = this.getContactType();
            String rhsContactType;
            rhsContactType = that.getContactType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contactType", lhsContactType), LocatorUtils.property(thatLocator, "contactType", rhsContactType), lhsContactType, rhsContactType)) {
                return false;
            }
        }
        {
            String lhsEcasUserId;
            lhsEcasUserId = this.getEcasUserId();
            String rhsEcasUserId;
            rhsEcasUserId = that.getEcasUserId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ecasUserId", lhsEcasUserId), LocatorUtils.property(thatLocator, "ecasUserId", rhsEcasUserId), lhsEcasUserId, rhsEcasUserId)) {
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
            String theContactType;
            theContactType = this.getContactType();
            strategy.appendField(locator, this, "contactType", buffer, theContactType);
        }
        {
            String theEcasUserId;
            theEcasUserId = this.getEcasUserId();
            strategy.appendField(locator, this, "ecasUserId", buffer, theEcasUserId);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String theContactType;
            theContactType = this.getContactType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contactType", theContactType), currentHashCode, theContactType);
        }
        {
            String theEcasUserId;
            theEcasUserId = this.getEcasUserId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ecasUserId", theEcasUserId), currentHashCode, theEcasUserId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
